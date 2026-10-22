package yc6;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f567175a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f567176b = null;

    static {
        f567175a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(e.class, "GIFT_LAST_SEND_GIFT_ID", "getGIFT_LAST_SEND_GIFT_ID()Ljava/lang/String;", 1))};
        f567176b = SpongePreferenceManager.a().a("gift_last_send_gift_id", "0", String.class);
    }
}
