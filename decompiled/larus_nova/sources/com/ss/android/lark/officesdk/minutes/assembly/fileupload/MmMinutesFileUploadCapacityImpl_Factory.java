package com.ss.android.lark.officesdk.minutes.assembly.fileupload;

import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class MmMinutesFileUploadCapacityImpl_Factory implements Factory<MmMinutesFileUploadCapacityImpl> {
    private final Provider<a> userComponentApiProvider;

    public static MmMinutesFileUploadCapacityImpl newInstance() {
        return new MmMinutesFileUploadCapacityImpl();
    }

    @Override // javax.inject.Provider
    public MmMinutesFileUploadCapacityImpl get() {
        MmMinutesFileUploadCapacityImpl r100 = newInstance();
        r100.f433582a = this.userComponentApiProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MmMinutesFileUploadCapacityImpl_Factory(Provider<a> r100) {
        this.userComponentApiProvider = r100;
    }

    public static MmMinutesFileUploadCapacityImpl_Factory create(Provider<a> r100) {
        return new MmMinutesFileUploadCapacityImpl_Factory(r100);
    }
}
