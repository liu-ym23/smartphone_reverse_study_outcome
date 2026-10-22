package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.list.pipeline.direct_add.UserActiveDeleteTipHelper;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusPageChatBottomShareBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.home.impl.sdk.SdkSheetsServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$initMessageShareMode$3", f = "ChatShareBottomComponent.kt", i = {}, l = {668}, m = "invokeSuspend", n = {}, s = {})
public final class ChatShareBottomComponent$initMessageShareMode$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatShareBottomComponent f301508a;

        public a(ChatShareBottomComponent r100) {
            this.f301508a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r27v0 */
        /* JADX WARN: Type inference failed for: r27v1 */
        /* JADX WARN: Type inference failed for: r27v10 */
        /* JADX WARN: Type inference failed for: r27v11 */
        /* JADX WARN: Type inference failed for: r27v12 */
        /* JADX WARN: Type inference failed for: r27v13 */
        /* JADX WARN: Type inference failed for: r27v14 */
        /* JADX WARN: Type inference failed for: r27v2 */
        /* JADX WARN: Type inference failed for: r27v3 */
        /* JADX WARN: Type inference failed for: r27v4 */
        /* JADX WARN: Type inference failed for: r27v5 */
        /* JADX WARN: Type inference failed for: r27v6 */
        /* JADX WARN: Type inference failed for: r27v7 */
        /* JADX WARN: Type inference failed for: r27v8 */
        /* JADX WARN: Type inference failed for: r27v9 */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.component.share.n0, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v17, types: [xi8.a] */
        /* JADX WARN: Type inference failed for: r3v56, types: [com.larus.bmhome.chat.component.share.n0] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4 */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r410, Continuation r411) {
            rr8.a r100 = (rr8.a) r410;
            final ChatShareBottomComponent r101 = this.f301508a;
            ?? r102 = new n0(r101);
            final IChatMessageShareAbility.ActionType r103 = r100.f539035b;
            Boolean r104 = r100.f539034a;
            if (r104 == null) goto L5;
            boolean r105 = r104.booleanValue();
        L6:
            final Map<String, Object> r106 = r100.f539036c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r103, "action");
            Intrinsics.checkNotNullParameter(r102, "onCloseClick");
            IChatMessageShareAbility.ActionType r107 = IChatMessageShareAbility.ActionType.SHARE;
            if (r103 == r107) goto L9;
        L11:
            boolean r110 = false;
        L12:
            String r111 = "0";
            String r112 = null;
            if (r105 == false) goto L76;
            if (r110 == true) goto L16;
            ?? r210 = r102;
            final LarusPageChatBottomShareBinding r108 = r101.f301480n;
            ?? r211 = r210;
            if (r108 != null) goto L40;
        L67:
            LarusPageChatBottomShareBinding r109 = r101.f301480n;
            ?? r212 = r211;
            if (r109 == null) goto L77;
            if (r110 == false) goto L71;
            r109.f311123h.setVisibility(8);
            r109.f311126k.setVisibility(0);
            r212 = r211;
            goto L77
        L71:
            r109.f311123h.setVisibility(0);
            if (r103 == r107) goto L74;
            int r113 = -2;
            r109.f311123h.getLayoutParams().height = -2;
            r109.f311117b.setVisibility(8);
            r109.f311118c.setVisibility(8);
        L75:
            r109.f311126k.setVisibility(8);
            ?? r213 = r211;
        L78:
            ry8.b r114 = (ry8.b) r101.f301491y.getValue();
            if (r114 == null) goto L81;
            r114.hz();
        L81:
            p1 r115 = (p1) r101.f301488v.getValue();
            if (r115 == null) goto L84;
            r115.cb(false);
        L84:
            Intrinsics.checkNotNullParameter(r101, "<this>");
            com.larus.bmhome.a0 r116 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(r101, r101));
            if (r116 == null) goto L87;
            r116.ED(!r105, "select mode");
        L87:
            Intrinsics.checkNotNullParameter(r101, "<this>");
            ci8.d r117 = ci8.e.a(com.larus.ui.arch.component.internal.attach.a.b(r101, r101));
            if (r117 == null) goto L90;
            r117.hp(!r105);
        L90:
            LarusPageChatBottomShareBinding r118 = r101.f301480n;
            if (r118 == null) goto L195;
            if (r105 == false) goto L171;
            ViewGroup.LayoutParams r119 = r118.f311116a.getLayoutParams();
            if (r119 == null) goto L105;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            if (com.larus.ui.arch.component.internal.attach.a.b(r101, r101).getActivity() == null) goto L105;
            if (r110 == false) goto L100;
        L104:
            r119.height = r113;
            goto L105
        L100:
            if (z2.f365865a.enableChatWithTab() == false) goto L102;
            r113 = i5.y0(R.dimen.larus_dp_141);
            goto L104
        L102:
            if (r103 != r107) goto L104;
            r113 = i5.y0(R.dimen.larus_dp_120);
        L105:
            r118.f311116a.setVisibility(0);
            com.larus.bmhome.share.panel.a r120 = r101.f301483q;
            if (r120 == null) goto L108;
            r120.setVisibility(0);
        L108:
            View r121 = r118.f311116a.findViewById(R.id.normal_action_button_top_split);
            if (r103 != r107) goto L111;
            int r122 = 8;
        L112:
            r121.setVisibility(r122);
            com.larus.bmhome.chat.component.immerse.a r123 = (com.larus.bmhome.chat.component.immerse.a) r101.C.getValue();
            if (r123 == null) goto L115;
            r123.UP();
        L115:
            r101.k4();
            if (r107 != r103) goto L181;
            if (r106 == null) goto L119;
            Object r124 = r106.get("EXT_KEY_CLICK_FROM");
        L121:
            if ((r124 instanceof String) == false) goto L123;
            String r125 = (String) r124;
        L124:
            if (r125 != null) goto L126;
            r125 = "share_panel";
        L126:
            String r310 = r125;
            Message r126 = r101.e4().getOriginSelectMessage();
            ChatShareBottomComponent.a r127 = ChatShareBottomComponent.H3(r126);
            ShareServiceDelegate r214 = ShareServiceDelegate.f313831b;
            boolean r215 = r101.f1().z();
            ChatControlTrace r128 = ChatControlTrace.f309996b;
            wc9.e r129 = r101.h();
            if (r129 == null) goto L129;
            Integer r130 = r129.f559219v;
        L130:
            String r311 = r128.g(r130, r101.V3(), r101.Q3());
            String r312 = r101.X3();
            if (r126 == null) goto L134;
            String r131 = r126.getMessageId();
            if (r131 == null) goto L134;
        L135:
            String r313 = r131;
            if (z2.f365865a.longPressShowMultiSelect() == false) goto L138;
            String r132 = "multiple_choose";
        L139:
            String r314 = r132;
            if (r106 == null) goto L142;
            Object r133 = r106.get("EXT_KEY_IS_BUTTON_ADD_TEXT");
        L144:
            if ((r133 instanceof Integer) == false) goto L146;
            Integer r315 = (Integer) r133;
        L147:
            if (r126 != null) goto L149;
        L151:
            boolean r134 = false;
        L152:
            if (r134 == false) goto L154;
            String r135 = "user";
        L155:
            String r316 = r135;
            if (r126 == null) goto L158;
            String r317 = com.larus.bmhome.chat.bean.d.u(r126);
        L159:
            Intrinsics.checkNotNullParameter(r101, "<this>");
            ActivityResultCaller r136 = com.larus.ui.arch.component.internal.attach.a.b(r101, r101);
            Intrinsics.checkNotNull(r136, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
            by7.e r318 = (by7.e) r136;
            JSONObject r137 = new JSONObject();
            if (r101.l4() == false) goto L162;
            r111 = "1";
        L162:
            r137.put("is_ai_podcast", r111);
            r137.putOpt("page_token", r127.f301497e);
            r137.putOpt("artifact_meta_id", r127.f301493a);
            r137.putOpt("resource_type", r127.f301494b);
            r137.putOpt("artifact_type", r127.f301494b);
            r137.putOpt("resource_id", r127.f301497e);
            r137.putOpt("base_id", r127.f301496d);
            r137.putOpt("canvas_type", r127.f301498f);
            r137.putOpt("current_page", "chat");
            if (r126 == null) goto L167;
            IFlowSdkDepend r138 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r138 == null) goto L167;
            r138.h();
            r137.putOpt("spreadsheet_id", SdkSheetsServiceImpl.f346130a.d(r126));
        L167:
            if (r126 == null) goto L169;
            boolean r319 = com.larus.im.bean.message.a.g0(r126);
        L170:
            r214.e(r215, r311, r310, r312, r313, r314, r315, r316, r317, r318, r319, r137);
            goto L181
        L169:
            r319 = false;
            goto L170
        L158:
            r317 = null;
            goto L159
        L154:
            r135 = "bot";
            goto L155
        L149:
            if (com.larus.bmhome.chat.bean.d.G0(r126) != true) goto L151;
            r134 = true;
            goto L152
        L146:
            r315 = null;
            goto L147
        L142:
            r133 = null;
            goto L144
        L138:
            r132 = "share";
        L134:
            r131 = "";
            goto L135
        L129:
            r130 = null;
            goto L130
        L123:
            r125 = null;
            goto L124
        L119:
            r124 = null;
        L181:
            if (r101.L == true) goto L195;
            u7 r139 = r101.Z3();
            if (r139 == null) goto L185;
            MessageAdapter r140 = r139.MF();
        L187:
            if ((r140 instanceof MessageAdapter) == false) goto L189;
            MessageAdapter r141 = r140;
        L190:
            if (r141 == null) goto L192;
            com.larus.utils.t0.e(new com.larus.bmhome.chat.adapter.x(r141));
            goto L195
        L192:
            if (r140 == null) goto L195;
            r140.notifyDataSetChanged();
            goto L195
        L189:
            r141 = null;
            goto L190
        L185:
            r140 = null;
            goto L187
        L111:
            r122 = 0;
            goto L112
        L171:
            r118.f311116a.setVisibility(8);
            com.larus.bmhome.share.panel.a r142 = r101.f301483q;
            if (r142 == null) goto L174;
            r142.setVisibility(8);
        L174:
            com.larus.bmhome.chat.component.immerse.a r143 = (com.larus.bmhome.chat.component.immerse.a) r101.C.getValue();
            if (r143 == null) goto L177;
            r143.x90();
        L177:
            ChatShareBottomComponent$registerShareModeBackPressCallback$1 r144 = r101.f301478J;
            if (r144 == null) goto L181;
            r144.remove();
        L195:
            Fragment r145 = s1a.a.c(this.f301508a).getParentFragment();
            ?? r216 = r213;
        L196:
            if (r145 == null) goto L206;
            if ((r145 instanceof xi8.a) == false) goto L204;
            ?? r146 = (xi8.a) r145;
            Boolean r147 = r100.f539034a;
            if (r147 == null) goto L202;
            boolean r148 = r147.booleanValue();
        L203:
            r146.NK(r148, r216);
        L205:
            r145 = r145.getParentFragment();
            r216 = r216;
            goto L196
        L202:
            r148 = false;
            goto L203
        L204:
            r216 = r216;
            goto L205
        L206:
            Iterator r149 = ((ArrayList) this.f301508a.Q).iterator();
        L208:
            if (r149.hasNext() == false) goto L215;
            hca.e r150 = (hca.e) r149.next();
            Boolean r151 = r100.f539034a;
            if (r151 == null) goto L212;
            boolean r152 = r151.booleanValue();
        L213:
            r150.onSelectModeChanged(r152);
            goto L208
        L212:
            r152 = false;
            goto L213
        L215:
            return Unit.INSTANCE;
        L74:
            r113 = -2;
        L77:
            r113 = -2;
            r213 = r212;
            goto L78
        L40:
            if (r103 != IChatMessageShareAbility.ActionType.DELETE) goto L44;
            int r153 = UserActiveDeleteTipHelper.f301196a;
            int r154 = ra9.a.f536860a;
            if (Intrinsics.areEqual(ga9.a.e("delete_msg_tip_display", "0"), "2") == false) goto L44;
            Button r155 = r108.f311122g;
            Context r156 = r155.getContext();
            Intrinsics.checkNotNullParameter(r156, PerfLog.PARAM_KEY_CONTEXT_ID);
            r155.setText(r156.getString(R.string.larus_responseMenu_option_recall));
        L52:
            com.larus.utils.e1.d(r108.f311122g, new q(r103, r101, r106));
            com.larus.utils.e1.d(r108.f311119d, new r(r108));
            if (r101.f1().z() == false) goto L55;
            r108.f311122g.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.larus_static_black));
            r108.f311122g.setBackgroundResource(R.drawable.larus_bg_select_mode_action_button_immers);
            r108.f311120e.setBackgroundResource(R.drawable.larus_ic_share_seo_checkbox_immerse);
            r108.f311119d.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.static_white_transparent_3));
        L62:
            z2 r157 = z2.f365865a;
            if (r157.getShareConfig().d() == false) goto L65;
            r108.f311117b.setVisibility(8);
            r108.f311118c.setVisibility(0);
        L66:
            r101.e4().getShareMegNum().observe(r101, new ChatShareBottomComponent.g(new s(r101)));
            r211 = r210;
            goto L67
        L65:
            r108.f311117b.setVisibility(0);
            r108.f311118c.setVisibility(8);
            r108.f311120e.setChecked(r157.getShareConfig().u());
            goto L66
        L55:
            r108.f311122g.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.larus_static_white));
            Button r158 = r108.f311122g;
            if (r158 == null) goto L58;
            r158.setBackgroundResource(v19.c.b(R.attr.larus_bg_select_mode_action_button, r158.getContext(), R.drawable.larus_bg_select_mode_action_button));
        L58:
            AppCompatCheckBox r159 = r108.f311120e;
            if (r159 == null) goto L61;
            r159.setBackgroundResource(v19.c.b(R.attr.larus_ic_share_seo_checkbox, r159.getContext(), R.drawable.larus_ic_share_seo_checkbox));
        L61:
            r108.f311119d.setTextColor(ContextCompat.getColor(r101.getContext(), v19.c.b(R.attr.larus_neutral_50, r101.getContext(), R.color.larus_neutral_50)));
        L44:
            Button r160 = r108.f311122g;
            int r161 = ChatShareBottomComponent.d.f301504a[r103.ordinal()];
            if (r161 != 1) goto L47;
            int r162 = R.string.larus_collections_tab;
        L51:
            r160.setText(r162);
            goto L52
        L47:
            if (r161 == 2) goto L49;
            r162 = R.string.larus_cici_share_btn;
            goto L51
        L49:
            r162 = R.string.larus_long_press_delete_message;
            goto L51
        L16:
            if (r101.f301483q != null) goto L36;
            LarusPageChatBottomShareBinding r163 = r101.f301480n;
            if (r163 == null) goto L36;
            ShareServiceDelegate r164 = ShareServiceDelegate.f313831b;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            Context r165 = com.larus.ui.arch.component.internal.attach.a.b(r101, r101).getContext();
            if (r101.q4() == false) goto L24;
            ShareScene r166 = ShareScene.OFFICE_SHARE_CHAT;
        L27:
            boolean r217 = r101.f1().C();
            boolean r218 = com.larus.bmhome.utils.i.f(r101.h());
            com.larus.bmhome.share.panel.h r219 = r101.D3();
            o0 r167 = new o0(r101);
            Intrinsics.checkNotNullParameter(r101, "<this>");
            ActivityResultCaller r168 = com.larus.ui.arch.component.internal.attach.a.b(r101, r101);
            if ((r168 instanceof by7.e) == false) goto L30;
            by7.e r220 = (by7.e) r168;
        L32:
            if (sr8.c.a() == true) goto L34;
            List<jr9.a> r221 = null;
        L35:
            com.larus.bmhome.share.panel.a r169 = r164.q(r165, r166, null, r217, r218, r219, r167, null, r220, r221);
            r101.f301483q = r169;
            r163.f311125j.addView(r169);
            LiveData<Integer> r170 = r101.e4().getShareMegNum();
            Intrinsics.checkNotNullParameter(r101, "<this>");
            r170.observe(com.larus.ui.arch.component.internal.attach.a.b(r101, r101).getViewLifecycleOwner(), new ChatShareBottomComponent.g(new t(r101)));
            r211 = r102;
            goto L67
        L34:
            r221 = CollectionsKt.listOf(new jr9.a(ShareChannel.CCM_SHARE, r112, 14));
            goto L35
        L30:
            r220 = null;
            goto L32
        L24:
            if (z2.f365865a.getShareConfig().n() == false) goto L26;
            r166 = ShareScene.MESSAGES_LINK_IMAGE;
            goto L27
        L26:
            r166 = ShareScene.MESSAGES_LINK;
        L36:
            r211 = r102;
            goto L67
        L76:
            r212 = r102;
            goto L77
        L9:
            if (Intrinsics.areEqual(z2.f365865a.getShareConfig().o(), Boolean.TRUE) == false) goto L11;
            r110 = true;
            goto L12
        L5:
            r105 = false;
            goto L6
        }
    }

    public ChatShareBottomComponent$initMessageShareMode$3(ChatShareBottomComponent r100, Continuation<? super ChatShareBottomComponent$initMessageShareMode$3> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatShareBottomComponent$initMessageShareMode$3(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatShareBottomComponent$initMessageShareMode$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ChatShareBottomComponent r103 = this.this$0;
        int r104 = ChatShareBottomComponent.R;
        kotlinx.coroutines.flow.i1<rr8.a> r105 = r103.e4().getShareModeFlow();
        a r106 = new a(this.this$0);
        this.label = 1;
        if (r105.collect(r106, this) != r101) goto L12;
        return r101;
    }
}
