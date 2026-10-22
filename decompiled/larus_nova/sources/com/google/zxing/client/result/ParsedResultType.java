package com.google.zxing.client.result;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum ParsedResultType extends Enum<ParsedResultType> {
    public static final ParsedResultType ADDRESSBOOK = null;
    public static final ParsedResultType CALENDAR = null;
    public static final ParsedResultType EMAIL_ADDRESS = null;
    public static final ParsedResultType GEO = null;
    public static final ParsedResultType ISBN = null;
    public static final ParsedResultType PRODUCT = null;
    public static final ParsedResultType SMS = null;
    public static final ParsedResultType TEL = null;
    public static final ParsedResultType TEXT = null;
    public static final ParsedResultType URI = null;
    public static final ParsedResultType VIN = null;
    public static final ParsedResultType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ParsedResultType[] f275941a = null;

    static {
        ParsedResultType r100 = new ParsedResultType("ADDRESSBOOK", 0);
        ADDRESSBOOK = r100;
        ParsedResultType r101 = new ParsedResultType("EMAIL_ADDRESS", 1);
        EMAIL_ADDRESS = r101;
        ParsedResultType r102 = new ParsedResultType("PRODUCT", 2);
        PRODUCT = r102;
        ParsedResultType r103 = new ParsedResultType("URI", 3);
        URI = r103;
        ParsedResultType r104 = new ParsedResultType(CardAdapter.TEXT, 4);
        TEXT = r104;
        ParsedResultType r105 = new ParsedResultType("GEO", 5);
        GEO = r105;
        ParsedResultType r110 = new ParsedResultType("TEL", 6);
        TEL = r110;
        ParsedResultType r111 = new ParsedResultType(CancelRetainContactInfoFunctions.SMS, 7);
        SMS = r111;
        ParsedResultType r112 = new ParsedResultType("CALENDAR", 8);
        CALENDAR = r112;
        ParsedResultType r113 = new ParsedResultType("WIFI", 9);
        WIFI = r113;
        ParsedResultType r114 = new ParsedResultType("ISBN", 10);
        ISBN = r114;
        ParsedResultType r115 = new ParsedResultType("VIN", 11);
        VIN = r115;
        f275941a = new ParsedResultType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static ParsedResultType[] values() {
        return (ParsedResultType[]) f275941a.clone();
    }

    public static ParsedResultType valueOf(String r100) {
        return (ParsedResultType) a.a(ParsedResultType.class, r100);
    }

    public ParsedResultType(String r100, int r101) {
        super(r100, r101);
    }
}
