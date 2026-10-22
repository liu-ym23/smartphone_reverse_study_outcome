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
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0017\u001a\u00020\u00122\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "viewDelegate", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel$ViewDelegate;", "appUrls", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/DocAssociatedAppUrlInfos;", "appUrlItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/associateddocs/view/AppUrlItem;", "Lkotlin/collections/ArrayList;", "itemClickListener", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel$ItemClickListener;", "getDocAssociatedAppUrls", "getAssociatedAppUrlItems", "setItemClickListener", "", "defaultAppUrlIcons", "context", "Landroid/content/Context;", "requestUrlPreview", "updateAppUrlItems", "items", "setViewDelegate", "onItemClick", "urlMetaId", "", "ViewDelegate", "Delegate", "ItemClickListener", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedAppUrlListViewModel extends ViewModel {
    private ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> appUrlItems;
    private final MutableLiveData<DocAssociatedAppUrlInfos> appUrls;
    private b itemClickListener;
    private c viewDelegate;

    public interface a {
        void a(ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r1);
    }

    public interface b {
        void a(String r1);
    }

    public interface c {
        void a();
    }

    public static final class d implements a {
        public final /* synthetic */ AssociatedAppUrlListViewModel a;

        public static final class a implements Runnable {
            public final /* synthetic */ AssociatedAppUrlListViewModel a;
            public final /* synthetic */ ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> b;

            public a(AssociatedAppUrlListViewModel r1, ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.updateAppUrlItems(this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(AssociatedAppUrlListViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel.a
        public final void a(ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r3) {
            Intrinsics.checkNotNullParameter(r3, "items");
            com.bytedance.ee.util.ui.j.f(new a(this.a, r3));
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

    public final void defaultAppUrlIcons(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        DocAssociatedAppUrlInfos r0 = (DocAssociatedAppUrlInfos) this.appUrls.getValue();
        if (r0 == null) goto L5;
        ArrayList<DocAssociatedAppUrlInfo> r1 = r0.getData();
    L6:
        ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r2 = new ArrayList();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.size() <= 0) goto L17;
        Iterator<DocAssociatedAppUrlInfo> r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        DocAssociatedAppUrlInfo r4 = r3.next();
        String r5 = r4.getPrevieToken();
        String r6 = r4.getUrl();
        String r7 = r4.getUrl();
        Drawable r8 = AppCompatResources.getDrawable(r11, 2131255013);
        String r9 = r4.getUrlMetaId();
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        r2.add(new com.bytedance.ee.bear.document.associateddocs.view.a(r5, r6, r7, r8, r9));
    L17:
        this.appUrlItems = r2;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onItemClick(String r2) {
        Intrinsics.checkNotNullParameter(r2, "urlMetaId");
        b r0 = this.itemClickListener;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void requestUrlPreview(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        DocAssociatedAppUrlInfos r0 = (DocAssociatedAppUrlInfos) this.appUrls.getValue();
        if (r0 == null) goto L6;
        ((AssociatedPreviewService) AssociatedPreviewService.c.getValue()).a(r0, r4, new d(this));
        return;
    }

    public final void setItemClickListener(b r1) {
        this.itemClickListener = r1;
    }

    public final void setViewDelegate(c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewDelegate");
        this.viewDelegate = r2;
    }

    public final void updateAppUrlItems(ArrayList<com.bytedance.ee.bear.document.associateddocs.view.a> r7) {
        Intrinsics.checkNotNullParameter(r7, "items");
        Iterator<com.bytedance.ee.bear.document.associateddocs.view.a> r0 = this.appUrlItems.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.ee.bear.document.associateddocs.view.a r1 = r0.next();
        Iterator<com.bytedance.ee.bear.document.associateddocs.view.a> r2 = r7.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        com.bytedance.ee.bear.document.associateddocs.view.a r3 = r2.next();
        if (Intrinsics.areEqual(r3.a, r1.a) == false) goto L7;
        String r4 = r3.b;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.b = r4;
        r1.d = r3.d;
        goto L4
    L11:
        c r8 = this.viewDelegate;
        if (r8 == null) goto L21;
        r8.a();
        return;
    }
}
