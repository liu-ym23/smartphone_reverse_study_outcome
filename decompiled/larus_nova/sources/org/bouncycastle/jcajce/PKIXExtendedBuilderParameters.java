package org.bouncycastle.jcajce;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXExtendedBuilderParameters implements CertPathParameters {
    private final PKIXExtendedParameters baseParameters;
    private final Set<X509Certificate> excludedCerts;
    private final int maxPathLength;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.PKIXExtendedBuilderParameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final PKIXExtendedParameters baseParameters;
        private Set<X509Certificate> excludedCerts;
        private int maxPathLength;

        public Builder(PKIXBuilderParameters r100) {
            this.maxPathLength = 5;
            this.excludedCerts = new HashSet();
            this.baseParameters = new PKIXExtendedParameters.Builder(r100).build();
            this.maxPathLength = r100.getMaxPathLength();
        }

        public Builder(PKIXExtendedParameters r100) {
            this.maxPathLength = 5;
            this.excludedCerts = new HashSet();
            this.baseParameters = r100;
        }

        public static /* synthetic */ PKIXExtendedParameters access$100(Builder r100) {
            return r100.baseParameters;
        }

        public static /* synthetic */ Set access$200(Builder r100) {
            return r100.excludedCerts;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.maxPathLength;
        }

        public Builder addExcludedCerts(Set<X509Certificate> r100) {
            this.excludedCerts.addAll(r100);
            return this;
        }

        public PKIXExtendedBuilderParameters build() {
            return new PKIXExtendedBuilderParameters(this, null);
        }

        public Builder setMaxPathLength(int r100) {
            if (r100 < (-1)) goto L7;
            this.maxPathLength = r100;
            return this;
        L7:
            throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
        }
    }

    private PKIXExtendedBuilderParameters(Builder r100) {
        this.baseParameters = Builder.access$100(r100);
        this.excludedCerts = Collections.unmodifiableSet(Builder.access$200(r100));
        this.maxPathLength = Builder.access$300(r100);
    }

    public /* synthetic */ PKIXExtendedBuilderParameters(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        return this;
    }

    public PKIXExtendedParameters getBaseParameters() {
        return this.baseParameters;
    }

    public Set getExcludedCerts() {
        return this.excludedCerts;
    }

    public int getMaxPathLength() {
        return this.maxPathLength;
    }
}
