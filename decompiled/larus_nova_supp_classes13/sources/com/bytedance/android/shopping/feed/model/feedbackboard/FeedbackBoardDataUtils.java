package com.bytedance.android.shopping.feed.model.feedbackboard;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.feed.repository.api.FeedbackPanelApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class FeedbackBoardDataUtils {
    public static e a;
    public static boolean b;
    public static final Lazy c = null;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r3) {
            e r4 = (e) r3;
            if (r4 == null) goto L7;
            com.bytedance.android.shopping.feed.model.feedbackboard.b r0 = r4.a();
            if (r0 == null) goto L7;
            List<f> r1 = r0.b();
        L8:
            List<f> r2 = r1;
            if (r2 != null) goto L11;
        L14:
            boolean r5 = true;
        L15:
            if (r5 == true) goto L17;
            FeedbackBoardDataUtils.a = r4;
        L17:
            FeedbackBoardDataUtils.b = false;
            return;
        L11:
            if (r2.isEmpty() == true) goto L14;
            r5 = false;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
            FeedbackBoardDataUtils.b = false;
        }
    }

    static {
        c = LazyKt.lazy(FeedbackBoardDataUtils$feedbackPanelApi$2.INSTANCE);
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewChineseName");
        if (b == false) goto L5;
        return;
    L5:
        b = true;
        FeedbackPanelApi r0 = (FeedbackPanelApi) c.getValue();
        if (r0 == null) goto L15;
        Observable<e> r3 = r0.getFeedbackBoard(r2);
        if (r3 == null) goto L16;
        Observable r4 = r3.subscribeOn(Schedulers.io());
        if (r4 == null) goto L17;
        Observable r5 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r5 == null) goto L18;
        r5.subscribe(a.a, b.a);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
