package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface u {
    public static final a a = null;

    public static final class a {
        public static final C0161a a = null;
        public static final /* synthetic */ a b = null;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u$a$a, reason: collision with other inner class name */
        public static final class C0161a implements u {
            public C0161a() {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void a() {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void onClose(boolean r1) {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void onShow() {
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void b(l r2) {
                Intrinsics.checkNotNullParameter(r2, "other");
                Intrinsics.checkNotNullParameter(r2, "other");
            }

            @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.u
            public final void c(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r2) {
                Intrinsics.checkNotNullParameter(r2, "floatVideo");
                Intrinsics.checkNotNullParameter(r2, "floatVideo");
            }
        }

        public a() {
        }

        static {
            b = new a();
            a = new C0161a();
        }
    }

    static {
        a = a.b;
    }

    void a();

    void b(l r1);

    void c(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a r1);

    void onClose(boolean r1);

    void onShow();
}
