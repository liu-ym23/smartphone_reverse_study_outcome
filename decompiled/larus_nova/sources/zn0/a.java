package zn0;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<Object> f572900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Converter<TypedInput, ?> f572901b;

    public final void a() {
        this.f572900a.onComplete();
    }

    public final void b(com.bytedance.frameworks.baselib.netx.chunk.b r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, MonitorConstants.CHUNK);
        r101.getClass();
        throw null;
    }

    public final void c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f572900a.onFailed(r100);
    }

    public final void d(com.bytedance.frameworks.baselib.netx.chunk.b r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, MonitorConstants.CHUNK);
        r101.getClass();
        throw null;
    }

    public a(e<Object> r100, Converter<TypedInput, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Intrinsics.checkNotNullParameter(r101, "converter");
        this.f572900a = r100;
        this.f572901b = r101;
    }
}
