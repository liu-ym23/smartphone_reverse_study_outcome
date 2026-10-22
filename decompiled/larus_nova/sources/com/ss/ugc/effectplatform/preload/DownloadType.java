package com.ss.ugc.effectplatform.preload;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/ugc/effectplatform/preload/DownloadType;", "", "EFFECT", "ALGORITHM", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final enum DownloadType extends Enum<DownloadType> {
    public static final DownloadType ALGORITHM = null;
    public static final DownloadType EFFECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownloadType[] f457433a = null;

    static {
        DownloadType r100 = new DownloadType("EFFECT", 0);
        EFFECT = r100;
        DownloadType r101 = new DownloadType("ALGORITHM", 1);
        ALGORITHM = r101;
        f457433a = new DownloadType[]{r100, r101};
    }

    public static DownloadType valueOf(String r100) {
        return (DownloadType) r27.a.a(DownloadType.class, r100);
    }

    public static DownloadType[] values() {
        return (DownloadType[]) f457433a.clone();
    }

    public DownloadType(String r100, int r101) {
        super(r100, r101);
    }
}
