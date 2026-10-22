package x4b;

import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.PageLoader;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageLoader f562476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PageLoader.b f562477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PageLoader.IReceiver f562478c;

    public /* synthetic */ k(com.ss.android.lark.chat.core.model.a r100, com.ss.android.lark.chat.core.model.c r101, PageLoader.IReceiver r102) {
        this.f562476a = r100;
        this.f562477b = r101;
        this.f562478c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PageLoader r100 = this.f562476a;
        PageLoader.b r101 = this.f562477b;
        PageLoader.IReceiver r102 = this.f562478c;
        r100.getClass();
        PageLoader.d r103 = new PageLoader.d(r102, 1);
        com.ss.android.lark.chat.core.model.a r104 = (com.ss.android.lark.chat.core.model.a) r100;
        com.ss.android.lark.chat.core.model.c r105 = (com.ss.android.lark.chat.core.model.c) r101;
        int r106 = r105.f414762a.getPosition();
        int r107 = r105.f414763b;
        r104.e(MessageFetchScene.NEXT_PAGE, r106, r107, ChannelDataFetcherStrategy.SYNC_SERVER_DATA, r103);
    }
}
