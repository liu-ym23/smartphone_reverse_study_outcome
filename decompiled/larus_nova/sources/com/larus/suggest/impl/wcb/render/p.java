package com.larus.suggest.impl.wcb.render;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f370068b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f370069a;

    public static final class a {
        public static p a(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            String r101 = r100.getLocalMessageId();
            if (r101 != null) goto L6;
            r101 = "";
        L6:
            return new p(r101);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f370069a, ((p) r100).f370069a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f370069a.hashCode();
    }

    public final String toString() {
        return "WcbRenderTargetRef(localMessageId=" + this.f370069a + ')';
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        this.f370069a = r100;
    }
}
