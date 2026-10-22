package com.larus.bmhome.chat.standarduikit.markdown.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.android.material.card.MaterialCardView;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0019\u0018\u0000 32\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u00013B\u001d\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J!\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u0011H\u0002J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u0015J\u001a\u0010*\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020,H\u0016J5\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010,2\b\u00100\u001a\u0004\u0018\u00010,2\b\u00101\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u00102R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainer;", "Lcom/google/android/material/card/MaterialCardView;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainerInput;", "Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainerOutput;", "Lcom/larus/business/markdown/api/view/IMarkdownMarginFreeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "appletWidget", "Lcom/larus/bmhome/chat/layout/widget/AppletWidget;", "size", "Landroid/util/Size;", "isFullWidth", "", "appletWidgetView", "Landroid/view/View;", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "generateExposureCallback", "com/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainer$generateExposureCallback$1", "mixtureCardId", "", "renderData", "(Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/standarduikit/markdown/view/MarkdownAppletContainer$generateExposureCallback$1;", "registerAutoExposureManager", "exposureManager", "Lcom/larus/bmhome/chat/exposure/ExposureManager;", "lastContainerConfig", "Lcom/larus/bmhome/chat/standarduikit/markdown/view/AppletContainerUIConfig;", "updateContainUI", "containerUIConfig", "isFullBlock", "onViewRecycled", "data", "Lcom/larus/bmhome/chat/layout/widget/RecycleData;", "resetForSkip", "sizeThatFits", "preferredMaxWidth", "", "onMarkdownMarginChanged", "left", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownAppletContainer extends MaterialCardView implements nw8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f309508e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppletWidget f309509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Size f309510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f309511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public bm8.a f309512d;

    public static final class a {
    }

    static {
    }

    public MarkdownAppletContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public MarkdownAppletContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setCardElevation(0.0f);
        setCardBackgroundColor(null);
        setImportantForAccessibility(2);
        this.f309510b = new Size(0, 0);
    }

    public final void a(bm8.a r100, boolean r101) {
        bm8.a r102 = this.f309512d;
        boolean r103 = false;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        if (r100 == null) goto L8;
        int r105 = r100.hashCode();
    L9:
        if (r104 == r105) goto L28;
        if (r100 == null) goto L12;
        r103 = Intrinsics.areEqual(r100.f19624a, Boolean.TRUE);
    L12:
        if (r103 == false) goto L19;
        Integer r106 = r100.f19626c;
        if (r106 == null) goto L16;
        setStrokeColor(r106.intValue());
    L16:
        Integer r107 = r100.f19627d;
        if (r107 == null) goto L19;
        setStrokeWidth(r107.intValue());
    L19:
        if (r100 == null) goto L28;
        Float r108 = r100.f19625b;
        if (r108 == null) goto L28;
        float r109 = r108.floatValue();
        if (r101 == false) goto L25;
        setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.larus_base_1));
        setRadius(r109);
        goto L28
    L25:
        AppletWidget r110 = this.f309509a;
        if (r110 == null) goto L28;
        r110.j(Float.valueOf(r109), Float.valueOf(r109), Float.valueOf(r109), Float.valueOf(r109));
    L28:
        this.f309512d = r100;
        return;
    L8:
        r105 = 0;
        goto L9
    L5:
        r104 = 0;
        goto L6
    }

    @Override // nw8.a
    public final void k(Integer r100, Integer r101, Integer r102, Integer r103) {
        ViewGroup.LayoutParams r104 = getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
    L6:
        if (r105 != null) goto L9;
        return;
    L9:
        if (this.f309511c == false) goto L11;
        r100 = 0;
    L11:
        boolean r106 = true;
        if (r100 != null) goto L14;
    L16:
        boolean r107 = false;
    L17:
        if (r101 == null) goto L22;
        if (r105.topMargin == r101.intValue()) goto L22;
        r105.topMargin = r101.intValue();
        r107 = true;
    L22:
        if (this.f309511c == false) goto L24;
        r102 = 0;
    L24:
        if (r102 != null) goto L26;
    L28:
        if (r103 != null) goto L30;
    L32:
        r106 = r107;
    L33:
        if (r106 == false) goto L36;
        setLayoutParams(r105);
    L36:
        if (getVisibility() == 0) goto L39;
        setVisibility(0);
        return;
    L39:
        return;
    L30:
        if (r105.bottomMargin == r103.intValue()) goto L32;
        r105.bottomMargin = r103.intValue();
        goto L33
    L26:
        if (r105.rightMargin == r102.intValue()) goto L28;
        r105.rightMargin = r102.intValue();
        r107 = true;
        goto L28
    L14:
        if (r105.leftMargin == r100.intValue()) goto L16;
        r105.leftMargin = r100.intValue();
        r107 = true;
        goto L17
    L5:
        r105 = null;
        goto L6
    }
}
