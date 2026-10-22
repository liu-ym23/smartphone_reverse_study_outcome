package com.bytedance.kmp.livesdk.gift.platform.dialog.service;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.p;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements o, d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static p f252337e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i12.e f252338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qc6.a f252339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.livesdk.gift.platform.dialog.service.a f252340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f252341d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.dialog.service.d
    public final void kj() {
        this.f252340c.S();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        kj();
        KProperty[] r100 = yc6.e.f567175a;
        Intrinsics.checkNotNullParameter("0", "<set-?>");
        yc6.e.f567176b.setValue(null, yc6.e.f567175a[0], "0");
    }

    public e(i12.e r100, Context r101, qc6.a r102, com.bytedance.kmp.livesdk.gift.platform.dialog.service.a r103, g r104, GiftReceiverRepoService r105, y r106, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r107) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "giftExtraRepository");
        Intrinsics.checkNotNullParameter(r103, "giftDialogService");
        Intrinsics.checkNotNullParameter(r104, "roomDataService");
        Intrinsics.checkNotNullParameter(r105, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r106, "selectReceiverService");
        Intrinsics.checkNotNullParameter(r107, "allMicService");
        this.f252338a = r100;
        this.f252339b = r102;
        this.f252340c = r103;
        this.f252341d = r104;
    }
}
