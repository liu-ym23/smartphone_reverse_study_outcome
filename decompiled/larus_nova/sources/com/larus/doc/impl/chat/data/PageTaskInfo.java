package com.larus.doc.impl.chat.data;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/larus/doc/impl/chat/data/PageTaskInfo;", "Ljava/io/Serializable;", "actionBarKey", "", "selectedText", "paragraphText", ReportConstant.COMMON_ACTION_TYPE, "resourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionBarKey", "()Ljava/lang/String;", "getSelectedText", "getParagraphText", "getActionType", "getResourceId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageTaskInfo implements Serializable {

    @SerializedName("action_bar_key")
    private final String actionBarKey;

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName("paragraph_text")
    private final String paragraphText;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("selected_text")
    private final String selectedText;

    public PageTaskInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PageTaskInfo copy$default(PageTaskInfo r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.actionBarKey;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.selectedText;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.paragraphText;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.actionType;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.resourceId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.actionBarKey;
    }

    public final String component2() {
        return this.selectedText;
    }

    public final String component3() {
        return this.paragraphText;
    }

    public final String component4() {
        return this.actionType;
    }

    public final String component5() {
        return this.resourceId;
    }

    public final PageTaskInfo copy(String r100, String r101, String r110, String r111, String r112) {
        return new PageTaskInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PageTaskInfo) == true) goto L8;
        return false;
    L8:
        PageTaskInfo r101 = (PageTaskInfo) r100;
        if (Intrinsics.areEqual(this.actionBarKey, r101.actionBarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedText, r101.selectedText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.paragraphText, r101.paragraphText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.actionBarKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.selectedText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.paragraphText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.actionType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.resourceId;
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
        return "PageTaskInfo(actionBarKey=" + this.actionBarKey + ", selectedText=" + this.selectedText + ", paragraphText=" + this.paragraphText + ", actionType=" + this.actionType + ", resourceId=" + this.resourceId + ')';
    }

    public final String getActionBarKey() {
        return this.actionBarKey;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getParagraphText() {
        return this.paragraphText;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getSelectedText() {
        return this.selectedText;
    }

    public PageTaskInfo(String r100, String r101, String r102, String r103, String r104) {
        this.actionBarKey = r100;
        this.selectedText = r101;
        this.paragraphText = r102;
        this.actionType = r103;
        this.resourceId = r104;
    }

    public /* synthetic */ PageTaskInfo(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
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
