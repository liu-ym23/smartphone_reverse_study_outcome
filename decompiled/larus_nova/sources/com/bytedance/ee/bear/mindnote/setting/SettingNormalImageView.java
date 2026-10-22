package com.bytedance.ee.bear.mindnote.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes18.dex */
public class SettingNormalImageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f234461a;

    public f getWrapper() {
        return this.f234461a;
    }

    public SettingNormalImageView(Context r100) {
        super(r100);
    }

    public void setWrapper(f r100) {
        this.f234461a = r100;
        setOnClickListener(r100);
    }

    public SettingNormalImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public SettingNormalImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
