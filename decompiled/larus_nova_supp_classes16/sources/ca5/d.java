package ca5;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements tk5.c {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void a(tk5.d<? extends vk5.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "mission");
        tt5.a.h("DrivePdfCommentOnboardMission", TipCallBackData.CONFIRM);
        sk5.c r4 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.a.getClass();
        r4.c("ccm_mobile_drive_pdf_area_box_comment_intro");
    }

    public final void b(tk5.d<? extends vk5.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "mission");
        tt5.a.h("DrivePdfCommentOnboardMission", "dismiss");
        sk5.c r4 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.a.getClass();
        r4.c("ccm_mobile_drive_pdf_area_box_comment_intro");
    }

    public final void c(tk5.d<? extends vk5.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "mission");
        tt5.a.h("DrivePdfCommentOnboardMission", "cancel");
        sk5.c r4 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        this.a.getClass();
        r4.c("ccm_mobile_drive_pdf_area_box_comment_intro");
    }
}
