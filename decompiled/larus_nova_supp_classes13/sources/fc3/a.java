package fc3;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.g;
import com.bytedance.android.ecom.arch.slice.action.h;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.CommentFragment;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentTemplate;
import com.bytedance.android.shopping.commentv3.event_chain.f;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import ic3.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final String a;
    public final C0195a b;
    public final EventChain c;

    /* JADX INFO: renamed from: fc3.a$a, reason: collision with other inner class name */
    public static final class C0195a {
        public final Context a;
        public final CommentParams b;
        public final com.bytedance.android.shopping.commentv3.data.b c;
        public final CommentFragment d;
        public final Function1<Number, Integer> e;
        public final Function1<Number, Float> f;
        public final d g;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0195a) == false) goto L20;
            C0195a r4 = (C0195a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            Context r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            CommentParams r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            com.bytedance.android.shopping.commentv3.data.b r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            CommentFragment r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Function1<Number, Integer> r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Function1<Number, Float> r16 = this.f;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            d r19 = this.g;
            if (r19 == null) goto L30;
            r1 = r19.hashCode();
        L30:
            return r18 + r1;
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ActionContextParams(context=" + this.a + ", commentParams=" + this.b + ", viewModel=" + this.c + ", fragment=" + this.d + ", slcDp=" + this.e + ", slcSp=" + this.f + ", commentV3Tracker=" + this.g + ")";
        }

        public final Context getContext() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0195a(Context r2, CommentParams r3, com.bytedance.android.shopping.commentv3.data.b r4, CommentFragment r5, Function1<? super Number, Integer> r6, Function1<? super Number, Float> r7, d r8) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "viewModel");
            Intrinsics.checkNotNullParameter(r5, "fragment");
            Intrinsics.checkNotNullParameter(r6, "slcDp");
            Intrinsics.checkNotNullParameter(r7, "slcSp");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public final void a(c r10) {
        Intrinsics.checkNotNullParameter(r10, "handleActionParams");
        EventChain r1 = this.c;
        String r2 = null;
        if (r1 == null) goto L39;
        int r3 = f.a;
        Intrinsics.checkNotNullParameter(r10, "handleActionParams");
        Intrinsics.checkNotNullParameter(this, "actionContext");
        IAction r0 = r10.a;
        CommentSliceComponent r4 = r10.d;
        Pair r5 = h.c(r0);
        if (r5 == null) goto L42;
        Pair r6 = TuplesKt.to(r5.getFirst(), r5.getSecond());
        if (r6 == null) goto L44;
        List r7 = (List) r6.component1();
        Intrinsics.checkNotNullParameter(r0, "$this$getChainName");
        String r8 = r0.getType();
        if (r7 == null) goto L15;
        List r9 = r7;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r12 = r9.iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        eq.a r13 = (eq.a) r12.next();
        Intrinsics.checkNotNullParameter(r13, "$this$toChainBaseEvent");
        r11.add(new g(r13));
    L17:
        if (r11 != null) goto L19;
    L22:
        boolean r14 = true;
    L24:
        if ((true ^ r14) == true) goto L27;
        r11 = null;
    L27:
        if (r11 == null) goto L43;
        LinkedHashMap r15 = new LinkedHashMap();
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("handle_action_params", r10);
        r16.put("action_context", this);
        StringBuilder r17 = new StringBuilder();
        r17.append(r8);
        r17.append('_');
        if (r4 == null) goto L31;
        String r18 = r4.getSliceId();
    L32:
        r17.append(r18);
        r17.append('_');
        if (r4 == null) goto L37;
        CommentTemplate r19 = r4.getTemplate();
        if (r19 == null) goto L37;
        r2 = r19.getName();
    L37:
        r17.append(r2);
        h.b(r1, r17.toString(), r11, r15, r16, "comment_fragment", new yp.b(0));
        return;
    L31:
        r18 = null;
        goto L32
    L43:
        return;
    L19:
        if (r11.isEmpty() == true) goto L22;
        r14 = false;
        goto L24
    L15:
        r11 = null;
        goto L17
    L44:
        return;
    L42:
        return;
    L39:
        dm.a.b r110 = dm.a.a;
        dm.a.a(this.a).b("eventChain is null", null);
    }

    public a(C0195a r2, EventChain r3) {
        Intrinsics.checkNotNullParameter(r2, "actionCtxParams");
        this.b = r2;
        this.c = r3;
        this.a = "CommentActionContext";
    }
}
