package com.ss.android.dypay.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f408520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f408521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f408522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f408523d;

    public interface a {
    }

    public g(Context r100, com.ss.android.dypay.activity.e r101) {
        super(r100);
        this.f408523d = r101;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        setContentView(R.layout.dypay_dialog_layout);
        setCanceledOnTouchOutside(false);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -2;
        r102.height = -2;
        r101.setAttributes(r102);
    L5:
        this.f408520a = (TextView) findViewById(R.id.dy_pay_dialog_title);
        this.f408521b = (TextView) findViewById(R.id.dy_pay_op_cancel);
        this.f408522c = (TextView) findViewById(R.id.dy_pay_op_confirm);
        TextView r103 = this.f408520a;
        if (r103 == null) goto L9;
        r103.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r103.getPaint().setStrokeWidth(1.0f);
    L9:
        TextView r104 = this.f408522c;
        if (r104 == null) goto L13;
        r104.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r104.getPaint().setStrokeWidth(1.0f);
    L13:
        TextView r105 = this.f408521b;
        if (r105 == null) goto L16;
        r105.setOnClickListener(new h(this));
    L16:
        TextView r106 = this.f408522c;
        if (r106 == null) goto L20;
        r106.setOnClickListener(new i(this));
        return;
    }
}
