package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0000J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/VisibilityBean;", "Lcom/bytedance/ee/util/io/NonProguard;", ResourceData.KEY_TYPE, "", "<init>", "(I)V", "getType", "()I", "setType", "permissionMembers", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMemberBean;", "getPermissionMembers", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMemberBean;", "setPermissionMembers", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMemberBean;)V", "getReportVisibility", "", "cloneSelf", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisibilityBean implements NonProguard {
    public static final a Companion = null;
    public static final String TAG = "VisibilityBean";
    public static final int TYPE_PART = 1;
    public static final int TYPE_PRIVATE = 2;
    public static final int TYPE_PUBLIC = 0;
    private PermMemberBean permissionMembers;
    private int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VisibilityBean() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ VisibilityBean copy$default(VisibilityBean r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.type;
    }

    public final VisibilityBean copy(int r2) {
        return new VisibilityBean(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof VisibilityBean) == true) goto L9;
        return false;
    L9:
        if (this.type == ((VisibilityBean) r4).type) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.type;
    }

    public String toString() {
        return "VisibilityBean(type=" + this.type + ')';
    }

    public final VisibilityBean cloneSelf() {
        int r3 = 0;
        VisibilityBean r0 = new VisibilityBean(r3, 1, null);
        r0.type = this.type;
        r0.permissionMembers = this.permissionMembers;
        return r0;
    }

    public final String getReportVisibility() {
        int r0 = this.type;
        if (r0 != 0) goto L5;
        return "public_comment";
    L5:
        if (r0 != 1) goto L7;
        return "partially_visible_comments";
    L7:
        if (r0 == 2) goto L9;
        return "";
    L9:
        return "private_comments";
    }

    public final PermMemberBean getPermissionMembers() {
        return this.permissionMembers;
    }

    public final int getType() {
        return this.type;
    }

    public VisibilityBean(int r1) {
        this.type = r1;
    }

    public final void setPermissionMembers(PermMemberBean r1) {
        this.permissionMembers = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public /* synthetic */ VisibilityBean(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }
}
