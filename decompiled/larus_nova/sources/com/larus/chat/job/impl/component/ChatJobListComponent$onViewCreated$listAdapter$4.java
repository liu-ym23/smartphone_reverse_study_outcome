package com.larus.chat.job.impl.component;

import com.baidu.platform.comapi.map.MapController;
import com.larus.im.bean.job.AIJob;
import com.obric.capabilitykit.common.Ext;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ChatJobListComponent$onViewCreated$listAdapter$4 extends FunctionReferenceImpl implements Function2<com.larus.chat.job.impl.page.i.a, Integer, Unit> {
    public ChatJobListComponent$onViewCreated$listAdapter$4(Object r100) {
        super(2, r100, ez8.a.class, "trackItemShow", "trackItemShow(Lcom/larus/chat/job/impl/page/ChatJobListItem$Job;I)V", 0);
    }

    public final void invoke(com.larus.chat.job.impl.page.i.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((ez8.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        String r102 = null;
        if (r100.f325376b == false) goto L7;
        String r103 = ez8.a.c(r100.f325375a);
        if (r103 == null) goto L13;
        r102 = "recommend:".concat(r103);
    L13:
        if (r102 != null) goto L16;
        return;
    L16:
        if (ez8.a.f474905b.add(r102) == true) goto L19;
        return;
    L19:
        if (r100.f325376b == false) goto L24;
        String r104 = ez8.a.c(r100.f325375a);
        if (r104 == null) goto L35;
        ez8.a.f("recommend_cron_job_show", ez8.a.d(r100.f325375a, r104, r101));
        return;
    L35:
        return;
    L24:
        AIJob r105 = r100.f325375a;
        JSONObject r106 = new JSONObject().put(Ext.KEY_JOB_ID, r105.getJobId()).put("current_page", "cron_job_manage").put("index", r101);
        ez8.a.f474904a.getClass();
        String r107 = ez8.a.l(r105);
        if (r107 == null) goto L27;
        r106.put("job_status", r107);
    L27:
        String r108 = ez8.a.e(r105);
        if (r108 == null) goto L30;
        r106.put(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE, r108);
    L30:
        ez8.a.f("cron_job_show", r106);
        return;
    L7:
        String r109 = r100.f325375a.getJobId();
        if ((!StringsKt.isBlank(r109)) == true) goto L11;
        r109 = null;
    L11:
        if (r109 == null) goto L13;
        r102 = "job:".concat(r109);
        goto L13
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.larus.chat.job.impl.page.i.a r100, Integer r101) {
        invoke(r100, r101.intValue());
        return Unit.INSTANCE;
    }
}
