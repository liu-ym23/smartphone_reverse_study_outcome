package com.ss.android.lark.forwardv3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.gson.JsonArray;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle;
import com.ss.android.lark.forwardv3.utils.FileUtils;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.Source;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;
import z5c.b3;
import z5c.c3;
import z5c.d3;
import z5c.e3;
import z5c.r;
import z5c.t1;
import z5c.t2;
import z5c.u2;

/* JADX INFO: loaded from: classes36.dex */
public final class ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1 implements qib.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f425111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ForwardNewFragment f425112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<SearchBaseInfo> f425113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s5c.d f425114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ForwardNewFragment.b f425115e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForwardNewFragment f425116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f425117b;

        public a(ForwardNewFragment r100, FragmentActivity r101) {
            this.f425116a = r100;
            this.f425117b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            StringBuilder r101 = new StringBuilder("click custom content container, clickable is: ");
            ForwardV3ViewModel r102 = this.f425116a.f425091f;
            ForwardV3ViewModel r103 = null;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r102 = null;
        L5:
            r101.append(r102.getDialogContent().f425138k);
            Log.i("NewForward", r101.toString());
            ForwardV3ViewModel r104 = this.f425116a.f425091f;
            if (r104 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r104 = null;
        L9:
            if (r104.getDialogContent().f425138k == false) goto L18;
            s5c.a r105 = r.f570314b1;
            s5c.h r106 = s5c.h.f540777a;
            int r107 = zib.e.f572329a;
            r105.getClass();
            zib.e.a.c(s5c.d.b.b(r105, r106));
            ForwardV3ViewModel r108 = this.f425116a.f425091f;
            if (r108 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L14:
            OnCustomForwardConfirmDialogContentView r109 = r103.getCustomConfirmDialogContentView();
            if (r109 == null) goto L19;
            FragmentActivity r110 = this.f425117b;
            ForwardNewFragment r111 = this.f425116a;
            Intrinsics.checkNotNull(r100);
            r109.p(r110, r111, r100);
            return;
        L19:
            return;
        L13:
            r103 = r108;
            goto L14
        }
    }

    public static final class b implements OnCustomForwardConfirmDialogContentView.a {
        public b() {
        }
    }

    @Override // qib.a
    public final void a() {
        s5c.a r100 = r.f570319d;
        s5c.h r101 = s5c.h.f540777a;
        int r102 = zib.e.f572329a;
        r100.getClass();
        zib.e.a.e(s5c.d.b.b(r100, r101));
        ForwardV3ViewModel r103 = this.f425112b.f425091f;
        tib.e r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r103 = null;
    L5:
        oib.c r105 = r103.getConfirmDialogListener();
        if (r105 == null) goto L8;
        r105.onCancelButtonClick();
    L8:
        tib.e r106 = this.f425112b.f425090e;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
    L12:
        r104.i(true);
        return;
    L11:
        r104 = r106;
        goto L12
    }

    @Override // qib.a
    public final void onDismissForward() {
        boolean r100 = zib.b.f572310d;
        zib.b.b();
        ForwardV3ViewModel r101 = null;
        if (this.f425112b.isAdded() == false) goto L19;
        ForwardV3ViewModel r102 = this.f425112b.f425091f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L8:
        if (r102.getSource() == Forward$Source.MY_AI) goto L16;
        ForwardV3ViewModel r103 = this.f425112b.f425091f;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r103 = null;
    L13:
        if (r103.getSource() == Forward$Source.KNOWLEDGE_AI) goto L16;
        int r104 = com.ss.android.lark.forwardv3.utils.n.f425590a;
        if (com.ss.android.lark.forwardv3.utils.n.f(this.f425112b.getActivity()) == false) goto L19;
    L16:
        FragmentTransaction r105 = this.f425112b.getChildFragmentManager().beginTransaction();
        Fragment r106 = this.f425112b.getChildFragmentManager().findFragmentByTag("frowardDialog");
        if (r106 == null) goto L19;
        r105.remove(r106);
        r105.commitAllowingStateLoss();
    L19:
        ForwardV3ViewModel r107 = this.f425112b.f425091f;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        oib.c r108 = r101.getConfirmDialogListener();
        if (r108 == null) goto L27;
        r108.onDismissForward();
        return;
    L27:
        return;
    L22:
        r101 = r107;
        goto L23
    }

    public final void c(ConstraintLayout r210) {
        Intrinsics.checkNotNullParameter(r210, "baseContentContainer");
        Log.i("NewForward", "setup base forward content");
        int r100 = com.ss.android.lark.forwardv3.utils.n.f425590a;
        Context r101 = this.f425111a;
        ForwardV3ViewModel r102 = this.f425112b.f425091f;
        IMFileResult r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L5:
        Message r104 = r102.getDisplayMessage();
        ForwardV3ViewModel r105 = this.f425112b.f425091f;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r105 = null;
    L8:
        BasicDialogContentConfig r110 = r105.getDialogContent();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "baseContentContainer");
        Intrinsics.checkNotNullParameter(r110, "dialogContent");
        FrameLayout r106 = (FrameLayout) r210.findViewById(R.id.confirm_dialog_icon_layout);
        GifImageView r111 = (GifImageView) r210.findViewById(R.id.confirm_dialog_icon);
        ImageView r112 = (ImageView) r210.findViewById(R.id.confirm_dialog_sub_icon);
        LinearLayout r113 = (LinearLayout) r210.findViewById(R.id.confirm_dialog_content_layout);
        TextView r114 = (TextView) r210.findViewById(R.id.confirm_msg_title);
        TextView r115 = (TextView) r210.findViewById(R.id.confirm_msg_content);
        TextView r107 = (TextView) r210.findViewById(R.id.confirm_msg_desc);
        Intrinsics.checkNotNull(r111);
        Intrinsics.checkNotNull(r112);
        Intrinsics.checkNotNull(r114);
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNull(r107);
        int r108 = FileUtils.f425553a;
        if (r104 == null) goto L14;
        ValidateIMFileResult r109 = r104.getValidateIMFileResult();
        if (r109 == null) goto L14;
        r103 = r109.getResultType();
    L14:
        if (r103 != null) goto L16;
        FileUtils.ReceiveAuthorizationState r116 = FileUtils.ReceiveAuthorizationState.NORMAL_STATE;
    L30:
        Intrinsics.checkNotNullParameter(r116, "receiveAuthorizationState");
        int r117 = FileUtils.a.f425556a[r116.ordinal()];
        if (r117 == 1) goto L34;
        if (r117 == 2) goto L34;
        boolean r118 = false;
    L36:
        if (r118 == false) goto L42;
        r111.setVisibility(0);
        r111.setImageResource(R.drawable.no_view_perm_drawable);
        r112.setVisibility(8);
        if (r116 != FileUtils.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY) goto L40;
        String r119 = y9c.d.h(R.string.Lark_IM_NoReceivingPermission_Text);
    L41:
        r107.setText(r119);
        r107.setVisibility(0);
        TextView r120 = r107;
        TextView r121 = r115;
        TextView r122 = r114;
        int r123 = 0;
        int r124 = 8;
        boolean r125 = true;
    L82:
        if (r111.getVisibility() != 0) goto L84;
        boolean r126 = true;
    L86:
        if (r112.getVisibility() != 0) goto L88;
        boolean r127 = true;
    L90:
        if (r122.getVisibility() != 0) goto L92;
        boolean r128 = true;
    L94:
        if (r121.getVisibility() != 0) goto L96;
        boolean r129 = true;
    L98:
        if (r120.getVisibility() == 0) goto L101;
        r125 = false;
    L101:
        int r130 = y9c.d.a(10);
        int r131 = y9c.d.a(5);
        if (r126 == false) goto L111;
        if (r128 == true) goto L106;
        if (r129 == true) goto L106;
        if (r125 == false) goto L111;
    L106:
        Intrinsics.checkNotNull(r106);
        r106.setVisibility(r123);
        Intrinsics.checkNotNull(r113);
        r113.setVisibility(r123);
        if (r127 == true) goto L110;
        r123 = 8;
    L110:
        r112.setVisibility(r123);
        ViewGroup.LayoutParams r132 = r113.getLayoutParams();
        Intrinsics.checkNotNull(r132, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r133 = (ConstraintLayout.LayoutParams) r132;
        ((ViewGroup.MarginLayoutParams) r133).leftMargin = r130;
        r113.setLayoutParams(r133);
        com.ss.android.lark.forwardv3.utils.n.a(r101, r131, r128, r122, r129, r121, r125, r120);
        return;
    L111:
        if (r126 == true) goto L116;
        if (r128 == true) goto L115;
        if (r129 == true) goto L115;
        if (r125 == false) goto L116;
    L115:
        Intrinsics.checkNotNull(r106);
        r106.setVisibility(r124);
        Intrinsics.checkNotNull(r113);
        r113.setVisibility(r123);
        r112.setVisibility(r124);
        com.ss.android.lark.forwardv3.utils.n.a(r101, r131, r128, r122, r129, r121, r125, r120);
        return;
    L116:
        if (r126 == false) goto L125;
        if (r128 == true) goto L125;
        if (r129 == true) goto L125;
        if (r125 == true) goto L125;
        Intrinsics.checkNotNull(r106);
        r106.setVisibility(r123);
        Intrinsics.checkNotNull(r113);
        r113.setVisibility(r124);
        if (r127 == false) goto L123;
        int r134 = 0;
    L124:
        r112.setVisibility(r134);
        return;
    L123:
        r134 = 8;
    L125:
        if (r126 == true) goto L134;
        if (r128 == true) goto L135;
        if (r129 == true) goto L136;
        if (r125 == true) goto L137;
        r210.setVisibility(r124);
        return;
    L137:
        return;
    L136:
        return;
    L135:
        return;
    L134:
        return;
    L96:
        r129 = false;
        goto L98
    L92:
        r128 = false;
        goto L94
    L88:
        r127 = false;
        goto L90
    L84:
        r126 = false;
        goto L86
    L40:
        r119 = "";
        goto L41
    L42:
        boolean r135 = ForwardModuleV3.a().hasFilePreviewPermissionFromMessage(r104);
        if (r135 == true) goto L46;
        r111.setVisibility(0);
        r111.setImageResource(R.drawable.no_view_perm_drawable);
    L48:
        TextView r211 = r107;
        TextView r212 = r115;
        TextView r213 = r114;
        r123 = 0;
        r124 = 8;
        r125 = true;
    L60:
        if (r135 == true) goto L63;
        r112.setVisibility(r124);
    L68:
        if (TextUtils.isEmpty(r110.f425129b) == true) goto L70;
        r122 = r213;
        r122.setVisibility(r123);
        r122.setText(r110.f425129b);
    L72:
        if (TextUtils.isEmpty(r110.f425130c) == true) goto L74;
        r121 = r212;
        r121.setVisibility(r123);
        r121.setText(r110.f425130c);
    L75:
        if (r135 == true) goto L77;
        r120 = r211;
        r120.setVisibility(r123);
        r120.setText(y9c.d.h(R.string.Lark_IM_UnableToPreview_Button));
        goto L82
    L77:
        r120 = r211;
        if (TextUtils.isEmpty(r110.f425131d) == true) goto L80;
        r120.setVisibility(r123);
        r120.setText(r110.f425131d);
        goto L82
    L80:
        r120.setVisibility(r124);
        goto L82
    L74:
        r121 = r212;
        r121.setVisibility(r124);
        goto L75
    L70:
        r122 = r213;
        r122.setVisibility(r124);
        goto L72
    L63:
        if (r111.getVisibility() == r124) goto L68;
        if (r110.f425132e <= 0) goto L68;
        r112.setVisibility(r123);
        r112.setImageResource(r110.f425132e);
        goto L68
    L46:
        if (r110.f425133f <= 0) goto L50;
        r111.setVisibility(0);
        r111.setImageResource(r110.f425133f);
        goto L48
    L50:
        if (r110.f425135h == null) goto L52;
        r111.setVisibility(0);
        r125 = true;
        r211 = r107;
        r212 = r115;
        r213 = r114;
        r123 = 0;
        com.ss.android.lark.forwardv3.utils.a.a(r101, r111, r110.f425137j, r110.f425135h, false, true, 0, 0);
    L58:
        r124 = 8;
        goto L60
    L52:
        r211 = r107;
        r212 = r115;
        r213 = r114;
        r123 = 0;
        r125 = true;
        if (r110.f425134g == null) goto L56;
        r111.setVisibility(0);
        com.ss.android.lark.forwardv3.utils.a.a(r101, r111, r110.f425137j, r110.f425134g, true, false, 0, 0);
        goto L58
    L56:
        if (r110.f425136i == null) goto L59;
        r111.setVisibility(0);
        ForwardModuleV3.a().showSquareMessageStickerThumb(r101, r111, r110.f425136i);
        goto L58
    L59:
        r124 = 8;
        r111.setVisibility(8);
    L34:
        r118 = true;
        goto L36
    L16:
        FileUtils.ReceiveAuthorizationState.a r136 = FileUtils.ReceiveAuthorizationState.Companion;
        int r137 = r103.getValue();
        r136.getClass();
        if (r137 == 0) goto L29;
        if (r137 == 1) goto L28;
        if (r137 != 2) goto L21;
        r116 = FileUtils.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS;
        goto L30
    L21:
        if (r137 != 3) goto L23;
        r116 = FileUtils.ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY;
        goto L30
    L23:
        if (r137 == 4) goto L25;
        r116 = FileUtils.ReceiveAuthorizationState.UNKNOWN;
        goto L30
    L25:
        r116 = FileUtils.ReceiveAuthorizationState.NORMAL_STATE;
        goto L30
    L28:
        r116 = FileUtils.ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE;
        goto L30
    L29:
        r116 = FileUtils.ReceiveAuthorizationState.UNKNOWN;
        goto L30
    }

    public final void d(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "customContentContainer");
        Log.i("NewForward", "setup custom forward content");
        ForwardNewFragment r101 = this.f425112b;
        b r102 = new b();
        FragmentActivity r103 = r101.getActivity();
        if (r103 == null) goto L15;
        ForwardNewFragment r104 = this.f425112b;
        ForwardV3ViewModel r105 = r104.f425091f;
        ForwardV3ViewModel r106 = null;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r105 = null;
    L7:
        OnCustomForwardConfirmDialogContentView r107 = r105.getCustomConfirmDialogContentView();
        if (r107 == null) goto L14;
        ForwardV3ViewModel r108 = r104.f425091f;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r107.E1(r103, r100, r106.getDialogContent(), r102);
        goto L14
    L12:
        r106 = r108;
    L14:
        r100.setOnClickListener(new a(r104, r103));
        return;
    L15:
        Log.e("NewForward", "activity is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qib.a
    public final void b(final String r210, final RichText r211) {
        Intrinsics.checkNotNullParameter(r210, "note");
        Intrinsics.checkNotNullParameter(r211, "richText");
        final BeforeForwardErrorHandle r100 = new BeforeForwardErrorHandle(this.f425111a);
        i08.a.b(this.f425111a, y9c.d.h(R.string.Lark_Legacy_Sending));
        String r101 = com.ss.android.lark.widget.richtext.i.g(r211, true);
        ForwardNewFragment r102 = this.f425112b;
        List<SearchBaseInfo> r103 = this.f425113c;
        s5c.d r104 = this.f425114d;
        int r105 = ForwardNewFragment.f425088t;
        r102.getClass();
        s5c.a r106 = r.f570321f;
        s5c.h r107 = s5c.h.f540777a;
        if (TextUtils.isEmpty(r210) == false) goto L5;
    L8:
        s5c.a r110 = t1.f570374d;
    L9:
        int r111 = zib.e.f572329a;
        ForwardV3ViewModel r108 = r102.f425091f;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r108 = null;
    L12:
        sib.a<rib.b, Throwable> r109 = r108.getRecommendData().getValue();
        Intrinsics.checkNotNullParameter(r103, "selectedInfo");
        JsonArray r112 = new JsonArray();
        Iterator r113 = r103.iterator();
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        int r118 = 0;
    L14:
        if (r113.hasNext() == false) goto L43;
        SearchBaseInfo r119 = (SearchBaseInfo) r113.next();
        if ((r119 instanceof SearchChatInfo) == false) goto L22;
        if (((SearchChatInfo) r119).isSecretChat() == false) goto L20;
        r114 = r114 + 1;
    L20:
        r116 = r116 + 1;
    L26:
        Iterator r212 = r113;
    L27:
        Source.Type r120 = r119.getSource();
        if (r120 != null) goto L30;
        int r121 = -1;
    L32:
        if (r121 == 1) goto L42;
        if (r121 != 2) goto L36;
        r118 = r118 + 1;
        goto L42
    L36:
        if (r121 != 3) goto L42;
        if ((r109 instanceof sib.a.b) == false) goto L42;
        r112.add(Integer.valueOf(((rib.b) ((sib.a.b) r109).f542257a).f537929a.indexOf(r119)));
    L42:
        r113 = r212;
        goto L14
    L30:
        r121 = zib.e.a.C8466a.f572330a[r120.ordinal()];
        goto L32
    L22:
        if ((r119 instanceof SearchChatterInfo) == false) goto L26;
        r115 = r115 + 1;
        r212 = r113;
        if (((SearchChatterInfo) r119).getChatterType() != Chatter.ChatterType.BOT) goto L27;
        r117 = r117 + 1;
        goto L27
    L43:
        s5c.a r122 = c3.f570177c.a(String.valueOf(r114));
        s5c.a r123 = e3.f570192c.a(String.valueOf(r115));
        s5c.a r124 = d3.f570184c.a(String.valueOf(r116));
        s5c.a r125 = b3.f570159c.a(String.valueOf(r117));
        s5c.d r126 = s5c.d.b.b(u2.f570384c.a(String.valueOf(r118)), t2.f570375c.a(r112.toString())).plus(r125).plus(r122).plus(r123).plus(r124);
        int r127 = zib.e.f572329a;
        r106.getClass();
        zib.e.a.e(s5c.d.b.b(r106, r104).plus(r107).plus(r126).plus(r110));
        ForwardV3ViewModel r128 = this.f425112b.f425091f;
        if (r128 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r128 = null;
    L46:
        oib.c r129 = r128.getConfirmDialogListener();
        if (r129 == null) goto L49;
        r129.onConfirmButtonClick(r210, r101);
    L49:
        final ForwardNewFragment r130 = this.f425112b;
        final Context r131 = this.f425111a;
        final List<SearchBaseInfo> r132 = this.f425113c;
        final ForwardNewFragment.b r133 = this.f425115e;
        UIGetDataCallback<List<ForwardTargetBaseInfoNew>> r134 = new ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1$onConfirmForward$prepareChatCallback$1(r130, r131, r132, r210, r211, r133, r100);
        if (this.f425115e.f425105a.isEmpty() == false) goto L55;
        ForwardNewFragment r135 = this.f425112b;
        Context r136 = this.f425111a;
        List<SearchBaseInfo> r137 = this.f425113c;
        z r138 = r135.f425097l;
        if (r138 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("forwardSendHelper");
        r138 = null;
    L54:
        LifecycleCoroutineScope r139 = LifecycleOwnerKt.getLifecycleScope(r135);
        r138.a(r139, r136, r137, r210, r211);
    L60:
        boolean r140 = zib.b.f572310d;
        zib.b.f572307a = 0;
        zib.b.f572308b = 0;
        zib.b.f572309c = 0;
        return;
    L55:
        ForwardV3ViewModel r141 = this.f425112b.f425091f;
        if (r141 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        ForwardV3ViewModel r142 = null;
    L59:
        r142.prepareChatBeforeForward(this.f425115e.f425105a, r134);
        goto L60
    L58:
        r142 = r141;
        goto L59
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r110 = t1.f570373c;
        goto L9
    }

    public ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1(Context r100, ForwardNewFragment r101, List r102, s5c.a r103, ForwardNewFragment.b r104) {
        this.f425111a = r100;
        this.f425112b = r101;
        this.f425113c = r102;
        this.f425114d = r103;
        this.f425115e = r104;
    }
}
