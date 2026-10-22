package yw1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CheckedTextView f569335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f569336b;

    public a(Context r100) {
        super(r100);
        LinearLayout.inflate(r100, R.layout.ttlive_item_tab_check_view, this);
        this.f569335a = (CheckedTextView) findViewById(R.id.ttlive_tab_text);
        this.f569336b = (ImageView) findViewById(R.id.ttlive_tab_bottom_indicator);
    }

    public void setChecked(boolean r100) {
        this.f569335a.setChecked(r100);
        if (r100 == false) goto L5;
        this.f569335a.setTypeface(Typeface.DEFAULT_BOLD);
        this.f569336b.setVisibility(0);
        return;
    L5:
        this.f569335a.setTypeface(Typeface.DEFAULT);
        this.f569336b.setVisibility(8);
    }

    public void setIndicatorWidth(int r100) {
        ViewGroup.LayoutParams r101 = this.f569336b.getLayoutParams();
        r101.width = r100;
        this.f569336b.setLayoutParams(r101);
    }

    public void setText(String r100) {
        this.f569335a.setText(r100);
    }

    public void setTextColor(ColorStateList r100) {
        this.f569335a.setTextColor(r100);
    }
}
