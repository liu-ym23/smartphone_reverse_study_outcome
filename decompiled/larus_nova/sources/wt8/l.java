package wt8;

import com.larus.bmhome.view.title.ChatTitle;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatTitle f561246a;

    public /* synthetic */ l(ChatTitle r100) {
        this.f561246a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f561246a.getBinding().f310811n.setVisibility(0);
    }
}
