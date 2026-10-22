package com.larus.drive.sdk.impl.view.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.drive.sdk.impl.databinding.LarusLayoutDrivePreviewFileFragmentBinding;
import com.larus.drive.sdk.impl.service.t;
import com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer;
import com.larus.drive.sdk.impl.viewmodel.preview.DrivePreviewViewModel;
import com.larus.nova.R;
import com.larus.platform.exp.o;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import va8.g0;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\u0006\u0010%\u001a\u00020\"J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020 H\u0002J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0018H\u0002J\u0010\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/drive/sdk/impl/view/preview/DrivePreviewFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusLayoutDrivePreviewFileFragmentBinding;", "viewModel", "Lcom/larus/drive/sdk/impl/viewmodel/preview/DrivePreviewViewModel;", "getViewModel", "()Lcom/larus/drive/sdk/impl/viewmodel/preview/DrivePreviewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "floatChatContainer", "Lcom/larus/drive/sdk/impl/view/chat/DriveFloatChatContainer;", "contentContainer", "Lcom/larus/drive/sdk/impl/view/preview/DrivePreviewContentContainer;", "conversationId", "", "driveFile", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "previewFromPage", "Lcom/larus/drive/sdk/api/meta/PreviewFromPage;", "getCurrentPageName", "autoLogEnterPage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onBackPressed", "initHostFragment", "initConfig", "refreshPreviewPermission", "initTopContainer", "initContentContainer", "initFloatChatContainer", "getParamsBundle", "handleDrivePreviewSendMsg", "sendText", "isSpeak", "buildMoreMenu", "anchorView", "adjustPreviewContentBottomMargin", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewFragment extends TraceFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f342288l = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusLayoutDrivePreviewFileFragmentBinding f342289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f342290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DriveFloatChatContainer f342291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f342292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f342293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DriveFileItem f342294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PreviewFromPage f342295k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "ai_space_detail";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        e r100 = this.f342292h;
        if (r100 == null) goto L13;
        Fragment r101 = r100.f342308e;
        if (r101 != null) goto L7;
    L12:
        r100.f342308e = null;
        goto L13
    L7:
        if (r101.isAdded() == false) goto L12;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        r100.f342304a.getChildFragmentManager().beginTransaction().remove(r101).commitNowAllowingStateLoss();     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        this.f342292h = null;
        DriveFloatChatContainer r104 = this.f342291g;
        if (r104 == null) goto L53;
        r104.f342061h++;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[detach] start, fragmentTag=");
        r106.append(r104.f342055b);
        r106.append(", containerId=");
        r106.append(r104.f342056c);
        r106.append(", fragmentAdded=");
        Fragment r107 = r104.f342059f;
        if (r107 != null) goto L18;
    L20:
        boolean r108 = false;
    L21:
        r106.append(r108);
        r105.i("DriveFloatChatContainer", r106.toString());
        r104.b("[detach] provider before clear");
        DriveFloatChatContainer.c r109 = r104.f342060g;
        if (r109 == null) goto L26;
        g0 r110 = r109.b();
        if (r110 == null) goto L26;
        r110.Zh(r104.f342064k);
    L26:
        DriveFloatChatContainer.c r111 = r104.f342060g;
        if (r111 == null) goto L31;
        r79.b r112 = r111.e();
        if (r112 == null) goto L31;
        r112.az(false);
    L31:
        DriveFloatChatContainer.c r113 = r104.f342060g;
        if (r113 == null) goto L36;
        ICoreInputAbility r114 = r113.v0();
        if (r114 == null) goto L36;
        r114.p80(true);
        r114.tr(new com.larus.drive.sdk.impl.view.chat.a());
    L36:
        DriveFloatChatContainer.c r115 = r104.f342060g;
        if (r115 == null) goto L41;
        l r116 = r115.c();
        if (r116 == null) goto L41;
        r116.b3(new com.larus.drive.sdk.impl.view.chat.b());
        r116.B9(r104.f342065l);
    L41:
        Fragment r117 = r104.f342059f;
        if (r117 != null) goto L55;
        r105.i("DriveFloatChatContainer", "[detach] skip remove, fragment is null");
    L52:
        r104.f342060g = null;
        r104.f342059f = null;
        FLogger.f375446a.i("DriveFloatChatContainer", "[detach] finish, fragmentTag=" + r104.f342055b + ", containerId=" + r104.f342056c);
        goto L53
    L55:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L45
        Object r119 = Result.m9449constructorimpl(Integer.valueOf(r104.f342054a.getChildFragmentManager().beginTransaction().remove(r117).commitAllowingStateLoss()));     // Catch: Throwable -> L45
    L47:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L50;
        FLogger.f375446a.e("DriveFloatChatContainer", "[detach] remove fragment failed, fragmentTag=" + r104.f342055b + ", containerId=" + r104.f342056c, r120);
    L50:
        Result.m9448boximpl(r119);
    L45:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L18:
        if (r107.isAdded() != true) goto L20;
        r108 = true;
    L53:
        this.f342291g = null;
        this.f342289e = null;
        super.onDestroyView();
    }

    public DrivePreviewFragment() {
        final Function0<Fragment> r100 = new DrivePreviewFragment$special$$inlined$viewModels$default$1(this);
        this.f342290f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DrivePreviewViewModel.class), new DrivePreviewFragment$special$$inlined$viewModels$default$2(r100), new DrivePreviewFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f342293i = "";
        this.f342295k = PreviewFromPage.UNKNOWN;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        String r102 = "";
        String r103 = null;
        if (o.a() == true) goto L10;
        wc9.e r104 = AuthModelDelegate.f297134b.y().getValue();
        if (r104 == null) goto L8;
        String r105 = r104.f559198a;
    L9:
        if (r105 == null) goto L10;
    L11:
        this.f342293i = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L14;
        DriveFileItem r107 = (DriveFileItem) r106.getParcelable("drive_file");
    L15:
        this.f342294j = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L28;
        String r109 = r108.getString("drive_preview_from_page");
        if (r109 == null) goto L28;
        Iterator<PreviewFromPage> r110 = PreviewFromPage.getEntries().iterator();
    L21:
        if (r110.hasNext() == false) goto L25;
        PreviewFromPage r111 = r110.next();
        if (Intrinsics.areEqual(r111.getValue(), r109) == false) goto L21;
    L26:
        PreviewFromPage r112 = r111;
        if (r112 == null) goto L28;
    L29:
        this.f342295k = r112;
        DriveFileItem r113 = this.f342294j;
        boolean r114 = true;
        if (r113 == null) goto L38;
        String r115 = r113.f341565b;
        if (r115.length() != 0) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == false) goto L37;
        FLogger.f375446a.i("DrivePreviewFragment", "[refreshPreviewPermission] invalid fileToken");
        goto L38
    L37:
        t.a().p(r115, r113.f341567d, null);
        goto L38
    L34:
        r116 = false;
    L38:
        final LarusLayoutDrivePreviewFileFragmentBinding r117 = this.f342289e;
        if (r117 == null) goto L57;
        ConstraintLayout r118 = r117.f341752h;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if ((r119 instanceof ConstraintLayout.LayoutParams) == false) goto L43;
        ConstraintLayout.LayoutParams r120 = (ConstraintLayout.LayoutParams) r119;
    L44:
        if (r120 == null) goto L50;
        FragmentActivity r121 = getActivity();
        if (r121 == null) goto L48;
        int r122 = u.c(r121);
    L49:
        ((ViewGroup.MarginLayoutParams) r120).topMargin = r122;
    L51:
        r118.setLayoutParams(r120);
        TextView r123 = r117.f341751g;
        DriveFileItem r124 = this.f342294j;
        if (r124 == null) goto L54;
        String r125 = r124.f341564a;
    L55:
        r123.setText(r125);
        e1.d(r117.f341746b, new f(this));
        e1.d(r117.f341750f, new g(this, r117));
        goto L57
    L54:
        r125 = null;
        goto L55
    L48:
        r122 = 0;
        goto L49
    L50:
        r120 = null;
        goto L51
    L43:
        r120 = null;
    L57:
        if (this.f342292h == null) goto L59;
        FLogger.f375446a.i("DrivePreviewFragment", "[initContentContainer] Already init");
    L98:
        if (this.f342291g == null) goto L100;
        FLogger.f375446a.i("DrivePreviewFragment", "[initFloatChatFragment] Already init");
    L117:
        LarusLayoutDrivePreviewFileFragmentBinding r126 = this.f342289e;
        if (r126 == null) goto L126;
        FrameLayout r127 = r126.f341747c;
        if (r127 == null) goto L127;
        r127.postDelayed(new h(this), 500);
        return;
    L127:
        return;
    L126:
        return;
    L100:
        DriveFileItem r128 = this.f342294j;
        if (r128 == null) goto L103;
        r103 = r128.d(false);
    L103:
        if (r103 == null) goto L107;
        r102 = r103;
    L107:
        if (UploadFilePolicy.e(r102) == true) goto L109;
        FLogger.f375446a.i("DrivePreviewFragment", "[initFloatChatFragment] This file postFix=" + r102 + " is not support input");
        goto L117
    L109:
        DriveFileItem r129 = this.f342294j;
        if (r129 == null) goto L112;
        long r130 = r129.e();
    L114:
        if (UploadFilePolicy.f(r130) == true) goto L116;
        FLogger.f375446a.i("DrivePreviewFragment", "[initFloatChatFragment] This file size=" + r130 + " is not support input");
        goto L117
    L116:
        DriveFloatChatContainer r131 = new DriveFloatChatContainer(this, new DrivePreviewFragment$initFloatChatContainer$1(this), new k(this));
        this.f342291g = r131;
        r131.a();
        goto L117
    L112:
        r130 = 0;
        goto L114
    L59:
        e r132 = new e(this, this.f342294j);
        this.f342292h = r132;
        if (r132.f342308e == null) goto L63;
        FLogger.f375446a.i("DrivePreviewContentContainer", "[attach] Already attached");
        goto L98
    L63:
        if (r132.f342304a.isAdded() == true) goto L65;
        FLogger.f375446a.i("DrivePreviewContentContainer", "[attach] Parent not added");
        goto L98
    L65:
        DriveFileItem r133 = r132.f342306c;
        if (r133 == null) goto L68;
        String r134 = r133.f341565b;
    L69:
        if (r134 != null) goto L71;
        r134 = "";
    L71:
        String r135 = StringsKt.trim(r134).toString();
        if ((!StringsKt.isBlank(r135)) == false) goto L74;
        String r136 = "https://feishu.doubao.com/file/" + r135;
    L76:
        if ((!StringsKt.isBlank(r136)) == false) goto L78;
        Fragment r137 = t.b().d(r136);
    L79:
        if (r137 != null) goto L81;
        r137 = new DrivePreviewContentFragment();
    L81:
        r132.f342308e = r137;
        FragmentTransaction r138 = r132.f342304a.getChildFragmentManager().beginTransaction();
        String r139 = r132.f342307d;
        if (r139 != null) goto L84;
    L87:
        if (r114 == false) goto L92;
        int r140 = r132.f342305b;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r138, r137, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r140) == true) goto L96;
        r138.replace(r140, r137);
    L96:
        r138.commitNowAllowingStateLoss();
        goto L98
    L92:
        int r141 = r132.f342305b;
        String r142 = r132.f342307d;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r138, r137, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r142, r141) == true) goto L96;
        r138.replace(r141, r137, r142);
        goto L96
    L84:
        if (StringsKt.isBlank(r139) == true) goto L87;
        r114 = false;
        goto L87
    L78:
        r137 = null;
        goto L79
    L74:
        r136 = "";
        goto L76
    L68:
        r134 = null;
        goto L69
    L25:
        r111 = null;
    L28:
        r112 = PreviewFromPage.UNKNOWN;
        goto L29
    L14:
        r107 = null;
        goto L15
    L8:
        r105 = null;
    L10:
        r105 = "";
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_layout_drive_preview_file_fragment, r111, false);
        int r114 = R.id.drive_preview_back;
        ImageView r100 = (ImageView) ViewBindings.findChildViewById(r113, R.id.drive_preview_back);
        if (r100 == null) goto L19;
        r114 = R.id.drive_preview_content_container;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.drive_preview_content_container);
        if (r101 == null) goto L19;
        r114 = R.id.drive_preview_float_chat_container;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.drive_preview_float_chat_container);
        if (r102 == null) goto L19;
        r114 = R.id.drive_preview_float_chat_mask;
        View r103 = ViewBindings.findChildViewById(r113, R.id.drive_preview_float_chat_mask);
        if (r103 == null) goto L19;
        r114 = R.id.drive_preview_more;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r113, R.id.drive_preview_more);
        if (r104 == null) goto L19;
        r114 = R.id.drive_preview_title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.drive_preview_title);
        if (r105 == null) goto L19;
        r114 = R.id.drive_preview_title_bar;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.drive_preview_title_bar);
        if (r106 == null) goto L19;
        ConstraintLayout r115 = (ConstraintLayout) r113;
        this.f342289e = new LarusLayoutDrivePreviewFileFragmentBinding(r115, r100, r101, r102, r103, r104, r105, r106);
        return r115;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
