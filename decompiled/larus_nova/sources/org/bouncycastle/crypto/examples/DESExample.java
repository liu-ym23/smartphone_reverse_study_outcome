package org.bouncycastle.crypto.examples;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.generators.DESedeKeyGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class DESExample {
    private PaddedBufferedBlockCipher cipher;
    private boolean encrypt;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private BufferedInputStream f525208in;
    private byte[] key;
    private BufferedOutputStream out;

    public DESExample() {
        this.encrypt = true;
        this.cipher = null;
        this.f525208in = null;
        this.out = null;
        this.key = null;
    }

    public DESExample(String r100, String r101, String r102, boolean r110) {
        SecureRandom r103 = null;
        this.cipher = null;
        this.f525208in = null;
        this.out = null;
        this.key = null;
        this.encrypt = r110;
        this.f525208in = new BufferedInputStream(new PolarisFileInputStreamWrapper(r100));     // Catch: FileNotFoundException -> L5
    L31:
        this.out = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: IOException -> L8
    L10:
        if (r110 == false) goto L33;
        SecureRandom r104 = new SecureRandom();     // Catch: Exception -> L24
        r104.setSeed("www.bouncycastle.org".getBytes());     // Catch: Exception -> L14
    L16:
        KeyGenerationParameters r111 = new KeyGenerationParameters(r104, 192);     // Catch: IOException -> L18
        DESedeKeyGenerator r105 = new DESedeKeyGenerator();     // Catch: IOException -> L18
        r105.init(r111);     // Catch: IOException -> L18
        this.key = r105.generateKey();     // Catch: IOException -> L18
        BufferedOutputStream r106 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r102));     // Catch: IOException -> L18
        byte[] r112 = Hex.encode(this.key);     // Catch: IOException -> L18
        r106.write(r112, 0, r112.length);     // Catch: IOException -> L18
        r106.flush();     // Catch: IOException -> L18
        r106.close();     // Catch: IOException -> L18
        return;
    L18:
        PrintStream r107 = System.err;
        StringBuilder r108 = new StringBuilder("Could not decryption create key file [");
    L22:
        r108.append(r102);
        r108.append("]");
        r107.println(r108.toString());
        System.exit(1);
        return;
    L14:
        r103 = r104;
    L35:
        System.err.println("Hmmm, no SHA1PRNG, you need the Sun implementation");     // Catch: IOException -> L18
        System.exit(1);     // Catch: IOException -> L18
        r104 = r103;
        goto L16
    L33:
        BufferedInputStream r109 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r102));     // Catch: IOException -> L21
        int r113 = r109.available();     // Catch: IOException -> L21
        byte[] r114 = new byte[r113];     // Catch: IOException -> L21
        r109.read(r114, 0, r113);     // Catch: IOException -> L21
        this.key = Hex.decode(r114);     // Catch: IOException -> L21
        return;
    L21:
        r107 = System.err;
        r108 = new StringBuilder("Decryption key file not found, or not valid [");
    L8:
        System.err.println("Output file not created [" + r101 + "]");
        System.exit(1);
    L5:
        System.err.println("Input file not found [" + r100 + "]");
        System.exit(1);
        goto L31
    }

    public static void main(String[] r100) {
        boolean r101 = true;
        if (r100.length >= 2) goto L5;
        new DESExample();
        System.err.println("Usage: java " + DESExample.class.getName() + " infile outfile [keyfile]");
        System.exit(1);
    L5:
        String r102 = r100[0];
        String r103 = r100[1];
        if (r100.length <= 2) goto L8;
        String r104 = r100[2];
        r101 = false;
    L9:
        new DESExample(r102, r103, r104, r101).process();
        return;
    L8:
        r104 = "deskey.dat";
        goto L9
    }

    private void performDecrypt(byte[] r110) {
        this.cipher.init(false, new KeyParameter(r110));
        BufferedReader r100 = new BufferedReader(new InputStreamReader(this.f525208in));
        byte[] r101 = null;
    L19:
        String r102 = r100.readLine();     // Catch: IOException -> L13
        if (r102 == null) goto L17;
        byte[] r103 = Hex.decode(r102);     // Catch: IOException -> L13
        r101 = new byte[this.cipher.getOutputSize(r103.length)];     // Catch: IOException -> L13
        int r104 = this.cipher.processBytes(r103, 0, r103.length, r101, 0);     // Catch: IOException -> L13
        if (r104 <= 0) goto L19;
        this.out.write(r101, 0, r104);     // Catch: IOException -> L13
        goto L19
    L17:
        int r105 = this.cipher.doFinal(r101, 0);     // Catch: IOException -> L13 CryptoException -> L16
        if (r105 <= 0) goto L24;
        this.out.write(r101, 0, r105);     // Catch: IOException -> L13 CryptoException -> L16
        goto L26
    L25:
        return;
    L24:
        return;
    L26:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private void performEncrypt(byte[] r110) {
        this.cipher.init(true, new KeyParameter(r110));
        byte[] r100 = new byte[47];
        byte[] r111 = new byte[this.cipher.getOutputSize(47)];
    L17:
        int r101 = this.f525208in.read(r100, 0, 47);     // Catch: IOException -> L13
        if (r101 <= 0) goto L19;
        int r102 = this.cipher.processBytes(r100, 0, r101, r111, 0);     // Catch: IOException -> L13
        if (r102 <= 0) goto L17;
        byte[] r103 = Hex.encode(r111, 0, r102);     // Catch: IOException -> L13
        this.out.write(r103, 0, r103.length);     // Catch: IOException -> L13
        this.out.write(10);     // Catch: IOException -> L13
        goto L17
    L19:
        int r104 = this.cipher.doFinal(r111, 0);     // Catch: IOException -> L13 CryptoException -> L16
        if (r104 <= 0) goto L24;
        byte[] r112 = Hex.encode(r111, 0, r104);     // Catch: IOException -> L13 CryptoException -> L16
        this.out.write(r112, 0, r112.length);     // Catch: IOException -> L13 CryptoException -> L16
        this.out.write(10);     // Catch: IOException -> L13 CryptoException -> L16
        goto L26
    L25:
        return;
    L24:
        return;
    L26:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private void process() {
        this.cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()));
        if (this.encrypt == false) goto L5;
        performEncrypt(this.key);
    L11:
        this.f525208in.close();     // Catch: IOException -> L8
        this.out.flush();     // Catch: IOException -> L8
        this.out.close();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        System.err.println("exception closing resources: " + e.getMessage());
        return;
    L5:
        performDecrypt(this.key);
        goto L11
    }
}
