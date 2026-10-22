package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorViewModel extends ViewModel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FRAGMENT_TAG_SELECT_COLOR = "select_color";
    protected a callback;
    private MutableLiveData<b> selectParam;

    public interface a {
        void a(String r1);
    }

    public static class b {
        public final String a;
        public String b;
        public final String[] c;

        public b(String r1, String r2, String[] r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public MutableLiveData<b> getSelectParam() {
        if (this.selectParam != null) goto L6;
        this.selectParam = new MutableLiveData();
    L6:
        return this.selectParam;
    }

    static {
    }

    public SelectColorViewModel() {
    }

    public void colorSelected(String r2) {
        updateSelectedColor(r2);
        a r0 = this.callback;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public void setCallback(a r1) {
        this.callback = r1;
    }

    public void updateSelectedColor(String r3) {
        MutableLiveData<b> r0 = getSelectParam();
        b r1 = (b) r0.getValue();
        if (r1 == null) goto L6;
        r1.b = r3;
        r0.setValue(r1);
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_toolbar_selectcolor_impl_SelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r2, FragmentManager r3, String r4) {
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

    public void selectColor(FragmentActivity r2, b r3, a r4) {
        getSelectParam().setValue(r3);
        this.callback = r4;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_toolbar_selectcolor_impl_SelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(Fragment.instantiate(r2, SelectColorFragment.class.getName()), r2.getSupportFragmentManager(), FRAGMENT_TAG_SELECT_COLOR);
    }

    public void selectColorCompat(Fragment r2, b r3, a r4) {
        getSelectParam().setValue(r3);
        this.callback = r4;
        if (r2.getArguments() != null) goto L5;
        Bundle r5 = new Bundle();
    L6:
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_toolbar_selectcolor_impl_SelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(Fragment.instantiate(r2.getActivity(), SelectColorCompatFragment.class.getName(), r5), r2.getActivity().getSupportFragmentManager(), FRAGMENT_TAG_SELECT_COLOR);
        return;
    L5:
        r5 = r2.getArguments();
        goto L6
    }
}
