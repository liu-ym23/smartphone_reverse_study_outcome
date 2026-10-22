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

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorViewModel extends ViewModel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FRAGMENT_TAG_SELECT_COLOR = "select_color";
    protected a callback;
    private MutableLiveData<b> selectParam;

    public interface a {
        void a(String r100);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f222405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f222406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f222407c;

        public b(String r100, String r101, String[] r102) {
            this.f222405a = r100;
            this.f222406b = r101;
            this.f222407c = r102;
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

    public void colorSelected(String r100) {
        updateSelectedColor(r100);
        a r101 = this.callback;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void setCallback(a r100) {
        this.callback = r100;
    }

    public void updateSelectedColor(String r100) {
        MutableLiveData<b> r101 = getSelectParam();
        b r102 = r101.getValue();
        if (r102 == null) goto L6;
        r102.f222406b = r100;
        r101.setValue(r102);
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_toolbar_selectcolor_impl_SelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        DialogFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public void selectColor(FragmentActivity r100, b r101, a r102) {
        getSelectParam().setValue(r101);
        this.callback = r102;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_toolbar_selectcolor_impl_SelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show((DialogFragment) Fragment.instantiate(r100, SelectColorFragment.class.getName()), r100.getSupportFragmentManager(), FRAGMENT_TAG_SELECT_COLOR);
    }

    public void selectColorCompat(Fragment r100, b r101, a r102) {
        getSelectParam().setValue(r101);
        this.callback = r102;
        if (r100.getArguments() != null) goto L5;
        Bundle r103 = new Bundle();
    L6:
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_toolbar_selectcolor_impl_SelectColorViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show((DialogFragment) Fragment.instantiate(r100.getActivity(), SelectColorCompatFragment.class.getName(), r103), r100.getActivity().getSupportFragmentManager(), FRAGMENT_TAG_SELECT_COLOR);
        return;
    L5:
        r103 = r100.getArguments();
        goto L6
    }
}
