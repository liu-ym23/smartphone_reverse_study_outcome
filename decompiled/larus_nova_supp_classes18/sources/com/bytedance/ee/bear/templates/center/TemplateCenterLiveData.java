package com.bytedance.ee.bear.templates.center;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiMutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/TemplateCenterLiveData;", "T", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiMutableLiveData;", "<init>", "()V", "value", "(Ljava/lang/Object;)V", "enable", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCenterLiveData<T> extends ForsetiMutableLiveData<T> {
    public TemplateCenterLiveData() {
    }

    public TemplateCenterLiveData(sbb.e r1) {
        super(r1);
    }

    public final boolean a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return super.a(r2);
    }
}
