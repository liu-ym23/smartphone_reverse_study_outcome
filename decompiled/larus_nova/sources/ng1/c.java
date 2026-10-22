package ng1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.setting.i1;
import com.bytedance.android.livesdk.chatroom.distribution.preload.PreloadModelState;
import com.bytedance.android.livesdkapi.distribution.EnterParams;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f519040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f519041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f519042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mg1.b f519043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EnterParams f519044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PreloadModelState f519045f;

    public final void a() {
        int r100 = og1.c.f523182a;
        og1.c.a("VirtualContainerPreloadModel directRemovePreloadContainer , uniqueKey: " + this.f519040a);
        mg1.b r101 = this.f519043d;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        c();
    }

    public final void b() {
        if (this.f519043d == null) goto L5;
        return;
    L5:
        if (this.f519045f == PreloadModelState.PENDING_ADD) goto L7;
        return;
    L7:
        if (i1.f65321a.getValue().booleanValue() == true) goto L44;
    L37:
        boolean r100 = true;
    L38:
        if (r100 == false) goto L47;
        int r101 = og1.c.f523182a;
        og1.c.a("VirtualContainerPreloadModel invokeAddPreloadContainerTask , uniqueKey: " + this.f519040a);
        a r102 = this.f519041b;
        if (r102 == null) goto L42;
        r102.run();
    L42:
        this.f519045f = PreloadModelState.ADDED;
        return;
    L47:
        return;
    L44:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L35
        EnterParams r104 = this.f519044e;     // Catch: Throwable -> L35
        r100 = false;
        if (r104 == null) goto L13;
        FrameLayout r105 = r104.getContainer();     // Catch: Throwable -> L35
        if (r105 == null) goto L13;
        int r106 = r105.getId();     // Catch: Throwable -> L35
    L14:
        if (r106 > 0) goto L16;
        int r107 = og1.c.f523182a;     // Catch: Throwable -> L35
        og1.c.a("VirtualContainerPreloadModel invokeAddPreloadContainerTask error, containerId <= 0 , uniqueKey: " + this.f519040a);     // Catch: Throwable -> L35
        goto L38
    L16:
        EnterParams r108 = this.f519044e;     // Catch: Throwable -> L35
        View r109 = null;
        if (r108 == null) goto L19;
        Context r110 = r108.getContext();     // Catch: Throwable -> L35
    L20:
        Activity r111 = (Activity) r110;     // Catch: Throwable -> L35
        if (r111 == null) goto L31;
        Window r112 = r111.getWindow();     // Catch: Throwable -> L35
        if (r112 == null) goto L31;
        View r113 = r112.getDecorView();     // Catch: Throwable -> L35
        if (com.larus.home.impl.utils.c.f346345e == false) goto L29;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L35
        Thread r114 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L35
        if (r114 == com.larus.home.impl.utils.c.f346341a) goto L29;
        com.larus.home.impl.utils.c.a(r114, "getDecorView");     // Catch: Throwable -> L35
    L29:
        if (r113 == null) goto L31;
        r109 = r113.findViewById(r106);     // Catch: Throwable -> L35
    L31:
        if (r109 != null) goto L33;
        int r115 = og1.c.f523182a;     // Catch: Throwable -> L35
        og1.c.a("VirtualContainerPreloadModel invokeAddPreloadContainerTask error, view == null , uniqueKey: " + this.f519040a);     // Catch: Throwable -> L35
        goto L38
    L33:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
        goto L37
    L19:
        r110 = null;
    L13:
        r106 = 0;
    L35:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    public final void c() {
        int r100 = og1.c.f523182a;
        og1.c.a("VirtualContainerPreloadModel reset , uniqueKey: " + this.f519040a);
        this.f519045f = PreloadModelState.INIT;
        this.f519044e = null;
        this.f519040a = null;
        this.f519041b = null;
        this.f519042c = null;
        this.f519043d = null;
    }

    public c() {
        this.f519045f = PreloadModelState.INIT;
    }
}
