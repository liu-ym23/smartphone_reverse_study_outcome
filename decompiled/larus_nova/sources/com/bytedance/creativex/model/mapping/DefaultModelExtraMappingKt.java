package com.bytedance.creativex.model.mapping;

import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes15.dex */
public final class DefaultModelExtraMappingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<? extends Object>[] f204227a = null;

    static {
        f204227a = new Class[]{Parcelable.class, Serializable.class, Byte.TYPE, Character.TYPE, Boolean.TYPE, Integer.TYPE, Short.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, String.class};
    }

    public static final InitialModelExtraMapping a() {
        return new InitialModelExtraMapping(DefaultModelExtraMappingKt$simpleBundleModelExtraMapping$1.INSTANCE);
    }
}
