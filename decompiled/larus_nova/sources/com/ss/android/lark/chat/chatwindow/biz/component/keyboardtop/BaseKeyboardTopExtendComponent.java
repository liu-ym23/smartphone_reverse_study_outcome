package com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.chat_window.keyboard_top.ExtendType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.scaffold.UiComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.view.SizeDetectConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\"H\u0016J\"\u0010-\u001a\u00020(2\u0006\u0010,\u001a\u00020\"2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010-\u001a\u00020(2\u0006\u0010,\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00101\u001a\u00020(2\u0006\u0010,\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020(H\u0016J\b\u00103\u001a\u00020(H\u0016J5\u00104\u001a\u00020(2+\u00105\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\"07¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020(06j\u0002`;H\u0002J\b\u0010<\u001a\u00020(H\u0016J\b\u0010=\u001a\u00020(H\u0016J\b\u0010>\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020#H\u0016J\b\u0010A\u001a\u00020#H\u0016J\u0010\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\u001dH\u0016J\b\u0010D\u001a\u00020(H\u0016J\r\u0010E\u001a\u00020#H\u0016¢\u0006\u0002\u0010FJ\u001c\u0010G\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020J0I\u0012\u0004\u0012\u00020J0HH\u0016J\b\u0010@\u001a\u00020#H\u0016J\u0010\u0010K\u001a\u00020(2\u0006\u0010C\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020(2\u0006\u0010C\u001a\u00020LH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020&0!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardtop/BaseKeyboardTopExtendComponent;", "Lcom/ss/android/lark/scaffold/UiComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardtop/IKeyboardTopExtendComponent;", "<init>", "()V", "lockKeyboardTopZone", "", "mTimeZoneContainer", "Landroid/view/ViewGroup;", "getMTimeZoneContainer", "()Landroid/view/ViewGroup;", "setMTimeZoneContainer", "(Landroid/view/ViewGroup;)V", "mButtonExtendContainer", "Landroid/widget/FrameLayout;", "getMButtonExtendContainer", "()Landroid/widget/FrameLayout;", "setMButtonExtendContainer", "(Landroid/widget/FrameLayout;)V", "mTextExtendContainer", "getMTextExtendContainer", "setMTextExtendContainer", "mRootLayout", "Lcom/ss/android/lark/view/SizeDetectConstraintLayout;", "getMRootLayout", "()Lcom/ss/android/lark/view/SizeDetectConstraintLayout;", "setMRootLayout", "(Lcom/ss/android/lark/view/SizeDetectConstraintLayout;)V", "mListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardtop/KeyboardExtendsManager$OnExtendStatusChangeListener;", "timeZoneAnimationPlayer", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardtop/IKeyboardTopExtendComponent$ITimeZoneAnimationPlayer;", "buttonProperties", "", "Lcom/ss/android/lark/biz/im/extension/chat_window/keyboard_top/ExtendType;", "", "textProperties", "extendManagerMap", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardtop/KeyboardExtendsManager;", "registerKeyboardTopExtend", "", GXTemplateKey.GAIAX_EXTEND, "Lcom/ss/android/lark/biz/im/extension/chat_window/keyboard_top/IKeyboardTopExtend;", "unRegisterKeyboardTopExtend", "type", "showExtend", "data", "Lcom/ss/android/lark/biz/im/extension/chat_window/keyboard_top/IKeyboardExtendData;", "animationPlayer", "hideExtend", "showKeyboardExtend", "hideKeyboardExtend", "onExtendVisibilityChanged", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "typeList", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardtop/OnExtendVisibilityChangedAction;", "showKeyboardTopContainer", "hideKeyboardTopContainer", "getTimeZone", "changeBottomMargin", "height", "getBottomMargin", "setOnKeyboardExtendStatusChangeListener", "listener", WidgetCostModule.TYPE_ON_CREATE, "getLayoutResId", "()Ljava/lang/Integer;", "provideWidgetExport", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "addOnExtendSizeChangedListener", "Lcom/ss/android/lark/widget/listener/OnSizeChangeListener;", "removeOnExtendSizeChangedListener", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseKeyboardTopExtendComponent extends UiComponent implements IKeyboardTopExtendComponent {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f412101l = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<ExtendType, Integer> f412102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<ExtendType, Integer> f412103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Integer, com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a> f412104k;

    @BindView(9733)
    public FrameLayout mButtonExtendContainer;

    @BindView(11066)
    public SizeDetectConstraintLayout mRootLayout;

    @BindView(11356)
    public FrameLayout mTextExtendContainer;

    @BindView(10161)
    public ViewGroup mTimeZoneContainer;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a.b {
        public b() {
        }
    }

    public static final class c implements com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a.b {
        public c() {
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.IKeyboardTopExtendComponent
    public final void Id() {
        com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a r100 = (com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a) ((LinkedHashMap) this.f412104k).get(0);
        com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a r101 = (com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a) ((LinkedHashMap) this.f412104k).get(1);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.IKeyboardTopExtendComponent
    public final void fb() {
        View r100 = this.f425740e;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        C0(new BaseKeyboardTopExtendComponent$hideKeyboardExtend$1(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.IKeyboardTopExtendComponent
    public final void gt() {
        FrameLayout r100 = this.mTextExtendContainer;
        FrameLayout r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTextExtendContainer");
        r100 = null;
    L6:
        r100.setVisibility(8);
        FrameLayout r102 = this.mButtonExtendContainer;
        if (r102 == null) goto L9;
        r101 = r102;
    L10:
        r101.setVisibility(8);
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("mButtonExtendContainer");
        goto L10
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.IKeyboardTopExtendComponent
    public final void wC() {
        View r100 = this.f425740e;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        C0(new BaseKeyboardTopExtendComponent$showKeyboardExtend$1(this));
    }

    @Override // com.ss.android.lark.scaffold.Component, com.ss.android.lark.framework.larkwidget.Widget
    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(IKeyboardTopExtendComponent.class, this));
    }

    public BaseKeyboardTopExtendComponent() {
        this.f412102i = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ExtendType.TEAM, 19), TuplesKt.to(ExtendType.TODO, 18), TuplesKt.to(ExtendType.ON_CALL, 17), TuplesKt.to(ExtendType.TOOL_KIT, 16), TuplesKt.to(ExtendType.UNKNOWN, 0)});
        this.f412103j = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ExtendType.SCHEDULE_SEND, 19), TuplesKt.to(ExtendType.TIME_ZONE, 18)});
        this.f412104k = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public void onCreate() {
        super.onCreate();
        PerfLog.start("keyboard_extend_init", "");
        View r100 = this.f425740e;
        if (r100 == null) goto L20;
        ButterKnife.bind(this, r100);
        Map<ExtendType, Integer> r101 = this.f412102i;     // Catch: Exception -> L16
        Context r102 = B0();     // Catch: Exception -> L16
        FrameLayout r103 = this.mButtonExtendContainer;     // Catch: Exception -> L16
        FrameLayout r104 = null;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mButtonExtendContainer");     // Catch: Exception -> L16
        r103 = null;
    L9:
        this.f412104k.put(1, new com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a(r101, r102, r103, new b()));     // Catch: Exception -> L16
        Map<ExtendType, Integer> r105 = this.f412103j;     // Catch: Exception -> L16
        Context r106 = B0();     // Catch: Exception -> L16
        FrameLayout r107 = this.mTextExtendContainer;     // Catch: Exception -> L16
        if (r107 == null) goto L12;
        r104 = r107;
    L13:
        this.f412104k.put(0, new com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a(r105, r106, r104, new c()));     // Catch: Exception -> L16
        PerfLog.end("keyboard_extend_init", "");
        return;
    L12:
        Intrinsics.throwUninitializedPropertyAccessException("mTextExtendContainer");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.e("KeyboardTopExtend", "init keyboard_extend crash", e, true);
        throw e;
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final Integer r0() {
        return Integer.valueOf(R.layout.chat_window_component_keyboard_top_extend);
    }

    public final void C0(Function1<? super List<? extends ExtendType>, Unit> r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((LinkedHashMap) this.f412104k).values().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        ((com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a) r102.next()).getClass();
        goto L4
    L7:
        if ((!r101.isEmpty()) == false) goto L11;
        r100.invoke(r101);
        return;
    }
}
