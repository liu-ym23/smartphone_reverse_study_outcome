package com.bytedance.bdturing.setting;

import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/bdturing/setting/Region;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CN", "SINGAPOER", "USA_EAST", "INDIA", "BOE", "setting_cnRelease"}, k = 1, mv = {1, 6, 0})
public final enum Region extends Enum<Region> {
    public static final Region BOE = null;
    public static final Region CN = null;
    public static final Region INDIA = null;
    public static final Region SINGAPOER = null;
    public static final Region USA_EAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Region[] f202075a = null;
    private final String value;

    public static Region valueOf(String r100) {
        return (Region) r27.a.a(Region.class, r100);
    }

    public static Region[] values() {
        return (Region[]) f202075a.clone();
    }

    static {
        Region r100 = new Region("CN", 0, "cn");
        CN = r100;
        Region r101 = new Region("SINGAPOER", 1, EnvConst$GEO.SG);
        SINGAPOER = r101;
        Region r102 = new Region("USA_EAST", 2, "va");
        USA_EAST = r102;
        Region r103 = new Region("INDIA", 3, "in");
        INDIA = r103;
        Region r104 = new Region("BOE", 4, "boe");
        BOE = r104;
        f202075a = new Region[]{r100, r101, r102, r103, r104};
    }

    public final String getValue() {
        return this.value;
    }

    public Region(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
