package w64;

import android.content.Context;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.NetworkStatusMonitor;
import com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeResult;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements IMobileResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f558413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f558414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f558415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f558416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BadgerModuleBase.BadgerRequestData f558417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f558418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f558419g;

    public a(c r100, AtomicInteger r101, Ref.ObjectRef r102, Context r103, BadgerModuleBase.BadgerRequestData r104, long r105, CountDownLatch r106) {
        this.f558413a = r100;
        this.f558414b = r101;
        this.f558415c = r102;
        this.f558416d = r103;
        this.f558417e = r104;
        this.f558418f = r105;
        this.f558419g = r106;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, org.json.JSONObject] */
    @Override // com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback
    public final void onComplete(Object r100) {
        PseudoCodeResult r101 = (PseudoCodeResult) r100;
    L13:
        th = move-exception;
        this.f558419g.countDown();
        throw th;
    L4:
        if (this.f558414b.compareAndSet(0, 1) == false) goto L10;
        com.bytedance.badger.e.f(Constants.TAGS.PSEUDO, "pseudo done, result=" + r101);     // Catch: Throwable -> L13
        Ref.ObjectRef r102 = this.f558415c;     // Catch: Throwable -> L13
        c r103 = this.f558413a;     // Catch: Throwable -> L13
        Context r104 = this.f558416d;     // Catch: Throwable -> L13
        r103.getClass();     // Catch: Throwable -> L13
        r102.element = c.c(r101, r104);     // Catch: Throwable -> L13
        if (r101.enableSimCardListen == true) goto L8;
    L11:
        this.f558419g.countDown();
        return;
    L8:
        if (NetworkStatusMonitor.isStarted() == true) goto L11;
        Context r105 = this.f558416d;     // Catch: Throwable -> L13
        h r106 = new h(r105);     // Catch: Throwable -> L13
        NetworkStatusMonitor.getInstance(r105).setOnNetworkChangeListener(r106);     // Catch: Throwable -> L13
        NetworkStatusMonitor.getInstance(this.f558416d).setOnSimCardChangeListener(r106);     // Catch: Throwable -> L13
        NetworkStatusMonitor.getInstance(this.f558416d).start();     // Catch: Throwable -> L13
        com.bytedance.badger.e.f(Constants.TAGS.PSEUDO, "enable pseudo listener");     // Catch: Throwable -> L13
        goto L11
    L10:
        c.d(this.f558413a, this.f558416d, r101, this.f558417e, this.f558418f);     // Catch: Throwable -> L13
        goto L11
    }
}
