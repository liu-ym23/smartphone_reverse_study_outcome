package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/AuthReason;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "copy", "", "view", "<init>", "(II)V", "getCopy", "()I", "setCopy", "(I)V", "getView", "setView", "isCopyAuthByKp", "", "isCopyAuthByLeader", "isViewAuthByLeader", "component1", "component2", "equals", "other", "", "hashCode", "toString", "", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthReason extends Result<Serializable> {
    public static final int AUTH_DEFAULT = 0;
    public static final int AUTH_KP_CAN_READ = 210001;
    public static final int AUTH_LEADER_AUTO_FA = 100003;
    public static final int AUTH_LEADER_DEFAULT_COPY = 100000;
    public static final a Companion = null;
    private int copy;
    private int view;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AuthReason() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ AuthReason copy$default(AuthReason r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.copy;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.view;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.copy;
    }

    public final int component2() {
        return this.view;
    }

    public final AuthReason copy(int r2, int r3) {
        return new AuthReason(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AuthReason) == true) goto L8;
        return false;
    L8:
        AuthReason r6 = (AuthReason) r5;
        if (this.copy == r6.copy) goto L12;
        return false;
    L12:
        if (this.view == r6.view) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.copy * 31) + this.view;
    }

    public String toString() {
        return "AuthReason(copy=" + this.copy + ", view=" + this.view + ')';
    }

    public final boolean isCopyAuthByKp() {
        if (this.copy != 210001) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCopyAuthByLeader() {
        if (this.copy != 100000) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isViewAuthByLeader() {
        if (this.view != 100003) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getCopy() {
        return this.copy;
    }

    public final int getView() {
        return this.view;
    }

    public final void setCopy(int r1) {
        this.copy = r1;
    }

    public final void setView(int r1) {
        this.view = r1;
    }

    public AuthReason(int r1, int r2) {
        this.copy = r1;
        this.view = r2;
    }

    public /* synthetic */ AuthReason(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
