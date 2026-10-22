package com.larus.platform.api;

import com.larus.im.bean.bot.BotModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wc9.e f365277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotModel f365278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f365279c;

    public t4() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t4) == true) goto L8;
        return false;
    L8:
        t4 r101 = (t4) r100;
        if (Intrinsics.areEqual(this.f365277a, r101.f365277a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365278b, r101.f365278b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365279c, r101.f365279c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        wc9.e r100 = this.f365277a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        BotModel r104 = this.f365278b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f365279c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenPushReminderDataBizInfo(conversation=" + this.f365277a + ", botModel=" + this.f365278b + ", extra=" + this.f365279c + ')';
    }

    public t4(wc9.e r100, BotModel r101, Map<String, ? extends Object> r102) {
        this.f365277a = r100;
        this.f365278b = r101;
        this.f365279c = r102;
    }
}
