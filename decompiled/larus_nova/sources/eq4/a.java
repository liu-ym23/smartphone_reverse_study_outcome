package eq4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.h5;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import un5.l;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f473482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DocViewModel f473483b;

    @Override // eq4.g
    public final void i1() {
        Toast.showText(this.f473482a, R.string.Bitable_Field_PleaseUpdateToViewPic);
    }

    public a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f473482a = r100.getContext();
        this.f473483b = (DocViewModel) q.a(r100, DocViewModel.class);
    }

    @Override // un5.a.InterfaceC7903a
    public final void B3(un5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        if ((r100 instanceof un5.e) == false) goto L6;
        a(((un5.e) r100).f550787e, true);
        return;
    L6:
        if ((r100 instanceof un5.h) == false) goto L9;
        a(((un5.h) r100).f550805d, false);
        return;
    L9:
        if ((r100 instanceof l) == false) goto L19;
        CharSequence r101 = null;
        k r102 = (k) org.koin.java.a.c(k.class, null, null, 6);
        String r103 = ((l) r100).f550815d;
        DocViewModel r104 = this.f473483b;
        if (r104 == null) goto L15;
        LiveData<CharSequence> r105 = r104.getTitle();
        if (r105 == null) goto L15;
        r101 = r105.getValue();
    L15:
        r102.e(r103, r101);
        return;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f473482a = r100;
    }

    public final void a(String r100, boolean r101) {
        if (p.a().v6(r100) == false) goto L32;
        DocViewModel r102 = this.f473483b;
        if (r102 == null) goto L7;
        String r103 = r102.getOriginUrl();
    L8:
        DocViewModel r104 = this.f473483b;
        if (r104 == null) goto L11;
        DocsOpenSource r105 = r104.getOpenSource();
    L13:
        if (r105 != DocsOpenSource.f216966vc) goto L15;
        boolean r106 = true;
    L17:
        if (h5.b(r100, r103, r106) == false) goto L20;
        Toast.showFailureText(this.f473482a, R.string.Doc_Doc_LinkToCurrentDoc);
        return;
    L20:
        DocViewModel r107 = this.f473483b;
        if (r107 == null) goto L23;
        String r108 = r107.getDocumentType();
    L25:
        if (Intrinsics.areEqual(r108, sbb.e.f541297h.getType()) == false) goto L28;
        String r109 = "from_parent_sheet";
    L31:
        r100 = ow4.a.a(r100, r109);
        goto L32
    L28:
        if (Intrinsics.areEqual(r108, sbb.e.f541296g.getType()) == false) goto L30;
        r109 = "from_parent_docs";
        goto L31
    L30:
        r109 = "from_parent_bitable";
        goto L31
    L23:
        r108 = null;
        goto L25
    L15:
        r106 = false;
        goto L17
    L11:
        r105 = null;
        goto L13
    L7:
        r103 = null;
    L32:
        int r110 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r111 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.encode_url_query.enable") == false) goto L36;
        if (r101 == true) goto L36;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(com.bytedance.ee.bear.bitable.utils.h.a(r100));
        return;
    L36:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r100);
    }
}
