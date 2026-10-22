package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/forest/model/Status;", "", "PENDING", "FETCHING", "FINISHED", "CANCELED", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum Status extends Enum<Status> {
    public static final Status CANCELED = null;
    public static final Status FETCHING = null;
    public static final Status FINISHED = null;
    public static final Status PENDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f244326a = null;

    static {
        Status r100 = new Status("PENDING", 0);
        PENDING = r100;
        Status r101 = new Status("FETCHING", 1);
        FETCHING = r101;
        Status r102 = new Status("FINISHED", 2);
        FINISHED = r102;
        Status r103 = new Status("CANCELED", 3);
        CANCELED = r103;
        f244326a = new Status[]{r100, r101, r102, r103};
    }

    public static Status valueOf(String r100) {
        return (Status) r27.a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) f244326a.clone();
    }

    public Status(String r100, int r101) {
        super(r100, r101);
    }
}
