package com.bytedance.android.shopping.prepurchase.arch.exposure;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ConfigurationBuilder {
    public LifecycleOwner a;
    public f b;
    public long c;
    public Function1<? super View, c> d;

    public ConfigurationBuilder() {
        this.c = 100;
        this.d = ConfigurationBuilder$algorithm$1.INSTANCE;
    }
}
