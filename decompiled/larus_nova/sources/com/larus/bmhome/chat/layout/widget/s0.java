package com.larus.bmhome.chat.layout.widget;

import com.larus.common.apphost.AppHost;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<q0>> f305249a = null;

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            CopyOnWriteArrayList<WeakReference<q0>> r100 = s0.f305249a;
            CollectionsKt.removeAll(r100, new r0(null));
            Iterator<WeakReference<q0>> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            q0 r102 = r101.next().get();
            if (r102 == null) goto L4;
            Intrinsics.checkNotNullParameter(r102, "it");
            r102.onAppBackground();
            Unit r103 = Unit.INSTANCE;
            goto L4
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            CopyOnWriteArrayList<WeakReference<q0>> r100 = s0.f305249a;
            CollectionsKt.removeAll(r100, new r0(null));
            Iterator<WeakReference<q0>> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            q0 r102 = r101.next().get();
            if (r102 == null) goto L4;
            Intrinsics.checkNotNullParameter(r102, "it");
            r102.onAppForeground();
            Unit r103 = Unit.INSTANCE;
            goto L4
        }
    }

    public s0() {
    }

    static {
        f305249a = new CopyOnWriteArrayList();
        a r100 = new a();
        AppHost.f326268a.a().j(r100);
    }

    public static void a(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        CopyOnWriteArrayList<WeakReference<q0>> r101 = f305249a;
        CollectionsKt.removeAll(r101, new r0(r100));
        r101.add(new WeakReference(r100));
    }
}
