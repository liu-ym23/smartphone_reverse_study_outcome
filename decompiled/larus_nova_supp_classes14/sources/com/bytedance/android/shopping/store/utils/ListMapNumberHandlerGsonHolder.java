package com.bytedance.android.shopping.store.utils;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ListMapNumberHandlerGsonHolder {
    public static final Type a = null;
    public static final Lazy b = null;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/android/shopping/store/utils/ListMapNumberHandlerGsonHolder$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Map<String, ? extends Object>>> {
        public a() {
        }
    }

    static {
        a = new a().getType();
        b = LazyKt.lazy(ListMapNumberHandlerGsonHolder$instance$2.INSTANCE);
    }
}
