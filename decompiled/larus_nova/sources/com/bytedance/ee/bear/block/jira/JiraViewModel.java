package com.bytedance.ee.bear.block.jira;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "jiraActionData", "Lcom/bytedance/ee/bear/block/jira/JiraActionData;", "getJiraActionData", "setJiraActionData", "(Landroidx/lifecycle/MutableLiveData;)V", "delegate", "Lcom/bytedance/ee/bear/block/jira/JiraViewModel$Delegate;", "getDelegate", "()Lcom/bytedance/ee/bear/block/jira/JiraViewModel$Delegate;", "setDelegate", "(Lcom/bytedance/ee/bear/block/jira/JiraViewModel$Delegate;)V", "setActive", "", "callback", "actionId", "", "Delegate", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JiraViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private a delegate;
    private MutableLiveData<JiraActionData> jiraActionData;

    public interface a {
        void a(String r100, String r101);
    }

    public JiraViewModel() {
        this.active = new MutableLiveData();
        this.jiraActionData = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final MutableLiveData<JiraActionData> getJiraActionData() {
        return this.jiraActionData;
    }

    public final void callback(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        JiraActionData r101 = this.jiraActionData.getValue();
        if (r101 == null) goto L10;
        String r102 = r101.getBlockId();
        if (r102 == null) goto L11;
        a r103 = this.delegate;
        if (r103 == null) goto L12;
        r103.a(r102, r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setActive(boolean r100) {
        if (Intrinsics.areEqual(Boolean.valueOf(r100), this.active.getValue()) == true) goto L6;
        this.active.setValue(Boolean.valueOf(r100));
        return;
    }

    public final void setDelegate(a r100) {
        this.delegate = r100;
    }

    public final void setJiraActionData(JiraActionData r100) {
        Intrinsics.checkNotNullParameter(r100, "jiraActionData");
        this.jiraActionData.setValue(r100);
    }

    public final void setJiraActionData(MutableLiveData<JiraActionData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jiraActionData = r100;
    }
}
