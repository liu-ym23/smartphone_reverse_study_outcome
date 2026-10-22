package defpackage;

import com.bytedance.android.shopping.store.home.entity.a0;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LTabToStoreTabAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabToStoreTabAdapterFactory implements TypeAdapterFactory {
    public TabToStoreTabAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(final Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "typeToken");
        if (Intrinsics.areEqual(r101.getRawType(), k.class) == false) goto L6;
        final TypeAdapter<T> r102 = r100.getAdapter(a0.class);
        return new AnonymousClass1(r102, r100);
    L6:
        return null;
    }
}
