package com.bytedance.ee.bear.list.applydelete;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/list/applydelete/DeleteResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "need_apply", "", "getNeed_apply", "()Z", "setNeed_apply", "(Z)V", "reviewer", "", "getReviewer", "()Ljava/lang/String;", "users", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/list/applydelete/DeleteReviewer;", "getUsers", "()Ljava/util/HashMap;", "setUsers", "(Ljava/util/HashMap;)V", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeleteResult implements NonProguard {
    private boolean need_apply;
    private final String reviewer;
    private HashMap<String, DeleteReviewer> users;

    public DeleteResult() {
    }

    public final boolean getNeed_apply() {
        return this.need_apply;
    }

    public final String getReviewer() {
        return this.reviewer;
    }

    public final HashMap<String, DeleteReviewer> getUsers() {
        return this.users;
    }

    public final void setNeed_apply(boolean r1) {
        this.need_apply = r1;
    }

    public final void setUsers(HashMap<String, DeleteReviewer> r1) {
        this.users = r1;
    }
}
