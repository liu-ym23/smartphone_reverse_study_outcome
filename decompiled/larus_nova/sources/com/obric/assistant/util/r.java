package com.obric.assistant.util;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class r implements zga.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f393826a;

    public /* synthetic */ r(String r100) {
        this.f393826a = r100;
    }

    @Override // zga.d
    public final boolean a(jha.p r100) {
        String r101 = this.f393826a;
        Intrinsics.checkNotNullParameter(r100, "envelope");
        S r102 = r100.f499148b;
        if ((r102 instanceof aha.j) == false) goto L5;
        return true;
    L5:
        if ((r102 instanceof aha.e0) == false) goto L7;
        return true;
    L7:
        if ((r102 instanceof aha.h0) == false) goto L10;
        return true;
    L10:
        if ((r102 instanceof aha.q) == false) goto L20;
        Message r103 = ((aha.q) r102).d();
        if (r103 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L28;
    L22:
        return false;
    L28:
        return true;
    L14:
        if (com.larus.bmhome.chat.bean.d.T(r103) != true) goto L16;
        r104 = true;
        goto L17
    L20:
        if ((r102 instanceof aha.n) == false) goto L22;
        return Intrinsics.areEqual(((aha.n) r102).b(), r101);
    }
}
