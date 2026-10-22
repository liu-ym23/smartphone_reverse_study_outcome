package mm5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends z {
    public final a c;

    public static final class a extends t {
        public final /* synthetic */ b c;

        public a(b r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r1) {
            com.bytedance.ee.bear.share.newshare.b r2 = this.c.c();
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public b() {
        this.c = new a(this);
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        View r0 = e();
        if (r0 != null) goto L6;
        return null;
    L6:
        int r2 = b0.f.b;
        return new d((BaseTitleBar) r0);
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        BaseTitleBar r1 = new BaseTitleBar(getContext());
        r1.setTitle(2131887832);
        r1.setMainTitleSize(17.0f);
        ShareParams r2 = this.b;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        r1.setTitle(r0.getString(2131889297));
    L14:
        int r4 = c.a;
        c.a(r1, this.c);
        return r1;
    L9:
        if (r2.getType() != 44) goto L11;
        r3 = true;
        goto L12
    }
}
