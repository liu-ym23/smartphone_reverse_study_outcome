package mo7;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements co7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f514594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f514595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ShareChannelType f514596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ShareContent f514597d;

    @Override // co7.b
    public final void a() {
        kn7.b.a(10055, this.f514597d);
    }

    @Override // co7.b
    public final void b(String r100) {
        Uri r101 = oo7.f.g(this.f514594a, r100, false);
        if (r101 == null) goto L5;
        this.f514595b.add(r101);
    L5:
        d.c(this.f514594a, this.f514596c, this.f514597d, this.f514595b);
    }

    public a(Context r100, ArrayList r101, ShareChannelType r102, ShareContent r103) {
        this.f514594a = r100;
        this.f514595b = r101;
        this.f514596c = r102;
        this.f514597d = r103;
    }
}
