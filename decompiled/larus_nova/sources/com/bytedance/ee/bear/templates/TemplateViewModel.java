package com.bytedance.ee.bear.templates;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "templateTagStatueLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getTemplateTagStatueLiveData", "()Landroidx/lifecycle/MutableLiveData;", "hasReportTemplateDocShow", "getHasReportTemplateDocShow", "()Z", "setHasReportTemplateDocShow", "(Z)V", "groupPreviewCallBack", "Lcom/bytedance/ee/bear/templates/dto/GroupPreviewCallBack;", "getGroupPreviewCallBack", "()Lcom/bytedance/ee/bear/templates/dto/GroupPreviewCallBack;", "setGroupPreviewCallBack", "(Lcom/bytedance/ee/bear/templates/dto/GroupPreviewCallBack;)V", "features-templates-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateViewModel extends ViewModel {
    private com.bytedance.ee.bear.templates.dto.b groupPreviewCallBack;
    private boolean hasReportTemplateDocShow;
    private final MutableLiveData<Boolean> templateTagStatueLiveData;

    public TemplateViewModel() {
        this.templateTagStatueLiveData = new MutableLiveData();
    }

    public final com.bytedance.ee.bear.templates.dto.b getGroupPreviewCallBack() {
        return this.groupPreviewCallBack;
    }

    public final boolean getHasReportTemplateDocShow() {
        return this.hasReportTemplateDocShow;
    }

    public final MutableLiveData<Boolean> getTemplateTagStatueLiveData() {
        return this.templateTagStatueLiveData;
    }

    public final void setGroupPreviewCallBack(com.bytedance.ee.bear.templates.dto.b r100) {
        this.groupPreviewCallBack = r100;
    }

    public final void setHasReportTemplateDocShow(boolean r100) {
        this.hasReportTemplateDocShow = r100;
    }
}
