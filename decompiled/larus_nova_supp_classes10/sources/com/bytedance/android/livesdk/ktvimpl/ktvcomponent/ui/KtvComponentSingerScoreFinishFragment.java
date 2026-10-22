package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/KtvComponentSingerScoreFinishFragment;", "Lcom/bytedance/android/livesdk/ktvimpl/ksong/base/view/AbsKSongScoreFinishFragment;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentSingerScoreFinishFragment extends AbsKSongScoreFinishFragment {
    public static final /* synthetic */ int k = 0;
    public boolean g;
    public int h;
    public int i;
    public DataCenter j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvComponentSingerScoreFinishFragment a;

        public b(KtvComponentSingerScoreFinishFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            KtvComponentSingerScoreFinishFragment r0 = this.a;
            if (r0.g == false) goto L7;
            TextView r1 = r0.f;
            if (r1 == null) goto L11;
            r1.setText(s1.C(2131918457, new Object[]{Long.valueOf(((long) 9) - r10.longValue())}));
            return;
        L11:
            return;
        L7:
            TextView r2 = r0.f;
            if (r2 == null) goto L13;
            r2.setText(s1.C(2131918402, new Object[]{Long.valueOf(((long) 9) - r10.longValue())}));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ KtvComponentSingerScoreFinishFragment a;

        public d(KtvComponentSingerScoreFinishFragment r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ KtvComponentSingerScoreFinishFragment a;

        public e(KtvComponentSingerScoreFinishFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ KtvComponentSingerScoreFinishFragment a;

        public f(KtvComponentSingerScoreFinishFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment
    public final Disposable S90() {
        return du2.a.d(1, TimeUnit.SECONDS).take(10).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a, new d(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment
    public final float T90() {
        int r0 = this.h;
        if (r0 != 0) goto L7;
        return 0.0f;
    L7:
        return this.i / r0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment
    public final void initViews() {
        TextView r0 = this.f;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        KtvComponentOrderedSongDataContext r1 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r1 == null) goto L8;
        MusicPanel r2 = r1.getKtvPublicSecondOrderedSong();
    L10:
        if (r2 == null) goto L12;
        boolean r3 = true;
    L13:
        this.g = r3;
        if (r3 == false) goto L21;
        TextView r4 = this.f;
        if (r4 == null) goto L18;
        r4.setText(s1.C(2131918457, new Object[]{10}));
    L18:
        TextView r5 = this.f;
        if (r5 == null) goto L27;
        r5.setOnClickListener(new e(this));
    L27:
        super.initViews();
        return;
    L21:
        TextView r6 = this.f;
        if (r6 == null) goto L24;
        r6.setText(s1.C(2131918402, new Object[]{10}));
    L24:
        TextView r7 = this.f;
        if (r7 == null) goto L27;
        r7.setOnClickListener(new f(this));
        goto L27
    L12:
        r3 = false;
        goto L13
    L8:
        r2 = null;
        goto L10
    }

    public KtvComponentSingerScoreFinishFragment() {
        this.g = true;
    }

    public final void dismissAllowingStateLoss() {
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment
    public final void U90(String r7) {
        KtvContext.Companion.getClass();
        MusicPanel r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r0 == null) goto L7;
        KtvMusic r1 = r0.a;
        if (r1 == null) goto L7;
        long r2 = r1.getMId();
    L8:
        Long r3 = KtvLoggerHelper.a;
        if (r7 == null) goto L12;
        String r8 = r7.toUpperCase();
        if (r8 == null) goto L12;
    L13:
        String r4 = com.bytedance.android.live.ktv.common.util.j.e(this.j);
        String r5 = com.bytedance.android.live.ktv.common.util.j.a(this.j);
        Intrinsics.checkNotNullParameter(r8, "level");
        Intrinsics.checkNotNullParameter(r4, "liveType");
        Intrinsics.checkNotNullParameter(r5, "roomType");
        HashMap r6 = new HashMap(4);
        r6.put("ksong_id", String.valueOf(r2));
        r6.put("live_type", r4);
        r6.put("room_type", r5);
        r6.put("score_level", r8);
        j0.l().sendLog("anchor_ksong_score_level", r6, new Object[]{IRoom.class, am2.x.class});
        return;
    L12:
        r8 = "";
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        this.i = r3.getInt("ARG_CUR_TOTAL_SCORE");
        this.h = r3.getInt("ARG_TOTAL_SCORE");
        return;
    }
}
