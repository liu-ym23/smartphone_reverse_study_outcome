package com.bytedance.ee.bear.middleground.permission.collaborator.askowner;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/askowner/AskOwnerModel$FailMember;", "Ljava/io/Serializable;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AskOwnerModel$FailMember implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f233161id;

    public final String getId() {
        return this.f233161id;
    }

    public AskOwnerModel$FailMember(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f233161id = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f233161id = r100;
    }
}
