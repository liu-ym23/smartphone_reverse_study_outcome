package com.ss.android.lark.integrator.security.compliance.export;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/integrator/security/compliance/export/OfficeSDKLgwHeaderKey;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "UNKNOWN", "LOCALE", "APP_VERSION", "SEC_TOKEN", "TERMINAL_TYPE", "USER_ID", "DEVICE_ID", "INSTALL_ID", "APP_ID", "OS_VERSION", "DEVICE_TYPE", "OS_TYPE", "APP_CHANNEL", "DEVICE_BRAND", "APP_VERSION_EXT", "androidFixedValue", "getAndroidFixedValue", "Companion", "security-compliance-assembly-officesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSDKLgwHeaderKey extends Enum<OfficeSDKLgwHeaderKey> {
    public static final OfficeSDKLgwHeaderKey APP_CHANNEL = null;
    public static final OfficeSDKLgwHeaderKey APP_ID = null;
    public static final OfficeSDKLgwHeaderKey APP_VERSION = null;
    public static final OfficeSDKLgwHeaderKey APP_VERSION_EXT = null;
    public static final a Companion = null;
    public static final OfficeSDKLgwHeaderKey DEVICE_BRAND = null;
    public static final OfficeSDKLgwHeaderKey DEVICE_ID = null;
    public static final OfficeSDKLgwHeaderKey DEVICE_TYPE = null;
    public static final OfficeSDKLgwHeaderKey INSTALL_ID = null;
    public static final OfficeSDKLgwHeaderKey LOCALE = null;
    public static final OfficeSDKLgwHeaderKey OS_TYPE = null;
    public static final OfficeSDKLgwHeaderKey OS_VERSION = null;
    public static final OfficeSDKLgwHeaderKey SEC_TOKEN = null;
    public static final OfficeSDKLgwHeaderKey TERMINAL_TYPE = null;
    public static final OfficeSDKLgwHeaderKey UNKNOWN = null;
    public static final OfficeSDKLgwHeaderKey USER_ID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<OfficeSDKLgwHeaderKey, String> f428067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ OfficeSDKLgwHeaderKey[] f428068b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428069c = null;
    private final String rawValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OfficeSDKLgwHeaderKey> getEntries() {
        return f428069c;
    }

    static {
        OfficeSDKLgwHeaderKey r100 = new OfficeSDKLgwHeaderKey("UNKNOWN", 0, "");
        UNKNOWN = r100;
        OfficeSDKLgwHeaderKey r101 = new OfficeSDKLgwHeaderKey("LOCALE", 1, "x-lgw-locale");
        LOCALE = r101;
        OfficeSDKLgwHeaderKey r102 = new OfficeSDKLgwHeaderKey("APP_VERSION", 2, "x-lgw-app-version");
        APP_VERSION = r102;
        OfficeSDKLgwHeaderKey r103 = new OfficeSDKLgwHeaderKey("SEC_TOKEN", 3, "x-lgw-sec-token");
        SEC_TOKEN = r103;
        OfficeSDKLgwHeaderKey r104 = new OfficeSDKLgwHeaderKey("TERMINAL_TYPE", 4, "x-lgw-terminal-type");
        TERMINAL_TYPE = r104;
        OfficeSDKLgwHeaderKey r105 = new OfficeSDKLgwHeaderKey("USER_ID", 5, "x-lgw-user-id");
        USER_ID = r105;
        OfficeSDKLgwHeaderKey r110 = new OfficeSDKLgwHeaderKey("DEVICE_ID", 6, "x-lgw-device-id");
        DEVICE_ID = r110;
        OfficeSDKLgwHeaderKey r111 = new OfficeSDKLgwHeaderKey("INSTALL_ID", 7, "x-lgw-install-id");
        INSTALL_ID = r111;
        OfficeSDKLgwHeaderKey r112 = new OfficeSDKLgwHeaderKey("APP_ID", 8, "x-lgw-app-id");
        APP_ID = r112;
        OfficeSDKLgwHeaderKey r113 = new OfficeSDKLgwHeaderKey("OS_VERSION", 9, "x-lgw-os-version");
        OS_VERSION = r113;
        OfficeSDKLgwHeaderKey r106 = new OfficeSDKLgwHeaderKey("DEVICE_TYPE", 10, "x-lgw-device-type");
        DEVICE_TYPE = r106;
        OfficeSDKLgwHeaderKey r107 = new OfficeSDKLgwHeaderKey("OS_TYPE", 11, "x-lgw-os-type");
        OS_TYPE = r107;
        OfficeSDKLgwHeaderKey r108 = new OfficeSDKLgwHeaderKey("APP_CHANNEL", 12, "x-lgw-app-channel");
        APP_CHANNEL = r108;
        OfficeSDKLgwHeaderKey r109 = new OfficeSDKLgwHeaderKey("DEVICE_BRAND", 13, "x-lgw-device-brand");
        DEVICE_BRAND = r109;
        OfficeSDKLgwHeaderKey r114 = new OfficeSDKLgwHeaderKey("APP_VERSION_EXT", 14, "x-lgw-app-version-ext");
        APP_VERSION_EXT = r114;
        OfficeSDKLgwHeaderKey[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114};
        f428068b = r115;
        f428069c = EnumEntriesKt.enumEntries(r115);
        Companion = new a();
        f428067a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r107, "4"), TuplesKt.to(r104, "3")});
    }

    public static OfficeSDKLgwHeaderKey[] values() {
        return (OfficeSDKLgwHeaderKey[]) f428068b.clone();
    }

    public final String getAndroidFixedValue() {
        return f428067a.get(this);
    }

    public static final /* synthetic */ Map access$getAndroidFixedHeaders$cp() {
        return f428067a;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public static OfficeSDKLgwHeaderKey valueOf(String r100) {
        return (OfficeSDKLgwHeaderKey) r27.a.a(OfficeSDKLgwHeaderKey.class, r100);
    }

    public OfficeSDKLgwHeaderKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
