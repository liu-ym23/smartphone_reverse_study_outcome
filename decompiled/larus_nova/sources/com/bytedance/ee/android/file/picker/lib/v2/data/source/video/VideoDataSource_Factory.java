package com.bytedance.ee.android.file.picker.lib.v2.data.source.video;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class VideoDataSource_Factory implements Factory<VideoDataSource> {
    private final Provider<Context> mContextProvider;

    @Override // javax.inject.Provider
    public VideoDataSource get() {
        return newInstance(this.mContextProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VideoDataSource_Factory(Provider<Context> r100) {
        this.mContextProvider = r100;
    }

    public static VideoDataSource_Factory create(Provider<Context> r100) {
        return new VideoDataSource_Factory(r100);
    }

    public static VideoDataSource newInstance(Context r100) {
        return new VideoDataSource(r100);
    }
}
