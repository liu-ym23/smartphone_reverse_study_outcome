package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001=Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÂ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJn\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0006J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0006HÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0010\u0010\t\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006>"}, d2 = {"Lcom/larus/bmhome/auth/ActionBarConfig;", "Landroid/os/Parcelable;", "enable", "", "enableRefresh", "msgReqCount", "", "msgUpdateLimit", "msgCount", "realReplaceMode", "clickActionBarTemporaryChatStyle", "clickActionBarShouldAutoSendMessage", "actionBarShouldShowCallBotButton", "<init>", "(ZZIIIILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnable", "()Z", "getEnableRefresh", "getMsgReqCount", "()I", "getMsgUpdateLimit", "getMsgCount", "getClickActionBarTemporaryChatStyle", "()Ljava/lang/Integer;", "setClickActionBarTemporaryChatStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickActionBarShouldAutoSendMessage", "()Ljava/lang/Boolean;", "setClickActionBarShouldAutoSendMessage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getActionBarShouldShowCallBotButton", "setActionBarShouldShowCallBotButton", "replaceMode", "Lcom/larus/bmhome/auth/ActionBarConfig$ActionBarReplaceMode;", "getReplaceMode", "()Lcom/larus/bmhome/auth/ActionBarConfig$ActionBarReplaceMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZIIIILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/auth/ActionBarConfig;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ActionBarReplaceMode", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarConfig implements Parcelable {
    public static final Parcelable.Creator<ActionBarConfig> CREATOR = null;

    @SerializedName("action_bar_should_show_call_bot_button")
    private Boolean actionBarShouldShowCallBotButton;

    @SerializedName("click_action_bar_should_auto_send_message")
    private Boolean clickActionBarShouldAutoSendMessage;

    @SerializedName("click_action_bar_temporary_chat_style")
    private Integer clickActionBarTemporaryChatStyle;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_refresh")
    private final boolean enableRefresh;

    @SerializedName("refresh_msg_req_count")
    private final int msgCount;

    @SerializedName("msg_req_count")
    private final int msgReqCount;

    @SerializedName("refresh_msg_rate_limit")
    private final int msgUpdateLimit;

    @SerializedName("refresh_replace_mode")
    private final int realReplaceMode;

    /* JADX INFO: loaded from: classes25.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/auth/ActionBarConfig$ActionBarReplaceMode;", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "<init>", "(Ljava/lang/String;II)V", "getModel", "()I", "UNKNOWN", "REPLACE_ALL", "INSERT_AHEAD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionBarReplaceMode extends Enum<ActionBarReplaceMode> {
        public static final ActionBarReplaceMode INSERT_AHEAD = null;
        public static final ActionBarReplaceMode REPLACE_ALL = null;
        public static final ActionBarReplaceMode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionBarReplaceMode[] f295682a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f295683b = null;
        private final int model;

        public static EnumEntries<ActionBarReplaceMode> getEntries() {
            return f295683b;
        }

        static {
            ActionBarReplaceMode r100 = new ActionBarReplaceMode("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            ActionBarReplaceMode r101 = new ActionBarReplaceMode("REPLACE_ALL", 1, 1);
            REPLACE_ALL = r101;
            ActionBarReplaceMode r102 = new ActionBarReplaceMode("INSERT_AHEAD", 2, 2);
            INSERT_AHEAD = r102;
            ActionBarReplaceMode[] r103 = {r100, r101, r102};
            f295682a = r103;
            f295683b = EnumEntriesKt.enumEntries(r103);
        }

        public static ActionBarReplaceMode[] values() {
            return (ActionBarReplaceMode[]) f295682a.clone();
        }

        public final int getModel() {
            return this.model;
        }

        public static ActionBarReplaceMode valueOf(String r100) {
            return (ActionBarReplaceMode) r27.a.a(ActionBarReplaceMode.class, r100);
        }

        public ActionBarReplaceMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.model = r102;
        }
    }

    public static final class a implements Parcelable.Creator<ActionBarConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ActionBarConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            boolean r100 = false;
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r102 = true;
        L10:
            int r103 = r110.readInt();
            int r104 = r110.readInt();
            int r105 = r110.readInt();
            int r106 = r110.readInt();
            Boolean r111 = null;
            if (r110.readInt() != 0) goto L13;
            Integer r112 = null;
        L15:
            if (r110.readInt() != 0) goto L18;
            Boolean r113 = null;
        L23:
            if (r110.readInt() == 0) goto L30;
            if (r110.readInt() == 0) goto L28;
            r100 = true;
        L28:
            r111 = Boolean.valueOf(r100);
        L30:
            return new ActionBarConfig(r101, r102, r103, r104, r105, r106, r112, r113, r111);
        L18:
            if (r110.readInt() == 0) goto L20;
            boolean r107 = true;
        L21:
            r113 = Boolean.valueOf(r107);
            goto L23
        L20:
            r107 = false;
            goto L21
        L13:
            r112 = Integer.valueOf(r110.readInt());
            goto L15
        L9:
            r102 = false;
            goto L10
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ActionBarConfig[] newArray(int r100) {
            return new ActionBarConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ActionBarConfig() {
        Boolean r100 = Boolean.FALSE;
        this(false, false, 6, 3, 5, 1, 0, r100, r100);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActionBarConfig) == true) goto L8;
        return false;
    L8:
        ActionBarConfig r101 = (ActionBarConfig) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.enableRefresh == r101.enableRefresh) goto L15;
        return false;
    L15:
        if (this.msgReqCount == r101.msgReqCount) goto L18;
        return false;
    L18:
        if (this.msgUpdateLimit == r101.msgUpdateLimit) goto L21;
        return false;
    L21:
        if (this.msgCount == r101.msgCount) goto L24;
        return false;
    L24:
        if (this.realReplaceMode == r101.realReplaceMode) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.clickActionBarTemporaryChatStyle, r101.clickActionBarTemporaryChatStyle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.clickActionBarShouldAutoSendMessage, r101.clickActionBarShouldAutoSendMessage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.actionBarShouldShowCallBotButton, r101.actionBarShouldShowCallBotButton) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableRefresh == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((((((((r102 + r100) * 31) + this.msgReqCount) * 31) + this.msgUpdateLimit) * 31) + this.msgCount) * 31) + this.realReplaceMode) * 31;
        Integer r104 = this.clickActionBarTemporaryChatStyle;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        Boolean r108 = this.clickActionBarShouldAutoSendMessage;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.actionBarShouldShowCallBotButton;
        if (r111 == null) goto L23;
        r105 = r111.hashCode();
    L23:
        return r110 + r105;
    L17:
        r109 = r108.hashCode();
        goto L18
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ActionBarConfig(enable=" + this.enable + ", enableRefresh=" + this.enableRefresh + ", msgReqCount=" + this.msgReqCount + ", msgUpdateLimit=" + this.msgUpdateLimit + ", msgCount=" + this.msgCount + ", realReplaceMode=" + this.realReplaceMode + ", clickActionBarTemporaryChatStyle=" + this.clickActionBarTemporaryChatStyle + ", clickActionBarShouldAutoSendMessage=" + this.clickActionBarShouldAutoSendMessage + ", actionBarShouldShowCallBotButton=" + this.actionBarShouldShowCallBotButton + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.enable ? 1 : 0);
        r100.writeInt(this.enableRefresh ? 1 : 0);
        r100.writeInt(this.msgReqCount);
        r100.writeInt(this.msgUpdateLimit);
        r100.writeInt(this.msgCount);
        r100.writeInt(this.realReplaceMode);
        Integer r102 = this.clickActionBarTemporaryChatStyle;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.clickActionBarShouldAutoSendMessage;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Boolean r104 = this.actionBarShouldShowCallBotButton;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public ActionBarConfig(boolean r100, boolean r101, int r102, int r103, int r104, int r105, Integer r106, Boolean r107, Boolean r108) {
        this.enable = r100;
        this.enableRefresh = r101;
        this.msgReqCount = r102;
        this.msgUpdateLimit = r103;
        this.msgCount = r104;
        this.realReplaceMode = r105;
        this.clickActionBarTemporaryChatStyle = r106;
        this.clickActionBarShouldAutoSendMessage = r107;
        this.actionBarShouldShowCallBotButton = r108;
    }
}
