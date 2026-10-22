package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i extends pr4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StageTabCell f213979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f213980c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StageTabCell f213981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f213982b;

        public a(StageTabCell r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101) {
            this.f213981a = r100;
            this.f213982b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StageTabCell r100 = this.f213981a;     // Catch: Throwable -> L8
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101 = this.f213982b;     // Catch: Throwable -> L8
            int r102 = StageTabCell.f213955f;     // Catch: Throwable -> L8
            r100.getClass();     // Catch: Throwable -> L8
            StageActionPayload r103 = r100.b("ItemViewStageMarkDoneAction", r101.f207141a);     // Catch: Throwable -> L8
            if (r103 == null) goto L11;
            gv4.a r104 = r100.f213959d;     // Catch: Throwable -> L8
            if (r104 == null) goto L15;
            r104.a(r103);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    @Override // pr4.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        com.bytedance.ee.util.ui.j.d(new a(this.f213979b, this.f213980c), 100);
    }

    public i(StageTabCell r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101) {
        this.f213979b = r100;
        this.f213980c = r101;
    }
}
