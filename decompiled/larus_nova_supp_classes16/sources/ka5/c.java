package ka5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import i75.g;
import z95.d;
import z95.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final Context a;

    public c(FragmentActivity r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.LinearLayout, com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView] */
    public final FailedToRetryView a(ViewOwner r7, PreviewViewModel r8) {
        String r0 = this.a.getString(2131888419);
        if (g.a() == false) goto L5;
    L6:
        r0 = this.a.getResources().getString(2131887130);
    L7:
        ?? r1 = new FailedToRetryView(this.a);
        r1.g = r8;
        DriveBlockViewSwitchManager r2 = new DriveBlockViewSwitchManager(r7);
        if (r2.b.getLiveBlockState().getValue() == null) goto L10;
        boolean r3 = true;
    L11:
        r1.d = r3;
        r1.g.liveOuterNetState().observe(r7.lifecycleOwner(), new d(r1));
        r2.a(new h(r1));
        r1.setDescriptionText(r0);
        r1.setRetryClickListener(new b(r8));
        r1.f();
        r1.setVisibility(0);
        return r1;
    L10:
        r3 = false;
        goto L11
    L5:
        if (g.b() == false) goto L7;
        goto L6
    }
}
