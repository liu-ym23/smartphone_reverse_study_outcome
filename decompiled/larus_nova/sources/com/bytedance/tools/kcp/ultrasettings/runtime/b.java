package com.bytedance.tools.kcp.ultrasettings.runtime;

import com.facebook.keyframes.model.KFAnimation;
import java.lang.reflect.Type;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f271021a = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f271022b = null;

        public a() {
        }

        static {
            f271022b = new a();
        }

        @Override // com.bytedance.tools.kcp.ultrasettings.runtime.b
        public final <T> ReadOnlyProperty<Object, T> a(String r100, T r101, Type r102, boolean r103, KProperty<?> r104) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r102, "type");
            Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            throw new NotImplementedError("UltraSettings sdk is not initialized.");
        }
    }

    static {
        f271021a = a.f271022b;
    }

    <T> ReadOnlyProperty<Object, T> a(String r100, T r101, Type r102, boolean r103, KProperty<?> r104);
}
