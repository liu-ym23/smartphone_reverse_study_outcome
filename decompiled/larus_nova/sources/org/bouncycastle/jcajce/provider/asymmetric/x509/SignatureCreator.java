package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;

/* JADX INFO: loaded from: classes42.dex */
interface SignatureCreator {
    Signature createSignature(String r100) throws NoSuchAlgorithmException, NoSuchProviderException;
}
