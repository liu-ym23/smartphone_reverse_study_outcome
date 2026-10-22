package hob;

import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f486326f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.widget.span.b.AbstractC5432b<?> f486327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RichTextElement.ImageProperty f486330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f486331e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f486327a, r101.f486327a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486328b, r101.f486328b) == true) goto L15;
        return false;
    L15:
        if (this.f486329c == r101.f486329c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486330d, r101.f486330d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f486327a.hashCode() * 31) + this.f486328b.hashCode()) * 31;
        if (this.f486329c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        RichTextElement.ImageProperty r103 = this.f486330d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "InsertImageInfo(imageInfo=" + this.f486327a + ", imageToken=" + this.f486328b + ", keepOrigin=" + this.f486329c + ", imageProperty=" + this.f486330d + ')';
    }

    public f(com.ss.android.lark.widget.span.b.AbstractC5432b<?> r100, String r101, boolean r102, RichTextElement.ImageProperty r103) {
        Intrinsics.checkNotNullParameter(r100, "imageInfo");
        Intrinsics.checkNotNullParameter(r101, "imageToken");
        this.f486327a = r100;
        this.f486328b = r101;
        this.f486329c = r102;
        this.f486330d = r103;
        this.f486331e = -1;
    }
}
