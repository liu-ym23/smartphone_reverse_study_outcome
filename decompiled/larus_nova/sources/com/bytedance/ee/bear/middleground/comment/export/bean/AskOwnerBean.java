package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/AskOwnerBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "permissionMembers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMember;", "Lkotlin/collections/ArrayList;", "getPermissionMembers", "()Ljava/util/ArrayList;", "setPermissionMembers", "(Ljava/util/ArrayList;)V", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AskOwnerBean implements NonProguard {
    private String commentId;
    private ArrayList<PermMember> permissionMembers;

    public AskOwnerBean() {
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final ArrayList<PermMember> getPermissionMembers() {
        return this.permissionMembers;
    }

    public final void setCommentId(String r100) {
        this.commentId = r100;
    }

    public final void setPermissionMembers(ArrayList<PermMember> r100) {
        this.permissionMembers = r100;
    }
}
