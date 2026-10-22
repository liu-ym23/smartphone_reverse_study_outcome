package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public final class a extends RecyclerView.Adapter<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f232313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f232314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super b, Unit> f232315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.uitls.h f232316d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.widget.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C3321a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232317a = null;

        static {
            int[] r100 = new int[BotAtHintActionType.values().length];
            r100[BotAtHintActionType.LEARN_MORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[BotAtHintActionType.CONFIGURE_NOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f232317a = r100;
        }
    }

    public final List<j0> y2() {
        if (((ArrayList) this.f232313a).isEmpty() == true) goto L5;
        ArrayList r100 = new ArrayList();
        List<b> r101 = this.f232313a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L7:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L14;
        Object r105 = r103.next();
        if (((b) r105).f232320c != BotAtHintActionType.LEARN_MORE) goto L12;
        r104 = true;
    L12:
        if (r104 == false) goto L7;
        r102.add(r105);
        goto L7
    L14:
        HashSet r106 = new HashSet();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r102.iterator();
    L16:
        if (r108.hasNext() == false) goto L20;
        Object r109 = r108.next();
        if (r106.add(Long.valueOf(((b) r109).f232318a)) == false) goto L16;
        r107.add(r109);
        goto L16
    L20:
        Iterator<T> r110 = this.f232313a.iterator();
    L22:
        if (r110.hasNext() == false) goto L45;
        b r111 = (b) r110.next();
        if (r111.f232320c == BotAtHintActionType.LEARN_MORE) goto L25;
        r100.add(new j0(r111, CollectionsKt.listOf(r111.f232319b), CollectionsKt.listOf(Long.valueOf(r111.f232318a))));
        goto L22
    L25:
        if (r104 == true) goto L22;
        if ((!r107.isEmpty()) == false) goto L22;
        b r112 = (b) CollectionsKt.first(r107);
        Iterator r113 = r107.iterator();
    L30:
        if (r113.hasNext() == false) goto L34;
        String r114 = ((b) r113.next()).f232321d;
        if (r114 == null) goto L30;
    L35:
        long r115 = r112.f232318a;
        String r116 = r112.f232319b;
        BotAtHintActionType r117 = r112.f232320c;
        String r118 = r112.f232322e;
        Long r119 = r112.f232323f;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r116, "botName");
        Intrinsics.checkNotNullParameter(r117, ReportConstant.COMMON_ACTION_TYPE);
        b r120 = new b(r115, r116, r117, r114, r118, r119);
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r122 = r107.iterator();
    L37:
        if (r122.hasNext() == false) goto L39;
        r121.add(((b) r122.next()).f232319b);
        goto L37
    L39:
        List r123 = CollectionsKt.distinct(r121);
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r125 = r107.iterator();
    L41:
        if (r125.hasNext() == false) goto L43;
        r124.add(Long.valueOf(((b) r125.next()).f232318a));
        goto L41
    L43:
        r100.add(new j0(r120, r123, CollectionsKt.distinct(r124)));
        r104 = true;
        goto L22
    L34:
        r114 = null;
        goto L35
    L45:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public a() {
        this.f232313a = new ArrayList();
        this.f232314b = new LinkedHashSet();
    }

    public final void A2() {
        List<j0> r100 = y2();
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((j0) r102.next()).c());
        goto L4
    L6:
        this.f232314b.retainAll(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return y2().size();
    }

    public final int z2() {
        return y2().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
        final d r100 = (d) r210;
        Intrinsics.checkNotNullParameter(r100, "holder");
        j0 r101 = (j0) ListProtector.get(y2(), r211);
        String r102 = r101.c();
        if (this.f232314b.add(r102) == false) goto L8;
        tt5.a.h("BotAtHintView", "[BOT_GUIDE_APP_ID_TRACE] report exposure, key=" + r102 + ", appId=" + r101.a() + ", itemType=" + r101.b() + ", botIds=" + r101.f232340c + ", botNames=" + r101.f232339b);
        com.bytedance.ee.bear.middleground.comment.uitls.h r103 = this.f232316d;
        if (r103 == null) goto L8;
        String r104 = r101.b();
        String r105 = r101.a();
        Map<String, Object> r106 = r103.b();
        HashMap r107 = (HashMap) r106;
        r107.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r104);
        r107.put("app_id", r105);
        tt5.a.h("Comment#CommentAnalytic", "[BOT_GUIDE_APP_ID_TRACE] track item view, itemType = " + r104 + ", appId = " + r105);
        StringBuilder r108 = new StringBuilder("reportBotGuideItemView params = ");
        r108.append(r106);
        tt5.a.b("Comment#CommentAnalytic", r108.toString());
        r103.f232209g.a("ccm_comment_item_view", r106);
    L8:
        Function1<? super b, Unit> r109 = this.f232315c;
        com.bytedance.ee.bear.middleground.comment.uitls.h r110 = this.f232316d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Context r111 = r100.itemView.getContext();
        int r112 = d.a.f232328a[r101.f232338a.f232320c.ordinal()];
        if (r112 == 1) goto L14;
        if (r112 != 2) goto L13;
        int r113 = R.string.LarkCCM_Docs_AgentReplyComment_LearnMore_Button;
    L15:
        String r114 = r111.getString(r113);
        String r115 = xo5.a.d(r100.itemView.getContext(), R.string.LarkCCM_Docs_AgentReplyComment_AppConfigsMissing_Text, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("botNames", CollectionsKt.joinToString$default(r101.f232339b, r100.itemView.getContext().getString(R.string.LarkCCM_Docs_AgentReplyComment_Separator_Text), null, null, 0, null, new BotAtHintViewHolder$bind$botNames$1(r100), 30, null)), TuplesKt.to("redirectLink", r114)}));
        SpannableStringBuilder r116 = new SpannableStringBuilder(r115);
        Intrinsics.checkNotNull(r115);
        int r117 = StringsKt.lastIndexOf$default(r115, r114, 0, false, 6, null);
        if (r117 < 0) goto L18;
        r116.setSpan(new e(r101, r110, r109, r100), r117, r114.length() + r117, 33);
    L18:
        r100.f232327a.setHighlightColor(0);
        r100.f232327a.setLineSpacing(com.bytedance.ee.util.ui.n.d(4), 1.0f);
        r100.f232327a.setMovementMethod(LinkMovementMethod.getInstance());
        r100.f232327a.setText(r116);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r113 = R.string.LarkCCM_Docs_AgentReplyComment_ConfigureNow_Button;
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.comment_bot_at_hint_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new d(r102);
    }
}
