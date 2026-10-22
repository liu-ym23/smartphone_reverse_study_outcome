package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f410424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f410425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f410426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f410427d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f410424a, r101.f410424a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410425b, r101.f410425b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410426c, r101.f410426c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410427d, r101.f410427d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f410424a.hashCode() * 31) + this.f410425b.hashCode()) * 31) + this.f410426c.hashCode()) * 31) + this.f410427d.hashCode();
    }

    public final String toString() {
        return "HumanMergeForwardVO(msg=" + this.f410424a + ", title=" + this.f410425b + ", subMsgIds=" + this.f410426c + ", paramsMap=" + this.f410427d + ')';
    }

    public o(Message r100, String r101, List<String> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subMsgIds");
        Intrinsics.checkNotNullParameter(r103, "paramsMap");
        this.f410424a = r100;
        this.f410425b = r101;
        this.f410426c = r102;
        this.f410427d = r103;
    }
}
