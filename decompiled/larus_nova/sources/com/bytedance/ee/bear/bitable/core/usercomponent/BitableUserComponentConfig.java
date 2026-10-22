package com.bytedance.ee.bear.bitable.core.usercomponent;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = "ccm_base_user_component_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/usercomponent/BitableUserComponentConfig;", "", "<init>", "()V", "enableStorage", "", "getEnableStorage", "()Ljava/lang/Boolean;", "setEnableStorage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableFg", "getEnableFg", "setEnableFg", "enableUserKV", "getEnableUserKV", "setEnableUserKV", "enableRustCall", "getEnableRustCall", "setEnableRustCall", "enableExtends", "getEnableExtends", "setEnableExtends", "enableHomePageSession", "getEnableHomePageSession", "setEnableHomePageSession", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableUserComponentConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<BitableUserComponentConfig> f210587a = null;

    @SerializedName("enable_extends")
    private Boolean enableExtends;

    @SerializedName("enable_fg")
    private Boolean enableFg;

    @SerializedName("enable_homepage_session")
    private Boolean enableHomePageSession;

    @SerializedName("enable_rust_call")
    private Boolean enableRustCall;

    @SerializedName("enable_storage")
    private Boolean enableStorage;

    @SerializedName("enable_user_kv")
    private Boolean enableUserKV;

    public static final class a {
    }

    public BitableUserComponentConfig() {
    }

    static {
        f210587a = LazyKt.lazy(BitableUserComponentConfig$Companion$config$2.INSTANCE);
    }
}
