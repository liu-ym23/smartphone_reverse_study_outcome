package com.bytedance.ee.bear.templates.recommend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/templates/recommend/NewRecommendTemplateViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "selectedTemplate", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "getSelectedTemplate", "()Landroidx/lifecycle/MutableLiveData;", "selectedTemplate$delegate", "Lkotlin/Lazy;", "setSelectedTemplate", "", ThumbGlideUrl.SOURCE_TEMPLATE, "fromRecommend", "", "Landroidx/lifecycle/LiveData;", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewRecommendTemplateViewModel extends ViewModel {
    private final Lazy selectedTemplate$delegate;

    private final MutableLiveData<TemplateV4> getSelectedTemplate() {
        return (MutableLiveData) this.selectedTemplate$delegate.getValue();
    }

    public NewRecommendTemplateViewModel() {
        this.selectedTemplate$delegate = LazyKt.lazy(NewRecommendTemplateViewModel$selectedTemplate$2.INSTANCE);
    }

    /* JADX INFO: renamed from: getSelectedTemplate, reason: collision with other method in class */
    public final LiveData<TemplateV4> m8333getSelectedTemplate() {
        return getSelectedTemplate();
    }

    public final void setSelectedTemplate(TemplateV4 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        getSelectedTemplate().setValue(r100);
    }
}
