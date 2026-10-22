package com.bytedance.android.shopping.anchorv4.voavhs.jedi;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.jedi.arch.JediArchPlugins;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> {
    public final Executor a;
    public final DiffUtil.ItemCallback<T> b;

    public a(DiffUtil.ItemCallback r1) {
        this.b = r1;
        this.a = (Executor) JediArchPlugins.INSTANCE.getStoreExecutorFactory().invoke();
    }
}
