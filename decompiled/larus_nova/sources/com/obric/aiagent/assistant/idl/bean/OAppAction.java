package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.obric.capabilitykit.common.TimeTransformAdapter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002./BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u00020\tH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0006\u0010#\u001a\u00020\u0003J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u00060"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OAppAction;", "Landroid/os/Parcelable;", "appType", "", "messageId", "", "questionId", "createTime", "content", "", "messageType", "timeoutMs", "<init>", "(IJJJLjava/lang/String;II)V", "getAppType", "()I", "getMessageId", "()J", "getQuestionId", "getCreateTime", "getContent", "()Ljava/lang/String;", "getMessageType", "getTimeoutMs", "getMpParams", "Lcom/obric/aiagent/assistant/idl/bean/OAppAction$OMpParams;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "OMpParams", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OAppAction implements Parcelable {
    public static final Parcelable.Creator<OAppAction> CREATOR = null;
    public static final a Companion = null;
    public static final int MESSAGE_TYPE_ACK = 2;
    public static final int MESSAGE_TYPE_MSG = 1;
    private static final Lazy<Gson> gson$delegate = null;

    @SerializedName("app_type")
    private final int appType;

    @SerializedName("content")
    private final String content;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private final long createTime;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final long messageId;

    @SerializedName("message_type")
    private final int messageType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID)
    private final long questionId;

    @SerializedName(LocationMonitorConst.TIMEOUT_MS)
    private final int timeoutMs;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b implements Parcelable.Creator<OAppAction> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final OAppAction createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new OAppAction(r110.readInt(), r110.readLong(), r110.readLong(), r110.readLong(), r110.readString(), r110.readInt(), r110.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final OAppAction[] newArray(int r100) {
            return new OAppAction[r100];
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OAppAction$OMpParams;", "", "id", "", "questionId", "actionParameters", "", "actionResultData", "ext", "", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getId", "()J", "getQuestionId", "getActionParameters", "()Ljava/lang/String;", "getActionResultData", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName("action_parameters")
        private final String actionParameters;

        @SerializedName("action_result_data")
        private final String actionResultData;

        @SerializedName("ext")
        private final Map<String, String> ext;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final long f384506id;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID)
        private final long questionId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f384506id == r101.f384506id) goto L12;
            return false;
        L12:
            if (this.questionId == r101.questionId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.actionParameters, r101.actionParameters) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.actionResultData, r101.actionResultData) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f384506id;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.questionId;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            String r104 = this.actionParameters;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            String r108 = this.actionResultData;
            if (r108 != null) goto L9;
            int r109 = 0;
        L10:
            int r110 = (r107 + r109) * 31;
            Map<String, String> r111 = this.ext;
            if (r111 == null) goto L15;
            r105 = r111.hashCode();
        L15:
            return r110 + r105;
        L9:
            r109 = r108.hashCode();
            goto L10
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public final String toString() {
            return "OMpParams(id=" + this.f384506id + ", questionId=" + this.questionId + ", actionParameters=" + this.actionParameters + ", actionResultData=" + this.actionResultData + ", ext=" + this.ext + ')';
        }

        public c() {
            this.f384506id = -1;
            this.questionId = -1;
            this.actionParameters = "";
            this.actionResultData = "";
            this.ext = null;
        }
    }

    public OAppAction() {
        this(0, 0, 0, 0, null, 0, 0, 127, null);
    }

    public static /* synthetic */ Gson a() {
        return gson_delegate$lambda$0();
    }

    public static /* synthetic */ OAppAction copy$default(OAppAction r110, int r111, long r112, long r113, long r114, String r115, int r210, int r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.appType;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = r110.messageId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.questionId;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r103 = r110.createTime;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.content;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int r105 = r110.messageType;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r116 = r110.timeoutMs;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116);
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.appType;
    }

    public final long component2() {
        return this.messageId;
    }

    public final long component3() {
        return this.questionId;
    }

    public final long component4() {
        return this.createTime;
    }

    public final String component5() {
        return this.content;
    }

    public final int component6() {
        return this.messageType;
    }

    public final int component7() {
        return this.timeoutMs;
    }

    public final OAppAction copy(int r110, long r111, long r112, long r113, String r210, int r211, int r212) {
        return new OAppAction(r110, r111, r112, r113, r210, r211, r212);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OAppAction) == true) goto L8;
        return false;
    L8:
        OAppAction r101 = (OAppAction) r100;
        if (this.appType == r101.appType) goto L12;
        return false;
    L12:
        if (this.messageId == r101.messageId) goto L15;
        return false;
    L15:
        if (this.questionId == r101.questionId) goto L18;
        return false;
    L18:
        if (this.createTime == r101.createTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
        return false;
    L24:
        if (this.messageType == r101.messageType) goto L27;
        return false;
    L27:
        if (this.timeoutMs == r101.timeoutMs) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.appType * 31;
        long r101 = this.messageId;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.questionId;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.createTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.content;
        if (r107 != null) goto L5;
        int r108 = 0;
    L7:
        return ((((r106 + r108) * 31) + this.messageType) * 31) + this.timeoutMs;
    L5:
        r108 = r107.hashCode();
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.appType);
        r100.writeLong(this.messageId);
        r100.writeLong(this.questionId);
        r100.writeLong(this.createTime);
        r100.writeString(this.content);
        r100.writeInt(this.messageType);
        r100.writeInt(this.timeoutMs);
    }

    static {
        Companion = new a();
        CREATOR = new b();
        gson$delegate = LazyKt.lazy(new m9a.a());
    }

    private static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    public final c getMpParams() {
        String r100 = this.content;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        Companion.getClass();
        return (c) GsonProtectorUtils.fromJson((Gson) access$getGson$delegate$cp().getValue(), this.content, c.class);
    L11:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public String toString() {
        return "[appType=" + this.appType + ". messageId=" + this.messageId + ", questionId=" + this.questionId + ". createTime=" + this.createTime + "messageType=" + this.messageType + ", timeoutMs=" + this.timeoutMs + ". content=" + this.content + ". ]";
    }

    public static final /* synthetic */ Lazy access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public final int getAppType() {
        return this.appType;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final int getTimeoutMs() {
        return this.timeoutMs;
    }

    public OAppAction(int r100, long r101, long r102, long r103, String r104, int r105, int r110) {
        this.appType = r100;
        this.messageId = r101;
        this.questionId = r102;
        this.createTime = r103;
        this.content = r104;
        this.messageType = r105;
        this.timeoutMs = r110;
    }

    public /* synthetic */ OAppAction(int r110, long r111, long r112, long r113, String r114, int r115, int r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        int r100 = -1;
    L6:
        long r101 = -1;
        if ((r211 & 2) == 0) goto L9;
        long r102 = -1;
    L11:
        if ((r211 & 4) != 0) goto L15;
        r101 = r112;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r103 = System.currentTimeMillis();
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r211 & 32) == 0) goto L25;
        int r105 = 1;
    L27:
        if ((r211 & 64) == 0) goto L29;
        int r106 = 0;
    L30:
        this(r100, r102, r101, r103, r104, r105, r106);
        return;
    L29:
        r106 = r210;
        goto L30
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
