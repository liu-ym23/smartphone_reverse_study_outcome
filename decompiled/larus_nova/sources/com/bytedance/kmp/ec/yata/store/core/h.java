package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.patch.BasePatch;
import com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor;
import com.bytedance.kmp.ec.yata.common.protocol.data.r;
import com.bytedance.kmp.ec.yata.common.render.TreeType;
import com.bytedance.kmp.ec.yata.store.frontier.FrontierMessageHandleType;
import com.bytedance.kmp.ec.yata.store.frontier.YataFrontierMessageDispatcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements com.bytedance.kmp.ec.yata.store.redux.f<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f251742a;

    public h(m r100) {
        this.f251742a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.f
    public final l a(l r210, com.bytedance.kmp.ec.yata.store.redux.a r211) {
        l r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r211, "action");
        String r101 = YaTaLog.f251436a;
        YaTaLog.c("YataState_YataActions", YataActionsKt$createHandleDispatchActionReducer$1$reduce$1.INSTANCE);
        YataStoreData r102 = r211.getData();
        if (Intrinsics.areEqual(r102.f251719c, aa6.a.b.C0039a.f2349b) == false) goto L7;
        AbsPerfMonitor r103 = r102.f251723g;
        if (r103 == null) goto L10;
        AbsPerfMonitor.d(r103, com.bytedance.kmp.ec.yata.common.perf.c.f251486n);
    L10:
        m r104 = this.f251742a;
        Intrinsics.checkNotNullParameter(r102, "storeData");
        Intrinsics.checkNotNullParameter(r100, "oldState");
        Intrinsics.checkNotNullParameter(r104, "storeContext");
        Object r105 = r102.f251718b;
        if (r105 != null) goto L13;
        r105 = r102.f251717a.r().a();
    L13:
        if (r105 == null) goto L170;
        boolean r106 = r105 instanceof com.bytedance.kmp.ec.yata.common.protocol.data.c;
        if (r106 == true) goto L18;
    L20:
        boolean r110 = false;
    L22:
        if ((r105 instanceof aa6.b) == false) goto L24;
        aa6.b r111 = (aa6.b) r105;
    L30:
        k r107 = r100.f251747a;
        YataStoreData.StoreType r112 = r102.f251720d;
        int r113 = YataReducersKt.a.f251711a[r112.ordinal()];
        if (r113 != 1) goto L33;
        aa6.a r114 = r102.f251719c;
        Intrinsics.checkNotNullParameter(r114, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r111, "incrementalProtocol");
        Intrinsics.checkNotNullParameter(r104, "storeContext");
        if (r107 == null) goto L45;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r107.f251745a = r104;
        YataReducersKt.c(r107.f251746b, r111, r104, r114);
    L48:
        k r115 = r107;
        Intrinsics.checkNotNullParameter(r105, "yataData");
        Intrinsics.checkNotNullParameter(r102, "storeData");
        Intrinsics.checkNotNullParameter(r104, "storeContext");
        Intrinsics.checkNotNullParameter(r115, "protocolContext");
        if (Intrinsics.areEqual(r102.f251719c, aa6.a.C0038a.f2348b) == true) goto L129;
        YataFrontierMessageDispatcher r108 = r104.f251752a.t();
        if (r108 == null) goto L58;
        List<com.bytedance.kmp.ec.yata.store.frontier.c> r109 = r108.c(r102.f251719c, aa6.c.c(r115.f251746b), aa6.c.a(r115.f251746b));
        if (r109 == null) goto L58;
        List r116 = CollectionsKt.toMutableList(r109);
        if (r116 == null) goto L58;
    L59:
        if (r110 == false) goto L66;
        if (r106 == false) goto L62;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r117 = (com.bytedance.kmp.ec.yata.common.protocol.data.c) r105;
    L63:
        if (r117 == null) goto L66;
        YataErrorManager r118 = r104.f251752a.f();
        r118.getClass();
        Intrinsics.checkNotNullParameter("log_id", "key");
        com.bytedance.kmp.ec.yata.store.frontier.c r119 = new com.bytedance.kmp.ec.yata.store.frontier.c(r117, String.valueOf((String) ((Map) r118.f251390d.getValue()).get("log_id")));
        r119.f251773c = FrontierMessageHandleType.UPLINK;
        Unit r120 = Unit.INSTANCE;
        ListProtector.add(r116, 0, r119);
        goto L66
    L62:
        r117 = null;
    L66:
        if (r116.isEmpty() == false) goto L68;
        YaTaLog.c("YataReducers", YataReducersKt$handleFrontierPatch$2.INSTANCE);
        goto L129
    L68:
        AbsPerfMonitor r121 = r102.f251723g;
        if (r121 == null) goto L71;
        AbsPerfMonitor.d(r121, com.bytedance.kmp.ec.yata.common.perf.c.f251488p);
    L71:
        Iterator r122 = r116.iterator();
    L73:
        if (r122.hasNext() == false) goto L126;
        final com.bytedance.kmp.ec.yata.store.frontier.c r123 = (com.bytedance.kmp.ec.yata.store.frontier.c) r122.next();
        if (com.bytedance.kmp.ec.yata.common.protocol.data.d.b(r123.f251771a) == true) goto L76;
        String r124 = YaTaLog.f251436a;
        YaTaLog.c("YataReducers", new YataReducersKt$handleFrontierPatch$3$2(r123));
        YataReducersKt.c(r115.f251746b, com.bytedance.kmp.ec.yata.common.protocol.data.d.d(r123.f251771a), r104, r102.f251719c);
        goto L73
    L76:
        String r125 = YaTaLog.f251436a;
        YaTaLog.c("YataReducers", new YataReducersKt$handleFrontierPatch$3$1(r123));
        aa6.b r126 = r115.f251746b;
        Intrinsics.checkNotNullParameter(r123, "messageData");
        if (r126 != null) goto L83;
        YataStoreWrapper r127 = r104.f251752a;
        if (r127 == null) goto L121;
        YataErrorManager r128 = r127.f();
        if (r128 == null) goto L121;
        com.bytedance.kmp.ec.yata.common.error.d r129 = com.bytedance.kmp.ec.yata.common.error.c.i();
        r129.c("protocol_is_null");
        r129.d("本地Protocol为null  无法执行Patch");
        r128.c(r129);
    L121:
        if (r126 == null) goto L123;
        YataReducersKt.b(r126, r102.f251719c, true, r104.f251752a, com.bytedance.kmp.ec.yata.common.protocol.data.d.d(r123.f251771a));
    L123:
        if (r126 == null) goto L73;
        Intrinsics.checkNotNullParameter(r126, "<set-?>");
        r115.f251746b = r126;
        goto L73
    L83:
        r r130 = r123.f251771a.i();
        if (r130 == null) goto L86;
        List<Map<String, Object>> r131 = r130.a();
    L87:
        if (r131 == null) goto L89;
        int r132 = r131.size();
    L90:
        if (r132 <= 0) goto L121;
        BasePatch r133 = BasePatch.f251443a;
        Map<String, Object> r134 = r126.f();
        if (r131 != null) goto L94;
        r131 = CollectionsKt.emptyList();
    L94:
        r133.getClass();
        BasePatch.a r135 = BasePatch.g(r134, r131, false);
        if (r135.f251450g == false) goto L102;
        YataStoreWrapper r136 = r104.f251752a;
        if (r136 == null) goto L102;
        YataErrorManager r137 = r136.f();
        if (r137 == null) goto L102;
        com.bytedance.kmp.ec.yata.common.error.d r138 = com.bytedance.kmp.ec.yata.common.error.c.i();
        r138.c(String.valueOf(r135.f251447d));
        r138.n(r135);
        r138.m("patch_log_id", r123.f251772b);
        r138.d("Patch执行Crash");
        r137.c(r138);
    L102:
        if (r135.f251444a == false) goto L121;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L105
        Map<String, Object> r140 = r135.f251445b;     // Catch: Throwable -> L105
        Intrinsics.checkNotNull(r140);     // Catch: Throwable -> L105
        Object r141 = Result.m9449constructorimpl(aa6.c.d(r140));     // Catch: Throwable -> L105
    L108:
        if (Result.m9456isSuccessimpl(r141) == true) goto L110;
        YataStoreWrapper r142 = r104.f251752a;
        if (r142 == null) goto L121;
        YataErrorManager r143 = r142.f();
        if (r143 == null) goto L121;
        com.bytedance.kmp.ec.yata.common.error.d r144 = com.bytedance.kmp.ec.yata.common.error.c.i();
        r144.c("map_to_model_crash");
        r144.m("patch_log_id", r123.f251772b);
        r144.i(Result.m9452exceptionOrNullimpl(r141));
        r144.d("Patch结果转模型Crash");
        r143.c(r144);
        goto L121
    L110:
        if (Result.m9455isFailureimpl(r141) == false) goto L112;
        r141 = null;
    L112:
        aa6.b r145 = (aa6.b) r141;
        if (r145 == null) goto L121;
        r126 = r145;
    L105:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L108
    L89:
        r132 = 0;
        goto L90
    L86:
        r131 = null;
        goto L87
    L126:
        AbsPerfMonitor r147 = r102.f251723g;
        if (r147 == null) goto L129;
        AbsPerfMonitor.c(r147, com.bytedance.kmp.ec.yata.common.perf.c.f251488p);
    L58:
        r116 = new ArrayList();
    L129:
        Map<String, com.bytedance.kmp.ec.yata.common.protocol.data.p> r148 = r115.f251746b.getData();
        if (r148 == null) goto L144;
        Iterator<Map.Entry<String, com.bytedance.kmp.ec.yata.common.protocol.data.p>> r149 = r148.entrySet().iterator();
    L133:
        if (r149.hasNext() == false) goto L144;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r150 = r149.next().getValue();
        Intrinsics.checkNotNullParameter(r150, "<this>");
        Map<String, Object> r151 = r150.h();
        if (r151 != null) goto L137;
    L139:
        boolean r152 = false;
    L140:
        if (r152 == false) goto L133;
        Map<String, Object> r153 = r150.h();
        if (r153 == null) goto L133;
        r153.put("custom", new LinkedHashMap());
        goto L133
    L137:
        if (r151.containsKey("custom") == true) goto L139;
        r152 = true;
    L144:
        com.bytedance.kmp.ec.yata.common.protocol.data.i r154 = r115.f251746b.g();
        if (r154 == null) goto L147;
        String r155 = r154.g();
    L148:
        com.bytedance.kmp.ec.yata.store.node.a r156 = YataReducersKt.d(r155, r115);
        com.bytedance.kmp.ec.yata.common.protocol.data.i r157 = r115.f251746b.g();
        if (r157 == null) goto L151;
        List<String> r158 = r157.e();
    L152:
        List<com.bytedance.kmp.ec.yata.store.node.a> r159 = YataReducersKt.e(r115, r158);
        com.bytedance.kmp.ec.yata.common.protocol.data.i r160 = r115.f251746b.g();
        if (r160 == null) goto L155;
        List<String> r161 = r160.c();
    L156:
        List<com.bytedance.kmp.ec.yata.store.node.a> r162 = YataReducersKt.e(r115, r161);
        if (r156 == null) goto L159;
        RenderTreeStruct r163 = new RenderTreeStruct(r156);
    L160:
        List<com.bytedance.kmp.ec.yata.store.node.a> r164 = r159;
        ArrayList r165 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r164, 10));
        Iterator<T> r166 = r164.iterator();
    L162:
        if (r166.hasNext() == false) goto L164;
        r165.add(new RenderTreeStruct((com.bytedance.kmp.ec.yata.store.node.a) r166.next()));
        goto L162
    L164:
        List<com.bytedance.kmp.ec.yata.store.node.a> r167 = r162;
        ArrayList r168 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r167, 10));
        Iterator<T> r169 = r167.iterator();
    L166:
        if (r169.hasNext() == false) goto L168;
        r168.add(new RenderTreeStruct((com.bytedance.kmp.ec.yata.store.node.a) r169.next()));
        goto L166
    L168:
        ArrayList r170 = new ArrayList();
        r170.add(new e(TreeType.MAIN, CollectionsKt.listOfNotNull(r163)));
        r170.add(new e(TreeType.POPUP, r165));
        r170.add(new e(TreeType.COMMON_NODE, r168));
        r100 = new l(r104.f251752a, r115, r165, r168, r170);
        goto L170
    L159:
        r163 = null;
        goto L160
    L155:
        r161 = null;
        goto L156
    L151:
        r158 = null;
        goto L152
    L147:
        r155 = null;
        goto L148
    L45:
        r107 = new k(r104, r111);
        com.bytedance.kmp.ec.yata.common.protocol.data.i r171 = r107.f251746b.g();
        if (r171 == null) goto L48;
        com.bytedance.kmp.ec.yata.common.protocol.data.j.a(r171);
        goto L48
    L33:
        if (r113 != 2) goto L41;
        Intrinsics.checkNotNullParameter(r111, "overwriteProtocol");
        Intrinsics.checkNotNullParameter(r104, "storeContext");
        if (r107 == null) goto L37;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r107.f251745a = r104;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r107.f251746b = r111;
        goto L48
    L37:
        r107 = new k(r104, r111);
        com.bytedance.kmp.ec.yata.common.protocol.data.i r172 = r107.f251746b.g();
        if (r172 == null) goto L48;
        com.bytedance.kmp.ec.yata.common.protocol.data.j.a(r172);
        goto L48
    L41:
        throw new NoWhenBranchMatchedException();
    L24:
        if (r110 == false) goto L28;
        r111 = r100.a();
        if (r111 != null) goto L30;
    L28:
        if (r106 == false) goto L170;
        r111 = com.bytedance.kmp.ec.yata.common.protocol.data.d.d((com.bytedance.kmp.ec.yata.common.protocol.data.c) r105);
        goto L30
    L18:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.d.b((com.bytedance.kmp.ec.yata.common.protocol.data.c) r105) == false) goto L20;
        r110 = true;
    L170:
        if (Intrinsics.areEqual(r102.f251719c, aa6.a.b.C0039a.f2349b) == false) goto L174;
        AbsPerfMonitor r173 = r102.f251723g;
        if (r173 == null) goto L177;
        AbsPerfMonitor.c(r173, com.bytedance.kmp.ec.yata.common.perf.c.f251486n);
    L177:
        return r100;
    L174:
        AbsPerfMonitor r174 = r102.f251723g;
        if (r174 == null) goto L177;
        AbsPerfMonitor.c(r174, com.bytedance.kmp.ec.yata.common.perf.c.f251487o);
        goto L177
    L7:
        AbsPerfMonitor r175 = r102.f251723g;
        if (r175 == null) goto L10;
        AbsPerfMonitor.d(r175, com.bytedance.kmp.ec.yata.common.perf.c.f251487o);
        goto L10
    }
}
