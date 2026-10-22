package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
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
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ AuthReason copy$default(AuthReason r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.copy;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.view;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.copy;
    }

    public final int component2() {
        return this.view;
    }

    public final AuthReason copy(int r100, int r101) {
        return new AuthReason(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuthReason) == true) goto L8;
        return false;
    L8:
        AuthReason r101 = (AuthReason) r100;
        if (this.copy == r101.copy) goto L12;
        return false;
    L12:
        if (this.view == r101.view) goto L14;
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

    public final void setCopy(int r100) {
        this.copy = r100;
    }

    public final void setView(int r100) {
        this.view = r100;
    }

    public AuthReason(int r100, int r101) {
        this.copy = r100;
        this.view = r101;
    }

    public /* synthetic */ AuthReason(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
