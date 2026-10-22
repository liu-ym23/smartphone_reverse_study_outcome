package com.bytedance.ee.bear.list.move;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bizwidget.at.AtUserSupportTextView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.disposables.Disposable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010)\u001a\u00020%H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020+H\u0016J\b\u0010/\u001a\u00020+H\u0016J\b\u00100\u001a\u00020+H\u0016J\b\u00101\u001a\u00020+H\u0016J\b\u00102\u001a\u00020'H&J\b\u00103\u001a\u00020+H\u0004J\b\u00104\u001a\u00020'H\u0016J\b\u00105\u001a\u00020'H\u0002J\b\u00106\u001a\u00020'H\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0016J\u0006\u0010:\u001a\u00020;R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006>"}, d2 = {"Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "disposable", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "reviewer", "Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment$ApplyReviewer;", "getReviewer", "()Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment$ApplyReviewer;", "setReviewer", "(Lcom/bytedance/ee/bear/list/move/ApplyMoveFragment$ApplyReviewer;)V", "applyMoveInputView", "Landroid/widget/TextView;", "getApplyMoveInputView", "()Landroid/widget/TextView;", "setApplyMoveInputView", "(Landroid/widget/TextView;)V", "applyMoveTitle", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getApplyMoveTitle", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setApplyMoveTitle", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getLayoutResId", "", "onViewCreated", "", "view", "getDescFormatStringId", "getDescFormatKey", "", "jumpHelpCenter", "getHelpCenterUrl", "getHelpCenterPointKey", "getFeishuArticalId", "getLarkArticalId", "getHelpQuery", "sendApply", "getUserName", "onStart", "addWatermark", "dispose", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "isShow", "", "Companion", "ApplyReviewer", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ApplyMoveFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int l = 0;
    public Disposable h;
    public a i;
    public TextView j;
    public BaseTitleBar k;

    public interface a {
        String a();

        String b();

        String getEnName();

        String getId();

        String getName();
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ApplyMoveFragment a;

        public c(ApplyMoveFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            ApplyMoveFragment r7 = this.a;
            int r0 = ApplyMoveFragment.l;
            r7.getClass();
            com.bytedance.ee.bear.route.h r1 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            s45.h r2 = s45.g.a;
            r1.u5(s45.g.a.a(r7.da0(), r7.ca0(), r7.fa0(), MapsKt.mapOf(TuplesKt.to("from", r7.ea0()))));
        }
    }

    public static final class d extends t {
        public final /* synthetic */ ApplyMoveFragment c;

        public d(ApplyMoveFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            tt5.a.h("ApplyMoveFragment", "on click back.");
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e extends t {
        public final /* synthetic */ ApplyMoveFragment c;

        public e(ApplyMoveFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            tt5.a.h("ApplyMoveFragment", "on click send.");
            this.c.ia0();
        }
    }

    public static final class f implements ov4.b.a {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void a(String r4) {
            tt5.a.h("ApplyMoveFragment", "on click userSpace. uid = " + r4);
            ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(r4, "");
        }
    }

    static {
    }

    public String aa0() {
        return "user";
    }

    public int ba0() {
        return 2131887481;
    }

    public String ca0() {
        return "394436478773";
    }

    public String da0() {
        return "cm_apply_move";
    }

    public String ea0() {
        return "ccm_permission_move";
    }

    public String fa0() {
        return "756157089386";
    }

    public int ga0() {
        return 2131558720;
    }

    public abstract void ia0();

    public final void Z90() {
        Disposable r0 = this.h;
        if (r0 == null) goto L14;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L15;
        Disposable r2 = this.h;
        if (r2 == null) goto L16;
        r2.dispose();
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r0.isDisposed() == true) goto L9;
        r1 = true;
        goto L9
    }

    public final String ha0() {
        a r0 = this.i;
        if (r0 == null) goto L6;
        String r1 = r0.getName();
        if (r1 == null) goto L6;
    L7:
        String r2 = null;
        String r3 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        if (Locale.CHINESE.getLanguage().equals(r3) == false) goto L21;
        tt5.a.h("ApplyMoveFragment", "language is chinese.");
        a r4 = this.i;
        if (r4 == null) goto L13;
        r2 = r4.b();
    L13:
        if (TextUtils.isEmpty(r2) == true) goto L43;
        a r5 = this.i;
        if (r5 == null) goto L44;
        String r6 = r5.b();
        if (r6 != null) goto L45;
        return r1;
    L45:
        return r6;
    L44:
        return r1;
    L43:
        return r1;
    L21:
        if (Locale.JAPANESE.getLanguage().equals(r3) == false) goto L33;
        tt5.a.h("ApplyMoveFragment", "language is japanese");
        a r7 = this.i;
        if (r7 == null) goto L26;
        r2 = r7.a();
    L26:
        if (TextUtils.isEmpty(r2) == true) goto L46;
        a r8 = this.i;
        if (r8 == null) goto L47;
        r6 = r8.a();
        if (r6 != null) goto L45;
        return r1;
    L47:
        return r1;
    L46:
        return r1;
    L33:
        if (Locale.ENGLISH.getLanguage().equals(r3) == false) goto L48;
        tt5.a.h("ApplyMoveFragment", "language is english");
        a r9 = this.i;
        if (r9 == null) goto L38;
        r2 = r9.getEnName();
    L38:
        if (TextUtils.isEmpty(r2) == true) goto L49;
        a r10 = this.i;
        if (r10 == null) goto L50;
        r6 = r10.getEnName();
        if (r6 != null) goto L45;
        return r1;
    L50:
        return r1;
    L49:
        return r1;
    L48:
        return r1;
    L6:
        r1 = "";
        goto L7
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        return;
    L9:
        return;
    }

    public ApplyMoveFragment() {
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        Z90();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r11, r12);
        this.k = (BaseTitleBar) r11.findViewById(2131393220);
        this.j = (TextView) r11.findViewById(2131363190);
        ImageView r1 = new ImageView(getContext());
        r1.setImageResource(2131255085);
        r1.setVisibility(0);
        int r3 = com.bytedance.ee.util.ui.n.d(6) + com.bytedance.ee.util.ui.n.d(15);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(com.bytedance.ee.util.ui.n.d(15), com.bytedance.ee.util.ui.n.d(15));
        r5.leftMargin = -r3;
        r5.bottomMargin = com.bytedance.ee.util.ui.n.d(4);
        BaseTitleBar r4 = this.k;
        if (r4 == null) goto L5;
        TextView r6 = r4.h;
        r6.setPadding(r6.getPaddingLeft(), r4.h.getPaddingTop(), r4.h.getPaddingRight() + r3, r4.h.getPaddingBottom());
        r5.addRule(1, r4.h.getId());
        r5.addRule(8, r4.h.getId());
        r4.g.addView(r1, r5);
    L5:
        r1.setOnClickListener(new c(this));
        ((BaseTitleBar) r11.findViewById(2131393220)).setLeftClickListener(new d(this));
        Context r2 = getContext();
        a r7 = this.i;
        if (r7 == null) goto L9;
        String r8 = r7.getId();
        if (r8 == null) goto L9;
    L10:
        ov4.b r13 = new ov4.b(r2, r8, ha0(), f.a);
        AtUserSupportTextView r9 = r11.findViewById(2131393218);
        String r10 = xo5.a.c(getContext(), ba0(), aa0(), "@".concat(ha0()));
        r9.getClass();
        if (TextUtils.isEmpty(r10) == false) goto L14;
        tt5.a.h("AtUserSupportTextView", "setSingleUserSpanText()...text is empty");
    L20:
        ((Button) r11.findViewById(2131393219)).setOnClickListener(new e(this));
        this.j = (TextView) r11.findViewById(2131363190);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(getDialog());
        return;
    L14:
        if (r10.contains("@") == true) goto L16;
        tt5.a.h("AtUserSupportTextView", "setSingleUserSpanText()...@ is not exist");
        r9.setText(r10);
        goto L20
    L16:
        SpannableStringBuilder r14 = new SpannableStringBuilder();
        r14.append(r10);
        int r15 = r10.indexOf("@");
        if (r15 == (-1)) goto L19;
        r14.setSpan(r13, r15, (r15 + 1) + r13.c.length(), 34);
    L19:
        r9.setText(r14);
        r9.setMovementMethod(LinkMovementMethod.getInstance());
    L9:
        r8 = "";
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(ga0(), r3, false);
    }
}
