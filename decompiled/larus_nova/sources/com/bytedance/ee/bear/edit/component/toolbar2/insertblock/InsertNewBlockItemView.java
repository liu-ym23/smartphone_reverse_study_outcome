package com.bytedance.ee.bear.edit.component.toolbar2.insertblock;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class InsertNewBlockItemView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f226152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f226153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f226154c;

    public InsertNewBlockItemView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        View.inflate(r100, R.layout.doc_toolbar_insert_new_block_item, this);
        this.f226152a = (AppCompatImageView) findViewById(R.id.inb_icon);
        this.f226153b = (TextView) findViewById(R.id.inb_text);
        this.f226154c = findViewById(R.id.inb_badge);
        l.c(this.f226152a, R.color.icon_n1);
    }

    public void setBadge(boolean r100) {
        View r101 = this.f226154c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setIcon(int r100) {
        this.f226152a.setImageResource(kac.a.b(r100));
    }

    public void setIconBackground(int r100) {
        this.f226152a.setBackgroundResource(kac.a.b(r100));
    }

    public void setIconBackgroundTint(int r100) {
        ColorStateList r101 = getResources().getColorStateList(r100);
        this.f226152a.setBackgroundTintList(r101);
    }

    public void setIconImageTint(int r100) {
        ColorStateList r101 = getResources().getColorStateList(r100);
        this.f226152a.setImageTintList(r101);
    }

    public void setText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f226153b.setVisibility(8);
        return;
    L5:
        this.f226153b.setVisibility(0);
        this.f226153b.setText(r100);
    }

    public void setIconBackgroundTint(String r100) {
        ColorStateList r101 = ColorStateList.valueOf(ColorUtils.h(r100));
        this.f226152a.setBackgroundTintList(r101);
    }

    public void setIconImageTint(String r100) {
        ColorStateList r101 = ColorStateList.valueOf(ColorUtils.h(r100));
        this.f226152a.setImageTintList(r101);
    }

    public InsertNewBlockItemView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }
}
