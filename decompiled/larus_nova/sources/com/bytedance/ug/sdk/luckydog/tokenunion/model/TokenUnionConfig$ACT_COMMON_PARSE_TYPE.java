package com.bytedance.ug.sdk.luckydog.tokenunion.model;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum TokenUnionConfig$ACT_COMMON_PARSE_TYPE extends Enum<TokenUnionConfig$ACT_COMMON_PARSE_TYPE> {
    public static final TokenUnionConfig$ACT_COMMON_PARSE_TYPE DEFAULT = null;
    public static final TokenUnionConfig$ACT_COMMON_PARSE_TYPE GET_JSON_FROM_STR = null;
    public static final TokenUnionConfig$ACT_COMMON_PARSE_TYPE GSON = null;
    public static final TokenUnionConfig$ACT_COMMON_PARSE_TYPE UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TokenUnionConfig$ACT_COMMON_PARSE_TYPE[] f272297a = null;
    private String typeStr;

    static {
        TokenUnionConfig$ACT_COMMON_PARSE_TYPE r100 = new TokenUnionConfig$ACT_COMMON_PARSE_TYPE("DEFAULT", 0, "default");
        DEFAULT = r100;
        TokenUnionConfig$ACT_COMMON_PARSE_TYPE r101 = new TokenUnionConfig$ACT_COMMON_PARSE_TYPE("GSON", 1, "gson");
        GSON = r101;
        TokenUnionConfig$ACT_COMMON_PARSE_TYPE r102 = new TokenUnionConfig$ACT_COMMON_PARSE_TYPE("GET_JSON_FROM_STR", 2, "get_json_from_str");
        GET_JSON_FROM_STR = r102;
        TokenUnionConfig$ACT_COMMON_PARSE_TYPE r103 = new TokenUnionConfig$ACT_COMMON_PARSE_TYPE("UNKNOWN", 3, "unknown");
        UNKNOWN = r103;
        f272297a = new TokenUnionConfig$ACT_COMMON_PARSE_TYPE[]{r100, r101, r102, r103};
    }

    public static TokenUnionConfig$ACT_COMMON_PARSE_TYPE[] values() {
        return (TokenUnionConfig$ACT_COMMON_PARSE_TYPE[]) f272297a.clone();
    }

    public String getTypeStr() {
        return this.typeStr;
    }

    public static TokenUnionConfig$ACT_COMMON_PARSE_TYPE valueOf(String r100) {
        return (TokenUnionConfig$ACT_COMMON_PARSE_TYPE) a.a(TokenUnionConfig$ACT_COMMON_PARSE_TYPE.class, r100);
    }

    public TokenUnionConfig$ACT_COMMON_PARSE_TYPE(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeStr = r102;
    }
}
