package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.KtvComponentUIWidget;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jg4.i;
import jg4.j;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LyricComponentListenerPresenter {
    public final jg4.b a;
    public final LyricsDisplayConfig b;
    public final jg4.f c;
    public final wd2.a d;
    public j e;
    public final HashSet<Integer> f;
    public k g;
    public String h;
    public final jg4.c i;
    public final KtvSingAndListenerLyricViewV2.a j;

    @Deprecated(message = "不要使用")
    public final j a() {
        i r0 = this.i.k();
        if (r0 == null) goto L7;
        j r1 = r0.a("", "", "", this.i.c());
        if (r1 == null) goto L7;
        r1.c = new ArrayList();
        return r1;
    L7:
        return null;
    }

    public final void b() {
        this.d.e();
        this.e = null;
        jg4.f r0 = this.c;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        this.f.clear();
    }

    public final void c(int r2) {
        if (r2 != 4) goto L5;
        wd2.a.b(this.d);
        return;
    L5:
        if (r2 != 5) goto L7;
        wd2.a.c(this.d);
        return;
    L7:
        if (r2 != 6) goto L15;
        this.d.e();
        this.e = null;
        return;
    }

    public final void d(final k r14) {
        Intrinsics.checkNotNullParameter(r14, "seiModelCompat");
        long r1 = 0;
        if (KtvSettingHelper.h() == false) goto L16;
        final String r0 = r14.p();
        if (r14.j() <= 0) goto L124;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        if ((!Intrinsics.areEqual(r0, this.h)) == false) goto L127;
        this.h = r0;
        UtilityKotlinExtentionsKt.b(this, new LyricComponentListenerPresenter$processLyricSeiResult$1(this, r0, r14));
        return;
    L127:
        return;
    L10:
        r2 = false;
        goto L11
    L124:
        return;
    L16:
        List<v> r3 = r14.l();
        if (r3 == null) goto L112;
        j r4 = this.i.f();
        if (r4 != null) goto L21;
        long r6 = r14.j();
        k r5 = this.g;
        if (r5 == null) goto L32;
        long r8 = r5.j();
    L34:
        if (r6 == r8) goto L52;
        j r7 = this.e;
        if (r7 == null) goto L40;
        CopyOnWriteArrayList r9 = r7.e;
        if (r9 == null) goto L40;
        r9.clear();
    L40:
        j r10 = this.e;
        if (r10 == null) goto L43;
        List r11 = r10.c;
    L45:
        if ((r11 instanceof ArrayList) == true) goto L47;
        r11 = null;
    L47:
        ArrayList r12 = (ArrayList) r11;
        if (r12 == null) goto L50;
        r12.clear();
    L50:
        String r13 = "initRequset for guest: " + r14.j();
        ALogger.i(bb0.b.b().concat("-lyric-LyricComponentListenerPresenter"), r13 + ", invoke class :" + List.class.getSimpleName());
        this.e = a();
    L59:
        j r15 = this.e;
        if (r15 != null) goto L62;
        return;
    L62:
        this.g = r14;
        int r16 = r14.n();
        r15.d = r16;
        Iterator<v> r17 = r3.iterator();
    L64:
        if (r17.hasNext() == false) goto L128;
        v r18 = r17.next();
        if (this.f.contains(Integer.valueOf(r18.b())) == true) goto L64;
        String r19 = "";
        if (r16 != 2) goto L80;
        new lg4.b();
        TreeMap r20 = new TreeMap();
        String r21 = r18.a();
        if (r21 == null) goto L74;
        r19 = r21;
    L74:
        lg4.b.c(r20, r19);
        Iterator r22 = r20.keySet().iterator();
        if (r22 != null) goto L77;
    L87:
        com.bytedance.component.lyric.model.b r23 = null;
    L88:
        if (r23 == null) goto L64;
        j r24 = this.e;
        if (r24 == null) goto L92;
        List r25 = r24.c;
    L94:
        if ((r25 instanceof ArrayList) == true) goto L96;
        r25 = null;
    L96:
        ArrayList r26 = (ArrayList) r25;
        if (r26 == null) goto L99;
        r26.add(r23);
    L99:
        jg4.b r27 = this.a;
        if (r27 == null) goto L102;
        CopyOnWriteArrayList r28 = r15.e;
        LyricsDisplayConfig r29 = this.b;
        r27.a(r28, r23, r29.k, r29.d, r15.d, r28.size());
    L102:
        this.f.add(Integer.valueOf(r18.b()));
        if (r15.f != null) goto L107;
        com.bytedance.component.lyric.model.b r30 = (com.bytedance.component.lyric.model.b) CollectionsKt.firstOrNull(r15.e);
        if (r30 == null) goto L107;
        r15.f = new jg4.a(r30, r15.d);
    L107:
        jg4.a r31 = r15.f;
        if (r31 == null) goto L64;
        jg4.f r32 = this.c;
        if (r32 == null) goto L64;
        r32.a(r15, r31, this.b);
        goto L64
    L92:
        r25 = null;
        goto L94
    L77:
        if (r22.hasNext() != true) goto L87;
        com.bytedance.component.lyric.model.b r33 = (com.bytedance.component.lyric.model.b) r20.get(r22.next());
    L86:
        r23 = r33;
        goto L88
    L80:
        if (r16 != 3) goto L87;
        lg4.a r34 = new lg4.a();
        String r35 = r18.a();
        if (r35 == null) goto L85;
        r19 = r35;
    L85:
        r33 = r34.b(r19);
        goto L86
    L128:
        return;
    L43:
        r11 = null;
        goto L45
    L52:
        if (this.e != null) goto L59;
        long r36 = r14.j();
        k r37 = this.g;
        if (r37 == null) goto L57;
        r1 = r37.j();
    L57:
        if (r36 != r1) goto L59;
        this.e = a();
        goto L59
    L32:
        r8 = 0;
        goto L34
    L21:
        if ((r4 instanceof h) == true) goto L23;
        r4 = null;
    L23:
        h r38 = (h) r4;
        if (r38 == null) goto L59;
        if (r38.n != r14.j()) goto L59;
        this.e = null;
        return;
    }

    public LyricComponentListenerPresenter(LyricComponentImplManager r2, KtvComponentUIWidget.f r3) {
        Intrinsics.checkNotNullParameter(r2, "lyricComponent");
        Intrinsics.checkNotNullParameter(r3, "lyricProgressListener");
        this.i = r2;
        this.j = r3;
        this.a = r2.l();
        this.b = r2.f;
        this.c = r2.g.d;
        wd2.a r4 = new wd2.a();
        Intrinsics.checkNotNullParameter("LyricComponentListenerPresenter", LocationMonitorConst.TAG);
        r4.g = "LyricComponentListenerPresenter";
        r4.b = new LyricComponentListenerPresenter$$special$$inlined$apply$lambda$1(this);
        Unit r5 = Unit.INSTANCE;
        this.d = r4;
        this.f = new HashSet();
    }
}
