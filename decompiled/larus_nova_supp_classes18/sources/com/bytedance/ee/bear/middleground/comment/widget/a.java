package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends RecyclerView.Adapter<d> {
    public final List<b> a;
    public final Set<String> b;
    public Function1<? super b, Unit> c;
    public com.bytedance.ee.bear.middleground.comment.uitls.h d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.widget.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0074a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BotAtHintActionType.values().length];
            r0[BotAtHintActionType.LEARN_MORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BotAtHintActionType.CONFIGURE_NOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final List<j0> y2() {
        if (((ArrayList) this.a).isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList();
        List<b> r1 = this.a;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L7:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L14;
        Object r5 = r3.next();
        if (((b) r5).c != BotAtHintActionType.LEARN_MORE) goto L12;
        r4 = true;
    L12:
        if (r4 == false) goto L7;
        r2.add(r5);
        goto L7
    L14:
        HashSet r6 = new HashSet();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r2.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        if (r6.add(Long.valueOf(((b) r9).a)) == false) goto L16;
        r7.add(r9);
        goto L16
    L20:
        Iterator<T> r10 = this.a.iterator();
    L22:
        if (r10.hasNext() == false) goto L45;
        b r11 = (b) r10.next();
        if (r11.c == BotAtHintActionType.LEARN_MORE) goto L25;
        r0.add(new j0(r11, CollectionsKt.listOf(r11.b), CollectionsKt.listOf(Long.valueOf(r11.a))));
        goto L22
    L25:
        if (r4 == true) goto L22;
        if ((!r7.isEmpty()) == false) goto L22;
        b r12 = (b) CollectionsKt.first(r7);
        Iterator r13 = r7.iterator();
    L30:
        if (r13.hasNext() == false) goto L34;
        String r14 = ((b) r13.next()).d;
        if (r14 == null) goto L30;
    L35:
        long r15 = r12.a;
        String r16 = r12.b;
        BotAtHintActionType r17 = r12.c;
        String r18 = r12.e;
        Long r19 = r12.f;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r16, "botName");
        Intrinsics.checkNotNullParameter(r17, "actionType");
        b r20 = new b(r15, r16, r17, r14, r18, r19);
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r22 = r7.iterator();
    L37:
        if (r22.hasNext() == false) goto L39;
        r21.add(((b) r22.next()).b);
        goto L37
    L39:
        List r23 = CollectionsKt.distinct(r21);
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r25 = r7.iterator();
    L41:
        if (r25.hasNext() == false) goto L43;
        r24.add(Long.valueOf(((b) r25.next()).a));
        goto L41
    L43:
        r0.add(new j0(r20, r23, CollectionsKt.distinct(r24)));
        r4 = true;
        goto L22
    L34:
        r14 = null;
        goto L35
    L45:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public a() {
        this.a = new ArrayList();
        this.b = new LinkedHashSet();
    }

    public final void A2() {
        List<j0> r0 = y2();
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((j0) r2.next()).c());
        goto L4
    L6:
        this.b.retainAll(r1);
    }

    public final int getItemCount() {
        return y2().size();
    }

    public final int z2() {
        return y2().size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r20, int r21) {
        final d r1 = (d) r20;
        Intrinsics.checkNotNullParameter(r1, "holder");
        j0 r2 = (j0) ListProtector.get(y2(), r21);
        String r3 = r2.c();
        if (this.b.add(r3) == false) goto L8;
        tt5.a.h("BotAtHintView", "[BOT_GUIDE_APP_ID_TRACE] report exposure, key=" + r3 + ", appId=" + r2.a() + ", itemType=" + r2.b() + ", botIds=" + r2.c + ", botNames=" + r2.b);
        com.bytedance.ee.bear.middleground.comment.uitls.h r4 = this.d;
        if (r4 == null) goto L8;
        String r5 = r2.b();
        String r6 = r2.a();
        Map<String, Object> r7 = r4.b();
        HashMap r8 = (HashMap) r7;
        r8.put("item_type", r5);
        r8.put("app_id", r6);
        tt5.a.h("Comment#CommentAnalytic", "[BOT_GUIDE_APP_ID_TRACE] track item view, itemType = " + r5 + ", appId = " + r6);
        StringBuilder r9 = new StringBuilder("reportBotGuideItemView params = ");
        r9.append(r7);
        tt5.a.b("Comment#CommentAnalytic", r9.toString());
        r4.g.a("ccm_comment_item_view", r7);
    L8:
        Function1<? super b, Unit> r10 = this.c;
        com.bytedance.ee.bear.middleground.comment.uitls.h r11 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "item");
        Context r12 = ((RecyclerView.ViewHolder) r1).itemView.getContext();
        int r13 = d.a.a[r2.a.c.ordinal()];
        if (r13 == 1) goto L14;
        if (r13 != 2) goto L13;
        int r14 = 2131888941;
    L15:
        String r15 = r12.getString(r14);
        String r16 = xo5.a.d(((RecyclerView.ViewHolder) r1).itemView.getContext(), 2131888938, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("botNames", CollectionsKt.joinToString$default(r2.b, ((RecyclerView.ViewHolder) r1).itemView.getContext().getString(2131888942), null, null, 0, null, new BotAtHintViewHolder$bind$botNames$1(r1), 30, null)), TuplesKt.to("redirectLink", r15)}));
        SpannableStringBuilder r17 = new SpannableStringBuilder(r16);
        Intrinsics.checkNotNull(r16);
        int r18 = StringsKt.lastIndexOf$default(r16, r15, 0, false, 6, null);
        if (r18 < 0) goto L18;
        r17.setSpan(new e(r2, r11, r10, r1), r18, r15.length() + r18, 33);
    L18:
        r1.a.setHighlightColor(0);
        r1.a.setLineSpacing(com.bytedance.ee.util.ui.n.d(4), 1.0f);
        r1.a.setMovementMethod(LinkMovementMethod.getInstance());
        r1.a.setText(r17);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r14 = 2131888940;
        goto L15
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131559849, r3, false);
        Intrinsics.checkNotNull(r5);
        return new d(r5);
    }
}
