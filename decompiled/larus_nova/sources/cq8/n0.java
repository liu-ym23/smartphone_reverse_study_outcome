package cq8;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bq8.a f464905c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f464904b, r101.f464904b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464905c, r101.f464905c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f464904b.hashCode() * 31) + this.f464905c.hashCode();
    }

    public final String toString() {
        return "MusicTemplateChooseAction(widgetId=" + this.f464904b + ", template=" + this.f464905c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464904b;
    }

    public n0(String r100, bq8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        super("MusicTemplateChooseAction");
        this.f464904b = r100;
        this.f464905c = r101;
    }
}
