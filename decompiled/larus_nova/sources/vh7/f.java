package vh7;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.tools.kcp.modelx.runtime.internal.CompositeModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionProcessor;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.ModelXReflections;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f554983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f554984b;

    static {
        f554983a = d.a.f554982a;
        f554984b = new g.a();
    }

    @JvmStatic
    public static final <T extends c<?>> T c(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100.isInterface() == false) goto L9;
        CompositeModelExtensionInfoHolder r101 = ModelExtensionProcessor.f270937a;
        Intrinsics.checkNotNullParameter(r100, "interfaceType");
        Class<?> r102 = ModelExtensionProcessor.f270937a.c(r100);
        if (r102 == null) goto L9;
        return (T) ModelXReflections.f(r102, SliceInitService.DEFAULT_SWITCH, false);
    L9:
        return (T) ModelXReflections.f(r100, SliceInitService.DEFAULT_SWITCH, false);
    }

    @JvmStatic
    public static final <T> T a(am3.g r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        Intrinsics.checkNotNullParameter(r101, "type");
        return (T) ModelExtensionProcessor.a(r101, r100);
    }

    @JvmStatic
    public static final <T> T b(byte[] r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r101, "type");
        am3.g r102 = new am3.g();
        r102.k(new am3.b(r100));
        return (T) ModelExtensionProcessor.a(r101, r102);
    }
}
