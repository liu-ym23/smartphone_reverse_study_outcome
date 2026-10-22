package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;", "Ljava/io/Serializable;", "eventType", "", "jumpUrl", "", "toastContent", "mobEventName", "mobExtraParams", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventType", "()I", "getJumpUrl", "()Ljava/lang/String;", "getMobEventName", "getMobExtraParams", "getToastContent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TagClickEvent implements Serializable {

    @SerializedName("event_type")
    private final int eventType;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private final String mobEventName;

    @SerializedName("extra_params")
    private final String mobExtraParams;

    @SerializedName("toast_content")
    private final String toastContent;

    public TagClickEvent() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TagClickEvent copy$default(TagClickEvent r100, int r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.eventType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.jumpUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.toastContent;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.mobEventName;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.mobExtraParams;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.eventType;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final String component3() {
        return this.toastContent;
    }

    public final String component4() {
        return this.mobEventName;
    }

    public final String component5() {
        return this.mobExtraParams;
    }

    public final TagClickEvent copy(int r100, String r101, String r110, String r111, String r112) {
        return new TagClickEvent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagClickEvent) == true) goto L8;
        return false;
    L8:
        TagClickEvent r101 = (TagClickEvent) r100;
        if (this.eventType == r101.eventType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.toastContent, r101.toastContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mobEventName, r101.mobEventName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mobExtraParams, r101.mobExtraParams) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.eventType * 31;
        String r101 = this.jumpUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.toastContent;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.mobEventName;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.mobExtraParams;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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

    public String toString() {
        return "TagClickEvent(eventType=" + this.eventType + ", jumpUrl=" + this.jumpUrl + ", toastContent=" + this.toastContent + ", mobEventName=" + this.mobEventName + ", mobExtraParams=" + this.mobExtraParams + ')';
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getMobEventName() {
        return this.mobEventName;
    }

    public final String getMobExtraParams() {
        return this.mobExtraParams;
    }

    public final String getToastContent() {
        return this.toastContent;
    }

    public TagClickEvent(int r100, String r101, String r102, String r103, String r104) {
        this.eventType = r100;
        this.jumpUrl = r101;
        this.toastContent = r102;
        this.mobEventName = r103;
        this.mobExtraParams = r104;
    }

    public /* synthetic */ TagClickEvent(int r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r106 = "";
        if ((r105 & 2) == 0) goto L8;
        String r111 = "";
    L10:
        if ((r105 & 4) == 0) goto L12;
        String r107 = "";
    L14:
        if ((r105 & 8) == 0) goto L16;
        String r108 = "";
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
