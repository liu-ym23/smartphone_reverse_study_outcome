package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ GroupInfo d;

    public k(ViewGroup r1, ViewGroup r2, TextView r3, GroupInfo r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r12) {
        Disposable r13 = (Disposable) r12;
        ViewGroup r14 = this.a;
        ViewGroup r0 = this.b;
        TextView r1 = this.c;
        GroupInfo r2 = this.d;
        r1.setVisibility(0);
        SpannableStringBuilder r4 = new SpannableStringBuilder();
        int r5 = r2.getGroupSize();
        int r6 = r2.getJoined();
        if (r6 != 0) goto L5;
        SpannableString r10 = new SpannableString(ag4.a.a(2131913943, CollectionsKt.listOf(Integer.valueOf(r5))));
        r10.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), 0, String.valueOf(r5).length() + 1, 17);
        r4.append(r10);
    L8:
        r1.setText(r4);
        Intrinsics.checkNotNullParameter(r2, "groupInfo");
        if (r2.getJoined() > 0) goto L11;
    L13:
        Drawable r3 = com.bytedance.commerce.base.drawable.a.a(DoExpandGroupAnimKt$generateGroupDescriptionBg$2.INSTANCE);
    L14:
        Intrinsics.checkNotNullParameter(r1, "$this$setBackgroundCompat");
        r1.setBackground(r3);
        Intrinsics.checkNotNullParameter(r14, "parent");
        Intrinsics.checkNotNullParameter(r0, "sibling");
        Intrinsics.checkNotNullParameter(r1, "target");
        int r15 = r14.getMeasuredWidth();
        int r7 = r0.getMeasuredWidth();
        float r8 = r1.getPaint().measureText(r1.getText().toString());
        int r16 = (r15 - r7) - (r1.getPaddingRight() * 2);
    L16:
        if (r16 >= r8) goto L24;
        float r9 = r1.getTextSize() - UIUtils.sp2px(r1.getContext(), 1.0f);
        if (r9 < 0) goto L19;
        r1.setTextSize(0, r9);
        r8 = r1.getPaint().measureText(r1.getText().toString());
        goto L16
    L19:
        r1.setVisibility(8);
        return;
    L24:
        return;
    L11:
        if (r2.getJoined() < r2.getGroupSize()) goto L13;
        r3 = com.bytedance.commerce.base.drawable.a.a(DoExpandGroupAnimKt$generateGroupDescriptionBg$1.INSTANCE);
        goto L14
    L5:
        if (r6 >= r5) goto L7;
        int r11 = r5 - r6;
        SpannableString r17 = new SpannableString(ag4.a.a(2131913942, CollectionsKt.listOf(Integer.valueOf(r11))));
        r17.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), 2, (String.valueOf(r11).length() + 2) + 1, 17);
        r4.append(r17);
        goto L8
    L7:
        SpannableString r18 = new SpannableString(ag4.a.d(2131913941));
        r18.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55")), 0, r18.length(), 17);
        r4.append(r18);
        goto L8
    }
}
