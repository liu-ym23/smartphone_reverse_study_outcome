package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BannerMoreView extends AppCompatTextView {
    public BannerMoreView(Context r1) {
        super(r1);
        initView(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initView(Context r3) {
        setText(2131887879);
        setTextColor(n.h(r3, 2131105548));
        setTextSize(14.0f);
        setGravity(16);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131243719, 0);
        l.b(this, 2131105548);
        setCompoundDrawablePadding(n.d(1));
    }

    public BannerMoreView(Context r1, AttributeSet r2) {
        super(r1, r2);
        initView(r1);
    }

    public BannerMoreView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        initView(r1);
    }
}
