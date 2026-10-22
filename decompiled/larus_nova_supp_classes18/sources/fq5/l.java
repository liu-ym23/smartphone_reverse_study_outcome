package fq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements tk5.c {
    public final /* synthetic */ String a;
    public final /* synthetic */ m b;

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r3) {
        tt5.a.h("WikiTreeSwipeItemOnBoarding", "click I known button, cancel left swipe");
        WikiTreeCtrlView r4 = this.b.b;
        String r0 = this.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "uid");
        r4.getWikiTreeViewFromXml().n(r0, false);
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().c("mobile_wiki_newbie_pageTree");
    }

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r2) {
        tt5.a.h("WikiTreeSwipeItemOnBoarding", "wiki tree left swipe dismiss");
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r2) {
        tt5.a.h("WikiTreeSwipeItemOnBoarding", "wiki tree left swipe cancel");
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().c("mobile_wiki_newbie_pageTree");
    }

    public l(m r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
