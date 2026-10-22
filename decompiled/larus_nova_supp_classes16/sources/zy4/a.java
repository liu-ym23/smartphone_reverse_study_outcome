package zy4;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.document.onboarding.b {

    /* JADX INFO: renamed from: zy4.a$a, reason: collision with other inner class name */
    public static final class C0335a {
    }

    public static final class b implements tk5.c {
        public b() {
        }

        public final void a(tk5.d<? extends vk5.c> r3) {
            Intrinsics.checkNotNullParameter(r3, "mission");
            ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c("docx_announcement_pin_list_guide");
        }

        public final void b(tk5.d<? extends vk5.c> r3) {
            Intrinsics.checkNotNullParameter(r3, "mission");
            ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c("docx_announcement_pin_list_guide");
        }

        public final void c(tk5.d<? extends vk5.c> r3) {
            Intrinsics.checkNotNullParameter(r3, "mission");
            ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c("docx_announcement_pin_list_guide");
        }
    }

    static {
    }

    public final String getBiz() {
        return "doc";
    }

    public final String getId() {
        return "docx_announcement_pin_list_guide";
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r5, OnBoardingData r6) {
        Intrinsics.checkNotNullParameter(r5, "ui");
        Intrinsics.checkNotNullParameter(r6, "data");
        RectF r0 = new RectF();
        OnBoardingData.Position r7 = r6.position;
        float r1 = r7.x;
        r0.left = r1;
        float r2 = r7.y;
        r0.top = r2;
        r0.right = r1 + r7.width;
        r0.bottom = r2 + r7.height;
        FragmentActivity r8 = r5.getActivity();
        uk5.c r3 = new uk5.c(r8.getResources().getString(2131889537), true, r0);
        r3.m = r8.getResources().getString(2131889676);
        r3.i = FlowStyleHollowShape.None;
        r3.c = r8.getResources().getString(2131889536);
        r5.c(r8.getWindow(), r3, new b());
        return true;
    }
}
