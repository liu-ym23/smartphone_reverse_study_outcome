package com.larus.bmhome.chat.component.bottom.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton;
import com.larus.bmhome.chat.component.bottom.floating.button.ButtonType;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.layout.holder.helper.m0;
import com.larus.bmhome.chat.layout.holder.helper.q1;
import com.larus.bmhome.chat.layout.holder.helper.t;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.u2;
import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.databinding.LarusPageChatBottomFloatingButtonBinding;
import com.larus.bmhome.view.FastScrollButton;
import com.larus.bmhome.view.a2;
import com.larus.bmhome.view.b2;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.service.z1;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.SafeExtKt;
import com.larus.utils.b1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ld8.g;
import ld8.h;
import ld8.i;
import ld8.j;
import ld8.k;
import ld8.l;
import ld8.m;
import ld8.n;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001n\u0018\u0000 p2\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0001pB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u00105\u001a\u0004\u0018\u00010)H\u0002J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\"H\u0016J\b\u00108\u001a\u00020&H\u0016J\u0010\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020&H\u0016J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J\u0018\u0010?\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u0010@\u001a\u000204H\u0016J\u0010\u0010A\u001a\u00020&2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u000204H\u0016J\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010F\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010G\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010H\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010I\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010J\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010K\u001a\u0002002\u0006\u0010E\u001a\u000200H\u0002J\u0012\u0010L\u001a\u00020&2\b\b\u0002\u0010M\u001a\u000204H\u0002J\b\u0010N\u001a\u00020&H\u0002J\u0010\u0010O\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\b\u0010Q\u001a\u00020&H\u0002J\u0012\u0010R\u001a\u00020&2\b\b\u0002\u0010M\u001a\u000204H\u0002J\b\u0010S\u001a\u00020&H\u0002J\u0010\u0010T\u001a\u0002042\u0006\u0010U\u001a\u000200H\u0016J\u0010\u0010V\u001a\u00020&2\u0006\u0010?\u001a\u000204H\u0016J3\u0010W\u001a\u00020&2\u0006\u0010U\u001a\u0002002!\u0010W\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0016J\u0018\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u000204H\u0016J\u0012\u0010^\u001a\u0002042\b\u0010_\u001a\u0004\u0018\u00010\\H\u0016J\u0010\u0010`\u001a\u00020&2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020\u001dH\u0016J\b\u0010d\u001a\u00020&H\u0016J\n\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010g\u001a\u00020&H\u0016J\u0010\u0010h\u001a\u00020&2\u0006\u0010i\u001a\u00020\\H\u0002J,\u0010j\u001a\u00020&2\u0006\u0010Y\u001a\u00020Z2\b\u0010k\u001a\u0004\u0018\u00010l2\b\u0010_\u001a\u0004\u0018\u00010\\2\u0006\u0010:\u001a\u00020;H\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R+\u00102\u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010o¨\u0006q"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "collectionAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectionAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "collectionAbility$delegate", "listComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listComponentAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "totalY", "", "bindingViewStub", "Landroid/view/ViewStub;", "onFastButtonClicked", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "it", "", "onBackChatButtonClicked", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBottomFloatingButtonBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatBottomFloatingButtonBinding;", "showAnimator", "Landroid/animation/AnimatorSet;", "hideAnimator", "currentType", "Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonType;", "lastType", "longImageButtonClickListener", "isForceHide", "", "initBinding", "onViewCreated", "view", "onAttach", "findTargetType", "action", "Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonAction;", LiveCommonConstants.REASON_ON_DEDTROY, "cancelHideAnimation", "cancelShowAnimation", "show", "isForce", "hide", "setForceHide", "forceHide", "dispatchAnimation", "targetType", "dispatchTypeNone", "dispatchTypeFastScroll", "dispatchTypeBackChat", "dispatchTypeShareLongImage", "dispatchTypeShareLongImageScrolled", "dispatchTypeGuideCollect", "showFastScrollButtonWithAnimation", "isFastBackChat", "showFastScrollButtonFromShareLongImageButton", "showFloatingBottomButtonWithAnimation", "expendWidthAnimator", "showViewNewsWithAnimation", "hideFastScrollButtonWithAnimation", "hideFloatingBottomButtonWithAnimation", "isShow", "type", "resumeFastScrollButton", SendEventContainerMethodParamModel.EventKinds.onClick, "guideAddCollectIfNeed", "from", "Lcom/larus/bmhome/chat/component/bottom/floating/collect/CollectFrom;", RemoteMessageConst.MSGID, "", "guideLookLikeIfNeed", "guideLookCollectIfNeed", "collectId", "addFastButtonTranslationY", "y", "", "getFastButtonTranslationY", "recoverFastButtonTranslationY", "fastScrollIconLayoutTarget", "Landroid/widget/ImageView;", "hideFastScrollButton", "logFastScrollButtonState", "source", "showGuideCollectTip", "msg", "Lcom/larus/im/bean/message/Message;", "floatingBottomButtonDependency", "com/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonComponent$floatingBottomButtonDependency$1", "Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonComponent$floatingBottomButtonDependency$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomFloatingButtonComponent extends BaseContentWidget implements n, xa8.a {
    public static final Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> D = null;
    public boolean A;
    public AnimatorSet B;
    public final c C;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f299573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f299574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f299575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f299576p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f299577q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewStub f299578r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super View, Unit> f299579s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1<? super View, Unit> f299580t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LarusPageChatBottomFloatingButtonBinding f299581u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AnimatorSet f299582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AnimatorSet f299583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public BottomFloatingButtonType f299584x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BottomFloatingButtonType f299585y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1<? super View, Unit> f299586z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f299587a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f299588b = null;

        static {
            int[] r100 = new int[BottomFloatingButtonType.values().length];
            r100[BottomFloatingButtonType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r100[BottomFloatingButtonType.FAST_SCROLL_BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L53:
            r100[BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON_SCROLLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[BottomFloatingButtonType.ADD_COLLECT_TIP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[BottomFloatingButtonType.LOOK_COLLECT_TIP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L47:
            r100[BottomFloatingButtonType.BACK_CHAT_BUTTON.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L49:
            r100[BottomFloatingButtonType.VIEW_NEW_NEWS_BUTTON.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L37:
            r100[BottomFloatingButtonType.CHECK_FAST_SCROLL_BUTTON.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L41:
            r100[BottomFloatingButtonType.CHECK_SHARE_LONG_IMAGE_BUTTON.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L14:
            f299587a = r100;
            int[] r101 = new int[CollectFrom.values().length];
            r101[CollectFrom.COPY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L31:
            r101[CollectFrom.LIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L17:
            f299588b = r101;
        }
    }

    public static final class c implements BottomFloatingButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public md8.a f299589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomFloatingButtonComponent f299590b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f299591a = null;

            static {
                int[] r100 = new int[ButtonType.values().length];
                r100[ButtonType.SHARE_LONG_IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[ButtonType.ADD_COLLECT_COPY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[ButtonType.ADD_COLLECT_LIKE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[ButtonType.LOOK_COLLECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[ButtonType.LOOK_LIKE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f299591a = r100;
            }
        }

        @Override // com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton.b
        public final void a() {
            this.f299590b.m60(BottomFloatingButtonAction.AUTO_HIDE);
        }

        public final void c() {
            FLogger.f375446a.i("BottomFloatingButtonComponent", "collect, data:" + this.f299589a);
            md8.a r100 = this.f299589a;
            if (r100 == null) goto L31;
            CollectFrom r101 = r100.f513424a;
            if (r101 == null) goto L35;
            Message r102 = r100.f513425b;
            if (r102 == null) goto L36;
            BottomFloatingButtonComponent r103 = this.f299590b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r104 = BottomFloatingButtonComponent.D;
            u7 r105 = (u7) r103.f299575o.getValue();
            if (r105 == null) goto L32;
            List<Message> r106 = r105.zj();
            if (r106 == null) goto L37;
            IChatMessageShareAbility r107 = (IChatMessageShareAbility) this.f299590b.f299576p.getValue();
            if (r107 == null) goto L33;
            List<Message> r108 = r107.Us(r102, r106);
            if (r108 == null) goto L38;
            o r109 = (o) this.f299590b.f299574n.getValue();
            if (r109 == null) goto L34;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            int r110 = md8.c.f513428a[r101.ordinal()];
            if (r110 != 1) goto L25;
            String r111 = "copy";
        L29:
            final BottomFloatingButtonComponent r112 = this.f299590b;
            o.a.b(r109, "toast_after_other_action", r111, r108, new i(r112, this));
            return;
        L25:
            if (r110 == 2) goto L27;
            r111 = "None";
            goto L29
        L27:
            r111 = IStrategyStateSupplier.KEY_INFO_LIKE;
            goto L29
        L34:
            return;
        L38:
            return;
        L33:
            return;
        L37:
            return;
        L32:
            return;
        L36:
            return;
        L35:
            return;
        }

        public c(BottomFloatingButtonComponent r100) {
            this.f299590b = r100;
        }

        public final void d(String r100) {
            FLogger.f375446a.i("BottomFloatingButtonComponent", "lookCollect");
            md8.a r101 = this.f299589a;
            if (r101 == null) goto L27;
            CollectFrom r102 = r101.f513424a;
            if (r102 == null) goto L30;
            CollectionReportDelegate r103 = CollectionReportDelegate.f310657b;
            if (r100 != null) goto L10;
            r100 = r101.f513426c;
        L10:
            Intrinsics.checkNotNullParameter(r102, "<this>");
            int r104 = md8.c.f513428a[r102.ordinal()];
            if (r104 != 1) goto L13;
            String r105 = "copy";
        L17:
            ActivityResultCaller r106 = s1a.a.c(this.f299590b);
            if ((r106 instanceof by7.e) == false) goto L20;
            by7.e r107 = (by7.e) r106;
        L21:
            r103.a(r100, "collected_check", r105, r107);
            z1.f365863a.b(s1a.a.c(this.f299590b), "MY_COLLECT");
            BottomFloatingButtonComponent r108 = this.f299590b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r109 = BottomFloatingButtonComponent.D;
            LarusPageChatBottomFloatingButtonBinding r110 = r108.m3();
            if (r110 == null) goto L28;
            FrameLayout r111 = r110.f311110a;
            if (r111 == null) goto L29;
            final BottomFloatingButtonComponent r112 = this.f299590b;
            SafeExtKt.b(r111, new k(r112), 500);
            return;
        L29:
            return;
        L28:
            return;
        L20:
            r107 = null;
            goto L21
        L13:
            if (r104 == 2) goto L15;
            r105 = "None";
            goto L17
        L15:
            r105 = IStrategyStateSupplier.KEY_INFO_LIKE;
            goto L17
        L30:
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton.b
        public final void b(BottomFloatingButton r100, ButtonType r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "type");
            int r102 = a.f299591a[r101.ordinal()];
            if (r102 != 1) goto L5;
            Function1<? super View, Unit> r103 = this.f299590b.f299586z;
            if (r103 == null) goto L38;
            r103.invoke(r100);
            return;
        L38:
            return;
        L5:
            if (r102 == 2) goto L24;
            if (r102 == 3) goto L21;
            if (r102 != 4) goto L11;
            d(null);
            return;
        L11:
            if (r102 != 5) goto L18;
            FLogger.f375446a.i("BottomFloatingButtonComponent", "lookLike");
            z1.f365863a.b(s1a.a.c(this.f299590b), "MY_LIKE");
            BottomFloatingButtonComponent r104 = this.f299590b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r105 = BottomFloatingButtonComponent.D;
            LarusPageChatBottomFloatingButtonBinding r106 = r104.m3();
            if (r106 == null) goto L30;
            FrameLayout r107 = r106.f311110a;
            if (r107 == null) goto L31;
            final BottomFloatingButtonComponent r108 = this.f299590b;
            SafeExtKt.b(r107, new j(r108), 500);
            return;
        L31:
            return;
        L30:
            return;
        L18:
            throw new NoWhenBranchMatchedException();
        L21:
            if (AppHost.f326268a.isPlugin() == true) goto L34;
            c();
            return;
        L34:
            return;
        L24:
            if (AppHost.f326268a.isPlugin() == true) goto L36;
            c();
            return;
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomFloatingButtonComponent f299592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f299593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding f299594c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BottomFloatingButtonComponent r101 = this.f299592a;
            String r102 = "hide_fast_animation_cancel isFastBackChat=" + this.f299593b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r103 = BottomFloatingButtonComponent.D;
            r101.B3(r102);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f299594c.f311110a.setVisibility(8);
            if (this.f299593b == false) goto L5;
            this.f299594c.f311112c.setVisibility(0);
            this.f299594c.f311114e.setVisibility(8);
        L6:
            this.f299594c.f311115f.setVisibility(8);
            this.f299594c.f311113d.setBackground(null);
            ViewGroup.LayoutParams r101 = this.f299594c.f311112c.getLayoutParams();
            r101.width = i5.s0();
            this.f299594c.f311112c.setLayoutParams(r101);
            this.f299594c.f311111b.b();
            BottomFloatingButtonComponent r102 = this.f299592a;
            r102.f299583w = null;
            r102.B3("hide_fast_animation_end isFastBackChat=" + this.f299593b);
            return;
        L5:
            this.f299594c.f311112c.setVisibility(8);
            this.f299594c.f311114e.setVisibility(0);
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BottomFloatingButtonComponent r101 = this.f299592a;
            String r102 = "hide_fast_animation_start isFastBackChat=" + this.f299593b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r103 = BottomFloatingButtonComponent.D;
            r101.B3(r102);
        }

        public d(BottomFloatingButtonComponent r100, boolean r101, LarusPageChatBottomFloatingButtonBinding r102) {
            this.f299592a = r100;
            this.f299593b = r101;
            this.f299594c = r102;
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding f299595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomFloatingButtonComponent f299596b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f299595a.f311110a.setVisibility(8);
            this.f299595a.f311114e.setVisibility(8);
            this.f299595a.f311111b.b();
            this.f299596b.f299583w = null;
        }

        public e(LarusPageChatBottomFloatingButtonBinding r100, BottomFloatingButtonComponent r101) {
            this.f299595a = r100;
            this.f299596b = r101;
        }
    }

    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomFloatingButtonComponent f299597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f299598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding f299599c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BottomFloatingButtonComponent r101 = this.f299597a;
            String r102 = "show_fast_animation_cancel isFastBackChat=" + this.f299598b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r103 = BottomFloatingButtonComponent.D;
            r101.B3(r102);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BottomFloatingButtonComponent r101 = this.f299597a;
            String r102 = "show_fast_animation_end isFastBackChat=" + this.f299598b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r103 = BottomFloatingButtonComponent.D;
            r101.B3(r102);
            this.f299597a.f299582v = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BottomFloatingButtonComponent r101 = this.f299597a;
            String r102 = "show_fast_animation_start isFastBackChat=" + this.f299598b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r103 = BottomFloatingButtonComponent.D;
            r101.B3(r102);
            this.f299599c.f311110a.setVisibility(0);
            if (this.f299598b == false) goto L5;
            this.f299599c.f311112c.setVisibility(0);
            this.f299599c.f311114e.setVisibility(8);
        L6:
            this.f299599c.f311111b.b();
            return;
        L5:
            this.f299599c.f311112c.setVisibility(8);
            this.f299599c.f311114e.setVisibility(0);
            goto L6
        }

        public f(BottomFloatingButtonComponent r100, boolean r101, LarusPageChatBottomFloatingButtonBinding r102) {
            this.f299597a = r100;
            this.f299598b = r101;
            this.f299599c = r102;
        }
    }

    static {
        BottomFloatingButtonType r100 = BottomFloatingButtonType.NONE;
        BottomFloatingButtonAction r101 = BottomFloatingButtonAction.SCROLL_UP;
        Pair r102 = new Pair(r100, r101);
        BottomFloatingButtonType r103 = BottomFloatingButtonType.FAST_SCROLL_BUTTON;
        BottomFloatingButtonAction r104 = BottomFloatingButtonAction.SCROLL_DOWN;
        BottomFloatingButtonAction r105 = BottomFloatingButtonAction.AUTO_HIDE;
        BottomFloatingButtonAction r106 = BottomFloatingButtonAction.SCREENSHOT;
        Pair r107 = new Pair(r100, r106);
        BottomFloatingButtonType r108 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON;
        BottomFloatingButtonAction r109 = BottomFloatingButtonAction.SHOW_ADD_COLLECT_TIP;
        Pair r110 = new Pair(r100, r109);
        BottomFloatingButtonType r111 = BottomFloatingButtonType.ADD_COLLECT_TIP;
        BottomFloatingButtonAction r112 = BottomFloatingButtonAction.SHOW_LOOK_COLLECT_TIP;
        Pair r113 = new Pair(r100, r112);
        BottomFloatingButtonType r114 = BottomFloatingButtonType.LOOK_COLLECT_TIP;
        BottomFloatingButtonAction r115 = BottomFloatingButtonAction.BACK_CHAT;
        Pair r116 = new Pair(r100, r115);
        BottomFloatingButtonType r117 = BottomFloatingButtonType.BACK_CHAT_BUTTON;
        Pair r118 = new Pair(r103, r106);
        BottomFloatingButtonType r119 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON_SCROLLED;
        Pair r120 = new Pair(r111, r105);
        BottomFloatingButtonType r121 = BottomFloatingButtonType.CHECK_FAST_SCROLL_BUTTON;
        Pair r122 = new Pair(r111, r106);
        BottomFloatingButtonType r123 = BottomFloatingButtonType.CHECK_SHARE_LONG_IMAGE_BUTTON;
        BottomFloatingButtonAction r124 = BottomFloatingButtonAction.VIEW_NEW_NEWS;
        Pair r125 = new Pair(r117, r124);
        BottomFloatingButtonType r126 = BottomFloatingButtonType.VIEW_NEW_NEWS_BUTTON;
        D = MapsKt.mapOf(new Pair[]{TuplesKt.to(r102, r103), TuplesKt.to(new Pair(r100, r104), r100), TuplesKt.to(new Pair(r100, r105), r100), TuplesKt.to(r107, r108), TuplesKt.to(r110, r111), TuplesKt.to(r113, r114), TuplesKt.to(r116, r117), TuplesKt.to(new Pair(r103, r101), r103), TuplesKt.to(new Pair(r103, r105), r103), TuplesKt.to(r118, r119), TuplesKt.to(new Pair(r103, r104), r100), TuplesKt.to(new Pair(r103, r109), r111), TuplesKt.to(new Pair(r103, r112), r114), TuplesKt.to(new Pair(r103, r115), r117), TuplesKt.to(new Pair(r108, r101), r119), TuplesKt.to(new Pair(r108, r106), r108), TuplesKt.to(new Pair(r108, r104), r108), TuplesKt.to(new Pair(r108, r105), r100), TuplesKt.to(new Pair(r108, r109), r111), TuplesKt.to(new Pair(r108, r112), r114), TuplesKt.to(new Pair(r108, r115), r119), TuplesKt.to(new Pair(r119, r101), r119), TuplesKt.to(new Pair(r119, r106), r119), TuplesKt.to(new Pair(r119, r105), r103), TuplesKt.to(new Pair(r119, r104), r108), TuplesKt.to(new Pair(r119, r109), r111), TuplesKt.to(new Pair(r119, r112), r114), TuplesKt.to(new Pair(r119, r115), r119), TuplesKt.to(new Pair(r111, r101), r111), TuplesKt.to(new Pair(r111, r104), r111), TuplesKt.to(r120, r121), TuplesKt.to(r122, r123), TuplesKt.to(new Pair(r111, r109), r111), TuplesKt.to(new Pair(r111, r112), r114), TuplesKt.to(new Pair(r111, r115), r111), TuplesKt.to(new Pair(r114, r101), r114), TuplesKt.to(new Pair(r114, r104), r114), TuplesKt.to(new Pair(r114, r105), r121), TuplesKt.to(new Pair(r114, r106), r123), TuplesKt.to(new Pair(r114, r109), r111), TuplesKt.to(new Pair(r114, r112), r114), TuplesKt.to(new Pair(r114, r115), r114), TuplesKt.to(new Pair(r117, r101), r103), TuplesKt.to(new Pair(r117, r104), r117), TuplesKt.to(new Pair(r117, r105), r117), TuplesKt.to(new Pair(r117, r106), r119), TuplesKt.to(new Pair(r117, r109), r111), TuplesKt.to(new Pair(r117, r112), r114), TuplesKt.to(new Pair(r117, r115), r117), TuplesKt.to(new Pair(r117, BottomFloatingButtonAction.HIDE_BACK_CHAT), r100), TuplesKt.to(r125, r126), TuplesKt.to(new Pair(r126, r101), r126), TuplesKt.to(new Pair(r126, r104), r126), TuplesKt.to(new Pair(r126, r124), r126)});
    }

    @Override // ld8.n
    public final void RZ() {
        B3("hide_fast_scroll_button_direct");
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        if (r100 == null) goto L6;
        r100.f311114e.setVisibility(8);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, ld8.f] */
    public final LarusPageChatBottomFloatingButtonBinding m3() {
        if (this.f299581u != null) goto L27;
        ViewStub r100 = this.f299578r;
        LarusPageChatBottomFloatingButtonBinding r101 = null;
        if (r100 == null) goto L25;
        r100.setLayoutResource(R.layout.larus_page_chat_bottom_floating_button);
        View r102 = r100.inflate();
        if (r102 == null) goto L25;
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-2, -2);
        r103.topToTop = R.id.input;
        r103.startToStart = 0;
        r103.endToEnd = 0;
        r102.setLayoutParams(r103);
        r102.setTranslationZ(1.0f);
        int r104 = R.id.bottom_button;
        final BottomFloatingButton r105 = (BottomFloatingButton) ViewBindings.findChildViewById(r102, R.id.bottom_button);
        if (r105 == null) goto L24;
        r104 = R.id.fast_back_button;
        LinearLayout r110 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.fast_back_button);
        if (r110 == null) goto L24;
        r104 = R.id.fast_back_button_container;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.fast_back_button_container);
        if (r106 == null) goto L24;
        r104 = R.id.fast_button;
        final FastScrollButton r111 = (FastScrollButton) ViewBindings.findChildViewById(r102, R.id.fast_button);
        if (r111 == null) goto L24;
        r104 = R.id.tv_back_to_chat;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r102, R.id.tv_back_to_chat);
        if (r112 == null) goto L24;
        LarusPageChatBottomFloatingButtonBinding r107 = new LarusPageChatBottomFloatingButtonBinding((FrameLayout) r102, r105, r110, r106, r111, r112);
        final c r108 = this.C;
        Intrinsics.checkNotNullParameter(r108, "dependency");
        r105.f299603a = r108;
        e1.d(r105, new com.larus.bmhome.chat.component.bottom.floating.button.b(r105, r108));
        final ?? r109 = new ld8.f(this);
        Intrinsics.checkNotNullParameter(r109, SendEventContainerMethodParamModel.EventKinds.onClick);
        r111.f315545d.setOnTouchListener(new a2(r111));
        ImageView r113 = r111.f315545d;
        Function1 r114 = new b2(r111, r109);
        Intrinsics.checkNotNullParameter(r114, SendEventContainerMethodParamModel.EventKinds.onClick);
        if (r113 == null) goto L22;
        r113.setTag(123400001, 100L);
        r113.setOnClickListener(new b1(r113, r114));
    L22:
        r110.setOnClickListener(new g(this));
        this.f299578r = null;
        r101 = r107;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    L25:
        this.f299581u = r101;
    L27:
        return this.f299581u;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        AnimatorSet r100 = this.f299583w;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f299583w = null;
        AnimatorSet r101 = this.f299582v;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f299582v = null;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, n.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, xa8.a.class);
    }

    public BottomFloatingButtonComponent() {
        this.f299573m = LazyKt.lazy(new ld8.b(this));
        this.f299574n = LazyKt.lazy(new ld8.c(this));
        this.f299575o = LazyKt.lazy(new ld8.d(this));
        this.f299576p = LazyKt.lazy(new ld8.e(this));
        this.f299577q = -i5.o0();
        BottomFloatingButtonType r100 = BottomFloatingButtonType.NONE;
        this.f299584x = r100;
        this.f299585y = r100;
        this.C = new c(this);
    }

    @Override // ld8.n
    public final ImageView G50() {
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        if (r100 == null) goto L7;
        FastScrollButton r101 = r100.f311114e;
        if (r101 == null) goto L7;
        return r101.f315545d;
    L7:
        return null;
    }

    @Override // xa8.a
    public final void mD() {
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        if (r100 == null) goto L9;
        FrameLayout r101 = r100.f311110a;
        if (r101 == null) goto L10;
        float r102 = -i5.o0();
        this.f299577q = r102;
        r101.setTranslationY(r102);
        return;
    L10:
        return;
    }

    public final void z3() {
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        if (r100 == null) goto L6;
        FrameLayout r101 = r100.f311110a;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), 0.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.f311110a, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100.f311111b, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r105 = new AnimatorSet();
        r105.playTogether(new Animator[]{r102, r103, r104});
        r105.setDuration(300);
        r105.addListener(new e(r100, this));
        r105.start();
        this.f299583w = r105;
        return;
    }

    public final void B3(String r110) {
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        boolean r101 = true;
        if (r100 != null) goto L10;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("component_state source=");
        r103.append(r110);
        r103.append(" binding=null currentType=");
        r103.append(this.f299584x);
        r103.append(" lastType=");
        r103.append(this.f299585y);
        r103.append(" forceHide=");
        r103.append(this.A);
        r103.append(" hasFastCallback=");
        if (this.f299579s != null) goto L8;
        r101 = false;
    L8:
        r103.append(r101);
        r102.d("fast-scroll-click-chain", r103.toString());
        return;
    L10:
        View r104 = r100.f311114e.getChildAt(0);
        FLogger r105 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("component_state source=");
        r111.append(r110);
        r111.append(" currentType=");
        r111.append(this.f299584x);
        r111.append(" lastType=");
        r111.append(this.f299585y);
        r111.append(" rootVisible=");
        if (r100.f311110a.getVisibility() != 0) goto L13;
        boolean r112 = true;
    L14:
        r111.append(r112);
        r111.append(" rootAlpha=");
        r111.append(r100.f311110a.getAlpha());
        r111.append(" rootTranslationY=");
        r111.append(r100.f311110a.getTranslationY());
        r111.append(" fastVisible=");
        if (r100.f311114e.getVisibility() != 0) goto L17;
        boolean r113 = true;
    L18:
        r111.append(r113);
        r111.append(" fastAlpha=");
        r111.append(r100.f311114e.getAlpha());
        r111.append(" fastTranslationY=");
        r111.append(r100.f311114e.getTranslationY());
        r111.append(" fastIsShow=");
        r111.append(r100.f311114e.f315546e);
        r111.append(" fastEnabled=");
        r111.append(r100.f311114e.isEnabled());
        r111.append(" fastClickable=");
        r111.append(r100.f311114e.isClickable());
        r111.append(" iconVisible=");
        Boolean r114 = null;
        if (r104 != null) goto L21;
        Boolean r106 = null;
    L26:
        r111.append(r106);
        r111.append(" iconAlpha=");
        if (r104 == null) goto L29;
        Float r107 = Float.valueOf(r104.getAlpha());
    L30:
        r111.append(r107);
        r111.append(" iconEnabled=");
        if (r104 == null) goto L33;
        Boolean r108 = Boolean.valueOf(r104.isEnabled());
    L34:
        r111.append(r108);
        r111.append(" iconClickable=");
        if (r104 == null) goto L37;
        r114 = Boolean.valueOf(r104.isClickable());
    L37:
        r111.append(r114);
        r111.append(" showAnimatorRunning=");
        AnimatorSet r115 = this.f299582v;
        if (r115 != null) goto L40;
    L42:
        boolean r116 = false;
    L43:
        r111.append(r116);
        r111.append(" hideAnimatorRunning=");
        AnimatorSet r117 = this.f299583w;
        if (r117 != null) goto L46;
    L48:
        boolean r118 = false;
    L49:
        r111.append(r118);
        r111.append(" forceHide=");
        r111.append(this.A);
        r111.append(" hasFastCallback=");
        if (this.f299579s != null) goto L53;
        r101 = false;
    L53:
        r111.append(r101);
        r105.d("fast-scroll-click-chain", r111.toString());
        return;
    L46:
        if (r117.isRunning() != true) goto L48;
        r118 = true;
        goto L49
    L40:
        if (r115.isRunning() != true) goto L42;
        r116 = true;
        goto L43
    L33:
        r108 = null;
        goto L34
    L29:
        r107 = null;
        goto L30
    L21:
        if (r104.getVisibility() != 0) goto L23;
        boolean r109 = true;
    L24:
        r106 = Boolean.valueOf(r109);
        goto L26
    L23:
        r109 = false;
        goto L24
    L17:
        r113 = false;
        goto L18
    L13:
        r112 = false;
        goto L14
    }

    public final void C3(boolean r110) {
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        if (r100 == null) goto L10;
        FrameLayout r101 = r100.f311110a;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), this.f299577q});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.f311110a, "alpha", new float[]{0.0f, 1.0f});
        if (r110 == false) goto L7;
        Object r104 = r100.f311112c;
    L8:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r104, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r102, r103, r105});
        r106.setDuration(300);
        r106.addListener(new f(this, r110, r100));
        r106.start();
        this.f299582v = r106;
        return;
    L7:
        r104 = r100.f311114e;
        goto L8
    }

    public final void D3(BottomFloatingButtonType r110) {
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        if (r100 == null) goto L45;
        r100.f311110a.setVisibility(0);
        r100.f311110a.setTranslationY(this.f299577q);
        r100.f311110a.setAlpha(1.0f);
        r100.f311114e.setVisibility(8);
        int r111 = b.f299587a[r110.ordinal()];
        if (r111 != 3) goto L7;
    L35:
        ButtonType r112 = ButtonType.SHARE_LONG_IMAGE;
    L36:
        final BottomFloatingButton r101 = r100.f311111b;
        if (r112 != null) goto L39;
        r101.getClass();
        return;
    L39:
        r101.a();
        FLogger r102 = FLogger.f375446a;
        r102.i("BottomFloatingButton", "firstShowWithAnimation, type:" + r112);
        e1.x(r101);
        r102.i("BottomFloatingButton", "delayAutoHide");
        r101.f299606d.removeCallbacksAndMessages(null);
        r101.f299606d.postDelayed(new com.larus.bmhome.chat.component.bottom.floating.button.a(r101), 5000);
        Object r103 = r101.getParent();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.View");
        View r104 = (View) r103;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r104.getTranslationY(), -i5.o0()});
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r104, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.0f, 1.0f});
        if (r101.f299604b == r112) goto L43;
        r102.i("BottomFloatingButton", "updateContent, type:" + r112);
        r101.f299604b = r112;
        r101.removeAllViews();
        r101.addView(r112.getLayout(r101.getContext()));
    L43:
        AnimatorSet r113 = new AnimatorSet();
        r113.playTogether(new Animator[]{r105, r106, r107});
        r113.setInterpolator(new LinearInterpolator());
        r113.setDuration(300);
        r113.start();
        r101.f299605c = r113;
        return;
    L7:
        if (r111 == 4) goto L35;
        if (r111 != 5) goto L11;
        md8.a r114 = this.C.f299589a;
        if (r114 == null) goto L26;
        CollectFrom r115 = r114.f513424a;
    L27:
        if (r115 != null) goto L29;
        int r116 = -1;
    L30:
        if (r116 == 1) goto L34;
        if (r116 != 2) goto L14;
        r112 = ButtonType.ADD_COLLECT_LIKE;
    L14:
        r112 = null;
        goto L36
    L34:
        r112 = ButtonType.ADD_COLLECT_COPY;
        goto L36
    L29:
        r116 = b.f299588b[r115.ordinal()];
        goto L30
    L26:
        r115 = null;
        goto L27
    L11:
        if (r111 != 6) goto L13;
        md8.a r117 = this.C.f299589a;
        if (r117 == null) goto L18;
        CollectFrom r118 = r117.f513424a;
    L20:
        if (r118 != CollectFrom.LIKE) goto L22;
        r112 = ButtonType.LOOK_LIKE;
        goto L36
    L22:
        r112 = ButtonType.LOOK_COLLECT;
        goto L36
    L18:
        r118 = null;
        goto L20
    L13:
        if (r111 == 10) goto L35;
    }

    @Override // ld8.n
    public final void Dm(boolean r100) {
        B3("resume_fast_scroll_request show=" + r100);
        if (r100 == false) goto L8;
        LarusPageChatBottomFloatingButtonBinding r101 = m3();
        if (r101 == null) goto L9;
        r101.f311110a.setTranslationY(this.f299577q);
        r101.f311110a.setAlpha(1.0f);
        r101.f311114e.setAlpha(1.0f);
        r101.f311110a.setVisibility(0);
        r101.f311114e.setVisibility(0);
        this.f299584x = BottomFloatingButtonType.FAST_SCROLL_BUTTON;
        B3("resume_fast_scroll_applied show=" + r100);
        return;
    L9:
        return;
    }

    @Override // xa8.a
    public final void H9(boolean r100) {
        FLogger.f375446a.d("BottomFloatingButtonComponent", "setForceHide, forceHide = " + r100);
        this.A = r100;
        BottomFloatingButtonType r101 = h3(BottomFloatingButtonAction.SCROLL_DOWN);
        AnimatorSet r102 = this.f299582v;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        this.f299582v = null;
        Y2(r101);
    }

    @Override // ld8.n
    public final void Sc(String r100) {
        FLogger.f375446a.i("BottomFloatingButtonComponent", "guideLookCollectIfNeed, collectId:" + r100);
        E3(CollectFrom.COLLECT, null, r100, BottomFloatingButtonAction.SHOW_LOOK_COLLECT_TIP);
    }

    public final void Y2(BottomFloatingButtonType r110) {
        BottomFloatingButtonType r100 = this.f299584x;
        int[] r101 = b.f299587a;
        boolean r102 = false;
        boolean r111 = true;
        switch(r101[r100.ordinal()]) {
            case 1: goto L76;
            case 2: goto L67;
            case 3: goto L60;
            case 4: goto L51;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L86;
        };
    L22:
        int r103 = r101[r110.ordinal()];
        if (r103 == 5) goto L50;
        if (r103 == 6) goto L50;
        if (r103 != 7) goto L27;
        C3(false);
        goto L86
    L27:
        if (r103 != 9) goto L29;
        u7 r112 = (u7) this.f299575o.getValue();
        if (r112 != null) goto L43;
    L45:
        r111 = false;
    L46:
        if (r111 == false) goto L48;
        r110 = BottomFloatingButtonType.FAST_SCROLL_BUTTON;
        C3(false);
        goto L86
    L48:
        r110 = BottomFloatingButtonType.NONE;
        z3();
        goto L86
    L43:
        if (r112.IS() != true) goto L45;
    L29:
        if (r103 != 10) goto L86;
        u7 r113 = (u7) this.f299575o.getValue();
        if (r113 != null) goto L34;
    L36:
        if (r102 == false) goto L38;
        r110 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON_SCROLLED;
    L39:
        D3(r110);
        goto L86
    L38:
        r110 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON;
        goto L39
    L34:
        if (r113.IS() != true) goto L36;
        r102 = true;
    L50:
        D3(r110);
        goto L86
    L51:
        int r104 = r101[r110.ordinal()];
        if (r104 == 2) goto L57;
        if (r104 == 5) goto L56;
        if (r104 != 6) goto L86;
    L56:
        D3(r110);
        goto L86
    L57:
        final LarusPageChatBottomFloatingButtonBinding r105 = m3();
        if (r105 == null) goto L86;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r105.f311114e, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r105.f311111b, "alpha", new float[]{1.0f, 0.0f});
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{r105.f311111b.getWidth(), i5.s0()});
        r108.addUpdateListener(new ld8.a(r105));
        AnimatorSet r109 = new AnimatorSet();
        r109.playTogether(new Animator[]{r106, r107, r108});
        r109.setDuration(300);
        r109.addListener(new l(r105, this));
        r109.setInterpolator(PathInterpolatorCompat.create(0.45f, 0.45f, 0.8f, 1.0f));
        r109.start();
        this.f299582v = r109;
        goto L86
    L60:
        int r114 = r101[r110.ordinal()];
        if (r114 == 1) goto L66;
        if (r114 == 5) goto L65;
        if (r114 != 6) goto L86;
    L65:
        D3(r110);
        goto L86
    L66:
        z3();
        goto L86
    L67:
        int r115 = r101[r110.ordinal()];
        if (r115 != 1) goto L70;
        p3(false);
        goto L86
    L70:
        if (r115 == 4) goto L74;
        if (r115 == 5) goto L74;
        if (r115 != 6) goto L86;
    L74:
        D3(r110);
        goto L86
    L76:
        int r116 = r101[r110.ordinal()];
        if (r116 == 2) goto L85;
        if (r116 == 3) goto L84;
        if (r116 == 5) goto L84;
        if (r116 == 6) goto L84;
        if (r116 != 7) goto L86;
        C3(true);
    L84:
        D3(r110);
        goto L86
    L85:
        C3(false);
    L86:
        FLogger.f375446a.i("BottomFloatingButtonComponent", "dispatchAnimation: " + this.f299585y + " -> " + this.f299584x + " -> " + r110);
        this.f299585y = this.f299584x;
        this.f299584x = r110;
        return;
    L6:
        switch(r101[r110.ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L86;
            case 8: goto L8;
            default: goto L86;
        };
    L8:
        AnimatorSet r117 = this.B;
        if (r117 != null) goto L11;
    L13:
        boolean r118 = false;
    L14:
        if (r118 == true) goto L86;
        LarusPageChatBottomFloatingButtonBinding r119 = m3();
        if (r119 == null) goto L86;
        r119.f311113d.setBackgroundResource(R.drawable.larus_bg_fast_top_btn);
        TextView r120 = r119.f311115f;
        final LinearLayout r121 = r119.f311112c;
        r120.setVisibility(0);
        r120.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(r121.getHeight(), 1073741824));
        ValueAnimator r122 = ValueAnimator.ofInt(new int[]{r121.getWidth(), ((r120.getMeasuredWidth() + r121.getPaddingLeft()) + r121.getPaddingRight()) + i5.A()});
        r122.setDuration(300);
        r122.setInterpolator(new AccelerateDecelerateInterpolator());
        r122.addUpdateListener(new h(r121));
        r122.addListener(new m(r121));
        AnimatorSet r123 = new AnimatorSet();
        r123.playTogether(new Animator[]{r122});
        r123.start();
        this.B = r123;
        goto L86
    L11:
        if (r117.isRunning() != true) goto L13;
        r118 = true;
        goto L14
    L19:
        D3(r110);
        goto L86
    L20:
        C3(false);
        goto L86
    L21:
        p3(true);
        goto L86
    }

    @Override // ld8.n, xa8.a
    public final void e2(int r100) {
        this.f299577q += r100;
        LarusPageChatBottomFloatingButtonBinding r101 = m3();
        if (r101 == null) goto L8;
        FrameLayout r102 = r101.f311110a;
        if (r102 == null) goto L9;
        r102.setTranslationY(this.f299577q);
        return;
    L9:
        return;
    }

    public final BottomFloatingButtonType h3(BottomFloatingButtonAction r100) {
        BottomFloatingButtonType r101 = D.get(new Pair(this.f299584x, r100));
        if (r101 != null) goto L5;
        r101 = BottomFloatingButtonType.NONE;
    L5:
        FLogger.f375446a.d("BottomFloatingButtonComponent", "findTargetType: action = " + r100 + ", targetType = " + r101);
        return r101;
    }

    @Override // ld8.n
    public final void m60(BottomFloatingButtonAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        BottomFloatingButtonType r101 = h3(r100);
        B3("hide_request action=" + r100 + " target=" + r101);
        if (uo(r101) == false) goto L6;
        B3("hide_skip_already_show action=" + r100 + " target=" + r101);
        return;
    L6:
        AnimatorSet r102 = this.f299582v;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        this.f299582v = null;
        Y2(r101);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ViewStub) == false) goto L6;
        this.f299578r = (ViewStub) r100;
        return;
    }

    public final void p3(boolean r110) {
        LarusPageChatBottomFloatingButtonBinding r100 = m3();
        if (r100 == null) goto L10;
        FrameLayout r101 = r100.f311110a;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), 0.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.f311110a, "alpha", new float[]{1.0f, 0.0f});
        if (r110 == false) goto L7;
        Object r104 = r100.f311112c;
    L8:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r104, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r102, r103, r105});
        r106.setDuration(300);
        r106.addListener(new d(this, r110, r100));
        r106.start();
        this.f299583w = r106;
        return;
    L7:
        r104 = r100.f311114e;
        goto L8
    }

    @Override // ld8.n
    public final boolean uo(BottomFloatingButtonType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (this.f299584x != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ld8.n
    public final void AE(BottomFloatingButtonType r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        FLogger.f375446a.i("fast-scroll-click-chain", "component_register_on_click type=" + r100);
        int r102 = b.f299587a[r100.ordinal()];
        if (r102 != 2) goto L5;
        this.f299579s = r101;
        return;
    L5:
        if (r102 != 3) goto L7;
    L12:
        this.f299586z = r101;
        return;
    L7:
        if (r102 == 4) goto L12;
        if (r102 != 7) goto L17;
        this.f299580t = r101;
        return;
    }

    @Override // ld8.n
    public final boolean Ho(CollectFrom r110, String r210) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Intrinsics.checkNotNullParameter(r210, RemoteMessageConst.MSGID);
        CollectFrom r100 = CollectFrom.LIKE;
        if (r110 == r100) goto L5;
    L10:
        o r101 = (o) this.f299574n.getValue();
        if (r101 != null) goto L13;
    L15:
        boolean r102 = false;
    L16:
        FLogger.f375446a.i("BottomFloatingButtonComponent", "guideAddCollectIfNeed: from=" + r110 + ",msg=" + r210 + ",isCollectionMode:" + r102);
        if (r102 == true) goto L90;
        y r103 = (y) this.f299573m.getValue();
        if (r103 == null) goto L90;
        BotModel r111 = r103.j0();
        if (r111 == null) goto L90;
        y r104 = (y) this.f299573m.getValue();
        if (r104 == null) goto L90;
        wc9.e r112 = r104.h();
        if (r112 == null) goto L90;
        u7 r105 = (u7) this.f299575o.getValue();
        if (r105 == null) goto L90;
        List<Message> r106 = r105.zj();
        if (r106 == null) goto L90;
        Iterator<T> r107 = r106.iterator();
    L34:
        if (r107.hasNext() == false) goto L38;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((Message) r108).getMessageId(), r210) == false) goto L34;
    L39:
        Message r109 = (Message) r108;
        if (r109 == null) goto L90;
        int r113 = md8.b.f513427a;
        Context r114 = getContext();
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "bot");
        Intrinsics.checkNotNullParameter(r112, "conversation");
        Intrinsics.checkNotNullParameter(r109, "msg");
        if (r109.getContentType() == 1) goto L48;
        if (r109.getContentType() == 9999) goto L48;
        t0 r115 = null;
    L64:
        if (r115 == null) goto L66;
        List r116 = t0.a.a(r115, r114, r109, null, null, r111, r112, null, null, 132);
    L67:
        if (r116 == null) goto L82;
        Iterator r117 = r116.iterator();
    L70:
        if (r117.hasNext() == false) goto L80;
        Object r118 = r117.next();
        ot8.a r119 = (ot8.a) r118;
        if (r119.getId() != R.string.larus_collections_tab) goto L74;
    L77:
        boolean r120 = true;
    L78:
        if (r120 == false) goto L70;
    L81:
        ot8.a r121 = (ot8.a) r118;
    L83:
        if (r121 == null) goto L85;
        boolean r122 = true;
    L86:
        FLogger.f375446a.i("GuideCollectExt", "hasCollectMenuItem, msg:" + r109.getMessageId() + ",hasCollectMenuItem:" + r122);
        if (r122 == false) goto L90;
        E3(r110, r109, null, BottomFloatingButtonAction.SHOW_ADD_COLLECT_TIP);
        return true;
    L85:
        r122 = false;
        goto L86
    L74:
        if (r119.getId() == R.id.msg_action_single_collect) goto L77;
        r120 = false;
        goto L78
    L80:
        r118 = null;
        goto L81
    L82:
        r121 = null;
        goto L83
    L66:
        r116 = null;
    L48:
        if (com.larus.bmhome.chat.bean.d.z0(r109) == false) goto L54;
        if (com.larus.bmhome.chat.bean.d.Q0(r109) == false) goto L52;
        t0 r123 = new q1();
    L63:
        r115 = r123;
        goto L64
    L52:
        r123 = new m0(null);
        goto L63
    L54:
        if (com.larus.bmhome.chat.bean.d.G0(r109) == false) goto L57;
        r123 = new u2();
        goto L63
    L57:
        if (com.larus.bmhome.chat.bean.d.y0(r109) == false) goto L60;
        r123 = new t();
        goto L63
    L60:
        if (com.larus.bmhome.chat.bean.d.Q0(r109) == false) goto L62;
        r123 = new q1();
        goto L63
    L62:
        r123 = new m0(null);
        goto L63
    L38:
        r108 = null;
    L90:
        return false;
    L13:
        if (r101.i0() != true) goto L15;
        r102 = true;
        goto L16
    L5:
        if (z1.f365863a.d() == true) goto L7;
        boolean r124 = false;
    L8:
        if (r124 == false) goto L10;
        return true;
    L7:
        FLogger.f375446a.i("BottomFloatingButtonComponent", "guideLookLikeIfNeed");
        E3(r100, null, null, BottomFloatingButtonAction.SHOW_LOOK_COLLECT_TIP);
        r124 = true;
        goto L8
    }

    @Override // ld8.n
    public final void Ib(BottomFloatingButtonAction r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        BottomFloatingButtonType r102 = h3(r100);
        B3("show_request action=" + r100 + " target=" + r102 + " isForce=" + r101);
        if (this.A == false) goto L6;
        B3("show_drop_force_hide action=" + r100 + " target=" + r102);
        return;
    L6:
        if (r101 == false) goto L8;
    L11:
        AnimatorSet r103 = this.f299583w;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        this.f299583w = null;
        Y2(r102);
        return;
    L8:
        if (uo(r102) == false) goto L11;
        B3("show_skip_already_show action=" + r100 + " target=" + r102);
    }

    public final void E3(CollectFrom r100, Message r101, String r102, BottomFloatingButtonAction r103) {
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("showGuideCollectTip: from:");
        r105.append(r100);
        r105.append(",msg:");
        if (r101 == null) goto L5;
        String r106 = r101.getMessageId();
    L6:
        r105.append(r106);
        r105.append(",collectId:");
        r105.append(r102);
        r105.append(",action:");
        r105.append(r103);
        r104.i("BottomFloatingButtonComponent", r105.toString());
        c r107 = this.C;
        md8.a r108 = new md8.a(r100, r101, r102);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "data");
        r107.f299589a = r108;
        Ib(r103, true);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
