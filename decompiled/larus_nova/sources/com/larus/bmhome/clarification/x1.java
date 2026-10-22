package com.larus.bmhome.clarification;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.input.swipe.InputContentMode;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import com.larus.im.bean.message.block.InteractionAskQuestionCapability;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class x1 implements ze8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e2 f310629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f310630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Integer, InteractionAskOption, Unit> f310631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Integer, Unit> f310632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, BaseResourceViewHolder.a> f310633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Integer, Integer> f310634f;

    public static final class a extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public hk9.a f310635a;

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }
    }

    @Override // ze8.a
    public final int getPageCount() {
        d2 r100 = this.f310629a.f310511a;
        if (r100 == null) goto L7;
        List<InteractionAskQuestion> r101 = r100.f310502h;
        if (r101 == null) goto L7;
        return r101.size();
    L7:
        return 0;
    }

    @Override // ze8.a
    public final a b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        a r101 = new a(r100.getContext());
        int r102 = ra8.a.f536852a;
        hk9.a r103 = ra8.a.a(r100.getContext());
        Intrinsics.checkNotNullParameter(r103, "blockContainer");
        if (r101.f310635a == r103) goto L6;
        r101.removeAllViews();
        r101.f310635a = r103;
        r101.addView(r103, new FrameLayout.LayoutParams(-1, -2, 80));
    L6:
        return r101;
    }

    @Override // ze8.a
    public final ze8.d c(int r110) {
        d2 r100 = this.f310629a.f310511a;
        InputContentMode r101 = null;
        if (r100 == null) goto L7;
        List<z1> r102 = r100.f310506l;
        if (r102 == null) goto L7;
        z1 r103 = (z1) CollectionsKt.getOrNull(r102, r110);
    L8:
        if (r100 == null) goto L12;
        List<InteractionAskQuestion> r104 = r100.f310502h;
        if (r104 == null) goto L12;
        InteractionAskQuestion r105 = (InteractionAskQuestion) CollectionsKt.getOrNull(r104, r110);
    L13:
        if (r105 == null) goto L17;
        InteractionAskQuestionCapability r106 = r105.getQuestionCapability();
        if (r106 == null) goto L17;
        String r107 = r106.getTextPlaceholder();
    L18:
        if (r105 == null) goto L22;
        InteractionAskQuestionCapability r108 = r105.getQuestionCapability();
        if (r108 == null) goto L22;
        boolean r109 = Intrinsics.areEqual(r108.getAllowText(), Boolean.TRUE);
    L23:
        if (r103 == null) goto L27;
        i r111 = r103.f310655l;
        if (r111 == null) goto L27;
        String r112 = r111.f310541b;
    L28:
        String r113 = "";
        if (r112 != null) goto L31;
        String r114 = "";
    L32:
        if (r105 == null) goto L34;
        String r115 = r105.getQuestionId();
    L35:
        if (r115 == null) goto L39;
        r113 = r115;
    L39:
        if (StringsKt.isBlank(r113) == false) goto L41;
        String r116 = "clarification_input_" + r110;
    L42:
        if (r109 == false) goto L44;
        String r117 = r107;
    L45:
        if (r103 == null) goto L47;
        int r118 = r103.f310648e;
    L48:
        int r119 = r118;
        if (r103 == null) goto L51;
        int r120 = r103.f310649f;
    L52:
        int r121 = r120;
        Integer r122 = this.f310634f.invoke(Integer.valueOf(r110));
        if (r103 == null) goto L55;
        ze8.c r123 = y1.a(r103, null);
    L56:
        if (r103 == null) goto L63;
        if (r103.f310650g == false) goto L60;
        InputContentMode r124 = InputContentMode.SPEAK;
    L61:
        r101 = r124;
        goto L63
    L60:
        r124 = InputContentMode.TEXT;
    L63:
        return new ze8.d(r116, r114, r117, r119, r121, r122, r123, r101);
    L55:
        r123 = null;
        goto L56
    L51:
        r120 = r114.length();
        goto L52
    L47:
        r118 = r114.length();
        goto L48
    L44:
        r117 = null;
        goto L45
    L41:
        r116 = r113;
        goto L42
    L34:
        r115 = null;
        goto L35
    L31:
        r114 = r112;
    L27:
        r112 = null;
    L22:
        r109 = false;
    L17:
        r107 = null;
    L12:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // ze8.a
    public final void onPageSelected(int r100) {
        this.f310632d.invoke(Integer.valueOf(r100));
    }

    @Override // ze8.a
    public final void a(View r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "page");
        d2 r110 = this.f310629a.f310511a;
        if (r110 != null) goto L6;
        return;
    L6:
        if ((r210 instanceof a) == false) goto L8;
        a r100 = (a) r210;
    L9:
        if (r100 == null) goto L22;
        final hk9.a r111 = r100.f310635a;
        if (r111 == null) goto L23;
        z1 r101 = (z1) CollectionsKt.getOrNull(r110.f310506l, r211);
        if (r101 != null) goto L16;
        return;
    L16:
        i r102 = r101.f310655l;
        List<String> r103 = r102.f310540a;
        String r104 = r102.f310541b;
        boolean r105 = r101.f310652i;
        int r106 = r101.f310653j;
        List<ResourceItemBean> r107 = r101.f310654k;
        Function0<Unit> r108 = this.f310630b;
        Function2<Integer, InteractionAskOption, Unit> r112 = this.f310631c;
        Function1<Integer, BaseResourceViewHolder.a> r109 = this.f310633e;
        if (r109 == null) goto L19;
        BaseResourceViewHolder.a r113 = r109.invoke(Integer.valueOf(r211));
    L20:
        r111.b(u.class, new u(r211, r103, r104, r105, r106, r107, r108, r112, r113));
        this.f310629a.d(r211, new w1(r111));
        int r114 = ra8.a.f536852a;
        ra8.a.d(r111, CollectionsKt.listOf(Block.copy$default(r110.f310501g, 0, null, null, null, false, null, null, null, 251, null)), new kc8.f(r110.f310500f, Boolean.TRUE, false, false, null, "input_supplement", 476), true);
        return;
    L19:
        r113 = null;
        goto L20
    L23:
        return;
    L22:
        return;
    L8:
        r100 = null;
        goto L9
    }

    public x1(e2 r100, i0 r101, t0 r102, e1 r103, j1 r104, k1 r105) {
        Intrinsics.checkNotNullParameter(r100, "stateStore");
        Intrinsics.checkNotNullParameter(r101, "onCloseClick");
        Intrinsics.checkNotNullParameter(r102, "onOptionClick");
        Intrinsics.checkNotNullParameter(r103, "onPageSelected");
        Intrinsics.checkNotNullParameter(r105, "sendButtonImageResId");
        this.f310629a = r100;
        this.f310630b = r101;
        this.f310631c = r102;
        this.f310632d = r103;
        this.f310633e = r104;
        this.f310634f = r105;
    }
}
