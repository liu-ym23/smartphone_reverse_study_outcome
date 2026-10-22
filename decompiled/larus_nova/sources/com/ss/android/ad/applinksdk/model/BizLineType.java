package com.ss.android.ad.applinksdk.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ad/applinksdk/model/BizLineType;", "", "", "code", "I", "getCode", "()I", "AD", "GAME", "STAR_MAP", "DEFAULT", "applinksdk_release"}, k = 1, mv = {1, 4, 0})
public final enum BizLineType extends Enum<BizLineType> {
    public static final BizLineType AD = null;
    public static final BizLineType DEFAULT = null;
    public static final BizLineType GAME = null;
    public static final BizLineType STAR_MAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BizLineType[] f406393a = null;
    private final int code;

    static {
        BizLineType r100 = new BizLineType("AD", 0, 1);
        AD = r100;
        BizLineType r101 = new BizLineType("GAME", 1, 2);
        GAME = r101;
        BizLineType r102 = new BizLineType("STAR_MAP", 2, 3);
        STAR_MAP = r102;
        BizLineType r103 = new BizLineType("DEFAULT", 3, -1);
        DEFAULT = r103;
        f406393a = new BizLineType[]{r100, r101, r102, r103};
    }

    public static BizLineType valueOf(String r100) {
        return (BizLineType) a.a(BizLineType.class, r100);
    }

    public static BizLineType[] values() {
        return (BizLineType[]) f406393a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public BizLineType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
