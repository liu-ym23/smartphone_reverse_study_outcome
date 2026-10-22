package com.bytedance.ee.bear.sheet.selectcolor;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockSelectColorFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetSelectColorViewModel extends ViewModel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FRAGMENT_TAG_SELECT_COLOR = "select_color";
    protected a callback;
    private MutableLiveData<SheetSelectColorData> selectColorData;
    private Map<String, MutableLiveData<SheetSelectColorData>> selectColorDatas;

    public interface a {
        void a(String r1);
    }

    public MutableLiveData<SheetSelectColorData> getSelectColorData() {
        if (this.selectColorData != null) goto L6;
        this.selectColorData = new MutableLiveData();
    L6:
        return this.selectColorData;
    }

    public SheetSelectColorViewModel() {
        this.selectColorDatas = new HashMap();
    }

    static {
    }

    public MutableLiveData<SheetSelectColorData> getSelectColorData(String r3) {
        MutableLiveData<SheetSelectColorData> r0 = this.selectColorDatas.get(r3);
        if (r0 != null) goto L6;
        MutableLiveData<SheetSelectColorData> r1 = new MutableLiveData();
        this.selectColorDatas.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public void onSpecificColorSelected(String r3) {
        SheetSelectColorData r0 = (SheetSelectColorData) getSelectColorData().getValue();
        if (r0 == null) goto L5;
        String r1 = r0.getSelectedColor();
    L7:
        if (this.callback != null) goto L9;
        return;
    L9:
        if (TextUtils.equals(r1, r3) == true) goto L13;
        this.callback.a(r3);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public void onTopicColorSelected(String r2) {
        SheetSelectColorData r0 = (SheetSelectColorData) getSelectColorData().getValue();
        if (r0 == null) goto L6;
        onSpecificColorSelected(SheetSelectColorData.findDefaultColor(r0.getColorSchemeList(), r2));
        return;
    }

    public void setCallback(a r1) {
        this.callback = r1;
    }

    public void onSpecificColorSelected(String r2, String r3) {
        SheetSelectColorData r4 = (SheetSelectColorData) getSelectColorData(r2).getValue();
        if (r4 == null) goto L5;
        String r5 = r4.getSelectedColor();
    L7:
        if (this.callback != null) goto L9;
        return;
    L9:
        if (TextUtils.equals(r5, r3) == true) goto L13;
        this.callback.a(r3);
        return;
    L13:
        return;
    L5:
        r5 = null;
        goto L7
    }

    public void onTopicColorSelected(String r2, String r3) {
        SheetSelectColorData r0 = (SheetSelectColorData) getSelectColorData(r2).getValue();
        if (r0 == null) goto L6;
        onSpecificColorSelected(r2, SheetSelectColorData.findDefaultColor(r0.getColorSchemeList(), r3));
        return;
    }

    public void openSelectColorPanel(Fragment r3, a r4) {
        this.callback = r4;
        if (r3.getArguments() != null) goto L5;
        Bundle r5 = new Bundle();
    L6:
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_selectcolor_SheetSelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(Fragment.instantiate(r3.getActivity(), SheetBlockSelectColorFragment.class.getName(), r5), r3.getActivity().getSupportFragmentManager(), FRAGMENT_TAG_SELECT_COLOR);
        return;
    L5:
        r5 = r3.getArguments();
        goto L6
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_selectcolor_SheetSelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
