package ej7;

import android.app.Activity;
import com.bytedance.ug.sdk.luckycat.impl.bigredpacket.model.RedPacketModel;
import java.lang.ref.WeakReference;
import uj7.w;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements fj7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f472878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f472879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f472880c;

    public final void a() {
        b r100 = this.f472880c;
        r100.f472881a = RedPacketModel.getDefaultModel();
        this.f472880c.a((Activity) this.f472878a.get(), this.f472879b);
        this.f472880c.getClass();
    }

    public final void b(RedPacketModel r100) {
        b r101 = this.f472880c;
        r101.f472881a = r100;
        if (r100 != null) goto L5;
        r101.f472881a = RedPacketModel.getDefaultModel();
    L5:
        this.f472880c.a((Activity) this.f472878a.get(), this.f472879b);
        this.f472880c.getClass();
    }

    public a(b r100, WeakReference r101, w.a r102) {
        this.f472880c = r100;
        this.f472878a = r101;
        this.f472879b = "project_activity";
    }
}
