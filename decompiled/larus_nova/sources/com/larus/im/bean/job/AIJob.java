package com.larus.im.bean.job;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.hihonor.honorid.core.data.UserInfo;
import com.obric.capabilitykit.common.Ext;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00060\u0001j\u0002`\u0002:\u0002KLB{\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012B\u007f\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\u0004HÆ\u0003J\t\u00109\u001a\u00020\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J}\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u0006HÖ\u0001J\t\u0010B\u001a\u00020\u0004HÖ\u0001J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\"R\u001c\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\"R\u001c\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010\u001aR\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001aR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001aR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001a¨\u0006M"}, d2 = {"Lcom/larus/im/bean/job/AIJob;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "jobId", "", "jobType", "", "status", "updateVersion", "", "conversationId", "createTime", UserInfo.UPDATE_TIME, "content", "ext", "localJobId", "templateUrl", "<init>", "(Ljava/lang/String;IIJLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IIJLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJobId$annotations", "()V", "getJobId", "()Ljava/lang/String;", "getJobType$annotations", "getJobType", "()I", "getStatus$annotations", "getStatus", "getUpdateVersion$annotations", "getUpdateVersion", "()J", "getConversationId$annotations", "getConversationId", "getCreateTime$annotations", "getCreateTime", "getUpdateTime$annotations", "getUpdateTime", "getContent$annotations", "getContent", "getExt$annotations", "getExt", "getLocalJobId$annotations", "getLocalJobId", "getTemplateUrl$annotations", "getTemplateUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class AIJob implements java.io.Serializable {
    public static final b Companion = null;
    private final String content;
    private final String conversationId;
    private final long createTime;
    private final String ext;
    private final String jobId;
    private final int jobType;
    private final String localJobId;
    private final int status;
    private final String templateUrl;
    private final long updateTime;
    private final long updateVersion;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<AIJob> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346551a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346552b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346552b;
        }

        static {
            a r100 = new a();
            f346551a = r100;
            g2 r101 = new g2("com.larus.im.bean.job.AIJob", r100, 11);
            r101.j(Ext.KEY_JOB_ID, true);
            r101.j("job_type", true);
            r101.j("status", true);
            r101.j("update_version", true);
            r101.j("conversation_id", true);
            r101.j("create_time", true);
            r101.j("update_time", true);
            r101.j("content", true);
            r101.j("ext", true);
            r101.j("local_job_id", true);
            r101.j("template_url", true);
            f346552b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            g1 r102 = g1.f520681a;
            return new d[]{r100, r101, r101, r102, kuc.a.d(r100), r102, r102, r100, r100, kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f346552b;
            c r101 = r310.beginStructure(r100);
            int r102 = 4;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = r101.decodeStringElement(r100, 0);
            int r104 = r101.decodeIntElement(r100, 1);
            int r105 = r101.decodeIntElement(r100, 2);
            long r110 = r101.decodeLongElement(r100, 3);
            v2 r106 = v2.f520790a;
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            long r111 = r101.decodeLongElement(r100, 5);
            long r112 = r101.decodeLongElement(r100, 6);
            String r108 = r101.decodeStringElement(r100, 7);
            String r109 = r101.decodeStringElement(r100, 8);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 9, r106, null);
            String r114 = r109;
            String r210 = (String) r101.decodeNullableSerializableElement(r100, 10, r106, null);
            String r211 = r113;
            int r115 = r105;
            int r116 = 2047;
            String r117 = r103;
            String r118 = r107;
            long r119 = r110;
            long r120 = r111;
            String r121 = r108;
            long r122 = r112;
            int r123 = r104;
        L26:
            r101.endStructure(r100);
            return new AIJob(r116, r117, r123, r115, r119, r118, r120, r122, r121, r114, r211, r210, null);
        L5:
            String r124 = null;
            String r125 = null;
            String r126 = null;
            String r212 = null;
            String r213 = null;
            String r214 = null;
            long r215 = 0;
            long r216 = 0;
            int r127 = 0;
            int r128 = 0;
            boolean r217 = true;
            r122 = 0;
            int r129 = 0;
        L6:
            if (r217 == false) goto L25;
            int r130 = r101.decodeElementIndex(r100);
            switch(r130) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r130);
        L19:
            r215 = r101.decodeLongElement(r100, 3);
            r127 = r127 | 8;
            goto L6
        L20:
            r127 = r127 | 4;
            r128 = r101.decodeIntElement(r100, 2);
            goto L6
        L21:
            r127 = r127 | 2;
            r129 = r101.decodeIntElement(r100, 1);
        L23:
            r102 = 4;
            goto L6
        L22:
            r212 = r101.decodeStringElement(r100, 0);
            r127 = r127 | 1;
            goto L23
        L24:
            r102 = 4;
            r217 = false;
            goto L6
        L11:
            r127 = r127 | 1024;
            r125 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r125);
            goto L6
        L12:
            r127 = r127 | 512;
            r126 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r126);
            goto L6
        L13:
            r127 = r127 | 256;
            r214 = r101.decodeStringElement(r100, 8);
            goto L6
        L14:
            r127 = r127 | 128;
            r213 = r101.decodeStringElement(r100, 7);
            goto L6
        L15:
            r122 = r101.decodeLongElement(r100, 6);
            r127 = r127 | 64;
            goto L6
        L16:
            r216 = r101.decodeLongElement(r100, 5);
            r127 = r127 | 32;
            goto L6
        L17:
            r127 = r127 | 16;
            r124 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r124);
            goto L6
        L25:
            r118 = r124;
            r115 = r128;
            r121 = r213;
            r114 = r214;
            r119 = r215;
            r116 = r127;
            r210 = r125;
            r117 = r212;
            r211 = r126;
            r123 = r129;
            r120 = r216;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            AIJob r102 = (AIJob) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346552b;
            muc.d r104 = r100.beginStructure(r103);
            AIJob.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<AIJob> serializer() {
            return a.f346551a;
        }
    }

    public AIJob() {
        this(null, 0, 0, 0, null, 0, 0, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ AIJob copy$default(AIJob r110, String r111, int r112, int r113, long r114, String r210, long r211, long r212, String r213, String r214, String r215, String r216, int r310, Object r311) {
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

    public final AIJob copy(String r110, int r111, int r112, long r210, String r211, long r212, long r213, String r214, String r215, String r216, String r310) {
        Intrinsics.checkNotNullParameter(r110, "jobId");
        Intrinsics.checkNotNullParameter(r214, "content");
        Intrinsics.checkNotNullParameter(r215, "ext");
        return new AIJob(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIJob) == true) goto L8;
        return false;
    L8:
        AIJob r101 = (AIJob) r100;
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
        int r100 = ((((this.jobId.hashCode() * 31) + this.jobType) * 31) + this.status) * 31;
        long r101 = this.updateVersion;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.conversationId;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        long r106 = this.createTime;
        int r107 = (((r102 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.updateTime;
        int r109 = (((((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.content.hashCode()) * 31) + this.ext.hashCode()) * 31;
        String r110 = this.localJobId;
        if (r110 != null) goto L9;
        int r111 = 0;
    L10:
        int r112 = (r109 + r111) * 31;
        String r113 = this.templateUrl;
        if (r113 == null) goto L15;
        r104 = r113.hashCode();
    L15:
        return r112 + r104;
    L9:
        r111 = r110.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "AIJob(jobId=" + this.jobId + ", jobType=" + this.jobType + ", status=" + this.status + ", updateVersion=" + this.updateVersion + ", conversationId=" + this.conversationId + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", content=" + this.content + ", ext=" + this.ext + ", localJobId=" + this.localJobId + ", templateUrl=" + this.templateUrl + ')';
    }

    static {
        Companion = new b();
    }

    public final String getContent() {
        return this.content;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getJobId() {
        return this.jobId;
    }

    public final int getJobType() {
        return this.jobType;
    }

    public final String getLocalJobId() {
        return this.localJobId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final long getUpdateVersion() {
        return this.updateVersion;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(AIJob r100, muc.d r110, f r111) {
        boolean r101 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r110.encodeStringElement(r111, 0, r100.jobId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        r110.encodeIntElement(r111, 1, r100.jobType);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L30;
        r110.encodeIntElement(r111, 2, r100.status);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r105 = true;
    L36:
        if (r105 == false) goto L39;
        r110.encodeLongElement(r111, 3, r100.updateVersion);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r106 = true;
    L45:
        if (r106 == false) goto L48;
        r110.encodeNullableSerializableElement(r111, 4, v2.f520790a, r100.conversationId);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r107 = true;
    L54:
        if (r107 == false) goto L57;
        r110.encodeLongElement(r111, 5, r100.createTime);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r108 = true;
    L63:
        if (r108 == false) goto L66;
        r110.encodeLongElement(r111, 6, r100.updateTime);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        boolean r109 = true;
    L72:
        if (r109 == false) goto L75;
        r110.encodeStringElement(r111, 7, r100.content);
    L75:
        if (r110.shouldEncodeElementDefault(r111, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r110.encodeStringElement(r111, 8, r100.ext);
    L84:
        if (r110.shouldEncodeElementDefault(r111, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r110.encodeNullableSerializableElement(r111, 9, v2.f520790a, r100.localJobId);
    L93:
        if (r110.shouldEncodeElementDefault(r111, 10) == false) goto L96;
    L94:
        r101 = true;
    L98:
        if (r101 == false) goto L101;
        r110.encodeNullableSerializableElement(r111, 10, v2.f520790a, r100.templateUrl);
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
        if (Intrinsics.areEqual(r100.ext, "") == false) goto L76;
        r112 = false;
        goto L81
    L69:
        if (Intrinsics.areEqual(r100.content, "") == false) goto L67;
        r109 = false;
        goto L72
    L60:
        if (r100.updateTime != 0) goto L58;
        r108 = false;
        goto L63
    L51:
        if (r100.createTime != 0) goto L49;
        r107 = false;
        goto L54
    L42:
        if (r100.conversationId != null) goto L40;
        r106 = false;
        goto L45
    L33:
        if (r100.updateVersion != 0) goto L31;
        r105 = false;
        goto L36
    L24:
        if (r100.status != 0) goto L22;
        r104 = false;
        goto L27
    L15:
        if (r100.jobType != 0) goto L13;
        r103 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.jobId, "") == false) goto L4;
        r102 = false;
        goto L9
    }

    public AIJob(String r100, int r101, int r102, long r103, String r104, long r105, long r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "jobId");
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r112, "ext");
        this.jobId = r100;
        this.jobType = r101;
        this.status = r102;
        this.updateVersion = r103;
        this.conversationId = r104;
        this.createTime = r105;
        this.updateTime = r110;
        this.content = r111;
        this.ext = r112;
        this.localJobId = r113;
        this.templateUrl = r114;
    }

    public AIJob(int r100, String r110, int r111, int r112, long r113, String r114, long r115, long r116, String r210, String r211, String r212, String r213, q2 r214) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346552b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.jobId = "";
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
        this.content = "";
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.ext = "";
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

    public /* synthetic */ AIJob(String r110, int r111, int r112, long r113, String r210, long r211, long r212, String r213, String r214, String r215, String r216, int r310, DefaultConstructorMarker r311) {
        String r100 = "";
        if ((r310 & 1) == 0) goto L5;
        String r101 = "";
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
    L18:
        String r114 = null;
        if ((r310 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        long r115 = 0;
    L27:
        if ((r310 & 64) != 0) goto L31;
        r104 = r212;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r116 = "";
    L35:
        if ((r310 & 256) != 0) goto L39;
        r100 = r214;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r117 = null;
    L43:
        if ((r310 & 1024) != 0) goto L46;
        r114 = r216;
    L46:
        this(r101, r103, r102, r105, r106, r115, r104, r116, r100, r117, r114);
        return;
    L41:
        r117 = r215;
        goto L43
    L33:
        r116 = r213;
        goto L35
    L25:
        r115 = r211;
        goto L27
    L21:
        r106 = r210;
        goto L23
    L17:
        r105 = r113;
        goto L18
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
