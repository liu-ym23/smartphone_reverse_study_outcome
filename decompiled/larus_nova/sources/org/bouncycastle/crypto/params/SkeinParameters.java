package org.bouncycastle.crypto.params;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class SkeinParameters implements CipherParameters {
    public static final int PARAM_TYPE_CONFIG = 4;
    public static final int PARAM_TYPE_KEY = 0;
    public static final int PARAM_TYPE_KEY_IDENTIFIER = 16;
    public static final int PARAM_TYPE_MESSAGE = 48;
    public static final int PARAM_TYPE_NONCE = 20;
    public static final int PARAM_TYPE_OUTPUT = 63;
    public static final int PARAM_TYPE_PERSONALISATION = 8;
    public static final int PARAM_TYPE_PUBLIC_KEY = 12;
    private Hashtable parameters;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.params.SkeinParameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Hashtable parameters;

        public Builder() {
            this.parameters = new Hashtable();
        }

        public Builder(Hashtable r100) {
            this.parameters = new Hashtable();
            Enumeration r101 = r100.keys();
        L4:
            if (r101.hasMoreElements() == false) goto L6;
            Integer r102 = (Integer) r101.nextElement();
            this.parameters.put(r102, r100.get(r102));
            goto L4
        }

        public Builder(SkeinParameters r100) {
            this.parameters = new Hashtable();
            Enumeration r101 = SkeinParameters.access$000(r100).keys();
        L4:
            if (r101.hasMoreElements() == false) goto L6;
            Integer r102 = (Integer) r101.nextElement();
            this.parameters.put(r102, SkeinParameters.access$000(r100).get(r102));
            goto L4
        }

        public SkeinParameters build() {
            return new SkeinParameters(this.parameters, null);
        }

        public Builder set(int r100, byte[] r101) {
            if (r101 == null) goto L19;
            if (r100 == 0) goto L13;
            if (r100 < 4) goto L12;
            if (r100 >= 63) goto L12;
            if (r100 != 48) goto L13;
        L12:
            throw new IllegalArgumentException("Parameter types must be in the range 0,5..47,49..62.");
        L13:
            if (r100 == 4) goto L17;
            this.parameters.put(Integers.valueOf(r100), r101);
            return this;
        L17:
            throw new IllegalArgumentException("Parameter type 4 is reserved for internal use.");
        L19:
            throw new IllegalArgumentException("Parameter value must not be null.");
        }

        public Builder setKey(byte[] r100) {
            return set(0, r100);
        }

        public Builder setKeyIdentifier(byte[] r100) {
            return set(16, r100);
        }

        public Builder setNonce(byte[] r100) {
            return set(20, r100);
        }

        public Builder setPersonalisation(Date r100, String r101, String r102) {
            ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: IOException -> L5
            OutputStreamWriter r104 = new OutputStreamWriter(r103, "UTF-8");     // Catch: IOException -> L5
            r104.write(new SimpleDateFormat("YYYYMMDD").format(r100));     // Catch: IOException -> L5
            r104.write(" ");     // Catch: IOException -> L5
            r104.write(r101);     // Catch: IOException -> L5
            r104.write(" ");     // Catch: IOException -> L5
            r104.write(r102);     // Catch: IOException -> L5
            r104.close();     // Catch: IOException -> L5
            return set(8, r103.toByteArray());
        L5:
            e = move-exception;
            throw new IllegalStateException("Byte I/O failed: " + e);
        }

        public Builder setPersonalisation(Date r100, Locale r101, String r102, String r103) {
            ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: IOException -> L5
            OutputStreamWriter r105 = new OutputStreamWriter(r104, "UTF-8");     // Catch: IOException -> L5
            r105.write(new SimpleDateFormat("YYYYMMDD", r101).format(r100));     // Catch: IOException -> L5
            r105.write(" ");     // Catch: IOException -> L5
            r105.write(r102);     // Catch: IOException -> L5
            r105.write(" ");     // Catch: IOException -> L5
            r105.write(r103);     // Catch: IOException -> L5
            r105.close();     // Catch: IOException -> L5
            return set(8, r104.toByteArray());
        L5:
            e = move-exception;
            throw new IllegalStateException("Byte I/O failed: " + e);
        }

        public Builder setPersonalisation(byte[] r100) {
            return set(8, r100);
        }

        public Builder setPublicKey(byte[] r100) {
            return set(12, r100);
        }
    }

    public SkeinParameters() {
        this(new Hashtable());
    }

    private SkeinParameters(Hashtable r100) {
        this.parameters = r100;
    }

    public /* synthetic */ SkeinParameters(Hashtable r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ Hashtable access$000(SkeinParameters r100) {
        return r100.parameters;
    }

    public byte[] getKey() {
        return (byte[]) this.parameters.get(Integers.valueOf(0));
    }

    public byte[] getKeyIdentifier() {
        return (byte[]) this.parameters.get(Integers.valueOf(16));
    }

    public byte[] getNonce() {
        return (byte[]) this.parameters.get(Integers.valueOf(20));
    }

    public Hashtable getParameters() {
        return this.parameters;
    }

    public byte[] getPersonalisation() {
        return (byte[]) this.parameters.get(Integers.valueOf(8));
    }

    public byte[] getPublicKey() {
        return (byte[]) this.parameters.get(Integers.valueOf(12));
    }
}
