package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00060\u0001j\u0002`\u0002:\u0002@AB\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012B\u007f\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0086\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\tHÖ\u0001J\t\u00107\u001a\u00020\u0004HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0018R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u0012\u0004\b\u001c\u0010\u0018R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u0012\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u0012\u0004\b\u001f\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u0012\u0004\b \u0010\u0018R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u0012\u0004\b\"\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0018¨\u0006B"}, d2 = {"Lcom/larus/im/bean/message/block/TaskCardBlock;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "threadId", "", DBDefinition.TASK_ID, "title", "subTitle", "status", "", "style", "action", "startTimestamp", "", "estimatedDuration", "actionParam", "Lcom/larus/im/bean/message/block/ActionParams;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/im/bean/message/block/ActionParams;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/im/bean/message/block/ActionParams;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThreadId$annotations", "()V", "getTaskId$annotations", "getTitle$annotations", "getSubTitle$annotations", "getStatus$annotations", "Ljava/lang/Integer;", "getStyle$annotations", "getAction$annotations", "getStartTimestamp$annotations", "Ljava/lang/Long;", "getEstimatedDuration$annotations", "getActionParam$annotations", "component1", "component2", "component3", "component4", "component5", "()Ljava/lang/Integer;", "component6", "component7", "component8", "()Ljava/lang/Long;", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/im/bean/message/block/ActionParams;)Lcom/larus/im/bean/message/block/TaskCardBlock;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class TaskCardBlock implements java.io.Serializable {
    public static final b Companion = null;
    public final Integer action;
    public final ActionParams actionParam;
    public final Long estimatedDuration;
    public final Long startTimestamp;
    public final Integer status;
    public final Integer style;
    public final String subTitle;
    public final String taskId;
    public final String threadId;
    public final String title;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TaskCardBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347074a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347075b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347075b;
        }

        static {
            a r100 = new a();
            f347074a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.TaskCardBlock", r100, 10);
            r101.j(CrashHianalyticsData.THREAD_ID, true);
            r101.j("task_id", true);
            r101.j("title", true);
            r101.j(BdpAppEventConstant.PARAMS_SUB_TITLE, true);
            r101.j("status", true);
            r101.j("style", true);
            r101.j("action", true);
            r101.j("start_timestamp", true);
            r101.j("estimated_duration", true);
            r101.j("action_params", true);
            f347075b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            g1 r102 = g1.f520681a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(ActionParams.a.f346769a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347075b;
            c r101 = r210.beginStructure(r100);
            int r102 = 8;
            int r103 = 6;
            int r104 = 7;
            String r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r105 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            w0 r108 = w0.f520792a;
            Integer r113 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r108, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r108, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r108, null);
            g1 r115 = g1.f520681a;
            Long r116 = (Long) r101.decodeNullableSerializableElement(r100, 7, r115, null);
            Long r117 = (Long) r101.decodeNullableSerializableElement(r100, 8, r115, null);
            Integer r118 = r114;
            Integer r119 = r109;
            ActionParams r120 = (ActionParams) r101.decodeNullableSerializableElement(r100, 9, ActionParams.a.f346769a, null);
            Long r121 = r116;
            String r122 = r111;
            int r123 = 1023;
            String r124 = r107;
            String r125 = r106;
            String r126 = r112;
            Integer r127 = r113;
        L27:
            r101.endStructure(r100);
            return new TaskCardBlock(r123, r122, r126, r125, r124, r127, r119, r118, r121, r117, r120, null);
        L5:
            ActionParams r128 = null;
            Long r129 = null;
            Long r130 = null;
            Integer r131 = null;
            Integer r132 = null;
            String r133 = null;
            Integer r134 = null;
            String r135 = null;
            String r211 = null;
            int r136 = 0;
            boolean r212 = true;
        L6:
            if (r212 == false) goto L26;
            int r137 = r101.decodeElementIndex(r100);
            switch(r137) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r137);
        L25:
            r102 = 8;
            r103 = 6;
            r104 = 7;
            r212 = false;
            goto L6
        L11:
            r128 = (ActionParams) r101.decodeNullableSerializableElement(r100, 9, ActionParams.a.f346769a, r128);
            r136 = r136 | 512;
        L20:
            String r138 = r135;
        L22:
            String r139 = r211;
        L24:
            r135 = r138;
            r211 = r139;
            r102 = 8;
            r103 = 6;
            r104 = 7;
            goto L6
        L12:
            r129 = (Long) r101.decodeNullableSerializableElement(r100, r102, g1.f520681a, r129);
            r136 = r136 | 256;
            goto L20
        L13:
            r130 = (Long) r101.decodeNullableSerializableElement(r100, r104, g1.f520681a, r130);
            r136 = r136 | 128;
            goto L20
        L14:
            r132 = (Integer) r101.decodeNullableSerializableElement(r100, r103, w0.f520792a, r132);
            r136 = r136 | 64;
            goto L20
        L16:
            r131 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r131);
            r136 = r136 | 32;
            goto L20
        L17:
            r134 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r134);
            r136 = r136 | 16;
            goto L20
        L18:
            r133 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r133);
            r136 = r136 | 8;
            goto L20
        L19:
            r135 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r135);
            r136 = r136 | 4;
            goto L20
        L21:
            r138 = r135;
            r211 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r211);
            r136 = r136 | 2;
            goto L22
        L23:
            r138 = r135;
            r139 = r211;
            r136 = r136 | 1;
            r110 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r110);
            goto L24
        L26:
            r123 = r136;
            r120 = r128;
            r117 = r129;
            r122 = r110;
            r126 = r211;
            r119 = r131;
            r124 = r133;
            r118 = r132;
            r127 = r134;
            r121 = r130;
            r125 = r135;
            goto L27
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            TaskCardBlock r102 = (TaskCardBlock) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347075b;
            muc.d r104 = r100.beginStructure(r103);
            TaskCardBlock.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TaskCardBlock> serializer() {
            return a.f347074a;
        }
    }

    public TaskCardBlock() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ TaskCardBlock copy$default(TaskCardBlock r110, String r111, String r112, String r113, String r114, Integer r115, Integer r116, Integer r117, Long r118, Long r210, ActionParams r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.threadId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.taskId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.title;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.subTitle;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r104 = r110.status;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r105 = r110.style;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r106 = r110.action;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Long r107 = r110.startTimestamp;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Long r119 = r110.estimatedDuration;
    L39:
        if ((r212 & 512) == 0) goto L41;
        ActionParams r108 = r110.actionParam;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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

    @SerialName("action")
    public static /* synthetic */ void getAction$annotations() {
    }

    @SerialName("action_params")
    public static /* synthetic */ void getActionParam$annotations() {
    }

    @SerialName("estimated_duration")
    public static /* synthetic */ void getEstimatedDuration$annotations() {
    }

    @SerialName("start_timestamp")
    public static /* synthetic */ void getStartTimestamp$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("style")
    public static /* synthetic */ void getStyle$annotations() {
    }

    @SerialName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public static /* synthetic */ void getSubTitle$annotations() {
    }

    @SerialName("task_id")
    public static /* synthetic */ void getTaskId$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String component1() {
        return this.threadId;
    }

    public final ActionParams component10() {
        return this.actionParam;
    }

    public final String component2() {
        return this.taskId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.subTitle;
    }

    public final Integer component5() {
        return this.status;
    }

    public final Integer component6() {
        return this.style;
    }

    public final Integer component7() {
        return this.action;
    }

    public final Long component8() {
        return this.startTimestamp;
    }

    public final Long component9() {
        return this.estimatedDuration;
    }

    public final TaskCardBlock copy(String r110, String r111, String r112, String r113, Integer r114, Integer r115, Integer r116, Long r210, Long r211, ActionParams r212) {
        return new TaskCardBlock(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskCardBlock) == true) goto L8;
        return false;
    L8:
        TaskCardBlock r101 = (TaskCardBlock) r100;
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.startTimestamp, r101.startTimestamp) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.estimatedDuration, r101.estimatedDuration) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actionParam, r101.actionParam) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.threadId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.taskId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subTitle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.status;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.style;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.action;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.startTimestamp;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.estimatedDuration;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ActionParams r128 = this.actionParam;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
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

    public String toString() {
        return "TaskCardBlock(threadId=" + this.threadId + ", taskId=" + this.taskId + ", title=" + this.title + ", subTitle=" + this.subTitle + ", status=" + this.status + ", style=" + this.style + ", action=" + this.action + ", startTimestamp=" + this.startTimestamp + ", estimatedDuration=" + this.estimatedDuration + ", actionParam=" + this.actionParam + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(TaskCardBlock r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.threadId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.taskId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.title);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.subTitle);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L41;
    L40:
        boolean r108 = true;
    L48:
        if (r108 == false) goto L51;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.status);
    L51:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L53;
    L52:
        boolean r109 = true;
    L60:
        if (r109 == false) goto L63;
        r101.encodeNullableSerializableElement(r102, 5, w0.f520792a, r100.style);
    L63:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L65;
    L64:
        boolean r110 = true;
    L72:
        if (r110 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 6, w0.f520792a, r100.action);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L78;
    L76:
        boolean r111 = true;
    L81:
        if (r111 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 7, g1.f520681a, r100.startTimestamp);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L87;
    L85:
        boolean r112 = true;
    L90:
        if (r112 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 8, g1.f520681a, r100.estimatedDuration);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L96;
    L94:
        r103 = true;
    L98:
        if (r103 == false) goto L101;
        r101.encodeNullableSerializableElement(r102, 9, ActionParams.a.f346769a, r100.actionParam);
        return;
    L101:
        return;
    L96:
        if (r100.actionParam == null) goto L98;
    L87:
        if (r100.estimatedDuration != null) goto L85;
        r112 = false;
        goto L90
    L78:
        if (r100.startTimestamp != null) goto L76;
        r111 = false;
        goto L81
    L65:
        Integer r113 = r100.action;
        int r114 = TaskCardActionStage.DEFAULT.getValue();
        if (r113 == null) goto L64;
        if (r113.intValue() != r114) goto L64;
        r110 = false;
        goto L72
    L53:
        Integer r115 = r100.style;
        int r116 = TaskCardStyle.DEFAULT.getValue();
        if (r115 == null) goto L52;
        if (r115.intValue() != r116) goto L52;
        r109 = false;
        goto L60
    L41:
        Integer r117 = r100.status;
        int r118 = Status.STATUS_UNKNOWN.getValue();
        if (r117 == null) goto L40;
        if (r117.intValue() != r118) goto L40;
        r108 = false;
        goto L48
    L33:
        if (r100.subTitle != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.title != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.taskId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.threadId != null) goto L4;
        r104 = false;
        goto L9
    }

    public TaskCardBlock(String r100, String r101, String r102, String r103, Integer r104, Integer r105, Integer r106, Long r107, Long r108, ActionParams r110) {
        this.threadId = r100;
        this.taskId = r101;
        this.title = r102;
        this.subTitle = r103;
        this.status = r104;
        this.style = r105;
        this.action = r106;
        this.startTimestamp = r107;
        this.estimatedDuration = r108;
        this.actionParam = r110;
    }

    public TaskCardBlock(int r100, String r101, String r102, String r103, String r104, Integer r105, Integer r106, Integer r107, Long r110, Long r111, ActionParams r112, q2 r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347075b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.threadId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.taskId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.title = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.subTitle = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.status = Integer.valueOf(Status.STATUS_UNKNOWN.getValue());
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.style = Integer.valueOf(TaskCardStyle.DEFAULT.getValue());
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.action = Integer.valueOf(TaskCardActionStage.DEFAULT.getValue());
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.startTimestamp = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.estimatedDuration = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.actionParam = null;
        return;
    L43:
        this.actionParam = r112;
        return;
    L39:
        this.estimatedDuration = r111;
        goto L41
    L35:
        this.startTimestamp = r110;
        goto L37
    L31:
        this.action = r107;
        goto L33
    L27:
        this.style = r106;
        goto L29
    L23:
        this.status = r105;
        goto L25
    L19:
        this.subTitle = r104;
        goto L21
    L15:
        this.title = r103;
        goto L17
    L11:
        this.taskId = r102;
        goto L13
    L7:
        this.threadId = r101;
        goto L9
    }

    public /* synthetic */ TaskCardBlock(String r110, String r111, String r112, String r113, Integer r114, Integer r115, Integer r116, Long r117, Long r210, ActionParams r211, int r212, DefaultConstructorMarker r213) {
        ActionParams r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r105 = Integer.valueOf(Status.STATUS_UNKNOWN.getValue());
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r106 = Integer.valueOf(TaskCardStyle.DEFAULT.getValue());
    L27:
        if ((r212 & 64) == 0) goto L29;
        Integer r107 = Integer.valueOf(TaskCardActionStage.DEFAULT.getValue());
    L31:
        if ((r212 & 128) == 0) goto L33;
        Long r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Long r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
