package tb5;

import android.webkit.JavascriptInterface;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.Message;
import com.ss.android.lark.officesdk.utils.ReflectUtils;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends tb5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f545258a;

    public interface a {
        void a();
    }

    public interface b {
        void b(String r100);
    }

    @JavascriptInterface
    public String callSync(String r100) throws Exception {
        return "null";
    }

    @JavascriptInterface
    public void prompt(String r100) {
        Flowable.just(r100).observeOn(Schedulers.from(null)).concatMap(new tb5.b(this)).filter(new c()).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
    }

    @Override // tb5.a
    public final void b(String r100, String r101) {
        Message r102 = new Message();
        r102.f227151b = r100;
        r102.f227152c = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void c(String r100, i<T> r101, m r102) {
        a r103 = f545258a;
        if (r103 == null) goto L5;
        r103.a();
    L5:
        Class r104 = ReflectUtils.a(r101);
        if (r104 != null) goto L8;
        r104 = ReflectUtils.b(r101);
    L8:
        Object r105 = null;
        if (r104 != null) goto L20;
        r101.handle(null, r102);
        return;
    L20:
    L16:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("Bridge", "handleJSMsg PARSE_DATA_ERR  data： " + r100 + "    clazz： " + r104 + "  e: " + th);
    L18:
        r101.handle(r105, r102);
        return;
    L12:
        if (r104.equals(String.class) == false) goto L14;
        Object r106 = r100;
    L15:
        r105 = r106;
        goto L18
    L14:
        r106 = JSON.parseObject(r100, r104);     // Catch: Throwable -> L16
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void d(String r100, o<T> r101, m r102) {
        Class r103 = ReflectUtils.a(r101);
        if (r103 != null) goto L5;
        r103 = ReflectUtils.b(r101);
    L5:
        Object r104 = null;
        if (r103 != null) goto L17;
        r101.handle(null, r102);
        return;
    L17:
    L13:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("Bridge", "handleJSMsg PARSE_DATA_ERR  data： " + r100 + "    clazz： " + r103 + "  e: " + th);
    L15:
        r101.handle(r104, r102);
        return;
    L9:
        if (r103.equals(String.class) == false) goto L11;
        Object r105 = r100;
    L12:
        r104 = r105;
        goto L15
    L11:
        r105 = JSON.parseObject(r100, r103);     // Catch: Throwable -> L13
        goto L12
    }
}
