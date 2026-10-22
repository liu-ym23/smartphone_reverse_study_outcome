package com.bytedance.ee.bear.middleground.permission.escape.request;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.escape.model.Instance;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/request/InstanceListResult;", "Lcom/bytedance/ee/bear/contract/Result;", "", "Ljava/io/Serializable;", "<init>", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "instances", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;", "Lkotlin/collections/ArrayList;", "getInstances", "()Ljava/util/ArrayList;", "setInstances", "(Ljava/util/ArrayList;)V", "myInstance", "getMyInstance", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;", "setMyInstance", "(Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstanceListResult extends Result<String> {
    private int count;
    private ArrayList<Instance> instances;

    @SerializedName("my_instance")
    private Instance myInstance;

    public InstanceListResult() {
        this.instances = new ArrayList();
    }

    public final int getCount() {
        return this.count;
    }

    public final ArrayList<Instance> getInstances() {
        return this.instances;
    }

    public final Instance getMyInstance() {
        return this.myInstance;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public final void setInstances(ArrayList<Instance> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.instances = r100;
    }

    public final void setMyInstance(Instance r100) {
        this.myInstance = r100;
    }
}
