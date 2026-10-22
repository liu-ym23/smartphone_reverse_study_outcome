package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMemberBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "before", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMember;", "Lkotlin/collections/ArrayList;", "getBefore", "()Ljava/util/ArrayList;", "setBefore", "(Ljava/util/ArrayList;)V", "after", "getAfter", "setAfter", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermMemberBean implements NonProguard {
    private ArrayList<PermMember> after;
    private ArrayList<PermMember> before;

    public PermMemberBean() {
    }

    public final ArrayList<PermMember> getAfter() {
        return this.after;
    }

    public final ArrayList<PermMember> getBefore() {
        return this.before;
    }

    public final void setAfter(ArrayList<PermMember> r1) {
        this.after = r1;
    }

    public final void setBefore(ArrayList<PermMember> r1) {
        this.before = r1;
    }
}
