package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.android.shopping.anchorv3.activities.quick.base.BaseViewModel;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4ActivityGroupViewModel;", "Lcom/bytedance/android/shopping/anchorv3/activities/quick/base/BaseViewModel;", "()V", "commonMeta", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "getCommonMeta", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "groupInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "getGroupInfo", "isFullScreenState", "", "postGroupBuyingRuleShowEvent", "", "context", "Landroid/content/Context;", "updateGroupInfo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ActivityGroupViewModel extends BaseViewModel {
    private final QLiveData<CommonMeta> commonMeta;
    private final QLiveData<GroupInfo> groupInfo;
    private final QLiveData<Boolean> isFullScreenState;

    public AnchorV4ActivityGroupViewModel() {
        super(null, null, 3, null);
        this.groupInfo = new QLiveData();
        this.commonMeta = new QLiveData();
        this.isFullScreenState = new QLiveData();
    }

    public final void postGroupBuyingRuleShowEvent(Context r1) {
    }

    public final QLiveData<CommonMeta> getCommonMeta() {
        return this.commonMeta;
    }

    public final QLiveData<GroupInfo> getGroupInfo() {
        return this.groupInfo;
    }

    public final QLiveData<Boolean> isFullScreenState() {
        return this.isFullScreenState;
    }

    public final void updateGroupInfo(GroupInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "groupInfo");
        this.groupInfo.g(r2);
    }
}
