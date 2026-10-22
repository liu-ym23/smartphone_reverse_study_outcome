package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import cq8.a0;
import cq8.c0;
import cq8.d0;
import cq8.e0;
import cq8.k0;
import cq8.y;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes26.dex */
public final class n extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f312007p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 15;
    }

    public n() {
        super("MultiMediaSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        com.larus.bmhome.instruction.core.impl.base.c r100 = this.f311921c;
        if (r100 == null) goto L9;
        aq8.d r101 = r100.f311935a;
        if (r101 == null) goto L9;
        dq8.f r102 = r101.f15939c;
        if (r102 == null) goto L9;
        List<MediaAttachment> r103 = r102.a();
    L10:
        if (r103 != null) goto L12;
        r103 = CollectionsKt.emptyList();
    L12:
        List<MediaAttachment> r104 = r103;
        String r105 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C4081b r106 = this.f311933o;
        com.larus.bmhome.actionbar.model.u r107 = this.f311920b;
        if (r107 == null) goto L19;
        String r108 = r107.f295476c;
        if (r108 == null) goto L19;
        if ((!StringsKt.isBlank(r108)) == false) goto L19;
        String r109 = r108;
    L20:
        com.larus.bmhome.actionbar.model.u r110 = this.f311920b;
        if (r110 == null) goto L27;
        String r111 = r110.f295476c;
        if (r111 == null) goto L27;
        if ((!StringsKt.isBlank(r111)) == false) goto L27;
        String r112 = r111;
    L28:
        com.larus.bmhome.actionbar.model.u r113 = this.f311920b;
        if (r113 == null) goto L31;
        boolean r114 = Intrinsics.areEqual(r113.f295479f, Boolean.TRUE);
    L33:
        return new k0(r105, r106, r104, r109, r112, r114);
    L31:
        r114 = false;
    L27:
        r112 = null;
    L19:
        r109 = null;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r100 instanceof c0) == false) goto L9;
        o(new com.larus.bmhome.instruction.core.impl.base.k.j(((c0) r100).f464813c));
        return;
    L9:
        if ((r100 instanceof e0) == false) goto L12;
        o(new com.larus.bmhome.instruction.core.impl.base.k.l(((e0) r100).getIdentifier()));
        return;
    L12:
        if ((r100 instanceof d0) == false) goto L17;
        d0 r101 = (d0) r100;
        o(new com.larus.bmhome.instruction.core.impl.base.k.C4082k(r101.f464820c, r101.f464821d));
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        if (this.f312007p == true) goto L14;
        com.larus.bmhome.instruction.core.impl.base.c r101 = this.f311921c;
        if (r101 == null) goto L14;
        aq8.d r102 = r101.f311935a;
        if (r102 == null) goto L14;
        dq8.f r103 = r102.f15939c;
        if (r103 == null) goto L14;
        this.f312007p = true;
        BuildersKt.launch$default(this.f311925g, null, null, new MultiMediaSelectorController$startObserveAttachments$1(r103, this, null), 3, null);
    L14:
        return new wa8.a0(Boolean.TRUE, "");
    }
}
