package com.obric.miniapp.sheet;

import com.lynx.tasm.TemplateBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/miniapp/sheet/SheetPageContent;", "", "realUrl", "", "packageName", "bundleId", "isWidget", "", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/lynx/tasm/TemplateBundle;)V", "getRealUrl", "()Ljava/lang/String;", "getPackageName", "getBundleId", "()Z", "getBundle", "()Lcom/lynx/tasm/TemplateBundle;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SheetPageContent {
    private final TemplateBundle bundle;
    private final String bundleId;
    private final boolean isWidget;
    private final String packageName;
    private final String realUrl;

    public static /* synthetic */ SheetPageContent copy$default(SheetPageContent r100, String r101, String r102, String r103, boolean r104, TemplateBundle r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.realUrl;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.packageName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.bundleId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isWidget;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.bundle;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.realUrl;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.bundleId;
    }

    public final boolean component4() {
        return this.isWidget;
    }

    public final TemplateBundle component5() {
        return this.bundle;
    }

    public final SheetPageContent copy(String r100, String r101, String r110, boolean r111, TemplateBundle r112) {
        Intrinsics.checkNotNullParameter(r100, "realUrl");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        return new SheetPageContent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SheetPageContent) == true) goto L8;
        return false;
    L8:
        SheetPageContent r101 = (SheetPageContent) r100;
        if (Intrinsics.areEqual(this.realUrl, r101.realUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bundleId, r101.bundleId) == true) goto L18;
        return false;
    L18:
        if (this.isWidget == r101.isWidget) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bundle, r101.bundle) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String toString() {
        return "SheetPageContent(realUrl=" + this.realUrl + ", packageName=" + this.packageName + ", bundleId=" + this.bundleId + ", isWidget=" + this.isWidget + ", bundle=" + this.bundle + ')';
    }

    public int hashCode() {
        int r100 = ((this.realUrl.hashCode() * 31) + this.packageName.hashCode()) * 31;
        String r101 = this.bundleId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.isWidget == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        TemplateBundle r107 = this.bundle;
        if (r107 == null) goto L15;
        r107.getClass();
        r102 = System.identityHashCode(r107);
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final TemplateBundle getBundle() {
        return this.bundle;
    }

    public final String getBundleId() {
        return this.bundleId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getRealUrl() {
        return this.realUrl;
    }

    public final boolean isWidget() {
        return this.isWidget;
    }

    public SheetPageContent(String r100, String r101, String r102, boolean r103, TemplateBundle r104) {
        Intrinsics.checkNotNullParameter(r100, "realUrl");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        this.realUrl = r100;
        this.packageName = r101;
        this.bundleId = r102;
        this.isWidget = r103;
        this.bundle = r104;
    }
}
