package com.bytedance.ee.bear.middleground.comment.permission;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.k;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.m;
import com.bytedance.ee.bear.middleground.comment.adapter.aside.AsideCommentCardAdapter;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0002*+B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J\b\u0010$\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0016J\u001c\u0010(\u001a\u00020\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/permission/CommentCollaboratorControlPadFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "visibilityType", "", "isWhole", "", "activity", "Landroid/app/Activity;", "archView", "Landroid/view/View;", "pageType", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "<init>", "(IZLandroid/app/Activity;Landroid/view/View;Lcom/ss/android/lark/docs/icon/util/DocumentType;)V", "callback", "Lcom/bytedance/ee/bear/middleground/comment/permission/CommentCollaboratorControlPadFragment$ICommentControlCallback;", "swAccessPrivate", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "tvDone", "Landroid/widget/TextView;", "tvAccess", "configChangeListener", "Landroid/content/ComponentCallbacks;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "configurePadModeDialog", "onCancel", "Companion", "ICommentControlCallback", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentCollaboratorControlPadFragment extends AppCompatDialogFragment {
    public static final /* synthetic */ int n = 0;
    public final int d;
    public final boolean e;
    public final Activity f;
    public final View g;
    public final e h;
    public b i;
    public UDSwitch j;
    public TextView k;
    public TextView l;
    public k m;

    public static final class a {
    }

    public interface b {
        void a(int r1);

        void onDismiss();
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ CommentCollaboratorControlPadFragment a;

        public c(CommentCollaboratorControlPadFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r1, boolean r2) {
            b r3 = this.a.i;
            if (r3 == null) goto L6;
            r3.a(r2 ? 1 : 0);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CommentCollaboratorControlPadFragment a;

        public d(CommentCollaboratorControlPadFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.i;
            if (r3 == null) goto L13;
            r3.onDismiss();
        L13:
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Activity r0 = this.f;
        View r1 = this.g;
        if (r0 == null) goto L17;
        if (r1 == null) goto L17;
        Rect r2 = m.b(r1);
        int r3 = UIUtils.dp2px(r0, 320.0f);
        dib.a r4 = m.a(r0, r2, r3, UIUtils.dp2px(r0, 120.0f));
        int r5 = r4.a;
        int r6 = r4.b;
        Dialog r7 = getDialog();
        if (r7 == null) goto L14;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L14;
        WindowManager.LayoutParams r9 = r8.getAttributes();
        if (r9 != null) goto L13;
        r9 = new WindowManager.LayoutParams();
    L13:
        r9.gravity = 8388659;
        r9.width = r3;
        r9.height = -2;
        r9.x = r5;
        r9.y = r6;
        r8.setAttributes(r9);
    L14:
        Dialog r10 = getDialog();
        if (r10 == null) goto L17;
        l.b(r0, r10);
    L17:
        Activity r11 = this.f;
        if (r11 == null) goto L23;
        Dialog r12 = getDialog();
        if (r12 == null) goto L24;
        int r13 = l.a;
        k r14 = l.c(r11, r12);
        this.m = r14;
        r11.registerComponentCallbacks(r14);
        return;
    L24:
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        b r3 = this.i;
        if (r3 == null) goto L6;
        r3.onDismiss();
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L9
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L9
        ComponentCallbacks r3 = this.m;     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        Activity r0 = this.f;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.unregisterComponentCallbacks(r3);     // Catch: Throwable -> L9
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void S90(FragmentManager r3, AsideCommentCardAdapter.i r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        Intrinsics.checkNotNullParameter(r4, "callback");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "CommentCollaboratorControlPadFragment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L10;
    L7:
        this.i = r4;
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super/*androidx.fragment.app.DialogFragment*/.show(r3, "CommentCollaboratorControlPadFragment");
        goto L7
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        UDSwitch r4 = this.j;
        boolean r5 = false;
        if (r4 != null) goto L5;
    L9:
        TextView r6 = this.k;
        if (r6 == null) goto L12;
        r6.setOnClickListener(new d(this));
    L12:
        e r7 = this.h;
        if (r7 == null) goto L15;
        r5 = com.bytedance.ee.bear.middleground.comment.card.e.b(r7);
    L15:
        int r8 = com.bytedance.ee.bear.middleground.comment.card.e.a;
        if (Intrinsics.areEqual(this.h, e.i) == false) goto L19;
        int r9 = 2131889708;
    L24:
        String r10 = getString(r9);
        SpannableStringBuilder r11 = new SpannableStringBuilder().append(r10);
        TextView r12 = this.l;
        if (r12 == null) goto L28;
        r12.setMovementMethod(LinkMovementMethod.getInstance());
        r12.setText(r11);
        return;
    L28:
        return;
    L19:
        if (this.e == true) goto L22;
        if (r5 == true) goto L22;
        r9 = 2131889221;
    L22:
        r9 = 2131889711;
        goto L24
    L5:
        if (this.d == 0) goto L7;
        boolean r0 = true;
    L8:
        r4.setChecked(r0);
        r4.setOnCheckedChangeListener(new c(this));
        goto L9
    L7:
        r0 = false;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131559858, r3, false);
        this.j = r5.findViewById(2131361974);
        this.k = (TextView) r5.findViewById(2131369396);
        this.l = (TextView) r5.findViewById(2131361978);
        return r5;
    }

    public CommentCollaboratorControlPadFragment(int r1, FragmentActivity r2, View r3, e r4) {
        this.d = r1;
        this.e = false;
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }
}
