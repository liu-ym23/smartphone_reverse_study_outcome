package com.ss.android.lark.chat.export.entity.message.content;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f415406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ByteString f415407d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f415406c == r101.f415406c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415407d, r101.f415407d) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f415406c * 31) + this.f415407d.hashCode();
    }

    public final String toString() {
        return "LarkCommand(cmd=" + this.f415406c + ", payload=" + this.f415407d + ')';
    }

    public d(int r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        super(1, true);
        this.f415406c = r100;
        this.f415407d = r101;
    }
}
