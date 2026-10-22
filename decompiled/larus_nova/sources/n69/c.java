package n69;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CommonDialog f518173a;

    static {
    }

    public static void a() {
        CommonDialog r100 = f518173a;
        if (r100 != null) goto L5;
    L12:
        f518173a = null;
        return;
    L5:
        if (r100.isAdded() == false) goto L12;
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public static void b(Context r100, FragmentManager r101, Function0 r110, Function0 r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r110, "confirm");
        Intrinsics.checkNotNullParameter(r111, "cancel");
        Intrinsics.checkNotNullParameter(r112, "backListener");
        if (r100 != null) goto L5;
        return;
    L5:
        a();
        CommonDialog.a r102 = new CommonDialog.a();
        int r103 = j0.f375426a;
        r102.i(j0.d(R.string.larus_dora_g_recovery_bound_other_cn));
        r102.g(j0.d(R.string.larus_dora_g_recovery_change_bound_cn));
        f0 r104 = new f0(15, Integer.valueOf(ContextCompat.getColor(r100, R.color.larus_neutral_50)), null, 4);
        Intrinsics.checkNotNullParameter(r104, "commonDialogTextStyleConfig");
        r102.C = r104;
        boolean r105 = false;
        CommonDialog.a.f(r102, new a(r110), j0.d(R.string.larus_dora_g_recovery_goto_unpair_cn), false, 12);
        f0 r106 = new f0(17, Integer.valueOf(ContextCompat.getColor(r100, R.color.larus_primary_50)), null, 4);
        Intrinsics.checkNotNullParameter(r106, "commonDialogTextStyleConfig");
        r102.D = r106;
        CommonDialog.a.e(r102, new b(r111), j0.d(R.string.larus_dora_dialog_btn_cancel_cn), 4);
        f0 r113 = new f0(17, Integer.valueOf(ContextCompat.getColor(r100, R.color.neutral_70)), null, 4);
        Intrinsics.checkNotNullParameter(r113, "commonDialogTextStyleConfig");
        r102.E = r113;
        r102.f327197z = false;
        Intrinsics.checkNotNullParameter(r112, "callback");
        r102.B = r112;
        CommonDialog r107 = r102.a();
        f518173a = r107;
        if (r107.isVisible() != true) goto L8;
        r105 = true;
    L8:
        if (r105 == true) goto L20;
        CommonDialog r108 = f518173a;
        if (r108 == null) goto L21;
        LandscapeRestrictionOperation r114 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r108, null, r114);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r108, r114) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r108.show(r101, null);
        return;
    L22:
        return;
    L21:
        return;
    }
}
