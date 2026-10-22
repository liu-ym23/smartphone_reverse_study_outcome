package com.bytedance.ee.bear.document.sharewords;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\u0010\u00101\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00102\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/OfficeShareWordsDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment;", "Lcom/bytedance/ee/bear/share/export/ISharePanel;", "<init>", "()V", "panelSession", "", "getPanelSession", "()Ljava/lang/String;", "externalShareView", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareView;", "externalShareMinaConfig", "Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig;", "getExternalShareMinaConfig", "()Lcom/bytedance/ee/bear/bizwidget/shareview/ExternalShareMinaConfig;", "externalShareMinaConfig$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onDestroyView", "getCornerRadius", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$CornerRadius;", "calculateHeightPx", "", "createShareView", "getShareItems", "", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareItemModel;", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "buildFallbackShareItems", "isSupportExternalApp", "", "canShowThirdShareChannel", "createShareItemClickListener", "Lcom/bytedance/ee/bear/bizwidget/shareview/SimpleShareItemClickListener;", "buildShareData", "Lcom/bytedance/ee/bear/share/ShareData;", "context", "Landroid/content/Context;", "shareUrlToExternalApp", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "getShareUrl", "copyShareUrl", "shareUrlWithSystemPanel", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeShareWordsDialogFragment extends BaseUDBottomSheetDialogFragment implements i {
    public static final int w = 0;
    public final String t;
    public ExternalShareView u;
    public final Lazy v;

    public static final class a {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment
    public final void onDestroyView() {
        this.u = null;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.NOT_SHOW, ra0());
        super.onDestroyView();
    }

    static {
        w = LarkContext.getApplication().getResources().getDimensionPixelSize(2131169387);
    }

    public OfficeShareWordsDialogFragment() {
        super("OfficeShareWordsDialog");
        this.t = String.valueOf(hashCode());
        this.v = LazyKt.lazy(OfficeShareWordsDialogFragment$externalShareMinaConfig$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment
    public final int ea0() {
        ExternalShareView r0 = this.u;
        if (r0 != null) goto L5;
        return -2;
    L5:
        View r2 = getView();
        Integer r3 = null;
        boolean r4 = true;
        if (r2 == null) goto L16;
        Integer r5 = Integer.valueOf(r2.getWidth());
        if (r5.intValue() <= 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        int r7 = r5.intValue();
    L17:
        r0.measure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Integer r1 = Integer.valueOf(r0.getMeasuredHeight());
        if (r1.intValue() > 0) goto L21;
        r4 = false;
    L21:
        if (r4 == false) goto L23;
        r3 = r1;
    L23:
        if (r3 != null) goto L25;
        return -2;
    L25:
        return r3.intValue();
    L10:
        r6 = false;
    L16:
        Resources r8 = getResources();
        r7 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).widthPixels;
        goto L17
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment
    public final BaseUDBottomSheetDialogFragment.a ga0() {
        int r0 = BaseUDBottomSheetDialogFragment.a.d;
        return BaseUDBottomSheetDialogFragment.a.C0032a.a(w);
    }

    public final km5.a ra0() {
        Bundle r0 = getArguments();
        int r2 = 0;
        if (r0 == null) goto L5;
        r2 = r0.getInt("arg_doc_type", 0);
    L5:
        Bundle r1 = getArguments();
        if (r1 == null) goto L8;
        String r3 = r1.getString("arg_doc_token");
    L10:
        return new km5.a(0, r2, r3, false, false, null, null, null, false, false, false, false, null, null, false, false, ShareScene.SHARE_TEXT, 49152);
    L8:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Context r0 = getContext();
        if (r0 == null) goto L5;
        int r1 = UIUtils.getColor(r0, 2131100557);
    L6:
        pa0(r1);
        return;
    L5:
        r1 = -1;
        goto L6
    }

    public final String ta0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("arg_share_url");
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getPanelSession() {
        return this.t;
    }

    public final void sa0(Context r5) {
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(ta0(), false, new Token("LARK-PSDA-ccm_android_share_words_copy_link")) == false) goto L5;
        int r0 = 2131887614;
    L6:
        Toast.showText(r5, r0);
        return;
    L5:
        r0 = 2131887613;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        qa0();
        FrameLayout r16 = fa0();
        if (r16 != null) goto L5;
        tt5.a.d("OfficeShareWordsDialog", "createShareView, contentContainer not found.");
    L99:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).H9(this, SharePanelState.SHOWING, ra0());
        return;
    L5:
        ExternalShareView r2 = new ExternalShareView(r16.getContext());
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L62
        List r7 = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().a(ra0());     // Catch: Throwable -> L62
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L62
    L8:
        if (r8.hasNext() == false) goto L15;
        Object r9 = r8.next();     // Catch: Throwable -> L62
        if (((ShareItemModel) r9).getType() != ShareType.CopyLink) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L8;
    L17:
        if (((ShareItemModel) r9) != null) goto L60;
        ShareItemUtil r11 = ShareItemUtil.a;     // Catch: Throwable -> L62
        ShareType r12 = ShareType.CopyLink;     // Catch: Throwable -> L62
        ShareState r17 = ShareState.SHOW;     // Catch: Throwable -> L62
        r11.getClass();     // Catch: Throwable -> L62
        ShareItemModel r18 = ShareItemUtil.a(r12, r17);     // Catch: Throwable -> L62
        r18.setShareIconStyle(ShareItemModel.ShareIconStyle.FILL);     // Catch: Throwable -> L62
        r18.setSrcTint(ShareItemModel.SRC_TINT_UNDEFINED);     // Catch: Throwable -> L62
        r18.setShareItemBackground(0);     // Catch: Throwable -> L62
        Iterator r19 = r7.iterator();     // Catch: Throwable -> L62
        int r20 = 0;
    L20:
        if (r19.hasNext() == false) goto L28;
        if (((ShareItemModel) r19.next()).getType() != ShareType.CopyText) goto L24;
        boolean r110 = true;
    L25:
        if (r110 == true) goto L29;
        r20 = r20 + 1;     // Catch: Throwable -> L62
    L29:
        Integer r21 = Integer.valueOf(r20);     // Catch: Throwable -> L62
        if (r21.intValue() < 0) goto L32;
        boolean r22 = true;
    L33:
        if (r22 == true) goto L36;
        r21 = null;
    L36:
        if (r21 == null) goto L38;
        ListProtector.set(r7, r21.intValue(), r18);     // Catch: Throwable -> L62
    L59:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L62
        goto L60
    L38:
        Iterator r24 = r7.iterator();     // Catch: Throwable -> L62
        int r26 = 0;
    L40:
        if (r24.hasNext() == false) goto L48;
        if (((ShareItemModel) r24.next()).getType() != ShareType.Lark) goto L44;
        boolean r111 = true;
    L45:
        if (r111 == true) goto L49;
        r26 = r26 + 1;     // Catch: Throwable -> L62
    L49:
        Integer r27 = Integer.valueOf(r26);     // Catch: Throwable -> L62
        if (r27.intValue() < 0) goto L52;
        boolean r28 = true;
    L53:
        if (r28 == true) goto L56;
        r27 = null;
    L56:
        if (r27 == null) goto L58;
        ListProtector.add(r7, r27.intValue() + 1, r18);     // Catch: Throwable -> L62
        goto L59
    L58:
        ListProtector.add(r7, 0, r18);     // Catch: Throwable -> L62
        goto L59
    L52:
        r28 = false;
        goto L53
    L44:
        r111 = false;
        goto L45
    L48:
        r26 = -1;
        goto L49
    L32:
        r22 = false;
        goto L33
    L24:
        r110 = false;
        goto L25
    L28:
        r20 = -1;
    L60:
        Object r29 = Result.constructor-impl(r7);     // Catch: Throwable -> L62
    L64:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L68;
        tt5.a.e("OfficeShareWordsDialog", "getShareItems failed", r30, false);
    L68:
        if (Result.isFailure-impl(r29) == false) goto L70;
        r29 = null;
    L70:
        List r31 = (List) r29;
        if (r31 != null) goto L73;
        r31 = CollectionsKt.emptyList();
    L73:
        List r32 = r31;
        if (r32.isEmpty() == false) goto L98;
        ShareItemUtil r33 = ShareItemUtil.a;
        ShareType r34 = ShareType.CopyLink;
        ShareState r36 = ShareState.SHOW;
        r33.getClass();
        r32 = CollectionsKt.mutableListOf(new ShareItemModel[]{ShareItemUtil.a(r34, r36)});
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();     // Catch: Throwable -> L80
        Object r1 = Result.constructor-impl(Boolean.valueOf(jg5.e.a.a.h()));     // Catch: Throwable -> L80
    L82:
        Boolean r5 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L86;
        r1 = r5;
    L86:
        if (((Boolean) r1).booleanValue() == false) goto L98;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).Y9().getClass();     // Catch: Throwable -> L89
        Object r3 = Result.constructor-impl(Boolean.valueOf(!km5.c.d()));     // Catch: Throwable -> L89
    L91:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r3) == false) goto L95;
        r3 = r4;
    L95:
        if (((Boolean) r3).booleanValue() == false) goto L97;
        ShareItemUtil r37 = ShareItemUtil.a;
        ShareType r38 = ShareType.Wechat;
        ShareState r39 = ShareState.SHOW;
        r37.getClass();
        r32.add(ShareItemUtil.a(r38, r39));
        r32.add(ShareItemUtil.a(ShareType.WechatMoments, r39));
        r32.add(ShareItemUtil.a(ShareType.QQ, r39));
        r32.add(ShareItemUtil.a(ShareType.Weibo, r39));
    L97:
        ShareItemUtil r40 = ShareItemUtil.a;
        ShareType r41 = ShareType.More;
        ShareState r42 = ShareState.SHOW;
        r40.getClass();
        r32.add(ShareItemUtil.a(r41, r42));
    L89:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L80:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L98:
        r2.b(r32);
        r2.setOnShareItemClickListener(new c(this));
        this.u = r2;
        r16.addView(r2, new ViewGroup.LayoutParams(-1, -2));
        goto L99
    L12:
        r10 = false;
        goto L13
    L15:
        r9 = null;
    L62:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    }
}
