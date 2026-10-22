package y4;

import com.bytedance.ai.view.input.v;
import com.bytedance.ai.view.input.w;
import com.bytedance.ai.view.input.x;
import com.bytedance.ai.view.input.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f565912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f565913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<b> f565914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f565915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f565916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f565917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<String> f565918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<String, String, Boolean> f565919h;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f565912a, r101.f565912a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565913b, r101.f565913b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565914c, r101.f565914c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565915d, r101.f565915d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f565916e, r101.f565916e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f565917f, r101.f565917f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f565918g, r101.f565918g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f565919h, r101.f565919h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f565912a.hashCode() * 31) + this.f565913b.hashCode()) * 31) + this.f565914c.hashCode()) * 31) + this.f565915d.hashCode()) * 31;
        Object r101 = this.f565916e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f565917f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f565918g.hashCode()) * 31;
        Function2<String, String, Boolean> r108 = this.f565919h;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OnSpeakAbility(cvsId=" + this.f565912a + ", botId=" + this.f565913b + ", visualizer=" + this.f565914c + ", isSubmit=" + this.f565915d + ", msgReq=" + this.f565916e + ", taskId=" + this.f565917f + ", appendQuery=" + this.f565918g + ", redirectQuery=" + this.f565919h + ')';
    }

    public c(w r100, x r101, y r102, v r103, Function0 r104, Function2 r105) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "botId");
        Intrinsics.checkNotNullParameter(r102, "visualizer");
        Intrinsics.checkNotNullParameter(r103, "isSubmit");
        Intrinsics.checkNotNullParameter(r104, "appendQuery");
        this.f565912a = r100;
        this.f565913b = r101;
        this.f565914c = r102;
        this.f565915d = r103;
        this.f565916e = null;
        this.f565917f = null;
        this.f565918g = r104;
        this.f565919h = r105;
    }
}
