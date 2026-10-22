package com.ss.android.update;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import yhc.i;

/* JADX INFO: loaded from: classes5.dex */
public interface OnUpdateStatusChangedListener extends i {

    /* JADX INFO: loaded from: classes40.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface UpdateResultStatus {
        public static final int STATUS_AVAILABLE = 1;
        public static final int STATUS_FAILURE = -1;
        public static final int STATUS_NONE = -2;
    }

    void c(int r100);
}
