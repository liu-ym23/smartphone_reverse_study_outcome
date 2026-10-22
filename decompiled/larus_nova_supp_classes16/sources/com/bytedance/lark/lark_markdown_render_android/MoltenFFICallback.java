package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MoltenFFICallback;", "", "callbackObj", "getCallbackObj", "()Ljava/lang/Object;", "onInvoke", "", "methodId", "", "params", "onInvokeAsync", "", "sender", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MoltenFFICallback {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onInvokeAsync(MoltenFFICallback r0, long r1, long r3, byte[] r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            throw new RuntimeException("onInvokeAsync not implemented");
        }
    }

    Object getCallbackObj();

    byte[] onInvoke(long r1, byte[] r3);

    void onInvokeAsync(long r1, long r3, byte[] r5);
}
