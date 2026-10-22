package o21;

import com.bytedance.android.live.link.player.MultiPlayerScene;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor.PlayerStatus;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiPlayerScene f521757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlayerStatus f521758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f521759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f521760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f521761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Float f521762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f521763g;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f521757a, this.f521758b, this.f521759c, this.f521760d, this.f521761e, this.f521762f});
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("playerScene = " + this.f521757a + ", errorCode = " + this.f521758b);
        if (this.f521759c == null) goto L6;
        r100.append(", ratioLeft = " + this.f521759c);
    L6:
        if (this.f521760d == null) goto L9;
        r100.append(", ratioTop = " + this.f521760d);
    L9:
        if (this.f521761e == null) goto L12;
        r100.append(", ratioRight = " + this.f521761e);
    L12:
        if (this.f521762f == null) goto L15;
        r100.append(", ratioBottom = " + this.f521762f);
    L15:
        if (this.f521763g == null) goto L18;
        r100.append(", message = " + this.f521763g);
    L18:
        return r100.toString();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L36;
        a r102 = (a) r100;
        if (this.f521757a == r102.f521757a) goto L17;
        return false;
    L17:
        if (this.f521758b == r102.f521758b) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f521759c, r102.f521759c)) == false) goto L23;
        return false;
    L23:
        if ((!Intrinsics.areEqual(this.f521760d, r102.f521760d)) == false) goto L26;
        return false;
    L26:
        if ((!Intrinsics.areEqual(this.f521761e, r102.f521761e)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(this.f521762f, r102.f521762f)) == false) goto L32;
        return false;
    L32:
        if ((!Intrinsics.areEqual(this.f521763g, r102.f521763g)) == false) goto L34;
        return false;
    L34:
        return true;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor.MultiPlayerMessage");
    L8:
        r101 = null;
        goto L10
    }

    public /* synthetic */ a(MultiPlayerScene r100, PlayerStatus r110) {
        this(r100, r110, null, null, null, null, null);
    }

    public a(MultiPlayerScene r100, PlayerStatus r101, Float r102, Float r103, Float r104, Float r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "playerScene");
        Intrinsics.checkNotNullParameter(r101, "playerStatus");
        this.f521757a = r100;
        this.f521758b = r101;
        this.f521759c = r102;
        this.f521760d = r103;
        this.f521761e = r104;
        this.f521762f = r105;
        this.f521763g = r106;
    }
}
