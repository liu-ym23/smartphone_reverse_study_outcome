package com.bytedance.ee.bear.bitable.card.view.cell.rating;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f208015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableAnalytic f208016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f208017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonActionPanelLayout f208018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Dialog f208019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BTRatingBar f208020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f208021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f208022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f208023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f208024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f208025k;

    public interface a {
        void a();

        void b(Integer r100);

        String getTitle();

        mr4.a o();

        void onDismiss();
    }

    public final BTRatingBar.a a() {
        BTRatingBar.a r100 = new BTRatingBar.a();
        r100.f210048e = this.f208021g;
        r100.f210047d = this.f208024j;
        Integer r101 = this.f208025k;
        r100.f210046c = r101;
        sr4.e r102 = null;
        if (r101 == null) goto L17;
        int r103 = r101.intValue();
        Integer r104 = this.f208024j;
        if (r104 == null) goto L7;
        Integer r105 = Integer.valueOf((r103 - r104.intValue()) + 1);
    L8:
        if (r105 == null) goto L17;
        int r106 = r105.intValue();
        if (r106 > 5) goto L14;
        sr4.e r107 = new sr4.e(38, 12, 9);
    L12:
        r102 = r107;
        goto L17
    L14:
        if (r106 > 8) goto L16;
        r107 = new sr4.e(33, 10, 17);
        goto L12
    L16:
        r107 = new sr4.e(24, 6, 23);
        goto L12
    L7:
        r105 = null;
    L17:
        r100.f210051h = r102;
        r100.f210050g = false;
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r108 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        if (com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.c(this.f208023i) == false) goto L31;
        Integer r109 = this.f208024j;
        if (r109 == null) goto L34;
        int r110 = r109.intValue();
        Integer r111 = this.f208025k;
        if (r111 == null) goto L34;
        int r112 = r111.intValue();
        ArrayList r113 = new ArrayList();
        if (r110 > r112) goto L30;
    L25:
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r114 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r115 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.b(String.valueOf(r110));
        if (r115 == null) goto L28;
        r113.add(r115);
    L28:
        if (r110 == r112) goto L30;
        r110 = r110 + 1;
    L30:
        r100.f210053j = r113;
        r100.f210052i = true;
    L34:
        return r100;
    L31:
        r100.f210052i = false;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.b r116 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.a(this.f208023i);
        if (r116 == null) goto L34;
        r100.f210044a = Integer.valueOf(r116.f210057a);
        r100.f210045b = Integer.valueOf(r116.f210058b);
        goto L34
    }

    public final void dismiss() {
        Dialog r100 = this.f208019e;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    public void show() {
        if (this.f208023i == null) goto L58;
        Unit r100 = null;
        if (this.f208019e != null) goto L49;
        CommonActionPanelLayout r101 = new CommonActionPanelLayout(this.f208015a);
        a r102 = this.f208022h;
        if (r102 == null) goto L9;
        String r103 = r102.getTitle();
    L10:
        r101.setTitle(r103);
        r101.setPanelBackgroundColor(R.color.bg_float);
        r101.setDividerVisible(false);
        r101.setLeftIconVisible(false);
        r101.h(this.f208015a.getString(R.string.Bitable_Common_ButtonDone), Integer.valueOf(R.color.primary_fill_default));
        r101.setOnActionListener(new c(this));
        this.f208018d = r101;
        View r104 = LayoutInflater.from(this.f208015a).inflate(R.layout.bitable_card_rating_edit_panel, null);
        this.f208020f = (BTRatingBar) r104.findViewById(R.id.rating_bar);
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(-1, -2);
        CommonActionPanelLayout r106 = this.f208018d;
        if (r106 == null) goto L13;
        r106.addView(r104, r105);
    L13:
        Object r107 = r104.getParent();
        if ((r107 instanceof View) == false) goto L16;
        View r108 = (View) r107;
    L17:
        if (r108 == null) goto L19;
        r108.setMinimumHeight((int) (((double) n.r(this.f208015a)) * 0.25d));
    L19:
        BTRatingBar r109 = this.f208020f;
        if (r109 == null) goto L22;
        r109.setRatingBarInfo(a());
    L22:
        BTRatingBar r110 = this.f208020f;
        if (r110 == null) goto L26;
        r110.setRatingChangeListener(new e(this));
    L26:
        if (ku5.c.k(this.f208015a) == false) goto L28;
        int r111 = R.style.CustomPadBottomSheetDialog;
    L29:
        CommonActionPanelLayout r112 = this.f208018d;
        if (r112 == null) goto L43;
        Dialog r113 = new Dialog(this.f208015a, r111);
        r113.setContentView(r112);
        Window r114 = r113.getWindow();
        if (r114 == null) goto L35;
        r112.measure(0, 0);
        WindowManager.LayoutParams r115 = r114.getAttributes();
        r115.dimAmount = 0.0f;
        r115.width = -1;
        r115.height = r112.getMeasuredHeight();
        r115.gravity = 80;
        r114.setAttributes(r115);
    L35:
        if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L41;
        int r116 = WatermarkUtils.f209802a;
        a r117 = this.f208022h;
        if (r117 == null) goto L39;
        mr4.a r118 = r117.o();
    L40:
        WatermarkUtils.a(r118, r113);
    L42:
        this.f208019e = r113;
        goto L43
    L39:
        r118 = null;
        goto L40
    L41:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(r113);
    L43:
        Dialog r119 = this.f208019e;
        if (r119 == null) goto L46;
        r119.setOnDismissListener(new d(this));
    L46:
        Dialog r120 = this.f208019e;
        if (r120 == null) goto L49;
        r120.setOnShowListener(new zp4.c(this));
        goto L49
    L28:
        r111 = R.style.CustomBottomSheetDialog;
        goto L29
    L16:
        r108 = null;
        goto L17
    L9:
        r103 = null;
    L49:
        Dialog r121 = this.f208019e;
        if (r121 != null) goto L52;
    L57:
        if (r100 == null) goto L58;
        return;
    L52:
        if (DialogLancet.shouldBlockDialogShow(r121) == false) goto L61;
        DialogLancet.handleBlockedDialogShow(r121);
    L56:
        r100 = Unit.INSTANCE;
        goto L57
    L61:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L55:
        DialogLancet.beforeDialogShow(r121);
        r121.show();
        DialogLancet.afterDialogShow(r121);
    L58:
        tt5.a.d(this.f208017c, " can not show RatingEditPanel: empty ratingIconId");
    }

    public final Context getContext() {
        return this.f208015a;
    }

    public final void update(NumberModel r100) {
        if (r100 == null) goto L6;
        Double r101 = r100.getNumberValue();
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf((int) r101.doubleValue());
    L7:
        this.f208021g = r102;
        BTRatingBar r103 = this.f208020f;
        if (r103 == null) goto L11;
        r103.c(r102);
        return;
    L11:
        return;
    L6:
        r102 = null;
        goto L7
    }

    public final void update(Integer r100) {
        this.f208021g = r100;
        BTRatingBar r101 = this.f208020f;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public b(Context r100, BitableAnalytic r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f208015a = r100;
        this.f208016b = r101;
        this.f208017c = "RatingEditPanel";
    }

    public final void c(String r100, Integer r101, Integer r102) {
        if (TextUtils.equals(r100, this.f208023i) == true) goto L5;
    L9:
        if (r100 != null) goto L11;
        r100 = ScoreTags.SCORE_TYPE_STAR;
    L11:
        this.f208023i = r100;
        if (r101 != null) goto L14;
        r101 = 1;
    L14:
        this.f208024j = r101;
        if (r102 != null) goto L17;
        r102 = 5;
    L17:
        this.f208025k = r102;
        BTRatingBar r103 = this.f208020f;
        if (r103 == null) goto L21;
        r103.setRatingBarInfo(a());
        return;
    L21:
        return;
    L5:
        if (Intrinsics.areEqual(r101, this.f208024j) == false) goto L9;
        if (Intrinsics.areEqual(r102, this.f208025k) == false) goto L9;
    }
}
