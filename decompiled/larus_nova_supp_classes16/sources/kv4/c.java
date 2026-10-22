package kv4;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.g;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final lv4.b a;

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Unit> r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            this.a.getClass();
            if (com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().a.a.compareAndSet(false, true) == false) goto L17;
            tt5.a.h("WebSubPageResTask", "websubpage init res start: " + System.currentTimeMillis());
            this.a.a.getClass();
            VFSFile r2 = null;
            VFSFile r6 = ((g) org.koin.java.a.c(g.class, null, null, 6)).getResource().a;
            if (r6 == null) goto L7;
            r6.getAbsolutePath().contains("_sim");
        L7:
            if (r6 == null) goto L9;
            r2 = ay4.d.a().B(r6);
        L9:
            if (r2 != null) goto L11;
        L15:
            tt5.a.h("WebSubPageResTask", "websubpage init res end: " + System.currentTimeMillis());
            return;
        L11:
            if (r2.exists() == false) goto L15;
            if (r2.exists() == false) goto L15;
            com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().a.b.clear();
            HashMap r7 = new HashMap();
            lv4.b.a(r2, r7, r2.getParentFile().getAbsolutePath().length());
            com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().a.b.putAll(r7);
            goto L15
        }
    }

    /* JADX INFO: renamed from: kv4.c$c, reason: collision with other inner class name */
    public static final class C0246c<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public C0246c(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            tt5.a.h("WebSubPageResTask", "loadRes async:" + this.a + " success!!");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.d("WebSubPageResTask", "loadRes error:" + ((Throwable) r3).getMessage());
            int r4 = com.bytedance.ee.bear.bitable.core.usercomponent.d.a;
            Intrinsics.checkNotNullParameter("ccm.bitable.websubpage.res_load_retry_disable", "key");
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.websubpage.res_load_retry_disable") == true) goto L6;
            this.a.getClass();
            com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().a.a.set(false);
            return;
        }
    }

    static {
    }

    public c() {
        this.a = new lv4.b();
    }

    public final void b(boolean r3) {
        Observable r0 = Observable.create(new b(this));
        if (r3 == false) goto L5;
        Scheduler r1 = Schedulers.io();
    L6:
        Observable r2 = r0.subscribeOn(r1);
        if (r2 == null) goto L12;
        Observable r4 = r2.observeOn(AndroidSchedulers.mainThread());
        if (r4 == null) goto L13;
        r4.subscribe(new C0246c(r3), new d(this));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = AndroidSchedulers.mainThread();
        goto L6
    }

    public final InputStream a(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "name");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "name");
        String r2 = (String) com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().a.b.get(r7);
        InputStream r3 = null;
        if (r2 == null) goto L14;
        InputStream r8 = (InputStream) j.b(r6, r2, null).first;
        if (r8 == null) goto L10;
        int r1 = r8.available();     // Catch: Exception -> L12
        if (r1 <= 0) goto L9;
        tt5.a.h("ResUtils", "getFileStreamByName()... mFileStreamCacheMap fileName = " + r7 + " inputStream size: " + r1);     // Catch: Exception -> L12
        r3 = r8;
    L15:
        goto L14
    L9:
        tt5.a.h("ResUtils", "getFileStreamByName()..11.. fileName = ".concat(r7));     // Catch: Exception -> L12
        goto L15
    L10:
        tt5.a.h("ResUtils", "getFileStreamByName()..22.. fileName = ".concat(r7));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.h("ResUtils", "getFileStreamByName()..33.. fileName = " + r7 + "   ===== e = " + e);
    L14:
        return r3;
    }
}
