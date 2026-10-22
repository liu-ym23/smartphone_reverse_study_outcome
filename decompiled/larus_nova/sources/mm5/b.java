package mm5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f514465c;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f514466c;

        public a(b r100) {
            this.f514466c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            com.bytedance.ee.bear.share.newshare.b r101 = this.f514466c.c();
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    public b() {
        this.f514465c = new a(this);
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        View r100 = e();
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = b0.f.f237193b;
        return new d((BaseTitleBar) r100);
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return null;
    L6:
        BaseTitleBar r101 = new BaseTitleBar(getContext());
        r101.setTitle(R.string.Doc_Facade_Share);
        r101.setMainTitleSize(17.0f);
        ShareParams r102 = this.f237245b;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        r101.setTitle(r100.getString(R.string.LarkCCM_Docs_SyncBlock_ManageCollaborators_Title));
    L14:
        int r104 = c.f514467a;
        c.a(r101, this.f514465c);
        return r101;
    L9:
        if (r102.getType() != 44) goto L11;
        r103 = true;
        goto L12
    }
}
