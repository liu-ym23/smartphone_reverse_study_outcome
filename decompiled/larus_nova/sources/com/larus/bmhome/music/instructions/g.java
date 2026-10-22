package com.larus.bmhome.music.instructions;

import android.content.Context;
import android.text.InputFilter;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.music.applet.g1;
import com.larus.uaigc.music.applet.h1;
import com.larus.uaigc.music.applet.i1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import va8.o;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements com.larus.bmhome.music.instructions.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f312853m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1a.b f312854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f312855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f312856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f312857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f312858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f312859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f312860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f312861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f312862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f312863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f312864k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.c f312865l;

    public static final class a {
    }

    static {
    }

    public final o c() {
        return (o) this.f312858e.getValue();
    }

    public final ICoreInputAbility d() {
        return (ICoreInputAbility) this.f312857d.getValue();
    }

    public final void h() {
        if (d() == null) goto L27;
        View r100 = this.f312856c;
        if (r100 == null) goto L7;
        boolean r101 = r100.isEnabled();
    L8:
        o r102 = c();
        if (r102 == null) goto L11;
        r102.L70(r101);
    L11:
        o r103 = c();
        if (r103 == null) goto L14;
        r103.SB(r101);
    L14:
        o r104 = c();
        if (r104 == null) goto L17;
        r104.qG(r101);
    L17:
        o r105 = c();
        if (r105 == null) goto L20;
        r105.vI(false);
    L20:
        o r106 = c();
        if (r106 == null) goto L23;
        r106.u60(false);
    L23:
        o r107 = c();
        if (r107 == null) goto L27;
        r107.C40(this.f312855b.getResources().getColor(v19.c.b(R.attr.larus_neutral_100, this.f312855b, R.color.larus_neutral_100)));
        goto L27
    L7:
        r101 = false;
    L27:
        if (this.f312862i == false) goto L33;
        Job r108 = this.f312864k;
        if (r108 == null) goto L31;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L31:
        this.f312862i = false;
        return;
    }

    public final Context getContext() {
        return this.f312855b;
    }

    public final void f(int r100) {
        this.f312863j = r100;
        if (r100 != 1) goto L5;
        String r101 = "ai";
    L6:
        this.f312861h = r101;
        if (r100 == 1) goto L40;
        if (r100 == 2) goto L10;
        FLogger.f375446a.e("MusicCreateManager", "Process music instruction select tab error, unexpected tab selected: UNKNOWN");
    L49:
        if (r100 != 2) goto L51;
        final int r102 = z2.f365865a.getMusicCreateConfig().f486643a;
    L52:
        com.larus.bmhome.music.utils.a r103 = new com.larus.bmhome.music.utils.a(r102, new b(this, r102));
        o r104 = c();
        if (r104 == null) goto L55;
        r104.oD(new InputFilter[]{r103});
    L55:
        com.larus.bmhome.instruction.g r105 = (com.larus.bmhome.instruction.g) this.f312859f.getValue();
        if (r105 == null) goto L58;
        r105.S7();
    L58:
        ys8.a r106 = (ys8.a) this.f312860g.getValue();
        if (r106 == null) goto L62;
        r106.S7();
        return;
    L62:
        return;
    L51:
        r102 = z2.f365865a.getMusicCreateConfig().f486645c;
        goto L52
    L10:
        String r107 = this.f312855b.getResources().getString(R.string.larus_lyrics_generate_customize_placeholder);
        ICoreInputAbility r108 = d();
        if (r108 == null) goto L13;
        r108.Yk(r107);
    L13:
        com.larus.bmhome.view.actionbar.edit.c r109 = this.f312865l;
        if (r109 == null) goto L16;
        r109.onInputHintChanged(r107, "LyricsTypeChange, MUSIC CUSTOM");
    L16:
        ICoreInputAbility r110 = d();
        if (r110 != null) goto L19;
    L21:
        boolean r111 = false;
    L22:
        if (r111 == true) goto L37;
        ICoreInputAbility r112 = d();
        if (r112 != null) goto L26;
    L28:
        boolean r113 = false;
    L29:
        if (r113 == true) goto L37;
        ICoreInputAbility r114 = d();
        if (r114 != null) goto L33;
    L35:
        boolean r115 = false;
    L36:
        if (r115 == false) goto L49;
    L33:
        if (r114.Rp() != 4) goto L35;
        r115 = true;
        goto L36
    L26:
        if (r112.Rp() != 3) goto L28;
        r113 = true;
    L37:
        o r116 = c();
        if (r116 == null) goto L49;
        r116.vI(true);
        goto L49
    L19:
        if (r110.Rp() != 1) goto L21;
        r111 = true;
        goto L22
    L40:
        h();
        o r117 = c();
        if (r117 == null) goto L43;
        r117.vI(false);
    L43:
        String r118 = this.f312855b.getResources().getString(R.string.larus_lyrics_generate_ai_placeholder);
        ICoreInputAbility r119 = d();
        if (r119 == null) goto L46;
        r119.Yk(r118);
    L46:
        com.larus.bmhome.view.actionbar.edit.c r120 = this.f312865l;
        if (r120 == null) goto L49;
        r120.onInputHintChanged(r118, "LyricsTypeChange, AI_GENERATION");
        goto L49
    L5:
        r101 = "user";
        goto L6
    }

    public static final void b(g r100, boolean r101) {
        if (r101 == false) goto L31;
        ICoreInputAbility r102 = r100.d();
        if (r102 == null) goto L28;
        o r103 = r100.c();
        if (r103 == null) goto L9;
        r103.SB(false);
    L9:
        o r104 = r100.c();
        if (r104 == null) goto L12;
        r104.qG(false);
    L12:
        o r105 = r100.c();
        if (r105 == null) goto L15;
        r105.L70(false);
    L15:
        o r106 = r100.c();
        if (r106 == null) goto L18;
        r106.C40(r100.f312855b.getResources().getColor(v19.c.b(R.attr.larus_neutral_50, r100.f312855b, R.color.larus_neutral_50)));
    L18:
        o r107 = r100.c();
        if (r107 == null) goto L21;
        r107.vI(false);
    L21:
        o r108 = r100.c();
        if (r108 == null) goto L24;
        r108.u60(true);
    L24:
        o r109 = r100.c();
        if (r109 == null) goto L27;
        r109.XW(false);
    L27:
        r102.Yk(r100.f312855b.getResources().getString(R.string.larus_lyrics_generating));
    L28:
        r100.f312862i = true;
        com.larus.bmhome.instruction.g r110 = (com.larus.bmhome.instruction.g) r100.f312859f.getValue();
        if (r110 == null) goto L64;
        r110.requestFocus();
        return;
    L64:
        return;
    L31:
        ICoreInputAbility r111 = r100.d();
        if (r111 == null) goto L62;
        View r112 = r100.f312856c;
        if (r112 == null) goto L36;
        boolean r113 = r112.isEnabled();
    L37:
        o r114 = r100.c();
        if (r114 == null) goto L40;
        r114.L70(r113);
    L40:
        o r115 = r100.c();
        if (r115 == null) goto L43;
        r115.SB(r113);
    L43:
        o r116 = r100.c();
        if (r116 == null) goto L46;
        r116.qG(r113);
    L46:
        o r117 = r100.c();
        if (r117 == null) goto L49;
        r117.vI(true);
    L49:
        o r118 = r100.c();
        if (r118 == null) goto L52;
        r118.u60(false);
    L52:
        o r119 = r100.c();
        if (r119 == null) goto L55;
        r119.XW(true);
    L55:
        o r120 = r100.c();
        if (r120 == null) goto L58;
        r120.E40();
    L58:
        o r121 = r100.c();
        if (r121 == null) goto L61;
        r121.C40(r100.f312855b.getResources().getColor(v19.c.b(R.attr.larus_neutral_100, r100.f312855b, R.color.larus_neutral_100)));
    L61:
        r111.Yk(r100.f312855b.getResources().getString(R.string.larus_lyrics_generate_customize_placeholder));
        goto L62
    L36:
        r113 = false;
    L62:
        r100.f312862i = false;
    }

    public static String e(bq8.a r110, boolean r111) {
        String[] r100 = new String[3];
        bq8.e r101 = r110.b().f20079a;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f20085b;
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r100[0] = r103;
        bq8.e r105 = r110.b().f20080b;
        if (r105 == null) goto L12;
        String r106 = r105.f20085b;
    L13:
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        r100[1] = r106;
        bq8.e r107 = r110.b().f20081c;
        if (r107 == null) goto L18;
        r102 = r107.f20085b;
    L18:
        if (r102 != null) goto L20;
        r102 = "";
    L20:
        r100[2] = r102;
        List r108 = CollectionsKt.listOf(r100);
        ArrayList r109 = new ArrayList();
        Iterator r112 = r108.iterator();
    L22:
        if (r112.hasNext() == false) goto L26;
        Object r113 = r112.next();
        if (StringsKt.isBlank((String) r113) == true) goto L22;
        r109.add(r113);
        goto L22
    L26:
        IAIChatUgcAIGCService.Companion r114 = IAIChatUgcAIGCService.f365905a;
        String r115 = CollectionsKt.joinToString$default(r109, r114.z0().c(), null, null, 0, null, null, 62, null);
        int r116 = j0.f375426a;
        String r117 = j0.d(R.string.larus_music_generate_message_prompt);
        String r118 = j0.d(R.string.larus_music_gen_style_select);
        if (r111 == false) goto L41;
        StringCompanionObject r119 = StringCompanionObject.INSTANCE;
        Object[] r120 = new Object[1];
        String r121 = r110.f20051d;
        if (r121 == null) goto L32;
        r104 = r121;
    L32:
        r120[0] = r104;
        String r122 = String.format(r117, Arrays.copyOf(r120, 1));
        if (o0.d(r118) == false) goto L52;
        if (r115.length() <= 0) goto L37;
        boolean r123 = true;
    L38:
        if (r123 == false) goto L52;
        r115 = String.format(r118, Arrays.copyOf(new Object[]{r115}, 1));
        goto L52
    L37:
        r123 = false;
    L52:
        return r114.z0().a(r122) + r114.z0().a(r115);
    L41:
        String r124 = j0.d(R.string.larus_music_generate_message_lyrics);
        StringCompanionObject r125 = StringCompanionObject.INSTANCE;
        String r126 = r114.z0().a(String.format(r117, Arrays.copyOf(new Object[]{String.format(r118, Arrays.copyOf(new Object[]{r115}, 1))}, 1)));
        if (o0.d(r124) == false) goto L44;
        String r127 = String.format(r124, Arrays.copyOf(new Object[]{r110.getLyrics()}, 1));
    L46:
        return r126 + "\n\n" + r127;
    L44:
        r127 = r110.getLyrics();
        goto L46
    L12:
        r106 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final void g(Fragment r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f312864k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new MusicCreateManager$onClickLyricsAiGen$1(this, r101, null), 3, null);
        this.f312861h = "mix";
    }

    public g(t1a.b r100, Context r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f312854a = r100;
        this.f312855b = r101;
        this.f312856c = r102;
        this.f312857d = LazyKt.lazy(new c(this));
        this.f312858e = LazyKt.lazy(new d(this));
        this.f312859f = LazyKt.lazy(new e(this));
        this.f312860g = LazyKt.lazy(new f(this));
        this.f312861h = "ai";
        this.f312863j = 1;
    }

    @Override // com.larus.bmhome.music.instructions.a
    public final void a(Fragment r110, List r111, g1 r112, h1 r113, i1 r114) {
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r112, "promptProvider");
        Intrinsics.checkNotNullParameter(r113, "onResult");
        Intrinsics.checkNotNullParameter(r114, "onLoadingChanged");
        this.f312864k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110), null, null, new MusicCreateManager$onClickLyricsAiGen$2(this, r114, r112, r111, r113, null), 3, null);
        this.f312861h = "mix";
    }
}
