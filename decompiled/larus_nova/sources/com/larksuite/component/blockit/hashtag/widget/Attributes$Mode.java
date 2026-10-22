package com.larksuite.component.blockit.hashtag.widget;

/* JADX INFO: loaded from: classes24.dex */
public final enum Attributes$Mode extends Enum<Attributes$Mode> {
    public static final Attributes$Mode Multiple = null;
    public static final Attributes$Mode Single = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Attributes$Mode[] f283057a = null;

    static {
        Attributes$Mode r100 = new Attributes$Mode("Single", 0);
        Single = r100;
        Attributes$Mode r101 = new Attributes$Mode("Multiple", 1);
        Multiple = r101;
        f283057a = new Attributes$Mode[]{r100, r101};
    }

    public static Attributes$Mode[] values() {
        return (Attributes$Mode[]) f283057a.clone();
    }

    public static Attributes$Mode valueOf(String r100) {
        return (Attributes$Mode) r27.a.a(Attributes$Mode.class, r100);
    }

    public Attributes$Mode(String r100, int r101) {
        super(r100, r101);
    }
}
