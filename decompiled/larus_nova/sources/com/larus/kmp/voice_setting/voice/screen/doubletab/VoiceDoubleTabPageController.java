package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.SpeakerVoice;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class VoiceDoubleTabPageController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f354106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e5 f354107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<CoroutineScope> f354108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f354109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f354110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Long> f354111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<String, Unit> f354112g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<String, Unit> f354113h;

    public final void d(com.larus.kmp.voice_setting.voice.component.v4 r210) {
        Intrinsics.checkNotNullParameter(r210, "args");
        e5 r100 = this.f354107b;
        i4 r101 = this.f354106a;
        int r110 = r101.f354370d;
        int r102 = r101.f354369c.size();
        CoroutineScope r111 = this.f354108c.invoke();
        Function1 r103 = new c5(this);
        Function0 r104 = new d5(this);
        VoiceDoubleTabPageController$schedulePageOwnerAttach$3 r105 = new VoiceDoubleTabPageController$schedulePageOwnerAttach$3(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "args");
        Intrinsics.checkNotNullParameter(r111, "scope");
        Intrinsics.checkNotNullParameter(r103, "isCurrentArgs");
        Intrinsics.checkNotNullParameter(r104, "currentArgsHash");
        Intrinsics.checkNotNullParameter(r105, "attachPageOwner");
        int r106 = r100.f354273b;
        if (r106 > 0) goto L6;
        r100.f354272a.invoke("[entryPerf:ownerAttach:schedule] skip offscreenLimit=" + r100.f354273b + " ownerCount=" + r102);
        return;
    L6:
        if (r102 > 0) goto L9;
        List r107 = CollectionsKt.emptyList();
    L8:
        List r112 = r107;
        if (r112.isEmpty() == false) goto L24;
        r100.f354272a.invoke("[entryPerf:ownerAttach:schedule] skip empty owners");
        return;
    L24:
        Job r108 = r100.f354274c;
        if (r108 == null) goto L27;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L27:
        r100.f354274c = BuildersKt.launch$default(r111, null, null, new VoiceDoubleTabPageOwnerCoordinator$scheduleAttach$1(r112, r100, r103, r210, r104, r105, null), 3, null);
        r100.f354272a.invoke("[entryPerf:ownerAttach:schedule] selectedIndex=" + r110 + " order=" + CollectionsKt.joinToString$default(r112, null, null, null, 0, null, null, 63, null));
        return;
    L9:
        int r109 = r102 - 1;
        int r113 = RangesKt.coerceIn(r110, 0, r109);
        int r114 = RangesKt.coerceIn(r106, 0, r109);
        List r115 = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(r113)});
        if (r114 <= 0) goto L20;
        if (1 > r114) goto L20;
        int r116 = 1;
    L13:
        int r117 = r113 - r116;
        int r118 = r113 + r116;
        if (r117 < 0) goto L16;
        r115.add(Integer.valueOf(r117));
    L16:
        if (r118 >= r102) goto L18;
        r115.add(Integer.valueOf(r118));
    L18:
        if (r116 == r114) goto L20;
        r116 = r116 + 1;
    L20:
        r107 = CollectionsKt.distinct(r115);
        goto L8
    }

    public static final void c(Map<String, SpeakerVoice> r100, SpeakerVoice r101) {
        String r102 = r101.getId();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if ((!StringsKt.isBlank(r102)) == false) goto L9;
        r100.put(r102, r101);
        return;
    }

    public static boolean e(g5 r100, com.larus.kmp.voice_setting.voice.feature.l r101) {
        String r102 = r100.a();
        if (Intrinsics.areEqual(r102, "my") == false) goto L10;
        if (r101.f353329d == false) goto L7;
        return true;
    L7:
        if ((!r101.f353327b.isEmpty()) == true) goto L17;
    L14:
        return false;
    L17:
        return true;
    L10:
        if (Intrinsics.areEqual(r102, "recommend") == false) goto L14;
        if (r101.f353342q == null) goto L14;
        return true;
    }

    public final void b(int r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        g5 r101 = (g5) CollectionsKt.getOrNull(this.f354106a.f354369c, r100);
        if (r101 != null) goto L5;
        return;
    L5:
        e5 r102 = this.f354107b;
        String r103 = r101.a();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "tabKey");
        if (r102.f354275d.add(r103) == true) goto L9;
        this.f354112g.invoke("[entryPerf:ownerAttach:skip] reason=" + r110 + " pageIndex=" + r100 + " tab=" + r101.a());
        return;
    L9:
        long r104 = this.f354111f.invoke().longValue();
        this.f354112g.invoke("[entryPerf:ownerAttach:start] reason=" + r110 + " pageIndex=" + r100 + " tab=" + r101.a());
        r101.attach();
        this.f354112g.invoke("[entryPerf:ownerAttach:end] reason=" + r110 + " pageIndex=" + r100 + " tab=" + r101.a() + " rows=" + r101.getState().f352164c.f353451a.size() + " cost=" + (this.f354111f.invoke().longValue() - r104) + "ms");
        com.larus.kmp.voice_setting.voice.feature.l r105 = this.f354106a.f354381o;
        if (r105 == null) goto L22;
        com.larus.kmp.voice_setting.voice.feature.l r106 = null;
        if ((!this.f354107b.a(r101.a(), r105.f353326a)) == true) goto L15;
        r105 = null;
    L15:
        if (r105 != null) goto L17;
        return;
    L17:
        if (e(r101, r105) == false) goto L19;
        r106 = r105;
    L19:
        if (r106 == null) goto L24;
        a(r106, "ownerAttach_" + r110, CollectionsKt.listOf(r101));
        return;
    L24:
        return;
    }

    public final void a(final com.larus.kmp.voice_setting.voice.feature.l r310, String r311, final List<? extends g5> r312) {
        Function1<String, Unit> r100 = this.f354113h;
        StringBuilder r101 = new StringBuilder("[bridge:apply:start] source=");
        r101.append(r311);
        r101.append(" token=");
        r101.append(r310.f353326a);
        r101.append(" my=");
        r101.append(r310.f353327b.size());
        r101.append(" recommend=");
        r101.append(r310.f353330e.size());
        r101.append(" recommendFirst=");
        ah9.c r102 = r310.f353342q;
        if (r102 == null) goto L7;
        List<SpeakerVoice> r103 = r102.f3446a;
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.size());
    L8:
        r101.append(r104);
        r101.append(" target=");
        List<? extends g5> r110 = r312;
        r101.append(CollectionsKt.joinToString$default(r110, null, null, null, 0, null, new v4(), 31, null));
        r101.append(" owners=");
        r101.append(CollectionsKt.joinToString$default(this.f354106a.f354369c, null, null, null, 0, null, new w4(), 31, null));
        r100.invoke(r101.toString());
        s4.d(this.f354106a, "applyRepoData:" + r311, this.f354110e, this.f354113h, true, "token=" + r310.f353326a + " target=" + CollectionsKt.joinToString$default(r110, null, null, null, 0, null, new x4(), 31, null), new y4(r312, r310, this));
        this.f354113h.invoke("[bridge:apply:afterOwners] source=" + r311 + " token=" + r310.f353326a + " target=" + CollectionsKt.joinToString$default(r110, null, null, null, 0, null, new z4(), 31, null) + " owners=" + CollectionsKt.joinToString$default(this.f354106a.f354369c, null, null, null, 0, null, new a5(), 31, null));
        return;
    L7:
        r104 = null;
        goto L8
    }

    public VoiceDoubleTabPageController(i4 r100, e5 r101, com.larus.kmp.voice_setting.voice.component.s1 r102, Function0 r103, Function0 r104, Function0 r105, z5 r106, a6 r107) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "pageOwnerCoordinator");
        Intrinsics.checkNotNullParameter(r102, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r103, "clearPreviewCache");
        Intrinsics.checkNotNullParameter(r104, "publish");
        Intrinsics.checkNotNullParameter(r105, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(r106, "logInfo");
        Intrinsics.checkNotNullParameter(r107, "logDiag");
        this.f354106a = r100;
        this.f354107b = r101;
        this.f354108c = r102;
        this.f354109d = r103;
        this.f354110e = r104;
        this.f354111f = r105;
        this.f354112g = r106;
        this.f354113h = r107;
    }
}
