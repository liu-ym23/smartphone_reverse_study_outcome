package com.bytedance.ee.bear.wikiv2.wikitreev2.applydelete;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.list.applydelete.DeleteResult;
import com.bytedance.ee.bear.list.applydelete.DeleteReviewer;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FragmentManager r4, String r5, String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "objToken");
        Intrinsics.checkNotNullParameter(r7, "spaceId");
        NonProguard r1 = null;
        if (r5 != null) goto L33;
    L7:
        DeleteResult r9 = null;
    L8:
        int r2 = 1;
        if (r9 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L37;
        HashMap<String, DeleteReviewer> r10 = r9.getUsers();
        if (r10 == null) goto L18;
        r1 = (DeleteReviewer) r10.get(r9.getReviewer());
    L18:
        if (r1 == null) goto L38;
        int r11 = ApplyDeleteWikiFragment.q;
        if (r8 == true) goto L23;
        r2 = 2;
    L23:
        Intrinsics.checkNotNullParameter(r1, "reviewer");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "spaceId");
        ApplyDeleteWikiFragment r12 = new ApplyDeleteWikiFragment();
        Bundle r13 = new Bundle();
        r13.putSerializable("extra_user", r1);
        r13.putString("extra_token", r6);
        r13.putString("extra_space_id", r7);
        r13.putInt("extra_delete_opt", r2);
        r12.setArguments(r13);
        if (r4 == null) goto L39;
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "ApplyDeleteWikiFragment", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r12, r14) == true) goto L40;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L29:
        r12.show(r4, "ApplyDeleteWikiFragment");
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L11:
        if (r9.getNeed_apply() != true) goto L13;
        r3 = true;
        goto L14
    L33:
        r9 = (DeleteResult) new Gson().fromJson(r5, DeleteResult.class);     // Catch: Exception -> L32
        goto L8
    }
}
