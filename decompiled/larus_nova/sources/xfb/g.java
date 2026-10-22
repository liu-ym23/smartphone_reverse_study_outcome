package xfb;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static g f563558e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f563559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowManager f563560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Application f563561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f563562d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Log.i("ScreenSizeManager", "initView");
        View r100 = new View(this.f563561c);
        this.f563560b = (WindowManager) this.f563561c.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r101 = 2038;
    L6:
        WindowManager.LayoutParams r102 = new WindowManager.LayoutParams(r101, 568, -2);
        r102.alpha = 0.0f;
        WindowManager r103 = this.f563560b;     // Catch: Exception -> L12
        if (r103 == null) goto L10;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r100, r102);     // Catch: Exception -> L12
        r103.addView(r100, r102);     // Catch: Exception -> L12
    L10:
        this.f563559a = new WeakReference(r100);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e("ScreenSizeManager", "permission denied: " + e.getMessage(), e, true);
        return;
    L5:
        r101 = 2002;
        goto L6
    }

    public g() {
        this.f563561c = LarkContext.getApplication();
        this.f563562d = new Handler(Looper.getMainLooper());
    }
}
