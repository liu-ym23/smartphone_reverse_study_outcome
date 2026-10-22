package com.bytedance.android.shopping.store.tabkit.events;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/events/SecSettingSource;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "LIBRA_SETTING", "APP_SETTING_AWEME", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SecSettingSource extends Enum<SecSettingSource> {
    public static final SecSettingSource APP_SETTING_AWEME = null;
    public static final SecSettingSource LIBRA_SETTING = null;
    public static final /* synthetic */ SecSettingSource[] a = null;
    private final String type;

    static {
        SecSettingSource r1 = new SecSettingSource("LIBRA_SETTING", 0, "libra_setting");
        LIBRA_SETTING = r1;
        SecSettingSource r2 = new SecSettingSource("APP_SETTING_AWEME", 1, "app_setting_aweme");
        APP_SETTING_AWEME = r2;
        a = new SecSettingSource[]{r1, r2};
    }

    public static SecSettingSource valueOf(String r1) {
        return (SecSettingSource) a.a(SecSettingSource.class, r1);
    }

    public static SecSettingSource[] values() {
        return (SecSettingSource[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public SecSettingSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
