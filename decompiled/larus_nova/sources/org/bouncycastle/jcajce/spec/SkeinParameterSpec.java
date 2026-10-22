package org.bouncycastle.jcajce.spec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.spec.AlgorithmParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class SkeinParameterSpec implements AlgorithmParameterSpec {
    public static final int PARAM_TYPE_CONFIG = 4;
    public static final int PARAM_TYPE_KEY = 0;
    public static final int PARAM_TYPE_KEY_IDENTIFIER = 16;
    public static final int PARAM_TYPE_MESSAGE = 48;
    public static final int PARAM_TYPE_NONCE = 20;
    public static final int PARAM_TYPE_OUTPUT = 63;
    public static final int PARAM_TYPE_PERSONALISATION = 8;
    public static final int PARAM_TYPE_PUBLIC_KEY = 12;
    private Map parameters;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.spec.SkeinParameterSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Map parameters;

        public Builder() {
            this.parameters = new HashMap();
        }

        public Builder(SkeinParameterSpec r100) {
            this.parameters = new HashMap();
            Iterator r101 = SkeinParameterSpec.access$000(r100).keySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Integer r102 = (Integer) r101.next();
            this.parameters.put(r102, SkeinParameterSpec.access$000(r100).get(r102));
            goto L4
        }

        public SkeinParameterSpec build() {
            return new SkeinParameterSpec(this.parameters, null);
        }

        public Builder set(int r100, byte[] r101) {
            if (r101 == null) goto L19;
            if (r100 == 0) goto L13;
            if (r100 <= 4) goto L12;
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

    public SkeinParameterSpec() {
        this(new HashMap());
    }

    private SkeinParameterSpec(Map r100) {
        this.parameters = Collections.unmodifiableMap(r100);
    }

    public /* synthetic */ SkeinParameterSpec(Map r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ Map access$000(SkeinParameterSpec r100) {
        return r100.parameters;
    }

    public byte[] getKey() {
        return Arrays.clone((byte[]) this.parameters.get(Integers.valueOf(0)));
    }

    public byte[] getKeyIdentifier() {
        return Arrays.clone((byte[]) this.parameters.get(Integers.valueOf(16)));
    }

    public byte[] getNonce() {
        return Arrays.clone((byte[]) this.parameters.get(Integers.valueOf(20)));
    }

    public Map getParameters() {
        return this.parameters;
    }

    public byte[] getPersonalisation() {
        return Arrays.clone((byte[]) this.parameters.get(Integers.valueOf(8)));
    }

    public byte[] getPublicKey() {
        return Arrays.clone((byte[]) this.parameters.get(Integers.valueOf(12)));
    }
}
