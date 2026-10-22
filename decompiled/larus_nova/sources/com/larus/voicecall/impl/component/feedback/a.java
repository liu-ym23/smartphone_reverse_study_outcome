package com.larus.voicecall.impl.component.feedback;

import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<FeedbackMeta> f377437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f377438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f377439c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f377437a, r101.f377437a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f377438b, r101.f377438b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f377439c, r101.f377439c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f377437a.hashCode() * 31) + this.f377438b.hashCode()) * 31;
        Message r101 = this.f377439c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DislikeDetailDialogParams(metaList=" + this.f377437a + ", feedbackPlaceholder=" + this.f377438b + ", message=" + this.f377439c + ')';
    }

    public a(ArrayList<FeedbackMeta> r100, String r101, Message r102) {
        Intrinsics.checkNotNullParameter(r100, "metaList");
        Intrinsics.checkNotNullParameter(r101, "feedbackPlaceholder");
        this.f377437a = r100;
        this.f377438b = r101;
        this.f377439c = r102;
    }
}
