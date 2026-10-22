package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.RichMediaItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f309664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f309666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<RichMediaItem> f309667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f309668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f309669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f309670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f309671h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f309664a, r101.f309664a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309665b, r101.f309665b) == true) goto L15;
        return false;
    L15:
        if (this.f309666c == r101.f309666c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309667d, r101.f309667d) == true) goto L21;
        return false;
    L21:
        if (this.f309668e == r101.f309668e) goto L24;
        return false;
    L24:
        if (this.f309669f == r101.f309669f) goto L27;
        return false;
    L27:
        if (this.f309670g == r101.f309670g) goto L30;
        return false;
    L30:
        if (this.f309671h == r101.f309671h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f309664a.hashCode() * 31;
        String r101 = this.f309665b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f309666c) * 31) + this.f309667d.hashCode()) * 31;
        if (this.f309668e == false) goto L9;
        int r104 = 1231;
    L11:
        return ((((((r103 + r104) * 31) + this.f309669f) * 31) + this.f309670g) * 31) + this.f309671h;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RichMediaLayoutVMData(message=" + this.f309664a + ", richMediaBlockId=" + this.f309665b + ", cardPosition=" + this.f309666c + ", sourceItems=" + this.f309667d + ", enableCreationLayoutFallback=" + this.f309668e + ", maxWidth=" + this.f309669f + ", contentPaddingStart=" + this.f309670g + ", contentPaddingEnd=" + this.f309671h + ')';
    }

    public e0(Message r100, String r101, int r102, List<RichMediaItem> r103, boolean r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "sourceItems");
        this.f309664a = r100;
        this.f309665b = r101;
        this.f309666c = r102;
        this.f309667d = r103;
        this.f309668e = r104;
        this.f309669f = r105;
        this.f309670g = r106;
        this.f309671h = r107;
    }
}
