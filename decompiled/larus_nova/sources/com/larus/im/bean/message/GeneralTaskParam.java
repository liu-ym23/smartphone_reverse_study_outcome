package com.larus.im.bean.message;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import yc9.n;
import yc9.o;
import yc9.p;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 j2\u00060\u0001j\u0002`\u0002:\u0002ijBÙ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cBÍ\u0001\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001b\u0010 J\u0010\u0010J\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tHÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010O\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010$J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010W\u001a\u00020\u0017HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jà\u0001\u0010Z\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020\u00172\b\u0010]\u001a\u0004\u0018\u00010^HÖ\u0003J\t\u0010_\u001a\u00020\u0004HÖ\u0001J\t\u0010`\u001a\u00020\u0006HÖ\u0001J%\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0002\bhR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\"\u001a\u0004\b'\u0010(R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\"\u001a\u0004\b*\u0010(R&\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\"\u001a\u0004\b,\u0010-R \u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010$R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\"\u001a\u0004\b1\u00102R \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b3\u0010\"\u001a\u0004\b4\u0010$R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\"\u001a\u0004\b6\u0010-R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\"\u001a\u0004\b8\u0010-R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\"\u001a\u0004\b:\u0010(R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\"\u001a\u0004\b<\u0010(R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\"\u001a\u0004\b>\u0010(R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\"\u001a\u0004\b@\u0010AR\u001c\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\"\u001a\u0004\bC\u0010DR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010\"\u001a\u0004\bF\u0010GR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010\"\u001a\u0004\bI\u0010(¨\u0006k"}, d2 = {"Lcom/larus/im/bean/message/GeneralTaskParam;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "action", "", DBDefinition.TASK_ID, "", "threadId", "threadLocalMessageIds", "", "sourceType", "clientOption", "Lcom/larus/im/bean/message/ClientOption;", "runtimeType", "selectedSkills", "skillSelections", "Lcom/larus/im/bean/message/SelectedSkill;", "dispatchControllerMobileDid", "dispatchControllerMobilePlatform", "dispatchControllerAppid", "agentTaskParamChange", "Lcom/larus/im/bean/message/AgentTaskParamChange;", "needModifyConversation", "", "agentTaskParam", "Lcom/larus/im/bean/message/AgentTaskParam;", "projectId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/im/bean/message/ClientOption;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/AgentTaskParamChange;ZLcom/larus/im/bean/message/AgentTaskParam;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/im/bean/message/ClientOption;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/AgentTaskParamChange;ZLcom/larus/im/bean/message/AgentTaskParam;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAction$annotations", "()V", "getAction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTaskId$annotations", "getTaskId", "()Ljava/lang/String;", "getThreadId$annotations", "getThreadId", "getThreadLocalMessageIds$annotations", "getThreadLocalMessageIds", "()Ljava/util/List;", "getSourceType$annotations", "getSourceType", "getClientOption$annotations", "getClientOption", "()Lcom/larus/im/bean/message/ClientOption;", "getRuntimeType$annotations", "getRuntimeType", "getSelectedSkills$annotations", "getSelectedSkills", "getSkillSelections$annotations", "getSkillSelections", "getDispatchControllerMobileDid$annotations", "getDispatchControllerMobileDid", "getDispatchControllerMobilePlatform$annotations", "getDispatchControllerMobilePlatform", "getDispatchControllerAppid$annotations", "getDispatchControllerAppid", "getAgentTaskParamChange$annotations", "getAgentTaskParamChange", "()Lcom/larus/im/bean/message/AgentTaskParamChange;", "getNeedModifyConversation$annotations", "getNeedModifyConversation", "()Z", "getAgentTaskParam$annotations", "getAgentTaskParam", "()Lcom/larus/im/bean/message/AgentTaskParam;", "getProjectId$annotations", "getProjectId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/im/bean/message/ClientOption;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/AgentTaskParamChange;ZLcom/larus/im/bean/message/AgentTaskParam;Ljava/lang/String;)Lcom/larus/im/bean/message/GeneralTaskParam;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class GeneralTaskParam implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final Integer action;
    private final AgentTaskParam agentTaskParam;
    private final AgentTaskParamChange agentTaskParamChange;
    private final ClientOption clientOption;
    private final String dispatchControllerAppid;
    private final String dispatchControllerMobileDid;
    private final String dispatchControllerMobilePlatform;
    private final boolean needModifyConversation;
    private final String projectId;
    private final Integer runtimeType;
    private final List<String> selectedSkills;
    private final List<SelectedSkill> skillSelections;
    private final Integer sourceType;
    private final String taskId;
    private final String threadId;
    private final List<String> threadLocalMessageIds;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<GeneralTaskParam> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346635a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346636b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346636b;
        }

        static {
            a r100 = new a();
            f346635a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.GeneralTaskParam", r100, 16);
            r101.j("action", true);
            r101.j("task_id", true);
            r101.j(CrashHianalyticsData.THREAD_ID, true);
            r101.j("thread_local_message_id", true);
            r101.j("source_type", true);
            r101.j("client_option", true);
            r101.j("runtime_type", true);
            r101.j("selected_skills", true);
            r101.j("skill_selections", true);
            r101.j("dispatch_controller_mobile_did", true);
            r101.j("dispatch_controller_mobile_platform", true);
            r101.j("dispatch_controller_appid", true);
            r101.j("agent_task_param_change", true);
            r101.j("need_modify_conversation", true);
            r101.j("agent_task_param", true);
            r101.j(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, true);
            f346636b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = GeneralTaskParam.access$get$childSerializers$cp();
            w0 r101 = w0.f520792a;
            v2 r102 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d((d) r100[3].getValue()), kuc.a.d(r101), kuc.a.d(ClientOption.a.f346602a), kuc.a.d(r101), kuc.a.d((d) r100[7].getValue()), kuc.a.d((d) r100[8].getValue()), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(AgentTaskParamChange.a.f346577a), i.f520705a, kuc.a.d(AgentTaskParam.a.f346575a), kuc.a.d(r102)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f346636b;
            muc.c r101 = r310.beginStructure(r100);
            Lazy[] r102 = GeneralTaskParam.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            w0 r103 = w0.f520792a;
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            List r110 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            ClientOption r111 = (ClientOption) r101.decodeNullableSerializableElement(r100, 5, ClientOption.a.f346602a, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            List r112 = (List) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), null);
            List r113 = (List) r101.decodeNullableSerializableElement(r100, 8, (juc.c) r102[8].getValue(), null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 10, r105, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 11, r105, null);
            AgentTaskParamChange r117 = (AgentTaskParamChange) r101.decodeNullableSerializableElement(r100, 12, AgentTaskParamChange.a.f346577a, null);
            boolean r118 = r101.decodeBooleanElement(r100, 13);
            AgentTaskParam r119 = (AgentTaskParam) r101.decodeNullableSerializableElement(r100, 14, AgentTaskParam.a.f346575a, null);
            String r210 = (String) r101.decodeNullableSerializableElement(r100, 15, r105, null);
            String r120 = r107;
            List r121 = r110;
            String r122 = r115;
            List r123 = r113;
            Integer r124 = r108;
            boolean r125 = r118;
            int r126 = 65535;
            AgentTaskParamChange r127 = r117;
            String r128 = r116;
            String r129 = r114;
            List r130 = r112;
            Integer r131 = r109;
            AgentTaskParam r211 = r119;
            String r132 = r106;
            Integer r133 = r104;
        L44:
            r101.endStructure(r100);
            return new GeneralTaskParam(r126, r133, r132, r120, r121, r124, r111, r131, r130, r123, r129, r122, r128, r127, r125, r211, r210, null);
        L5:
            List r134 = null;
            List r135 = null;
            String r136 = null;
            Integer r137 = null;
            AgentTaskParamChange r138 = null;
            List r139 = null;
            r111 = null;
            String r140 = null;
            Integer r141 = null;
            String r142 = null;
            r129 = null;
            String r212 = null;
            String r213 = null;
            Integer r214 = null;
            AgentTaskParam r215 = null;
            boolean r143 = false;
            int r216 = 0;
            boolean r217 = true;
        L6:
            if (r217 == false) goto L43;
            int r144 = r101.decodeElementIndex(r100);
            switch(r144) {
                case -1: goto L42;
                case 0: goto L40;
                case 1: goto L37;
                case 2: goto L36;
                case 3: goto L33;
                case 4: goto L31;
                case 5: goto L28;
                case 6: goto L27;
                case 7: goto L23;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L18;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r144);
        L42:
            boolean r311 = r143;
            r102 = r102;
            r140 = r140;
            r217 = false;
            r136 = r136;
            r214 = r214;
            r216 = r216;
            r134 = r134;
            r143 = r311;
            goto L6
        L11:
            r143 = r143;
            int r145 = 32768 | r216;
            r136 = r136;
            AgentTaskParamChange r218 = r138;
            r140 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r140);
            r215 = r215;
        L19:
            int r146 = r145;
            r138 = r218;
            r213 = r213;
        L35:
            AgentTaskParam r219 = r215;
            r140 = r140;
            r134 = r134;
            String r312 = r136;
            r102 = r102;
            String r147 = r213;
            r136 = r312;
        L39:
            String r148 = r147;
            r216 = r146;
            r134 = r134;
            r143 = r143;
            AgentTaskParam r220 = r219;
            Integer r221 = r214;
            String r222 = r212;
        L41:
            r213 = r148;
            r102 = r102;
            r215 = r220;
            r212 = r222;
            r214 = r221;
            goto L6
        L13:
            int r149 = r216 | 16384;
            r215 = (AgentTaskParam) r101.decodeNullableSerializableElement(r100, 14, AgentTaskParam.a.f346575a, r215);
        L25:
            int r150 = r149;
            boolean r151 = r143;
        L32:
            r143 = r151;
            r146 = r150;
        L34:
            r138 = r138;
            goto L35
        L14:
            r136 = r136;
            int r152 = r216;
            r140 = r140;
            r215 = r215;
            r150 = r152 | 8192;
            r138 = r138;
            r151 = r101.decodeBooleanElement(r100, 13);
            r213 = r213;
            goto L32
        L15:
            r138 = (AgentTaskParamChange) r101.decodeNullableSerializableElement(r100, 12, AgentTaskParamChange.a.f346577a, r138);
            r145 = r216 | 4096;
        L17:
            r218 = r138;
            goto L19
        L16:
            r142 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r142);
            r145 = r216 | 2048;
            goto L17
        L18:
            r136 = r136;
            r143 = r143;
            int r153 = r216;
            r140 = r140;
            r215 = r215;
            r218 = r138;
            r213 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r213);
            r145 = r153 | 1024;
            goto L19
        L20:
            r129 = (String) r101.decodeNullableSerializableElement(r100, 9, v2.f520790a, r129);
            int r154 = r216 | 512;
        L24:
            r149 = r154;
            goto L25
        L21:
            r215 = r215;
            r139 = (List) r101.decodeNullableSerializableElement(r100, 8, (juc.c) r102[8].getValue(), r139);
            r149 = r216 | 256;
            goto L25
        L23:
            r135 = (List) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), r135);
            r154 = r216 | 128;
            goto L24
        L27:
            r141 = (Integer) r101.decodeNullableSerializableElement(r100, 6, w0.f520792a, r141);
            r150 = r216 | 64;
        L29:
            r151 = r143;
            goto L32
        L28:
            r111 = (ClientOption) r101.decodeNullableSerializableElement(r100, 5, ClientOption.a.f346602a, r111);
            r150 = r216 | 32;
            goto L29
        L31:
            r136 = r136;
            boolean r313 = r143;
            r138 = r138;
            r213 = r213;
            int r155 = r216;
            r140 = r140;
            r215 = r215;
            r137 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r137);
            r150 = r155 | 16;
            r151 = r313;
            goto L32
        L33:
            r136 = r136;
            r143 = r143;
            r138 = r138;
            r213 = r213;
            int r156 = r216;
            r140 = r140;
            r215 = r215;
            r134 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r134);
            r146 = r156 | 8;
            goto L34
        L36:
            String r157 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r136);
            r146 = r216 | 4;
        L38:
            r147 = r213;
            r138 = r138;
            r136 = r157;
            r219 = r215;
            r140 = r140;
            goto L39
        L37:
            r157 = r136;
            r212 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r212);
            r146 = r216 | 2;
            goto L38
        L40:
            r102 = r102;
            List r223 = r134;
            boolean r314 = r143;
            int r158 = r216;
            Integer r159 = r214;
            r222 = r212;
            r138 = r138;
            r221 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r159);
            r134 = r223;
            r220 = r215;
            r140 = r140;
            r216 = r158 | 1;
            r143 = r314;
            r136 = r136;
            r148 = r213;
            goto L41
        L43:
            List r224 = r134;
            String r160 = r136;
            boolean r315 = r143;
            int r161 = r216;
            r122 = r213;
            r128 = r142;
            r127 = r138;
            r121 = r224;
            r210 = r140;
            r125 = r315;
            r133 = r214;
            r123 = r139;
            r211 = r215;
            r131 = r141;
            r130 = r135;
            r124 = r137;
            r126 = r161;
            r132 = r212;
            r120 = r160;
            goto L44
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            GeneralTaskParam r102 = (GeneralTaskParam) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346636b;
            muc.d r104 = r100.beginStructure(r103);
            GeneralTaskParam.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<GeneralTaskParam> serializer() {
            return a.f346635a;
        }
    }

    public GeneralTaskParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(kuc.a.d(v2.f520790a));
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(v2.f520790a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        return new nuc.f(SelectedSkill.a.f346713a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeneralTaskParam copy$default(GeneralTaskParam r110, Integer r111, String r112, String r210, List r211, Integer r212, ClientOption r213, Integer r214, List r215, List r216, String r217, String r218, String r219, AgentTaskParamChange r310, boolean r311, AgentTaskParam r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        Integer r100 = r110.action;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.taskId;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.threadId;
    L15:
        if ((r314 & 8) == 0) goto L17;
        List r103 = r110.threadLocalMessageIds;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Integer r104 = r110.sourceType;
    L23:
        if ((r314 & 32) == 0) goto L25;
        ClientOption r105 = r110.clientOption;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Integer r106 = r110.runtimeType;
    L31:
        if ((r314 & 128) == 0) goto L33;
        List r107 = r110.selectedSkills;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r113 = r110.skillSelections;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r114 = r110.dispatchControllerMobileDid;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = r110.dispatchControllerMobilePlatform;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r116 = r110.dispatchControllerAppid;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        AgentTaskParamChange r117 = r110.agentTaskParamChange;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r118 = r110.needModifyConversation;
    L58:
        boolean r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        AgentTaskParam r119 = r110.agentTaskParam;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.projectId;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
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

    @SerialName("agent_task_param")
    public static /* synthetic */ void getAgentTaskParam$annotations() {
    }

    @SerialName("agent_task_param_change")
    public static /* synthetic */ void getAgentTaskParamChange$annotations() {
    }

    @SerialName("client_option")
    public static /* synthetic */ void getClientOption$annotations() {
    }

    @SerialName("dispatch_controller_appid")
    public static /* synthetic */ void getDispatchControllerAppid$annotations() {
    }

    @SerialName("dispatch_controller_mobile_did")
    public static /* synthetic */ void getDispatchControllerMobileDid$annotations() {
    }

    @SerialName("dispatch_controller_mobile_platform")
    public static /* synthetic */ void getDispatchControllerMobilePlatform$annotations() {
    }

    @SerialName("need_modify_conversation")
    public static /* synthetic */ void getNeedModifyConversation$annotations() {
    }

    @SerialName(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID)
    public static /* synthetic */ void getProjectId$annotations() {
    }

    @SerialName("runtime_type")
    public static /* synthetic */ void getRuntimeType$annotations() {
    }

    @SerialName("selected_skills")
    public static /* synthetic */ void getSelectedSkills$annotations() {
    }

    @SerialName("skill_selections")
    public static /* synthetic */ void getSkillSelections$annotations() {
    }

    @SerialName("source_type")
    public static /* synthetic */ void getSourceType$annotations() {
    }

    @SerialName("task_id")
    public static /* synthetic */ void getTaskId$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    @SerialName("thread_local_message_id")
    public static /* synthetic */ void getThreadLocalMessageIds$annotations() {
    }

    public final Integer component1() {
        return this.action;
    }

    public final String component10() {
        return this.dispatchControllerMobileDid;
    }

    public final String component11() {
        return this.dispatchControllerMobilePlatform;
    }

    public final String component12() {
        return this.dispatchControllerAppid;
    }

    public final AgentTaskParamChange component13() {
        return this.agentTaskParamChange;
    }

    public final boolean component14() {
        return this.needModifyConversation;
    }

    public final AgentTaskParam component15() {
        return this.agentTaskParam;
    }

    public final String component16() {
        return this.projectId;
    }

    public final String component2() {
        return this.taskId;
    }

    public final String component3() {
        return this.threadId;
    }

    public final List<String> component4() {
        return this.threadLocalMessageIds;
    }

    public final Integer component5() {
        return this.sourceType;
    }

    public final ClientOption component6() {
        return this.clientOption;
    }

    public final Integer component7() {
        return this.runtimeType;
    }

    public final List<String> component8() {
        return this.selectedSkills;
    }

    public final List<SelectedSkill> component9() {
        return this.skillSelections;
    }

    public final GeneralTaskParam copy(Integer r110, String r210, String r211, List<String> r212, Integer r213, ClientOption r214, Integer r215, List<String> r216, List<SelectedSkill> r217, String r218, String r219, String r310, AgentTaskParamChange r311, boolean r312, AgentTaskParam r313, String r314) {
        return new GeneralTaskParam(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GeneralTaskParam) == true) goto L8;
        return false;
    L8:
        GeneralTaskParam r101 = (GeneralTaskParam) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.threadLocalMessageIds, r101.threadLocalMessageIds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clientOption, r101.clientOption) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.runtimeType, r101.runtimeType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectedSkills, r101.selectedSkills) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.skillSelections, r101.skillSelections) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dispatchControllerMobileDid, r101.dispatchControllerMobileDid) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.dispatchControllerMobilePlatform, r101.dispatchControllerMobilePlatform) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.dispatchControllerAppid, r101.dispatchControllerAppid) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.agentTaskParamChange, r101.agentTaskParamChange) == true) goto L48;
        return false;
    L48:
        if (this.needModifyConversation == r101.needModifyConversation) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.agentTaskParam, r101.agentTaskParam) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.projectId, r101.projectId) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.action;
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
        String r107 = this.threadId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.threadLocalMessageIds;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.sourceType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ClientOption r116 = this.clientOption;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.runtimeType;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.selectedSkills;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<SelectedSkill> r125 = this.skillSelections;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.dispatchControllerMobileDid;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.dispatchControllerMobilePlatform;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.dispatchControllerAppid;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        AgentTaskParamChange r137 = this.agentTaskParamChange;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        if (this.needModifyConversation == false) goto L57;
        int r140 = 1231;
    L58:
        int r141 = (r139 + r140) * 31;
        AgentTaskParam r142 = this.agentTaskParam;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        String r145 = this.projectId;
        if (r145 == null) goto L67;
        r101 = r145.hashCode();
    L67:
        return r144 + r101;
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = 1237;
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

    public String toString() {
        return "GeneralTaskParam(action=" + this.action + ", taskId=" + this.taskId + ", threadId=" + this.threadId + ", threadLocalMessageIds=" + this.threadLocalMessageIds + ", sourceType=" + this.sourceType + ", clientOption=" + this.clientOption + ", runtimeType=" + this.runtimeType + ", selectedSkills=" + this.selectedSkills + ", skillSelections=" + this.skillSelections + ", dispatchControllerMobileDid=" + this.dispatchControllerMobileDid + ", dispatchControllerMobilePlatform=" + this.dispatchControllerMobilePlatform + ", dispatchControllerAppid=" + this.dispatchControllerAppid + ", agentTaskParamChange=" + this.agentTaskParamChange + ", needModifyConversation=" + this.needModifyConversation + ", agentTaskParam=" + this.agentTaskParam + ", projectId=" + this.projectId + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(r100, new n()), null, null, null, LazyKt.lazy(r100, new o()), LazyKt.lazy(r100, new p()), null, null, null, null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final Integer getAction() {
        return this.action;
    }

    public final AgentTaskParam getAgentTaskParam() {
        return this.agentTaskParam;
    }

    public final AgentTaskParamChange getAgentTaskParamChange() {
        return this.agentTaskParamChange;
    }

    public final ClientOption getClientOption() {
        return this.clientOption;
    }

    public final String getDispatchControllerAppid() {
        return this.dispatchControllerAppid;
    }

    public final String getDispatchControllerMobileDid() {
        return this.dispatchControllerMobileDid;
    }

    public final String getDispatchControllerMobilePlatform() {
        return this.dispatchControllerMobilePlatform;
    }

    public final boolean getNeedModifyConversation() {
        return this.needModifyConversation;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final Integer getRuntimeType() {
        return this.runtimeType;
    }

    public final List<String> getSelectedSkills() {
        return this.selectedSkills;
    }

    public final List<SelectedSkill> getSkillSelections() {
        return this.skillSelections;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final List<String> getThreadLocalMessageIds() {
        return this.threadLocalMessageIds;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(GeneralTaskParam r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, w0.f520792a, r100.action);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.taskId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.threadId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.threadLocalMessageIds);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.sourceType);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, ClientOption.a.f346602a, r100.clientOption);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, w0.f520792a, r100.runtimeType);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, r103[7].getValue(), r100.selectedSkills);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, r103[8].getValue(), r100.skillSelections);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.dispatchControllerMobileDid);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.dispatchControllerMobilePlatform);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r101.encodeNullableSerializableElement(r102, 11, v2.f520790a, r100.dispatchControllerAppid);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, AgentTaskParamChange.a.f346577a, r100.agentTaskParamChange);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r101.encodeBooleanElement(r102, 13, r100.needModifyConversation);
    L129:
        if (r101.shouldEncodeElementDefault(r102, 14) == false) goto L132;
    L130:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r101.encodeNullableSerializableElement(r102, 14, AgentTaskParam.a.f346575a, r100.agentTaskParam);
    L138:
        if (r101.shouldEncodeElementDefault(r102, 15) == false) goto L141;
    L139:
        r104 = true;
    L143:
        if (r104 == false) goto L146;
        r101.encodeNullableSerializableElement(r102, 15, v2.f520790a, r100.projectId);
        return;
    L146:
        return;
    L141:
        if (r100.projectId == null) goto L143;
    L132:
        if (r100.agentTaskParam != null) goto L130;
        r119 = false;
        goto L135
    L123:
        if (r100.needModifyConversation == true) goto L121;
        r118 = false;
        goto L126
    L114:
        if (r100.agentTaskParamChange != null) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.dispatchControllerAppid != null) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.dispatchControllerMobilePlatform != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.dispatchControllerMobileDid != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.skillSelections != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.selectedSkills != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.runtimeType != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.clientOption != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.sourceType != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.threadLocalMessageIds != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.threadId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.taskId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.action != null) goto L4;
        r105 = false;
        goto L9
    }

    public GeneralTaskParam(Integer r100, String r101, String r102, List<String> r103, Integer r104, ClientOption r105, Integer r106, List<String> r110, List<SelectedSkill> r111, String r112, String r113, String r114, AgentTaskParamChange r115, boolean r116, AgentTaskParam r117, String r118) {
        this.action = r100;
        this.taskId = r101;
        this.threadId = r102;
        this.threadLocalMessageIds = r103;
        this.sourceType = r104;
        this.clientOption = r105;
        this.runtimeType = r106;
        this.selectedSkills = r110;
        this.skillSelections = r111;
        this.dispatchControllerMobileDid = r112;
        this.dispatchControllerMobilePlatform = r113;
        this.dispatchControllerAppid = r114;
        this.agentTaskParamChange = r115;
        this.needModifyConversation = r116;
        this.agentTaskParam = r117;
        this.projectId = r118;
    }

    public GeneralTaskParam(int r100, Integer r101, String r102, String r103, List r110, Integer r111, ClientOption r112, Integer r113, List r114, List r115, String r116, String r117, String r118, AgentTaskParamChange r119, boolean r210, AgentTaskParam r211, String r212, q2 r213) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346636b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.action = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.taskId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.threadId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.threadLocalMessageIds = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.sourceType = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.clientOption = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.runtimeType = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.selectedSkills = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.skillSelections = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.dispatchControllerMobileDid = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.dispatchControllerMobilePlatform = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.dispatchControllerAppid = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.agentTaskParamChange = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.needModifyConversation = false;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.agentTaskParam = null;
    L65:
        if ((r100 & 32768) != 0) goto L67;
        this.projectId = null;
        return;
    L67:
        this.projectId = r212;
        return;
    L63:
        this.agentTaskParam = r211;
        goto L65
    L59:
        this.needModifyConversation = r210;
        goto L61
    L55:
        this.agentTaskParamChange = r119;
        goto L57
    L51:
        this.dispatchControllerAppid = r118;
        goto L53
    L47:
        this.dispatchControllerMobilePlatform = r117;
        goto L49
    L43:
        this.dispatchControllerMobileDid = r116;
        goto L45
    L39:
        this.skillSelections = r115;
        goto L41
    L35:
        this.selectedSkills = r114;
        goto L37
    L31:
        this.runtimeType = r113;
        goto L33
    L27:
        this.clientOption = r112;
        goto L29
    L23:
        this.sourceType = r111;
        goto L25
    L19:
        this.threadLocalMessageIds = r110;
        goto L21
    L15:
        this.threadId = r103;
        goto L17
    L11:
        this.taskId = r102;
        goto L13
    L7:
        this.action = r101;
        goto L9
    }

    public /* synthetic */ GeneralTaskParam(Integer r110, String r111, String r210, List r211, Integer r212, ClientOption r213, Integer r214, List r215, List r216, String r217, String r218, String r219, AgentTaskParamChange r310, boolean r311, AgentTaskParam r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        ClientOption r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        List r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        AgentTaskParamChange r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r117 = false;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        AgentTaskParam r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
