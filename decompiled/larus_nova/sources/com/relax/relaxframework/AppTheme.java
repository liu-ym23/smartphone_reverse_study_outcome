package com.relax.relaxframework;

import com.bytedance.ee.bear.bitable.app.model.ThemeType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/AppTheme;", "", "", "value", "J", "getValue", "()J", ThemeType.DEFAULT_THEME_SYSTEM_TYPE, faceverify.w.SUB_TYPE_DARK, "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AppTheme extends Enum<AppTheme> {
    public static final AppTheme Dark = null;
    public static final AppTheme Light = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppTheme[] f404673a = null;
    private final long value;

    public static AppTheme valueOf(String r100) {
        return (AppTheme) r27.a.a(AppTheme.class, r100);
    }

    public static AppTheme[] values() {
        return (AppTheme[]) f404673a.clone();
    }

    static {
        AppTheme r100 = new AppTheme(ThemeType.DEFAULT_THEME_SYSTEM_TYPE, 0, 0);
        Light = r100;
        AppTheme r101 = new AppTheme(faceverify.w.SUB_TYPE_DARK, 1, 1);
        Dark = r101;
        f404673a = new AppTheme[]{r100, r101};
    }

    public final long getValue() {
        return this.value;
    }

    public AppTheme(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
