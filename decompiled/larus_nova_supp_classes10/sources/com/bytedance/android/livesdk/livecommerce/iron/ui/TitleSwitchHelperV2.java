package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.os.SystemClock;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.model.live.q;
import com.bytedance.android.livesdk.livecommerce.network.response.ECBackgroundAnimationType;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import xi2.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class TitleSwitchHelperV2 {
    public static final /* synthetic */ int l = 0;
    public int a;
    public int b;
    public long c;
    public final TitleSwitchHelperV2$switchAction$1 d;
    public final ECCustomizedElementView e;
    public final xi2.e f;
    public final int g;
    public final Function2<String, String, Unit> h;
    public final Function2<m0, String, Unit> i;
    public final boolean j;
    public final Integer k;

    public static final class a {
    }

    static {
    }

    public final void a() {
        List<xi2.f> r0 = this.f.b();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L34;
        b((xi2.f) ListProtector.get(r0, 0), this.f.c());
        xi2.g r1 = this.f.a();
        if (r1 == null) goto L35;
        Long r3 = r1.a();
        if (r3 == null) goto L14;
        long r4 = r3.longValue();
    L15:
        this.c = r4;
        int r5 = r1.getType();
        if (r5 != ECBackgroundAnimationType.NUMBER.getType()) goto L27;
        Long r2 = r1.b();
        if (r2 == null) goto L20;
        long r6 = r2.longValue();
    L22:
        if (r6 > 0) goto L24;
    L31:
        Unit r7 = Unit.INSTANCE;
        return;
    L24:
        if (r0.size() <= 1) goto L31;
        c();
        goto L31
    L20:
        r6 = 0;
        goto L22
    L27:
        if (r5 != ECBackgroundAnimationType.INFINITE.getType()) goto L31;
        if (r0.size() <= 1) goto L31;
        c();
        goto L31
    L14:
        r4 = 5;
        goto L15
    L35:
        return;
    }

    public final void c() {
        UtilityKotlinExtentionsKt.b.removeCallbacks(this.d);
        ECCustomizedElementView r0 = this.e;
        Function0<Unit> r1 = new TitleSwitchHelperV2$postSwitchAction$1(this);
        if (ViewCompat.isAttachedToWindow(r0) == false) goto L6;
        r1.invoke();
        return;
    }

    public final int getType() {
        return this.g;
    }

    public final void b(final xi2.f r14, final m0 r15) {
        final String r0 = r14.b();
        boolean r1 = false;
        Integer r2 = null;
        if (r0 != null) goto L5;
    L21:
        long r4 = SystemClock.elapsedRealtime();
        List<com.bytedance.android.ec.model.live.b> r3 = r14.a();
        if (r3 == null) goto L34;
        Iterator<T> r5 = r3.iterator();
    L25:
        if (r5.hasNext() == false) goto L32;
        Object r6 = r5.next();
        if (((q) ((com.bytedance.android.ec.model.live.b) r6).a.getValue()) == null) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == false) goto L25;
    L33:
        final com.bytedance.android.ec.model.live.b r11 = (com.bytedance.android.ec.model.live.b) r6;
    L35:
        if (r11 == null) goto L68;
        q r8 = (q) r11.a.getValue();
        if (r8 == null) goto L68;
        long r9 = r8.a;
        long r10 = r8.b;
        if (r9 <= r4) goto L41;
    L44:
        boolean r12 = true;
    L45:
        if (r12 == true) goto L48;
        r8 = null;
    L48:
        if (r8 == null) goto L68;
        com.bytedance.android.ec.model.live.g r13 = r11.i();
        if (r13 == null) goto L66;
        List<com.bytedance.android.ec.model.live.b> r16 = r13.c();
        if (r16 == null) goto L66;
        Integer r17 = this.k;
        if (r17 != null) goto L56;
    L64:
        this.e.b(r16, true);
    L65:
        Unit r18 = Unit.INSTANCE;
    L67:
        if (r18 == null) goto L68;
    L86:
        this.i.invoke(r15, this.e.getShowContent());
        return;
    L56:
        if (r17.intValue() <= 0) goto L58;
        boolean r19 = true;
    L59:
        if (r19 == true) goto L62;
        r17 = null;
    L62:
        if (r17 == null) goto L64;
        this.e.c(r16, r17.intValue());
        goto L65
    L58:
        r19 = false;
    L66:
        r18 = null;
        goto L67
    L41:
        if (r10 <= r4) goto L44;
        r12 = false;
    L68:
        List<com.bytedance.android.ec.model.live.b> r20 = r14.a();
        if (r20 == null) goto L80;
        Integer r21 = this.k;
        if (r21 != null) goto L73;
    L79:
        this.e.b(r20, true);
        goto L80
    L73:
        if (r21.intValue() <= 0) goto L75;
        r1 = true;
    L75:
        if (r1 == false) goto L77;
        r2 = r21;
    L77:
        if (r2 == null) goto L79;
        this.e.c(r20, r2.intValue());
    L80:
        if (r11 == null) goto L86;
        com.bytedance.android.ec.model.live.g r22 = r11.i();
        if (r22 == null) goto L86;
        final List r23 = r22.c();
        if (r23 == null) goto L86;
        this.e.setCountDownEndCallback(new TitleSwitchHelperV2$bindContent$$inlined$run$lambda$1(r23, this, r14, r11, r15));
        Unit r110 = Unit.INSTANCE;
        goto L86
    L29:
        r7 = false;
        goto L30
    L32:
        r6 = null;
        goto L33
    L34:
        r11 = null;
        goto L35
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r24 = true;
    L8:
        if (r24 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L21;
        if (this.j == false) goto L20;
        Object r25 = this.e.getParent();
        if ((r25 instanceof View) == true) goto L17;
        r25 = null;
    L17:
        View r26 = (View) r25;
        if (r26 == null) goto L21;
        com.bytedance.android.ec.core.widget.f.c(r26, null, null, new TitleSwitchHelperV2$bindContent$$inlined$let$lambda$1(r0, this, r14), 3);
        goto L21
    L20:
        com.bytedance.android.ec.core.widget.f.c(this.e, null, null, new TitleSwitchHelperV2$bindContent$$inlined$let$lambda$2(r0, this, r14), 3);
        goto L21
    L7:
        r24 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TitleSwitchHelperV2(ECCustomizedElementView r2, xi2.e r3, int r4, String r5, Function2<? super String, ? super String, Unit> r6, Function2<? super m0, ? super String, Unit> r7, boolean r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bannerComponent");
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Intrinsics.checkNotNullParameter(r6, "clickCallback");
        Intrinsics.checkNotNullParameter(r7, "showCallback");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.c = 5;
        this.d = new TitleSwitchHelperV2$switchAction$1(this);
    }
}
