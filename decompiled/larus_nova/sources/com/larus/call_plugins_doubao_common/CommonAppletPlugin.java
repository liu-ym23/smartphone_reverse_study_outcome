package com.larus.call_plugins_doubao_common;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.audio.call.arch.c;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.v;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public class CommonAppletPlugin<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f321335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommonAppletPlugin$initAppletPayloadChangeListener$1 f321336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f321337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f321338i;

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f321339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonAppletPlugin<C> f321340b;

        @Override // com.larus.im.service.audio.v
        public final String getName() {
            return this.f321339a;
        }

        public a(CommonAppletPlugin<C> r100) {
            this.f321340b = r100;
            this.f321339a = r100.T2();
        }

        @Override // com.larus.im.service.audio.v
        public final void O1(jd9.c r100, jd9.c r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            FLogger.f375446a.i(this.f321340b.T2(), "onConnectionStateChanged status=" + r101);
            if ((r101 instanceof jd9.c.a) == false) goto L5;
            this.f321340b.k3();
            return;
        L5:
            boolean r102 = r101 instanceof jd9.c.d;
        }
    }

    public static final class b implements e78.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C f321341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonAppletPlugin<C> f321342b;

        @Override // e78.b
        public final void a() {
            CoroutineScope r100 = this.f321341a.r();
            if (r100 == null) goto L6;
            BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new CommonAppletPlugin$musicStreamVolumeChangedListener$1$onVolumeChanged$1(this.f321341a, this.f321342b, null), 2, null);
            return;
        }

        public b(C r100, CommonAppletPlugin<C> r101) {
            this.f321341a = r100;
            this.f321342b = r101;
        }
    }

    public void j3(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
    }

    @Override // com.larus.audio.call.arch.a
    public final v R2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        AppletPayloadProviderDelegate.f297130a.a(this.f321336g);
        this.f321336g = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.call_plugins_doubao_common.CommonAppletPlugin$initAppletPayloadChangeListener$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        AppletPayloadProviderDelegate r100 = AppletPayloadProviderDelegate.f297130a;
        r100.a(this.f321336g);
        ?? r101 = new CommonAppletPlugin$initAppletPayloadChangeListener$1(this);
        this.f321336g = r101;
        r100.c(r101);
        GlobalAudioController.f289658a.k(this.f321338i);
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        GlobalAudioController.f289658a.n(this.f321338i);
    }

    public void k3() {
        CoroutineScope r100 = getContext().r();
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new CommonAppletPlugin$onSessionStarted$1(this, null), 2, null);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return this.f321335f;
    }

    public CommonAppletPlugin(C r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f321335f = "CommonAppletPlugin";
        this.f321337h = new ConcurrentHashMap();
        this.f321338i = new b(r100, this);
    }

    @Override // com.larus.call_plugins_doubao_common.i
    public final void updateScreenshotForAsr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tosKey");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        JSONObject r102 = new JSONObject();
        r102.put("image_url", r100);
        r102.put("update_nonstream_context_finish", true);
        JSONObject r103 = new JSONObject();
        r103.put("context_data", r102);
        id9.d r104 = getContext().j();
        if (r104 == null) goto L11;
        jd9.c r105 = r104.state();
    L13:
        if ((r105 instanceof jd9.c.a) == false) goto L18;
        id9.d r106 = getContext().j();
        if (r106 == null) goto L19;
        r106.p(TriggerMode.UPDATE_PERSONAL_CONTEXT, r103.toString());
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r105 = null;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.call_plugins_doubao_common.i
    public final void r1(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (r101 != null) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        j3(r102);
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, String> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue());
        goto L7
    L10:
        if (AppHost.f326268a.a().isAppBackground() == false) goto L12;
        String r105 = "1";
    L13:
        r102.put("is_app_background", r105);
        IVoiceCallService r106 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        jd9.c r107 = null;
        if (r106 == null) goto L16;
        Integer r108 = Integer.valueOf(r106.N());
    L17:
        r102.put("location_permission", String.valueOf(r108));
        r102.put("obric_launch_method", kga.b.a().a());
        ConcurrentHashMap<String, String> r109 = this.f321337h;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator<String> r111 = r102.keys();
    L19:
        if (r111.hasNext() == false) goto L21;
        String r112 = r111.next();
        Intrinsics.checkNotNull(r112);
        r110.put(r112, JSONObjectProtectorUtils.getString(r102, r112));
        goto L19
    L21:
        Map r113 = MapsKt.plus(r109, r110);
        this.f321337h = new ConcurrentHashMap(r113);
        JSONObject r114 = new JSONObject();
        r114.put("applet_payload", new JSONObject(r113));
        FLogger r115 = FLogger.f375446a;
        r115.i(T2(), "updateAppletPayload in " + r100 + " >>>>" + r113);
        String r116 = T2();
        StringBuilder r117 = new StringBuilder("updateContext: ");
        r117.append(r114);
        r115.i(r116, r117.toString());
        id9.d r118 = getContext().j();
        if (r118 == null) goto L25;
        r107 = r118.state();
    L25:
        if ((r107 instanceof jd9.c.a) == false) goto L32;
        id9.d r119 = getContext().j();
        if (r119 == null) goto L33;
        r119.p(TriggerMode.UPDATE_UI_CONTEXT, r114.toString());
        return;
    L33:
        return;
    L32:
        return;
    L16:
        r108 = null;
        goto L17
    L12:
        r105 = "0";
        goto L13
    }
}
