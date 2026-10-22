package com.larus.avlink.plugins;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.dora.api.IDoraService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class DoraAppletPlugin extends CommonAppletPlugin<n4> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f293580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f293581k;

    @Override // com.larus.call_plugins_doubao_common.CommonAppletPlugin
    public final void k3() {
        super.k3();
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 != null) goto L5;
        return;
    L5:
        List r101 = CollectionsKt.toList(r100.G0());
        com.larus.avlink.n1.d(this.f293580j, "onStart: vad: " + r101);
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Map r103 = (Map) r102.next();
        CoroutineScope r104 = ((n4) getContext()).r();
        if (r104 == null) goto L7;
        BuildersKt.launch$default(r104, Dispatchers.getIO(), null, new DoraAppletPlugin$onSessionStarted$1(this, r103, null), 2, null);
        goto L7
    L11:
        r100.G0().clear();
        CoroutineScope r105 = ((n4) getContext()).r();
        if (r105 == null) goto L20;
        BuildersKt.launch$default(r105, Dispatchers.getIO(), null, new DoraAppletPlugin$onSessionStarted$2(this, null), 2, null);
        return;
    }

    @Override // com.larus.call_plugins_doubao_common.CommonAppletPlugin, com.larus.audio.call.arch.a
    public final String T2() {
        return this.f293580j;
    }

    public DoraAppletPlugin(n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f293580j = "DoraAppletPlugin";
        this.f293581k = AppletPayloadProviderDelegate.f297130a.b(r100.params().f288755o.f288901c, r100.params().f288755o.f288906h, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.audio.call.arch.c] */
    @Override // com.larus.call_plugins_doubao_common.CommonAppletPlugin
    public final void j3(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        y1 r101 = (y1) getContext().c(Reflection.getOrCreateKotlinClass(y1.class), null);
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.P() != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        String r103 = String.valueOf(DoraVisionBizScene.LIVE_AI.getValue());
    L11:
        r100.put("vision_biz_scene", r103);
        return;
    L10:
        DoraVisionBizScene.a r104 = DoraVisionBizScene.Companion;
        int r105 = ((n4) getContext()).q();
        r104.getClass();
        r103 = String.valueOf(DoraVisionBizScene.a.a(r105).getValue());
    L7:
        r102 = false;
        goto L8
    }
}
