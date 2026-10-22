package dm5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f;
import com.bytedance.ee.bear.search.SelectFolderConfig;
import com.bytedance.ee.bear.search.b;
import com.bytedance.ee.bear.search.e;
import com.bytedance.ee.bear.search.picker.filter.folder.SearchFolderFragment;
import com.bytedance.ee.bear.search.picker.filter.permission.ChatterPickerFragment;
import com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import rj5.i0;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.ee.bear.search.b
    public final String d(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (Boolean.valueOf(r0).booleanValue() == false) goto L13;
        Pattern r1 = c.a;
        r5 = r5.replace("<em>", "").replace("</em>", "");
    L13:
        if (r5 != null) goto L16;
        return "";
    L16:
        return r5;
    L5:
        if (r5.contains("<em>") == false) goto L9;
        if (r5.contains("</em>") == false) goto L9;
        r0 = true;
        goto L11
    }

    @Override // com.bytedance.ee.bear.search.b
    public final SearchFolderFragment b(Context r2, SelectFolderConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "folderConfig");
        int r0 = SearchFolderFragment.j;
        return SearchFolderFragment.a.a(r2, "", r3);
    }

    @Override // com.bytedance.ee.bear.search.b
    public final WikiSearchPickerFragment c(Context r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "bundle");
        int r2 = WikiSearchPickerFragment.n;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "bundle");
        WikiSearchPickerFragment r6 = Fragment.instantiate(r4, WikiSearchPickerFragment.class.getName(), r5);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment");
        return r6;
    }

    @Override // com.bytedance.ee.bear.search.b
    public final void a(FragmentActivity r10, i0 r11, Fragment r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "callBack");
        e r1 = ChatterPickerFragment.k;
        Intrinsics.checkNotNullParameter(r10, "context");
        ChatterPickerFragment r0 = new ChatterPickerFragment();
        ChatterPickerFragment.k = r11;
        if (ForsetiHelper.s(r12) == true) goto L5;
    L6:
        FragmentManager r13 = r10.getSupportFragmentManager();
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "ChatterPickerFragment", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r0, r14) == true) goto L16;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r0.show(r13, "ChatterPickerFragment");
        return;
    L16:
        return;
    L5:
        if (f.e(r0, r12, ForsetiNavOptions.DestinationStyle.FLOAT, false, 0, false, 60) == false) goto L6;
    }
}
