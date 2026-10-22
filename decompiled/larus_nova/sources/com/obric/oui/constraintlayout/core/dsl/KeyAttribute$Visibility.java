package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyAttribute$Visibility extends Enum<KeyAttribute$Visibility> {
    public static final KeyAttribute$Visibility GONE = null;
    public static final KeyAttribute$Visibility INVISIBLE = null;
    public static final KeyAttribute$Visibility VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttribute$Visibility[] f399665a = null;

    static {
        KeyAttribute$Visibility r100 = new KeyAttribute$Visibility("VISIBLE", 0);
        VISIBLE = r100;
        KeyAttribute$Visibility r101 = new KeyAttribute$Visibility("INVISIBLE", 1);
        INVISIBLE = r101;
        KeyAttribute$Visibility r102 = new KeyAttribute$Visibility("GONE", 2);
        GONE = r102;
        f399665a = new KeyAttribute$Visibility[]{r100, r101, r102};
    }

    public static KeyAttribute$Visibility[] values() {
        return (KeyAttribute$Visibility[]) f399665a.clone();
    }

    public static KeyAttribute$Visibility valueOf(String r100) {
        return (KeyAttribute$Visibility) a.a(KeyAttribute$Visibility.class, r100);
    }

    public KeyAttribute$Visibility(String r100, int r101) {
        super(r100, r101);
    }
}
