package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum KeyAttributes$Visibility extends Enum<KeyAttributes$Visibility> {
    public static final KeyAttributes$Visibility GONE = null;
    public static final KeyAttributes$Visibility INVISIBLE = null;
    public static final KeyAttributes$Visibility VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyAttributes$Visibility[] f399667a = null;

    static {
        KeyAttributes$Visibility r100 = new KeyAttributes$Visibility("VISIBLE", 0);
        VISIBLE = r100;
        KeyAttributes$Visibility r101 = new KeyAttributes$Visibility("INVISIBLE", 1);
        INVISIBLE = r101;
        KeyAttributes$Visibility r102 = new KeyAttributes$Visibility("GONE", 2);
        GONE = r102;
        f399667a = new KeyAttributes$Visibility[]{r100, r101, r102};
    }

    public static KeyAttributes$Visibility[] values() {
        return (KeyAttributes$Visibility[]) f399667a.clone();
    }

    public static KeyAttributes$Visibility valueOf(String r100) {
        return (KeyAttributes$Visibility) a.a(KeyAttributes$Visibility.class, r100);
    }

    public KeyAttributes$Visibility(String r100, int r101) {
        super(r100, r101);
    }
}
