package com.bytedance.android.livesdk.livecommerce.userinfo.title.utils;

import android.os.SystemClock;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.i;
import com.bytedance.android.ec.monitor.duration.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoEventHelper$reportPerformance$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $btmPageId;
    final /* synthetic */ String $roomId;
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.utils.ECUserInfoEventHelper$reportPerformance$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iAdapterService", "Lcom/bytedance/android/ec/adapter/api/IAdapterService;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<IAdapterService, Unit> {
        final /* synthetic */ d $monitor;

        public AnonymousClass1(d r1) {
            this.$monitor = r1;
            super(1);
        }

        public final void invoke(IAdapterService r5) {
            if (r5 == null) goto L12;
            i r6 = r5.getUxTracerService();
            if (r6 == null) goto L13;
            long r0 = (r6.a("enter_room") - SystemClock.uptimeMillis()) + System.currentTimeMillis();
            r6.b();
            d r7 = this.$monitor;
            if (r7 == null) goto L8;
            r7.d("initial", r0);
        L8:
            d r8 = this.$monitor;
            if (r8 == null) goto L14;
            r8.b("enter_room_api_duration", 0L);
            return;
        L14:
            return;
        L13:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((IAdapterService) r1);
            return Unit.INSTANCE;
        }
    }

    public ECUserInfoEventHelper$reportPerformance$1(a r1, String r2, String r3) {
        this.this$0 = r1;
        this.$btmPageId = r2;
        this.$roomId = r3;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1283invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1283invoke() {
        throw null;
    }
}
