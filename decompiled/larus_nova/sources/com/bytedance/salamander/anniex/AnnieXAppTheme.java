package com.bytedance.salamander.anniex;

import com.bytedance.ee.bear.bitable.app.model.ThemeType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXAppTheme;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", ThemeType.DEFAULT_THEME_SYSTEM_TYPE, faceverify.w.SUB_TYPE_DARK, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXAppTheme extends Enum<AnnieXAppTheme> {
    public static final AnnieXAppTheme Dark = null;
    public static final AnnieXAppTheme Light = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXAppTheme[] f267806a = null;
    private final String value;

    public static AnnieXAppTheme valueOf(String r100) {
        return (AnnieXAppTheme) r27.a.a(AnnieXAppTheme.class, r100);
    }

    public static AnnieXAppTheme[] values() {
        return (AnnieXAppTheme[]) f267806a.clone();
    }

    static {
        AnnieXAppTheme r100 = new AnnieXAppTheme(ThemeType.DEFAULT_THEME_SYSTEM_TYPE, 0, "light");
        Light = r100;
        AnnieXAppTheme r101 = new AnnieXAppTheme(faceverify.w.SUB_TYPE_DARK, 1, "dark");
        Dark = r101;
        f267806a = new AnnieXAppTheme[]{r100, r101};
    }

    public final String getValue() {
        return this.value;
    }

    public AnnieXAppTheme(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
