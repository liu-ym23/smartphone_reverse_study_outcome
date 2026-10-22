package com.ss.ttm.player;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public class TTAVPlayerViewType {
    public static final int DEFAULT = 0;
    public static final int SURFACE = 1;
    public static final int TEXTURE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {
    }

    public TTAVPlayerViewType() {
    }
}
