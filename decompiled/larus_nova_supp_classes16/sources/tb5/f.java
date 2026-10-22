package tb5;

import android.webkit.JavascriptInterface;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.Message;
import com.ss.android.lark.officesdk.utils.ReflectUtils;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends tb5.a {
    public static a a;

    public interface a {
        void a();
    }

    public interface b {
        void b(String r1);
    }

    @JavascriptInterface
    public String callSync(String r1) throws Exception {
        return "null";
    }

    @JavascriptInterface
    public void prompt(String r3) {
        Flowable.just(r3).observeOn(Schedulers.from(null)).concatMap(new tb5.b(this)).filter(new c()).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
    }

    @Override // tb5.a
    public final void b(String r2, String r3) {
        Message r0 = new Message();
        r0.b = r2;
        r0.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void c(String r5, i<T> r6, m r7) {
        a r0 = a;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        Class r1 = ReflectUtils.a(r6);
        if (r1 != null) goto L8;
        r1 = ReflectUtils.b(r6);
    L8:
        Object r2 = null;
        if (r1 != null) goto L20;
        r6.handle(null, r7);
        return;
    L20:
    L16:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("Bridge", "handleJSMsg PARSE_DATA_ERR  data： " + r5 + "    clazz： " + r1 + "  e: " + th);
    L18:
        r6.handle(r2, r7);
        return;
    L12:
        if (r1.equals(String.class) == false) goto L14;
        Object r8 = r5;
    L15:
        r2 = r8;
        goto L18
    L14:
        r8 = JSON.parseObject(r5, r1);     // Catch: Throwable -> L16
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void d(String r5, o<T> r6, m r7) {
        Class r0 = ReflectUtils.a(r6);
        if (r0 != null) goto L5;
        r0 = ReflectUtils.b(r6);
    L5:
        Object r1 = null;
        if (r0 != null) goto L17;
        r6.handle(null, r7);
        return;
    L17:
    L13:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("Bridge", "handleJSMsg PARSE_DATA_ERR  data： " + r5 + "    clazz： " + r0 + "  e: " + th);
    L15:
        r6.handle(r1, r7);
        return;
    L9:
        if (r0.equals(String.class) == false) goto L11;
        Object r8 = r5;
    L12:
        r1 = r8;
        goto L15
    L11:
        r8 = JSON.parseObject(r5, r0);     // Catch: Throwable -> L13
        goto L12
    }
}
