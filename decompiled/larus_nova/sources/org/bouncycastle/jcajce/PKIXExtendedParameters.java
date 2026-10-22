package org.bouncycastle.jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXExtendedParameters implements CertPathParameters {
    public static final int CHAIN_VALIDITY_MODEL = 1;
    public static final int PKIX_VALIDITY_MODEL = 0;
    private final PKIXParameters baseParameters;
    private final Date date;
    private final List<PKIXCRLStore> extraCRLStores;
    private final List<PKIXCertStore> extraCertStores;
    private final Map<GeneralName, PKIXCRLStore> namedCRLStoreMap;
    private final Map<GeneralName, PKIXCertStore> namedCertificateStoreMap;
    private final boolean revocationEnabled;
    private final PKIXCertStoreSelector targetConstraints;
    private final Set<TrustAnchor> trustAnchors;
    private final boolean useDeltas;
    private final Date validityDate;
    private final int validityModel;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.PKIXExtendedParameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final PKIXParameters baseParameters;
        private final Date date;
        private List<PKIXCRLStore> extraCRLStores;
        private List<PKIXCertStore> extraCertStores;
        private Map<GeneralName, PKIXCRLStore> namedCRLStoreMap;
        private Map<GeneralName, PKIXCertStore> namedCertificateStoreMap;
        private boolean revocationEnabled;
        private PKIXCertStoreSelector targetConstraints;
        private Set<TrustAnchor> trustAnchors;
        private boolean useDeltas;
        private final Date validityDate;
        private int validityModel;

        public Builder(PKIXParameters r100) {
            this.extraCertStores = new ArrayList();
            this.namedCertificateStoreMap = new HashMap();
            this.extraCRLStores = new ArrayList();
            this.namedCRLStoreMap = new HashMap();
            this.validityModel = 0;
            this.useDeltas = false;
            this.baseParameters = (PKIXParameters) r100.clone();
            CertSelector r101 = r100.getTargetCertConstraints();
            if (r101 == null) goto L5;
            this.targetConstraints = new PKIXCertStoreSelector.Builder(r101).build();
        L5:
            Date r102 = r100.getDate();
            this.validityDate = r102;
            if (r102 != null) goto L8;
            r102 = new Date();
        L8:
            this.date = r102;
            this.revocationEnabled = r100.isRevocationEnabled();
            this.trustAnchors = r100.getTrustAnchors();
        }

        public Builder(PKIXExtendedParameters r100) {
            this.extraCertStores = new ArrayList();
            this.namedCertificateStoreMap = new HashMap();
            this.extraCRLStores = new ArrayList();
            this.namedCRLStoreMap = new HashMap();
            this.validityModel = 0;
            this.useDeltas = false;
            this.baseParameters = PKIXExtendedParameters.access$000(r100);
            this.validityDate = PKIXExtendedParameters.access$100(r100);
            this.date = PKIXExtendedParameters.access$200(r100);
            this.targetConstraints = PKIXExtendedParameters.access$300(r100);
            this.extraCertStores = new ArrayList(PKIXExtendedParameters.access$400(r100));
            this.namedCertificateStoreMap = new HashMap(PKIXExtendedParameters.access$500(r100));
            this.extraCRLStores = new ArrayList(PKIXExtendedParameters.access$600(r100));
            this.namedCRLStoreMap = new HashMap(PKIXExtendedParameters.access$700(r100));
            this.useDeltas = PKIXExtendedParameters.access$800(r100);
            this.validityModel = PKIXExtendedParameters.access$900(r100);
            this.revocationEnabled = r100.isRevocationEnabled();
            this.trustAnchors = r100.getTrustAnchors();
        }

        public static /* synthetic */ PKIXParameters access$1100(Builder r100) {
            return r100.baseParameters;
        }

        public static /* synthetic */ Date access$1200(Builder r100) {
            return r100.validityDate;
        }

        public static /* synthetic */ Date access$1300(Builder r100) {
            return r100.date;
        }

        public static /* synthetic */ List access$1400(Builder r100) {
            return r100.extraCertStores;
        }

        public static /* synthetic */ Map access$1500(Builder r100) {
            return r100.namedCertificateStoreMap;
        }

        public static /* synthetic */ List access$1600(Builder r100) {
            return r100.extraCRLStores;
        }

        public static /* synthetic */ Map access$1700(Builder r100) {
            return r100.namedCRLStoreMap;
        }

        public static /* synthetic */ PKIXCertStoreSelector access$1800(Builder r100) {
            return r100.targetConstraints;
        }

        public static /* synthetic */ boolean access$1900(Builder r100) {
            return r100.revocationEnabled;
        }

        public static /* synthetic */ boolean access$2000(Builder r100) {
            return r100.useDeltas;
        }

        public static /* synthetic */ int access$2100(Builder r100) {
            return r100.validityModel;
        }

        public static /* synthetic */ Set access$2200(Builder r100) {
            return r100.trustAnchors;
        }

        public Builder addCRLStore(PKIXCRLStore r100) {
            this.extraCRLStores.add(r100);
            return this;
        }

        public Builder addCertificateStore(PKIXCertStore r100) {
            this.extraCertStores.add(r100);
            return this;
        }

        public Builder addNamedCRLStore(GeneralName r100, PKIXCRLStore r101) {
            this.namedCRLStoreMap.put(r100, r101);
            return this;
        }

        public Builder addNamedCertificateStore(GeneralName r100, PKIXCertStore r101) {
            this.namedCertificateStoreMap.put(r100, r101);
            return this;
        }

        public PKIXExtendedParameters build() {
            return new PKIXExtendedParameters(this, null);
        }

        public void setRevocationEnabled(boolean r100) {
            this.revocationEnabled = r100;
        }

        public Builder setTargetConstraints(PKIXCertStoreSelector r100) {
            this.targetConstraints = r100;
            return this;
        }

        public Builder setTrustAnchor(TrustAnchor r100) {
            this.trustAnchors = Collections.singleton(r100);
            return this;
        }

        public Builder setTrustAnchors(Set<TrustAnchor> r100) {
            this.trustAnchors = r100;
            return this;
        }

        public Builder setUseDeltasEnabled(boolean r100) {
            this.useDeltas = r100;
            return this;
        }

        public Builder setValidityModel(int r100) {
            this.validityModel = r100;
            return this;
        }
    }

    private PKIXExtendedParameters(Builder r100) {
        this.baseParameters = Builder.access$1100(r100);
        this.validityDate = Builder.access$1200(r100);
        this.date = Builder.access$1300(r100);
        this.extraCertStores = Collections.unmodifiableList(Builder.access$1400(r100));
        this.namedCertificateStoreMap = Collections.unmodifiableMap(new HashMap(Builder.access$1500(r100)));
        this.extraCRLStores = Collections.unmodifiableList(Builder.access$1600(r100));
        this.namedCRLStoreMap = Collections.unmodifiableMap(new HashMap(Builder.access$1700(r100)));
        this.targetConstraints = Builder.access$1800(r100);
        this.revocationEnabled = Builder.access$1900(r100);
        this.useDeltas = Builder.access$2000(r100);
        this.validityModel = Builder.access$2100(r100);
        this.trustAnchors = Collections.unmodifiableSet(Builder.access$2200(r100));
    }

    public /* synthetic */ PKIXExtendedParameters(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ PKIXParameters access$000(PKIXExtendedParameters r100) {
        return r100.baseParameters;
    }

    public static /* synthetic */ Date access$100(PKIXExtendedParameters r100) {
        return r100.validityDate;
    }

    public static /* synthetic */ Date access$200(PKIXExtendedParameters r100) {
        return r100.date;
    }

    public static /* synthetic */ PKIXCertStoreSelector access$300(PKIXExtendedParameters r100) {
        return r100.targetConstraints;
    }

    public static /* synthetic */ List access$400(PKIXExtendedParameters r100) {
        return r100.extraCertStores;
    }

    public static /* synthetic */ Map access$500(PKIXExtendedParameters r100) {
        return r100.namedCertificateStoreMap;
    }

    public static /* synthetic */ List access$600(PKIXExtendedParameters r100) {
        return r100.extraCRLStores;
    }

    public static /* synthetic */ Map access$700(PKIXExtendedParameters r100) {
        return r100.namedCRLStoreMap;
    }

    public static /* synthetic */ boolean access$800(PKIXExtendedParameters r100) {
        return r100.useDeltas;
    }

    public static /* synthetic */ int access$900(PKIXExtendedParameters r100) {
        return r100.validityModel;
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        return this;
    }

    public List<PKIXCRLStore> getCRLStores() {
        return this.extraCRLStores;
    }

    public List getCertPathCheckers() {
        return this.baseParameters.getCertPathCheckers();
    }

    public List<CertStore> getCertStores() {
        return this.baseParameters.getCertStores();
    }

    public List<PKIXCertStore> getCertificateStores() {
        return this.extraCertStores;
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    public Set getInitialPolicies() {
        return this.baseParameters.getInitialPolicies();
    }

    public Map<GeneralName, PKIXCRLStore> getNamedCRLStoreMap() {
        return this.namedCRLStoreMap;
    }

    public Map<GeneralName, PKIXCertStore> getNamedCertificateStoreMap() {
        return this.namedCertificateStoreMap;
    }

    public boolean getPolicyQualifiersRejected() {
        return this.baseParameters.getPolicyQualifiersRejected();
    }

    public String getSigProvider() {
        return this.baseParameters.getSigProvider();
    }

    public PKIXCertStoreSelector getTargetConstraints() {
        return this.targetConstraints;
    }

    public Set getTrustAnchors() {
        return this.trustAnchors;
    }

    public Date getValidityDate() {
        if (this.validityDate != null) goto L6;
        return null;
    L6:
        return new Date(this.validityDate.getTime());
    }

    public int getValidityModel() {
        return this.validityModel;
    }

    public boolean isAnyPolicyInhibited() {
        return this.baseParameters.isAnyPolicyInhibited();
    }

    public boolean isExplicitPolicyRequired() {
        return this.baseParameters.isExplicitPolicyRequired();
    }

    public boolean isPolicyMappingInhibited() {
        return this.baseParameters.isPolicyMappingInhibited();
    }

    public boolean isRevocationEnabled() {
        return this.revocationEnabled;
    }

    public boolean isUseDeltasEnabled() {
        return this.useDeltas;
    }
}
