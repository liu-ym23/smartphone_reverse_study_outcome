package df8;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f468310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageItem f468311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f468312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f468313d;

    public /* synthetic */ a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f468310a == r101.f468310a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468311b, r101.f468311b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f468312c, r101.f468312c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468313d, r101.f468313d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f468310a * 31) + this.f468311b.hashCode()) * 31;
        TemplateInfo$TemplateInfo r101 = this.f468312c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, Object> r105 = this.f468313d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageItemInfo(index=" + this.f468310a + ", imageItem=" + this.f468311b + ", templateInfo=" + this.f468312c + ", commonTraceParams=" + this.f468313d + ')';
    }

    public a(int r100, ImageItem r101, TemplateInfo$TemplateInfo r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "imageItem");
        this.f468310a = r100;
        this.f468311b = r101;
        this.f468312c = r102;
        this.f468313d = r103;
    }
}
