package ij8;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.block.InteractionAskOption;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f490137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<InteractionAskOption> f490138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f490139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f490140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f490141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f490142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f490143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<ResourceItemBean> f490144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f490145j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f490136a, r101.f490136a) == true) goto L12;
        return false;
    L12:
        if (this.f490137b == r101.f490137b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f490138c, r101.f490138c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f490139d, r101.f490139d) == true) goto L21;
        return false;
    L21:
        if (this.f490140e == r101.f490140e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f490141f, r101.f490141f) == true) goto L27;
        return false;
    L27:
        if (this.f490142g == r101.f490142g) goto L30;
        return false;
    L30:
        if (this.f490143h == r101.f490143h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f490144i, r101.f490144i) == true) goto L36;
        return false;
    L36:
        if (this.f490145j == r101.f490145j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f490136a.hashCode() * 31) + this.f490137b) * 31) + this.f490138c.hashCode()) * 31) + this.f490139d.hashCode()) * 31;
        int r101 = 1231;
        if (this.f490140e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f490141f.hashCode()) * 31;
        if (this.f490142g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((r103 + r104) * 31) + this.f490143h) * 31) + this.f490144i.hashCode()) * 31;
        if (this.f490145j == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "InteractionAskViewInput(title=" + this.f490136a + ", questionType=" + this.f490137b + ", options=" + this.f490138c + ", selectedOptionIds=" + this.f490139d + ", allowInputText=" + this.f490140e + ", textPlaceholder=" + this.f490141f + ", hasAttachment=" + this.f490142g + ", attachmentCount=" + this.f490143h + ", attachmentItems=" + this.f490144i + ", showCloseButton=" + this.f490145j + ')';
    }

    public p() {
        this("", 0, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, "", false, 0, CollectionsKt.emptyList(), true);
    }

    public p(String r100, int r101, List<InteractionAskOption> r102, List<String> r103, boolean r104, String r105, boolean r106, int r107, List<ResourceItemBean> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "options");
        Intrinsics.checkNotNullParameter(r103, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r105, "textPlaceholder");
        Intrinsics.checkNotNullParameter(r110, "attachmentItems");
        this.f490136a = r100;
        this.f490137b = r101;
        this.f490138c = r102;
        this.f490139d = r103;
        this.f490140e = r104;
        this.f490141f = r105;
        this.f490142g = r106;
        this.f490143h = r107;
        this.f490144i = r110;
        this.f490145j = r111;
    }
}
