package io.ktor.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/util/Platform;", "", "Jvm", "Native", "Browser", "Node", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final enum Platform extends Enum<Platform> {
    public static final Platform Browser = null;
    public static final Platform Jvm = null;
    public static final Platform Native = null;
    public static final Platform Node = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Platform[] f491943a = null;

    public static Platform valueOf(String r100) {
        return (Platform) r27.a.a(Platform.class, r100);
    }

    public static Platform[] values() {
        return (Platform[]) f491943a.clone();
    }

    static {
        Platform r100 = new Platform("Jvm", 0);
        Jvm = r100;
        Platform r101 = new Platform("Native", 1);
        Native = r101;
        Platform r102 = new Platform("Browser", 2);
        Browser = r102;
        Platform r103 = new Platform("Node", 3);
        Node = r103;
        f491943a = new Platform[]{r100, r101, r102, r103};
    }

    public Platform(String r100, int r101) {
        super(r100, r101);
    }
}
