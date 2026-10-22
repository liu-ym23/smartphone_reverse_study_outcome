package com.bytedance.ee.bear.sheet.borderline;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockSelectBorderFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: classes18.dex */
public class BorderLineViewModel extends ViewModel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FRAGMENT_TAG_SELECT_BORDER = "select_border";
    public static final String REPORT_TAG_ENTER_BORDER_PANEL = "borderLineEnter";
    private MutableLiveData<BorderLineData> borderLineData;
    private a callback;
    private MutableLiveData<Boolean> isClearBorderLinePanel;

    public interface a {
        void a(JSONObject r100);
    }

    public MutableLiveData<BorderLineData> getBorderLineData() {
        if (this.borderLineData != null) goto L6;
        this.borderLineData = new MutableLiveData();
    L6:
        return this.borderLineData;
    }

    public MutableLiveData<Boolean> isClearBorderLinePanel() {
        if (this.isClearBorderLinePanel != null) goto L6;
        this.isClearBorderLinePanel = new MutableLiveData();
    L6:
        return this.isClearBorderLinePanel;
    }

    public void clearBorderLinePanel() {
        isClearBorderLinePanel().setValue(Boolean.TRUE);
    }

    static {
    }

    public BorderLineViewModel() {
    }

    public void setCallback(a r100) {
        this.callback = r100;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_borderline_BorderLineViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r100, FragmentManager r101, String r102) {
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

    public void onBorderLineSelected(String r100, String r101, String r102) {
        if (this.callback == null) goto L6;
        JSONObject r103 = new JSONObject();
        r103.put2("border", r100);
        r103.put2("color", r101);
        r103.put2("choose", r102);
        this.callback.a(r103);
        return;
    }

    public void openBorderLinePanel(Fragment r100, BorderLineData r101, a r102) {
        getBorderLineData().setValue(r101);
        this.callback = r102;
        if (r100.getArguments() != null) goto L5;
        Bundle r103 = new Bundle();
    L6:
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_borderline_BorderLineViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show((DialogFragment) Fragment.instantiate(r100.getActivity(), SheetBlockSelectBorderFragment.class.getName(), r103), r100.getActivity().getSupportFragmentManager(), FRAGMENT_TAG_SELECT_BORDER);
        return;
    L5:
        r103 = r100.getArguments();
        goto L6
    }
}
