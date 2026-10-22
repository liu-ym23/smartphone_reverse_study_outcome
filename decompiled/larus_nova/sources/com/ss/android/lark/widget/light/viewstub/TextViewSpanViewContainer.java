package com.ss.android.lark.widget.light.viewstub;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 d2\u00020\u0001:\u0003bcdB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\rH\u0002J\u0018\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020 H\u0002J\u0018\u0010*\u001a\u00020 2\u0006\u0010$\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0010\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0011H\u0002J2\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J \u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0017\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020<H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00072\u0006\u0010;\u001a\u00020<H\u0002¢\u0006\u0004\b@\u0010>J/\u0010A\u001a\u00020 2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020<2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002¢\u0006\u0004\bC\u0010DJ\u0018\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0014J0\u0010H\u001a\u00020 2\u0006\u0010$\u001a\u00020+2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u000209H\u0002J0\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0014J\b\u0010S\u001a\u00020 H\u0002J \u0010T\u001a\u00020 2\u0006\u0010U\u001a\u00020\u00172\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\u000eH\u0002J\b\u0010X\u001a\u00020 H\u0016J\u001d\u0010Y\u001a\u00020 2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\\J\u0017\u0010]\u001a\u00020<2\u0006\u0010^\u001a\u00020_H\u0002¢\u0006\u0004\b`\u0010aJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00060\u001dR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/ss/android/lark/widget/light/viewstub/TextViewSpanViewContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "spanViewMap", "", "Lcom/ss/android/lark/widget/light/viewstub/ViewHolderSpan;", "Landroid/view/View;", "viewStubSpanSet", "", "Lcom/ss/android/lark/widget/light/viewstub/ViewStubSpan;", "targetEditText", "Landroid/widget/TextView;", "targetWidthMeasureSpec", "targetHeightMeasureSpec", "reusableRect", "Landroid/graphics/Rect;", "reusableSet", "", "reusableList", "", "innerSpanWatcher", "Lcom/ss/android/lark/widget/light/viewstub/TextViewSpanViewContainer$InnerSpanWatcher;", "willNotifySpanSpanViews", "attachTargetEditText", "", "editText", "attachTargetEditText$linked_emoji_release", "checkAndChangeSpans", "editable", "Landroid/text/Editable;", "removeSpanViewIfNeed", "span", "addSpanViewIfNeed", "clearAllSpanAndViews", "handleViewStubSpanAdd", "Landroid/text/Spannable;", "viewStubSpan", "createViewHolderSpan", "measureChildWithMargins", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "measureChildIfNeed", "view", "source", "", "notifyOnSizeChange", "", "getWidthSpecFromMeasureSpecLong", "measureSpecLong", "Lkotlin/ULong;", "getWidthSpecFromMeasureSpecLong-VKZWuLQ", "(J)I", "getHeightSpecFromMeasureSpecLong", "getHeightSpecFromMeasureSpecLong-VKZWuLQ", "measureChildInner", "measureSpec", "measureChildInner-32etgaw", "(Landroid/view/View;JLjava/lang/String;Z)V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "addViewHolder", "viewHolderSpan", "start", "end", "setSpan", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "relayoutSpanView", "getLocation", SVGRenderEngine.RECT, PickerReporterConstants.KEY.TARGET, "spanView", "invalidate", "updateTargetMeasureSpec", "widthSpec", "heightSpec", "updateTargetMeasureSpec$linked_emoji_release", "calculateMeasureSpecForSpan", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "calculateMeasureSpecForSpan-I7RO_PI", "(Landroid/view/ViewGroup$LayoutParams;)J", "InnerSpanViewCoordinator", "InnerSpanWatcher", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextViewSpanViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f446317k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ViewHolderSpan, View> f446318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<h> f446319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f446320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f446321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f446322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f446323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Object> f446324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Object> f446325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f446326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<View> f446327j;

    public static final class a {
    }

    public final class b implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextViewSpanViewContainer f446328b;

        public b(TextViewSpanViewContainer r100) {
            this.f446328b = r100;
        }

        @Override // com.ss.android.lark.widget.light.viewstub.f
        public final View a(h r100) {
            Intrinsics.checkNotNullParameter(r100, "stubSpan");
            return r100.b(this.f446328b.getContext());
        }

        @Override // com.ss.android.lark.widget.light.viewstub.f
        public final void b(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r100.isLaidOut() == true) goto L5;
        L6:
            TextViewSpanViewContainer r102 = this.f446328b;
            int r103 = TextViewSpanViewContainer.f446317k;
            r102.b(r100, "measureSpan", false);
            return;
        L5:
            if (r100.isLayoutRequested() == true) goto L6;
        }
    }

    public final class c implements SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextViewSpanViewContainer f446329a;

        public c(TextViewSpanViewContainer r100) {
            this.f446329a = r100;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
            if ((r100 instanceof Editable) == true) goto L5;
            return;
        L5:
            if ((r101 instanceof h) == false) goto L9;
            int r104 = TextViewSpanViewContainer.f446317k;
            this.f446329a.a((Editable) r100, r101);
            return;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
            if ((r101 instanceof ViewHolderSpan) == false) goto L6;
            int r104 = TextViewSpanViewContainer.f446317k;
            this.f446329a.d((ViewHolderSpan) r101);
            return;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
            if (CollectionsKt.contains(((LinkedHashMap) this.f446329a.f446318a).keySet(), r101) == false) goto L6;
            this.f446329a.requestLayout();
            return;
        }
    }

    static {
    }

    public TextViewSpanViewContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public TextViewSpanViewContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public TextViewSpanViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void c() {
        long r100 = System.currentTimeMillis();
        Iterator r101 = ((LinkedHashMap) this.f446318a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L35;
        Map.Entry r102 = (Map.Entry) r101.next();
        ViewHolderSpan r103 = (ViewHolderSpan) r102.getKey();
        View r104 = (View) r102.getValue();
        Rect r105 = this.f446323f;
        r105.setEmpty();
        TextView r106 = this.f446320c;
        if (r106 == null) goto L31;
        Layout r107 = r106.getLayout();
        if (r107 == null) goto L31;
        CharSequence r110 = r107.getText();
        if ((r110 instanceof Spanned) == false) goto L14;
        Spanned r111 = (Spanned) r110;
    L15:
        if (r111 == null) goto L31;
        int r108 = r111.getSpanStart(r103);
        float r112 = r107.getPrimaryHorizontal(r108);
        int r109 = r107.getLineForOffset(r108);
        float r113 = r104.getMeasuredWidth() + r112;
        r107.getLineBounds(r109, r105);
        Log.d("SpanView", "getLocation: line bounds is " + r105);
        boolean r114 = true;
        if (r109 < (r107.getLineCount() - 1)) goto L20;
    L27:
        int r115 = r104.getMeasuredHeight();
        if (r115 >= r105.height()) goto L30;
        Log.d("SpanView", "getLocation: viewHeight < rect.height()");
        r105.top = r105.bottom - r115;
    L30:
        int r116 = r106.getTop();
        int r117 = r106.getLeft();
        int r118 = r116 + r106.getTotalPaddingTop();
        r105.top += r118;
        r105.bottom += r118;
        int r119 = r105.left + MathKt.roundToInt((r117 + r112) + r106.getTotalPaddingLeft());
        r105.left = r119;
        r105.right = MathKt.roundToInt((r119 + r113) - r112);
        goto L31
    L20:
        if (r107.getSpacingMultiplier() == 0.0f) goto L23;
        r114 = false;
    L23:
        if (r114 == false) goto L25;
        float r120 = 1.0f;
    L26:
        float r121 = (r105.height() - r107.getSpacingAdd()) / r120;
        r105.offset(0, MathKt.roundToInt((-1) * (r105.height() - r121)));
        goto L27
    L25:
        r120 = r107.getSpacingMultiplier();
        goto L26
    L14:
        r111 = null;
    L31:
        Log.d("SpanView", "get viewLocation, view is " + r102 + " ,rect " + r105);
        if (r105.height() >= r104.getMeasuredHeight()) goto L34;
        Log.e("SpanView", "view height is " + r104.getMeasuredHeight() + ", but span rect height is " + r105.height());
    L34:
        r104.layout(r105.left, r105.top, r105.right, r105.bottom);
        goto L4
    L35:
        Log.d("SpanView", "relayoutSpanView: cost " + (System.currentTimeMillis() - r100) + " millis");
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        TextView r100 = this.f446320c;
        if (r100 == null) goto L6;
        r100.invalidate();
        return;
    }

    public final void d(ViewHolderSpan r100) {
        Log.d("SpanView", "removeSpanViewIfNeed: span is " + r100);
        View r101 = this.f446318a.remove(r100);
        this.f446319b.remove(r100.f446331b);
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        requestLayout();
    }

    public final void a(Editable r100, Object r101) {
        if ((r101 instanceof h) == true) goto L5;
        return;
    L5:
        if (this.f446319b.contains(r101) == true) goto L34;
        h r102 = (h) r101;
        int r103 = r100.getSpanStart(r102);
        int r104 = r100.getSpanEnd(r102);
        boolean r105 = false;
        ViewHolderSpan r106 = (ViewHolderSpan) ArraysKt.getOrNull(r100.getSpans(r103, r104, ViewHolderSpan.class), 0);
        ViewGroup r107 = null;
        if (r106 == null) goto L9;
        h r108 = r106.f446331b;
    L11:
        if (Intrinsics.areEqual(r108, r102) == true) goto L31;
        if (r106 != null) goto L15;
    L17:
        if (r106 != null) goto L19;
        r106 = new ViewHolderSpan(new b(this), r102);
        r105 = true;
    L19:
        View r109 = r106.a();
        ViewParent r110 = r109.getParent();
        if ((r110 instanceof ViewGroup) == false) goto L22;
        r107 = (ViewGroup) r110;
    L22:
        if (r107 != null) goto L24;
    L25:
        if (r107 == null) goto L27;
        r107.removeView(r109);
    L27:
        addView(r109);
    L28:
        this.f446318a.put(r106, r109);
        this.f446319b.add(r106.f446331b);
        if (r105 == false) goto L31;
        r100.setSpan(r106, r103, r104, 33);
        goto L31
    L24:
        if (Intrinsics.areEqual(r107, this) == true) goto L28;
    L15:
        if (Intrinsics.areEqual(r106.f446331b, r102) == true) goto L17;
        r100.removeSpan(r106);
        r106 = null;
    L31:
        requestLayout();
        return;
    L9:
        r108 = null;
        goto L11
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        this.f446327j.clear();
        super.onMeasure(r110, r111);
        if (this.f446327j.isEmpty() == false) goto L5;
        return;
    L5:
        TextView r112 = this.f446320c;
        if (r112 == null) goto L41;
        Editable r113 = r112.getEditableText();
        if (r113 == null) goto L42;
        ArrayList r114 = (ArrayList) this.f446325h;
        r114.clear();
        Iterator r100 = ((LinkedHashMap) this.f446318a).entrySet().iterator();
    L12:
        if (r100.hasNext() == false) goto L16;
        Map.Entry r101 = (Map.Entry) r100.next();
        if (this.f446327j.contains(r101.getValue()) == false) goto L12;
        r114.add(r101.getKey());
        goto L12
    L16:
        SpanWatcher[] r102 = (SpanWatcher[]) r113.getSpans(0, r113.length(), SpanWatcher.class);
        Iterator r103 = r114.iterator();
    L18:
        if (r103.hasNext() == false) goto L26;
        Object r115 = r103.next();
        int r116 = r102.length;
        int r117 = 0;
    L20:
        if (r117 >= r116) goto L18;
        SpanWatcher r104 = r102[r117];
        if (Intrinsics.areEqual(r104, this.f446326i) == true) goto L25;
        int r105 = r113.getSpanStart(r115);
        int r106 = r113.getSpanEnd(r115);
        r104.onSpanChanged(r113, r115, r105, r106, r105, r106);
    L25:
        r117 = r117 + 1;
        goto L20
    L26:
        TextWatcher[] r107 = (TextWatcher[]) r113.getSpans(0, r113.length(), TextWatcher.class);
        int r108 = r107.length;
        int r109 = 0;
    L27:
        if (r109 >= r108) goto L29;
        r107[r109].onTextChanged(r113, 0, r113.length(), r113.length());
        r109 = r109 + 1;
        goto L27
    L29:
        r114.clear();
        this.f446327j.clear();
        return;
    L42:
        return;
    }

    public final void b(View r110, String r111, boolean r210) {
        ViewGroup.LayoutParams r100 = r110.getLayoutParams();
        TextView r101 = this.f446320c;
        long r102 = 0;
        if (r101 != null) goto L6;
        long r103 = 0;
    L49:
        Object r104 = r110.getTag(R.id.tag_span_measure_spec);
        if ((r104 instanceof ULong) == false) goto L52;
        ULong r105 = (ULong) r104;
    L53:
        if (r105 == null) goto L56;
        r102 = r105.m9675unboximpl();
    L56:
        if (r110.isLaidOut() == true) goto L58;
    L61:
        Log.d("SpanView", "measureChildInner called, lastMeasureSpec is " + ULong.m9669toStringimpl(r102) + ", measureSpec is " + ULong.m9669toStringimpl(r103) + ", view is laiout is " + r110.isLaidOut() + ", layoutRequested is " + r110.isLayoutRequested());
        if (r102 == r103) goto L64;
        int r106 = (int) ULong.m9623constructorimpl(r102 >>> 32);
        int r107 = (int) r102;
        int r108 = View.MeasureSpec.getMode(r106);
        int r109 = View.MeasureSpec.getSize(r106);
        int r112 = View.MeasureSpec.getMode(r107);
        int r113 = View.MeasureSpec.getSize(r107);
        int r114 = (int) ULong.m9623constructorimpl(r103 >>> 32);
        int r115 = (int) r103;
        Log.d("SpanView", "measureChildInner: lastWidthMode is " + r108 + ", lastWidth is " + r109 + ", lastHeightMode is " + r112 + ", lastHeight is " + r113 + ", widthMode is " + View.MeasureSpec.getMode(r114) + ", width is " + View.MeasureSpec.getSize(r114) + ", heightMode is " + View.MeasureSpec.getMode(r115) + ", height is " + View.MeasureSpec.getSize(r115));
    L64:
        long r116 = System.nanoTime();
        r110.setTag(R.id.tag_span_measure_spec, ULong.m9617boximpl(r103));
        int r117 = (int) ULong.m9623constructorimpl(r103 >>> 32);
        int r118 = (int) r103;
        int r119 = r110.getMeasuredWidth();
        int r120 = r110.getMeasuredHeight();
        r110.measure(r117, r118);
        if (r110.getMeasuredWidth() == r119) goto L67;
    L70:
        boolean r121 = true;
    L71:
        Log.d("SpanView", "measureChildInner: from " + r111 + ", child measured size is " + r110.getMeasuredWidth() + Permission.EXECUTE + r110.getMeasuredHeight() + ", measureSpec is " + View.MeasureSpec.getSize(r117) + Permission.EXECUTE + View.MeasureSpec.getSize(r118) + ", cost " + ((System.nanoTime() - r116) / 1000000.0d) + " mills");
        if (r210 == false) goto L77;
        if (r121 == false) goto L78;
        this.f446327j.add(r110);
        return;
    L78:
        return;
    L77:
        return;
    L67:
        if (r110.getMeasuredHeight() != r120) goto L70;
        r121 = false;
        goto L71
    L58:
        if (r110.isLayoutRequested() == true) goto L61;
        if (r103 != r102) goto L61;
        return;
    L52:
        r105 = null;
        goto L53
    L6:
        if ((r101.getInputType() & 131072) == 131072) goto L8;
        boolean r122 = true;
    L9:
        boolean r123 = Intrinsics.areEqual(r101.getTransformationMethod(), SingleLineTransformationMethod.getInstance());
        if (r122 == false) goto L15;
        if (r123 == false) goto L15;
        if (r101.getMaxLines() != 1) goto L15;
        boolean r124 = true;
    L16:
        int r125 = View.MeasureSpec.getSize(this.f446321d);
        int r126 = View.MeasureSpec.getSize(this.f446322e);
        int r127 = r100.width;
        int r128 = r100.height;
        int r129 = Integer.MIN_VALUE;
        if (r124 == false) goto L32;
        int r130 = this.f446322e;
        if (r130 == 0) goto L23;
        if (r127 < 0) goto L22;
        int r131 = 1073741824;
    L24:
        if (r130 == 0) goto L47;
        if (r128 < 0) goto L27;
        r126 = Math.min(r128, r126);
    L28:
        r129 = 1073741824;
    L48:
        r103 = ULong.m9623constructorimpl(ULong.m9623constructorimpl(ULong.m9623constructorimpl(View.MeasureSpec.makeMeasureSpec(r127, r131)) << 32) + ULong.m9623constructorimpl(((long) UInt.m9544constructorimpl(View.MeasureSpec.makeMeasureSpec(r126, r129))) & BodyPartID.bodyIdMax));
        goto L49
    L27:
        if (r128 == (-1)) goto L28;
        if (r128 == (-2)) goto L48;
    L47:
        r126 = 0;
        r129 = 0;
        goto L48
    L22:
        r131 = Integer.MIN_VALUE;
        r127 = 536870912;
        goto L24
    L23:
        r131 = 0;
        r127 = 0;
        goto L24
    L32:
        if (this.f446321d == 0) goto L39;
        if (r127 < 0) goto L35;
        r125 = Math.min(r127, r125);
    L36:
        int r132 = 1073741824;
    L41:
        if (this.f446322e == 0) goto L46;
        if (r128 < 0) goto L44;
        r126 = r128;
        r129 = 1073741824;
    L45:
        r127 = r125;
        r131 = r132;
        goto L48
    L44:
        r126 = 536870912;
        goto L45
    L46:
        r127 = r125;
        r131 = r132;
        goto L47
    L35:
        if (r127 == (-1)) goto L36;
        if (r127 != (-2)) goto L39;
        r132 = Integer.MIN_VALUE;
    L39:
        r132 = 0;
        r125 = 0;
    L15:
        r124 = false;
        goto L16
    L8:
        r122 = false;
        goto L9
    }

    public TextViewSpanViewContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f446318a = new LinkedHashMap();
        this.f446319b = new LinkedHashSet();
        this.f446323f = new Rect();
        this.f446324g = new LinkedHashSet();
        this.f446325h = new ArrayList();
        this.f446326i = new c(this);
        this.f446327j = new LinkedHashSet();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r100, int r101, int r102, int r103, int r104) {
        if (r100 == null) goto L5;
        b(r100, "measureChild", true);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        c();
    }
}
