package com.bytedance.android.livesdk.livecommerce.saascoupon.presenter;

import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lbl2/e;", "it", "", "invoke", "(Lbl2/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SaasCouponPresenter$setCommonText$4 extends Lambda implements Function1<bl2.e, Unit> {
    final /* synthetic */ d this$0;

    public SaasCouponPresenter$setCommonText$4(d r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(bl2.e r16) {
        Intrinsics.checkNotNullParameter(r16, "it");
        bl2.d r1 = r16.d();
        if (r1 == null) goto L7;
        String r2 = r1.c();
        if (r2 == null) goto L7;
        ((TextView) this.this$0.Z().b(2131385064).f()).setText(r2);
    L7:
        bl2.d r3 = r16.d();
        if (r3 == null) goto L14;
        final String r4 = r3.b();
        if (r4 == null) goto L14;
        if (this.this$0.Z().b(2131385065).d() == false) goto L15;
        d.d0(this.this$0).getCurrentAccountPhoneNumber(new SaasCouponPresenter$setCommonText$4$$special$$inlined$let$lambda$1(r4, this));
    L15:
        this.this$0.Z().b(2131385057).f().C(SaasCouponPresenter$setCommonText$4$3$1.INSTANCE);
        List<bl2.c> r5 = r16.a();
        if (r5 != null) goto L18;
    L42:
        bl2.d r6 = r16.d();
        if (r6 == null) goto L55;
        List<bl2.d.a> r7 = r6.a();
        if (r7 != null) goto L47;
        return;
    L47:
        if ((!r7.isEmpty()) == false) goto L49;
        List<bl2.d.a> r8 = r7;
    L50:
        if (r8 == null) goto L57;
        bl2.d.a r9 = (bl2.d.a) ListProtector.get(r8, 0);
        if (r9 == null) goto L58;
        ((TextView) this.this$0.Z().b(2131385063).f()).setText(r9.a());
        return;
    L58:
        return;
    L57:
        return;
    L49:
        r8 = null;
        goto L50
    L55:
        return;
    L18:
        if ((!r5.isEmpty()) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L42;
        bl2.c r10 = (bl2.c) ListProtector.get(r5, 0);
        if (r10 == null) goto L42;
        bl2.c.a r11 = r10.g();
        int r12 = r10.b();
        long r13 = 0;
        if (r11 != null) goto L27;
    L36:
        this.this$0.Z().b(2131385057).f().setText(new BigDecimal(r10.f() / ((double) 100)).setScale(2, 5).stripTrailingZeros().toPlainString());
        ((TextView) this.this$0.Z().b(2131385058).f()).setText(w0.getContext().getString(2131913617));
        long r14 = r10.l();
        if (r14 <= 0) goto L39;
        ((TextView) this.this$0.Z().b(2131385059).f()).setText("满" + new BigDecimal(r14 / ((long) 100)).stripTrailingZeros().toPlainString() + "元可用");
    L41:
        ((TextView) this.this$0.Z().b(2131385062).f()).setText(r10.i());
        ((TextView) this.this$0.Z().b(2131385061).f()).setText(r10.m());
        ((TextView) this.this$0.Z().b(2131385060).f()).setText(r10.n());
        goto L42
    L39:
        if (r14 != 0) goto L41;
        ((TextView) this.this$0.Z().b(2131385059).f()).setText("无门槛");
        goto L41
    L27:
        if (r12 != 3) goto L36;
        Long r15 = r11.a();
        if (r15 == null) goto L31;
        long r17 = r15.longValue();
    L32:
        Long r18 = r11.b();
        if (r18 == null) goto L35;
        r13 = r18.longValue();
    L35:
        this.this$0.Z().b(2131385057).f().setText(String.valueOf(r17 / 10.0f));
        ((TextView) this.this$0.Z().b(2131385058).f()).setText(w0.getContext().getString(2131913618));
        ((TextView) this.this$0.Z().b(2131385059).f()).setText("最高减" + new BigDecimal(r13 / ((long) 100)).stripTrailingZeros().toPlainString() + "元");
        goto L41
    L31:
        r17 = 0;
    L14:
        this.this$0.Z().b(2131385065).c();
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((bl2.e) r1);
        return Unit.INSTANCE;
    }
}
