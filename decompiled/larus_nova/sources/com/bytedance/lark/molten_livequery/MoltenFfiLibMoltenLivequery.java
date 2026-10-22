package com.bytedance.lark.molten_livequery;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0087 J)\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0087 J!\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0087 J\u0010\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$J\u0012\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010\"J\u0010\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001R\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/bytedance/lark/molten_livequery/MoltenFfiLibMoltenLivequery;", "", "<init>", "()V", "loaded", "", "getLoaded$molten_livequery_core_release", "()Lkotlin/Unit;", "loaded$delegate", "Lkotlin/Lazy;", "runtime", "", "getRuntime$molten_livequery_core_release", "()J", "runtime$delegate", "molten_ffi_init", "library_id", "callback_entry", "Ljava/lang/Class;", "molten_ffi_molten_livequery_call", "", "instance", "method_id", "params", "molten_ffi_molten_livequery_free", "pointer", "value", "Lcom/bytedance/lark/molten_livequery/ContextHook;", "contextHook", "getContextHook", "()Lcom/bytedance/lark/molten_livequery/ContextHook;", "setContextHook$molten_livequery_core_release", "(Lcom/bytedance/lark/molten_livequery/ContextHook;)V", "buildExtra", "Lokio/ByteString;", "info", "Lcom/bytedance/lark/molten_livequery/InvokeHookInfo;", "onInvokeeStart", "buf", "onInvokeeEnd", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "molten_livequery_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoltenFfiLibMoltenLivequery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MoltenFfiLibMoltenLivequery f253320a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f253321b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f253322c = null;

    public MoltenFfiLibMoltenLivequery() {
    }

    @JvmStatic
    public static final native long molten_ffi_init(long r100, Class<?> r101);

    @JvmStatic
    public static final native byte[] molten_ffi_molten_livequery_call(long r100, long r101, long r102, byte[] r103);

    @JvmStatic
    public static final native void molten_ffi_molten_livequery_free(long r100, long r101, long r102);

    static {
        f253320a = new MoltenFfiLibMoltenLivequery();
        f253321b = LazyKt.lazy(MoltenFfiLibMoltenLivequery$loaded$2.INSTANCE);
        f253322c = LazyKt.lazy(MoltenFfiLibMoltenLivequery$runtime$2.INSTANCE);
    }

    public static long a() {
        return ((Number) f253322c.getValue()).longValue();
    }
}
