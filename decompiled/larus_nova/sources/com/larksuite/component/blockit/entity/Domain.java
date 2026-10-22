package com.larksuite.component.blockit.entity;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;

/* JADX INFO: loaded from: classes24.dex */
public final enum Domain extends Enum<Domain> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Domain[] f282982a = null;
    public static final Domain calendar = null;
    public static final Domain chat = null;
    public static final Domain docs = null;
    public static final Domain event = null;
    public static final Domain message = null;
    public static final Domain sheet = null;
    public static final Domain todo = null;
    private int value;

    static {
        Domain r100 = new Domain("chat", 0, 1);
        chat = r100;
        Domain r101 = new Domain("message", 1, 2);
        message = r101;
        Domain r102 = new Domain("event", 2, 3);
        event = r102;
        Domain r103 = new Domain("calendar", 3, 4);
        calendar = r103;
        Domain r104 = new Domain("docs", 4, 5);
        docs = r104;
        Domain r110 = new Domain(DocumentType.SHEET_NAME, 5, 6);
        sheet = r110;
        Domain r111 = new Domain(IOfflineExtraParser.ParserType.TODO, 6, 7);
        todo = r111;
        f282982a = new Domain[]{r100, r101, r102, r103, r104, r110, r111};
    }

    public static Domain[] values() {
        return (Domain[]) f282982a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static Domain forNumber(int r100) {
        switch(r100) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return todo;
    L8:
        return sheet;
    L10:
        return docs;
    L12:
        return calendar;
    L14:
        return event;
    L16:
        return message;
    L18:
        return chat;
    }

    public static Domain valueOf(String r100) {
        return (Domain) r27.a.a(Domain.class, r100);
    }

    public static Domain valueOf(int r100) {
        return forNumber(r100);
    }

    public Domain(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
