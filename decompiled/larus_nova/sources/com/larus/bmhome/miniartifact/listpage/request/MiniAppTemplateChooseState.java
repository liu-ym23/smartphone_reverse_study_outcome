package com.larus.bmhome.miniartifact.listpage.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jk\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/MiniAppTemplateChooseState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "foo", "", "pageStatus", "Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;", "templatePageTitle", "", "templateEmptyHint", "myArtifactTitle", "currentRenderTemplateList", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "inputEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "applicationEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "<init>", "(ZLcom/larus/bmhome/miniartifact/listpage/request/PageStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;)V", "getFoo", "()Z", "getPageStatus", "()Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;", "getTemplatePageTitle", "()Ljava/lang/String;", "getTemplateEmptyHint", "getMyArtifactTitle", "getCurrentRenderTemplateList", "()Ljava/util/List;", "getInputEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "getApplicationEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppTemplateChooseState implements w1a.b {
    private final ApplicationEntrance applicationEntrance;
    private final List<ApplicationTemplate> currentRenderTemplateList;
    private final boolean foo;
    private final InputEntrance inputEntrance;
    private final String myArtifactTitle;
    private final PageStatus pageStatus;
    private final String templateEmptyHint;
    private final String templatePageTitle;

    public MiniAppTemplateChooseState() {
        this(false, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniAppTemplateChooseState copy$default(MiniAppTemplateChooseState r100, boolean r110, PageStatus r111, String r112, String r113, String r114, List r115, InputEntrance r116, ApplicationEntrance r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.foo;
    L7:
        if ((r118 & 2) == 0) goto L9;
        PageStatus r102 = r100.pageStatus;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.templatePageTitle;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.templateEmptyHint;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.myArtifactTitle;
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = r100.currentRenderTemplateList;
    L27:
        if ((r118 & 64) == 0) goto L29;
        InputEntrance r107 = r100.inputEntrance;
    L31:
        if ((r118 & 128) == 0) goto L33;
        ApplicationEntrance r108 = r100.applicationEntrance;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final boolean component1() {
        return this.foo;
    }

    public final PageStatus component2() {
        return this.pageStatus;
    }

    public final String component3() {
        return this.templatePageTitle;
    }

    public final String component4() {
        return this.templateEmptyHint;
    }

    public final String component5() {
        return this.myArtifactTitle;
    }

    public final List<ApplicationTemplate> component6() {
        return this.currentRenderTemplateList;
    }

    public final InputEntrance component7() {
        return this.inputEntrance;
    }

    public final ApplicationEntrance component8() {
        return this.applicationEntrance;
    }

    public final MiniAppTemplateChooseState copy(boolean r110, PageStatus r111, String r112, String r113, String r114, List<ApplicationTemplate> r115, InputEntrance r116, ApplicationEntrance r117) {
        Intrinsics.checkNotNullParameter(r111, "pageStatus");
        return new MiniAppTemplateChooseState(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiniAppTemplateChooseState) == true) goto L8;
        return false;
    L8:
        MiniAppTemplateChooseState r101 = (MiniAppTemplateChooseState) r100;
        if (this.foo == r101.foo) goto L12;
        return false;
    L12:
        if (this.pageStatus == r101.pageStatus) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templatePageTitle, r101.templatePageTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateEmptyHint, r101.templateEmptyHint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.myArtifactTitle, r101.myArtifactTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.currentRenderTemplateList, r101.currentRenderTemplateList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.inputEntrance, r101.inputEntrance) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.applicationEntrance, r101.applicationEntrance) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        if (this.foo == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.pageStatus.hashCode()) * 31;
        String r102 = this.templatePageTitle;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.templateEmptyHint;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.myArtifactTitle;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        List<ApplicationTemplate> r112 = this.currentRenderTemplateList;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        InputEntrance r115 = this.inputEntrance;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        ApplicationEntrance r118 = this.applicationEntrance;
        if (r118 == null) goto L31;
        r103 = r118.hashCode();
    L31:
        return r117 + r103;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "MiniAppTemplateChooseState(foo=" + this.foo + ", pageStatus=" + this.pageStatus + ", templatePageTitle=" + this.templatePageTitle + ", templateEmptyHint=" + this.templateEmptyHint + ", myArtifactTitle=" + this.myArtifactTitle + ", currentRenderTemplateList=" + this.currentRenderTemplateList + ", inputEntrance=" + this.inputEntrance + ", applicationEntrance=" + this.applicationEntrance + ')';
    }

    public final ApplicationEntrance getApplicationEntrance() {
        return this.applicationEntrance;
    }

    public final List<ApplicationTemplate> getCurrentRenderTemplateList() {
        return this.currentRenderTemplateList;
    }

    public final boolean getFoo() {
        return this.foo;
    }

    public final InputEntrance getInputEntrance() {
        return this.inputEntrance;
    }

    public final String getMyArtifactTitle() {
        return this.myArtifactTitle;
    }

    public final PageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final String getTemplateEmptyHint() {
        return this.templateEmptyHint;
    }

    public final String getTemplatePageTitle() {
        return this.templatePageTitle;
    }

    public MiniAppTemplateChooseState(boolean r100, PageStatus r101, String r102, String r103, String r104, List<ApplicationTemplate> r105, InputEntrance r106, ApplicationEntrance r107) {
        Intrinsics.checkNotNullParameter(r101, "pageStatus");
        this.foo = r100;
        this.pageStatus = r101;
        this.templatePageTitle = r102;
        this.templateEmptyHint = r103;
        this.myArtifactTitle = r104;
        this.currentRenderTemplateList = r105;
        this.inputEntrance = r106;
        this.applicationEntrance = r107;
    }

    public /* synthetic */ MiniAppTemplateChooseState(boolean r110, PageStatus r111, String r112, String r113, String r114, List r115, InputEntrance r116, ApplicationEntrance r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r118 & 2) == 0) goto L9;
        PageStatus r101 = PageStatus.LOADING;
    L10:
        ApplicationEntrance r102 = null;
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        InputEntrance r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r100, r101, r103, r104, r105, r106, r107, r102);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
