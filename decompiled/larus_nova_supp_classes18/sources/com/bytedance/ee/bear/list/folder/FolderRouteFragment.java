package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import uc5.j1;
import uc5.k1;
import uc5.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderRouteFragment extends BaseFragment {
    public static final /* synthetic */ int k = 0;
    public String e;
    public final CompositeDisposable f;
    public Disposable g;
    public LinearLayout h;
    public LinearLayout i;
    public b j;

    public class a extends t {
        public final /* synthetic */ FolderRouteFragment c;

        public a(FolderRouteFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            FolderRouteFragment r3 = this.c;
            int r0 = FolderRouteFragment.k;
            r3.V90();
        }
    }

    public interface b {
        void lc(int r1);
    }

    public final void V90() {
        tt5.a.h("FolderRouteFragment", "route()...");
        this.f.clear();
        tt5.a.h("FolderRouteFragment", "showLoading()...");
        hideLoading();
        this.g = Flowable.timer(300, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new n1(this));
        String r0 = this.e;
        int r1 = sbb.e.f.b;
        int r2 = md5.e.a;
        Intrinsics.checkNotNullParameter(r0, "objToken");
        Disposable r3 = md5.e.a(r0, r1).map(new md5.d()).subscribe(new j1(this), new k1(this));
        this.f.add(r3);
    }

    public final void hideLoading() {
        tt5.a.h("FolderRouteFragment", "hideLoading()...");
        Disposable r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        this.h.setVisibility(8);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.g.dispose();
        goto L7
    }

    public FolderRouteFragment() {
        this.f = new CompositeDisposable();
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("FolderRouteFragment", "onDestroy()...");
        hideLoading();
        this.f.clear();
    }

    public final void U90(int r3) {
        tt5.a.h("FolderRouteFragment", "openFolder()...ownerType = " + r3);
        b r0 = this.j;
        if (r0 == null) goto L6;
        r0.lc(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Context r2) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        if ((r2 instanceof b) == false) goto L6;
        this.j = (b) r2;
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        this.e = r4.getString(ResourceData.KEY_TOKEN, "");
        return;
    L5:
        tt5.a.h("FolderRouteFragment", "onCreate()...bundle is null, finish!");
        tt5.a.h("FolderRouteFragment", "finish()...");
        if (getActivity() == null) goto L10;
        getActivity().finish();
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        LinearLayout r4 = (LinearLayout) r2.findViewById(2131367556);
        this.i = r4;
        r4.setOnClickListener(new a(this));
        this.h = (LinearLayout) r2.findViewById(2131367564);
        V90();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131561214, r3, false);
    }
}
