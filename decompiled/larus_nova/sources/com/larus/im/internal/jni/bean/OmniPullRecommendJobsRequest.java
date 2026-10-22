package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u0002:\u0002\u001e\u001fB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPullRecommendJobsRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "includeLarkEventJobs", "", "<init>", "(Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIncludeLarkEventJobs$annotations", "()V", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniPullRecommendJobsRequest implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean includeLarkEventJobs;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPullRecommendJobsRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniPullRecommendJobsRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniPullRecommendJobsRequest> serializer() {
            return OmniPullRecommendJobsRequest$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniPullRecommendJobsRequest() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ OmniPullRecommendJobsRequest copy$default(OmniPullRecommendJobsRequest r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.includeLarkEventJobs;
    L6:
        return r100.copy(r101);
    }

    @SerialName("include_lark_event_jobs")
    public static /* synthetic */ void getIncludeLarkEventJobs$annotations() {
    }

    public final boolean component1() {
        return this.includeLarkEventJobs;
    }

    public final OmniPullRecommendJobsRequest copy(boolean r100) {
        return new OmniPullRecommendJobsRequest(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniPullRecommendJobsRequest) == true) goto L9;
        return false;
    L9:
        if (this.includeLarkEventJobs == ((OmniPullRecommendJobsRequest) r100).includeLarkEventJobs) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.includeLarkEventJobs == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "OmniPullRecommendJobsRequest(includeLarkEventJobs=" + this.includeLarkEventJobs + ')';
    }

    public OmniPullRecommendJobsRequest(boolean r100) {
        this.includeLarkEventJobs = r100;
    }

    public /* synthetic */ OmniPullRecommendJobsRequest(int r100, boolean r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniPullRecommendJobsRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.includeLarkEventJobs = false;
        return;
    L7:
        this.includeLarkEventJobs = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniPullRecommendJobsRequest r100, muc.d r101, f r102) {
        boolean r103 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r103 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.includeLarkEventJobs);
        return;
    L12:
        return;
    L6:
        if (r100.includeLarkEventJobs == true) goto L9;
        r103 = false;
        goto L9
    }

    public /* synthetic */ OmniPullRecommendJobsRequest(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
