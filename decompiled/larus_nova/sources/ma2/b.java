package ma2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import d52.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC6787b f512678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a52.a<?, ?>> f512679b;

    public static final class a {
    }

    /* JADX INFO: renamed from: ma2.b$b, reason: collision with other inner class name */
    public interface InterfaceC6787b {
        void Cn(Class r100, d52.b r101, la2.a r102);
    }

    static {
    }

    public abstract float c(float r100);

    public abstract int d(float r100);

    public abstract String e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract <T extends c> void i(Class<T> r100, int r101);

    public abstract void j(DataCenter r100);

    public b() {
        this.f512679b = new LinkedHashMap();
    }

    public final <T extends c> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "styleType");
        a52.a r101 = (a52.a) ((LinkedHashMap) this.f512679b).get(r100);
        if (r101 != null) goto L5;
        ALogger.i("IPSStyleSettingPresenter", r100.getSimpleName() + " has no related strategy in " + getClass().getSimpleName() + ", make sure you register it");
        r101 = null;
    L5:
        if (r101 == null) goto L10;
        BaseStyleSettingModel<T> r102 = r101.a();
        if (r102 != null) goto L9;
        return null;
    L9:
        return (T) r102.b();
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends c, V> V b(Class<T> r100, Class<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "styleType");
        Intrinsics.checkNotNullParameter(r101, "valueType");
        a52.a r102 = (a52.a) ((LinkedHashMap) this.f512679b).get(r100);
        a52.a r103 = r102;
        if (r102 != null) goto L5;
        ALogger.i("IPSStyleSettingPresenter", r100.getSimpleName() + " has no related strategy in " + e() + ", make sure you register it");
        r103 = 0;
    L5:
        if (r103 != 0) goto L7;
        return null;
    L7:
        return (V) r103.b(r103.a().b());
    }
}
