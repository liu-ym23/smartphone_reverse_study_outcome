package com.bytedance.ee.bear.middleground.comment.permission;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/permission/CommentCollaboratorControlFragmentV2;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "visibilityType", "", "isWhole", "", "pageType", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "<init>", "(IZLcom/ss/android/lark/docs/icon/util/DocumentType;)V", "callback", "Lcom/bytedance/ee/bear/middleground/comment/permission/CommentCollaboratorControlFragmentV2$ICommentControlCallback;", "swAccessPrivate", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "tvDone", "Landroid/widget/TextView;", "tvAccess", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "ICommentControlCallback", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentCollaboratorControlFragmentV2 extends CompatLandscapeBottomSheetDialogFragment {
    public static final /* synthetic */ int r = 0;
    public final int k;
    public final boolean l;
    public final sbb.e m;
    public b n;
    public UDSwitch o;
    public TextView p;
    public TextView q;

    public static final class a {
    }

    public interface b {
        void a(int r1);

        void onDismiss();
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ CommentCollaboratorControlFragmentV2 a;

        public c(CommentCollaboratorControlFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r1, boolean r2) {
            b r3 = this.a.n;
            if (r3 == null) goto L6;
            r3.a(r2 ? 1 : 0);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CommentCollaboratorControlFragmentV2 a;

        public d(CommentCollaboratorControlFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.n;
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

    public static final class e extends ClickableSpan {
        public final /* synthetic */ CommentCollaboratorControlFragmentV2 a;

        public e(CommentCollaboratorControlFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r4) {
            Intrinsics.checkNotNullParameter(r4, "widget");
            int r0 = com.bytedance.ee.bear.middleground.comment.card.e.a;
            if (Intrinsics.areEqual(this.a.m, sbb.e.i) == false) goto L6;
            int r1 = 2131889709;
        L12:
            new UDDialogBuilder(r4.getContext()).title(2131889220).message(r1).addActionButton(2131391777, 2131889222, null).show();
            return;
        L6:
            if (com.bytedance.ee.bear.middleground.comment.card.e.b(this.a.m) == false) goto L9;
            r1 = 2131889712;
            goto L12
        L9:
            if (this.a.l == false) goto L11;
            r1 = 2131889071;
            goto L12
        L11:
            r1 = 2131889223;
            goto L12
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "ds");
            super.updateDrawState(r3);
            r3.setUnderlineText(false);
            r3.setColor(ContextCompat.getColor(LarkContext.getApplication(), 2131106616));
        }
    }

    static {
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        b r3 = this.n;
        if (r3 == null) goto L6;
        r3.onDismiss();
        return;
    }

    public final void da0(FragmentManager r3, b r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        Intrinsics.checkNotNullParameter(r4, "callback");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "CommentCollaboratorControlFragmentV2", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L10;
    L7:
        this.n = r4;
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        show(r3, "CommentCollaboratorControlFragmentV2");
        goto L7
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r5, r6);
        UDSwitch r7 = this.o;
        if (r7 != null) goto L5;
    L9:
        TextView r8 = this.p;
        if (r8 == null) goto L12;
        r8.setOnClickListener(new d(this));
    L12:
        int r9 = com.bytedance.ee.bear.middleground.comment.card.e.a;
        if (Intrinsics.areEqual(this.m, sbb.e.i) == false) goto L16;
        int r10 = 2131889708;
    L22:
        String r11 = getString(r10);
        String r12 = getString(2131889219);
        SpannableStringBuilder r0 = new SpannableStringBuilder().append(r11);
        r0.append(r12).setSpan(new e(this), r11.length(), r11.length() + r12.length(), 33);
        TextView r13 = this.q;
        if (r13 == null) goto L26;
        r13.setMovementMethod(LinkMovementMethod.getInstance());
        r13.setText(r0);
        return;
    L26:
        return;
    L16:
        if (this.l == false) goto L19;
    L20:
        r10 = 2131889711;
        goto L22
    L19:
        if (com.bytedance.ee.bear.middleground.comment.card.e.b(this.m) == true) goto L20;
        r10 = 2131889221;
        goto L22
    L5:
        if (this.k == 0) goto L7;
        boolean r14 = true;
    L8:
        r7.setChecked(r14);
        r7.setOnCheckedChangeListener(new c(this));
        goto L9
    L7:
        r14 = false;
        goto L8
    }

    public CommentCollaboratorControlFragmentV2(int r2, boolean r3, sbb.e r4) {
        Intrinsics.checkNotNullParameter(r4, "pageType");
        this.k = r2;
        this.l = r3;
        this.m = r4;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131559859, r3, false);
        this.o = r5.findViewById(2131361974);
        this.p = (TextView) r5.findViewById(2131369396);
        this.q = (TextView) r5.findViewById(2131361978);
        return r5;
    }
}
