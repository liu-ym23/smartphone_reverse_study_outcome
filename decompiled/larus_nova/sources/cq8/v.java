package cq8;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f464970c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f464969b, r101.f464969b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464970c, r101.f464970c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f464969b.hashCode() * 31) + this.f464970c.hashCode();
    }

    public final String toString() {
        return "ImageTemplateChooseAction(widgetId=" + this.f464969b + ", template=" + this.f464970c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464969b;
    }

    public v(String r100, TemplateInfo$TemplateInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        super("ImageTemplateChooseAction");
        this.f464969b = r100;
        this.f464970c = r101;
    }
}
