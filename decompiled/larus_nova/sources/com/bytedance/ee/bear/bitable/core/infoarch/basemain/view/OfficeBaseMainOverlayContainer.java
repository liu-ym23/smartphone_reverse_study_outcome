package com.bytedance.ee.bear.bitable.core.infoarch.basemain.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fJ3\u0010\"\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\f2#\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fJ\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0001H\u0002J\b\u0010*\u001a\u00020+H\u0002R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a+\u0012\u0004\u0012\u00020\f\u0012!\u0012\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/view/OfficeBaseMainOverlayContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "slotRootMap", "", "Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/view/OfficeBaseMainOverlayType;", "slotMap", "verticalReleaseListeners", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "scrollUp", "", "touchSlop", "downX", "", "downY", "lastY", "Ljava/lang/Boolean;", "pendingDy", "movedVertically", "ensureSlot", "type", "show", "hide", "isShowing", "setOnVerticalRelease", "listener", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "createSlotRoot", "addSlotDecoration", RootDescription.ROOT_ELEMENT, "matchParentLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBaseMainOverlayContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<OfficeBaseMainOverlayType, FrameLayout> f210522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<OfficeBaseMainOverlayType, FrameLayout> f210523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<OfficeBaseMainOverlayType, Function1<Boolean, Unit>> f210524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f210525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f210526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f210527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f210528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f210529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f210530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f210531j;

    public static final class a {
    }

    static {
    }

    public OfficeBaseMainOverlayContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OfficeBaseMainOverlayContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final FrameLayout a(OfficeBaseMainOverlayType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        LinkedHashMap r101 = (LinkedHashMap) this.f210523b;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        FrameLayout r103 = new FrameLayout(getContext());
        r103.setVisibility(8);
        FrameLayout r104 = new FrameLayout(getContext());
        r104.setId(View.generateViewId());
        r103.addView(r104, new FrameLayout.LayoutParams(-1, -1));
        this.f210522a.put(r100, r103);
        addView(r103, new FrameLayout.LayoutParams(-1, -1));
        r101.put(r100, r104);
        r102 = r104;
    L6:
        return (FrameLayout) r102;
    }

    public final void b(OfficeBaseMainOverlayType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        FrameLayout r101 = (FrameLayout) ((LinkedHashMap) this.f210522a).get(r100);
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        Collection r102 = ((LinkedHashMap) this.f210522a).values();
        boolean r103 = true;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        if (((FrameLayout) r104.next()).getVisibility() != 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L12;
        r103 = false;
        goto L19
    L16:
        r105 = false;
    L19:
        if (r103 == false) goto L27;
        setVisibility(8);
        return;
    L27:
        return;
    L8:
        if (r102.isEmpty() == false) goto L10;
        goto L10
    }

    public final void c(OfficeBaseMainOverlayType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        a(r100);
        FrameLayout r101 = (FrameLayout) ((LinkedHashMap) this.f210522a).get(r100);
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        FrameLayout r102 = (FrameLayout) ((LinkedHashMap) this.f210522a).get(r100);
        if (r102 == null) goto L8;
        r102.bringToFront();
    L8:
        setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 != 0) goto L5;
        this.f210526e = r110.getX();
        this.f210527f = r110.getY();
        this.f210528g = r110.getY();
        this.f210529h = null;
        this.f210530i = 0.0f;
        this.f210531j = false;
    L70:
        return super.dispatchTouchEvent(r110);
    L5:
        if (r100 != 1) goto L7;
    L40:
        Boolean r102 = this.f210529h;
        StringBuilder r103 = new StringBuilder("[release] Overlay release action:");
        r103.append(r110.getActionMasked());
        r103.append(" movedVertically:");
        r103.append(this.f210531j);
        r103.append(" scrollUp:");
        r103.append(r102);
        r103.append(" visibleSlots:");
        Map<OfficeBaseMainOverlayType, FrameLayout> r104 = this.f210522a;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator r106 = ((LinkedHashMap) r104).entrySet().iterator();
    L42:
        if (r106.hasNext() == false) goto L49;
        Map.Entry r107 = (Map.Entry) r106.next();
        if (((FrameLayout) r107.getValue()).getVisibility() != 0) goto L46;
        boolean r108 = true;
    L47:
        if (r108 == false) goto L42;
        r105.put(r107.getKey(), r107.getValue());
        goto L42
    L46:
        r108 = false;
        goto L47
    L49:
        r103.append(r105.keySet());
        tt5.a.h("OfficeBaseMainOverlay", r103.toString());
        if (this.f210531j == false) goto L67;
        if (r102 == null) goto L67;
        Map<OfficeBaseMainOverlayType, FrameLayout> r109 = this.f210522a;
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator r112 = ((LinkedHashMap) r109).entrySet().iterator();
    L54:
        if (r112.hasNext() == false) goto L61;
        Map.Entry r113 = (Map.Entry) r112.next();
        if (((FrameLayout) r113.getValue()).getVisibility() != 0) goto L58;
        boolean r114 = true;
    L59:
        if (r114 == false) goto L54;
        r111.put(r113.getKey(), r113.getValue());
        goto L54
    L58:
        r114 = false;
        goto L59
    L61:
        Iterator r115 = r111.keySet().iterator();
    L63:
        if (r115.hasNext() == false) goto L67;
        Function1 r116 = (Function1) ((LinkedHashMap) this.f210524c).get((OfficeBaseMainOverlayType) r115.next());
        if (r116 == null) goto L63;
        r116.invoke(r102);
    L67:
        this.f210529h = null;
        this.f210530i = 0.0f;
        this.f210531j = false;
        goto L70
    L7:
        if (r100 != 2) goto L9;
        float r117 = r110.getY() - this.f210528g;
        if (Math.abs(r117) <= 0.0f) goto L34;
        float r118 = this.f210530i;
        if (r118 != 0.0f) goto L16;
        boolean r119 = true;
    L17:
        if (r119 == false) goto L19;
    L27:
        r117 = r117 + r118;
    L28:
        this.f210530i = r117;
        if (Math.abs(r117) < this.f210525d) goto L34;
        if (this.f210530i >= 0.0f) goto L33;
        r101 = true;
    L33:
        this.f210529h = Boolean.valueOf(r101);
        this.f210530i = 0.0f;
        goto L34
    L19:
        if (r118 <= 0.0f) goto L21;
        boolean r120 = true;
    L23:
        if (r117 <= 0.0f) goto L25;
        boolean r121 = true;
    L26:
        if (r120 != r121) goto L28;
    L25:
        r121 = false;
        goto L26
    L21:
        r120 = false;
        goto L23
    L16:
        r119 = false;
    L34:
        float r122 = r110.getX() - this.f210526e;
        float r123 = r110.getY() - this.f210527f;
        if (Math.abs(r123) > this.f210525d) goto L37;
    L39:
        this.f210528g = r110.getY();
        goto L70
    L37:
        if (Math.abs(r123) <= Math.abs(r122)) goto L39;
        this.f210531j = true;
        goto L39
    L9:
        if (r100 == 3) goto L40;
        goto L40
    }

    public OfficeBaseMainOverlayContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f210522a = new LinkedHashMap();
        this.f210523b = new LinkedHashMap();
        this.f210524c = new LinkedHashMap();
        this.f210525d = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ OfficeBaseMainOverlayContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
