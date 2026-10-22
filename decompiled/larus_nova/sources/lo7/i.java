package lo7;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends a {
    public i(Context r100) {
        super(r100);
    }

    @Override // no7.a
    public final boolean a(ShareContent r100) {
        this.f510133b = r100;
        return mo7.d.b(this.f510132a, ShareChannelType.SYSTEM, r100);
    }
}
