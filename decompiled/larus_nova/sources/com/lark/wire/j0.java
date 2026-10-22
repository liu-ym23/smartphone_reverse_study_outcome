package com.lark.wire;

import com.byted.cast.common.Constants;
import com.bytedance.mira.oat.ShareElfFile;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
public final class j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f282766b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedSink f282767a;

    public static final class a {
        public static int a(int r100) {
            if ((r100 & com.alipay.sdk.m.n.a.f25611g) != 0) goto L7;
            return 1;
        L7:
            if ((r100 & (-16384)) != 0) goto L11;
            return 2;
        L11:
            if (((-2097152) & r100) != 0) goto L15;
            return 3;
        L15:
            if ((r100 & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0) goto L17;
            return 4;
        L17:
            return 5;
        }

        public static int b(long r100) {
            if (((-128) & r100) != 0) goto L7;
            return 1;
        L7:
            if (((-16384) & r100) != 0) goto L11;
            return 2;
        L11:
            if (((-2097152) & r100) != 0) goto L15;
            return 3;
        L15:
            if (((-268435456) & r100) != 0) goto L19;
            return 4;
        L19:
            if (((-34359738368L) & r100) != 0) goto L23;
            return 5;
        L23:
            if (((-4398046511104L) & r100) != 0) goto L27;
            return 6;
        L27:
            if (((-562949953421312L) & r100) != 0) goto L31;
            return 7;
        L31:
            if (((-72057594037927936L) & r100) != 0) goto L35;
            return 8;
        L35:
            if ((r100 & Long.MIN_VALUE) != 0) goto L37;
            return 9;
        L37:
            return 10;
        }
    }

    static {
    }

    public j0(BufferedSink r100) {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        this.f282767a = r100;
    }

    public final void a(ByteString r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f282767a.write(r100);
    }

    public final void c(int r100) throws IOException {
    L3:
        if ((r100 & com.alipay.sdk.m.n.a.f25611g) == 0) goto L5;
        this.f282767a.writeByte((r100 & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L5:
        this.f282767a.writeByte(r100);
    }

    public final void d(long r100) throws IOException {
    L3:
        if (((-128) & r100) == 0) goto L5;
        this.f282767a.writeByte((((int) r100) & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L5:
        this.f282767a.writeByte((int) r100);
    }

    public final void b(int r100, FieldEncoding r101) throws IOException {
        Intrinsics.checkNotNullParameter(r101, "fieldEncoding");
        Intrinsics.checkNotNullParameter(r101, "fieldEncoding");
        c((r100 << 3) | r101.getValue$wire_runtime());
    }
}
