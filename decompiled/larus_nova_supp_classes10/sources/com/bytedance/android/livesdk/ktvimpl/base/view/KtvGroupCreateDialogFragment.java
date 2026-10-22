package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.ktv.common.util.h;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvGroupViewModel;
import com.bytedance.live.datacontext.j;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvGroupCreateDialogFragment;", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvBaseBottomDialogFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupCreateDialogFragment extends KtvBaseBottomDialogFragment {
    public ImageView h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ KtvGroupCreateDialogFragment b;

        public b(TextView r1, KtvGroupCreateDialogFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Long r4 = KtvLoggerHelper.a;
            KtvLoggerHelper.X("livesdk_ktv_friends_group_create_click", MapsKt.mapOf(TuplesKt.to("page", "interact_function")));
            if (this.a.getContext() == null) goto L21;
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r5 = KtvRoomContext.a.a();
            if (r5 == null) goto L19;
            j<KtvGroupViewModel> r6 = r5.getKtvGroupViewModel();
            if (r6 == null) goto L19;
            KtvGroupViewModel r7 = (KtvGroupViewModel) r6.getValue();
            if (r7 == null) goto L19;
            r7.createGroup(this.a.getContext(), "interact_function");
        L19:
            this.b.dismiss();     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L22;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L22:
            return;
        }
    }

    static {
    }

    public KtvGroupCreateDialogFragment() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvBaseBottomDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954699);
        Intrinsics.checkNotNullParameter("歌友群", "title");
        this.g = "歌友群";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvBaseBottomDialogFragment
    public final View S90(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "container");
        r4.setBackgroundResource(2131252061);
        View r5 = r3.inflate(2131566494, r4, false);
        this.h = (ImageView) r5.findViewById(2131376953);
        FrescoLoader r6 = FrescoLoader.with(getContext());
        int r0 = h.a;
        r6.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_group_description_pic.png").into(this.h);
        TextView r7 = (TextView) r5.findViewById(2131376949);
        if (r7 == null) goto L5;
        r7.setText("创建歌友群");
        Long r1 = KtvLoggerHelper.a;
        KtvLoggerHelper.X("livesdk_ktv_friends_group_create_icon_show", MapsKt.mapOf(TuplesKt.to("page", "interact_function")));
        r7.setOnClickListener(new b(r7, this));
    L5:
        return r5;
    }
}
