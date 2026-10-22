package com.ss.android.ugc.tools.view.widget.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes40.dex */
public class AVIconButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f455168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f455169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f455170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ButtonStyle f455171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f455172e;

    public AVIconButton(Context r100) {
        this(r100, null);
    }

    public AVIconButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AVIconButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455168a = 1;
        this.f455171d = ButtonStyle.SOLID;
        this.f455172e = -1;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.tools_layout_icon_button, this, true);
        this.f455169b = (ImageView) r103.findViewById(R.id.iv_icon);
        this.f455170c = (TextView) r103.findViewById(R.id.tv_text);
        if (this.f455168a != 0) goto L5;
        setBackgroundResource(R.drawable.tools_bg_default_button_solid_light);
    L6:
        this.f455170c.setTextColor(ResourcesCompat.getColor(getContext().getResources(), R.color.tools_const_tInverse, null));
        if (this.f455172e == (-1)) goto L10;
        d.a(getContext(), this.f455169b, this.f455172e, R.color.tools_const_tInverse);
        return;
    L10:
        return;
    L5:
        setBackgroundResource(R.drawable.tools_bg_default_button_solid_dark);
        goto L6
    }
}
