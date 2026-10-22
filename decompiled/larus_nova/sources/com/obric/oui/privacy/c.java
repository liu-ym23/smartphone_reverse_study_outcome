package com.obric.oui.privacy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.privacy.adapter.PrivacySheetAdapter;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f402469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f402470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OSheet f402471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PrivacyTopDownAlphaMaskRecyclerView f402472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f402473e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        OSheet r100 = this.f402471c;     // Catch: Exception -> L7
        if (r100 == null) goto L10;
        a(r100);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final void d() {
        int r100 = 0;
        OSheet r101 = new OSheet(this.f402469a, 0, false, 14);
        OSheetBase.DefaultImpls.q(r101, OSheet.HeightMode.FULL_HEIGHT);
        r101.setCanceledOnTouchOutside(false);
        r101.setCancelable(false);
        OSheetBase.DefaultImpls.r(r101, ContextCompat.getColor(r101.getContext(), R.color.oui_bg_base_2));
        String r102 = this.f402470b.f402485c;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        AttributeSet r104 = null;
        if (r103 == true) goto L16;
        OTextView r105 = new OTextView(new ContextThemeWrapper(this.f402469a, R.style.Body_1_Regular), null, 0, 14);
        r105.setIncludeFontPadding(true);
        r105.setTextColor(ContextCompat.getColor(r105.getContext(), R.color.oui_basic_text_3));
        r105.setText(this.f402470b.f402485c);
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L14;
        int r110 = 17;
    L15:
        r105.setGravity(r110);
        r105.setMaxLines(3);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -2);
        r111.topMargin = pla.d.c(r105.getContext(), 8);
        r105.setLayoutParams(r111);
    L17:
        LinearLayout r112 = new LinearLayout(this.f402469a);
        r112.setOrientation(1);
        r112.setGravity(1);
        r112.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OImageAppIcon r113 = new OImageAppIcon(this.f402469a, null, 6, 0);
        int r106 = r113.getContext().getResources().getDimensionPixelSize(R.dimen.oui_image_size_xl);
        r113.setLayoutParams(new LinearLayout.LayoutParams(r106, r106));
        String r107 = this.f402470b.f402483a;
        if (r107 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        if (r108 == true) goto L26;
        r113.setImagePackageName(this.f402470b.f402483a);
    L26:
        r112.addView(r113);
        LinearLayout r109 = new LinearLayout(this.f402469a);
        r109.setOrientation(1);
        r109.setGravity(1);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-1, -2);
        r114.leftMargin = pla.d.c(r109.getContext(), 32);
        r114.rightMargin = pla.d.c(r109.getContext(), 32);
        r114.topMargin = pla.d.c(r109.getContext(), 20);
        r109.setLayoutParams(r114);
        OTextView r115 = new OTextView(new ContextThemeWrapper(this.f402469a, R.style.Title_4_Bold), null, 0, 14);
        r115.setIncludeFontPadding(true);
        r115.setTextColor(ContextCompat.getColor(r115.getContext(), R.color.oui_basic_text_1));
        r115.setText(this.f402470b.f402484b);
        r115.setGravity(17);
        r115.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r109.addView(r115);
        if (r105 == null) goto L29;
        r109.addView(r105);
    L29:
        r112.addView(r109);
        Size r116 = zma.a.c(r112.getContext());
        int r117 = pla.d.k(r101.getContext(), r116.getHeight());
        if (r105 != null) goto L32;
        int r118 = 0;
    L33:
        c(r117, r112, r116, r118);
        OSheetBase.DefaultImpls.p(r101, r112);
        int r119 = pla.d.k(this.f402469a, zma.a.c(this.f402469a).getHeight());
        FrameLayout r120 = new FrameLayout(this.f402469a);
        FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams(-1, -1);
        r121.bottomMargin = pla.d.c(r120.getContext(), 8);
        r120.setLayoutParams(r121);
        PrivacyTopDownAlphaMaskRecyclerView r122 = new PrivacyTopDownAlphaMaskRecyclerView(this.f402469a, r104, 6, r100);
        r122.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r119 <= 650) goto L36;
        r122.setPadding(0, pla.d.c(r122.getContext(), 16), 0, pla.d.c(r122.getContext(), 16));
    L37:
        r122.setFadeEdgeLength(pla.d.e(r122.getContext(), 75));
        r122.setFadeTop(true);
        r122.setFadeBottom(true);
        r122.setDynamicFade(true);
        r122.setBackgroundColor(0);
        r122.setClipToPadding(false);
        r122.getContext();
        r122.setLayoutManager(new LinearLayoutManager(1));
        r122.setAdapter(new PrivacySheetAdapter(this.f402470b.f402486d));
        r122.i(new d(this, r122));
        this.f402472d = r122;
        r120.addView(r122);
        OSheetBase.DefaultImpls.j(r101, r120);
        LinearLayout r123 = new LinearLayout(this.f402469a);
        r123.setOrientation(1);
        r123.setGravity(1);
        r123.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r123.setPadding(pla.d.c(r123.getContext(), 20), pla.d.c(r123.getContext(), 16), pla.d.c(r123.getContext(), 20), pla.d.c(r123.getContext(), 8));
        if (this.f402470b.f402487e == null) goto L52;
        OTextView r124 = new OTextView(new ContextThemeWrapper(this.f402469a, R.style.Button_1_Regular), null, 0, 14);
        r124.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r124.setTextColor(ContextCompat.getColor(r124.getContext(), R.color.oui_basic_text_1));
        r124.setGravity(GravityCompat.START);
        h r125 = this.f402470b;
        String r126 = r125.f402487e;
        List<String> r127 = r125.f402488f;
        if ((!r127.isEmpty()) == false) goto L50;
        SpannableString r128 = new SpannableString(r126);
        Iterator<String> r129 = r127.iterator();
    L43:
        if (r129.hasNext() == false) goto L49;
        String r130 = r129.next();
        int r131 = 0;
    L45:
        String r210 = r130;
        SpannableString r132 = r128;
        int r133 = StringsKt.indexOf$default(r126, r130, r131, false, 4, null);
        if (r133 < 0) goto L47;
        int r134 = r210.length() + r133;
        r132.setSpan(new e(this, r210, r124), r133, r134, 33);
        r131 = r134;
        r130 = r210;
        r128 = r132;
        goto L45
    L47:
        r128 = r132;
        goto L43
    L49:
        r124.setText(r128);
        r124.setMovementMethod(LinkMovementMethod.getInstance());
        r124.setHighlightColor(0);
    L51:
        r123.addView(r124);
        goto L52
    L50:
        r124.setText(r126);
    L52:
        LinearLayout r135 = new LinearLayout(this.f402469a);
        r135.setOrientation(1);
        r135.setGravity(1);
        LinearLayout.LayoutParams r136 = new LinearLayout.LayoutParams(-1, -2);
        r136.topMargin = pla.d.c(r135.getContext(), 14);
        r135.setLayoutParams(r136);
        r135.setPadding(pla.d.c(r135.getContext(), 4), 0, pla.d.c(r135.getContext(), 4), 0);
        Context r137 = this.f402469a;
        final String r138 = this.f402470b.f402489g;
        if (r138 != null) goto L55;
        r138 = r137.getString(R.string.oui_agree);
    L55:
        final Function1<View, Unit> r139 = new OPrivacySheet$buildFooterView$agreeButton$1(this);
        r135.addView((OButton) vma.e.a(r137, R.style.OStyleV2_OButton_L_Standard_Primary, new OPrivacySheet$createSingleButton$1(r138, r139)));
        Context r140 = this.f402469a;
        final String r141 = this.f402470b.f402490h;
        if (r141 != null) goto L58;
        r141 = r140.getString(R.string.oui_exit);
    L58:
        final Function1<View, Unit> r142 = new OPrivacySheet$buildFooterView$exitButton$1(this);
        OButton r143 = (OButton) vma.e.a(r140, R.style.OStyleV2_OButton_L_Trans_Neutral, new OPrivacySheet$createSingleButton$1(r141, r142));
        LinearLayout.LayoutParams r144 = new LinearLayout.LayoutParams(-1, -2);
        r144.topMargin = pla.d.c(r143.getContext(), 12);
        r143.setLayoutParams(r144);
        r135.addView(r143);
        r123.addView(r135);
        OSheetBase.DefaultImpls.m(r101, r123);
        r101.f402880g = !this.f402470b.f402491i;
        r101.setOnDismissListener(new com.obric.oui.privacy.a(this));
        if (this.f402470b.f402492j == false) goto L61;
        r101.setOnKeyListener(new b(this));
    L61:
        r101.f402894u = new g(this, r112, r118);
        this.f402471c = r101;
        r101.f402882i = this.f402470b.f402493k;
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L68;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L68:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L67
    L65:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        return;
    L36:
        r122.setPadding(0, 0, 0, 0);
        goto L37
    L32:
        r105.measure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(r116.getWidth() - (pla.d.c(this.f402469a, 32) * 2), 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        r118 = (RangesKt.coerceAtLeast(r105.getLineCount(), 1) - 1) * r105.getLineHeight();
        goto L33
    L20:
        if (StringsKt.isBlank(r107) == true) goto L23;
        r108 = false;
        goto L24
    L14:
        r110 = GravityCompat.START;
        goto L15
    L16:
        r105 = null;
        goto L17
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static void a(OSheet r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public c(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f402469a = r100;
        this.f402470b = r101;
    }

    public static void c(int r100, View r101, Size r102, int r103) {
        if (r100 <= 650) goto L5;
        r101.setPadding(0, (int) (r102.getHeight() * 0.135f), 0, (int) ((r102.getHeight() * 0.10375f) - r103));
        return;
    L5:
        r101.setPadding(0, pla.d.n(r101, 20), 0, pla.d.n(r101, 12));
    }
}
