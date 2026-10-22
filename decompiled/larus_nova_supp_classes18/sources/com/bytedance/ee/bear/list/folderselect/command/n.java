package com.bytedance.ee.bear.list.folderselect.command;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements td5.d {
    public Context a;
    public final String b;
    public final int c;
    public final int d;
    public final ShareFolderUserPermission e;
    public td5.b f;
    public final SpaceSelectorBean g;
    public final CompositeDisposable h;
    public com.larksuite.component.universe_design.toast.c i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ n a;

        public b(n r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            SpaceMakeCopyToSpaceResult r9 = (SpaceMakeCopyToSpaceResult) r8;
            tt5.a.h("SpaceMakeCopyToSpaceCommand", "make copy success.");
            jw4.a.g("copy", Integer.valueOf(this.a.g.a));
            n r0 = this.a;
            Intrinsics.checkNotNull(r9);
            r0.getClass();
            Toast.cancelLoading();
            td5.b r1 = r0.f;
            if (r1 == null) goto L5;
            r1.finish();
        L5:
            com.bytedance.ee.bear.route.h r2 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
            Ref.ObjectRef r3 = new Ref.ObjectRef();
            Activity r4 = r2.getActivity();
            r3.element = r4;
            if (com.bytedance.ee.util.ui.b.a(r4) == false) goto L15;
            Activity r5 = (Activity) r3.element;
            if (r5 == null) goto L16;
            SpaceSelectorBean r6 = r0.g;
            if (r6 == null) goto L12;
            int r7 = r6.a;
        L13:
            UDToast.a r10 = UDToast.build(r5);
            r10.b.e(2131887772);
            r10.b(2131887161, new q(r2, r9, r0, r7));
            r10.f(new r(r3, r0));
            com.ss.android.lark.compose.foundation.toast.g r11 = r10.a();
            r0.i = r11;
            r11.show();
            return;
        L12:
            r7 = sbb.e.g.b;
            goto L13
        L16:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ n a;

        public c(n r1) {
            this.a = r1;
        }

        public final void accept(Object r15) {
            NetService.ServerErrorException r16 = (Throwable) r15;
            tt5.a.d("SpaceMakeCopyToSpaceCommand", "make copy failed, throwable = " + r16);
            jw4.a.h("copy", r16, Integer.valueOf(this.a.g.a));
            n r0 = this.a;
            Intrinsics.checkNotNull(r16);
            r0.getClass();
            Toast.cancelLoading();
            if ((r16 instanceof NetService.ServerErrorException) == false) goto L5;
            int r1 = r16.getCode();
        L6:
            ErrorResponse r3 = null;
            Integer r4 = null;
            rc5.a r2 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
            if (com.bytedance.ee.bear.contract.k0.b(r1) == true) goto L112;
            com.bytedance.ee.bear.quoto.t r5 = (com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6);
            SpaceSelectorBean r6 = r0.g;
            if (r6 == null) goto L12;
            int r7 = r6.a;
        L14:
            if (r1 != 4) goto L17;
            Toast.showFailureText(r0.a, 2131889873);
            return;
        L17:
            if (r1 != 4007) goto L24;
            if (r7 != sbb.e.l.b) goto L21;
            int r17 = 2131887748;
        L22:
            Toast.showFailureText(r0.a, r17);
            return;
        L21:
            r17 = 2131887743;
            goto L22
        L24:
            if (r1 != 11001) goto L29;
            FragmentActivity r18 = r0.a;
            if ((r18 instanceof FragmentActivity) == false) goto L98;
            ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).j(r18, FullQuotoConfig.MAKE_COPY.withShowCreateExceedCapacity(!((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand()));
            return;
        L98:
            return;
        L29:
            if (r5.o(r1) == false) goto L32;
            r5.l(r1, r0.a);
            return;
        L32:
            if (r5.k(r1) == false) goto L37;
            Context r8 = r0.a;
            if ((r8 instanceof FragmentActivity) == false) goto L101;
            ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).c(r8, null, null, !TextUtils.isEmpty(r0.b), false, "");
            return;
        L101:
            return;
        L37:
            if (r5.s(r1) == false) goto L41;
            Context r9 = r0.a;
            if ((r9 instanceof FragmentActivity) == false) goto L103;
            ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).c(r9, null, null, !TextUtils.isEmpty(r0.b), true, "");
            return;
        L103:
            return;
        L41:
            String r10 = "";
            if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).g(r1) == false) goto L53;
            if (r7 != sbb.e.l.b) goto L53;
            com.bytedance.ee.bear.h r19 = (com.bytedance.ee.bear.h) org.koin.java.a.c(com.bytedance.ee.bear.h.class, null, null, 6);
            SpaceSelectorBean r11 = r0.g;
            if (r11 == null) goto L51;
            String r12 = r11.b;
            if (r12 == null) goto L51;
            r10 = r12;
        L51:
            r0.h.add(r19.P5(r10, "explorer").subscribe(new o(r0), new p(r0)));
            return;
        L53:
            if (r1 != 4000080) goto L55;
        L94:
            Toast.showFailureText(r0.a, 2131887226);
            return;
        L55:
            if (r1 == 800004046) goto L94;
            if (r1 != 4202) goto L60;
            Toast.showFailureText(r0.a, 2131887146);
            return;
        L60:
            com.bytedance.ee.bear.middleground_permission_export.model.d r13 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6);
            SpaceSelectorBean r14 = r0.g;
            if (r14 == null) goto L64;
            String r20 = r14.b;
            if (r20 == null) goto L64;
        L65:
            String r21 = r13.f(r20, "CCM_CREATE_COPY", r1);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            boolean r22 = jg5.e.a.a.g();
            if (r22 == false) goto L76;
            ph5.b r23 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            SpaceSelectorBean r24 = r0.g;
            if (r24 == null) goto L73;
            String r25 = r24.b;
            if (r25 == null) goto L73;
            r10 = r25;
        L73:
            if (r24 == null) goto L75;
            r4 = Integer.valueOf(r24.a);
        L75:
            r3 = r23.e(r10, r4, "CREATE_COPY", r16);
        L76:
            if (r22 == false) goto L86;
            if (r3 == null) goto L86;
            if (r3.getHasHandledUiAction() == false) goto L86;
            ph5.a r110 = r3.getCallback();
            if (r110 == null) goto L107;
            Context r26 = r0.a;
            if (r26 != null) goto L85;
            r26 = eu5.b.a;
        L85:
            Intrinsics.checkNotNull(r26);
            r110.a(r26, r3);
            return;
        L107:
            return;
        L86:
            if (r22 == true) goto L91;
            if (TextUtils.isEmpty(r21) == true) goto L91;
            Toast.showFailureText(r0.a, r21);
            return;
        L91:
            if (r1 != 1201) goto L93;
            Toast.showFailureText(r0.a, 2131889748);
            return;
        L93:
            Toast.showFailureText(r0.a, 2131887802);
            return;
        L64:
            r20 = "";
            goto L65
        L12:
            r7 = sbb.e.g.b;
            goto L14
        L112:
            return;
        L5:
            r1 = -1;
            goto L6
        }
    }

    static {
    }

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "destroy()...");
        if (this.h.isDisposed() == true) goto L5;
        this.h.clear();
    L5:
        this.a = null;
        this.f = null;
        if (this.i != null) goto L9;
        Toast.cancelLoading();
        return;
    }

    @Override // td5.d
    public final void execute() {
        if (this.g != null) goto L6;
        tt5.a.d("SpaceMakeCopyToSpaceCommand", "execute()...spaceSelectorBean is null.");
        return;
    L6:
        com.larksuite.component.universe_design.toast.c r0 = this.i;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "already make copy success, return");
        return;
    L15:
        String r2 = null;
        if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L23;
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "execute()...failed, offline");
        Context r3 = this.a;
        if (r3 == null) goto L20;
        r2 = r3.getString(2131887951);
    L20:
        Toast.showFailureText(r3, r2);
        return;
    L23:
        if (this.g.g == false) goto L32;
        FolderVersion.a r4 = FolderVersion.Companion;
        Integer r5 = Integer.valueOf(this.d);
        r4.getClass();
        if (FolderVersion.a.c(r5) == true) goto L32;
        Context r6 = this.a;
        if (r6 == null) goto L29;
        r2 = r6.getString(2131887316);
    L29:
        Toast.showText(r6, r2);
        return;
    L32:
        if (this.g.g == true) goto L41;
        FolderVersion.a r7 = FolderVersion.Companion;
        Integer r8 = Integer.valueOf(this.d);
        r7.getClass();
        if (FolderVersion.a.c(r8) == false) goto L41;
        Context r9 = this.a;
        if (r9 == null) goto L38;
        r2 = r9.getString(2131887317);
    L38:
        Toast.showText(r9, r2);
        return;
    L41:
        if (this.e == null) goto L50;
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).u(this.e, "MOVE_TO_HERE"), Boolean.FALSE) == false) goto L50;
        tt5.a.h("SpaceMakeCopyToSpaceCommand", "execute()...has no permission.");
        Context r10 = this.a;
        if (r10 == null) goto L47;
        r2 = r10.getString(2131889873);
    L47:
        Toast.showFailureText(r10, r2);
        return;
    L50:
        if (this.h.isDisposed() == true) goto L52;
        this.h.clear();
    L52:
        Context r11 = this.a;
        if (r11 == null) goto L55;
        String r12 = r11.getString(2131887469);
    L56:
        Toast.showLoading(r11, r12);
        if (this.c != 4) goto L59;
        String r13 = "";
    L60:
        String r14 = r13;
        rc5.a r15 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        Context r16 = this.a;
        SpaceSelectorBean r17 = this.g;
        this.h.add(r15.h(new com.bytedance.ee.bear.contract.d0(r16, r17.b, r17.a, r17.e, r14, r17.f, r17.n, r17.m, r17.g)).subscribe(new b(this), new c(this)));
        return;
    L59:
        r13 = this.b;
        goto L60
    L55:
        r12 = null;
        goto L56
    L9:
        if (r0.isShowing() != true) goto L11;
        r1 = true;
        goto L12
    }

    public final Context getContext() {
        return this.a;
    }

    public n(Context r2, String r3, int r4, int r5, ShareFolderUserPermission r6, Bundle r7, td5.b r8, ce5.a r9) {
        Intrinsics.checkNotNullParameter(r3, "destToken");
        Intrinsics.checkNotNullParameter(r9, "userComponentAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        if (r7 == null) goto L5;
        SpaceSelectorBean r10 = (SpaceSelectorBean) r7.getParcelable("extra_space_bean");
    L6:
        this.g = r10;
        this.h = new CompositeDisposable();
        return;
    L5:
        r10 = null;
        goto L6
    }
}
