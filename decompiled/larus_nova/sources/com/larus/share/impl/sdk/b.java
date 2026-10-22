package com.larus.share.impl.sdk;

import android.content.Context;
import com.larus.nova.R;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import t19.s;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f368733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f368734b;

    public /* synthetic */ b(Context r100, Function1 r101) {
        this.f368733a = r100;
        this.f368734b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Context r101 = this.f368733a;
        Function1 r102 = this.f368734b;
        int r103 = ((Integer) r100).intValue();
        Set<String> r104 = SharePanelService.f368729b;
        if (r103 != 2) goto L5;
        s.f544207a.g(r101, R.string.larus_share_failed, false);
    L5:
        if (r102 == null) goto L8;
        r102.invoke(Integer.valueOf(r103));
    L8:
        return Unit.INSTANCE;
    }
}
