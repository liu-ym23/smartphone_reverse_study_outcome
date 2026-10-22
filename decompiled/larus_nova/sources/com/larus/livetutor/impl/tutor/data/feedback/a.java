package com.larus.livetutor.impl.tutor.data.feedback;

import com.larus.livetutor.api.idl.CommonFeedbackConf;
import com.larus.livetutor.api.idl.EvaluateLabel;
import com.larus.livetutor.api.idl.FeedbackNode;
import com.larus.livetutor.api.idl.GetCommonFeedbackConfResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final List a(FeedbackNode r100, GetCommonFeedbackConfResponse r101) {
        ArrayList r102 = new ArrayList();
        List<Integer> r103 = r100.getEvaluateLabelIds();
        if (r103 == null) goto L10;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        EvaluateLabel r105 = c(r101, ((Number) r104.next()).intValue());
        if (r105 == null) goto L6;
        r102.add(r105);
    L10:
        return r102;
    }

    public static final FeedbackNode b(GetCommonFeedbackConfResponse r100, int r101) {
        CommonFeedbackConf r102 = r100.getConversationConf();
        Object r103 = null;
        if (r102 == null) goto L27;
        List<FeedbackNode> r104 = r102.getFeedbackNodes();
        if (r104 == null) goto L28;
        List r105 = CollectionsKt.filterNotNull(r104);
        if (r105 == null) goto L29;
        Iterator r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        Integer r108 = ((FeedbackNode) r107).getFeedbackNodeId();
        if (r108 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == false) goto L10;
        r103 = r107;
        goto L21
    L15:
        if (r108.intValue() != r101) goto L17;
        r109 = true;
    L21:
        return (FeedbackNode) r103;
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    }

    public static final EvaluateLabel c(GetCommonFeedbackConfResponse r100, int r101) {
        CommonFeedbackConf r102 = r100.getConversationConf();
        Object r103 = null;
        if (r102 == null) goto L27;
        List<EvaluateLabel> r104 = r102.getEvaluateLabels();
        if (r104 == null) goto L28;
        List r105 = CollectionsKt.filterNotNull(r104);
        if (r105 == null) goto L29;
        Iterator r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        Integer r108 = ((EvaluateLabel) r107).getEvaluateLabelId();
        if (r108 != null) goto L15;
    L17:
        boolean r109 = false;
    L18:
        if (r109 == false) goto L10;
        r103 = r107;
        goto L21
    L15:
        if (r108.intValue() != r101) goto L17;
        r109 = true;
    L21:
        return (EvaluateLabel) r103;
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    }
}
