package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.bytedance.lark.pb.im.v1.AIRecommendQuestionsType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f414323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f414324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f414325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AIRecommendQuestionsType f414326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f414327e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f414323a == r101.f414323a) goto L12;
        return false;
    L12:
        if (this.f414324b == r101.f414324b) goto L15;
        return false;
    L15:
        if (this.f414325c == r101.f414325c) goto L18;
        return false;
    L18:
        if (this.f414326d == r101.f414326d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f414327e, r101.f414327e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f414323a * 31) + this.f414324b) * 31;
        long r101 = this.f414325c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        AIRecommendQuestionsType r103 = this.f414326d;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f414327e;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "UnreadSummaryVisibleInfo(startPos=" + this.f414323a + ", endPos=" + this.f414324b + ", queryId=" + this.f414325c + ", aiRecommendType=" + this.f414326d + ", anchorMessageId=" + this.f414327e + ')';
    }

    public a(int r100, int r101, long r102, AIRecommendQuestionsType r103, String r104) {
        this.f414323a = r100;
        this.f414324b = r101;
        this.f414325c = r102;
        this.f414326d = r103;
        this.f414327e = r104;
    }
}
