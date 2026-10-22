package oe0;

import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends i.a<ILinkPlayerInfoBridge> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f522924a;

    public c(b r100) {
        this.f522924a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r100) {
        if (r100 == null) goto L5;
        this.f522924a.d(r100);
        return;
    }
}
