package com.bytedance.ee.lark.plugin_annotation.bean;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum Scope extends Enum<Scope> {
    public static final Scope APPLICATION = null;
    public static final Scope CONTAINER = null;
    public static final Scope SERVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scope[] f242841a = null;

    static {
        Scope r100 = new Scope(HTTP.SERVICE, 0);
        SERVICE = r100;
        Scope r101 = new Scope("APPLICATION", 1);
        APPLICATION = r101;
        Scope r102 = new Scope("CONTAINER", 2);
        CONTAINER = r102;
        f242841a = new Scope[]{r100, r101, r102};
    }

    public static Scope[] values() {
        return (Scope[]) f242841a.clone();
    }

    public static Scope valueOf(String r100) {
        return (Scope) a.a(Scope.class, r100);
    }

    public Scope(String r100, int r101) {
        super(r100, r101);
    }
}
