package com.bytedance.kmp.klay.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/klay/ui/Visibility;", "", "Visible", "Invisible", "Gone", "klay_release"}, k = 1, mv = {1, 7, 0})
public final enum Visibility extends Enum<Visibility> {
    public static final Visibility Gone = null;
    public static final Visibility Invisible = null;
    public static final Visibility Visible = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Visibility[] f252191a = null;

    public static Visibility valueOf(String r100) {
        return (Visibility) r27.a.a(Visibility.class, r100);
    }

    public static Visibility[] values() {
        return (Visibility[]) f252191a.clone();
    }

    static {
        Visibility r100 = new Visibility("Visible", 0);
        Visible = r100;
        Visibility r101 = new Visibility("Invisible", 1);
        Invisible = r101;
        Visibility r102 = new Visibility("Gone", 2);
        Gone = r102;
        f252191a = new Visibility[]{r100, r101, r102};
    }

    public Visibility(String r100, int r101) {
        super(r100, r101);
    }
}
