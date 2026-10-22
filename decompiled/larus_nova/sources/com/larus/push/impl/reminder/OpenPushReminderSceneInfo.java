package com.larus.push.impl.reminder;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0004\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/larus/push/impl/reminder/OpenPushReminderSceneInfo;", "", "sceneId", "", "isOpen", "", "eventTimes", "", "title", "subTitle", "bubbleInfo", "Lcom/larus/push/impl/reminder/BubbleInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/push/impl/reminder/BubbleInfo;)V", "getSceneId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEventTimes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getSubTitle", "getBubbleInfo", "()Lcom/larus/push/impl/reminder/BubbleInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/push/impl/reminder/BubbleInfo;)Lcom/larus/push/impl/reminder/OpenPushReminderSceneInfo;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPushReminderSceneInfo {

    @SerializedName("bubble_info")
    private final BubbleInfo bubbleInfo;

    @SerializedName("event_times")
    private final Integer eventTimes;

    @SerializedName("is_open")
    private final Boolean isOpen;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    public OpenPushReminderSceneInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ OpenPushReminderSceneInfo copy$default(OpenPushReminderSceneInfo r100, String r101, Boolean r102, Integer r103, String r104, String r105, BubbleInfo r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.sceneId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.isOpen;
    L8:
        Boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.eventTimes;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.subTitle;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.bubbleInfo;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.sceneId;
    }

    public final Boolean component2() {
        return this.isOpen;
    }

    public final Integer component3() {
        return this.eventTimes;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.subTitle;
    }

    public final BubbleInfo component6() {
        return this.bubbleInfo;
    }

    public final OpenPushReminderSceneInfo copy(String r100, Boolean r110, Integer r111, String r112, String r113, BubbleInfo r114) {
        return new OpenPushReminderSceneInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPushReminderSceneInfo) == true) goto L8;
        return false;
    L8:
        OpenPushReminderSceneInfo r101 = (OpenPushReminderSceneInfo) r100;
        if (Intrinsics.areEqual(this.sceneId, r101.sceneId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isOpen, r101.isOpen) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.eventTimes, r101.eventTimes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bubbleInfo, r101.bubbleInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.sceneId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isOpen;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.eventTimes;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.subTitle;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        BubbleInfo r116 = this.bubbleInfo;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "OpenPushReminderSceneInfo(sceneId=" + this.sceneId + ", isOpen=" + this.isOpen + ", eventTimes=" + this.eventTimes + ", title=" + this.title + ", subTitle=" + this.subTitle + ", bubbleInfo=" + this.bubbleInfo + ')';
    }

    public final BubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    public final Integer getEventTimes() {
        return this.eventTimes;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isOpen() {
        return this.isOpen;
    }

    public OpenPushReminderSceneInfo(String r100, Boolean r101, Integer r102, String r103, String r104, BubbleInfo r105) {
        this.sceneId = r100;
        this.isOpen = r101;
        this.eventTimes = r102;
        this.title = r103;
        this.subTitle = r104;
        this.bubbleInfo = r105;
    }

    public /* synthetic */ OpenPushReminderSceneInfo(String r100, Boolean r101, Integer r102, String r103, String r110, BubbleInfo r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        Boolean r104 = r101;
        if ((r112 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        Integer r105 = r102;
        if ((r112 & 8) == 0) goto L15;
        String r106 = null;
    L17:
        if ((r112 & 16) == 0) goto L19;
        String r107 = null;
    L21:
        if ((r112 & 32) == 0) goto L23;
        BubbleInfo r115 = null;
    L24:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L23:
        r115 = r111;
        goto L24
    L19:
        r107 = r110;
        goto L21
    L15:
        r106 = r103;
        goto L17
    L5:
        r114 = r100;
        goto L7
    }
}
