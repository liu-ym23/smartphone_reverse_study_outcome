package com.bytedance.lark.base.open.pkm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000 \b2\u00020\u0001:\u0002\u0007\bB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/BufferCallStatus;", "Lcom/sun/jna/Structure;", "code", "", "data", "Lcom/bytedance/lark/base/open/pkm/RustBuffer$ByValue;", "(ILcom/bytedance/lark/base/open/pkm/RustBuffer$ByValue;)V", "ByValue", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Structure.FieldOrder({"code", "data"})
public class BufferCallStatus extends Structure {
    public static final Companion Companion = null;
    public int code;
    public RustBuffer.ByValue data;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/BufferCallStatus$ByValue;", "Lcom/bytedance/lark/base/open/pkm/BufferCallStatus;", "Lcom/sun/jna/Structure$ByValue;", "()V", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ByValue extends BufferCallStatus implements Structure.ByValue {
        /* JADX WARN: Multi-variable type inference failed */
        public ByValue() {
            int r100 = 0;
            super(r100, null, 3, 0 == true ? 1 : 0);
        }
    }

    public static final class Companion {
        public Companion() {
        }

        public static BufferCallStatus a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            final byte[] r101 = r100.getBytes(Charsets.UTF_8);
            int r102 = r101.length;
            Function1<OutputStream, Unit> r103 = new BufferCallStatus$Companion$panic$1(r101);
            Intrinsics.checkNotNullParameter(r103, "write_block");
            if (r102 <= 0) goto L5;
            RustBuffer.Companion.getClass();
            RustBuffer.ByValue r104 = RustBuffer.a.a(r102);
            Pointer r105 = r104.data;
            Intrinsics.checkNotNull(r105);
            f r106 = new f(r105);
            r103.invoke(r106);
            r106.close();
        L7:
            return new BufferCallStatus(2, r104);
        L5:
            RustBuffer.Companion.getClass();
            r104 = RustBuffer.a.a(0);
            goto L7
        }
    }

    static {
        Companion = new Companion();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferCallStatus() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public BufferCallStatus(int r100, RustBuffer.ByValue r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.code = r100;
        this.data = r101;
    }

    public /* synthetic */ BufferCallStatus(int r100, RustBuffer.ByValue r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new RustBuffer.ByValue();
    L8:
        this(r100, r101);
    }
}
