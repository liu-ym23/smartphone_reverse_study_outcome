package msb;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.multitask.task.b;
import com.ss.android.lark.multitask.task.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515533a = 0;

    /* JADX INFO: renamed from: msb.a$a, reason: collision with other inner class name */
    public static final class C6849a {
    }

    static {
    }

    public final e b() {
        Intrinsics.throwUninitializedPropertyAccessException("taskWrapper");
        return null;
    }

    public final void c() {
        Log.i("MULTITASK-MultitaskHelper", "isDuplicatedTask isInitialized = false");
    }

    public final void e() {
        Log.i("MULTITASK-MultitaskHelper", "terminate isInitialized = false");
    }

    public a() {
        Log.e("MULTITASK-MultitaskHelper", "Multitask is not initialized. Skip initialization!");
    }

    @JvmStatic
    public static final a a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "taskWrapper");
        Intrinsics.checkNotNullParameter(r100, "taskWrapper");
        return new a(r100, true);
    }

    public static a d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "taskWrapper");
        Fragment r101 = r100.getActivity().getSupportFragmentManager().findFragmentByTag("multitask.lifecycle.fragment.tag");
        if (r101 == null) goto L6;
        r100.getActivity().getSupportFragmentManager().beginTransaction().remove(r101).commitNowAllowingStateLoss();
    L6:
        return new a();
    }

    public a(b r100, boolean r101) {
        if (r101 == false) goto L5;
        new com.ss.android.lark.slideback.b(r100.getActivity());
    L5:
        Log.e("MULTITASK-MultitaskHelper", "Multitask is not initialized. Skip initialization!");
    }
}
