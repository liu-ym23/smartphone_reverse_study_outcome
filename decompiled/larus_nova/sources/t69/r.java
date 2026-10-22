package t69;

import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class r implements yj4.i {
    public r() {
    }

    @Override // yj4.i
    public final /* synthetic */ void a() {
    }

    @Override // yj4.i
    public final /* synthetic */ void c() {
    }

    @Override // yj4.i
    public final /* synthetic */ void e() {
    }

    @Override // yj4.i
    public final /* synthetic */ void i(String r100, long r101, int r102) {
    }

    @Override // yj4.i
    public final void b(int r100) {
        FLogger.f375446a.i("FlowDoraWifiStateManager", "onGlassOpenStateChange: state=" + r100);
        FlowDoraGlassOpenState.Companion.getClass();
        FlowDoraGlassOpenState r101 = FlowDoraGlassOpenState.a.a(r100);
        Iterator<h49.i> r102 = s.f544697a.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        r102.next().a(r101);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        FLogger.f375446a.e("FlowDoraWifiStateManager", "onGlassOpenStateChange: ", th);
        throw th;
    }

    @Override // yj4.i
    public final void d(yj4.b r100) {
        FLogger.f375446a.i("FlowDoraWifiStateManager", "onAlbumThumbnailData: data =" + r100);
        Iterator<h49.i> r101 = s.f544697a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        h49.i r102 = r101.next();
        byte[] r103 = r100.f568080b;
        if (r103 != null) goto L8;
        r103 = new byte[0];
    L8:
        r102.d(new b49.f(r103));
        goto L4
    }

    @Override // yj4.i
    public final void f(int r100) {
        FLogger.f375446a.i("FlowDoraWifiStateManager", "onVideoEvent: event=" + r100);
        FlowDoraGlassOpenState.Companion.getClass();
        FlowDoraGlassOpenState r101 = FlowDoraGlassOpenState.a.a(r100);
        Iterator<h49.i> r102 = s.f544697a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().e(r101);
        goto L4
    }

    @Override // yj4.i
    public final void g(yj4.a r100) {
        FLogger.f375446a.i("FlowDoraWifiStateManager", "onAlbumStateChanged: state=" + r100);
        Iterator<T> r101 = s.f544697a.iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        h49.i r102 = (h49.i) r101.next();
        Integer r103 = null;
        if (r100 == null) goto L8;
        Integer r104 = Integer.valueOf(r100.f568075a);
    L9:
        if (r100 == null) goto L11;
        Integer r105 = Integer.valueOf(r100.f568076b);
    L12:
        if (r100 == null) goto L14;
        Integer r106 = Integer.valueOf(r100.f568077c);
    L15:
        if (r100 == null) goto L17;
        r103 = Integer.valueOf(r100.f568078d);
    L17:
        r102.b(new b49.e(r104, r105, r106, r103));
        goto L4
    L14:
        r106 = null;
        goto L15
    L11:
        r105 = null;
        goto L12
    L8:
        r104 = null;
        goto L9
    }

    @Override // yj4.i
    public final void h(int r100) {
        FLogger.f375446a.i("FlowDoraWifiStateManager", "onAlbumSilentTrans: state=" + r100);
        Iterator<h49.i> r101 = s.f544697a.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        r101.next().c();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        FLogger.f375446a.e("FlowDoraWifiStateManager", "onAlbumSilentTrans: ", th);
        throw th;
    }
}
