package jj8;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.InteractionAskBlock;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f499351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InteractionAskBlock f499352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f499353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f499354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f499355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f499356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f499357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f499358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f499359i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<ResourceItemBean> f499360j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f499361k;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f499351a, r101.f499351a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499352b, r101.f499352b) == true) goto L15;
        return false;
    L15:
        if (this.f499353c == r101.f499353c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f499354d, r101.f499354d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f499355e, r101.f499355e) == true) goto L24;
        return false;
    L24:
        if (this.f499356f == r101.f499356f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f499357g, r101.f499357g) == true) goto L30;
        return false;
    L30:
        if (this.f499358h == r101.f499358h) goto L33;
        return false;
    L33:
        if (this.f499359i == r101.f499359i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f499360j, r101.f499360j) == true) goto L39;
        return false;
    L39:
        if (this.f499361k == r101.f499361k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f499351a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        InteractionAskBlock r104 = this.f499352b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((((((r103 + r101) * 31) + this.f499353c) * 31) + this.f499354d.hashCode()) * 31) + this.f499355e.hashCode()) * 31;
        int r106 = 1231;
        if (this.f499356f == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((r105 + r107) * 31) + this.f499357g.hashCode()) * 31;
        if (this.f499358h == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((((r108 + r109) * 31) + this.f499359i) * 31) + this.f499360j.hashCode()) * 31;
        if (this.f499361k == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionAskVMData(message=" + this.f499351a + ", interactionAskBlock=" + this.f499352b + ", questionIndex=" + this.f499353c + ", selectedOptionIds=" + this.f499354d + ", inputText=" + this.f499355e + ", allowInputText=" + this.f499356f + ", textPlaceholder=" + this.f499357g + ", hasAttachment=" + this.f499358h + ", attachmentCount=" + this.f499359i + ", attachmentItems=" + this.f499360j + ", showCloseButton=" + this.f499361k + ')';
    }

    public /* synthetic */ f(int r110) {
        this(null, null, 0, CollectionsKt.emptyList(), "", false, "", false, 0, CollectionsKt.emptyList(), true);
    }

    public f(Message r100, InteractionAskBlock r101, int r102, List<String> r103, String r104, boolean r105, String r106, boolean r107, int r110, List<ResourceItemBean> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r103, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r104, "inputText");
        Intrinsics.checkNotNullParameter(r106, "textPlaceholder");
        Intrinsics.checkNotNullParameter(r111, "attachmentItems");
        this.f499351a = r100;
        this.f499352b = r101;
        this.f499353c = r102;
        this.f499354d = r103;
        this.f499355e = r104;
        this.f499356f = r105;
        this.f499357g = r106;
        this.f499358h = r107;
        this.f499359i = r110;
        this.f499360j = r111;
        this.f499361k = r112;
    }
}
