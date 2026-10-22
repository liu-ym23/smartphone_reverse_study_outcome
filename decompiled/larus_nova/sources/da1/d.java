package da1;

import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f467665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IRoom f467666b;

    public d(c r100, IRoom r101) {
        this.f467665a = r100;
        this.f467666b = r101;
    }

    @Override // com.bytedance.android.livesdk.app.dataholder.Observer
    public final void onChanged(Object r100) {
        if (((bz.a) r100) == null) goto L6;
        T r101 = this.f467665a.f531633a;
        return;
    }
}
