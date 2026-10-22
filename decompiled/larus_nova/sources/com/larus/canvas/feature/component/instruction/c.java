package com.larus.canvas.feature.component.instruction;

import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InstructionTabEventType f323123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InstructionTab f323124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OptionItem f323125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f323126d;

    public c() {
        this(null, null, null, false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f323123a == r101.f323123a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323124b, r101.f323124b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f323125c, r101.f323125c) == true) goto L18;
        return false;
    L18:
        if (this.f323126d == r101.f323126d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f323123a.hashCode() * 31;
        InstructionTab r101 = this.f323124b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        OptionItem r105 = this.f323125c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f323126d == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionTabEvent(eventType=" + this.f323123a + ", targetInstructionTab=" + this.f323124b + ", targetOptionItem=" + this.f323125c + ", banAnimation=" + this.f323126d + ')';
    }

    public c(InstructionTabEventType r100, InstructionTab r101, OptionItem r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = InstructionTabEventType.NONE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, "eventType");
        this.f323123a = r100;
        this.f323124b = r101;
        this.f323125c = r102;
        this.f323126d = r103;
    }
}
