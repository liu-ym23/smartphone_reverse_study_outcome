package tr4;

import com.bytedance.ee.bear.bitable.context.BitableBlockType;
import com.bytedance.ee.bear.bitable.context.BitableViewType;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableBlockType f547299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableViewType f547301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f547302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f547303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f547304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f547305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f547306h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f547299a == r101.f547299a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547300b, r101.f547300b) == true) goto L15;
        return false;
    L15:
        if (this.f547301c == r101.f547301c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f547302d, r101.f547302d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f547303e, r101.f547303e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f547304f, r101.f547304f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f547305g, r101.f547305g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f547306h, r101.f547306h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f547299a.hashCode() * 31) + this.f547300b.hashCode()) * 31;
        BitableViewType r101 = this.f547301c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f547302d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f547303e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f547304f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f547305g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f547306h;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BitableViewParam(blockType=" + this.f547299a + ", blockId=" + this.f547300b + ", viewType=" + this.f547301c + ", viewId=" + this.f547302d + ", dashboardToken=" + this.f547303e + ", workflowToken=" + this.f547304f + ", docToken=" + this.f547305g + ", pageId=" + this.f547306h + ')';
    }

    public e(BitableBlockType r100, String r101, BitableViewType r102, String r103, String r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 128) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "blockType");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.BLOCK_ID);
        this.f547299a = r100;
        this.f547300b = r101;
        this.f547301c = r102;
        this.f547302d = r103;
        this.f547303e = null;
        this.f547304f = null;
        this.f547305g = null;
        this.f547306h = r104;
    }
}
