package com.bytedance.ee.bear.bitable.app.model;

import faceverify.w;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/model/ThemeType;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", ThemeType.DEFAULT_THEME_SYSTEM_TYPE, w.SUB_TYPE_DARK, "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThemeType extends Enum<ThemeType> {
    public static final a Companion = null;
    public static final String DEFAULT_THEME_SYSTEM_TYPE = "Light";
    public static final ThemeType Dark = null;
    public static final ThemeType Light = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemeType[] f206949a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206950b = null;
    private final String rawValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ThemeType> getEntries() {
        return f206950b;
    }

    static {
        ThemeType r100 = new ThemeType(DEFAULT_THEME_SYSTEM_TYPE, 0, DEFAULT_THEME_SYSTEM_TYPE);
        Light = r100;
        ThemeType r101 = new ThemeType(w.SUB_TYPE_DARK, 1, w.SUB_TYPE_DARK);
        Dark = r101;
        ThemeType[] r102 = {r100, r101};
        f206949a = r102;
        f206950b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ThemeType[] values() {
        return (ThemeType[]) f206949a.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public static ThemeType valueOf(String r100) {
        return (ThemeType) r27.a.a(ThemeType.class, r100);
    }

    public ThemeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
