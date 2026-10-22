package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00060\u0001j\u0002`\u0002:\u0002'(B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB7\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J0\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0012\u0010\u0010¨\u0006)"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetAIJobRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "jobId", "", "fetchRemote", "", "jobType", "", "<init>", "(Ljava/lang/String;ZLjava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJobId$annotations", "()V", "getFetchRemote$annotations", "getJobType$annotations", "Ljava/lang/Integer;", "component1", "component2", "component3", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;ZLjava/lang/Integer;)Lcom/larus/im/internal/jni/bean/OmniGetAIJobRequest;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniGetAIJobRequest implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean fetchRemote;
    public final String jobId;
    public final Integer jobType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetAIJobRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniGetAIJobRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniGetAIJobRequest> serializer() {
            return OmniGetAIJobRequest$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniGetAIJobRequest() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ OmniGetAIJobRequest copy$default(OmniGetAIJobRequest r100, String r101, boolean r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.jobId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.fetchRemote;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.jobType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("fetch_remote")
    public static /* synthetic */ void getFetchRemote$annotations() {
    }

    @SerialName(Ext.KEY_JOB_ID)
    public static /* synthetic */ void getJobId$annotations() {
    }

    @SerialName("job_type")
    public static /* synthetic */ void getJobType$annotations() {
    }

    public final String component1() {
        return this.jobId;
    }

    public final boolean component2() {
        return this.fetchRemote;
    }

    public final Integer component3() {
        return this.jobType;
    }

    public final OmniGetAIJobRequest copy(String r100, boolean r101, Integer r102) {
        return new OmniGetAIJobRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniGetAIJobRequest) == true) goto L8;
        return false;
    L8:
        OmniGetAIJobRequest r101 = (OmniGetAIJobRequest) r100;
        if (Intrinsics.areEqual(this.jobId, r101.jobId) == true) goto L12;
        return false;
    L12:
        if (this.fetchRemote == r101.fetchRemote) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jobType, r101.jobType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.jobId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.fetchRemote == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        Integer r106 = this.jobType;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniGetAIJobRequest(jobId=" + this.jobId + ", fetchRemote=" + this.fetchRemote + ", jobType=" + this.jobType + ')';
    }

    public OmniGetAIJobRequest(String r100, boolean r101, Integer r102) {
        this.jobId = r100;
        this.fetchRemote = r101;
        this.jobType = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniGetAIJobRequest r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.jobId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.fetchRemote);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.jobType);
        return;
    L29:
        return;
    L24:
        if (r100.jobType == null) goto L26;
    L15:
        if (r100.fetchRemote == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.jobId != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniGetAIJobRequest(int r100, String r101, boolean r102, Integer r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniGetAIJobRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.jobId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.fetchRemote = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.jobType = null;
        return;
    L15:
        this.jobType = r103;
        return;
    L11:
        this.fetchRemote = r102;
        goto L13
    L7:
        this.jobId = r101;
        goto L9
    }

    public /* synthetic */ OmniGetAIJobRequest(String r100, boolean r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
