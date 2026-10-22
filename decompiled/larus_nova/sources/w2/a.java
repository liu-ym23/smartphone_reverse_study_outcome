package w2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.w;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface a {

    /* JADX INFO: renamed from: w2.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC8061a<T extends AbstractC8061a<T, R>, R extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f557953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f557954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f557955c;

        public final Context getContext() {
            return this.f557953a;
        }

        public AbstractC8061a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f557953a = r100;
            this.f557955c = 1.0f;
        }
    }

    public static final class b {
        public static void b(a r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
            w2.c r102 = r100.getComposition();
            Map<String, ? extends Object> r103 = MapsKt.toMutableMap(r100.getComposition().f557957b);
            r103.putAll(r101);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r102.f557957b = r103;
        }

        public static /* synthetic */ void a(a r100, JSONObject r101, boolean r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = new JSONObject();
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = false;
        L8:
            r100.b(r101, r102);
        }
    }

    public interface c {
        void onTouchEvent(MotionEvent r100);
    }

    void a();

    View asView();

    void b(JSONObject r100, boolean r101);

    void c();

    boolean d();

    void destroy();

    void e(Map<String, ? extends Object> r100);

    Object f(String r100, JSONObject r101, Continuation<? super Unit> r102);

    w getBridge();

    w2.c getComposition();

    RenderType getRenderType();

    View realView();

    void setGlobalProperties(Map<String, ? extends Object> r100);

    void setOnTouchEventListener(c r100);

    void setReused(boolean r100);

    void setViewClient(w2.b r100);

    void setViewContext(Map<String, ? extends Object> r100);

    void setViewData(JSONObject r100);
}
