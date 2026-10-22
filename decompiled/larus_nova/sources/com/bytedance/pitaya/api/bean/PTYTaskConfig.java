package com.bytedance.pitaya.api.bean;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B'\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J)\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYTaskConfig;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "", "component1", "", "component2", "", "component3", DocumentType.DOCX_SYNC_BLOCK_NAME, SoloKtvContext.SOLO_PAGE_ENTRANCE, "pendingTimeout", "copy", "toString", "", "hashCode", "", "other", "equals", "Z", "getSync", "()Z", "Ljava/lang/String;", "getEntrance", "()Ljava/lang/String;", FaceService.girlLabel, "getPendingTimeout", "()F", "callType", "I", "getCallType", "()I", "setCallType", "(I)V", "<init>", "(ZLjava/lang/String;F)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYTaskConfig implements ReflectionCall {
    public static final a Companion = null;
    public static final int FORWARD_TYPE_AUTO = 4;
    public static final int FORWARD_TYPE_CORE_ML = 10;
    public static final int FORWARD_TYPE_CPU = 0;
    public static final int FORWARD_TYPE_CUDA = 9;
    public static final int FORWARD_TYPE_DSP = 2;
    public static final int FORWARD_TYPE_GPU = 1;
    public static final int FORWARD_TYPE_METAL = 5;
    public static final int FORWARD_TYPE_NPU = 3;
    public static final int FORWARD_TYPE_OPENCL = 6;
    public static final int FORWARD_TYPE_OPENGL = 7;
    public static final int FORWARD_TYPE_VULKAN = 8;
    public static final int TASK_CALL_API = 1;
    public static final int TASK_CALL_API_CACHED = 14;
    public static final int TASK_CALL_PRELOAD = 13;
    public static final int TASK_CALL_RELEASE_RUNNER_AND_ENGINE = 16;
    public static final int TASK_CALL_UNKNOWN = 0;
    public static final int TASK_PRIORITY_HIGH = 3;
    public static final int TASK_PRIORITY_HIGHEST = 4;
    public static final int TASK_PRIORITY_LOW = 1;
    public static final int TASK_PRIORITY_LOWEST = 0;
    public static final int TASK_PRIORITY_NORMAL = 2;
    private int callType;
    private final String entrance;
    private final float pendingTimeout;
    private final boolean sync;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PTYTaskConfig() {
        this(false, null, 0.0f, 7, null);
    }

    public static /* synthetic */ PTYTaskConfig copy$default(PTYTaskConfig r100, boolean r101, String r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.sync;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.entrance;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pendingTimeout;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.sync;
    }

    public final String component2() {
        return this.entrance;
    }

    public final float component3() {
        return this.pendingTimeout;
    }

    public final PTYTaskConfig copy(boolean r100, String r101, float r102) {
        return new PTYTaskConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYTaskConfig) == true) goto L8;
        return false;
    L8:
        PTYTaskConfig r101 = (PTYTaskConfig) r100;
        if (this.sync == r101.sync) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entrance, r101.entrance) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.pendingTimeout, r101.pendingTimeout) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.sync;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.entrance;
        if (r103 != null) goto L8;
        int r104 = 0;
    L10:
        return ((r102 + r104) * 31) + Float.floatToIntBits(this.pendingTimeout);
    L8:
        r104 = r103.hashCode();
        goto L10
    }

    public String toString() {
        return "PTYTaskConfig(sync=" + this.sync + ", entrance=" + this.entrance + ", pendingTimeout=" + this.pendingTimeout + ')';
    }

    public final int getCallType() {
        return this.callType;
    }

    public final String getEntrance() {
        return this.entrance;
    }

    public final float getPendingTimeout() {
        return this.pendingTimeout;
    }

    public final boolean getSync() {
        return this.sync;
    }

    public final void setCallType(int r100) {
        this.callType = r100;
    }

    public PTYTaskConfig(boolean r100, String r101, float r102) {
        this.sync = r100;
        this.entrance = r101;
        this.pendingTimeout = r102;
        this.callType = 1;
    }

    public /* synthetic */ PTYTaskConfig(boolean r100, String r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = -1.0f;
    L11:
        this(r100, r101, r102);
    }
}
