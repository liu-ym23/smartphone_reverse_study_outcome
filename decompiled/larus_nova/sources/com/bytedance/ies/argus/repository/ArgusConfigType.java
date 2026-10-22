package com.bytedance.ies.argus.repository;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusConfigType;", "", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "geckoChannelName", "getGeckoChannelName", "GLOBAL_CONFIG", "CONTAINER_CONFIG", "WEB_CONTENT_VERIFY_CONFIG", "FE_CONFIG_WEB", "FE_CONFIG_LYNX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusConfigType extends Enum<ArgusConfigType> {
    public static final ArgusConfigType CONTAINER_CONFIG = null;
    public static final ArgusConfigType FE_CONFIG_LYNX = null;
    public static final ArgusConfigType FE_CONFIG_WEB = null;
    public static final ArgusConfigType GLOBAL_CONFIG = null;
    public static final ArgusConfigType WEB_CONTENT_VERIFY_CONFIG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusConfigType[] f246093a = null;
    private final String geckoChannelName;
    private final String str;

    public static ArgusConfigType valueOf(String r100) {
        return (ArgusConfigType) r27.a.a(ArgusConfigType.class, r100);
    }

    public static ArgusConfigType[] values() {
        return (ArgusConfigType[]) f246093a.clone();
    }

    static {
        ArgusConfigType r100 = new ArgusConfigType("GLOBAL_CONFIG", 0, "global", "global_config");
        GLOBAL_CONFIG = r100;
        ArgusConfigType r101 = new ArgusConfigType("CONTAINER_CONFIG", 1, KtvSubElement.CONTAINER, "container_config");
        CONTAINER_CONFIG = r101;
        ArgusConfigType r102 = new ArgusConfigType("WEB_CONTENT_VERIFY_CONFIG", 2, "web_content_verify", "web_content_verify_config");
        WEB_CONTENT_VERIFY_CONFIG = r102;
        ArgusConfigType r103 = new ArgusConfigType("FE_CONFIG_WEB", 3, "fe_config_web", "fe_config_web");
        FE_CONFIG_WEB = r103;
        ArgusConfigType r104 = new ArgusConfigType("FE_CONFIG_LYNX", 4, "fe_config_lynx", "fe_config_lynx");
        FE_CONFIG_LYNX = r104;
        f246093a = new ArgusConfigType[]{r100, r101, r102, r103, r104};
    }

    public final String getGeckoChannelName() {
        return this.geckoChannelName;
    }

    public final String getStr() {
        return this.str;
    }

    public ArgusConfigType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.str = r102;
        this.geckoChannelName = r103;
    }
}
