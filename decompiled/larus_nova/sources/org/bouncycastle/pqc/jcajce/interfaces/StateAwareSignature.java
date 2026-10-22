package org.bouncycastle.pqc.jcajce.interfaces;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes42.dex */
public interface StateAwareSignature {
    String getAlgorithm();

    PrivateKey getUpdatedPrivateKey();

    void initSign(PrivateKey r100) throws InvalidKeyException;

    void initSign(PrivateKey r100, SecureRandom r101) throws InvalidKeyException;

    void initVerify(PublicKey r100) throws InvalidKeyException;

    void initVerify(Certificate r100) throws InvalidKeyException;

    boolean isSigningCapable();

    int sign(byte[] r100, int r101, int r102) throws SignatureException;

    byte[] sign() throws SignatureException;

    void update(byte r100) throws SignatureException;

    void update(ByteBuffer r100) throws SignatureException;

    void update(byte[] r100) throws SignatureException;

    void update(byte[] r100, int r101, int r102) throws SignatureException;

    boolean verify(byte[] r100) throws SignatureException;

    boolean verify(byte[] r100, int r101, int r102) throws SignatureException;
}
