package org.bouncycastle.asn1.smime;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public interface SMIMEAttributes {
    public static final ASN1ObjectIdentifier encrypKeyPref = null;
    public static final ASN1ObjectIdentifier smimeCapabilities = null;

    static {
        smimeCapabilities = PKCSObjectIdentifiers.pkcs_9_at_smimeCapabilities;
        encrypKeyPref = PKCSObjectIdentifiers.id_aa_encrypKeyPref;
    }
}
