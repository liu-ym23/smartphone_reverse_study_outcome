package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.StatusDegradeView;
import com.bytedance.android.ec.core.widget.StatusView;
import com.bytedance.android.ec.core.widget.j;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECLoadingStateView extends LinearLayout {
    public View.OnClickListener a;
    public TextView b;
    public LinearLayout c;
    public ECHostNetErrorLayout d;
    public j e;

    public ECLoadingStateView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        setOrientation(1);
        setGravity(17);
        View.inflate(r3, 2131560764, this);
        this.b = (TextView) findViewById(2131391509);
        this.d = (ECHostNetErrorLayout) findViewById(2131371365);
        this.c = (LinearLayout) findViewById(2131378922);
        ECLiveDegradeHelper.c.getClass();
        if (ECLiveDegradeHelper.a("promotion_list_loading_degrade", ECLiveDegradeHelper.b().getEnablePromotionListLoadingDegrade()) != 1) goto L5;
        StatusDegradeView r4 = findViewById(2131387789);
        r4.setVisibility(0);
        this.e = r4;
        return;
    L5:
        StatusView r5 = findViewById(2131387788);
        r5.setVisibility(0);
        this.e = r5;
    }

    public void setRetryClickListener(View.OnClickListener r2) {
        this.a = r2;
        this.d.setRetryClickListener(r2);
    }

    public ECLoadingStateView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public ECLoadingStateView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
