package com.bytedance.awemeopen.apps.framework.comment.api.param;

import com.bytedance.awemeopen.apps.framework.comment.api.param.CommentPageParam;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000 \u0011*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002:\u0001\u0012B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\tR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/api/param/CommentPageParam;", "T", "Ljava/io/Serializable;", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "cid", "getCid", "setCid", "authorUid", "getAuthorUid", "setAuthorUid", "<init>", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class CommentPageParam<T extends CommentPageParam<? extends T>> implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 9148864135191458444L;
    private String authorUid;
    private String cid;
    private String groupId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getAuthorUid() {
        return this.authorUid;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public CommentPageParam(String r1) {
        this.groupId = r1;
    }

    public final void setAuthorUid(String r1) {
        this.authorUid = r1;
    }

    public final void setCid(String r1) {
        this.cid = r1;
    }

    public final void setGroupId(String r1) {
        this.groupId = r1;
    }
}
