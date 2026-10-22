package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.crypto.PasswordConverter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Argon2Parameters {
    public static final int ARGON2_VERSION_10 = 16;
    public static final int ARGON2_VERSION_13 = 19;
    public static final int ARGON2_d = 0;
    public static final int ARGON2_i = 1;
    public static final int ARGON2_id = 2;
    private static final int DEFAULT_ITERATIONS = 3;
    private static final int DEFAULT_LANES = 1;
    private static final int DEFAULT_MEMORY_COST = 12;
    private static final int DEFAULT_TYPE = 1;
    private static final int DEFAULT_VERSION = 19;
    private final byte[] additional;
    private final CharToByteConverter converter;
    private final int iterations;
    private final int lanes;
    private final int memory;
    private final byte[] salt;
    private final byte[] secret;
    private final int type;
    private final int version;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.params.Argon2Parameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private byte[] additional;
        private CharToByteConverter converter;
        private int iterations;
        private int lanes;
        private int memory;
        private byte[] salt;
        private byte[] secret;
        private final int type;
        private int version;

        public Builder() {
            this(1);
        }

        public Builder(int r100) {
            this.converter = PasswordConverter.UTF8;
            this.type = r100;
            this.lanes = 1;
            this.memory = 4096;
            this.iterations = 3;
            this.version = 19;
        }

        public Argon2Parameters build() {
            return new Argon2Parameters(this.type, this.salt, this.secret, this.additional, this.iterations, this.memory, this.lanes, this.version, this.converter, null);
        }

        public void clear() {
            Arrays.clear(this.salt);
            Arrays.clear(this.secret);
            Arrays.clear(this.additional);
        }

        public Builder withAdditional(byte[] r100) {
            this.additional = Arrays.clone(r100);
            return this;
        }

        public Builder withCharToByteConverter(CharToByteConverter r100) {
            this.converter = r100;
            return this;
        }

        public Builder withIterations(int r100) {
            this.iterations = r100;
            return this;
        }

        public Builder withMemoryAsKB(int r100) {
            this.memory = r100;
            return this;
        }

        public Builder withMemoryPowOfTwo(int r100) {
            this.memory = 1 << r100;
            return this;
        }

        public Builder withParallelism(int r100) {
            this.lanes = r100;
            return this;
        }

        public Builder withSalt(byte[] r100) {
            this.salt = Arrays.clone(r100);
            return this;
        }

        public Builder withSecret(byte[] r100) {
            this.secret = Arrays.clone(r100);
            return this;
        }

        public Builder withVersion(int r100) {
            this.version = r100;
            return this;
        }
    }

    private Argon2Parameters(int r100, byte[] r101, byte[] r102, byte[] r103, int r104, int r105, int r106, int r107, CharToByteConverter r108) {
        this.salt = Arrays.clone(r101);
        this.secret = Arrays.clone(r102);
        this.additional = Arrays.clone(r103);
        this.iterations = r104;
        this.memory = r105;
        this.lanes = r106;
        this.version = r107;
        this.type = r100;
        this.converter = r108;
    }

    public /* synthetic */ Argon2Parameters(int r100, byte[] r101, byte[] r102, byte[] r103, int r104, int r105, int r106, int r107, CharToByteConverter r108, AnonymousClass1 r110) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public void clear() {
        Arrays.clear(this.salt);
        Arrays.clear(this.secret);
        Arrays.clear(this.additional);
    }

    public byte[] getAdditional() {
        return Arrays.clone(this.additional);
    }

    public CharToByteConverter getCharToByteConverter() {
        return this.converter;
    }

    public int getIterations() {
        return this.iterations;
    }

    public int getLanes() {
        return this.lanes;
    }

    public int getMemory() {
        return this.memory;
    }

    public byte[] getSalt() {
        return Arrays.clone(this.salt);
    }

    public byte[] getSecret() {
        return Arrays.clone(this.secret);
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }
}
