package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view.TuningMusicControlContainer;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.utils.k1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements fc0.a {
    public final CompositeDisposable a;
    public Disposable b;
    public final ec0.a c;
    public TuningMusicControlContainer d;

    public final void c() {
        ec0.a r0 = this.c;
        long r1 = 0;
        if (r0 == null) goto L5;
        long r3 = r0.o();
    L6:
        SimpleDateFormat r2 = new SimpleDateFormat("mm:ss", Locale.US);
        ec0.a r5 = this.c;
        if (r5 == null) goto L9;
        r1 = r5.c();
    L9:
        String r6 = s1.C(2131918614, new Object[]{r2.format(Long.valueOf(r3)), r2.format(Long.valueOf(r1))});
        SpannableString r4 = new SpannableString(r6);
        r4.setSpan(new ForegroundColorSpan(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.y)), 0, StringsKt.indexOf$default(r6, "/", 0, false, 6, null), 34);
        TuningMusicControlContainer r7 = this.d;
        if (r7 == null) goto L15;
        TextView r8 = r7.getCurPlayTime();
        if (r8 == null) goto L16;
        r8.setText(r4);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void d() {
        ec0.a r0 = this.c;
        if (r0 != null) goto L5;
    L16:
        TuningMusicControlContainer r1 = this.d;
        if (r1 == null) goto L21;
        TextView r2 = r1.getPauseRestartTv();
        if (r2 == null) goto L21;
        r2.setText(s1.B(2131918605));
    L21:
        TuningMusicControlContainer r3 = this.d;
        if (r3 == null) goto L30;
        View r4 = r3.getPauseRestartImg();
        if (r4 == null) goto L31;
        r4.setSelected(true);
        return;
    L31:
        return;
    L30:
        return;
    L5:
        if (r0.a() != true) goto L16;
        TuningMusicControlContainer r5 = this.d;
        if (r5 == null) goto L11;
        TextView r6 = r5.getPauseRestartTv();
        if (r6 == null) goto L11;
        r6.setText(s1.B(2131918606));
    L11:
        TuningMusicControlContainer r7 = this.d;
        if (r7 == null) goto L27;
        View r8 = r7.getPauseRestartImg();
        if (r8 == null) goto L28;
        r8.setSelected(false);
        return;
    L28:
        return;
    }

    public final void onClear() {
        this.a.clear();
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        this.d = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public j() {
        this.a = new CompositeDisposable();
        this.c = KSongTuningPanelHelperKt.e();
    }

    public final void a(TuningMusicControlContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "tuningMusicControlContainer");
        this.d = r2;
        if (r2 == null) goto L7;
        TextView r3 = r2.getCurPlayTime();
        if (r3 == null) goto L7;
        r3.setTextColor(ColorProtector.parseColor("#B2B2B2"));
    L7:
        TuningMusicControlContainer r4 = this.d;
        if (r4 == null) goto L13;
        View r5 = r4.getPauseRestartImg();
        if (r5 == null) goto L13;
        KtvOrderSongThemeManager.c(r5, KtvOrderSongThemeManager.z);
    L13:
        if (gh0.a.d() == true) goto L19;
        RealTimeChorusBusinessContext.a r6 = RealTimeChorusBusinessContext.Companion;
        r6.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L19;
        if (r6.j() == false) goto L19;
        boolean r7 = KtvUtilsKt.j();
    L20:
        if (r7 == false) goto L31;
        TuningMusicControlContainer r8 = this.d;
        if (r8 == null) goto L26;
        ConstraintLayout r9 = r8.getCutSongContainer();
        if (r9 == null) goto L26;
        r9.setVisibility(0);
    L26:
        TuningMusicControlContainer r10 = this.d;
        if (r10 == null) goto L42;
        ConstraintLayout r11 = r10.getPauseRestartContainer();
        if (r11 == null) goto L43;
        r11.setVisibility(0);
        return;
    L43:
        return;
    L42:
        return;
    L31:
        TuningMusicControlContainer r12 = this.d;
        if (r12 == null) goto L36;
        ConstraintLayout r13 = r12.getCutSongContainer();
        if (r13 == null) goto L36;
        r13.setVisibility(8);
    L36:
        TuningMusicControlContainer r14 = this.d;
        if (r14 == null) goto L45;
        ConstraintLayout r15 = r14.getPauseRestartContainer();
        if (r15 == null) goto L46;
        r15.setVisibility(8);
        return;
    L46:
        return;
    L45:
        return;
    L19:
        r7 = true;
        goto L20
    }

    public final void b(TuningMusicControlContainer r4) {
        Intrinsics.checkNotNullParameter(r4, "tuningMusicControlContainer");
        ec0.a r5 = this.c;
        if (r5 == null) goto L5;
        r5.k();
    L5:
        d();
        TuningMusicControlContainer r6 = this.d;
        if (r6 == null) goto L10;
        ec0.a r0 = this.c;
        if (r0 == null) goto L10;
        r0.p(r6, new e(this));
    L10:
        TuningMusicControlContainer r7 = this.d;
        if (r7 == null) goto L15;
        ConstraintLayout r8 = r7.getCutSongContainer();
        if (r8 == null) goto L15;
        r8.setOnClickListener(new f(this));
    L15:
        TuningMusicControlContainer r9 = this.d;
        if (r9 == null) goto L20;
        ConstraintLayout r10 = r9.getPauseRestartContainer();
        if (r10 == null) goto L20;
        r10.setOnClickListener(new k1(new KSongTuningMusicControlOuterCallback$addTuningMusicControlObserver$3(this), KSongTuningMusicControlOuterCallback$addTuningMusicControlObserver$4.INSTANCE));
    L20:
        TuningMusicControlContainer r11 = this.d;
        if (r11 == null) goto L25;
        Button r12 = r11.getGoKtvDialog();
        if (r12 == null) goto L25;
        r12.setOnClickListener(new g(this));
    L25:
        c();
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r13 = KtvContext.a.g().getKtvCoreController();
        if (r13 == null) goto L32;
        Observable r14 = r13.a();
        if (r14 == null) goto L32;
        Disposable r15 = r14.subscribe(new h(this));
        if (r15 == null) goto L32;
        RxUtilKt.c(r15, this.a);
    L32:
        Disposable r16 = this.b;
        if (r16 != null) goto L35;
    L37:
        ALogger.d("ttlive_ktv_realTimeChorus_KSongTuningMusicControlOuterCallback", "observePlayProgressEvent");
        ec0.a r17 = this.c;
        if (r17 == null) goto L40;
        Disposable r18 = r17.n(new i(this));
    L41:
        this.b = r18;
        return;
    L40:
        r18 = null;
        goto L41
    L35:
        if (r16.isDisposed() == true) goto L37;
        r16.dispose();
        goto L37
    }
}
