package com.bytedance.ee.android.file.picker.lib.v2.data.category;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import sm4.a;
import sm4.c;

/* JADX INFO: loaded from: classes15.dex */
public final class FileCategoryConfigModule_ProvideReceivedConfigFactory implements Factory<a> {
    private final Provider<Context> contextProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideReceivedConfig(this.contextProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FileCategoryConfigModule_ProvideReceivedConfigFactory(Provider<Context> r100) {
        this.contextProvider = r100;
    }

    public static FileCategoryConfigModule_ProvideReceivedConfigFactory create(Provider<Context> r100) {
        return new FileCategoryConfigModule_ProvideReceivedConfigFactory(r100);
    }

    public static a provideReceivedConfig(Context r100) {
        int r101 = c.f542573a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (a) Preconditions.checkNotNullFromProvides(new a(500, UIUtils.getString(r100, R.string.Lark_Legacy_FileTypeReceive)));
    }
}
