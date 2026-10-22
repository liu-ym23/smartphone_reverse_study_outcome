package com.bytedance.ee.bear.list.applydelete;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import du5.b;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.applydelete.a$a, reason: collision with other inner class name */
    public static final class C0013a {
    }

    static {
    }

    public static void a(FragmentManager r5, String r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r7, "objToken");
        tt5.a.h("ApplyDeleteSpaceExecutor", "handleDeleteApply objToken is " + b.i(r7) + " type is " + r8);
        NonProguard r2 = null;
        if (r6 != null) goto L28;
    L7:
        DeleteResult r9 = null;
    L8:
        if (r9 == null) goto L12;
        boolean r4 = true;
        if (r9.getNeed_apply() != true) goto L12;
    L13:
        if (r4 == false) goto L23;
        HashMap<String, DeleteReviewer> r3 = r9.getUsers();
        if (r3 == null) goto L17;
        r2 = (DeleteReviewer) r3.get(r9.getReviewer());
    L17:
        if (r2 == null) goto L23;
        int r10 = ApplyDeleteSpaceFragment.p;
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        Intrinsics.checkNotNullParameter(r2, "reviewer");
        Intrinsics.checkNotNullParameter(r7, "objToken");
        ApplyDeleteSpaceFragment r0 = new ApplyDeleteSpaceFragment();
        Bundle r1 = new Bundle();
        r1.putSerializable("extra_user", r2);
        r1.putString("extra_obj_token", r7);
        r1.putInt("extra_obj_type", r8);
        r0.setArguments(r1);
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "ApplyMoveSpaceToSpaceFragment", r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r0, r11) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L22:
        r0.show(r5, "ApplyMoveSpaceToSpaceFragment");
    L23:
        if (r9 == null) goto L32;
        r9.getNeed_apply();
        return;
    L32:
        return;
    L12:
        r4 = false;
        goto L13
    L28:
        r9 = (DeleteResult) new Gson().fromJson(r6, DeleteResult.class);     // Catch: Exception -> L27
        goto L8
    }
}
