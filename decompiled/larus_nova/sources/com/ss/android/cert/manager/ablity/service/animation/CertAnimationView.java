package com.ss.android.cert.manager.ablity.service.animation;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes34.dex */
public abstract class CertAnimationView extends AppCompatImageView implements CertAnimatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    public abstract CertAnimationConfig getConfig();

    public abstract int getRepeatCount();

    public abstract int getRepeatMode();

    public abstract void setConfig(CertAnimationConfig r100);

    public abstract void setRepeatCount(int r100);

    public abstract void setRepeatMode(int r100);

    public void updateBitmap(String r100, Bitmap r101) {
    }

    public void release() {
        stop();
        setImageDrawable(null);
    }

    public CertAnimationView(Context r100) {
        super(r100);
    }
}
