package com.bytedance.ies.ugc.appcontext;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/ugc/appcontext/Irrelevant;", "", "INSTANCE", "appcontext_release"}, k = 1, mv = {1, 4, 0})
public final enum Irrelevant extends Enum<Irrelevant> {
    public static final Irrelevant INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Irrelevant[] f248845a = null;

    static {
        Irrelevant r100 = new Irrelevant();
        INSTANCE = r100;
        f248845a = new Irrelevant[]{r100};
    }

    public static Irrelevant valueOf(String r100) {
        return (Irrelevant) a.a(Irrelevant.class, r100);
    }

    public static Irrelevant[] values() {
        return (Irrelevant[]) f248845a.clone();
    }

    public Irrelevant() {
        super("INSTANCE", 0);
    }
}
