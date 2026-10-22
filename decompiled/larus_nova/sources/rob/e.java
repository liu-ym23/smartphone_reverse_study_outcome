package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.IconWithTitleItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f538809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IconWithTitleItemId f538811c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f538809a == r101.f538809a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538810b, r101.f538810b) == true) goto L15;
        return false;
    L15:
        if (this.f538811c == r101.f538811c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f538809a * 31) + this.f538810b.hashCode()) * 31) + this.f538811c.hashCode();
    }

    public final String toString() {
        return "IconWithTitleData(iconRes=" + this.f538809a + ", title=" + this.f538810b + ", itemId=" + this.f538811c + ')';
    }

    public e(int r100, String r101, IconWithTitleItemId r102) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "itemId");
        this.f538809a = r100;
        this.f538810b = r101;
        this.f538811c = r102;
    }
}
