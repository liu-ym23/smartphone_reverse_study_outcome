package com.larus.im.internal.core.project.receiver;

import com.larus.im.internal.database.utils.e;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.observer.OmniProjectDispatcherKt;
import com.larus.im.internal.jni.observer.OmniProjectObserver;
import com.larus.im.service.c0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vt7.a<String, CopyOnWriteArrayList<c0<OmniProject>>> f347909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<c0<OmniProject>> f347910b = null;

    /* JADX INFO: renamed from: com.larus.im.internal.core.project.receiver.a$a, reason: collision with other inner class name */
    public static final class C4349a implements OmniProjectObserver {
        public C4349a() {
        }

        @Override // com.larus.im.internal.jni.observer.OmniProjectObserver
        public final void onChanged(List<OmniProject> r100) {
            Intrinsics.checkNotNullParameter(r100, "projects");
            vt7.a<String, CopyOnWriteArrayList<c0<OmniProject>>> r101 = a.f347909a;
            Intrinsics.checkNotNullParameter(r100, "projects");
            e.d(new ProjectDispatcher$notifyChange$1(r100, null));
        }
    }

    static {
        new ReentrantLock();
        f347909a = new vt7.a();
        new vt7.a();
        f347910b = new CopyOnWriteArrayList();
        com.larus.im.internal.delegate.a.f348188b.i("ProjectDispatcher", "init");
        OmniProjectDispatcherKt.GetOmniProjectDispatcher().registerGlobal(new C4349a());
    }
}
