package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.UserHighScoreSongTag;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends me.drakeet.multitype.b<com.bytedance.android.live.ktv.common.model.bean.d, ApplyUserItemViewHolder> {
    public final d b;

    public b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        final ApplyUserItemViewHolder r10 = (ApplyUserItemViewHolder) r8;
        final com.bytedance.android.live.ktv.common.model.bean.d r11 = (com.bytedance.android.live.ktv.common.model.bean.d) r9;
        Intrinsics.checkNotNullParameter(r10, "viewHolder");
        Intrinsics.checkNotNullParameter(r11, "data");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "waitingUser");
        HSImageView r0 = (HSImageView) r10.a.getValue();
        String r1 = null;
        if (r0 == null) goto L9;
        IBaseUser r2 = r11.f();
        if (r2 == null) goto L7;
        py.k r3 = r2.getAvatarThumbKt();
    L8:
        a1.x(r0, r3, r0.getWidth(), r0.getHeight(), 2131251677);
        goto L9
    L7:
        r3 = null;
    L9:
        TextView r4 = (TextView) r10.c.getValue();
        if (r4 == null) goto L16;
        IBaseUser r5 = r11.f();
        if (r5 == null) goto L14;
        String r6 = r5.getNickName();
    L15:
        r4.setText(r6);
        goto L16
    L14:
        r6 = null;
    L16:
        TextView r7 = (TextView) r10.h.getValue();
        if (r7 == null) goto L19;
        r7.setText(ApplyUserItemViewHolder.T3(r11));
    L19:
        View r12 = ((RecyclerView.ViewHolder) r10).itemView;
        StringBuilder r13 = new StringBuilder();
        IBaseUser r14 = r11.f();
        if (r14 == null) goto L22;
        String r15 = r14.getNickName();
    L23:
        r13.append(r15);
        r13.append(' ');
        r13.append(ApplyUserItemViewHolder.T3(r11));
        r3.a(r12, r13.toString());
        UserHighScoreSongTag r16 = r11.d();
        int r17 = 0;
        if (r16 != null) goto L26;
    L53:
        ImageView r18 = (ImageView) r10.b.getValue();
        if (r18 == null) goto L66;
        IBaseUser r19 = r11.f();
        if (r19 != null) goto L58;
    L60:
        IBaseUser r20 = r11.f();
        if (r20 != null) goto L63;
    L65:
        r18.setVisibility(8);
        goto L66
    L63:
        if (r20.getGender() != 2) goto L65;
        r18.setImageResource(2131252069);
        r18.setVisibility(0);
        goto L66
    L58:
        if (r19.getGender() != 1) goto L60;
        r18.setImageResource(2131252070);
        r18.setVisibility(0);
    L66:
        TextView r21 = (TextView) r10.i.getValue();
        if (r21 != null) goto L69;
    L73:
        r3.c((TextView) r10.i.getValue(), s1.B(2131919204), true);
        ImageView r22 = (ImageView) r10.j.getValue();
        if (r22 == null) goto L91;
        IBaseUser r23 = r11.f();
        if (r23 == null) goto L78;
        String r24 = r23.getIdString();
    L79:
        IMiddlewareUserService r25 = jc1.k.f(IMiddlewareUserService.class);
        if (r25 == null) goto L87;
        com.bytedance.android.livesdk.user.e r26 = r25.user();
        if (r26 == null) goto L87;
        String r27 = r26.n();
        if (r27 == null) goto L87;
        r1 = r27;
    L87:
        if (Intrinsics.areEqual(r24, r1) == true) goto L90;
        r17 = 8;
    L90:
        r22.setVisibility(r17);
        goto L91
    L78:
        r24 = null;
    L91:
        r3.c((ImageView) r10.j.getValue(), s1.B(2131914425), true);
        TextView r28 = (TextView) r10.i.getValue();
        if (r28 == null) goto L94;
        r28.setOnClickListener(x0.a(new ApplyUserItemViewHolder$bind$5(r10, r11)));
    L94:
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(x0.a(new ApplyUserItemViewHolder$bind$6(r11)));
        ImageView r29 = (ImageView) r10.j.getValue();
        if (r29 == null) goto L99;
        r29.setOnClickListener(x0.a(new ApplyUserItemViewHolder$bind$7(r10, r11)));
        return;
    L99:
        return;
    L69:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L71;
        int r30 = 0;
    L72:
        r21.setVisibility(r30);
        goto L73
    L71:
        r30 = 8;
        goto L72
    L26:
        if (TextUtils.isEmpty(r16.getHighScoreSongCount()) == true) goto L53;
        LinearLayout r31 = (LinearLayout) r10.d.getValue();
        if (r31 == null) goto L31;
        r31.setVisibility(0);
    L31:
        List r32 = r16.getBgColor();
        if (r32 == null) goto L39;
        List r33 = r32;
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r35 = r33.iterator();
    L35:
        if (r35.hasNext() == false) goto L37;
        r34.add(Integer.valueOf(ColorProtector.parseColor((String) r35.next())));
        goto L35
    L37:
        int[] r36 = CollectionsKt.toIntArray(r34);
        if (r36 == null) goto L39;
    L41:
        if (r36.length <= 1) goto L45;
        GradientDrawable r37 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r36);
        r37.setShape(0);
        r37.setCornerRadius(s1.e(27.0f));
        LinearLayout r38 = (LinearLayout) r10.d.getValue();
        if (r38 == null) goto L45;
        r38.setBackground(r37);
    L45:
        TextView r39 = (TextView) r10.f.getValue();
        if (r39 == null) goto L48;
        r39.setText(r16.getHighScoreSongCount());
    L48:
        HSImageView r40 = (HSImageView) r10.e.getValue();
        Uri r41 = UriProtector.parse(r16.getIcon());
        if (r40 == null) goto L53;
        if (r41 == null) goto L53;
        r40.setImageURI(r41);
    L39:
        r36 = new int[0];
        goto L41
    L22:
        r15 = null;
        goto L23
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ApplyUserItemViewHolder(r4.inflate(2131566475, r5, false), this.b);
    }
}
