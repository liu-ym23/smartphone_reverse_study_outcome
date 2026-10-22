package ca5;

import android.graphics.RectF;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import kotlin.jvm.internal.Intrinsics;
import uk5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements tk5.d<vk5.a> {
    public static final /* synthetic */ int b = 0;
    public final CommentRectLayout a;

    public static final class a {
    }

    static {
    }

    public final String getBiz() {
        return "drive";
    }

    public final /* synthetic */ String getDependency() {
        return null;
    }

    public final String getId() {
        return "ccm_mobile_drive_pdf_area_box_comment_intro";
    }

    public c(CommentRectLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.a = r2;
    }

    public final boolean b(vk5.c r11) {
        vk5.a r12 = (vk5.a) r11;
        Intrinsics.checkNotNullParameter(r12, "ui");
        tt5.a.h("DrivePdfCommentOnboardMission", "show");
        String r1 = r12.getActivity().getResources().getString(2131889760);
        CommentRectF r2 = this.a.getCurrentAreaRect();
        if (r2 != null) goto L5;
        tt5.a.k("DrivePdfCommentOnboardMission", "show: currentAreaRect is null");
        return false;
    L5:
        RectF r0 = this.a.getHostWholeRectF();
        int[] r4 = new int[2];
        this.a.getLocationOnScreen(r4);
        float r3 = r4[0] + r0.left;
        float r5 = r4[1] + r0.top;
        float r6 = r0.width();
        float r7 = r0.height();
        e r8 = new e(r1, new RectF((((RectF) r2).left * r6) + r3, (((RectF) r2).top * r7) + r5, r3 + (((RectF) r2).right * r6), r5 + (((RectF) r2).bottom * r7)));
        r8.j = true;
        r8.g = Direction.UP;
        r12.d(r12.getActivity().getWindow(), r8, new d(this));
        return true;
    }
}
