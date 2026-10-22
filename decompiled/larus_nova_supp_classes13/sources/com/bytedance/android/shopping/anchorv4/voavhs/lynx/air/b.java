package com.bytedance.android.shopping.anchorv4.voavhs.lynx.air;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends FrameLayout {
    public static final String d = null;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b a;
    public ECLynxCard b;
    public final C0018b c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.b$b, reason: collision with other inner class name */
    public static final class C0018b extends IECLynxCardLifeCycle.Base {
        public final /* synthetic */ b a;

        public final void onRuntimeReady() {
            ECLynxCard r0 = this.a.b;
            if (r0 == null) goto L5;
            r0.n();
        L5:
            dm.a.b r1 = dm.a.a;
            dm.a.a(b.d).i("IECLynxCardLifeCycle onRuntimeReady");
        }

        public C0018b(b r1) {
            this.a = r1;
        }

        public final void onTimingSetup(Map<String, ? extends Object> r4) {
            super.onTimingSetup(r4);
            dm.a.a("LynxTiming").i("AnchorV4LynxAirNodeView onTimingSetup timingInfo:" + r4);
        }

        public final void onLoadFailed(ECLynxCardErrorType r4, Integer r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "type");
            dm.a.b r0 = dm.a.a;
            dm.a.a(b.d).b("IECLynxCardLifeCycle onLoadFailed: type:" + r4.name() + ", errorCode: " + r5 + ", errorMsg: " + r6, null);
        }
    }

    static {
        d = b.class.getSimpleName();
    }

    public b(Context r3) {
        if (r3 == null) goto L6;
        super(r3);
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r4 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.a = r4;
        r4.f(new Radius(8, 8, 8, 8));
        this.c = new C0018b(this);
        return;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.a.e(r2);
        super.draw(r2);
        this.a.d(r2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.a.c(r1, r2);
    }
}
