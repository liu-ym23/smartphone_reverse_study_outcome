package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.impl.Utils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public abstract class LazyInputStream {
    private final Context mContext;
    private InputStream mInput;

    public LazyInputStream(Context r100) {
        this.mContext = r100;
    }

    public final void close() {
        Utils.closeQuietly(this.mInput);
    }

    public abstract InputStream get(Context r100);

    public InputStream loadInputStream() {
        if (this.mInput != null) goto L6;
        this.mInput = get(this.mContext);
    L6:
        return this.mInput;
    }
}
