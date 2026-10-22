package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MoltenFfiLibLarkMarkdownRender;", "", "()V", "Companion", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MoltenFfiLibLarkMarkdownRender {
    public static final Companion Companion = null;
    private static ContextHook contextHook;
    private static final Lazy<Long> runtime$delegate = null;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001d\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0087 J)\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0087 J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0087 J\u0010\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0001J\u0012\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0011R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MoltenFfiLibLarkMarkdownRender$Companion;", "", "()V", "<set-?>", "Lcom/bytedance/lark/lark_markdown_render_android/ContextHook;", "contextHook", "getContextHook", "()Lcom/bytedance/lark/lark_markdown_render_android/ContextHook;", "setContextHook$lark_markdown_render_android_release", "(Lcom/bytedance/lark/lark_markdown_render_android/ContextHook;)V", "runtime", "", "getRuntime$lark_markdown_render_android_release", "()J", "runtime$delegate", "Lkotlin/Lazy;", "buildExtra", "Lokio/ByteString;", "info", "Lcom/bytedance/lark/lark_markdown_render_android/InvokeHookInfo;", "molten_ffi_init", "library_id", "callback_entry", "Ljava/lang/Class;", "molten_ffi_lark_markdown_render_call", "", "instance", "method", "params", "molten_ffi_lark_markdown_render_free", "", "onInvokeeEnd", "obj", "onInvokeeStart", "buf", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final long molten_ffi_init(long r1, Class<?> r3) {
            return MoltenFfiLibLarkMarkdownRender.molten_ffi_init(r1, r3);
        }

        @JvmStatic
        public final byte[] molten_ffi_lark_markdown_render_call(long r1, long r3, long r5, byte[] r7) {
            return MoltenFfiLibLarkMarkdownRender.molten_ffi_lark_markdown_render_call(r1, r3, r5, r7);
        }

        @JvmStatic
        public final void molten_ffi_lark_markdown_render_free(long r1, long r3, long r5) {
            MoltenFfiLibLarkMarkdownRender.molten_ffi_lark_markdown_render_free(r1, r3, r5);
        }

        public final ContextHook getContextHook() {
            return MoltenFfiLibLarkMarkdownRender.access$getContextHook$cp();
        }

        public final long getRuntime$lark_markdown_render_android_release() {
            return ((Number) MoltenFfiLibLarkMarkdownRender.access$getRuntime$delegate$cp().getValue()).longValue();
        }

        public final ByteString buildExtra(InvokeHookInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "info");
            ContextHook r0 = getContextHook();
            if (r0 != null) goto L5;
            return null;
        L5:
            byte[] r4 = r0.onInvoke(r3);
            if (r4 != null) goto L8;
            return null;
        L8:
            return ByteString.a.e(ByteString.Companion, r4);
        }

        public final void onInvokeeEnd(Object r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            ContextHook r0 = getContextHook();
            if (r0 != null) goto L7;
            return;
        L7:
            r0.onInvokeeEnd(r2);
        }

        public final Object onInvokeeStart(ByteString r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            ContextHook r1 = getContextHook();
            if (r1 != null) goto L9;
            return null;
        L9:
            return r1.onInvokeeStart(r3.toByteArray());
        }

        public final void setContextHook$lark_markdown_render_android_release(ContextHook r1) {
            MoltenFfiLibLarkMarkdownRender.access$setContextHook$cp(r1);
        }
    }

    private MoltenFfiLibLarkMarkdownRender() {
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    @JvmStatic
    public static final native long molten_ffi_init(long r0, Class<?> r2);

    @JvmStatic
    public static final native byte[] molten_ffi_lark_markdown_render_call(long r0, long r2, long r4, byte[] r6);

    @JvmStatic
    public static final native void molten_ffi_lark_markdown_render_free(long r0, long r2, long r4);

    static {
        Companion = new Companion(null);
        INVOKESTATIC_com_bytedance_lark_lark_markdown_render_android_MoltenFfiLibLarkMarkdownRender_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(Lark_markdown_renderKt.access$findLibraryName("lark_markdown_render"));
        runtime$delegate = LazyKt.lazy(MoltenFfiLibLarkMarkdownRender$Companion$runtime$2.INSTANCE);
    }

    public static final /* synthetic */ ContextHook access$getContextHook$cp() {
        return contextHook;
    }

    public static final /* synthetic */ Lazy access$getRuntime$delegate$cp() {
        return runtime$delegate;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_lark_lark_markdown_render_android_MoltenFfiLibLarkMarkdownRender_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static final /* synthetic */ void access$setContextHook$cp(ContextHook r0) {
        contextHook = r0;
    }
}
