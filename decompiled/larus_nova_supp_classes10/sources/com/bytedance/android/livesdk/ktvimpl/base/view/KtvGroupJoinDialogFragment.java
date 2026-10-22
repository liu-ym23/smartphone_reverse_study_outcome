package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.ktv.common.model.api.GroupInfo;
import com.bytedance.android.live.ktv.common.util.h;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvGroupViewModel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvGroupJoinDialogFragment;", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvBaseBottomDialogFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupJoinDialogFragment extends KtvBaseBottomDialogFragment {
    public static int l;
    public static int m;
    public TextView h;
    public GroupInfo i;
    public ImageView j;
    public final KtvGroupJoinDialogFragment$accessOnClicklistener$1 k;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            SpannableString r4 = (SpannableString) r3;
            ALogger.i("KtvGroupViewModel", "joinGroupTips:" + r4);
            if (r4 == null) goto L7;
            ((TextView) this.a.findViewById(2131376951)).setText(r4);
            return;
        }
    }

    static {
        l = 23;
        m = 1;
    }

    public KtvGroupJoinDialogFragment() {
        this.k = new KtvGroupJoinDialogFragment$accessOnClicklistener$1(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvBaseBottomDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954699);
        Intrinsics.checkNotNullParameter("歌友群", "title");
        this.g = "歌友群";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvBaseBottomDialogFragment
    public final View S90(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "container");
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L7;
        j<KtvGroupViewModel> r1 = r0.getKtvGroupViewModel();
        if (r1 == null) goto L7;
        KtvGroupViewModel r2 = (KtvGroupViewModel) r1.getValue();
    L8:
        final View r6 = r4.inflate(2131566496, r5, false);
        r6.findViewById(2131376954).setVisibility(0);
        this.j = (ImageView) r6.findViewById(2131376953);
        FrescoLoader r7 = FrescoLoader.with(getContext());
        int r3 = h.a;
        r7.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_group_description_pic.png").into(this.j);
        if (r2 == null) goto L13;
        NextLiveData<SpannableString> r8 = r2.getJoinGroupTips();
        if (r8 == null) goto L13;
        r8.observe(this, new b(r6), true);
    L13:
        if (r2 == null) goto L15;
        r2.checkSetting();
    L15:
        if (r2 == null) goto L17;
        r2.getGroupInfo(new KtvGroupJoinDialogFragment$initBodyView$2(this, r6), true);
    L17:
        return r6;
    L7:
        r2 = null;
        goto L8
    }

    public final void T90(TextView r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$checkBtnState");
        String r1 = bb0.b.b();
        ALogger.i(r1, ("checkBtnState:" + r9) + ", invoke class :" + TextView.class.getSimpleName());
        if (r9 != GroupInfo.UserInGroupStatus.Clear.getValue()) goto L23;
        r8.setEnabled(true);
        TextView r0 = this.h;
        if (r0 == null) goto L7;
        r0.setOnClickListener(this.k);
    L7:
        View r2 = this.f;
        if (r2 == null) goto L12;
        View r3 = r2.findViewById(2131376957);
        if (r3 == null) goto L12;
        r3.setVisibility(0);
    L12:
        View r4 = this.f;
        if (r4 == null) goto L17;
        View r5 = r4.findViewById(2131376951);
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        Long r6 = KtvLoggerHelper.a;
        Pair[] r7 = new Pair[2];
        r7[0] = TuplesKt.to("user_type", KtvLoggerHelper.I());
        GroupInfo r10 = this.i;
        if (r10 == null) goto L20;
        long r11 = r10.d();
    L21:
        r7[1] = TuplesKt.to("member_cnt", String.valueOf(r11));
        KtvLoggerHelper.X("livesdk_ktv_friends_group_join_icon_show", MapsKt.mapOf(r7));
        String r12 = r8.getContext().getString(2131918396);
    L49:
        r8.setText(r12);
        return;
    L20:
        r11 = 0;
        goto L21
    L23:
        if (r9 != GroupInfo.UserInGroupStatus.Applied.getValue()) goto L36;
        r8.setEnabled(false);
        View r13 = this.f;
        if (r13 == null) goto L29;
        View r14 = r13.findViewById(2131376957);
        if (r14 == null) goto L29;
        r14.setVisibility(8);
    L29:
        View r15 = this.f;
        if (r15 == null) goto L34;
        View r16 = r15.findViewById(2131376951);
        if (r16 == null) goto L34;
        r16.setVisibility(0);
    L34:
        r12 = "已申请";
        goto L49
    L36:
        if (r9 != GroupInfo.UserInGroupStatus.Engaged.getValue()) goto L48;
        r8.setEnabled(false);
        View r17 = this.f;
        if (r17 == null) goto L42;
        View r18 = r17.findViewById(2131376957);
        if (r18 == null) goto L42;
        r18.setVisibility(8);
    L42:
        View r19 = this.f;
        if (r19 == null) goto L47;
        View r20 = r19.findViewById(2131376951);
        if (r20 == null) goto L47;
        r20.setVisibility(0);
    L47:
        r12 = "已加入";
        goto L49
    L48:
        r12 = r8.getContext().getString(2131918396);
        goto L49
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.view.KtvBaseBottomDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = super.onCreateView(r2, r3, r4);
        r5.setBackgroundResource(2131252061);
        return r5;
    }
}
