package pq;

import android.graphics.Typeface;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    BaseSlcViewManager<?> a(String r100, SlcTemplateContext r101);

    int b();

    com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a c();

    Map<String, Object> d();

    JSONObject e();

    void ensureNotReachHere(Throwable r100, String r101);

    void f();

    void g(int r100, Function1<? super c, Unit> r101);

    String getAppId();

    String getAppVersionName();

    b h();

    void i(String r100, Map<String, ? extends Object> r101);

    boolean isDebug();

    boolean isLocalTest();

    boolean isNightMode();

    Typeface j(String r100, int r101, boolean r102);

    Object provideImageCallerContext(String r100, String r101);
}
