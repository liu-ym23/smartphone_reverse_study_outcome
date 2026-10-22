package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final /* synthetic */ int g = 0;
    public final Context a;
    public final e b;
    public final ml5.b c;
    public f d;
    public boolean e;
    public final UDDialog f;

    public static final class a implements fp5.a.b {
        public final /* synthetic */ Ref.BooleanRef a;

        public a(Ref.BooleanRef r1) {
            this.a = r1;
        }

        @Override // fp5.a.b
        public final void a(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "checkBox");
            this.a.element = !r3;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ m a;
        public final /* synthetic */ Ref.BooleanRef b;

        public b(m r1, Ref.BooleanRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            ml5.b r4 = this.a.c;
            int r5 = m.g;
            r4.b("PREF_KEY_REMIND", Boolean.valueOf(this.b.element));
            this.a.b.onContinue();
            this.a.e = true;
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ m a;

        public c(m r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            m r3 = this.a;
            if (r3.e == true) goto L8;
            f r4 = r3.d;
            if (r4 == null) goto L9;
            r4.onCancel();
            return;
        L9:
            return;
        }
    }

    public static final class d {
    }

    public interface e {
        void onContinue();
    }

    public interface f {
        void onCancel();
    }

    static {
    }

    public final void a() {
        UDDialog r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    public final Context getContext() {
        return this.a;
    }

    public m(Context r4, e r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "confirmCallBack");
        this.a = r4;
        this.b = r5;
        ml5.b r0 = new ml5.b("download_sd_pref");
        this.c = r0;
        if (((Boolean) r0.a("PREF_KEY_REMIND", Boolean.TRUE)).booleanValue() == false) goto L5;
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        r6.element = true;
        fp5.a r1 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(r4).title(2131888315)).titleBold(true)).titleGravity(17)).message(2131888314)).messageGravity(8388611);
        r1.a = false;
        r1.a(r4.getString(2131888313));
        r1.d = 2131106607;
        a r7 = new a(r6);
        Intrinsics.checkNotNullParameter(r7, "value");
        r1.f = r7;
        this.f = ((fp5.a) ((fp5.a) ((fp5.a) r1.addActionButton(2131391777, 2131888310, new b(this, r6))).addActionButton(2131391778, 2131887170, null)).onDismissListener(new c(this))).build();
        return;
    L5:
        r5.onContinue();
    }
}
