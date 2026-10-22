package com.bytedance.kmp.network.multinet;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/network/multinet/MultiNetStateValue;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "STOPPED", "NO_NETWORK", "DEFAULT_CELLULAR_WITH_WIFI_DOWN", "DEFAULT_WIFI_WITH_CELLULAR_DOWN", "DEFAULT_WIFI_WITH_CELLULAR_UP", "DEFAULT_VPN", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum MultiNetStateValue extends Enum<MultiNetStateValue> {
    public static final a Companion = null;
    public static final MultiNetStateValue DEFAULT_CELLULAR_WITH_WIFI_DOWN = null;
    public static final MultiNetStateValue DEFAULT_VPN = null;
    public static final MultiNetStateValue DEFAULT_WIFI_WITH_CELLULAR_DOWN = null;
    public static final MultiNetStateValue DEFAULT_WIFI_WITH_CELLULAR_UP = null;
    public static final MultiNetStateValue NO_NETWORK = null;
    public static final MultiNetStateValue STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Map<Integer, MultiNetStateValue>> f252531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ MultiNetStateValue[] f252532b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static MultiNetStateValue valueOf(String r100) {
        return (MultiNetStateValue) r27.a.a(MultiNetStateValue.class, r100);
    }

    public static MultiNetStateValue[] values() {
        return (MultiNetStateValue[]) f252532b.clone();
    }

    static {
        MultiNetStateValue r100 = new MultiNetStateValue("STOPPED", 0, -1);
        STOPPED = r100;
        MultiNetStateValue r101 = new MultiNetStateValue("NO_NETWORK", 1, 0);
        NO_NETWORK = r101;
        MultiNetStateValue r102 = new MultiNetStateValue("DEFAULT_CELLULAR_WITH_WIFI_DOWN", 2, 1);
        DEFAULT_CELLULAR_WITH_WIFI_DOWN = r102;
        MultiNetStateValue r103 = new MultiNetStateValue("DEFAULT_WIFI_WITH_CELLULAR_DOWN", 3, 2);
        DEFAULT_WIFI_WITH_CELLULAR_DOWN = r103;
        MultiNetStateValue r104 = new MultiNetStateValue("DEFAULT_WIFI_WITH_CELLULAR_UP", 4, 3);
        DEFAULT_WIFI_WITH_CELLULAR_UP = r104;
        MultiNetStateValue r105 = new MultiNetStateValue("DEFAULT_VPN", 5, 5);
        DEFAULT_VPN = r105;
        f252532b = new MultiNetStateValue[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
        f252531a = LazyKt.lazy(MultiNetStateValue$Companion$valueMap$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getValueMap$delegate$cp() {
        return f252531a;
    }

    public final int getValue() {
        return this.value;
    }

    public MultiNetStateValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
