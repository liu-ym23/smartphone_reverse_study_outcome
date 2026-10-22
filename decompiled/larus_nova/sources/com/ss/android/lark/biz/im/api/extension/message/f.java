package com.ss.android.lark.biz.im.api.extension.message;

import android.content.Context;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f410205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Chat f410206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Chatter f410207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f410208d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f410205a, r101.f410205a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410206b, r101.f410206b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410207c, r101.f410207c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410208d, r101.f410208d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f410205a.hashCode() * 31;
        Chat r101 = this.f410206b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Chatter r105 = this.f410207c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        c r108 = this.f410208d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MessageResourceLoadTaskContext(context=" + this.f410205a + ", chat=" + this.f410206b + ", p2pChatter=" + this.f410207c + ", updater=" + this.f410208d + ')';
    }

    public final Context getContext() {
        return this.f410205a;
    }

    public f(Context r100, Chat r101, Chatter r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f410205a = r100;
        this.f410206b = r101;
        this.f410207c = r102;
        this.f410208d = r103;
    }
}
