package ui5;

import android.content.Context;
import android.content.DialogInterface;
import ax4.d;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.AskOwnerHelper;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.InviteMemberSendLinkData;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(List<? extends NotNotifyUserEntity> r7) {
        if (r7 != null) goto L4;
        return "";
    L4:
        if (r7.isEmpty() == true) goto L32;
        StringBuilder r0 = new StringBuilder();
        i0 r1 = (i0) org.koin.java.a.c(i0.class, null, null, 6);
        if (r1 == null) goto L10;
        String r2 = r1.a();
        if (r2 == null) goto L10;
    L11:
        Iterator<T> r3 = r7.iterator();
        int r4 = 0;
    L13:
        if (r3.hasNext() == false) goto L25;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        NotNotifyUserEntity r8 = (NotNotifyUserEntity) r5;
        r0.append(ou5.a.b(r2, r8.getName(), r8.getEn_name()));
        if (r4 == (r7.size() - 1)) goto L23;
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r2) == false) goto L22;
        r0.append(",");
        goto L23
    L22:
        r0.append("、");
    L23:
        r4 = r6;
        goto L13
    L25:
        return r0.toString();
    L10:
        r2 = Locale.CHINA.getLanguage();
        goto L11
    L32:
        return "";
    }

    public static boolean c(AskOwnerHelper.AskOwnerSendResult r4, Context r5, DialogInterface.OnDismissListener r6) {
        Intrinsics.checkNotNullParameter(r4, "askOwnerSendResult");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "dismissListener");
        AskOwnerHelper.AskOwner r0 = (AskOwnerHelper.AskOwner) ((Result) r4).data;
        if (r0 == null) goto L9;
        HashMap<String, List<AskOwnerHelper.FailMember>> r1 = r0.getFailMembers();
        if (r1 == null) goto L9;
        if (r1.containsKey("2002") != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        e(r5, r5.getString(2131889841), r6);
    L22:
        return true;
    L12:
        AskOwnerHelper.AskOwner r7 = (AskOwnerHelper.AskOwner) ((Result) r4).data;
        if (r7 == null) goto L19;
        HashMap<String, List<AskOwnerHelper.FailMember>> r8 = r7.getFailMembers();
        if (r8 == null) goto L19;
        if (r8.containsKey("2005") != true) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L24;
        e(r5, r5.getString(2131888962), r6);
        goto L22
    L24:
        return false;
    L19:
        r9 = false;
    L9:
        r2 = false;
        goto L10
    }

    public static void e(Context r2, String r3, DialogInterface.OnDismissListener r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "dismissListener");
        Intrinsics.checkNotNullParameter(r2, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r2);
        r0.autoDismiss(true);
        r0.title(2131889849);
        Intrinsics.checkNotNullParameter(r3, "value");
        r0.message(r3);
        r0.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887759).textColorRes(2131105548).onClickListener(null));
        Intrinsics.checkNotNullParameter(r4, "value");
        r0.onDismissListener(r4);
        r0.cancelOnTouchOutside(false);
        UDDialog r5 = r0.build();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    @JvmStatic
    public static final void b(Context r4, Throwable r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "e");
        String r1 = "others";
        if ((r5 instanceof NetService.HttpErrorException) == false) goto L8;
        if (((NetService.HttpErrorException) r5).getCode() != 429) goto L8;
        String r9 = r4.getString(2131888125);
        Intrinsics.checkNotNull(r9);
    L27:
        Toast.showFailureText(r4, r9);
        PermissionAnalytic.j(r1, r7, r8, "apply_permission");
        return;
    L8:
        if (d.b(r5, 10021) == false) goto L13;
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r9 = xo5.a.c(r4, 2131888077, "userName", r6);
        Intrinsics.checkNotNull(r9);
        r1 = "block";
        goto L27
    L13:
        if (d.b(r5, 10022) == false) goto L16;
        r9 = r4.getString(2131888738);
        Intrinsics.checkNotNull(r9);
        r1 = "blocked";
        goto L27
    L16:
        if (d.b(r5, 10023) == false) goto L21;
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r9 = xo5.a.c(r4, 2131888128, "userName", r6);
        Intrinsics.checkNotNull(r9);
        r1 = "privacy_setting";
        goto L27
    L21:
        if (d.b(r5, 10015) == false) goto L24;
        r9 = r4.getString(2131888099);
        Intrinsics.checkNotNull(r9);
        r1 = "admin_setting";
        goto L27
    L24:
        if (d.b(r5, 10040) == false) goto L26;
        r9 = r4.getString(2131887146);
        Intrinsics.checkNotNull(r9);
        goto L27
    L26:
        r9 = r4.getString(2131887828);
        goto L27
    }

    @JvmStatic
    public static final void d(Context r7, UserInfo r8, Locale r9, Throwable r10, String r11, int r12, String r13, ArrayList<UserInfo> r14) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "ownerInfo");
        Intrinsics.checkNotNullParameter(r9, "locale");
        Intrinsics.checkNotNullParameter(r10, "throwable");
        Intrinsics.checkNotNullParameter(r14, "selectedUser");
        String r2 = "others";
        if ((r10 instanceof NetService.ServerErrorException) == false) goto L85;
        int r0 = yg5.b.a;
        NetService.ServerErrorException r15 = (NetService.ServerErrorException) r10;
        InviteMemberSendLinkData r16 = yg5.b.a.a(r15.getData(), r14);
        List<NotNotifyUserEntity> r1 = r16.getOwnerNotInGroups();
        boolean r3 = false;
        if (r1 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L14;
        HashMap r17 = new HashMap();
        r17.put("group_name", a(r16.getOwnerNotInGroups()));
        u4.a.getClass();
        r17.put("doc_type", u4.a(r7, r12));
        Toast.showText(r7, xo5.a.d(r7, 2131887098, r17));
        return;
    L14:
        if (r15.getCode() != 10040) goto L17;
        String r18 = r7.getString(2131887146);
    L90:
        Toast.showFailureText(r7, r18);
        PermissionAnalytic.j(r2, r11, r13, "ask_owner");
        return;
    L17:
        if (r15.getCode() != 10021) goto L20;
        r18 = xo5.a.c(r7, 2131888058, "name", r8.getDisplayName(r9));
    L39:
        r2 = "block";
        goto L90
    L20:
        if (r15.getCode() != 10022) goto L23;
        r18 = r7.getString(2131888735);
    L48:
        r2 = "blocked";
        goto L90
    L23:
        if (r15.getCode() != 10023) goto L26;
        r18 = xo5.a.c(r7, 2131888069, "name", r8.getDisplayName(r9));
    L57:
        r2 = "privacy_setting";
        goto L90
    L26:
        if (r15.getCode() != 10025) goto L29;
        HashMap r19 = new HashMap();
        r19.put("name", r8.getDisplayName(r9));
        r19.put("count", String.valueOf(r16.getAskOwnerLimitNum()));
        r18 = xo5.a.d(r7, 2131888060, r19);
    L66:
        r2 = "more_then_limited";
        goto L90
    L29:
        if (r15.getCode() != 10015) goto L31;
        r18 = xo5.a.c(r7, 2131888114, "owner_name", r8.getDisplayName(r9));
    L75:
        r2 = "admin_setting";
        goto L90
    L31:
        List<NotNotifyUserEntity> r110 = r16.getBlockUsers();
        if (r110 != null) goto L34;
    L36:
        boolean r111 = false;
    L37:
        if (r111 == false) goto L40;
        HashMap r112 = new HashMap();
        r112.put("owner_name", r8.getDisplayName(r9));
        r112.put("name", a(r16.getBlockUsers()));
        r18 = xo5.a.d(r7, 2131888062, r112);
        goto L39
    L40:
        List<NotNotifyUserEntity> r113 = r16.getBlockedUsers();
        if (r113 != null) goto L43;
    L45:
        boolean r114 = false;
    L46:
        if (r114 == false) goto L49;
        HashMap r115 = new HashMap();
        r115.put("owner_name", r8.getDisplayName(r9));
        r115.put("name", a(r16.getBlockedUsers()));
        r18 = xo5.a.d(r7, 2131888063, r115);
        goto L48
    L49:
        List<NotNotifyUserEntity> r116 = r16.getPrivacyUsers();
        if (r116 != null) goto L52;
    L54:
        boolean r117 = false;
    L55:
        if (r117 == false) goto L58;
        r18 = xo5.a.c(r7, 2131888065, "name", a(r16.getPrivacyUsers()));
        goto L57
    L58:
        List<NotNotifyUserEntity> r118 = r16.getLimitUsers();
        if (r118 != null) goto L61;
    L63:
        boolean r119 = false;
    L64:
        if (r119 == false) goto L67;
        HashMap r120 = new HashMap();
        r120.put("owner_name", r8.getDisplayName(r9));
        r120.put("name", a(r16.getLimitUsers()));
        r120.put("count", String.valueOf(r16.getAskOwnerLimitNum()));
        r18 = xo5.a.d(r7, 2131888064, r120);
        goto L66
    L67:
        List<NotNotifyUserEntity> r20 = r16.getNotNotifyUsers();
        if (r20 != null) goto L70;
    L72:
        boolean r21 = false;
    L73:
        if (r21 == false) goto L76;
        r18 = xo5.a.c(r7, 2131888061, "name", a(r16.getNotNotifyUsers()));
        goto L75
    L76:
        List<NotNotifyUserEntity> r22 = r16.getInviteFailedUsers();
        if (r22 != null) goto L79;
    L81:
        if (r3 == false) goto L83;
        r18 = r7.getString(2131888115);
        goto L90
    L83:
        r18 = r7.getString(2131888113);
        goto L90
    L79:
        if ((!r22.isEmpty()) != true) goto L81;
        r3 = true;
        goto L81
    L70:
        if ((!r20.isEmpty()) != true) goto L72;
        r21 = true;
        goto L73
    L61:
        if ((!r118.isEmpty()) != true) goto L63;
        r119 = true;
        goto L64
    L52:
        if ((!r116.isEmpty()) != true) goto L54;
        r117 = true;
        goto L55
    L43:
        if ((!r113.isEmpty()) != true) goto L45;
        r114 = true;
        goto L46
    L34:
        if ((!r110.isEmpty()) != true) goto L36;
        r111 = true;
        goto L37
    L7:
        if ((!r1.isEmpty()) != true) goto L9;
        r4 = true;
        goto L10
    L85:
        if ((r10 instanceof NetService.HttpErrorException) == true) goto L87;
    L89:
        r18 = r7.getString(2131888113);
        goto L90
    L87:
        if (((NetService.HttpErrorException) r10).getCode() != 429) goto L89;
        r18 = r7.getString(2131888125);
        goto L90
    }
}
