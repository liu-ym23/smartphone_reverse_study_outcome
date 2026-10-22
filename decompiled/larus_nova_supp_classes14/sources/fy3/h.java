package fy3;

import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.collect.UserCollectViewModel;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.collect.i d;
    public final DmtTextView e;
    public final AoImageView f;
    public final LinearLayout g;
    public final e h;
    public final f i;

    @Override // f04.a
    public final void k() {
        UserCollectViewModel r0 = this.d.b;
        r0.getUserName().removeObserver(this.h);
        r0.getHeaderImage().removeObserver(this.i);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [fy3.e] */
    /* JADX WARN: Type inference failed for: r2v14, types: [fy3.f] */
    public h(com.bytedance.awemeopen.apps.framework.collect.i r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        LinearLayout r3 = (LinearLayout) i(2131392031);
        this.e = (DmtTextView) i(2131392055);
        this.f = i(2131374294);
        this.g = (LinearLayout) i(2131367144);
        this.h = new e(this);
        this.i = new f(this);
    }

    @Override // f04.a
    public final void j(Unit r4) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        UserCollectViewModel r5 = this.d.b;
        r5.getUserName().observe(this.d.c, this.h);
        r5.getHeaderImage().observe(this.d.c, this.i);
        this.f.setBackground(ContextCompat.getDrawable(getContext(), 2131231383));
    }
}
