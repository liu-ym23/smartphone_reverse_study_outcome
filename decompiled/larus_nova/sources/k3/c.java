package k3;

import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.google.gson.JsonObject;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f501630a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f501631a = null;

        static {
            int[] r100 = new int[DefaultType.values().length];
            r100[DefaultType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DefaultType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DefaultType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DefaultType.BOOL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DefaultType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f501631a = r100;
        }
    }

    static {
    }

    public static BaseModel a(final Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        final JsonObject r101 = new JsonObject();
        Object r102 = Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new b(r100, r101));
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.bytedance.ai.bridge.core.utils.ResultModelArguments.createModel");
        return (BaseModel) r102;
    }
}
