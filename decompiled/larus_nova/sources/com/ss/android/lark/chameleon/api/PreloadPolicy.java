package com.ss.android.lark.chameleon.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/api/PreloadPolicy;", "", "(Ljava/lang/String;I)V", "NO_PRELOAD", "PRELOAD_EMPTY_WEBVIEW", "PRELOAD_BIZ_HTML", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum PreloadPolicy extends Enum<PreloadPolicy> {
    private static final /* synthetic */ PreloadPolicy[] $VALUES = null;
    public static final PreloadPolicy NO_PRELOAD = null;
    public static final PreloadPolicy PRELOAD_BIZ_HTML = null;
    public static final PreloadPolicy PRELOAD_EMPTY_WEBVIEW = null;

    private static final /* synthetic */ PreloadPolicy[] $values() {
        return new PreloadPolicy[]{NO_PRELOAD, PRELOAD_EMPTY_WEBVIEW, PRELOAD_BIZ_HTML};
    }

    public static PreloadPolicy valueOf(String r100) {
        return (PreloadPolicy) a.a(PreloadPolicy.class, r100);
    }

    public static PreloadPolicy[] values() {
        return (PreloadPolicy[]) $VALUES.clone();
    }

    static {
        NO_PRELOAD = new PreloadPolicy("NO_PRELOAD", 0);
        PRELOAD_EMPTY_WEBVIEW = new PreloadPolicy("PRELOAD_EMPTY_WEBVIEW", 1);
        PRELOAD_BIZ_HTML = new PreloadPolicy("PRELOAD_BIZ_HTML", 2);
        $VALUES = $values();
    }

    private PreloadPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
