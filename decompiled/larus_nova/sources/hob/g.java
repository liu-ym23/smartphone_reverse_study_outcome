package hob;

import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f486332f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.widget.span.b.AbstractC5432b<?> f486333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f486334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VideoInfo f486335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameInfo f486336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RichTextElement.MediaProperty f486337e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f486333a, r101.f486333a) == true) goto L12;
        return false;
    L12:
        if (this.f486334b == r101.f486334b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486335c, r101.f486335c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486336d, r101.f486336d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486337e, r101.f486337e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f486333a.hashCode() * 31) + this.f486334b) * 31) + this.f486335c.hashCode()) * 31) + this.f486336d.hashCode()) * 31;
        RichTextElement.MediaProperty r101 = this.f486337e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "InsertMediaInfo(coverLoadInfo=" + this.f486333a + ", duration=" + this.f486334b + ", videoInfo=" + this.f486335c + ", frameInfo=" + this.f486336d + ", mediaProperty=" + this.f486337e + ')';
    }

    public g(com.ss.android.lark.widget.span.b.AbstractC5432b<?> r100, int r101, VideoInfo r102, FrameInfo r103, RichTextElement.MediaProperty r104) {
        Intrinsics.checkNotNullParameter(r100, "coverLoadInfo");
        Intrinsics.checkNotNullParameter(r102, "videoInfo");
        Intrinsics.checkNotNullParameter(r103, "frameInfo");
        this.f486333a = r100;
        this.f486334b = r101;
        this.f486335c = r102;
        this.f486336d = r103;
        this.f486337e = r104;
    }
}
