package com.bytedance.ee.bear.doc.resupdate;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum EChannel extends Enum<EChannel> {
    public static final EChannel DOCS_CHANNEL = null;
    public static final EChannel DOCS_FULLPKG_CHANNEL = null;
    public static final EChannel DOCS_GRAY_CHANNEL = null;
    public static final /* synthetic */ EChannel[] a = null;

    static {
        EChannel r0 = new EChannel("DOCS_CHANNEL", 0);
        DOCS_CHANNEL = r0;
        EChannel r1 = new EChannel("DOCS_FULLPKG_CHANNEL", 1);
        DOCS_FULLPKG_CHANNEL = r1;
        EChannel r3 = new EChannel("DOCS_GRAY_CHANNEL", 2);
        DOCS_GRAY_CHANNEL = r3;
        a = new EChannel[]{r0, r1, r3};
    }

    public static EChannel[] values() {
        return (EChannel[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name().toLowerCase();
    }

    public static List<String> getChannelList(boolean r6) {
        ArrayList r0 = new ArrayList();
        EChannel[] r1 = values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        EChannel r4 = r1[r3];
        if (r4 != DOCS_FULLPKG_CHANNEL) goto L8;
        if (r6 == true) goto L8;
    L9:
        r3 = r3 + 1;
    L8:
        r0.add(r4.toString());
        goto L9
    L10:
        return r0;
    }

    public static EChannel valueOf(String r1) {
        return (EChannel) r27.a.a(EChannel.class, r1);
    }

    public EChannel(String r1, int r2) {
        super(r1, r2);
    }
}
