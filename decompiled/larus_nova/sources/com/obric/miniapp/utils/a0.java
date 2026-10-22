package com.obric.miniapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.lang.ref.WeakReference;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f398434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f398435b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet<Integer> f398436c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<OSheet> f398437d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f398438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f398439b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f398438a, r101.f398438a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f398439b, r101.f398439b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f398438a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Long r104 = this.f398439b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PickerTimestampBounds(minTimestamp=" + this.f398438a + ", maxTimestamp=" + this.f398439b + ')';
        }

        public final long a(long r100) {
            Long r101 = this.f398438a;
            if (r101 != null) goto L5;
        L7:
            Long r102 = this.f398439b;
            if (r102 != null) goto L10;
            return r100;
        L10:
            if (r100 > r102.longValue()) goto L12;
            return r100;
        L12:
            return this.f398439b.longValue();
        L5:
            if (r100 >= r101.longValue()) goto L7;
            return this.f398438a.longValue();
        }

        public a(Long r100, Long r101) {
            this.f398438a = r100;
            this.f398439b = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f398440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OSheet f398441b;

        public b(String r100, OSheet r101) {
            this.f398440a = r100;
            this.f398441b = r101;
        }

        public final void b() {
            a0 r100 = a0.f398434a;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
            FLogger.f375446a.i("DatePickerUtils", "dismissActiveSheet reason=" + this.f398440a);     // Catch: Throwable -> L8
            if (this.f398441b.isShowing() == false) goto L6;
            a(this.f398441b);     // Catch: Throwable -> L8
        L6:
            Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L16;
            FLogger.f375446a.w("DatePickerUtils", "dismissActiveSheet failed: " + r103.getMessage());
            return;
        L16:
            return;
        L8:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public static void a(OSheet r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSheet f398442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f398443b;

        public c(OSheet r100, Function1 r101) {
            this.f398442a = r100;
            this.f398443b = r101;
        }

        public final void a() {
            a0 r100 = a0.f398434a;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
            OSheet r102 = this.f398442a;     // Catch: Throwable -> L11
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r102);     // Catch: Throwable -> L11
        L9:
            Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L22;
            this.f398443b.invoke(r104);
            return;
        L22:
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17 Throwable -> L11
        L8:
            DialogLancet.beforeDialogShow(r102);     // Catch: Throwable -> L11
            r102.show();     // Catch: Throwable -> L11
            DialogLancet.afterDialogShow(r102);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a0() {
    }

    public static long n(long r100) {
        if (0 <= r100) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return r100;
    L10:
        return r100 * ((long) 1000);
    L5:
        if (r100 >= 1000000000000L) goto L7;
        r101 = true;
        goto L8
    }

    static {
        f398434a = new a0();
        f398435b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new h());
        f398436c = new HashSet();
    }

    public static void a(OInsetSheet r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(OSheet r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void c(OInsetSheet r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final Handler d(a0 r100) {
        r100.getClass();
        return (Handler) f398435b.getValue();
    }

    public static void i(OSheet r100) {
        WeakReference<OSheet> r101 = f398437d;
        if (r101 == null) goto L5;
        OSheet r102 = r101.get();
    L6:
        if (r102 != r100) goto L9;
        f398437d = null;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static Activity l(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L10:
        if ((r100 instanceof Activity) == true) goto L16;
        return null;
    L16:
        return (Activity) r100;
    }

    public static LocalDate v(long r100) {
        return Instant.ofEpochMilli(r100).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.time.LocalDateTime] */
    public static LocalDateTime w(long r100) {
        return Instant.ofEpochMilli(r100).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public final void k(String r100) {
        WeakReference<OSheet> r101 = f398437d;
        if (r101 == null) goto L23;
        OSheet r102 = r101.get();
        if (r102 == null) goto L26;
        f398437d = null;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L21;
        d(this).post(new b(r100, r102));
        return;
    L21:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        FLogger.f375446a.i("DatePickerUtils", "dismissActiveSheet reason=".concat(r100));     // Catch: Throwable -> L14
        if (r102.isShowing() == false) goto L12;
        b(r102);     // Catch: Throwable -> L14
    L12:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L24;
        FLogger.f375446a.w("DatePickerUtils", "dismissActiveSheet failed: " + r105.getMessage());
        return;
    L24:
        return;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L26:
        return;
    }

    public static List f(Context r100, int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r100.getString(R.string.oui_reel_picker_day_tag));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        IntRange r105 = new IntRange(1, r101);
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<Integer> r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        r106.add(((IntIterator) r107).nextInt() + r104);
        goto L14
    L16:
        return r106;
    L4:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static FrameLayout j(Context r100, hma.c r101) {
        FrameLayout r102 = new FrameLayout(r100);
        View r103 = r101.a();
        if (r103 == null) goto L12;
        r102.removeAllViews();
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        int r105 = -2;
        if (r104 == null) goto L7;
        int r106 = r104.width;
    L8:
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        if (r107 == null) goto L11;
        r105 = r107.height;
    L11:
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(r106, r105);
        r108.gravity = 17;
        r103.setLayoutParams(r108);
        r102.addView(r103);
        goto L12
    L7:
        r106 = -2;
    L12:
        return r102;
    }

    public static Pair o(JSONObject r100, a r101) {
        if (r100 == null) goto L8;
        String r102 = r100.optString("from");
        if (r102 == null) goto L8;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        if (r100 == null) goto L15;
        String r105 = r100.optString(RemoteMessageConst.TO);
        if (r105 == null) goto L15;
        Integer r106 = StringsKt.toIntOrNull(r105);
        if (r106 == null) goto L15;
        int r107 = r106.intValue();
    L16:
        Long r108 = r101.f398438a;
        if (r108 == null) goto L19;
        long r109 = r108.longValue();
        f398434a.getClass();
        r104 = Math.max(r104, v(r109).getYear());
    L19:
        Long r110 = r101.f398439b;
        if (r110 == null) goto L22;
        long r111 = r110.longValue();
        f398434a.getClass();
        r107 = Math.min(r107, v(r111).getYear());
    L22:
        if (r104 <= r107) goto L25;
        r107 = r104;
    L25:
        return TuplesKt.to(Integer.valueOf(r104), Integer.valueOf(r107));
    L15:
        r107 = 2030;
    L8:
        r104 = 2000;
        goto L9
    }

    public static final Integer r(JSONObject r100, String r101) {
        if (r100 == null) goto L6;
        String r102 = r100.optString(r101);
        if (r102 == null) goto L6;
        return StringsKt.toIntOrNull(r102);
    L6:
        return null;
    }

    public final void u(OSheet r100, Function1<? super Throwable, Unit> r101) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L20;
        d(this).post(new c(r100, r101));
        return;
    L20:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r100);     // Catch: Throwable -> L12
    L10:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L24;
        r101.invoke(r104);
        return;
    L24:
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19 Throwable -> L12
    L9:
        DialogLancet.beforeDialogShow(r100);     // Catch: Throwable -> L12
        r100.show();     // Catch: Throwable -> L12
        DialogLancet.afterDialogShow(r100);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static JSONObject h(String r100, long r101, boolean r110) {
        LocalDateTime r102 = w(r101);
        if (r110 == false) goto L5;
        int r111 = r102.getHour();
    L8:
        int r103 = r102.getMinute();
        if (r102.getHour() >= 12) goto L11;
        boolean r104 = true;
    L12:
        JSONObject r105 = new JSONObject();
        r105.put("date", r102.toLocalDate().toString());
        r105.put(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, r102.getYear());
        r105.put(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, r102.getMonthValue());
        r105.put(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, r102.getDayOfMonth());
        r105.put("hour", r111);
        r105.put("minute", r103);
        r105.put("timestamp", r101);
        r105.put("isAm", r104);
        if (Intrinsics.areEqual(r100, "time_with_am_pm") == false) goto L19;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        Object[] r107 = new Object[3];
        r107[0] = Integer.valueOf(r111);
        r107[1] = Integer.valueOf(r103);
        if (r104 == false) goto L17;
        String r112 = "上午";
    L18:
        r107[2] = r112;
        r105.put("formatted", String.format("%02d:%02d %s", Arrays.copyOf(r107, 3)));
    L20:
        return r105;
    L17:
        r112 = "下午";
        goto L18
    L19:
        StringCompanionObject r108 = StringCompanionObject.INSTANCE;
        r105.put("formatted", String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r111), Integer.valueOf(r103)}, 2)));
        goto L20
    L11:
        r104 = false;
        goto L12
    L5:
        r111 = r102.getHour() % 12;
        if (r111 != 0) goto L8;
        r111 = 12;
        goto L8
    }

    public static OSelectionPanelBtnView m(Context r100, View.OnClickListener r101, View.OnClickListener r102) {
        OSelectionPanelBtnView r103 = new OSelectionPanelBtnView(r100, null);
        r103.getBtnNegative().setText("取消");
        r103.getBtnPositive().setText("确认");
        r103.getBtnNegative().setOnClickListener(r101);
        r103.getBtnPositive().setOnClickListener(r102);
        return r103;
    }

    public static final void s(AtomicBoolean r100, g r101, Long r102) {
        if (r100.compareAndSet(false, true) == false) goto L7;
        if (r101 == null) goto L8;
        r101.a(r102);
        return;
    L8:
        return;
    }

    public static final void t(AtomicBoolean r100, g r101, Long r102) {
        if (r100.compareAndSet(false, true) == false) goto L7;
        if (r101 == null) goto L8;
        r101.a(r102);
        return;
    L8:
        return;
    }

    public static final void q(AtomicBoolean r100, Function3<? super Boolean, ? super JSONObject, ? super Map<Integer, Integer>, Unit> r101, boolean r102, JSONObject r103, Map<Integer, Integer> r104) {
        if (r100.compareAndSet(false, true) == false) goto L6;
        r101.invoke(Boolean.valueOf(r102), r103, r104);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.time.ZonedDateTime] */
    public static long g(String r100, LocalDate r101, int r102, int r103, Integer r104, boolean r105) {
        if (r105 == true) goto L6;
        r102 = r102 + 1;
    L6:
        if (Intrinsics.areEqual(r100, "time_with_am_pm") == false) goto L23;
        if (r105 == true) goto L28;
        if (r104 != null) goto L12;
    L15:
        if (r104 != null) goto L18;
    L20:
        if (r102 != 12) goto L22;
        r102 = 12;
        goto L28
    L22:
        r102 = r102 + 12;
        goto L28
    L18:
        if (r104.intValue() != 0) goto L20;
    L12:
        if (r104.intValue() != 0) goto L15;
        if (r102 != 12) goto L15;
    L26:
        r102 = 0;
    L28:
        return r101.atTime(r102, r103).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    L23:
        if (r105 == true) goto L28;
        if (r102 != 12) goto L28;
        goto L26
    }

    public static void e(Context r100, hma.c r101, Map r102, int r103, int r104, int r105, int r110, int r111, int r112) {
        int r106 = System.identityHashCode(r101);
        HashSet<Integer> r107 = f398436c;
        monitor-enter(r107);
    L98:
        th = move-exception;
        throw th;
    L5:
        if (r107.add(Integer.valueOf(r106)) == true) goto L8;
        monitor-exit(r107);
        return;
    L8:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L98
        monitor-exit(r107);
        OReelPickerMulti r109 = r101.a();     // Catch: Throwable -> L89
        Object r113 = null;
        if ((r109 instanceof OReelPickerMulti) == true) goto L15;
        r109 = null;
    L15:
        if (r109 != null) goto L24;
        monitor-enter(r107);
        r107.remove(Integer.valueOf(r106));     // Catch: Throwable -> L20
        monitor-exit(r107);
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        WheelView r114 = r109.L0(2);     // Catch: Throwable -> L89
        if (r114 != null) goto L33;
        monitor-enter(r107);
        r107.remove(Integer.valueOf(r106));     // Catch: Throwable -> L30
        monitor-exit(r107);
        return;
    L30:
        th = move-exception;
        throw th;
    L33:
        if (r102 == null) goto L37;
        Integer r115 = (Integer) r102.get(Integer.valueOf(r103));     // Catch: Throwable -> L89
        if (r115 == null) goto L37;
        r111 = r110 + r115.intValue();     // Catch: Throwable -> L89
    L37:
        boolean r116 = true;
        if (r102 == null) goto L101;
        Integer r117 = (Integer) r102.get(Integer.valueOf(r104));     // Catch: Throwable -> L89
        if (r117 == null) goto L101;
        r112 = r117.intValue() + 1;
    L101:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L45
        Object r119 = Result.m9449constructorimpl(Integer.valueOf(YearMonth.of(r111, r112).lengthOfMonth()));     // Catch: Throwable -> L45
    L48:
        if (Result.m9455isFailureimpl(r119) == true) goto L51;
        r113 = r119;
    L51:
        Integer r120 = (Integer) r113;     // Catch: Throwable -> L89
        if (r120 == null) goto L54;
        int r121 = r120.intValue();     // Catch: Throwable -> L89
    L56:
        if (r102 == null) goto L60;
        Integer r122 = (Integer) r102.get(Integer.valueOf(r105));     // Catch: Throwable -> L89
        if (r122 == null) goto L60;
        int r123 = r122.intValue();     // Catch: Throwable -> L89
    L61:
        int r124 = RangesKt.coerceIn(r123, 0, RangesKt.coerceAtLeast(r121 - 1, 0));     // Catch: Throwable -> L89
        if (r114.getItemSize() == r121) goto L64;
        boolean r125 = true;
    L65:
        if (r123 != r124) goto L68;
        r116 = false;
    L68:
        if (r125 == true) goto L78;
        if (r116 == true) goto L78;
        HashSet<Integer> r126 = f398436c;
        monitor-enter(r126);
        r126.remove(Integer.valueOf(r106));     // Catch: Throwable -> L75
        monitor-exit(r126);
        return;
    L75:
        th = move-exception;
        throw th;
    L78:
        if (r125 == false) goto L80;
        r114.setStartIndex(r124);     // Catch: Throwable -> L89
        r114.setEntries(f(r100, r121));     // Catch: Throwable -> L89
    L81:
        HashSet<Integer> r127 = f398436c;
        monitor-enter(r127);
        r127.remove(Integer.valueOf(r106));     // Catch: Throwable -> L86
        monitor-exit(r127);
        return;
    L86:
        th = move-exception;
        throw th;
    L80:
        r114.i(r124);     // Catch: Throwable -> L89
        goto L81
    L64:
        r125 = false;
    L60:
        r123 = 0;
        goto L61
    L54:
        r121 = 31;
    L45:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L89
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        HashSet<Integer> r129 = f398436c;
        monitor-enter(r129);
        r129.remove(Integer.valueOf(r106));     // Catch: Throwable -> L95
        throw th;
    L95:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r15v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v9 */
    public static void p(a0 r210, Context r211, final String r212, String r213, JSONObject r214, final JSONObject r215, final List r216, final boolean r217, boolean r310, Integer r311, Integer r312, Long r313, Long r314, final com.obric.miniapp.aibridge.a0 r315) {
        r210.getClass();
        Intrinsics.checkNotNullParameter(r211, "ctx");
        Intrinsics.checkNotNullParameter(r212, "type");
        Intrinsics.checkNotNullParameter(r315, "callback");
        r210.k("showAppletShowDatePicker");
        hma.c.a r110 = new hma.c.a();
        if (r213 != null) goto L5;
        String r111 = "选择";
    L6:
        if (r313 == null) goto L8;
        Long r100 = Long.valueOf(n(r313.longValue()));
    L9:
        if (r314 == null) goto L11;
        Long r101 = Long.valueOf(n(r314.longValue()));
    L12:
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (r100.longValue() <= r101.longValue()) goto L17;
        r101 = r100;
    L17:
        a r102 = new a(r100, r101);
        if (r214 == null) goto L36;
        String r103 = r214.optString("date");
        if (r103 == null) goto L36;
        if ((!StringsKt.isBlank(r103)) == true) goto L25;
        r103 = null;
    L25:
        if (r103 == null) goto L36;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L28
        Object r105 = Result.m9449constructorimpl(LocalDate.parse(r103));     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r105) == false) goto L33;
        r105 = null;
    L33:
        LocalDate r106 = (LocalDate) r105;
        if (r106 == null) goto L36;
    L88:
        switch(r212.hashCode()) {
            case -930218263: goto L168;
            case 99228: goto L159;
            case 3560141: goto L118;
            case 3704893: goto L110;
            case 104080000: goto L101;
            case 1126698537: goto L91;
            default: goto L89;
        };
    L89:
        String r112 = r111;
        boolean r113 = false;
        a r114 = r102;
    L103:
        boolean r115 = r113;
    L228:
        r110.g(1007, CollectionsKt.listOf("Unsupported: ".concat(r212)), null, 0, 1.0f, null, null, r211);
        ?? r116 = r115;
    L230:
        if (r311 == null) goto L232;
        int r107 = r311.intValue();
        f398434a.getClass();
        Resources r108 = r211.getResources();
        r110.f486020b = Integer.valueOf((int) ((r107 * WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density) + 0.5f));
    L232:
        if (r312 == null) goto L234;
        int r109 = r312.intValue();
        f398434a.getClass();
        Resources r117 = r211.getResources();
        r110.f486021c = Integer.valueOf((int) ((r109 * WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics()).density) + 0.5f));
    L234:
        final Function1 r118 = null;
        Consumer<hma.c.b> r119 = new r(r118);
        Intrinsics.checkNotNullParameter(r119, "listener");
        r110.f486019a = r119;
        final hma.c r120 = (hma.c) hma.d.a.a(r110, r211);
        FrameLayout r121 = j(r211, r120);
        final AtomicBoolean r122 = new AtomicBoolean(r116);
        Activity r123 = l(r211);
        if (r123 != null) goto L237;
    L246:
        FLogger.f375446a.w("DatePickerUtils", "showAppletShowDatePicker blocked: invalid Activity context");
        q(r122, r315, true, null, null);
        c1.a(r211, r116);
        return;
    L237:
        if (r123.isFinishing() == true) goto L246;
        if (r123.isDestroyed() == true) goto L246;
        final b1 r124 = c1.a(r211, r116);
        f398437d = new WeakReference(r124);
        final a r125 = r114;
        final LocalDate r126 = r106;
        OSheetBase.DefaultImpls.o(r124, OSheet.Header.ACTION, null, r112, null, true, new s(r124, r122, r315), new t(r120, r212, r215, r125, r126, r217, r216, r124, r122, r315), 16134);
        OSheetBase.DefaultImpls.j(r124, r121);
        r124.setOnDismissListener(new u(r124, r122, r315));
        if (DialogLancet.shouldBlockDialogShow(r124) == false) goto L251;
        DialogLancet.handleBlockedDialogShow(r124);
        return;
    L251:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L248
    L245:
        DialogLancet.beforeDialogShow(r124);
        r124.show();
        DialogLancet.afterDialogShow(r124);
        return;
    L101:
        r112 = r111;
        r113 = false;
        r114 = r102;
        if (r212.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH) == false) goto L103;
        Integer r127 = r(r214, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        if (r127 == null) goto L107;
        int r128 = r127.intValue();
    L108:
        r110.f(r211, 1002, Integer.valueOf(RangesKt.coerceIn(r128, 1, 12)), null);
    L167:
        r116 = 0;
        goto L230
    L107:
        r128 = LocalDate.now().getMonthValue();
        goto L108
    L110:
        r112 = r111;
        r115 = false;
        r114 = r102;
        if (r212.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR) == false) goto L228;
        Pair r129 = o(r215, r114);
        int r130 = ((Number) r129.component1()).intValue();
        int r131 = ((Number) r129.component2()).intValue();
        Integer r132 = r(r214, BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR);
        if (r132 == null) goto L116;
        int r133 = r132.intValue();
    L117:
        r110.i(r211, 1001, r130, r131, Integer.valueOf(RangesKt.coerceIn(r133, r130, r131)), null);
        goto L167
    L116:
        r133 = LocalDate.now().getYear();
        goto L117
    L118:
        r112 = r111;
        r114 = r102;
        if (r212.equals("time") == false) goto L170;
        Integer r134 = r(r214, "hour");
        Integer r135 = r(r214, "minute");
        if (r135 == null) goto L124;
        int r136 = r135.intValue();
        int r137 = 59;
    L125:
        int r138 = RangesKt.coerceIn(r136, 0, r137);
        if (r217 == false) goto L132;
        if (r134 == null) goto L129;
        int r139 = r134.intValue();
    L130:
        int r140 = RangesKt.coerceIn(r139, 0, 23);
    L152:
        LocalDateTime r141 = w(r114.a(g(r212, r106, r140, r138, null, r217)));
        if (r217 == false) goto L155;
        int r142 = r141.getHour();
    L158:
        hma.c.a.d(r110, r211, 1004, r217, r310, Integer.valueOf(r142));
        hma.c.a.e(r110, r211, 1005, r310, Integer.valueOf(r141.getMinute()));
        goto L167
    L155:
        r142 = r141.getHour() % 12;
        if (r142 != 0) goto L158;
        r142 = 12;
        goto L158
    L129:
        r139 = LocalDateTime.now().getHour();
        goto L130
    L132:
        if (r134 == null) goto L134;
        int r143 = r134.intValue();
    L135:
        if (1 <= r143) goto L137;
    L139:
        boolean r144 = false;
    L140:
        if (r144 == true) goto L151;
        if (r143 >= 0) goto L144;
    L146:
        boolean r145 = false;
    L147:
        if (r145 == false) goto L150;
        r143 = r143 % 12;
        if (r143 != 0) goto L151;
    L150:
        r143 = 12;
        goto L151
    L144:
        if (r143 >= 24) goto L146;
        r145 = true;
    L151:
        r140 = RangesKt.coerceAtLeast(r143 - 1, 0);
        goto L152
    L137:
        if (r143 >= 13) goto L139;
        r144 = true;
        goto L140
    L134:
        r143 = 12;
        goto L135
    L124:
        r137 = 59;
        r136 = 0;
    L170:
        r115 = false;
        goto L228
    L159:
        r112 = r111;
        r114 = r102;
        if (r212.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY) == false) goto L170;
        Integer r146 = r(r214, BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        if (r146 == null) goto L165;
        int r147 = r146.intValue();
    L166:
        hma.c.a.c(r110, r211, 1003, Integer.valueOf(RangesKt.coerceIn(r147, 1, 31)));
        goto L167
    L165:
        r147 = LocalDate.now().getDayOfMonth();
        goto L166
    L168:
        r112 = r111;
        r114 = r102;
        if (r212.equals("time_with_am_pm") == false) goto L170;
        Integer r148 = r(r214, "hour");
        Integer r149 = r(r214, "minute");
        if (r149 == null) goto L174;
        int r150 = r149.intValue();
        int r151 = 59;
    L175:
        int r152 = RangesKt.coerceIn(r150, 0, r151);
        if (r214 == null) goto L180;
        String r153 = r214.optString("isAm");
        if (r153 == null) goto L180;
        Boolean r154 = StringsKt.toBooleanStrictOrNull(r153);
    L181:
        if (r217 == false) goto L186;
        if (r148 == null) goto L184;
        int r155 = r148.intValue();
    L185:
        int r156 = RangesKt.coerceIn(r155, 0, 23);
    L206:
        if (r154 != null) goto L208;
        if (r148 != null) goto L212;
    L215:
        int r157 = 0;
    L216:
        r116 = 0;
        LocalDateTime r158 = w(r114.a(g(r212, r106, r156, r152, Integer.valueOf(r157), r217)));
        if (r217 == false) goto L219;
        int r159 = r158.getHour();
    L222:
        int r160 = r159;
    L223:
        hma.c.a.d(r110, r211, 1004, r217, r310, Integer.valueOf(r160));
        hma.c.a.e(r110, r211, 1005, r310, Integer.valueOf(r158.getMinute()));
        if (r158.getHour() >= 12) goto L226;
        int r161 = 0;
    L227:
        hma.c.a.b(r110, r211, 1006, Integer.valueOf(r161));
        goto L230
    L226:
        r161 = 1;
        goto L227
    L219:
        r159 = r158.getHour() % 12;
        if (r159 != 0) goto L222;
        r160 = 12;
        goto L223
    L212:
        if (r148.intValue() < 12) goto L215;
    L214:
        r157 = 1;
        goto L216
    L208:
        if (r154.booleanValue() == false) goto L214;
    L184:
        r155 = LocalDateTime.now().getHour();
        goto L185
    L186:
        if (r148 == null) goto L188;
        int r162 = r148.intValue();
    L189:
        if (1 <= r162) goto L191;
    L193:
        boolean r163 = false;
    L194:
        if (r163 == true) goto L205;
        if (r162 >= 0) goto L198;
    L200:
        boolean r164 = false;
    L201:
        if (r164 == false) goto L204;
        r162 = r162 % 12;
        if (r162 != 0) goto L205;
    L204:
        r162 = 12;
        goto L205
    L198:
        if (r162 >= 24) goto L200;
        r164 = true;
    L205:
        r156 = RangesKt.coerceAtLeast(r162 - 1, 0);
        goto L206
    L191:
        if (r162 >= 13) goto L193;
        r163 = true;
        goto L194
    L188:
        r162 = 12;
    L180:
        r154 = null;
        goto L181
    L174:
        r151 = 59;
        r150 = 0;
        goto L175
    L91:
        if (r212.equals("custom_repeat") == false) goto L89;
        if (r216 != null) goto L95;
        List r165 = CollectionsKt.emptyList();
    L96:
        Integer r166 = r(r214, "customIndex");
        if (r166 == null) goto L99;
        int r167 = r166.intValue();
    L100:
        r116 = 0;
        r112 = r111;
        r114 = r102;
        r110.g(1007, r165, null, RangesKt.coerceIn(r167, 0, RangesKt.coerceAtLeast(r165.size() - 1, 0)), 1.0f, null, null, r211);
        goto L230
    L99:
        r167 = 0;
        goto L100
    L95:
        r165 = r216;
    L28:
        th = move-exception;
        Result.Companion r168 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L36:
        if (r214 == null) goto L58;
        Object r169 = r214.opt("timestamp");
        if (r169 == null) goto L58;
        if ((r169 instanceof Number) == false) goto L43;
        a0 r170 = f398434a;
        long r171 = ((Number) r169).longValue();
        r170.getClass();
        Long r172 = Long.valueOf(n(r171));
    L56:
        if (r172 == null) goto L58;
        long r173 = r172.longValue();
        f398434a.getClass();
        r106 = v(r173);
        goto L88
    L43:
        if ((r169 instanceof String) == false) goto L55;
        String r174 = StringsKt.trim((String) r169).toString();
        if (r174.length() <= 0) goto L47;
        boolean r175 = true;
    L48:
        if (r175 == true) goto L51;
        r174 = null;
    L51:
        if (r174 == null) goto L55;
        Long r176 = StringsKt.toLongOrNull(r174);
        if (r176 == null) goto L55;
        a0 r177 = f398434a;
        long r178 = r176.longValue();
        r177.getClass();
        r172 = Long.valueOf(n(r178));
        goto L56
    L47:
        r175 = false;
    L55:
        r172 = null;
    L58:
        if (r214 == null) goto L62;
        String r179 = r214.optString(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR);
        if (r179 == null) goto L62;
        Integer r180 = StringsKt.toIntOrNull(r179);
    L63:
        if (r214 == null) goto L67;
        String r181 = r214.optString(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        if (r181 == null) goto L67;
        Integer r182 = StringsKt.toIntOrNull(r181);
    L68:
        if (r214 == null) goto L72;
        String r183 = r214.optString(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        if (r183 == null) goto L72;
        Integer r184 = StringsKt.toIntOrNull(r183);
    L73:
        if (r180 == null) goto L86;
        if (r182 == null) goto L86;
        if (r184 == null) goto L86;
        Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L78
        Object r186 = Result.m9449constructorimpl(LocalDate.of(r180.intValue(), r182.intValue(), r184.intValue()));     // Catch: Throwable -> L78
    L81:
        if (Result.m9455isFailureimpl(r186) == false) goto L83;
        r186 = null;
    L83:
        r106 = (LocalDate) r186;
        if (r106 == null) goto L86;
    L78:
        th = move-exception;
        Result.Companion r187 = Result.Companion;
        r186 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L86:
        r106 = LocalDate.now();
    L72:
        r184 = null;
    L67:
        r182 = null;
    L62:
        r180 = null;
        goto L63
    L11:
        r101 = null;
        goto L12
    L8:
        r100 = null;
        goto L9
    L5:
        r111 = r213;
        goto L6
    }
}
