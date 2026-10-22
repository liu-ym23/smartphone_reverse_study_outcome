package h1a;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ixigua.lib.track.TrackParams;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/larus/ugc/perf/impl/mob/BaseUgcPerfEvent;", "Lcom/larus/ugc/perf/impl/mob/UgcPerfEvent;", "scene", "", "parentScene", "success", "errorCode", "", "duration", "traceId", DBDefinition.TASK_ID, "instructionType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getScene", "()Ljava/lang/String;", "getParentScene", "getSuccess", "getErrorCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "getTraceId", "getTaskId", "getInstructionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "sendWith", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/ugc/perf/impl/mob/BaseUgcPerfEvent;", "equals", "", "other", "", "hashCode", "toString", "Companion", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f483560a = null;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("error_code")
    private final Long errorCode;

    @SerializedName("instruction_type")
    private final Integer instructionType;

    @SerializedName("parent_scene")
    private final String parentScene;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("success")
    private final String success;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName(BindCardPayConfirmConstants.Key.TRACE_ID)
    private final String traceId;

    /* JADX INFO: renamed from: h1a.a$a, reason: collision with other inner class name */
    public static final class C6091a {
    }

    public a() {
        this(null, null, null, null, null, null, null, null, 255);
    }

    @Override // h1a.d
    public final String a() {
        return "ugc_core_segment_report";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentScene, r101.parentScene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.instructionType, r101.instructionType) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.parentScene;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.success;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.errorCode;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.duration;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.traceId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.taskId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.instructionType;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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

    public final String toString() {
        return "BaseUgcPerfEvent(scene=" + this.scene + ", parentScene=" + this.parentScene + ", success=" + this.success + ", errorCode=" + this.errorCode + ", duration=" + this.duration + ", traceId=" + this.traceId + ", taskId=" + this.taskId + ", instructionType=" + this.instructionType + ')';
    }

    static {
        f483560a = new Gson();
    }

    public final void b() {
        JSONObject r100 = new JSONObject(GsonProtectorUtils.toJson(f483560a, this));
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("ugc_core_segment_report");
        r102.f21463a.merge(r101);
        r102.b();
    }

    public a(String r100, String r101, String r102, Long r103, Long r104, String r105, String r106, Integer r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L26;
        r110 = null;
    L26:
        this.scene = r100;
        this.parentScene = r101;
        this.success = r102;
        this.errorCode = r103;
        this.duration = r104;
        this.traceId = r105;
        this.taskId = r106;
        this.instructionType = r110;
    }
}
