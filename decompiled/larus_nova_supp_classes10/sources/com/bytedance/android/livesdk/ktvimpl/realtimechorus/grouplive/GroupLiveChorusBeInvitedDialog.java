package com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/grouplive/GroupLiveChorusBeInvitedDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GroupLiveChorusBeInvitedDialog extends LiveDialogFragment {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable d;
    public MusicPanel e;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ GroupLiveChorusBeInvitedDialog a;

        public b(GroupLiveChorusBeInvitedDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r4) {
            GroupLiveChorusBeInvitedDialog r5 = this.a;
            int r0 = GroupLiveChorusBeInvitedDialog.f;
            Dialog r1 = r5.getDialog();
            Object r2 = null;
            if (r1 == null) goto L5;
            View r3 = r1.getCurrentFocus();
        L6:
            Context r6 = r5.getContext();
            if (r3 == null) goto L20;
            if (r6 == null) goto L23;
            Object r7 = r6.getSystemService("input_method");
            if ((r7 instanceof InputMethodManager) == false) goto L14;
            r2 = r7;
        L14:
            InputMethodManager r8 = (InputMethodManager) r2;
            if (r8 != null) goto L17;
            return;
        L17:
            if (r8.isActive() != true) goto L22;
            r8.hideSoftInputFromWindow(r3.getWindowToken(), 0);
            return;
        L22:
            return;
        L23:
            return;
        L20:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ Ref.IntRef a;

        public c(Ref.IntRef r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a.element) - r6.longValue());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ GroupLiveChorusBeInvitedDialog b;

        public d(TextView r1, GroupLiveChorusBeInvitedDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.setText(s1.C(2131917997, new Object[]{Integer.valueOf((int) r6.longValue())}));
            if (r6.longValue() != 0) goto L14;
            GroupLiveChorusBeInvitedDialog r7 = this.b;
            int r0 = GroupLiveChorusBeInvitedDialog.f;
            r7.getClass();
            ALogger.i("GuestTalkBeInvitedDialog", "refuseInvite, isTimeLimit: true");
            r7.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L15;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        }
    }

    static {
    }

    public GroupLiveChorusBeInvitedDialog() {
        this.d = new CompositeDisposable();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.d.isDisposed() == true) goto L6;
        this.d.dispose();
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(false);
        return r3;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        ImageView r8 = (ImageView) r6.findViewById(2131374209);
        IInteractService r0 = k.f(IInteractService.class);
        String r1 = null;
        if (r0 == null) goto L24;
        i r2 = r0.getLinkUserInfoCenter();
        if (r2 == null) goto L24;
        List r3 = r2.getOnlineUserList();
        if (r3 == null) goto L24;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L18;
        Object r5 = r4.next();
        IBaseUser r9 = ((ILinkPlayerInfoBridge) r5).getUser();
        if (r9 == null) goto L14;
        String r10 = r9.getIdString();
    L16:
        if (Intrinsics.areEqual(r10, je0.d.a()) == false) goto L10;
    L19:
        ILinkPlayerInfoBridge r11 = (ILinkPlayerInfoBridge) r5;
        if (r11 == null) goto L24;
        IBaseUser r12 = r11.getUser();
        if (r12 == null) goto L24;
        py.k r13 = r12.getAvatarMedium();
    L25:
        a1.v(r8, r13, 2131251889);
        TextView r14 = (TextView) r6.findViewById(2131387625);
        if (r14 == null) goto L35;
        StringBuilder r15 = new StringBuilder("正在唱《");
        MusicPanel r16 = this.e;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("currentMusic");
    L30:
        if (r16 == null) goto L34;
        KtvMusic r17 = r16.a;
        if (r17 == null) goto L34;
        r1 = r17.getTitle();
    L34:
        r15.append(r1);
        r15.append(12299);
        r14.setText(r15.toString());
    L35:
        ((TextView) r6.findViewById(2131361963)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        final Ref.IntRef r18 = new Ref.IntRef();
        r18.element = 9;
        TextView r19 = (TextView) r6.findViewById(2131384151);
        if (r19 == null) goto L42;
        r19.setText(s1.C(2131917997, new Object[]{Integer.valueOf(r18.element)}));
        r19.setOnClickListener(x0.a(new GroupLiveChorusBeInvitedDialog$onViewCreated$$inlined$let$lambda$1(this, r18)));
        this.d.add(du2.a.d(1, TimeUnit.SECONDS).take(r18.element + 1).map(new c(r18)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r19, this)));
        return;
    L42:
        return;
    L14:
        r10 = null;
        goto L16
    L18:
        r5 = null;
    L24:
        r13 = null;
        goto L25
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565475, r3, false);
    }
}
