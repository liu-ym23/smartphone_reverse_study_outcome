package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ k1 a;
        public final /* synthetic */ WikiTreeMoreProvider b;

        public a(k1 r1, WikiTreeMoreProvider r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (this.a.getHost().getHostFragment().getContext() == null) goto L24;
            fu5.a r6 = (fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6);
            WikiTreeMoreProvider r0 = this.b;
            String r1 = r0.m.url;
            String r2 = "";
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            if (r1.length() != 0) goto L10;
            boolean r3 = true;
        L11:
            if (r3 == true) goto L21;
            if (AppInfoUtils.f().booleanValue() == false) goto L21;
            String r4 = s45.p.a().T6(r1, Integer.valueOf(r0.m.obj_type));
            if (r4 == null) goto L19;
            r2 = r4;
        L19:
            r1 = r2;
        L21:
            if (r6.p(r1, new Token("LARK-PSDA-ccm_android_wiki_tree_copy_link_set_clipboard")) == false) goto L25;
            Toast.showSuccessText(eu5.b.a, 2131887728);
            this.a.getHost().a();
            return;
        L25:
            return;
        L10:
            r3 = false;
            goto L11
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        return com.bytedance.ee.bear.more.protocol3.g.i(this, com.bytedance.ee.bear.more.protocol3.f.h.c, null, null, null, new a(this, this.c), 14);
    }

    public k1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
