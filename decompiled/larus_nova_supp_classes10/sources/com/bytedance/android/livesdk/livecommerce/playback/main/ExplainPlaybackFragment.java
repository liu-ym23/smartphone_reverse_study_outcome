package com.bytedance.android.livesdk.livecommerce.playback.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.ec.model.playback.SearchExplainReplayParams;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.j;
import com.bytedance.android.livesdk.livecommerce.playback.video.ExplainPlaybackVideoViewModel;
import com.bytedance.ies.uikit.base.AbsFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackFragment;", "Lcom/bytedance/ies/uikit/base/AbsFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackFragment extends AbsFragment implements QViewModelOwner {
    public static String i;
    public static final a j = null;
    public final QUIManager d;
    public ExplainPlaybackViewModel e;
    public ExplainPlaybackVideoViewModel f;
    public e g;
    public final ExplainPlaybackFragment$factory$1 h;

    public static final class a {
        public a() {
        }
    }

    static {
        j = new a();
        i = "";
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(ExplainPlaybackFragment.class, "a1.b3390");
    }

    public final void onDestroy() {
        this.d.r(g.class);
        ExplainPlaybackViewModel r0 = this.e;
        if (r0 == null) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(r0, new com.bytedance.android.livesdk.livecommerce.playback.main.a.o(false));
    L6:
        if (cj2.b.e == false) goto L8;
    L17:
        super.onDestroy();
        return;
    L8:
        if (cj2.b.f == true) goto L13;
        com.bytedance.android.ec.monitor.duration.d r1 = i.a.get(cj2.b.a);
        if (r1 == null) goto L12;
        r1.a("render_start");
    L12:
        cj2.b.f = true;
    L13:
        cj2.b.c();
        com.bytedance.android.ec.monitor.duration.d r2 = i.a.get(cj2.b.a);
        if (r2 == null) goto L16;
        r2.b("not_complete_load_reason", "destroy_view");
    L16:
        cj2.b.e(false);
        goto L17
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackFragment$factory$1] */
    public ExplainPlaybackFragment() {
        this.d = new QUIManager();
        this.h = new ExplainPlaybackFragment$factory$1(this);
    }

    public final void onResume() {
        super.onResume();
        ExplainPlaybackViewModel r0 = this.e;
        if (r0 == null) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(r0, new com.bytedance.android.livesdk.livecommerce.playback.main.a.o(true));
    L6:
        if (this.g == null) goto L8;
        return;
    L8:
        ExplainPlaybackVideoViewModel r1 = this.f;
        if (r1 == null) goto L12;
        com.bytedance.android.ec.core.arch.event.c.d(r1, com.bytedance.android.livesdk.livecommerce.playback.video.a.c.a);
        return;
    }

    public final ViewModelProvider.Factory o6() {
        return this.h;
    }

    public final void onPause() {
        super.onPause();
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Lazy r8 = BtmSDKWrapper.a;
        Bundle r9 = getArguments();
        String r1 = null;
        if (r9 == null) goto L7;
        String r10 = r9.getString("key_explain_play_back_schema");
        if (r10 == null) goto L7;
        String r11 = UriProtector.getQueryParameter(UriProtector.parse(r10), "source_btm_token");
    L8:
        BtmSDKWrapper.b(this, "a1.b3390", r11);
        Bundle r12 = getArguments();
        if (r12 == null) goto L11;
        Serializable r13 = r12.getSerializable("playback_data_string");
    L13:
        if ((r13 instanceof SearchExplainReplayParams) == true) goto L15;
        r13 = null;
    L15:
        SearchExplainReplayParams r14 = (SearchExplainReplayParams) r13;
        boolean r2 = false;
        if (r14 == null) goto L41;
        String r0 = r14.getCommentaryInfo();
        if (r0 != null) goto L20;
    L53:
        String r15 = null;
    L54:
        if (r1 != null) goto L56;
    L59:
        boolean r3 = true;
    L60:
        if (r3 == true) goto L66;
        if (r15 != null) goto L63;
    L64:
        r2 = true;
    L65:
        if (r2 == true) goto L66;
    L67:
        jc.b r4 = com.bytedance.android.bcm.api.b.a;
        PageFinder r5 = PageFinder.via(this);
        BcmParams r6 = new BcmParams();
        r6.put("room_id", r1);
        r6.put("author_id", r15);
        Unit r16 = Unit.INSTANCE;
        com.bytedance.android.bcm.api.b.d(r5, r6, true);
        i r17 = i.a;
        com.bytedance.android.ec.monitor.duration.d r18 = r17.get(i);
        if (r18 == null) goto L70;
        r18.a("initial");
    L70:
        this.e = new ViewModelProvider(this, this.h).get(ExplainPlaybackViewModel.class);
        this.f = new ViewModelProvider(this, this.h).get(ExplainPlaybackVideoViewModel.class);
        com.bytedance.android.ec.monitor.duration.d r19 = r17.get(i);
        if (r19 == null) goto L73;
        r19.a("render_start");
    L73:
        ExplainPlaybackViewModel r20 = this.e;
        if (r20 != null) goto L76;
        return;
    L76:
        if (r20.isFromSearch() != true) goto L82;
        this.g = new e(this.e, this.f);
        return;
    L82:
        return;
    L63:
        if (r15.length() != 0) goto L65;
    L66:
        String r21 = "分佣参数 room_id: " + r1 + "，author_id: " + r15 + " 不能为空";
        j.b("ExplainPlaybackFragment", r21);
        ECExceptionMonitor.e(new RuntimeException(r21));
        goto L67
    L56:
        if (r1.length() == 0) goto L59;
        r3 = false;
        goto L60
    L20:
        if (r0.length() <= 0) goto L22;
        boolean r22 = true;
    L23:
        if (r22 == true) goto L26;
        r0 = null;
    L26:
        if (r0 == null) goto L53;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L29
        Object r24 = Result.constructor-impl((ol.a) new Gson().fromJson(r0, ol.a.class));     // Catch: Throwable -> L29
    L31:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L35;
        ECExceptionMonitor.e(r25);
    L35:
        if (Result.isFailure-impl(r24) == false) goto L37;
        r24 = null;
    L37:
        ol.a r26 = (ol.a) r24;
        if (r26 == null) goto L40;
        r1 = r26.m();
    L40:
        r15 = r14.getUid();
    L29:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L22:
        r22 = false;
        goto L23
    L41:
        Bundle r28 = getArguments();
        if (r28 == null) goto L53;
        String r29 = r28.getString("key_explain_play_back_schema");
        if (r29 == null) goto L53;
        int r30 = b.k;
        b r31 = b.a.a(r29);
        ExplainPlaybackRequest r32 = r31.a;
        if (r32 == null) goto L48;
        String r33 = r32.getRoomId();
    L49:
        ExplainPlaybackRequest r34 = r31.a;
        if (r34 == null) goto L52;
        r1 = r34.getAuthorId();
    L52:
        r15 = r1;
        r1 = r33;
        goto L54
    L48:
        r33 = null;
        goto L49
    L11:
        r13 = null;
    L7:
        r11 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        this.d.a = this;
        ExplainPlaybackViewModel r6 = this.e;
        if (r6 == null) goto L9;
        b r7 = r6.getExplainPlaybackOriginParams();
        if (r7 == null) goto L9;
        LogExtraData r8 = r7.d;
        if (r8 == null) goto L9;
        String r9 = r8.getEnterScene();
    L10:
        this.d.l(new g(this, r9), r3.getContext(), true);
        if (this.g != null) goto L14;
        this.d.c(g.class, null);
    L14:
        return this.d.p();
    L9:
        r9 = null;
        goto L10
    }
}
