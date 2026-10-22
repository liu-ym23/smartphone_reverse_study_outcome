package kotlin.random;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012B\u0017\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B7\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "w", BaseSwitches.V, "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XorWowRandom extends Random implements Serializable {
    private static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f504561v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f504562w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f504563x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f504564y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f504565z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/random/XorWowRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int r100 = this.f504563x;
        int r101 = r100 ^ (r100 >>> 2);
        this.f504563x = this.f504564y;
        this.f504564y = this.f504565z;
        this.f504565z = this.f504562w;
        int r102 = this.f504561v;
        this.f504562w = r102;
        int r103 = ((r101 ^ (r101 << 1)) ^ r102) ^ (r102 << 4);
        this.f504561v = r103;
        int r104 = this.addend + 362437;
        this.addend = r104;
        return r103 + r104;
    }

    @Override // kotlin.random.Random
    public int nextBits(int r100) {
        return RandomKt.takeUpperBits(nextInt(), r100);
    }

    public XorWowRandom(int r100, int r101) {
        this(r100, r101, 0, 0, ~r100, (r100 << 10) ^ (r101 >>> 4));
    }

    public XorWowRandom(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.f504563x = r100;
        this.f504564y = r101;
        this.f504565z = r102;
        this.f504562w = r103;
        this.f504561v = r104;
        this.addend = r105;
        int r106 = (((r100 | r101) | r102) | r103) | r104;
        int r107 = 0;
        if (r106 == 0) goto L5;
        boolean r108 = true;
    L6:
        if (r108 == false) goto L12;
    L8:
        if (r107 >= 64) goto L10;
        nextInt();
        r107 = r107 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    L5:
        r108 = false;
        goto L6
    }
}
