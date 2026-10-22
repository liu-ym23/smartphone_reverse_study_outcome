package com.bytedance.ee.bear.middleground.permission.transfer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import ax4.d;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.b;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.OwnerTransferApplyExecutor;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.e;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mbb.c;
import sbb.g;
import ti5.h;
import ti5.i;
import ti5.j;
import ti5.k;
import ti5.l;
import ti5.m;
import ti5.o;
import ti5.p;
import ti5.s;
import ti5.t;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u001a\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "info", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/TransferApplyInfo;", "adapter", "Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyAdapter;", "selectPermission", "", "isPresenter", "", "recursiveTransfer", "removeOldOwner", "ownerTransferApplyInfo", "Lcom/bytedance/ee/bear/middleground/permission/transfer/executor/OwnerTransferApplyExecutor;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "editText", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "handleCheckFolder", "handlePresenterFolder", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", WidgetCostModule.TYPE_ON_START, "onViewCreated", "view", "init", "handleTransferButtonStatus", "rootView", "fetchNeedDoubleCheck", "showActionSheet", "Landroid/widget/TextView;", "observePermission", "getDoubleCheckerMessage", "", "showDoubleCheckerDialog", "showTransferDialog", "showFolderDialog", "handlePermissionError", LynxError.LYNX_THROWABLE, "", "showCheckDialog", "addWatermark", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransferApplyFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f234285q = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TransferApplyInfo f234286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TransferApplyAdapter f234287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f234288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f234289k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f234290l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f234291m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OwnerTransferApplyExecutor f234292n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CompositeDisposable f234293o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f234294p;

    public static final class a {
    }

    static {
    }

    public TransferApplyFragment() {
        this.f234286h = new TransferApplyInfo(0, null, null, null, null, 0, null, false, false, false, 0, false, false, 8191, null);
        this.f234288j = 3;
        this.f234294p = "";
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r100 = this.f234293o;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -2;
        r102.gravity = 80;
        r101.setAttributes(r102);
        r102.softInputMode = 16;
        r101.setDimAmount(0.2f);
        r101.setWindowAnimations(R.style.ActionSheetAnimation);
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        return;
    L9:
        return;
    }

    public static final void aa0(TransferApplyFragment r110) {
        if (r110.f234286h.getType() != 0) goto L16;
        Context r100 = r110.getContext();
        if (r100 == null) goto L54;
        String r111 = r110.f234286h.getOwnerName();
        boolean r112 = r110.f234289k;
        int r113 = t.f546152a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "ownerName");
        String r101 = r100.getString(R.string.CreationMobile_ECM_Transfer_DocTitle);
        if (r112 == false) goto L10;
        String r102 = xo5.a.c(r100, R.string.LarkCCM_Perm_ChangeFolderOwner_WillChangeDocLocation_Description, "userName", r111);
    L11:
        Pair r103 = new Pair(r101, r102);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r104 = new UDDialogBuilder(r100);
        r104.autoDismiss(true);
        CharSequence r105 = (CharSequence) r103.getFirst();
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.title(r105);
        r104.titleBold(true);
        r104.titleGravity(17);
        CharSequence r106 = (CharSequence) r103.getSecond();
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.message(r106);
        r104.messageGravity(GravityCompat.START);
        r104.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Share_Transfer, new s(r100, r110));
        r104.addActionButton(R.id.ud_dialog_btn_secondary, R.string.CreationMobile_Docs_Cancel_Button, null);
        UDDialog r107 = r104.build();
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r107);
        return;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L15:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        return;
    L10:
        r102 = xo5.a.c(r100, R.string.CreationMobile_ECM_Transfer_ConfirmDialog, HintConstants.AUTOFILL_HINT_USERNAME, r111);
        goto L11
    L54:
        return;
    L16:
        Context r108 = r110.getContext();
        if (r108 == null) goto L55;
        int r114 = r110.f234286h.getType();
        String r115 = r110.f234286h.getOwnerName();
        boolean r116 = r110.f234289k;
        boolean r117 = r110.f234286h.isWiki();
        int r118 = t.f546152a;
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "ownerName");
        if (r114 == 28) goto L27;
        if (r117 == true) goto L27;
        String r109 = r108.getString(R.string.CreationMobile_ECM_Transfer_DocTitle);
        if (r116 == false) goto L25;
        String r119 = xo5.a.c(r108, R.string.LarkCCM_Perm_ChangeDocOwner_WillChangeDocLocation_Description, "userName", r115);
    L26:
        Intrinsics.checkNotNull(r119);
        Pair r120 = new Pair(r109, r119);
    L39:
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r121 = new UDDialogBuilder(r108);
        r121.autoDismiss(true);
        CharSequence r122 = (CharSequence) r120.getFirst();
        Intrinsics.checkNotNullParameter(r122, "value");
        r121.title(r122);
        CharSequence r123 = (CharSequence) r120.getSecond();
        Intrinsics.checkNotNullParameter(r123, "value");
        r121.message(r123);
        r121.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, o.f546133a);
        r121.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Share_Transfer, new p(r108, r110));
        r121.cancelOnTouchOutside(false);
        UDDialog r124 = r121.build();
        if (DialogLancet.shouldBlockDialogShow(r124) == false) goto L47;
        DialogLancet.handleBlockedDialogShow(r124);
        return;
    L47:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L43:
        DialogLancet.beforeDialogShow(r124);
        r124.show();
        DialogLancet.afterDialogShow(r124);
        return;
    L25:
        r119 = xo5.a.c(r108, R.string.CreationMobile_ECM_Transfer_DocContent, HintConstants.AUTOFILL_HINT_USERNAME, r115);
    L27:
        HashMap r125 = new HashMap();
        r125.put("who", r115);
        r125.put("bot", r108.getString(b.a(r114)));
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (g.b(r114) == false) goto L30;
        String r126 = r108.getString(R.string.LarkCCM_Common_app_Variable);
    L38:
        r125.put("doc_type", r126);
        r120 = new Pair(xo5.a.c(r108, R.string.Doc_Share_ConfirmTransferOwner, "who", r115), xo5.a.d(r108, R.string.Doc_Share_TransferDocOwnerExplain_AddVariable, r125));
        goto L39
    L30:
        if (r114 != 0) goto L32;
        r126 = r108.getString(R.string.Doc_List_TypeSimpleNameFolder);
        goto L38
    L32:
        if (r114 == 12) goto L36;
        if (r114 == 28) goto L35;
        r126 = r108.getString(R.string.Doc_List_TypeSimpleNameDoc);
        goto L38
    L35:
        r126 = r108.getString(R.string.CreationMobile_Minutes_name);
        goto L38
    L36:
        r126 = r108.getString(R.string.Doc_Facade_MoreRenameTypeFile);
        goto L38
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r210) {
        super.onCreate(r210);
        Bundle r100 = getArguments();
        Disposable r101 = null;
        if (r100 == null) goto L11;
        Serializable r102 = r100.getSerializable("extra_info");
        if ((r102 instanceof TransferApplyInfo) == false) goto L7;
        TransferApplyInfo r103 = (TransferApplyInfo) r102;
    L8:
        if (r103 != null) goto L10;
        r103 = new TransferApplyInfo(0, null, null, null, null, 0, null, false, false, false, 0, false, false, 8191, null);
    L10:
        this.f234286h = r103;
        goto L11
    L7:
        r103 = null;
    L11:
        this.f234293o = new CompositeDisposable();
        this.f234292n = new OwnerTransferApplyExecutor((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        if (this.f234286h.getType() == 28) goto L33;
        int r104 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        boolean r105 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.transfer_check");
        tt5.a.h("PermFGUtils", "enableTransferCheck()...enable = " + r105);
        if (r105 == false) goto L30;
        AccountService$Account r106 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (TextUtils.isEmpty(r106.uid) == true) goto L19;
        String r107 = r106.uid;
    L20:
        OwnerTransferApplyExecutor r108 = this.f234292n;
        if (r108 == null) goto L25;
        String r109 = this.f234286h.getToken();
        int r110 = this.f234286h.getType();
        Intrinsics.checkNotNull(r107);
        Intrinsics.checkNotNullParameter(r109, "token");
        Intrinsics.checkNotNullParameter(r107, "ownerId");
        JsonObject r111 = new JsonObject();
        JsonArray r112 = new JsonArray();
        JsonObject r113 = new JsonObject();
        r113.addProperty("obj_type", Integer.valueOf(r110));
        r113.addProperty("obj_token", r109);
        r112.add(r113);
        r111.addProperty("owner_id", r107);
        r111.add("entities", r112);
        NetService.f r114 = new NetService.f("/api/explorer/v2/transfer_check/");
        r114.f216906c = 1;
        r114.f216913j = r111.toString();
        Flowable r115 = r108.f234295a.Vc(new OwnerTransferApplyExecutor.b(r108, r109)).a(r114).map(e.f234302a);
        if (r115 == null) goto L25;
        r101 = r115.subscribe(new ti5.g(this), h.f546123a);
    L25:
        if (r101 == null) goto L31;
        CompositeDisposable r116 = this.f234293o;
        if (r116 == null) goto L32;
        r116.add(r101);
        return;
    L32:
        return;
    L31:
        return;
    L19:
        r107 = this.f234286h.getOwnerId();
        goto L20
    L30:
        return;
    }

    public static final void Z90(TransferApplyFragment r100, Throwable r101) {
        r100.getClass();
        Toast.cancelLoading();
        Context r102 = r100.getContext();
        if (r102 == null) goto L26;
        String r103 = r100.f234286h.getOwnerName();
        int r104 = t.f546152a;
        Intrinsics.checkNotNullParameter(r103, "ownerName");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (d.b(r101, 10015) == false) goto L8;
    L20:
        Toast.showFailureText(r102, UIHelper.mustacheFormat(R.string.LarkCCM_Docs_BlockTransfer2Kp_Toast, "user", r103));
        return;
    L8:
        if (d.b(r101, 10022) == true) goto L20;
        if (d.b(r101, 2002) == false) goto L14;
        t.b(r102);
        return;
    L14:
        if (d.b(r101, 2005) == false) goto L17;
        t.c(r102, r102.getResources().getString(R.string.LarkCCM_Docs_CannotTransferOwner_Toast));
        return;
    L17:
        if (d.b(r101, 2006) == false) goto L19;
        t.c(r102, r102.getResources().getQuantityString(R.plurals.LarkCCM_Docs_ContentUnderReview_Toast, 1, new Object[]{15}));
        return;
    L19:
        Toast.showFailureText(r102, R.string.LarkCCM_Perm_UnableToChangeOwner_Toast);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        BaseTitleBar r100 = (BaseTitleBar) r210.findViewById(R.id.titleBar);
        TextView r101 = (TextView) r210.findViewById(R.id.selected_doc_name);
        UDAvatar r102 = (UDAvatar) r210.findViewById(R.id.selected_doc_avatar);
        TextView r103 = (TextView) r210.findViewById(R.id.transfer_name);
        LinearLayout r104 = (LinearLayout) r210.findViewById(R.id.transfer_doc_root);
        RecyclerView r105 = (RecyclerView) r210.findViewById(R.id.recyclerView);
        View r106 = r210.findViewById(R.id.divider);
        LinearLayout r107 = (LinearLayout) r210.findViewById(R.id.transfer_folder_root);
        UDCheckBox r110 = (UDCheckBox) r210.findViewById(R.id.folder_check_box);
        if (r100 == null) goto L5;
        r100.setLeftClickListener(new j(this));
    L5:
        String r111 = UIHelper.mustacheFormat(R.string.LarkCCM_Docs_TransferOwnerRequest_ToUser_Title, HintConstants.AUTOFILL_HINT_USERNAME, this.f234286h.getOwnerName());
        if (r100 == null) goto L8;
        r100.setTitle(r111);
    L8:
        r105.setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        TransferApplyAdapter r108 = new TransferApplyAdapter();
        this.f234287i = r108;
        Context r112 = getContext();
        int r113 = t.f546152a;
        ArrayList r114 = new ArrayList();
        if (r112 == null) goto L14;
        String r115 = r112.getString(R.string.LarkCCM_Docs_TransferOwnerRequest_KeepPerm_Radio);
        if (r115 == null) goto L14;
        String r116 = r115;
    L15:
        r114.add(new ti5.d(true, true, r116, true, 5));
        if (r112 == null) goto L21;
        String r117 = r112.getString(R.string.LarkCCM_Docs_TransferOwnerRequest_NotKeep_Radio);
        if (r117 == null) goto L21;
        String r212 = r117;
    L22:
        r114.add(new ti5.d(false, false, r212, false, 111));
        r108.setNewData(r114);
        TransferApplyAdapter r109 = this.f234287i;
        if (r109 == null) goto L25;
        k r118 = new k(this);
        Intrinsics.checkNotNullParameter(r118, "clickListener");
        r109.f234284a = r118;
    L25:
        r105.setAdapter(this.f234287i);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.f234286h.getToken(), this.f234286h.getType(), getDialog());
        boolean r119 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
        if (TextUtils.isEmpty(this.f234286h.getOwnerId()) == true) goto L37;
        if (r119 == false) goto L37;
        Context r120 = getContext();
        if (r120 == null) goto L37;
        UDButton r121 = (UDButton) r210.findViewById(R.id.doneBtn);
        if (r121 == null) goto L35;
        r121.setBackgroundColor(UDColorUtils.getColor(r120, R.color.ud_button_blue_bg));
    L35:
        if (r121 == null) goto L37;
        r121.setOnClickListener(new i(r120, this));
    L37:
        int r122 = 8;
        if (this.f234286h.getShowDocTile() == true) goto L40;
        if (r103 == null) goto L57;
        r103.setVisibility(8);
    L57:
        if (r104 == null) goto L60;
        r104.setVisibility(8);
    L60:
        if (r106 == null) goto L68;
        if (this.f234286h.getShowDocTile() == true) goto L64;
    L66:
        r106.setVisibility(r122);
        goto L68
    L64:
        if (this.f234286h.getType() != 0) goto L66;
        r122 = 0;
    L68:
        if (this.f234286h.getType() != 0) goto L85;
        if (r103 == null) goto L77;
        Context r123 = getContext();
        if (r123 == null) goto L75;
        String r124 = r123.getString(R.string.LarkCCM_Docs_TransferOwnerRequest_SelectedFolder_Title);
        if (r124 == null) goto L75;
    L76:
        r103.setText(r124);
    L75:
        r124 = "";
    L77:
        if (r103 == null) goto L79;
        r103.setVisibility(0);
    L79:
        if (r107 == null) goto L81;
        r107.setVisibility(0);
    L81:
        r107.setOnClickListener(new l(r110, this));
        if (r110 == null) goto L86;
        r110.setOnCheckedChangeListener(new m(this));
        return;
    L86:
        return;
    L85:
        return;
    L40:
        if (TextUtils.isEmpty(this.f234286h.getTitle()) == true) goto L43;
        if (r101 == null) goto L46;
        r101.setText(this.f234286h.getTitle());
    L46:
        if (TextUtils.isEmpty(this.f234286h.getIconUrl()) == true) goto L48;
    L51:
        obb.a r125 = new obb.a(Boolean.FALSE, Boolean.valueOf(this.f234286h.isShareFolder()), null);
        r125.b(IconScene.DOCUMENT);
        if (g.b(this.f234286h.getType()) == false) goto L54;
        Intrinsics.checkNotNull(r102);
        c.c(r102, this.f234286h.getToken(), this.f234286h.getType(), IconShape.SQUARE, r125);
        goto L60
    L54:
        Intrinsics.checkNotNull(r102);
        c.e(r102, this.f234286h.getIconUrl(), IconShape.SQUARE, r125);
        goto L60
    L48:
        if (this.f234286h.getIcon() == (-1)) goto L51;
        if (r102 == null) goto L60;
        r102.setImageResource(this.f234286h.getIcon());
        goto L60
    L43:
        if (r101 == null) goto L46;
        r101.setText(((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(getActivity(), this.f234286h.getType()));
    L21:
        r212 = "";
    L14:
        r116 = "";
        goto L15
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.transfer_apply_fragment, r101, false);
    }
}
