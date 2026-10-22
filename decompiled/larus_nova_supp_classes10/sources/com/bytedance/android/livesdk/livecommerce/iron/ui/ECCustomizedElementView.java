package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.AutoSizeTextView;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.live.p;
import com.bytedance.android.ec.model.live.q;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.RemoteGroupHeadImageView;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.t0;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003 !\"B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function0;", "", "callback", "setCountDownEndCallback", "", "getShowContent", "", "Lcom/bytedance/android/ec/model/live/b;", "getCurrentData", "Lbk2/d;", "h", "Lkotlin/Lazy;", "getDisposableContext", "()Lbk2/d;", "disposableContext", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView$a;", "<set-?>", "i", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView$a;", "getAnimatorState", "()Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView$a;", "animatorState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCustomizedElementView extends LinearLayout {
    public static final /* synthetic */ int k = 0;
    public List<com.bytedance.android.ec.model.live.b> a;
    public ECCustomizedCountDownView b;
    public c c;
    public q d;
    public Function0<Unit> e;
    public Animator f;
    public Animator g;
    public final Lazy h;
    public a i;
    public final ECCustomizedElementView$countDownTickListener$1 j;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView$a$a, reason: collision with other inner class name */
        public static final class C0070a extends a {
            public static final C0070a a = null;

            static {
                a = new C0070a();
            }

            public C0070a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public static final class b {
    }

    public final class c extends TextView {
        public Disposable a;
        public final com.bytedance.android.ec.model.live.i b;
        public final /* synthetic */ ECCustomizedElementView c;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final void accept(Object r7) {
                Long r8 = (Long) r7;
                com.bytedance.android.ec.model.live.i r0 = this.a.b;
                if (r0 == null) goto L20;
                List r1 = r0.c();
                if (r1 != null) goto L7;
                return;
            L7:
                if ((!r1.isEmpty()) == true) goto L10;
                r1 = null;
            L10:
                if (r1 != null) goto L12;
                return;
            L12:
                if (r8.longValue() < r1.size()) goto L16;
                c r9 = this.a;
                Disposable r2 = r9.a;
                if (r2 == null) goto L23;
                bk2.d r10 = ECCustomizedElementView.a(r9.c);
                Intrinsics.checkNotNullParameter(r2, "$this$disposeFrom");
                Intrinsics.checkNotNullParameter(r10, "disposableContext");
                r10.remove(r2);
                return;
            L23:
                return;
            L16:
                this.a.setText((CharSequence) CollectionsKt.getOrNull(r1, (int) r8.longValue()));
                if (r8.longValue() != (((long) r1.size()) - 1)) goto L25;
                this.a.animate().scaleX(1.2f).scaleY(1.2f).setDuration(200).withEndAction(new com.bytedance.android.livesdk.livecommerce.iron.ui.b(this)).start();
                return;
            L25:
                return;
            }
        }

        public final void a() {
            int r0 = t0.a;
            com.bytedance.android.ec.model.live.i r1 = this.b;
            if (r1 == null) goto L5;
            long r3 = r1.a();
        L6:
            this.a = bk2.c.a(t0.a(200, r3, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), ECCustomizedElementView.a(this.c));
            return;
        L5:
            r3 = 200;
            goto L6
        }

        public final float getLoopEndingTextWidth() {
            com.bytedance.android.ec.model.live.i r0 = this.b;
            if (r0 == null) goto L7;
            List r1 = r0.c();
            if (r1 == null) goto L7;
            String r2 = (String) CollectionsKt.lastOrNull(r1);
        L8:
            if (r2 != null) goto L10;
        L13:
            boolean r3 = true;
        L14:
            if (r3 == false) goto L17;
            return 0.0f;
        L17:
            return getPaint().measureText(r2);
        L10:
            if (r2.length() == 0) goto L13;
            r3 = false;
        L7:
            r2 = null;
            goto L8
        }

        public c(ECCustomizedElementView r4, com.bytedance.android.ec.model.live.i r5, Context r6) {
            Intrinsics.checkNotNullParameter(r6, "context");
            this.c = r4;
            String r7 = null;
            boolean r0 = false;
            super(r6, null, 0);
            this.b = r5;
            setMaxLines(1);
            if (r5 == null) goto L12;
            Integer r1 = Integer.valueOf(r5.e());
            if (r1.intValue() <= 0) goto L7;
            r0 = true;
        L7:
            if (r0 == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L12;
            float r2 = r1.intValue();
        L13:
            setTextSize(1, r2);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            if (r5 != null) goto L16;
        L18:
            setEllipsize(TextUtils.TruncateAt.END);
            int r8 = s.a;
            if (r5 == null) goto L21;
            r7 = r5.d();
        L21:
            Integer r9 = s.b(r7);
            if (r9 == null) goto L24;
            int r10 = r9.intValue();
        L25:
            setTextColor(r10);
            return;
        L24:
            r10 = -16777216;
            goto L25
        L16:
            if (r5.b() != true) goto L18;
            setTypeface(Typeface.DEFAULT_BOLD);
        L12:
            r2 = 12.0f;
            goto L13
        }
    }

    static {
    }

    public ECCustomizedElementView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECCustomizedElementView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final bk2.d getDisposableContext() {
        return (bk2.d) this.h.getValue();
    }

    public final String getShowContent() {
        List<com.bytedance.android.ec.model.live.b> r0 = this.a;
        if (r0 == null) goto L31;
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        if (((com.bytedance.android.ec.model.live.b) r3).o() != 20) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        r4 = false;
        goto L11
    L13:
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r6 = r2.iterator();
    L15:
        if (r6.hasNext() == false) goto L22;
        com.bytedance.android.ec.model.live.l r7 = ((com.bytedance.android.ec.model.live.b) r6.next()).n();
        if (r7 == null) goto L19;
        String r8 = r7.j();
    L20:
        r5.add(r8);
        goto L15
    L19:
        r8 = null;
        goto L20
    L22:
        return CollectionsKt.joinToString$default(r5, null, null, null, 0, null, null, 63, null);
    L31:
        return null;
    }

    public final void e() {
        removeAllViews();
        this.a = null;
        this.d = null;
        this.b = null;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        getDisposableContext().clearDisposable();
        c r0 = this.c;
        if (r0 == null) goto L7;
        Disposable r1 = r0.a;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        super.onDetachedFromWindow();
    }

    public final a getAnimatorState() {
        return this.i;
    }

    public final List<com.bytedance.android.ec.model.live.b> getCurrentData() {
        return this.a;
    }

    public static final /* synthetic */ bk2.d a(ECCustomizedElementView r0) {
        return r0.getDisposableContext();
    }

    public static float k(TextView r1) {
        TextPaint r0 = r1.getPaint();
        CharSequence r2 = r1.getText();
        if (r2 == null) goto L6;
        String r3 = r2.toString();
        if (r3 == null) goto L6;
    L8:
        return r0.measureText(r3);
    L6:
        r3 = "";
        goto L8
    }

    public final View f(ECUrlModel r13) {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(0);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Float r2 = null;
        float r3 = 22.0f;
        if (r13 == null) goto L13;
        Float r5 = Float.valueOf(r13.getWidth());
        if (r5.floatValue() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L13;
        float r7 = r5.floatValue();
    L14:
        if (r13 == null) goto L23;
        Float r8 = Float.valueOf(r13.getHeight());
        if (r8.floatValue() <= 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        r2 = r8;
    L21:
        if (r2 == null) goto L23;
        r3 = r2.floatValue();
        goto L23
    L18:
        r9 = false;
    L23:
        if (r13 == null) goto L46;
        List r14 = r13.getUrlList();
        if (r14 == null) goto L46;
        ArrayList r4 = new ArrayList();
        Iterator r15 = r14.iterator();
    L28:
        if (r15.hasNext() == false) goto L32;
        Object r10 = r15.next();
        if (a2.b((String) r10) == false) goto L28;
        r4.add(r10);
        goto L28
    L32:
        Iterator r16 = r4.iterator();
        int r11 = 0;
    L34:
        if (r16.hasNext() == false) goto L46;
        Object r12 = r16.next();
        int r17 = r11 + 1;
        if (r11 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        String r18 = (String) r12;
        DraweeView r19 = new RemoteGroupHeadImageView(getContext());
        r19.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        if (r11 == 0) goto L41;
        boolean r20 = true;
    L42:
        r19.setClip(r20);
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(r7)), UtilityKotlinExtentionsKt.d(Float.valueOf(r3)));
        if (r11 == 0) goto L45;
        int r22 = UtilityKotlinExtentionsKt.d(Float.valueOf(-2.5f));
        r21.setMarginStart(r22);
        r21.leftMargin = r22;
    L45:
        y.d(r19, r18);
        r0.addView(r19, r21);
        r11 = r17;
        goto L34
    L41:
        r20 = false;
    L46:
        return r0;
    L7:
        r6 = false;
    L13:
        r7 = 22.0f;
        goto L14
    }

    public final View j(com.bytedance.android.ec.model.live.b r20) {
        int r0 = r20.o();
        boolean r7 = true;
        if (r0 != 1) goto L5;
        AppCompatTextView r8 = f(r20.a());
    L232:
        if (r20.e() == false) goto L235;
        if (r8 == null) goto L235;
        r8.setTag("cart_add_destination");
    L235:
        return r8;
    L5:
        if (r0 == 2) goto L229;
        int r2 = 0;
        if (r0 == 3) goto L225;
        ECUrlModel r9 = null;
        if (r0 == 4) goto L224;
        float r4 = 12.0f;
        if (r0 == 5) goto L223;
        int r3 = 6;
        switch(r0) {
            case 20: goto L93;
            case 21: goto L86;
            case 22: goto L79;
            case 23: goto L75;
            case 24: goto L63;
            case 25: goto L17;
            default: goto L15;
        };
    L17:
        final com.bytedance.android.ec.model.live.e r1 = r20.c();
        final AppCompatTextView r10 = new ECCustomizedElementView(getContext(), r9, r3, r2);
        if (r1 == null) goto L62;
        r10.setGravity(17);
        Integer r5 = Integer.valueOf(r1.f());
        if (r5.intValue() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L26;
        r5 = null;
    L26:
        int r11 = -2;
        if (r5 == null) goto L29;
        r10.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Integer.valueOf(r5.intValue()))));
    L29:
        ECUrlModel r12 = r1.b();
        if (r12 == null) goto L52;
        Integer r13 = Integer.valueOf(r12.getWidth());
        if (r13.intValue() <= 0) goto L34;
        boolean r14 = true;
    L35:
        if (r14 == true) goto L38;
        r13 = null;
    L38:
        if (r13 == null) goto L40;
        r11 = UtilityKotlinExtentionsKt.d(r13);
    L40:
        Integer r15 = Integer.valueOf(r12.getHeight());
        if (r15.intValue() <= 0) goto L43;
        boolean r16 = true;
    L44:
        if (r16 == true) goto L47;
        r15 = null;
    L47:
        if (r15 != null) goto L50;
        r15 = Integer.valueOf(getHeight());
    L50:
        r10.setLayoutParams(new LinearLayout.LayoutParams(r11, UtilityKotlinExtentionsKt.d(r15)));
        if (h0.g(r12, null, new ECCustomizedElementView$createBlockGroup$$inlined$also$lambda$1(r10, this, r1)) == null) goto L52;
    L55:
        ViewExtensionsKt.f(r10, UtilityKotlinExtentionsKt.c(Integer.valueOf(r1.h())), UtilityKotlinExtentionsKt.c(Integer.valueOf(r1.h())), UtilityKotlinExtentionsKt.c(Integer.valueOf(r1.h())), UtilityKotlinExtentionsKt.c(Integer.valueOf(r1.h())), false);
        List<com.bytedance.android.ec.model.live.b> r17 = r1.e();
        if (r17 == null) goto L58;
        r10.b(r17, false);
    L58:
        final p r18 = r1.g();
        if (r18 == null) goto L61;
        com.bytedance.android.ec.core.widget.f.c(r10, null, "bind_key_live_promotion_list", new ECCustomizedElementView$createBlockGroup$$inlined$also$lambda$2(r18, r1, r10, this, r1), 1);
    L61:
        postDelayed(new com.bytedance.android.livesdk.livecommerce.iron.ui.c(r1, r10, this), 100);
        goto L62
    L43:
        r16 = false;
        goto L44
    L34:
        r14 = false;
    L52:
        String r19 = r1.a();
        if (r19 == null) goto L55;
        int r21 = s.a;
        r10.setBackgroundColor(s.a(r19, th.a.a(getContext(), 2131106784)));
        goto L55
    L22:
        r6 = false;
    L62:
        r8 = r10;
        goto L232
    L63:
        com.bytedance.android.ec.model.live.h r22 = r20.j();
        if (r22 == null) goto L66;
        ECUrlModel r23 = r22.b();
    L67:
        com.bytedance.android.ec.model.live.h r24 = r20.j();
        if (r24 == null) goto L70;
        Integer r25 = Integer.valueOf(r24.c());
    L71:
        com.bytedance.android.ec.model.live.h r26 = r20.j();
        if (r26 == null) goto L74;
        r9 = r26.a();
    L74:
        r8 = h(r23, r25, r9);
        goto L232
    L70:
        r25 = null;
        goto L71
    L66:
        r23 = null;
        goto L67
    L75:
        com.bytedance.android.ec.model.live.c r27 = r20.g();
        if (r27 == null) goto L78;
        r9 = r27.a();
    L78:
        r8 = f(r9);
        goto L232
    L79:
        q r28 = (q) r20.a.getValue();
        com.bytedance.android.ec.model.live.g r29 = r20.i();
        if (r29 == null) goto L82;
        r9 = r29.a();
    L82:
        com.bytedance.android.ec.model.live.g r30 = r20.i();
        if (r30 == null) goto L85;
        r4 = r30.d();
    L85:
        r8 = g(r28, r9, Float.valueOf(r4));
        goto L232
    L86:
        com.bytedance.android.ec.model.live.d r31 = r20.h();
        if (r31 == null) goto L89;
        r9 = Integer.valueOf(r31.a());
    L89:
        AppCompatTextView r32 = new Space(getContext());
        if (r9 == null) goto L92;
        r2 = (int) UtilityKotlinExtentionsKt.c(r9);
    L92:
        r32.setMinimumWidth(r2);
        r8 = r32;
        goto L232
    L93:
        com.bytedance.android.ec.model.live.l r33 = r20.n();
        if (r33 == null) goto L96;
        String r34 = r33.j();
    L97:
        com.bytedance.android.ec.model.live.l r35 = r20.n();
        if (r35 == null) goto L100;
        Integer r36 = r35.i();
    L101:
        com.bytedance.android.ec.model.live.l r37 = r20.n();
        if (r37 == null) goto L104;
        String r38 = r37.b();
    L105:
        com.bytedance.android.ec.model.live.l r39 = r20.n();
        if (r39 != null) goto L108;
    L110:
        boolean r40 = false;
    L111:
        com.bytedance.android.ec.model.live.l r41 = r20.n();
        if (r41 == null) goto L114;
        ECUrlModel r42 = r41.f();
    L115:
        com.bytedance.android.ec.model.live.l r43 = r20.n();
        if (r43 == null) goto L118;
        Long r44 = Long.valueOf(r43.h());
    L119:
        com.bytedance.android.ec.model.live.l r45 = r20.n();
        if (r45 == null) goto L122;
        Integer r46 = r45.d();
    L123:
        com.bytedance.android.ec.model.live.l r47 = r20.n();
        if (r47 == null) goto L126;
        Integer r110 = r47.e();
    L127:
        com.bytedance.android.ec.model.live.l r48 = r20.n();
        if (r48 == null) goto L130;
        Integer r111 = r48.g();
    L131:
        r8 = i(r34, r36, r38, r40, r42, r44, r46, r110, r111);
        goto L232
    L130:
        r111 = null;
        goto L131
    L126:
        r110 = null;
        goto L127
    L122:
        r46 = null;
        goto L123
    L118:
        r44 = null;
        goto L119
    L114:
        r42 = null;
        goto L115
    L108:
        if (r39.a() != true) goto L110;
        r40 = true;
        goto L111
    L104:
        r38 = null;
        goto L105
    L100:
        r36 = null;
        goto L101
    L96:
        r34 = null;
        goto L97
    L15:
        switch(r0) {
            case 27: goto L148;
            case 28: goto L133;
            case 29: goto L132;
            default: goto L16;
        };
    L16:
        r8 = null;
        goto L232
    L132:
        r8 = new c(this, r20.k(), getContext());
        this.c = r8;
        goto L232
    L133:
        final com.bytedance.android.ec.model.live.j r49 = r20.l();
        final AppCompatTextView r50 = new PriceView(getContext(), null, 0, 14);
        if (r49 == null) goto L147;
        ECUrlModel r51 = Long.valueOf(r49.d());
        if (r51.longValue() <= 0) goto L138;
        boolean r112 = true;
    L139:
        if (r112 == false) goto L141;
        r9 = r51;
    L141:
        if (r9 == null) goto L143;
        r4 = r9.longValue();
    L143:
        r50.setTextSize(1, r4);
        r50.C(new ECCustomizedElementView$createPriceElement$$inlined$also$lambda$1(r49, r50, r49));
        if (r49.e() <= 0) goto L146;
        r50.setMaxWidth(UtilityKotlinExtentionsKt.c(Long.valueOf(r49.e())));
    L146:
        r50.setPadding(0, UtilityKotlinExtentionsKt.d(Long.valueOf(r49.d() / ((long) 4))), 0, 0);
        r50.setIncludeFontPadding(false);
        goto L147
    L138:
        r112 = false;
    L147:
        r8 = r50;
        goto L232
    L148:
        com.bytedance.android.ec.model.live.k r52 = r20.m();
        AppCompatTextView r53 = new AutoSizeTextView(getContext(), null, 6, 0);
        SpannableStringBuilder r54 = new SpannableStringBuilder();
        if (r52 == null) goto L210;
        List r55 = r52.a();
        if (r55 == null) goto L210;
        ArrayList r113 = new ArrayList();
        Iterator r56 = r55.iterator();
    L153:
        int r114 = 20;
        if (r56.hasNext() == false) goto L164;
        Object r115 = r56.next();
        com.bytedance.android.ec.model.live.b r116 = (com.bytedance.android.ec.model.live.b) r115;
        if (r116.o() != 20) goto L158;
    L161:
        boolean r57 = true;
    L162:
        if (r57 == false) goto L153;
        r113.add(r115);
        goto L153
    L158:
        if (r116.o() == 21) goto L161;
        r57 = false;
        goto L162
    L164:
        Iterator r58 = r113.iterator();
        int r59 = 0;
        int r117 = 12;
    L166:
        if (r58.hasNext() == false) goto L209;
        Object r118 = r58.next();
        int r119 = r59 + 1;
        if (r59 >= 0) goto L170;
        CollectionsKt.throwIndexOverflow();
    L170:
        com.bytedance.android.ec.model.live.b r120 = (com.bytedance.android.ec.model.live.b) r118;
        if (r120.o() != r114) goto L204;
        com.bytedance.android.ec.model.live.l r60 = r120.n();     // Catch: Throwable -> L206
        if (r60 == null) goto L208;
        if (a2.b(r60.j()) == true) goto L179;
        r60 = null;
    L179:
        if (r60 == null) goto L208;
        if (r59 != 0) goto L193;
        Integer r61 = r60.i();     // Catch: Throwable -> L206
        if (r61 != null) goto L184;
    L192:
        r117 = 12;
        goto L193
    L184:
        if (r61.intValue() <= 0) goto L186;
        boolean r121 = true;
    L187:
        if (r121 == true) goto L190;
        r61 = null;
    L190:
        if (r61 == null) goto L192;
        r117 = r61.intValue();     // Catch: Throwable -> L206
        goto L193
    L186:
        r121 = false;
    L193:
        String r62 = r60.j();     // Catch: Throwable -> L206
        if (r62 != null) goto L196;
        r62 = "";
    L196:
        SpannableString r122 = new SpannableString(r62);     // Catch: Throwable -> L206
        if (a2.b(r60.b()) == false) goto L200;
        r122.setSpan(new ForegroundColorSpan(Color.parseColor(r60.b())), 0, r62.length(), 33);     // Catch: Throwable -> L206
    L200:
        if (r60.a() == false) goto L202;
        int r63 = 1;
    L203:
        r122.setSpan(new StyleSpan(r63), 0, r62.length(), 33);     // Catch: Throwable -> L206
        r54.append(r122);     // Catch: Throwable -> L206
        goto L208
    L202:
        r63 = 0;
    L208:
        r59 = r119;
        r114 = 20;
        goto L166
    L204:
        r54.append(new SpannableString(" "));     // Catch: Throwable -> L206
    L206:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L208
    L209:
        int r64 = r117;
    L211:
        r53.setText(r54);
        r53.setBaseTextSize(UtilityKotlinExtentionsKt.c(Integer.valueOf(r64)));
        r53.setTextSize(1, r64);
        if (r52 == null) goto L222;
        Long r65 = Long.valueOf(r52.b());
        if (r65.longValue() > 0) goto L217;
        r7 = false;
    L217:
        if (r7 == false) goto L219;
        Long r66 = r65;
    L220:
        if (r66 == null) goto L222;
        r53.setViewMaxWidth(UtilityKotlinExtentionsKt.d(Long.valueOf(r66.longValue())));
        goto L222
    L219:
        r66 = null;
    L222:
        r8 = r53;
    L210:
        r64 = 12;
        goto L211
    L223:
        r8 = g((q) r20.a.getValue(), r20.t(), Float.valueOf(12.0f));
        goto L232
    L224:
        r8 = h(r20.q(), null, null);
        goto L232
    L225:
        Integer r67 = Integer.valueOf(r20.b());
        r8 = new Space(getContext());
        if (r67 == null) goto L228;
        r2 = (int) UtilityKotlinExtentionsKt.c(r67);
    L228:
        r8.setMinimumWidth(r2);
        goto L232
    L229:
        r8 = i(r20.s(), Integer.valueOf(r20.p()), r20.t(), r20.d(), null, null, null, null, null);
        goto L232
    }

    public final void setCountDownEndCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.e = r2;
    }

    public final void b(List<com.bytedance.android.ec.model.live.b> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if ((!Intrinsics.areEqual(this.a, r2)) == true) goto L5;
        if (r3 == true) goto L5;
    L17:
        c r4 = this.c;
        if (r4 == null) goto L26;
        r4.a();
        return;
    L26:
        return;
    L5:
        Animator r5 = this.f;
        if (r5 == null) goto L8;
        r5.cancel();
    L8:
        this.f = null;
        Animator r0 = this.g;
        if (r0 == null) goto L11;
        r0.cancel();
    L11:
        this.g = null;
        e();
        this.i = a.C0070a.a;
        this.a = r2;
        Iterator<T> r6 = r2.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        View r7 = j((com.bytedance.android.ec.model.live.b) r6.next());
        if (r7 == null) goto L13;
        addView(r7);
        goto L13
    }

    public final void c(List r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "data");
        boolean r1 = true;
        boolean r0 = !Intrinsics.areEqual(this.a, r14);
        Animator r2 = this.f;
        if (r2 == null) goto L5;
        r2.cancel();
    L5:
        View r3 = null;
        this.f = null;
        Animator r4 = this.g;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        this.g = null;
        e();
        this.i = a.C0070a.a;
        this.a = r14;
        Iterator r16 = r14.iterator();
        int r5 = -1;
        View r7 = null;
        float r6 = 0.0f;
        int r8 = 0;
    L10:
        if (r16.hasNext() == false) goto L61;
        Object r9 = r16.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        com.bytedance.android.ec.model.live.b r11 = (com.bytedance.android.ec.model.live.b) r9;
        View r12 = j(r11);
        if (r12 == null) goto L60;
        int r13 = r11.o();
        if (r13 != 20) goto L19;
        com.bytedance.android.ec.model.live.l r17 = r11.n();
        if (r17 == null) goto L50;
        if (r17.c() != true) goto L50;
        if (r7 != null) goto L50;
        r5 = r8;
        r7 = r12;
    L50:
        if ((r12 instanceof TextView) == true) goto L52;
        View r18 = null;
    L53:
        TextView r19 = (TextView) r18;
        if (r19 == null) goto L58;
        float r20 = k(r19);
    L56:
        r6 = r6 + r20;
    L58:
        if (r6 > r15) goto L97;
        addView(r12);
    L97:
        c r110 = this.c;
        if (r110 == null) goto L108;
        r110.a();
        return;
    L108:
        return;
    L52:
        r18 = r12;
        goto L53
    L19:
        if (r13 != 21) goto L21;
        com.bytedance.android.ec.model.live.d r21 = r11.h();
        if (r21 == null) goto L42;
        r20 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r21.a()));
    L42:
        r20 = 0.0f;
        goto L56
    L21:
        if (r13 == 24) goto L34;
        switch(r13) {
            case 27: goto L28;
            case 28: goto L28;
            case 29: goto L24;
            default: goto L58;
        };
    L24:
        c r22 = this.c;
        if (r22 == null) goto L42;
        r20 = r22.getLoopEndingTextWidth();
        goto L56
    L28:
        if ((r12 instanceof TextView) == true) goto L30;
        View r23 = null;
    L31:
        TextView r24 = (TextView) r23;
        if (r24 == null) goto L58;
        r20 = k(r24);
        goto L56
    L30:
        r23 = r12;
        goto L31
    L34:
        com.bytedance.android.ec.model.live.h r25 = r11.j();
        if (r25 == null) goto L42;
        ECUrlModel r26 = r25.b();
        if (r26 == null) goto L42;
        r20 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r26.getWidth()));
    L60:
        r8 = r10;
        goto L10
    L61:
        Float r111 = Float.valueOf(r15 - r6);
        if (r111.floatValue() <= 0) goto L64;
        boolean r112 = true;
    L65:
        if (r112 == true) goto L68;
        r111 = null;
    L68:
        if (r111 == null) goto L97;
        float r113 = r111.floatValue();
        if ((r7 instanceof TextView) == false) goto L73;
        r3 = r7;
    L73:
        TextView r27 = (TextView) r3;
        if (r27 == null) goto L95;
        String r114 = r27.getText().toString();
        if (r27.getPaint().measureText(r114) <= r113) goto L95;
    L79:
        if (r114.length() <= 0) goto L81;
        boolean r28 = true;
    L83:
        if (r28 == false) goto L88;
        if (r27.getPaint().measureText(r114.concat("… ")) <= r113) goto L88;
        r114 = r114.substring(0, r114.length() - 1);
    L88:
        if (r114.length() > 0) goto L91;
        r1 = false;
    L91:
        if (r1 == false) goto L93;
        String r115 = r114.concat("… ");
    L94:
        float r116 = r27.getPaint().measureText(r115);
        r27.setText(r115);
        ViewGroup.LayoutParams r117 = r27.getLayoutParams();
        r117.width = (int) r116;
        r27.setLayoutParams(r117);
        goto L95
    L93:
        r115 = "";
        goto L94
    L81:
        r28 = false;
    L95:
        if (r7 == null) goto L97;
        addView(r7, r5);
        goto L97
    L64:
        r112 = false;
        goto L65
    }

    public final void d(List r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "data");
        if ((!Intrinsics.areEqual(this.a, r18)) == false) goto L86;
        Animator r2 = this.f;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        View r3 = null;
        this.f = null;
        Animator r4 = this.g;
        if (r4 == null) goto L11;
        r4.cancel();
    L11:
        this.g = null;
        e();
        this.i = a.C0070a.a;
        this.a = r18;
        com.bytedance.android.ec.model.live.b r5 = (com.bytedance.android.ec.model.live.b) CollectionsKt.getOrNull(r18, r18.size() - 1);
        if (r5 != null) goto L14;
    L20:
        View r7 = null;
    L21:
        float r6 = 0.0f;
    L22:
        Iterator r8 = r18.iterator();
        int r10 = 0;
    L24:
        if (r8.hasNext() == false) goto L84;
        Object r11 = r8.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        com.bytedance.android.ec.model.live.b r13 = (com.bytedance.android.ec.model.live.b) r11;
        View r14 = j(r13);
        if (r14 == null) goto L83;
        int r15 = r13.o();
        if (r15 != 20) goto L33;
        boolean r16 = r14 instanceof TextView;
        if (r16 == true) goto L60;
        View r17 = r3;
    L61:
        TextView r110 = (TextView) r17;
        if (r110 == null) goto L83;
        float r111 = k(r110) + r6;
        float r112 = r19;
        if (r111 <= r112) goto L81;
        Float r113 = Float.valueOf(r112 - r6);
        if (r113.floatValue() <= 0) goto L68;
        boolean r9 = true;
    L69:
        if (r9 == true) goto L72;
        r113 = null;
    L72:
        if (r113 == null) goto L83;
        float r1 = r113.floatValue();
        if (r16 == true) goto L76;
        View r20 = null;
    L77:
        TextView r21 = (TextView) r20;
        if (r21 == null) goto L80;
        r21.setMaxWidth((int) r1);
        r21.setEllipsize(TextUtils.TruncateAt.END);
        r21.setMaxLines(1);
    L80:
        addView(r14);
        goto L84
    L76:
        r20 = r14;
        goto L77
    L68:
        r9 = false;
        goto L69
    L81:
        addView(r14);
        r6 = r111;
        goto L83
    L60:
        r17 = r14;
        goto L61
    L33:
        if (r15 == 21) goto L52;
        if (r15 == 24) goto L44;
        if (r15 != 29) goto L83;
        c r114 = this.c;
        if (r114 == null) goto L41;
        float r115 = r114.getLoopEndingTextWidth();
    L42:
        r6 = r6 + r115;
        addView(r14);
        goto L83
    L41:
        r115 = 0.0f;
        goto L42
    L44:
        if (r10 >= (r18.size() - 1)) goto L83;
        com.bytedance.android.ec.model.live.h r116 = r13.j();
        if (r116 == null) goto L50;
        ECUrlModel r117 = r116.b();
        if (r117 == null) goto L50;
        float r118 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r117.getWidth()));
    L51:
        r6 = r6 + r118;
        addView(r14);
    L50:
        r118 = 0.0f;
        goto L51
    L52:
        com.bytedance.android.ec.model.live.d r119 = r13.h();
        if (r119 == null) goto L55;
        float r120 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r119.a()));
    L56:
        r6 = r6 + r120;
        addView(r14);
        goto L83
    L55:
        r120 = 0.0f;
    L83:
        r10 = r12;
        r3 = null;
    L84:
        if (r7 == null) goto L86;
        addView(r7);
        goto L86
    L14:
        if (r5.o() != 24) goto L20;
        r7 = j(r5);
        com.bytedance.android.ec.model.live.h r22 = r5.j();
        if (r22 == null) goto L21;
        ECUrlModel r23 = r22.b();
        if (r23 == null) goto L21;
        r6 = UtilityKotlinExtentionsKt.c(Integer.valueOf(r23.getWidth()));
    L86:
        c r24 = this.c;
        if (r24 == null) goto L95;
        r24.a();
        return;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView$countDownTickListener$1] */
    public ECCustomizedElementView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = LazyKt.lazy(ECCustomizedElementView$disposableContext$2.INSTANCE);
        this.i = a.C0070a.a;
        this.j = new ECCustomizedElementView$countDownTickListener$1(this);
        setOrientation(0);
        setGravity(16);
        setBaselineAligned(false);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedCountDownView] */
    public final ECCustomizedCountDownView g(q r11, String r12, Float r13) {
        long r0 = SystemClock.elapsedRealtime();
        if (r11 == null) goto L24;
        long r3 = r11.a;
        long r5 = r11.b;
        if (r3 <= r0) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L14;
        r11 = null;
    L14:
        if (r11 == null) goto L24;
        this.d = r11;
        ?? r6 = new ECCustomizedCountDownView(getContext(), null, 6, 0);
        r6.setMaxLines(1);
        Integer r14 = s.b(r12);
        if (r14 == null) goto L18;
        int r15 = r14.intValue();
    L19:
        r6.setTextColor(r15);
        if (r13 == null) goto L22;
        float r16 = r13.floatValue();
    L23:
        r6.setTextSize(1, r16);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.x(r11.b - r0);
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.b(this.j);
        Unit r17 = Unit.INSTANCE;
        this.b = r6;
        return r6;
    L22:
        r16 = 12.0f;
        goto L23
    L18:
        r15 = -16777216;
        goto L19
    L8:
        if (r5 <= r0) goto L10;
        r4 = true;
    L24:
        this.d = null;
        this.b = null;
        Function0<Unit> r18 = this.e;
        if (r18 == null) goto L29;
        Unit r19 = (Unit) r18.invoke();
        return null;
    L29:
        return null;
    }

    public final View h(ECUrlModel r11, Integer r12, com.bytedance.android.ec.model.live.f r13) {
        int r2 = 0;
        if (r13 != null) goto L31;
        ECDraweeView r14 = new ECDraweeView(getContext(), null, 0, 6, null);
        r14.setAutoPlayAnimation(true);
        if (r11 == null) goto L10;
        String r1 = r11.getFirstUrl();
        if (r1 == null) goto L10;
        String r4 = r1;
    L12:
        if (r11 == null) goto L14;
        int r0 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getWidth()));
    L15:
        Integer r6 = Integer.valueOf(r0);
        if (r11 == null) goto L18;
        int r3 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getHeight()));
    L19:
        h0.e(r14, r4, null, r6, Integer.valueOf(r3), 96);
        if (r11 == null) goto L22;
        int r5 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getWidth()));
    L23:
        if (r11 == null) goto L25;
        r2 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getHeight()));
    L25:
        r14.setLayoutParams(new LinearLayout.LayoutParams(r5, r2));
        if (r12 != null) goto L28;
    L30:
        return r14;
    L28:
        if (r12.intValue() <= 0) goto L30;
        r14.setCornerRadius(UtilityKotlinExtentionsKt.c(r12));
        goto L30
    L22:
        r5 = 0;
        goto L23
    L18:
        r3 = 0;
        goto L19
    L14:
        r0 = 0;
    L10:
        r4 = "";
        goto L12
    L31:
        ConstraintLayout r15 = new ConstraintLayout(getContext());
        ECDraweeView r7 = new ECDraweeView(getContext(), null, 0, 6, null);
        r7.setAutoPlayAnimation(true);
        r7.setId(ViewCompat.generateViewId());
        if (r11 == null) goto L37;
        String r8 = r11.getFirstUrl();
        if (r8 == null) goto L37;
        String r9 = r8;
    L39:
        if (r11 == null) goto L41;
        int r10 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getWidth()));
    L42:
        Integer r16 = Integer.valueOf(r10);
        if (r11 == null) goto L45;
        int r17 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getHeight()));
    L46:
        h0.e(r7, r9, null, r16, Integer.valueOf(r17), 96);
        if (r11 == null) goto L49;
        int r18 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getWidth()));
    L50:
        if (r11 == null) goto L52;
        int r19 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11.getHeight()));
    L53:
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(r18, r19);
        r20.topToTop = 0;
        r20.leftToLeft = 0;
        Unit r110 = Unit.INSTANCE;
        r7.setLayoutParams(r20);
        r15.addView(r7);
        TextView r111 = new TextView(getContext());
        Long r21 = Long.valueOf(r13.e());
        if (r21.longValue() <= 0) goto L56;
        boolean r22 = true;
    L57:
        if (r22 == true) goto L60;
        r21 = null;
    L60:
        if (r21 == null) goto L62;
        float r23 = r21.longValue();
    L63:
        r111.setTextSize(1, r23);
        ConstraintLayout.LayoutParams r24 = new ConstraintLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Long.valueOf(r13.f())));
        r24.topToTop = 0;
        r24.rightToRight = r7.getId();
        r24.setMargins(0, 0, -UtilityKotlinExtentionsKt.d(2), 0);
        r111.setLayoutParams(r24);
        r111.setGravity(17);
        r111.setText(r13.h());
        int r25 = s.a;
        Integer r26 = s.b(r13.d());
        if (r26 == null) goto L66;
        int r27 = r26.intValue();
    L67:
        r111.setTextColor(r27);
        r111.setPadding(UtilityKotlinExtentionsKt.d(Long.valueOf(r13.g())), 0, UtilityKotlinExtentionsKt.d(Long.valueOf(r13.g())), 0);
        GradientDrawable r28 = new GradientDrawable();
        Integer r29 = s.b(r13.a());
        if (r29 == null) goto L70;
        r28.setColor(r29.intValue());
    L70:
        Integer r30 = s.b(r13.b());
        if (r30 == null) goto L73;
        r28.setStroke(1, r30.intValue());
    L73:
        r28.setCornerRadius(UtilityKotlinExtentionsKt.c(Long.valueOf(r13.c())));
        r111.setBackground(r28);
        r15.addView(r111);
        return r15;
    L66:
        r27 = -16777216;
        goto L67
    L62:
        r23 = 12.0f;
        goto L63
    L56:
        r22 = false;
        goto L57
    L52:
        r19 = 0;
        goto L53
    L49:
        r18 = 0;
        goto L50
    L45:
        r17 = 0;
        goto L46
    L41:
        r10 = 0;
    L37:
        r9 = "";
        goto L39
    }

    public /* synthetic */ ECCustomizedElementView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final View i(String r11, Integer r12, String r13, boolean r14, ECUrlModel r15, Long r16, Integer r17, Integer r18, Integer r19) {
        float r1 = 12.0f;
        if (r16 != null) goto L5;
    L19:
        AutoSizeTextView r5 = new TextView(getContext());
    L20:
        if (r19 != null) goto L22;
    L30:
        int r6 = 1;
    L31:
        r5.setMaxLines(r6);
        if (r12 != null) goto L34;
    L42:
        r5.setTextSize(1, r1);
        r5.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r5.setText(r11);
        int r2 = FontFamilyType.DOUYIN_SANS.getType();
        if (r17 != null) goto L46;
    L48:
        int r3 = FontFamilyType.DOUYIN_NUMBER_ABC.getType();
        if (r17 != null) goto L52;
    L54:
        Typeface r4 = null;
    L55:
        if (r4 == null) goto L57;
        r5.setTypeface(r4);
    L62:
        r5.setEllipsize(TextUtils.TruncateAt.END);
        Integer r7 = s.b(r13);
        if (r7 == null) goto L65;
        int r8 = r7.intValue();
    L66:
        r5.setTextColor(r8);
        if (r15 == null) goto L71;
        View r0 = h(r15, null, null);
        ConstraintLayout r9 = new ConstraintLayout(getContext());
        r9.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(r0.getLayoutParams());
        r10.topToTop = 0;
        r10.bottomToBottom = 0;
        r10.leftToLeft = 0;
        r10.rightToRight = 0;
        Unit r20 = Unit.INSTANCE;
        r9.addView(r0, r10);
        r5.setIncludeFontPadding(false);
        ConstraintLayout.LayoutParams r21 = new ConstraintLayout.LayoutParams(r5.getLayoutParams());
        r21.topToTop = 0;
        r21.bottomToBottom = 0;
        r21.leftToLeft = 0;
        r21.rightToRight = 0;
        r9.addView(r5, r21);
        return r9;
    L71:
        return r5;
    L65:
        r8 = -16777216;
        goto L66
    L57:
        if (r18 == null) goto L59;
        int r22 = c0.a;
        c0.b(r5, r18.intValue());
    L61:
        Unit r23 = Unit.INSTANCE;
        goto L62
    L59:
        if (r14 == false) goto L61;
        r5.setTypeface(Typeface.DEFAULT_BOLD);
        goto L61
    L52:
        if (r17.intValue() != r3) goto L54;
        r4 = ECFontHelper.e.b("DouyinNumberABC", MonitorLevel.ERROR, false);
        goto L55
    L46:
        if (r17.intValue() != r2) goto L48;
        r4 = ECFontHelper.e.b("DouyinSans", MonitorLevel.ERROR, false);
        goto L55
    L34:
        if (r12.intValue() <= 0) goto L36;
        boolean r24 = true;
    L37:
        if (r24 == false) goto L39;
        Integer r25 = r12;
    L40:
        if (r25 == null) goto L42;
        r1 = r25.intValue();
        goto L42
    L39:
        r25 = null;
        goto L40
    L36:
        r24 = false;
        goto L37
    L22:
        if (r19.intValue() <= 0) goto L24;
        boolean r26 = true;
    L25:
        if (r26 == false) goto L27;
        Integer r27 = r19;
    L28:
        if (r27 == null) goto L30;
        r6 = r27.intValue();
        goto L31
    L27:
        r27 = null;
        goto L28
    L24:
        r26 = false;
        goto L25
    L5:
        if (r16.longValue() <= 0) goto L19;
        r5 = new AutoSizeTextView(getContext(), null, 6, 0);
        if (r12 != null) goto L9;
    L17:
        float r28 = 12.0f;
    L18:
        r5.setBaseTextSize(UtilityKotlinExtentionsKt.c(Float.valueOf(r28)));
        r5.setViewMaxWidth(UtilityKotlinExtentionsKt.d(r16));
        goto L20
    L9:
        if (r12.intValue() <= 0) goto L11;
        boolean r29 = true;
    L12:
        if (r29 == false) goto L14;
        Integer r30 = r12;
    L15:
        if (r30 == null) goto L17;
        r28 = r30.intValue();
        goto L18
    L14:
        r30 = null;
        goto L15
    L11:
        r29 = false;
        goto L12
    }
}
