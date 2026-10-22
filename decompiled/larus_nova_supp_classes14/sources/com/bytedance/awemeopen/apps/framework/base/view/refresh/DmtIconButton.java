package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtIconButton extends FrameLayout implements f {
    public int a;
    public ImageView b;
    public TextView c;
    public final ButtonStyle d;
    public int e;

    public String getTextString() {
        TextView r0 = this.c;
        if (r0 != null) goto L6;
        return "";
    L6:
        if (r0.getText() != null) goto L9;
        return "";
    L9:
        return this.c.getText().toString();
    }

    public DmtIconButton(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r4) {
        if (this.a == r4) goto L20;
        this.a = r4;
        if (this.d != ButtonStyle.SOLID) goto L12;
        if (r4 != 0) goto L8;
        setBackgroundResource(2131231622);
    L9:
        this.c.setTextColor(getContext().getResources().getColor(2131100351));
        if (this.e == (-1)) goto L21;
        r.a(getContext(), this.b, this.e, 2131100351);
        return;
    L21:
        return;
    L8:
        setBackgroundResource(2131231621);
        goto L9
    L12:
        if (r4 != 0) goto L16;
        setBackgroundResource(2131231620);
        this.c.setTextColor(getContext().getResources().getColor(2131100353));
        if (this.e == (-1)) goto L23;
        r.a(getContext(), this.b, this.e, 2131100353);
        return;
    L23:
        return;
    L16:
        setBackgroundResource(2131231618);
        this.c.setTextColor(getContext().getResources().getColor(2131100352));
        if (this.e == (-1)) goto L25;
        r.a(getContext(), this.b, this.e, 2131100352);
        return;
    L25:
        return;
    }

    public DmtIconButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DmtIconButton(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = 1;
        this.d = ButtonStyle.SOLID;
        this.e = -1;
        View r5 = LayoutInflater.from(r2).inflate(2131558671, this, true);
        this.b = (ImageView) r5.findViewById(2131376297);
        this.c = (TextView) r5.findViewById(2131391574);
        if (this.a != 0) goto L5;
        setBackgroundResource(2131231622);
    L6:
        this.c.setTextColor(getContext().getResources().getColor(2131100351));
        if (this.e == (-1)) goto L10;
        r.a(getContext(), this.b, this.e, 2131100351);
        return;
    L10:
        return;
    L5:
        setBackgroundResource(2131231621);
        goto L6
    }
}
