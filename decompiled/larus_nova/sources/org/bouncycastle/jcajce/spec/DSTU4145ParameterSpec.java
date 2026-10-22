package org.bouncycastle.jcajce.spec;

import java.security.spec.ECParameterSpec;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU4145ParameterSpec extends ECParameterSpec {
    private final byte[] dke;
    private final ECDomainParameters parameters;

    public DSTU4145ParameterSpec(ECDomainParameters r100) {
        this(r100, EC5Util.convertToSpec(r100), DSTU4145Params.getDefaultDKE());
    }

    private DSTU4145ParameterSpec(ECDomainParameters r100, ECParameterSpec r101, byte[] r102) {
        super(r101.getCurve(), r101.getGenerator(), r101.getOrder(), r101.getCofactor());
        this.parameters = r100;
        this.dke = Arrays.clone(r102);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DSTU4145ParameterSpec) == true) goto L5;
        return false;
    L5:
        return this.parameters.equals(((DSTU4145ParameterSpec) r100).parameters);
    }

    public byte[] getDKE() {
        return Arrays.clone(this.dke);
    }

    public int hashCode() {
        return this.parameters.hashCode();
    }
}
