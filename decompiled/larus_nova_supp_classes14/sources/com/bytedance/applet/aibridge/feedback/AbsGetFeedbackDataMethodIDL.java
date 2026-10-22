package com.bytedance.applet.aibridge.feedback;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.flow.kmp.common.util.g;
import com.larus.im.bean.message.feedback.FeedbackItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import nuc.w0;
import org.json.JSONObject;
import ouc.e0;
import ouc.j;
import zd9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applet/aibridge/feedback/AbsGetFeedbackDataMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/feedback/AbsGetFeedbackDataMethodIDL$GetFeedbackParam;", "Lcom/bytedance/applet/aibridge/feedback/AbsGetFeedbackDataMethodIDL$GetFeedbackResult;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "updateFeedbackInfos", "", "feedbacks", "", "Lcom/larus/im/bean/message/feedback/FeedbackItem;", "GetFeedbackParam", "GetFeedbackResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetFeedbackDataMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "entityID", required = false)
        String getEntityId();

        @AIBridgeParamField(keyPath = "entityType", required = false)
        String getEntityType();

        @AIBridgeParamField(keyPath = "messageID", required = true)
        String getMessageId();

        @AIBridgeParamField(keyPath = "scene", required = false)
        String getScene();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "feedbackInfoDatas", required = true)
        void setFeedbackInfosJson(List<? extends JSONObject> r1);
    }

    public AbsGetFeedbackDataMethodIDL() {
        this.a = "flow.getFeedbackData";
    }

    public final String getName() {
        return this.a;
    }

    public static void b(b r5, List r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "feedbacks");
        List r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L30;
        FeedbackItem r1 = (FeedbackItem) r8.next();
        r1.getClass();
        e0 r2 = new e0();
        j.b(r2, "feedbackType", Integer.valueOf(r1.a));
        Integer r3 = r1.b;
        if (r3 == null) goto L8;
        j.b(r2, "feedbackDetailType", Integer.valueOf(r3.intValue()));
    L8:
        List r4 = r1.c;
        if (r4 == null) goto L14;
        kuc.a.e(IntCompanionObject.INSTANCE);
        String r9 = i.c(r4, kuc.a.b(w0.a));
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        j.c(r2, "feedbackDetailTypes", r9);
    L14:
        String r10 = r1.d;
        if (r10 == null) goto L17;
        j.c(r2, "feedbackDetailContent", r10);
    L17:
        String r11 = r1.e;
        if (r11 == null) goto L20;
        j.c(r2, "scene", r11);
    L20:
        String r12 = r1.f;
        if (r12 == null) goto L23;
        j.c(r2, "entityID", r12);
    L23:
        String r13 = r1.g;
        if (r13 == null) goto L26;
        j.c(r2, "entityType", r13);
    L26:
        String r14 = r1.h;
        if (r14 == null) goto L29;
        j.c(r2, "extra", r14);
    L29:
        r0.add(g.b(r2.a().toString()));
        goto L4
    L30:
        r5.setFeedbackInfosJson(r0);
    }
}
