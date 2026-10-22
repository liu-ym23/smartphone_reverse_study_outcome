package com.ss.android.rust.lark_fg;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/rust/lark_fg/LarkFg;", "", "<init>", "()V", "Companion", "lark-fg_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkFg {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0087 ¨\u0006\t"}, d2 = {"Lcom/ss/android/rust/lark_fg/LarkFg$Companion;", "", "<init>", "()V", "getImmutableFeatureGating", "", "userId", "", "key", "lark-fg_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final boolean getImmutableFeatureGating(String r100, String r101) throws Exception {
            return LarkFg.getImmutableFeatureGating(r100, r101);
        }
    }

    public LarkFg() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    @JvmStatic
    public static final native boolean getImmutableFeatureGating(String r100, String r101) throws Exception;

    static {
        Companion = new Companion(null);
        INVOKESTATIC_com_ss_android_rust_lark_fg_LarkFg_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lark");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_android_rust_lark_fg_LarkFg_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
