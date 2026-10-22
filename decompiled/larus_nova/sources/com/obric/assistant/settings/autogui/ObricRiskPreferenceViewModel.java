package com.obric.assistant.settings.autogui;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;
import com.obric.assistant.RiskPreferenceSettings;
import com.obric.assistant.t1;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricRiskPreferenceViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/autogui/ObricRiskPreferenceUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "onRiskPreferenceSelected", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/settings/autogui/RiskPreferenceItemUiModel;", "buildRows", "", "Lcom/obric/assistant/settings/autogui/RiskPreferenceRowUiModel;", "selectedValue", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRiskPreferenceViewModel extends ViewModel {
    private final kotlinx.coroutines.flow.z0<s0> _uiState;
    private final i1<s0> uiState;

    public final void refresh() {
        kotlinx.coroutines.flow.z0<s0> r100 = this._uiState;
        r100.setValue(s0.a(r100.getValue(), buildRows(t1.f393353a.O())));
    }

    public ObricRiskPreferenceViewModel() {
        StateFlowImpl r100 = j1.a(new s0(FlowRuntime.a().getApplication().getString(R.string.obric_setting_auto_gui_risk_preference), buildRows(t1.f393353a.O())));
        this._uiState = r100;
        this.uiState = kotlinx.coroutines.flow.e.b(r100);
    }

    public final i1<s0> getUiState() {
        return this.uiState;
    }

    private final List<v0> buildRows(@RiskPreferenceSettings String r110) {
        Application r100 = FlowRuntime.a().getApplication();
        return CollectionsKt.listOf(new v0[]{new v0.b(new u0("1", r100.getString(R.string.obric_setting_auto_gui_risk_preference_confirm_first), r100.getString(R.string.obric_setting_auto_gui_risk_preference_confirm_first_hint), Intrinsics.areEqual(r110, "1"), 1)), new v0.b(new u0("2", r100.getString(R.string.obric_setting_auto_gui_risk_preference_smart_balance), r100.getString(R.string.obric_setting_auto_gui_risk_preference_smart_balance_hint), Intrinsics.areEqual(r110, "2"), 2)), new v0.b(new u0("3", r100.getString(R.string.obric_setting_auto_gui_risk_preference_autonomy_first), r100.getString(R.string.obric_setting_auto_gui_risk_preference_autonomy_first_hint), Intrinsics.areEqual(r110, "3"), 3)), new v0.a(r100.getString(R.string.obric_setting_auto_gui_risk_preference_bottom_hint))});
    }

    public final void onRiskPreferenceSelected(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        t1.f393353a.n0(r100.f391960a);
        kotlinx.coroutines.flow.z0<s0> r101 = this._uiState;
        r101.setValue(s0.a(r101.getValue(), buildRows(r100.f391960a)));
    }
}
