package com.larus.home.api.main;

import gb9.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/home/api/main/HomeServiceV2;", "Lcom/larus/home/api/main/IHomeApiV2;", "<init>", "()V", "iHomeApi", "getIHomeApi", "()Lcom/larus/home/api/main/IHomeApiV2;", "iHomeApi$delegate", "Lkotlin/Lazy;", "getMainActivityClassName", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeServiceV2 implements IHomeApiV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HomeServiceV2 f344096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f344097b = null;

    private HomeServiceV2() {
    }

    static {
        f344096a = new HomeServiceV2();
        f344097b = LazyKt.lazy(new c());
    }

    @Override // com.larus.home.api.main.IHomeApiV2
    public final String a() {
        IHomeApiV2 r100 = (IHomeApiV2) f344097b.getValue();
        if (r100 == null) goto L5;
        String r101 = r100.a();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }
}
