package com.larus.bmhome.chat.block.base.renderer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BÃ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0019\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0010HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010,J\t\u0010=\u001a\u00020\fHÆ\u0003JÊ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010?J\u0006\u0010@\u001a\u00020\u0004J\u0013\u0010A\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0004HÖ\u0001J\t\u0010E\u001a\u00020\u0006HÖ\u0001J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#¨\u0006K"}, d2 = {"Lcom/larus/bmhome/chat/block/base/renderer/FileCardVMData;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardVMData;", "Landroid/os/Parcelable;", "iconRes", "", "darkIcon", "", "lightIcon", "fileName", "url", "type", "showType", "", "rootBackgroundRes", "messageId", "messageExt", "", "conversationId", "botId", "showPlayAudioButton", "fileSizeBytes", "", "showFileActions", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Z)V", "getIconRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDarkIcon", "()Ljava/lang/String;", "getLightIcon", "getFileName", "getUrl", "getType", "getShowType", "()Z", "getRootBackgroundRes", "getMessageId", "getMessageExt", "()Ljava/util/Map;", "getConversationId", "getBotId", "getShowPlayAudioButton", "getFileSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowFileActions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Z)Lcom/larus/bmhome/chat/block/base/renderer/FileCardVMData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileCardVMData implements Parcelable {
    public static final Parcelable.Creator<FileCardVMData> CREATOR = null;

    @SerializedName("botId")
    private final String botId;

    @SerializedName("conversationId")
    private final String conversationId;

    @SerializedName("darkIcon")
    private final String darkIcon;

    @SerializedName("fileName")
    private final String fileName;

    @SerializedName("fileSizeBytes")
    private final Long fileSizeBytes;

    @SerializedName("iconRes")
    private final Integer iconRes;

    @SerializedName("lightIcon")
    private final String lightIcon;

    @SerializedName("messageExt")
    private final Map<String, String> messageExt;

    @SerializedName("messageId")
    private final String messageId;

    @SerializedName("rootBackgroundRes")
    private final Integer rootBackgroundRes;

    @SerializedName("showFileActions")
    private final boolean showFileActions;

    @SerializedName("showPlayAudioButton")
    private final boolean showPlayAudioButton;

    @SerializedName("showType")
    private final boolean showType;

    @SerializedName("type")
    private final String type;

    @SerializedName("url")
    private final String url;

    public static final class a implements Parcelable.Creator<FileCardVMData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FileCardVMData createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            if (r210.readInt() != 0) goto L5;
            Integer r100 = null;
        L6:
            String r101 = r210.readString();
            String r102 = r210.readString();
            String r103 = r210.readString();
            String r104 = r210.readString();
            String r105 = r210.readString();
            if (r210.readInt() == 0) goto L9;
            boolean r106 = true;
        L11:
            if (r210.readInt() != 0) goto L13;
            Integer r110 = null;
        L14:
            String r111 = r210.readString();
            if (r210.readInt() != 0) goto L17;
            LinkedHashMap r112 = null;
        L21:
            String r113 = r210.readString();
            String r114 = r210.readString();
            if (r210.readInt() == 0) goto L24;
            boolean r107 = true;
        L26:
            if (r210.readInt() != 0) goto L28;
            Long r115 = null;
        L30:
            if (r210.readInt() == 0) goto L32;
            boolean r108 = true;
        L34:
            return new FileCardVMData(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r115, r108);
        L32:
            r108 = false;
            goto L34
        L28:
            r115 = Long.valueOf(r210.readLong());
            goto L30
        L24:
            r107 = false;
            goto L26
        L17:
            int r116 = r210.readInt();
            LinkedHashMap r117 = new LinkedHashMap(r116);
            int r118 = 0;
        L18:
            if (r118 == r116) goto L20;
            r117.put(r210.readString(), r210.readString());
            r118 = r118 + 1;
            goto L18
        L20:
            r112 = r117;
            goto L21
        L13:
            r110 = Integer.valueOf(r210.readInt());
            goto L14
        L9:
            r106 = false;
            goto L11
        L5:
            r100 = Integer.valueOf(r210.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FileCardVMData[] newArray(int r100) {
            return new FileCardVMData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FileCardVMData() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, false, 32767);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileCardVMData) == true) goto L8;
        return false;
    L8:
        FileCardVMData r101 = (FileCardVMData) r100;
        if (Intrinsics.areEqual(this.iconRes, r101.iconRes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.darkIcon, r101.darkIcon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lightIcon, r101.lightIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L27;
        return false;
    L27:
        if (this.showType == r101.showType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.rootBackgroundRes, r101.rootBackgroundRes) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.messageExt, r101.messageExt) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L45;
        return false;
    L45:
        if (this.showPlayAudioButton == r101.showPlayAudioButton) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.fileSizeBytes, r101.fileSizeBytes) == true) goto L51;
        return false;
    L51:
        if (this.showFileActions == r101.showFileActions) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.iconRes;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.darkIcon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lightIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.fileName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.url;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.type;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        int r119 = 1231;
        if (this.showType == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.rootBackgroundRes;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.messageId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.messageExt;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.conversationId;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.botId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        if (this.showPlayAudioButton == false) goto L53;
        int r137 = 1231;
    L54:
        int r138 = (r136 + r137) * 31;
        Long r139 = this.fileSizeBytes;
        if (r139 == null) goto L58;
        r101 = r139.hashCode();
    L58:
        int r140 = (r138 + r101) * 31;
        if (this.showFileActions == true) goto L63;
        r119 = 1237;
    L63:
        return r140 + r119;
    L53:
        r137 = 1237;
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = 1237;
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public final String toString() {
        return "FileCardVMData(iconRes=" + this.iconRes + ", darkIcon=" + this.darkIcon + ", lightIcon=" + this.lightIcon + ", fileName=" + this.fileName + ", url=" + this.url + ", type=" + this.type + ", showType=" + this.showType + ", rootBackgroundRes=" + this.rootBackgroundRes + ", messageId=" + this.messageId + ", messageExt=" + this.messageExt + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ", showPlayAudioButton=" + this.showPlayAudioButton + ", fileSizeBytes=" + this.fileSizeBytes + ", showFileActions=" + this.showFileActions + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.iconRes;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.darkIcon);
        r100.writeString(this.lightIcon);
        r100.writeString(this.fileName);
        r100.writeString(this.url);
        r100.writeString(this.type);
        r100.writeInt(this.showType ? 1 : 0);
        Integer r103 = this.rootBackgroundRes;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.messageId);
        Map<String, String> r104 = this.messageExt;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L17:
        r100.writeString(this.conversationId);
        r100.writeString(this.botId);
        r100.writeInt(this.showPlayAudioButton ? 1 : 0);
        Long r105 = this.fileSizeBytes;
        if (r105 != null) goto L20;
        r100.writeInt(0);
    L21:
        r100.writeInt(this.showFileActions ? 1 : 0);
        return;
    L20:
        r100.writeInt(1);
        r100.writeLong(r105.longValue());
        goto L21
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<Map.Entry<String, String>> r106 = r104.entrySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        Map.Entry<String, String> r107 = r106.next();
        r100.writeString(r107.getKey());
        r100.writeString(r107.getValue());
        goto L15
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final String b() {
        return this.botId;
    }

    public final String c() {
        return this.conversationId;
    }

    public final String d() {
        return this.darkIcon;
    }

    public final String e() {
        return this.fileName;
    }

    public final Long g() {
        return this.fileSizeBytes;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer h() {
        return this.iconRes;
    }

    public final String i() {
        return this.lightIcon;
    }

    public final Map<String, String> j() {
        return this.messageExt;
    }

    public final String k() {
        return this.messageId;
    }

    public final Integer o() {
        return this.rootBackgroundRes;
    }

    public final boolean q() {
        return this.showFileActions;
    }

    public final boolean r() {
        return this.showPlayAudioButton;
    }

    public final boolean s() {
        return this.showType;
    }

    public final String t() {
        return this.url;
    }

    public static FileCardVMData a(FileCardVMData r110, Integer r111, String r112, Map r210, String r211, String r212) {
        return new FileCardVMData(r110.iconRes, r110.darkIcon, r110.lightIcon, r110.fileName, r110.url, r110.type, r110.showType, r111, r112, r210, r211, r212, r110.showPlayAudioButton, r110.fileSizeBytes, r110.showFileActions);
    }

    public /* synthetic */ FileCardVMData(Integer r210, String r211, String r212, String r213, String r214, String r215, Integer r216, String r217, Map r218, String r219, String r310, boolean r311, Long r312, boolean r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r314 & 128) == 0) goto L29;
        Integer r110 = null;
    L31:
        if ((r314 & 256) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r314 & 512) == 0) goto L37;
        Map r112 = null;
    L39:
        if ((r314 & 1024) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r314 & 2048) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r314 & 4096) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r314 & 8192) == 0) goto L53;
        Long r116 = null;
    L55:
        if ((r314 & 16384) == 0) goto L57;
        boolean r117 = false;
    L58:
        this(r100, r101, r102, r103, r104, r105, false, r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L57:
        r117 = r313;
        goto L58
    L53:
        r116 = r312;
        goto L55
    L49:
        r115 = r311;
        goto L51
    L45:
        r114 = r310;
        goto L47
    L41:
        r113 = r219;
        goto L43
    L37:
        r112 = r218;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public FileCardVMData(Integer r100, String r101, String r102, String r103, String r104, String r105, boolean r106, Integer r107, String r108, Map<String, String> r110, String r111, String r112, boolean r113, Long r114, boolean r115) {
        this.iconRes = r100;
        this.darkIcon = r101;
        this.lightIcon = r102;
        this.fileName = r103;
        this.url = r104;
        this.type = r105;
        this.showType = r106;
        this.rootBackgroundRes = r107;
        this.messageId = r108;
        this.messageExt = r110;
        this.conversationId = r111;
        this.botId = r112;
        this.showPlayAudioButton = r113;
        this.fileSizeBytes = r114;
        this.showFileActions = r115;
    }
}
