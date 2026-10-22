package fq5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements tk5.c {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    @Override // tk5.c
    public final void a(tk5.d<? extends vk5.c> r2) {
        tt5.a.h("WikiTreeMenuOnBoarding", "click next step, open wiki tree page");
        this.a.getClass();
        this.a.a.showWikiTree();
    }

    @Override // tk5.c
    public final void b(tk5.d<? extends vk5.c> r2) {
        tt5.a.h("WikiTreeMenuOnBoarding", "wiki tree guide dismiss");
        this.a.getClass();
    }

    @Override // tk5.c
    public final void c(tk5.d<? extends vk5.c> r2) {
        tt5.a.h("WikiTreeMenuOnBoarding", "skip wiki tree guide");
        ((sk5.b) org.koin.java.a.a(sk5.b.class)).b().c("mobile_wiki_newbie_swipeLeft");
    }
}
