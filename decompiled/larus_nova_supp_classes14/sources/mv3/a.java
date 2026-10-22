package mv3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import e3.d;
import k2.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {

    /* JADX INFO: renamed from: mv3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0147a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final Fragment a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        a0 r0 = r3.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L6:
        if (r1 != null) goto L8;
        int r2 = -1;
    L10:
        if (r2 != 1) goto L12;
        WidgetContainer r4 = (WidgetContainer) r3.d(WidgetContainer.class);
        if (r4 == null) goto L25;
        View r5 = r4.realView();
        if (r5 != null) goto L22;
        return null;
    L22:
        return CompatKt.findFragment(r5);
    L25:
        return null;
    L12:
        if (r2 != 2) goto L27;
        View r6 = r3.getEngineView();
        if (r6 != null) goto L24;
        return null;
    L24:
        return CompatKt.findFragment(r6);
    L27:
        return null;
    L8:
        r2 = C0147a.a[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final Activity getActivity(d r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        a0 r0 = r3.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L6:
        if (r1 != null) goto L8;
        int r2 = -1;
    L10:
        if (r2 != 1) goto L12;
        WidgetContainer r4 = (WidgetContainer) r3.d(WidgetContainer.class);
        if (r4 != null) goto L32;
        return null;
    L32:
        return r4.getActivity();
    L12:
        if (r2 != 2) goto L39;
        j r5 = (j) r3.d(j.class);
        if (r5 == null) goto L17;
        r5.doRefresh();
    L17:
        View r6 = r3.getEngineView();
        if (r6 == null) goto L20;
        Context r7 = r6.getContext();
    L22:
        if ((r7 instanceof ContextWrapper) == false) goto L27;
        if ((r7 instanceof Activity) == true) goto L27;
        r7 = ((ContextWrapper) r7).getBaseContext();
    L27:
        if ((r7 instanceof Activity) == true) goto L37;
        return null;
    L37:
        return (Activity) r7;
    L20:
        r7 = null;
        goto L22
    L39:
        return null;
    L8:
        r2 = C0147a.a[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
