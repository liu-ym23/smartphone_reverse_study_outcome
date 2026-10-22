package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.badge.UDBadgeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends LinearLayout {
    public ImageView a;
    public TextView b;
    public UDBadgeView c;

    public final UDBadgeView getGuideBadgeFromXml() {
        UDBadgeView r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131374087);
        this.c = r0;
    L6:
        return r0;
    }

    public final ImageView getIconFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131374718);
        this.a = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    public final TextView getTitleFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131388772);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public e(Context r3) {
        super(r3);
        LayoutInflater.from(r3).inflate(2131558943, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public final void setBadgeVisibility(boolean r2) {
        UDBadgeView r0 = getGuideBadgeFromXml();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setGuideBadgeFromXml(UDBadgeView r1) {
        this.c = r1;
    }

    public final void setIconFromXml(ImageView r1) {
        this.a = r1;
    }

    public final void setLeftIcon(int r3) {
        getIconFromXml().setVisibility(0);
        getIconFromXml().setImageResource(kac.a.b(r3));
    }

    public final void setTitle(CharSequence r3) {
        getTitleFromXml().setVisibility(0);
        getTitleFromXml().setText(r3);
    }

    public final void setTitleFromXml(TextView r1) {
        this.b = r1;
    }
}
