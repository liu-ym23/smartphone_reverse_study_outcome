package com.story.ai.biz.comment.viewmodel.subvm;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ixigua.lib.track.TrackParams;
import com.larus.network.http.y;
import com.larus.platform.model.comment.CommentContent;
import com.larus.platform.model.comment.api.CommentHttpApi$PostCommentResponse;
import com.story.ai.biz.comment.model.BaseComment;
import com.story.ai.biz.comment.model.CommentPublishState;
import com.story.ai.biz.comment.viewmodel.CommentViewModel;
import com.story.ai.biz.comment.viewmodel.w;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class PublishActionSubVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f460049a;

    public PublishActionSubVM(w r100) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        this.f460049a = r100;
    }

    public final void a(String r100, BaseComment r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.f460049a.baseViewModel()), null, null, new PublishActionSubVM$publishComment$1(r100, r101, this, null), 3, null);
    }

    public final void c(BaseComment r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "commentData");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.f460049a.baseViewModel()), null, null, new PublishActionSubVM$retryComment$1(r100, this, r101, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(inc.b r110, boolean r210, int r211, Continuation<? super Unit> r212) {
        if ((r212 instanceof PublishActionSubVM$realSendComment$1) == false) goto L7;
        PublishActionSubVM$realSendComment$1 r100 = (PublishActionSubVM$realSendComment$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PublishActionSubVM$realSendComment$1 r111 = r100;
        Object r102 = r111.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r111.label;
        String r113 = null;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        int r104 = r111.I$0;
        boolean r105 = r111.Z$0;
        Long r106 = (Long) r111.L$1;
        inc.b r107 = (inc.b) r111.L$0;
        ResultKt.throwOnFailure(r102);
    L70:
        int r108 = r104;
        Long r109 = r106;
        inc.b r114 = r107;
        boolean r115 = r105;
    L71:
        CommentViewModel r116 = this.f460049a.baseViewModel();
        if (r109 == null) goto L74;
        int r117 = (int) r109.longValue();
    L75:
        r116.updatePublishData(r114, r115, r108, r117);
        Set<String> r118 = jnc.a.f499793a;
        Intrinsics.checkNotNullParameter(r114, "publishData");
        rq9.f r119 = jnc.a.f499796d;
        if (r119 == null) goto L100;
        Pair<String, JSONObject> r120 = r119.e();
        if (r120 == null) goto L100;
        by7.a r121 = jnc.a.b(r120);
        TrackParams r122 = new TrackParams();
        String r123 = r114.f490636d;
        if (r123 != null) goto L82;
    L85:
        boolean r124 = true;
    L86:
        if (r124 == false) goto L88;
        String r125 = UGCMonitor.TYPE_POST;
    L98:
        r121.f21463a.merge(r122.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TYPE, r125).put("comment_id", r114.f490641i));
        r121.b();
        goto L100
    L88:
        String r126 = r114.f490635c;
        if (r126 != null) goto L91;
    L94:
        boolean r127 = true;
    L95:
        if (r127 == false) goto L97;
        r125 = "reply";
        goto L98
    L97:
        r125 = "reply_second";
        goto L98
    L91:
        if (r126.length() == 0) goto L94;
        r127 = false;
        goto L95
    L82:
        if (r123.length() == 0) goto L85;
        r124 = false;
    L100:
        return Unit.INSTANCE;
    L74:
        r117 = -1;
        goto L75
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r128 = r111.I$0;
        boolean r129 = r111.Z$0;
        r114 = (inc.b) r111.L$0;
        ResultKt.throwOnFailure(r102);
        Object r130 = r102;
        r108 = r128;
        r115 = r129;
        Object r131 = r112;
        int r132 = 2;
    L32:
        com.larus.network.http.a r133 = (com.larus.network.http.a) r130;
    L35:
        if ((r133 instanceof y) == false) goto L56;
        y r134 = (y) r133;
        Long r135 = r134.f360205g;
        if (r135 != null) goto L40;
    L45:
        CommentPublishState r136 = CommentPublishState.FAIL;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r136, "<set-?>");
        r114.f490638f = r136;
        Long r137 = r134.f360205g;
        if (r137 == null) goto L48;
        long r138 = r137.longValue();
    L50:
        if (r138 > 0) goto L52;
    L54:
        r109 = r134.f360205g;
    L65:
        if (r114.f490638f != CommentPublishState.FAIL) goto L71;
        r111.L$0 = r114;
        r111.L$1 = r109;
        r111.Z$0 = r115;
        r111.I$0 = r108;
        r111.label = r132;
        if (DelayKt.delay(200, r111) != r131) goto L69;
        return r131;
    L69:
        r105 = r115;
        r104 = r108;
        r107 = r114;
        r106 = r109;
        goto L70
    L52:
        if (TextUtils.isEmpty(r134.f360204f) == true) goto L54;
        this.f460049a.showToast(r134.f360204f);
        goto L54
    L48:
        r138 = 0;
        goto L50
    L40:
        if (r135.longValue() != 0) goto L45;
        CommentPublishState r139 = CommentPublishState.SUCCESS;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r139, "<set-?>");
        r114.f490638f = r139;
        CommentHttpApi$PostCommentResponse r140 = (CommentHttpApi$PostCommentResponse) r134.f360135b;
        if (r140 == null) goto L44;
        r113 = r140.a();
    L44:
        r114.f490641i = r113;
        r109 = r134.f360205g;
        goto L65
    L56:
        if ((r133 instanceof com.larus.network.http.f) == false) goto L63;
        CommentPublishState r141 = CommentPublishState.FAIL;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r141, "<set-?>");
        r114.f490638f = r141;
        com.larus.network.http.f r142 = (com.larus.network.http.f) r133;
        if (r142.f360157d.getCode() > 0) goto L60;
    L62:
        r109 = Boxing.boxLong(r142.f360157d.getCode());
        goto L65
    L60:
        if (TextUtils.isEmpty(r142.f360157d.getMessage()) == true) goto L62;
        this.f460049a.showToast(r142.f360157d.getMessage());
        goto L62
    L63:
        r109 = Boxing.boxLong(-1);
        goto L65
    L16:
        ResultKt.throwOnFailure(r102);
        CommentViewModel.updatePublishData$default(this.f460049a.baseViewModel(), r110, r210, r211, 0, 8, null);
        rq9.h r143 = this.f460049a.dataMediator();
        if (r143 == null) goto L33;
        String r144 = r110.f490633a;
        CommentContent r145 = r110.f490637e;
        if (r145 != null) goto L21;
        r145 = new CommentContent(0);
    L21:
        String r146 = r110.f490636d;
        String r147 = "";
        if (r146 != null) goto L24;
        r146 = "";
    L24:
        String r148 = r110.f490635c;
        if (r148 == null) goto L28;
        r147 = r148;
    L28:
        r111.L$0 = r110;
        r111.Z$0 = r210;
        r111.I$0 = r211;
        r111.label = 1;
        String r149 = r146;
        r132 = 2;
        String r150 = r147;
        r131 = r112;
        Object r151 = r143.a(r144, r145, r149, r150, r111);
        if (r151 != r131) goto L31;
        return r131;
    L31:
        r115 = r210;
        r114 = r110;
        r130 = r151;
        r108 = r211;
        goto L32
    L33:
        r131 = r112;
        r132 = 2;
        r108 = r211;
        r115 = r210;
        r114 = r110;
        r133 = null;
    L7:
        r100 = new PublishActionSubVM$realSendComment$1(this, r212);
        goto L8
    }
}
