package com.bytedance.lark.lark_bitable_android;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H&J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/NativeLib;", "Lcom/sun/jna/Library;", "molten_ffi_init_lark_bitable_bc8fdfae5ca0c1aa", "", "frontend", "", "library_id", "entry", "Lcom/bytedance/lark/lark_bitable_android/CallbackEntry;", "molten_ffi_lark_bitable_call", "Lcom/bytedance/lark/lark_bitable_android/BufferCallStatus$ByValue;", "runtime", "Lcom/sun/jna/Pointer;", "pointer", com.alipay.sdk.m.p.e.f25671s, "param", "Lcom/bytedance/lark/lark_bitable_android/RustBuffer$ByValue;", "molten_ffi_lark_bitable_free", "molten_ffi_rustbuffer_alloc", "capacity", "molten_ffi_rustbuffer_free", "", "buf", "molten_ffi_rustbuffer_from_bytes", HTTP.CONTENT_RANGE_BYTES, "Lcom/bytedance/lark/lark_bitable_android/ForeignBytes$ByValue;", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NativeLib extends Library {
    public static final Companion Companion = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f252967a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<NativeLib> f252968b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<Pointer> f252969c = null;

        public Companion() {
        }

        static {
            f252967a = new Companion();
            f252968b = LazyKt.lazy(NativeLib$Companion$INSTANCE$2.INSTANCE);
            f252969c = LazyKt.lazy(NativeLib$Companion$runtime$2.INSTANCE);
        }

        public static NativeLib a() {
            return f252968b.getValue();
        }

        public static Pointer b() {
            return f252969c.getValue();
        }
    }

    static {
        Companion = Companion.f252967a;
    }

    long molten_ffi_init_lark_bitable_bc8fdfae5ca0c1aa(int r100, long r101, CallbackEntry r102);

    BufferCallStatus.ByValue molten_ffi_lark_bitable_call(Pointer r100, Pointer r101, long r102, RustBuffer.ByValue r103);

    BufferCallStatus.ByValue molten_ffi_lark_bitable_free(Pointer r100, Pointer r101, long r102);

    RustBuffer.ByValue molten_ffi_rustbuffer_alloc(int r100);

    void molten_ffi_rustbuffer_free(RustBuffer.ByValue r100);

    RustBuffer.ByValue molten_ffi_rustbuffer_from_bytes(ForeignBytes.ByValue r100);
}
