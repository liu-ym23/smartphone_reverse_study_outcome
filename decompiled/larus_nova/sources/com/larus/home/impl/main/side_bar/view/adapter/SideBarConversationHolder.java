package com.larus.home.impl.main.side_bar.view.adapter;

import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.databinding.LarusItemSideBarConversationBinding;
import com.larus.home.impl.main.side_bar.data.y0;
import com.larus.home.impl.main.side_bar.view.d2;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 I2\u00020\u0001:\u0001IB\u0088\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012Q\u0010\f\u001aM\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010)\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u000eH\u0002J\u0012\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u00102\u001a\u00020\u0016H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0002J\u0012\u00105\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u00106\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\u0016H\u0002J\b\u0010:\u001a\u00020\u0016H\u0002J\u0012\u0010;\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010<\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0012\u0010=\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u000108H\u0002J,\u0010>\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010\u00142\b\u0010@\u001a\u0004\u0018\u00010\u00142\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tH\u0002J\u0018\u0010C\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\tH\u0002J\b\u0010E\u001a\u00020\u0016H\u0002J\u0012\u0010F\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010G\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001fH\u0002J\u001a\u0010H\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000RY\u0010\f\u001aM\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b'\u0010$¨\u0006J"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarConversationHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/home/impl/databinding/LarusItemSideBarConversationBinding;", "contentBridge", "Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;", "conversationBridge", "Lcom/larus/home/impl/main/side_bar/view/ISideBarConversationBridge;", "takeOverActions", "", "conversationIconAlpha", "", "onItemClicked", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/larus/home/impl/main/side_bar/data/SideBarItemConfig;", "config", "", "clickType", "", "<init>", "(Lcom/larus/home/impl/databinding/LarusItemSideBarConversationBinding;Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;Lcom/larus/home/impl/main/side_bar/view/ISideBarConversationBridge;ZFLkotlin/jvm/functions/Function3;)V", "messageProgressAnimator", "Landroid/animation/ObjectAnimator;", "progressConversationId", "itemConfig", "itemPosition", "boundConversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "observingScheduledJobs", "scheduledJobObserver", "Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarScheduledJobIndicatorProvider$Observer;", "isEnhancedStyle", "()Z", "isEnhancedStyle$delegate", "Lkotlin/Lazy;", "isMainCvsBold", "isMainCvsBold$delegate", "bind", "recycle", "bindEndAction", "conversationData", "shouldShowPendingConfirmation", "applyRoundBadgeStyleIfNeeded", "unreadCount", "showMessageProgress", "conversationId", "hideMessageProgress", "stopMessageProgress", "onPreBind", com.alipay.sdk.m.x.d.f25925o, "getSideBarDisplayName", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "updateRightActionAreaVisibility", "updateTitleEndGradientVisibility", "setAvatar", "shouldUseTaskRuntimeAvatar", "isMissingRuntimeMainBot", "setAvatarInternal", "url", "bizTag", "needResize", SVGRenderEngine.CIRCLE, "setAvatarByResIdInternal", "resId", "refreshPcAvatar", "setupPinIcon", "setupRealtimeCallTag", "initEvents", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarConversationHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f344921o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemSideBarConversationBinding f344922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.b f344923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.c f344924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f344925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f344926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<Integer, com.larus.home.impl.main.side_bar.data.j0, String, Unit> f344927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObjectAnimator f344928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f344929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f344930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public wh8.a f344931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f344932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b0 f344933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f344934m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f344935n;

    public static final class a {
    }

    static {
        f344921o = AppHost.f326268a.getApplication().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_28, null, R.dimen.larus_side_bar_icon_size));
    }

    public final void V3() {
        ObjectAnimator r100 = this.f344928g;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f344929h = null;
        this.f344922a.f344302l.setRotation(0.0f);
        e1.o(this.f344922a.f344302l);
    }

    public final void W3() {
        com.larus.home.impl.main.side_bar.view.b r100 = this.f344923b;
        if (r100 == null) goto L5;
        r100.IO(this);
    L5:
        ObjectAnimator r101 = this.f344928g;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f344929h = null;
        this.f344922a.f344302l.setRotation(0.0f);
        e1.o(this.f344922a.f344302l);
        this.f344922a.f344294d.setOnClickListener(null);
        this.itemView.setOnClickListener(null);
        this.itemView.setOnLongClickListener(null);
        this.f344930i = -1;
        this.f344931j = null;
        if (this.f344932k == false) goto L12;
        this.f344932k = false;
        t0 r102 = t0.f345021a;
        final b0 r103 = this.f344933l;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        t0.b(new o0(r103));
        return;
    }

    public final void a4() {
        int r100 = 0;
        if (this.f344922a.f344297g.getVisibility() != 0) goto L5;
    L10:
        boolean r101 = true;
    L11:
        LinearLayout r102 = this.f344922a.f344303m;
        if (r101 == true) goto L15;
        r100 = 8;
    L15:
        r102.setVisibility(r100);
        TextView r103 = this.f344922a.f344308r;
        OneShotPreDrawListener.add(r103, new e0(r103, this));
        return;
    L5:
        if (this.f344922a.f344296f.getVisibility() == 0) goto L10;
        if (this.f344922a.f344300j.getVisibility() == 0) goto L10;
        r101 = false;
        goto L11
    }

    public static boolean Z3(wc9.e r100) {
        if (ic8.n.u(r100) == true) goto L7;
        return true;
    L7:
        return FlowRuntime.a().n();
    }

    public final void U3(wh8.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        boolean r101 = true;
        int r102 = y0.a(r100, true);
        if (z2.f365865a.getChatNavigatorConfig().f486630g != 1) goto L6;
        this.f344922a.f344306p.setForceCircleBadgeDiameter(Integer.valueOf(i5.v()));
        this.f344922a.f344306p.setTextSize(0, i5.g());
        FLogger.f375446a.i("SideBarConversationHolder", "[badgeStyle=1] apply round badge style, unreadCount=" + r102);
    L6:
        this.f344922a.f344306p.z(r102);
        Message r103 = r100.f559710c;
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L21;
        wc9.e r105 = r100.f559708a;
        if (r105 == null) goto L22;
        String r106 = r105.f559198a;
        if (r106 == null) goto L22;
        d2 r107 = d2.f345076a;
        if (d2.a(r106) != null) goto L21;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == false) goto L25;
        e1.x(this.f344922a.f344300j);
        e1.x(this.f344922a.f344301k);
        V3();
        e1.o(this.f344922a.f344298h);
        e1.o(this.f344922a.f344295e);
        e1.o(this.f344922a.f344306p);
        e1.o(this.f344922a.f344294d);
    L85:
        a4();
        return;
    L25:
        Message r109 = r100.f559710c;
        if (r109 != null) goto L28;
    L30:
        boolean r110 = false;
    L31:
        String r111 = null;
        if (r110 == true) goto L69;
        Message r112 = r100.f559710c;
        if (r112 != null) goto L36;
    L38:
        boolean r113 = false;
    L39:
        if (r113 == true) goto L69;
        Message r114 = r100.f559710c;
        if (r114 != null) goto L44;
    L46:
        boolean r115 = false;
    L47:
        if (r115 == true) goto L68;
        Message r116 = r100.f559710c;
        if (r116 != null) goto L51;
    L53:
        r101 = false;
    L54:
        if (r101 == true) goto L68;
        if (r102 <= 0) goto L58;
        e1.x(this.f344922a.f344300j);
        e1.o(this.f344922a.f344301k);
        V3();
        e1.o(this.f344922a.f344298h);
        e1.o(this.f344922a.f344295e);
        e1.x(this.f344922a.f344306p);
        e1.o(this.f344922a.f344294d);
        goto L85
    L58:
        t0 r117 = t0.f345021a;
        wc9.e r118 = r100.f559708a;
        if (r118 == null) goto L61;
        r111 = r118.f559198a;
    L61:
        r117.getClass();
        if (t0.c(r111) == false) goto L65;
        e1.x(this.f344922a.f344300j);
        e1.o(this.f344922a.f344301k);
        V3();
        e1.o(this.f344922a.f344298h);
        e1.o(this.f344922a.f344306p);
        e1.x(this.f344922a.f344295e);
        e1.o(this.f344922a.f344294d);
        goto L85
    L65:
        if (ic8.n.r(r100.f559708a) == false) goto L67;
        e1.x(this.f344922a.f344300j);
        e1.o(this.f344922a.f344301k);
        V3();
        e1.o(this.f344922a.f344298h);
        e1.o(this.f344922a.f344295e);
        e1.o(this.f344922a.f344306p);
        e1.x(this.f344922a.f344294d);
        goto L85
    L67:
        e1.o(this.f344922a.f344301k);
        V3();
        e1.o(this.f344922a.f344298h);
        e1.o(this.f344922a.f344295e);
        e1.o(this.f344922a.f344306p);
        e1.o(this.f344922a.f344294d);
        e1.o(this.f344922a.f344300j);
        goto L85
    L51:
        if (r116.getMessageStatusLocal() != 12) goto L53;
    L68:
        e1.x(this.f344922a.f344300j);
        e1.o(this.f344922a.f344301k);
        V3();
        e1.x(this.f344922a.f344298h);
        e1.o(this.f344922a.f344295e);
        e1.o(this.f344922a.f344306p);
        e1.o(this.f344922a.f344294d);
        goto L85
    L44:
        if (r114.getMessageStatusLocal() != 22) goto L46;
        r115 = true;
        goto L47
    L36:
        if (r112.getMessageStatusLocal() != 24) goto L38;
        r113 = true;
    L69:
        e1.x(this.f344922a.f344300j);
        e1.o(this.f344922a.f344301k);
        wc9.e r119 = r100.f559708a;
        if (r119 == null) goto L72;
        r111 = r119.f559198a;
    L72:
        e1.x(this.f344922a.f344302l);
        if (this.f344928g != null) goto L75;
        ObjectAnimator r120 = ObjectAnimator.ofFloat(this.f344922a.f344302l, View.ROTATION, new float[]{0.0f, 360.0f});
        r120.setDuration(1000);
        r120.setInterpolator(new LinearInterpolator());
        r120.setRepeatCount(-1);
        r120.setRepeatMode(1);
        this.f344928g = r120;
    L75:
        ObjectAnimator r121 = this.f344928g;
        if (r121 != null) goto L79;
    L84:
        e1.o(this.f344922a.f344298h);
        e1.o(this.f344922a.f344295e);
        e1.o(this.f344922a.f344306p);
        e1.o(this.f344922a.f344294d);
        goto L85
    L79:
        if (r121.isRunning() == true) goto L81;
    L82:
        r121.cancel();
        r121.start();
        r121.setCurrentPlayTime(AnimationUtils.currentAnimationTimeMillis() % 1000);
    L83:
        this.f344929h = r111;
        goto L84
    L81:
        if (Intrinsics.areEqual(this.f344929h, r111) == true) goto L83;
    L28:
        if (r109.getMessageStatusLocal() != 20) goto L30;
        r110 = true;
    L21:
        r108 = true;
        goto L23
    L9:
        if (com.larus.bmhome.chat.bean.d.R(r103) != true) goto L11;
        r104 = true;
        goto L12
    }

    public final boolean X3(wh8.a r110) {
        if (r110 == null) goto L5;
        wc9.e r111 = r110.f559708a;
    L6:
        boolean r100 = ic8.n.u(r111);
        boolean r101 = Z3(r111);
        if (r101 == false) goto L11;
        com.larus.home.impl.main.side_bar.view.b r102 = this.f344923b;
        if (r102 == null) goto L11;
        Integer r103 = r102.Xg(r111);
    L13:
        if (((Boolean) this.f344934m.getValue()).booleanValue() == false) goto L17;
        if (r100 == true) goto L17;
        if (r103 != null) goto L17;
        e1.o(this.f344922a.f344299i);
    L85:
        if (r103 == null) goto L90;
        return true;
    L90:
        return false;
    L17:
        e1.x(this.f344922a.f344299i);
        if (r111 == null) goto L24;
        IconImage r104 = r111.f559199b;
        if (r104 == null) goto L24;
        ImageObj r105 = r104.imageThumb;
        if (r105 == null) goto L24;
        String r106 = r105.url;
    L26:
        if (com.larus.utils.o0.d(r106) == false) goto L33;
        if (r111 == null) goto L39;
        IconImage r107 = r111.f559199b;
        if (r107 == null) goto L39;
        ImageObj r108 = r107.imageThumb;
        if (r108 == null) goto L39;
        String r109 = r108.url;
    L40:
        if (r103 == null) goto L43;
        Y3(r103.intValue());
        goto L85
    L43:
        if (r101 == true) goto L45;
    L47:
        if (r101 == false) goto L52;
        if (ic8.n.t(r111) == false) goto L52;
        Y3(R.drawable.larus_ic_side_bar_local_pc_conversation);
    L52:
        if (ic8.n.u(r111) == true) goto L54;
    L75:
        boolean r112 = false;
    L76:
        if (r112 == false) goto L79;
        Y3(R.drawable.larus_ic_side_bar_cloud_pc_conversation);
        goto L85
    L79:
        if (com.larus.utils.o0.d(r109) == false) goto L82;
        e1.x(this.f344922a.f344293c);
        ImageLoaderKt.v(this.f344922a.f344293c, r109, "side_bar_covn_list.avatar", null, new x());
        this.f344922a.f344299i.a(true);
        goto L85
    L82:
        if (ic8.n.w(r111) == false) goto L84;
        Y3(R.drawable.larus_ic_doubao_pc_empty);
        goto L85
    L84:
        String r113 = com.larus.utils.y0.k(new Uri.Builder().scheme("res").path(String.valueOf(R.drawable.larus_common_ui_avatar_placeholder)).build());
        e1.x(this.f344922a.f344293c);
        ImageLoaderKt.v(this.f344922a.f344293c, r113, null, null, new x());
        this.f344922a.f344299i.a(true);
        goto L85
    L54:
        if (Z3(r111) == false) goto L75;
        if (r111 == null) goto L58;
        String r114 = r111.f559215r;
    L59:
        if (r114 != null) goto L61;
    L64:
        boolean r115 = true;
    L65:
        if (r115 == false) goto L88;
        r112 = true;
        goto L76
    L88:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L69
        Object r117 = Result.m9449constructorimpl(Boolean.valueOf(!new JSONObject(r114).has("agent_task_param")));     // Catch: Throwable -> L69
    L71:
        Boolean r118 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r117) == false) goto L74;
        r117 = r118;
    L74:
        r112 = ((Boolean) r117).booleanValue();
    L69:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L71
    L61:
        if (StringsKt.isBlank(r114) == true) goto L64;
        r115 = false;
        goto L65
    L58:
        r114 = null;
        goto L59
    L45:
        if (ic8.n.n(r111) == false) goto L47;
        Y3(R.drawable.larus_ic_side_bar_cloud_pc_conversation);
    L39:
        r109 = null;
        goto L40
    L33:
        if (r111 == null) goto L39;
        IconImage r120 = r111.f559199b;
        if (r120 == null) goto L39;
        ImageObj r121 = r120.imageOri;
        if (r121 == null) goto L39;
        r109 = r121.url;
    L24:
        r106 = null;
    L11:
        r103 = null;
        goto L13
    L5:
        r111 = null;
        goto L6
    }

    public final void Y3(int r100) {
        e1.x(this.f344922a.f344293c);
        ImageLoaderKt.b(this.f344922a.f344293c);
        this.f344922a.f344293c.getHierarchy().setFailureImage(R.drawable.larus_common_ui_avatar_placeholder);
        this.f344922a.f344293c.setActualImageResource(r100);
        this.f344922a.f344299i.a(true);
    }

    public final void T3(final com.larus.home.impl.main.side_bar.data.j0 r110, final int r111) {
        com.larus.home.impl.main.side_bar.view.b r100 = this.f344923b;
        if (r100 == null) goto L5;
        r100.IO(this);
    L5:
        this.f344922a.f344299i.setAlpha(this.f344926e);
        e1.o(this.f344922a.f344297g);
        e1.o(this.f344922a.f344295e);
        e1.o(this.f344922a.f344294d);
        e1.o(this.f344922a.f344306p);
        e1.o(this.f344922a.f344301k);
        e1.o(this.f344922a.f344298h);
        e1.o(this.f344922a.f344307q);
        e1.o(this.f344922a.f344305o);
        e1.o(this.f344922a.f344300j);
        e1.o(this.f344922a.f344303m);
        e1.o(this.f344922a.f344296f);
        e1.q(this.f344922a.f344304n);
        this.f344930i = r111;
        wh8.a r101 = r110.f344507b;
        this.f344931j = r101;
        if (r101 == null) goto L11;
        if (this.f344932k == true) goto L11;
        this.f344932k = true;
        t0 r102 = t0.f345021a;
        final b0 r103 = this.f344933l;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        t0.b(new s0(r103));
    L11:
        if (r101 != null) goto L17;
        ObjectAnimator r104 = this.f344928g;
        if (r104 == null) goto L15;
        r104.cancel();
    L15:
        this.f344929h = null;
        this.f344922a.f344302l.setRotation(0.0f);
        e1.o(this.f344922a.f344302l);
    L17:
        if (((Boolean) this.f344934m.getValue()).booleanValue() == false) goto L27;
        ConstraintLayout r105 = this.f344922a.f344291a;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r101 == null) goto L21;
        wc9.e r107 = r101.f559708a;
    L23:
        if (ic8.n.u(r107) == false) goto L25;
        int r108 = i5.g0();
    L26:
        r106.height = r108;
        r105.setLayoutParams(r106);
        goto L27
    L25:
        r108 = i5.d0();
        goto L26
    L21:
        r107 = null;
    L27:
        if (r101 == null) goto L29;
        wc9.e r109 = r101.f559708a;
    L30:
        boolean r112 = false;
        if (ic8.n.u(r109) == true) goto L33;
    L35:
        boolean r113 = false;
    L36:
        TextView r114 = this.f344922a.f344308r;
        String r115 = "";
        if (ic8.n.u(r109) == true) goto L39;
    L74:
        String r116 = ic8.n.g(r109, "");
    L75:
        r114.setText(r116);
        if (com.larus.platform.service.n0.f365775a.b() == true) goto L78;
    L80:
        boolean r117 = false;
    L81:
        e1.o(this.f344922a.f344305o);
        if (r117 == true) goto L89;
        if (r101 == null) goto L85;
        BotModel r118 = r101.f559709b;
    L87:
        if (vb8.a.b(r118) == false) goto L89;
        boolean r119 = true;
    L90:
        TextView r120 = this.f344922a.f344307q;
        if (r119 == false) goto L93;
        r120.setMaxWidth(RangesKt.coerceAtLeast((int) (((double) (((com.larus.utils.i.d(this.itemView.getContext()) - (i5.h() * 2)) - f344921o) - i5.C())) * 0.7d), 0));
        int r121 = 0;
    L94:
        r120.setVisibility(r121);
        a4();
        if (((Boolean) this.f344935n.getValue()).booleanValue() == false) goto L100;
        if (r113 == false) goto L98;
        this.f344922a.f344308r.setTypeface(Typeface.DEFAULT, 1);
        goto L100
    L98:
        this.f344922a.f344308r.setTypeface(Typeface.DEFAULT, 0);
    L100:
        if (((Boolean) this.f344934m.getValue()).booleanValue() == false) goto L105;
        if (r113 == false) goto L103;
        this.f344922a.f344308r.setTextSize(0, i5.v());
        goto L105
    L103:
        this.f344922a.f344308r.setTextSize(0, this.itemView.getContext().getResources().getDimension(v19.c.b(R.attr.larus_dp_17, this.itemView.getContext(), R.dimen.larus_side_bar_text_size)));
    L105:
        if (X3(r101) == false) goto L109;
        com.larus.home.impl.main.side_bar.view.b r122 = this.f344923b;
        if (r122 == null) goto L109;
        r122.YX(this, new SideBarConversationHolder$bind$2(this));
    L109:
        if (r101 == null) goto L111;
        wc9.e r123 = r101.f559708a;
    L112:
        if (r123 == null) goto L119;
        Integer r124 = r123.f559202e;
        if (r124 == null) goto L119;
        if (r124.intValue() != 1) goto L119;
        boolean r125 = true;
    L120:
        if (r125 == true) goto L122;
    L126:
        ImageView r126 = this.f344922a.f344296f;
        if (r112 == false) goto L129;
        e1.x(r126);
    L130:
        if (r101 == null) goto L138;
        U3(r101);
        com.larus.home.impl.main.side_bar.view.b r127 = this.f344923b;
        if (r127 == null) goto L138;
        Fragment r128 = r127.getFragment();
        if (r128 == null) goto L138;
        LifecycleCoroutineScope r129 = LifecycleOwnerKt.getLifecycleScope(r128);
        if (r129 == null) goto L138;
        BuildersKt.launch$default(r129, null, null, new SideBarConversationHolder$setupRealtimeCallTag$1(r101, this, null), 3, null);
    L138:
        final wh8.a r130 = r110.f344507b;
        e1.d(this.f344922a.f344294d, new y(this, r130, r111, r110));
        View r131 = this.itemView;
        if (r130 == null) goto L141;
        wc9.e r132 = r130.f559708a;
    L142:
        r131.setHapticFeedbackEnabled(true ^ ic8.n.u(r132));
        if (this.f344925d == true) goto L145;
        this.itemView.setOnClickListener(null);
        this.itemView.setOnLongClickListener(null);
    L146:
        this.f344922a.f344292b.setSelected(r110.f344514i);
        return;
    L145:
        e1.d(this.itemView, new z(this, r130, r111, r110));
        this.itemView.setOnLongClickListener(new a0(this, r130));
        goto L146
    L141:
        r132 = null;
        goto L142
    L129:
        e1.o(r126);
        goto L130
    L122:
        if (ic8.n.u(r123) == true) goto L126;
        if (com.larus.home.impl.main.side_bar.p.b().g() == true) goto L126;
        r112 = true;
    L119:
        r125 = false;
        goto L120
    L111:
        r123 = null;
        goto L112
    L93:
        r121 = 8;
        goto L94
    L85:
        r118 = null;
    L89:
        r119 = false;
        goto L90
    L78:
        if (ic8.n.u(r109) == false) goto L80;
        r117 = true;
        goto L81
    L39:
        if (FlowRuntime.a().n() == false) goto L74;
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L74;
        AppHost.Companion r133 = AppHost.f326268a;
        if (r133.isOversea() == true) goto L74;
        if (r109 == null) goto L47;
        String r134 = r109.f559200c;
    L48:
        if (r134 == null) goto L52;
        r115 = r134;
    L52:
        if (r115.length() != 0) goto L54;
        boolean r135 = true;
    L56:
        if (r135 == false) goto L58;
        r116 = r133.getApplication().getString(R.string.larus_infra_sidebar_chatWithDoubaoWork);
        goto L75
    L58:
        if (r109 == null) goto L60;
        Boolean r136 = r109.a();
    L62:
        if (Intrinsics.areEqual(r136, Boolean.TRUE) == false) goto L65;
        r115 = r133.getApplication().getString(R.string.larus_infra_sidebar_chatWithDoubaoWork);
    L71:
        r116 = r115;
        goto L75
    L65:
        if (Intrinsics.areEqual(r136, Boolean.FALSE) == true) goto L71;
        if (r136 != null) goto L73;
        if (Intrinsics.areEqual(r115, r133.getApplication().getString(R.string.larus_mainchat_inpage_chatTitle_doubaoWork)) == false) goto L71;
        r115 = r133.getApplication().getString(R.string.larus_infra_sidebar_chatWithDoubaoWork);
        goto L71
    L73:
        throw new NoWhenBranchMatchedException();
    L60:
        r136 = null;
        goto L62
    L54:
        r135 = false;
        goto L56
    L47:
        r134 = null;
        goto L48
    L33:
        if (FlowRuntime.a().n() == true) goto L35;
        r113 = true;
        goto L36
    L29:
        r109 = null;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.home.impl.main.side_bar.view.adapter.b0] */
    public SideBarConversationHolder(LarusItemSideBarConversationBinding r100, com.larus.home.impl.main.side_bar.view.b r101, com.larus.home.impl.main.side_bar.view.c r102, boolean r103, float r104, Function3<? super Integer, ? super com.larus.home.impl.main.side_bar.data.j0, ? super String, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r102, "conversationBridge");
        super(r100.f344291a);
        this.f344922a = r100;
        this.f344923b = r101;
        this.f344924c = r102;
        this.f344925d = r103;
        this.f344926e = r104;
        this.f344927f = r105;
        this.f344930i = -1;
        this.f344933l = new b0(this);
        this.f344934m = LazyKt.lazy(new c0());
        this.f344935n = LazyKt.lazy(new d0());
        x0.c(r100.f344291a, false);
    }
}
