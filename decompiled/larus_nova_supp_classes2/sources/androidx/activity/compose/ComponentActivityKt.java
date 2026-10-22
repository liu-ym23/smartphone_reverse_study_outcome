package androidx.activity.compose;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n\u001a\f\u0010\u000b\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DefaultActivityContentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setContent", "", "Landroidx/activity/ComponentActivity;", "parent", "Landroidx/compose/runtime/CompositionContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setOwners", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComponentActivityKt {
    private static final ViewGroup.LayoutParams DefaultActivityContentLayoutParams = null;

    static {
        DefaultActivityContentLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    }

    public static View INVOKEVIRTUAL_androidx_activity_compose_ComponentActivityKt_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private static final void setOwners(ComponentActivity r2) {
        View r0 = INVOKEVIRTUAL_androidx_activity_compose_ComponentActivityKt_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2.getWindow());
        if (ViewTreeLifecycleOwner.get(r0) != null) goto L6;
        ViewTreeLifecycleOwner.set(r0, r2);
    L6:
        if (ViewTreeViewModelStoreOwner.get(r0) != null) goto L9;
        ViewTreeViewModelStoreOwner.set(r0, r2);
    L9:
        if (ViewTreeSavedStateRegistryOwner.get(r0) != null) goto L12;
        ViewTreeSavedStateRegistryOwner.set(r0, r2);
        return;
    }

    public static final void setContent(ComponentActivity r7, CompositionContext r8, Function2<? super Composer, ? super Integer, Unit> r9) {
        ComposeView r0 = ((ViewGroup) INVOKEVIRTUAL_androidx_activity_compose_ComponentActivityKt_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r7.getWindow()).findViewById(R.id.content)).getChildAt(0);
        if ((r0 instanceof ComposeView) == false) goto L5;
        ComposeView r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.setParentCompositionContext(r8);
        r1.setContent(r9);
        return;
    L8:
        ComposeView r2 = new ComposeView(r7, null, 0, 6, null);
        r2.setParentCompositionContext(r8);
        r2.setContent(r9);
        setOwners(r7);
        r7.setContentView(r2, DefaultActivityContentLayoutParams);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void setContent$default(ComponentActivity r0, CompositionContext r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        setContent(r0, r1, r2);
    }
}
