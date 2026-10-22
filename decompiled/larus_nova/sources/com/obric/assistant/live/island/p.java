package com.obric.assistant.live.island;

import android.content.Context;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.live.template.ObricAINotificationTemplateText;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.RuntimeState;
import com.obric.livecard.api.entity.SceneType;
import com.obric.livecard.api.entity.TaskSceneEntity;
import com.obric.livecard.api.entity.Text;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sea.i0;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f390129e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f390130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f390131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f390132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f390133d;

    public static final class a {
    }

    static {
    }

    public p(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        this.f390130a = r100;
        this.f390131b = 5;
        this.f390132c = new q();
        this.f390133d = new ConcurrentHashMap();
    }

    public final void a(String r100) {
        com.obric.assistant.reporter.b.a("dynamic_island", null, 6);
        String r101 = this.f390133d.get(r100);
        FLogger.f375446a.i("ComplexTaskQueueingIslandModule", "openQueueingTask, taskId=" + r100 + ", targetMessageId=" + r101);
        i0.c(r101, ObricInteractionScene.COMPLEX_TASK_SCENE);
    }

    public final void update(List<DMTaskState> r410) {
        int r100 = 0;
        boolean r101 = true;
        if (r410 == null) goto L25;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r410.iterator();
    L6:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        DMTaskState r105 = (DMTaskState) r104;
        if (r105.getState() != DMConstData.DMComplexTaskState.Queueing.ordinal()) goto L17;
        DMTaskInfo r106 = r105.getTaskInfo();
        if (r106 != null) goto L12;
    L14:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L6;
        r102.add(r104);
        goto L6
    L12:
        if (r106.getTaskType() != DMConstData.DMTaskType.COMPLEX.ordinal()) goto L14;
        r107 = true;
    L17:
        r108 = false;
        goto L18
    L20:
        List r109 = CollectionsKt.sortedWith(r102, ComparisonsKt.compareBy(new Function1[]{new ComplexTaskQueueingIslandModule$getQueueingTasks$2(this), new o()}));
        if (r109 == null) goto L25;
        List r110 = CollectionsKt.take(r109, this.f390131b);
        if (r110 == null) goto L25;
    L26:
        FLogger r111 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("update, activeTaskSize=");
        if (r410 == null) goto L29;
        r100 = r410.size();
    L29:
        r112.append(r100);
        r112.append(", queueingTaskSize=");
        r112.append(r110.size());
        r112.append(", queueingTaskIds=");
        List r113 = r110;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L31:
        if (r115.hasNext() == false) goto L33;
        r114.add(((DMTaskState) r115.next()).getTaskId());
        goto L31
    L33:
        r112.append(r114);
        r111.i("ComplexTaskQueueingIslandModule", r112.toString());
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r117 = r113.iterator();
    L35:
        if (r117.hasNext() == false) goto L37;
        r116.add(((DMTaskState) r117.next()).getTaskId());
        goto L35
    L37:
        Set r118 = SetsKt.minus(CollectionsKt.toSet(this.f390132c.f390134a.keySet()), CollectionsKt.toSet(r116));
        if ((!r118.isEmpty()) == false) goto L40;
        FLogger.f375446a.i("ComplexTaskQueueingIslandModule", "removeInactiveQueueingSessions, removableTaskIds=" + r118);
    L40:
        Iterator r119 = r118.iterator();
    L42:
        if (r119.hasNext() == false) goto L47;
        String r120 = (String) r119.next();
        Intrinsics.checkNotNullParameter(r120, DBDefinition.TASK_ID);
        this.f390133d.remove(r120);
        q r121 = this.f390132c;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r120, DBDefinition.TASK_ID);
        IslandSession r122 = r121.f390134a.remove(r120);
        if (r122 == null) goto L42;
        int r123 = j.f390122a;
        j.f(r122);
        goto L42
    L47:
        Iterator r124 = r113.iterator();
    L49:
        if (r124.hasNext() == false) goto L93;
        DMTaskState r125 = (DMTaskState) r124.next();
        String r126 = r125.getTaskId();
        if (r126 != null) goto L53;
        r126 = "";
    L53:
        String r127 = r126;
        String r128 = r125.getExtra().get("origin_query");
        DMTaskInfo r129 = r125.getTaskInfo();
        if (r129 == null) goto L58;
        Map<String, String> r130 = r129.getExt();
        if (r130 == null) goto L58;
        String r131 = r130.get("o_last_reply_message_id");
    L59:
        String r132 = this.f390130a.getString(R.string.obric_complex_task_state_queueing);
        if (r128 != null) goto L62;
    L66:
        String r133 = r132;
    L67:
        DMTaskInfo r134 = r125.getTaskInfo();
        if (r134 == null) goto L79;
        IMMessage r135 = r134.getMessage();
        if (r135 == null) goto L79;
        String r136 = com.larus.bmhome.chat.bean.d.H(com.obric.assistant.special_input.util.i.a(r135));
        if (r136 == null) goto L79;
        if ((StringsKt.isBlank(r136) ^ r101) == true) goto L77;
        r136 = null;
    L77:
        if (r136 == null) goto L79;
        String r137 = r136;
    L80:
        sea.b.f541630a.getClass();
        final s r138 = new s(r127, r128, r131, r137, r132, r137, sea.b.a(r125.getTaskInfo()));
        String r139 = r138.f390141c;
        if (r139 != null) goto L83;
    L88:
        q r140 = this.f390132c;
        String r141 = r138.f390139a;
        r140.getClass();
        Intrinsics.checkNotNullParameter(r141, DBDefinition.TASK_ID);
        if (r140.f390134a.get(r141) != null) goto L91;
        FLogger r142 = FLogger.f375446a;
        r142.i("ComplexTaskQueueingIslandModule", "updateOrCreateQueueingSession create, taskId=" + r138.f390139a + ", targetMessageId=" + r138.f390141c);
        r r143 = new r(r138.f390139a, null, null, r138.f390145g);
        JsonObject r144 = new JsonObject();
        r144.addProperty("ext_task_id", r138.f390139a);
        Intrinsics.checkNotNullParameter(r143, "openChatParams");
        Intrinsics.checkNotNullParameter(r144, "ext");
        int r145 = j.f390122a;
        t r146 = new t(j.d(r143), r144, null);
        IslandWidget r147 = j.a(sea.h.t(), new Text(this.f390130a.getString(R.string.obric_live_island_collapse_view_complex_task_queueing), 14, "#FFFFFFFF", "#D9000000", null, null, null, sea.d.d(), 112, null));
        r147.setOnCardClickCallback(new l(this, r138));
        IslandWidget r148 = j.b(sea.h.o(), new Text(r138.f390142d, 16, "#FFFFFFFF", "#E6000000", null, null, null, sea.d.d(), 112, null), new Text(r138.f390143e, 13, "#E0FFFFFF", "#E6000000", null, null, null, sea.d.a(), 112, null), CollectionsKt.emptyList(), CollectionsKt.emptyList());
        r148.setOnCardClickCallback(new m(this, r138));
        IslandWidget r149 = j.c(new ObricAINotificationTemplateText(r138.f390142d, this.f390130a.getString(R.string.obric_complex_task_notification_title_masked_text), 14, "#FFFFFFFF", "#FF000000", "500", 1, sea.d.c()), new ObricAINotificationTemplateText(r138.f390143e, null, 14, "#E6FFFFFF", "#E6000000", null, 3, sea.d.b(), 34, null), null, sea.h.r(), 28);
        r149.setOnCardClickCallback(new n(this, r138));
        IslandSession r150 = j.e(new u(r147, r148, r149, r146, 4352));
        r150.setSceneEntity(new TaskSceneEntity(SceneType.AI_TASK, RuntimeState.PENDING, r138.f390144f, sea.h.v(r150), 0, "omni", 16, null));
        j.g(r150);
        r142.i("ComplexTaskQueueingIslandModule", "createAndPublishQueueingSession, taskId=" + r138.f390139a + ", targetMessageId=" + r138.f390141c);
        q r151 = this.f390132c;
        String r152 = r138.f390139a;
        r151.getClass();
        Intrinsics.checkNotNullParameter(r152, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r150, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r151.f390134a.put(r152, r150);
        r142.i("ComplexTaskQueueingIslandModule", "storeQueueingSession success, taskId=" + r138.f390139a + ", session=" + r150);
    L92:
        r101 = true;
        goto L49
    L91:
        FLogger.f375446a.i("ComplexTaskQueueingIslandModule", "updateOrCreateQueueingSession keep, taskId=" + r138.f390139a + ", targetMessageId=" + r138.f390141c);
        goto L92
    L83:
        if ((StringsKt.isBlank(r139) ^ r101) == true) goto L86;
        r139 = null;
    L86:
        if (r139 == null) goto L88;
        this.f390133d.put(r138.f390139a, r139);
    L79:
        r137 = r133;
        goto L80
    L62:
        if ((StringsKt.isBlank(r128) ^ r101) == false) goto L64;
        r133 = r128;
    L65:
        if (r133 != null) goto L67;
    L64:
        r133 = null;
    L58:
        r131 = null;
        goto L59
    L93:
        return;
    L25:
        r110 = CollectionsKt.emptyList();
        goto L26
    }
}
