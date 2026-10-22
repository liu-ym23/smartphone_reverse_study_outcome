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
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.middleground.permission.widget.editpermdialog.EditPermAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final Context a;
    public final Dialog b;
    public final EditPermAdapter c;
    public final UDAvatar d;
    public final SpaceTagTitleView e;
    public final TextView f;

    public final void b() {
        Dialog r0 = this.b;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r0));
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this.a = r9;
        Dialog r0 = new Dialog(r9, 2131951622);
        this.b = r0;
        EditPermAdapter r1 = new EditPermAdapter();
        this.c = r1;
        View r2 = LayoutInflater.from(r9).inflate(2131564172, null);
        r0.setContentView(r2);
        Window r3 = r0.getWindow();
        Intrinsics.checkNotNull(r3);
        a(r3).setPadding(0, 0, 0, 0);
        r3.setGravity(8388691);
        WindowManager.LayoutParams r5 = r3.getAttributes();
        Configuration r6 = r9.getResources().getConfiguration();
        Intrinsics.checkNotNull(r5);
        int r7 = r6.orientation;
        if (2 != r7) goto L8;
        r5.width = (int) (n.q(r9) * 0.7f);
        Window r4 = r0.getWindow();
        if (r4 == null) goto L13;
        r4.setGravity(81);
        Unit r8 = Unit.INSTANCE;
    L13:
        r3.setAttributes(r5);
        r2.findViewById(2131382105).setAdapter(r1);
        r2.findViewById(2131382105).setLayoutManager(new LinearLayoutManagerWrapper(r9));
        this.d = r2.findViewById(2131363638);
        this.e = (SpaceTagTitleView) r2.findViewById(2131379842);
        this.f = (TextView) r2.findViewById(2131379838);
        return;
    L8:
        if (1 != r7) goto L12;
        r5.width = -1;
        Window r10 = r0.getWindow();
        if (r10 == null) goto L13;
        r10.setGravity(8388691);
        Unit r11 = Unit.INSTANCE;
        goto L13
    L12:
        tt5.a.h("EditPermDialog", "onConfigurationChanged");
        Unit r12 = Unit.INSTANCE;
        goto L13
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void c(UserInfo r9, String r10, int r11, ArrayList<c> r12) {
        Intrinsics.checkNotNullParameter(r9, "userInfo");
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r12, "permItemList");
        pg5.a.b(this.d, r9);
        Locale r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        AccountService.Account r3 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        this.e.setTitle(r9.getDisplayName(r0));
        SpaceTagTitleView r1 = this.e;
        int r6 = SpaceTagType.e;
        r1.setLabels(new SpaceTagType[]{SpaceTagType.Companion.f(r9.getOrganizationTagValue(), r9.isExternal(), ui5.c.a(r3)), SpaceTagType.Companion.a(r9.isApp())});
        if (r9.getOwnerType() != 2) goto L6;
        this.f.setVisibility(0);
        this.f.setText(r9.getLabel());
    L27:
        this.c.setNewData(r12);
        f r13 = WindowInsetsUtils.a(this.b);
        r13.i(n.h(this.a, 2131100548));
        r13.o(true);
        r13.r(true);
        Dialog r14 = this.b;
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r14);
    L32:
        zo5.b r15 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        Window r16 = this.b.getWindow();
        if (r16 != null) goto L35;
    L37:
        r15.j(r10, r11, this.b);
        return;
    L35:
        if ((a(r16) instanceof FrameLayout) == false) goto L37;
        Window r17 = this.b.getWindow();
        Intrinsics.checkNotNull(r17);
        View r18 = a(r17);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.widget.FrameLayout");
        r15.detachWatermark((FrameLayout) r18);
        goto L37
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L31:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L32
    L6:
        if (r9.getOwnerType() != 29) goto L9;
        this.f.setVisibility(0);
        this.f.setText(this.a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r11, 2131888868, 2131889097)));
        goto L27
    L9:
        if (r9.getOwnerType() != 5) goto L11;
    L26:
        this.f.setVisibility(8);
        goto L27
    L11:
        if (r9.getOwnerType() == 11) goto L26;
        if (r9.getOwnerType() == 16) goto L26;
        if (r9.getOwnerType() == 18) goto L26;
        String r2 = r9.getDisplayLabel();
        if (r2 != null) goto L19;
    L22:
        boolean r4 = true;
    L23:
        if (r4 == true) goto L26;
        this.f.setVisibility(0);
        this.f.setText(r9.getDisplayLabel());
        goto L27
    L19:
        if (r2.length() == 0) goto L22;
        r4 = false;
        goto L23
    }
}
