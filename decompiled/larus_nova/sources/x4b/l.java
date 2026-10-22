package x4b;

import com.ss.android.lark.chat.core.model.PageLoader;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageLoader f562479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PageLoader.b f562480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PageLoader.IReceiver f562481c;

    public /* synthetic */ l(com.ss.android.lark.chat.core.model.a r100, com.ss.android.lark.chat.core.model.c r101, PageLoader.IReceiver r102) {
        this.f562479a = r100;
        this.f562480b = r101;
        this.f562481c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PageLoader r100 = this.f562479a;
        PageLoader.b r101 = this.f562480b;
        PageLoader.IReceiver r102 = this.f562481c;
        r100.getClass();
        PageLoader.d r103 = new PageLoader.d(r102, 0);
        com.ss.android.lark.chat.core.model.a r104 = (com.ss.android.lark.chat.core.model.a) r100;
        com.ss.android.lark.chat.core.model.c r105 = (com.ss.android.lark.chat.core.model.c) r101;
        int r106 = r105.f414762a.getPosition();
        int r107 = r105.f414763b;
        r104.e(r105.f414776c, r106, r107, r105.f414777d, r103);
    }
}
