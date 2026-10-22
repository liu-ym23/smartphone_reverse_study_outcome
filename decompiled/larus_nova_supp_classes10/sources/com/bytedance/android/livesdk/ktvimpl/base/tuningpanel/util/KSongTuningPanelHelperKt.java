package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.ktv.common.tuningpanel.ability.a;
import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.KSongTuningMusicControl;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongTuningButtonOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongTuningPanelOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.KSongViceSingerTuningButtonOuterCallback;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.s;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvComponentTuningDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvModeTuningDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oe2.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KSongTuningPanelHelperKt {
    public static final a d() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L5;
    L8:
        KtvModeTuningDataContext.Companion.getClass();
        return KtvModeTuningDataContext.b.a();
    L5:
        if (KtvContext.a.j() == true) goto L8;
        KtvComponentTuningDataContext.Companion.getClass();
        return KtvComponentTuningDataContext.b.a();
    }

    public static final ec0.a e() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L5;
    L13:
        KtvModeTuningDataContext.Companion.getClass();
        DataContext r0 = d.d(KtvModeTuningDataContext.class);
        if ((r0 instanceof KtvModeTuningDataContext) == true) goto L16;
        r0 = null;
    L16:
        KtvModeTuningDataContext r1 = (KtvModeTuningDataContext) r0;
        if (r1 != null) goto L19;
        return null;
    L19:
        return r1.getMTuningMusicControl();
    L5:
        if (KtvContext.a.j() == true) goto L13;
        KtvComponentTuningDataContext.Companion.getClass();
        DataContext r2 = d.d(KtvComponentTuningDataContext.class);
        if ((r2 instanceof KtvComponentTuningDataContext) == true) goto L10;
        r2 = null;
    L10:
        KtvComponentTuningDataContext r3 = (KtvComponentTuningDataContext) r2;
        if (r3 != null) goto L21;
        return null;
    L21:
        return r3.getMTuningMusicControl();
    }

    public static final void c(String r21) {
        Intrinsics.checkNotNullParameter(r21, "buttonType");
        ec0.a r2 = e();
        if (r2 == null) goto L57;
        MusicPanel r15 = r2.e();
        if (r15 == null) goto L59;
        String r3 = r15.a.getMTitle();
        if (r3 != null) goto L10;
        String r6 = "";
    L11:
        long r7 = r15.a.getMId();
        String r4 = r15.a.getAddSongSource();
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        boolean r9 = false;
        if (r15.d.length() <= 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r4 = r15.d;
    L20:
        String r11 = r4;
        String r8 = com.bytedance.android.live.ktv.common.util.a.b(r15.a);
        if (r8.length() != 0) goto L23;
        boolean r10 = true;
    L25:
        if (r10 == false) goto L27;
        HashMap r13 = null;
    L28:
        KtvContext.Companion.getClass();
        b r12 = (b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r12 == null) goto L34;
        String r14 = r12.getEnterFrom();
        if (r14 == null) goto L34;
        String r16 = r14;
    L36:
        if (j.i() == false) goto L38;
        String r17 = r16;
    L40:
        if (j.i() == false) goto L42;
        String r18 = "ktv_room_open";
    L43:
        String r19 = r15.a.getMidiUrl();
        if (r19 != null) goto L46;
        Boolean r110 = null;
    L50:
        pb0.a r20 = pb0.b.a;
        String r22 = j.d();
        String r23 = j.a(null);
        String r24 = j.c();
        String r111 = j.g();
        String r112 = r15.b();
        String r25 = r15.a.getMAuthor();
        if (r25 != null) goto L53;
        r25 = "";
    L53:
        Intrinsics.checkNotNullParameter(r21, "buttonType");
        Intrinsics.checkNotNullParameter(r22, "liveType");
        Intrinsics.checkNotNullParameter(r23, "roomType");
        Intrinsics.checkNotNullParameter(r24, "functionType");
        Intrinsics.checkNotNullParameter("tone_tuning", "requestPage");
        Intrinsics.checkNotNullParameter(r6, "songName");
        Intrinsics.checkNotNullParameter(r111, "userType");
        Intrinsics.checkNotNullParameter(r11, "fromRequestType");
        Intrinsics.checkNotNullParameter(r112, "artistId");
        Intrinsics.checkNotNullParameter(r25, "artistName");
        pb0.a r0 = pb0.b.a;
        if (r0 == null) goto L58;
        r0.o(r21, r22, r23, r24, "tone_tuning", r6, r7, r111, r11, r112, r25, r13, r16, r17, r18, r110, null, r15);
        return;
    L58:
        return;
    L46:
        if (r19.length() <= 0) goto L48;
        r9 = true;
    L48:
        r110 = Boolean.valueOf(r9);
        goto L50
    L42:
        r18 = null;
        goto L43
    L38:
        r17 = null;
    L34:
        r16 = "";
        goto L36
    L27:
        r13 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("song_type", r8)});
        goto L28
    L23:
        r10 = false;
        goto L25
    L17:
        r5 = false;
        goto L18
    L10:
        r6 = r3;
        goto L11
    L59:
        return;
    }

    public static final void a(Context r19, String r20) {
        Intrinsics.checkNotNullParameter(r20, "source");
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(r19);
        if (r0 == null) goto L61;
        FragmentManager r3 = r0.getSupportFragmentManager();
        if (r3 == null) goto L63;
        Fragment r1 = r3.findFragmentByTag("TuningPanelDialog");
        Function1<ViewGroup, com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.view.a> r6 = null;
        if ((r1 instanceof DialogFragment) == true) goto L10;
        r1 = null;
    L10:
        DialogFragment r2 = (DialogFragment) r1;
        if (r2 == null) goto L19;
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L19;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L19:
        if (r3.findFragmentByTag("TuningPanelDialog") != null) goto L62;
        int r5 = TuningPanelDialog.m;
        ChorusContext.a r7 = ChorusContext.Companion;
        ChorusContext r8 = r7.getContext();
        if (r8 == null) goto L27;
        n<List<MusicPanel>> r9 = r8.getChorusSelectedSongList();
        if (r9 == null) goto L27;
        List r10 = (List) r9.getValue();
        if (r10 == null) goto L27;
        int r11 = r10.size();
    L28:
        final a r15 = d();
        KSongTuningPanelOuterCallback r12 = new KSongTuningPanelOuterCallback();
        if (r7.c() == true) goto L31;
    L33:
        MultiChorusContext.a r13 = MultiChorusContext.Companion;
        if (r13.c() == true) goto L36;
    L43:
        ec0.a r16 = e();
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.n r14 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.n(r15);
        KSongTuningButtonOuterCallback r17 = new KSongTuningButtonOuterCallback(r15, r12);
        Function1<ViewGroup, View> r18 = new KSongTuningPanelHelperKt$getTuningPanelConfig$3(r15);
        if (r15 != null) goto L46;
    L48:
        ac0.b r21 = new ac0.b(true, r12, r17, r14, new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback.j(), r18, r6, r15, r16, false, 8331);
    L49:
        Intrinsics.checkNotNullParameter(r21, "config");
        TuningPanelDialog r22 = new TuningPanelDialog(r21);
        LandscapeRestrictionOperation r23 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r22, "TuningPanelDialog", r23);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r22, r23) == false) goto L57;
    L54:
        pd2.d.n.getClass();
        Intrinsics.checkNotNullParameter(r20, "source");
        pd2.d.w(LinkMonitorData.BusinessAdjustTonePanelShow, new JSONObject().put("source", r20));
        return;
    L57:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
    L53:
        r22.show(r3, "TuningPanelDialog");
        goto L54
    L46:
        if (r15.O() != true) goto L48;
        r6 = new KSongTuningPanelHelperKt$getTuningPanelConfig$4(r15);
        goto L48
    L36:
        if (r13.a() != 2) goto L43;
    L37:
        s r110 = new s(r15);
        KSongViceSingerTuningButtonOuterCallback r111 = new KSongViceSingerTuningButtonOuterCallback();
        Function1<ViewGroup, View> r112 = new KSongTuningPanelHelperKt$getTuningPanelConfig$1(r15);
        if (r15 != null) goto L40;
    L42:
        r21 = new ac0.b(false, r12, r111, r110, null, r112, r6, r15, null, false, 12682);
        goto L49
    L40:
        if (r15.O() != true) goto L42;
        r6 = new KSongTuningPanelHelperKt$getTuningPanelConfig$2(r15);
        goto L42
    L31:
        if (r7.a() != 2) goto L33;
        if (r11 != 0) goto L37;
    L27:
        r11 = 0;
        goto L28
    L62:
        return;
    L63:
        return;
    }

    public static final Pair<DataContext, Disposable> b(boolean r4, com.bytedance.android.live.pushstream.d r5, WeakReference<Context> r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r4 == false) goto L10;
        if (r5 == null) goto L17;
        Pair r7 = d.a(KSongTuningPanelHelperKt$initKSongTuningDataContextIfNeed$1.INSTANCE);
        KtvModeTuningDataContext r1 = (KtvModeTuningDataContext) r7.component1();
        Disposable r8 = (Disposable) r7.component2();
        KtvModeOrderSongDataContext.Companion.getClass();
        KSongTuningMusicControl r2 = new KSongTuningMusicControl(KtvModeOrderSongDataContext.Companion.a());
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r3 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b(r5, r2, r6);
        r3.j0();
        r1.setMTuningCore(r3);
        r1.setMTuningMusicControl(r2);
        com.bytedance.live.datacontext.b.a(r1, KtvModeTuningDataContext.class);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r9 = KtvModeOrderSongDataContext.Companion.a();
        if (r9 == null) goto L8;
        r9.getOrderedSongList(false);
    L8:
        r3.n0();
        return new Pair(r1, r8);
    L17:
        return new Pair(null, null);
    L10:
        if (r5 == null) goto L17;
        Pair r10 = d.a(KSongTuningPanelHelperKt$initKSongTuningDataContextIfNeed$2.INSTANCE);
        KtvComponentTuningDataContext r11 = (KtvComponentTuningDataContext) r10.component1();
        Disposable r12 = (Disposable) r10.component2();
        KtvComponentOrderSongDataContext.Companion.getClass();
        KSongTuningMusicControl r13 = new KSongTuningMusicControl(KtvComponentOrderSongDataContext.Companion.a());
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r14 = new com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b(r5, r13, r6);
        r14.j0();
        r11.setMTuningCore(r14);
        r11.setMTuningMusicControl(r13);
        com.bytedance.live.datacontext.b.a(r11, KtvComponentTuningDataContext.class);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r15 = KtvComponentOrderSongDataContext.Companion.a();
        if (r15 == null) goto L14;
        r15.getOrderedSongList(false);
    L14:
        r14.n0();
        return new Pair(r11, r12);
    }
}
