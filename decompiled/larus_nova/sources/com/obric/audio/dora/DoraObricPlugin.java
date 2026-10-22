package com.obric.audio.dora;

import com.bytedance.keva.Keva;
import com.larus.avlink.plugins.o4;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.m;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.obric.assistant.t1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import pf9.o;
import pf9.z;

/* JADX INFO: loaded from: classes33.dex */
public final class DoraObricPlugin extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements o4 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<String> f395381p = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f395382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f395383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f395384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f395385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f395386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Keva f395387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f395388l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f395389m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f395390n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.obric.audio.dora.a f395391o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f395393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f395394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f395395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f395396e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f395397f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f395398g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f395399h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f395392a == r101.f395392a) goto L12;
            return false;
        L12:
            if (this.f395393b == r101.f395393b) goto L15;
            return false;
        L15:
            if (this.f395394c == r101.f395394c) goto L18;
            return false;
        L18:
            if (this.f395395d == r101.f395395d) goto L21;
            return false;
        L21:
            if (this.f395396e == r101.f395396e) goto L24;
            return false;
        L24:
            if (this.f395397f == r101.f395397f) goto L27;
            return false;
        L27:
            if (this.f395398g == r101.f395398g) goto L30;
            return false;
        L30:
            if (this.f395399h == r101.f395399h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f395392a * 31;
            int r101 = 1231;
            if (this.f395393b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f395394c == true) goto L11;
            r101 = 1237;
        L11:
            return ((((((((((r103 + r101) * 31) + this.f395395d) * 31) + this.f395396e) * 31) + this.f395397f) * 31) + this.f395398g) * 31) + this.f395399h;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "RuntimeContextSettingsSnapshot(autoGuiEnabledScene=" + this.f395392a + ", localDataSearchEnabled=" + this.f395393b + ", lockedScreenUseEnabled=" + this.f395394c + ", autoGuiExecuteOnLockScreenAuthType=" + this.f395395d + ", chatAndOnlineQAOnLockScreenAuthType=" + this.f395396e + ", localAppDataAccessOnLockScreenAuthType=" + this.f395397f + ", chatHistoryAccessOnLockScreenAuthType=" + this.f395398g + ", simpleCommandExecuteOnLockScreenAuthType=" + this.f395399h + ')';
        }

        public b(int r100, boolean r101, boolean r102, int r103, int r104, int r105, int r106, int r107) {
            this.f395392a = r100;
            this.f395393b = r101;
            this.f395394c = r102;
            this.f395395d = r103;
            this.f395396e = r104;
            this.f395397f = r105;
            this.f395398g = r106;
            this.f395399h = r107;
        }
    }

    public static final class c extends z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f395400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DoraObricPlugin f395401b;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            return this.f395400a;
        }

        public c(DoraObricPlugin r100) {
            this.f395401b = r100;
            this.f395400a = r100.f395382f;
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof z) == false) goto L6;
            DoraObricPlugin r101 = this.f395401b;
            long r102 = ((z) r100).f528982c;
            r101.f395384h = r102;
            r101.f395386j = false;
            r101.m3(r102, false);
            return;
        L6:
            if ((r100 instanceof o) == false) goto L12;
            DoraObricPlugin r103 = this.f395401b;
            r103.f395385i = true;
            if ((!v88.a.b(Integer.valueOf(r103.getContext().params().f288751k.f288830s))) == false) goto L13;
            this.f395401b.l3();
            this.f395401b.m3(0, true);
            return;
        L13:
            return;
        }
    }

    public static final class d implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraObricPlugin f395403a;

        public d(DoraObricPlugin r100) {
            this.f395403a = r100;
        }

        @Override // com.obric.assistant.m
        public final void a(String r100) {
            if (r100 != null) goto L4;
        L6:
            this.f395403a.j3(r100);
            return;
        L4:
            if (DoraObricPlugin.f395381p.contains(r100) == true) goto L6;
        }
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r100) {
    }

    static {
        f395381p = SetsKt.setOf(new String[]{"auto_gui_enable_scene_2025_1225", "locked_screen_use_enabled", "authentication_type_of_auto_gui_execute_on_lock_screen", "authentication_type_of_chat_and_online_qa_on_lock_screen", "authentication_type_of_local_app_data_access_on_lock_screen", "authentication_type_of_chat_history_access_on_lock_screen", "authentication_type_of_simple_command_execute_on_lock_screen"});
    }

    public static b k3() {
        t1 r100 = t1.f393353a;
        return new b(r100.getAutoGuiEnabledScene(), ObricPersonalContextSettingApiDelegate.f391714b.q(), r100.i(), r100.e1(), r100.k1(), r100.v0(), r100.Q1(), r100.W());
    }

    @Override // com.larus.audio.call.arch.a
    public final z0 S2() {
        return new c(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        t1.f393353a.S0(this.f395390n);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        Keva r101 = this.f395387k;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.unRegisterChangeListener(this.f395391o);     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L14;
        FLogger.f375446a.w(this.f395382f, "unRegister localDataSearchChangedListener failed", r104);
    L14:
        this.f395387k = null;
        Job r105 = this.f395389m;
        if (r105 == null) goto L17;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L17:
        this.f395389m = null;
        Job r106 = this.f395383g;
        if (r106 == null) goto L20;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L20:
        this.f395383g = null;
        this.f395388l = null;
        this.f395385i = false;
        super.g3();
        return;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void l3() {
        IObricDoraService r100 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r100 == null) goto L5;
        JSONObject r101 = r100.c();
    L6:
        if (r101 == null) goto L12;
        id9.d r102 = getContext().j();
        if (r102 == null) goto L10;
        r102.p(TriggerMode.UPDATE_PERSONAL_CONTEXT, r101.toString());
    L10:
        FLogger.f375446a.i(this.f395382f, "trigger UPDATE_PERSONAL_CONTEXT, personalContext=" + r101);
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        Job r100 = this.f395383g;
        Object r101 = null;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        i1<Boolean> r102 = ObricAssistantForAudioDelegate.f385669b.c5();
        if (r102 == null) goto L10;
        CoroutineScope r103 = getContext().r();
        if (r103 == null) goto L10;
        Job r104 = BuildersKt.launch$default(r103, null, null, new DoraObricPlugin$collectSpecialInputOpenState$1$1(r102, this, null), 3, null);
    L11:
        this.f395383g = r104;
        if (r104 != null) goto L14;
        FLogger.f375446a.w(this.f395382f, "collectSpecialInputOpenState skipped, stateFlow or lifecycleScope is null");
    L14:
        this.f395388l = k3();
        t1.f393353a.B0(this.f395390n);
        Keva r105 = this.f395387k;
        if (r105 == null) goto L38;
        r105.unRegisterChangeListener(this.f395391o);
    L38:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L23
        Object r107 = ObricPersonalContextSettingApiDelegate.f391714b.a();     // Catch: Throwable -> L23
        if ((r107 instanceof Keva) == false) goto L20;
        Keva r108 = (Keva) r107;     // Catch: Throwable -> L23
    L21:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L23
    L25:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L29;
        FLogger.f375446a.w(this.f395382f, "registerLocalDataSearchSettingListener failed", r110);
    L29:
        if (Result.m9455isFailureimpl(r109) == true) goto L32;
        r101 = r109;
    L32:
        Keva r111 = (Keva) r101;
        if (r111 != null) goto L35;
        FLogger.f375446a.w(this.f395382f, "registerLocalDataSearchSettingListener skipped, keva is null");
    L36:
        FLogger.f375446a.i(this.f395382f, "registerRuntimeContextSettingListener, initialSnapshot=" + this.f395388l);
        return;
    L35:
        this.f395387k = r111;
        r111.registerChangeListener(this.f395391o);
        goto L36
    L20:
        r108 = null;
    L23:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f395382f;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.audio.dora.a] */
    public DoraObricPlugin(com.larus.audio.call.arch.c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f395382f = "DoraObricPlugin";
        this.f395390n = new d(this);
        this.f395391o = new com.obric.audio.dora.a(this);
    }

    public final void j3(String r100) {
        CoroutineScope r101 = getContext().r();
        if (r101 != null) goto L6;
        FLogger.f375446a.w(this.f395382f, "skip checkRuntimeContextSettingsChangedWithDebounce, lifecycleScope is null, key=" + r100);
        return;
    L6:
        Job r102 = this.f395389m;
        if (r102 == null) goto L9;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L9:
        this.f395389m = BuildersKt.launch$default(r101, null, null, new DoraObricPlugin$checkRuntimeContextSettingsChangedWithDebounce$1(this, r100, null), 3, null);
    }

    public final void n3(long r100) {
        IObricDoraService r101 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r101 == null) goto L14;
        Map<String, String> r102 = r101.a(r100, true);
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.isEmpty() == true) goto L16;
        JSONObject r103 = new JSONObject();
        r103.put("o_runtime_ctx", new JSONObject(r102).toString());
        id9.d r104 = getContext().j();
        if (r104 == null) goto L12;
        TriggerMode r105 = TriggerMode.UPDATE_UI_CONTEXT;
        JSONObject r106 = new JSONObject();
        r106.put("applet_payload", r103);
        Unit r107 = Unit.INSTANCE;
        r104.p(r105, r106.toString());
    L12:
        FLogger.f375446a.i(this.f395382f, "trigger UPDATE_UI_CONTEXT");
        return;
    L16:
        return;
    }

    public final void m3(long r100, boolean r101) {
        IObricDoraService r102 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r102 == null) goto L14;
        Map<String, String> r103 = r102.a(r100, r101);
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.isEmpty() == true) goto L16;
        JSONObject r104 = new JSONObject();
        r104.put("round_id", r100);
        JSONObject r105 = new JSONObject();
        r105.put("o_round_ctx", new JSONObject(r103).toString());
        Unit r106 = Unit.INSTANCE;
        r104.put("params", r105);
        id9.d r107 = getContext().j();
        if (r107 == null) goto L12;
        r107.p(TriggerMode.UPDATE_ROUND_CONTEXT, r104.toString());
    L12:
        FLogger.f375446a.i(this.f395382f, "trigger UPDATE_ROUND_CONTEXT");
        return;
    L16:
        return;
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        Intrinsics.checkNotNullParameter(r100, "caller");
        if ((!v88.a.b(Integer.valueOf(getContext().params().f288751k.f288830s))) == true) goto L6;
        l3();
        n3(this.f395384h);
        return;
    }
}
