package com.ss.android.lark.seccache.impl;

import android.os.Build;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Provider;
import java.security.SecureRandomSpi;

/* JADX INFO: loaded from: classes38.dex */
public final class AesCbcUtils$PrngFixes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f440383a = null;

    public static class LinuxPRNGSecureRandom extends SecureRandomSpi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PolarisFileWrapper f440384a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Object f440385b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static DataInputStream f440386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static PolarisFileOutputStreamWrapper f440387d;
        private boolean mSeeded;

        static {
            f440384a = new PolarisFileWrapper("/dev/urandom");
            f440385b = new Object();
        }

        public static DataInputStream a() {
            Object r100 = f440385b;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (f440386c == null) goto L17;
        L11:
            DataInputStream r101 = f440386c;     // Catch: Throwable -> L14
            monitor-exit(r100);     // Catch: Throwable -> L14
            return r101;
        L17:
            f440386c = new DataInputStream(new PolarisFileInputStreamWrapper(f440384a));     // Catch: IOException -> L8 Throwable -> L14
        L8:
            e = move-exception;
            throw new SecurityException("Failed to open " + f440384a + " for reading", e);     // Catch: Throwable -> L14
        }

        public static OutputStream b() throws IOException {
            Object r100 = f440385b;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (f440387d != null) goto L7;
            f440387d = new PolarisFileOutputStreamWrapper(f440384a);     // Catch: Throwable -> L10
        L7:
            PolarisFileOutputStreamWrapper r101 = f440387d;     // Catch: Throwable -> L10
            monitor-exit(r100);     // Catch: Throwable -> L10
            return r101;
        }

        public LinuxPRNGSecureRandom() {
        }

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int r100) {
            byte[] r101 = new byte[r100];
            engineNextBytes(r101);
            return r101;
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] r100) {
            if (this.mSeeded == true) goto L27;
            byte[] r101 = AesCbcUtils$PrngFixes.f440383a;
            ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: IOException -> L7
            DataOutputStream r103 = new DataOutputStream(r102);     // Catch: IOException -> L7
            r103.writeLong(System.currentTimeMillis());     // Catch: IOException -> L7
            r103.writeLong(System.nanoTime());     // Catch: IOException -> L7
            r103.writeInt(Process.myPid());     // Catch: IOException -> L7
            r103.writeInt(Process.myUid());     // Catch: IOException -> L7
            r103.write(AesCbcUtils$PrngFixes.f440383a);     // Catch: IOException -> L7
            r103.close();     // Catch: IOException -> L7
            engineSetSeed(r102.toByteArray());
        L7:
            e = move-exception;
            throw new SecurityException("Failed to generate seed", e);
        L27:
            Object r104 = f440385b;     // Catch: IOException -> L24
            monitor-enter(r104);     // Catch: IOException -> L24
            DataInputStream r105 = a();     // Catch: Throwable -> L21
            monitor-exit(r104);     // Catch: Throwable -> L21
            monitor-enter(r105);     // Catch: IOException -> L24
            r105.readFully(r100);     // Catch: Throwable -> L18
            monitor-exit(r105);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;     // Catch: IOException -> L24
        L21:
            th = move-exception;
            throw th;     // Catch: IOException -> L24
        L24:
            e = move-exception;
            throw new SecurityException("Failed to read from " + f440384a, e);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] r100) {
            Object r101 = f440385b;     // Catch: Throwable -> L12 IOException -> L14
            monitor-enter(r101);     // Catch: Throwable -> L12 IOException -> L14
            OutputStream r102 = b();     // Catch: Throwable -> L9
            monitor-exit(r101);     // Catch: Throwable -> L9
            r102.write(r100);     // Catch: Throwable -> L12 IOException -> L14
            r102.flush();     // Catch: Throwable -> L12 IOException -> L14
        L16:
            this.mSeeded = true;
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12 IOException -> L14
        L12:
            th = move-exception;
            this.mSeeded = true;
            throw th;
        L14:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L12
            goto L16
        }
    }

    public static class LinuxPRNGSecureRandomProvider extends Provider {
        public LinuxPRNGSecureRandomProvider() {
            super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", LinuxPRNGSecureRandom.class.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    static {
        StringBuilder r100 = new StringBuilder();
        String r101 = Build.FINGERPRINT;
        if (r101 == null) goto L5;
        r100.append(r101);
    L5:
        String r102 = null;
        r102 = (String) Build.class.getField("SERIAL").get(null);     // Catch: Exception -> L8
    L9:
        if (r102 == null) goto L11;
        r100.append(r102);
    L11:
        f440383a = r100.toString().getBytes(StandardCharsets.UTF_8);
    }
}
