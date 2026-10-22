package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingNestedScrollMode;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingSlotKey;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingTopSlotMode;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mwb.e;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f436264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentManager f436265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f436266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f436267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<MmRecordingTopBarView> f436268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<MmRecordingTitleNameView> f436269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<mwb.d> f436270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f436271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f436272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f436273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public dwb.b f436274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<MmRecordingSlotKey, View> f436275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MmRecordingTopBarView f436276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MmRecordingTitleNameView f436277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public mwb.d f436278o;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5208a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436279a = null;

        static {
            int[] r100 = new int[MmRecordingSlotKey.values().length];
            r100[MmRecordingSlotKey.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[MmRecordingSlotKey.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[MmRecordingSlotKey.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[MmRecordingSlotKey.TOOLBAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f436279a = r100;
        }
    }

    public final void b() {
        int r100 = 0;
        if (this.f436274k.f470400f.f470403a != MmRecordingTopSlotMode.OVERLAY) goto L5;
        boolean r101 = true;
    L6:
        ViewGroup.LayoutParams r102 = this.f436266c.f516054d.getLayoutParams();
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
    L10:
        if (r103 == null) goto L25;
        int r104 = -1;
        if (r101 == false) goto L15;
        int r105 = 0;
    L16:
        if (r101 == true) goto L20;
        r104 = this.f436266c.f516053c.getId();
    L20:
        if (r103.topToTop == r105) goto L22;
    L24:
        r103.topToTop = r105;
        r103.topToBottom = r104;
        this.f436266c.f516054d.setLayoutParams(r103);
        goto L25
    L22:
        if (r103.topToBottom != r104) goto L24;
    L15:
        r105 = -1;
    L25:
        if (r101 == false) goto L30;
        Integer r106 = this.f436274k.f470400f.f470404b;
        if (r106 == null) goto L29;
        r100 = r106.intValue();
        goto L30
    L29:
        r100 = e().getHeight();
    L30:
        this.f436266c.f516054d.setContentTopInsetPx(r100);
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public final View e() {
        Map<MmRecordingSlotKey, View> r100 = this.f436275l;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        View r102 = (View) r101.get(MmRecordingSlotKey.TOP);
        if (r102 != null) goto L9;
        MmRecordingTopBarView r103 = this.f436276m;
        if (r103 == null) goto L8;
        return r103;
    L8:
        return this.f436266c.f516053c;
    L9:
        return r102;
    }

    public static FrameLayout.LayoutParams d(MmRecordingSlotKey r100) {
        if (r100 != MmRecordingSlotKey.MIDDLE) goto L5;
        int r101 = -1;
    L7:
        return new FrameLayout.LayoutParams(-1, r101);
    L5:
        r101 = -2;
        goto L7
    }

    public final void f(dwb.b r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        this.f436274k = r110;
        MmRecordingSlotKey[] r100 = MmRecordingSlotKey.values();
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L49;
        MmRecordingSlotKey r103 = r100[r102];
        r110.getClass();
        Intrinsics.checkNotNullParameter(r103, "key");
        int r104 = dwb.b.a.f470401a[r103.ordinal()];
        boolean r105 = true;
        if (r104 == 1) goto L15;
        if (r104 == 2) goto L14;
        if (r104 == 3) goto L13;
        if (r104 != 4) goto L12;
        dwb.a r106 = r110.f470398d;
    L16:
        int r107 = C5208a.f436279a[r103.ordinal()];
        if (r107 == 1) goto L47;
        if (r107 == 2) goto L46;
        if (r107 == 3) goto L39;
        if (r107 != 4) goto L38;
        MmRecordingSlotKey r108 = MmRecordingSlotKey.TOOLBAR;
        Fragment r109 = this.f436265b.findFragmentByTag("mm_recording_slot_" + r108.name().toLowerCase(Locale.ROOT));
        if (r109 == null) goto L25;
        this.f436265b.beginTransaction().remove(r109).commitNowAllowingStateLoss();
    L25:
        this.f436275l.remove(r108);
        this.f436266c.f516057g.removeAllViews();
        if (r106 != null) goto L29;
        this.f436271h.invoke();
    L48:
        r102 = r102 + 1;
        goto L4
    L29:
        if ((r106 instanceof dwb.a.C5719a) == true) goto L35;
        if ((r106 instanceof dwb.a.b) == false) goto L34;
        View r111 = ((dwb.a.b) r106).f470393a.invoke(this.f436264a.requireContext(), this.f436267d);
        this.f436266c.f516057g.addView(r111, new FrameLayout.LayoutParams(-1, -2));
        this.f436275l.put(r108, r111);
        goto L48
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        FragmentContainerView r112 = new FragmentContainerView(this.f436264a.requireContext());
        r112.setId(View.generateViewId());
        r112.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f436266c.f516057g.addView(r112);
        r112.getId();
        dwb.a.C5719a r113 = (dwb.a.C5719a) r106;
        throw null;
    L38:
        throw new NoWhenBranchMatchedException();
    L39:
        a(MmRecordingSlotKey.MIDDLE, this.f436266c.f516056f, r106, new MmRecordingSlotsController$applyMiddleSlot$1(this));
        if (r106 == null) goto L48;
        MmRecordingNavLayout r114 = this.f436266c.f516054d;
        if (r106.a() == MmRecordingNestedScrollMode.Enabled) goto L45;
        r105 = false;
    L45:
        r114.setEnableScroll(r105);
        goto L48
    L46:
        a(MmRecordingSlotKey.TITLE, this.f436266c.f516055e, r106, new MmRecordingSlotsController$applyTitleSlot$1(this));
        goto L48
    L47:
        a(MmRecordingSlotKey.TOP, this.f436266c.f516053c, r106, new MmRecordingSlotsController$applyTopSlot$1(this));
        goto L48
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        r106 = r110.f470397c;
        goto L16
    L14:
        r106 = r110.f470396b;
        goto L16
    L15:
        r106 = r110.f470395a;
        goto L16
    L49:
        b();
        this.f436266c.f516054d.setTopBarView(e());
        MmRecordingNavLayout r115 = this.f436266c.f516054d;
        View r116 = (View) ((LinkedHashMap) this.f436275l).get(MmRecordingSlotKey.TITLE);
        if (r116 != null) goto L55;
        r116 = this.f436277n;
        if (r116 != null) goto L55;
        r116 = this.f436266c.f516055e;
    L55:
        FrameLayout r117 = this.f436266c.f516056f;
        r115.f435673a = r116;
        r115.f435674b = null;
        r115.f435676d = r117;
        r115.a(r116);
        r115.d();
        r115.removeCallbacks(r115.f435693u);
        r115.post(r115.f435693u);
        r115.requestLayout();
        View r118 = e();
        if (r118.isLaidOut() == true) goto L58;
    L60:
        r118.addOnLayoutChangeListener(new b(this));
    L61:
        this.f436273j.invoke();
        return;
    L58:
        if (r118.isLayoutRequested() == true) goto L60;
        b();
        this.f436273j.invoke();
        goto L61
    }

    public static void c(FrameLayout r100, View r101, FrameLayout.LayoutParams r102) {
        if (r101.getParent() == r100) goto L12;
        ViewParent r103 = r101.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L7;
        ViewGroup r104 = (ViewGroup) r103;
    L8:
        if (r104 == null) goto L10;
        r104.removeView(r101);
    L10:
        r100.addView(r101, r102);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void a(MmRecordingSlotKey r100, FrameLayout r101, dwb.a r102, Function0<Unit> r103) {
        Fragment r104 = this.f436265b.findFragmentByTag("mm_recording_slot_" + r100.name().toLowerCase(Locale.ROOT));
        if (r104 == null) goto L6;
        this.f436265b.beginTransaction().remove(r104).commitNowAllowingStateLoss();
    L6:
        this.f436275l.remove(r100);
        r101.removeAllViews();
        if (r102 != null) goto L10;
        r103.invoke();
        return;
    L10:
        if ((r102 instanceof dwb.a.C5719a) == false) goto L12;
        dwb.a.C5719a r105 = (dwb.a.C5719a) r102;
        throw null;
    L12:
        if ((r102 instanceof dwb.a.b) == false) goto L16;
        View r106 = ((dwb.a.b) r102).f470393a.invoke(this.f436264a.requireContext(), this.f436267d);
        r101.addView(r106, d(r100));
        this.f436275l.put(r100, r106);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public a(Fragment r100, FragmentManager r101, e r102, d r103, Function0<MmRecordingTopBarView> r104, Function0<MmRecordingTitleNameView> r105, Function0<mwb.d> r106, Function0<Unit> r107, Function0<Unit> r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        Intrinsics.checkNotNullParameter(r101, "childFragmentManager");
        Intrinsics.checkNotNullParameter(r102, "recordingView");
        Intrinsics.checkNotNullParameter(r103, "slotScope");
        Intrinsics.checkNotNullParameter(r104, "defaultTopFactory");
        Intrinsics.checkNotNullParameter(r105, "defaultTitleFactory");
        Intrinsics.checkNotNullParameter(r106, "defaultMiddleFactory");
        Intrinsics.checkNotNullParameter(r107, "defaultToolbarBinder");
        Intrinsics.checkNotNullParameter(r110, "onDefaultMiddleAttached");
        Intrinsics.checkNotNullParameter(r111, "onSlotsChanged");
        this.f436264a = r100;
        this.f436265b = r101;
        this.f436266c = r102;
        this.f436267d = r103;
        this.f436268e = r104;
        this.f436269f = r105;
        this.f436270g = r106;
        this.f436271h = r107;
        this.f436272i = r110;
        this.f436273j = r111;
        this.f436274k = new dwb.b(null, null, null, null, 63);
        this.f436275l = new LinkedHashMap();
    }
}
