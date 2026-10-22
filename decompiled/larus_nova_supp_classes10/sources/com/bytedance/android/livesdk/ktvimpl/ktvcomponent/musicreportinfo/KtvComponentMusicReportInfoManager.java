package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.g0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.h0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.i0;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentEmptyView;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import je2.c;
import je2.d;
import je2.e;
import je2.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvComponentMusicReportInfoManager {
    public Disposable a;
    public Disposable b;
    public Disposable c;
    public Disposable d;
    public Disposable e;
    public final e f;
    public final MutableLiveData g;
    public final MusicReportInfoViewStateObserver h;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/musicreportinfo/KtvComponentMusicReportInfoManager$MusicReportInfoViewStateObserver;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lje2/f;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class MusicReportInfoViewStateObserver implements Observer<f> {
        public final /* synthetic */ KtvComponentMusicReportInfoManager a;

        public MusicReportInfoViewStateObserver(KtvComponentMusicReportInfoManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r17) {
            f r1 = (f) r17;
            String r3 = null;
            if ((r1 instanceof f.b) == false) goto L27;
            e r2 = this.a.f;
            KtvComponentEmptyView r4 = r2.a;
            if (r4 == null) goto L7;
            UtilityKotlinExtentionsKt.t(r4);
        L7:
            TextView r5 = r2.c;
            if (r5 == null) goto L10;
            UtilityKotlinExtentionsKt.t(r5);
        L10:
            TextView r6 = r2.d;
            if (r6 == null) goto L13;
            UtilityKotlinExtentionsKt.t(r6);
        L13:
            i0 r7 = r2.e;
            if (r7 == null) goto L16;
            r7.c();
        L16:
            TextView r8 = r2.f;
            if (r8 == null) goto L19;
            UtilityKotlinExtentionsKt.w(r8);
        L19:
            TextView r9 = this.a.f.f;
            if (r9 == null) goto L275;
            r9.setTextSize(20.0f);
            if (((f.b) r1).a == false) goto L25;
            r3 = s1.B(2131918537);
        L25:
            r9.setText(r3);
            return;
        L275:
            return;
        L27:
            if ((r1 instanceof f.C0147f) == false) goto L58;
            e r10 = this.a.f;
            KtvComponentEmptyView r11 = r10.a;
            if (r11 == null) goto L31;
            UtilityKotlinExtentionsKt.w(r11);
        L31:
            KtvComponentEmptyView r12 = r10.b;
            if (r12 == null) goto L34;
            UtilityKotlinExtentionsKt.t(r12);
        L34:
            TextView r13 = r10.c;
            if (r13 == null) goto L37;
            UtilityKotlinExtentionsKt.t(r13);
        L37:
            TextView r14 = r10.d;
            if (r14 == null) goto L40;
            UtilityKotlinExtentionsKt.t(r14);
        L40:
            i0 r15 = r10.e;
            if (r15 == null) goto L43;
            r15.c();
        L43:
            TextView r16 = r10.f;
            if (r16 == null) goto L46;
            UtilityKotlinExtentionsKt.t(r16);
        L46:
            j r18 = j.l;
            f.C0147f r19 = (f.C0147f) r1;
            KtvMusic r20 = r19.a;
            r18.getClass();
            if (j.d(r20) == false) goto L54;
            KtvComponentEmptyView r21 = r10.a;
            if (r21 == null) goto L51;
            r21.b(r19.a);
        L51:
            KtvComponentEmptyView r22 = r10.a;
            if (r22 == null) goto L277;
            UtilityKotlinExtentionsKt.w(r22);
            return;
        L277:
            return;
        L54:
            KtvComponentEmptyView r23 = r10.a;
            if (r23 == null) goto L279;
            UtilityKotlinExtentionsKt.t(r23);
            return;
        L279:
            return;
        L58:
            if ((r1 instanceof f.g) == false) goto L78;
            e r24 = this.a.f;
            KtvComponentEmptyView r25 = r24.a;
            if (r25 == null) goto L62;
            UtilityKotlinExtentionsKt.t(r25);
        L62:
            KtvComponentEmptyView r26 = r24.b;
            if (r26 == null) goto L65;
            UtilityKotlinExtentionsKt.w(r26);
        L65:
            TextView r27 = r24.c;
            if (r27 == null) goto L68;
            UtilityKotlinExtentionsKt.t(r27);
        L68:
            TextView r28 = r24.d;
            if (r28 == null) goto L71;
            UtilityKotlinExtentionsKt.t(r28);
        L71:
            i0 r29 = r24.e;
            if (r29 == null) goto L74;
            r29.c();
        L74:
            KtvComponentEmptyView r30 = this.a.f.b;
            if (r30 == null) goto L281;
            r30.d(((f.g) r1).a);
            return;
        L281:
            return;
        L78:
            if ((r1 instanceof f.e) == false) goto L110;
            e r31 = this.a.f;
            KtvComponentEmptyView r32 = r31.a;
            if (r32 == null) goto L82;
            UtilityKotlinExtentionsKt.t(r32);
        L82:
            KtvComponentEmptyView r33 = r31.b;
            if (r33 == null) goto L85;
            UtilityKotlinExtentionsKt.t(r33);
        L85:
            TextView r34 = r31.c;
            if (r34 == null) goto L88;
            UtilityKotlinExtentionsKt.w(r34);
        L88:
            TextView r35 = r31.d;
            if (r35 == null) goto L91;
            UtilityKotlinExtentionsKt.t(r35);
        L91:
            i0 r36 = r31.e;
            if (r36 == null) goto L94;
            r36.c();
        L94:
            TextView r37 = r31.f;
            if (r37 == null) goto L97;
            UtilityKotlinExtentionsKt.t(r37);
        L97:
            f.e r38 = (f.e) r1;
            Long r39 = r38.a;
            if (r39 != null) goto L100;
            return;
        L100:
            if (r38.b == null) goto L297;
            TextView r40 = this.a.f.c;
            if (r40 != null) goto L105;
            return;
        L105:
            if (r39.longValue() > 10) goto L107;
            int r41 = 2131252020;
        L108:
            Drawable r42 = s1.m(r41);
            r42.setBounds(0, 0, UtilityKotlinExtentionsKt.i(12), UtilityKotlinExtentionsKt.i(12));
            r40.setCompoundDrawables(r42, null, null, null);
            r40.setCompoundDrawablePadding(UtilityKotlinExtentionsKt.i(1));
            r40.setText(String.valueOf(KtvUtilsKt.e(r38.a.longValue())));
            r40.setTextColor(ColorProtector.parseColor(r38.b));
            return;
        L107:
            r41 = 2131252021;
            goto L108
        L297:
            return;
        L110:
            if ((r1 instanceof f.c) == false) goto L133;
            e r43 = this.a.f;
            KtvComponentEmptyView r44 = r43.a;
            if (r44 == null) goto L114;
            UtilityKotlinExtentionsKt.t(r44);
        L114:
            KtvComponentEmptyView r45 = r43.b;
            if (r45 == null) goto L117;
            UtilityKotlinExtentionsKt.t(r45);
        L117:
            TextView r46 = r43.c;
            if (r46 == null) goto L120;
            UtilityKotlinExtentionsKt.t(r46);
        L120:
            TextView r47 = r43.d;
            if (r47 == null) goto L123;
            UtilityKotlinExtentionsKt.w(r47);
        L123:
            i0 r48 = r43.e;
            if (r48 == null) goto L126;
            r48.c();
        L126:
            TextView r49 = r43.f;
            if (r49 == null) goto L129;
            UtilityKotlinExtentionsKt.t(r49);
        L129:
            TextView r50 = this.a.f.d;
            if (r50 == null) goto L286;
            r50.setText(((f.c) r1).a);
            return;
        L286:
            return;
        L133:
            if ((r1 instanceof f.d) == false) goto L255;
            e r51 = this.a.f;
            KtvComponentEmptyView r52 = r51.a;
            if (r52 == null) goto L137;
            UtilityKotlinExtentionsKt.t(r52);
        L137:
            KtvComponentEmptyView r53 = r51.b;
            if (r53 == null) goto L140;
            UtilityKotlinExtentionsKt.t(r53);
        L140:
            TextView r54 = r51.c;
            if (r54 == null) goto L143;
            UtilityKotlinExtentionsKt.t(r54);
        L143:
            TextView r55 = r51.d;
            if (r55 == null) goto L146;
            UtilityKotlinExtentionsKt.t(r55);
        L146:
            i0 r56 = r51.e;
            if (r56 == null) goto L149;
            r56.c();
        L149:
            TextView r57 = r51.f;
            if (r57 == null) goto L152;
            UtilityKotlinExtentionsKt.t(r57);
        L152:
            f.d r58 = (f.d) r1;
            j r59 = j.l;
            Long r60 = r58.a.i();
            r59.getClass();
            if (j.e(r60) == true) goto L155;
            return;
        L155:
            if (r58.a.l() == false) goto L205;
            i0 r61 = this.a.f.e;
            if (r61 == null) goto L289;
            float r62 = r58.a.g();
            String r110 = r58.a.j();
            String r63 = r58.a.f();
            ConstraintLayout r111 = r61.d;
            if (r111 == null) goto L161;
            r111.setVisibility(0);
        L161:
            TextView r112 = r61.f;
            if (r112 == null) goto L164;
            r112.getViewTreeObserver().addOnGlobalLayoutListener(new g0(r112, r61));
        L164:
            TextView r113 = r61.e;
            if (r113 == null) goto L167;
            r113.getViewTreeObserver().addOnGlobalLayoutListener(new h0(r113, r61));
        L167:
            ImageView r114 = r61.g;
            if (r114 == null) goto L170;
            r114.setVisibility(0);
        L170:
            int r64 = (int) r62;
            TextView r115 = r61.e;
            if (r115 == null) goto L173;
            StringBuilder r116 = new StringBuilder();
            r116.append(r64);
            r116.append(' ');
            r115.setText(r116.toString());
        L173:
            if (r63 != null) goto L175;
        L178:
            boolean r65 = true;
        L179:
            if (r65 == false) goto L181;
        L183:
            if (r110 != null) goto L185;
        L188:
            boolean r66 = true;
        L189:
            if (r66 == false) goto L191;
        L193:
            TextView r67 = r61.c;
            if (r67 == null) goto L196;
            r67.setText(s1.C(2131918321, new Object[]{r63}));
        L196:
            TextView r68 = r61.b;
            if (r68 == null) goto L199;
            r68.setText(s1.C(2131918526, new Object[]{r110}));
        L199:
            ImageView r69 = r61.a;
            if (r69 == null) goto L202;
            r69.setVisibility(0);
        L202:
            ConstraintLayout r70 = r61.d;
            if (r70 == null) goto L290;
            r70.setBackground(s1.m(2131252038));
            return;
        L290:
            return;
        L191:
            if (r110.length() <= 6) goto L193;
            r110 = r110.subSequence(0, 6) + "...";
            goto L193
        L185:
            if (r110.length() == 0) goto L188;
            r66 = false;
            goto L189
        L181:
            if (r63.length() <= 4) goto L183;
            r63 = r63.subSequence(0, 4) + "...";
            goto L183
        L175:
            if (r63.length() == 0) goto L178;
            r65 = false;
            goto L179
        L289:
            return;
        L205:
            i0 r71 = this.a.f.e;
            if (r71 == null) goto L292;
            float r72 = r58.a.g();
            String r117 = r58.a.j();
            String r118 = r58.a.f();
            double r119 = r58.a.c();
            ConstraintLayout r73 = r71.d;
            if (r73 == null) goto L210;
            r73.setVisibility(0);
        L210:
            TextView r74 = r71.f;
            if (r74 == null) goto L213;
            r74.setTextColor(-1);
        L213:
            TextView r75 = r71.e;
            if (r75 == null) goto L216;
            r75.setTextColor(-1);
        L216:
            ImageView r76 = r71.g;
            if (r76 == null) goto L219;
            r76.setVisibility(8);
        L219:
            TextView r77 = r71.e;
            if (r77 == null) goto L222;
            r77.setText(String.valueOf((int) r72) + " ");
        L222:
            if (r118 != null) goto L224;
        L227:
            boolean r78 = true;
        L228:
            if (r78 == false) goto L230;
        L232:
            if (r117 != null) goto L234;
        L237:
            boolean r79 = true;
        L238:
            if (r79 == false) goto L240;
        L242:
            int r80 = Math.abs(((int) r119) - ((int) r72));
            TextView r81 = r71.c;
            if (r81 == null) goto L245;
            r81.setText(s1.C(2131918320, new Object[]{r118, Integer.valueOf(r80)}));
        L245:
            TextView r82 = r71.b;
            if (r82 == null) goto L248;
            r82.setText(s1.C(2131918526, new Object[]{r117}));
        L248:
            ImageView r83 = r71.a;
            if (r83 == null) goto L251;
            r83.setVisibility(8);
        L251:
            ConstraintLayout r85 = r71.d;
            if (r85 == null) goto L293;
            r85.setBackground(s1.m(2131252037));
            return;
        L293:
            return;
        L240:
            if (r117.length() <= 6) goto L242;
            r117 = r117.subSequence(0, 6) + "...";
            goto L242
        L234:
            if (r117.length() == 0) goto L237;
            r79 = false;
            goto L238
        L230:
            if (r118.length() <= 4) goto L232;
            r118 = r118.subSequence(0, 4) + "...";
            goto L232
        L224:
            if (r118.length() == 0) goto L227;
            r78 = false;
            goto L228
        L292:
            return;
        L255:
            if ((r1 instanceof f.a) == false) goto L295;
            e r86 = this.a.f;
            KtvComponentEmptyView r87 = r86.a;
            if (r87 == null) goto L259;
            UtilityKotlinExtentionsKt.t(r87);
        L259:
            KtvComponentEmptyView r88 = r86.b;
            if (r88 == null) goto L262;
            UtilityKotlinExtentionsKt.t(r88);
        L262:
            TextView r89 = r86.c;
            if (r89 == null) goto L265;
            UtilityKotlinExtentionsKt.t(r89);
        L265:
            TextView r90 = r86.d;
            if (r90 == null) goto L268;
            UtilityKotlinExtentionsKt.t(r90);
        L268:
            i0 r91 = r86.e;
            if (r91 == null) goto L271;
            r91.c();
        L271:
            TextView r92 = r86.f;
            if (r92 == null) goto L296;
            UtilityKotlinExtentionsKt.t(r92);
            return;
        L296:
            return;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvComponentMusicReportInfoManager a;
        public final /* synthetic */ Function0 b;

        public b(KtvComponentMusicReportInfoManager r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            if ((this.a.g.getValue() instanceof f.C0147f) == false) goto L5;
            this.a.f(f.a.a);
        L5:
            Function0 r4 = this.b;
            if (r4 == null) goto L9;
            Unit r5 = (Unit) r4.invoke();
            return;
        }
    }

    static {
    }

    public final void a() {
        this.g.removeObserver(this.h);
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.b;
        if (r1 != null) goto L10;
    L12:
        Disposable r2 = this.c;
        if (r2 != null) goto L15;
    L17:
        Disposable r3 = this.d;
        if (r3 != null) goto L20;
    L22:
        Disposable r4 = this.e;
        if (r4 != null) goto L25;
        return;
    L25:
        if (r4.isDisposed() == true) goto L29;
        r4.dispose();
        return;
    L29:
        return;
    L20:
        if (r3.isDisposed() == true) goto L22;
        r3.dispose();
        goto L22
    L15:
        if (r2.isDisposed() == true) goto L17;
        r2.dispose();
        goto L17
    L10:
        if (r1.isDisposed() == true) goto L12;
        r1.dispose();
        goto L12
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public KtvComponentMusicReportInfoManager() {
        this.f = new e();
        this.g = new MutableLiveData(f.a.a);
        this.h = new MusicReportInfoViewStateObserver(this);
    }

    public final void b(boolean r3) {
        Disposable r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        f(new f.b(r3));
        this.d = Observable.timer(KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new je2.a(this));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void c(h r3) {
        Intrinsics.checkNotNullParameter(r3, "seiModel");
        Disposable r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        f(new f.d(r3));
        this.e = Observable.timer(KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void f(f r3) {
        Intrinsics.checkNotNullParameter(r3, "viewState");
        MutableLiveData r0 = this.g;
        if ((r0 instanceof MutableLiveData) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L8;
        r0.setValue(r3);
        return;
    }

    public static void e(KtvComponentMusicReportInfoManager r2, KtvMusic r3, long r4) {
        Disposable r0 = r2.a;
        if (r0 != null) goto L5;
    L7:
        r2.f(new f.g(r3));
        r2.a = Observable.timer(r4, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r2, null));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void d(KtvMusic r3, long r4, Function0<Unit> r6) {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        f(new f.C0147f(r3));
        this.b = Observable.timer(r4, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r6));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }
}
