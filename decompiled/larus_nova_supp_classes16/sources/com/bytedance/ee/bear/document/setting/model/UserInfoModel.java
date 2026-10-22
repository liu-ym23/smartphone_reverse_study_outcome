package com.bytedance.ee.bear.document.setting.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/model/UserInfoModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "hasLeader", "", "getHasLeader", "()Z", "setHasLeader", "(Z)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserInfoModel implements NonProguard {
    private boolean hasLeader;

    public UserInfoModel() {
        this.hasLeader = true;
    }

    public final boolean getHasLeader() {
        return this.hasLeader;
    }

    public final void setHasLeader(boolean r1) {
        this.hasLeader = r1;
    }
}
