package kd6;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f502844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<Boolean, Unit>> f502845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kd6.a f502846c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f502847a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[Lifecycle.Event.ON_CREATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[Lifecycle.Event.ON_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f502847a = r100;
        }
    }

    public i() {
        this(false);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kd6.a] */
    public i(boolean r100) {
        this.f502844a = r100;
        this.f502845b = new ArrayList();
        this.f502846c = new kd6.a(this);
    }

    public final void a(boolean r100) {
        if (this.f502844a != r100) goto L5;
        return;
    L5:
        this.f502844a = r100;
        Iterator<T> r101 = this.f502845b.iterator();
    L7:
        if (r101.hasNext() == false) goto L16;
        Function1 r102 = (Function1) r101.next();
        r102.invoke(Boolean.valueOf(r100));     // Catch: Exception -> L11
    L11:
        ld6.a r103 = ld6.b.f508697a;
        StringBuilder r104 = new StringBuilder("KPerf: ");
        StringBuilder r105 = new StringBuilder("Error notifying page ");
        if (r100 == false) goto L14;
        String r106 = "visible";
    L15:
        r105.append(r106);
        r105.append(" callback");
        r104.append(r105.toString());
        String r107 = r104.toString();
        System.out.println(r107);
        goto L7
    L14:
        r106 = "invisible";
        goto L15
    }
}
