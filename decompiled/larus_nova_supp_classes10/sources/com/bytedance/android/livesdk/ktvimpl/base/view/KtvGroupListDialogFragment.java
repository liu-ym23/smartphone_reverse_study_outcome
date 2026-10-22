package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.adapter.KtvGroupUserListAdapter;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvGroupListDialogFragment;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupListDialogFragment extends CommonBottomDialog {
    public RecyclerView a;
    public TextView b;
    public final CompositeDisposable c;
    public final long d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ KtvGroupListDialogFragment a;

        public b(KtvGroupListDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ KtvGroupListDialogFragment a;

        public c(KtvGroupListDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {
        public final /* synthetic */ KtvGroupListDialogFragment a;

        public d(KtvGroupListDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            if (this.a.c.isDisposed() == true) goto L6;
            this.a.c.dispose();
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566497;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        long r0 = System.currentTimeMillis();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getKtvGroupUser(String.valueOf(this.d), 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.base.view.d(this, r0), new e(this, r0)), this.c);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.b = (TextView) findViewById(2131376958);
        TextView r1 = (TextView) findViewById(2131376948);
        if (r1 == null) goto L5;
        r1.setOnClickListener(new b(this));
        r1.setText("x");
    L5:
        View r2 = findViewById(2131366972);
        if (r2 == null) goto L8;
        r2.setOnClickListener(new c(this));
    L8:
        RecyclerView r3 = findViewById(2131376955);
        if (r3 == null) goto L11;
        r3.setAdapter(new KtvGroupUserListAdapter(r3.getContext()));
        r3.setLayoutManager(new LinearLayoutManager(r3.getContext(), 1, false));
        Unit r6 = Unit.INSTANCE;
    L12:
        this.a = r3;
        setOnDismissListener(new d(this));
        return;
    L11:
        r3 = null;
        goto L12
    }

    public KtvGroupListDialogFragment(Context r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = r3;
        this.c = new CompositeDisposable();
    }
}
