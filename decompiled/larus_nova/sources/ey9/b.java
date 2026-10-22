package ey9;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.uaigc.avatar.api.UserGender;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J|\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018¨\u00061"}, d2 = {"Lcom/larus/uaigc/avatar/api/CreateDigitalAvatarRequest;", "", "gender", "", "preGenImages", "", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "conversationId", "", EventConstant.Key.RETAIN_PROMPT, "masterIdx", "refMsgId", "replicaRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "fromCreation", "", "enterMethod", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;Ljava/lang/Boolean;Ljava/lang/String;)V", "getGender", "()I", "getPreGenImages", "()Ljava/util/List;", "getConversationId", "()Ljava/lang/String;", "getPrompt", "getMasterIdx", "getRefMsgId", "getReplicaRefVideo", "()Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "getFromCreation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnterMethod", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/uaigc/avatar/api/CreateDigitalAvatarRequest;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("from_creation")
    private final Boolean fromCreation;

    @SerializedName("gender")
    private final int gender;

    @SerializedName("master_idx")
    private final int masterIdx;

    @SerializedName("pre_gen_images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<k> preGenImages;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private final String prompt;

    @SerializedName("ref_msg_id")
    private final String refMsgId;

    @SerializedName("replica_ref_video")
    private final a replicaRefVideo;

    public b() {
        this(0, null, null, null, -1, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.gender == r101.gender) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preGenImages, r101.preGenImages) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L21;
        return false;
    L21:
        if (this.masterIdx == r101.masterIdx) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.refMsgId, r101.refMsgId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.replicaRefVideo, r101.replicaRefVideo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fromCreation, r101.fromCreation) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.gender * 31;
        List<k> r101 = this.preGenImages;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.conversationId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.prompt;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.masterIdx) * 31;
        String r111 = this.refMsgId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        a r114 = this.replicaRefVideo;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.fromCreation;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.enterMethod;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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

    public final String toString() {
        return "CreateDigitalAvatarRequest(gender=" + this.gender + ", preGenImages=" + this.preGenImages + ", conversationId=" + this.conversationId + ", prompt=" + this.prompt + ", masterIdx=" + this.masterIdx + ", refMsgId=" + this.refMsgId + ", replicaRefVideo=" + this.replicaRefVideo + ", fromCreation=" + this.fromCreation + ", enterMethod=" + this.enterMethod + ')';
    }

    public b(@UserGender int r100, List<k> r101, String r102, String r103, int r104, String r105, a r106, Boolean r107, String r108) {
        this.gender = r100;
        this.preGenImages = r101;
        this.conversationId = r102;
        this.prompt = r103;
        this.masterIdx = r104;
        this.refMsgId = r105;
        this.replicaRefVideo = r106;
        this.fromCreation = r107;
        this.enterMethod = r108;
    }
}
