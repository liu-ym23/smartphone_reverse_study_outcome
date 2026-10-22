package com.bytedance.lark.office_sdk_im_android;

import com.alipay.sdk.m.p.e;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/MoltenFfiLibOfficeSdkIm;", "", "()V", "Companion", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MoltenFfiLibOfficeSdkIm {
    public static final Companion Companion = null;
    private static ContextHook contextHook;
    private static final Lazy<Long> runtime$delegate = null;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001d\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0087 J1\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0087 J)\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0087 J!\u0010 \u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0087 J\u0010\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0001J\u0012\u0010#\u001a\u0004\u0018\u00010\u00012\b\u0010$\u001a\u0004\u0018\u00010\u0011R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/MoltenFfiLibOfficeSdkIm$Companion;", "", "()V", "<set-?>", "Lcom/bytedance/lark/office_sdk_im_android/ContextHook;", "contextHook", "getContextHook", "()Lcom/bytedance/lark/office_sdk_im_android/ContextHook;", "setContextHook$office_sdk_im_android_release", "(Lcom/bytedance/lark/office_sdk_im_android/ContextHook;)V", "runtime", "", "getRuntime$office_sdk_im_android_release", "()J", "runtime$delegate", "Lkotlin/Lazy;", "buildExtra", "Lokio/ByteString;", "info", "Lcom/bytedance/lark/office_sdk_im_android/InvokeHookInfo;", "molten_ffi_init", "library_id", "callback_entry", "Ljava/lang/Class;", "molten_ffi_office_sdk_im_async_call", "", "cont", "instance", e.f25671s, "params", "", "molten_ffi_office_sdk_im_call", "molten_ffi_office_sdk_im_free", "onInvokeeEnd", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "onInvokeeStart", "buf", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final long molten_ffi_init(long r100, Class<?> r101) {
            return MoltenFfiLibOfficeSdkIm.molten_ffi_init(r100, r101);
        }

        @JvmStatic
        public final void molten_ffi_office_sdk_im_async_call(long r100, long r101, long r102, long r103, byte[] r104) {
            MoltenFfiLibOfficeSdkIm.molten_ffi_office_sdk_im_async_call(r100, r101, r102, r103, r104);
        }

        @JvmStatic
        public final byte[] molten_ffi_office_sdk_im_call(long r100, long r101, long r102, byte[] r103) {
            return MoltenFfiLibOfficeSdkIm.molten_ffi_office_sdk_im_call(r100, r101, r102, r103);
        }

        @JvmStatic
        public final void molten_ffi_office_sdk_im_free(long r100, long r101, long r102) {
            MoltenFfiLibOfficeSdkIm.molten_ffi_office_sdk_im_free(r100, r101, r102);
        }

        public final ContextHook getContextHook() {
            return MoltenFfiLibOfficeSdkIm.access$getContextHook$cp();
        }

        public final long getRuntime$office_sdk_im_android_release() {
            return ((Number) MoltenFfiLibOfficeSdkIm.access$getRuntime$delegate$cp().getValue()).longValue();
        }

        public final ByteString buildExtra(InvokeHookInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            ContextHook r101 = getContextHook();
            if (r101 != null) goto L5;
            return null;
        L5:
            byte[] r102 = r101.onInvoke(r100);
            if (r102 != null) goto L8;
            return null;
        L8:
            return ByteString.a.e(ByteString.Companion, r102);
        }

        public final void onInvokeeEnd(Object r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            ContextHook r101 = getContextHook();
            if (r101 != null) goto L7;
            return;
        L7:
            r101.onInvokeeEnd(r100);
        }

        public final Object onInvokeeStart(ByteString r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            ContextHook r101 = getContextHook();
            if (r101 != null) goto L9;
            return null;
        L9:
            return r101.onInvokeeStart(r100.toByteArray());
        }

        public final void setContextHook$office_sdk_im_android_release(ContextHook r100) {
            MoltenFfiLibOfficeSdkIm.access$setContextHook$cp(r100);
        }
    }

    private MoltenFfiLibOfficeSdkIm() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    @JvmStatic
    public static final native long molten_ffi_init(long r100, Class<?> r101);

    @JvmStatic
    public static final native void molten_ffi_office_sdk_im_async_call(long r100, long r101, long r102, long r103, byte[] r104);

    @JvmStatic
    public static final native byte[] molten_ffi_office_sdk_im_call(long r100, long r101, long r102, byte[] r103);

    @JvmStatic
    public static final native void molten_ffi_office_sdk_im_free(long r100, long r101, long r102);

    static {
        Companion = new Companion(null);
        INVOKESTATIC_com_bytedance_lark_office_sdk_im_android_MoltenFfiLibOfficeSdkIm_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(Office_sdk_imKt.access$findLibraryName("office_sdk_im"));
        runtime$delegate = LazyKt.lazy(MoltenFfiLibOfficeSdkIm$Companion$runtime$2.INSTANCE);
    }

    public static final /* synthetic */ ContextHook access$getContextHook$cp() {
        return contextHook;
    }

    public static final /* synthetic */ Lazy access$getRuntime$delegate$cp() {
        return runtime$delegate;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_lark_office_sdk_im_android_MoltenFfiLibOfficeSdkIm_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static final /* synthetic */ void access$setContextHook$cp(ContextHook r100) {
        contextHook = r100;
    }
}
