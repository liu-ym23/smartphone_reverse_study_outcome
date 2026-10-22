package nb8;

import com.larus.im.bean.message.Message;
import fh8.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f518531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fh8.d f518532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f518533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fh8.f f518534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f518535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f518536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f518537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t.a f518538h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f518531a == r101.f518531a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f518532b, r101.f518532b) == true) goto L15;
        return false;
    L15:
        if (this.f518533c == r101.f518533c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f518534d, r101.f518534d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f518535e, r101.f518535e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f518536f, r101.f518536f) == true) goto L27;
        return false;
    L27:
        if (this.f518537g == r101.f518537g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f518538h, r101.f518538h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f518531a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        fh8.d r103 = this.f518532b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f518533c == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((((((r105 + r106) * 31) + this.f518534d.hashCode()) * 31) + this.f518535e.hashCode()) * 31) + this.f518536f.hashCode()) * 31;
        if (this.f518537g == true) goto L19;
        r100 = 1237;
    L19:
        return ((r107 + r100) * 31) + this.f518538h.hashCode();
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkContentViewInput(isDeepThinkingStreaming=" + this.f518531a + ", deepThinkFoldStatusManager=" + this.f518532b + ", needRefresh=" + this.f518533c + ", markdownCommonInputData=" + this.f518534d + ", message=" + this.f518535e + ", thinkingContent=" + this.f518536f + ", forceRefreshAllSpan=" + this.f518537g + ", renderViewConfig=" + this.f518538h + ')';
    }

    public i(boolean r100, fh8.d r101, boolean r102, fh8.f r103, Message r104, String r105, boolean r106, t.a r107) {
        Intrinsics.checkNotNullParameter(r103, "markdownCommonInputData");
        Intrinsics.checkNotNullParameter(r104, "message");
        Intrinsics.checkNotNullParameter(r105, "thinkingContent");
        Intrinsics.checkNotNullParameter(r107, "renderViewConfig");
        this.f518531a = r100;
        this.f518532b = r101;
        this.f518533c = r102;
        this.f518534d = r103;
        this.f518535e = r104;
        this.f518536f = r105;
        this.f518537g = r106;
        this.f518538h = r107;
    }
}
