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

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f479457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b<Model> f479458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f479459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f479460d;

    /* JADX INFO: renamed from: g04.a$a, reason: collision with other inner class name */
    public static final class C5973a {
    }

    static {
    }

    public abstract void f(Model r100);

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public final Context getContext() {
        return this.f479457a.getContext();
    }

    public final void j() {
        if (this.f479459c == true) goto L10;
        String r100 = getClass().getSimpleName().concat(" must bind before selected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosFeedBasePresenter", null, r100, 20);
        goto L10
    L8:
        throw new RuntimeException(r100);
    L10:
        if (this.f479460d == false) goto L12;
        return;
    L12:
        this.f479460d = true;
        g();
    }

    public final void k() {
        if (this.f479459c == true) goto L9;
        String r100 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosFeedBasePresenter", null, r100, 20);
        goto L9
    L8:
        throw new RuntimeException(r100);
    L9:
        l();
        this.f479459c = false;
        h();
    }

    public final void l() {
        if (this.f479459c == true) goto L10;
        String r100 = getClass().getSimpleName().concat(" must bind before unSelected!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosFeedBasePresenter", null, r100, 20);
        goto L10
    L8:
        throw new RuntimeException(r100);
    L10:
        if (this.f479460d == true) goto L12;
        return;
    L12:
        this.f479460d = false;
        i();
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f479457a = r100;
    }

    public final void b(Model r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f479459c == false) goto L9;
        String r101 = getClass().getSimpleName().concat(" already bind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r102 = AoExceptionReporter.f198706a;
        AoExceptionReporter.b(ErrorPriority.f198711p1, "AosFeedBasePresenter", null, r101, 20);
        goto L9
    L8:
        throw new RuntimeException(r101);
    L9:
        this.f479459c = true;
        f(r100);
    }

    public final a c(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        b<Model> r101 = this.f479458b;
    L4:
        if (r101 == null) goto L6;
        b<Model> r102 = r101.f479458b;
    L7:
        if (r102 == null) goto L9;
        r101 = r101.f479458b;
        goto L4
    L9:
        if (r101 == null) goto L11;
        a r103 = d(r101, r100);
        if (r103 != null) goto L19;
        return null;
    L19:
        return r103;
    L11:
        if ((this instanceof b) == false) goto L21;
        r103 = d((b) this, r100);
        if (r103 != null) goto L19;
        return null;
    L21:
        return null;
    L6:
        r102 = null;
        goto L7
    }

    public final <T extends View> T e(int r100) {
        return (T) this.f479457a.findViewById(r100);
    }

    public static a d(b r100, Class r101) {
        if (r100 == null) goto L12;
        Iterator r102 = ((ArrayList) r100.f479461e).iterator();
    L5:
        if (r102.hasNext() == false) goto L21;
        a r103 = (a) r102.next();
        if ((r103 instanceof b) == true) goto L8;
        if (Intrinsics.areEqual(r101, r103.getClass()) == false) goto L5;
        return r103;
    L8:
        r103.getClass();
        d((b) r103, r101);
        goto L5
    L21:
        return null;
    L12:
        return null;
    }
}
