package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.model.bean.SetBgmFunctionType;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.p;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvMusicPlayer implements com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b {
    public final SetBgmFunctionType a;
    public MusicPanel b;
    public long c;
    public boolean d;
    public final g e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final CompositeDisposable j;
    public final d k;
    public final j1 l;

    public static final class a {
    }

    public static final class b {
        public final /* synthetic */ KtvMusicPlayer a;

        public b(KtvMusicPlayer r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void release() {
        this.b = null;
        this.j.clear();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "resetMusic");
        a();
        a();
        a();
        g r0 = this.e;
        r0.a();
        r0.a.clear();
    }

    public final void a() {
        j1 r0 = this.l;
        if (r0 == null) goto L14;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L15;
        hg6.g r2 = r1.getRtcManager();
        if (r2 == null) goto L16;
        ec6.b r3 = r2.R();
        if (r3 == null) goto L17;
        com.bytedance.android.live.pushstream.d r4 = gc6.b.a(r3);
        if (r4 == null) goto L18;
        r4.u();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void o() {
        Intrinsics.checkNotNullParameter("", "path");
        Intrinsics.checkNotNullParameter("", "name");
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void pause() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "pause");
        a();
        if (vm2.h.d() == false) goto L5;
        a();
    L5:
        UtilityKotlinExtentionsKt.b(this, AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void resume() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "resume");
        a();
        if (vm2.h.d() == false) goto L5;
        a();
    L5:
        UtilityKotlinExtentionsKt.b(this, C02351.INSTANCE);
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void n() {
        if (vm2.h.d() == false) goto L5;
        a();
        return;
    L5:
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void f() {
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void j() {
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final boolean m() {
        return this.d;
    }

    public final void b(Map<String, com.bytedance.android.live.ktv.common.model.bean.f> r11) {
        if (r11.isEmpty() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; map is empty");
        return;
    L7:
        if (this.f == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; hasSetBGMMusicWithAllResource");
        this.k.n().setValue(new LinkedHashMap());
        return;
    L10:
        MusicPanel r0 = this.k.a();
        if (r0 != null) goto L13;
        return;
    L13:
        com.bytedance.android.live.ktv.common.model.bean.f r12 = r11.get(KtvUtilsKt.c(r0));
        if (r12 != null) goto L17;
        return;
    L17:
        if (r12.a == DownloadResourceType.OTHER_RESOURCE) goto L19;
        return;
    L19:
        if (r12.b == false) goto L21;
        return;
    L21:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r0) == false) goto L50;
        boolean r4 = true;
        if (this.g == true) goto L34;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithMainResource ;; " + r12);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicWithMainResource ;; song_id == " + r0.a.getMId());
        this.g = true;
        Intrinsics.checkNotNullParameter(r0, "$this$isRealOriginFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r0.n) == false) goto L27;
        a();
        boolean r2 = this.d;
    L32:
        i(r2, false);
        goto L34
    L27:
        Intrinsics.checkNotNullParameter(r0, "$this$isRealAccompanimentFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r0.o) == false) goto L30;
        a();
    L31:
        r2 = false;
        goto L32
    L30:
        mb0.f.o(r0);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "music file path not exists ");
        c("music_path_not_exist_source");
    L34:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.q(r0) == false) goto L54;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithAllResource ;; " + r12);
        this.k.n().setValue(new LinkedHashMap());
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicWithAllResource ;; song_id == " + r0.a.getMId() + " startTime " + this.c);
        this.f = true;
        long r1 = r0.c();
        int r13 = e.a[r0.h().ordinal()];
        if (r13 != 1) goto L38;
        a();
        r4 = this.d;
        pd2.d.L(pd2.d.n, r1, "set_bgm");
    L49:
        i(r4, false);
        return;
    L38:
        if (r13 != 2) goto L40;
        a();
        pd2.d.L(pd2.d.n, r1, "set_bgm");
        goto L49
    L40:
        if (r13 != 3) goto L42;
        a();
        pd2.d.L(pd2.d.n, r1, "set_bgm");
    L46:
        r4 = false;
        goto L49
    L42:
        if (r13 != 4) goto L46;
        c("music_path_not_exist_source");
        f2.c(s1.B(2131918394), 0);
        pd2.d.v(LinkMonitorData.BusinessSetBgmFailed, MapsKt.mapOf(TuplesKt.to("reason", "both of origin and accompaniment are empty")));
        mb0.f.p(r0, "both of origin and accompaniment are empty");
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "both of origin and accompaniment are empty.");
        pd2.d.L(pd2.d.n, r1, "error");
        goto L46
    L54:
        return;
    L50:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; curMusicPanel == " + r0 + " ;; curProgress== " + this.c + " ;; isSupportOriginSwitchWithPath == " + com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r0) + " ;; " + r12);
    }

    public final void c(String r3) {
        if (this.h == false) goto L5;
        return;
    L5:
        if (this.i == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "resetMusic");
        a();
    L7:
        this.h = true;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "on stop bgm");
        if (Intrinsics.areEqual(r3, "live_core_stop_music_callback_source") == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "livecore stop");
        int r4 = mb0.f.a;
        mb0.f.d(this.b);
    L10:
        this.c = 0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void g(double[] r3) {
        Intrinsics.checkNotNullParameter(r3, "scoreInfo");
        a();
        vm2.h.d();
        if (r3.length >= 21) goto L5;
        return;
    L5:
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        p r1 = (p) r0.getRealTimeInfoModel().getValue();
        if (r1 != null) goto L8;
        return;
    L8:
        m<p> r2 = r0.getRealTimeInfoModel();
        r1.a(r3);
        r2.setValue(r1);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void k(JsonObject r17) {
        g r2 = this.e;
        r2.getClass();
        Boolean r3 = null;
        if (r17 == null) goto L7;
        JsonElement r4 = r17.get("name");
        if (r4 == null) goto L7;
        String r5 = r4.getAsString();
    L8:
        if (r17 == null) goto L12;
        JsonElement r6 = r17.get("icon");
        if (r6 == null) goto L12;
        String r7 = r6.getAsString();
    L13:
        if (r17 == null) goto L17;
        JsonElement r8 = r17.get("title");
        if (r8 == null) goto L17;
        String r9 = r8.getAsString();
    L18:
        if (r17 == null) goto L22;
        JsonElement r10 = r17.get("conf");
        if (r10 == null) goto L22;
        String r11 = r10.getAsString();
    L23:
        if (r17 == null) goto L27;
        JsonElement r12 = r17.get("version");
        if (r12 == null) goto L27;
        Integer r13 = Integer.valueOf(r12.getAsInt());
    L28:
        if (r17 == null) goto L33;
        JsonElement r1 = r17.get("isSelected");
        if (r1 == null) goto L33;
        r3 = Boolean.valueOf(r1.getAsBoolean());
    L33:
        if (r5 != null) goto L35;
        String r14 = "";
    L36:
        if (r9 != null) goto L38;
        String r15 = "";
    L39:
        int r16 = qy.a.a;
        if (r7 != null) goto L42;
        r7 = "";
    L42:
        py.k r18 = qy.a.a(r7);
        if (r11 != null) goto L45;
        r11 = "";
    L45:
        py.k r19 = qy.a.a(r11);
        if (r13 == null) goto L48;
        int r110 = r13.intValue();
    L49:
        if (r3 == null) goto L51;
        boolean r20 = r3.booleanValue();
    L52:
        com.bytedance.android.live.ktv.common.model.bean.h r21 = new com.bytedance.android.live.ktv.common.model.bean.h(r14, r15, r18, r19, r110, r20);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("TuningEffectManager", "downloadTuningEffect tuningEffectItem: " + r21);
        k r22 = new k(r2, r21);
        if (r21.g() == false) goto L55;
        r22.a("");
        return;
    L55:
        RxUtilKt.c(Single.create(new h(r2, r21)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r22), new j(r22)), r2.a);
        return;
    L51:
        r20 = false;
        goto L52
    L48:
        r110 = -1;
        goto L49
    L38:
        r15 = r9;
        goto L39
    L35:
        r14 = r5;
    L27:
        r13 = null;
    L22:
        r11 = null;
    L17:
        r9 = null;
    L12:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void l(com.bytedance.android.livesdk.ktvimpl.crossplatform.player.a r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        MusicPanel r0 = this.k.a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.a.isSameKtvMusicByIdStr(r7.a) == true) goto L8;
        return;
    L8:
        this.b = r0;
        KtvMusic r1 = r0.a;
        long r2 = r7.d;
        Long r8 = r7.e;
        if (r2 != 0) goto L11;
        KtvMusic.Companion.getClass();
        r2 = KtvMusic.a.c(r1);
    L11:
        if (r8 == null) goto L13;
        long r3 = r8.longValue();
    L14:
        Pair r9 = new Pair(Long.valueOf(r2), Long.valueOf(r3));
        ((Number) r9.component1()).longValue();
        ((Number) r9.component2()).longValue();
        a();
        return;
    L13:
        KtvMusic.Companion.getClass();
        r3 = KtvMusic.a.a(r1);
        goto L14
    }

    public KtvMusicPlayer(d r2, j1 r3) {
        Intrinsics.checkNotNullParameter(r2, "runContext");
        this.k = r2;
        this.l = r3;
        this.a = SetBgmFunctionType.MULTI_KTV;
        Long r0 = (Long) KtvSettingHelper.H0.getValue();
        this.d = KtvUtilsKt.b(true, 1);
        this.e = new g(r3);
        CompositeDisposable r4 = new CompositeDisposable();
        this.j = r4;
        new b(this);
        b((Map) r2.n().getValue());
        Disposable r5 = r2.n().a().subscribe(new f(this));
        if (r5 == null) goto L6;
        RxUtilKt.c(r5, r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void i(boolean r1, boolean r2) {
        this.d = r1;
        a();
        if (r2 == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.h;
        if (r1 == false) goto L7;
        int r4 = 1;
    L8:
        Integer r5 = Integer.valueOf(r4);
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r5);
        goto L9
    L7:
        r4 = 2;
    L9:
        MusicPanel r6 = this.b;
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.a == null) goto L16;
        a();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void p(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "midiPath");
        Intrinsics.checkNotNullParameter(r3, "lyricsPath");
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void h(String r1, String r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "midiPath");
        Intrinsics.checkNotNullParameter(r2, "lyricsPath");
        Intrinsics.checkNotNullParameter(r1, "midiPath");
        Intrinsics.checkNotNullParameter(r2, "lyricsPath");
        p(r1, r2);
    }
}
