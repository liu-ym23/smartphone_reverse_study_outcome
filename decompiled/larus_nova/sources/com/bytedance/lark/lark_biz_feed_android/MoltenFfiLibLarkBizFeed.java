package com.bytedance.lark.lark_biz_feed_android;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/MoltenFfiLibLarkBizFeed;", "", "()V", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MoltenFfiLibLarkBizFeed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Long> f253143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f253144b;

    public static final class a {
        public static long b() {
            return MoltenFfiLibLarkBizFeed.f253143a.getValue().longValue();
        }

        public static ByteString a(m r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            g r101 = MoltenFfiLibLarkBizFeed.f253144b;
            if (r101 != null) goto L5;
            return null;
        L5:
            byte[] r102 = r101.a(r100);
            if (r102 != null) goto L8;
            return null;
        L8:
            return ByteString.a.e(ByteString.Companion, r102);
        }

        public static void c(Object r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            g r101 = MoltenFfiLibLarkBizFeed.f253144b;
            if (r101 != null) goto L7;
            return;
        L7:
            r101.onInvokeeEnd(r100);
        }

        public static Object d(ByteString r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            g r101 = MoltenFfiLibLarkBizFeed.f253144b;
            if (r101 != null) goto L9;
            return null;
        L9:
            return r101.onInvokeeStart(r100.toByteArray());
        }
    }

    public MoltenFfiLibLarkBizFeed() {
    }

    @JvmStatic
    public static final native long molten_ffi_init(long r100, Class<?> r101);

    @JvmStatic
    public static final native byte[] molten_ffi_lark_biz_feed_call(long r100, long r101, long r102, byte[] r103);

    @JvmStatic
    public static final native void molten_ffi_lark_biz_feed_free(long r100, long r101, long r102);

    static {
        monitor-enter(s0.class);
        String r100 = System.getProperty("molten_ffi.lark_biz_feed.lib_name");     // Catch: Throwable -> L10
        if (r100 != null) goto L7;
        r100 = "lark";
    L7:
        monitor-exit(s0.class);
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
        f253143a = LazyKt.lazy(MoltenFfiLibLarkBizFeed$Companion$runtime$2.INSTANCE);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
