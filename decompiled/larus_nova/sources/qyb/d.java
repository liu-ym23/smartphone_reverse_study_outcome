package qyb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {
    public static final Activity a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Context r101 = r100.getContext();
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L10;
        if ((r101 instanceof Activity) == true) goto L8;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L8:
        return (Activity) r101;
    L10:
        return null;
    }

    public static final LifecycleRegistry b(View r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "owner");
        LifecycleRegistry r102 = new LifecycleRegistry(r101);
        if (r100.isAttachedToWindow() == false) goto L5;
        r102.setCurrentState(Lifecycle.State.RESUMED);
    L5:
        r100.addOnAttachStateChangeListener(new c(r102));
        return r102;
    }

    public static void c(View r100, int r101) {
        int r102 = r100.getPaddingLeft();
        int r103 = r100.getPaddingTop();
        int r104 = r100.getPaddingRight();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setPadding(r102, r103, r104, r101);
    }
}
