package com.bytedance.android.shopping.order;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.shopping.order.api.OrderApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJB\u0010\u0015\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\n\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012J\u0006\u0010\u0016\u001a\u00020\u0007R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/order/PreviewPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "", "getPanelState", "Lcg3/e;", "getShareInfoVOState", "", "init", "Ltl/a;", "param", "configShareInfo", "Landroid/content/Context;", "commentPageContext", "Lcg3/g;", "", "videoPath", "musicId", "Lkotlin/Function1;", "", "loadingAnimCallback", "publishCommentAndVideo", "unbind", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "panelState", "Landroidx/lifecycle/MutableLiveData;", "shareInfoVO", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewPanelViewModel extends ViewModel {
    public static final a Companion = null;
    public static final int STATE_ERROR = 2;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_SUCCESS = 1;
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Integer> panelState;
    private final MutableLiveData<cg3.e> shareInfoVO;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PreviewPanelViewModel a;

        public b(PreviewPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            cg3.h r3 = (cg3.h) r2;
            if (r3 == null) goto L6;
            PreviewPanelViewModel.access$getShareInfoVO$p(this.a).setValue(r3.a());
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PreviewPanelViewModel a;

        public c(PreviewPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            PreviewPanelViewModel.access$getPanelState$p(this.a).setValue(2);
        }
    }

    static {
        Companion = new a();
    }

    public final void init() {
        this.panelState.setValue(0);
    }

    public final void unbind() {
        this.compositeDisposable.clear();
    }

    public PreviewPanelViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.panelState = new MutableLiveData();
        this.shareInfoVO = new MutableLiveData();
    }

    public final LiveData<Integer> getPanelState() {
        return this.panelState;
    }

    public final LiveData<cg3.e> getShareInfoVOState() {
        return this.shareInfoVO;
    }

    public static final /* synthetic */ MutableLiveData access$getPanelState$p(PreviewPanelViewModel r0) {
        return r0.panelState;
    }

    public static final /* synthetic */ MutableLiveData access$getShareInfoVO$p(PreviewPanelViewModel r0) {
        return r0.shareInfoVO;
    }

    public final void configShareInfo(tl.a r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        CompositeDisposable r0 = this.compositeDisposable;
        OrderApi.a.getClass();
        r0.add(bg4.b.b(OrderApi.a.a.getShareInfo(r12.a, r12.b, r12.c, r12.d, r12.e, r12.f, null, null)).subscribe(new b(this), new c(this)));
    }

    public final void publishCommentAndVideo(Context r13, cg3.g r14, String r15, String r16, final Function1<? super Boolean, Unit> r17) {
        Intrinsics.checkNotNullParameter(r17, "loadingAnimCallback");
        if (r14 == null) goto L12;
        if (r15 == null) goto L13;
        Boolean r3 = Boolean.TRUE;
        r17.invoke(r3);
        CompositeDisposable r10 = this.compositeDisposable;
        Handler r4 = PublishUtil.a;
        cg3.e r5 = (cg3.e) this.shareInfoVO.getValue();
        final Function2<Boolean, String, Unit> r6 = new AnonymousClass1(this);
        Function1<Throwable, Unit> r11 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r6, "onPublishFinished");
        Intrinsics.checkNotNullParameter(r11, "onError");
        Unit r7 = (Unit) r17.invoke(r3);
        List<cg3.f> r8 = r14.d;
        if (r8 == null) goto L9;
        cg3.f r9 = (cg3.f) CollectionsKt.firstOrNull(r8);
    L10:
        r10.add(PublishUtil.d(r14, null, r5, r17).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r13, r9, r15, r16, new PublishUtil$publishCommentAndVideo$onFinished$1(r17, r6)), new g(r11)));
        return;
    L9:
        r9 = null;
        goto L10
    L13:
        return;
    }
}
