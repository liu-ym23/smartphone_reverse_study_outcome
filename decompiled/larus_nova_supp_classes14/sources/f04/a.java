package f04;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<Model> {
    public final View a;
    public b<Model> b;
    public boolean c;

    /* JADX INFO: renamed from: f04.a$a, reason: collision with other inner class name */
    public static final class C0122a {
    }

    static {
    }

    public abstract void j(Model r1);

    public abstract void k();

    public final Context getContext() {
        return this.a.getContext();
    }

    public final void l() {
        if (this.c == true) goto L9;
        String r0 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.a(ErrorPriority.p1, "AosBasePresenter", "", r0, new Throwable());
        goto L9
    L8:
        throw new RuntimeException(r0);
    L9:
        this.c = false;
        k();
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
    }

    public final void f(Model r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (this.c == false) goto L9;
        String r0 = getClass().getSimpleName().concat(" already bind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.a(ErrorPriority.p1, "AosBasePresenter", "", r0, new Throwable());
        goto L9
    L8:
        throw new RuntimeException(r0);
    L9:
        this.c = true;
        j(r6);
    }

    public final <T extends a<?>> T g(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        b<Model> r0 = this.b;
    L4:
        if (r0 == null) goto L6;
        b<Model> r2 = r0.b;
    L7:
        if (r2 == null) goto L9;
        r0 = r0.b;
        goto L4
    L9:
        if (r0 == null) goto L11;
        a r5 = h(r0, r4);
        if ((r5 instanceof a) == true) goto L18;
        return null;
    L18:
        return (T) r5;
    L11:
        if ((this instanceof b) == false) goto L20;
        r5 = h((b) this, r4);
        if ((r5 instanceof a) == true) goto L18;
        return null;
    L20:
        return null;
    L6:
        r2 = null;
        goto L7
    }

    public final <T extends View> T i(int r2) {
        return (T) this.a.findViewById(r2);
    }

    public static a h(b r2, Class r3) {
        if (r2 == null) goto L12;
        Iterator r4 = ((ArrayList) r2.d).iterator();
    L5:
        if (r4.hasNext() == false) goto L21;
        a r0 = (a) r4.next();
        if ((r0 instanceof b) == true) goto L8;
        if (Intrinsics.areEqual(r3, r0.getClass()) == false) goto L5;
        return r0;
    L8:
        r0.getClass();
        h((b) r0, r3);
        goto L5
    L21:
        return null;
    L12:
        return null;
    }
}
