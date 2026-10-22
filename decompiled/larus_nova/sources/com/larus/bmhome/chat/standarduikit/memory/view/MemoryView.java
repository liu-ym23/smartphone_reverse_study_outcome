package com.larus.bmhome.chat.standarduikit.memory.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusMdMemoryWidgetBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import jm8.d;
import jm8.e;
import jm8.f;
import jm8.g;
import jm8.h;
import jm8.j;
import jm8.k;
import jm8.m;
import jm8.n;
import km8.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 72\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u00017B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0004H\u0016J\u001a\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0002J\u001f\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0003H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/memory/view/MemoryView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/memory/view/MemoryViewInput;", "Lcom/larus/bmhome/chat/standarduikit/memory/view/MemoryViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusMdMemoryWidgetBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusMdMemoryWidgetBinding;", "binding$delegate", "Lkotlin/Lazy;", "isShowing", "", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title$delegate", "icon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "icon$delegate", RootDescription.ROOT_ELEMENT, "Landroid/widget/LinearLayout;", "getRoot", "()Landroid/widget/LinearLayout;", "root$delegate", "memoryVcOut", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "sizeThatFits", "Landroid/util/Size;", "preferredMaxWidth", "", "updatePadding", "flowMemoryInput", "setupIconImage", "setupTitle", "setupFullView", "mobCardShow", "getCardId", "", "messageId", "cardIndex", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "tryShowTip", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemoryView extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f309518g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f309519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f309520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f309521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f309522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f309523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f309524f;

    public static final class a {
    }

    static {
    }

    private final LarusMdMemoryWidgetBinding getBinding() {
        return (LarusMdMemoryWidgetBinding) this.f309519a.getValue();
    }

    private final SimpleDraweeView getIcon() {
        return (SimpleDraweeView) this.f309522d.getValue();
    }

    private final LinearLayout getRoot() {
        return (LinearLayout) this.f309523e.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.f309521c.getValue();
    }

    public MemoryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static SimpleDraweeView a(MemoryView r100) {
        return r100.getBinding().f358743b;
    }

    public static TextView b(MemoryView r100) {
        return r100.getBinding().f358744c;
    }

    public static LinearLayout c(MemoryView r100) {
        return r100.getBinding().f358742a;
    }

    private final void setupFullView(final m r100) {
        if (Intrinsics.areEqual(r100.f499697i, Boolean.TRUE) == true) goto L6;
        e1.d(getRoot(), new g(this, r100));
        ExposeXTrackerExtKt.b(this, new h(this, r100));
        return;
    }

    private final void setupIconImage(m r100) {
        boolean r101 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L7;
        String r102 = r100.f499694f;
        if (r102 == null) goto L9;
    L10:
        GenericDraweeHierarchy r103 = getIcon().getHierarchy();
        if (r103 == null) goto L13;
        r103.setPlaceholderImage(c.b(R.attr.larus_md_memorys_widget_icon, null, R.drawable.larus_md_memorys_widget_icon));
    L13:
        ImageLoaderKt.u(getIcon(), r102, "markdown.media_source_icon");
        return;
    L9:
        r102 = "";
        goto L10
    L7:
        r102 = r100.f499695g;
        if (r102 != null) goto L10;
        goto L9
    }

    private final void setupTitle(m r100) {
        TextView r101 = getTitle();
        String r102 = r100.f499696h;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.setText(r102);
    }

    public MemoryView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f309519a = LazyKt.lazy(new jm8.a(r100, this));
        this.f309521c = LazyKt.lazy(new d(this));
        this.f309522d = LazyKt.lazy(new e(this));
        this.f309523e = LazyKt.lazy(new f(this));
    }

    public final void e(m r100, i.a r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f309524f = r101;
        if (Intrinsics.areEqual(r100.f499693e, Boolean.TRUE) == false) goto L6;
        setVisibility(8);
        return;
    L6:
        setupIconImage(r100);
        setupTitle(r100);
        setupFullView(r100);
        Pair<Integer, Integer> r102 = r100.f499690b;
        int r103 = 0;
        if (r102 == null) goto L9;
        int r104 = r102.getFirst().intValue();
    L10:
        Pair<Integer, Integer> r105 = r100.f499690b;
        if (r105 == null) goto L13;
        r103 = r105.getSecond().intValue();
    L13:
        setPaddingRelative(getPaddingStart(), r104, getPaddingEnd(), r103);
        return;
    L9:
        r104 = 0;
        goto L10
    }

    public final Size f(m r100, int r101) {
        if (r100 != null) goto L7;
        return new Size(0, 0);
    L7:
        if (Intrinsics.areEqual(r100.f499693e, Boolean.TRUE) == true) goto L9;
        getRoot().measure(0, 0);
        int r102 = getPaddingTop() + getPaddingBottom();
        return new Size(r101, getRoot().getMeasuredHeight() + r102);
    L9:
        return new Size(r101, 0);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [jm8.j] */
    public static Unit d(final MemoryView r310, m r311, LinearLayout r312) {
        Intrinsics.checkNotNullParameter(r312, "it");
        if (r310.f309520b == true) goto L36;
        int[] r100 = new int[2];
        r310.getBinding().f358742a.getLocationOnScreen(r100);
        if (r100[1] <= (i5.w0() + com.larus.utils.i.e(r310.getContext()))) goto L8;
        AutoOffsetPopupWindow.WindowGravity r101 = AutoOffsetPopupWindow.WindowGravity.TOP;
    L9:
        AutoOffsetPopupWindow.WindowGravity r110 = r101;
        n r102 = r310.f309524f;
        if (r102 != null) goto L12;
    L14:
        final boolean r103 = false;
    L16:
        if (r103 == false) goto L18;
        String r104 = r310.getContext().getString(R.string.larus_new_memory_manage_toggle);
    L21:
        String r105 = r104;
    L22:
        Intrinsics.checkNotNull(r105);
        Integer r106 = null;
        if (r103 == false) goto L25;
        Integer r210 = Integer.valueOf(c.b(R.attr.larus_memory_icon_tips, null, R.drawable.larus_memory_icon_tips));
    L26:
        if (r103 == false) goto L28;
        r106 = Integer.valueOf(c.b(R.attr.larus_primary_50, null, R.color.larus_primary_50));
    L28:
        Integer r107 = r106;
        String r108 = r311.f499699k;
        if (r108 != null) goto L31;
        String r109 = "";
    L32:
        int r111 = AutoOffsetPopupWindow.f327761a;
        final PopupWindow r112 = AutoOffsetPopupWindow.a(r310.getContext(), r310.getBinding().f358742a, r105, r107, r109, i5.h(), i5.h(), i5.j0(), r110, i5.h(), 0, null, new jm8.i(r310), 0, 0, null, new j(r103, r310), null, false, false, r210, i5.e0(), null, false, null, 59698176);
        long r113 = r311.f499691c;
        if (r113 <= 0) goto L35;
        r310.postDelayed(new k(r112), r113);
    L35:
        r310.f309520b = true;
        goto L36
    L31:
        r109 = r108;
        goto L32
    L25:
        r210 = null;
        goto L26
    L18:
        r104 = r311.f499698j;
        if (r104 != null) goto L21;
        r105 = "";
        goto L22
    L12:
        if (r102.a() != true) goto L14;
        r103 = true;
        goto L16
    L8:
        r101 = AutoOffsetPopupWindow.WindowGravity.BOTTOM;
    L36:
        n r114 = r310.f309524f;
        if (r114 == null) goto L40;
        r114.b();
    L40:
        return Unit.INSTANCE;
    }
}
