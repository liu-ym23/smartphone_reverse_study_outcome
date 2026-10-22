package com.suite.lark.platform.feature.forward.doubao;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.forwardv3.ExternalForwardSendHelper;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModelFactory;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.doubao.ExternalTargetConstants;
import com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoThreadAvatar;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.List;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u0001:\u0001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\tH\u0002J$\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010-\u001a\u00020$H\u0016J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0002J\u001e\u00106\u001a\u00020$2\f\u00107\u001a\b\u0012\u0004\u0012\u000204082\u0006\u00105\u001a\u00020\u0019H\u0002J\u0018\u00109\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0002J \u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\u00162\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0002J\b\u0010<\u001a\u00020$H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020B2\u0006\u00103\u001a\u000204H\u0002J\b\u0010F\u001a\u00020$H\u0002J\u0010\u0010G\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0014H\u0002J\f\u0010H\u001a\u00020\u001e*\u00020IH\u0002J\u0018\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020\u00142\u0006\u0010L\u001a\u00020\u0019H\u0002J\b\u0010M\u001a\u00020\u0019H\u0002J\u0018\u0010N\u001a\u00020$2\u0006\u0010L\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u001eH\u0002J\u0010\u0010P\u001a\u00020$2\u0006\u0010L\u001a\u00020\u0019H\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\b\u0010R\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020B08H\u0002J \u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010W2\f\u00107\u001a\b\u0012\u0004\u0012\u00020408H\u0002J\n\u0010X\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020BH\u0002J\u0018\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u001eH\u0002J\b\u0010_\u001a\u00020$H\u0002J\u0010\u0010`\u001a\u00020$2\u0006\u0010a\u001a\u00020BH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/DoubaoForwardConfirmFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "forwardSendHelper", "Lcom/ss/android/lark/forwardv3/IForwardSendHelper;", RemoteMessageConst.SEND_MODE, "Lcom/ss/android/lark/forwardv3/ExternalForwardSendMode;", "singleAvatarRow", "Landroid/widget/LinearLayout;", "avatarScroll", "Landroid/widget/HorizontalScrollView;", "avatarRow", "previewContainer", "Landroid/widget/FrameLayout;", "noteEt", "Landroid/widget/EditText;", "sendBtn", "Landroid/view/View;", "backBtn", "Landroid/widget/ImageView;", "bottomContainer", "bottomOriginPadding", "", "lastAppliedExtraBottom", "sheetOriginBottomMargin", "lastAppliedSheetBottomExtra", "imeAnimationRunning", "", "sheetBottomMarginAnimator", "Landroid/animation/ValueAnimator;", MessageIndication.STATUS_SENDING, "avatarScrollEnabled", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "resolveSendMode", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onDestroyView", "bindViews", RootDescription.ROOT_ELEMENT, "goBackToSelect", "renderAvatars", "renderSingleAvatar", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "sizePx", "renderMultiAvatars", "items", "", "createAvatarContainer", "loadAvatar", "view", "setupAvatarScrollConflict", "createNameView", "Landroid/widget/TextView;", "ctx", "Landroid/content/Context;", "name", "", "createNameLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "readDisplayName", "renderPreview", "setupBottomInsets", "isImeAnimation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "applyBottomExtraPadding", BaseSwitches.V, "extraBottom", "currentSheetBottomMargin", "applySheetBottomMargin", "animate", "setSheetBottomMargin", "currentSheetBottomExtra", "resetSheetBottomMargin", "startToSend", "resolveForwardMessageIds", "doSuccess", "result", "Lcom/ss/android/lark/forwardv3/data/ForwardResultV3;", "resolveSourceChatId", "openChat", "chatId", "doError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "showToast", "clearFocus", "errorToast", "errorMsg", "Companion", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoForwardConfirmFragment extends Fragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f461206v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ForwardV3ViewModel f461207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ExternalForwardSendHelper f461208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExternalForwardSendMode f461209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f461210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HorizontalScrollView f461211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f461212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f461213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EditText f461214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f461215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f461216m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f461217n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f461218o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f461219p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f461220q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f461221r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f461222s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f461223t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f461224u;

    public static final class a {
    }

    public static final class b extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f461225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f461226b;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            this.f461225a.setImageDrawable(this.f461226b);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            ImageView r102 = this.f461225a;
            if (r101 != null) goto L5;
            r101 = this.f461226b;
        L5:
            r102.setImageDrawable(r101);
        }

        public b(ImageView r100, Drawable r101) {
            this.f461225a = r100;
            this.f461226b = r101;
        }
    }

    public static final class c implements com.ss.android.lark.forwardv3.y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoForwardConfirmFragment f461227a;

        public c(DoubaoForwardConfirmFragment r100) {
            this.f461227a = r100;
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void a(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "err");
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void onError(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "err");
            DoubaoForwardConfirmFragment r101 = this.f461227a;
            int r102 = DoubaoForwardConfirmFragment.f461206v;
            r101.getClass();
            UICallbackExecutor.post(com.suite.lark.platform.feature.forward.doubao.b.f461312a);
            String r103 = y9c.d.h(R.string.Lark_Legacy_ChatViewForwardingFailed);
            String r104 = null;
            if ((r100 instanceof ForwardErrorResultV3) == false) goto L5;
            ForwardErrorResultV3 r105 = (ForwardErrorResultV3) r100;
        L6:
            if (r105 != null) goto L8;
            UICallbackExecutor.execute(new com.suite.lark.platform.feature.forward.doubao.f(r101, r100.getDisplayMsg(r103)));
            return;
        L8:
            String r106 = r105.getMessage();
            if ((!TextUtils.isEmpty(r106)) == false) goto L11;
            r104 = r106;
        L11:
            if (r104 == null) goto L15;
            r103 = r104;
        L15:
            if (r105.isIsDialog() == false) goto L17;
            UICallbackExecutor.execute(new com.suite.lark.platform.feature.forward.doubao.c(r101, r105, r103));
            return;
        L17:
            UICallbackExecutor.execute(new com.suite.lark.platform.feature.forward.doubao.d(r101, r100, r103, r105));
            return;
        L5:
            r105 = null;
            goto L6
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void b(final rib.d r100, List<? extends SearchBaseInfo> r101) {
            Intrinsics.checkNotNullParameter(r101, "items");
            final DoubaoForwardConfirmFragment r102 = this.f461227a;
            int r103 = DoubaoForwardConfirmFragment.f461206v;
            r102.getClass();
            UICallbackExecutor.post(com.suite.lark.platform.feature.forward.doubao.e.f461333a);
            UICallbackExecutor.execute(new DoubaoForwardConfirmFragment$doSuccess$2(r102, r100));
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f461228a = null;

        static {
            f461228a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoForwardConfirmFragment f461231a;

        public e(DoubaoForwardConfirmFragment r100) {
            this.f461231a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DoubaoForwardConfirmFragment r101 = this.f461231a;
            int r102 = DoubaoForwardConfirmFragment.f461206v;
            KeyboardUtils.hideKeyboard(r101.requireActivity());
            r101.requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubaoForwardConfirmFragment f461232a;

        public f(DoubaoForwardConfirmFragment r100) {
            this.f461232a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            final DoubaoForwardConfirmFragment r101 = this.f461232a;
            int r102 = DoubaoForwardConfirmFragment.f461206v;
            final Context r103 = r101.getContext();
            if (r103 == null) goto L34;
            ForwardV3ViewModel r104 = r101.f461207d;
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r104 = null;
        L8:
            final List<SearchBaseInfo> r105 = r104.getSelectedItemList();
            if (r105.isEmpty() == false) goto L11;
            Log.w("DoubaoForwardConfirmFragment", "onSendClick skip: empty items");
            return;
        L11:
            View r106 = r101.f461215l;
            if (r106 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            r106 = null;
        L14:
            r106.setEnabled(false);
            View r107 = r101.f461215l;
            if (r107 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            r107 = null;
        L17:
            r107.setAlpha(0.6f);
            final BeforeForwardErrorHandle r108 = new BeforeForwardErrorHandle(r103);
            i08.a.b(r103, y9c.d.h(R.string.Lark_Legacy_Sending));
            EditText r109 = r101.f461214k;
            if (r109 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("noteEt");
            r109 = null;
        L20:
            Editable r110 = r109.getText();
            if (r110 == null) goto L25;
            String r111 = r110.toString();
            if (r111 == null) goto L25;
            final String r112 = StringsKt.trim(r111).toString();
        L26:
            if (r112 != null) goto L28;
            r112 = "";
        L28:
            ForwardV3ViewModel r113 = r101.f461207d;
            if (r113 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r113 = null;
        L31:
            r113.prepareChatBeforeForward(r105, new DoubaoForwardConfirmFragment$startToSend$1(r101, r103, r105, r112, r108));
            return;
        L25:
            r112 = null;
            goto L26
        }
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ValueAnimator r100 = this.f461223t;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        FrameLayout.LayoutParams r101 = null;
        this.f461223t = null;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L18;
        View r103 = r102.findViewById(R.id.bottom_sheet_container);
        if (r103 == null) goto L18;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L13;
        r101 = (FrameLayout.LayoutParams) r104;
    L13:
        if (r101 == null) goto L18;
        int r105 = r101.bottomMargin;
        int r106 = this.f461220q;
        if (r105 == r106) goto L18;
        r101.bottomMargin = r106;
        r103.setLayoutParams(r101);
    L18:
        super.onDestroyView();
    }

    public DoubaoForwardConfirmFragment() {
        this.f461219p = -1;
        this.f461221r = -1;
    }

    public final int W90() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L14;
        View r101 = r100.findViewById(R.id.bottom_sheet_container);
        if (r101 == null) goto L16;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L10;
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
    L11:
        if (r103 != null) goto L13;
        return 0;
    L13:
        return r103.bottomMargin;
    L10:
        r103 = null;
        goto L11
    L16:
        return 0;
    L14:
        return 0;
    }

    public final void Y90(int r100) {
        this.f461221r = r100;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L17;
        View r102 = r101.findViewById(R.id.bottom_sheet_container);
        if (r102 == null) goto L19;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof FrameLayout.LayoutParams) == false) goto L10;
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
    L11:
        if (r104 != null) goto L13;
        return;
    L13:
        int r105 = this.f461220q + r100;
        if (r104.bottomMargin == r105) goto L18;
        r104.bottomMargin = r105;
        r102.setLayoutParams(r104);
        return;
    L18:
        return;
    L10:
        r104 = null;
        goto L11
    L19:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Intent r101 = requireActivity().getIntent();
        ExternalForwardSendMode r102 = null;
        if (r101 == null) goto L7;
        Bundle r103 = r101.getExtras();
        if (r103 == null) goto L7;
        ForwardTemplateNew r104 = (ForwardTemplateNew) r103.getParcelable("key_intent_forward_template_new");
    L8:
        if (r104 != null) goto L11;
        Log.e("DoubaoForwardConfirmFragment", "ForwardTemplateNew is null, finish");
        requireActivity().finish();
        return;
    L11:
        this.f461207d = (ForwardV3ViewModel) new ViewModelProvider(requireActivity(), new ForwardV3ViewModelFactory(r104)).get(ForwardV3ViewModel.class);
        Intent r105 = requireActivity().getIntent();
        if (r105 == null) goto L14;
        String r106 = r105.getStringExtra("extra_external_forward_send_mode");
    L34:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L20
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        Object r108 = Result.m9449constructorimpl(ExternalForwardSendMode.valueOf(r106));     // Catch: Throwable -> L20
    L22:
        ExternalForwardSendMode r109 = ExternalForwardSendMode.DOUBAO_ENTRY;
        if (Result.m9455isFailureimpl(r108) == false) goto L25;
        r108 = r109;
    L25:
        this.f461209f = (ExternalForwardSendMode) r108;
        c r110 = new c(this);
        ForwardV3ViewModel r111 = this.f461207d;
        if (r111 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r111 = null;
    L28:
        ExternalForwardSendMode r112 = this.f461209f;
        if (r112 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException(RemoteMessageConst.SEND_MODE);
    L32:
        this.f461208e = new ExternalForwardSendHelper(r111, r110, r102);
        return;
    L31:
        r102 = r112;
    L20:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L14:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public static final boolean U90(DoubaoForwardConfirmFragment r100, WindowInsetsAnimationCompat r101) {
        r100.getClass();
        if ((r101.getTypeMask() & WindowInsetsCompat.Type.ime()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final FrameLayout V90(SearchBaseInfo r100, int r101) {
        Context r102 = requireContext();
        FrameLayout r103 = new FrameLayout(r102);
        ImageView r104 = new ImageView(r102);
        r104.setBackground(r102.getDrawable(R.drawable.doubao_forward_avatar_default_bg));
        r104.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r104.setClipToOutline(true);
        r103.addView(r104, new FrameLayout.LayoutParams(r101, r101));
        DoubaoThreadAvatar r105 = DoubaoThreadAvatar.INSTANCE;
        Integer r106 = r105.mainIconRes(r100);
        Integer r107 = r105.badgeIconRes(r100);
        if (r106 == null) goto L5;
        r104.setImageResource(r106.intValue());
    L6:
        if (r106 != null) goto L8;
        if (r107 != null) goto L8;
    L14:
        return r103;
    L8:
        int r108 = r103.getResources().getDimensionPixelSize(R.dimen.doubao_thread_avatar_badge_size);
        ImageView r109 = new ImageView(r102);
        r109.setBackground(r102.getDrawable(R.drawable.doubao_forward_avatar_default_bg));
        r109.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r109.setClipToOutline(true);
        if (r106 == null) goto L11;
        X90(r109, r100, r108);
    L13:
        r103.addView(r109, new FrameLayout.LayoutParams(r108, r108, VideoPlayDataContext.PLAYING_GRAVITY));
        goto L14
    L11:
        if (r107 == null) goto L13;
        r109.setImageResource(r107.intValue());
        goto L13
    L5:
        X90(r104, r100, r101);
        goto L6
    }

    public static final void S90(DoubaoForwardConfirmFragment r100, View r101, int r102) {
        if (r102 == r100.f461219p) goto L7;
        r100.f461219p = r102;
        int r103 = r100.f461218o + r102;
        r101.setPadding(r101.getPaddingLeft(), r101.getPaddingTop(), r101.getPaddingRight(), r103);
        return;
    }

    public static final void T90(DoubaoForwardConfirmFragment r100, int r101, boolean r102) {
        int r103 = r100.f461221r;
        if (r101 == r103) goto L26;
        Integer r104 = null;
        if (r102 == true) goto L11;
        ValueAnimator r105 = r100.f461223t;
        if (r105 == null) goto L10;
        r105.cancel();
    L10:
        r100.f461223t = null;
        r100.Y90(r101);
        return;
    L11:
        Integer r106 = Integer.valueOf(r103);
        if (r106.intValue() < 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r104 = r106;
    L17:
        if (r104 == null) goto L19;
        int r108 = r104.intValue();
    L20:
        ValueAnimator r109 = r100.f461223t;
        if (r109 == null) goto L23;
        r109.cancel();
    L23:
        ValueAnimator r110 = ValueAnimator.ofInt(new int[]{r108, r101});
        r110.setDuration(250);
        r110.addUpdateListener(new com.suite.lark.platform.feature.forward.doubao.a(r100));
        r110.start();
        r100.f461223t = r110;
        return;
    L19:
        r108 = RangesKt.coerceAtLeast(r100.W90() - r100.f461220q, 0);
        goto L20
    L14:
        r107 = false;
        goto L15
    }

    public final void X90(ImageView r100, SearchBaseInfo r101, int r102) {
        Context r103 = requireContext();
        String r104 = null;
        if (Intrinsics.areEqual(r101.getId(), ExternalTargetConstants.DOUBAO_EXTERNAL_TARGET_ID) == false) goto L9;
        mpc.e r105 = (mpc.e) OfficeSDKManager.getHostGlobalService(mpc.e.class);
        if (r105 == null) goto L9;
        mpc.a r106 = r105.K0();
        if (r106 == null) goto L9;
        Drawable r107 = r106.f514767c;
    L10:
        if (r107 == null) goto L13;
        ImageLoader.with(r103).load(r107).override(r102, r102).asDrawable().transform(new CropCircleTransformation()).into(new b(r100, r107));
        return;
    L13:
        String r108 = r101.getAvatarKey();
        if (r108.length() <= 0) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L19;
        r104 = r108;
    L19:
        if (r104 != null) goto L21;
        return;
    L21:
        ImageLoader.with(r103).load(AvatarImage.Builder.obtain(r104, DoubaoThreadAvatar.INSTANCE.avatarEntityId(r101), r102, r102).build()).asDrawable().transform(new CropCircleTransformation()).into(r100);
        return;
    L16:
        r109 = false;
    L9:
        r107 = null;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        int r100 = 0;
        final View r113 = r110.inflate(R.layout.fragment_forward_doubao_confirm, r111, false);
        Intrinsics.checkNotNull(r113);
        this.f461210g = (LinearLayout) r113.findViewById(R.id.forward_confirm_single_avatar_row);
        this.f461211h = (HorizontalScrollView) r113.findViewById(R.id.forward_confirm_avatar_scroll);
        this.f461212i = (LinearLayout) r113.findViewById(R.id.forward_confirm_avatar_row);
        this.f461213j = (FrameLayout) r113.findViewById(R.id.forward_confirm_preview_container);
        this.f461214k = (EditText) r113.findViewById(R.id.forward_confirm_note_et);
        this.f461215l = r113.findViewById(R.id.forward_confirm_send_btn);
        this.f461216m = (ImageView) r113.findViewById(R.id.forward_confirm_back_btn);
        View r114 = r113.findViewById(R.id.forward_confirm_bottom_container);
        this.f461217n = r114;
        View r101 = null;
        if (r114 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        r114 = null;
    L5:
        r114.setOnClickListener(d.f461228a);
        ImageView r115 = this.f461216m;
        if (r115 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        r115 = null;
    L8:
        r115.setOnClickListener(new e(this));
        View r116 = this.f461215l;
        if (r116 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
        r116 = null;
    L11:
        r116.setOnClickListener(new f(this));
        int r117 = ViewConfiguration.get(requireContext()).getScaledTouchSlop();
        Ref.FloatRef r102 = new Ref.FloatRef();
        Ref.FloatRef r103 = new Ref.FloatRef();
        HorizontalScrollView r104 = this.f461211h;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r104 = null;
    L14:
        r104.setOnTouchListener(new g(this, r102, r103, r117));
        ForwardV3ViewModel r118 = this.f461207d;
        if (r118 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r118 = null;
    L17:
        List<SearchBaseInfo> r119 = r118.getSelectedItemList();
        if (r119.isEmpty() == false) goto L26;
        LinearLayout r120 = this.f461210g;
        if (r120 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r120 = null;
    L22:
        r120.setVisibility(8);
        HorizontalScrollView r121 = this.f461211h;
        if (r121 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r121 = null;
    L25:
        r121.setVisibility(8);
    L77:
        Unit r122 = Unit.INSTANCE;
        ppc.f r123 = ppc.f.f530249a;
        FragmentActivity r105 = requireActivity();
        FrameLayout r106 = this.f461213j;
        if (r106 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
        r106 = null;
    L80:
        ForwardV3ViewModel r107 = this.f461207d;
        if (r107 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r107 = null;
    L83:
        ppc.g r108 = new ppc.g(r105, this, r106, r107);
        r123.getClass();
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        r108.f530253c.removeAllViews();
        r108.f530253c.setVisibility(8);
        Iterator<T> r124 = ppc.f.f530250b.iterator();
    L85:
        if (r124.hasNext() == false) goto L89;
        Object r109 = r124.next();
        if (((ppc.e) r109).a(r108) == false) goto L85;
    L90:
        ppc.e r125 = (ppc.e) r109;
        if (r125 != null) goto L98;
        StringBuilder r126 = new StringBuilder("skip unsupported forwardContent=");
        IForwardContent r127 = r108.f530254d.getForwardContent();
        if (r127 == null) goto L95;
        String r128 = r127.getClass().getSimpleName();
    L96:
        r126.append(r128);
        Log.i("DoubaoForwardPreviewBinder", r126.toString());
    L100:
        this.f461219p = -1;
        this.f461221r = -1;
        View r129 = this.f461217n;
        if (r129 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
    L104:
        this.f461218o = r101.getPaddingBottom();
        this.f461220q = W90();
        ViewCompat.setOnApplyWindowInsetsListener(r113, new h(this));
        ViewCompat.setWindowInsetsAnimationCallback(r113, new DoubaoForwardConfirmFragment$setupBottomInsets$2(this, r113));
        ViewCompat.requestApplyInsets(r113);
        return r113;
    L103:
        r101 = r129;
        goto L104
    L95:
        r128 = null;
        goto L96
    L98:
        if (r125.b(r108) == true) goto L100;
        r108.f530253c.removeAllViews();
        r108.f530253c.setVisibility(8);
        goto L100
    L89:
        r109 = null;
        goto L90
    L26:
        int r130 = y9c.d.a(36);
        if (r119.size() != 1) goto L49;
        SearchBaseInfo r131 = (SearchBaseInfo) CollectionsKt.first(r119);
        this.f461224u = false;
        HorizontalScrollView r132 = this.f461211h;
        if (r132 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r132 = null;
    L31:
        r132.setVisibility(8);
        LinearLayout r133 = this.f461212i;
        if (r133 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("avatarRow");
        r133 = null;
    L34:
        r133.removeAllViews();
        LinearLayout r134 = this.f461210g;
        if (r134 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r134 = null;
    L37:
        r134.setVisibility(0);
        r134.removeAllViews();
        r134.addView(V90(r131, r130), new LinearLayout.LayoutParams(r130, r130));
        String r135 = r131.getTitle();
        if (r135 != null) goto L41;
        r135 = "";
    L41:
        if (r135.length() <= 0) goto L43;
        boolean r136 = true;
    L44:
        if (r136 == true) goto L47;
        r135 = null;
    L47:
        if (r135 == null) goto L77;
        Context r137 = requireContext();
        TextView r138 = new TextView(r137);
        r138.setText(r135);
        r138.setTextSize(17.0f);
        r138.setTextColor(ContextCompat.getColor(r137, R.color.forward_larus_neutral_100));
        r138.setMaxLines(1);
        r138.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r139 = new LinearLayout.LayoutParams(0, -2);
        r139.setMarginStart(y9c.d.a(12));
        r139.gravity = 16;
        r139.weight = 1.0f;
        r134.addView(r138, r139);
        goto L77
    L43:
        r136 = false;
        goto L44
    L49:
        LinearLayout r140 = this.f461210g;
        if (r140 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r140 = null;
    L52:
        r140.setVisibility(8);
        LinearLayout r141 = this.f461210g;
        if (r141 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("singleAvatarRow");
        r141 = null;
    L55:
        r141.removeAllViews();
        this.f461224u = true;
        HorizontalScrollView r142 = this.f461211h;
        if (r142 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r142 = null;
    L58:
        r142.setVisibility(0);
        HorizontalScrollView r143 = this.f461211h;
        if (r143 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScroll");
        r143 = null;
    L61:
        r143.scrollTo(0, 0);
        int r144 = y9c.d.a(8);
        LinearLayout r145 = this.f461212i;
        if (r145 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("avatarRow");
        r145 = null;
    L64:
        r145.removeAllViews();
        r145.setMinimumWidth(0);
        r145.getLayoutParams().width = -2;
        r145.setLayoutParams(r145.getLayoutParams());
        r145.setGravity(17);
        Iterator<T> r146 = r119.iterator();
    L66:
        if (r146.hasNext() == false) goto L77;
        Object r147 = r146.next();
        int r148 = r100 + 1;
        if (r100 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        SearchBaseInfo r149 = (SearchBaseInfo) r147;
        LinearLayout.LayoutParams r150 = new LinearLayout.LayoutParams(r130, r130);
        if (r100 <= 0) goto L73;
        r150.setMarginStart(r144);
    L73:
        LinearLayout r151 = this.f461212i;
        if (r151 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("avatarRow");
        r151 = null;
    L76:
        r151.addView(V90(r149, r130), r150);
        r100 = r148;
        goto L66
    }
}
