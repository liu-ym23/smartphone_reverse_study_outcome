package com.bytedance.ee.bear.more.pageview2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class PageviewTextView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f234769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f234770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f234771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f234772d;

    public final void a() {
        tt5.a.b("PageviewItemView", "initViews: ");
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.more_item_text_v2, this, true);
        this.f234769a = r100;
        this.f234770b = (TextView) r100.findViewById(R.id.title);
        this.f234771c = (ImageView) this.f234769a.findViewById(R.id.icon);
        this.f234772d = this.f234769a.findViewById(R.id.divider);
    }

    public PageviewTextView(Context r100) {
        super(r100);
        a();
    }

    public void setImageResource(int r100) {
        this.f234771c.setImageResource(r100);
    }

    public void setTitle(String r100) {
        this.f234770b.setText(r100);
    }

    public PageviewTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public PageviewTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
