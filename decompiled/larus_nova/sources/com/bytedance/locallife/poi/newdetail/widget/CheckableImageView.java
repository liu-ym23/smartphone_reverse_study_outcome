package com.bytedance.locallife.poi.newdetail.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes21.dex */
public class CheckableImageView extends SimpleDraweeView {

    public interface a {
    }

    public void setOnStateChangeListener(a r100) {
    }

    public CheckableImageView(Context r100) {
        this(r100, null);
    }

    public CheckableImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CheckableImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
