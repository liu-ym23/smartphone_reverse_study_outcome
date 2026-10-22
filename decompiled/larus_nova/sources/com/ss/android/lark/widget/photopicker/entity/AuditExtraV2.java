package com.ss.android.lark.widget.photopicker.entity;

import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Extend;
import com.ss.android.lark.pb.security_event.ModuleType;
import com.ss.android.lark.pb.security_event.ObjectDetail;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/entity/AuditExtraV2;", "Ljava/io/Serializable;", "moduleType", "Lcom/ss/android/lark/pb/security_event/ModuleType;", "entityType", "Lcom/ss/android/lark/pb/security_event/EntityType;", "objectDetail", "Lcom/ss/android/lark/pb/security_event/ObjectDetail;", "extends", "Lcom/ss/android/lark/pb/security_event/Extend;", "<init>", "(Lcom/ss/android/lark/pb/security_event/ModuleType;Lcom/ss/android/lark/pb/security_event/EntityType;Lcom/ss/android/lark/pb/security_event/ObjectDetail;Lcom/ss/android/lark/pb/security_event/Extend;)V", "getModuleType", "()Lcom/ss/android/lark/pb/security_event/ModuleType;", "getEntityType", "()Lcom/ss/android/lark/pb/security_event/EntityType;", "getObjectDetail", "()Lcom/ss/android/lark/pb/security_event/ObjectDetail;", "getExtends", "()Lcom/ss/android/lark/pb/security_event/Extend;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuditExtraV2 implements Serializable {
    private final EntityType entityType;

    /* JADX INFO: renamed from: extends, reason: not valid java name */
    private final Extend f120extends;
    private final ModuleType moduleType;
    private final ObjectDetail objectDetail;

    public static /* synthetic */ AuditExtraV2 copy$default(AuditExtraV2 r100, ModuleType r101, EntityType r102, ObjectDetail r103, Extend r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.moduleType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.entityType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.objectDetail;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.f120extends;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ModuleType component1() {
        return this.moduleType;
    }

    public final EntityType component2() {
        return this.entityType;
    }

    public final ObjectDetail component3() {
        return this.objectDetail;
    }

    public final Extend component4() {
        return this.f120extends;
    }

    public final AuditExtraV2 copy(ModuleType r100, EntityType r101, ObjectDetail r102, Extend r103) {
        Intrinsics.checkNotNullParameter(r100, "moduleType");
        Intrinsics.checkNotNullParameter(r101, "entityType");
        return new AuditExtraV2(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuditExtraV2) == true) goto L8;
        return false;
    L8:
        AuditExtraV2 r101 = (AuditExtraV2) r100;
        if (this.moduleType == r101.moduleType) goto L12;
        return false;
    L12:
        if (this.entityType == r101.entityType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objectDetail, r101.objectDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f120extends, r101.f120extends) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.moduleType.hashCode() * 31) + this.entityType.hashCode()) * 31;
        ObjectDetail r101 = this.objectDetail;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Extend r105 = this.f120extends;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AuditExtraV2(moduleType=" + this.moduleType + ", entityType=" + this.entityType + ", objectDetail=" + this.objectDetail + ", extends=" + this.f120extends + ')';
    }

    public final EntityType getEntityType() {
        return this.entityType;
    }

    public final Extend getExtends() {
        return this.f120extends;
    }

    public final ModuleType getModuleType() {
        return this.moduleType;
    }

    public final ObjectDetail getObjectDetail() {
        return this.objectDetail;
    }

    public AuditExtraV2(ModuleType r100, EntityType r101, ObjectDetail r102, Extend r103) {
        Intrinsics.checkNotNullParameter(r100, "moduleType");
        Intrinsics.checkNotNullParameter(r101, "entityType");
        this.moduleType = r100;
        this.entityType = r101;
        this.objectDetail = r102;
        this.f120extends = r103;
    }

    public /* synthetic */ AuditExtraV2(ModuleType r100, EntityType r101, ObjectDetail r102, Extend r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
