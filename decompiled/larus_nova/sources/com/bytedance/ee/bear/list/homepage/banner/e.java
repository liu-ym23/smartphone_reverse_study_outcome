package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f228298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f228299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDBadgeView f228300c;

    public final UDBadgeView getGuideBadgeFromXml() {
        KeyEvent.Callback r100 = this.f228300c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.guideBadge);
        this.f228300c = (UDBadgeView) r100;
    L6:
        return (UDBadgeView) r100;
    }

    public final ImageView getIconFromXml() {
        KeyEvent.Callback r100 = this.f228298a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.icon);
        this.f228298a = (ImageView) r100;
    L6:
        return (ImageView) r100;
    }

    public final TextView getTitleFromXml() {
        KeyEvent.Callback r100 = this.f228299b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.title);
        this.f228299b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public e(Context r100) {
        super(r100);
        LayoutInflater.from(r100).inflate(R.layout.bitable_create_action_sheet_item, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public final void setBadgeVisibility(boolean r100) {
        UDBadgeView r101 = getGuideBadgeFromXml();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setGuideBadgeFromXml(UDBadgeView r100) {
        this.f228300c = r100;
    }

    public final void setIconFromXml(ImageView r100) {
        this.f228298a = r100;
    }

    public final void setLeftIcon(int r100) {
        getIconFromXml().setVisibility(0);
        getIconFromXml().setImageResource(kac.a.b(r100));
    }

    public final void setTitle(CharSequence r100) {
        getTitleFromXml().setVisibility(0);
        getTitleFromXml().setText(r100);
    }

    public final void setTitleFromXml(TextView r100) {
        this.f228299b = r100;
    }
}
