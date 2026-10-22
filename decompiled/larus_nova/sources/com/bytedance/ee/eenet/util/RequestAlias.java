package com.bytedance.ee.eenet.util;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestAlias[] f242764a = null;
    private int value;

    static {
        RequestAlias r100 = new RequestAlias("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        RequestAlias r101 = new RequestAlias("API", 1, 1);
        API = r101;
        RequestAlias r102 = new RequestAlias("FILE", 2, 2);
        FILE = r102;
        RequestAlias r103 = new RequestAlias(DocTabPayload.VALUE_OPAI, 3, 3);
        OAPI = r103;
        RequestAlias r104 = new RequestAlias("DRIVE", 4, 4);
        DRIVE = r104;
        RequestAlias r105 = new RequestAlias("DOCS", 5, 5);
        DOCS = r105;
        RequestAlias r110 = new RequestAlias("MINA", 6, 6);
        MINA = r110;
        RequestAlias r111 = new RequestAlias("OPEN", 7, 7);
        OPEN = r111;
        RequestAlias r112 = new RequestAlias("DOCS_API", 8, 8);
        DOCS_API = r112;
        RequestAlias r113 = new RequestAlias("PASSPORT", 9, 9);
        PASSPORT = r113;
        f242764a = new RequestAlias[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static RequestAlias[] values() {
        return (RequestAlias[]) f242764a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static RequestAlias valueOf(String r100) {
        return (RequestAlias) a.a(RequestAlias.class, r100);
    }

    public RequestAlias(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
