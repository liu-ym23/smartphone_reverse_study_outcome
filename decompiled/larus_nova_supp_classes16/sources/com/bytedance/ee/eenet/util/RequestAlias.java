package com.bytedance.ee.eenet.util;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum RequestAlias extends Enum<RequestAlias> {
    public static final RequestAlias API = null;
    public static final RequestAlias DOCS = null;
    public static final RequestAlias DOCS_API = null;
    public static final RequestAlias DRIVE = null;
    public static final RequestAlias FILE = null;
    public static final RequestAlias MINA = null;
    public static final RequestAlias OAPI = null;
    public static final RequestAlias OPEN = null;
    public static final RequestAlias PASSPORT = null;
    public static final RequestAlias UNKNOWN = null;
    public static final /* synthetic */ RequestAlias[] a = null;
    private int value;

    static {
        RequestAlias r0 = new RequestAlias("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        RequestAlias r1 = new RequestAlias("API", 1, 1);
        API = r1;
        RequestAlias r3 = new RequestAlias("FILE", 2, 2);
        FILE = r3;
        RequestAlias r5 = new RequestAlias("OAPI", 3, 3);
        OAPI = r5;
        RequestAlias r7 = new RequestAlias("DRIVE", 4, 4);
        DRIVE = r7;
        RequestAlias r9 = new RequestAlias("DOCS", 5, 5);
        DOCS = r9;
        RequestAlias r11 = new RequestAlias("MINA", 6, 6);
        MINA = r11;
        RequestAlias r13 = new RequestAlias("OPEN", 7, 7);
        OPEN = r13;
        RequestAlias r16 = new RequestAlias("DOCS_API", 8, 8);
        DOCS_API = r16;
        RequestAlias r14 = new RequestAlias("PASSPORT", 9, 9);
        PASSPORT = r14;
        a = new RequestAlias[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14};
    }

    public static RequestAlias[] values() {
        return (RequestAlias[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static RequestAlias valueOf(String r1) {
        return (RequestAlias) a.a(RequestAlias.class, r1);
    }

    public RequestAlias(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
