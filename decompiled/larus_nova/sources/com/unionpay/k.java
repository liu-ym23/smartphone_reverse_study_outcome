package com.unionpay;

import java.util.Comparator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class k implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f462164a;

    public k() {
        this.f462164a = "";
        this.f462164a = "sort";
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object r100, Object r101) {
        long r102 = ((JSONObject) r100).optLong(this.f462164a);
        long r103 = ((JSONObject) r101).optLong(this.f462164a);
        if (r102 >= r103) goto L6;
        return -1;
    L6:
        if (r102 <= r103) goto L9;
        return 1;
    L9:
        return 0;
    }
}
