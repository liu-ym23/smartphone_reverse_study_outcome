package com.bytedance.android.livesdk.livecommerce.livereplay.presenter;

import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.arch.event.c;
import com.bytedance.android.livesdk.livecommerce.livereplay.adapter.ECScrollProductCardAdapter;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECContainerUIPresenter extends QPresenter {
    public static final /* synthetic */ int g = 0;
    public final String e;
    public final ViewModelProvider.Factory f;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECScrollProductCardAdapter a;

        public b(ECScrollProductCardAdapter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            PagedList<T> r3 = (PagedList) r2;
            ECScrollProductCardAdapter r0 = this.a;
            if (r0 == null) goto L6;
            r0.submitList(r3);
            return;
        }
    }

    static {
    }

    public final void A(QModel r15) {
        int r16 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
        final AbsECScrollProductCardBaseVideModel r17 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a(u(), this.e, this.f);
        if (r17 != null) goto L5;
        return;
    L5:
        RecyclerView r0 = w().f();
        if (r0.getAdapter() != null) goto L8;
        r0.setAdapter(new ECScrollProductCardAdapter(new ni2.b(r17.getFunType(), r17.getRoomInfo(), r17.getHistoryMap(), r17.getBtmInfo(), r17.getEcomSceneId(), r17.getReplayId(), r17.getEntranceInfos(), this.e, r17.getParams(), this.f), r0));
        r0.addOnScrollListener(new ECContainerUIPresenter$onBind$1(r17));
    L8:
        RecyclerView.Adapter r1 = r0.getAdapter();
        LinearLayoutManager r3 = null;
        if ((r1 instanceof ECScrollProductCardAdapter) == true) goto L11;
        r1 = null;
    L11:
        final ECScrollProductCardAdapter r2 = (ECScrollProductCardAdapter) r1;
        c.c(r17, u().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.a.e.class), new ECContainerUIPresenter$onBind$2(r2));
        LinearLayoutManager r4 = r0.getLayoutManager();
        if ((r4 instanceof LinearLayoutManager) == false) goto L15;
        r3 = r4;
    L15:
        final LinearLayoutManager r5 = r3;
        com.bytedance.android.ec.core.arch.state.c.a(r17, u().e(), ECContainerUIPresenter$onBind$3.INSTANCE, new ECContainerUIPresenter$onBind$4(this, r2, r5));
        c.c(r17, u().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.a.g.class), new ECContainerUIPresenter$onBind$5(this, r2, r5));
        r17.getPagedList().observe(u().e(), new b(r2));
    }

    public ECContainerUIPresenter(String r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.e = r2;
        this.f = r3;
    }
}
