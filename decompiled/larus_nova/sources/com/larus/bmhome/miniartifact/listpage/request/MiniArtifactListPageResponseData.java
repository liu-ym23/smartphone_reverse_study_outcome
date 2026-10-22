package com.larus.bmhome.miniartifact.listpage.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/MiniArtifactListPageResponseData;", "Ljava/io/Serializable;", "templatePageTitle", "", "templateEmptyHint", "inputEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "applicationEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "applicationTemplateList", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;Ljava/util/List;)V", "getTemplatePageTitle", "()Ljava/lang/String;", "getTemplateEmptyHint", "getInputEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "getApplicationEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "getApplicationTemplateList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactListPageResponseData implements Serializable {

    @SerializedName("application_entrance")
    private final ApplicationEntrance applicationEntrance;

    @SerializedName("application_template_list")
    private final List<ApplicationTemplate> applicationTemplateList;

    @SerializedName("input_entrance")
    private final InputEntrance inputEntrance;

    @SerializedName("template_empty_hint")
    private final String templateEmptyHint;

    @SerializedName("template_page_title")
    private final String templatePageTitle;

    public MiniArtifactListPageResponseData() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniArtifactListPageResponseData copy$default(MiniArtifactListPageResponseData r100, String r101, String r102, InputEntrance r103, ApplicationEntrance r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.templatePageTitle;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.templateEmptyHint;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.inputEntrance;
    L11:
        InputEntrance r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.applicationEntrance;
    L14:
        ApplicationEntrance r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.applicationTemplateList;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.templatePageTitle;
    }

    public final String component2() {
        return this.templateEmptyHint;
    }

    public final InputEntrance component3() {
        return this.inputEntrance;
    }

    public final ApplicationEntrance component4() {
        return this.applicationEntrance;
    }

    public final List<ApplicationTemplate> component5() {
        return this.applicationTemplateList;
    }

    public final MiniArtifactListPageResponseData copy(String r100, String r101, InputEntrance r110, ApplicationEntrance r111, List<ApplicationTemplate> r112) {
        return new MiniArtifactListPageResponseData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiniArtifactListPageResponseData) == true) goto L8;
        return false;
    L8:
        MiniArtifactListPageResponseData r101 = (MiniArtifactListPageResponseData) r100;
        if (Intrinsics.areEqual(this.templatePageTitle, r101.templatePageTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateEmptyHint, r101.templateEmptyHint) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputEntrance, r101.inputEntrance) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.applicationEntrance, r101.applicationEntrance) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.applicationTemplateList, r101.applicationTemplateList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.templatePageTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.templateEmptyHint;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        InputEntrance r107 = this.inputEntrance;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ApplicationEntrance r110 = this.applicationEntrance;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<ApplicationTemplate> r113 = this.applicationTemplateList;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MiniArtifactListPageResponseData(templatePageTitle=" + this.templatePageTitle + ", templateEmptyHint=" + this.templateEmptyHint + ", inputEntrance=" + this.inputEntrance + ", applicationEntrance=" + this.applicationEntrance + ", applicationTemplateList=" + this.applicationTemplateList + ')';
    }

    public final ApplicationEntrance getApplicationEntrance() {
        return this.applicationEntrance;
    }

    public final List<ApplicationTemplate> getApplicationTemplateList() {
        return this.applicationTemplateList;
    }

    public final InputEntrance getInputEntrance() {
        return this.inputEntrance;
    }

    public final String getTemplateEmptyHint() {
        return this.templateEmptyHint;
    }

    public final String getTemplatePageTitle() {
        return this.templatePageTitle;
    }

    public MiniArtifactListPageResponseData(String r100, String r101, InputEntrance r102, ApplicationEntrance r103, List<ApplicationTemplate> r104) {
        this.templatePageTitle = r100;
        this.templateEmptyHint = r101;
        this.inputEntrance = r102;
        this.applicationEntrance = r103;
        this.applicationTemplateList = r104;
    }

    public /* synthetic */ MiniArtifactListPageResponseData(String r100, String r101, InputEntrance r102, ApplicationEntrance r103, List r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        InputEntrance r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        ApplicationEntrance r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        List r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
