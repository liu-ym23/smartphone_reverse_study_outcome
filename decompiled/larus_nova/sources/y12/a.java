package y12;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f565620b = null;

    static {
        f565619a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(a.class, "VS_BLOCK_GIFT_FOR_TEST", "getVS_BLOCK_GIFT_FOR_TEST()Z", 1))};
        f565620b = SpongePreferenceManager.a().a("vs_block_gift_for_test", Boolean.FALSE, Boolean.TYPE);
    }
}
