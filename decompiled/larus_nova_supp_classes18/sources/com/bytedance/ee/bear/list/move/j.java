package com.bytedance.ee.bear.list.move;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiPuller$ObjInfo;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiPuller$Params;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements td5.d {
    public static final /* synthetic */ int k = 0;
    public final Context a;
    public final Fragment b;
    public final WikiSelectorBean c;
    public final String d;
    public final SpaceSelectorBean e;
    public final boolean f;
    public final CompositeDisposable g;
    public long h;
    public final NetService i;
    public UDDialog j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Pair r4 = (Pair) r3;
            if (((Boolean) r4.getFirst()).booleanValue() == false) goto L5;
            this.a.e((String) r4.getSecond(), "");
            return;
        L5:
            this.a.d();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ int b;

        public c(j r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            int r0 = j.k;
            tt5.a.e("SpaceMoveToWikiCommand", "pullMoveNodeHint error: ", (Throwable) r4, false);
            j r5 = this.a;
            String r1 = r5.c.g;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r5.e(com.bytedance.ee.bear.list.move.api.a.a(r1, Integer.valueOf(this.b)), "");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ j a;

        public d(j r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            GetMoveReviewerInfoPuller$Result r2 = (GetMoveReviewerInfoPuller$Result) r9;
            Intrinsics.checkNotNullParameter(r2, "result");
            int r10 = j.k;
            tt5.a.b("SpaceMoveToWikiCommand", "GetMoveReviewerInfoPuller()...result = " + r2);
            Toast.cancelLoading();
            if (r2.not_need_apply == false) goto L5;
            j r11 = this.a;
            Context r1 = r11.getContext();
            SpaceSelectorBean r3 = this.a.e;
            tt5.a.h("SpaceMoveToWikiCommand", "moveSpace()...");
            Toast.showLoading(r1, r1.getString(2131888333));
            r11.h = System.currentTimeMillis();
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = new ViewModelProvider(r11.b).get(ApplyMoveViewModel.class);
            NetService r4 = r11.i;
            final String r6 = r3.b;
            final int r7 = r3.a;
            final List r5 = CollectionsKt.listOf(new SpaceMoveToWikiPuller$ObjInfo(r6, r7));
            final String r8 = r11.c.d;
            final String r12 = r11.d;
            NonProguard r13 = new SpaceMoveToWikiPuller$Params(r5, r8, r12);
            NetService.f r14 = new NetService.f("/space/api/wiki/v2/tree/move_from_space2/");
            ((NetService.e) r14).c = 1;
            ((NetService.e) r14).j = GsonProtectorUtils.toJson(new Gson(), r13);
            r11.g.add(r4.Vc(new com.bytedance.ee.bear.list.move.api.c()).a(r14).map(new com.bytedance.ee.bear.list.move.api.b()).flatMap(new k(r11)).subscribe(new l(r1, r3, r11, r0), new m(r11, r0, r1)));
            return;
        L5:
            j r15 = this.a;
            r15.getContext();
            SpaceSelectorBean r16 = this.a.e;
            tt5.a.h("SpaceMoveToWikiCommand", "applyMoveToWiki()...");
            int r17 = ApplyMoveSpaceToWikiFragment.s;
            com.bytedance.ee.bear.list.move.a r18 = new com.bytedance.ee.bear.list.move.a(r15.b.getChildFragmentManager(), r2, r16.b, r16.a, r15.c.d, r15.d);
            Intrinsics.checkNotNullParameter(r18, "param");
            ApplyMoveSpaceToWikiFragment r19 = new ApplyMoveSpaceToWikiFragment();
            Bundle r20 = new Bundle();
            r20.putSerializable("extra_user", r18.b);
            r20.putString("extra_obj_token", r18.c);
            r20.putInt("extra_obj_type", r18.d);
            r20.putString("extra_wiki_token", r18.e);
            r20.putString("extra_space_id", r18.f);
            r19.setArguments(r20);
            FragmentManager r21 = r18.a;
            LandscapeRestrictionOperation r22 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, "ApplyMoveSpaceToWikiFragment", r22);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r21, r19, r22) == true) goto L15;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            r19.show(r21, "ApplyMoveSpaceToWikiFragment");
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ j a;

        public e(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            int r0 = j.k;
            tt5.a.d("SpaceMoveToWikiCommand", "GetMoveReviewerInfoPuller()...failed, error = " + r4);
            Toast.cancelLoading();
            if (ax4.d.b(r4, 4204) == false) goto L5;
            Toast.showFailureText(this.a.getContext(), this.a.getContext().getString(2131889815));
            return;
        L5:
            Toast.showFailureText(this.a.getContext(), this.a.getContext().getString(2131889140));
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ j a;

        public f(j r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.d();
        }
    }

    static {
    }

    public final void d() {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.e == null) goto L10;
        tt5.a.h("SpaceMoveToWikiCommand", "applyMoveToWiki()...focusToken = " + du5.b.g(this.c.d));
        Context r0 = this.a;
        Toast.showLoading(r0, r0.getResources().getString(2131887769));
        NetService r1 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        GetMoveReviewerInfoPuller$Params r2 = new GetMoveReviewerInfoPuller$Params(this.e.d, "", -1, this.c.d);
        NetService.f r3 = new NetService.f("/space/api/explorer/v2/move_reviewer/");
        ((NetService.e) r3).c = 2;
        r3.b("src_token", r2.src_token);
        r3.b("src_obj_token", r2.src_obj_token);
        r3.b("src_obj_type", String.valueOf(r2.src_obj_type));
        r3.b("dest_token", r2.dest_token);
        this.g.add(r1.Vc(new com.bytedance.ee.bear.list.move.d()).a(r3).map(new com.bytedance.ee.bear.list.move.c()).subscribe(new d(this), new e(this)));
        return;
    }

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("SpaceMoveToWikiCommand", "destroy()...");
        if (this.g.isDisposed() == true) goto L6;
        this.g.clear();
        return;
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("SpaceMoveToWikiCommand", "execute()...");
        if (this.a != null) goto L6;
        return;
    L6:
        if (this.e != null) goto L9;
        tt5.a.h("SpaceMoveToWikiCommand", "spaceSelectorBean is null");
        return;
    L9:
        boolean r2 = false;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L13;
        tt5.a.h("SpaceMoveToWikiCommand", "execute()...failed, offline");
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getResources().getString(2131887951), 0);
        return;
    L13:
        String r1 = "";
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == true) goto L16;
        Context r3 = this.a;
        String r4 = this.c.g;
        if (r4 == null) goto L43;
        r1 = r4;
    L43:
        e(xo5.a.c(r3, 2131889142, "username", r1), this.a.getResources().getString(2131889809));
        return;
    L16:
        if (this.e != null) goto L19;
    L24:
        if (r2 == false) goto L38;
        NetService r5 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        SpaceSelectorBean r6 = this.e;
        String r7 = r6.b;
        int r8 = r6.a;
        boolean r9 = this.f;
        if (r9 == false) goto L28;
        String r10 = this.c.d;
    L29:
        String r11 = r10;
        if (r9 == false) goto L32;
        int r12 = 23;
    L33:
        Integer r13 = Integer.valueOf(r8);
        Integer r14 = Integer.valueOf(r12);
        String r15 = this.c.g;
        if (r15 != null) goto L36;
        String r16 = "";
    L37:
        Disposable r17 = com.bytedance.ee.bear.list.move.api.a.b(r5, r7, r13, false, r11, r14, r16).subscribe(new b(this), new c(this, r12));
        this.g.add(r17);
        return;
    L36:
        r16 = r15;
        goto L37
    L32:
        r12 = this.c.j;
        goto L33
    L28:
        r10 = this.c.i;
        goto L29
    L38:
        d();
        return;
    L19:
        if (this.c.n == true) goto L21;
    L23:
        r2 = true;
        goto L24
    L21:
        if (this.f == false) goto L23;
        goto L23
    }

    public final Context getContext() {
        return this.a;
    }

    public static /* synthetic */ void c(j r1, ApplyMoveViewModel r2) {
        r1.getClass();
        b(r2, false, "", "");
    }

    public final void e(String r7, String r8) {
        if (this.a != null) goto L5;
        return;
    L5:
        UDDialog r0 = this.j;
        if (r0 == null) goto L10;
        boolean r2 = true;
        if (true != r0.isShowing()) goto L10;
    L12:
        if (r2 == false) goto L33;
        UDDialog r3 = this.j;
        if (r3 == null) goto L32;
        Handler r4 = DialogLancet.resolveDialogHandler(r3);
        if (r4 != null) goto L18;
    L20:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r3);
        goto L32
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r5 == null) goto L29;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L18:
        if (Looper.myLooper() == r4.getLooper()) goto L20;
        r4.post(DialogLancet.createDismissRunnable(r3));
    L32:
        this.j = null;
    L33:
        fp5.a r9 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131889891)).message(r7)).messageGravity(8388611);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "tips");
        r9.c = r8;
        r9.e = false;
        UDDialog r10 = ((fp5.a) ((fp5.a) r9.addActionButton(2131391777, 2131887719, new f(this))).addActionButton(2131391778, 2131887716, null)).build();
        this.j = r10;
        if (r10 != null) goto L36;
        return;
    L36:
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L39:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L10:
        r2 = false;
        goto L12
    }

    public static final Flowable a(j r5, String r6, long r7) {
        r5.getClass();
        if ((System.currentTimeMillis() - r5.h) <= 30000) goto L5;
        tt5.a.d("SpaceMoveToWikiCommand", "pollingMoveToWikiStatus()...timeout!");
        throw new TimeoutException();
    L5:
        return Flowable.just(Boolean.TRUE).delay(r7, TimeUnit.MILLISECONDS).flatMap(new n(r5, r6)).flatMap(new o(r5, r6));
    }

    public static void b(ApplyMoveViewModel r3, boolean r4, String r5, String r6) {
        if (r3 != null) goto L4;
    L10:
        if (r4 == false) goto L13;
        td5.c.a(r5);
        return;
    L13:
        return;
    L4:
        if (r4 == false) goto L6;
        com.bytedance.ee.bear.list.move.b r0 = new com.bytedance.ee.bear.list.move.b(1, r5);
    L7:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        r0.c = r6;
        r3.setState(r0);
        goto L10
    L6:
        r0 = new com.bytedance.ee.bear.list.move.b(2, "");
        goto L7
    }

    public j(Context r2, Fragment r3, WikiSelectorBean r4, String r5, SpaceSelectorBean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "destWikiSelectorBean");
        Intrinsics.checkNotNullParameter(r5, "spaceId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = new CompositeDisposable();
        this.i = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
    }
}
