package com.ss.android.ugc.aweme.search.mob;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/EmptyReason;", "", "SERVER_EMPTY", "SENSITIVE", "LIMIT", "SCHEMA_ERROR", "RENDER_NO_CARD", "LOADING_EMPTY", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EmptyReason extends Enum<EmptyReason> {
    public static final EmptyReason LIMIT = null;
    public static final EmptyReason LOADING_EMPTY = null;
    public static final EmptyReason RENDER_NO_CARD = null;
    public static final EmptyReason SCHEMA_ERROR = null;
    public static final EmptyReason SENSITIVE = null;
    public static final EmptyReason SERVER_EMPTY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyReason[] f453296a = null;

    static {
        EmptyReason r100 = new EmptyReason("SERVER_EMPTY", 0);
        SERVER_EMPTY = r100;
        EmptyReason r101 = new EmptyReason("SENSITIVE", 1);
        SENSITIVE = r101;
        EmptyReason r102 = new EmptyReason("LIMIT", 2);
        LIMIT = r102;
        EmptyReason r103 = new EmptyReason("SCHEMA_ERROR", 3);
        SCHEMA_ERROR = r103;
        EmptyReason r104 = new EmptyReason("RENDER_NO_CARD", 4);
        RENDER_NO_CARD = r104;
        EmptyReason r105 = new EmptyReason("LOADING_EMPTY", 5);
        LOADING_EMPTY = r105;
        f453296a = new EmptyReason[]{r100, r101, r102, r103, r104, r105};
    }

    public static EmptyReason valueOf(String r100) {
        return (EmptyReason) a.a(EmptyReason.class, r100);
    }

    public static EmptyReason[] values() {
        return (EmptyReason[]) f453296a.clone();
    }

    public EmptyReason(String r100, int r101) {
        super(r100, r101);
    }
}
