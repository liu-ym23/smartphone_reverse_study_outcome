package com.larus.bmhome.chat.outerinput;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.component.bottom.core.f9;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.o4;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.bmhome.utils.y2;
import com.larus.bmhome.view.j2;
import com.larus.common_ui.view.ChatInputInnerView;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.conversation.InputLeftButtonStyle;
import com.larus.input.impl.databinding.LarusWidgetInputOuterBinding;
import com.larus.nova.R;
import com.larus.platform.service.o2;
import com.larus.platform.service.z1;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0003J\b\u0010.\u001a\u00020 H\u0003J\f\u0010/\u001a\u00020 *\u000200H\u0002J\b\u00101\u001a\u00020 H\u0002J\u0018\u00102\u001a\u00020 2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J\u0006\u00106\u001a\u000207J\u0018\u00108\u001a\u00020\n2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J(\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\n2\n\b\u0002\u0010;\u001a\u0004\u0018\u0001002\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020?H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b*\u0010+¨\u0006A"}, d2 = {"Lcom/larus/bmhome/chat/outerinput/OuterChatInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/input/impl/databinding/LarusWidgetInputOuterBinding;", "tabFragment", "Landroidx/fragment/app/Fragment;", "info", "Lcom/larus/im/bean/conversation/Conversation;", "tabKey", "", "bot", "Lcom/larus/im/bean/bot/BotModel;", "actionShown", "inputLeftActionStyle", "Ljava/lang/Integer;", "navigationView", "Landroid/view/View;", "getNavigationView", "()Landroid/view/View;", "navigationView$delegate", "Lkotlin/Lazy;", "init", "", LynxTemplateRender.RENDER_PHASE_SETUP, "(Landroidx/fragment/app/Fragment;Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setText", "setActionSpeakResource", "updateActionSpeakGroupStyle", "setBottomMenuEntranceVisible", "addClickListeners", "cameraLongClickListener", "Lcom/larus/bmhome/view/LongPressTouchListener;", "getCameraLongClickListener", "()Lcom/larus/bmhome/view/LongPressTouchListener;", "cameraLongClickListener$delegate", "setActionEntranceLongClickListener", "addTouchListeners", "adaptInputEventForTabKey", "Lcom/larus/bmhome/chat/outerinput/OuterInputEventBus$OuterInputEvent;", "refreshStatus", "setActionEntranceVisible", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "isShowingRealTimeEntrance", "", "getActionShownByConf", "openMainBot", com.heytap.mcssdk.constant.b.f276361k, "downEvent", "clickFrom", "getStatus", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OuterChatInput extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f308379j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusWidgetInputOuterBinding f308380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f308381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wc9.e f308382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f308383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BotModel f308384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f308385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f308386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f308387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f308388i;

    public static final class a {
    }

    static {
    }

    private final j2 getCameraLongClickListener() {
        return (j2) this.f308388i.getValue();
    }

    private final View getNavigationView() {
        return (View) this.f308387h.getValue();
    }

    private final int getStatus() {
        o2 r100 = o2.f365782a;
        int r101 = Keva.getRepo(r100.e(), 0).getInt("chat_input_status", -1);
        IAIChatService.Companion r102 = IAIChatService.f365899a;
        if (r102.h7() == false) goto L5;
        Keva.getRepo(r100.e(), 0).storeInt("chat_input_status", 2);
        return 2;
    L5:
        if (r101 <= 0) goto L7;
        return r101;
    L7:
        return r102.w7();
    }

    public final void V5() {
        int r100 = getStatus();
        z2 r101 = z2.f365865a;
        if (r101.m3() == true) goto L6;
        if (r100 != 2) goto L6;
        r100 = 1;
    L6:
        FLogger.f375446a.i("OuterChatInput", "refreshStatus, status:" + r100);
        LarusWidgetInputOuterBinding r102 = null;
        if (r100 != 2) goto L61;
        LarusWidgetInputOuterBinding r103 = this.f308380a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L11:
        e1.o(r103.f351528l);
        LarusWidgetInputOuterBinding r104 = this.f308380a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L14:
        e1.x(r104.f351520d);
        LarusWidgetInputOuterBinding r105 = this.f308380a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L17:
        e1.x(r105.f351529m);
        LarusWidgetInputOuterBinding r106 = this.f308380a;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L20:
        ChatInputInnerView r107 = r106.f351529m;
        IAIChatService.Companion r108 = IAIChatService.f365899a;
        Fragment r109 = this.f308381b;
        if (r109 == null) goto L23;
        FragmentActivity r110 = r109.getActivity();
    L24:
        BotModel r111 = this.f308384e;
        wc9.e r112 = this.f308382c;
        if (r112 == null) goto L27;
        String r113 = r112.f559198a;
    L28:
        boolean r114 = r108.N7(r110, r111, r113);
        r107.R5(r114, r114, r114, false, null);
        LarusWidgetInputOuterBinding r115 = this.f308380a;
        if (r115 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L31:
        e1.o(r115.f351526j);
        LarusWidgetInputOuterBinding r116 = this.f308380a;
        if (r116 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L34:
        AppCompatImageView r117 = r116.f351527k;
        Fragment r118 = this.f308381b;
        if (r118 == null) goto L37;
        FragmentActivity r119 = r118.getActivity();
    L38:
        BotModel r120 = this.f308384e;
        wc9.e r121 = this.f308382c;
        if (r121 == null) goto L41;
        String r122 = r121.f559198a;
    L43:
        if (r108.Q7(r119, r120, r122) == false) goto L45;
        int r123 = 0;
    L46:
        r117.setVisibility(r123);
        if (r101.X().a() == false) goto L78;
        LarusWidgetInputOuterBinding r124 = this.f308380a;
        if (r124 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r124 = null;
    L51:
        AppCompatImageView r125 = r124.f351527k;
        if (r125 == null) goto L78;
        LarusWidgetInputOuterBinding r126 = this.f308380a;
        if (r126 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L56:
        AppCompatImageView r127 = r126.f351527k;
        if (r127 == null) goto L59;
        Context r128 = r127.getContext();
    L60:
        r125.setImageResource(v19.c.b(R.attr.larus_icon_chat_action_realtime_call, r128, R.drawable.larus_icon_chat_action_realtime_call));
        goto L78
    L59:
        r128 = null;
    L78:
        if (r101.m3() == true) goto L88;
        LarusWidgetInputOuterBinding r129 = this.f308380a;
        if (r129 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L82:
        e1.o(r129.f351529m);
        LarusWidgetInputOuterBinding r130 = this.f308380a;
        if (r130 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L86:
        e1.o(r102.f351526j);
        return;
    L85:
        r102 = r130;
        goto L86
    L88:
        return;
    L45:
        r123 = 8;
        goto L46
    L41:
        r122 = null;
        goto L43
    L37:
        r119 = null;
        goto L38
    L27:
        r113 = null;
        goto L28
    L23:
        r110 = null;
        goto L24
    L61:
        LarusWidgetInputOuterBinding r131 = this.f308380a;
        if (r131 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L64:
        e1.x(r131.f351528l);
        LarusWidgetInputOuterBinding r132 = this.f308380a;
        if (r132 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L67:
        e1.o(r132.f351520d);
        LarusWidgetInputOuterBinding r133 = this.f308380a;
        if (r133 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r133 = null;
    L70:
        e1.o(r133.f351529m);
        LarusWidgetInputOuterBinding r134 = this.f308380a;
        if (r134 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r134 = null;
    L73:
        e1.x(r134.f351526j);
        LarusWidgetInputOuterBinding r135 = this.f308380a;
        if (r135 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r135 = null;
    L76:
        e1.o(r135.f351527k);
        goto L78
    }

    public final FragmentActivity Y5() {
        Context r100 = getContext();
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L8;
        if ((r100 instanceof FragmentActivity) == true) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
    L8:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        return (FragmentActivity) r100;
    }

    public OuterChatInput(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f308383d = "";
        this.f308387h = LazyKt.lazy(new j(this));
        this.f308388i = LazyKt.lazy(new k(this));
        FLogger.f375446a.i("OuterChatInput", "init");
    }

    public static j2 R5(final OuterChatInput r100) {
        Function1 r101 = new m(r100);
        Function1 r102 = new n();
        Lazy r103 = y2.f315154a;
        return new j2(r101, r102);
    }

    private final void setActionEntranceVisible(List<BotConfItem> r110) {
        Integer r100 = this.f308386g;
        boolean r101 = false;
        LarusWidgetInputOuterBinding r102 = null;
        if (r100 == null) goto L19;
        int r111 = r100.intValue();
        if (r111 != InputLeftButtonStyle.ButtonStyle_Camera.getValue()) goto L8;
    L54:
        int r112 = 1;
    L56:
        this.f308385f = r112;
        FLogger.f375446a.i("OuterChatInput", "setActionEntranceVisible, actionShown:" + this.f308385f);
        int r113 = this.f308385f;
        if (r113 == 1) goto L112;
        if (r113 == 2) goto L96;
        if (r113 == 3) goto L78;
        if (r113 != 4) goto L128;
        LarusWidgetInputOuterBinding r114 = this.f308380a;
        if (r114 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L65:
        r114.f351518b.setVisibility(8);
        LarusWidgetInputOuterBinding r115 = this.f308380a;
        if (r115 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L68:
        AppCompatImageView r116 = r115.f351519c;
        if (r116 == null) goto L128;
        LarusWidgetInputOuterBinding r103 = this.f308380a;
        if (r103 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L73:
        AppCompatImageView r104 = r103.f351519c;
        if (r104 == null) goto L76;
        Context r105 = r104.getContext();
    L77:
        r116.setImageResource(v19.c.b(R.attr.larus_icon_chat_action_realtime_call, r105, R.drawable.larus_icon_chat_action_realtime_call));
        goto L128
    L76:
        r105 = null;
    L128:
        LarusWidgetInputOuterBinding r117 = this.f308380a;
        if (r117 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L132:
        if (r117.f351518b.getVisibility() == 0) goto L135;
        return;
    L135:
        if (this.f308385f != 1) goto L141;
        LarusWidgetInputOuterBinding r118 = this.f308380a;
        if (r118 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L140:
        r102.f351518b.setOnTouchListener(getCameraLongClickListener());
        return;
    L139:
        r102 = r118;
        goto L140
    L141:
        LarusWidgetInputOuterBinding r119 = this.f308380a;
        if (r119 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L144:
        r119.f351518b.setOnTouchListener(null);
        return;
    L78:
        LarusWidgetInputOuterBinding r120 = this.f308380a;
        if (r120 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L81:
        r120.f351518b.setVisibility(0);
        wc9.e r121 = this.f308382c;
        if (r121 == null) goto L89;
        int r106 = InputLeftButtonStyle.ButtonStyle_File_Icon2.getValue();
        Integer r122 = r121.C;
        if (r122 == null) goto L89;
        if (r106 != r122.intValue()) goto L89;
        r101 = true;
    L89:
        if (r101 == false) goto L91;
        int r123 = v19.c.b(R.attr.larus_icon_chat_action_file_02, getContext(), R.drawable.larus_icon_chat_action_file_02);
    L92:
        LarusWidgetInputOuterBinding r107 = this.f308380a;
        if (r107 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L95:
        r107.f351519c.setImageResource(r123);
        goto L128
    L91:
        r123 = v19.c.b(R.attr.larus_icon_chat_action_file_01, getContext(), R.drawable.larus_icon_chat_action_file_01);
        goto L92
    L96:
        LarusWidgetInputOuterBinding r124 = this.f308380a;
        if (r124 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r124 = null;
    L99:
        r124.f351518b.setVisibility(0);
        LarusWidgetInputOuterBinding r125 = this.f308380a;
        if (r125 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r125 = null;
    L102:
        AppCompatImageView r126 = r125.f351519c;
        if (r126 == null) goto L128;
        LarusWidgetInputOuterBinding r108 = this.f308380a;
        if (r108 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L107:
        AppCompatImageView r109 = r108.f351519c;
        if (r109 == null) goto L110;
        Context r127 = r109.getContext();
    L111:
        r126.setImageResource(v19.c.b(R.attr.larus_icon_chat_action_album, r127, R.drawable.larus_icon_chat_action_album));
        goto L128
    L110:
        r127 = null;
        goto L111
    L112:
        LarusWidgetInputOuterBinding r128 = this.f308380a;
        if (r128 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L115:
        r128.f351518b.setVisibility(0);
        LarusWidgetInputOuterBinding r129 = this.f308380a;
        if (r129 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L118:
        AppCompatImageView r130 = r129.f351519c;
        if (r130 == null) goto L128;
        LarusWidgetInputOuterBinding r131 = this.f308380a;
        if (r131 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L123:
        AppCompatImageView r132 = r131.f351519c;
        if (r132 == null) goto L126;
        Context r133 = r132.getContext();
    L127:
        r130.setImageResource(v19.c.b(R.attr.larus_icon_chat_action_camera, r133, R.drawable.larus_icon_chat_action_camera));
        goto L128
    L126:
        r133 = null;
        goto L127
    L8:
        if (r111 != InputLeftButtonStyle.ButtonStyle_Photo.getValue()) goto L11;
    L43:
        r112 = 2;
        goto L56
    L11:
        if (r111 != InputLeftButtonStyle.ButtonStyle_File_Icon1.getValue()) goto L14;
    L47:
        r112 = 3;
        goto L56
    L14:
        if (r111 == InputLeftButtonStyle.ButtonStyle_File_Icon2.getValue()) goto L47;
        if (r111 == InputLeftButtonStyle.ButtonStyle_Call.getValue()) goto L51;
    L55:
        r112 = 0;
    L51:
        r112 = 4;
        goto L56
    L19:
        if (r110 == null) goto L35;
        Iterator<T> r134 = r110.iterator();
    L22:
        if (r134.hasNext() == false) goto L31;
        Object r135 = r134.next();
        BotConfItem r136 = (BotConfItem) r135;
        if (Intrinsics.areEqual(r136.getConfGroupKey(), "show_icon") == true) goto L26;
    L28:
        boolean r137 = false;
    L29:
        if (r137 == false) goto L22;
    L32:
        BotConfItem r138 = (BotConfItem) r135;
        if (r138 == null) goto L35;
        String r139 = r138.getConfValue();
    L36:
        if (r139 == null) goto L55;
        switch(r139.hashCode()) {
            case -1367751899: goto L53;
            case 3045982: goto L49;
            case 3143036: goto L45;
            case 92896879: goto L41;
            default: goto L55;
        };
    L41:
        if (r139.equals("album") == true) goto L43;
    L45:
        if (r139.equals("file") == true) goto L47;
    L49:
        if (r139.equals(NotificationCompat.CATEGORY_CALL) == true) goto L51;
    L53:
        if (r139.equals("camera") == false) goto L55;
    L26:
        if (Intrinsics.areEqual(r136.getConfKey(), "show_icon") == false) goto L28;
        r137 = true;
        goto L29
    L31:
        r135 = null;
    L35:
        r139 = null;
        goto L36
    }

    public OuterChatInput(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f308383d = "";
        this.f308387h = LazyKt.lazy(new j(this));
        this.f308388i = LazyKt.lazy(new k(this));
        FLogger.f375446a.i("OuterChatInput", "init");
    }

    public static final /* synthetic */ void T5(OuterChatInput r100, List r101) {
        r100.setActionEntranceVisible(r101);
    }

    public OuterChatInput(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f308383d = "";
        this.f308387h = LazyKt.lazy(new j(this));
        this.f308388i = LazyKt.lazy(new k(this));
        FLogger.f375446a.i("OuterChatInput", "init");
    }

    public final Object Z5(Fragment r210, wc9.e r211, String r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof OuterChatInput$setup$1) == false) goto L7;
        OuterChatInput$setup$1 r100 = (OuterChatInput$setup$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        OuterChatInput$setup$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        wc9.e r104 = (wc9.e) r110.L$0;
        ResultKt.throwOnFailure(r102);
        int r105 = 1;
        char r106 = 0;
    L63:
        BotModel r112 = (BotModel) r102;
        if (r112 == null) goto L66;
        this.f308384e = r112;
    L67:
        if (r112 == null) goto L69;
        List<BotConfItem> r107 = r112.getBotConf();
    L70:
        setActionEntranceVisible(r107);
        LarusWidgetInputOuterBinding r108 = this.f308380a;
        if (r108 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L73:
        TextView r109 = r108.f351528l;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        String r114 = r109.getContext().getResources().getString(R.string.larus_chat_list_input_placeholder_cn);
        Object[] r115 = new Object[r105];
        r115[r106] = r109.getContext().getResources().getString(R.string.larus_main_bot_name);
        r109.setText(String.format(r114, Arrays.copyOf(r115, r105)));
        z2 r116 = z2.f365865a;
        if (r116.useOldVoiceInputIcon() == false) goto L88;
        LarusWidgetInputOuterBinding r117 = this.f308380a;
        if (r117 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L78:
        AppCompatImageView r118 = r117.f351525i;
        if (r118 == null) goto L101;
        LarusWidgetInputOuterBinding r119 = this.f308380a;
        if (r119 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L83:
        AppCompatImageView r120 = r119.f351525i;
        if (r120 == null) goto L86;
        Context r121 = r120.getContext();
    L87:
        r118.setImageResource(v19.c.b(R.attr.larus_ic_mic_old, r121, R.drawable.larus_ic_mic_old));
        goto L101
    L86:
        r121 = null;
    L101:
        final LarusWidgetInputOuterBinding r122 = this.f308380a;
        if (r122 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r122 = null;
    L104:
        Integer r123 = r116.asrStrengthenConfig().getAsrSpeakStyle();
        if (r123 == null) goto L111;
        if (r123.intValue() != 3) goto L111;
        e1.o(r122.f351525i);
        e1.x(r122.f351522f);
        r122.f351524h.setTextSize(r105, 17.0f);
        int r124 = l0.f375430a;
        r122.f351524h.setText((CharSequence) l0.a(r122.f351524h.getText(), new i(r122, this)));
    L128:
        LarusWidgetInputOuterBinding r125 = this.f308380a;
        if (r125 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r125 = null;
    L131:
        FrameLayout r126 = r125.f351521e;
        if (o4.a() == false) goto L134;
        int r127 = 0;
    L135:
        r126.setVisibility(r127);
        LarusWidgetInputOuterBinding r128 = this.f308380a;
        if (r128 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L138:
        e1.d(r128.f351518b, new e(this));
        LarusWidgetInputOuterBinding r129 = this.f308380a;
        if (r129 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L141:
        e1.d(r129.f351520d, new f(this));
        LarusWidgetInputOuterBinding r130 = this.f308380a;
        if (r130 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r130 = null;
    L144:
        e1.d(r130.f351521e, new g(this));
        LarusWidgetInputOuterBinding r131 = this.f308380a;
        if (r131 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L147:
        e1.d(r131.f351527k, new h(this));
        final Ref.IntRef r132 = new Ref.IntRef();
        final Ref.IntRef r133 = new Ref.IntRef();
        View.OnTouchListener r134 = new l(r132, this, r133);
        LarusWidgetInputOuterBinding r135 = this.f308380a;
        if (r135 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r135 = null;
    L150:
        r135.f351528l.setOnTouchListener(r134);
        LarusWidgetInputOuterBinding r136 = this.f308380a;
        if (r136 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r136 = null;
    L153:
        r136.f351529m.setOnTouchListener(r134);
        LarusWidgetInputOuterBinding r137 = this.f308380a;
        if (r137 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r137 = null;
    L156:
        r137.f351526j.setOnTouchListener(r134);
        V5();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(Y5()), null, null, new OuterChatInput$setup$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(Y5()), null, null, new OuterChatInput$setup$3(r104, this, r112, null), 3, null);
        return Unit.INSTANCE;
    L134:
        r127 = 8;
    L111:
        if (r123 != null) goto L114;
    L119:
        if (r123 != null) goto L122;
    L127:
        e1.x(r122.f351525i);
        e1.o(r122.f351522f);
        goto L128
    L122:
        if (r123.intValue() != r105) goto L127;
        e1.o(r122.f351525i);
        e1.x(r122.f351522f);
        ConstraintLayout r138 = r122.f351522f;
        if (r138 == null) goto L126;
        r138.setBackgroundResource(v19.c.b(R.attr.larus_bg_action_press_speak_group, r138.getContext(), R.drawable.larus_bg_action_press_speak_group));
    L126:
        e1.x(r122.f351523g);
        r122.f351524h.setTextSize(r105, 14.0f);
        TextView r139 = r122.f351524h;
        r139.setText(r139.getText().toString());
        goto L128
    L114:
        if (r123.intValue() != 2) goto L119;
        e1.o(r122.f351525i);
        e1.x(r122.f351522f);
        ConstraintLayout r140 = r122.f351522f;
        if (r140 == null) goto L118;
        r140.setBackgroundResource(v19.c.b(R.attr.larus_bg_action_press_speak_group, r140.getContext(), R.drawable.larus_bg_action_press_speak_group));
    L118:
        e1.o(r122.f351523g);
        r122.f351524h.setTextSize(r105, 14.0f);
        TextView r141 = r122.f351524h;
        r141.setText(r141.getText().toString());
        goto L128
    L88:
        LarusWidgetInputOuterBinding r142 = this.f308380a;
        if (r142 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r142 = null;
    L91:
        AppCompatImageView r143 = r142.f351525i;
        if (r143 == null) goto L101;
        LarusWidgetInputOuterBinding r144 = this.f308380a;
        if (r144 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r144 = null;
    L96:
        AppCompatImageView r145 = r144.f351525i;
        if (r145 == null) goto L99;
        Context r146 = r145.getContext();
    L100:
        r143.setImageResource(v19.c.b(R.attr.larus_ic_mic, r146, R.drawable.larus_ic_mic));
        goto L101
    L99:
        r146 = null;
        goto L100
    L69:
        r107 = null;
        goto L70
    L66:
        r112 = null;
        goto L67
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (this.f308380a != null) goto L17;
        this.f308381b = r210;
        this.f308382c = r211;
        this.f308383d = r212;
        Lazy r147 = f9.f298504a;
        if (r211 == null) goto L21;
        String r148 = r211.f559198a;
    L22:
        if (r211 == null) goto L24;
        Integer r149 = r211.f559219v;
    L25:
        Integer r150 = f9.b(r211, r148, r149);
        this.f308386g = r150;
        if (r150 == null) goto L28;
        FLogger.f375446a.i("OuterChatInput", "[MainConversationInputFallback] outerSetup resolvedStyle=" + this.f308386g);
    L28:
        LayoutInflater.from(getContext()).inflate(R.layout.larus_widget_input_outer, this);
        int r151 = R.id.action_area;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.action_area)) == null) goto L159;
        r151 = R.id.action_entrance;
        FrameLayout r152 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.action_entrance);
        if (r152 == null) goto L159;
        r151 = R.id.action_entrance_iv;
        AppCompatImageView r153 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.action_entrance_iv);
        if (r153 == null) goto L159;
        r151 = R.id.action_input;
        AppCompatImageView r154 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.action_input);
        if (r154 == null) goto L159;
        r151 = R.id.action_menu_entrance;
        FrameLayout r155 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.action_menu_entrance);
        if (r155 == null) goto L159;
        r151 = R.id.action_press_speak_group;
        ConstraintLayout r156 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.action_press_speak_group);
        if (r156 == null) goto L159;
        r151 = R.id.action_press_speak_icon;
        AppCompatImageView r157 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.action_press_speak_icon);
        if (r157 == null) goto L159;
        r151 = R.id.action_press_speak_text;
        TextView r158 = (TextView) ViewBindings.findChildViewById(this, R.id.action_press_speak_text);
        if (r158 == null) goto L159;
        r151 = R.id.action_speak;
        AppCompatImageView r159 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.action_speak);
        if (r159 == null) goto L159;
        r151 = R.id.action_speak_group;
        FrameLayout r160 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.action_speak_group);
        if (r160 == null) goto L159;
        r151 = R.id.action_speech;
        AppCompatImageView r161 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.action_speech);
        if (r161 == null) goto L159;
        r151 = R.id.input_area;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.input_area)) == null) goto L159;
        r151 = R.id.input_area_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.input_area_container)) == null) goto L159;
        r151 = R.id.input_text;
        TextView r162 = (TextView) ViewBindings.findChildViewById(this, R.id.input_text);
        if (r162 == null) goto L159;
        r151 = R.id.iv_action_menu_entrance;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_action_menu_entrance)) == null) goto L159;
        r151 = R.id.speak_area;
        ChatInputInnerView r214 = (ChatInputInnerView) ViewBindings.findChildViewById(this, R.id.speak_area);
        if (r214 == null) goto L159;
        this.f308380a = new LarusWidgetInputOuterBinding(this, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r214);
        IBotRepoService r163 = RepoDispatcherDelegate.f307737b.b();
        r104 = r211;
        String r164 = r104.f559198a;
        r110.L$0 = r104;
        r105 = 1;
        r110.label = 1;
        r106 = 0;
        r102 = r163.j1(r164, false, r110);
        if (r102 != r111) goto L63;
        return r111;
    L159:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r151)));
    L24:
        r149 = null;
        goto L25
    L21:
        r148 = null;
        goto L22
    L17:
        return Unit.INSTANCE;
    L7:
        r100 = new OuterChatInput$setup$1(this, r213);
        goto L8
    }

    public static void S5(Ref.IntRef r100, OuterChatInput r101, Ref.IntRef r102, View r110, MotionEvent r111) {
        MutableSharedFlow<Integer> r103 = OuterInputEventBus.f308397a;
        Intrinsics.checkNotNull(r111);
        Intrinsics.checkNotNullParameter(r111, "<this>");
        OuterInputEventBus.OuterInputEvent r104 = new OuterInputEventBus.OuterInputEvent(r111.getAction(), r111.getX(), r111.getY(), 0.0f, 0.0f);
        if (r111.getAction() != 0) goto L28;
        View r105 = r101.getNavigationView();
        if (r105 == null) goto L7;
        int r106 = r105.getHeight();
    L8:
        r100.element = r106;
        LarusWidgetInputOuterBinding r107 = r101.f308380a;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L12:
        if (Intrinsics.areEqual(r110, r107.f351528l) == false) goto L14;
        int r108 = 201;
    L27:
        OuterInputEventBus.b(r101.f308383d).resetReplayCache();
        U5(r101, r108, r104, null, 4);
    L44:
        if (r111.getAction() != 0) goto L46;
        OuterInputEventBus.a(r101.f308383d).resetReplayCache();
    L46:
        OuterInputEventBus.a(r101.f308383d).tryEmit(r104);
        if (r111.getActionMasked() != 2) goto L52;
        int r109 = r102.element + 1;
        r102.element = r109;
        if (r109 != 1) goto L56;
        FLogger.f375446a.i("OuterChatInput", "onTouchEvent event=" + r111.getAction() + ", MOVE");
        return;
    L56:
        return;
    L52:
        if (r102.element <= 0) goto L54;
        FLogger.f375446a.i("OuterChatInput", "onTouchEvent:" + r111.getAction() + ", after " + r102.element + " MOVE");
        r102.element = 0;
        return;
    L54:
        FLogger.f375446a.i("OuterChatInput", "onTouchEvent:" + r111.getAction());
        return;
    L14:
        LarusWidgetInputOuterBinding r112 = r101.f308380a;
        if (r112 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L18:
        if (Intrinsics.areEqual(r110, r112.f351529m) == false) goto L20;
        r108 = 202;
        goto L27
    L20:
        LarusWidgetInputOuterBinding r113 = r101.f308380a;
        if (r113 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L24:
        if (Intrinsics.areEqual(r110, r113.f351526j) == false) goto L26;
        r108 = 203;
        goto L27
    L26:
        r108 = -1;
        goto L27
    L7:
        r106 = 0;
        goto L8
    L28:
        View r114 = r101.getNavigationView();
        if (r114 != null) goto L31;
    L36:
        boolean r115 = false;
    L37:
        if (r115 == true) goto L40;
        float r116 = r104.f308403c;
        float r117 = r100.element;
        r104.f308403c = r116 + r117;
        r104.f308405e += r117;
    L40:
        if (Intrinsics.areEqual(r101.f308383d, "aweeme_feed_fragment") == false) goto L42;
        r104.f308402b -= com.larus.utils.i.d(r101.getContext());
    L42:
        OuterInputEventBus.b(r101.f308383d).tryEmit(r104);
        goto L44
    L31:
        if (r114.getVisibility() != 0) goto L33;
        boolean r118 = true;
    L34:
        if (r118 != true) goto L36;
        r115 = true;
        goto L37
    L33:
        r118 = false;
        goto L34
    }

    public static void U5(OuterChatInput r110, int r111, OuterInputEventBus.OuterInputEvent r210, String r211, int r212) {
        String r100 = null;
        if ((r212 & 2) == 0) goto L5;
        OuterInputEventBus.OuterInputEvent r101 = null;
    L7:
        if ((r212 & 4) == 0) goto L9;
        String r102 = null;
    L10:
        r110.getClass();
        FLogger.f375446a.i("OuterChatInput", "openMainBot, eventId:" + r111);
        z1.f365863a.c(r110.Y5());
        Pair[] r103 = new Pair[10];
        r103[0] = TuplesKt.to("arg_outer_input_tab_key", r110.f308383d);
        BotModel r104 = r110.f308384e;
        if (r104 == null) goto L13;
        String r105 = r104.getBotId();
    L14:
        r103[1] = TuplesKt.to("argBotId", r105);
        wc9.e r106 = r110.f308382c;
        if (r106 == null) goto L17;
        r100 = r106.f559198a;
    L17:
        r103[2] = TuplesKt.to("argConversationId", r100);
        r103[3] = TuplesKt.to("arg_outer_input_event_id", Integer.valueOf(r111));
        r103[4] = TuplesKt.to("arg_outer_input_down_event", r101);
        r103[5] = TuplesKt.to("click_from", r102);
        int r107 = b0.f308425a;
        r103[6] = TuplesKt.to("enter_method", b0.a(r110.f308383d));
        r103[7] = TuplesKt.to("enter_from", b0.a(r110.f308383d));
        String r108 = r110.f308383d;
        Intrinsics.checkNotNullParameter(r108, "tabKey");
        switch(r108.hashCode()) {
            case -1462439438: goto L29;
            case -1039689911: goto L26;
            case -503960960: goto L23;
            case 1619864869: goto L20;
            default: goto L31;
        };
    L20:
        String r109 = "chat_list";
        if (r108.equals("chat_list") == false) goto L31;
    L32:
        r103[8] = TuplesKt.to("argPreviousPage", r109);
        if (Intrinsics.areEqual(r110.f308383d, "aweme_feed_dialog") == false) goto L35;
    L38:
        String r112 = "0";
    L39:
        r103[9] = TuplesKt.to("argOpenNewChatPage", r112);
        Bundle r113 = com.larus.utils.f.c(r103);
        MainBotServiceDelegate r114 = MainBotServiceDelegate.f308544b;
        Context r115 = r110.getContext();
        wc9.e r116 = r110.f308382c;
        if (r116 == null) goto L46;
        ConversationPage r117 = r116.f559204g;
        if (r117 == null) goto L46;
        Integer r118 = r117.getDefaultStatus();
        if (r118 == null) goto L46;
        int r119 = r118.intValue();
    L47:
        int r120 = r119;
        wc9.e r121 = r110.f308382c;
        if (r121 == null) goto L53;
        ConversationPage r122 = r121.f559204g;
        if (r122 == null) goto L53;
        List<Integer> r123 = r122.getPageList();
        if (r123 == null) goto L53;
    L54:
        List<Integer> r124 = r123;
        wc9.e r125 = r110.f308382c;
        if (r125 == null) goto L61;
        ConversationPage r126 = r125.f559204g;
        if (r126 == null) goto L61;
        Integer r127 = r126.getPagePosition();
        if (r127 == null) goto L61;
        int r128 = r127.intValue();
    L62:
        r114.c(r115, new IMainBotService.a(r113, r120, r124, r128, R.anim.larus_fade_in, R.anim.larus_fade_out, null, 64));
        return;
    L61:
        r128 = 0;
    L53:
        r123 = CollectionsKt.emptyList();
    L46:
        r119 = PageType.Chat.getType();
        goto L47
    L35:
        if (Intrinsics.areEqual(r110.f308383d, "aweeme_feed_fragment") == true) goto L38;
        r112 = "1";
        goto L39
    L23:
        r109 = "bot_list_profile";
        if (r108.equals("bot_list_profile") == true) goto L32;
    L26:
        r109 = "notify";
        if (r108.equals("notify") == true) goto L32;
    L29:
        r109 = "bot_list_discover";
        if (r108.equals("bot_list_discover") == true) goto L32;
    L31:
        r109 = "";
        goto L32
    L13:
        r105 = null;
        goto L14
    L9:
        r102 = r211;
        goto L10
    L5:
        r101 = r210;
        goto L7
    }
}
