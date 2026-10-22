package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/SettingsScope;", "", "", "value", "I", "getValue", "()I", "Common", "ANNIEX_SL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SettingsScope extends Enum<SettingsScope> {
    public static final SettingsScope ANNIEX_SL = null;
    public static final SettingsScope Common = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SettingsScope[] f267922a = null;
    private final int value;

    public static SettingsScope valueOf(String r100) {
        return (SettingsScope) r27.a.a(SettingsScope.class, r100);
    }

    public static SettingsScope[] values() {
        return (SettingsScope[]) f267922a.clone();
    }

    static {
        SettingsScope r100 = new SettingsScope("Common", 0, 0);
        Common = r100;
        SettingsScope r101 = new SettingsScope("ANNIEX_SL", 1, 1);
        ANNIEX_SL = r101;
        f267922a = new SettingsScope[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public SettingsScope(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
