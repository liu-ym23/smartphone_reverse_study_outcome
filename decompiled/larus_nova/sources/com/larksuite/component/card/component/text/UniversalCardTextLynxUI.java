package com.larksuite.component.card.component.text;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.lark.pb.openplatform.v1.GetUuidRequest;
import com.google.gson.Gson;
import com.larksuite.component.card.action.InteractiveHandler;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.light.touch.TouchConsumeView;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0007J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u000108H\u0016J \u00109\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=J\u001a\u0010>\u001a\u00020\u000e2\u0006\u00104\u001a\u0002052\b\u0010?\u001a\u0004\u0018\u000102H\u0002J\b\u0010@\u001a\u00020\u000eH\u0002J\b\u0010A\u001a\u00020\u0010H\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020FH\u0002J\u0018\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u0017H\u0002J\u000e\u0010J\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020-J\b\u0010K\u001a\u00020\u001dH\u0002J\b\u0010L\u001a\u00020\u001dH\u0002J\u0010\u0010M\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020-H\u0002J\u001e\u0010N\u001a\u00020\u001d2\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020Q\u0018\u00010PH\u0016J\u0010\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\bH\u0002J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0017H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006X"}, d2 = {"Lcom/larksuite/component/card/component/text/UniversalCardTextLynxUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/text/UniversalCardLightTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "currentSelectionInfo", "Lcom/ss/android/lark/widget/select/SelectedTextInfo;", "selectionHelper", "Lcom/ss/android/lark/widget/select/TextSelectHelper;", "interactiveHandler", "Lcom/larksuite/component/card/action/InteractiveHandler;", "enableShowMore", "", "selectCopyWindow", "Landroid/widget/PopupWindow;", "getSelectCopyWindow", "()Landroid/widget/PopupWindow;", "selectCopyWindow$delegate", "Lkotlin/Lazy;", "previewImages", "", "", "checker", "Lcom/ss/android/lark/widget/listener/DuplicateEnterChecker;", "createView", "Landroid/content/Context;", "updateExtraData", "", ControlRule.KEY_EXTRA_DATA, "", RXScreenCaptureService.KEY_CONTENT_TEXT, "getContentText", "()Ljava/lang/String;", "setContentText", "(Ljava/lang/String;)V", "setContent", SlcElement.KEY_PROPS, "Lcom/lynx/react/bridge/ReadableMap;", "setPreviewImages", "images", "Lcom/lynx/react/bridge/ReadableArray;", "updateView", "textContent", "Lcom/larksuite/component/card/component/text/TextProps;", "resetView", "resetSelection", "disableNativeClick", "getCurrentShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "initListener", "textView", "Lcom/ss/android/lark/widget/light/LKUILightTextView;", "dispatchEvent", "event", "Lcom/lynx/tasm/event/LynxEventDetail;", "doCopyText", "copyText", "", "token", "Lcom/bytedance/supervisor/token/Token;", "enableCopy", "cardShareData", "inDetailPage", "prepareSelectionWindow", "handleSelectionWindowDismiss", "handleSelectionTextCopy", "handleUrlClick", "urlInfo", "Lcom/ss/android/lark/widget/span/UrlInfo;", "handleAudioClick", "tag", "id", "setImageClickListener", "disableAtClick", "disableLinkClick", "setBaseStyle", "setEvents", "events", "", "Lcom/lynx/tasm/event/EventsListener;", "handleTextSelect", "info", "parseTextAlign", "", "textAlign", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardTextLynxUI extends LynxUI<UniversalCardLightTextView> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f283581g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.widget.select.g f283582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.widget.select.m f283583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InteractiveHandler f283584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f283585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f283586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final rcc.a f283587f;

    public static final class a {
    }

    static {
    }

    public final void Q() {
        T r100 = this.mView;
        if (r100 == 0) goto L5;
        ((UniversalCardLightTextView) r100).setUseOuterLayout(true);
        UniversalCardLightTextView r101 = (UniversalCardLightTextView) this.mView;
        r101.setSpacingExtra(UIUtils.dp2px(r101.getContext(), 4.0f));
        ((UniversalCardLightTextView) this.mView).setEllipsize(TextUtils.TruncateAt.END);
        ((UniversalCardLightTextView) this.mView).setTextSize(UIUtils.dp2px(this.mContext.getContext(), 14.0f));
        LKUILightTextView r102 = (LKUILightTextView) this.mView;
        r102.setUrlSpanClickListener(new k(this));
        r102.setAtSpanClickListener(new l(this));
        r102.setOnClickListener(m.f283657a);
        r102.setOnLongClickListener(new n(this, r102));
        r102.setCodeBlockV2SpanCLickListener(new o(r102));
        r102.setPersonSpanClickListener(new p(this));
        r102.setCardSpanClickListener(new q(this));
        ((UniversalCardLightTextView) this.mView).setGravity(3);
    L5:
        com.ss.android.lark.widget.select.m r103 = this.f283583b;
        if (r103 == null) goto L8;
        r103.a();
    L8:
        com.ss.android.lark.widget.select.m r104 = this.f283583b;
        if (r104 == null) goto L12;
        r104.h();
        return;
    }

    public final com.larksuite.component.card.cardcontainer.c O() {
        return (com.larksuite.component.card.cardcontainer.c) getLynxContext().getSharedData("card_share_data", com.larksuite.component.card.cardcontainer.c.class);
    }

    public UniversalCardTextLynxUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f283584c = new InteractiveHandler();
        this.f283585d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UniversalCardTextLynxUI$selectCopyWindow$2(this));
        this.f283586e = new ArrayList();
        this.f283587f = new rcc.a();
    }

    public static final /* synthetic */ LynxContext M(UniversalCardTextLynxUI r100) {
        return r100.mContext;
    }

    public static final /* synthetic */ View N(UniversalCardTextLynxUI r100) {
        return r100.mView;
    }

    public final void P(final UrlInfo r100) {
        if (this.f283587f.a() == false) goto L6;
        Log.e("UniversalCardTextLynxUI", "url check isDuplicate: " + r100.href.hashCode());
        return;
    L6:
        final com.larksuite.component.card.cardcontainer.c r101 = O();
        if (r101 != null) goto L10;
        Log.e("UniversalCardTextLynxUI", "cardShareData null");
        return;
    L10:
        int r102 = com.larksuite.component.card.monitor.a.f283717a;
        com.larksuite.component.card.monitor.a.c(r101.f283234b.getVersion(), "markdown", r100.href, r101.f283235c.getMonitorData(), r101.f283234b.getCardID());
        Context r103 = this.mContext.getContext();
        String r104 = r100.href;
        if (TextUtils.isEmpty(r104) == false) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L19;
        Log.e("UniversalCardTextLynxUI", "url check interceptUrl: " + r100.href.hashCode());
        return;
    L19:
        CardDataUtils r106 = CardDataUtils.f283938a;
        Function1<String, Unit> r107 = new UniversalCardTextLynxUI$handleUrlClick$1(this, r100, r101);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "callback");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.larksuite.component.card.utils.b(new GetUuidRequest.Builder(), r107));
        return;
    L13:
        if (r104.toLowerCase().startsWith("lark://msgcard/unsupported_action") == false) goto L15;
        LKUIToast.show(r103, R.string.Lark_Legacy_MsgCardUnsupportedActionMobile);
        r105 = true;
        goto L16
    }

    public final void R(TextProps r110) {
        if (r110 != null) goto L7;
        Log.e("UniversalCardTextLynxUI", "setContent fail, content is empty");
        return;
    L7:
        if (r110.getPaddingLeft() == null) goto L9;
    L14:
        UniversalCardLightTextView r100 = (UniversalCardLightTextView) this.mView;
        Context r101 = this.mContext.getContext();
        Integer r102 = r110.getPaddingLeft();
        float r103 = 0.0f;
        if (r102 == null) goto L17;
        float r104 = r102.intValue();
    L18:
        int r105 = UIUtils.dp2px(r101, r104);
        Context r106 = this.mContext.getContext();
        Integer r107 = r110.getPaddingTop();
        if (r107 == null) goto L21;
        float r108 = r107.intValue();
    L22:
        int r109 = UIUtils.dp2px(r106, r108);
        Context r111 = this.mContext.getContext();
        Integer r112 = r110.getPaddingRight();
        if (r112 == null) goto L25;
        float r113 = r112.intValue();
    L26:
        int r114 = UIUtils.dp2px(r111, r113);
        Context r115 = this.mContext.getContext();
        Integer r116 = r110.getPaddingBottom();
        if (r116 == null) goto L29;
        r103 = r116.intValue();
    L29:
        r100.setPadding(r105, r109, r114, UIUtils.dp2px(r115, r103));
    L30:
        String r117 = r110.getBgColor();
        int r118 = 0;
        if (r117 != null) goto L33;
    L44:
        String r119 = r110.getTextColor();
        if (r119 == null) goto L59;
        if (r119.length() <= 0) goto L49;
        boolean r120 = true;
    L50:
        if (r120 == true) goto L53;
        r119 = null;
    L53:
        if (r119 == null) goto L59;
        ((UniversalCardLightTextView) this.mView).setTextColor(Color.parseColor(r119));     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        Log.e("UniversalCardTextLynxUI", "textColor parseColor failed", th);
        goto L59
    L49:
        r120 = false;
    L59:
        if (TextUtils.isEmpty(r110.getAlign()) == false) goto L61;
    L99:
        UniversalCardLightTextView r121 = (UniversalCardLightTextView) this.mView;
        Float r122 = r110.getLineSpacing();
        if (r122 == null) goto L102;
        float r123 = r122.floatValue();
    L103:
        r121.setSpacingExtra(r123);
        Boolean r124 = r110.getAtClickable();
        Boolean r125 = Boolean.FALSE;
        if (Intrinsics.areEqual(r124, r125) == false) goto L107;
        ((UniversalCardLightTextView) this.mView).setAtSpanClickListener(new h());
    L107:
        if (Intrinsics.areEqual(r110.getLinkClickable(), r125) == false) goto L110;
        ((UniversalCardLightTextView) this.mView).setUrlSpanClickListener(new i());
    L110:
        if (Intrinsics.areEqual(r110.getAtClickable(), r125) == false) goto L112;
    L113:
        UniversalCardLightTextView r126 = (UniversalCardLightTextView) this.mView;
        if (r126 == null) goto L116;
        r126.setOnClickListener(null);
    L116:
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        ((UniversalCardLightTextView) this.mView).setImageSpanClickListener(new t(this, r110));
        return;
    L112:
        if (Intrinsics.areEqual(r110.getLinkClickable(), r125) == false) goto L116;
    L102:
        r123 = UIUtils.dp2px(((UniversalCardLightTextView) this.mView).getContext(), 4.0f);
        goto L103
    L61:
        if (r110.getAlign() == null) goto L99;
        UniversalCardLightTextView r127 = (UniversalCardLightTextView) this.mView;
        String r128 = r110.getAlign();
        if (TextUtils.isEmpty(r128) == true) goto L97;
        String[] r129 = (String[]) StringsKt.split$default(r128, new String[]{"\\|"}, false, 0, 6, null).toArray(new String[0]);
        if (r129.length != 0) goto L67;
        boolean r130 = true;
    L69:
        if ((true ^ r130) == false) goto L97;
        int r131 = r129.length;
        int r132 = 0;
    L71:
        if (r118 >= r131) goto L95;
        String r133 = r129[r118];
        if (TextUtils.isEmpty(r133) == true) goto L75;
        r133 = r133.toLowerCase(Locale.ROOT);
    L75:
        int r134 = r133.hashCode();
        if (r134 == (-1364013995)) goto L91;
        if (r134 == 3317767) goto L87;
        if (r134 != 108511772) goto L94;
        if (r133.equals("right") == false) goto L94;
        r132 = r132 | 5;
    L94:
        r118 = r118 + 1;
        goto L71
    L87:
        if (r133.equals("left") == false) goto L94;
        r132 = r132 | 3;
        goto L94
    L91:
        if (r133.equals("center") == false) goto L94;
        r132 = r132 | 1;
        goto L94
    L95:
        if (r132 == 0) goto L97;
    L98:
        r127.setGravity(r132);
        goto L99
    L67:
        r130 = false;
    L97:
        r132 = 3;
        goto L98
    L33:
        if (r117.length() <= 0) goto L35;
        boolean r135 = true;
    L36:
        if (r135 == true) goto L39;
        r117 = null;
    L39:
        if (r117 == null) goto L44;
        ((UniversalCardLightTextView) this.mView).setBackgroundColor(Color.parseColor(r117));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        Log.e("UniversalCardTextLynxUI", "setBackgroundColor parseColor failed", th);
        goto L44
    L35:
        r135 = false;
        goto L36
    L25:
        r113 = 0.0f;
        goto L26
    L21:
        r108 = 0.0f;
        goto L22
    L17:
        r104 = 0.0f;
        goto L18
    L9:
        if (r110.getPaddingRight() != null) goto L14;
        if (r110.getPaddingTop() != null) goto L14;
        if (r110.getPaddingBottom() == null) goto L30;
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new UniversalCardLightTextView(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchEvent(LynxEventDetail r100) {
        T r101 = this.mView;
        if (((UniversalCardLightTextView) r101) == null) goto L41;
        boolean r102 = r101 instanceof LKUILightTextView;
        Integer r103 = null;
        if (r100 == null) goto L7;
        String r104 = r100.f383319a.getName();
    L9:
        if (TextUtils.equals(r104, "tap") == false) goto L41;
        UniversalCardLightTextView r105 = (UniversalCardLightTextView) this.mView;
        if (r100 == null) goto L13;
        Integer r106 = Integer.valueOf((int) r100.a().f383322a);
    L14:
        if (r100 == null) goto L16;
        r103 = Integer.valueOf((int) r100.a().f383323b);
    L16:
        r105.getClass();
        boolean r107 = false;
        if (r106 == null) goto L42;
        if (r103 == null) goto L46;
        Layout r108 = r105.U;
        if (r108 != null) goto L23;
        return false;
    L23:
        if ((r108.getText() instanceof Spanned) == false) goto L44;
        TouchConsumeView.c r109 = r105.W;
        int r110 = r106.intValue();
        int r111 = r103.intValue();
        CharSequence r112 = r108.getText();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r113 = (Spanned) r112;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r105, "widget");
        Intrinsics.checkNotNullParameter(r108, "layout");
        Intrinsics.checkNotNullParameter(r113, "buffer");
        int r114 = TouchConsumeView.c.b(r105, r108, r110, r111);
        ClickableSpan[] r115 = (ClickableSpan[]) r113.getSpans(r114, r114, ClickableSpan.class);
        if (r115 == null) goto L36;
        if (r115.length != 0) goto L29;
        boolean r116 = true;
    L31:
        if ((!r116) == false) goto L36;
        if (TouchConsumeView.c.a(r114, r115[0], r113) == false) goto L36;
        Log.d("TouchConsumeView", "currentLocationIsProcess return false, offset is " + r114);
        return false;
    L29:
        r116 = false;
    L36:
        if (r115.length != 0) goto L39;
        r107 = true;
    L39:
        return !r107;
    L44:
        return false;
    L46:
        return false;
    L42:
        return false;
    L13:
        r106 = null;
        goto L14
    L7:
        r104 = null;
    L41:
        return super.dispatchEvent(r100);
    }

    @LynxProp(name = SlcElement.KEY_PROPS)
    public final void setContent(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        TraceEvent.beginSection("UniversalCardTextLynxUI.setContent");
        if (UniversalCardTextPerfOpt.a() == true) goto L10;
        Q();
        Gson r101 = com.larksuite.component.card.component.g.f283368a;     // Catch: Throwable -> L7
        TextProps r102 = (TextProps) com.larksuite.component.card.component.g.c(r100, TextProps.class);     // Catch: Throwable -> L7
    L9:
        R(r102);
    L7:
        th = move-exception;
        Log.e("UniversalCardTextLynxUI", "props from lynx transform failed", th);
        r102 = null;
    L10:
        TraceEvent.endSection("UniversalCardTextLynxUI.setContent");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L6;
        r100.containsKey("isNeedShowMore");
        return;
    }

    @LynxProp(name = "previewImages")
    public final void setPreviewImages(ReadableArray r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L10;
        int r102 = r100.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        String r104 = r100.getString(r103);
        if (r104 == null) goto L9;
        r101.add(r104);
    L9:
        r103 = r103 + 1;
    L10:
        ((ArrayList) this.f283586e).clear();
        ((ArrayList) this.f283586e).addAll(r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r100) {
        if ((r100 instanceof c) == true) goto L5;
        return;
    L5:
        if (UniversalCardTextPerfOpt.a() == false) goto L7;
        Q();
        R(((c) r100).f283609a);
    L7:
        c r101 = (c) r100;
        int r102 = r101.f283611c;
        if (r102 == 0) goto L11;
        ((UniversalCardLightTextView) this.mView).setTextColor(r102);
    L11:
        if (Intrinsics.areEqual(r101.f283610b, ((UniversalCardLightTextView) this.mView).getLayout()) == true) goto L13;
        Log.d("UniversalCardTextLynxUI", "setContentLayout: null");
    L13:
        int r103 = r101.f283612d;
        if (r103 <= 0) goto L16;
        ((UniversalCardLightTextView) this.mView).setPadding(getView().getPaddingLeft(), r103, getView().getPaddingRight(), r103);
    L16:
        ((UniversalCardLightTextView) this.mView).setLayout(r101.f283610b);
    }
}
