package ln4;

import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.larksuite.component.card.protocol.CardData;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements com.bytedance.ee.bear.atfinder.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f510021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f510022b;

    @Override // com.bytedance.ee.bear.atfinder.g
    public final void a() {
        com.bytedance.ee.bear.atfinder.g r100 = this.f510022b.f510029g;
        if (r100 == null) goto L11;
        int r101 = this.f510021a;
        if (r100 != null) goto L7;
        int r102 = -1;
    L8:
        if (r101 != r102) goto L10;
        r100.a();
        return;
    L10:
        tt5.a.h(CardData.TAG, "onSearchStart(): Identity has changed");
        return;
    L7:
        r102 = System.identityHashCode(r100);
        goto L8
    L11:
        tt5.a.h(CardData.TAG, "onSearchStart(): getSearchCallback() == null");
    }

    @Override // com.bytedance.ee.bear.atfinder.g
    public final void b(AtFinderResult r100) {
        com.bytedance.ee.bear.atfinder.g r101 = this.f510022b.f510029g;
        if (r101 == null) goto L11;
        int r102 = this.f510021a;
        if (r101 != null) goto L7;
        int r103 = -1;
    L8:
        if (r102 != r103) goto L10;
        r101.b(r100);
        return;
    L10:
        tt5.a.h(CardData.TAG, "onSearchResult(): Identity has changed");
        return;
    L7:
        r103 = System.identityHashCode(r101);
        goto L8
    L11:
        tt5.a.h(CardData.TAG, "onSearchResult(): getSearchCallback() == null");
    }

    public l(m r100, int r101) {
        this.f510022b = r100;
        this.f510021a = r101;
    }
}
