package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xt7.d;
import zp9.v;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u00ad\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u00105\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\u000fJ\u0006\u00107\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010E\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010F\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J´\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u00020\u0006J\u0013\u0010J\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\u0006HÖ\u0001J\t\u0010N\u001a\u00020\u0004HÖ\u0001J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R#\u0010-\u001a\u0004\u0018\u00010.8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b3\u00104\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u0006T"}, d2 = {"Lcom/larus/platform/api/creation/PublisherCreation;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "creationId", "", "creationType", "", "fromIMCreationType", "messageId", EventConstant.Key.RETAIN_PROMPT, "imageUrl", "refContent", "index", DBDefinition.TASK_ID, "ignoreCheckInfoEnough", "", "materialId", "canvasId", "", "canvasSubId", "canvasMode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getCreationId", "()Ljava/lang/String;", "getCreationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFromIMCreationType", "getMessageId", "getPrompt", "getImageUrl", "getRefContent", "getIndex", "getTaskId", "getIgnoreCheckInfoEnough", "()Z", "getMaterialId", "getCanvasId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCanvasSubId", "getCanvasMode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "refContentBean", "Lcom/larus/platform/api/creation/UserCreationRefContent;", "getRefContentBean$annotations", "()V", "getRefContentBean", "()Lcom/larus/platform/api/creation/UserCreationRefContent;", "refContentBean$delegate", "Lkotlin/Lazy;", "isValid", "isVideo", "hasRefResource", "isInfoNotEnough", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/platform/api/creation/PublisherCreation;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PublisherCreation implements Parcelable, Serializable {
    public static final Parcelable.Creator<PublisherCreation> CREATOR = null;

    @SerializedName("canvas_id")
    private final Long canvasId;

    @SerializedName("canvas_mode")
    private final Boolean canvasMode;

    @SerializedName("canvas_sub_id")
    private final Long canvasSubId;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("creation_type")
    private final Integer creationType;

    @SerializedName("form_im_creation_type")
    private final Integer fromIMCreationType;

    @SerializedName("ignore_check_info_enough")
    private final boolean ignoreCheckInfoEnough;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("index")
    private final Integer index;

    @SerializedName("material_id")
    private final String materialId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private final String prompt;

    @SerializedName("ref_content")
    private final String refContent;
    private final Lazy refContentBean$delegate;

    @SerializedName("task_id")
    private final String taskId;

    public static final class a implements Parcelable.Creator<PublisherCreation> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PublisherCreation createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r100 = r210.readString();
            if (r210.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            if (r210.readInt() != 0) goto L9;
            Integer r102 = null;
        L10:
            String r103 = r210.readString();
            String r104 = r210.readString();
            String r105 = r210.readString();
            String r106 = r210.readString();
            if (r210.readInt() != 0) goto L13;
            Integer r110 = null;
        L14:
            String r111 = r210.readString();
            boolean r112 = false;
            if (r210.readInt() == 0) goto L17;
            boolean r113 = true;
        L18:
            String r114 = r210.readString();
            if (r210.readInt() != 0) goto L21;
            Long r115 = null;
        L23:
            if (r210.readInt() != 0) goto L25;
            Long r116 = null;
        L27:
            if (r210.readInt() != 0) goto L30;
            Boolean r117 = null;
        L34:
            return new PublisherCreation(r100, r101, r102, r103, r104, r105, r106, r110, r111, r113, r114, r115, r116, r117);
        L30:
            if (r210.readInt() == 0) goto L32;
            r112 = true;
        L32:
            r117 = Boolean.valueOf(r112);
            goto L34
        L25:
            r116 = Long.valueOf(r210.readLong());
            goto L27
        L21:
            r115 = Long.valueOf(r210.readLong());
            goto L23
        L17:
            r113 = false;
            goto L18
        L13:
            r110 = Integer.valueOf(r210.readInt());
            goto L14
        L9:
            r102 = Integer.valueOf(r210.readInt());
            goto L10
        L5:
            r101 = Integer.valueOf(r210.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PublisherCreation[] newArray(int r100) {
            return new PublisherCreation[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PublisherCreation() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ PublisherCreation copy$default(PublisherCreation r110, String r111, Integer r112, Integer r113, String r114, String r210, String r211, String r212, Integer r213, String r214, boolean r215, String r216, Long r217, Long r218, Boolean r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.creationId;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Integer r101 = r110.creationType;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Integer r102 = r110.fromIMCreationType;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.messageId;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.prompt;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.imageUrl;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.refContent;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r107 = r110.index;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = r110.taskId;
    L39:
        if ((r310 & 512) == 0) goto L41;
        boolean r116 = r110.ignoreCheckInfoEnough;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.materialId;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Long r118 = r110.canvasId;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Long r119 = r110.canvasSubId;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        Boolean r108 = r110.canvasMode;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public static /* synthetic */ void getRefContentBean$annotations() {
    }

    public final String component1() {
        return this.creationId;
    }

    public final boolean component10() {
        return this.ignoreCheckInfoEnough;
    }

    public final String component11() {
        return this.materialId;
    }

    public final Long component12() {
        return this.canvasId;
    }

    public final Long component13() {
        return this.canvasSubId;
    }

    public final Boolean component14() {
        return this.canvasMode;
    }

    public final Integer component2() {
        return this.creationType;
    }

    public final Integer component3() {
        return this.fromIMCreationType;
    }

    public final String component4() {
        return this.messageId;
    }

    public final String component5() {
        return this.prompt;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.refContent;
    }

    public final Integer component8() {
        return this.index;
    }

    public final String component9() {
        return this.taskId;
    }

    public final PublisherCreation copy(String r110, @UserCreationType Integer r111, @UserCreationType Integer r112, String r210, String r211, String r212, String r213, Integer r214, String r215, boolean r216, String r217, Long r218, Long r219, Boolean r310) {
        return new PublisherCreation(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PublisherCreation) == true) goto L8;
        return false;
    L8:
        PublisherCreation r101 = (PublisherCreation) r100;
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationType, r101.creationType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fromIMCreationType, r101.fromIMCreationType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.refContent, r101.refContent) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L36;
        return false;
    L36:
        if (this.ignoreCheckInfoEnough == r101.ignoreCheckInfoEnough) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.materialId, r101.materialId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.canvasId, r101.canvasId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.canvasSubId, r101.canvasSubId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.canvasMode, r101.canvasMode) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r100 = this.creationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.creationType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.fromIMCreationType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.messageId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.prompt;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.imageUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.refContent;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.index;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.taskId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        if (this.ignoreCheckInfoEnough == false) goto L41;
        int r128 = 1231;
    L42:
        int r129 = (r127 + r128) * 31;
        String r130 = this.materialId;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        Long r133 = this.canvasId;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        Long r136 = this.canvasSubId;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        Boolean r139 = this.canvasMode;
        if (r139 == null) goto L59;
        r101 = r139.hashCode();
    L59:
        return r138 + r101;
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = 1237;
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
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

    public final boolean isValid() {
        return true;
    }

    public final boolean isVideo() {
        return CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{7, 6, 9, 8, 10, 11, 12}), this.creationType);
    }

    public String toString() {
        return "PublisherCreation(creationId=" + this.creationId + ", creationType=" + this.creationType + ", fromIMCreationType=" + this.fromIMCreationType + ", messageId=" + this.messageId + ", prompt=" + this.prompt + ", imageUrl=" + this.imageUrl + ", refContent=" + this.refContent + ", index=" + this.index + ", taskId=" + this.taskId + ", ignoreCheckInfoEnough=" + this.ignoreCheckInfoEnough + ", materialId=" + this.materialId + ", canvasId=" + this.canvasId + ", canvasSubId=" + this.canvasSubId + ", canvasMode=" + this.canvasMode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.creationId);
        Integer r102 = this.creationType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.fromIMCreationType;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.messageId);
        r100.writeString(this.prompt);
        r100.writeString(this.imageUrl);
        r100.writeString(this.refContent);
        Integer r104 = this.index;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeString(this.taskId);
        r100.writeInt(this.ignoreCheckInfoEnough ? 1 : 0);
        r100.writeString(this.materialId);
        Long r105 = this.canvasId;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        Long r106 = this.canvasSubId;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        Boolean r107 = this.canvasMode;
        if (r107 != null) goto L25;
        r100.writeInt(0);
        return;
    L25:
        r100.writeInt(1);
        r100.writeInt(r107.booleanValue() ? 1 : 0);
        return;
    L21:
        r100.writeInt(1);
        r100.writeLong(r106.longValue());
        goto L22
    L17:
        r100.writeInt(1);
        r100.writeLong(r105.longValue());
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final UserCreationRefContent getRefContentBean() {
        return (UserCreationRefContent) this.refContentBean$delegate.getValue();
    }

    public final boolean isInfoNotEnough() {
        boolean r100 = false;
        if (this.ignoreCheckInfoEnough == false) goto L5;
        return false;
    L5:
        String r101 = this.creationId;
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L25;
        String r103 = this.prompt;
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == true) goto L25;
        if (this.creationType == null) goto L25;
        boolean r105 = false;
    L26:
        if (r105 == true) goto L33;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("isInfoNotEnough: ");
        r107.append(this.creationId);
        r107.append(',');
        String r108 = this.prompt;
        if (r108 != null) goto L30;
    L31:
        r100 = true;
    L32:
        r107.append(r100);
        r107.append(',');
        r107.append(this.creationType);
        r106.i("PublisherCreation", r107.toString());
        goto L33
    L30:
        if (r108.length() != 0) goto L32;
    L33:
        return r105;
    L16:
        if (r103.length() == 0) goto L19;
        r104 = false;
    L25:
        r105 = true;
        goto L26
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public final boolean hasRefResource() {
        UserCreationRefContent r100 = getRefContentBean();
        if (r100 == null) goto L5;
        List<Resource> r101 = r100.f365037c;
    L6:
        List<Resource> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return false;
    L15:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{5, 4, 3, 7, 9, 8, 10, 11, 12}), this.creationType) == false) goto L19;
        return true;
    L19:
        return false;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final Long getCanvasId() {
        return this.canvasId;
    }

    public final Boolean getCanvasMode() {
        return this.canvasMode;
    }

    public final Long getCanvasSubId() {
        return this.canvasSubId;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final Integer getCreationType() {
        return this.creationType;
    }

    public final Integer getFromIMCreationType() {
        return this.fromIMCreationType;
    }

    public final boolean getIgnoreCheckInfoEnough() {
        return this.ignoreCheckInfoEnough;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getRefContent() {
        return this.refContent;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public static UserCreationRefContent a(PublisherCreation r100) {
        String r101 = r100.refContent;
        Object r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L22;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl((UserCreationRefContent) d.f565073b.c(UserCreationRefContent.Companion.serializer(), r101));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == true) goto L18;
        r102 = r104;
    L18:
        return (UserCreationRefContent) r102;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public PublisherCreation(String r100, @UserCreationType Integer r101, @UserCreationType Integer r102, String r103, String r104, String r105, String r106, Integer r107, String r108, boolean r110, String r111, Long r112, Long r113, Boolean r114) {
        this.creationId = r100;
        this.creationType = r101;
        this.fromIMCreationType = r102;
        this.messageId = r103;
        this.prompt = r104;
        this.imageUrl = r105;
        this.refContent = r106;
        this.index = r107;
        this.taskId = r108;
        this.ignoreCheckInfoEnough = r110;
        this.materialId = r111;
        this.canvasId = r112;
        this.canvasSubId = r113;
        this.canvasMode = r114;
        this.refContentBean$delegate = LazyKt.lazy(new v(this));
    }

    public /* synthetic */ PublisherCreation(String r110, Integer r111, Integer r112, String r113, String r210, String r211, String r212, Integer r213, String r214, boolean r215, String r216, Long r217, Long r218, Boolean r219, int r310, DefaultConstructorMarker r311) {
        Boolean r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        boolean r115 = false;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Long r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Long r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
}
