package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/CallbackEntry;", "", "()V", "Companion", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallbackEntry {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/CallbackEntry$Companion;", "", "()V", AbsMethodDelegate.TAG_INVOKE, "", "instanceId", "", "methodId", "params", "invokeAsync", "", "sender", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final byte[] invoke(long r100, long r101, byte[] r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            CallbackInstance r102 = CallbackInstance.INSTANCE;
            MoltenFFICallback r103 = r102.getInstance(r100);
            if (r103 == null) goto L12;
            if (r101 != 0) goto L8;
            r102.unregisterInstance(r100);
            return new byte[0];
        L8:
            byte[] r104 = r103.onInvoke(r101, r110);
            if (r104 == null) goto L12;
            return r104;
        L12:
            throw new RuntimeException("No registered callback<InstanceId(" + r100 + ")>");
        }

        @JvmStatic
        public final void invokeAsync(long r100, long r110, long r111, byte[] r112) {
            Intrinsics.checkNotNullParameter(r112, "params");
            MoltenFFICallback r101 = CallbackInstance.INSTANCE.getInstance(r110);
            if (r101 == null) goto L5;
            r101.onInvokeAsync(r100, r111, r112);
            Unit r102 = Unit.INSTANCE;
        L6:
            if (r102 == null) goto L9;
            return;
        L9:
            throw new RuntimeException("No registered callback<InstanceId(" + r110 + ")>");
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CallbackEntry() {
    }

    @JvmStatic
    public static final byte[] invoke(long r100, long r101, byte[] r110) {
        return Companion.invoke(r100, r101, r110);
    }

    @JvmStatic
    public static final void invokeAsync(long r100, long r110, long r111, byte[] r112) {
        Companion.invokeAsync(r100, r110, r111, r112);
    }
}
