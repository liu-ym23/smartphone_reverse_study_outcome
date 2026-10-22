package com.bytedance.ee.bear.mindnote.setting;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.facade.common.widget.NiceImageView;

/* JADX INFO: loaded from: classes18.dex */
public class SettingRoundImageView extends NiceImageView {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f234462y;

    public f getWrapper() {
        return this.f234462y;
    }

    public SettingRoundImageView(Context r100) {
        super(r100);
    }

    public void setWrapper(f r100) {
        this.f234462y = r100;
        setOnClickListener(r100);
    }

    public SettingRoundImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public SettingRoundImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
