package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/CallbackEntry;", "", "()V", "Companion", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallbackEntry {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/CallbackEntry$Companion;", "", "()V", "invoke", "", "instanceId", "", "methodId", "params", "invokeAsync", "", "sender", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final byte[] invoke(long r6, long r8, byte[] r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            CallbackInstance r0 = CallbackInstance.INSTANCE;
            MoltenFFICallback r1 = r0.getInstance(r6);
            if (r1 == null) goto L12;
            if (r8 != 0) goto L8;
            r0.unregisterInstance(r6);
            return new byte[0];
        L8:
            byte[] r9 = r1.onInvoke(r8, r10);
            if (r9 == null) goto L12;
            return r9;
        L12:
            throw new RuntimeException("No registered callback<InstanceId(" + r6 + ")>");
        }

        @JvmStatic
        public final void invokeAsync(long r8, long r10, long r12, byte[] r14) {
            Intrinsics.checkNotNullParameter(r14, "params");
            MoltenFFICallback r1 = CallbackInstance.INSTANCE.getInstance(r10);
            if (r1 == null) goto L5;
            r1.onInvokeAsync(r8, r12, r14);
            Unit r9 = Unit.INSTANCE;
        L6:
            if (r9 == null) goto L9;
            return;
        L9:
            throw new RuntimeException("No registered callback<InstanceId(" + r10 + ")>");
        L5:
            r9 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CallbackEntry() {
    }

    @JvmStatic
    public static final byte[] invoke(long r6, long r8, byte[] r10) {
        return Companion.invoke(r6, r8, r10);
    }

    @JvmStatic
    public static final void invokeAsync(long r8, long r10, long r12, byte[] r14) {
        Companion.invokeAsync(r8, r10, r12, r14);
    }
}
