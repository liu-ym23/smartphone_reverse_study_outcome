package com.bytedance.ug.sdk.luckydog.task.tasktimer.view;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.ug.sdk.luckydog.task.pendant.f;
import com.larus.nova.R;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class LuckyCommonPendantView extends com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f272268n = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHandler f272269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimerTaskPendantState f272270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f272271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f272272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hm7.a f272273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bitmap f272274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bitmap f272275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f272276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f272277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f272278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final tk7.a f272279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f272280m;

    public static final class a {
    }

    static {
    }

    public final View b(int r100) {
        if (this.f272280m != null) goto L5;
        this.f272280m = new HashMap();
    L5:
        View r101 = (View) this.f272280m.get(Integer.valueOf(r100));
        if (r101 != null) goto L9;
        View r102 = findViewById(r100);
        this.f272280m.put(Integer.valueOf(r100), r102);
        return r102;
    L9:
        return r101;
    }

    public final void h() {
    L15:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyCommonPendantView", "setProgressColor(), " + e.getMessage());
        return;
    L3:
        if (this.f272273f.h() == false) goto L13;
        ((ProgressBar) b(R.id.lucky_common_pendant_progressbar)).setVisibility(0);     // Catch: Exception -> L15
        GradientDrawable r100 = new GradientDrawable();     // Catch: Exception -> L15
        r100.setCornerRadius(UIUtils.dip2Px(getContext(), 2.5f));     // Catch: Exception -> L15
        if (f(this.f272273f.f()) == false) goto L7;
        r100.setColor(Color.parseColor(this.f272273f.f()));     // Catch: Exception -> L15
    L8:
        ((ProgressBar) b(R.id.lucky_common_pendant_progressbar)).setBackground(r100);     // Catch: Exception -> L15
        GradientDrawable r101 = new GradientDrawable();     // Catch: Exception -> L15
        r101.setCornerRadius(UIUtils.dip2Px(getContext(), 2.5f));     // Catch: Exception -> L15
        if (f(this.f272273f.g()) == false) goto L11;
        r101.setColor(Color.parseColor(this.f272273f.g()));     // Catch: Exception -> L15
    L12:
        ((ProgressBar) b(R.id.lucky_common_pendant_progressbar)).setProgressDrawable(new ClipDrawable(r101, GravityCompat.START, 1));     // Catch: Exception -> L15
        return;
    L11:
        r101.setColor(getContext().getResources().getColor(R.color.luckydog_FFD580));     // Catch: Exception -> L15
        goto L12
    L7:
        r100.setColor(getContext().getResources().getColor(R.color.luckydog_CB1A16));     // Catch: Exception -> L15
        goto L8
    L13:
        ((ProgressBar) b(R.id.lucky_common_pendant_progressbar)).setVisibility(8);     // Catch: Exception -> L15
    }

    public final void j() {
        if (this.f272273f.h() == false) goto L16;
        TimerTaskPendantState r100 = this.f272270c;
        int r101 = b.f272284b[r100.ordinal()];
        if (r101 != 1) goto L7;
    L14:
        ((ProgressBar) b(R.id.lucky_common_pendant_progressbar)).setProgress((this.f272272e * 100) / this.f272271d);
        return;
    L7:
        if (r101 == 2) goto L14;
        if (r101 == 3) goto L14;
        if (r101 != 4) goto L18;
        ((ProgressBar) b(R.id.lucky_common_pendant_progressbar)).setVisibility(8);
        return;
    L18:
        return;
    }

    public final void i() {
        TextView r100 = (TextView) b(R.id.lucky_common_pendant_content);
        if (((ProgressBar) b(R.id.lucky_common_pendant_progressbar)).getVisibility() != 0) goto L5;
        int r101 = 1;
    L6:
        r100.setMaxLines(r101);
        int r102 = b.f272283a[this.f272270c.ordinal()];
        if (r102 == 1) goto L34;
        if (r102 != 2) goto L10;
    L25:
        int r103 = this.f272271d - this.f272272e;
        int r104 = r103 / 60;
        int r105 = r103 % 60;
        if (r104 <= 0) goto L32;
        StringBuilder r106 = new StringBuilder();
        r106.append(r104);
        r106.append(':');
        if (r105 < 10) goto L30;
        Object r107 = Integer.valueOf(r105);
    L31:
        r106.append(r107);
        String r108 = r106.toString();
    L33:
        ((TextView) b(R.id.lucky_common_pendant_content)).setText(this.f272270c.getTipsContext() + r108);
        return;
    L30:
        r107 = "0" + r105;
        goto L31
    L32:
        StringBuilder r109 = new StringBuilder();
        r109.append(r105);
        r109.append(31186);
        r108 = r109.toString();
        goto L33
    L10:
        if (r102 == 3) goto L25;
        if (r102 != 4) goto L38;
        ((TextView) b(R.id.lucky_common_pendant_content)).setText(this.f272270c.getTipsContext());
        WeakHandler r110 = this.f272269b;
        String r111 = this.f272273f.i();
        if (r111 != null) goto L17;
    L20:
        boolean r112 = true;
    L21:
        if (r112 == false) goto L23;
        long r113 = 3000;
    L24:
        r110.sendEmptyMessageDelayed(1, r113);
        return;
    L23:
        r113 = 30000;
        goto L24
    L17:
        if (r111.length() == 0) goto L20;
        r112 = false;
        goto L21
    L38:
        return;
    L34:
        ((TextView) b(R.id.lucky_common_pendant_content)).setText(this.f272270c.getTipsContext());
        return;
    L5:
        r101 = 2;
        goto L6
    }

    @Override // com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f272269b.removeCallbacksAndMessages(null);
    }

    public static final void c(LuckyCommonPendantView r110) {
        r110.getClass();
        LayoutInflater.from(r110.getContext()).inflate(R.layout.lucky_common_pendant_view, r110, true);     // Catch: Throwable -> L5
    L6:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCommonPendantView", "initPendant() is called");
    L12:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyCommonPendantView", "setPendant(), " + e.getMessage());
    L14:
        hm7.e r100 = r110.f272273f.m();
        if (r100 != null) goto L17;
        return;
    L17:
        if (r100.d() == false) goto L55;
        int r101 = 3;
        if (r110.f272272e < 3) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r100.b()) == true) goto L57;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCommonPendantView", "show tips");
    L46:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyCommonPendantView", "setTips(), " + e.getMessage());
        return;
    L24:
        if (r110.f272276i == false) goto L28;
        ((ViewStub) r110.findViewById(R.id.lucky_cp_right_viewstub)).inflate();     // Catch: Exception -> L46
        ((ImageView) r110.b(R.id.lucky_common_pendant_right_arrow)).setVisibility(8);     // Catch: Exception -> L46
        ((ImageView) r110.b(R.id.lucky_common_pendant_left_arrow)).setVisibility(0);     // Catch: Exception -> L46
        String r102 = e(r100.a());     // Catch: Exception -> L46
        if (r102 == null) goto L32;
        ((ImageView) r110.b(R.id.lucky_common_pendant_left_arrow)).setColorFilter(Color.parseColor(r102));     // Catch: Exception -> L46
    L32:
        if (r100.e() <= 0) goto L34;
        r101 = (int) r100.e();     // Catch: Exception -> L46
    L34:
        r110.f272269b.sendEmptyMessageDelayed(0, ((long) r101) * 1000);     // Catch: Exception -> L46
        if (((ImageView) r110.b(R.id.lucky_common_pendant_icon)).getVisibility() != 0) goto L41;
        ViewGroup.LayoutParams r103 = ((LinearLayout) r110.b(R.id.lucky_common_pendant_tips_layout)).getLayoutParams();     // Catch: Exception -> L46
        if (r103 == null) goto L40;
        ((LinearLayout.LayoutParams) r103).topMargin = (int) UIUtils.dip2Px(r110.getContext(), 13.0f);     // Catch: Exception -> L46
        goto L41
    L40:
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");     // Catch: Exception -> L46
    L41:
        ((TextView) r110.b(R.id.lucky_common_pendant_tips_tv)).setText(r100.b());     // Catch: Exception -> L46
        if (f(r100.c()) == false) goto L44;
        ((TextView) r110.b(R.id.lucky_common_pendant_tips_tv)).setTextColor(Color.parseColor(r100.c()));     // Catch: Exception -> L46
    L44:
        r110.g((TextView) r110.b(R.id.lucky_common_pendant_tips_tv), r100.a(), false);     // Catch: Exception -> L46
        return;
    L28:
        ((ViewStub) r110.findViewById(R.id.lucky_cp_left_viewstub)).inflate();     // Catch: Exception -> L46
        ((ImageView) r110.b(R.id.lucky_common_pendant_left_arrow)).setVisibility(8);     // Catch: Exception -> L46
        ((ImageView) r110.b(R.id.lucky_common_pendant_right_arrow)).setVisibility(0);     // Catch: Exception -> L46
        String r104 = e(r100.a());     // Catch: Exception -> L46
        if (r104 == null) goto L32;
        ((ImageView) r110.b(R.id.lucky_common_pendant_right_arrow)).setColorFilter(Color.parseColor(r104));     // Catch: Exception -> L46
        goto L32
    L57:
        return;
    L55:
        return;
    L8:
        if (f(r110.f272273f.l()) == false) goto L10;
        ((TextView) r110.b(R.id.lucky_common_pendant_content)).setTextColor(Color.parseColor(r110.f272273f.l()));     // Catch: Exception -> L12
    L10:
        r110.g((LinearLayout) r110.b(R.id.lucky_common_pendant_content_layout), r110.f272273f.k(), true);     // Catch: Exception -> L12
        r110.h();     // Catch: Exception -> L12
        r110.j();     // Catch: Exception -> L12
        r110.i();     // Catch: Exception -> L12
        r110.setIcon(true);     // Catch: Exception -> L12
        ((RelativeLayout) r110.b(R.id.lucky_common_pendant_layout)).setOnClickListener(new c(r110));     // Catch: Exception -> L12
        ((ImageView) r110.b(R.id.lucky_common_pendant_close_icon)).setOnClickListener(new d(r110));     // Catch: Exception -> L12
    L5:
        Application r105 = m.f538347a;
        LayoutInflater.from(m.g()).inflate(R.layout.lucky_common_pendant_view, r110, true);
        goto L6
    }

    public static final /* synthetic */ void d(LuckyCommonPendantView r100) {
        r100.setIcon(false);
    }

    public static String e(List r110) {
        List r100 = r110;
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return null;
    L11:
        if (r110.size() <= 1) goto L23;
        if (f((String) ListProtector.get(r110, 0)) == true) goto L15;
        return null;
    L15:
        if (f((String) ListProtector.get(r110, 1)) == false) goto L30;
        String r103 = StringsKt.replace$default((String) ListProtector.get(r110, 0), "#", "", false, 4, null);
        String r111 = StringsKt.replace$default((String) ListProtector.get(r110, 1), "#", "", false, 4, null);
        StringBuffer r104 = new StringBuffer("#");
        int r105 = 0;
    L18:
        if (r101 >= r103.length()) goto L21;
        int r106 = r105 + 1;
        r104.append(Integer.toHexString(CastIntegerProtector.parseInt(new BigInteger(String.valueOf((CastIntegerProtector.valueOf(new BigInteger(String.valueOf(r103.charAt(r101)), 16).toString()).intValue() + CastIntegerProtector.valueOf(new BigInteger(String.valueOf(r111.charAt(r105)), 16).toString()).intValue()) / 2), 10).toString())));
        r101 = r101 + 1;
        r105 = r106;
        goto L18
    L21:
        return r104.toString();
    L30:
        return null;
    L23:
        if (f((String) ListProtector.get(r110, 0)) == true) goto L25;
        return null;
    L25:
        return (String) ListProtector.get(r110, 0);
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static boolean f(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L15:
        return false;
    L11:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L15;
        if (r100.length() != 7) goto L15;
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    private final void setIcon(boolean r100) {
        TimerTaskPendantState r101 = this.f272270c;
        if (b.f272285c[r101.ordinal()] == 1) goto L37;
        if (r100 == false) goto L45;
        Bitmap r102 = this.f272274g;
        if (r102 != null) goto L8;
    L10:
        Bitmap r103 = this.f272275h;
        if (r103 != null) goto L13;
    L15:
        ((ImageView) b(R.id.lucky_common_pendant_icon)).setVisibility(8);
    L44:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L31
        if (this.f272274g == null) goto L19;
    L29:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L46;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("LuckyCommonPendantView", r106.getLocalizedMessage(), r106);
        return;
    L46:
        return;
    L19:
        if (this.f272275h != null) goto L29;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCommonPendantView", "图片获取失败，重新安排关闭按钮的layout");     // Catch: Throwable -> L31
        ((ImageView) b(R.id.lucky_common_pendant_icon)).setVisibility(8);     // Catch: Throwable -> L31
        if (((LinearLayout) b(R.id.lucky_common_pendant_content_layout)).getLayoutParams() != null) goto L23;
        RelativeLayout.LayoutParams r107 = new RelativeLayout.LayoutParams((int) UIUtils.dip2Px(getContext(), 16.0f), (int) UIUtils.dip2Px(getContext(), 16.0f));     // Catch: Throwable -> L31
    L26:
        r107.addRule(3, R.id.lucky_common_pendant_close_icon);     // Catch: Throwable -> L31
        ((LinearLayout) b(R.id.lucky_common_pendant_content_layout)).setLayoutParams(r107);     // Catch: Throwable -> L31
        goto L29
    L23:
        ViewGroup.LayoutParams r108 = ((LinearLayout) b(R.id.lucky_common_pendant_content_layout)).getLayoutParams();     // Catch: Throwable -> L31
        if (r108 == null) goto L28;
        r107 = (RelativeLayout.LayoutParams) r108;     // Catch: Throwable -> L31
        goto L26
    L28:
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L13:
        if (r103.isRecycled() == true) goto L15;
        ((ImageView) b(R.id.lucky_common_pendant_icon)).setVisibility(0);
        ((ImageView) b(R.id.lucky_common_pendant_icon)).setImageBitmap(this.f272275h);
        goto L44
    L8:
        if (r102.isRecycled() == true) goto L10;
        ((ImageView) b(R.id.lucky_common_pendant_icon)).setVisibility(0);
        ((ImageView) b(R.id.lucky_common_pendant_icon)).setImageBitmap(this.f272274g);
        goto L44
    L45:
        return;
    L37:
        if (((ImageView) b(R.id.lucky_common_pendant_icon)).getVisibility() != 0) goto L48;
        Bitmap r110 = this.f272275h;
        if (r110 != null) goto L41;
        return;
    L41:
        if (r110.isRecycled() == true) goto L50;
        ((ImageView) b(R.id.lucky_common_pendant_icon)).setImageBitmap(this.f272275h);
        return;
    L50:
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.what);
    L5:
        if (r101 != null) goto L8;
    L10:
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.intValue() != 1) goto L17;
        this.f272277j.invoke();
        return;
    L17:
        return;
    L8:
        if (r101.intValue() != 0) goto L10;
        ((LinearLayout) b(R.id.lucky_common_pendant_tips_layout)).setVisibility(8);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public LuckyCommonPendantView(Context r100, hm7.c r101, FrameLayout.LayoutParams r102) {
        super(r100);
        this.f272269b = new WeakHandler(Looper.getMainLooper(), this);
        this.f272277j = LuckyCommonPendantView$fReleasePendant$1.INSTANCE;
        this.f272278k = LuckyCommonPendantView$fHidePendant$1.INSTANCE;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCommonPendantView", "init() is called");
        this.f272270c = r101.f485944c;
        this.f272271d = r101.f485942a;
        this.f272272e = r101.f485943b;
        this.f272273f = r101.f485945d;
        Bitmap r103 = r101.f485947f;
        if (r103 == null) goto L5;
        Bitmap r104 = r103;
    L6:
        this.f272274g = r104;
        Bitmap r105 = r101.f485946e;
        if (r105 == null) goto L9;
        r103 = r105;
    L9:
        this.f272275h = r103;
        this.f272279l = r101.f485948g;
        if ((r102.gravity & 3) != 3) goto L12;
        boolean r106 = true;
    L13:
        this.f272276i = r106;
        f.a(new AnonymousClass2(this));
        return;
    L12:
        r106 = false;
        goto L13
    L5:
        r104 = r101.f485946e;
        goto L6
    }

    public final void g(View r100, List<String> r101, boolean r102) {
        List<String> r103 = r101;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L24;
        return;
    L24:
        int[] r105 = new int[2];     // Catch: Exception -> L21
        r105[0] = Color.parseColor((String) ListProtector.get(r101, 0));     // Catch: Exception -> L21
        if (r101.size() <= 1) goto L15;
        r105[1] = Color.parseColor((String) ListProtector.get(r101, 1));     // Catch: Exception -> L21
    L16:
        GradientDrawable r106 = new GradientDrawable();     // Catch: Exception -> L21
        r106.setShape(0);     // Catch: Exception -> L21
        r106.setGradientType(0);     // Catch: Exception -> L21
        r106.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);     // Catch: Exception -> L21
        r106.setCornerRadius(UIUtils.dip2Px(getContext(), 6.0f));     // Catch: Exception -> L21
        r106.setColors(r105);     // Catch: Exception -> L21
        if (r102 == false) goto L19;
        r106.setStroke((int) UIUtils.dip2Px(getContext(), 1.5f), -1);     // Catch: Exception -> L21
    L19:
        r100.setBackground(r106);     // Catch: Exception -> L21
        return;
    L15:
        r105[1] = r105[0];     // Catch: Exception -> L21
    L21:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyCommonPendantView", "setGradientBgDrawable(), " + e.getMessage());
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.bytedance.ug.sdk.luckydog.task.tasktimer.view.a
    public final void a(TimerTaskPendantState r100, int r101, Function0<Unit> r102, Function0<Unit> r103) {
        this.f272270c = r100;
        this.f272272e = r101;
        this.f272277j = r102;
        this.f272278k = r103;
        f.a(new LuckyCommonPendantView$updatePendantView$1(this));
    }
}
