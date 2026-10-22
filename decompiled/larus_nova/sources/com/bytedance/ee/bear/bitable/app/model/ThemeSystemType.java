package com.bytedance.ee.bear.bitable.app.model;

import faceverify.w;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/app/model/ThemeSystemType;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", ThemeType.DEFAULT_THEME_SYSTEM_TYPE, w.SUB_TYPE_DARK, "Default", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThemeSystemType extends Enum<ThemeSystemType> {
    public static final a Companion = null;
    public static final String DEFAULT_THEME_SYSTEM_TYPE = "Default";
    public static final ThemeSystemType Dark = null;
    public static final ThemeSystemType Default = null;
    public static final ThemeSystemType Light = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemeSystemType[] f206947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206948b = null;
    private final String rawValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ThemeSystemType> getEntries() {
        return f206948b;
    }

    static {
        ThemeSystemType r100 = new ThemeSystemType(ThemeType.DEFAULT_THEME_SYSTEM_TYPE, 0, ThemeType.DEFAULT_THEME_SYSTEM_TYPE);
        Light = r100;
        ThemeSystemType r101 = new ThemeSystemType(w.SUB_TYPE_DARK, 1, w.SUB_TYPE_DARK);
        Dark = r101;
        ThemeSystemType r102 = new ThemeSystemType("Default", 2, "Default");
        Default = r102;
        ThemeSystemType[] r103 = {r100, r101, r102};
        f206947a = r103;
        f206948b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ThemeSystemType[] values() {
        return (ThemeSystemType[]) f206947a.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public static ThemeSystemType valueOf(String r100) {
        return (ThemeSystemType) r27.a.a(ThemeSystemType.class, r100);
    }

    public ThemeSystemType(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
