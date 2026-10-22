package kx0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f506532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f506533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f506534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f506535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f506536e;

    public final View getView() {
        Long r100 = this.f506532a;
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L7:
        if (r101 <= 0) goto L9;
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_amount)).setVisibility(0);
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_amount)).setText(s1.C(R.string.ttlive_cash_exchange_rebate_toast_title, new Object[]{String.valueOf(this.f506532a)}));
    L9:
        Long r102 = this.f506533b;
        if (r102 == null) goto L12;
        long r103 = r102.longValue();
    L14:
        if (r103 <= 0) goto L17;
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_hint)).setVisibility(0);
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_hint)).setText(s1.C(R.string.ttlive_cash_exchange_rebate_toast_content, new Object[]{String.valueOf(this.f506533b), r3.b()}));
    L17:
        return this.f506536e;
    L12:
        r103 = 0;
        goto L14
    L5:
        r101 = 0;
        goto L7
    }

    public final View getView2() {
        Long r100 = this.f506532a;
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L7:
        if (r101 <= 0) goto L16;
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_amount)).setVisibility(0);
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_amount)).setText(s1.C(R.string.ttlive_cash_exchange_rebate_toast_title, new Object[]{String.valueOf(this.f506532a)}));
        Long r102 = this.f506532a;
        Integer r103 = this.f506535d;
        Integer r104 = this.f506534c;
        if (r102 == null) goto L16;
        if (r103 == null) goto L16;
        if (r104 == null) goto L16;
        int r105 = r104.intValue();
        int r106 = r103.intValue();
        long r107 = r102.longValue();
        if (r106 <= 0) goto L16;
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_hint)).setVisibility(0);
        ((TextView) this.f506536e.findViewById(R.id.recharge_rebate_hint)).setText(s1.C(R.string.ttlive_cash_exchange_rebate_toast_content, new Object[]{String.valueOf((r107 / ((long) r106)) * ((long) r105)), r3.b()}));
    L16:
        return this.f506536e;
    L5:
        r101 = 0;
        goto L7
    }

    public final Long getMDeductAmount() {
        return this.f506533b;
    }

    public final Integer getMGiftLimit() {
        return this.f506535d;
    }

    public final Long getMRebateAmount() {
        return this.f506532a;
    }

    public final Integer getMRebateLimit() {
        return this.f506534c;
    }

    public final void setMDeductAmount(Long r100) {
        this.f506533b = r100;
    }

    public final void setMGiftLimit(Integer r100) {
        this.f506535d = r100;
    }

    public final void setMRebateAmount(Long r100) {
        this.f506532a = r100;
    }

    public final void setMRebateLimit(Integer r100) {
        this.f506534c = r100;
    }

    public e(Long r100, Long r101, Integer r102, Integer r103, Context r104) {
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r104, null, 0);
        this.f506532a = 0L;
        this.f506533b = 0L;
        this.f506534c = 0;
        this.f506535d = 0;
        this.f506536e = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_recharge_rebate_toast_view, null);
        this.f506532a = r100;
        this.f506533b = r101;
        this.f506534c = r102;
        this.f506535d = r103;
    }
}
