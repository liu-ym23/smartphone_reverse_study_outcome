package com.bytedance.android.shopping.buynow.slice.countdown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/slice/countdown/BuyNowCountDownView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowCountDownView extends SlcRoundFrameLayout {
    public Map<Integer, View> c;
    public final List<TextView> d;
    public l1 e;
    public int f;
    public long g;
    public long h;
    public String i;
    public Map<String, ? extends Object> j;
    public String k;

    public static final class a {
    }

    public static final class b implements l1.a {
        public final /* synthetic */ BuyNowCountDownView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ String g;

        public final void onFinish() {
            BuyNowCountDownView.c(this.a, this.b, 0, this.d, this.e, this.f);
            String r0 = this.g;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L17;
            BaseSlcViewManager r2 = SlcViewExtensionsKt.g(this.a);
            if (r2 == null) goto L18;
            String r3 = this.g;
            if (r3 != null) goto L15;
            r3 = "";
        L15:
            SlcCommonAction r4 = new SlcCommonAction(r3, MapsKt.emptyMap());
            SlcRoundFrameLayout r5 = this.a;
            r2.getTemplateContext().d(r4, r5, r2.l(), null, null);
            return;
        L18:
            return;
        L17:
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public final void onStart() {
            BuyNowCountDownView.c(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public final void onTick(long r9) {
            BuyNowCountDownView.c(this.a, this.b, r9, this.d, this.e, this.f);
        }

        public b(BuyNowCountDownView r1, int r2, long r3, long r5, String r7, Map r8, String r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
            this.f = r8;
            this.g = r9;
        }
    }

    static {
    }

    public BuyNowCountDownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BuyNowCountDownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        d(this.f, this.g, this.h, this.i, this.j, this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        l1 r0 = this.e;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(int r3) {
        if (this.c != null) goto L5;
        this.c = new LinkedHashMap();
    L5:
        View r0 = this.c.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.c.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BuyNowCountDownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new LinkedHashMap();
        ArrayList r5 = new ArrayList();
        this.d = r5;
        setVisibility(8);
        int r6 = com.bytedance.android.shopping.buynow.opt.a.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(this, "parentView");
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131559217, this, true);
        r5.add(b(2131368564));
        r5.add(b(2131368561));
        r5.add(b(2131374570));
        r5.add(b(2131374566));
        r5.add(b(2131380164));
        r5.add(b(2131380163));
        r5.add(b(2131385700));
        r5.add(b(2131385691));
        this.f = 14;
        this.i = "";
    }

    public /* synthetic */ BuyNowCountDownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(BuyNowCountDownView r24, int r25, long r26, long r28, String r30, Map r31) {
        if (r26 >= 0) goto L5;
        r24.setVisibility(8);
        return;
    L5:
        r24.setVisibility(0);
        Iterator r8 = ((ArrayList) r24.d).iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        TextView r9 = (TextView) r8.next();
        Integer r10 = rc3.a.a(r30);
        if (r10 == null) goto L11;
        r9.setTextColor(r10.intValue());
    L11:
        r9.setTextSize(r25);
        goto L7
    L12:
        TextView r11 = (TextView) r24.b(2131368561);
        Object r12 = null;
        if (r31 == null) goto L15;
        Object r13 = r31.get("day_suffix");
    L17:
        if ((r13 instanceof String) == true) goto L19;
        r13 = null;
    L19:
        String r14 = (String) r13;
        if (r14 != null) goto L23;
        r14 = "天";
    L23:
        r11.setText(r14);
        TextView r15 = (TextView) r24.b(2131374566);
        if (r31 == null) goto L26;
        Object r16 = r31.get("hours_suffix");
    L28:
        if ((r16 instanceof String) == true) goto L30;
        r16 = null;
    L30:
        String r17 = (String) r16;
        String r18 = ":";
        if (r17 != null) goto L34;
        r17 = ":";
    L34:
        r15.setText(r17);
        TextView r19 = (TextView) r24.b(2131380163);
        if (r31 == null) goto L37;
        Object r110 = r31.get("minutes_suffix");
    L39:
        if ((r110 instanceof String) == true) goto L41;
        r110 = null;
    L41:
        String r111 = (String) r110;
        if (r111 == null) goto L44;
        r18 = r111;
    L44:
        r19.setText(r18);
        TextView r112 = (TextView) r24.b(2131385691);
        if (r31 == null) goto L47;
        Object r3 = r31.get("seconds_suffix");
    L49:
        if ((r3 instanceof String) == false) goto L52;
        r12 = r3;
    L52:
        String r113 = (String) r12;
        if (r113 != null) goto L56;
        r113 = "";
    L56:
        r112.setText(r113);
        if (r28 != 1) goto L59;
    L62:
        r24.b(2131368561).setVisibility(8);
        r24.b(2131368564).setVisibility(8);
        TextView r4 = (TextView) r24.b(2131374570);
        r4.setText(StringsKt.padStart(String.valueOf(r26 / 3600000), 2, '0'));
        r4.setVisibility(0);
        TextView r5 = (TextView) r24.b(2131380164);
        r5.setText(StringsKt.padStart(String.valueOf((r26 % 3600000) / 60000), 2, '0'));
        r5.setVisibility(0);
        TextView r6 = (TextView) r24.b(2131385700);
        r6.setText(StringsKt.padStart(String.valueOf((r26 % 60000) / 1000), 2, '0'));
        r6.setVisibility(0);
        r24.b(2131374570).setVisibility(0);
        r24.b(2131374566).setVisibility(0);
        r24.b(2131380163).setVisibility(0);
        r24.b(2131380164).setVisibility(0);
        r24.b(2131385691).setVisibility(0);
        r24.b(2131385700).setVisibility(0);
        return;
    L59:
        if ((r26 / 86400000) == 0) goto L62;
        ((TextView) r24.b(2131368564)).setText(String.valueOf((int) ((r26 * 1.0d) / 86400000)));
        ((TextView) r24.b(2131374570)).setText(StringsKt.padStart(String.valueOf((r26 % 86400000) / 3600000), 2, '0'));
        ((TextView) r24.b(2131380164)).setText(StringsKt.padStart(String.valueOf((r26 % 3600000) / 60000), 2, '0'));
        ((TextView) r24.b(2131385700)).setText(StringsKt.padStart(String.valueOf((r26 % 60000) / 1000), 2, '0'));
        r24.b(2131368564).setVisibility(0);
        r24.b(2131368561).setVisibility(0);
        r24.b(2131374570).setVisibility(0);
        r24.b(2131374566).setVisibility(0);
        r24.b(2131380163).setVisibility(0);
        r24.b(2131380164).setVisibility(0);
        r24.b(2131385691).setVisibility(0);
        r24.b(2131385700).setVisibility(0);
        return;
    L47:
        r3 = null;
        goto L49
    L37:
        r110 = null;
        goto L39
    L26:
        r16 = null;
        goto L28
    L15:
        r13 = null;
        goto L17
    }

    public final void d(int r18, long r19, long r21, String r23, Map<String, ? extends Object> r24, String r25) {
        Intrinsics.checkNotNullParameter(r23, "fontColor");
        this.f = r18;
        this.g = r19;
        this.h = r21;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        TimeUnit r3 = TimeUnit.SECONDS;
        long r11 = r3.toMillis(r19) - System.currentTimeMillis();
        l1 r0 = this.e;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.e = null;
        l1 r13 = new l1(r11, r3.toMillis(1), new b(this, r18, r11, r21, r23, r24, r25));
        r13.d();
        Unit r1 = Unit.INSTANCE;
        this.e = r13;
    }
}
