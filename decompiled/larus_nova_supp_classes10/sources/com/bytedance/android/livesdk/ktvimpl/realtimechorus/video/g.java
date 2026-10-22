package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvimpl.base.component.lyric.KaraokeLyricComponent;
import com.bytedance.android.livesdk.ktvimpl.base.component.midi.KaraokeMidiComponent;
import com.bytedance.android.livesdk.ktvimpl.base.component.midi.KaraokeMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.livesdk.ktvimpl.base.lyric.KaraokeLyricComponentV2;
import com.bytedance.livesdk.ktvimpl.base.lyric.KaraokeLyricTimerV2;
import com.bytedance.livesdk.ktvimpl.base.lyric.KaraokeSceneType;
import com.bytedance.livesdk.ktvimpl.base.midi.KaraokeMidiComponentV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public KaraokeLyricComponent a;
    public KaraokeLyricComponentV2 b;
    public KaraokeMidiComponent c;
    public KaraokeMidiComponentV2 d;
    public MusicPanel e;
    public boolean f;
    public final b g;
    public final ViewGroup h;
    public final ViewGroup i;
    public final LifecycleOwner j;
    public final j1 k;
    public final com.bytedance.android.scope.j l;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ g a;

        public final void t1() {
            com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("VideoChorusViewManager", "onReleaseLiveClient");
            this.a.f = false;
        }

        public b(g r1) {
            this.a = r1;
        }

        public final void u4(long r1, ec6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("VideoChorusViewManager", "onLiveClientInitSuccess");
            this.a.f = true;
        }
    }

    static {
    }

    public final void g() {
        this.e = null;
        KaraokeLyricComponentV2 r0 = this.b;
        if (r0 == null) goto L15;
        com.bytedance.livesdk.ktvimpl.base.lyric.b r1 = r0.l;
        r1.f.setVisibility(8);
        KaraokeLyricTimerV2 r4 = r1.b;
        if (r4 == null) goto L12;
        Disposable r5 = r4.a;
        if (r5 != null) goto L9;
    L11:
        r4.c = 0;
        r4.b = 0;
        goto L12
    L9:
        if (r5.isDisposed() == true) goto L11;
        r5.dispose();
    L12:
        ng4.e r2 = r1.d.a;
        if (r2 == null) goto L15;
        r2.release();
    L15:
        KaraokeLyricComponent r3 = this.a;
        if (r3 == null) goto L26;
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.b r6 = r3.j;
        r6.g.setVisibility(8);
        KaraokeLyricTimer r7 = r6.b;
        if (r7 == null) goto L25;
        Disposable r8 = r7.a;
        if (r8 != null) goto L22;
    L24:
        r7.c = 0;
        r7.b = 0;
        goto L25
    L22:
        if (r8.isDisposed() == true) goto L24;
        r8.dispose();
    L25:
        r6.c.m();
    L26:
        KaraokeMidiComponent r9 = this.c;
        if (r9 == null) goto L31;
        KtvComponentMidiView r10 = r9.h;
        if (r10 == null) goto L31;
        r10.reset();
    L31:
        KaraokeMidiComponentV2 r11 = this.d;
        if (r11 == null) goto L36;
        com.bytedance.livesdk.ktvcommon.midi.view.a r12 = r11.i;
        if (r12 == null) goto L36;
        r12.onDetach();
    L36:
        h();
    }

    public final void b() {
        j1 r0 = this.k;
        if (r0 == null) goto L9;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L9;
        vb6.g r2 = r1.O5();
        if (r2 == null) goto L9;
        r2.a1(this.g);
    L9:
        h();
        KaraokeLyricComponentV2 r3 = this.b;
        if (r3 == null) goto L12;
        r3.onDestroy();
    L12:
        this.b = null;
        KaraokeLyricComponent r4 = this.a;
        if (r4 == null) goto L15;
        r4.onDestroy();
    L15:
        this.a = null;
    }

    public final void c() {
        KaraokeLyricComponentV2 r0 = this.b;
        if (r0 == null) goto L8;
        KaraokeLyricTimerV2 r2 = r0.l.b;
        if (r2 == null) goto L7;
        r2.b(null);
    L7:
        r0.g();
    L8:
        KaraokeLyricComponent r1 = this.a;
        if (r1 == null) goto L14;
        KaraokeLyricTimer r3 = r1.j.b;
        if (r3 == null) goto L13;
        r3.b(null);
    L13:
        r1.g();
    L14:
        KaraokeMidiComponent r4 = this.c;
        if (r4 == null) goto L22;
        KaraokeMidiViewModel r5 = r4.g;
        if (r5 == null) goto L19;
        r5.pauseMusic();
    L19:
        KtvComponentMidiView r6 = r4.h;
        if (r6 == null) goto L22;
        r6.A1();
    L22:
        KaraokeMidiComponentV2 r7 = this.d;
        if (r7 == null) goto L33;
        com.bytedance.livesdk.ktvimpl.base.midi.h r8 = r7.h;
        if (r8 == null) goto L29;
        zk6.b r9 = r8.a;
        if (r9 == null) goto L29;
        r9.pauseMusic();
    L29:
        com.bytedance.livesdk.ktvcommon.midi.view.a r10 = r7.i;
        if (r10 == null) goto L34;
        r10.A1();
        return;
    L34:
        return;
    }

    public final void d() {
        KaraokeLyricComponentV2 r0 = this.b;
        if (r0 == null) goto L7;
        KaraokeLyricTimerV2 r1 = r0.l.b;
        if (r1 == null) goto L7;
        r1.c(null);
    L7:
        KaraokeLyricComponent r2 = this.a;
        if (r2 == null) goto L12;
        KaraokeLyricTimer r3 = r2.j.b;
        if (r3 == null) goto L12;
        r3.c(null);
    L12:
        KaraokeMidiComponent r4 = this.c;
        if (r4 == null) goto L17;
        KaraokeMidiViewModel r5 = r4.g;
        if (r5 == null) goto L17;
        r5.playMusic();
    L17:
        KaraokeMidiComponentV2 r6 = this.d;
        if (r6 == null) goto L21;
        r6.g();
        return;
    }

    public final void h() {
        KaraokeMidiComponent r0 = this.c;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        this.c = null;
        KaraokeMidiComponentV2 r1 = this.d;
        if (r1 == null) goto L8;
        r1.onDestroy();
    L8:
        this.d = null;
    }

    public final void a(final LifecycleOwner r9) {
        Intrinsics.checkNotNullParameter(r9, "owner");
        if (vm2.h.a() == false) goto L8;
        ViewGroup r6 = this.i;
        com.bytedance.android.scope.j r3 = this.l;
        if (r6 == null) goto L18;
        if (r3 == null) goto L18;
        KaraokeLyricComponentV2 r0 = new KaraokeLyricComponentV2(r3, KaraokeSceneType.VIDEO_CHORUS, r9, r6, new i(this, r9));
        r0.k = new VideoChorusViewManager$loadLyricComponent$$inlined$lets$lambda$2(this, r9);
        r0.a(new ViewGroup.LayoutParams(-1, -1));
        Unit r10 = Unit.INSTANCE;
        this.b = r0;
    L18:
        j1 r11 = this.k;
        if (r11 == null) goto L26;
        cg6.a r12 = r11.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r12 == null) goto L27;
        vb6.g r13 = r12.O5();
        if (r13 == null) goto L28;
        r13.X0(this.g, true);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L8:
        ViewGroup r1 = this.i;
        if (r1 == null) goto L11;
        KaraokeLyricComponent r2 = new KaraokeLyricComponent(r9, r1, new h(this, r9));
    L12:
        this.a = r2;
        if (r2 == null) goto L18;
        r2.i = new VideoChorusViewManager$loadLyricComponent$$inlined$apply$lambda$1(this);
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.b r14 = r2.j;
        r14.getClass();
        LyricsDisplayConfig r15 = r14.c.f;
        if (r15 == null) goto L17;
        r15.h("#2AF2C9", "#B3FFFFFF");
    L17:
        r2.j.c.f.i(s1.f(19.0f), s1.f(13.0f));
        LyricsDisplayConfig r16 = r2.j.c.f;
        r16.o = false;
        r16.a = 8.0f;
        r2.a(new ViewGroup.LayoutParams(-1, -1));
        goto L18
    L11:
        r2 = null;
        goto L12
    }

    public final void e(long r6) {
        KaraokeLyricComponentV2 r0 = this.b;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a r1 = r0.n;
        if (r1 == null) goto L8;
        MusicPanel r2 = r1.a();
        if (r2 == null) goto L49;
    L16:
        KtvMusic.a r3 = KtvMusic.Companion;
        KtvMusic r4 = r2.a;
        r3.getClass();
        long r5 = KtvMusic.a.a(r4) * 1000;
        if (r6 > 0) goto L19;
        return;
    L19:
        if (1 <= r5) goto L22;
    L24:
        KaraokeLyricComponentV2 r7 = this.b;
        if (r7 == null) goto L30;
        KaraokeLyricTimerV2 r8 = r7.l.b;
        if (r8 == null) goto L29;
        r8.a(r6);
    L29:
        r7.g();
    L30:
        KaraokeLyricComponent r9 = this.a;
        if (r9 == null) goto L36;
        KaraokeLyricTimer r10 = r9.j.b;
        if (r10 == null) goto L35;
        r10.a(r6);
    L35:
        r9.g();
    L36:
        KaraokeMidiComponent r11 = this.c;
        if (r11 == null) goto L41;
        KaraokeMidiViewModel r12 = r11.g;
        if (r12 == null) goto L41;
        r12.seekMusic(r6);
    L41:
        KaraokeMidiComponentV2 r13 = this.d;
        if (r13 == null) goto L53;
        com.bytedance.livesdk.ktvimpl.base.midi.h r14 = r13.h;
        if (r14 == null) goto L54;
        zk6.b r15 = r14.a;
        if (r15 == null) goto L55;
        r15.g((int) r6);
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L22:
        if (r6 <= r5) goto L24;
        return;
    L49:
        return;
    L8:
        return;
    L9:
        KaraokeLyricComponent r16 = this.a;
        if (r16 == null) goto L50;
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a r17 = r16.k;
        if (r17 == null) goto L51;
        r2 = r17.a();
        if (r2 != null) goto L16;
        return;
    L51:
        return;
    }

    public final void f(com.bytedance.android.livesdk.ktvimpl.base.a r18) {
        Intrinsics.checkNotNullParameter(r18, "param");
        if (r18.c == true) goto L5;
    L25:
        h();
    L27:
        if (r18.d.length() <= 0) goto L29;
        boolean r3 = true;
    L30:
        if (r3 == false) goto L32;
        List r4 = CollectionsKt.listOf(r18.d);
    L33:
        MusicPanel r7 = this.e;
        if (r7 == null) goto L38;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L38;
        r8.setId(((Number) i(Long.valueOf(d5.c(r18.a)), Long.valueOf(r8.getId()), VideoChorusViewManager$updateMusicPanelIfNeed$1$1.INSTANCE)).longValue());
        r8.setMIdStr((String) i(r18.a, r8.getMIdStr(), VideoChorusViewManager$updateMusicPanelIfNeed$1$2.INSTANCE));
        r8.setMLyricType(((Number) i(Integer.valueOf(r18.e), Integer.valueOf(r8.getMLyricType()), VideoChorusViewManager$updateMusicPanelIfNeed$1$3.INSTANCE)).intValue());
        r8.setMLyricUrlList((List) i(r4, r8.getMLyricUrlList(), VideoChorusViewManager$updateMusicPanelIfNeed$1$4.INSTANCE));
    L39:
        KaraokeLyricComponentV2 r5 = this.b;
        String r9 = "";
        if (r5 == null) goto L54;
        Intrinsics.checkNotNullParameter(r18, "param");
        com.bytedance.livesdk.ktvimpl.base.lyric.b r6 = r5.l;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r18, "param");
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a r10 = r6.g;
        if (r10 == null) goto L54;
        MusicPanel r11 = r10.a();
        if (r11 == null) goto L54;
        List r12 = r11.a.getMLyricUrlList();
        if (r12 == null) goto L50;
        String r13 = (String) ListProtector.get(r12, 0);
        if (r13 == null) goto L50;
    L51:
        com.bytedance.android.live.ktv.common.music.download.h r14 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r15 = com.bytedance.android.live.ktv.common.music.download.h.d(r13, r11.c());
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.c.a("KaraokeLyricPresenterV2", "startMusic, path = " + r15 + ", lyricUrl = " + r13);
        r6.a = r18;
        ug4.b.a(new Object[]{"KaraokeLyricPresenterV2 startMusic, lyricUrl = " + r13 + ", path = " + r15});
        com.bytedance.livesdk.ktvimpl.base.lyric.d r16 = r6.d;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r15, "savePath");
        ng4.e r17 = r16.a;
        if (r17 == null) goto L54;
        r17.load(r13, r15);
    L50:
        r13 = "";
    L54:
        KaraokeLyricComponent r19 = this.a;
        if (r19 == null) goto L70;
        Intrinsics.checkNotNullParameter(r18, "param");
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.b r20 = r19.j;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r18, "param");
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a r21 = r20.h;
        if (r21 == null) goto L70;
        MusicPanel r22 = r21.a();
        if (r22 == null) goto L70;
        List r110 = r22.a.getMLyricUrlList();
        if (r110 == null) goto L65;
        String r23 = (String) ListProtector.get(r110, 0);
        if (r23 == null) goto L65;
    L66:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r111 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvMusic r112 = r22.a;
        r111.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r112) == true) goto L69;
        r20.e.setValue(null);
        r20.c.m();
        goto L70
    L69:
        com.bytedance.android.live.ktv.common.music.download.h r24 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r25 = com.bytedance.android.live.ktv.common.music.download.h.d(r23, r22.c());
        com.bytedance.android.livesdk.ktvimpl.base.component.lyric.c.a("KaraokeLyricPresenter", "startMusic, path = " + r25 + ", lyricUrl = " + r23);
        r20.a = r18;
        r20.c.load(r23, r25);
    L65:
        r23 = "";
    L70:
        KaraokeMidiComponent r26 = this.c;
        if (r26 == null) goto L75;
        Intrinsics.checkNotNullParameter(r18, "param");
        KaraokeMidiViewModel r27 = r26.g;
        if (r27 == null) goto L75;
        r27.startMusic(r18);
    L75:
        KaraokeMidiComponentV2 r28 = this.d;
        if (r28 == null) goto L98;
        Intrinsics.checkNotNullParameter(r18, "param");
        com.bytedance.livesdk.ktvimpl.base.midi.h r2 = r28.h;
        if (r2 == null) goto L99;
        zk6.b r29 = r2.a;
        if (r29 == null) goto L100;
        String r30 = r18.a;
        MusicPanel r31 = r28.m.a();
        if (r31 == null) goto L89;
        KtvMusic r32 = r31.a;
        if (r32 == null) goto L89;
        String r33 = r32.getMidiUrl();
        if (r33 == null) goto L89;
        r9 = r33;
    L89:
        MusicPanel r34 = r28.m.a();
        if (r34 == null) goto L95;
        KtvMusic r35 = r34.a;
        if (r35 == null) goto L95;
        String r36 = r35.getMSongUrl();
        if (r36 == null) goto L95;
    L96:
        r29.h(r30, r9, r36);
        return;
    L95:
        r36 = r18.d;
        goto L96
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L38:
        MusicPanel r37 = new MusicPanel(null, 0, null, false, MusicPanel.MusicPanelSource.KTV, null, null, 1073741791);
        KtvMusic r38 = r37.a;
        r38.setId(d5.c(r18.a));
        r38.setMIdStr(r18.a);
        r38.setMLyricType(r18.e);
        r38.setMLyricUrlList(r4);
        Unit r39 = Unit.INSTANCE;
        this.e = r37;
        goto L39
    L32:
        r4 = null;
        goto L33
    L29:
        r3 = false;
        goto L30
    L5:
        if (this.f == false) goto L7;
    L8:
        LifecycleOwner r40 = this.j;
        if (vm2.h.a() == false) goto L18;
        if (this.d != null) goto L27;
        com.bytedance.android.scope.j r41 = this.l;
        ViewGroup r42 = this.h;
        if (r41 == null) goto L27;
        if (r42 == null) goto L27;
        KaraokeMidiComponentV2 r43 = new KaraokeMidiComponentV2(r41, r40, r42, new j());
        r43.a(new ViewGroup.LayoutParams(-1, -1));
        Unit r44 = Unit.INSTANCE;
        this.d = r43;
        goto L27
    L18:
        if (this.c != null) goto L27;
        ViewGroup r45 = this.h;
        if (r45 == null) goto L23;
        KaraokeMidiComponent r46 = new KaraokeMidiComponent(r40, r45, new k());
        r46.a(new ViewGroup.LayoutParams(-1, -1));
    L24:
        this.c = r46;
        goto L27
    L23:
        r46 = null;
        goto L24
    L7:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L25;
        goto L8
    }

    public static Object i(Object r0, Object r1, Function1 r2) {
        if (((Boolean) r2.invoke(r0)).booleanValue() == false) goto L6;
        return r0;
    L6:
        return r1;
    }

    public g(ViewGroup r11, ViewGroup r12, LifecycleOwner r13, j1 r14, com.bytedance.android.scope.j r15) {
        Intrinsics.checkNotNullParameter(r13, "owner");
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.e = new MusicPanel(null, 0, null, false, MusicPanel.MusicPanelSource.KTV, null, null, 1073741791);
        this.g = new b(this);
    }
}
