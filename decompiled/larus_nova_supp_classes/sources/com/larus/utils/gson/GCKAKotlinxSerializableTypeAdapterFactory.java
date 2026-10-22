package com.larus.utils.gson;

import android.util.EventsUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import juc.v;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import ouc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/utils/gson/GCKAKotlinxSerializableTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class GCKAKotlinxSerializableTypeAdapterFactory implements TypeAdapterFactory {
    public static final GCKAKotlinxSerializableTypeAdapterFactory a = null;

    static {
        a = new GCKAKotlinxSerializableTypeAdapterFactory();
    }

    private GCKAKotlinxSerializableTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        Intrinsics.checkNotNullParameter(r4, "type");
        Class<? super T> r5 = r4.getRawType();
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.isAnnotationPresent(Serializable.class) == true) goto L9;
        return null;
    L9:
        if (ouc.i.class.isAssignableFrom(r5) == false) goto L11;
        return null;
    L11:
        juc.d r0 = kotlinx.serialization.modules.d.c(((a) xt7.d.b).b, JvmClassMappingKt.getKotlinClass(r5));
        if (r0 != null) goto L15;
        r0 = v.e(JvmClassMappingKt.getKotlinClass(r5));
    L15:
        if ((r0 instanceof juc.d) == true) goto L18;
        r0 = null;
    L18:
        if (r0 != null) goto L25;
        String r6 = "serializer is null for type: " + r5;
        FLogger.a.e("GCKAKotlinxSerializableTypeAdapter", r6);
        if (AppHost.a.isTestChannel() == true) goto L23;
        return null;
    L23:
        throw new IllegalArgumentException(r6);
    L25:
        return new GCKAKotlinxSerializableTypeAdapter(r0);
    }
}
