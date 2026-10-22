package kv4;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n25.j;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lv4.b f506267a;

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f506268a;

        public b(c r100) {
            this.f506268a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f506268a.getClass();
            if (com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().f210608a.f210611a.compareAndSet(false, true) == false) goto L17;
            tt5.a.h("WebSubPageResTask", "websubpage init res start: " + System.currentTimeMillis());
            this.f506268a.f506267a.getClass();
            VFSFile r101 = null;
            VFSFile r102 = ((g) org.koin.java.a.c(g.class, null, null, 6)).getResource().f218007a;
            if (r102 == null) goto L7;
            r102.getAbsolutePath().contains("_sim");
        L7:
            if (r102 == null) goto L9;
            r101 = ay4.d.a().B(r102);
        L9:
            if (r101 != null) goto L11;
        L15:
            tt5.a.h("WebSubPageResTask", "websubpage init res end: " + System.currentTimeMillis());
            return;
        L11:
            if (r101.exists() == false) goto L15;
            if (r101.exists() == false) goto L15;
            com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().f210608a.f210612b.clear();
            HashMap r103 = new HashMap();
            lv4.b.a(r101, r103, r101.getParentFile().getAbsolutePath().length());
            com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().f210608a.f210612b.putAll(r103);
            goto L15
        }
    }

    /* JADX INFO: renamed from: kv4.c$c, reason: collision with other inner class name */
    public static final class C6615c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f506269a;

        public C6615c(boolean r100) {
            this.f506269a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            tt5.a.h("WebSubPageResTask", "loadRes async:" + this.f506269a + " success!!");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f506270a;

        public d(c r100) {
            this.f506270a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("WebSubPageResTask", "loadRes error:" + ((Throwable) r100).getMessage());
            int r101 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
            Intrinsics.checkNotNullParameter("ccm.bitable.websubpage.res_load_retry_disable", "key");
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.websubpage.res_load_retry_disable") == true) goto L6;
            this.f506270a.getClass();
            com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().f210608a.f210611a.set(false);
            return;
        }
    }

    static {
    }

    public c() {
        this.f506267a = new lv4.b();
    }

    public final void b(boolean r100) {
        Observable r101 = Observable.create(new b(this));
        if (r100 == false) goto L5;
        Scheduler r102 = Schedulers.io();
    L6:
        Observable r103 = r101.subscribeOn(r102);
        if (r103 == null) goto L12;
        Observable r104 = r103.observeOn(AndroidSchedulers.mainThread());
        if (r104 == null) goto L13;
        r104.subscribe(new C6615c(r100), new d(this));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = AndroidSchedulers.mainThread();
        goto L6
    }

    public final InputStream a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f506267a.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "name");
        String r102 = com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().f210608a.f210612b.get(r101);
        InputStream r103 = null;
        if (r102 == null) goto L14;
        InputStream r104 = (InputStream) j.b(r100, r102, null).first;
        if (r104 == null) goto L10;
        int r105 = r104.available();     // Catch: Exception -> L12
        if (r105 <= 0) goto L9;
        tt5.a.h("ResUtils", "getFileStreamByName()... mFileStreamCacheMap fileName = " + r101 + " inputStream size: " + r105);     // Catch: Exception -> L12
        r103 = r104;
    L15:
        goto L14
    L9:
        tt5.a.h("ResUtils", "getFileStreamByName()..11.. fileName = ".concat(r101));     // Catch: Exception -> L12
        goto L15
    L10:
        tt5.a.h("ResUtils", "getFileStreamByName()..22.. fileName = ".concat(r101));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.h("ResUtils", "getFileStreamByName()..33.. fileName = " + r101 + "   ===== e = " + e);
    L14:
        return r103;
    }
}
