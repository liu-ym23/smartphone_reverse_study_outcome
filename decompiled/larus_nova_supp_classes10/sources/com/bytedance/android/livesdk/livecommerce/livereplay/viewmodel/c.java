package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import androidx.lifecycle.ViewModelProvider;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final <T extends QViewModel> T a(QContext r1, Class<T> r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$vm");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "factory");
        return new ViewModelProvider(r1.a(), r3).get(r2);
    }
}
