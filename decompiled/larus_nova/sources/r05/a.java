package r05;

import android.content.Context;
import android.content.DialogInterface;
import androidx.core.view.GravityCompat;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535453a = 0;

    /* JADX INFO: renamed from: r05.a$a, reason: collision with other inner class name */
    public interface InterfaceC7408a {
        void onClick();
    }

    public static final class b {

        /* JADX INFO: renamed from: r05.a$b$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC7409a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterfaceC7408a f535454a;

            public DialogInterfaceOnClickListenerC7409a(InterfaceC7408a r100) {
                this.f535454a = r100;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                this.f535454a.onClick();
            }
        }

        /* JADX INFO: renamed from: r05.a$b$b, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC7410b implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final DialogInterfaceOnClickListenerC7410b f535455a = null;

            static {
                f535455a = new DialogInterfaceOnClickListenerC7410b();
            }

            public DialogInterfaceOnClickListenerC7410b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                if (r100 == null) goto L5;
                r100.dismiss();
                return;
            }
        }

        @JvmStatic
        public static void a(Context r100, String r101, int r102, InterfaceC7408a r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "token");
            Intrinsics.checkNotNullParameter(r103, "clickListener");
            UDBaseDialogBuilder.ActionBottomOrientation r104 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            fp5.a r105 = new fp5.a(r100).title(r100.getResources().getString(R.string.LarkCCM_Docs_AppLinkDoc_Unlink_Title)).titleGravity(17).message(r100.getText(R.string.LarkCCM_Docs_AppLinkDoc_Unlink_Desc)).messageGravity(GravityCompat.START);
            r105.f478274e = false;
            UDDialog r106 = r105.actionButtonOrientation(r104).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).textColorRes(R.color.function_danger_500).text(r100.getText(R.string.LarkCCM_Docs_AppLinkDoc_Unlink_Tooltip)).onClickListener(new DialogInterfaceOnClickListenerC7409a(r103))).addActionButton(R.id.ud_dialog_btn_secondary, r100.getText(R.string.LarkCCM_Docs_AppLinkDoc_Cancel_Button), DialogInterfaceOnClickListenerC7410b.f535455a).build();
            if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r106);
        L7:
            ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(r101, r102, r106);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L6:
            DialogLancet.beforeDialogShow(r106);
            r106.show();
            DialogLancet.afterDialogShow(r106);
            goto L7
        }
    }

    static {
    }
}
