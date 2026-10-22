package com.bytedance.ee.bear.bitable.card.view.page;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeStatusResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeStatusResult$SubscribeStatusResultData;", "<init>", "()V", "SubscribeStatusResultData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordSubscribeStatusResult extends Result<SubscribeStatusResultData> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR:\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/RecordSubscribeStatusResult$SubscribeStatusResultData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "status", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getStatus", "()Ljava/util/HashMap;", "setStatus", "(Ljava/util/HashMap;)V", "autoSubStatusMap", "getAutoSubStatusMap", "setAutoSubStatusMap", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubscribeStatusResultData implements NonProguard {
        private HashMap<String, Integer> autoSubStatusMap;
        private HashMap<String, Integer> status;

        public SubscribeStatusResultData() {
        }

        public final HashMap<String, Integer> getAutoSubStatusMap() {
            return this.autoSubStatusMap;
        }

        public final HashMap<String, Integer> getStatus() {
            return this.status;
        }

        public final void setAutoSubStatusMap(HashMap<String, Integer> r100) {
            this.autoSubStatusMap = r100;
        }

        public final void setStatus(HashMap<String, Integer> r100) {
            this.status = r100;
        }
    }

    public RecordSubscribeStatusResult() {
    }
}
