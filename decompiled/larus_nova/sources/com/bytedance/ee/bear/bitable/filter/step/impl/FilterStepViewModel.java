package com.bytedance.ee.bear.bitable.filter.step.impl;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.step.EFilterStep;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010X\u001a\u00020LJ\u0006\u0010Y\u001a\u00020LJ\u0006\u0010Z\u001a\u00020LJ\u0014\u0010[\u001a\u00020L2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020L0KJ\u0006\u0010]\u001a\u00020\u0006J\u0006\u0010^\u001a\u00020LR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001c\u0010 \u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR$\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R,\u00107\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0019\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\bR\u0019\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\bR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR6\u0010I\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K0Jj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K`MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006_"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "setActive", "(Landroidx/lifecycle/MutableLiveData;)V", "webService", "Lcom/bytedance/ee/bear/browser/Web;", "getWebService", "()Lcom/bytedance/ee/bear/browser/Web;", "setWebService", "(Lcom/bytedance/ee/bear/browser/Web;)V", "asyncRequestDelegate", "Lcom/bytedance/ee/bear/bitable/AsyncRequestDelegate;", "getAsyncRequestDelegate", "()Lcom/bytedance/ee/bear/bitable/AsyncRequestDelegate;", "setAsyncRequestDelegate", "(Lcom/bytedance/ee/bear/bitable/AsyncRequestDelegate;)V", "requestBaseId", "", "getRequestBaseId", "()Ljava/lang/String;", "setRequestBaseId", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "viewId", "getViewId", "setViewId", TimeZoneItemV2.TIME_ZONE, "getTimeZone", "setTimeZone", "fieldOptions", "", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "getFieldOptions", "()[Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "setFieldOptions", "([Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;)V", "[Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "oldCondition", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "getOldCondition", "()Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "setOldCondition", "(Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;)V", "newCondition", "getNewCondition", "setNewCondition", "startStep", "Lkotlin/Pair;", "Lcom/bytedance/ee/bear/bitable/filter/step/EFilterStep;", "Lcom/bytedance/ee/bear/bitable/filter/step/EFilterStep$SubValueStep;", "getStartStep", "()Lkotlin/Pair;", "setStartStep", "(Lkotlin/Pair;)V", "currentFilterStep", "getCurrentFilterStep", "currentStepTitle", "getCurrentStepTitle", "filterStepPanelDelegate", "Lcom/bytedance/ee/bear/bitable/filter/step/IFilterStepPanelDelegate;", "getFilterStepPanelDelegate", "()Lcom/bytedance/ee/bear/bitable/filter/step/IFilterStepPanelDelegate;", "setFilterStepPanelDelegate", "(Lcom/bytedance/ee/bear/bitable/filter/step/IFilterStepPanelDelegate;)V", "filterStepDoneListeners", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "getFilterStepDoneListeners", "()Ljava/util/ArrayList;", "setFilterStepDoneListeners", "(Ljava/util/ArrayList;)V", "srcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "getSrcObjInfo", "()Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "setSrcObjInfo", "(Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;)V", "backToPreStep", "goToNextStep", "notifyFilterStepDone", "addFilterStepDoneListener", "listener", "shouldHandleSubValueStep", "clearTemporaryData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterStepViewModel extends ViewModel {
    private MutableLiveData<Boolean> active;
    private com.bytedance.ee.bear.bitable.a asyncRequestDelegate;
    private final MutableLiveData<EFilterStep> currentFilterStep;
    private final MutableLiveData<String> currentStepTitle;
    private FilterFieldOption[] fieldOptions;
    private ArrayList<Function0<Unit>> filterStepDoneListeners;
    private com.bytedance.ee.bear.bitable.filter.step.a filterStepPanelDelegate;
    private FilterCondition newCondition;
    private FilterCondition oldCondition;
    private String requestBaseId;
    private mr4.a srcObjInfo;
    private Pair<? extends EFilterStep, ? extends EFilterStep.SubValueStep> startStep;
    private String tableId;
    private String timeZone;
    private String viewId;
    private k webService;

    public final void clearTemporaryData() {
        this.oldCondition = null;
        this.newCondition = null;
        this.startStep = null;
        this.currentFilterStep.setValue(null);
        this.currentStepTitle.setValue(null);
        this.filterStepPanelDelegate = null;
        this.filterStepDoneListeners.clear();
    }

    public final void backToPreStep() {
        MutableLiveData<EFilterStep> r100 = this.currentFilterStep;
        EFilterStep r101 = r100.getValue();
        if (r101 == null) goto L5;
        EFilterStep r102 = r101.previous(shouldHandleSubValueStep());
    L6:
        r100.setValue(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void goToNextStep() {
        MutableLiveData<EFilterStep> r100 = this.currentFilterStep;
        EFilterStep r101 = r100.getValue();
        if (r101 == null) goto L5;
        EFilterStep r102 = r101.next(shouldHandleSubValueStep());
    L6:
        r100.setValue(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void notifyFilterStepDone() {
        Iterator<T> r100 = this.filterStepDoneListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    L6:
        com.bytedance.ee.bear.bitable.filter.step.a r101 = this.filterStepPanelDelegate;
        if (r101 == null) goto L9;
        r101.a(this.newCondition);
    L9:
        this.active.setValue(Boolean.FALSE);
    }

    public final boolean shouldHandleSubValueStep() {
        FilterCondition r100 = this.newCondition;
        if (r100 != null) goto L5;
        r100 = this.oldCondition;
    L5:
        FilterFieldOption[] r101 = this.fieldOptions;
        EFieldType r102 = null;
        if (r101 == null) goto L17;
        int r103 = r101.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L17;
        FilterFieldOption r105 = r101[r104];
        String r106 = r105.getId();
        if (r100 == null) goto L12;
        String r107 = r100.getFieldId();
    L14:
        if (TextUtils.equals(r106, r107) == true) goto L18;
        r104 = r104 + 1;
    L18:
        if (r105 == null) goto L21;
        r102 = r105.getValueFieldType();
    L21:
        return lr4.a.b(r102);
    L12:
        r107 = null;
    L17:
        r105 = null;
        goto L18
    }

    public FilterStepViewModel() {
        this.active = new MutableLiveData();
        this.currentFilterStep = new MutableLiveData();
        this.currentStepTitle = new MutableLiveData();
        this.filterStepDoneListeners = new ArrayList();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final com.bytedance.ee.bear.bitable.a getAsyncRequestDelegate() {
        return this.asyncRequestDelegate;
    }

    public final MutableLiveData<EFilterStep> getCurrentFilterStep() {
        return this.currentFilterStep;
    }

    public final MutableLiveData<String> getCurrentStepTitle() {
        return this.currentStepTitle;
    }

    public final FilterFieldOption[] getFieldOptions() {
        return this.fieldOptions;
    }

    public final ArrayList<Function0<Unit>> getFilterStepDoneListeners() {
        return this.filterStepDoneListeners;
    }

    public final com.bytedance.ee.bear.bitable.filter.step.a getFilterStepPanelDelegate() {
        return this.filterStepPanelDelegate;
    }

    public final FilterCondition getNewCondition() {
        return this.newCondition;
    }

    public final FilterCondition getOldCondition() {
        return this.oldCondition;
    }

    public final String getRequestBaseId() {
        return this.requestBaseId;
    }

    public final mr4.a getSrcObjInfo() {
        return this.srcObjInfo;
    }

    public final Pair<EFilterStep, EFilterStep.SubValueStep> getStartStep() {
        return this.startStep;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final k getWebService() {
        return this.webService;
    }

    public final void addFilterStepDoneListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.filterStepDoneListeners.contains(r100) == true) goto L6;
        this.filterStepDoneListeners.add(r100);
        return;
    }

    public final void setActive(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.active = r100;
    }

    public final void setAsyncRequestDelegate(com.bytedance.ee.bear.bitable.a r100) {
        this.asyncRequestDelegate = r100;
    }

    public final void setFieldOptions(FilterFieldOption[] r100) {
        this.fieldOptions = r100;
    }

    public final void setFilterStepDoneListeners(ArrayList<Function0<Unit>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filterStepDoneListeners = r100;
    }

    public final void setFilterStepPanelDelegate(com.bytedance.ee.bear.bitable.filter.step.a r100) {
        this.filterStepPanelDelegate = r100;
    }

    public final void setNewCondition(FilterCondition r100) {
        this.newCondition = r100;
    }

    public final void setOldCondition(FilterCondition r100) {
        this.oldCondition = r100;
    }

    public final void setRequestBaseId(String r100) {
        this.requestBaseId = r100;
    }

    public final void setSrcObjInfo(mr4.a r100) {
        this.srcObjInfo = r100;
    }

    public final void setStartStep(Pair<? extends EFilterStep, ? extends EFilterStep.SubValueStep> r100) {
        this.startStep = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setTimeZone(String r100) {
        this.timeZone = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public final void setWebService(k r100) {
        this.webService = r100;
    }
}
