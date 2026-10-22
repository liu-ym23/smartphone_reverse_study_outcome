package com.bytedance.caijing.sdk.infra.base.api.plugin.container.xelement.keyboard;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/xelement/keyboard/Theme;", "", "", "theme", "Ljava/lang/String;", "getTheme", "()Ljava/lang/String;", "LIGHT", "NIGHT", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum Theme extends Enum<Theme> {
    public static final Theme LIGHT = null;
    public static final Theme NIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Theme[] f202240a = null;
    private final String theme;

    public static Theme valueOf(String r100) {
        return (Theme) a.a(Theme.class, r100);
    }

    public static Theme[] values() {
        return (Theme[]) f202240a.clone();
    }

    static {
        Theme r100 = new Theme("LIGHT", 0, "light");
        LIGHT = r100;
        Theme r101 = new Theme("NIGHT", 1, "night");
        NIGHT = r101;
        f202240a = new Theme[]{r100, r101};
    }

    public final String getTheme() {
        return this.theme;
    }

    public Theme(String r100, int r101, String r102) {
        super(r100, r101);
        this.theme = r102;
    }
}
