package com.larus.ugc.perf.impl.genimg;

import android.util.LruCache;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import nq9.g;

/* JADX INFO: loaded from: classes31.dex */
public class OldUgcGenImgPerfMonitor implements com.larus.ugc.perf.impl.d, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, Boolean> f375115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, Job> f375116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f375117c;

    public static final class a {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b<\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010F\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010G\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00100Jæ\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0011HÖ\u0001J\t\u0010R\u001a\u00020\bHÖ\u0001R(\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR(\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010(R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b3\u00100R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b4\u00100R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b6\u00100R\u0016\u00107\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010(¨\u0006S"}, d2 = {"Lcom/larus/ugc/perf/impl/genimg/OldUgcGenImgPerfMonitor$UgcCompatGenerateImageEvent;", "Lcom/larus/ugc/perf/impl/mob/UgcPerfEvent;", "messageReceiveFirstPackage", "", "messageReceiveFirstImageDuration", "messageReceiveContentEnd", "duration", "scene", "", "parentScene", "success", "errorCode", "traceId", DBDefinition.TASK_ID, "taskType", "isMixedTask", "instructionType", "", "imageEditType", "expectCount", "realCount", "intentionType", "index", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getMessageReceiveFirstPackage$annotations", "()V", "getMessageReceiveFirstPackage", "()Ljava/lang/Long;", "setMessageReceiveFirstPackage", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMessageReceiveFirstImageDuration$annotations", "getMessageReceiveFirstImageDuration", "setMessageReceiveFirstImageDuration", "getMessageReceiveContentEnd$annotations", "getMessageReceiveContentEnd", "setMessageReceiveContentEnd", "getDuration", "getScene", "()Ljava/lang/String;", "getParentScene", "getSuccess", "getErrorCode", "getTraceId", "getTaskId", "getTaskType", "getInstructionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageEditType", "getExpectCount", "getRealCount", "getIntentionType", "getIndex", "mobKey", "getMobKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/ugc/perf/impl/genimg/OldUgcGenImgPerfMonitor$UgcCompatGenerateImageEvent;", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements h1a.d {

        @SerializedName("duration")
        private final Long duration;

        @SerializedName("error_code")
        private final Long errorCode;

        @SerializedName("expect_count")
        private final Integer expectCount;

        @SerializedName("image_edit_type")
        private final Integer imageEditType;

        @SerializedName("index")
        private final Integer index;

        @SerializedName("instruction_type")
        private final Integer instructionType;

        @SerializedName("intention_type")
        private final String intentionType;

        @SerializedName("is_mixed_task")
        private final String isMixedTask;

        @SerializedName("message_receive_content_end")
        private Long messageReceiveContentEnd;

        @SerializedName("message_receive_first_image_duration")
        private Long messageReceiveFirstImageDuration;

        @SerializedName("message_receive_first_package")
        private Long messageReceiveFirstPackage;

        @SerializedName("parent_scene")
        private final String parentScene;

        @SerializedName("real_count")
        private final Integer realCount;

        @SerializedName("scene")
        private final String scene;

        @SerializedName("success")
        private final String success;

        @SerializedName("task_id")
        private final String taskId;

        @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
        private final String taskType;

        @SerializedName(BindCardPayConfirmConstants.Key.TRACE_ID)
        private final String traceId;

        public b() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143);
        }

        @Override // h1a.d
        public final String a() {
            return "chat_generate_image";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.messageReceiveFirstPackage, r101.messageReceiveFirstPackage) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageReceiveFirstImageDuration, r101.messageReceiveFirstImageDuration) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.messageReceiveContentEnd, r101.messageReceiveContentEnd) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.parentScene, r101.parentScene) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.success, r101.success) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.taskType, r101.taskType) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.isMixedTask, r101.isMixedTask) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.instructionType, r101.instructionType) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.imageEditType, r101.imageEditType) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.expectCount, r101.expectCount) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.realCount, r101.realCount) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.intentionType, r101.intentionType) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.index, r101.index) == true) goto L62;
            return false;
        L62:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.messageReceiveFirstPackage;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Long r104 = this.messageReceiveFirstImageDuration;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.messageReceiveContentEnd;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Long r110 = this.duration;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.scene;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.parentScene;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.success;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            Long r122 = this.errorCode;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.traceId;
            if (r125 != null) goto L37;
            int r126 = 0;
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.taskId;
            if (r128 != null) goto L41;
            int r129 = 0;
        L42:
            int r130 = (r127 + r129) * 31;
            String r131 = this.taskType;
            if (r131 != null) goto L45;
            int r132 = 0;
        L46:
            int r133 = (r130 + r132) * 31;
            String r134 = this.isMixedTask;
            if (r134 != null) goto L49;
            int r135 = 0;
        L50:
            int r136 = (r133 + r135) * 31;
            Integer r137 = this.instructionType;
            if (r137 != null) goto L53;
            int r138 = 0;
        L54:
            int r139 = (r136 + r138) * 31;
            Integer r140 = this.imageEditType;
            if (r140 != null) goto L57;
            int r141 = 0;
        L58:
            int r142 = (r139 + r141) * 31;
            Integer r143 = this.expectCount;
            if (r143 != null) goto L61;
            int r144 = 0;
        L62:
            int r145 = (r142 + r144) * 31;
            Integer r146 = this.realCount;
            if (r146 != null) goto L65;
            int r147 = 0;
        L66:
            int r148 = (r145 + r147) * 31;
            String r149 = this.intentionType;
            if (r149 != null) goto L69;
            int r150 = 0;
        L70:
            int r151 = (r148 + r150) * 31;
            Integer r152 = this.index;
            if (r152 == null) goto L75;
            r101 = r152.hashCode();
        L75:
            return r151 + r101;
        L69:
            r150 = r149.hashCode();
            goto L70
        L65:
            r147 = r146.hashCode();
            goto L66
        L61:
            r144 = r143.hashCode();
            goto L62
        L57:
            r141 = r140.hashCode();
            goto L58
        L53:
            r138 = r137.hashCode();
            goto L54
        L49:
            r135 = r134.hashCode();
            goto L50
        L45:
            r132 = r131.hashCode();
            goto L46
        L41:
            r129 = r128.hashCode();
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

        public final String toString() {
            return "UgcCompatGenerateImageEvent(messageReceiveFirstPackage=" + this.messageReceiveFirstPackage + ", messageReceiveFirstImageDuration=" + this.messageReceiveFirstImageDuration + ", messageReceiveContentEnd=" + this.messageReceiveContentEnd + ", duration=" + this.duration + ", scene=" + this.scene + ", parentScene=" + this.parentScene + ", success=" + this.success + ", errorCode=" + this.errorCode + ", traceId=" + this.traceId + ", taskId=" + this.taskId + ", taskType=" + this.taskType + ", isMixedTask=" + this.isMixedTask + ", instructionType=" + this.instructionType + ", imageEditType=" + this.imageEditType + ", expectCount=" + this.expectCount + ", realCount=" + this.realCount + ", intentionType=" + this.intentionType + ", index=" + this.index + ')';
        }

        public b(Long r210, Long r211, Long r212, Long r213, String r214, String r215, String r216, Long r217, String r218, String r219, String r310, String r311, Integer r312, Integer r313, Integer r314, Integer r315, String r316, Integer r317, int r318) {
            if ((r318 & 1) == 0) goto L5;
            Long r100 = null;
        L7:
            if ((r318 & 2) == 0) goto L9;
            Long r101 = null;
        L11:
            if ((r318 & 4) == 0) goto L13;
            Long r102 = null;
        L15:
            if ((r318 & 8) == 0) goto L17;
            Long r103 = null;
        L19:
            if ((r318 & 16) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r318 & 32) == 0) goto L25;
            String r105 = null;
        L27:
            if ((r318 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r318 & 128) == 0) goto L33;
            Long r110 = null;
        L35:
            if ((r318 & 256) == 0) goto L37;
            String r111 = null;
        L39:
            if ((r318 & 512) == 0) goto L41;
            String r112 = null;
        L43:
            if ((r318 & 1024) == 0) goto L45;
            String r113 = null;
        L47:
            if ((r318 & 2048) == 0) goto L49;
            String r114 = null;
        L51:
            if ((r318 & 4096) == 0) goto L53;
            Integer r115 = null;
        L55:
            if ((r318 & 8192) == 0) goto L57;
            Integer r107 = null;
        L58:
            Integer r220 = r107;
            if ((r318 & 16384) == 0) goto L61;
            Integer r108 = null;
        L63:
            if ((r318 & 32768) == 0) goto L65;
            Integer r116 = null;
        L67:
            if ((r318 & 65536) == 0) goto L69;
            String r117 = null;
        L71:
            if ((r318 & 131072) == 0) goto L73;
            Integer r109 = null;
        L74:
            this.messageReceiveFirstPackage = r100;
            this.messageReceiveFirstImageDuration = r101;
            this.messageReceiveContentEnd = r102;
            this.duration = r103;
            this.scene = r104;
            this.parentScene = r105;
            this.success = r106;
            this.errorCode = r110;
            this.traceId = r111;
            this.taskId = r112;
            this.taskType = r113;
            this.isMixedTask = r114;
            this.instructionType = r115;
            this.imageEditType = r220;
            this.expectCount = r108;
            this.realCount = r116;
            this.intentionType = r117;
            this.index = r109;
            return;
        L73:
            r109 = r317;
            goto L74
        L69:
            r117 = r316;
            goto L71
        L65:
            r116 = r315;
            goto L67
        L61:
            r108 = r314;
            goto L63
        L57:
            r107 = r313;
            goto L58
        L53:
            r115 = r312;
            goto L55
        L49:
            r114 = r311;
            goto L51
        L45:
            r113 = r310;
            goto L47
        L41:
            r112 = r219;
            goto L43
        L37:
            r111 = r218;
            goto L39
        L33:
            r110 = r217;
            goto L35
        L29:
            r106 = r216;
            goto L31
        L25:
            r105 = r215;
            goto L27
        L21:
            r104 = r214;
            goto L23
        L17:
            r103 = r213;
            goto L19
        L13:
            r102 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    static {
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void d(com.larus.ugc.perf.impl.e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    public OldUgcGenImgPerfMonitor() {
        this.f375115a = new LruCache(5);
        this.f375116b = new LruCache(1);
        this.f375117c = "";
        com.larus.im.d.e().registerOnGlobalMessageObserver(new AnonymousClass1(this));
    }

    @Deprecated(message = "change to duration by multi-stage mob serials")
    public static void i(com.larus.ugc.perf.impl.e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        HashMap<String, Object> r101 = r100.f375105b;
        long r102 = System.currentTimeMillis();
        Long r103 = r100.c();
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L6:
        r101.put("message_receive_first_package", Long.valueOf(r102 - r104));
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.larus.ugc.perf.impl.d
    public void a(com.larus.ugc.perf.impl.e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        FLogger.f375446a.i("OldUgcGenImgPerfMonitor", "onReceiveMsg:" + r100.b());
        j(r100, 0);
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void c(com.larus.ugc.perf.impl.e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        FLogger.f375446a.i("OldUgcGenImgPerfMonitor", "onFirstPackage:" + r100.b());
        i(r100);
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void h(com.larus.ugc.perf.impl.e r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r100, "source");
        FLogger.f375446a.i("OldUgcGenImgPerfMonitor", "onReceiveLoadingMsg:" + r100.b());
        String r101 = r100.b();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f375117c = r101;
        String r102 = r100.b();
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f375116b.get(r102) == null) goto L10;
        return;
    L10:
        Job r103 = this.f375116b.put(r102, BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new OldUgcGenImgPerfMonitor$onReceiveLoadingMsg$1$job$1(r100, this, r102, null), 3, null));
    }

    public static long k(Message r100, long r101) {
        if (r100 == null) goto L6;
        Map<String, String> r102 = r100.getExt();
        if (r102 == null) goto L6;
        String r103 = r102.get("ai_creation_res_code");
    L7:
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        if (r103.length() != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return r101;
    L15:
        Long r105 = StringsKt.toLongOrNull(r103);
        if (r105 != null) goto L18;
        return r101;
    L18:
        return r105.longValue();
    L12:
        r104 = false;
    L6:
        r103 = null;
        goto L7
    }

    @Override // nq9.g
    public void b(Message r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "message");
        Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
        com.larus.ugc.perf.impl.e r100 = com.larus.ugc.perf.impl.d.a.a(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.f375105b.get("is_report_image_loading_success" + r111);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L8;
        return;
    L8:
        r100.f375105b.put("is_report_image_loading_success" + r111, r102);
        long r103 = System.currentTimeMillis();
        Object r112 = r100.f375105b.get("loading_item_start" + r111);
        if ((r112 instanceof Long) == false) goto L11;
        Long r113 = (Long) r112;
    L12:
        if (r113 == null) goto L14;
        long r104 = r113.longValue();
    L15:
        long r105 = r103 - r104;
        String r114 = r110.getMessageId();
        if (r114 != null) goto L18;
        r114 = "";
    L18:
        h1a.e.b(l(this, r114, "1", r105, com.larus.bmhome.chat.bean.d.h(r110)), r100);
        return;
    L14:
        r104 = System.currentTimeMillis();
        goto L15
    L11:
        r113 = null;
        goto L12
    }

    @Override // nq9.g
    public void e(Message r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
    }

    @Override // nq9.g
    public void f(Message r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        com.larus.ugc.perf.impl.e r102 = com.larus.ugc.perf.impl.d.a.a(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = r100.getMessageId();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        h1a.e.b(l(this, r103, "0", -1, com.larus.bmhome.chat.bean.d.h(r100)), r102);
    }

    @Override // nq9.g
    public void g(Message r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        com.larus.ugc.perf.impl.e r102 = com.larus.ugc.perf.impl.d.a.a(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.f375105b.put("loading_item_start" + r101, Long.valueOf(System.currentTimeMillis()));
    }

    @Deprecated(message = "change to duration by multi-stage mob serials")
    public final void j(com.larus.ugc.perf.impl.e r310, long r311) {
        Object r100 = r310.f375105b.get("is_send_message_content_end");
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
        return;
    L5:
        r310.f375105b.put("is_send_message_content_end", r101);
        long r102 = System.currentTimeMillis();
        Long r103 = r310.d();
        if (r103 == null) goto L8;
        long r104 = r103.longValue();
    L9:
        long r105 = r102 - r104;
        if (r105 > 0) goto L12;
        return;
    L12:
        if (r105 > 180000) goto L78;
        Long r106 = r310.c();
        if (r106 == null) goto L17;
        long r107 = r106.longValue();
    L18:
        long r110 = System.currentTimeMillis() - r107;
        long r108 = k(r310.f375104a, r311);
        Message r111 = r310.f375104a;
        if (r111 == null) goto L21;
        int r112 = com.larus.bmhome.chat.bean.d.I(r111);
    L22:
        Message r113 = r310.f375104a;
        if (r113 == null) goto L25;
        String r210 = tz9.a.a(r113);
    L26:
        Object r114 = r310.f375105b.get("message_receive_first_package");
        if ((r114 instanceof Long) == false) goto L29;
        Long r115 = (Long) r114;
    L31:
        if (r311 != 0) goto L33;
        long r109 = r105;
    L34:
        Message r116 = r310.f375104a;
        if (r116 == null) goto L37;
        Integer r211 = Integer.valueOf(com.larus.bmhome.chat.bean.d.h(r116));
    L38:
        Message r117 = r310.f375104a;
        if (r117 == null) goto L41;
        Integer r312 = IAIChatControlTraceService.f365889a.Wb(r117);
    L42:
        int r118 = r310.a();
        if (r108 != 0) goto L45;
        String r119 = "1";
    L46:
        String r212 = r119;
        Message r120 = r310.f375104a;
        if (r120 != null) goto L49;
    L51:
        boolean r121 = false;
    L52:
        if (r121 == false) goto L54;
        String r122 = "image";
    L57:
        String r313 = r122;
    L59:
        h1a.e.a(new b(r115, Long.valueOf(r105), Long.valueOf(r110), Long.valueOf(r109), "gen_image/receive_last_package", r210, r212, Long.valueOf(r108), null, null, null, null, r211, r312, Integer.valueOf(r118), Integer.valueOf(r112), r313, null, 134912), r310);
        Message r123 = r310.f375104a;
        if (r123 == null) goto L62;
        String r124 = r123.getMessageId();
    L63:
        if (r108 != 0) goto L65;
        boolean r125 = true;
    L66:
        h1a.b.a(r124, null, r125, Long.valueOf(r105), null);
        String r126 = r310.b();
        if (r126 == null) goto L72;
        this.f375115a.put(r126, r101);
        Job r127 = this.f375116b.get(r126);
        if (r127 == null) goto L71;
        Job.DefaultImpls.cancel$default(r127, null, 1, null);
    L71:
        Job r128 = this.f375116b.remove(r126);
    L72:
        IFlowSdkDepend r129 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r129 == null) goto L77;
        r129.r0();
        e2.f346164a.x();
        return;
    L77:
        return;
    L65:
        r125 = false;
        goto L66
    L62:
        r124 = null;
        goto L63
    L54:
        Message r130 = r310.f375104a;
        if (r130 == null) goto L58;
        r122 = ap8.a.b(r130);
        goto L57
    L58:
        r313 = null;
        goto L59
    L49:
        if (com.larus.bmhome.chat.bean.d.a0(r120) != true) goto L51;
        r121 = true;
        goto L52
    L45:
        r119 = "0";
        goto L46
    L41:
        r312 = null;
        goto L42
    L37:
        r211 = null;
        goto L38
    L33:
        r109 = -1;
        goto L34
    L29:
        r115 = null;
        goto L31
    L25:
        r210 = null;
        goto L26
    L21:
        r112 = 0;
        goto L22
    L17:
        r107 = 0;
        goto L18
    L78:
        return;
    L8:
        r104 = System.currentTimeMillis();
        goto L9
    }

    public static h1a.a l(OldUgcGenImgPerfMonitor r110, String r111, String r112, long r113, int r114) {
        r110.getClass();
        return new h1a.a("image_create/image_loading", null, r112, 0L, Long.valueOf(r113), r111, null, Integer.valueOf(r114), 66);
    }
}
