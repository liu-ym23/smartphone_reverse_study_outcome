package com.larksuite.component.ignition.widget.setting_group;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f284021a = 0;

    static {
    }

    @JvmStatic
    public static final void a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 != null) goto L5;
        return;
    L5:
        SettingGroupAdapter r102 = new SettingGroupAdapter(r100.getContext(), r101);
        if (r102.f284005c == R.color.facade_selector_item_float) goto L9;
        r102.f284005c = R.color.facade_selector_item_float;
    L9:
        r100.setAdapter(r102);
        SettingGroupDividerItemDecoration r103 = new SettingGroupDividerItemDecoration(r100.getContext());
        int r104 = UIUtils.getColor(r100.getContext(), R.color.bg_float);
        SettingGroupDividerDrawable r105 = r103.f284014a;
        r105.f284010c = r104;
        r105.invalidateSelf();
        r100.addItemDecoration(r103);
        int r106 = UIUtils.dp2px(r100.getContext(), 16.0f);
        r100.setPadding(r106, r100.getPaddingTop(), r106, r100.getPaddingBottom());
        r100.setOverScrollMode(2);
    }

    @JvmStatic
    public static final void b(RecyclerView r100, int r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView.Adapter r104 = r100.getAdapter();
        if (r104 != null) goto L5;
        return;
    L5:
        SettingGroupAdapter r105 = new SettingGroupAdapter(r100.getContext(), r104);
        if (r105.f284005c == r103) goto L9;
        r105.f284005c = r103;
    L9:
        r100.setAdapter(r105);
        if (r102 == false) goto L12;
        SettingGroupDividerItemDecoration r106 = new SettingGroupDividerItemDecoration(r100.getContext());
        SettingGroupDividerDrawable r107 = r106.f284014a;
        r107.f284009b = r101;
        r107.invalidateSelf();
        r100.addItemDecoration(r106);
    L12:
        int r108 = UIUtils.dp2px(r100.getContext(), 16.0f);
        r100.setPadding(r108, r100.getPaddingTop(), r108, r100.getPaddingBottom());
        r100.setOverScrollMode(2);
    }
}
