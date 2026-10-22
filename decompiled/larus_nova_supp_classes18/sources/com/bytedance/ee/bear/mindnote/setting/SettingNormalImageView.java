package com.bytedance.ee.bear.mindnote.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SettingNormalImageView extends FrameLayout {
    public f a;

    public f getWrapper() {
        return this.a;
    }

    public SettingNormalImageView(Context r1) {
        super(r1);
    }

    public void setWrapper(f r1) {
        this.a = r1;
        setOnClickListener(r1);
    }

    public SettingNormalImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SettingNormalImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
