package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;

/* JADX INFO: loaded from: classes5.dex */
public class NativeCronetEngineBuilderWithLibraryLoaderImpl extends NativeCronetEngineBuilderImpl {
    private VersionSafeCallbacks.LibraryLoader mLibraryLoader;

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return this.mLibraryLoader;
    }

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
        this.mLibraryLoader = new VersionSafeCallbacks.LibraryLoader(r100);
        return this;
    }

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
        return setLibraryLoader(r100);
    }

    public NativeCronetEngineBuilderWithLibraryLoaderImpl(Context r100, boolean r101) {
        super(r100, r101);
    }
}
