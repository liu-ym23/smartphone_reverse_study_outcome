package com.larus.livetutor.impl.tutor.data.feedback;

import com.larus.livetutor.api.idl.CommonFeedbackConf;
import com.larus.livetutor.api.idl.EvaluateLabel;
import com.larus.livetutor.api.idl.FeedbackNode;
import com.larus.livetutor.api.idl.GetCommonFeedbackConfResponse;
import com.larus.livetutor.api.idl.StatusInfo;
import com.larus.livetutor.impl.repository.LiveTutorApi;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class CommonFeedbackConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommonFeedbackConfig f356554a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, CommonFeedbackModel> f356555b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, List<EvaluateLabel>> f356556c = null;

    public CommonFeedbackConfig() {
    }

    static {
        f356554a = new CommonFeedbackConfig();
        f356555b = new HashMap();
        f356556c = new HashMap();
    }

    public final Object a(long r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof CommonFeedbackConfig$requestFeedbackConfig$1) == false) goto L7;
        CommonFeedbackConfig$requestFeedbackConfig$1 r100 = (CommonFeedbackConfig$requestFeedbackConfig$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L17:
        GetCommonFeedbackConfResponse r105 = (GetCommonFeedbackConfResponse) r102;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("Feedback config map=");
        CommonFeedbackConf r108 = r105.getConversationConf();
        if (r108 == null) goto L20;
        Map<String, Integer> r109 = r108.getRootFeedbackNodeMap();
    L21:
        r107.append(r109);
        r106.i("CommonFeedbackConfig", r107.toString());
        StatusInfo r110 = r105.getStatusInfo();
        if (r110 == null) goto L29;
        Integer r111 = r110.getStatusCode();
        if (r111 == null) goto L29;
        if (r111.intValue() != 0) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L108;
        HashMap r113 = (HashMap) f356555b;
        r113.clear();
        CommonFeedbackConf r114 = r105.getConversationConf();
        if (r114 == null) goto L36;
        Map<String, Integer> r115 = r114.getRootFeedbackNodeMap();
        if (r115 == null) goto L36;
        Integer r116 = r115.get("live_tutor_exit_feedback_root_feedback_node_id");
    L37:
        if (r116 == null) goto L39;
        FeedbackNode r117 = a.b(r105, r116.intValue());
    L40:
        if (r117 == null) goto L80;
        String r118 = r117.getTitle();
        if (r118 != null) goto L44;
        String r119 = "";
    L45:
        String r120 = r117.getSubTitle();
        if (r120 != null) goto L48;
        String r121 = "";
    L49:
        List r122 = null;
        CommonFeedbackConf r123 = r105.getConversationConf();
        if (r123 == null) goto L54;
        Map<String, Integer> r124 = r123.getRootFeedbackNodeMap();
        if (r124 == null) goto L54;
        Integer r125 = r124.get("live_tutor_exit_feedback_root_feedback_node_id");
    L55:
        if (r125 == null) goto L57;
        int r126 = r125.intValue();
    L58:
        CommonFeedbackModel r127 = new CommonFeedbackModel(r119, r121, r122, r126, 4, null);
        r127.getEntities().add(new CommonFeedbackItemEntity(null, 0, a.a(r117, r105), null, null, false, 59, null));
        List<CommonFeedbackItemEntity> r128 = r127.getEntities();
        ArrayList r129 = new ArrayList();
        List<Integer> r130 = r117.getFeedbackNodeIds();
        if (r130 == null) goto L67;
        ArrayList r131 = new ArrayList();
        Iterator<T> r132 = r130.iterator();
    L62:
        if (r132.hasNext() == false) goto L66;
        FeedbackNode r133 = a.b(r105, ((Number) r132.next()).intValue());
        if (r133 == null) goto L62;
        r131.add(r133);
        goto L62
    L66:
        r129.addAll(r131);
    L67:
        ArrayList r134 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r135 = r129.iterator();
    L69:
        if (r135.hasNext() == false) goto L79;
        FeedbackNode r136 = (FeedbackNode) r135.next();
        String r137 = r136.getTitle();
        if (r137 != null) goto L73;
        String r138 = "";
    L74:
        Integer r139 = r136.getFeedbackNodeId();
        if (r139 == null) goto L77;
        int r140 = r139.intValue();
    L78:
        r134.add(new CommonFeedbackItemEntity(r138, r140, a.a(r136, r105), null, null, false, 56, null));
        goto L69
    L77:
        r140 = 0;
        goto L78
    L73:
        r138 = r137;
        goto L74
    L79:
        r128.addAll(r134);
        Unit r141 = Unit.INSTANCE;
        CommonFeedbackModel r142 = (CommonFeedbackModel) r113.put("live_tutor_exit_feedback_root_feedback_node_id", r127);
        goto L80
    L57:
        r126 = 0;
    L54:
        r125 = null;
        goto L55
    L48:
        r121 = r120;
        goto L49
    L44:
        r119 = r118;
    L80:
        HashMap r143 = (HashMap) f356556c;
        r143.clear();
        HashMap r144 = new HashMap();
        CommonFeedbackConf r145 = r105.getConversationConf();
        if (r145 == null) goto L107;
        List<EvaluateLabel> r146 = r145.getEvaluateLabels();
        if (r146 == null) goto L107;
        List r147 = CollectionsKt.filterNotNull(r146);
        if (r147 == null) goto L107;
        Iterator r148 = r147.iterator();
    L88:
        if (r148.hasNext() == false) goto L107;
        EvaluateLabel r149 = (EvaluateLabel) r148.next();
        List<Integer> r150 = r149.getNextOptEvaluateLabelIds();
        if (r150 == null) goto L88;
        ArrayList r151 = new ArrayList();
        Iterator<T> r152 = r150.iterator();
    L93:
        if (r152.hasNext() == false) goto L98;
        EvaluateLabel r153 = a.c(r105, ((Number) r152.next()).intValue());
        if (r153 == null) goto L93;
        r151.add(r153);
        goto L93
    L98:
        if ((!r151.isEmpty()) == true) goto L101;
        r151 = null;
    L101:
        if (r151 == null) goto L88;
        Integer r154 = r149.getEvaluateLabelId();
        if (r154 == null) goto L105;
        int r155 = r154.intValue();
    L106:
        r144.put(Integer.valueOf(r155), CollectionsKt.toMutableList(r151));
        goto L88
    L105:
        r155 = 0;
    L107:
        r143.putAll(r144);
        FLogger r156 = FLogger.f375446a;
        r156.i("CommonFeedbackConfig", "Parse tcc feedback model. feedbackMap=" + f356555b);
        r156.i("CommonFeedbackConfig", "Parse tcc feedback model. nextOptLabels=" + f356556c);
    L110:
        return Unit.INSTANCE;
    L39:
        r117 = null;
    L36:
        r116 = null;
        goto L37
    L108:
        r106.i("CommonFeedbackConfig", "Request ttc feedback config fail.");
    L29:
        r112 = false;
        goto L30
    L20:
        r109 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        LiveTutorApi.Companion r157 = LiveTutorApi.f356187a;
        CommonFeedbackConfig$requestFeedbackConfig$res$1 r158 = new CommonFeedbackConfig$requestFeedbackConfig$res$1(r210, null);
        r100.label = 1;
        r102 = r157.a(r158, r100);
        if (r102 != r103) goto L17;
        return r103;
    L7:
        r100 = new CommonFeedbackConfig$requestFeedbackConfig$1(this, r211);
        goto L8
    }
}
