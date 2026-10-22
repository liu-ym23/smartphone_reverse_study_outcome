package r05;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: r05.a$a, reason: collision with other inner class name */
    public interface InterfaceC0278a {
        void onClick();
    }

    public static final class b {

        /* JADX INFO: renamed from: r05.a$b$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0279a implements DialogInterface.OnClickListener {
            public final /* synthetic */ InterfaceC0278a a;

            public DialogInterfaceOnClickListenerC0279a(InterfaceC0278a r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                this.a.onClick();
            }
        }

        /* JADX INFO: renamed from: r05.a$b$b, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0280b implements DialogInterface.OnClickListener {
            public static final DialogInterfaceOnClickListenerC0280b a = null;

            static {
                a = new DialogInterfaceOnClickListenerC0280b();
            }

            public DialogInterfaceOnClickListenerC0280b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                if (r1 == null) goto L5;
                r1.dismiss();
                return;
            }
        }

        @JvmStatic
        public static void a(Context r4, String r5, int r6, InterfaceC0278a r7) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "token");
            Intrinsics.checkNotNullParameter(r7, "clickListener");
            UDBaseDialogBuilder.ActionBottomOrientation r0 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            fp5.a r1 = new fp5.a(r4).title(r4.getResources().getString(2131888957)).titleGravity(17).message(r4.getText(2131888956)).messageGravity(8388611);
            r1.e = false;
            UDDialog r8 = r1.actionButtonOrientation(r0).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102080).text(r4.getText(2131888958)).onClickListener(new DialogInterfaceOnClickListenerC0279a(r7))).addActionButton(2131391778, r4.getText(2131888946), DialogInterfaceOnClickListenerC0280b.a).build();
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r8);
        L7:
            ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(r5, r6, r8);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L6:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
            goto L7
        }
    }

    static {
    }
}
