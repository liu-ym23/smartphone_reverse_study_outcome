package com.ss.android.lark.im.sdk.proxy.builtin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okb.i;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/ss/android/lark/im/sdk/proxy/builtin/BuiltinStorageProxy$kvStoreOfUser$2$1", AbsMethodDelegate.TAG_INVOKE, "()Lcom/ss/android/lark/im/sdk/proxy/builtin/BuiltinStorageProxy$kvStoreOfUser$2$1;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BuiltinStorageProxy$kvStoreOfUser$2 extends Lambda implements Function0<a> {
    public static final BuiltinStorageProxy$kvStoreOfUser$2 INSTANCE = null;

    public static final class a implements i {
        public a() {
        }

        @Override // okb.i
        public final int a() {
            Intrinsics.checkNotNullParameter("key_translate_times_new", "key");
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // okb.i
        public final boolean e() {
            Intrinsics.checkNotNullParameter("android_file_upload_file_descriptor_config", "key");
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // okb.i
        public final String getString() {
            Intrinsics.checkNotNullParameter("chatter_info", "key");
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // okb.i
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter("chatter_info", "key");
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // okb.i
        public final void putInt(int r100) {
            Intrinsics.checkNotNullParameter("key_translate_times_new", "key");
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }
    }

    static {
        INSTANCE = new BuiltinStorageProxy$kvStoreOfUser$2();
    }

    public BuiltinStorageProxy$kvStoreOfUser$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return new a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
