package com.larus.bmhome.view.chatinput;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.input.impl.databinding.LarusInputKeyboardIconPopupViewBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.ss.android.lark.utils.statistics.PerfLog;
import et8.g;
import et8.h;
import et8.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J#\u0010\u0014\u001a\u00020\u00002\u001b\u0010\u0015\u001a\u0017\u0012\b\u0012\u00060\u0017R\u00020\u0000\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0002\b\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/view/chatinput/InputKeyboardIconPopupMenu;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/input/impl/databinding/LarusInputKeyboardIconPopupViewBinding;", "balloon", "Lcom/skydoves/balloon/Balloon;", "handleDismissBalloon", "createBalloon", "", "show", "anchor", "Landroid/view/View;", "config", "block", "Lkotlin/Function1;", "Lcom/larus/bmhome/view/chatinput/InputKeyboardIconPopupMenu$ConfigBuilder;", "Lkotlin/ExtensionFunctionType;", "Companion", "ConfigBuilder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputKeyboardIconPopupMenu extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusInputKeyboardIconPopupViewBinding f316869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Balloon f316870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Balloon f316871c;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), c7.b(Float.valueOf(12.0f)));
        }
    }

    public static final class b {
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputKeyboardIconPopupMenu f316872a;

        public c(InputKeyboardIconPopupMenu r100) {
            this.f316872a = r100;
        }
    }

    static {
    }

    public InputKeyboardIconPopupMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InputKeyboardIconPopupMenu(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public InputKeyboardIconPopupMenu(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_input_keyboard_icon_popup_view, this);
        int r103 = R.id.content;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.content);
        if (r104 == null) goto L21;
        r103 = R.id.divider;
        View r105 = ViewBindings.findChildViewById(this, R.id.divider);
        if (r105 == null) goto L21;
        r103 = R.id.menu_copy;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.menu_copy);
        if (r106 == null) goto L21;
        r103 = R.id.menu_copy_and_send;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.menu_copy_and_send);
        if (r107 == null) goto L21;
        r103 = R.id.shadow;
        if (((ShadowLayout) ViewBindings.findChildViewById(this, R.id.shadow)) == null) goto L21;
        this.f316869a = new LarusInputKeyboardIconPopupViewBinding(this, r104, r105, r106, r107);
        ViewGroup.LayoutParams r108 = getLayoutParams();
        if (r108 != null) goto L15;
        r108 = new FrameLayout.LayoutParams(-1, -1);
    L15:
        setLayoutParams(r108);
        if (z2.f365865a.messageInputMenuConfig().b() == true) goto L18;
        e1.o(r107);
    L18:
        r104.post(new g(this));
        measure(0, 0);
        Balloon.a r109 = new Balloon.a(getContext());
        Intrinsics.checkNotNullParameter(this, "layout");
        r109.I = this;
        r109.f406061v = 0;
        r109.n(Integer.MIN_VALUE);
        r109.j(Integer.MIN_VALUE);
        r109.e(ArrowPositionRules.ALIGN_BALLOON);
        r109.f406055p = 0.5f;
        r109.f(0);
        r109.f406052m = false;
        r109.T = true;
        r109.h(false);
        r109.l(new h(this));
        this.f316870b = r109.b();
        Balloon.a r110 = new Balloon.a(getContext());
        r110.f406061v = 0;
        r110.n(1);
        r110.j(1);
        r110.h(false);
        r110.T = false;
        k r111 = new k(this);
        Intrinsics.checkNotNullParameter(r111, "value");
        r110.Q = r111;
        this.f316871c = r110.b();
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ InputKeyboardIconPopupMenu(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
