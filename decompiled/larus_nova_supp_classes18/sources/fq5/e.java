package fq5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.docsdk.impl.base.DocumentType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements tk5.d<vk5.a> {
    public final /* synthetic */ View a;
    public final /* synthetic */ g b;

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
        return "mobile_wiki_newbie_pageTree";
    }

    @Override // tk5.d
    public final boolean b(vk5.c r7) {
        vk5.a r8 = (vk5.a) r7;
        tt5.a.h("WikiTreeMenuOnBoarding", "show wiki tree onBoarding");
        FragmentActivity r0 = r8.getActivity();
        String r1 = r0.getResources().getString(2131888353);
        final g r2 = this.b;
        View r3 = this.a;
        r2.getClass();
        uk5.c r4 = new uk5.c(r1, r3, 0);
        r4.k = new c(r2);
        g r5 = this.b;
        r5.getClass();
        f r6 = new f(r5);
        r8.c(r0.getWindow(), r4, r6);
        return true;
    }

    public e(g r1, View r2) {
        this.b = r1;
        this.a = r2;
    }
}
