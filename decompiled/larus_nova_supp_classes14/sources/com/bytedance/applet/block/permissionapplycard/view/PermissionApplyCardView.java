package com.bytedance.applet.block.permissionapplycard.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.applet.databinding.LarusPermissionApplyCardViewBinding;
import com.larus.bmhome.chat.api.AppletGrantingWidgetDelegate;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.utils.e1;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001!\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005B\u001d\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0004H\u0016J\u0018\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\rH\u0002Jx\u0010-\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010\u00102\b\u0010/\u001a\u0004\u0018\u00010\u00102\b\u00100\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u00102\b\u00104\u001a\u0004\u0018\u00010\u00102\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u00020&082\f\u00109\u001a\b\u0012\u0004\u0012\u00020&08H\u0002J\u0018\u0010:\u001a\u00020&2\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020&H\u0016J\b\u0010<\u001a\u00020&H\u0016J\u0006\u0010=\u001a\u00020&R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#¨\u0006>"}, d2 = {"Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardViewInput;", "Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardViewOutput;", "Lcom/larus/bmhome/chat/quickreply/IMoaGrantingCardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentCardModel", "Lcom/larus/bmhome/chat/api/CardModel;", "isLastMessage", "Lkotlin/Function1;", "", "", "moaOutput", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingCardViewOutput;", "currentAllowTitle", "currentRefuseTitle", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "binding", "Lcom/bytedance/applet/databinding/LarusPermissionApplyCardViewBinding;", "getBinding", "()Lcom/bytedance/applet/databinding/LarusPermissionApplyCardViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "callback", "com/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardView$callback$2$1", "getCallback", "()Lcom/bytedance/applet/block/permissionapplycard/view/PermissionApplyCardView$callback$2$1;", "callback$delegate", "bindData", "", "input", "output", "bind", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingCardViewInput;", "updateView", "cardModel", "render", "iconURL", "sourceName", "title", "subtitle", "showOperateButton", "allowTitle", "refuseTitle", "allowLoading", "refuseLoading", "onAllow", "Lkotlin/Function0;", "onRefuse", "setLoading", "hide", "recycle", "onRecycler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionApplyCardView extends ConstraintLayout implements mi8.a {
    public static final /* synthetic */ int h = 0;
    public com.larus.bmhome.chat.api.f a;
    public Function1<? super String, Boolean> b;
    public mi8.e c;
    public String d;
    public String e;
    public final Lazy f;
    public final Lazy g;

    public static final class a implements com.larus.bmhome.chat.api.k {
        public final /* synthetic */ PermissionApplyCardView a;

        public a(PermissionApplyCardView r1) {
            this.a = r1;
        }

        public final boolean c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msgID");
            return ((Boolean) this.a.b.invoke(r2)).booleanValue();
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [android.view.ViewGroup, com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView] */
        public final void d(String r2, final com.larus.bmhome.chat.api.f r3) {
            Intrinsics.checkNotNullParameter(r2, "msgID");
            Intrinsics.checkNotNullParameter(r3, "cardModel");
            if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
            this.a.a = r3;
            PermissionApplyCardView.R5(this.a, r3);
            return;
        L5:
            final ?? r4 = this.a;
            r4.post(new o(r4, r3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getView() {
        return this;
    }

    private final LarusPermissionApplyCardViewBinding getBinding() {
        return (LarusPermissionApplyCardViewBinding) this.f.getValue();
    }

    private final a getCallback() {
        return (a) this.g.getValue();
    }

    public final void recycle() {
        mi8.e r0 = this.c;
        if (r0 == null) goto L5;
        r0.onHidden();
    L5:
        this.c = null;
        this.d = "";
        this.e = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hide() {
        e1.o(this);
    }

    public PermissionApplyCardView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PermissionApplyCardView(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new com.bytedance.applet.block.permissionapplycard.view.a();
        this.d = "";
        this.e = "";
        this.f = LazyKt.lazy(new f(r2, this));
        setBackgroundResource(2131243143);
        this.g = LazyKt.lazy(new g(this));
    }

    public static final void R5(final PermissionApplyCardView r5, final com.larus.bmhome.chat.api.f r6) {
        LarusPermissionApplyCardViewBinding r0 = r5.getBinding();
        TextView r1 = r0.j;
        String r2 = r6.e;
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.setText(r2);
        TextView r4 = r0.i;
        String r7 = r6.f;
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r4.setText(r7);
        TextView r8 = r0.h;
        String r9 = r6.d;
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        r8.setText(r9);
        ImageLoaderKt.u(r0.e, r6.c, "test");
        e1.d(r0.b, new d(r5, r6));
        e1.d(r0.c, new e(r5, r6));
        if (r6.g == false) goto L14;
        e1.x(r0.b);
        e1.x(r0.c);
    L16:
        if (r6.j == false) goto L18;
        e1.x(r0.g);
        r0.c.setText("");
        r0.c.setEnabled(false);
    L23:
        if (r6.k == false) goto L25;
        e1.x(r0.f);
        r0.b.setText("");
        r0.b.setEnabled(false);
        return;
    L25:
        e1.q(r0.f);
        RoundTextView r10 = r0.b;
        String r11 = r6.i;
        if (r11 == null) goto L29;
        r3 = r11;
    L29:
        r10.setText(r3);
        r0.b.setEnabled(true);
        return;
    L18:
        e1.q(r0.g);
        RoundTextView r12 = r0.c;
        String r13 = r6.h;
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        r12.setText(r13);
        r0.c.setEnabled(true);
        goto L23
    L14:
        e1.o(r0.b);
        e1.o(r0.c);
        goto L16
    }

    public final void P2(boolean r5, boolean r6) {
        LarusPermissionApplyCardViewBinding r0 = getBinding();
        if (r5 == false) goto L5;
        e1.x(r0.g);
        r0.c.setText("");
    L6:
        if (r6 == false) goto L8;
        e1.x(r0.f);
        r0.b.setText("");
    L9:
        if (r5 == true) goto L12;
        if (r6 == true) goto L12;
        boolean r7 = true;
    L13:
        r0.c.setEnabled(r7);
        r0.b.setEnabled(r7);
        return;
    L12:
        r7 = false;
        goto L13
    L8:
        e1.q(r0.f);
        r0.b.setText(this.e);
        goto L9
    L5:
        e1.q(r0.g);
        r0.c.setText(this.d);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P5(final mi8.d r12, final qm8.b r13) {
        Intrinsics.checkNotNullParameter(r12, "input");
        Intrinsics.checkNotNullParameter(r13, "output");
        this.c = r13;
        e1.x(this);
        boolean r0 = v19.h.a;
        if (v19.h.a(null) == false) goto L7;
        String r1 = r12.c;
        if (r1 != null) goto L10;
        r1 = r12.b;
    L10:
        String r2 = r12.d;
        String r3 = r12.e;
        String r4 = r12.f;
        String r5 = r12.h;
        String r6 = r12.g;
        final PermissionApplyCardView$bind$1 r7 = new PermissionApplyCardView$bind$1(r13);
        final PermissionApplyCardView$bind$2 r8 = new PermissionApplyCardView$bind$2(r13);
        LarusPermissionApplyCardViewBinding r9 = getBinding();
        if (r5 != null) goto L13;
        String r10 = "";
    L14:
        this.d = r10;
        if (r6 != null) goto L17;
        String r11 = "";
    L18:
        this.e = r11;
        TextView r14 = r9.j;
        if (r3 != null) goto L21;
        r3 = "";
    L21:
        r14.setText(r3);
        TextView r15 = r9.i;
        if (r4 != null) goto L24;
        r4 = "";
    L24:
        r15.setText(r4);
        TextView r16 = r9.h;
        if (r2 != null) goto L27;
        r2 = "";
    L27:
        r16.setText(r2);
        ImageLoaderKt.u(r9.e, r1, "test");
        e1.d(r9.b, new m(r8));
        e1.d(r9.c, new n(r7));
        e1.x(r9.b);
        e1.x(r9.c);
        e1.q(r9.g);
        RoundTextView r17 = r9.c;
        if (r5 != null) goto L30;
        r5 = "";
    L30:
        r17.setText(r5);
        r9.c.setEnabled(true);
        e1.q(r9.f);
        RoundTextView r18 = r9.b;
        if (r6 != null) goto L33;
        r6 = "";
    L33:
        r18.setText(r6);
        r9.b.setEnabled(true);
        ExposeXTrackerExtKt.b(this, new i(r12, r13));
        return;
    L17:
        r11 = r6;
        goto L18
    L13:
        r10 = r5;
        goto L14
    L7:
        r1 = r12.b;
        if (r1 != null) goto L10;
        r1 = r12.c;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(final p r5, ew3.d.a r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        this.b = r5.c;
        AppletGrantingWidgetDelegate r7 = AppletGrantingWidgetDelegate.a;     // Catch: Exception -> L8
        String r0 = r5.a;     // Catch: Exception -> L8
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        r7.c(r0, r5.b, new WeakReference(getCallback()));     // Catch: Exception -> L8
        ExposeXTrackerExtKt.b(this, new l(r5));     // Catch: Exception -> L8
        return;
    }
}
