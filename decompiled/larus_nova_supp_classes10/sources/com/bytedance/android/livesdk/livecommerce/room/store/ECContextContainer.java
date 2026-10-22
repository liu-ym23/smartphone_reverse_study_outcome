package com.bytedance.android.livesdk.livecommerce.room.store;

import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECContextContainer {
    public static final /* synthetic */ int b = 0;
    public Pair<ECContext, ? extends Disposable> a;

    public static final class a {
        public static /* synthetic */ ECContext b() {
            return a(false, null);
        }

        public a() {
        }

        @JvmStatic
        public static ECContext a(boolean r0, Integer r1) {
            if (r0 == false) goto L5;
            if (r1 == null) goto L5;
        L6:
            DataContext r2 = d.d(r1);
            if ((r2 instanceof ECContext) == true) goto L10;
            r2 = null;
        L10:
            return (ECContext) r2;
        L5:
            Object r3 = ECContext.class;
            goto L6
        }
    }

    static {
        new a();
    }

    public ECContextContainer() {
    }

    public final void a(final ECContext r2) {
        Intrinsics.checkNotNullParameter(r2, "ecContext");
        this.a = d.a(new ECContextContainer$onCreate$1(r2));
    }

    public final void b(com.bytedance.android.ec.adapter.api.state.a r4) {
        Intrinsics.checkNotNullParameter(r4, BaseCoreViewModel.CORE_TAG_STATE);
        Pair<ECContext, ? extends Disposable> r0 = this.a;
        if (r0 == null) goto L9;
        ECContext r1 = (ECContext) r0.getFirst();
        if (r1 == null) goto L10;
        r1.isAnchor().d(Boolean.valueOf(r4.c));
        r1.getRoomId().d(r4.f);
        r1.getRoomUniqueKey().d(r4.e);
        r1.isPortrait().setValue(Boolean.valueOf(r4.d));
        r1.getAnchorId().d(r4.g);
        r1.getAnchorSecId().d(r4.h);
        r1.isLogin().setValue(Boolean.valueOf(r4.a()));
        r1.getStreamType().setValue(Integer.valueOf(r4.l));
        r1.getReportParams().setValue(r4.m);
        r1.getEnterRoomParams().setValue(r4.p);
        r1.getLiveSDKVersion().d(Integer.valueOf(r4.o));
        r1.isInKtv().setValue(Boolean.valueOf(((Boolean) r4.q.invoke()).booleanValue()));
        r1.isInDrawGuessGame().setValue(Boolean.valueOf(r4.a));
        r1.getExtras().setValue(r4.n);
        r1.isReplayOpen().setValue(Boolean.valueOf(r4.j));
        ECLivePerformanceMonitor r2 = (ECLivePerformanceMonitor) r1.getEcLivePerformanceMonitor().getValue();
        String r3 = r4.f;
        String r5 = r4.e;
        r2.a = r3;
        r2.b = r5;
        return;
    L10:
        return;
    }
}
