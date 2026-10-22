package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/a;", "Lcom/bytedance/android/ec/model/g;", "", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/d;", "content", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends g {

    @SerializedName("interaction")
    private final List<d> content;

    public final List<e> a() {
        if (this.content == null) goto L5;
        ArrayList r0 = new ArrayList();
        Iterator<d> r1 = this.content.iterator();
    L8:
        if (r1.hasNext() == false) goto L43;
        d r2 = r1.next();
        List<f> r3 = r2.a();
        if (r3 == null) goto L8;
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        ArrayList r11 = new ArrayList();
        e r12 = new e();
        Iterator<f> r4 = r3.iterator();
    L12:
        int r13 = 0;
        if (r4.hasNext() == false) goto L36;
        f r5 = r4.next();
        int r6 = r5.c();
        if (r6 != 1) goto L17;
        String r7 = r5.a();
        if (com.bytedance.android.shopping.anchorv3.a.b(r7) == true) goto L33;
        r7 = null;
    L33:
        if (r7 == null) goto L12;
        r11.add(r7);
        goto L12
    L17:
        if (r6 != 2) goto L19;
        String r8 = r5.d();
        if (r8 == null) goto L12;
        r10.append(r8);
        if (com.bytedance.android.shopping.anchorv3.a.b(r5.e()) == false) goto L12;
        int r9 = s.a;
        r10.setSpan(new ForegroundColorSpan(s.a(r5.e(), -1)), StringsKt.indexOf$default(r10, r8, 0, false, 6, null), r10.length(), 0);
        goto L12
    L19:
        if (r6 != 3) goto L12;
        int r14 = r5.b();
    L22:
        if (r13 >= r14) goto L12;
        r10.append(" ");
        r13 = r13 + 1;
        goto L22
    L36:
        if ((!r11.isEmpty()) == true) goto L38;
    L42:
        r12.a = r2.getType();
        r12.b = r10;
        r12.c = r11;
        r0.add(r12);
        goto L8
    L38:
        if (r11.size() <= 1) goto L40;
        int r15 = UtilityKotlinExtentionsKt.d(34);
    L41:
        r10.setSpan(new LeadingMarginSpan.Standard(r15, 0), 0, r10.length(), 0);
        goto L42
    L40:
        r15 = UtilityKotlinExtentionsKt.d(20);
        goto L41
    L43:
        return r0;
    L5:
        return new ArrayList();
    }

    public a() {
    }
}
