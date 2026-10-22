package zib;

import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import z5c.a2;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchBaseInfo f572338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f572339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s5c.d f572340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s5c.d f572341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f572342e;

    public g(SearchBaseInfo r100, boolean r101, s5c.a r102, s5c.a r103, boolean r104) {
        this.f572338a = r100;
        this.f572339b = r101;
        this.f572340c = r102;
        this.f572341d = r103;
        this.f572342e = r104;
    }

    public final void a() {
        a2 r100 = a2.f570151c;
        int r101 = e.f572329a;
        s5c.a r102 = r100.a(e.a.a(this.f572338a));
        s5c.d.a r103 = s5c.d.f540773o2;
        if (this.f572339b == false) goto L5;
        String r104 = "search";
    L6:
        r103.getClass();
        s5c.a r105 = new s5c.a(ShareConstants.KEY_PANEL_TYPE, r104);
        com.ss.android.lark.forwardv3.utils.b.d();
        s5c.a r106 = new s5c.a("panel_version", "integration_portrait_display");
        s5c.d r107 = this.f572340c.plus(this.f572341d).plus(r105).plus(r102).plus(r106);
        r107.plus(new s5c.a("is_knowledge_ai_show", String.valueOf(this.f572342e)));
        e.a.c(r107);
        return;
    L5:
        r104 = "recommend";
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
