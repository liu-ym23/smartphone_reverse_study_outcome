package com.bytedance.ee.bear.lark.selector.auth;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.dialog.BottomSheetListDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocAuthSelectorDialog extends AppCompatDialogFragment {
    public d d;
    public List<DocResult> e;
    public boolean f;

    public class a implements ChatDocAuthSeletorAdapter.a {
        public final /* synthetic */ ChatDocAuthSeletorAdapter a;
        public final /* synthetic */ DocAuthSelectorDialog b;

        public a(DocAuthSelectorDialog r1, ChatDocAuthSeletorAdapter r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ ChatDocAuthSeletorAdapter a;
        public final /* synthetic */ DocAuthSelectorDialog b;

        public b(DocAuthSelectorDialog r1, ChatDocAuthSeletorAdapter r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            this.b.f = true;
            ChatDocAuthSeletorAdapter r6 = this.a;
            r6.getClass();
            ArrayList r7 = new ArrayList(r6.e.size());
            Iterator<Integer> r0 = r6.e.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Integer r1 = r0.next();
            r7.add((DocResult) ListProtector.get(r6.c, r1.intValue()));
            goto L4
        L6:
            HashMap<String, DocPermPair.PermType> r8 = this.a.d;
            HashMap r2 = new HashMap();
            Iterator r9 = r7.iterator();
        L8:
            if (r9.hasNext() == false) goto L10;
            String r3 = ((DocResult) r9.next()).getDoc().getUrl();
            r2.put(r3, r8.get(r3));
            goto L8
        L10:
            DocAuthSelectorDialog r10 = this.b;
            r10.getClass();
            r10.dismissAllowingStateLoss();     // Catch: Exception -> L13
        L17:
            d r11 = r10.d;
            if (r11 == null) goto L25;
            r11.a(r2);
            return;
        L25:
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r12 = DialogFragmentLancet.sLastShowStack;
            if (r12 == null) goto L17;
            com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L17
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ DocAuthSelectorDialog a;

        public c(DocAuthSelectorDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            DocAuthSelectorDialog r3 = this.a;
            r3.f = true;
            d r4 = r3.d;
            if (r4 == null) goto L6;
            r4.b();
            return;
        }
    }

    public interface d {
        void a(Map<String, DocPermPair.PermType> r1);

        void b();

        void onCanceled();
    }

    public DocAuthSelectorDialog() {
        this.f = false;
    }

    public final void S90(FragmentActivity r3) {
        FragmentManager r4 = r3.getSupportFragmentManager();
        String r0 = getClass().getSimpleName();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r0, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r1) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r4, r0);
        return;
    }

    public final Dialog onCreateDialog(Bundle r5) {
        if (this.e != null) goto L16;
        HashMap r6 = new HashMap();
        dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        d r0 = this.d;
        if (r0 == null) goto L20;
        r0.a(r6);
        return null;
    L20:
        return null;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L16:
        ChatDocAuthSeletorAdapter r7 = new ChatDocAuthSeletorAdapter(getContext(), this.e);
        r7.b = new a(this, r7);
        BottomSheetListDialog.d r2 = new BottomSheetListDialog.d(getActivity());
        r2.b = false;
        r2.c = getString(2131891557);
        r2.e = r7;
        r2.d = getString(2131891554);
        String r3 = getString(2131892230);
        c r4 = new c(this);
        r2.f = r3;
        r2.g = r4;
        String r8 = UIHelper.mustacheFormat(2131891553, "count", Integer.toString(r7.e.size()));
        b r9 = new b(this, r7);
        r2.j = true;
        r2.h = r8;
        r2.i = r9;
        return new BottomSheetListDialog(r2);
    }

    public final void onDismiss(DialogInterface r2) {
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L10
        if (this.f == true) goto L8;
        d r3 = this.d;     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        r3.onCanceled();     // Catch: Throwable -> L10
    L7:
        this.f = false;     // Catch: Throwable -> L10
    L8:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L10:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}
