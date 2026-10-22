package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.components.ScreenCaptureManager;
import com.bytedance.android.shopping.anchorv4.components.n;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.q;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ScreenCaptureComponent extends b0 {
    public static final /* synthetic */ int j = 0;
    public final Lazy i;

    public final class ScreenCaptureDependency implements q {
        public final /* synthetic */ ScreenCaptureComponent a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final CommonMeta a() {
            return this.a.O1().d().getData().a().a();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.q
        public final boolean c() {
            return !Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.d.a(), Boolean.FALSE);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final void d() {
            Intrinsics.checkNotNullParameter("product_detail_capture", "eventName");
            ScreenCaptureComponent r0 = this.a;
            ScreenCaptureComponent$ScreenCaptureDependency$track$1 r3 = new ScreenCaptureComponent$ScreenCaptureDependency$track$1("product_detail_capture", null);
            int r1 = ScreenCaptureComponent.j;
            r0.Z1(w.class, r3);
        }

        public ScreenCaptureDependency(ScreenCaptureComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final void b(String r15, Map<String, ? extends Object> r16, boolean r17, boolean r18, String r19, View r20, String r21, PageFinder r22) {
            ScreenCaptureComponent r1 = this.a;
            ScreenCaptureComponent$ScreenCaptureDependency$track$2 r13 = new ScreenCaptureComponent$ScreenCaptureDependency$track$2(r16, r21, r15, r18, r19, r22, r20, r17, null);
            int r3 = ScreenCaptureComponent.j;
            r1.Z1(w.class, r13);
        }
    }

    public final class a implements n {
        public final /* synthetic */ ScreenCaptureComponent a;

        public final boolean a() {
            return false;
        }

        public final Boolean b() {
            return null;
        }

        public final String c() {
            CommonMeta r0 = this.a.O1().d().getData().a().a();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getScreenShotPopupSchema();
        }

        public final String d() {
            CommonMeta r0 = this.a.O1().d().getData().a().a();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getScreenShotPhotoSchema();
        }

        public a(ScreenCaptureComponent r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(w.class);
    }

    public ScreenCaptureComponent() {
        this.i = LazyKt.lazy(new ScreenCaptureComponent$screenCaptureManager$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        ((ScreenCaptureManager) this.i.getValue()).g();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.f r0 = O1().e();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "goodsDetailPauseScreenShot", true, new ScreenCaptureComponent$onAttach$1(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(r0, "goodsScreenshotShare", true, ScreenCaptureComponent$onAttach$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        ((ScreenCaptureManager) this.i.getValue()).f();
    }
}
