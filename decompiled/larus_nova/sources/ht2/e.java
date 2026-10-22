package ht2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.logsdk.format.Spm;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements a1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f487109a;

    public e(View r100) {
        this.f487109a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a1.b
    public final void a(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        if (s1.getResources() == null) goto L5;
        Resources r101 = s1.getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density / 3.0f;
    L6:
        NinePatchDrawable r103 = a1.g(r100, r102, true, true);
        s1.H(this.f487109a, r103);
        View r104 = this.f487109a;
        if (r104 == null) goto L10;
        r104.setPadding(0, 0, 0, 0);
        return;
    L10:
        return;
    L5:
        r102 = 1.0f;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a1.b
    public final void onFail(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.b7000").result(101).addArg("error_msg", "load nine patch error!"), "crash");
    }
}
