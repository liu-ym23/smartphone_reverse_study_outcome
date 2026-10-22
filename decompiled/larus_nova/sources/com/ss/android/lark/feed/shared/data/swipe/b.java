package com.ss.android.lark.feed.shared.data.swipe;

import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f421151a = null;

    static {
        f421151a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        s r101 = (s) r100;
        Intrinsics.checkNotNullParameter(r101, "r");
        return t.e(r101, SwipeActionSettingStore$getFeedActionSetting$1$1.INSTANCE);
    }
}
