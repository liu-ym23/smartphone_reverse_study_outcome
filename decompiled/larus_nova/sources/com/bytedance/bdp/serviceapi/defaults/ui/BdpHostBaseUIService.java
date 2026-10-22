package com.bytedance.bdp.serviceapi.defaults.ui;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpHostBaseUIService extends IBdpService {

    /* JADX INFO: loaded from: classes11.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationType {
        public static final int ANIMATION_TYPE_EXIT = 2;
        public static final int ANIMATION_TYPE_FLOAT_STYLE_EXIT = 4;
        public static final int ANIMATION_TYPE_FLOAT_STYLE_IN = 3;
        public static final int ANIMATION_TYPE_IN = 1;
    }

    /* JADX INFO: loaded from: classes11.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DatePickerType {
    }
}
