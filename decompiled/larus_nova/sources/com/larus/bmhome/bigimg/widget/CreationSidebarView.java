package com.larus.bmhome.bigimg.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.m1;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.Message;
import com.larus.image.databinding.LarusLayoutCreationSideBarBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJv\u0010)\u001a\u00020&2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJF\u0010*\u001a\u00020&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010,\u001a\u00020\u00172\n\b\u0002\u0010-\u001a\u0004\u0018\u00010#J\u0018\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\u0017J\u000e\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u0017J\b\u00104\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082D¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/bigimg/widget/CreationSidebarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/image/databinding/LarusLayoutCreationSideBarBinding;", "aiImageParams", "Lcom/larus/bmhome/chat/bean/AIEditParams;", "aiVideoParams", "aiImageExpandParams", "aiImageErasePrams", "aiImageSharepnessParams", "currentValidUri", "Landroid/net/Uri;", "imageData", "Lcom/larus/bmhome/bigimg/ImageData;", "currentIsVideo", "", "Ljava/lang/Boolean;", "videoData", "Lcom/larus/platform/model/video/VideoPlayData;", "aiVideoExtendParams", "needShowEditView", "isShowShare", "functionVisibleConfig", "Lcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;", "currentMessage", "Lcom/larus/im/bean/message/Message;", "currentDriveInfo", "Lcom/larus/bmhome/chat/bean/DriveImageExtraInfo;", "onShareClickListener", "Lkotlin/Function0;", "", "logTag", "", "initData", "bindData", "message", "showEditView", "driveInfo", "updateImageEditPanelAlpha", "alpha", "", "ignoreShareIcon", "updateSharpnessState", "enabled", "bindEditPanel", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationSidebarView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutCreationSideBarBinding f296086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ic8.d f296087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ic8.d f296088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ic8.d f296089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ic8.d f296090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ic8.d f296091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Uri f296092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m1 f296093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f296094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public nr9.g f296095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ic8.d f296096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f296097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f296098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LeftCreationEditView.b f296099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Message f296100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ic8.r f296101p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<Unit> f296102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f296103r;

    public CreationSidebarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationSidebarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void T5(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 1.0f;
    L5:
        LeftCreationEditView r102 = this.f296086a.f350938b;
        LeftCreationEditItemView r103 = r102.f296111f;
        View r104 = null;
        if (r103 == null) goto L8;
        ViewParent r105 = r103.getParent();
    L10:
        if ((r105 instanceof View) == false) goto L12;
        r104 = (View) r105;
    L12:
        if (r104 == null) goto L14;
        r104.setAlpha(r101);
    L14:
        LeftCreationEditItemView r106 = r102.f296111f;
        if (r106 == null) goto L18;
        r106.setClickable(r100);
        return;
    L18:
        return;
    L8:
        r105 = null;
        goto L10
    L4:
        r101 = 0.5f;
        goto L5
    }

    public CreationSidebarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_creation_side_bar, this);
        LeftCreationEditView r103 = (LeftCreationEditView) ViewBindings.findChildViewById(this, R.id.left_edit_view);
        if (r103 == null) goto L7;
        this.f296086a = new LarusLayoutCreationSideBarBinding(this, r103);
        this.f296098m = true;
        this.f296103r = "CreationSidebarView";
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.left_edit_view)));
    }

    public /* synthetic */ CreationSidebarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void R5(CreationSidebarView r110, Uri r111, m1 r112, nr9.g r113, Message r210, boolean r211, ic8.r r212, int r213) {
        Boolean r100 = null;
        if ((r213 & 8) == 0) goto L5;
        Message r101 = null;
    L6:
        boolean r102 = true;
        if ((r213 & 16) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r213 & 32) == 0) goto L13;
        ic8.r r104 = null;
    L14:
        r110.f296092g = r111;
        r110.f296093h = r112;
        r110.f296095j = r113;
        r110.f296100o = r101;
        r110.f296101p = r104;
        if (r113 == null) goto L17;
        boolean r105 = true;
    L18:
        boolean r106 = !Intrinsics.areEqual(r110.f296097l, Boolean.valueOf(r103));
        boolean r107 = !Intrinsics.areEqual(r110.f296094i, Boolean.valueOf(r105));
        r110.f296097l = Boolean.valueOf(r103);
        r110.f296094i = Boolean.valueOf(r105);
        FLogger r108 = FLogger.f375446a;
        r108.i(r110.f296103r, "bindData: showEditView " + r103 + " isVideo " + r105);
        if (r106 == true) goto L21;
        if (r107 == true) goto L21;
        return;
    L21:
        String r109 = r110.f296103r;
        StringBuilder r114 = new StringBuilder("bindEditPanel ");
        ic8.d r115 = r110.f296087b;
        if (r115 == null) goto L24;
        Boolean r116 = Boolean.valueOf(r115.f489181a);
    L25:
        r114.append(r116);
        r114.append(' ');
        ic8.d r117 = r110.f296088c;
        if (r117 == null) goto L28;
        r100 = Boolean.valueOf(r117.f489181a);
    L28:
        r114.append(r100);
        r114.append(',');
        r108.i(r109, r114.toString());
        if (Intrinsics.areEqual(r110.f296094i, Boolean.TRUE) == false) goto L36;
        ic8.d r118 = r110.f296096k;
        if (r118 == null) goto L33;
        boolean r119 = r118.f489181a;
    L34:
        if (r119 == false) goto L36;
        boolean r120 = true;
    L37:
        boolean r121 = Intrinsics.areEqual(PollingConfigService.f326423a.f("cre_pic_sc_dg"), "1");
        LeftCreationEditView r122 = r110.f296086a.f350938b;
        i r123 = new i(r110);
        Boolean r124 = r110.f296094i;
        Boolean r125 = Boolean.FALSE;
        if (Intrinsics.areEqual(r124, r125) == false) goto L48;
        ic8.d r126 = r110.f296088c;
        if (r126 == null) goto L42;
        boolean r127 = r126.f489181a;
    L43:
        if (r127 == false) goto L48;
        if (Intrinsics.areEqual(r110.f296097l, r125) == true) goto L48;
        if (r121 == true) goto L48;
        boolean r128 = true;
    L50:
        if (Intrinsics.areEqual(r110.f296094i, r125) == false) goto L60;
        ic8.d r129 = r110.f296087b;
        if (r129 == null) goto L54;
        boolean r130 = r129.f489181a;
    L55:
        if (r130 == false) goto L60;
        if (Intrinsics.areEqual(r110.f296097l, r125) == true) goto L60;
        if (r121 == true) goto L60;
        boolean r131 = true;
    L62:
        if (r110.f296098m == false) goto L64;
        z2.f365865a.w3();
        boolean r132 = true;
    L65:
        LeftCreationEditView.d(r122, r123, null, r131, false, r128, r120, r132, r110.f296099n, 10);
        if (Intrinsics.areEqual(r110.f296097l, r125) == true) goto L134;
        ic8.d r133 = r110.f296087b;
        if (r133 != null) goto L71;
    L73:
        boolean r134 = false;
    L74:
        if (r134 == false) goto L79;
        if (r133 == null) goto L79;
        Function1<ic8.f, Unit> r135 = r133.f489183c;
        if (r135 == null) goto L79;
        r135.invoke(new ic8.f(null, r110.f296100o, null, null, null, 61));
    L79:
        ic8.d r136 = r110.f296089d;
        if (r136 != null) goto L82;
    L84:
        boolean r137 = false;
    L85:
        if (r137 == false) goto L90;
        if (r136 == null) goto L90;
        Function1<ic8.f, Unit> r138 = r136.f489183c;
        if (r138 == null) goto L90;
        r138.invoke(new ic8.f(null, r110.f296100o, null, null, null, 61));
    L90:
        ic8.d r139 = r110.f296090e;
        if (r139 != null) goto L93;
    L95:
        boolean r140 = false;
    L96:
        if (r140 == false) goto L101;
        if (r139 == null) goto L101;
        Function1<ic8.f, Unit> r141 = r139.f489183c;
        if (r141 == null) goto L101;
        r141.invoke(new ic8.f(null, r110.f296100o, null, null, null, 61));
    L101:
        ic8.d r142 = r110.f296091f;
        if (r142 != null) goto L104;
    L106:
        boolean r143 = false;
    L107:
        if (r143 == false) goto L112;
        if (r142 == null) goto L112;
        Function1<ic8.f, Unit> r144 = r142.f489183c;
        if (r144 == null) goto L112;
        r144.invoke(new ic8.f(null, r110.f296100o, null, null, null, 61));
    L112:
        ic8.d r145 = r110.f296088c;
        if (r145 != null) goto L115;
    L117:
        r102 = false;
    L118:
        if (r102 == false) goto L123;
        if (r145 == null) goto L123;
        Function1<ic8.f, Unit> r146 = r145.f489183c;
        if (r146 == null) goto L123;
        r146.invoke(new ic8.f(null, r110.f296100o, null, null, null, 61));
    L123:
        if (r120 == false) goto L131;
        ic8.d r147 = r110.f296096k;
        if (r147 == null) goto L132;
        Function1<ic8.f, Unit> r148 = r147.f489183c;
        if (r148 == null) goto L133;
        r148.invoke(new ic8.f(null, r110.f296100o, null, null, null, 61));
        return;
    L133:
        return;
    L132:
        return;
    L131:
        return;
    L115:
        if (r145.f489181a != true) goto L117;
    L104:
        if (r142.f489181a != true) goto L106;
        r143 = true;
        goto L107
    L93:
        if (r139.f489181a != true) goto L95;
        r140 = true;
        goto L96
    L82:
        if (r136.f489181a != true) goto L84;
        r137 = true;
        goto L85
    L71:
        if (r133.f489181a != true) goto L73;
        r134 = true;
        goto L74
    L134:
        return;
    L64:
        r132 = false;
        goto L65
    L54:
        r130 = false;
    L60:
        r131 = false;
        goto L62
    L42:
        r127 = false;
    L48:
        r128 = false;
        goto L50
    L33:
        r119 = false;
    L36:
        r120 = false;
        goto L37
    L24:
        r116 = null;
        goto L25
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = r212;
        goto L14
    L9:
        r103 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L6
    }

    public static void S5(CreationSidebarView r100, ic8.d r101, ic8.d r102, ic8.d r103, ic8.d r104, ic8.d r105, ic8.d r106, Function0 r107, LeftCreationEditView.b r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r105 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r106 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r107 = null;
    L24:
        if ((r111 & 128) == 0) goto L26;
        boolean r108 = true;
    L28:
        if ((r111 & 256) == 0) goto L30;
        r110 = null;
    L30:
        r100.f296087b = r101;
        r100.f296088c = r102;
        r100.f296089d = r103;
        r100.f296090e = r104;
        r100.f296091f = r105;
        r100.f296096k = r106;
        r100.f296102q = r107;
        r100.f296098m = r108;
        r100.f296099n = r110;
        return;
    L26:
        r108 = false;
        goto L28
    }
}
