package com.bytedance.ee.bear.bitable.card.view.page;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeResult$RecordSubscribeResultData;", "<init>", "()V", "RecordSubscribeResultData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordSubscribeResult extends Result<RecordSubscribeResultData> {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeResult$RecordSubscribeResultData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isBaseUnSubscribe", "", "()Z", "setBaseUnSubscribe", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecordSubscribeResultData implements NonProguard {
        private boolean isBaseUnSubscribe;

        public RecordSubscribeResultData() {
        }

        public final boolean isBaseUnSubscribe() {
            return this.isBaseUnSubscribe;
        }

        public final void setBaseUnSubscribe(boolean r100) {
            this.isBaseUnSubscribe = r100;
        }
    }

    public RecordSubscribeResult() {
    }
}
