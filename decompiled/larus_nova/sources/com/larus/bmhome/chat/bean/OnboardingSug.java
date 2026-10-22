package com.larus.bmhome.chat.bean;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.video.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/bean/OnboardingSug;", "", "itemId", "", "itemType", "", ReportConstant.COMMON_ACTION_TYPE, "displayType", "richMediaDisplayContent", "Lcom/larus/bmhome/video/Content;", "<init>", "(JIIILcom/larus/bmhome/video/Content;)V", "getItemId", "()J", "setItemId", "(J)V", "getItemType", "()I", "setItemType", "(I)V", "getActionType", "setActionType", "getDisplayType", "setDisplayType", "getRichMediaDisplayContent", "()Lcom/larus/bmhome/video/Content;", "setRichMediaDisplayContent", "(Lcom/larus/bmhome/video/Content;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnboardingSug {

    @SerializedName("action_type")
    private int actionType;

    @SerializedName("display_type")
    private int displayType;

    @SerializedName("item_id")
    private long itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private int itemType;

    @SerializedName("rich_media_display_content")
    private Content richMediaDisplayContent;

    public OnboardingSug() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final Content getRichMediaDisplayContent() {
        return this.richMediaDisplayContent;
    }

    public final void setActionType(int r100) {
        this.actionType = r100;
    }

    public final void setDisplayType(int r100) {
        this.displayType = r100;
    }

    public final void setItemId(long r100) {
        this.itemId = r100;
    }

    public final void setItemType(int r100) {
        this.itemType = r100;
    }

    public final void setRichMediaDisplayContent(Content r100) {
        this.richMediaDisplayContent = r100;
    }

    public OnboardingSug(long r100, int r101, int r102, int r103, Content r104) {
        this.itemId = r100;
        this.itemType = r101;
        this.actionType = r102;
        this.displayType = r103;
        this.richMediaDisplayContent = r104;
    }

    public /* synthetic */ OnboardingSug(long r100, int r110, int r111, int r112, Content r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r101 = r100;
        if ((r114 & 2) == 0) goto L8;
        int r102 = 0;
    L10:
        if ((r114 & 4) == 0) goto L12;
        int r103 = 0;
    L14:
        if ((r114 & 8) == 0) goto L16;
        int r104 = 0;
    L18:
        if ((r114 & 16) == 0) goto L20;
        r113 = null;
    L20:
        this(r101, r102, r103, r104, r113);
        return;
    L16:
        r104 = r112;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L8:
        r102 = r110;
        goto L10
    }
}
