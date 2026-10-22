package com.bytedance.ee.bear.wikiv2.selector;

import android.os.Bundle;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.lynx.tasm.LynxError;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class u extends BasePresenter<iq5.n, n, n.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iq5.n f241204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f241205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectorConfig f241206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f241207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f241208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ce5.a f241209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f241210g;

    public static final class a {
    }

    public interface b {
        void E5();

        void RW(iq5.o r100);

        void Ra();

        void U5();

        void V6();

        void Z3();

        void ke();

        void onCancelClick();

        void tN(int r100, td5.e r101);
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f241211a;

        public c(u r100) {
            this.f241211a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocumentListInfo r101 = (DocumentListInfo) r100;
            Intrinsics.checkNotNullParameter(r101, "documentListInfo");
            ArrayList<Document> r102 = r101.getDocumentList();
            ArrayList<Document> r103 = dd5.a.a(r102, this.f241211a.f241209f.f23449d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
            tt5.a.h("RootSelectPresenter", "loadRecentFolders()...success, rawSize = " + hu5.a.c(r102) + ", visibleSize = " + hu5.a.c(r103));
            if (hu5.a.f(r103) == false) goto L6;
            tt5.a.h("RootSelectPresenter", "loadRecentFolders()...show recent folders");
            this.f241211a.getView().I(r103);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f241212a = null;

        static {
            f241212a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.d("RootSelectPresenter", "loadRecentFolders()...error = " + r101);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f241213a;

        public e(u r100) {
            this.f241213a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            ArrayList<RecentOperationResult.a> r111 = ((RecentOperationResult.Data) ((RecentOperationResult) r110).data).getRecentList();
            int r100 = com.bytedance.ee.bear.wikiv2.selector.a.f241144a;
            boolean r101 = this.f241213a.f241209f.f23449d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible");
            if (r111 != null) goto L5;
            List<? extends RecentOperationResult.a> r102 = null;
        L25:
            StringBuilder r103 = new StringBuilder("loadRecent()...success, rawSize = ");
            r103.append(hu5.a.c(r111));
            r103.append(", visibleSize = ");
            List<? extends RecentOperationResult.a> r112 = r102;
            r103.append(hu5.a.c(r112));
            tt5.a.h("RootSelectPresenter", r103.toString());
            if (hu5.a.f(r112) == false) goto L34;
            this.f241213a.getView().u1(r102);
            return;
        L34:
            return;
        L5:
            if (r101 == false) goto L7;
            ArrayList<RecentOperationResult.a> r104 = r111;
        L24:
            r102 = CollectionsKt.take(r104, 10);
            goto L25
        L7:
            r104 = new ArrayList();
            Iterator<T> r105 = r111.iterator();
        L9:
            if (r105.hasNext() == false) goto L24;
            T r106 = r105.next();
            RecentOperationResult.a r107 = (RecentOperationResult.a) r106;
            boolean r108 = false;
            if ((r107 instanceof RecentOperationResult.FolderInfo) == false) goto L22;
            RecentOperationResult.FolderInfo r109 = (RecentOperationResult.FolderInfo) r107;
            int r113 = r109.getType();
            long r114 = r109.getObjSubType();
            if (r113 == 0) goto L15;
        L19:
            boolean r115 = false;
        L20:
            if (r115 == false) goto L22;
            r108 = true;
            goto L22
        L15:
            if (r114 != 140) goto L17;
        L18:
            r115 = true;
            goto L20
        L17:
            if (r114 != 141) goto L19;
        L22:
            if (r108 == true) goto L9;
            r104.add(r106);
            goto L9
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T> f241214a = null;

        static {
            f241214a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("RootSelectPresenter", "loadRecent()...error = " + ((Throwable) r100));
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new v(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        if (this.f241206c.f229372d == true) goto L6;
        tt5.a.h("RootSelectPresenter", "create()...enableShowRecent = false");
        return;
    L6:
        boolean r100 = true;
        if ((!com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a()) == false) goto L10;
        tt5.a.h("RootSelectPresenter", "loadData()...offline, hide recently used group");
        return;
    L10:
        Disposable r101 = this.f241210g;
        if (r101 != null) goto L13;
    L15:
        r100 = false;
    L16:
        if (r100 == false) goto L21;
        Disposable r102 = this.f241210g;
        if (r102 == null) goto L21;
        r102.dispose();
    L21:
        if (this.f241206c.f229373e == false) goto L23;
        this.f241210g = getModel().P6().subscribe(new c(this), d.f241212a);
        return;
    L23:
        qc5.a.i(this.f241209f);
        this.f241210g = getModel().F0().subscribe(new e(this), f.f241214a);
        return;
    L13:
        if (r101.isDisposed() == true) goto L15;
        goto L15
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        Disposable r100 = this.f241210g;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L13;
        Disposable r102 = this.f241210g;
        if (r102 == null) goto L14;
        r102.dispose();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L8
    }

    public u(t r100, w r101, SelectorConfig r102, Bundle r103, b r104, ce5.a r105) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "selectorConfig");
        Intrinsics.checkNotNullParameter(r104, "dependence");
        Intrinsics.checkNotNullParameter(r105, "userComponentAbility");
        super(r100, r101);
        this.f241204a = r100;
        this.f241205b = r101;
        this.f241206c = r102;
        this.f241207d = r103;
        this.f241208e = r104;
        this.f241209f = r105;
    }
}
