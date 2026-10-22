package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.permission.define.value.TypePermissionScope;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/PermType;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "externalAccessSwitch", "", "linkShareEntity", "searchEntity", "<init>", "(III)V", "getExternalAccessSwitch", "()I", "getLinkShareEntity", "getSearchEntity", "toString", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermType extends Result<Serializable> implements NonProguard {
    private final int externalAccessSwitch;
    private final int linkShareEntity;
    private final int searchEntity;

    public PermType() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ PermType copy$default(PermType r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.externalAccessSwitch;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.linkShareEntity;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.searchEntity;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.externalAccessSwitch;
    }

    public final int component2() {
        return this.linkShareEntity;
    }

    public final int component3() {
        return this.searchEntity;
    }

    public final PermType copy(int r100, int r101, int r102) {
        return new PermType(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PermType) == true) goto L8;
        return false;
    L8:
        PermType r101 = (PermType) r100;
        if (this.externalAccessSwitch == r101.externalAccessSwitch) goto L12;
        return false;
    L12:
        if (this.linkShareEntity == r101.linkShareEntity) goto L15;
        return false;
    L15:
        if (this.searchEntity == r101.searchEntity) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.externalAccessSwitch * 31) + this.linkShareEntity) * 31) + this.searchEntity;
    }

    public String toString() {
        return "permType{externalAccessSwitch=" + this.externalAccessSwitch + " ,linkShareEntity=" + this.linkShareEntity + '}';
    }

    public final int getExternalAccessSwitch() {
        return this.externalAccessSwitch;
    }

    public final int getLinkShareEntity() {
        return this.linkShareEntity;
    }

    public final int getSearchEntity() {
        return this.searchEntity;
    }

    public PermType(int r100, int r101, int r102) {
        this.externalAccessSwitch = r100;
        this.linkShareEntity = r101;
        this.searchEntity = r102;
    }

    public /* synthetic */ PermType(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = TypePermissionScope.CONTAINER.m8352getTypeValue().intValue();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = TypePermissionScope.CONTAINER.m8352getTypeValue().intValue();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = TypePermissionScope.CONTAINER.m8352getTypeValue().intValue();
    L11:
        this(r100, r101, r102);
    }
}
