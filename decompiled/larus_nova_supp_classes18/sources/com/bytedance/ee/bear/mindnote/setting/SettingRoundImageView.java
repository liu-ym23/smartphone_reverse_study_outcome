package com.bytedance.ee.bear.mindnote.setting;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.facade.common.widget.NiceImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SettingRoundImageView extends NiceImageView {
    public f y;

    public f getWrapper() {
        return this.y;
    }

    public SettingRoundImageView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWrapper(f r1) {
        this.y = r1;
        setOnClickListener(r1);
    }

    public SettingRoundImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SettingRoundImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
