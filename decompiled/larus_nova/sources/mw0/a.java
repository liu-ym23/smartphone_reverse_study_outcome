package mw0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f515905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f515906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f515907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f515908d;

    public final View getView() {
        ((TextView) this.f515905a.findViewById(R.id.rebate_toast_title)).setText(s1.C(R.string.ttlive_cash_exchange_rebate_toast_title, new Object[]{String.valueOf(this.f515906b)}));
        Integer r100 = this.f515908d;
        if (r100 != null) goto L5;
    L9:
        ((TextView) this.f515905a.findViewById(R.id.rebate_toast_content)).setText(s1.C(R.string.ttlive_cash_exchange_rebate_toast_content, new Object[]{HttpClient.ENDFLAG, r3.b()}));
    L11:
        return this.f515905a;
    L5:
        if (r100.intValue() == 0) goto L9;
        if (this.f515907c == null) goto L9;
        ((TextView) this.f515905a.findViewById(R.id.rebate_toast_content)).setText(s1.C(R.string.ttlive_cash_exchange_rebate_toast_content, new Object[]{Integer.valueOf((this.f515906b / this.f515908d.intValue()) * this.f515907c.intValue()), r3.b()}));
        goto L11
    }

    public a(int r100, Integer r101, Integer r102, Context r103) {
        super(r103, null, 0);
        this.f515906b = r100;
        this.f515907c = r101;
        this.f515908d = r102;
        this.f515905a = LayoutInflater.from(r103).inflate(R.layout.ttlive_toast_exchange_rebate, null);
    }
}
