package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.ss.android.lark.chat.entity.message.Message;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f430799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f430801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ByteBuffer f430802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f430803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f430804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f430805g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f430799a, r101.f430799a) == true) goto L12;
        return false;
    L12:
        if (this.f430800b == r101.f430800b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f430801c, r101.f430801c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f430802d, r101.f430802d) == true) goto L21;
        return false;
    L21:
        if (this.f430803e == r101.f430803e) goto L24;
        return false;
    L24:
        if (this.f430804f == r101.f430804f) goto L27;
        return false;
    L27:
        if (this.f430805g == r101.f430805g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f430799a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f430800b) * 31;
        String r104 = this.f430801c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f430802d.hashCode()) * 31;
        int r106 = 1231;
        if (this.f430803e == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f430804f == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f430805g == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioRecordData(message=" + this.f430799a + ", sequenceId=" + this.f430800b + ", uploadId=" + this.f430801c + ", data=" + this.f430802d + ", isFinish=" + this.f430803e + ", needUploadAudioData=" + this.f430804f + ", isNeedUsePush=" + this.f430805g + ')';
    }

    public /* synthetic */ c(Message r100, int r110, String r111, ByteBuffer r112, boolean r113, boolean r114) {
        this(r100, r110, r111, r112, r113, false, r114);
    }

    public c(Message r100, int r101, String r102, ByteBuffer r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r103, "data");
        this.f430799a = r100;
        this.f430800b = r101;
        this.f430801c = r102;
        this.f430802d = r103;
        this.f430803e = r104;
        this.f430804f = r105;
        this.f430805g = r106;
    }
}
