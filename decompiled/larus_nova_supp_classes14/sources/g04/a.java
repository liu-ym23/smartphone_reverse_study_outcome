package g04;

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
    public boolean d;

    /* JADX INFO: renamed from: g04.a$a, reason: collision with other inner class name */
    public static final class C0127a {
    }

    static {
    }

    public abstract void f(Model r1);

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public final Context getContext() {
        return this.a.getContext();
    }

    public final void j() {
        if (this.c == true) goto L10;
        String r0 = getClass().getSimpleName().concat(" must bind before selected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosFeedBasePresenter", null, r0, 20);
        goto L10
    L8:
        throw new RuntimeException(r0);
    L10:
        if (this.d == false) goto L12;
        return;
    L12:
        this.d = true;
        g();
    }

    public final void k() {
        if (this.c == true) goto L9;
        String r0 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosFeedBasePresenter", null, r0, 20);
        goto L9
    L8:
        throw new RuntimeException(r0);
    L9:
        l();
        this.c = false;
        h();
    }

    public final void l() {
        if (this.c == true) goto L10;
        String r0 = getClass().getSimpleName().concat(" must bind before unSelected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosFeedBasePresenter", null, r0, 20);
        goto L10
    L8:
        throw new RuntimeException(r0);
    L10:
        if (this.d == true) goto L12;
        return;
    L12:
        this.d = false;
        i();
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
    }

    public final void b(Model r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (this.c == false) goto L9;
        String r0 = getClass().getSimpleName().concat(" already bind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r1 = AoExceptionReporter.a;
        AoExceptionReporter.b(ErrorPriority.p1, "AosFeedBasePresenter", null, r0, 20);
        goto L9
    L8:
        throw new RuntimeException(r0);
    L9:
        this.c = true;
        f(r6);
    }

    public final a c(Class r4) {
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
        a r5 = d(r0, r4);
        if (r5 != null) goto L19;
        return null;
    L19:
        return r5;
    L11:
        if ((this instanceof b) == false) goto L21;
        r5 = d((b) this, r4);
        if (r5 != null) goto L19;
        return null;
    L21:
        return null;
    L6:
        r2 = null;
        goto L7
    }

    public final <T extends View> T e(int r2) {
        return (T) this.a.findViewById(r2);
    }

    public static a d(b r2, Class r3) {
        if (r2 == null) goto L12;
        Iterator r4 = ((ArrayList) r2.e).iterator();
    L5:
        if (r4.hasNext() == false) goto L21;
        a r0 = (a) r4.next();
        if ((r0 instanceof b) == true) goto L8;
        if (Intrinsics.areEqual(r3, r0.getClass()) == false) goto L5;
        return r0;
    L8:
        r0.getClass();
        d((b) r0, r3);
        goto L5
    L21:
        return null;
    L12:
        return null;
    }
}
