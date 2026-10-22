package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "old link data")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"J\t\u00102\u001a\u00020\u000eHÆ\u0003J`\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020\u000eJ\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u000eHÖ\u0001J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000eR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b\u000b\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006A"}, d2 = {"Lcom/larus/bmhome/chat/resp/Templates;", "Landroid/os/Parcelable;", "Lcom/larus/im/bean/conversation/ActionbarBaseData;", "id", "", "botId", "templateName", "", "botStats", "Lcom/larus/bmhome/chat/resp/BotStatus;", "requestId", "isForcedSort", "", "forcedSortIndex", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Ljava/lang/Boolean;I)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBotId", "setBotId", "getTemplateName", "()Ljava/lang/String;", "setTemplateName", "(Ljava/lang/String;)V", "getBotStats", "()Lcom/larus/bmhome/chat/resp/BotStatus;", "setBotStats", "(Lcom/larus/bmhome/chat/resp/BotStatus;)V", "getRequestId", "setRequestId", "()Ljava/lang/Boolean;", "setForcedSort", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getForcedSortIndex", "()I", "setForcedSortIndex", "(I)V", "uniqueIdInType", "getContentFlag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Ljava/lang/Boolean;I)Lcom/larus/bmhome/chat/resp/Templates;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Templates implements Parcelable {
    public static final Parcelable.Creator<Templates> CREATOR = null;

    @SerializedName("bot_id")
    private Long botId;

    @SerializedName("bot_stats")
    private BotStatus botStats;

    @SerializedName("forced_sort_index")
    private int forcedSortIndex;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private Long f308560id;

    @SerializedName("forced_sort")
    private Boolean isForcedSort;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName("msg_template_name")
    private String templateName;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<Templates> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final Templates createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() != 0) goto L5;
            Long r100 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Long r101 = null;
        L10:
            String r102 = r110.readString();
            if (r110.readInt() != 0) goto L13;
            BotStatus r103 = null;
        L14:
            BotStatus r104 = r103;
            String r105 = r110.readString();
            if (r110.readInt() != 0) goto L18;
            Boolean r106 = null;
        L23:
            return new Templates(r100, r101, r102, r104, r105, r106, r110.readInt());
        L18:
            if (r110.readInt() == 0) goto L20;
            boolean r107 = true;
        L21:
            r106 = Boolean.valueOf(r107);
            goto L23
        L20:
            r107 = false;
            goto L21
        L13:
            r103 = BotStatus.CREATOR.createFromParcel(r110);
            goto L14
        L9:
            r101 = Long.valueOf(r110.readLong());
            goto L10
        L5:
            r100 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Templates[] newArray(int r100) {
            return new Templates[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Templates) == true) goto L8;
        return false;
    L8:
        Templates r101 = (Templates) r100;
        if (Intrinsics.areEqual(this.f308560id, r101.f308560id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateName, r101.templateName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botStats, r101.botStats) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isForcedSort, r101.isForcedSort) == true) goto L27;
        return false;
    L27:
        if (this.forcedSortIndex == r101.forcedSortIndex) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f308560id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.botId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.templateName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        BotStatus r110 = this.botStats;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.requestId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isForcedSort;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return ((r115 + r101) * 31) + this.forcedSortIndex;
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
        return "Templates(id=" + this.f308560id + ", botId=" + this.botId + ", templateName=" + this.templateName + ", botStats=" + this.botStats + ", requestId=" + this.requestId + ", isForcedSort=" + this.isForcedSort + ", forcedSortIndex=" + this.forcedSortIndex + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.f308560id;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.botId;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.templateName);
        BotStatus r104 = this.botStats;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeString(this.requestId);
        Boolean r105 = this.isForcedSort;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        r100.writeInt(this.forcedSortIndex);
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        goto L18
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public Templates() {
        this(0L, 0L, "", null, null, Boolean.FALSE, 0);
    }

    public Templates(Long r100, Long r101, String r102, BotStatus r103, String r104, Boolean r105, int r106) {
        this.f308560id = r100;
        this.botId = r101;
        this.templateName = r102;
        this.botStats = r103;
        this.requestId = r104;
        this.isForcedSort = r105;
        this.forcedSortIndex = r106;
    }
}
