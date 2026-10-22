package mo7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements co7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareContent f514598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f514599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ShareChannelType f514600c;

    @Override // co7.e
    public final void a() {
        kn7.b.a(10066, this.f514598a);
    }

    @Override // co7.e
    public final void b(String r100) {
        kn7.b.a(10000, this.f514598a);
        Intent r101 = new Intent();
        r101.setAction("android.intent.action.SEND");
        r101.setType("video/*");
        r101.putExtra("android.intent.extra.STREAM", oo7.f.g(this.f514599b, r100, true));
        kn7.a r102 = this.f514598a.getExtraParams();
        if (r102 == null) goto L7;
        Object r103 = r102.f504254h;
        if ((r103 instanceof kn7.c) == false) goto L7;
        ((kn7.c) r103).getClass();
        String r104 = null;
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L11;
        r104 = this.f514599b.getString(R.string.share_sdk_action_system_share);
    L11:
        d.a(this.f514599b, r101, this.f514600c, r104);
        return;
    L7:
        r104 = "";
        goto L9
    }

    public b(ShareContent r100, Context r101, ShareChannelType r102) {
        this.f514598a = r100;
        this.f514599b = r101;
        this.f514600c = r102;
    }
}
