package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvGroupJoinDialogFragment;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/KtvInteractGroupDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvInteractGroupDialog extends CommonBottomDialog {
    public static final /* synthetic */ int h = 0;
    public final CompositeDisposable a;
    public int b;
    public final boolean c;
    public final String d;
    public final String e;
    public final List<k> f;
    public final String g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ KtvInteractGroupDialog a;
        public final /* synthetic */ IRoom b;

        public b(KtvInteractGroupDialog r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            IRoom r5 = this.b;
            if (r5 != null) goto L5;
        L7:
            KtvInteractGroupDialog r6 = this.a;
            int r0 = KtvInteractGroupDialog.h;
            r6.M0("create", "click");
            CommonBottomDialog r7 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r7);
            if (r1 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r2 == null) goto L21;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L10:
            if (Looper.myLooper() == r1.getLooper()) goto L12;
            r1.post(DialogLancet.createDismissRunnable(r7));
            return;
        L5:
            if (r5.getOwnerUserIdString() == null) goto L7;
            jc1.k.n(IKtvService.class).createKtvGroup(this.a.getContext());
            goto L7
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ KtvInteractGroupDialog a;
        public final /* synthetic */ IRoom b;

        public c(KtvInteractGroupDialog r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            jc1.k.n(IMiddlewareUserService.class).user().n().getClass();
            IRoom r5 = this.b;
            if (r5 != null) goto L5;
        L7:
            KtvInteractGroupDialog r6 = this.a;
            int r0 = KtvInteractGroupDialog.h;
            r6.M0("join", "click");
            CommonBottomDialog r7 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r7);
            if (r1 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r2 == null) goto L21;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
            goto L21
        L10:
            if (Looper.myLooper() == r1.getLooper()) goto L12;
            r1.post(DialogLancet.createDismissRunnable(r7));
            return;
        L5:
            if (r5.getOwnerUserIdString() == null) goto L7;
            int r8 = KtvGroupJoinDialogFragment.l;
            KtvGroupJoinDialogFragment.l = this.a.b;
            KtvGroupJoinDialogFragment.m = 0;
            p8.a(new KtvGroupJoinDialogFragment(), this.a.getContext());
            goto L7
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvInteractGroupDialog a;

        public d(KtvInteractGroupDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            if (this.a.isShowing() == false) goto L21;
            CommonBottomDialog r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566490;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.dispose();
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        ((TextView) findViewById(2131388747)).setText(this.d);
        ((TextView) findViewById(2131388746)).setText(this.e);
        o r0 = m.i();
        k r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r0.getRoom();
        if (r2 == null) goto L7;
        IRoom r3 = (IRoom) r2.getValue();
    L8:
        String r4 = "show KtvInteractGroupDialog: " + jc1.k.n(IInteractService.class).getCurrentScene();
        ALogger.i(bb0.b.b(), r4 + ", invoke class :KtvInteractGroupDialog");
        if (this.c == false) goto L11;
        UtilityKotlinExtentionsKt.z(findViewById(2131362561), true);
        ImageLoader.load(qy.a.a("https://p6.douyinpic.com/aweme-client-static-resource/ttlive_bg_anchor_group.png~tplv-obj.image")).a(findViewById(2131362561));
        M0("create", "show");
        UtilityKotlinExtentionsKt.z(findViewById(2131362560), false);
        UtilityKotlinExtentionsKt.z(findViewById(2131374051), false);
        ((Button) findViewById(2131364615)).setText(s1.B(2131919482));
        ((Button) findViewById(2131364615)).setOnClickListener(new b(this, r3));
    L23:
        this.a.add(Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
        return;
    L11:
        M0("join", "show");
        HSImageView r5 = findViewById(2131362560);
        UtilityKotlinExtentionsKt.z(r5, true);
        List<k> r6 = this.f;
        if (r6 == null) goto L14;
        k r7 = (k) ListProtector.get(r6, 0);
    L15:
        if (r7 == null) goto L17;
        ImageLoader.bindImage(r5, r7);
    L17:
        HSImageView r8 = findViewById(2131374051);
        UtilityKotlinExtentionsKt.z(r8, true);
        List<k> r9 = this.f;
        if (r9 == null) goto L20;
        r1 = (k) ListProtector.get(r9, 1);
    L20:
        if (r1 == null) goto L22;
        ImageLoader.bindImage(r8, r1);
    L22:
        UtilityKotlinExtentionsKt.z(findViewById(2131362561), false);
        ((Button) findViewById(2131364615)).setText("加歌友群");
        ((Button) findViewById(2131364615)).setOnClickListener(new c(this, r3));
        goto L23
    L14:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void M0(String r8, String r9) {
        o r0 = m.i();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
    L8:
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.isLiveTypeAudio() == false) goto L13;
        String r3 = "voice_live";
    L14:
        int r4 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (r4 != 9) goto L17;
        String r5 = "ktv";
    L24:
        String r6 = r2.getOwnerUserIdString();
        String r7 = String.valueOf(r2.getId());
        if (this.c == false) goto L28;
        String r10 = "anchor";
    L31:
        Pair[] r11 = new Pair[8];
        r11[0] = TuplesKt.to("live_type", r3);
        r11[1] = TuplesKt.to("function_type", r5);
        r11[2] = TuplesKt.to("anchor_id", r6);
        r11[3] = TuplesKt.to("room_id", r7);
        r11[4] = TuplesKt.to("user_type", r10);
        r11[5] = TuplesKt.to("invite_type", r8);
        r11[6] = TuplesKt.to("action_type", r9);
        String r12 = this.g;
        if (r12 != null) goto L34;
        r12 = "";
    L34:
        r11[7] = TuplesKt.to("invite_source", r12);
        Map<String, String> r13 = MapsKt.mutableMapOf(r11);
        j0.l().sendLog("livesdk_group_chat_invite_toast", r13, new Object[0]);
        return;
    L28:
        if (hd0.c.f().h() == false) goto L30;
        r10 = "guest";
        goto L31
    L30:
        r10 = "user";
        goto L31
    L17:
        if (r4 != 12) goto L19;
    L22:
        r5 = "party";
        goto L24
    L19:
        if (d0.h(r2) == true) goto L22;
        r5 = "radio";
        goto L24
    L13:
        r3 = "video_live";
    L7:
        r2 = null;
        goto L8
    }

    public KtvInteractGroupDialog(Context r2, boolean r3, String r4, String r5, List<? extends k> r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "mCtx");
        Intrinsics.checkNotNullParameter(r4, "mHeaderText");
        Intrinsics.checkNotNullParameter(r5, "mBodyText");
        Intrinsics.checkNotNullParameter(r7, "mConversationID");
        Intrinsics.checkNotNullParameter(r8, "mConversationShortID");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r9;
        this.a = new CompositeDisposable();
        this.b = 23;
    }
}
