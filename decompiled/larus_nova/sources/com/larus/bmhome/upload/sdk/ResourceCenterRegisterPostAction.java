package com.larus.bmhome.upload.sdk;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenterPostUploadSupport;
import com.larus.bmhome.rc.ResourceRegisterData;
import com.larus.bmhome.rc.ResourceRegisterTraceError;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceCenterRegisterPostAction implements hs8.c {

    public static final class a {
    }

    static {
    }

    public ResourceCenterRegisterPostAction() {
    }

    @Override // hs8.c
    public final boolean a(is8.a r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return r100.f495638c;
    }

    @Override // hs8.c
    public final Object b(hs8.d r410, Continuation<? super hs8.d> r411) {
        if ((r411 instanceof ResourceCenterRegisterPostAction$execute$1) == false) goto L7;
        ResourceCenterRegisterPostAction$execute$1 r100 = (ResourceCenterRegisterPostAction$execute$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ResourceCenterRegisterPostAction$execute$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        String r111 = "fail";
        String r112 = "resource_register";
        Object r113 = "register_type";
        String r114 = "resource_scene";
        if (r104 == 0) goto L22;
        if (r104 != 1) goto L21;
        FlowResourceScene r105 = (FlowResourceScene) r110.L$5;
        String r106 = (String) r110.L$4;
        l r107 = (l) r110.L$3;
        j r108 = (j) r110.L$2;
        String r109 = (String) r110.L$1;
        hs8.d r115 = (hs8.d) r110.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 ResourceUploadError -> L16 ResourceRegisterTraceError -> L18
        FlowResourceScene r116 = r105;
        Object r117 = "api_path";
        Object r118 = "/alice/resource/register";
        String r310 = "resource_scene";
        String r311 = "resource_register";
        r113 = r113;
        char r210 = 1;
        char r211 = 0;
        String r119 = r106;
        Object r120 = r102;
        Object r121 = "api_name";
        l r122 = r107;
    L170:
        ResourceRegisterData r123 = (ResourceRegisterData) r120;     // Catch: Throwable -> L114 ResourceUploadError -> L122 ResourceRegisterTraceError -> L125
        Function1<String, Unit> r124 = r108.f515019u;     // Catch: Throwable -> L114 ResourceUploadError -> L116 ResourceRegisterTraceError -> L119
        if (r124 != null) goto L183;
    L60:
        ms8.b r312 = ms8.b.f515490a;     // Catch: Throwable -> L114 ResourceUploadError -> L122 ResourceRegisterTraceError -> L125
        Pair[] r125 = new Pair[4];     // Catch: Throwable -> L114 ResourceUploadError -> L122 ResourceRegisterTraceError -> L125
        r114 = r310;
        r125[r211] = TuplesKt.to(r114, r116.name());     // Catch: Throwable -> L107 ResourceUploadError -> L109 ResourceRegisterTraceError -> L111
        r113 = r113;
        r125[r210] = TuplesKt.to(r113, "normal_after_upload");     // Catch: Throwable -> L99 ResourceUploadError -> L102 ResourceRegisterTraceError -> L105
        r112 = r311;
        r111 = "fail";
        r125[2] = TuplesKt.to(r121, r112);     // Catch: Throwable -> L87 ResourceUploadError -> L89 ResourceRegisterTraceError -> L91
        r117 = r117;
        r118 = r118;
        r125[3] = TuplesKt.to(r117, r118);     // Catch: Throwable -> L79 ResourceUploadError -> L85 ResourceRegisterTraceError -> L91
    L177:
        ms8.b.c(r312, r108, "resource_register", "success", null, MapsKt.mapOf(r125), 8);     // Catch: Throwable -> L79 ResourceUploadError -> L81 ResourceRegisterTraceError -> L83
        ResourceRegisterData r126 = (ResourceRegisterData) r120;     // Catch: Throwable -> L79 ResourceUploadError -> L81 ResourceRegisterTraceError -> L83
        String r127 = r126.getResourceId();
        String r128 = r126.getAliasName();
        FLogger.f375446a.i("ResourceCenterPostAction", "[register] success, identifier=" + r109 + ", tosKey=" + r119 + ", resourceId=" + r127 + ", aliasName=" + r128 + ", scene=" + r116);
        ConcurrentHashMap<String, j> r129 = g.f314834a;
        l r130 = l.a(r122, null, r128, r127, 121);
        Intrinsics.checkNotNullParameter(r109, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r130, "result");
        g.f314836c.put(r109, r130);
        Map<String, String> r131 = r115.f487077e;
        Pair[] r132 = new Pair[2];
        r132[r211] = TuplesKt.to(r114, r116.name());
        if (r127 != null) goto L76;
        String r133 = "";
    L77:
        r132[r210] = TuplesKt.to("resource_id", r133);
        Map r134 = MapsKt.plus(r131, MapsKt.mapOf(r132));
        is8.g r135 = r115.f487073a;
        is8.a r136 = r115.f487074b;
        hs8.a r137 = r115.f487075c;
        Intrinsics.checkNotNullParameter(r135, "request");
        Intrinsics.checkNotNullParameter(r136, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r137, "engineResult");
        Intrinsics.checkNotNullParameter(r134, "attributes");
        return new hs8.d(r135, r136, r137, r127, r134);
    L76:
        r133 = r127;
        goto L77
    L83:
        e = e;
    L127:
        FlowResourceScene r138 = r116;
    L135:
        r116 = r138;
    L136:
        String r139 = r111;
    L163:
        ms8.b r140 = ms8.b.f515490a;
        ResourceUploadError r141 = e.getUploadError();
        Pair[] r142 = new Pair[2];
        r142[r211] = TuplesKt.to(r114, r116.name());
        r142[r210] = TuplesKt.to(r113, "normal_after_upload");
        Map r143 = MapsKt.plus(MapsKt.mapOf(r142), e.getTraceExtra());
        r140.getClass();
        ms8.b.b(r108, r112, r139, r141, r143);
        throw e.getUploadError();
    L81:
        e = e;
    L118:
        j r144 = r108;
    L145:
        FlowResourceScene r145 = r116;
        r108 = r144;
    L146:
        r116 = r145;
    L124:
        String r146 = r111;
    L158:
        ms8.b r147 = ms8.b.f515490a;
        Pair[] r148 = new Pair[4];
        r148[r211] = TuplesKt.to(r114, r116.name());
        r148[r210] = TuplesKt.to(r113, "normal_after_upload");
        r148[2] = TuplesKt.to(r121, r112);
        r148[3] = TuplesKt.to(r117, r118);
        Map r149 = MapsKt.mapOf(r148);
        r147.getClass();
        ms8.b.b(r108, r112, r146, e, r149);
        throw e;
    L85:
        e = e;
    L79:
        th = th;
    L121:
        r105 = r116;
    L150:
        String r150 = th.getMessage();
        if (r150 != null) goto L153;
        r150 = "";
    L153:
        ResourceUploadError r151 = new ResourceUploadError(ResourceUploadError.REGISTER_ERROR, r150);
        ms8.b r152 = ms8.b.f515490a;
        Pair[] r153 = new Pair[6];
        r153[r211] = TuplesKt.to(r114, r105.name());
        r153[r210] = TuplesKt.to(r113, "normal_after_upload");
        r153[2] = TuplesKt.to(r121, r112);
        r153[3] = TuplesKt.to(r117, r118);
        r153[4] = TuplesKt.to("error_type", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        r153[5] = TuplesKt.to("fail_reason", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Map r154 = MapsKt.mapOf(r153);
        r152.getClass();
        ms8.b.b(r108, r112, r111, r151, r154);
        throw r151;
    L91:
        e = e;
    L89:
        e = e;
    L90:
        r117 = r117;
        r118 = r118;
    L87:
        th = th;
    L88:
        r117 = r117;
        r118 = r118;
        goto L121
    L97:
        e = e;
        r111 = "fail";
    L95:
        e = e;
        r111 = "fail";
    L93:
        th = th;
        r111 = "fail";
        goto L88
    L105:
        e = e;
        r111 = "fail";
        r112 = r311;
    L102:
        e = e;
    L104:
        r112 = r311;
    L99:
        th = th;
    L101:
        r112 = r311;
        goto L121
    L111:
        e = e;
    L113:
        r112 = r311;
    L109:
        e = e;
        r113 = r113;
    L107:
        th = th;
        r113 = r113;
        goto L101
    L183:
        r124.invoke("register_finished");     // Catch: Throwable -> L54 ResourceUploadError -> L56 ResourceRegisterTraceError -> L58
    L58:
        e = e;
        r139 = "fail";
        r113 = r113;
        r114 = r310;
        r112 = r311;
    L56:
        e = e;
        r146 = "fail";
        r117 = r117;
        r118 = r118;
        r113 = r113;
        r114 = r310;
        r112 = r311;
    L54:
        th = th;
        r105 = r116;
        r111 = "fail";
        r117 = r117;
        r118 = r118;
        r113 = r113;
        r114 = r310;
        r112 = r311;
        goto L150
    L119:
        e = e;
        r111 = "fail";
        r113 = r113;
        r114 = r310;
        r112 = r311;
    L116:
        e = e;
        r111 = "fail";
        r117 = r117;
        r118 = r118;
        r113 = r113;
        r114 = r310;
        r112 = r311;
    L114:
        th = th;
        r113 = r113;
        r114 = r310;
    L125:
        e = e;
        r114 = r310;
    L122:
        e = e;
        r113 = r113;
        r114 = r310;
        goto L104
    L18:
        e = e;
        r116 = r105;
        r139 = "fail";
        r113 = r113;
        r210 = 1;
        r211 = 0;
    L16:
        e = e;
        r116 = r105;
        r121 = "api_name";
        r118 = "/alice/resource/register";
        r146 = "fail";
        r210 = 1;
        r211 = 0;
        r117 = "api_path";
        r113 = r113;
    L14:
        th = th;
        r121 = "api_name";
        r118 = "/alice/resource/register";
        r111 = "fail";
        r210 = 1;
        r211 = 0;
        r117 = "api_path";
        r113 = r113;
        goto L150
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r102);
        String r155 = r410.f487073a.f495672c.f495650f;
        ConcurrentHashMap<String, j> r156 = g.f314834a;
        Intrinsics.checkNotNullParameter(r155, LocationMonitorConst.IDENTIFIER);
        j r157 = g.f314834a.get(r155);
        if (r157 != null) goto L25;
        return r410;
    L25:
        Intrinsics.checkNotNullParameter(r155, LocationMonitorConst.IDENTIFIER);
        l r158 = g.f314836c.get(r155);
        if (r158 != null) goto L28;
        return r410;
    L28:
        String r159 = r158.f515022a;
        if (r159 != null) goto L31;
        return r410;
    L31:
        r116 = e.a(r410.f487073a, r157.f515010l);
        r157.f515013o.f514998e.invoke();
        Function1<String, Unit> r160 = r157.f515019u;
        if (r160 == null) goto L34;
        r160.invoke("register_started");
    L34:
        r114 = "resource_scene";
        r157.f515003e.invoke(new k(Boxing.boxLong(99), false));
        ms8.b.f515490a.getClass();
        ms8.b.i(r157, "resource_register");
        ResourceCenterPostUploadSupport r161 = ResourceCenterPostUploadSupport.f313547a;     // Catch: Throwable -> L137 ResourceUploadError -> L155 ResourceRegisterTraceError -> L160
        mr9.h r162 = r157.f515013o;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        UplinkFileEntity r163 = r162.f514996c;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        ResourceAttachmentExtra r164 = r162.f514995b;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        FlowResourceScene.Companion.getClass();     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        String r212 = FlowResourceScene.a.b(r116);     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        String r165 = r157.f515010l;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        FlowResourceType r213 = com.larus.bmhome.upload.a.a(r157);     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        Long r166 = r157.f515018t;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
    L43:
        r110.L$0 = r410;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r110.L$1 = r155;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r110.L$2 = r157;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r110.L$3 = r158;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r110.L$4 = r159;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r110.L$5 = r116;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r110.label = 1;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r121 = "api_name";
        r117 = "api_path";
        r118 = "/alice/resource/register";
        r210 = 1;
        j r214 = r157;
        r211 = 0;
        r113 = r113;
        r310 = r114;
        r311 = "resource_register";
        r120 = ResourceCenterPostUploadSupport.b(r158, r163, r164, r212, r165, r213, null, r166, r110, 64);     // Catch: Throwable -> L128 ResourceUploadError -> L130 ResourceRegisterTraceError -> L132
        if (r120 != r103) goto L48;
        return r103;
    L48:
        r115 = r410;
        r119 = r159;
        r122 = r158;
        r108 = r214;
        r109 = r155;
        goto L170
    L132:
        e = e;
        r113 = r113;
        r114 = r310;
        r112 = r311;
    L134:
        r138 = r116;
        r108 = r214;
    L130:
        e = e;
        r117 = r117;
        r118 = r118;
        r113 = r113;
        r114 = r310;
        r112 = r311;
        r146 = "fail";
    L157:
        r108 = r214;
    L128:
        th = th;
        r117 = r117;
        r118 = r118;
        r113 = r113;
        r114 = r310;
        r112 = r311;
    L149:
        r105 = r116;
        r108 = r214;
        goto L150
    L141:
        e = e;
        r210 = 1;
        r211 = 0;
        r139 = "fail";
    L162:
        r108 = r157;
    L139:
        e = e;
        r111 = "fail";
        r113 = r113;
        r121 = "api_name";
        r117 = "api_path";
        r114 = r114;
        r118 = "/alice/resource/register";
        r210 = 1;
        r211 = 0;
        r145 = r116;
        r108 = r157;
    L147:
        e = e;
        r214 = r157;
        r113 = r113;
        r114 = r114;
        r210 = 1;
        r211 = 0;
    L143:
        e = e;
        r111 = "fail";
        r113 = r113;
        r121 = "api_name";
        r117 = "api_path";
        r114 = r114;
        r118 = "/alice/resource/register";
        r210 = 1;
        r211 = 0;
        r144 = r157;
        goto L145
    L137:
        th = th;
        r113 = r113;
        r121 = "api_name";
        r117 = "api_path";
        r114 = r114;
        r118 = "/alice/resource/register";
        r210 = 1;
        r211 = 0;
        r214 = r157;
    L160:
        e = e;
        r139 = "fail";
        r210 = 1;
        r211 = 0;
    L155:
        e = e;
        r146 = "fail";
        r113 = r113;
        r121 = "api_name";
        r117 = "api_path";
        r114 = r114;
        r118 = "/alice/resource/register";
        r210 = 1;
        r211 = 0;
        r214 = r157;
    L7:
        r100 = new ResourceCenterRegisterPostAction$execute$1(this, r411);
        goto L8
    }
}
