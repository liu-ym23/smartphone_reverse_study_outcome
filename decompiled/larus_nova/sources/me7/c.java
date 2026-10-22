package me7;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext;
import com.bytedance.sdk.xbridge.cn.registry.core.RefType;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c implements IBDXContainerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f513511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f513512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f513513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, j<?>> f513514d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f513515a = null;

        static {
            int[] r100 = new int[RefType.values().length];
            r100[RefType.WEAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RefType.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f513515a = r100;
        }
    }

    public final void b() {
        Iterator r100 = ((ConcurrentHashMap) this.f513514d).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((j) r100.next()).release();
        goto L4
    L6:
        ((ConcurrentHashMap) this.f513514d).clear();
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L11;
        this.f513512b = null;
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final Activity getOwnerActivity() {
        View r100 = this.f513512b;
        if (r100 == null) goto L5;
        Context r101 = r100.getContext();
    L7:
        return com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getContainerID() {
        return this.f513511a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final View getEngineView() {
        return this.f513512b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getNamespace() {
        return this.f513513c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        j r101 = (j) ((ConcurrentHashMap) this.f513514d).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.provideInstance();
    }

    public final <T> void a(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Map<Class<?>, j<?>> r102 = this.f513514d;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r100, new u(r101));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        getJsEventDelegate().a(r100, r101);
    }

    public c(String r100, View r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "containerID");
        Intrinsics.checkNotNullParameter(r102, "namespace");
        this.f513511a = r100;
        this.f513512b = r101;
        this.f513513c = r102;
        this.f513514d = new ConcurrentHashMap();
    }
}
