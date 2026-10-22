package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public class DmtIconButton extends FrameLayout implements e46.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f248419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f248420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f248421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ButtonStyle f248422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f248423e;

    public String getTextString() {
        TextView r100 = this.f248421c;
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.getText() != null) goto L9;
        return "";
    L9:
        return this.f248421c.getText().toString();
    }

    public DmtIconButton(Context r100) {
        this(r100, null);
    }

    @Override // e46.b
    public final void a(int r100) {
        if (this.f248419a == r100) goto L20;
        this.f248419a = r100;
        if (this.f248422d != ButtonStyle.SOLID) goto L12;
        if (r100 != 0) goto L8;
        setBackgroundResource(R.drawable.uikit_bg_default_button_solid_light);
    L9:
        this.f248421c.setTextColor(getContext().getResources().getColor(R.color.uikit_const_tInverse));
        if (this.f248423e == (-1)) goto L21;
        i46.a.a(getContext(), this.f248420b, this.f248423e, R.color.uikit_const_tInverse);
        return;
    L21:
        return;
    L8:
        setBackgroundResource(R.drawable.uikit_bg_default_button_solid_dark);
        goto L9
    L12:
        if (r100 != 0) goto L16;
        setBackgroundResource(R.drawable.uikit_bg_default_button_border_light);
        this.f248421c.setTextColor(getContext().getResources().getColor(R.color.uikit_reverse_tPrimary_light));
        if (this.f248423e == (-1)) goto L23;
        i46.a.a(getContext(), this.f248420b, this.f248423e, R.color.uikit_reverse_tPrimary_light);
        return;
    L23:
        return;
    L16:
        setBackgroundResource(R.drawable.uikit_bg_default_button_border_dark);
        this.f248421c.setTextColor(getContext().getResources().getColor(R.color.uikit_reverse_tPrimary_dark));
        if (this.f248423e == (-1)) goto L25;
        i46.a.a(getContext(), this.f248420b, this.f248423e, R.color.uikit_reverse_tPrimary_dark);
        return;
    L25:
        return;
    }

    public DmtIconButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DmtIconButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248419a = 1;
        this.f248422d = ButtonStyle.SOLID;
        this.f248423e = -1;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.layout_icon_button, this, true);
        this.f248420b = (ImageView) r103.findViewById(R.id.iv_icon);
        this.f248421c = (TextView) r103.findViewById(R.id.tv_text);
        if (this.f248419a != 0) goto L5;
        setBackgroundResource(R.drawable.uikit_bg_default_button_solid_light);
    L6:
        this.f248421c.setTextColor(getContext().getResources().getColor(R.color.uikit_const_tInverse));
        if (this.f248423e == (-1)) goto L10;
        i46.a.a(getContext(), this.f248420b, this.f248423e, R.color.uikit_const_tInverse);
        return;
    L10:
        return;
    L5:
        setBackgroundResource(R.drawable.uikit_bg_default_button_solid_dark);
        goto L6
    }
}
