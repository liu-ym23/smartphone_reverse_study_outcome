package com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.locallife.cube.PrefetchTiming;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/fetch/async/emit/EmitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "event", "", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/fetch/async/emit/EmitModel$DataBean;", "getData", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/fetch/async/emit/EmitModel$DataBean;", "setData", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/fetch/async/emit/EmitModel$DataBean;)V", "checkParams", "", "DataBean", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmitModel implements NonProguard {
    private DataBean data;
    private String event;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/fetch/async/emit/EmitModel$DataBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/fetch/async/emit/EmitModel;)V", PrefetchTiming.ROUTER, "", "getRouter", "()Ljava/lang/String;", "setRouter", "(Ljava/lang/String;)V", "needRequestNet", "", "getNeedRequestNet", "()Ljava/lang/Boolean;", "setNeedRequestNet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DataBean implements NonProguard {
        private Boolean needRequestNet;
        private String router;
        final /* synthetic */ EmitModel this$0;

        public final Boolean getNeedRequestNet() {
            return this.needRequestNet;
        }

        public final String getRouter() {
            return this.router;
        }

        public DataBean(EmitModel r100) {
            this.this$0 = r100;
        }

        public final void setNeedRequestNet(Boolean r100) {
            this.needRequestNet = r100;
        }

        public final void setRouter(String r100) {
            this.router = r100;
        }
    }

    public EmitModel() {
    }

    public final boolean checkParams() {
        String r100 = this.event;
        if (r100 == null) goto L5;
        boolean r101 = !StringsKt.isBlank(r100);
    L6:
        if (r101 == false) goto L15;
        DataBean r102 = this.data;
        if (r102 == null) goto L12;
        String r103 = r102.getRouter();
        if (r103 == null) goto L12;
        boolean r104 = !StringsKt.isBlank(r103);
    L13:
        if (r104 == false) goto L15;
        return true;
    L12:
        r104 = false;
    L15:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public final DataBean getData() {
        return this.data;
    }

    public final String getEvent() {
        return this.event;
    }

    public final void setData(DataBean r100) {
        this.data = r100;
    }

    public final void setEvent(String r100) {
        this.event = r100;
    }
}
