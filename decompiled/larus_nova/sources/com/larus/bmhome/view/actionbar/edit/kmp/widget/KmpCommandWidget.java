package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import bt8.k;
import bt8.l;
import bt8.m;
import bt8.n;
import bt8.o;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.actionbar.model.c;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetKmpCommandBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.i;
import cq8.z0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t1a.b;
import v19.h;
import v19.i5;
import wa8.b0;
import wa8.c0;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001cH\u0014J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u000f\u0010&\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002J\u001f\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020+H\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020+H\u0002J\u000f\u00102\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0002\u00104J\u0012\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0012\u00108\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpCommandWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedColor", "unselectedColor", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetKmpCommandBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/CommandDescriptor;", "hasReportShow", "", "hasAddedCalendarPermissionObserver", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", ChameleonOpenTracker.Stage.RENDER, "renderSelection", "renderIcon", "commandOption", "Lcom/larus/bmhome/actionbar/model/ActionBarCommandOption;", "trackCommandShowOnce", "doReportShow", "trackCommandClick", "calculateShowPosition", "()Ljava/lang/Integer;", "findMultiRowContainer", "Landroid/widget/LinearLayout;", "rowParent", "Landroid/view/ViewGroup;", "calculatePositionInMultiRow", "multiRowContainer", "(Landroid/widget/LinearLayout;Landroid/view/ViewGroup;)Ljava/lang/Integer;", "countCommandWidgets", SlcFlexDirection.FLEX_ROW, "indexOfCommandWidgetInRow", "getConversationIdAsLong", "", "()Ljava/lang/Long;", "isPodcastOptionCommand", "command", "", "renderCommandVisibilityIfNeeded", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpCommandWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f316608m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f316609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f316610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f316611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetKmpCommandBinding f316612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f316613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f316614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f316615l;

    public static final class a {
    }

    static {
    }

    public KmpCommandWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpCommandWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final y getChatConversationAbility() {
        return (y) this.f316611h.getValue();
    }

    private final Long getConversationIdAsLong() {
        y r100 = getChatConversationAbility();
        if (r100 == null) goto L5;
        String r101 = r100.Y1();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return StringsKt.toLongOrNull(r101);
    L5:
        r101 = null;
        goto L6
    }

    public final Integer Z5() {
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        if ((r101 instanceof LinearLayout) == false) goto L28;
        ViewParent r102 = ((LinearLayout) r101).getParent();
        if ((r102 instanceof LinearLayout) == false) goto L14;
        LinearLayout r103 = (LinearLayout) r102;
    L15:
        if (r103 == null) goto L28;
        Iterator<View> r104 = ViewGroupKt.getChildren(r103).iterator();
        int r105 = 0;
    L19:
        if (r104.hasNext() == false) goto L26;
        if ((r104.next() instanceof LinearLayout) == false) goto L19;
        r105 = r105 + 1;
        if (r105 >= 0) goto L19;
        CollectionsKt.throwCountOverflow();
        goto L19
    L26:
        if (r105 < 2) goto L28;
    L29:
        if (r103 == null) goto L57;
        Iterator<View> r106 = ViewGroupKt.getChildren(r103).iterator();
        int r107 = 0;
    L32:
        if (r106.hasNext() == false) goto L89;
        View r108 = r106.next();
        if ((r108 instanceof LinearLayout) == false) goto L32;
        if (r108 == r101) goto L36;
        Iterator<View> r109 = ViewGroupKt.getChildren((ViewGroup) r108).iterator();
        int r110 = 0;
    L49:
        if (r109.hasNext() == false) goto L55;
        if ((r109.next() instanceof KmpCommandWidget) == false) goto L49;
        r110 = r110 + 1;
        if (r110 >= 0) goto L49;
        CollectionsKt.throwCountOverflow();
        goto L49
    L55:
        r107 = r107 + r110;
        goto L32
    L36:
        Iterator<View> r111 = ViewGroupKt.getChildren((ViewGroup) r108).iterator();
        int r112 = -1;
        int r113 = -1;
    L38:
        if (r111.hasNext() == false) goto L44;
        View r114 = r111.next();
        if ((r114 instanceof KmpCommandWidget) == false) goto L38;
        r113 = r113 + 1;
        if (r114 != this) goto L38;
        r112 = r113;
    L44:
        if (r112 >= 0) goto L56;
        return null;
    L56:
        return Integer.valueOf((r107 + r112) + 1);
    L89:
        return null;
    L57:
        int r115 = r101.indexOfChild(this);
        if (r115 >= 0) goto L61;
        return null;
    L61:
        return Integer.valueOf(r115 + 1);
    L14:
        r103 = null;
    L28:
        r103 = null;
        goto L29
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r11v8, types: [bt8.l] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r110) {
        Intrinsics.checkNotNullParameter(r110, "descriptor");
        Object r100 = null;
        if ((r110 instanceof i) == true) goto L5;
        r110 = null;
    L5:
        i r111 = (i) r110;
        if (r111 == null) goto L207;
        Intrinsics.checkNotNullParameter(r111, "descriptor");
        this.f316613j = r111;
        c r101 = r111.f464850f;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r102 = this.f316612i;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L11:
        AppCompatTextView r103 = r102.f351583d;
        if (r101 == null) goto L14;
        String r104 = r101.f295019b;
    L15:
        if (r104 != null) goto L17;
        r104 = "";
    L17:
        r103.setText(r104);
        c r105 = r111.f464850f;
        boolean r106 = false;
        if (r105 == null) goto L25;
        Integer r107 = r105.f295026i;
        if (r107 == null) goto L25;
        if (r107.intValue() != 1) goto L25;
        boolean r108 = true;
    L26:
        if (r108 == true) goto L28;
    L30:
        boolean r109 = false;
    L31:
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r112 = this.f316612i;
        if (r112 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L34:
        r112.f351580a.setSelected(r109);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r113 = this.f316612i;
        if (r113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L37:
        AppCompatTextView r114 = r113.f351583d;
        if (r109 == false) goto L40;
        int r115 = this.f316609f;
    L41:
        r114.setTextColor(r115);
        b r116 = getVContext();
        if (r116 == null) goto L44;
        com.larus.bmhome.chat.component.immerse.a r117 = (com.larus.bmhome.chat.component.immerse.a) r116.getAbility(com.larus.bmhome.chat.component.immerse.a.class);
    L45:
        if (r117 != null) goto L47;
    L49:
        boolean r118 = false;
    L50:
        boolean r119 = h.f552477a;
        if (h.b(getContext()) == true) goto L55;
        if (r118 == true) goto L55;
        boolean r120 = false;
    L56:
        if (r120 == false) goto L61;
        if (r101 == null) goto L65;
        g1 r121 = r101.f295023f;
        if (r121 == null) goto L65;
        String r122 = r121.f295156b;
    L66:
        if (r120 == false) goto L71;
        if (r101 == null) goto L75;
        g1 r123 = r101.f295025h;
        if (r123 == null) goto L75;
        String r124 = r123.f295156b;
    L76:
        if (r122 != null) goto L78;
    L81:
        boolean r125 = true;
    L83:
        if (r125 == false) goto L88;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r126 = this.f316612i;
        if (r126 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L87:
        e1.o(r126.f351581b);
    L95:
        if (r124 != null) goto L97;
    L100:
        boolean r127 = true;
    L102:
        if (r127 == false) goto L124;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r128 = this.f316612i;
        if (r128 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L106:
        e1.o(r128.f351582c);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r129 = this.f316612i;
        if (r129 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L109:
        AppCompatTextView r130 = r129.f351583d;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
        if (r131 == null) goto L123;
        ViewGroup.MarginLayoutParams r132 = (ViewGroup.MarginLayoutParams) r131;
        if (r122 != null) goto L114;
    L117:
        boolean r133 = true;
    L118:
        if (r133 == false) goto L120;
        int r134 = i5.m();
    L121:
        r132.setMarginStart(r134);
        r132.setMarginEnd(i5.m());
        r130.setLayoutParams(r132);
    L151:
        if (r101 != null) goto L153;
    L155:
        if (r106 == true) goto L157;
    L171:
        if (r101 == null) goto L173;
        String r135 = r101.f295021d;
    L175:
        if (Intrinsics.areEqual(r135, "sync_calendar") == false) goto L208;
        final ?? r136 = new l(this);
        if (((Boolean) r136.invoke()).booleanValue() == false) goto L180;
        FLogger.f375446a.d("KmpCommandWidget", "[renderCommandVisibilityIfNeeded] gone");
        e1.o(this);
    L182:
        if (this.f316615l == true) goto L204;
        this.f316615l = true;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L186
        Object r138 = Result.m9449constructorimpl(CompatKt.findFragment(this));     // Catch: Throwable -> L186
    L189:
        if (Result.m9455isFailureimpl(r138) == true) goto L192;
        r100 = r138;
    L192:
        Fragment r139 = (Fragment) r100;
        if (r139 == null) goto L205;
        Lifecycle r140 = r139.getLifecycle();
        if (r140 == null) goto L206;
        r140.addObserver(new KmpCommandWidget$renderCommandVisibilityIfNeeded$2(r136, this));
        return;
    L206:
        return;
    L205:
        return;
    L186:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L189
    L204:
        return;
    L180:
        FLogger.f375446a.d("KmpCommandWidget", "[renderCommandVisibilityIfNeeded] visible");
        e1.x(this);
        goto L182
    L208:
        return;
    L173:
        r135 = null;
        goto L175
    L157:
        if (this.f316614k == true) goto L171;
        this.f316614k = true;
        if (getParent() != null) goto L162;
    L170:
        addOnAttachStateChangeListener(new o(this, r111, r101));
        goto L171
    L162:
        if (isAttachedToWindow() == false) goto L170;
        if (isLaidOut() == true) goto L167;
    L169:
        addOnLayoutChangeListener(new n(this, r111, r101));
        goto L171
    L167:
        if (isLayoutRequested() == true) goto L169;
        Y5(this, r111, r101);
        goto L171
    L153:
        if (r101.f295028k != true) goto L155;
        r106 = true;
        goto L155
    L120:
        r134 = i5.j0();
        goto L121
    L114:
        if (r122.length() == 0) goto L117;
        r133 = false;
        goto L118
    L123:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L124:
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r142 = this.f316612i;
        if (r142 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r142 = null;
    L127:
        e1.x(r142.f351582c);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r143 = this.f316612i;
        if (r143 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r143 = null;
    L130:
        ImageLoaderKt.u(r143.f351582c, r124, "custom_actionbar_icon");
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r144 = this.f316612i;
        if (r144 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r144 = null;
    L133:
        AppCompatTextView r145 = r144.f351583d;
        ViewGroup.LayoutParams r146 = r145.getLayoutParams();
        if (r146 == null) goto L201;
        ViewGroup.MarginLayoutParams r147 = (ViewGroup.MarginLayoutParams) r146;
        if (r122 != null) goto L138;
    L141:
        boolean r148 = true;
    L142:
        if (r148 == false) goto L144;
        int r149 = i5.m();
    L145:
        r147.setMarginStart(r149);
        r147.setMarginEnd(0);
        r145.setLayoutParams(r147);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r150 = this.f316612i;
        if (r150 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r150 = null;
    L148:
        SimpleDraweeView r151 = r150.f351582c;
        ViewGroup.LayoutParams r152 = r151.getLayoutParams();
        if (r152 == null) goto L199;
        ViewGroup.MarginLayoutParams r153 = (ViewGroup.MarginLayoutParams) r152;
        r153.setMarginEnd(i5.h());
        r151.setLayoutParams(r153);
        goto L151
    L199:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L144:
        r149 = i5.j0();
        goto L145
    L138:
        if (r122.length() == 0) goto L141;
        r148 = false;
        goto L142
    L201:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L97:
        if (r124.length() == 0) goto L100;
        r127 = false;
        goto L102
    L88:
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r154 = this.f316612i;
        if (r154 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r154 = null;
    L91:
        e1.x(r154.f351581b);
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r155 = this.f316612i;
        if (r155 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r155 = null;
    L94:
        ImageLoaderKt.u(r155.f351581b, r122, "custom_actionbar_icon");
        goto L95
    L78:
        if (r122.length() == 0) goto L81;
        r125 = false;
    L75:
        r124 = null;
        goto L76
    L71:
        if (r101 == null) goto L75;
        g1 r156 = r101.f295024g;
        if (r156 == null) goto L75;
        r124 = r156.f295156b;
    L65:
        r122 = null;
        goto L66
    L61:
        if (r101 == null) goto L65;
        g1 r157 = r101.f295022e;
        if (r157 == null) goto L65;
        r122 = r157.f295156b;
    L55:
        r120 = true;
        goto L56
    L47:
        if (r117.pl() != true) goto L49;
        r118 = true;
        goto L50
    L44:
        r117 = null;
        goto L45
    L40:
        r115 = this.f316610g;
        goto L41
    L28:
        if (r111.f464851g == false) goto L30;
        r109 = true;
    L25:
        r108 = false;
        goto L26
    L14:
        r104 = null;
        goto L15
    }

    public static Unit V5(KmpCommandWidget r410, View r411) {
        Intrinsics.checkNotNullParameter(r411, "it");
        i r100 = r410.f316613j;
        if (r100 == null) goto L28;
        c r101 = r100.f464850f;
        if (r101 == null) goto L26;
        Integer r110 = r410.Z5();
        Map<String, b0> r102 = c0.f558840a;
        c0.a(r101.f295020c, ActionBarItemLocation.DETAIL_PANEL, r110);
        String r103 = r101.f295021d;
        if (Intrinsics.areEqual(r103, "single_file") == false) goto L10;
    L13:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L21;
        Integer r105 = r101.f295018a;
        if (r105 == null) goto L19;
        String r412 = r105.toString();
    L20:
        String r111 = r101.f295019b;
        z0 r106 = r100.f464852h;
        tx9.b.e(r106.f465007a, r106.f465009c, null, null, null, null, null, r111, r412, null, 1, r110, null, null, null, r410.getConversationIdAsLong(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -36228, 127);
        goto L26
    L19:
        r412 = null;
        goto L20
    L21:
        z0 r107 = r100.f464852h;
        String r108 = r107.f465007a;
        String r109 = r107.f465009c;
        String r112 = r107.f465010d;
        String r113 = r107.f465012f;
        String r114 = r107.f465013g;
        String r115 = r101.f295019b;
        Integer r116 = r101.f295018a;
        if (r116 == null) goto L24;
        String r117 = r116.toString();
    L25:
        tx9.b.c(r108, r109, r112, r113, r114, r115, r117, r110);
        goto L26
    L24:
        r117 = null;
        goto L25
    L10:
        if (Intrinsics.areEqual(r103, "paste_url") == true) goto L13;
        r104 = false;
    L26:
        r100.f464848d.a(new cq8.h(r100.f464847c));
        return Unit.INSTANCE;
    L28:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_action_bar_editor_widget_kmp_command, this);
        int r102 = R.id.ic_item_img;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.ic_item_img);
        if (r103 == null) goto L11;
        r102 = R.id.ic_item_right_img;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.ic_item_right_img);
        if (r104 == null) goto L11;
        r102 = R.id.tv_item_name;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.tv_item_name);
        if (r105 == null) goto L11;
        LarusLayoutActionBarEditorWidgetKmpCommandBinding r106 = new LarusLayoutActionBarEditorWidgetKmpCommandBinding(this, r103, r104, r105);
        this.f316612i = r106;
        e1.d(r106.f351580a, new m(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public KmpCommandWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f316609f = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_50, r100, R.color.larus_primary_50));
        this.f316610g = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100));
        this.f316611h = LazyKt.lazy(new k(this));
    }

    public static final void Y5(KmpCommandWidget r210, i r211, c r212) {
        Integer r110 = r210.Z5();
        Map<String, b0> r100 = c0.f558840a;
        c0.b(r212.f295020c, ActionBarItemLocation.DETAIL_PANEL, r110);
        String r101 = r212.f295021d;
        if (Intrinsics.areEqual(r101, "single_file") == false) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L16;
        Integer r103 = r212.f295018a;
        if (r103 == null) goto L14;
        String r213 = r103.toString();
    L15:
        String r104 = r212.f295019b;
        z0 r105 = r211.f464852h;
        tx9.b.f(r105.f465007a, r105.f465009c, null, null, null, null, null, r104, r213, null, 1, r110, null, r210.getConversationIdAsLong(), null, null, null, null, null, null, null, null, 8376956);
        return;
    L14:
        r213 = null;
        goto L15
    L16:
        z0 r106 = r211.f464852h;
        String r107 = r106.f465007a;
        String r108 = r106.f465009c;
        String r109 = r106.f465010d;
        String r111 = r106.f465012f;
        String r112 = r106.f465013g;
        String r113 = r212.f295019b;
        Integer r114 = r212.f295018a;
        if (r114 == null) goto L19;
        String r115 = r114.toString();
    L20:
        tx9.b.d(r107, r108, r109, r111, r112, r113, r115, r110);
        return;
    L19:
        r115 = null;
        goto L20
    L5:
        if (Intrinsics.areEqual(r101, "paste_url") == true) goto L8;
        r102 = false;
        goto L10
    }

    public /* synthetic */ KmpCommandWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
