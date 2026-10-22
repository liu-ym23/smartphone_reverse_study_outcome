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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BorderLineViewModel extends ViewModel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FRAGMENT_TAG_SELECT_BORDER = "select_border";
    public static final String REPORT_TAG_ENTER_BORDER_PANEL = "borderLineEnter";
    private MutableLiveData<BorderLineData> borderLineData;
    private a callback;
    private MutableLiveData<Boolean> isClearBorderLinePanel;

    public interface a {
        void a(JSONObject r1);
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

    public void setCallback(a r1) {
        this.callback = r1;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_borderline_BorderLineViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r2, FragmentManager r3, String r4) {
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

    public void onBorderLineSelected(String r3, String r4, String r5) {
        if (this.callback == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("border", r3);
        r0.put("color", r4);
        r0.put("choose", r5);
        this.callback.a(r0);
        return;
    }

    public void openBorderLinePanel(Fragment r2, BorderLineData r3, a r4) {
        getBorderLineData().setValue(r3);
        this.callback = r4;
        if (r2.getArguments() != null) goto L5;
        Bundle r5 = new Bundle();
    L6:
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_borderline_BorderLineViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(Fragment.instantiate(r2.getActivity(), SheetBlockSelectBorderFragment.class.getName(), r5), r2.getActivity().getSupportFragmentManager(), FRAGMENT_TAG_SELECT_BORDER);
        return;
    L5:
        r5 = r2.getArguments();
        goto L6
    }
}
