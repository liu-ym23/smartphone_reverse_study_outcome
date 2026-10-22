package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.response.CarouselDetailInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowDetailInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lk2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/adapter/ECFloatWindowPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/adapter/ECFloatWindowPanelAdapter$ViewHolder;", "ViewHolder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowPanelAdapter extends RecyclerView.Adapter<ViewHolder> {
    public RecyclerView a;
    public List<CarouselDetailInfo> b;
    public lk2.a c;
    public int d;
    public ViewHolder e;
    public final il.a f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/adapter/ECFloatWindowPanelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a a;

        public static final class a {
        }

        static {
        }

        public ViewHolder(View r2, com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "manager");
            super(r2);
            this.a = r3;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ ECFloatWindowPanelAdapter a;

        public a(ECFloatWindowPanelAdapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.safeNotifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final int getItemCount() {
        List<CarouselDetailInfo> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void safeNotifyDataSetChanged() {
        RecyclerView r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        notifyDataSetChanged();
        return;
    L5:
        if (r0.isComputingLayout() != true) goto L8;
        r0.post(new a(this));
    }

    public ECFloatWindowPanelAdapter(il.a r2) {
        Intrinsics.checkNotNullParameter(r2, "historyMap");
        this.f = r2;
        this.d = -1;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.a = r2;
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
        this.a = null;
    }

    public final b y2(int r10) {
        List<CarouselDetailInfo> r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L17;
        CarouselDetailInfo r11 = (CarouselDetailInfo) CollectionsKt.getOrNull(r0, r10);
        if (r11 == null) goto L18;
        Integer r3 = r11.getType();
        ECFloatWindowDetailInfo r4 = r11.getDetailInfo();
        Map r5 = r11.getEventParams();
        lk2.a r12 = this.c;
        if (r12 == null) goto L9;
        String r6 = r12.d;
    L10:
        if (r12 == null) goto L12;
        String r7 = r12.e;
    L13:
        if (r12 == null) goto L16;
        r1 = r12.f;
    L16:
        return new b(r3, r4, r5, r6, r7, r1);
    L12:
        r7 = null;
        goto L13
    L9:
        r6 = null;
        goto L10
    L18:
        return null;
    L17:
        return null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ViewHolder r7 = (ViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        final b r0 = y2(r6);
        r7.a.b(r0);
        if (r0 == null) goto L11;
        il.a r8 = this.f;
        StringBuilder r1 = new StringBuilder();
        r1.append(r0.getType());
        r1.append('_');
        ECFloatWindowDetailInfo r3 = r0.b;
        if (r3 == null) goto L8;
        Integer r4 = Integer.valueOf(r3.hashCode());
    L9:
        r1.append(r4);
        r1.append('_');
        r1.append(r6);
        r8.c("livesdk_size_card_show", r1.toString(), new ECFloatWindowPanelAdapter$logShowEvent$1(this, r0));
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        int r5 = ViewHolder.b;
        Context r6 = r3.getContext();
        lk2.a r7 = this.c;
        if (r7 == null) goto L5;
        LiveRoomParams r8 = r7.g;
    L6:
        Function0<Boolean> r0 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r0, "canToggle");
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a r1 = new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a(r6, r8, r0);
        r1.e();
        View r9 = r1.a;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L10:
        return new ViewHolder(r9, r1);
    L5:
        r8 = null;
        goto L6
    }
}
