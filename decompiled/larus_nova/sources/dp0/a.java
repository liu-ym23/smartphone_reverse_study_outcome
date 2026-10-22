package dp0;

import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenPlatformContext f469557a;

    public abstract boolean a();

    public abstract void b(String r100, String r101, boolean r102);

    public abstract void c(String r100, String r101, boolean r102);

    public abstract void d(String r100, String r101, String r102);

    public abstract void e(String r100, LinkScreenCastType r101, String r102);

    public abstract void f(String r100, LinkScreenCastType r101);

    public abstract void g();

    public abstract void h(String r100, int r101, int r102, LinkScreenCastType r103, boolean r104);

    public abstract void i(String r100, LinkScreenCastType r101, boolean r102);

    public a(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        this.f469557a = r100;
    }
}
