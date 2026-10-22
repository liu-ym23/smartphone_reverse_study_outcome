package vi5;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.middleground.permission.widget.editpermdialog.EditPermAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f555329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Dialog f555330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditPermAdapter f555331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UDAvatar f555332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpaceTagTitleView f555333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f555334f;

    public final void b() {
        Dialog r100 = this.f555330b;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L7;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final Context getContext() {
        return this.f555329a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f555329a = r100;
        Dialog r101 = new Dialog(r100, R.style.ActionSheetDialogStyle);
        this.f555330b = r101;
        EditPermAdapter r102 = new EditPermAdapter();
        this.f555331c = r102;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.perm_edit_perm_dialog_layout, null);
        r101.setContentView(r103);
        Window r104 = r101.getWindow();
        Intrinsics.checkNotNull(r104);
        a(r104).setPadding(0, 0, 0, 0);
        r104.setGravity(8388691);
        WindowManager.LayoutParams r105 = r104.getAttributes();
        Configuration r106 = r100.getResources().getConfiguration();
        Intrinsics.checkNotNull(r105);
        int r107 = r106.orientation;
        if (2 != r107) goto L8;
        r105.width = (int) (n.q(r100) * 0.7f);
        Window r108 = r101.getWindow();
        if (r108 == null) goto L13;
        r108.setGravity(81);
        Unit r109 = Unit.INSTANCE;
    L13:
        r104.setAttributes(r105);
        ((RecyclerView) r103.findViewById(R.id.permContainer)).setAdapter(r102);
        ((RecyclerView) r103.findViewById(R.id.permContainer)).setLayoutManager(new LinearLayoutManagerWrapper(r100));
        this.f555332d = (UDAvatar) r103.findViewById(R.id.avatarView);
        this.f555333e = (SpaceTagTitleView) r103.findViewById(R.id.memberNameTitle);
        this.f555334f = (TextView) r103.findViewById(R.id.memberLabel);
        return;
    L8:
        if (1 != r107) goto L12;
        r105.width = -1;
        Window r110 = r101.getWindow();
        if (r110 == null) goto L13;
        r110.setGravity(8388691);
        Unit r111 = Unit.INSTANCE;
        goto L13
    L12:
        tt5.a.h("EditPermDialog", "onConfigurationChanged");
        Unit r112 = Unit.INSTANCE;
        goto L13
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void c(UserInfo r100, String r110, int r111, ArrayList<c> r112) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "permItemList");
        pg5.a.b(this.f555332d, r100);
        Locale r101 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        AccountService$Account r102 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        this.f555333e.setTitle(r100.getDisplayName(r101));
        SpaceTagTitleView r103 = this.f555333e;
        int r104 = SpaceTagType.f240339e;
        r103.setLabels(new SpaceTagType[]{SpaceTagType.Companion.f(r100.getOrganizationTagValue(), r100.isExternal(), ui5.c.a(r102)), SpaceTagType.Companion.a(r100.isApp())});
        if (r100.getOwnerType() != 2) goto L6;
        this.f555334f.setVisibility(0);
        this.f555334f.setText(r100.getLabel());
    L27:
        this.f555331c.setNewData(r112);
        f r105 = WindowInsetsUtils.a(this.f555330b);
        r105.i(n.h(this.f555329a, R.color.bg_body));
        r105.o(true);
        r105.r(true);
        Dialog r106 = this.f555330b;
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r106);
    L32:
        zo5.b r107 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        Window r113 = this.f555330b.getWindow();
        if (r113 != null) goto L35;
    L37:
        r107.j(r110, r111, this.f555330b);
        return;
    L35:
        if ((a(r113) instanceof FrameLayout) == false) goto L37;
        Window r114 = this.f555330b.getWindow();
        Intrinsics.checkNotNull(r114);
        View r115 = a(r114);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.widget.FrameLayout");
        r107.detachWatermark((FrameLayout) r115);
        goto L37
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L31:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        goto L32
    L6:
        if (r100.getOwnerType() != 29) goto L9;
        this.f555334f.setVisibility(0);
        this.f555334f.setText(this.f555329a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r111, R.string.LarkCCM_ChatShare_EmailInviteWithoutLogin_Desc, R.string.LarkCCM_Docs_InviteEmail_Note_Descrip)));
        goto L27
    L9:
        if (r100.getOwnerType() != 5) goto L11;
    L26:
        this.f555334f.setVisibility(8);
        goto L27
    L11:
        if (r100.getOwnerType() == 11) goto L26;
        if (r100.getOwnerType() == 16) goto L26;
        if (r100.getOwnerType() == 18) goto L26;
        String r108 = r100.getDisplayLabel();
        if (r108 != null) goto L19;
    L22:
        boolean r109 = true;
    L23:
        if (r109 == true) goto L26;
        this.f555334f.setVisibility(0);
        this.f555334f.setText(r100.getDisplayLabel());
        goto L27
    L19:
        if (r108.length() == 0) goto L22;
        r109 = false;
        goto L23
    }
}
