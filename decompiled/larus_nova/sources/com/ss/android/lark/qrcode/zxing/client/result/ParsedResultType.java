package com.ss.android.lark.qrcode.zxing.client.result;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ParsedResultType extends Enum<ParsedResultType> {
    public static final ParsedResultType TEXT = null;
    public static final ParsedResultType URI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ParsedResultType[] f439111a = null;

    static {
        ParsedResultType r100 = new ParsedResultType("URI", 0);
        URI = r100;
        ParsedResultType r101 = new ParsedResultType(CardAdapter.TEXT, 1);
        TEXT = r101;
        f439111a = new ParsedResultType[]{r100, r101};
    }

    public static ParsedResultType[] values() {
        return (ParsedResultType[]) f439111a.clone();
    }

    public static ParsedResultType valueOf(String r100) {
        return (ParsedResultType) a.a(ParsedResultType.class, r100);
    }

    public ParsedResultType(String r100, int r101) {
        super(r100, r101);
    }
}
