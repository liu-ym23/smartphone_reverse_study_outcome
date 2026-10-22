package com.bytedance.ee.bear.wikiv2.selector;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u extends BasePresenter<iq5.n, n, n.a> {
    public final iq5.n a;
    public final n b;
    public final SelectorConfig c;
    public final Bundle d;
    public final b e;
    public final ce5.a f;
    public Disposable g;

    public static final class a {
    }

    public interface b {
        void E5();

        void RW(iq5.o r1);

        void Ra();

        void U5();

        void V6();

        void Z3();

        void ke();

        void onCancelClick();

        void tN(int r1, td5.e r2);
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ u a;

        public c(u r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            DocumentListInfo r5 = (DocumentListInfo) r4;
            Intrinsics.checkNotNullParameter(r5, "documentListInfo");
            ArrayList<Document> r6 = r5.getDocumentList();
            ArrayList<Document> r0 = dd5.a.a(r6, this.a.f.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
            tt5.a.h("RootSelectPresenter", "loadRecentFolders()...success, rawSize = " + hu5.a.c(r6) + ", visibleSize = " + hu5.a.c(r0));
            if (hu5.a.f(r0) == false) goto L6;
            tt5.a.h("RootSelectPresenter", "loadRecentFolders()...show recent folders");
            ((n) this.a.getView()).I(r0);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d("RootSelectPresenter", "loadRecentFolders()...error = " + r4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ u a;

        public e(u r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            ArrayList<RecentOperationResult.a> r12 = ((RecentOperationResult.Data) ((Result) ((RecentOperationResult) r11)).data).getRecentList();
            int r0 = com.bytedance.ee.bear.wikiv2.selector.a.a;
            boolean r1 = this.a.f.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible");
            if (r12 != null) goto L5;
            List<? extends RecentOperationResult.a> r2 = null;
        L25:
            StringBuilder r3 = new StringBuilder("loadRecent()...success, rawSize = ");
            r3.append(hu5.a.c(r12));
            r3.append(", visibleSize = ");
            List<? extends RecentOperationResult.a> r13 = r2;
            r3.append(hu5.a.c(r13));
            tt5.a.h("RootSelectPresenter", r3.toString());
            if (hu5.a.f(r13) == false) goto L34;
            ((n) this.a.getView()).u1(r2);
            return;
        L34:
            return;
        L5:
            if (r1 == false) goto L7;
            ArrayList<RecentOperationResult.a> r4 = r12;
        L24:
            r2 = CollectionsKt.take(r4, 10);
            goto L25
        L7:
            r4 = new ArrayList();
            Iterator<T> r5 = r12.iterator();
        L9:
            if (r5.hasNext() == false) goto L24;
            T r6 = r5.next();
            RecentOperationResult.a r7 = (RecentOperationResult.a) r6;
            boolean r8 = false;
            if ((r7 instanceof RecentOperationResult.FolderInfo) == false) goto L22;
            RecentOperationResult.FolderInfo r9 = (RecentOperationResult.FolderInfo) r7;
            int r10 = r9.getType();
            long r14 = r9.getObjSubType();
            if (r10 == 0) goto L15;
        L19:
            boolean r15 = false;
        L20:
            if (r15 == false) goto L22;
            r8 = true;
            goto L22
        L15:
            if (r14 != 140) goto L17;
        L18:
            r15 = true;
            goto L20
        L17:
            if (r14 != 141) goto L19;
        L22:
            if (r8 == true) goto L9;
            r4.add(r6);
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            tt5.a.d("RootSelectPresenter", "loadRecent()...error = " + ((Throwable) r3));
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new v(this);
    }

    public final void create() {
        super.create();
        if (this.c.d == true) goto L6;
        tt5.a.h("RootSelectPresenter", "create()...enableShowRecent = false");
        return;
    L6:
        boolean r2 = true;
        if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L10;
        tt5.a.h("RootSelectPresenter", "loadData()...offline, hide recently used group");
        return;
    L10:
        Disposable r0 = this.g;
        if (r0 != null) goto L13;
    L15:
        r2 = false;
    L16:
        if (r2 == false) goto L21;
        Disposable r1 = this.g;
        if (r1 == null) goto L21;
        r1.dispose();
    L21:
        if (this.c.e == false) goto L23;
        this.g = ((iq5.n) getModel()).P6().subscribe(new c(this), d.a);
        return;
    L23:
        qc5.a.i(this.f);
        this.g = ((iq5.n) getModel()).F0().subscribe(new e(this), f.a);
        return;
    L13:
        if (r0.isDisposed() == true) goto L15;
        goto L15
    }

    public final void destroy() {
        super.destroy();
        Disposable r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        Disposable r2 = this.g;
        if (r2 == null) goto L14;
        r2.dispose();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L8
    }

    public u(t r2, w r3, SelectorConfig r4, Bundle r5, b r6, ce5.a r7) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "selectorConfig");
        Intrinsics.checkNotNullParameter(r6, "dependence");
        Intrinsics.checkNotNullParameter(r7, "userComponentAbility");
        super(r2, r3);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
