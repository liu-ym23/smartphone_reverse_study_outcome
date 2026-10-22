package e3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.context.RefType;
import com.google.gson.JsonObject;
import d3.a0;
import d3.w;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f470889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f470890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<View> f470891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<String> f470892d;

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5733a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f470893a = null;

        static {
            int[] r100 = new int[RefType.values().length];
            r100[RefType.WEAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RefType.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f470893a = r100;
        }
    }

    @Override // e3.d
    public final a0 getContainerContext() {
        return (a0) d(a0.class);
    }

    @Override // e3.d
    public final View getEngineView() {
        WeakReference<View> r100 = this.f470891c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // e3.d
    public final Activity getOwnerActivity() {
        a0 r100 = (a0) d(a0.class);
        Context r101 = null;
        if (r100 == null) goto L5;
        ContainerType r102 = r100.getContainerType();
    L7:
        if (r102 != ContainerType.WORKER) goto L9;
        return null;
    L9:
        if (getEngineView() == null) goto L17;
        View r103 = getEngineView();
        if (r103 == null) goto L15;
        r101 = r103.getContext();
    L15:
        return getActivity(r101);
    L17:
        return null;
    L5:
        r102 = null;
        goto L7
    }

    @Override // e3.d
    public final g getJsEventDelegate() {
        return this.f470889a;
    }

    public a(w.d r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEventDelegate");
        this.f470889a = r100;
        this.f470890b = new ConcurrentHashMap();
        this.f470892d = new SparseArray();
    }

    private final Activity getActivity(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100 == null) goto L13;
        if ((r100 instanceof Activity) == true) goto L9;
        if ((r100 instanceof ContextWrapper) == false) goto L13;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L5
    L9:
        return (Activity) r100;
    L13:
        return null;
    }

    @Override // e3.d
    public final String c(int r100) {
        return this.f470892d.get(r100);
    }

    @Override // e3.d
    public final <T> T d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        f r101 = (f) ((ConcurrentHashMap) this.f470890b).get(r100);
        if (r101 == null) goto L5;
        Object r102 = r101.provideInstance();
    L6:
        if (r102 != null) goto L9;
        return null;
    L9:
        return (T) r102;
    L5:
        r102 = null;
        goto L6
    }

    @Override // e3.d
    public final void a(String r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f470889a.b(r100, r101);
    }

    public final <T> void e(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        b(r100, r101, RefType.NORMAL);
    }

    @Override // e3.d
    public final <T> void b(Class<T> r100, T r101, RefType r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r102, "refType");
        int r103 = C5733a.f470893a[r102.ordinal()];
        if (r103 != 1) goto L5;
        Map<Class<?>, f<?>> r104 = this.f470890b;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r100, new h(r101));
        return;
    L5:
        if (r103 != 2) goto L8;
        Map<Class<?>, f<?>> r106 = this.f470890b;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(r100, new c(r101));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
