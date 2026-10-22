package uk4;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dora.wear.PlayState;
import com.bytedance.dora.wear.WearState;
import hk4.e;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import pk4.j;
import pk4.m;
import pk4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<c> f550488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ak4.a f550489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f550490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f550491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f550492e;

    public class a implements IDoraLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f550493a;

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
            IDoraLinkCallback.CC.$default$onBtConnectStateChanged(this, r100, r101, r102);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onBtStateChanged(int r100, int r101) {
            IDoraLinkCallback.CC.$default$onBtStateChanged(this, r100, r101);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onDeviceFound(DoraDevice r100) {
            IDoraLinkCallback.CC.$default$onDeviceFound(this, r100);
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final /* synthetic */ void onScanFailed(int r100) {
            IDoraLinkCallback.CC.$default$onScanFailed(this, r100);
        }

        public a(b r100) {
            this.f550493a = r100;
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            if (r102 != 2) goto L11;
            final b r103 = this.f550493a;     // Catch: Exception -> L6
            m.a(new uk4.a(r103));     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            j.c("DoraWear", "onDoraLinkStateChanged, Exception: ", e);
            return;
        }
    }

    /* JADX INFO: renamed from: uk4.b$b, reason: collision with other inner class name */
    public static class C7893b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f550494a = null;

        static {
            f550494a = new b();
        }
    }

    public final byte b() {
        this.f550489b.h(1, 4, n.b(1, 4, 6), new byte[]{6, 0});
        byte[] r100 = this.f550490c;
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (r100.length >= 1) goto L7;
        return -1;
    L7:
        return r100[0];
    }

    public b() {
        this.f550488a = new CopyOnWriteArraySet();
        this.f550489b = ak4.a.d();
        this.f550490c = null;
        this.f550491d = new a(this);
        this.f550492e = new AtomicBoolean(false);
    }

    public final void a(DoraDevice r100, int[] r101) {
        Iterator r102 = ((CopyOnWriteArraySet) this.f550488a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        c r103 = (c) r102.next();
        WearState r104 = WearState.values()[r101[0]];
        WearState r105 = WearState.values()[r101[1]];
        PlayState r106 = PlayState.values()[r101[2]];
        r103.a(r100, r104, r105);
        goto L4
    }
}
