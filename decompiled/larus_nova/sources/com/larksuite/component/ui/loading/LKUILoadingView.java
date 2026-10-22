package com.larksuite.component.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public class LKUILoadingView extends LKUILottieAnimationView {
    private void init() {
        setAnimation(R.raw.loading_anim);
        setRepeatCount(-1);
    }

    public LKUILoadingView(Context r100) {
        this(r100, null);
    }

    public LKUILoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LKUILoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init();
    }
}
