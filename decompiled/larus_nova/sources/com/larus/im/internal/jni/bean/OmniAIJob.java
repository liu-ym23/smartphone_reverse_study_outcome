package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
import com.obric.capabilitykit.common.Ext;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>B\u0081\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012B\u007f\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0083\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0006HÖ\u0001J\t\u00104\u001a\u00020\u0004HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0018R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0018R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0018¨\u0006?"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJob;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "jobId", "", "jobType", "", "status", "updateVersion", "", "conversationId", "createTime", UserInfo.UPDATE_TIME, "content", "ext", "localJobId", "templateUrl", "<init>", "(Ljava/lang/String;IIJLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IIJLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJobId$annotations", "()V", "getJobType$annotations", "getStatus$annotations", "getUpdateVersion$annotations", "getConversationId$annotations", "getCreateTime$annotations", "getUpdateTime$annotations", "getContent$annotations", "getExt$annotations", "getLocalJobId$annotations", "getTemplateUrl$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniAIJob implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String content;
    public final String conversationId;
    public final long createTime;
    public final String ext;
    public final String jobId;
    public final int jobType;
    public final String localJobId;
    public final int status;
    public final String templateUrl;
    public final long updateTime;
    public final long updateVersion;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJob$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniAIJob;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniAIJob> serializer() {
            return OmniAIJob$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniAIJob() {
        this(null, 0, 0, 0, null, 0, 0, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ OmniAIJob copy$default(OmniAIJob r110, String r111, int r112, int r113, long r114, String r210, long r211, long r212, String r213, String r214, String r215, String r216, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.jobId;
    L7:
        if ((r310 & 2) == 0) goto L9;
        int r101 = r110.jobType;
    L11:
        if ((r310 & 4) == 0) goto L13;
        int r102 = r110.status;
    L15:
        if ((r310 & 8) == 0) goto L17;
        long r103 = r110.updateVersion;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.conversationId;
    L23:
        if ((r310 & 32) == 0) goto L25;
        long r105 = r110.createTime;
    L27:
        if ((r310 & 64) == 0) goto L29;
        long r115 = r110.updateTime;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r116 = r110.content;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r117 = r110.ext;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r118 = r110.localJobId;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r106 = r110.templateUrl;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r115, r116, r117, r118, r106);
    L45:
        r106 = r216;
        goto L47
    L41:
        r118 = r215;
        goto L43
    L37:
        r117 = r214;
        goto L39
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
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

    @SerialName("content")
    public static /* synthetic */ void getContent$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("create_time")
    public static /* synthetic */ void getCreateTime$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName(Ext.KEY_JOB_ID)
    public static /* synthetic */ void getJobId$annotations() {
    }

    @SerialName("job_type")
    public static /* synthetic */ void getJobType$annotations() {
    }

    @SerialName("local_job_id")
    public static /* synthetic */ void getLocalJobId$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("template_url")
    public static /* synthetic */ void getTemplateUrl$annotations() {
    }

    @SerialName("update_time")
    public static /* synthetic */ void getUpdateTime$annotations() {
    }

    @SerialName("update_version")
    public static /* synthetic */ void getUpdateVersion$annotations() {
    }

    public final String component1() {
        return this.jobId;
    }

    public final String component10() {
        return this.localJobId;
    }

    public final String component11() {
        return this.templateUrl;
    }

    public final int component2() {
        return this.jobType;
    }

    public final int component3() {
        return this.status;
    }

    public final long component4() {
        return this.updateVersion;
    }

    public final String component5() {
        return this.conversationId;
    }

    public final long component6() {
        return this.createTime;
    }

    public final long component7() {
        return this.updateTime;
    }

    public final String component8() {
        return this.content;
    }

    public final String component9() {
        return this.ext;
    }

    public final OmniAIJob copy(String r110, int r111, int r112, long r210, String r211, long r212, long r213, String r214, String r215, String r216, String r310) {
        return new OmniAIJob(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAIJob) == true) goto L8;
        return false;
    L8:
        OmniAIJob r101 = (OmniAIJob) r100;
        if (Intrinsics.areEqual(this.jobId, r101.jobId) == true) goto L12;
        return false;
    L12:
        if (this.jobType == r101.jobType) goto L15;
        return false;
    L15:
        if (this.status == r101.status) goto L18;
        return false;
    L18:
        if (this.updateVersion == r101.updateVersion) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L24;
        return false;
    L24:
        if (this.createTime == r101.createTime) goto L27;
        return false;
    L27:
        if (this.updateTime == r101.updateTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.localJobId, r101.localJobId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.templateUrl, r101.templateUrl) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.jobId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.jobType) * 31) + this.status) * 31;
        long r104 = this.updateVersion;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.conversationId;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        long r109 = this.createTime;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.updateTime;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        String r113 = this.content;
        if (r113 != null) goto L13;
        int r114 = 0;
    L14:
        int r115 = (r112 + r114) * 31;
        String r116 = this.ext;
        if (r116 != null) goto L17;
        int r117 = 0;
    L18:
        int r118 = (r115 + r117) * 31;
        String r119 = this.localJobId;
        if (r119 != null) goto L21;
        int r120 = 0;
    L22:
        int r121 = (r118 + r120) * 31;
        String r122 = this.templateUrl;
        if (r122 == null) goto L27;
        r101 = r122.hashCode();
    L27:
        return r121 + r101;
    L21:
        r120 = r119.hashCode();
        goto L22
    L17:
        r117 = r116.hashCode();
        goto L18
    L13:
        r114 = r113.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniAIJob(jobId=" + this.jobId + ", jobType=" + this.jobType + ", status=" + this.status + ", updateVersion=" + this.updateVersion + ", conversationId=" + this.conversationId + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", content=" + this.content + ", ext=" + this.ext + ", localJobId=" + this.localJobId + ", templateUrl=" + this.templateUrl + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniAIJob r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.jobId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeIntElement(r110, 1, r100.jobType);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeIntElement(r110, 2, r100.status);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.updateVersion);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeNullableSerializableElement(r110, 4, v2.f520790a, r100.conversationId);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeLongElement(r110, 5, r100.createTime);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeLongElement(r110, 6, r100.updateTime);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r110, 7, v2.f520790a, r100.content);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.ext);
    L84:
        if (r101.shouldEncodeElementDefault(r110, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r110, 9, v2.f520790a, r100.localJobId);
    L93:
        if (r101.shouldEncodeElementDefault(r110, 10) == false) goto L96;
    L94:
        r102 = true;
    L98:
        if (r102 == false) goto L101;
        r101.encodeNullableSerializableElement(r110, 10, v2.f520790a, r100.templateUrl);
        return;
    L101:
        return;
    L96:
        if (r100.templateUrl == null) goto L98;
    L87:
        if (r100.localJobId != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.ext != null) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.content != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.updateTime != 0) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.createTime != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.conversationId != null) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.updateVersion != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.status != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.jobType != 0) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.jobId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OmniAIJob(String r100, int r101, int r102, long r103, String r104, long r105, long r106, String r110, String r111, String r112, String r113) {
        this.jobId = r100;
        this.jobType = r101;
        this.status = r102;
        this.updateVersion = r103;
        this.conversationId = r104;
        this.createTime = r105;
        this.updateTime = r106;
        this.content = r110;
        this.ext = r111;
        this.localJobId = r112;
        this.templateUrl = r113;
    }

    public /* synthetic */ OmniAIJob(int r100, String r110, int r111, int r112, long r113, String r114, long r115, long r116, String r210, String r211, String r212, String r213, q2 r214) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniAIJob$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.jobId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.jobType = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.status = 0;
    L16:
        long r101 = 0;
        if ((r100 & 8) != 0) goto L19;
        this.updateVersion = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.conversationId = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.createTime = 0;
    L29:
        if ((r100 & 64) == 0) goto L32;
        r101 = r116;
    L32:
        this.updateTime = r101;
        if ((r100 & 128) != 0) goto L35;
        this.content = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.ext = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.localJobId = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.templateUrl = null;
        return;
    L47:
        this.templateUrl = r213;
        return;
    L43:
        this.localJobId = r212;
        goto L45
    L39:
        this.ext = r211;
        goto L41
    L35:
        this.content = r210;
        goto L37
    L27:
        this.createTime = r115;
        goto L29
    L23:
        this.conversationId = r114;
        goto L25
    L19:
        this.updateVersion = r113;
        goto L21
    L15:
        this.status = r112;
        goto L16
    L11:
        this.jobType = r111;
        goto L13
    L7:
        this.jobId = r110;
        goto L9
    }

    public /* synthetic */ OmniAIJob(String r110, int r111, int r112, long r113, String r210, long r211, long r212, String r213, String r214, String r215, String r216, int r310, DefaultConstructorMarker r311) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        int r102 = 0;
        if ((r310 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r310 & 4) != 0) goto L14;
        r102 = r112;
    L14:
        long r104 = 0;
        if ((r310 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        long r114 = 0;
    L27:
        if ((r310 & 64) != 0) goto L31;
        r104 = r212;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r310 & 1024) != 0) goto L46;
        r100 = r216;
    L46:
        this(r101, r103, r102, r105, r106, r114, r104, r115, r116, r117, r100);
        return;
    L41:
        r117 = r215;
        goto L43
    L37:
        r116 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L35
    L25:
        r114 = r211;
        goto L27
    L21:
        r106 = r210;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
