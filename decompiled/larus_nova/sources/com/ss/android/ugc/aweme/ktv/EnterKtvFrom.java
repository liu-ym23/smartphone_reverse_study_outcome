package com.ss.android.ugc.aweme.ktv;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/EnterKtvFrom;", "", "SCROLL_IN", "DEFAULT", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum EnterKtvFrom extends Enum<EnterKtvFrom> {
    public static final EnterKtvFrom DEFAULT = null;
    public static final EnterKtvFrom SCROLL_IN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterKtvFrom[] f450955a = null;

    static {
        EnterKtvFrom r100 = new EnterKtvFrom("SCROLL_IN", 0);
        SCROLL_IN = r100;
        EnterKtvFrom r101 = new EnterKtvFrom("DEFAULT", 1);
        DEFAULT = r101;
        f450955a = new EnterKtvFrom[]{r100, r101};
    }

    public static EnterKtvFrom valueOf(String r100) {
        return (EnterKtvFrom) a.a(EnterKtvFrom.class, r100);
    }

    public static EnterKtvFrom[] values() {
        return (EnterKtvFrom[]) f450955a.clone();
    }

    public EnterKtvFrom(String r100, int r101) {
        super(r100, r101);
    }
}
