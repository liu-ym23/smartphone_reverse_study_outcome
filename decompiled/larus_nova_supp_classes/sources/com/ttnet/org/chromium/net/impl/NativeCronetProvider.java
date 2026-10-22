package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetProvider;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class NativeCronetProvider extends CronetProvider {
    public String getName() {
        return "App-Packaged-Cronet-Provider";
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, ((CronetProvider) this).mContext});
    }

    public boolean isEnabled() {
        return true;
    }

    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public NativeCronetProvider(Context r1) {
        super(r1);
    }

    public CronetEngine.Builder createBuilder(boolean r3) {
        return new ExperimentalCronetEngine.Builder(new NativeCronetEngineBuilderWithLibraryLoaderImpl(((CronetProvider) this).mContext, r3));
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof NativeCronetProvider) == true) goto L6;
    L8:
        return false;
    L6:
        if (((CronetProvider) this).mContext.equals(((CronetProvider) ((NativeCronetProvider) r2)).mContext) == false) goto L8;
        goto L8
    }
}
