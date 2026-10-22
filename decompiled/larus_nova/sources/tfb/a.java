package tfb;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.floating.enums.ShowPattern;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import com.ss.android.lark.floating.widget.appfloat.TouchUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import wfb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f545789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f545790b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f545791c;

    /* JADX INFO: renamed from: tfb.a$a, reason: collision with other inner class name */
    public static final class C7719a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f545792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vfb.a f545793b;

        /* JADX INFO: renamed from: tfb.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C7720a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f545794a = null;

            static {
                int[] r100 = new int[ShowPattern.values().length];
                r100[ShowPattern.CURRENT_ACTIVITY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[ShowPattern.FOREGROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[ShowPattern.BACKGROUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[ShowPattern.ALL_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f545794a = r100;
            }
        }

        public final void c() {
            if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L9;
            xfb.g r100 = xfb.g.f563558e;
            if (r100 != null) goto L8;
            r100 = new xfb.g();
            xfb.g.f563558e = r100;
        L8:
            r100.a();
        L9:
            com.ss.android.lark.floating.widget.appfloat.c r101 = com.ss.android.lark.floating.widget.appfloat.c.f421938a;
            Context r102 = this.f545792a;
            vfb.a r103 = this.f545793b;
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "config");
            String r104 = r103.f554609d;
            if (r104 != null) goto L12;
            r104 = "default";
        L12:
            r103.f554609d = r104;
            Map<String, AppFloatManager> r105 = com.ss.android.lark.floating.widget.appfloat.c.f421939b;
            if ((!r105.containsKey(r104)) == false) goto L33;
            String r106 = r103.f554609d;
            if (r106 == null) goto L29;
            AppFloatManager r107 = new AppFloatManager(r102.getApplicationContext(), r103);
            r107.f421880f = new TouchUtils(r107.f421875a, r107.f421876b);     // Catch: Exception -> L20
            r107.g();     // Catch: Exception -> L20
            r107.a();     // Catch: Exception -> L20
            r107.f421876b.f554616k = true;     // Catch: Exception -> L20
            Unit r108 = Unit.INSTANCE;     // Catch: Exception -> L20
        L28:
            r105.put(r106, r107);
        L20:
            e = move-exception;
            r107.f421876b.getClass();
            wfb.a r109 = r107.f421876b.B;
            if (r109 == null) goto L28;
            wfb.a.C8107a r110 = r109.a();
            if (r110 == null) goto L28;
            Function3<? super Boolean, ? super String, ? super View, Unit> r111 = r110.f559497a;
            if (r111 == null) goto L28;
            r111.invoke(Boolean.FALSE, String.valueOf(e), null);
            Unit r112 = Unit.INSTANCE;
        L29:
            Unit r113 = Unit.INSTANCE;
            return;
        }

        public C7719a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f545792a = r100;
            this.f545793b = new vfb.a(null);
        }

        @Override // wfb.g
        public final void a(boolean r100) {
            if (r100 == false) goto L4;
            c();
            return;
        L4:
            b("No permission exception. You need to turn on overlay permissions.");
        }

        public final void b(String r100) {
            this.f545793b.getClass();
            wfb.a r101 = this.f545793b.B;
            if (r101 == null) goto L9;
            wfb.a.C8107a r102 = r101.a();
            if (r102 == null) goto L9;
            Function3<? super Boolean, ? super String, ? super View, Unit> r103 = r102.f559497a;
            if (r103 == null) goto L9;
            r103.invoke(Boolean.FALSE, r100, null);
        L9:
            Log.w(r100);
            int r104 = r100.hashCode();
            if (r104 == 324317221) goto L23;
            if (r104 == 832581388) goto L20;
            if (r104 == 952571600) goto L17;
            return;
        L17:
            if (r100.equals("Uninitialized exception. You need to initialize in the application.") == true) goto L26;
            return;
        L26:
            throw new RuntimeException(r100);
        L20:
            if (r100.equals("No layout exception. You need to set up the layout file.") == true) goto L26;
            return;
        L23:
            if (r100.equals("Context exception. Activity float need to pass in a activity context.") == true) goto L26;
        }
    }

    public static final class b {
        @JvmStatic
        public final void update() {
            update(null);
        }

        public b() {
        }

        @JvmStatic
        public static Pair a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            com.ss.android.lark.floating.widget.appfloat.c r101 = com.ss.android.lark.floating.widget.appfloat.c.f421938a;
            AppFloatManager r102 = com.ss.android.lark.floating.widget.appfloat.c.a(r100);
            if (r102 != null) goto L5;
        L8:
            return null;
        L5:
            if (r102.f421878d == null) goto L8;
            return TuplesKt.to(Integer.valueOf(((WindowManager.LayoutParams) r102.e().f421955a).x), Integer.valueOf(((WindowManager.LayoutParams) r102.e().f421955a).y));
        }

        @JvmStatic
        public final void update(String r100) {
            com.ss.android.lark.floating.widget.appfloat.c.f421938a.update(r100);
        }
    }

    public interface c {
    }

    @JvmStatic
    public static final void update() {
        f545789a.update();
    }

    @JvmStatic
    public static final void update(String r100) {
        f545789a.update(r100);
    }

    static {
        f545789a = new b();
        f545790b = new AtomicBoolean();
    }
}
