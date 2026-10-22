package org.bouncycastle.jce;

import java.security.cert.CertStoreParameters;
import java.security.cert.LDAPCertStoreParameters;
import org.bouncycastle.x509.X509StoreParameters;

/* JADX INFO: loaded from: classes42.dex */
public class X509LDAPCertStoreParameters implements X509StoreParameters, CertStoreParameters {
    private String aACertificateAttribute;
    private String aACertificateSubjectAttributeName;
    private String attributeAuthorityRevocationListAttribute;
    private String attributeAuthorityRevocationListIssuerAttributeName;
    private String attributeCertificateAttributeAttribute;
    private String attributeCertificateAttributeSubjectAttributeName;
    private String attributeCertificateRevocationListAttribute;
    private String attributeCertificateRevocationListIssuerAttributeName;
    private String attributeDescriptorCertificateAttribute;
    private String attributeDescriptorCertificateSubjectAttributeName;
    private String authorityRevocationListAttribute;
    private String authorityRevocationListIssuerAttributeName;
    private String baseDN;
    private String cACertificateAttribute;
    private String cACertificateSubjectAttributeName;
    private String certificateRevocationListAttribute;
    private String certificateRevocationListIssuerAttributeName;
    private String crossCertificateAttribute;
    private String crossCertificateSubjectAttributeName;
    private String deltaRevocationListAttribute;
    private String deltaRevocationListIssuerAttributeName;
    private String ldapAACertificateAttributeName;
    private String ldapAttributeAuthorityRevocationListAttributeName;
    private String ldapAttributeCertificateAttributeAttributeName;
    private String ldapAttributeCertificateRevocationListAttributeName;
    private String ldapAttributeDescriptorCertificateAttributeName;
    private String ldapAuthorityRevocationListAttributeName;
    private String ldapCACertificateAttributeName;
    private String ldapCertificateRevocationListAttributeName;
    private String ldapCrossCertificateAttributeName;
    private String ldapDeltaRevocationListAttributeName;
    private String ldapURL;
    private String ldapUserCertificateAttributeName;
    private String searchForSerialNumberIn;
    private String userCertificateAttribute;
    private String userCertificateSubjectAttributeName;

    /* JADX INFO: renamed from: org.bouncycastle.jce.X509LDAPCertStoreParameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String aACertificateAttribute;
        private String aACertificateSubjectAttributeName;
        private String attributeAuthorityRevocationListAttribute;
        private String attributeAuthorityRevocationListIssuerAttributeName;
        private String attributeCertificateAttributeAttribute;
        private String attributeCertificateAttributeSubjectAttributeName;
        private String attributeCertificateRevocationListAttribute;
        private String attributeCertificateRevocationListIssuerAttributeName;
        private String attributeDescriptorCertificateAttribute;
        private String attributeDescriptorCertificateSubjectAttributeName;
        private String authorityRevocationListAttribute;
        private String authorityRevocationListIssuerAttributeName;
        private String baseDN;
        private String cACertificateAttribute;
        private String cACertificateSubjectAttributeName;
        private String certificateRevocationListAttribute;
        private String certificateRevocationListIssuerAttributeName;
        private String crossCertificateAttribute;
        private String crossCertificateSubjectAttributeName;
        private String deltaRevocationListAttribute;
        private String deltaRevocationListIssuerAttributeName;
        private String ldapAACertificateAttributeName;
        private String ldapAttributeAuthorityRevocationListAttributeName;
        private String ldapAttributeCertificateAttributeAttributeName;
        private String ldapAttributeCertificateRevocationListAttributeName;
        private String ldapAttributeDescriptorCertificateAttributeName;
        private String ldapAuthorityRevocationListAttributeName;
        private String ldapCACertificateAttributeName;
        private String ldapCertificateRevocationListAttributeName;
        private String ldapCrossCertificateAttributeName;
        private String ldapDeltaRevocationListAttributeName;
        private String ldapURL;
        private String ldapUserCertificateAttributeName;
        private String searchForSerialNumberIn;
        private String userCertificateAttribute;
        private String userCertificateSubjectAttributeName;

        public Builder() {
            this("ldap://localhost:389", "");
        }

        public Builder(String r100, String r101) {
            this.ldapURL = r100;
            if (r101 != null) goto L5;
            this.baseDN = "";
        L6:
            this.userCertificateAttribute = "userCertificate";
            this.cACertificateAttribute = "cACertificate";
            this.crossCertificateAttribute = "crossCertificatePair";
            this.certificateRevocationListAttribute = "certificateRevocationList";
            this.deltaRevocationListAttribute = "deltaRevocationList";
            this.authorityRevocationListAttribute = "authorityRevocationList";
            this.attributeCertificateAttributeAttribute = "attributeCertificateAttribute";
            this.aACertificateAttribute = "aACertificate";
            this.attributeDescriptorCertificateAttribute = "attributeDescriptorCertificate";
            this.attributeCertificateRevocationListAttribute = "attributeCertificateRevocationList";
            this.attributeAuthorityRevocationListAttribute = "attributeAuthorityRevocationList";
            this.ldapUserCertificateAttributeName = "cn";
            this.ldapCACertificateAttributeName = "cn ou o";
            this.ldapCrossCertificateAttributeName = "cn ou o";
            this.ldapCertificateRevocationListAttributeName = "cn ou o";
            this.ldapDeltaRevocationListAttributeName = "cn ou o";
            this.ldapAuthorityRevocationListAttributeName = "cn ou o";
            this.ldapAttributeCertificateAttributeAttributeName = "cn";
            this.ldapAACertificateAttributeName = "cn o ou";
            this.ldapAttributeDescriptorCertificateAttributeName = "cn o ou";
            this.ldapAttributeCertificateRevocationListAttributeName = "cn o ou";
            this.ldapAttributeAuthorityRevocationListAttributeName = "cn o ou";
            this.userCertificateSubjectAttributeName = "cn";
            this.cACertificateSubjectAttributeName = "o ou";
            this.crossCertificateSubjectAttributeName = "o ou";
            this.certificateRevocationListIssuerAttributeName = "o ou";
            this.deltaRevocationListIssuerAttributeName = "o ou";
            this.authorityRevocationListIssuerAttributeName = "o ou";
            this.attributeCertificateAttributeSubjectAttributeName = "cn";
            this.aACertificateSubjectAttributeName = "o ou";
            this.attributeDescriptorCertificateSubjectAttributeName = "o ou";
            this.attributeCertificateRevocationListIssuerAttributeName = "o ou";
            this.attributeAuthorityRevocationListIssuerAttributeName = "o ou";
            this.searchForSerialNumberIn = "uid serialNumber cn";
            return;
        L5:
            this.baseDN = r101;
            goto L6
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.ldapURL;
        }

        public static /* synthetic */ String access$1000(Builder r100) {
            return r100.aACertificateAttribute;
        }

        public static /* synthetic */ String access$1100(Builder r100) {
            return r100.attributeDescriptorCertificateAttribute;
        }

        public static /* synthetic */ String access$1200(Builder r100) {
            return r100.attributeCertificateRevocationListAttribute;
        }

        public static /* synthetic */ String access$1300(Builder r100) {
            return r100.attributeAuthorityRevocationListAttribute;
        }

        public static /* synthetic */ String access$1400(Builder r100) {
            return r100.ldapUserCertificateAttributeName;
        }

        public static /* synthetic */ String access$1500(Builder r100) {
            return r100.ldapCACertificateAttributeName;
        }

        public static /* synthetic */ String access$1600(Builder r100) {
            return r100.ldapCrossCertificateAttributeName;
        }

        public static /* synthetic */ String access$1700(Builder r100) {
            return r100.ldapCertificateRevocationListAttributeName;
        }

        public static /* synthetic */ String access$1800(Builder r100) {
            return r100.ldapDeltaRevocationListAttributeName;
        }

        public static /* synthetic */ String access$1900(Builder r100) {
            return r100.ldapAuthorityRevocationListAttributeName;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.baseDN;
        }

        public static /* synthetic */ String access$2000(Builder r100) {
            return r100.ldapAttributeCertificateAttributeAttributeName;
        }

        public static /* synthetic */ String access$2100(Builder r100) {
            return r100.ldapAACertificateAttributeName;
        }

        public static /* synthetic */ String access$2200(Builder r100) {
            return r100.ldapAttributeDescriptorCertificateAttributeName;
        }

        public static /* synthetic */ String access$2300(Builder r100) {
            return r100.ldapAttributeCertificateRevocationListAttributeName;
        }

        public static /* synthetic */ String access$2400(Builder r100) {
            return r100.ldapAttributeAuthorityRevocationListAttributeName;
        }

        public static /* synthetic */ String access$2500(Builder r100) {
            return r100.userCertificateSubjectAttributeName;
        }

        public static /* synthetic */ String access$2600(Builder r100) {
            return r100.cACertificateSubjectAttributeName;
        }

        public static /* synthetic */ String access$2700(Builder r100) {
            return r100.crossCertificateSubjectAttributeName;
        }

        public static /* synthetic */ String access$2800(Builder r100) {
            return r100.certificateRevocationListIssuerAttributeName;
        }

        public static /* synthetic */ String access$2900(Builder r100) {
            return r100.deltaRevocationListIssuerAttributeName;
        }

        public static /* synthetic */ String access$300(Builder r100) {
            return r100.userCertificateAttribute;
        }

        public static /* synthetic */ String access$3000(Builder r100) {
            return r100.authorityRevocationListIssuerAttributeName;
        }

        public static /* synthetic */ String access$3100(Builder r100) {
            return r100.attributeCertificateAttributeSubjectAttributeName;
        }

        public static /* synthetic */ String access$3200(Builder r100) {
            return r100.aACertificateSubjectAttributeName;
        }

        public static /* synthetic */ String access$3300(Builder r100) {
            return r100.attributeDescriptorCertificateSubjectAttributeName;
        }

        public static /* synthetic */ String access$3400(Builder r100) {
            return r100.attributeCertificateRevocationListIssuerAttributeName;
        }

        public static /* synthetic */ String access$3500(Builder r100) {
            return r100.attributeAuthorityRevocationListIssuerAttributeName;
        }

        public static /* synthetic */ String access$3600(Builder r100) {
            return r100.searchForSerialNumberIn;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.cACertificateAttribute;
        }

        public static /* synthetic */ String access$500(Builder r100) {
            return r100.crossCertificateAttribute;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.certificateRevocationListAttribute;
        }

        public static /* synthetic */ String access$700(Builder r100) {
            return r100.deltaRevocationListAttribute;
        }

        public static /* synthetic */ String access$800(Builder r100) {
            return r100.authorityRevocationListAttribute;
        }

        public static /* synthetic */ String access$900(Builder r100) {
            return r100.attributeCertificateAttributeAttribute;
        }

        public X509LDAPCertStoreParameters build() {
            if (this.ldapUserCertificateAttributeName == null) goto L49;
            if (this.ldapCACertificateAttributeName == null) goto L49;
            if (this.ldapCrossCertificateAttributeName == null) goto L49;
            if (this.ldapCertificateRevocationListAttributeName == null) goto L49;
            if (this.ldapDeltaRevocationListAttributeName == null) goto L49;
            if (this.ldapAuthorityRevocationListAttributeName == null) goto L49;
            if (this.ldapAttributeCertificateAttributeAttributeName == null) goto L49;
            if (this.ldapAACertificateAttributeName == null) goto L49;
            if (this.ldapAttributeDescriptorCertificateAttributeName == null) goto L49;
            if (this.ldapAttributeCertificateRevocationListAttributeName == null) goto L49;
            if (this.ldapAttributeAuthorityRevocationListAttributeName == null) goto L49;
            if (this.userCertificateSubjectAttributeName == null) goto L49;
            if (this.cACertificateSubjectAttributeName == null) goto L49;
            if (this.crossCertificateSubjectAttributeName == null) goto L49;
            if (this.certificateRevocationListIssuerAttributeName == null) goto L49;
            if (this.deltaRevocationListIssuerAttributeName == null) goto L49;
            if (this.authorityRevocationListIssuerAttributeName == null) goto L49;
            if (this.attributeCertificateAttributeSubjectAttributeName == null) goto L49;
            if (this.aACertificateSubjectAttributeName == null) goto L49;
            if (this.attributeDescriptorCertificateSubjectAttributeName == null) goto L49;
            if (this.attributeCertificateRevocationListIssuerAttributeName == null) goto L49;
            if (this.attributeAuthorityRevocationListIssuerAttributeName == null) goto L49;
            return new X509LDAPCertStoreParameters(this, null);
        L49:
            throw new IllegalArgumentException("Necessary parameters not specified.");
        }

        public Builder setAACertificateAttribute(String r100) {
            this.aACertificateAttribute = r100;
            return this;
        }

        public Builder setAACertificateSubjectAttributeName(String r100) {
            this.aACertificateSubjectAttributeName = r100;
            return this;
        }

        public Builder setAttributeAuthorityRevocationListAttribute(String r100) {
            this.attributeAuthorityRevocationListAttribute = r100;
            return this;
        }

        public Builder setAttributeAuthorityRevocationListIssuerAttributeName(String r100) {
            this.attributeAuthorityRevocationListIssuerAttributeName = r100;
            return this;
        }

        public Builder setAttributeCertificateAttributeAttribute(String r100) {
            this.attributeCertificateAttributeAttribute = r100;
            return this;
        }

        public Builder setAttributeCertificateAttributeSubjectAttributeName(String r100) {
            this.attributeCertificateAttributeSubjectAttributeName = r100;
            return this;
        }

        public Builder setAttributeCertificateRevocationListAttribute(String r100) {
            this.attributeCertificateRevocationListAttribute = r100;
            return this;
        }

        public Builder setAttributeCertificateRevocationListIssuerAttributeName(String r100) {
            this.attributeCertificateRevocationListIssuerAttributeName = r100;
            return this;
        }

        public Builder setAttributeDescriptorCertificateAttribute(String r100) {
            this.attributeDescriptorCertificateAttribute = r100;
            return this;
        }

        public Builder setAttributeDescriptorCertificateSubjectAttributeName(String r100) {
            this.attributeDescriptorCertificateSubjectAttributeName = r100;
            return this;
        }

        public Builder setAuthorityRevocationListAttribute(String r100) {
            this.authorityRevocationListAttribute = r100;
            return this;
        }

        public Builder setAuthorityRevocationListIssuerAttributeName(String r100) {
            this.authorityRevocationListIssuerAttributeName = r100;
            return this;
        }

        public Builder setCACertificateAttribute(String r100) {
            this.cACertificateAttribute = r100;
            return this;
        }

        public Builder setCACertificateSubjectAttributeName(String r100) {
            this.cACertificateSubjectAttributeName = r100;
            return this;
        }

        public Builder setCertificateRevocationListAttribute(String r100) {
            this.certificateRevocationListAttribute = r100;
            return this;
        }

        public Builder setCertificateRevocationListIssuerAttributeName(String r100) {
            this.certificateRevocationListIssuerAttributeName = r100;
            return this;
        }

        public Builder setCrossCertificateAttribute(String r100) {
            this.crossCertificateAttribute = r100;
            return this;
        }

        public Builder setCrossCertificateSubjectAttributeName(String r100) {
            this.crossCertificateSubjectAttributeName = r100;
            return this;
        }

        public Builder setDeltaRevocationListAttribute(String r100) {
            this.deltaRevocationListAttribute = r100;
            return this;
        }

        public Builder setDeltaRevocationListIssuerAttributeName(String r100) {
            this.deltaRevocationListIssuerAttributeName = r100;
            return this;
        }

        public Builder setLdapAACertificateAttributeName(String r100) {
            this.ldapAACertificateAttributeName = r100;
            return this;
        }

        public Builder setLdapAttributeAuthorityRevocationListAttributeName(String r100) {
            this.ldapAttributeAuthorityRevocationListAttributeName = r100;
            return this;
        }

        public Builder setLdapAttributeCertificateAttributeAttributeName(String r100) {
            this.ldapAttributeCertificateAttributeAttributeName = r100;
            return this;
        }

        public Builder setLdapAttributeCertificateRevocationListAttributeName(String r100) {
            this.ldapAttributeCertificateRevocationListAttributeName = r100;
            return this;
        }

        public Builder setLdapAttributeDescriptorCertificateAttributeName(String r100) {
            this.ldapAttributeDescriptorCertificateAttributeName = r100;
            return this;
        }

        public Builder setLdapAuthorityRevocationListAttributeName(String r100) {
            this.ldapAuthorityRevocationListAttributeName = r100;
            return this;
        }

        public Builder setLdapCACertificateAttributeName(String r100) {
            this.ldapCACertificateAttributeName = r100;
            return this;
        }

        public Builder setLdapCertificateRevocationListAttributeName(String r100) {
            this.ldapCertificateRevocationListAttributeName = r100;
            return this;
        }

        public Builder setLdapCrossCertificateAttributeName(String r100) {
            this.ldapCrossCertificateAttributeName = r100;
            return this;
        }

        public Builder setLdapDeltaRevocationListAttributeName(String r100) {
            this.ldapDeltaRevocationListAttributeName = r100;
            return this;
        }

        public Builder setLdapUserCertificateAttributeName(String r100) {
            this.ldapUserCertificateAttributeName = r100;
            return this;
        }

        public Builder setSearchForSerialNumberIn(String r100) {
            this.searchForSerialNumberIn = r100;
            return this;
        }

        public Builder setUserCertificateAttribute(String r100) {
            this.userCertificateAttribute = r100;
            return this;
        }

        public Builder setUserCertificateSubjectAttributeName(String r100) {
            this.userCertificateSubjectAttributeName = r100;
            return this;
        }
    }

    private X509LDAPCertStoreParameters(Builder r100) {
        this.ldapURL = Builder.access$100(r100);
        this.baseDN = Builder.access$200(r100);
        this.userCertificateAttribute = Builder.access$300(r100);
        this.cACertificateAttribute = Builder.access$400(r100);
        this.crossCertificateAttribute = Builder.access$500(r100);
        this.certificateRevocationListAttribute = Builder.access$600(r100);
        this.deltaRevocationListAttribute = Builder.access$700(r100);
        this.authorityRevocationListAttribute = Builder.access$800(r100);
        this.attributeCertificateAttributeAttribute = Builder.access$900(r100);
        this.aACertificateAttribute = Builder.access$1000(r100);
        this.attributeDescriptorCertificateAttribute = Builder.access$1100(r100);
        this.attributeCertificateRevocationListAttribute = Builder.access$1200(r100);
        this.attributeAuthorityRevocationListAttribute = Builder.access$1300(r100);
        this.ldapUserCertificateAttributeName = Builder.access$1400(r100);
        this.ldapCACertificateAttributeName = Builder.access$1500(r100);
        this.ldapCrossCertificateAttributeName = Builder.access$1600(r100);
        this.ldapCertificateRevocationListAttributeName = Builder.access$1700(r100);
        this.ldapDeltaRevocationListAttributeName = Builder.access$1800(r100);
        this.ldapAuthorityRevocationListAttributeName = Builder.access$1900(r100);
        this.ldapAttributeCertificateAttributeAttributeName = Builder.access$2000(r100);
        this.ldapAACertificateAttributeName = Builder.access$2100(r100);
        this.ldapAttributeDescriptorCertificateAttributeName = Builder.access$2200(r100);
        this.ldapAttributeCertificateRevocationListAttributeName = Builder.access$2300(r100);
        this.ldapAttributeAuthorityRevocationListAttributeName = Builder.access$2400(r100);
        this.userCertificateSubjectAttributeName = Builder.access$2500(r100);
        this.cACertificateSubjectAttributeName = Builder.access$2600(r100);
        this.crossCertificateSubjectAttributeName = Builder.access$2700(r100);
        this.certificateRevocationListIssuerAttributeName = Builder.access$2800(r100);
        this.deltaRevocationListIssuerAttributeName = Builder.access$2900(r100);
        this.authorityRevocationListIssuerAttributeName = Builder.access$3000(r100);
        this.attributeCertificateAttributeSubjectAttributeName = Builder.access$3100(r100);
        this.aACertificateSubjectAttributeName = Builder.access$3200(r100);
        this.attributeDescriptorCertificateSubjectAttributeName = Builder.access$3300(r100);
        this.attributeCertificateRevocationListIssuerAttributeName = Builder.access$3400(r100);
        this.attributeAuthorityRevocationListIssuerAttributeName = Builder.access$3500(r100);
        this.searchForSerialNumberIn = Builder.access$3600(r100);
    }

    public /* synthetic */ X509LDAPCertStoreParameters(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    private int addHashCode(int r100, Object r101) {
        int r102 = r100 * 29;
        if (r101 != null) goto L5;
        int r103 = 0;
    L7:
        return r102 + r103;
    L5:
        r103 = r101.hashCode();
        goto L7
    }

    private boolean checkField(Object r100, Object r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.equals(r101);
    }

    public static X509LDAPCertStoreParameters getInstance(LDAPCertStoreParameters r100) {
        return new Builder("ldap://" + r100.getServerName() + ":" + r100.getPort(), "").build();
    }

    @Override // java.security.cert.CertStoreParameters
    public Object clone() {
        return this;
    }

    public boolean equal(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof X509LDAPCertStoreParameters) == true) goto L8;
        return false;
    L8:
        X509LDAPCertStoreParameters r101 = (X509LDAPCertStoreParameters) r100;
        if (checkField(this.ldapURL, r101.ldapURL) == true) goto L11;
    L81:
        return false;
    L11:
        if (checkField(this.baseDN, r101.baseDN) == false) goto L81;
        if (checkField(this.userCertificateAttribute, r101.userCertificateAttribute) == false) goto L81;
        if (checkField(this.cACertificateAttribute, r101.cACertificateAttribute) == false) goto L81;
        if (checkField(this.crossCertificateAttribute, r101.crossCertificateAttribute) == false) goto L81;
        if (checkField(this.certificateRevocationListAttribute, r101.certificateRevocationListAttribute) == false) goto L81;
        if (checkField(this.deltaRevocationListAttribute, r101.deltaRevocationListAttribute) == false) goto L81;
        if (checkField(this.authorityRevocationListAttribute, r101.authorityRevocationListAttribute) == false) goto L81;
        if (checkField(this.attributeCertificateAttributeAttribute, r101.attributeCertificateAttributeAttribute) == false) goto L81;
        if (checkField(this.aACertificateAttribute, r101.aACertificateAttribute) == false) goto L81;
        if (checkField(this.attributeDescriptorCertificateAttribute, r101.attributeDescriptorCertificateAttribute) == false) goto L81;
        if (checkField(this.attributeCertificateRevocationListAttribute, r101.attributeCertificateRevocationListAttribute) == false) goto L81;
        if (checkField(this.attributeAuthorityRevocationListAttribute, r101.attributeAuthorityRevocationListAttribute) == false) goto L81;
        if (checkField(this.ldapUserCertificateAttributeName, r101.ldapUserCertificateAttributeName) == false) goto L81;
        if (checkField(this.ldapCACertificateAttributeName, r101.ldapCACertificateAttributeName) == false) goto L81;
        if (checkField(this.ldapCrossCertificateAttributeName, r101.ldapCrossCertificateAttributeName) == false) goto L81;
        if (checkField(this.ldapCertificateRevocationListAttributeName, r101.ldapCertificateRevocationListAttributeName) == false) goto L81;
        if (checkField(this.ldapDeltaRevocationListAttributeName, r101.ldapDeltaRevocationListAttributeName) == false) goto L81;
        if (checkField(this.ldapAuthorityRevocationListAttributeName, r101.ldapAuthorityRevocationListAttributeName) == false) goto L81;
        if (checkField(this.ldapAttributeCertificateAttributeAttributeName, r101.ldapAttributeCertificateAttributeAttributeName) == false) goto L81;
        if (checkField(this.ldapAACertificateAttributeName, r101.ldapAACertificateAttributeName) == false) goto L81;
        if (checkField(this.ldapAttributeDescriptorCertificateAttributeName, r101.ldapAttributeDescriptorCertificateAttributeName) == false) goto L81;
        if (checkField(this.ldapAttributeCertificateRevocationListAttributeName, r101.ldapAttributeCertificateRevocationListAttributeName) == false) goto L81;
        if (checkField(this.ldapAttributeAuthorityRevocationListAttributeName, r101.ldapAttributeAuthorityRevocationListAttributeName) == false) goto L81;
        if (checkField(this.userCertificateSubjectAttributeName, r101.userCertificateSubjectAttributeName) == false) goto L81;
        if (checkField(this.cACertificateSubjectAttributeName, r101.cACertificateSubjectAttributeName) == false) goto L81;
        if (checkField(this.crossCertificateSubjectAttributeName, r101.crossCertificateSubjectAttributeName) == false) goto L81;
        if (checkField(this.certificateRevocationListIssuerAttributeName, r101.certificateRevocationListIssuerAttributeName) == false) goto L81;
        if (checkField(this.deltaRevocationListIssuerAttributeName, r101.deltaRevocationListIssuerAttributeName) == false) goto L81;
        if (checkField(this.authorityRevocationListIssuerAttributeName, r101.authorityRevocationListIssuerAttributeName) == false) goto L81;
        if (checkField(this.attributeCertificateAttributeSubjectAttributeName, r101.attributeCertificateAttributeSubjectAttributeName) == false) goto L81;
        if (checkField(this.aACertificateSubjectAttributeName, r101.aACertificateSubjectAttributeName) == false) goto L81;
        if (checkField(this.attributeDescriptorCertificateSubjectAttributeName, r101.attributeDescriptorCertificateSubjectAttributeName) == false) goto L81;
        if (checkField(this.attributeCertificateRevocationListIssuerAttributeName, r101.attributeCertificateRevocationListIssuerAttributeName) == false) goto L81;
        if (checkField(this.attributeAuthorityRevocationListIssuerAttributeName, r101.attributeAuthorityRevocationListIssuerAttributeName) == false) goto L81;
        if (checkField(this.searchForSerialNumberIn, r101.searchForSerialNumberIn) == false) goto L81;
        return true;
    }

    public String getAACertificateAttribute() {
        return this.aACertificateAttribute;
    }

    public String getAACertificateSubjectAttributeName() {
        return this.aACertificateSubjectAttributeName;
    }

    public String getAttributeAuthorityRevocationListAttribute() {
        return this.attributeAuthorityRevocationListAttribute;
    }

    public String getAttributeAuthorityRevocationListIssuerAttributeName() {
        return this.attributeAuthorityRevocationListIssuerAttributeName;
    }

    public String getAttributeCertificateAttributeAttribute() {
        return this.attributeCertificateAttributeAttribute;
    }

    public String getAttributeCertificateAttributeSubjectAttributeName() {
        return this.attributeCertificateAttributeSubjectAttributeName;
    }

    public String getAttributeCertificateRevocationListAttribute() {
        return this.attributeCertificateRevocationListAttribute;
    }

    public String getAttributeCertificateRevocationListIssuerAttributeName() {
        return this.attributeCertificateRevocationListIssuerAttributeName;
    }

    public String getAttributeDescriptorCertificateAttribute() {
        return this.attributeDescriptorCertificateAttribute;
    }

    public String getAttributeDescriptorCertificateSubjectAttributeName() {
        return this.attributeDescriptorCertificateSubjectAttributeName;
    }

    public String getAuthorityRevocationListAttribute() {
        return this.authorityRevocationListAttribute;
    }

    public String getAuthorityRevocationListIssuerAttributeName() {
        return this.authorityRevocationListIssuerAttributeName;
    }

    public String getBaseDN() {
        return this.baseDN;
    }

    public String getCACertificateAttribute() {
        return this.cACertificateAttribute;
    }

    public String getCACertificateSubjectAttributeName() {
        return this.cACertificateSubjectAttributeName;
    }

    public String getCertificateRevocationListAttribute() {
        return this.certificateRevocationListAttribute;
    }

    public String getCertificateRevocationListIssuerAttributeName() {
        return this.certificateRevocationListIssuerAttributeName;
    }

    public String getCrossCertificateAttribute() {
        return this.crossCertificateAttribute;
    }

    public String getCrossCertificateSubjectAttributeName() {
        return this.crossCertificateSubjectAttributeName;
    }

    public String getDeltaRevocationListAttribute() {
        return this.deltaRevocationListAttribute;
    }

    public String getDeltaRevocationListIssuerAttributeName() {
        return this.deltaRevocationListIssuerAttributeName;
    }

    public String getLdapAACertificateAttributeName() {
        return this.ldapAACertificateAttributeName;
    }

    public String getLdapAttributeAuthorityRevocationListAttributeName() {
        return this.ldapAttributeAuthorityRevocationListAttributeName;
    }

    public String getLdapAttributeCertificateAttributeAttributeName() {
        return this.ldapAttributeCertificateAttributeAttributeName;
    }

    public String getLdapAttributeCertificateRevocationListAttributeName() {
        return this.ldapAttributeCertificateRevocationListAttributeName;
    }

    public String getLdapAttributeDescriptorCertificateAttributeName() {
        return this.ldapAttributeDescriptorCertificateAttributeName;
    }

    public String getLdapAuthorityRevocationListAttributeName() {
        return this.ldapAuthorityRevocationListAttributeName;
    }

    public String getLdapCACertificateAttributeName() {
        return this.ldapCACertificateAttributeName;
    }

    public String getLdapCertificateRevocationListAttributeName() {
        return this.ldapCertificateRevocationListAttributeName;
    }

    public String getLdapCrossCertificateAttributeName() {
        return this.ldapCrossCertificateAttributeName;
    }

    public String getLdapDeltaRevocationListAttributeName() {
        return this.ldapDeltaRevocationListAttributeName;
    }

    public String getLdapURL() {
        return this.ldapURL;
    }

    public String getLdapUserCertificateAttributeName() {
        return this.ldapUserCertificateAttributeName;
    }

    public String getSearchForSerialNumberIn() {
        return this.searchForSerialNumberIn;
    }

    public String getUserCertificateAttribute() {
        return this.userCertificateAttribute;
    }

    public String getUserCertificateSubjectAttributeName() {
        return this.userCertificateSubjectAttributeName;
    }

    public int hashCode() {
        return addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(addHashCode(0, this.userCertificateAttribute), this.cACertificateAttribute), this.crossCertificateAttribute), this.certificateRevocationListAttribute), this.deltaRevocationListAttribute), this.authorityRevocationListAttribute), this.attributeCertificateAttributeAttribute), this.aACertificateAttribute), this.attributeDescriptorCertificateAttribute), this.attributeCertificateRevocationListAttribute), this.attributeAuthorityRevocationListAttribute), this.ldapUserCertificateAttributeName), this.ldapCACertificateAttributeName), this.ldapCrossCertificateAttributeName), this.ldapCertificateRevocationListAttributeName), this.ldapDeltaRevocationListAttributeName), this.ldapAuthorityRevocationListAttributeName), this.ldapAttributeCertificateAttributeAttributeName), this.ldapAACertificateAttributeName), this.ldapAttributeDescriptorCertificateAttributeName), this.ldapAttributeCertificateRevocationListAttributeName), this.ldapAttributeAuthorityRevocationListAttributeName), this.userCertificateSubjectAttributeName), this.cACertificateSubjectAttributeName), this.crossCertificateSubjectAttributeName), this.certificateRevocationListIssuerAttributeName), this.deltaRevocationListIssuerAttributeName), this.authorityRevocationListIssuerAttributeName), this.attributeCertificateAttributeSubjectAttributeName), this.aACertificateSubjectAttributeName), this.attributeDescriptorCertificateSubjectAttributeName), this.attributeCertificateRevocationListIssuerAttributeName), this.attributeAuthorityRevocationListIssuerAttributeName), this.searchForSerialNumberIn);
    }
}
