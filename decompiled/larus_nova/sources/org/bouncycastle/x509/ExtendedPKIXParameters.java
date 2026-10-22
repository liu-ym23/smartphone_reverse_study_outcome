package org.bouncycastle.x509;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;

/* JADX INFO: loaded from: classes42.dex */
public class ExtendedPKIXParameters extends PKIXParameters {
    public static final int CHAIN_VALIDITY_MODEL = 1;
    public static final int PKIX_VALIDITY_MODEL = 0;
    private boolean additionalLocationsEnabled;
    private List additionalStores;
    private Set attrCertCheckers;
    private Set necessaryACAttributes;
    private Set prohibitedACAttributes;
    private Selector selector;
    private List stores;
    private Set trustedACIssuers;
    private boolean useDeltas;
    private int validityModel;

    public ExtendedPKIXParameters(Set r100) throws InvalidAlgorithmParameterException {
        super(r100);
        this.validityModel = 0;
        this.useDeltas = false;
        this.stores = new ArrayList();
        this.additionalStores = new ArrayList();
        this.trustedACIssuers = new HashSet();
        this.necessaryACAttributes = new HashSet();
        this.prohibitedACAttributes = new HashSet();
        this.attrCertCheckers = new HashSet();
    }

    public static ExtendedPKIXParameters getInstance(PKIXParameters r100) {
        ExtendedPKIXParameters r101 = new ExtendedPKIXParameters(r100.getTrustAnchors());     // Catch: Exception -> L5
        r101.setParams(r100);
        return r101;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    }

    public void addAddionalStore(Store r100) {
        addAdditionalStore(r100);
    }

    public void addAdditionalStore(Store r100) {
        if (r100 == null) goto L5;
        this.additionalStores.add(r100);
        return;
    }

    public void addStore(Store r100) {
        if (r100 == null) goto L5;
        this.stores.add(r100);
        return;
    }

    @Override // java.security.cert.PKIXParameters, java.security.cert.CertPathParameters
    public Object clone() {
        ExtendedPKIXParameters r100 = new ExtendedPKIXParameters(getTrustAnchors());     // Catch: Exception -> L5
        r100.setParams(this);
        return r100;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    }

    public List getAdditionalStores() {
        return Collections.unmodifiableList(this.additionalStores);
    }

    public Set getAttrCertCheckers() {
        return Collections.unmodifiableSet(this.attrCertCheckers);
    }

    public Set getNecessaryACAttributes() {
        return Collections.unmodifiableSet(this.necessaryACAttributes);
    }

    public Set getProhibitedACAttributes() {
        return Collections.unmodifiableSet(this.prohibitedACAttributes);
    }

    public List getStores() {
        return Collections.unmodifiableList(new ArrayList(this.stores));
    }

    public Selector getTargetConstraints() {
        Selector r100 = this.selector;
        if (r100 != null) goto L5;
        return null;
    L5:
        return (Selector) r100.clone();
    }

    public Set getTrustedACIssuers() {
        return Collections.unmodifiableSet(this.trustedACIssuers);
    }

    public int getValidityModel() {
        return this.validityModel;
    }

    public boolean isAdditionalLocationsEnabled() {
        return this.additionalLocationsEnabled;
    }

    public boolean isUseDeltasEnabled() {
        return this.useDeltas;
    }

    public void setAdditionalLocationsEnabled(boolean r100) {
        this.additionalLocationsEnabled = r100;
    }

    public void setAttrCertCheckers(Set r100) {
        if (r100 != null) goto L5;
        this.attrCertCheckers.clear();
        return;
    L5:
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        if ((r101.next() instanceof PKIXAttrCertChecker) == true) goto L7;
        throw new ClassCastException("All elements of set must be of type " + PKIXAttrCertChecker.class.getName() + ".");
    L13:
        this.attrCertCheckers.clear();
        this.attrCertCheckers.addAll(r100);
    }

    @Override // java.security.cert.PKIXParameters
    public void setCertStores(List r100) {
        if (r100 == null) goto L7;
        Iterator r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L9;
        addCertStore((CertStore) r101.next());
        goto L5
    L9:
        return;
    }

    public void setNecessaryACAttributes(Set r100) {
        if (r100 != null) goto L5;
        this.necessaryACAttributes.clear();
        return;
    L5:
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        if ((r101.next() instanceof String) == true) goto L7;
        throw new ClassCastException("All elements of set must be of type String.");
    L13:
        this.necessaryACAttributes.clear();
        this.necessaryACAttributes.addAll(r100);
    }

    public void setParams(PKIXParameters r100) {
        setDate(r100.getDate());
        setCertPathCheckers(r100.getCertPathCheckers());
        setCertStores(r100.getCertStores());
        setAnyPolicyInhibited(r100.isAnyPolicyInhibited());
        setExplicitPolicyRequired(r100.isExplicitPolicyRequired());
        setPolicyMappingInhibited(r100.isPolicyMappingInhibited());
        setRevocationEnabled(r100.isRevocationEnabled());
        setInitialPolicies(r100.getInitialPolicies());
        setPolicyQualifiersRejected(r100.getPolicyQualifiersRejected());
        setSigProvider(r100.getSigProvider());
        setTargetCertConstraints(r100.getTargetCertConstraints());
        setTrustAnchors(r100.getTrustAnchors());     // Catch: Exception -> L12
        if ((r100 instanceof ExtendedPKIXParameters) == false) goto L17;
        ExtendedPKIXParameters r101 = (ExtendedPKIXParameters) r100;
        this.validityModel = r101.validityModel;
        this.useDeltas = r101.useDeltas;
        this.additionalLocationsEnabled = r101.additionalLocationsEnabled;
        Selector r102 = r101.selector;
        if (r102 != null) goto L9;
        Selector r103 = null;
    L10:
        this.selector = r103;
        this.stores = new ArrayList(r101.stores);
        this.additionalStores = new ArrayList(r101.additionalStores);
        this.trustedACIssuers = new HashSet(r101.trustedACIssuers);
        this.prohibitedACAttributes = new HashSet(r101.prohibitedACAttributes);
        this.necessaryACAttributes = new HashSet(r101.necessaryACAttributes);
        this.attrCertCheckers = new HashSet(r101.attrCertCheckers);
        return;
    L9:
        r103 = (Selector) r102.clone();
        goto L10
    L17:
        return;
    L12:
        e = move-exception;
        throw new RuntimeException(e.getMessage());
    }

    public void setProhibitedACAttributes(Set r100) {
        if (r100 != null) goto L5;
        this.prohibitedACAttributes.clear();
        return;
    L5:
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        if ((r101.next() instanceof String) == true) goto L7;
        throw new ClassCastException("All elements of set must be of type String.");
    L13:
        this.prohibitedACAttributes.clear();
        this.prohibitedACAttributes.addAll(r100);
    }

    public void setStores(List r100) {
        if (r100 != null) goto L4;
        this.stores = new ArrayList();
        return;
    L4:
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L12;
        if ((r101.next() instanceof Store) == true) goto L6;
        throw new ClassCastException("All elements of list must be of type org.bouncycastle.util.Store.");
    L12:
        this.stores = new ArrayList(r100);
    }

    @Override // java.security.cert.PKIXParameters
    public void setTargetCertConstraints(CertSelector r100) {
        super.setTargetCertConstraints(r100);
        if (r100 == null) goto L5;
        X509CertStoreSelector r101 = X509CertStoreSelector.getInstance((X509CertSelector) r100);
    L6:
        this.selector = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public void setTargetConstraints(Selector r100) {
        if (r100 == null) goto L4;
        Selector r101 = (Selector) r100.clone();
    L5:
        this.selector = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setTrustedACIssuers(Set r100) {
        if (r100 != null) goto L5;
        this.trustedACIssuers.clear();
        return;
    L5:
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        if ((r101.next() instanceof TrustAnchor) == true) goto L7;
        throw new ClassCastException("All elements of set must be of type " + TrustAnchor.class.getName() + ".");
    L13:
        this.trustedACIssuers.clear();
        this.trustedACIssuers.addAll(r100);
    }

    public void setUseDeltasEnabled(boolean r100) {
        this.useDeltas = r100;
    }

    public void setValidityModel(int r100) {
        this.validityModel = r100;
    }
}
