package com.larus.bmhome.chat.list.cell.prompt;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f305654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f305655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f305656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f305657d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k1) == true) goto L8;
        return false;
    L8:
        k1 r101 = (k1) r100;
        if (Intrinsics.areEqual(this.f305654a, r101.f305654a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f305655b, r101.f305655b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f305656c, r101.f305656c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f305657d, r101.f305657d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        CharSequence r100 = this.f305654a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f305655b.hashCode()) * 31) + this.f305656c.hashCode()) * 31;
        String r104 = this.f305657d;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PromptSendPayload(fillInputContent=" + this.f305654a + ", sendContent=" + this.f305655b + ", messageExt=" + this.f305656c + ", skillPrefix=" + this.f305657d + ')';
    }

    public final Map<String, String> a() {
        return this.f305656c;
    }

    public k1(CharSequence r100, String r101, Map<String, String> r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "sendContent");
        Intrinsics.checkNotNullParameter(r102, "messageExt");
        this.f305654a = r100;
        this.f305655b = r101;
        this.f305656c = r102;
        this.f305657d = r103;
    }
}
