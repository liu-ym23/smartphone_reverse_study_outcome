package com.larus.im.internal.core.thread.receiver;

import com.larus.im.bean.thread.ThreadData;
import com.larus.im.internal.database.utils.e;
import com.larus.im.internal.jni.bean.OmniThread;
import com.larus.im.internal.jni.converter.OmniThreadConverterKt;
import com.larus.im.internal.jni.observer.OmniThreadDispatcherKt;
import com.larus.im.internal.jni.observer.OmniThreadObserver;
import com.larus.im.service.e0;
import com.larus.im.service.f0;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<e0<ThreadData>> f347911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<f0<ThreadData>> f347912b = null;

    /* JADX INFO: renamed from: com.larus.im.internal.core.thread.receiver.a$a, reason: collision with other inner class name */
    public static final class C4350a implements OmniThreadObserver {
        public C4350a() {
        }

        @Override // com.larus.im.internal.jni.observer.OmniThreadObserver
        public final void onChanged(OmniThread r100) {
            Intrinsics.checkNotNullParameter(r100, "thread");
            CopyOnWriteArrayList<e0<ThreadData>> r101 = a.f347911a;
            ThreadData r102 = OmniThreadConverterKt.toThreadData(r100);
            Intrinsics.checkNotNullParameter(r102, "threadData");
            e.d(new ThreadDispatcher$notifyChange$1(r102, null));
        }

        @Override // com.larus.im.internal.jni.observer.OmniThreadObserver
        public final void onReplace(String r100, OmniThread r101, OmniThread r102) {
            Intrinsics.checkNotNullParameter(r100, "localThreadId");
            Intrinsics.checkNotNullParameter(r102, "remote");
            CopyOnWriteArrayList<e0<ThreadData>> r103 = a.f347911a;
            if (r101 == null) goto L5;
            ThreadData r104 = OmniThreadConverterKt.toThreadData(r101);
        L6:
            ThreadData r105 = OmniThreadConverterKt.toThreadData(r102);
            Intrinsics.checkNotNullParameter(r100, "localThreadId");
            Intrinsics.checkNotNullParameter(r105, "remoteThread");
            e.d(new ThreadDispatcher$notifyReplace$1(r100, r104, r105, null));
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        OmniThreadDispatcherKt.GetOmniThreadDispatcher().registerGlobal(new C4350a());
        f347911a = new CopyOnWriteArrayList();
        f347912b = new CopyOnWriteArrayList();
    }
}
