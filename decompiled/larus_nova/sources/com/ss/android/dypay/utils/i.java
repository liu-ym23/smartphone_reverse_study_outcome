package com.ss.android.dypay.utils;

import android.content.ComponentName;
import android.content.Intent;
import com.android.ttcjpaysdk.bdpay.counter.outer.base.CJOuterBaseProcessor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f408500a = 0;

    public interface a {
        void a();

        void a(String r100);

        void b();
    }

    public final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f408501a;

        public b(a r100) {
            this.f408501a = r100;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            a r100 = this.f408501a;
            if (r100 == null) goto L6;
            r100.b();
        L6:
            return Unit.INSTANCE;
        }
    }

    public final class c extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f408502a;

        public c(a r100) {
            this.f408502a = r100;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String r100) {
            String r101 = r100;
            a r102 = this.f408502a;
            if (r102 == null) goto L6;
            r102.a(r101);
        L6:
            return Unit.INSTANCE;
        }
    }

    public final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f408503a;

        public d(a r100) {
            this.f408503a = r100;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            a r100 = this.f408503a;
            if (r100 == null) goto L6;
            r100.a();
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public static Intent a(e.a r100, com.ss.android.dypay.activity.f.i.f r101) {
        int r102 = r100.ordinal();
        if (r102 != 0) goto L5;
    L11:
        String r103 = "com.ss.android.ugc.aweme";
    L12:
        Intent r104 = new Intent();
        r104.setComponent(new ComponentName(r103, CJOuterBaseProcessor.DY_PAY_ROOTER_ACTIVITY_CLASS));
        r101.invoke(r104);
        return r104;
    L5:
        if (r102 != 1) goto L7;
        r103 = "com.ss.android.ugc.aweme.lite";
        goto L12
    L7:
        if (r102 != 2) goto L11;
        r103 = "com.ss.android.ugc.live";
        goto L12
    }
}
