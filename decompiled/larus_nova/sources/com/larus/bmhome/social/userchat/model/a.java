package com.larus.bmhome.social.userchat.model;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f314111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotModel f314112b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f314111a == r101.f314111a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314112b, r101.f314112b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f314111a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        BotModel r102 = this.f314112b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "BotModelState(updated=" + this.f314111a + ", botModel=" + this.f314112b + ')';
    }

    public a(boolean r100, BotModel r101) {
        this.f314111a = r100;
        this.f314112b = r101;
    }
}
