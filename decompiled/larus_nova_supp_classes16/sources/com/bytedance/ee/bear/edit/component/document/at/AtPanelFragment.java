package com.bytedance.ee.bear.edit.component.document.at;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.atbottombar.AtBottomBar;
import com.bytedance.ee.bear.atfinder.AtCheckBoxViewModel;
import com.bytedance.ee.bear.atfinder.AtFinderJsCallbackData;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import ln4.m;
import sa5.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AtPanelFragment extends BaseFragment implements ocb.a {
    public static final /* synthetic */ int n = 0;
    public EditPanelsManager e;
    public AtPanelViewModel f;
    public FragmentActivity g;
    public AtCheckBoxViewModel h;
    public final j i;
    public AtBottomBar j;
    public FlowableEmitter<AtFinderJsCallbackData> k;
    public final CompositeDisposable l;
    public final CompositeDisposable m;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h("AtPanelFragment", "onClick(): ");
        }
    }

    public class b implements Observer<Integer> {
        public final /* synthetic */ AtPanelFragment a;

        public b(AtPanelFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            this.a.j.setTitleBarLocationY(((Integer) r2).intValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.edit.component.document.at.j] */
    public AtPanelFragment() {
        this.i = new j(this);
        this.l = new CompositeDisposable();
        this.m = new CompositeDisposable();
        com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docs.all.synced_block_enable");
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getSupportFragmentManager().isDestroyed() == true) goto L9;
        pcb.a.a.b(getActivity()).a(this);
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.ee.util.ui.j.e(this.i);
        this.l.clear();
        this.m.clear();
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        tt5.a.b("AtPanelFragment", "onCreate");
        this.g = getActivity();
        this.f = (AtPanelViewModel) q.a(this, AtPanelViewModel.class);
        this.h = ViewModelProviders.of(this).get(AtCheckBoxViewModel.class);
        EditPanelsManager r3 = this.f.getEditPanelsManager();
        this.e = r3;
        r3.getActiveEditPanel().observe(this, new i(this));
        pcb.a.a.b(getActivity()).c(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        r5.setOnClickListener(new a());
        com.bytedance.ee.bear.atbottombar.b.a r7 = new c(this);
        AtBottomBar r8 = r5.findViewById(2131363303);
        this.j = r8;
        r8.setCardsData(((com.bytedance.ee.bear.document.at.q) this.f.getMentionDelegate()).a);
        this.j.setAtCommonConfig(this.f.getMentionDelegate().a());
        this.j.setDelegate(r7);
        this.f.titleBarLocationLiveData().observe(getViewLifecycleOwner(), new b(this));
        ViewGroup r9 = this.j;
        if (((AtBottomBar) r9).b != null) goto L13;
        int r10 = 0;
    L7:
        if (r10 >= ((AtBottomBar) r9).j.size()) goto L9;
        m r0 = (m) ListProtector.get(((AtBottomBar) r9).j, r10);
        com.bytedance.ee.bear.atbottombar.b r1 = new com.bytedance.ee.bear.atbottombar.b(((AtBottomBar) r9).a, r0, ((AtBottomBar) r9).k, r9);
        r1.e = ((AtBottomBar) r9).m;
        r1.d = r0.d;
        r0.g = new ln4.b(r9, r10, r0);
        ((ArrayList) ((AtBottomBar) r9).c).add(r1);
        r10 = r10 + 1;
        goto L7
    L9:
        ((AtBottomBar) r9).i = ((AtBottomBar) r9).k.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.optimizing_authorizaiton") == false) goto L12;
        ((AtBottomBar) r9).b = new AtBottomBar.d(r9, LayoutInflater.from(((AtBottomBar) r9).a).inflate(2131558738, r9));
        goto L13
    L12:
        ((AtBottomBar) r9).b = new AtBottomBar.e(r9, LayoutInflater.from(((AtBottomBar) r9).a).inflate(2131558732, r9));
    L13:
        Disposable r11 = Flowable.create(new d(this), BackpressureStrategy.BUFFER).debounce(300, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).map(new e(this)).subscribe(new f(), new g());
        this.l.add(r11);
        this.f.getAtFinderLiveData().observe(getViewLifecycleOwner(), new h(this));
        this.j.setTouchMonitor((v) sa5.m.a.a(this.g, v.class));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131559938, r3, false);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        if (r2 != 0) goto L7;
        AtBottomBar r4 = this.j;
        if (r4 == null) goto L8;
        r4.a(true);
        this.e.setPanelHeight(0, "AtPanel");
        return;
    L8:
        return;
    }
}
