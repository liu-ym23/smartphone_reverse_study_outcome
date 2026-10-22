package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util;

import am2.x;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bb0.a;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.PlaylistTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.f;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.c;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xe2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KSongOrderSongUtilKt {
    public static final int a = 0;

    static {
        a = o.a(14.0f);
    }

    public static final Function1<Context, CustomViewTab> a() {
        return KSongOrderSongUtilKt$createSecondLevelCustomViewTabAction$1.INSTANCE;
    }

    public static final y c(b r1) {
        if (r1 == null) goto L8;
        Pair r0 = r1.getSelectedFirstLevelTabValue();
        if (r0 == null) goto L8;
        Integer r2 = (Integer) r0.getFirst();
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        if (r1 != null) goto L13;
        return null;
    L13:
        return r1.getSelectedSecondLevelTabData(r3);
    L8:
        r3 = FirstLevelTab.Unknown.getValue();
        goto L9
    }

    public static final String d(MusicPanel r4) {
        if (r4 == null) goto L5;
        String r0 = r4.d;
        if (r0 == null) goto L5;
    L6:
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(x.class);
        Long r3 = null;
        if ((r1 instanceof t) == true) goto L9;
        r1 = null;
    L9:
        t r2 = (t) r1;
        if (r2 == null) goto L14;
        Map<String, String> r5 = r2.getMap();
        if (r5 == null) goto L14;
        String r6 = r5.get("enter_from_merge");
    L16:
        if (Intrinsics.areEqual(r6, "single_song") == false) goto L42;
        com.bytedance.android.livesdk.log.filter.o r7 = j0.l().c(x.class);
        if ((r7 instanceof t) == true) goto L20;
        r7 = null;
    L20:
        t r8 = (t) r7;
        if (r8 == null) goto L25;
        Map<String, String> r9 = r8.getMap();
        if (r9 == null) goto L25;
        String r10 = r9.get("enter_method");
    L27:
        if (Intrinsics.areEqual(r10, "song") == false) goto L43;
        if (r4 == null) goto L32;
        KtvMusic r11 = r4.a;
        if (r11 == null) goto L32;
        Long r12 = Long.valueOf(r11.getMId());
    L33:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r13 = KtvRoomContext.a.a();
        if (r13 == null) goto L39;
        m<Long> r14 = r13.getRelevantLiveSongId();
        if (r14 == null) goto L39;
        r3 = (Long) r14.getValue();
    L39:
        if (Intrinsics.areEqual(r12, r3) == false) goto L44;
        return "from_detail_pop_music";
    L44:
        return r0;
    L32:
        r12 = null;
        goto L33
    L43:
        return r0;
    L25:
        r10 = null;
        goto L27
    L42:
        return r0;
    L14:
        r6 = null;
    L5:
        r0 = "";
        goto L6
    }

    public static final Integer e(d r2) {
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == true) goto L12;
        if (r2 == null) goto L10;
        OrderedSongDataContext r3 = r2.getOrderedSongDataContext();
        if (r3 == null) goto L10;
        List<SongUniqueInfo> r4 = r3.getKtvPublicSongUniqueInfoList();
        if (r4 == null) goto L10;
        int r5 = r4.size();
    L21:
        return Integer.valueOf(r5);
    L10:
        r5 = 0;
        goto L21
    L12:
        ChorusContext r6 = r0.getContext();
        if (r6 == null) goto L19;
        n<List<MusicPanel>> r7 = r6.getChorusSelectedSongList();
        if (r7 == null) goto L19;
        List r8 = (List) r7.getValue();
        if (r8 == null) goto L19;
        return Integer.valueOf(r8.size());
    L19:
        return null;
    }

    public static final int f(ModeType r2) {
        if (r2 != ModeType.VIDEO_CHORUS) goto L6;
        return 2;
    L6:
        if (r2 != ModeType.MUSIC_EFFECT) goto L9;
        return 7;
    L9:
        KtvContext.Companion.getClass();
        oe2.b r3 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r3 != null) goto L12;
        return 2;
    L12:
        return r3.i();
    }

    public static final boolean n(y r3) {
        if (j.i() == false) goto L36;
        int r0 = KtvOrderSongThemeManager.a;
        a r1 = bb0.b.a;
        if (r1 == null) goto L7;
        boolean r2 = r1.b();
    L9:
        if (r2 == true) goto L16;
        a r4 = bb0.b.a;
        if (r4 == null) goto L13;
        boolean r5 = r4.f();
    L14:
        if (r5 == false) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L37;
        a r7 = bb0.b.a;
        if (r7 == null) goto L21;
        boolean r8 = r7.b();
    L22:
        if (r8 == true) goto L29;
        a r9 = bb0.b.a;
        if (r9 == null) goto L26;
        boolean r10 = r9.l();
    L27:
        if (r10 == false) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == false) goto L38;
        if (r3 != null) goto L33;
    L34:
        return true;
    L33:
        if (r3.g != PlaylistTabType.TAB_TYPE_DRESS_LIST.getValue()) goto L34;
        return false;
    L38:
        return false;
    L26:
        r10 = false;
    L29:
        r11 = false;
        goto L30
    L21:
        r8 = false;
        goto L22
    L37:
        return false;
    L13:
        r5 = false;
    L16:
        r6 = false;
        goto L17
    L7:
        r2 = false;
        goto L9
    L36:
        return false;
    }

    public static final void b(Context r2, CloseOrderSongDialogSource r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        ALogger.i("KSongOrderSongDialog", "dismissOrderSongDialog ;; source == " + r3.getValue());
        FragmentActivity r4 = ContextUtil.contextToFragmentActivity(r2);
        Fragment r5 = null;
        if (r4 == null) goto L7;
        FragmentManager r6 = r4.getSupportFragmentManager();
        if (r6 == null) goto L7;
        Fragment r7 = r6.findFragmentByTag("KSongOrderSongDialog");
    L9:
        if ((r7 instanceof KSongOrderSongDialog) == false) goto L12;
        r5 = r7;
    L12:
        KSongOrderSongDialog r8 = (KSongOrderSongDialog) r5;
        if (r8 == null) goto L23;
        r8.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L24;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r7 = null;
        goto L9
    }

    public static final void i(Context r2, CloseOrderSongDialogSource r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        ALogger.i("KSongOrderSongDialog", "hideOrderSongDialog ;; source == " + r3.getValue());
        FragmentActivity r4 = ContextUtil.contextToFragmentActivity(r2);
        Fragment r5 = null;
        if (r4 == null) goto L7;
        FragmentManager r6 = r4.getSupportFragmentManager();
        if (r6 == null) goto L7;
        Fragment r7 = r6.findFragmentByTag("KSongOrderSongDialog");
    L9:
        if ((r7 instanceof KSongOrderSongDialog) == false) goto L12;
        r5 = r7;
    L12:
        KSongOrderSongDialog r8 = (KSongOrderSongDialog) r5;
        if (r8 == null) goto L16;
        r8.Z90();
        return;
    L16:
        return;
    L7:
        r7 = null;
        goto L9
    }

    public static final boolean j(b r1, FirstLevelTab r2) {
        Intrinsics.checkNotNullParameter(r2, "currentFirstLevelTab");
        if (r1 == null) goto L9;
        Pair r3 = r1.getSelectedFirstLevelTabValue();
        if (r3 == null) goto L9;
        if (((Number) r3.getFirst()).intValue() != r2.getValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public static final void g(y r2, ConstraintLayout r3, TextView r4, ModeType r5) {
        if (r5 != ModeType.MUSIC_EFFECT) goto L5;
    L29:
        if (r3 == null) goto L38;
        r3.setVisibility(8);
        return;
    L38:
        return;
    L5:
        if (r5 == ModeType.VIDEO_CHORUS) goto L29;
        if (n(r2) == true) goto L10;
        if (r3 == null) goto L36;
        r3.setVisibility(8);
        return;
    L36:
        return;
    L10:
        if (r3 == null) goto L12;
        r3.setVisibility(0);
    L12:
        if (r2 == null) goto L16;
        List r0 = r2.h;
        if (r0 == null) goto L16;
        int r1 = r0.size();
    L18:
        if (n(r2) == false) goto L39;
        if (r1 <= 0) goto L25;
        if (r3 == null) goto L23;
        r3.setVisibility(0);
    L23:
        if (r4 == null) goto L32;
        r4.setText(s1.C(2131918499, new Object[]{Integer.valueOf(r1)}));
        return;
    L32:
        return;
    L25:
        if (r3 == null) goto L34;
        r3.setVisibility(8);
        return;
    L34:
        return;
    L39:
        return;
    L16:
        r1 = 0;
        goto L18
    }

    public static final void h(b r6, Long r7, String r8, FirstLevelTab r9) {
        Intrinsics.checkNotNullParameter(r8, "tabName");
        Intrinsics.checkNotNullParameter(r9, "firstLevelTab");
        String r0 = null;
        boolean r1 = false;
        if (r6 == null) goto L32;
        List r2 = r6.getSecondLevelTabDataList(r9.getValue());
        if (r2 == null) goto L32;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((y) r4).c, r8) == false) goto L8;
    L13:
        String r5 = (y) r4;
        if (r5 == null) goto L32;
        y r10 = r6.getSelectedSecondLevelTabData(r9.getValue());
        if (r10 == null) goto L19;
        r0 = r10.c;
    L19:
        if ((!Intrinsics.areEqual(r0, r8)) == true) goto L21;
    L27:
        boolean r11 = false;
    L29:
        if (((y) r5).o == r11) goto L31;
        ((y) r5).o = r11;
        r1 = true;
    L31:
        r0 = r5;
        goto L32
    L21:
        if (r7 == null) goto L23;
        long r12 = r7.longValue();
    L25:
        if (r12 <= 0) goto L27;
        r11 = true;
        goto L29
    L23:
        r12 = 0;
        goto L25
    L12:
        r4 = null;
    L32:
        if (r1 == false) goto L39;
        if (r6 == null) goto L40;
        r6.updateSecondLevelTabListState(r0);
        return;
    L40:
        return;
    }

    public static final void k(MusicPanel r1, View r2, View r3, View r4, Context r5) {
        if (r1 == null) goto L14;
        if (r2 == null) goto L15;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.getVisibility() != 0) goto L17;
        int r0 = com.bytedance.android.live.ktv.common.view.d.a;
        if (r3 != null) goto L12;
        r3 = r4;
    L12:
        com.bytedance.android.live.ktv.common.view.d.a(r1, r2, r3, r5, KSongOrderSongUtilKt$playFavoriteSongAnim$1$1$1.INSTANCE);
        return;
    L17:
        return;
    L15:
        return;
    }

    public static final void l(MusicPanel r1, View r2, View r3, View r4, Context r5) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 == null) goto L15;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.getVisibility() != 0) goto L17;
        int r0 = com.bytedance.android.live.ktv.common.view.d.a;
        if (r3 != null) goto L13;
        r3 = r4;
    L13:
        com.bytedance.android.live.ktv.common.view.d.a(r1, r2, r3, r5, KSongOrderSongUtilKt$playOrderSongAnim$1$1.INSTANCE);
        return;
    L17:
        return;
    }

    public static final void m(String r9, int r10, String r11, String r12, ModeType r13) {
        Intrinsics.checkNotNullParameter(r9, "curSortType");
        Intrinsics.checkNotNullParameter(r11, "secondLevelTabDes");
        Intrinsics.checkNotNullParameter(r12, "enterFrom");
        String r2 = null;
        if (Intrinsics.areEqual(r9, f.b) == false) goto L6;
        String r14 = "play_date";
    L9:
        String r1 = "已唱";
        if (StringsKt.contains$default(r11, "已唱", false, 2, null) == false) goto L12;
    L11:
        r11 = r1;
    L26:
        if (r13 == null) goto L28;
        r2 = r13.getValue();
    L28:
        ModeType r15 = ModeType.MUSIC_EFFECT;
        if (Intrinsics.areEqual(r2, r15.getValue()) == false) goto L31;
        String r16 = r15.getValue();
    L32:
        Long r17 = KtvLoggerHelper.a;
        Intrinsics.checkNotNullParameter(r12, "enterFrom");
        Intrinsics.checkNotNullParameter("auto", "showType");
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_TIMEOUT, "isResourceInfo");
        HashMap r3 = new HashMap(2);
        String r4 = "";
        if (r16 != null) goto L35;
        r16 = "";
    L35:
        r3.put("main_tab", r16);
        if (r11 == null) goto L39;
        r4 = r11;
    L39:
        r3.put("sub_tab", r4);
        r3.put("enter_from", r12);
        r3.put("user_type", KtvLoggerHelper.I());
        r3.put("live_type", KtvLoggerHelper.F());
        if (r14 == null) goto L42;
        r3.put("mine_tab_rank", r14);
    L42:
        r3.put("show_type", "auto");
        r3.put("is_resource_info", BDLocationException.ERROR_TIMEOUT);
        KtvLoggerHelper.A(r3);
        we2.a.a(r3);
        c.b(r3);
        KtvLoggerHelper.o0(r3);
        int r18 = ke2.b.a;
        ke2.b.m(r3);
        ke2.b.l(r3);
        Intrinsics.checkNotNullParameter(r3, "$this$putSingApplyCnt");
        KtvComponentContext.a r19 = KtvComponentContext.Companion;
        KtvComponentContext r110 = r19.getContext();
        if (r110 == null) goto L53;
        n<KtvComponentUIContext> r111 = r110.getKtvComponentUIContext();
        if (r111 == null) goto L53;
        KtvComponentUIContext r112 = (KtvComponentUIContext) r111.getValue();
        if (r112 == null) goto L53;
        Long r113 = r112.getSingApplyUnreadNum();
        if (r113 == null) goto L51;
        long r5 = r113.longValue();
    L52:
        r3.put("sing_cnt", String.valueOf(r5));
        goto L53
    L51:
        r5 = 0;
    L53:
        Intrinsics.checkNotNullParameter(r3, "$this$putListenApplyCnt");
        KtvComponentContext r114 = r19.getContext();
        if (r114 == null) goto L67;
        n<KtvComponentUIContext> r115 = r114.getKtvComponentUIContext();
        if (r115 == null) goto L67;
        KtvComponentUIContext r116 = (KtvComponentUIContext) r115.getValue();
        if (r116 == null) goto L67;
        Long r0 = (Long) r116.getApplyListenTotalNum().getValue();
        if (r0 != null) goto L62;
        r0 = 0L;
    L62:
        long r6 = r0.longValue();
        Long r117 = r116.getSingApplyUnreadNum();
        if (r117 == null) goto L65;
        long r7 = r117.longValue();
    L66:
        r3.put("listen_cnt", String.valueOf(r6 + r7));
        goto L67
    L65:
        r7 = 0;
    L67:
        c.b(r3);
        ke2.b.o(r3);
        if (Intrinsics.areEqual(r11, s1.B(2131918433)) == false) goto L81;
        KtvComponentContext r20 = r19.getContext();
        if (r20 == null) goto L79;
        n<KtvComponentUIContext> r21 = r20.getKtvComponentUIContext();
        if (r21 == null) goto L79;
        KtvComponentUIContext r22 = (KtvComponentUIContext) r21.getValue();
        if (r22 == null) goto L79;
        NextLiveData<Long> r23 = r22.getMultiChorusApplyTotalCount();
        if (r23 == null) goto L79;
        Long r24 = (Long) r23.getValue();
        if (r24 == null) goto L79;
    L80:
        r3.put("chorus_apply_cnt", String.valueOf(r24.longValue()));
    L79:
        r24 = 0L;
    L81:
        h.b(r3);
        j0.l().sendLog("livesdk_anchor_ksong_show", r3, new Object[]{IRoom.class, x.class});
        return;
    L31:
        r16 = com.bytedance.android.live.ktv.common.karaokestation.model.f.b(com.bytedance.android.live.ktv.common.karaokestation.model.f.a(r10));
        goto L32
    L12:
        r1 = "我的想唱";
        if (StringsKt.contains$default(r11, "我的想唱", false, 2, null) == true) goto L11;
        r1 = "一起唱";
        if (StringsKt.contains$default(r11, "一起唱", false, 2, null) == false) goto L21;
        if (MultiChorusContext.Companion.c() == true) goto L11;
    L22:
        r11 = "单人唱";
        goto L26
    L21:
        if (StringsKt.contains$default(r11, "单人唱", false, 2, null) == true) goto L22;
        r1 = "播放列表";
        if (StringsKt.contains$default(r11, "播放列表", false, 2, null) == false) goto L26;
    L6:
        if (Intrinsics.areEqual(r9, f.a) == false) goto L8;
        r14 = "midi_score";
        goto L9
    L8:
        r14 = null;
        goto L9
    }

    public static void o(ModeType r14, b r15, FirstLevelTab r16, String r17, boolean r18, String r19, int r20) {
        List r2 = null;
        if ((r20 & 8) == 0) goto L5;
        String r11 = null;
    L6:
        boolean r3 = false;
        if ((r20 & 16) == 0) goto L9;
        boolean r10 = false;
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r4 = "";
    L14:
        Intrinsics.checkNotNullParameter(r16, "firstLevelTab");
        Intrinsics.checkNotNullParameter(r4, "defaultLabelName");
        if (r16.getValue() != FirstLevelTab.OrderSongTab.getValue()) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == false) goto L34;
        if (r15 == null) goto L24;
        r2 = r15.getSecondLevelTabDataList(r16.getValue());
    L24:
        List r5 = r2;
        if (r5 != null) goto L27;
    L28:
        r3 = true;
    L29:
        if (r3 == true) goto L31;
        if (r10 == true) goto L31;
        return;
    L31:
        if (r15 == null) goto L36;
        b.a.a(r15, com.bytedance.android.live.ktv.common.util.a.c().getRoomId(), r16.getValue(), r4, f(r14), 0, 0, r10, r11, KSongOrderSongUtilKt$syncSecondLevelTabListIfNeed$1.INSTANCE, 48);
        return;
    L36:
        return;
    L27:
        if (r5.isEmpty() == false) goto L29;
    L34:
        return;
    L17:
        if (r16.getValue() == FirstLevelTab.MySongTab.getValue()) goto L20;
        r1 = false;
        goto L21
    L13:
        r4 = r19;
        goto L14
    L9:
        r10 = r18;
        goto L11
    L5:
        r11 = r17;
        goto L6
    }
}
