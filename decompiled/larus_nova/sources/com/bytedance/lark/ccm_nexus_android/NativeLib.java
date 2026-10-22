package com.bytedance.lark.ccm_nexus_android;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH&J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/lark/ccm_nexus_android/NativeLib;", "Lcom/sun/jna/Library;", "molten_ffi_ccm_nexus_call", "Lcom/bytedance/lark/ccm_nexus_android/BufferCallStatus$ByValue;", "runtime", "Lcom/sun/jna/Pointer;", "pointer", com.alipay.sdk.m.p.e.f25671s, "", "param", "Lcom/bytedance/lark/ccm_nexus_android/RustBuffer$ByValue;", "molten_ffi_ccm_nexus_free", "molten_ffi_init_ccm_nexus_f00cc1dccc600976", "frontend", "", "library_id", "entry", "Lcom/bytedance/lark/ccm_nexus_android/CallbackEntry;", "molten_ffi_rustbuffer_alloc", "capacity", "molten_ffi_rustbuffer_free", "", "buf", "molten_ffi_rustbuffer_from_bytes", HTTP.CONTENT_RANGE_BYTES, "Lcom/bytedance/lark/ccm_nexus_android/ForeignBytes$ByValue;", "Companion", "ccm_nexus_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NativeLib extends Library {
    public static final Companion Companion = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f252907a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<NativeLib> f252908b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<Pointer> f252909c = null;

        public Companion() {
        }

        static {
            f252907a = new Companion();
            f252908b = LazyKt.lazy(NativeLib$Companion$INSTANCE$2.INSTANCE);
            f252909c = LazyKt.lazy(NativeLib$Companion$runtime$2.INSTANCE);
        }

        public static NativeLib a() {
            return f252908b.getValue();
        }

        public static Pointer b() {
            return f252909c.getValue();
        }
    }

    static {
        Companion = Companion.f252907a;
    }

    BufferCallStatus.ByValue molten_ffi_ccm_nexus_call(Pointer r100, Pointer r101, long r102, RustBuffer.ByValue r103);

    BufferCallStatus.ByValue molten_ffi_ccm_nexus_free(Pointer r100, Pointer r101, long r102);

    long molten_ffi_init_ccm_nexus_f00cc1dccc600976(int r100, long r101, CallbackEntry r102);

    RustBuffer.ByValue molten_ffi_rustbuffer_alloc(int r100);

    void molten_ffi_rustbuffer_free(RustBuffer.ByValue r100);

    RustBuffer.ByValue molten_ffi_rustbuffer_from_bytes(ForeignBytes.ByValue r100);
}
