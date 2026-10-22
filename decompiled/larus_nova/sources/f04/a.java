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

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f474976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b<Model> f474977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f474978c;

    /* JADX INFO: renamed from: f04.a$a, reason: collision with other inner class name */
    public static final class C5842a {
    }

    static {
    }

    public abstract void j(Model r100);

    public abstract void k();

    public final Context getContext() {
        return this.f474976a.getContext();
    }

    public final void l() {
        if (this.f474978c == true) goto L9;
        String r100 = getClass().getSimpleName().concat(" must bind before unbind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r101 = AoExceptionReporter.f198706a;
        AoExceptionReporter.a(ErrorPriority.f198711p1, "AosBasePresenter", "", r100, new Throwable());
        goto L9
    L8:
        throw new RuntimeException(r100);
    L9:
        this.f474978c = false;
        k();
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f474976a = r100;
    }

    public final void f(Model r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f474978c == false) goto L9;
        String r101 = getClass().getSimpleName().concat(" already bind!");
        if (AoEnv.h() == true) goto L8;
        AoNpthService r102 = AoExceptionReporter.f198706a;
        AoExceptionReporter.a(ErrorPriority.f198711p1, "AosBasePresenter", "", r101, new Throwable());
        goto L9
    L8:
        throw new RuntimeException(r101);
    L9:
        this.f474978c = true;
        j(r100);
    }

    public final <T extends a<?>> T g(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        b<Model> r101 = this.f474977b;
    L4:
        if (r101 == null) goto L6;
        b<Model> r102 = r101.f474977b;
    L7:
        if (r102 == null) goto L9;
        r101 = r101.f474977b;
        goto L4
    L9:
        if (r101 == null) goto L11;
        a r103 = h(r101, r100);
        if ((r103 instanceof a) == true) goto L18;
        return null;
    L18:
        return (T) r103;
    L11:
        if ((this instanceof b) == false) goto L20;
        r103 = h((b) this, r100);
        if ((r103 instanceof a) == true) goto L18;
        return null;
    L20:
        return null;
    L6:
        r102 = null;
        goto L7
    }

    public final <T extends View> T i(int r100) {
        return (T) this.f474976a.findViewById(r100);
    }

    public static a h(b r100, Class r101) {
        if (r100 == null) goto L12;
        Iterator r102 = ((ArrayList) r100.f474979d).iterator();
    L5:
        if (r102.hasNext() == false) goto L21;
        a r103 = (a) r102.next();
        if ((r103 instanceof b) == true) goto L8;
        if (Intrinsics.areEqual(r101, r103.getClass()) == false) goto L5;
        return r103;
    L8:
        r103.getClass();
        h((b) r103, r101);
        goto L5
    L21:
        return null;
    L12:
        return null;
    }
}
