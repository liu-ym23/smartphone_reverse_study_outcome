package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import bt8.i;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetButtonRouterBinding;
import com.larus.utils.e1;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.c;
import cq8.e;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00060\u0001j\u0002`\u0002:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0015H\u0002J\f\u0010\u0018\u001a\u00020\u0017*\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpButtonRouterWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetButtonRouterBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/ButtonRouterDescriptor;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", ChameleonOpenTracker.Stage.RENDER, "data", "Lcom/larus/bmhome/actionbar/model/ActionBarButtonRouterTemplate;", "shouldHideArrow", "", "isTrueValue", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpButtonRouterWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f316599h = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetButtonRouterBinding f316600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f316601g;

    public static final class a {
    }

    static {
    }

    public KmpButtonRouterWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpButtonRouterWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r101 = null;
        if ((r100 instanceof c) == true) goto L5;
        r100 = null;
    L5:
        c r102 = (c) r100;
        if (r102 == null) goto L70;
        this.f316601g = r102;
        com.larus.bmhome.actionbar.model.a r103 = r102.f464810f;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r104 = this.f316600f;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L11:
        AppCompatTextView r105 = r104.f351564d;
        if (r103 == null) goto L14;
        String r106 = r103.f294947b;
    L15:
        r105.setText(r106);
        boolean r107 = false;
        if (r103 == null) goto L33;
        HashMap<String, String> r108 = r103.f294949d;
        if (r108 == null) goto L30;
        String r109 = r108.get("hide_arrow");
        if (r109 == null) goto L30;
        if (StringsKt.equals(r109, "true", true) == false) goto L24;
    L27:
        boolean r110 = true;
    L28:
        if (r110 != true) goto L30;
        boolean r111 = true;
    L31:
        if (r111 != true) goto L33;
        boolean r112 = true;
    L34:
        if (r112 == false) goto L39;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r113 = this.f316600f;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L38:
        e1.o(r113.f351562b);
    L43:
        if (r103 == null) goto L49;
        List<w> r114 = r103.f294955j;
        if (r114 == null) goto L49;
        w r115 = (w) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L49;
        String r116 = r115.f295511b;
    L50:
        if (r116 != null) goto L52;
    L53:
        r107 = true;
    L54:
        if (r107 == false) goto L60;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r117 = this.f316600f;
        if (r117 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L59:
        e1.o(r101.f351565e);
    L68:
        r102.f464808d.a(new e(r102.f464807c));
        return;
    L58:
        r101 = r117;
        goto L59
    L60:
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r118 = this.f316600f;
        if (r118 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L63:
        r118.f351565e.setText(r116);
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r119 = this.f316600f;
        if (r119 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L67:
        e1.x(r101.f351565e);
        goto L68
    L66:
        r101 = r119;
        goto L67
    L52:
        if (r116.length() != 0) goto L54;
    L49:
        r116 = null;
        goto L50
    L39:
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r120 = this.f316600f;
        if (r120 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L42:
        e1.x(r120.f351562b);
        goto L43
    L24:
        if (Intrinsics.areEqual(r109, "1") == true) goto L27;
        r110 = false;
    L30:
        r111 = false;
    L33:
        r112 = false;
        goto L34
    L14:
        r106 = null;
        goto L15
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r102 = LarusLayoutActionBarEditorWidgetButtonRouterBinding.a(LayoutInflater.from(r100), this);
        this.f316600f = r102;
        e1.d(r102.f351563c, new i(this));
    }

    public KmpButtonRouterWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ KmpButtonRouterWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
