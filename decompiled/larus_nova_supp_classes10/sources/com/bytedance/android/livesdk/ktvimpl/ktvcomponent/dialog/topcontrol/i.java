package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public ImageView a;
    public boolean b;
    public final LifecycleOwner c;
    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c d;
    public final String e;

    public static final class a<T> implements Observer {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.a.d;
            if (r0 == null) goto L7;
            KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
            if (r1 == null) goto L7;
            MusicPanel r2 = r1.b();
        L8:
            this.a.getClass();
            if (r2 == null) goto L13;
            boolean r3 = true;
            if (KtvUtilsKt.B(r2) != true) goto L13;
        L14:
            if (r3 == false) goto L22;
            ImageView r6 = this.a.a;
            if (r6 == null) goto L18;
            r6.setAlpha(1.0f);
        L18:
            ImageView r7 = this.a.a;
            if (r7 == null) goto L21;
            r7.setTag(Boolean.TRUE);
        L21:
            this.a.a(r5.booleanValue());
            return;
        L22:
            ImageView r8 = this.a.a;
            if (r8 == null) goto L25;
            r8.setAlpha(0.5f);
        L25:
            ImageView r9 = this.a.a;
            if (r9 == null) goto L28;
            r9.setTag(Boolean.FALSE);
        L28:
            this.a.a(false);
            return;
        L13:
            r3 = false;
        L7:
            r2 = null;
            goto L8
        }
    }

    public final void a(boolean r3) {
        ImageView r0 = this.a;
        if (r0 == null) goto L7;
        if (r3 == false) goto L6;
        r0.setBackgroundResource(2131252139);
        goto L7
    L6:
        r0.setBackgroundResource(2131252136);
    L7:
        this.b = r3;
    }

    public final void b(boolean r7) {
        if (r7 == false) goto L50;
        KtvComponentContext.a r8 = KtvComponentContext.Companion;
        KtvComponentContext r3 = r8.getContext();
        if (r3 == null) goto L13;
        n<KtvComponentUIContext> r4 = r3.getKtvComponentUIContext();
        if (r4 == null) goto L13;
        KtvComponentUIContext r5 = (KtvComponentUIContext) r4.getValue();
        if (r5 == null) goto L13;
        MutableLiveData<Boolean> r6 = r5.getScoreOpen();
        if (r6 == null) goto L13;
        r6.observe(this.c, new a(this));
    L13:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r9 = this.d;
        if (r9 == null) goto L18;
        KtvRoomLyricsStateMachineConfig.d r10 = r9.getCurState();
        if (r10 == null) goto L18;
        MusicPanel r11 = r10.b();
    L19:
        if (r11 != null) goto L21;
    L23:
        boolean r12 = false;
    L24:
        if (r12 == false) goto L43;
        ImageView r1 = this.a;
        if (r1 == null) goto L28;
        r1.setAlpha(1.0f);
    L28:
        ImageView r2 = this.a;
        if (r2 == null) goto L31;
        r2.setTag(Boolean.TRUE);
    L31:
        KtvComponentContext r13 = r8.getContext();
        if (r13 == null) goto L41;
        n<KtvComponentUIContext> r14 = r13.getKtvComponentUIContext();
        if (r14 == null) goto L41;
        KtvComponentUIContext r15 = (KtvComponentUIContext) r14.getValue();
        if (r15 == null) goto L41;
        MutableLiveData<Boolean> r16 = r15.getScoreOpen();
        if (r16 == null) goto L41;
        Boolean r17 = (Boolean) r16.getValue();
        if (r17 == null) goto L41;
    L42:
        a(r17.booleanValue());
    L57:
        ImageView r18 = this.a;
        if (r18 != null) goto L60;
        return;
    L60:
        if (this.b != true) goto L62;
        r18.setBackgroundResource(2131252139);
        return;
    L62:
        r18.setBackgroundResource(2131252136);
        return;
    L41:
        r17 = Boolean.FALSE;
        goto L42
    L43:
        ImageView r19 = this.a;
        if (r19 == null) goto L46;
        r19.setAlpha(0.5f);
    L46:
        ImageView r20 = this.a;
        if (r20 == null) goto L49;
        r20.setTag(Boolean.FALSE);
    L49:
        this.b = false;
        goto L57
    L21:
        if (KtvUtilsKt.B(r11) != true) goto L23;
        r12 = true;
    L18:
        r11 = null;
        goto L19
    L50:
        ImageView r21 = this.a;
        if (r21 == null) goto L53;
        r21.setAlpha(0.5f);
    L53:
        ImageView r22 = this.a;
        if (r22 == null) goto L56;
        r22.setTag(Boolean.FALSE);
    L56:
        this.b = false;
        goto L57
    }

    public i(LifecycleOwner r2, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
