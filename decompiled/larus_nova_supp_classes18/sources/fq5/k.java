package fq5;

import android.app.Dialog;
import android.graphics.RectF;
import android.view.Window;
import com.bytedance.ee.docsdk.impl.base.DocumentType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements tk5.d<vk5.a> {
    public final /* synthetic */ Dialog a;
    public final /* synthetic */ RectF b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m d;

    @Override // tk5.d
    public final String getBiz() {
        return DocumentType.WIKI_NAME;
    }

    @Override // tk5.d
    public final /* synthetic */ String getDependency() {
        return null;
    }

    @Override // tk5.d
    public final String getId() {
        return "mobile_wiki_newbie_swipeLeft";
    }

    @Override // tk5.d
    public final boolean b(vk5.c r6) {
        vk5.a r7 = (vk5.a) r6;
        tt5.a.h("WikiTreeSwipeItemOnBoarding", "show wiki tree left swipe onBoarding");
        String r0 = r7.getActivity().getResources().getString(2131888337);
        Window r2 = this.a.getWindow();
        if (r2 != null) goto L5;
        tt5.a.d("WikiTreeSwipeItemOnBoarding", "show wiki tree left swipe onBoarding failed, get window failed");
        return false;
    L5:
        uk5.c r1 = new uk5.c(r0, this.b);
        m r3 = this.d;
        String r4 = this.c;
        r3.getClass();
        r7.c(r2, r1, new l(r3, r4));
        return true;
    }

    public k(m r1, Dialog r2, RectF r3, String r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
