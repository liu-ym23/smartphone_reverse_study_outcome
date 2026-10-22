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
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f476336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C5880a f476337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EventChain f476338c;

    /* JADX INFO: renamed from: fc3.a$a, reason: collision with other inner class name */
    public static final class C5880a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f476339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CommentParams f476340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.shopping.commentv3.data.b f476341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CommentFragment f476342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<Number, Integer> f476343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<Number, Float> f476344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final d f476345g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C5880a) == false) goto L20;
            C5880a r101 = (C5880a) r100;
            if (Intrinsics.areEqual(this.f476339a, r101.f476339a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f476340b, r101.f476340b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f476341c, r101.f476341c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476342d, r101.f476342d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f476343e, r101.f476343e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f476344f, r101.f476344f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f476345g, r101.f476345g) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            Context r100 = this.f476339a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            CommentParams r104 = this.f476340b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            com.bytedance.android.shopping.commentv3.data.b r107 = this.f476341c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            CommentFragment r110 = this.f476342d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Function1<Number, Integer> r113 = this.f476343e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Function1<Number, Float> r116 = this.f476344f;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            d r119 = this.f476345g;
            if (r119 == null) goto L30;
            r101 = r119.hashCode();
        L30:
            return r118 + r101;
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ActionContextParams(context=" + this.f476339a + ", commentParams=" + this.f476340b + ", viewModel=" + this.f476341c + ", fragment=" + this.f476342d + ", slcDp=" + this.f476343e + ", slcSp=" + this.f476344f + ", commentV3Tracker=" + this.f476345g + ")";
        }

        public final Context getContext() {
            return this.f476339a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C5880a(Context r100, CommentParams r101, com.bytedance.android.shopping.commentv3.data.b r102, CommentFragment r103, Function1<? super Number, Integer> r104, Function1<? super Number, Float> r105, d r106) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "viewModel");
            Intrinsics.checkNotNullParameter(r103, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r104, "slcDp");
            Intrinsics.checkNotNullParameter(r105, "slcSp");
            this.f476339a = r100;
            this.f476340b = r101;
            this.f476341c = r102;
            this.f476342d = r103;
            this.f476343e = r104;
            this.f476344f = r105;
            this.f476345g = r106;
        }
    }

    public final void a(c r110) {
        Intrinsics.checkNotNullParameter(r110, "handleActionParams");
        EventChain r100 = this.f476338c;
        String r101 = null;
        if (r100 == null) goto L39;
        int r102 = f.f172802a;
        Intrinsics.checkNotNullParameter(r110, "handleActionParams");
        Intrinsics.checkNotNullParameter(this, "actionContext");
        IAction r103 = r110.f476346a;
        CommentSliceComponent r104 = r110.f476349d;
        Pair<List<eq.a>, String> r105 = h.c(r103);
        if (r105 == null) goto L42;
        Pair r106 = TuplesKt.to(r105.getFirst(), r105.getSecond());
        if (r106 == null) goto L44;
        List r107 = (List) r106.component1();
        Intrinsics.checkNotNullParameter(r103, "$this$getChainName");
        String r108 = r103.getType();
        if (r107 == null) goto L15;
        List r109 = r107;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r112 = r109.iterator();
    L13:
        if (r112.hasNext() == false) goto L17;
        eq.a r113 = (eq.a) r112.next();
        Intrinsics.checkNotNullParameter(r113, "$this$toChainBaseEvent");
        r111.add(new g(r113));
    L17:
        if (r111 != null) goto L19;
    L22:
        boolean r114 = true;
    L24:
        if ((true ^ r114) == true) goto L27;
        r111 = null;
    L27:
        if (r111 == null) goto L43;
        LinkedHashMap r115 = new LinkedHashMap();
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put("handle_action_params", r110);
        r116.put("action_context", this);
        StringBuilder r117 = new StringBuilder();
        r117.append(r108);
        r117.append('_');
        if (r104 == null) goto L31;
        String r118 = r104.getSliceId();
    L32:
        r117.append(r118);
        r117.append('_');
        if (r104 == null) goto L37;
        CommentTemplate r119 = r104.getTemplate();
        if (r119 == null) goto L37;
        r101 = r119.getName();
    L37:
        r117.append(r101);
        h.b(r100, r117.toString(), r111, r115, r116, "comment_fragment", new yp.b(0));
        return;
    L31:
        r118 = null;
        goto L32
    L43:
        return;
    L19:
        if (r111.isEmpty() == true) goto L22;
        r114 = false;
        goto L24
    L15:
        r111 = null;
        goto L17
    L44:
        return;
    L42:
        return;
    L39:
        dm.a.b r120 = dm.a.f469202a;
        dm.a.a(this.f476336a).b("eventChain is null", null);
    }

    public a(C5880a r100, EventChain r101) {
        Intrinsics.checkNotNullParameter(r100, "actionCtxParams");
        this.f476337b = r100;
        this.f476338c = r101;
        this.f476336a = "CommentActionContext";
    }
}
