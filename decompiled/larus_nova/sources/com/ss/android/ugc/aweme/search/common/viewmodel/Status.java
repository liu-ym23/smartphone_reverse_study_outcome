package com.ss.android.ugc.aweme.search.common.viewmodel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/viewmodel/Status;", "", "COLLAPSED", "EXPANDED", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Status extends Enum<Status> {
    public static final Status COLLAPSED = null;
    public static final Status EXPANDED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f452551a = null;

    static {
        Status r100 = new Status("COLLAPSED", 0);
        COLLAPSED = r100;
        Status r101 = new Status("EXPANDED", 1);
        EXPANDED = r101;
        f452551a = new Status[]{r100, r101};
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) f452551a.clone();
    }

    public Status(String r100, int r101) {
        super(r100, r101);
    }
}
