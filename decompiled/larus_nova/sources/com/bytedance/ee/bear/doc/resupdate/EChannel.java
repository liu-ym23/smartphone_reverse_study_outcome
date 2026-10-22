package com.bytedance.ee.bear.doc.resupdate;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final enum EChannel extends Enum<EChannel> {
    public static final EChannel DOCS_CHANNEL = null;
    public static final EChannel DOCS_FULLPKG_CHANNEL = null;
    public static final EChannel DOCS_GRAY_CHANNEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EChannel[] f218000a = null;

    static {
        EChannel r100 = new EChannel("DOCS_CHANNEL", 0);
        DOCS_CHANNEL = r100;
        EChannel r101 = new EChannel("DOCS_FULLPKG_CHANNEL", 1);
        DOCS_FULLPKG_CHANNEL = r101;
        EChannel r102 = new EChannel("DOCS_GRAY_CHANNEL", 2);
        DOCS_GRAY_CHANNEL = r102;
        f218000a = new EChannel[]{r100, r101, r102};
    }

    public static EChannel[] values() {
        return (EChannel[]) f218000a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name().toLowerCase();
    }

    public static List<String> getChannelList(boolean r100) {
        ArrayList r101 = new ArrayList();
        EChannel[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        EChannel r105 = r102[r104];
        if (r105 != DOCS_FULLPKG_CHANNEL) goto L8;
        if (r100 == true) goto L8;
    L9:
        r104 = r104 + 1;
    L8:
        r101.add(r105.toString());
        goto L9
    L10:
        return r101;
    }

    public static EChannel valueOf(String r100) {
        return (EChannel) r27.a.a(EChannel.class, r100);
    }

    public EChannel(String r100, int r101) {
        super(r100, r101);
    }
}
