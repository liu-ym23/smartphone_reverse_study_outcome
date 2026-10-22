package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class BannerMoreView extends AppCompatTextView {
    public BannerMoreView(Context r100) {
        super(r100);
        initView(r100);
    }

    public final void initView(Context r100) {
        setText(R.string.Doc_List_All);
        setTextColor(n.h(r100, R.color.primary_fill_default));
        setTextSize(14.0f);
        setGravity(16);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.list_pin_view_more, 0);
        l.b(this, R.color.primary_fill_default);
        setCompoundDrawablePadding(n.d(1));
    }

    public BannerMoreView(Context r100, AttributeSet r101) {
        super(r100, r101);
        initView(r100);
    }

    public BannerMoreView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        initView(r100);
    }
}
