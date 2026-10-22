package com.ss.cast.discovery.mdns;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC5461b f456270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f456271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f456272c;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f456273a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 0) goto L7;
            this.f456273a.f456270a.onNsdDiscoveryTimeout();
            return;
        }

        public a(b r100, Looper r101) {
            this.f456273a = r100;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: com.ss.cast.discovery.mdns.b$b, reason: collision with other inner class name */
    public interface InterfaceC5461b {
        void onNsdDiscoveryTimeout();
    }

    public b(InterfaceC5461b r100, long r101) {
        this.f456272c = new a(this, Looper.getMainLooper());
        this.f456270a = r100;
        this.f456271b = r101;
    }
}
