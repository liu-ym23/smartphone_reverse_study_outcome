package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class DmtIconButton extends FrameLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f193276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f193277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f193278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ButtonStyle f193279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f193280e;

    public String getTextString() {
        TextView r100 = this.f193278c;
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.getText() != null) goto L9;
        return "";
    L9:
        return this.f193278c.getText().toString();
    }

    public DmtIconButton(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r100) {
        if (this.f193276a == r100) goto L20;
        this.f193276a = r100;
        if (this.f193279d != ButtonStyle.SOLID) goto L12;
        if (r100 != 0) goto L8;
        setBackgroundResource(R.drawable.aos_uikit_bg_default_button_solid_light);
    L9:
        this.f193278c.setTextColor(getContext().getResources().getColor(R.color.aos_uikit_const_t_inverse));
        if (this.f193280e == (-1)) goto L21;
        r.a(getContext(), this.f193277b, this.f193280e, R.color.aos_uikit_const_t_inverse);
        return;
    L21:
        return;
    L8:
        setBackgroundResource(R.drawable.aos_uikit_bg_default_button_solid_dark);
        goto L9
    L12:
        if (r100 != 0) goto L16;
        setBackgroundResource(R.drawable.aos_uikit_bg_default_button_border_light);
        this.f193278c.setTextColor(getContext().getResources().getColor(R.color.aos_uikit_reverse_t_primary_light));
        if (this.f193280e == (-1)) goto L23;
        r.a(getContext(), this.f193277b, this.f193280e, R.color.aos_uikit_reverse_t_primary_light);
        return;
    L23:
        return;
    L16:
        setBackgroundResource(R.drawable.aos_uikit_bg_default_button_border_dark);
        this.f193278c.setTextColor(getContext().getResources().getColor(R.color.aos_uikit_reverse_t_primary_dark));
        if (this.f193280e == (-1)) goto L25;
        r.a(getContext(), this.f193277b, this.f193280e, R.color.aos_uikit_reverse_t_primary_dark);
        return;
    L25:
        return;
    }

    public DmtIconButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DmtIconButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193276a = 1;
        this.f193279d = ButtonStyle.SOLID;
        this.f193280e = -1;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.aos_layout_icon_button, this, true);
        this.f193277b = (ImageView) r103.findViewById(R.id.iv_icon);
        this.f193278c = (TextView) r103.findViewById(R.id.tv_text);
        if (this.f193276a != 0) goto L5;
        setBackgroundResource(R.drawable.aos_uikit_bg_default_button_solid_light);
    L6:
        this.f193278c.setTextColor(getContext().getResources().getColor(R.color.aos_uikit_const_t_inverse));
        if (this.f193280e == (-1)) goto L10;
        r.a(getContext(), this.f193277b, this.f193280e, R.color.aos_uikit_const_t_inverse);
        return;
    L10:
        return;
    L5:
        setBackgroundResource(R.drawable.aos_uikit_bg_default_button_solid_dark);
        goto L6
    }
}
