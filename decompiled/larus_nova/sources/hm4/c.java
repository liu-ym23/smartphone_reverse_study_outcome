package hm4;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<b> f485930c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f485931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f485932b;

    public static final class a {
    }

    static {
        f485930c = CollectionsKt.listOf(new b[]{b.f485918c, b.f485919d, b.f485920e, b.f485921f, b.f485922g, b.f485923h, b.f485924i, b.f485925j, b.f485926k, b.f485927l});
    }

    public final FragmentActivity b() {
        View r100 = this.f485931a;
        if (r100 == null) goto L5;
        Context r101 = r100.getContext();
    L7:
        if ((r101 instanceof FragmentActivity) == true) goto L9;
        return null;
    L9:
        return (FragmentActivity) r101;
    L5:
        r101 = null;
        goto L7
    }

    public c(Context r100) {
        View r101 = null;
        if ((r100 instanceof Activity) == false) goto L7;
        Window r102 = ((Activity) r100).getWindow();
        if (r102 == null) goto L7;
        r101 = a(r102);
    L7:
        this(r101);
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public c(View r100) {
        this.f485931a = r100;
        this.f485932b = 1;
    }
}
