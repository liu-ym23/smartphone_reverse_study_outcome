package v4;

import com.bytedance.ai.debugscene.tag.DebugTagStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f552982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DebugTagStyle f552984c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f552982a == r101.f552982a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552983b, r101.f552983b) == true) goto L15;
        return false;
    L15:
        if (this.f552984c == r101.f552984c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f552982a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f552983b.hashCode()) * 31) + this.f552984c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DebugTag(showTag=" + this.f552982a + ", tagText=" + this.f552983b + ", style=" + this.f552984c + ')';
    }

    public /* synthetic */ a() {
        this(false, "", DebugTagStyle.LEGACY_PREVIEW);
    }

    public a(boolean r100, String r101, DebugTagStyle r102) {
        Intrinsics.checkNotNullParameter(r101, "tagText");
        Intrinsics.checkNotNullParameter(r102, "style");
        this.f552982a = r100;
        this.f552983b = r101;
        this.f552984c = r102;
    }
}
