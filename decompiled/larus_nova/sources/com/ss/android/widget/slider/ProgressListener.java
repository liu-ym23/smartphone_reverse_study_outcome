package com.ss.android.widget.slider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public interface ProgressListener {

    @Retention(RetentionPolicy.SOURCE)
    public @interface STATE {
    }

    void a(float r100, int r101);
}
