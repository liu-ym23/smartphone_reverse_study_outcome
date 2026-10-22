package jh4;

import com.bytedance.mira.MiraPluginEventListener;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements MiraPluginEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.b f499078a;

    public b(mh4.a r100) {
        this.f499078a = r100;
    }

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginLoaded(String r100) {
        ((mh4.a) this.f499078a).getClass();
        mh4.d.a();
    }

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginInstallResult(String r100, boolean r101) {
        ((mh4.a) this.f499078a).getClass();
        mh4.d.a();
    }
}
