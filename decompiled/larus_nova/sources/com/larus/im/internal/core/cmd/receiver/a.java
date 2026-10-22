package com.larus.im.internal.core.cmd.receiver;

import com.larus.im.callback.IMError;
import com.larus.im.internal.database.utils.e;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.internal.jni.bean.OmniIMError;
import com.larus.im.internal.jni.converter.OmniIMErrorConverterKt;
import com.larus.im.internal.jni.observer.OmniDispatchCommandDispatcherKt;
import com.larus.im.internal.jni.observer.OmniDispatchCommandObserver;
import com.larus.im.service.a0;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a0> f347536a = null;

    /* JADX INFO: renamed from: com.larus.im.internal.core.cmd.receiver.a$a, reason: collision with other inner class name */
    public static final class C4341a implements OmniDispatchCommandObserver {
        public C4341a() {
        }

        @Override // com.larus.im.internal.jni.observer.OmniDispatchCommandObserver
        public final void onReceiveDispatchCommand(OmniDispatchCommandResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            CopyOnWriteArrayList<a0> r101 = a.f347536a;
            Intrinsics.checkNotNullParameter(r100, "response");
            e.d(new DispatchCommandDispatcher$notifyReceiveDispatchCommand$1(r100, null));
        }

        @Override // com.larus.im.internal.jni.observer.OmniDispatchCommandObserver
        public final void onSendDispatchCommandFailed(String r100, String r101, OmniIMError r102) {
            Intrinsics.checkNotNullParameter(r100, "targetDeviceId");
            Intrinsics.checkNotNullParameter(r101, "commandId");
            Intrinsics.checkNotNullParameter(r102, "error");
            CopyOnWriteArrayList<a0> r103 = a.f347536a;
            IMError r104 = OmniIMErrorConverterKt.toIMError(r102);
            Intrinsics.checkNotNullParameter(r100, "targetDeviceId");
            Intrinsics.checkNotNullParameter(r101, "commandId");
            Intrinsics.checkNotNullParameter(r104, "error");
            e.d(new DispatchCommandDispatcher$notifySendDispatchCommandFailed$1(r101, r100, r104, null));
        }
    }

    static {
        f347536a = new CopyOnWriteArrayList();
        OmniDispatchCommandDispatcherKt.GetOmniDispatchCommandDispatcher().registerGlobal(new C4341a());
    }
}
