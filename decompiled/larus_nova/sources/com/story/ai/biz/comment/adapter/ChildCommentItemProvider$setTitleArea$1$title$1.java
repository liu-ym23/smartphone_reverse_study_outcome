package com.story.ai.biz.comment.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.model.comment.CommentInfo;
import com.larus.platform.model.comment.UserInfo;
import com.story.ai.biz.comment.model.ChildCommentItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/text/SpannableStringBuilder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.story.ai.biz.comment.adapter.ChildCommentItemProvider$setTitleArea$1$title$1", f = "ChildCommentItemProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChildCommentItemProvider$setTitleArea$1$title$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SpannableStringBuilder>, Object> {
    final /* synthetic */ ChildCommentItem $item;
    final /* synthetic */ List<jnc.b.a> $tagListUserA;
    final /* synthetic */ List<jnc.b.a> $tagListUserB;
    final /* synthetic */ TextView $titleView;
    int label;
    final /* synthetic */ ChildCommentItemProvider this$0;

    public ChildCommentItemProvider$setTitleArea$1$title$1(ChildCommentItem r100, TextView r101, List<jnc.b.a> r102, List<jnc.b.a> r103, ChildCommentItemProvider r104, Continuation<? super ChildCommentItemProvider$setTitleArea$1$title$1> r105) {
        this.$item = r100;
        this.$titleView = r101;
        this.$tagListUserA = r102;
        this.$tagListUserB = r103;
        this.this$0 = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChildCommentItemProvider$setTitleArea$1$title$1(this.$item, this.$titleView, this.$tagListUserA, this.$tagListUserB, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super SpannableStringBuilder> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super SpannableStringBuilder> r101) {
        return ((ChildCommentItemProvider$setTitleArea$1$title$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r310) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L138;
        ResultKt.throwOnFailure(r310);
        CommentInfo r100 = this.$item.getCommentData();
        if (r100 == null) goto L135;
        UserInfo r101 = r100.h();
        if (r101 == null) goto L135;
        ChildCommentItem r102 = this.$item;
        TextView r103 = this.$titleView;
        List<jnc.b.a> r104 = this.$tagListUserA;
        List<jnc.b.a> r105 = this.$tagListUserB;
        final ChildCommentItemProvider r106 = this.this$0;
        if (r102.isReplyParentComment() == true) goto L159;
        int r107 = jnc.b.f499798a;
        UserInfo r108 = r102.getReplyCommentUserInfo();
        rq9.d r109 = r106.f459775a.getInitData$impl_mainlandRelease();
        if (r109 != null) goto L14;
    L16:
        boolean r110 = false;
    L17:
        Function2 r111 = new g(r106);
        Intrinsics.checkNotNullParameter(r103, "textView");
        String r112 = "userInfoA";
        Intrinsics.checkNotNullParameter(r101, "userInfoA");
        Intrinsics.checkNotNullParameter(r104, "drawablesA");
        Intrinsics.checkNotNullParameter(r105, "drawablesB");
        Intrinsics.checkNotNullParameter(r111, SendEventContainerMethodParamModel.EventKinds.onClick);
        jnc.b.a(r103.getContext());
        ArrayList r113 = new ArrayList();
        ArrayList r114 = new ArrayList();
        SpannableStringBuilder r115 = new SpannableStringBuilder();
        if (r108 == null) goto L160;
        Iterator r116 = r104.iterator();     // Catch: Exception -> L127
        long r117 = 0;
        int r118 = 0;
    L22:
        if (r116.hasNext() == false) goto L29;
        Object r119 = r116.next();     // Catch: Exception -> L127
        int r120 = r118 + 1;     // Catch: Exception -> L127
        if (r118 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L127
    L26:
        jnc.b.a r121 = (jnc.b.a) r119;     // Catch: Exception -> L127
        Iterator r210 = r116;
        String r211 = r112;
        jnc.h r122 = new jnc.h(r121.f499800a, r121.f499801b, r121.f499802c, r121.f499803d, r121.f499804e, r121.f499805f);     // Catch: Exception -> L125
        r117 = r117 + ((long) r122.getSize(r103.getPaint(), "", 0, 0, r103.getPaint().getFontMetricsInt()));     // Catch: Exception -> L125
        r113.add(r122);     // Catch: Exception -> L125
        r118 = r120;
        r116 = r210;
        r112 = r211;
        r111 = r111;
    L125:
        e = e;
    L129:
        com.larus.platform.service.g r123 = com.larus.platform.service.g.f365738a;
        LinkedHashMap r124 = new LinkedHashMap();
        r124.put(r211, String.valueOf(r101.b()));
        if (r108 == null) goto L132;
        String r125 = r108.b();
    L133:
        r124.put("userInfoB", String.valueOf(r125));
        Unit r126 = Unit.INSTANCE;
        r123.ensureNotReachHere(e, "generateTitleTagSpan error", r124);
        r115.append(r101.b());
    L161:
        return r115;
    L132:
        r125 = null;
        goto L133
    L29:
        r211 = r112;
        g r212 = r111;
        Iterator r127 = r105.iterator();     // Catch: Exception -> L125
        long r128 = r117;
        int r129 = 0;
    L31:
        if (r127.hasNext() == false) goto L36;
        Object r130 = r127.next();     // Catch: Exception -> L125
        int r131 = r129 + 1;     // Catch: Exception -> L125
        if (r129 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L125
    L35:
        jnc.b.a r132 = (jnc.b.a) r130;     // Catch: Exception -> L125
        jnc.h r133 = new jnc.h(r132.f499800a, r132.f499801b, r132.f499802c, r132.f499803d, r132.f499804e, r132.f499805f);     // Catch: Exception -> L125
        r128 = r128 + ((long) r133.getSize(r103.getPaint(), "", 0, 0, r103.getPaint().getFontMetricsInt()));     // Catch: Exception -> L125
        r114.add(r133);     // Catch: Exception -> L125
        r127 = r127;
        r129 = r131;
        goto L31
    L36:
        Context r134 = AppHost.f326268a.getApplication().getApplicationContext();     // Catch: Exception -> L125
        if (r110 == false) goto L39;
        int r135 = R.drawable.larus_comment_icon_reply_dark;
    L40:
        com.story.ai.base.utils.a r136 = new com.story.ai.base.utils.a(r134, r135);     // Catch: Exception -> L125
        float r137 = r103.getPaint().measureText(r101.b());     // Catch: Exception -> L125
        float r138 = r103.getPaint().measureText(r108.b());     // Catch: Exception -> L125
        float r139 = r128;
        float r140 = (r137 + r139) + r136.getDrawable().getIntrinsicWidth();     // Catch: Exception -> L125
        r136.getDrawable().getIntrinsicWidth();     // Catch: Exception -> L125
        float r141 = ((r137 + r138) + r139) + r136.getDrawable().getIntrinsicWidth();     // Catch: Exception -> L125
        float r142 = jnc.b.f499799b;     // Catch: Exception -> L125
        if (r140 < r142) goto L72;
        String r143 = r101.b();     // Catch: Exception -> L125
        if (r143 == null) goto L46;
        int r144 = r143.length();     // Catch: Exception -> L125
    L47:
        String r145 = r108.b();     // Catch: Exception -> L125
        if (r145 == null) goto L50;
        int r146 = r145.length();     // Catch: Exception -> L125
    L52:
        if (r146 > 2) goto L54;
        r146 = 2;
    L54:
        if (r144 > 2) goto L56;
        r144 = 2;
    L56:
        if (r144 != 2) goto L59;
        if (r146 != 2) goto L59;
        ArrayList r147 = r113;
    L61:
        StringBuilder r148 = new StringBuilder();     // Catch: Exception -> L125
        String r149 = r101.b();     // Catch: Exception -> L125
        if (r149 == null) goto L64;
        CharSequence r150 = r149.subSequence(0, r144);     // Catch: Exception -> L125
    L65:
        r148.append(r150);     // Catch: Exception -> L125
        r148.append("...");     // Catch: Exception -> L125
        String r151 = r148.toString();     // Catch: Exception -> L125
        StringBuilder r152 = new StringBuilder();     // Catch: Exception -> L125
        String r153 = r108.b();     // Catch: Exception -> L125
        if (r153 == null) goto L68;
        CharSequence r154 = r153.subSequence(0, r146);     // Catch: Exception -> L125
    L69:
        r152.append(r154);     // Catch: Exception -> L125
        r152.append("...");     // Catch: Exception -> L125
        Pair r155 = TuplesKt.to(r151, r152.toString());     // Catch: Exception -> L125
    L100:
        r115.append((CharSequence) r155.getFirst());     // Catch: Exception -> L125
        Iterator r156 = r147.iterator();     // Catch: Exception -> L125
        int r157 = 0;
    L103:
        if (r156.hasNext() == false) goto L112;
        Object r158 = r156.next();     // Catch: Exception -> L125
        int r159 = r157 + 1;     // Catch: Exception -> L125
        if (r157 >= 0) goto L107;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L125
    L107:
        jnc.h r160 = (jnc.h) r158;     // Catch: Exception -> L125
        if (r157 != 0) goto L110;
        r115.append(".");     // Catch: Exception -> L125
    L111:
        r115.setSpan(r160, r115.length() - 1, r115.length(), 17);     // Catch: Exception -> L125
        r157 = r159;
        goto L103
    L110:
        r115.append(".");     // Catch: Exception -> L125
        goto L111
    L112:
        r115.append(".");     // Catch: Exception -> L125
        r115.setSpan(r136, r115.length() - 1, r115.length(), 17);     // Catch: Exception -> L125
        r115.append((CharSequence) r155.getSecond());     // Catch: Exception -> L125
        Iterator r161 = r114.iterator();     // Catch: Exception -> L125
        int r162 = 0;
    L114:
        if (r161.hasNext() == false) goto L123;
        Object r163 = r161.next();     // Catch: Exception -> L125
        int r164 = r162 + 1;     // Catch: Exception -> L125
        if (r162 >= 0) goto L118;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L125
    L118:
        jnc.h r165 = (jnc.h) r163;     // Catch: Exception -> L125
        if (r162 != 0) goto L121;
        r115.append(".");     // Catch: Exception -> L125
    L122:
        r115.setSpan(r165, r115.length() - 1, r115.length(), 17);     // Catch: Exception -> L125
        r162 = r164;
        goto L114
    L121:
        r115.append(".");     // Catch: Exception -> L125
        goto L122
    L123:
        r115.setSpan(new jnc.c(r212, r101), 0, ((String) r155.getFirst()).length(), 17);     // Catch: Exception -> L125
        r115.setSpan(new jnc.d(r212, r108), (r115.length() - ((String) r155.getSecond()).length()) + 1, r115.length(), 17);     // Catch: Exception -> L125
        goto L161
    L68:
        r154 = null;
        goto L69
    L64:
        r150 = null;
    L59:
        r144 = r144 - 1;     // Catch: Exception -> L125
        r146 = r146 - 1;     // Catch: Exception -> L125
        r147 = r113;
        long r166 = r128;
        if (((r103.getPaint().measureText(r101.b(), 0, r144) + r103.getPaint().measureText(r108.b(), 0, r146)) + (2 * r103.getPaint().measureText("..."))) < ((((long) jnc.b.f499799b) - r128) - ((long) r136.getDrawable().getIntrinsicWidth()))) goto L61;
        r113 = r147;
        r128 = r166;
        goto L52
    L50:
        r146 = 0;
        goto L52
    L46:
        r144 = 0;
        goto L47
    L72:
        r147 = r113;
        String r167 = "";
        if (r141 <= r142) goto L92;
        String r168 = r108.b();     // Catch: Exception -> L125
        if (r168 == null) goto L77;
        int r169 = r168.length();     // Catch: Exception -> L125
    L79:
        if (r169 <= 1) goto L83;
        r169 = r169 - 1;     // Catch: Exception -> L125
        if ((r103.getPaint().measureText(r108.b(), 0, r169) + r103.getPaint().measureText("...")) >= (jnc.b.f499799b - r140)) goto L79;
    L83:
        String r170 = r101.b();     // Catch: Exception -> L125
        if (r170 == null) goto L87;
        r167 = r170;
    L87:
        StringBuilder r171 = new StringBuilder();     // Catch: Exception -> L125
        String r172 = r108.b();     // Catch: Exception -> L125
        if (r172 == null) goto L90;
        CharSequence r173 = r172.subSequence(0, r169);     // Catch: Exception -> L125
    L91:
        r171.append(r173);     // Catch: Exception -> L125
        r171.append("...");     // Catch: Exception -> L125
        r155 = TuplesKt.to(r167, r171.toString());     // Catch: Exception -> L125
        goto L100
    L90:
        r173 = null;
        goto L91
    L77:
        r169 = 0;
        goto L79
    L92:
        String r174 = r101.b();     // Catch: Exception -> L125
        if (r174 != null) goto L95;
        r174 = "";
    L95:
        String r175 = r108.b();     // Catch: Exception -> L125
        if (r175 == null) goto L99;
        r167 = r175;
    L99:
        r155 = TuplesKt.to(r174, r167);     // Catch: Exception -> L125
        goto L100
    L39:
        r135 = R.drawable.larus_comment_icon_reply_auto;
        goto L40
    L160:
        return r115.append(r101.b());
    L127:
        e = e;
        r211 = "userInfoA";
        goto L129
    L14:
        if (r109.h() != true) goto L16;
        r110 = true;
        goto L17
    L159:
        return jnc.b.d(r103, r101, r104, false, new f(r106));
    L135:
        return null;
    L138:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
