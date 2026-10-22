package com.larus.bot.impl.feature.edit.feature.bio;

import com.larus.bot.impl.bean.BotEditParam;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class BotBioEditViewModel implements j, h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f319081j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f319082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f319083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f319084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1 f319085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<b> f319086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a1 f319087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableSharedFlow<b> f319088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f319089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f319090i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.h
    public final BotEditParam a() {
        return this.f319082a.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.h
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bio");
        this.f319082a.b(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.h
    public final boolean c() {
        return this.f319082a.c();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final boolean Ol() {
        String r100 = this.f319090i;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r102 = a().getBio();
        if (r102 == null) goto L10;
        r101 = r102;
    L10:
        return !Intrinsics.areEqual(r100, r101);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final String R() {
        String r100 = a().getBio();
        if (r100 == null) goto L5;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        return new Regex("\\n+").replace(r101, "\n");
    L5:
        r101 = null;
        goto L6
    }

    @Override // uu8.b
    public final d1<b> getUiEvent() {
        return this.f319087f;
    }

    @Override // uu8.b
    public final i1<c> getUiState() {
        return this.f319085d;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final void P6(String r100) {
        if (((c) this.f319085d.getValue()).f319097a == true) goto L5;
        return;
    L5:
        if (this.f319089h == true) goto L7;
        return;
    L7:
        if (r100 != null) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L15;
        FLogger.f375446a.e("BotBioEditViewModel", "generated empty bio");
    L16:
        this.f319089h = false;
        return;
    L15:
        b(r100);
        e(new b.a(r100, true));
        goto L16
    L9:
        if (StringsKt.isBlank(r100) == true) goto L12;
        r101 = false;
        goto L13
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final void Sf(boolean r100) {
        if (((c) this.f319085d.getValue()).f319097a == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        this.f319089h = true;
        d(this, true);
        e(new b.a("", false));
        return;
    L7:
        d(this, false);
    }

    @Override // uu8.b
    public final void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bio.a r100) {
        com.larus.bot.impl.feature.edit.feature.bio.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "action");
        if ((r101 instanceof com.larus.bot.impl.feature.edit.feature.bio.a.b) == false) goto L6;
        b(((com.larus.bot.impl.feature.edit.feature.bio.a.b) r101).f319093a);
        return;
    L6:
        if ((r101 instanceof com.larus.bot.impl.feature.edit.feature.bio.a.c) == false) goto L11;
        if (((c) this.f319085d.getValue()).f319097a == false) goto L23;
        e(new b.a(a().getBio(), false));
        return;
    L23:
        return;
    L11:
        if ((r101 instanceof com.larus.bot.impl.feature.edit.feature.bio.a.C4134a) == false) goto L21;
        if (((c) this.f319085d.getValue()).f319097a == false) goto L18;
        String r102 = a().getBio();
        if (r102 != null) goto L17;
        r102 = "";
    L17:
        b(r102);
    L18:
        this.f319090i = a().getBio();
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    }

    public final void e(b r100) {
        BuildersKt.launch$default(this.f319083b, null, null, new BotBioEditViewModel$sendUIEvent$1(this, r100, null), 3, null);
    }

    public BotBioEditViewModel(CoroutineScope r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f319082a = r101;
        this.f319083b = r100;
        e10 r102 = e10.f368561a;
        if (e10.D().bioEditable == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        StateFlowImpl r104 = j1.a(new c(r103, false));
        this.f319084c = r104;
        this.f319085d = kotlinx.coroutines.flow.e.b(r104);
        MutableSharedFlow<b> r105 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f319086e = r105;
        this.f319087f = kotlinx.coroutines.flow.e.a(r105);
        this.f319088g = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        BuildersKt.launch$default(r100, null, null, new BotBioEditViewModel$bindObservers$1(this, null), 3, null);
        return;
    L5:
        if (c() == false) goto L7;
        r103 = true;
        goto L8
    }

    public static void d(BotBioEditViewModel r100, boolean r101) {
        boolean r102 = ((c) r100.f319085d.getValue()).f319097a;
        r100.f319084c.setValue(new c(r102, r101));
    }
}
