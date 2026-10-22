package dl0;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f469061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b f469062b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f469061a.setText(this.f469062b.f87276a);
    }

    public d(TextView r100, com.bytedance.android.live.profit.fansclub.b r101) {
        this.f469061a = r100;
        this.f469062b = r101;
    }
}
