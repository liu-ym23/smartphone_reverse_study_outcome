package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view.MultiUserAvatarView;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends me.drakeet.multitype.b<z0, WantSingItemViewHolder> {
    public final e b;

    public l(k r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r13, Object r14) {
        WantSingItemViewHolder r15 = (WantSingItemViewHolder) r13;
        z0 r16 = (z0) r14;
        Intrinsics.checkNotNullParameter(r15, "holder");
        Intrinsics.checkNotNullParameter(r16, "item");
        int r1 = r15.getAdapterPosition();
        Intrinsics.checkNotNullParameter(r16, "item");
        r15.h = r16;
        TextView r0 = r15.a;
        if (r0 == null) goto L5;
        r0.setText(String.valueOf(r1 + 1));
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r2 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        TextView r3 = r15.a;
        r2.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(r3);
        HSImageView r4 = r15.b;
        KtvMusic r5 = r16.b();
        String r6 = null;
        if (r5 == null) goto L8;
        String r7 = r5.getCoverUrl();
    L9:
        ImageLoader.bindImage(r4, r7);
        TextView r8 = r15.c;
        if (r8 == null) goto L18;
        KtvMusic r9 = r16.b();
        if (r9 == null) goto L16;
        String r10 = r9.getMTitle();
        if (r10 == null) goto L16;
        r6 = StringsKt.trimStart(r10).toString();
    L16:
        r8.setText(r6);
    L18:
        if (r16.b() == null) goto L30;
        KtvMusic r11 = r16.b();
        Intrinsics.checkNotNull(r11);
        if (r11.getMDuration() <= 0) goto L27;
        TextView r12 = r15.d;
        if (r12 == null) goto L24;
        r12.setVisibility(0);
    L24:
        KtvMusic.a r17 = KtvMusic.Companion;
        KtvMusic r18 = r16.b();
        r17.getClass();
        long r19 = KtvMusic.a.a(r18);
        TextView r20 = r15.d;
        if (r20 == null) goto L30;
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;
        long r22 = 60;
        r20.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r19 / r22), Long.valueOf(r19 % r22)}, 2)));
        goto L30
    L27:
        TextView r23 = r15.d;
        if (r23 == null) goto L30;
        r23.setVisibility(8);
    L30:
        HashMap r24 = r16.a;
        if (r24.size() <= 1) goto L52;
        MultiUserAvatarView r110 = r15.f;
        if (r110 == null) goto L35;
        r110.setVisibility(0);
    L35:
        TextView r111 = r15.e;
        if (r111 == null) goto L38;
        r111.setVisibility(8);
    L38:
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a("WantSingItemViewHolder", "chorusUsers.size : " + r24.size());
        if (r24.size() <= 4) goto L46;
        TextView r112 = r15.g;
        if (r112 == null) goto L43;
        r112.setVisibility(0);
    L43:
        TextView r113 = r15.g;
        if (r113 == null) goto L49;
        r113.setText(s1.C(2131918436, new Object[]{Integer.valueOf(r24.size())}));
    L49:
        List<py.k> r114 = CollectionsKt.toMutableList(r24.values()).subList(0, Math.min(r24.size(), 4));
        MultiUserAvatarView r115 = r15.f;
        if (r115 == null) goto L71;
        r115.a(r114, r24.size());
        return;
    L71:
        return;
    L46:
        TextView r116 = r15.g;
        if (r116 == null) goto L49;
        r116.setVisibility(8);
        goto L49
    L52:
        TextView r25 = r15.g;
        if (r25 == null) goto L55;
        r25.setVisibility(8);
    L55:
        MultiUserAvatarView r26 = r15.f;
        if (r26 == null) goto L58;
        r26.setVisibility(8);
    L58:
        TextView r27 = r15.e;
        if (r27 == null) goto L61;
        r27.setVisibility(0);
    L61:
        TextView r117 = r15.e;
        if (r117 == null) goto L73;
        KtvMusic r118 = r16.b();
        if (r118 == null) goto L68;
        String r119 = r118.getMAuthor();
        if (r119 == null) goto L68;
    L69:
        r117.setText(r119);
        return;
    L68:
        r119 = "";
        goto L69
    L73:
        return;
    L8:
        r7 = null;
        goto L9
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new WantSingItemViewHolder(r4.inflate(2131566515, r5, false), this.b);
    }
}
