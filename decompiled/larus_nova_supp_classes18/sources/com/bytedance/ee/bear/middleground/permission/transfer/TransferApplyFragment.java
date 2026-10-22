package com.bytedance.ee.bear.middleground.permission.transfer;

import android.R;
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
import androidx.recyclerview.widget.RecyclerView;
import ax4.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.b;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.OwnerTransferApplyExecutor;
import com.bytedance.ee.bear.middleground.permission.transfer.executor.e;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u001a\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "info", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/TransferApplyInfo;", "adapter", "Lcom/bytedance/ee/bear/middleground/permission/transfer/TransferApplyAdapter;", "selectPermission", "", "isPresenter", "", "recursiveTransfer", "removeOldOwner", "ownerTransferApplyInfo", "Lcom/bytedance/ee/bear/middleground/permission/transfer/executor/OwnerTransferApplyExecutor;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "editText", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleCheckFolder", "handlePresenterFolder", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "init", "handleTransferButtonStatus", "rootView", "fetchNeedDoubleCheck", "showActionSheet", "Landroid/widget/TextView;", "observePermission", "getDoubleCheckerMessage", "", "showDoubleCheckerDialog", "showTransferDialog", "showFolderDialog", "handlePermissionError", "throwable", "", "showCheckDialog", "addWatermark", "onDestroy", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransferApplyFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int q = 0;
    public TransferApplyInfo h;
    public TransferApplyAdapter i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public OwnerTransferApplyExecutor n;
    public CompositeDisposable o;
    public CharSequence p;

    public static final class a {
    }

    static {
    }

    public TransferApplyFragment() {
        this.h = new TransferApplyInfo(0, null, null, null, null, 0, null, false, false, false, 0, false, false, 8191, null);
        this.j = 3;
        this.p = "";
    }

    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r0 = this.o;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r2.softInputMode = 16;
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        return;
    L9:
        return;
    }

    public static final void aa0(TransferApplyFragment r17) {
        if (r17.h.getType() != 0) goto L16;
        Context r1 = r17.getContext();
        if (r1 == null) goto L54;
        String r12 = r17.h.getOwnerName();
        boolean r13 = r17.k;
        int r14 = t.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r12, "ownerName");
        String r9 = r1.getString(2131887313);
        if (r13 == false) goto L10;
        String r7 = xo5.a.c(r1, 2131889684, "userName", r12);
    L11:
        Pair r8 = new Pair(r9, r7);
        Intrinsics.checkNotNullParameter(r1, "context");
        UDDialogBuilder r10 = new UDDialogBuilder(r1);
        r10.autoDismiss(true);
        CharSequence r11 = (CharSequence) r8.getFirst();
        Intrinsics.checkNotNullParameter(r11, "value");
        r10.title(r11);
        r10.titleBold(true);
        r10.titleGravity(17);
        CharSequence r2 = (CharSequence) r8.getSecond();
        Intrinsics.checkNotNullParameter(r2, "value");
        r10.message(r2);
        r10.messageGravity(8388611);
        r10.addActionButton(2131391777, 2131888249, new s(r1, r17));
        r10.addActionButton(2131391778, 2131887170, null);
        UDDialog r0 = r10.build();
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L15:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        return;
    L10:
        r7 = xo5.a.c(r1, 2131887311, "username", r12);
        goto L11
    L54:
        return;
    L16:
        Context r3 = r17.getContext();
        if (r3 == null) goto L55;
        int r15 = r17.h.getType();
        String r16 = r17.h.getOwnerName();
        boolean r18 = r17.k;
        boolean r19 = r17.h.isWiki();
        int r110 = t.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r16, "ownerName");
        if (r15 == 28) goto L27;
        if (r19 == true) goto L27;
        String r20 = r3.getString(2131887313);
        if (r18 == false) goto L25;
        String r21 = xo5.a.c(r3, 2131889683, "userName", r16);
    L26:
        Intrinsics.checkNotNull(r21);
        Pair r22 = new Pair(r20, r21);
    L39:
        Intrinsics.checkNotNullParameter(r3, "context");
        UDDialogBuilder r23 = new UDDialogBuilder(r3);
        r23.autoDismiss(true);
        CharSequence r4 = (CharSequence) r22.getFirst();
        Intrinsics.checkNotNullParameter(r4, "value");
        r23.title(r4);
        CharSequence r5 = (CharSequence) r22.getSecond();
        Intrinsics.checkNotNullParameter(r5, "value");
        r23.message(r5);
        r23.addActionButton(2131391778, 2131887716, o.a);
        r23.addActionButton(2131391777, 2131888249, new p(r3, r17));
        r23.cancelOnTouchOutside(false);
        UDDialog r6 = r23.build();
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L47;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L47:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L43:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    L25:
        r21 = xo5.a.c(r3, 2131887312, "username", r16);
    L27:
        HashMap r24 = new HashMap();
        r24.put("who", r16);
        r24.put("bot", r3.getString(b.a(r15)));
        Intrinsics.checkNotNullParameter(r3, "context");
        if (g.b(r15) == false) goto L30;
        String r25 = r3.getString(2131888912);
    L38:
        r24.put("doc_type", r25);
        r22 = new Pair(xo5.a.c(r3, 2131888207, "who", r16), xo5.a.d(r3, 2131888250, r24));
        goto L39
    L30:
        if (r15 != 0) goto L32;
        r25 = r3.getString(2131888004);
        goto L38
    L32:
        if (r15 == 12) goto L36;
        if (r15 == 28) goto L35;
        r25 = r3.getString(2131888003);
        goto L38
    L35:
        r25 = r3.getString(2131887343);
        goto L38
    L36:
        r25 = r3.getString(2131887779);
        goto L38
    }

    public final void onCreate(Bundle r20) {
        super.onCreate(r20);
        Bundle r1 = getArguments();
        Disposable r2 = null;
        if (r1 == null) goto L11;
        Object r3 = r1.getSerializable("extra_info");
        if ((r3 instanceof TransferApplyInfo) == false) goto L7;
        TransferApplyInfo r4 = (TransferApplyInfo) r3;
    L8:
        if (r4 != null) goto L10;
        r4 = new TransferApplyInfo(0, null, null, null, null, 0, null, false, false, false, 0, false, false, 8191, null);
    L10:
        this.h = r4;
        goto L11
    L7:
        r4 = null;
    L11:
        this.o = new CompositeDisposable();
        this.n = new OwnerTransferApplyExecutor((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        if (this.h.getType() == 28) goto L33;
        int r5 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r6 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.permission.transfer_check");
        tt5.a.h("PermFGUtils", "enableTransferCheck()...enable = " + r6);
        if (r6 == false) goto L30;
        AccountService.Account r7 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (TextUtils.isEmpty(r7.uid) == true) goto L19;
        String r8 = r7.uid;
    L20:
        OwnerTransferApplyExecutor r9 = this.n;
        if (r9 == null) goto L25;
        String r10 = this.h.getToken();
        int r11 = this.h.getType();
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "ownerId");
        JsonObject r12 = new JsonObject();
        JsonArray r13 = new JsonArray();
        JsonObject r14 = new JsonObject();
        r14.addProperty("obj_type", Integer.valueOf(r11));
        r14.addProperty(ResourceData.KEY_OBJ_TOKEN, r10);
        r13.add(r14);
        r12.addProperty("owner_id", r8);
        r12.add("entities", r13);
        NetService.f r15 = new NetService.f("/api/explorer/v2/transfer_check/");
        ((NetService.e) r15).c = 1;
        ((NetService.e) r15).j = r12.toString();
        Flowable r16 = r9.a.Vc(new OwnerTransferApplyExecutor.b(r9, r10)).a(r15).map(e.a);
        if (r16 == null) goto L25;
        r2 = r16.subscribe(new ti5.g(this), h.a);
    L25:
        if (r2 == null) goto L31;
        CompositeDisposable r17 = this.o;
        if (r17 == null) goto L32;
        r17.add(r2);
        return;
    L32:
        return;
    L31:
        return;
    L19:
        r8 = this.h.getOwnerId();
        goto L20
    L30:
        return;
    }

    public static final void Z90(TransferApplyFragment r4, Throwable r5) {
        r4.getClass();
        Toast.cancelLoading();
        Context r0 = r4.getContext();
        if (r0 == null) goto L26;
        String r6 = r4.h.getOwnerName();
        int r1 = t.a;
        Intrinsics.checkNotNullParameter(r6, "ownerName");
        Intrinsics.checkNotNullParameter(r5, "throwable");
        Intrinsics.checkNotNullParameter(r0, "context");
        if (d.b(r5, 10015) == false) goto L8;
    L20:
        Toast.showFailureText(r0, UIHelper.mustacheFormat(2131888959, "user", r6));
        return;
    L8:
        if (d.b(r5, 10022) == true) goto L20;
        if (d.b(r5, 2002) == false) goto L14;
        t.b(r0);
        return;
    L14:
        if (d.b(r5, DocPermissionAction.ERROR_DLP_INNER_SHARE_DETECTED_CODE) == false) goto L17;
        t.c(r0, r0.getResources().getString(2131888964));
        return;
    L17:
        if (d.b(r5, 2006) == false) goto L19;
        t.c(r0, r0.getResources().getQuantityString(2131755030, 1, new Object[]{15}));
        return;
    L19:
        Toast.showFailureText(r0, 2131889695);
        return;
    }

    public final void onViewCreated(View r27, Bundle r28) {
        Intrinsics.checkNotNullParameter(r27, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r27, r28);
        BaseTitleBar r2 = (BaseTitleBar) r27.findViewById(2131388775);
        TextView r3 = (TextView) r27.findViewById(2131385836);
        UDAvatar r4 = r27.findViewById(2131385835);
        TextView r5 = (TextView) r27.findViewById(2131389325);
        LinearLayout r6 = (LinearLayout) r27.findViewById(2131389323);
        RecyclerView r7 = r27.findViewById(2131384071);
        View r8 = r27.findViewById(2131369197);
        LinearLayout r9 = (LinearLayout) r27.findViewById(2131389324);
        UDCheckBox r10 = r27.findViewById(2131373071);
        if (r2 == null) goto L5;
        r2.setLeftClickListener(new j(this));
    L5:
        String r11 = UIHelper.mustacheFormat(2131889327, "username", this.h.getOwnerName());
        if (r2 == null) goto L8;
        r2.setTitle(r11);
    L8:
        r7.setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        TransferApplyAdapter r12 = new TransferApplyAdapter();
        this.i = r12;
        Context r13 = getContext();
        int r14 = t.a;
        ArrayList r15 = new ArrayList();
        if (r13 == null) goto L14;
        String r16 = r13.getString(2131889317);
        if (r16 == null) goto L14;
        String r17 = r16;
    L15:
        r15.add(new ti5.d(true, true, r17, true, 5));
        if (r13 == null) goto L21;
        String r18 = r13.getString(2131889320);
        if (r18 == null) goto L21;
        String r23 = r18;
    L22:
        r15.add(new ti5.d(false, false, r23, false, 111));
        r12.setNewData(r15);
        TransferApplyAdapter r19 = this.i;
        if (r19 == null) goto L25;
        k r110 = new k(this);
        Intrinsics.checkNotNullParameter(r110, "clickListener");
        r19.a = r110;
    L25:
        r7.setAdapter(this.i);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.h.getToken(), this.h.getType(), getDialog());
        boolean r20 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        if (TextUtils.isEmpty(this.h.getOwnerId()) == true) goto L37;
        if (r20 == false) goto L37;
        Context r21 = getContext();
        if (r21 == null) goto L37;
        UDButton r1 = r27.findViewById(2131369397);
        if (r1 == null) goto L35;
        r1.setBackgroundColor(UDColorUtils.getColor(r21, 2131108881));
    L35:
        if (r1 == null) goto L37;
        r1.setOnClickListener(new i(r21, this));
    L37:
        int r22 = 8;
        if (this.h.getShowDocTile() == true) goto L40;
        if (r5 == null) goto L57;
        r5.setVisibility(8);
    L57:
        if (r6 == null) goto L60;
        r6.setVisibility(8);
    L60:
        if (r8 == null) goto L68;
        if (this.h.getShowDocTile() == true) goto L64;
    L66:
        r8.setVisibility(r22);
        goto L68
    L64:
        if (this.h.getType() != 0) goto L66;
        r22 = 0;
    L68:
        if (this.h.getType() != 0) goto L85;
        if (r5 == null) goto L77;
        Context r24 = getContext();
        if (r24 == null) goto L75;
        String r25 = r24.getString(2131889325);
        if (r25 == null) goto L75;
    L76:
        r5.setText(r25);
    L75:
        r25 = "";
    L77:
        if (r5 == null) goto L79;
        r5.setVisibility(0);
    L79:
        if (r9 == null) goto L81;
        r9.setVisibility(0);
    L81:
        r9.setOnClickListener(new l(r10, this));
        if (r10 == null) goto L86;
        r10.setOnCheckedChangeListener(new m(this));
        return;
    L86:
        return;
    L85:
        return;
    L40:
        if (TextUtils.isEmpty(this.h.getTitle()) == true) goto L43;
        if (r3 == null) goto L46;
        r3.setText(this.h.getTitle());
    L46:
        if (TextUtils.isEmpty(this.h.getIconUrl()) == true) goto L48;
    L51:
        obb.a r26 = new obb.a(Boolean.FALSE, Boolean.valueOf(this.h.isShareFolder()), null);
        r26.b(IconScene.DOCUMENT);
        if (g.b(this.h.getType()) == false) goto L54;
        Intrinsics.checkNotNull(r4);
        c.c(r4, this.h.getToken(), this.h.getType(), IconShape.SQUARE, r26);
        goto L60
    L54:
        Intrinsics.checkNotNull(r4);
        c.e(r4, this.h.getIconUrl(), IconShape.SQUARE, r26);
        goto L60
    L48:
        if (this.h.getIcon() == (-1)) goto L51;
        if (r4 == null) goto L60;
        r4.setImageResource(this.h.getIcon());
        goto L60
    L43:
        if (r3 == null) goto L46;
        r3.setText(((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(getActivity(), this.h.getType()));
    L21:
        r23 = "";
    L14:
        r17 = "";
        goto L15
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565099, r3, false);
    }
}
