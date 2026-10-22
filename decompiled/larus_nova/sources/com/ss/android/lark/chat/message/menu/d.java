package com.ss.android.lark.chat.message.menu;

import com.byted.cast.linkcommon.cybergarage.upnp.ActionList;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yya.i;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends zya.e> f415494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<MessageActionType, ? extends List<zya.b>> f415495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f415496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<MessageActionType, List<i>> f415497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<yya.e> f415498e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f415494a, r101.f415494a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415495b, r101.f415495b) == true) goto L15;
        return false;
    L15:
        if (this.f415496c == r101.f415496c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f415497d, r101.f415497d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f415498e, r101.f415498e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f415494a.hashCode() * 31) + this.f415495b.hashCode()) * 31;
        if (this.f415496c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f415497d.hashCode()) * 31) + this.f415498e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MessageActionParseResult(actionList=" + this.f415494a + ", typeToVOList=" + this.f415495b + ", showReaction=" + this.f415496c + ", actionsMapIncludingGone=" + this.f415497d + ", featureInterceptors=" + this.f415498e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends zya.e> r100, Map<MessageActionType, ? extends List<zya.b>> r101, boolean r102, Map<MessageActionType, ? extends List<? extends i>> r103, List<? extends yya.e> r104) {
        Intrinsics.checkNotNullParameter(r100, ActionList.ELEM_NAME);
        Intrinsics.checkNotNullParameter(r101, "typeToVOList");
        Intrinsics.checkNotNullParameter(r103, "actionsMapIncludingGone");
        Intrinsics.checkNotNullParameter(r104, "featureInterceptors");
        this.f415494a = r100;
        this.f415495b = r101;
        this.f415496c = r102;
        this.f415497d = r103;
        this.f415498e = r104;
    }
}
