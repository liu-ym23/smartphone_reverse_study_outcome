package com.ss.android.lark.picker.base.widget.scenario;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\n"}, d2 = {"bindScenarioEntriesView", "", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "showPersonnel", "", "showPermission", "onPersonnelClick", "Lkotlin/Function0;", "onPermissionClick", "picker-base_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ScenarioEntriesBinderKt {
    public static final void bindScenarioEntriesView(View r100, boolean r101, boolean r102, final Function0<Unit> r103, final Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r103, "onPersonnelClick");
        Intrinsics.checkNotNullParameter(r104, "onPermissionClick");
        View r105 = r100.findViewById(R.id.picker_scenario_entry_personnel_type);
        View r106 = r100.findViewById(R.id.picker_scenario_entry_permission_group);
        int r107 = 0;
        if (r101 == false) goto L5;
        int r108 = 0;
    L6:
        r105.setVisibility(r108);
        if (r102 == true) goto L10;
        r107 = 8;
    L10:
        r106.setVisibility(r107);
        r105.setOnClickListener(new AnonymousClass1(r103));
        r106.setOnClickListener(new AnonymousClass2(r104));
        return;
    L5:
        r108 = 8;
        goto L6
    }
}
