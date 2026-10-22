package m15;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.content.creation.CreationMenuPanel;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import iw4.g;
import iw4.h;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements g {
    public c a;
    public m b;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // iw4.g
    public final boolean a(FragmentActivity r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
        return false;
    L5:
        CreationMenuPanel r1 = r7.getSupportFragmentManager().findFragmentByTag("CreationMenuPanel");
        if ((r1 instanceof CreationMenuPanel) == false) goto L8;
        tt5.a.h("DocumentSelectCreationMenuManager", "getCreationMenuPanel()...success");
        CreationMenuPanel r2 = r1;
    L10:
        if (r2 == null) goto L16;
        Dialog r5 = r2.getDialog();
        if (r5 == null) goto L16;
        if (r5.isShowing() != true) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L29;
        tt5.a.h("DocumentSelectCreationMenuManager", "create menu is already showing");
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L21
    L25:
        c r3 = this.a;
        if (r3 == null) goto L28;
        ((SelectCreationMenuViewModel) ViewModelProviders.of(r7).get(SelectCreationMenuViewModel.class)).getCreationMenuItemClick().removeObserver(r3);
        this.a = null;
    L28:
        r0 = true;
    L21:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L25;
        d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L29:
        tt5.a.h("DocumentSelectCreationMenuManager", "creationMenuPanel dismissCreationMenuPanelIfSupport: " + r0);
        return r0;
    L16:
        r6 = false;
        goto L17
    L8:
        r2 = null;
        goto L10
    }

    public final CreationMenuPanel b(FragmentActivity r4, h r5, SelectCreationMenuConfig r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r5, "menuContext");
        tt5.a.h("DocumentSelectCreationMenuManager", "showCreationMenuPanel() called with: activity = " + r4 + ", menuContext = " + r5 + ", menuConfig = " + r6);
        if (r4 != null) goto L6;
        return null;
    L6:
        Bundle r8 = new Bundle();
        r8.putParcelable("key_config", r6);
        r8.putString("key_parent_token", r5.a);
        r8.putString("key_module", r5.b);
        r8.putString("key_sub_module", r5.c);
        r8.putString("key_src_module", r5.d);
        r8.putBoolean("key_is_folder", r5.e);
        r8.putBoolean("key_is_from_empty", r5.f);
        r8.putBoolean("key_folder_version", r5.g);
        CreateSelectResult.a r9 = CreateSelectResult.CREATOR;
        String r0 = r5.a;
        r9.getClass();
        r8.putParcelable("CREATION_LOCATION", CreateSelectResult.a.a("my_document_library", r0, false, ""));
        r8.putString("SPACE_ID", r5.h);
        c r10 = this.a;
        if (r10 != null) goto L9;
        r10 = new c(this, r4, r5);
        this.a = r10;
    L9:
        ((SelectCreationMenuViewModel) ViewModelProviders.of(r4).get(SelectCreationMenuViewModel.class)).getCreationMenuItemClick().observe(r4, r10);
        return CreationMenuPanel.fa0(r4, r8, r5.i);
    }
}
