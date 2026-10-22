package z8c;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f570975a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<C8430a, String> f570976b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f570977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f570978d;

    /* JADX INFO: renamed from: z8c.a$a, reason: collision with other inner class name */
    public static final class C8430a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Scene f570979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Event f570980b;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f570979a, this.f570980b});
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof C8430a) == false) goto L9;
            C8430a r101 = (C8430a) r100;
            if (this.f570979a != r101.f570979a) goto L9;
            if (this.f570980b != r101.f570980b) goto L9;
            return true;
        L9:
            return false;
        }

        public C8430a(Scene r100, Event r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "event");
            this.f570979a = r100;
            this.f570980b = r101;
        }
    }

    public a() {
    }

    static {
        f570975a = new a();
        f570976b = new HashMap();
    }

    public static void e() {
        Intrinsics.checkNotNullParameter("new_version", "category");
        if (f570977c == false) goto L5;
        return;
    L5:
        f570977c = true;
        HashMap r100 = new HashMap();
        r100.put("tab", "new_version");
        HashMap r101 = new HashMap();
        r101.put("item_count", 0);
        a(Scene.TodoCenter, Event.todo_center_cold_launch, r100, r101);
    }

    public static void d(Scene r100, Event r110) {
        String r101 = AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Todo, r100, r110, null, false, 16, null);
        f570976b.put(new C8430a(r100, r110), r101);
    }

    public static void c(Scene r110, Event r111, ErrorResult r210) {
        Biz r100 = Biz.Todo;
        if (r210 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        ErrorType r102 = ErrorType.Network;
    L11:
        ErrorType r103 = r102;
        ErrorLevel r104 = ErrorLevel.Fatal;
        if (r210 == null) goto L14;
        int r105 = r210.getCode();
    L15:
        String r106 = null;
        String r107 = null;
        if (r210 == null) goto L18;
        String r108 = r210.getMessage();
    L19:
        ErrorParams r112 = new ErrorParams(r100, r110, r111, r103, r104, r105, r106, r107, r108, Boolean.TRUE, null, null, null, 7168, null);
        AppreciableKit.Companion.getInstance().error(r112);
        return;
    L18:
        r108 = null;
        goto L19
    L14:
        r105 = 0;
        goto L15
    L10:
        r102 = ErrorType.Other;
        goto L11
    L5:
        if (r210.getErrorCode() != 10008) goto L7;
        r101 = true;
        goto L8
    }

    public static void a(Scene r100, Event r110, Map r111, Map r112) {
        HashMap<C8430a, String> r101 = f570976b;
        String r102 = r101.get(new C8430a(r100, r110));
        if (r102 == null) goto L6;
        AppreciableKit.Companion.getInstance().end(r102, null, null, null, r112, r111);
        r101.put(new C8430a(r100, r110), null);
        return;
    }

    public static /* synthetic */ void b(a r100, Scene r101, Event r102, Map r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.getClass();
        a(r101, r102, r103, null);
    }
}
