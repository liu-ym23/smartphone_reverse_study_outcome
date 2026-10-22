package com.larus.bmhome.chat.list.datasource.adapter;

import android.os.Looper;
import androidx.recyclerview.widget.ListUpdateCallback;
import bh8.e;
import bh8.f;
import bh8.h;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.bmhome.chat.list.base.MessageCellAdapter;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0007R\u001a\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapterListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "pagingAdapter", "Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapter;", "<init>", "(Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapter;)V", "onInserted", "", "position", "", "count", "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", WsConstants.KEY_PAYLOAD, "", "logSubThreadStackTrace", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PagingAdapterListUpdateCallback implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagingAdapter<?, ?, ?> f306604a;

    public static final class a implements Function1<?, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f306605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f306606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f306607c;

        public a(int r100, int r101, Object r102) {
            this.f306605a = r100;
            this.f306606b = r101;
            this.f306607c = r102;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object r100) {
            MessageCellAdapter r101 = (MessageCellAdapter) r100;
            Intrinsics.checkNotNullParameter(r101, "$this$safeNotify");
            r101.notifyItemRangeChanged(this.f306605a, this.f306606b, this.f306607c);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<?, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f306608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f306609b;

        public b(int r100, int r101) {
            this.f306608a = r100;
            this.f306609b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object r100) {
            MessageCellAdapter r101 = (MessageCellAdapter) r100;
            Intrinsics.checkNotNullParameter(r101, "$this$safeNotify");
            r101.notifyItemRangeInserted(this.f306608a, this.f306609b);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<?, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f306610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f306611b;

        public c(int r100, int r101) {
            this.f306610a = r100;
            this.f306611b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object r100) {
            MessageCellAdapter r101 = (MessageCellAdapter) r100;
            Intrinsics.checkNotNullParameter(r101, "$this$safeNotify");
            r101.notifyItemMoved(this.f306610a, this.f306611b);
            return Unit.INSTANCE;
        }
    }

    public static final class d implements Function1<?, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f306612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f306613b;

        public d(int r100, int r101) {
            this.f306612a = r100;
            this.f306613b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object r100) {
            MessageCellAdapter r101 = (MessageCellAdapter) r100;
            Intrinsics.checkNotNullParameter(r101, "$this$safeNotify");
            r101.notifyItemRangeRemoved(this.f306612a, this.f306613b);
            return Unit.INSTANCE;
        }
    }

    public final void a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        String r100 = ArraysKt.joinToString$default(ThreadMethodProxy.currentThread().getStackTrace(), "\n", null, null, 0, null, null, 62, null);
        FLogger.f375446a.e("PagingAdapterListUpdateCallback", r100);
        g.f365738a.ensureNotReachHere(new IllegalStateException("PagingAdapterListUpdateCallback sub thread update"));
        return;
    }

    public PagingAdapterListUpdateCallback(PagingAdapter<?, ?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "pagingAdapter");
        this.f306604a = r100;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onInserted(final int r100, final int r101) {
        t0.e(new h(r100, r101, this));
        a();
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onMoved(final int r100, final int r101) {
        t0.e(new e(r100, r101, this));
        a();
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onRemoved(final int r100, final int r101) {
        t0.e(new f(r100, r101, this));
        a();
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(final int r100, final int r101, final Object r102) {
        t0.e(new bh8.g(r100, r101, r102, this));
        a();
    }
}
