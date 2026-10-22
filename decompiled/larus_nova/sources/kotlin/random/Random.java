package kotlin.random;

import androidx.camera.video.AudioStats;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class Random {
    public static final Default Default = null;
    private static final Random defaultRandom = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Random implements Serializable {

        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = null;
            private static final long serialVersionUID = 0;

            static {
                INSTANCE = new Serialized();
            }

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public /* synthetic */ Default(DefaultConstructorMarker r100) {
            this();
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.access$getDefaultRandom$cp().nextBoolean();
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.access$getDefaultRandom$cp().nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.access$getDefaultRandom$cp().nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.access$getDefaultRandom$cp().nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.access$getDefaultRandom$cp().nextLong();
        }

        private Default() {
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int r100) {
            return Random.access$getDefaultRandom$cp().nextBits(r100);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r100);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r100) {
            return Random.access$getDefaultRandom$cp().nextDouble(r100);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r100) {
            return Random.access$getDefaultRandom$cp().nextInt(r100);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r100) {
            return Random.access$getDefaultRandom$cp().nextLong(r100);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int r100) {
            return Random.access$getDefaultRandom$cp().nextBytes(r100);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r100, double r101) {
            return Random.access$getDefaultRandom$cp().nextDouble(r100, r101);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r100, int r101) {
            return Random.access$getDefaultRandom$cp().nextInt(r100, r101);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r100, long r101) {
            return Random.access$getDefaultRandom$cp().nextLong(r100, r101);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r100, r101, r102);
        }
    }

    public abstract int nextBits(int r100);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    static {
        Default = new Default(null);
        defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public Random() {
    }

    public static final /* synthetic */ Random access$getDefaultRandom$cp() {
        return defaultRandom;
    }

    public byte[] nextBytes(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return nextBytes(r100, 0, r100.length);
    }

    public double nextDouble(double r100) {
        return nextDouble(AudioStats.AUDIO_AMPLITUDE_NONE, r100);
    }

    public int nextInt(int r100) {
        return nextInt(0, r100);
    }

    public long nextLong(long r100) {
        return nextLong(0, r100);
    }

    public byte[] nextBytes(int r100) {
        return nextBytes(new byte[r100]);
    }

    public double nextDouble(double r100, double r101) {
        RandomKt.checkRangeBounds(r100, r101);
        double r102 = r101 - r100;
        if (Double.isInfinite(r102) == false) goto L19;
        boolean r103 = true;
        if (Double.isInfinite(r100) == false) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L19;
        if (Double.isInfinite(r101) == false) goto L14;
    L16:
        r103 = false;
    L17:
        if (r103 == false) goto L19;
        double r105 = 2;
        double r106 = nextDouble() * ((r101 / r105) - (r100 / r105));
        double r107 = (r100 + r106) + r106;
    L21:
        if (r107 >= r101) goto L23;
        return r107;
    L23:
        return Math.nextAfter(r101, Double.NEGATIVE_INFINITY);
    L14:
        if (Double.isNaN(r101) == true) goto L16;
    L7:
        if (Double.isNaN(r100) == true) goto L9;
        r104 = true;
    L19:
        r107 = r100 + (nextDouble() * r102);
        goto L21
    }

    public int nextInt(int r100, int r101) {
        RandomKt.checkRangeBounds(r100, r101);
        int r102 = r101 - r100;
        if (r102 > 0) goto L14;
        if (r102 == Integer.MIN_VALUE) goto L14;
    L7:
        int r103 = nextInt();
        boolean r104 = false;
        if (r100 > r103) goto L11;
        if (r103 >= r101) goto L11;
        r104 = true;
    L11:
        if (r104 == false) goto L7;
        return r103;
    L14:
        if (((-r102) & r102) != r102) goto L16;
        int r105 = nextBits(RandomKt.fastLog2(r102));
    L20:
        return r100 + r105;
    L16:
        int r106 = nextInt() >>> 1;
        int r107 = r106 % r102;
        if (((r106 - r107) + (r102 - 1)) < 0) goto L16;
        r105 = r107;
        goto L20
    }

    public long nextLong(long r110, long r111) {
        RandomKt.checkRangeBounds(r110, r111);
        long r100 = r111 - r110;
        if (r100 > 0) goto L5;
    L18:
        long r101 = nextLong();
        boolean r102 = false;
        if (r110 > r101) goto L23;
        if (r101 >= r111) goto L23;
        r102 = true;
    L23:
        if (r102 == false) goto L18;
        return r101;
    L5:
        if (((-r100) & r100) != r100) goto L13;
        int r112 = (int) r100;
        int r103 = (int) (r100 >>> 32);
        if (r112 == 0) goto L10;
        int r113 = nextBits(RandomKt.fastLog2(r112));
    L9:
        long r114 = ((long) r113) & BodyPartID.bodyIdMax;
    L17:
        return r110 + r114;
    L10:
        if (r103 != 1) goto L12;
        r113 = nextInt();
        goto L9
    L12:
        r114 = (((long) nextBits(RandomKt.fastLog2(r103))) << 32) + (((long) nextInt()) & BodyPartID.bodyIdMax);
    L13:
        long r115 = nextLong() >>> 1;
        long r104 = r115 % r100;
        if (((r115 - r104) + (r100 - 1)) < 0) goto L13;
        r114 = r104;
        goto L17
    }

    public byte[] nextBytes(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "array");
        boolean r103 = true;
        int r104 = 0;
        if (r101 >= 0) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L16;
        if (r102 >= 0) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == false) goto L16;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L33;
        if (r101 <= r102) goto L22;
        r103 = false;
    L22:
        if (r103 == false) goto L31;
        int r108 = (r102 - r101) / 4;
        int r109 = 0;
    L24:
        if (r109 >= r108) goto L26;
        int r110 = nextInt();
        r100[r101] = (byte) r110;
        r100[r101 + 1] = (byte) (r110 >>> 8);
        r100[r101 + 2] = (byte) (r110 >>> 16);
        r100[r101 + 3] = (byte) (r110 >>> 24);
        r101 = r101 + 4;
        r109 = r109 + 1;
        goto L24
    L26:
        int r111 = r102 - r101;
        int r112 = nextBits(r111 * 8);
    L27:
        if (r104 >= r111) goto L29;
        r100[r101 + r104] = (byte) (r112 >>> (r104 * 8));
        r104 = r104 + 1;
        goto L27
    L29:
        return r100;
    L31:
        throw new IllegalArgumentException(("fromIndex (" + r101 + ") must be not greater than toIndex (" + r102 + ").").toString());
    L33:
        throw new IllegalArgumentException(("fromIndex (" + r101 + ") or toIndex (" + r102 + ") are out of range: 0.." + r100.length + '.').toString());
    L11:
        if (r102 > r100.length) goto L13;
        r106 = true;
    L16:
        r107 = false;
        goto L18
    L5:
        if (r101 > r100.length) goto L7;
        r105 = true;
        goto L8
    }

    public static /* synthetic */ byte[] nextBytes$default(Random r100, byte[] r101, int r102, int r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = r101.length;
    L10:
        return r100.nextBytes(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }
}
