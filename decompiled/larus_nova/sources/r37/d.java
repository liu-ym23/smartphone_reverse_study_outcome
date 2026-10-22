package r37;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f535887a = null;

    static {
        f535887a = View.class.getDeclaredField("mContext");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        f535887a = null;
    }

    public static boolean a(Context r100) {
        if ((r100 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r101 = (FragmentActivity) r100;
        if (r101.isDestroyed() == false) goto L7;
        return false;
    L7:
        if (r101.isFinishing() == false) goto L13;
        return false;
    L13:
        return true;
    L10:
        return true;
    }

    public static void b(View r100, Activity r101) {
        Field r102 = f535887a;     // Catch: Exception -> L15
        if ((r100 instanceof ViewStub) == false) goto L6;
        ((ViewStub) r100).setLayoutInflater(LayoutInflater.from(r101).cloneInContext(r101));     // Catch: Exception -> L15
    L6:
        if ((r100 instanceof ProgressBar) == false) goto L11;
        Field r103 = (Field) e.a(ProgressBar.class);     // Catch: Exception -> L15
        if (r103 == null) goto L10;
        r103.setAccessible(true);     // Catch: Exception -> L15
        r103.set(r100, Long.valueOf(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId()));     // Catch: Exception -> L15
        goto L11
    L10:
        int r104 = c.f535886a;     // Catch: Exception -> L15
        o37.c.f521918e.getClass();     // Catch: Exception -> L15
        o37.c.c();     // Catch: Exception -> L15
    L11:
        if (r102 == null) goto L13;
        r102.setAccessible(true);     // Catch: Exception -> L15
        r102.set(r100, r101);     // Catch: Exception -> L15
        return;
    L13:
        int r105 = c.f535886a;     // Catch: Exception -> L15
        o37.c.f521918e.getClass();     // Catch: Exception -> L15
        o37.c.c();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(View r100, Activity r101) {
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L4:
        if ((r100.getContext() instanceof Activity) == true) goto L6;
    L7:
        b(r100, r101);     // Catch: Throwable -> L18
        if ((r100 instanceof ViewGroup) == false) goto L15;
        int r102 = ((ViewGroup) r100).getChildCount() - 1;     // Catch: Throwable -> L18
        if (r102 < 0) goto L15;
        int r103 = 0;
    L12:
        c(((ViewGroup) r100).getChildAt(r103), r101);     // Catch: Throwable -> L18
        if (r103 == r102) goto L15;
        r103 = r103 + 1;     // Catch: Throwable -> L18
    L15:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r100);
        return;
    L6:
        if ((!Intrinsics.areEqual(r100.getContext(), r101)) == false) goto L15;
        goto L7
    }
}
