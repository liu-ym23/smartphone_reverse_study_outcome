package te7;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends se7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f545612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f545613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<InputStream> f545614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f545615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f545616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f545617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<WeakReference<Call<TypedInput>>> f545618g;

    public final void a() {
        InputStream r100 = this.f545614c.element;     // Catch: Throwable -> L7
        if (r100 == null) goto L20;
        r100.close();     // Catch: Throwable -> L7
    L20:
        WeakReference<Call<TypedInput>> r101 = this.f545618g.element;     // Catch: Throwable -> L17
        if (r101 == null) goto L24;
        Call<TypedInput> r102 = r101.get();     // Catch: Throwable -> L17
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.isCanceled() == true) goto L26;
        r102.cancel();     // Catch: Throwable -> L17
        return;
    L26:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        Logger.e("HostNetworkDependImpl", "close call failed", th);
        return;
    L7:
        th = move-exception;
        Logger.e("HostNetworkDependImpl", "close inputStream failed", th);
        goto L20
    }

    public final Integer b() {
        return Integer.valueOf(this.f545617f.element);
    }

    public final String c() {
        return this.f545615d.element;
    }

    public final Throwable d() {
        return this.f545616e.element;
    }

    public final InputStream e() {
        return this.f545614c.element;
    }

    public i(LinkedHashMap<String, String> r100, Ref.IntRef r101, Ref.ObjectRef<InputStream> r102, Ref.ObjectRef<String> r103, Ref.ObjectRef<Throwable> r104, Ref.IntRef r105, Ref.ObjectRef<WeakReference<Call<TypedInput>>> r106) {
        this.f545612a = r100;
        this.f545613b = r101;
        this.f545614c = r102;
        this.f545615d = r103;
        this.f545616e = r104;
        this.f545617f = r105;
        this.f545618g = r106;
    }
}
