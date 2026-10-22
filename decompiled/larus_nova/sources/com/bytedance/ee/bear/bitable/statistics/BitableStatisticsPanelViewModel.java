package com.bytedance.ee.bear.bitable.statistics;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.document.i5;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010A\u001a\u00020BR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001e\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "panelType", "Lcom/bytedance/ee/bear/bitable/statistics/StatPanelType;", "getPanelType", "()Lcom/bytedance/ee/bear/bitable/statistics/StatPanelType;", "setPanelType", "(Lcom/bytedance/ee/bear/bitable/statistics/StatPanelType;)V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "setActive", "(Landroidx/lifecycle/MutableLiveData;)V", "templateData", "", "", "", "getTemplateData", "setTemplateData", "focusStatType", "getFocusStatType", "()Ljava/lang/String;", "setFocusStatType", "(Ljava/lang/String;)V", "focusId", "", "getFocusId", "()Ljava/util/List;", "setFocusId", "(Ljava/util/List;)V", "obtainGroupData", "getObtainGroupData", "setObtainGroupData", "lynxWebDelegate", "Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;", "getLynxWebDelegate", "()Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;", "setLynxWebDelegate", "(Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;)V", "analytic", "Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "getAnalytic", "()Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "setAnalytic", "(Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;)V", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "delegate", "Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/bitable/statistics/BitableStatisticsPanelViewModel$Delegate;)V", "close", "", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableStatisticsPanelViewModel extends ViewModel {
    private MutableLiveData<Boolean> active;
    private BitableFieldEditAnalytic analytic;
    private a delegate;
    private List<String> focusId;
    private String focusStatType;
    private i5 lynxWebDelegate;
    private MutableLiveData<String> obtainGroupData;
    private StatPanelType panelType;
    private String srcObjToken;
    private Integer srcObjType;
    private MutableLiveData<Map<String, Object>> templateData;

    public interface a {
        void onClose();
    }

    public final void close() {
        this.active.setValue(Boolean.FALSE);
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.onClose();
        return;
    }

    public BitableStatisticsPanelViewModel() {
        this.panelType = StatPanelType.UNKONW;
        this.active = new MutableLiveData();
        this.templateData = new MutableLiveData();
        this.obtainGroupData = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final BitableFieldEditAnalytic getAnalytic() {
        return this.analytic;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final List<String> getFocusId() {
        return this.focusId;
    }

    public final String getFocusStatType() {
        return this.focusStatType;
    }

    public final i5 getLynxWebDelegate() {
        return this.lynxWebDelegate;
    }

    public final MutableLiveData<String> getObtainGroupData() {
        return this.obtainGroupData;
    }

    public final StatPanelType getPanelType() {
        return this.panelType;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final Integer getSrcObjType() {
        return this.srcObjType;
    }

    public final MutableLiveData<Map<String, Object>> getTemplateData() {
        return this.templateData;
    }

    public final void setActive(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.active = r100;
    }

    public final void setAnalytic(BitableFieldEditAnalytic r100) {
        this.analytic = r100;
    }

    public final void setDelegate(a r100) {
        this.delegate = r100;
    }

    public final void setFocusId(List<String> r100) {
        this.focusId = r100;
    }

    public final void setFocusStatType(String r100) {
        this.focusStatType = r100;
    }

    public final void setLynxWebDelegate(i5 r100) {
        this.lynxWebDelegate = r100;
    }

    public final void setObtainGroupData(MutableLiveData<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.obtainGroupData = r100;
    }

    public final void setPanelType(StatPanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.panelType = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(Integer r100) {
        this.srcObjType = r100;
    }

    public final void setTemplateData(MutableLiveData<Map<String, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateData = r100;
    }
}
