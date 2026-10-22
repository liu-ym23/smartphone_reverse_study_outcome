package com.bytedance.morpheus.mira;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final enum MiraMorpheusHelper$DownloadType extends Enum<MiraMorpheusHelper$DownloadType> {
    public static final MiraMorpheusHelper$DownloadType CONCURRENCE = null;
    public static final MiraMorpheusHelper$DownloadType QUEUE = null;
    public static final /* synthetic */ MiraMorpheusHelper$DownloadType[] a = null;

    static {
        MiraMorpheusHelper$DownloadType r0 = new MiraMorpheusHelper$DownloadType("QUEUE", 0);
        QUEUE = r0;
        MiraMorpheusHelper$DownloadType r1 = new MiraMorpheusHelper$DownloadType("CONCURRENCE", 1);
        CONCURRENCE = r1;
        a = new MiraMorpheusHelper$DownloadType[]{r0, r1};
    }

    public static MiraMorpheusHelper$DownloadType[] values() {
        return (MiraMorpheusHelper$DownloadType[]) a.clone();
    }

    public static MiraMorpheusHelper$DownloadType valueOf(String r1) {
        return (MiraMorpheusHelper$DownloadType) a.a(MiraMorpheusHelper$DownloadType.class, r1);
    }

    public MiraMorpheusHelper$DownloadType(String r1, int r2) {
        super(r1, r2);
    }
}
