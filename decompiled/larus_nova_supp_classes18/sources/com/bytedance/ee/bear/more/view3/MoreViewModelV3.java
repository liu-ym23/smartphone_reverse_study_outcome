package com.bytedance.ee.bear.more.view3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.more.protocol3.h;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\r\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/more/view3/MoreViewModelV3;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataProvider", "Lcom/bytedance/ee/bear/more/protocol3/MoreProvider;", "init", "", "create", "host", "Lcom/bytedance/ee/bear/more/moreprotocol/IMoreHost;", "getMoreUIList", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/ee/bear/more/protocol3/MoreUIList;", "getChangedUIItem", "Lcom/bytedance/ee/bear/more/protocol3/UIMoreItem;", "getUrl", "", "getToken", "getType", "", "()Ljava/lang/Integer;", "release", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreViewModelV3 extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "MoreViewModel";
    private h dataProvider;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final LiveData<k> getChangedUIItem() {
        h r0 = this.dataProvider;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g;
    }

    public final LiveData<i> getMoreUIList() {
        h r0 = this.dataProvider;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    public final String getToken() {
        h r0 = this.dataProvider;
        if (r0 == null) goto L7;
        oj5.c r1 = r0.d;
        if (r1 == null) goto L7;
        return r1.getToken();
    L7:
        return null;
    }

    public final Integer getType() {
        h r0 = this.dataProvider;
        if (r0 == null) goto L7;
        oj5.c r1 = r0.d;
        if (r1 == null) goto L7;
        return Integer.valueOf(r1.getType());
    L7:
        return null;
    }

    public final String getUrl() {
        h r0 = this.dataProvider;
        if (r0 == null) goto L7;
        oj5.c r1 = r0.d;
        if (r1 == null) goto L7;
        return r1.getUrl();
    L7:
        return null;
    }

    public final void release() {
        h r0 = this.dataProvider;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public MoreViewModelV3() {
    }

    public final void create(sj5.b r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        h r0 = this.dataProvider;
        if (r0 == null) goto L6;
        r0.a(r3, d.a);
        return;
    }

    public final void init(h r2) {
        Intrinsics.checkNotNullParameter(r2, "dataProvider");
        this.dataProvider = r2;
    }
}
