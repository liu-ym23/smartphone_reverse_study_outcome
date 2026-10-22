package com.bytedance.ee.bear.document.associateddocs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.associateddocs.bean.DocAssociatedAppUrlInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.DocAssociatedAppUrlInfos;
import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0017\u001a\u00020\u00122\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "viewDelegate", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel$ViewDelegate;", "appUrls", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/DocAssociatedAppUrlInfos;", "appUrlItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/associateddocs/view/AppUrlItem;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel$ItemClickListener;", "getDocAssociatedAppUrls", "getAssociatedAppUrlItems", "setItemClickListener", "", "defaultAppUrlIcons", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "requestUrlPreview", "updateAppUrlItems", "items", "setViewDelegate", "onItemClick", "urlMetaId", "", "ViewDelegate", "Delegate", "ItemClickListener", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedAppUrlListViewModel extends ViewModel {
    private ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> appUrlItems;
    private final MutableLiveData<DocAssociatedAppUrlInfos> appUrls;
    private b itemClickListener;
    private c viewDelegate;

    public interface a {
        void a(ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r100);
    }

    public interface b {
        void a(String r100);
    }

    public interface c {
        void a();
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssociatedAppUrlListViewModel f218979a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AssociatedAppUrlListViewModel f218980a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> f218981b;

            public a(AssociatedAppUrlListViewModel r100, ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r101) {
                this.f218980a = r100;
                this.f218981b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f218980a.updateAppUrlItems(this.f218981b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(AssociatedAppUrlListViewModel r100) {
            this.f218979a = r100;
        }

        @Override // com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel.a
        public final void a(ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            com.bytedance.ee.util.ui.j.f(new a(this.f218979a, r100));
        }
    }

    public AssociatedAppUrlListViewModel() {
        this.appUrls = new MutableLiveData();
        this.appUrlItems = new ArrayList();
    }

    public final ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> getAssociatedAppUrlItems() {
        return this.appUrlItems;
    }

    public final MutableLiveData<DocAssociatedAppUrlInfos> getDocAssociatedAppUrls() {
        return this.appUrls;
    }

    public final void defaultAppUrlIcons(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        DocAssociatedAppUrlInfos r100 = this.appUrls.getValue();
        if (r100 == null) goto L5;
        ArrayList<DocAssociatedAppUrlInfo> r101 = r100.getData();
    L6:
        ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r102 = new ArrayList();
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.size() <= 0) goto L17;
        Iterator<DocAssociatedAppUrlInfo> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        DocAssociatedAppUrlInfo r104 = r103.next();
        String r105 = r104.getPrevieToken();
        String r106 = r104.getUrl();
        String r107 = r104.getUrl();
        Drawable r108 = AppCompatResources.getDrawable(r110, R.drawable.ud_icon_link_copy_outlined);
        String r109 = r104.getUrlMetaId();
        if (r109 != null) goto L16;
        r109 = "";
    L16:
        r102.add(new com.bytedance.ee.bear.document.associateddocs.view.a(r105, r106, r107, r108, r109));
    L17:
        this.appUrlItems = r102;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void onItemClick(String r100) {
        Intrinsics.checkNotNullParameter(r100, "urlMetaId");
        b r101 = this.itemClickListener;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void requestUrlPreview(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        DocAssociatedAppUrlInfos r101 = this.appUrls.getValue();
        if (r101 == null) goto L6;
        AssociatedPreviewService.f219010c.getValue().a(r101, r100, new d(this));
        return;
    }

    public final void setItemClickListener(b r100) {
        this.itemClickListener = r100;
    }

    public final void setViewDelegate(c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewDelegate");
        this.viewDelegate = r100;
    }

    public final void updateAppUrlItems(ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Iterator<com.bytedance.ee.bear.document.associateddocs.view.a> r101 = this.appUrlItems.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        com.bytedance.ee.bear.document.associateddocs.view.a r102 = r101.next();
        Iterator<com.bytedance.ee.bear.document.associateddocs.view.a> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        com.bytedance.ee.bear.document.associateddocs.view.a r104 = r103.next();
        if (Intrinsics.areEqual(r104.f219038a, r102.f219038a) == false) goto L7;
        String r105 = r104.f219039b;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r102.f219039b = r105;
        r102.f219041d = r104.f219041d;
        goto L4
    L11:
        c r106 = this.viewDelegate;
        if (r106 == null) goto L21;
        r106.a();
        return;
    }
}
