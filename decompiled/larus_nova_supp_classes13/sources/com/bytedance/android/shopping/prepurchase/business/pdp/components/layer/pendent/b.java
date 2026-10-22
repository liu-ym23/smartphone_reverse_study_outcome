package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.ec.model.response.anchorv3.VideoModelStruct;
import com.bytedance.android.shopping.anchorv3.videowindow.VideoWindowSession;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.v;
import java.util.List;
import kotlin.collections.CollectionsKt;
import vg3.b0;
import vg3.r;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements r {
    public SmallVideoWindowVO m;
    public v n;
    public VideoWindowSession o;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            SmallVideoWindowVO r4 = (SmallVideoWindowVO) r3;
            b r0 = this.a;
            if (r4 == null) goto L7;
            r0.m = r4;
            com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).b.d, this.a, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.a(this));
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.a.class, b0.class, w.class});
    }

    @Override // vg3.r
    public final boolean E() {
        VideoWindowSession r0 = this.o;
        if (r0 != null) goto L7;
        return false;
    L7:
        return !r0.j;
    }

    @Override // vg3.r
    public final boolean I() {
        if (this.m == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().t.getValue(), this, new a(this));
        AbsComponent.Y1(this, r.class, this, false, 12);
    }

    public b() {
    }

    public final fj.d h2(SmallVideoWindowVO r26) {
        VideoModelStruct r0 = r26.getVideoModel();
        Long r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getMainUrl();
    L6:
        VideoModelStruct r3 = r26.getVideoModel();
        if (r3 == null) goto L9;
        String r4 = r3.getBackupUrl();
    L10:
        VideoModelStruct r5 = r26.getVideoModel();
        if (r5 == null) goto L13;
        String r6 = r5.getVid();
    L14:
        VideoModelStruct r7 = r26.getVideoModel();
        if (r7 == null) goto L17;
        Long r8 = Long.valueOf(r7.getWidth());
    L18:
        long r9 = com.bytedance.android.shopping.extensions.k.h(r8);
        VideoModelStruct r10 = r26.getVideoModel();
        if (r10 == null) goto L21;
        Long r11 = Long.valueOf(r10.getHeight());
    L22:
        long r12 = com.bytedance.android.shopping.extensions.k.h(r11);
        VideoModelStruct r13 = r26.getVideoModel();
        if (r13 == null) goto L25;
        Long r14 = Long.valueOf(r13.getDuration());
    L26:
        long r15 = com.bytedance.android.shopping.extensions.k.h(r14);
        VideoModelStruct r16 = r26.getVideoModel();
        if (r16 == null) goto L30;
        r1 = Long.valueOf(r16.getInitialStartTimeMs());
    L30:
        return new fj.d(r2, r4, r6, r9, r12, r15, null, true, false, true, true, false, null, false, com.bytedance.android.shopping.extensions.k.h(r1), null, null, 112896);
    L25:
        r14 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
