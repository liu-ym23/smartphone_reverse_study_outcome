package com.bytedance.ee.bear.document.sharewords.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f221850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f221851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HashMap<String, ForwardTarget> f221852c;

    public l(i r100, Context r101, HashMap<String, ForwardTarget> r102) {
        this.f221850a = r100;
        this.f221851b = r101;
        this.f221852c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        i r102 = this.f221850a;
        Context r103 = this.f221851b;
        int r104 = this.f221852c.size();
        ForwardTarget r105 = (ForwardTarget) CollectionsKt.firstOrNull(this.f221852c.values());
        r102.getClass();
        if (r104 != 1) goto L5;
        com.bytedance.ee.util.ui.j.f(new j(r103, r104, r105, r102));
    L6:
        Toast.cancelLoading();
        return;
    L5:
        com.bytedance.ee.util.ui.j.f(new j(r103, r104, null, r102));
        goto L6
    }
}
