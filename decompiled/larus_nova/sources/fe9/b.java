package fe9;

import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements gd9.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f476621b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gd9.h f476622c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gd9.h f476623a;

    static {
        f476621b = new b();
        f476622c = FlowRuntime.b().e();
    }

    public b() {
        this.f476623a = FlowRuntime.b().e();
    }

    @Override // gd9.h
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f476622c.d("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f476622c.e("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f476622c.i("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f476622c.v("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f476622c.w("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f476622c.e("FlowIMSDK_" + r100, r101, r102);
    }

    @Override // gd9.h
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f476622c.w("FlowIMSDK_" + r100, r101, r102);
    }
}
