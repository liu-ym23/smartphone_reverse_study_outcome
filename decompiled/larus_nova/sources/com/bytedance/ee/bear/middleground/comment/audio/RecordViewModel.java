package com.bytedance.ee.bear.middleground.comment.audio;

import android.os.Vibrator;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class RecordViewModel extends gn4.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f230316k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f230317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f230318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ml5.b f230319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Vibrator f230320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<String> f230321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f230322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f230323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f230324j;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.utils.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordViewModel f230325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f230326b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(RecordViewModel r100, Function1<? super Boolean, Unit> r101) {
            this.f230325a = r100;
            this.f230326b = r101;
        }

        @Override // com.ss.android.lark.utils.h.e
        public final void a(boolean r100) {
            this.f230325a.getClass();
            this.f230326b.invoke(Boolean.valueOf(r100));
        }
    }

    public static final class c implements com.ss.android.lark.media.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f230327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecordViewModel f230328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f230329c;

        @Override // com.ss.android.lark.media.a
        public final void onSuccess() {
            this.f230329c.invoke();
        }

        @Override // com.ss.android.lark.media.a
        public final void a(MediaMutex.LockError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            tt5.a.h("RecordViewModel", "tryGetMediaMutex failed, occupiedScene: " + r100.getOccupiedScene());
            RecordViewModel.d(this.f230328b, r100.getErrorMessage());
        }

        @Override // com.ss.android.lark.media.a
        public final void b(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "byScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            tt5.a.h("RecordViewModel", "mediaResourceWasInterrupted, byScene = " + r100 + ", type = " + r101);
            this.f230327a.invoke();
            this.f230328b.k();
            RecordViewModel.d(this.f230328b, "");
        }

        @Override // com.ss.android.lark.media.a
        public final void c(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "fromScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            tt5.a.h("RecordViewModel", "mediaResourceInterruptionEnd, fromScene = " + r100 + ", type = " + r101);
        }

        public c(Function0<Unit> r100, RecordViewModel r101, Function0<Unit> r102) {
            this.f230327a = r100;
            this.f230328b = r101;
            this.f230329c = r102;
        }
    }

    static {
    }

    public final synchronized void k() {
        monitor-enter(this);
        c r100 = this.f230323i;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        MediaMutex.f431631r.n(Scene.CCM_Audio_Record, r100);     // Catch: Throwable -> L9
    L6:
        this.f230323i = null;     // Catch: Throwable -> L9
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
        this.f230324j++;     // Catch: Throwable -> L8
        monitor-exit(this);
    L8:
        th = move-exception;
        throw th;
    L11:
        int r100 = com.bytedance.ee.bear.middleground.comment.audio.c.f230335a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).c();
    }

    public final void g() {
        tt5.a.h("RecordViewModel", "showOfflineDialog:");
        BearUDDialogBuilder r100 = new BearUDDialogBuilder(this.f230317c.getActivity());
        r100.f240192a.message(R.string.Doc_Comment_OfflineAudioDisabled);
        BearUDDialogBuilder.a r101 = new BearUDDialogBuilder.a();
        r101.f240195a = R.id.ud_dialog_btn_primary;
        r101.f240196b = R.string.Doc_Facade_Confirm;
        r101.f240198d = R.color.text_title;
        r100.d(r101);
        UDDialog r102 = r100.e();
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    public final void i() {
        if (this.f230318d == true) goto L5;
        return;
    L5:
        tt5.a.h("RecordViewModel", "stopRecord:");
        this.f230318d = false;
        int r100 = com.bytedance.ee.bear.middleground.comment.audio.c.f230335a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).stopRecord();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordViewModel(p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f230317c = r100;
        ml5.b r101 = new ml5.b("RECORD_PANEL_CONFIG");
        this.f230319e = r101;
        MutableLiveData<String> r102 = new MutableLiveData();
        this.f230321g = r102;
        this.f230322h = true;
        r102.setValue(r101.a("AUDIO_RECOGNIZE_LOCALE_SETTING_KEY", "zh_ch"));
        Object r103 = r100.getActivity().getSystemService("vibrator");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.os.Vibrator");
        this.f230320f = (Vibrator) r103;
        tt5.a.h("RecordViewModel", "currentUserLocale:" + ((String) r102.getValue()));
    }

    public final void e(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "perCall");
        com.ss.android.lark.utils.h.a(this.f230317c.getActivity(), new Token("LARK-PSDA-ccm_android_comment_request_record_audio_permssion"), new b(this, r100));
    }

    public final void h(final Function3<? super String, ? super Boolean, ? super int[], Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "rskCallBack");
        this.f230320f.vibrate(100);
        if (this.f230322h == true) goto L6;
        g();
        return;
    L6:
        final boolean r101 = !com.bytedance.ee.bear.middleground.comment.export.e.a();
        if (r101 == false) goto L16;
        int r102 = com.bytedance.ee.bear.middleground.comment.audio.c.f230335a;
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).c();
        monitor-enter(this);
        final int r103 = this.f230324j + 1;     // Catch: Throwable -> L13
        this.f230324j = r103;     // Catch: Throwable -> L13
        monitor-exit(this);
    L17:
        this.f230318d = true;
        tt5.a.h("RecordViewModel", "startRecord:" + this.f230321g.getValue());
        this.f230321g.setValue((String) this.f230319e.a("AUDIO_RECOGNIZE_LOCALE_SETTING_KEY", "zh_ch"));
        int r104 = com.bytedance.ee.bear.middleground.comment.audio.c.f230335a;
        String r105 = this.f230321g.getValue();
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        Function3<String, Boolean, int[], Unit> r106 = new RecordViewModel$startRecord$1(r101, this, r103, r100);
        Intrinsics.checkNotNullParameter(r105, "speechLocale");
        Intrinsics.checkNotNullParameter(r106, "askCallCallBack");
        ((com.bytedance.ee.bear.middleground.audio.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground.audio.h.class, null, null, 6)).b(r105, r106);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        r103 = this.f230324j;
        goto L17
    }

    public static final void d(RecordViewModel r100, String r101) {
        r100.getClass();
        FragmentActivity r102 = r100.f230317c.getActivity();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r103 = new UDDialogBuilder(r102);
        r103.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r101, "value");
        r103.message(r101);
        r103.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_Ok, new l(r100));
        UDDialog r104 = r103.build();
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
    }

    public final synchronized void j(Function0<Unit> r100, Function0<Unit> r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "successCallback");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r101, "interruptCallback");     // Catch: Throwable -> L6
        k();     // Catch: Throwable -> L6
        this.f230323i = new c(r101, this, r100);     // Catch: Throwable -> L6
        MediaMutex r102 = MediaMutex.f431631r;     // Catch: Throwable -> L6
        Scene r103 = Scene.CCM_Audio_Record;     // Catch: Throwable -> L6
        c r104 = this.f230323i;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L6
        r102.l(r103, false, r104, true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
