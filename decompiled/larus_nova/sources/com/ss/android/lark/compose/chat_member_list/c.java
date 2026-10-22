package com.ss.android.lark.compose.chat_member_list;

import androidx.compose.ui.graphics.vector.ImageVector;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageVector f417337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f417338c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f417336a, r101.f417336a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417337b, r101.f417337b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417338c, r101.f417338c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f417336a.hashCode() * 31) + this.f417337b.hashCode()) * 31) + this.f417338c.hashCode();
    }

    public final String toString() {
        return "ChatMembersTopBarMenuItem(title=" + this.f417336a + ", icon=" + this.f417337b + ", onClick=" + this.f417338c + ')';
    }

    public c(String r100, ImageVector r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f417336a = r100;
        this.f417337b = r101;
        this.f417338c = r102;
    }
}
