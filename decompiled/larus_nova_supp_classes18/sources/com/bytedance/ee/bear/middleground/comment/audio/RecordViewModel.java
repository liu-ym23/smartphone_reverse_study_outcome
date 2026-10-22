package com.bytedance.ee.bear.middleground.comment.audio;

import android.os.Vibrator;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class RecordViewModel extends gn4.a {
    public static final /* synthetic */ int k = 0;
    public final p c;
    public boolean d;
    public final ml5.b e;
    public final Vibrator f;
    public final MutableLiveData<String> g;
    public boolean h;
    public c i;
    public int j;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.utils.h.e {
        public final /* synthetic */ RecordViewModel a;
        public final /* synthetic */ Function1<Boolean, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(RecordViewModel r1, Function1<? super Boolean, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(boolean r2) {
            this.a.getClass();
            this.b.invoke(Boolean.valueOf(r2));
        }
    }

    public static final class c implements com.ss.android.lark.media.a {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ RecordViewModel b;
        public final /* synthetic */ Function0<Unit> c;

        public final void onSuccess() {
            this.c.invoke();
        }

        public final void a(MediaMutex.LockError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            tt5.a.h("RecordViewModel", "tryGetMediaMutex failed, occupiedScene: " + r3.getOccupiedScene());
            RecordViewModel.d(this.b, r3.getErrorMessage());
        }

        public final void b(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, "byScene");
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
            tt5.a.h("RecordViewModel", "mediaResourceWasInterrupted, byScene = " + r3 + ", type = " + r4);
            this.a.invoke();
            this.b.k();
            RecordViewModel.d(this.b, "");
        }

        public final void c(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, "fromScene");
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
            tt5.a.h("RecordViewModel", "mediaResourceInterruptionEnd, fromScene = " + r3 + ", type = " + r4);
        }

        public c(Function0<Unit> r1, RecordViewModel r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final synchronized void k() {
        monitor-enter(this);
        c r0 = this.i;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        MediaMutex.r.n(Scene.CCM_Audio_Record, r0);     // Catch: Throwable -> L9
    L6:
        this.i = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void f() {
        tt5.a.h("RecordViewModel", "destroyRecord()");
        if (com.bytedance.ee.bear.middleground.comment.export.e.a() == true) goto L11;
        monitor-enter(this);
        this.j++;     // Catch: Throwable -> L8
        monitor-exit(this);
    L8:
        th = move-exception;
        throw th;
    L11:
        int r0 = com.bytedance.ee.bear.middleground.comment.audio.c.a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).c();
    }

    public final void g() {
        tt5.a.h("RecordViewModel", "showOfflineDialog:");
        BearUDDialogBuilder r0 = new BearUDDialogBuilder(this.c.getActivity());
        r0.a.message(2131887625);
        BearUDDialogBuilder.a r1 = new BearUDDialogBuilder.a();
        r1.a = 2131391777;
        r1.b = 2131887719;
        r1.d = 2131106622;
        r0.d(r1);
        UDDialog r2 = r0.e();
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
    }

    public final void i() {
        if (this.d == true) goto L5;
        return;
    L5:
        tt5.a.h("RecordViewModel", "stopRecord:");
        this.d = false;
        int r0 = com.bytedance.ee.bear.middleground.comment.audio.c.a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).stopRecord();
    }

    public RecordViewModel(p r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        this.c = r5;
        ml5.b r0 = new ml5.b("RECORD_PANEL_CONFIG");
        this.e = r0;
        MutableLiveData<String> r1 = new MutableLiveData();
        this.g = r1;
        this.h = true;
        r1.setValue(r0.a("AUDIO_RECOGNIZE_LOCALE_SETTING_KEY", "zh_ch"));
        Object r6 = r5.getActivity().getSystemService("vibrator");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.os.Vibrator");
        this.f = (Vibrator) r6;
        tt5.a.h("RecordViewModel", "currentUserLocale:" + ((String) r1.getValue()));
    }

    public final void e(Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "perCall");
        com.ss.android.lark.utils.h.a(this.c.getActivity(), new Token("LARK-PSDA-ccm_android_comment_request_record_audio_permssion"), new b(this, r4));
    }

    public final void h(final Function3<? super String, ? super Boolean, ? super int[], Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "rskCallBack");
        this.f.vibrate(100);
        if (this.h == true) goto L6;
        g();
        return;
    L6:
        final boolean r0 = !com.bytedance.ee.bear.middleground.comment.export.e.a();
        if (r0 == false) goto L16;
        int r4 = com.bytedance.ee.bear.middleground.comment.audio.c.a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).c();
        monitor-enter(this);
        final int r5 = this.j + 1;     // Catch: Throwable -> L13
        this.j = r5;     // Catch: Throwable -> L13
        monitor-exit(this);
    L17:
        this.d = true;
        tt5.a.h("RecordViewModel", "startRecord:" + ((String) this.g.getValue()));
        this.g.setValue(this.e.a("AUDIO_RECOGNIZE_LOCALE_SETTING_KEY", "zh_ch"));
        int r1 = com.bytedance.ee.bear.middleground.comment.audio.c.a;
        String r2 = (String) this.g.getValue();
        if (r2 != null) goto L20;
        r2 = "";
    L20:
        Function3<String, Boolean, int[], Unit> r6 = new RecordViewModel$startRecord$1(r0, this, r5, r9);
        Intrinsics.checkNotNullParameter(r2, "speechLocale");
        Intrinsics.checkNotNullParameter(r6, "askCallCallBack");
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).b(r2, r6);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        r5 = this.j;
        goto L17
    }

    public static final void d(RecordViewModel r2, String r3) {
        r2.getClass();
        FragmentActivity r0 = r2.c.getActivity();
        Intrinsics.checkNotNullParameter(r0, "context");
        UDDialogBuilder r1 = new UDDialogBuilder(r0);
        r1.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.message(r3);
        r1.addActionButton(2131391777, 2131887800, new l(r2));
        UDDialog r4 = r1.build();
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
    }

    public final synchronized void j(Function0<Unit> r4, Function0<Unit> r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "successCallback");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r5, "interruptCallback");     // Catch: Throwable -> L6
        k();     // Catch: Throwable -> L6
        this.i = new c(r5, this, r4);     // Catch: Throwable -> L6
        MediaMutex r6 = MediaMutex.r;     // Catch: Throwable -> L6
        Scene r7 = Scene.CCM_Audio_Record;     // Catch: Throwable -> L6
        c r0 = this.i;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
        r6.l(r7, false, r0, true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
