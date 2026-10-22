package nb8;

import com.larus.im.bean.message.Message;
import fh8.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fh8.f f518547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f518548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f518549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t.a f518550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f518551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f518552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f518553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final fh8.d f518554h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f518547a, r101.f518547a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f518548b, r101.f518548b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f518549c, r101.f518549c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f518550d, r101.f518550d) == true) goto L21;
        return false;
    L21:
        if (this.f518551e == r101.f518551e) goto L24;
        return false;
    L24:
        if (this.f518552f == r101.f518552f) goto L27;
        return false;
    L27:
        if (this.f518553g == r101.f518553g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f518554h, r101.f518554h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f518547a.hashCode() * 31) + this.f518548b.hashCode()) * 31) + this.f518549c.hashCode()) * 31) + this.f518550d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f518551e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f518552f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f518553g == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        fh8.d r107 = this.f518554h;
        if (r107 != null) goto L17;
        int r108 = 0;
    L19:
        return r106 + r108;
    L17:
        r108 = r107.hashCode();
        goto L19
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepThinkContentVmData(markdownCommonInputData=" + this.f518547a + ", message=" + this.f518548b + ", thinkingContent=" + this.f518549c + ", renderViewConfig=" + this.f518550d + ", isDeepThinkingTyping=" + this.f518551e + ", forceRefreshDeepThinkingArea=" + this.f518552f + ", forceRefreshAllSpan=" + this.f518553g + ", deepThinkFoldStatusManager=" + this.f518554h + ')';
    }

    public m(fh8.f r100, Message r101, String r102, t.a r103, boolean r104, boolean r105, boolean r106, fh8.d r107) {
        Intrinsics.checkNotNullParameter(r100, "markdownCommonInputData");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "thinkingContent");
        Intrinsics.checkNotNullParameter(r103, "renderViewConfig");
        this.f518547a = r100;
        this.f518548b = r101;
        this.f518549c = r102;
        this.f518550d = r103;
        this.f518551e = r104;
        this.f518552f = r105;
        this.f518553g = r106;
        this.f518554h = r107;
    }
}
