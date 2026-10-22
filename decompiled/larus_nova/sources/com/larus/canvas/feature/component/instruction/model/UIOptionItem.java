package com.larus.canvas.feature.component.instruction.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/UIOptionItem;", "", "id", "", "name", "", "visible", "", "uiStatus", "Lcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;", "<init>", "(JLjava/lang/String;ZLcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getVisible", "()Z", "getUiStatus", "()Lcom/larus/canvas/feature/component/instruction/model/UIOptionStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIOptionItem {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f323166id;
    private final String name;
    private final UIOptionStatus uiStatus;
    private final boolean visible;

    public static /* synthetic */ UIOptionItem copy$default(UIOptionItem r100, long r101, String r102, boolean r110, UIOptionStatus r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f323166id;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.visible;
    L11:
        boolean r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.uiStatus;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    public final long component1() {
        return this.f323166id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.visible;
    }

    public final UIOptionStatus component4() {
        return this.uiStatus;
    }

    public final UIOptionItem copy(long r100, String r110, boolean r111, UIOptionStatus r112) {
        Intrinsics.checkNotNullParameter(r112, "uiStatus");
        return new UIOptionItem(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UIOptionItem) == true) goto L8;
        return false;
    L8:
        UIOptionItem r101 = (UIOptionItem) r100;
        if (this.f323166id == r101.f323166id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.visible == r101.visible) goto L18;
        return false;
    L18:
        if (this.uiStatus == r101.uiStatus) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.f323166id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.name;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r101 + r103) * 31;
        if (this.visible == false) goto L9;
        int r105 = 1231;
    L11:
        return ((r104 + r105) * 31) + this.uiStatus.hashCode();
    L9:
        r105 = 1237;
        goto L11
    L5:
        r103 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "UIOptionItem(id=" + this.f323166id + ", name=" + this.name + ", visible=" + this.visible + ", uiStatus=" + this.uiStatus + ')';
    }

    public final long getId() {
        return this.f323166id;
    }

    public final String getName() {
        return this.name;
    }

    public final UIOptionStatus getUiStatus() {
        return this.uiStatus;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public UIOptionItem(long r100, String r101, boolean r102, UIOptionStatus r103) {
        Intrinsics.checkNotNullParameter(r103, "uiStatus");
        this.f323166id = r100;
        this.name = r101;
        this.visible = r102;
        this.uiStatus = r103;
    }

    public /* synthetic */ UIOptionItem(long r100, String r101, boolean r110, UIOptionStatus r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        r101 = "";
    L5:
        String r102 = r101;
        if ((r112 & 4) == 0) goto L8;
        boolean r103 = true;
    L10:
        if ((r112 & 8) == 0) goto L12;
        r111 = UIOptionStatus.NORMAL;
    L12:
        this(r100, r102, r103, r111);
        return;
    L8:
        r103 = r110;
        goto L10
    }
}
