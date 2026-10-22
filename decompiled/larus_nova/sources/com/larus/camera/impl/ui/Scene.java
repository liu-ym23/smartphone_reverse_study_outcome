package com.larus.camera.impl.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/impl/ui/Scene;", "", "<init>", "(Ljava/lang/String;I)V", "CAPTURE", "RESULT", "EDIT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scene extends Enum<Scene> {
    public static final Scene CAPTURE = null;
    public static final Scene EDIT = null;
    public static final Scene RESULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f321782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321783b = null;

    public static EnumEntries<Scene> getEntries() {
        return f321783b;
    }

    static {
        Scene r100 = new Scene("CAPTURE", 0);
        CAPTURE = r100;
        Scene r101 = new Scene("RESULT", 1);
        RESULT = r101;
        Scene r102 = new Scene("EDIT", 2);
        EDIT = r102;
        Scene[] r103 = {r100, r101, r102};
        f321782a = r103;
        f321783b = EnumEntriesKt.enumEntries(r103);
    }

    public static Scene[] values() {
        return (Scene[]) f321782a.clone();
    }

    public static Scene valueOf(String r100) {
        return (Scene) a.a(Scene.class, r100);
    }

    public Scene(String r100, int r101) {
        super(r100, r101);
    }
}
