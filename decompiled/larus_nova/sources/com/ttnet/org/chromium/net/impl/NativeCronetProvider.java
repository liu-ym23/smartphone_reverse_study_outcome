package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetProvider;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class NativeCronetProvider extends CronetProvider {
    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_APP_PACKAGED;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.mContext});
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public NativeCronetProvider(Context r100) {
        super(r100);
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder(boolean r100) {
        return new ExperimentalCronetEngine.Builder(new NativeCronetEngineBuilderWithLibraryLoaderImpl(this.mContext, r100));
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof NativeCronetProvider) == true) goto L6;
    L8:
        return false;
    L6:
        if (this.mContext.equals(((NativeCronetProvider) r100).mContext) == false) goto L8;
        goto L8
    }
}
