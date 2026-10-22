package com.ss.android.lark.vote.message.detail;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.vote.v1.GetVotedIndexInfoRequest;
import com.bytedance.lark.pb.vote.v1.Paginate;
import com.bytedance.lark.pb.vote.v1.PaginateIndex;
import com.bytedance.lark.pb.vote.v1.VoteScopeType;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.vote.message.content.VoteUser;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rbc.e;
import v19.f;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0014JC\u00101\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010$\u001a\u00020%2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002¢\u0006\u0002\u00106J\u001e\u00107\u001a\b\u0012\u0004\u0012\u00020\"082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020*H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006?"}, d2 = {"Lcom/ss/android/lark/vote/message/detail/VotePopupFacade;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "voterListRv", "Landroidx/recyclerview/widget/RecyclerView;", "getVoterListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setVoterListRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "voteTitleTv", "Landroid/widget/TextView;", "getVoteTitleTv", "()Landroid/widget/TextView;", "setVoteTitleTv", "(Landroid/widget/TextView;)V", "votedNumTv", "getVotedNumTv", "setVotedNumTv", "voteCloseIv", "Landroid/widget/ImageView;", "getVoteCloseIv", "()Landroid/widget/ImageView;", "setVoteCloseIv", "(Landroid/widget/ImageView;)V", "voteAdapter", "Lcom/ss/android/lark/vote/message/detail/VoterListAdapter;", "voteVersion", "", "Ljava/lang/Long;", "voteIndex", "voteId", "voteUserList", "", "Lcom/ss/android/lark/vote/message/content/VoteUser;", "startCursor", "chatId", "", "hasMore", "", "voteInitiator", "initVoterList", "", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "getVotedUserInfo", "index", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/vote/message/services/data/VotedIndexInfoResponse;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larksuite/framework/callback/IGetDataCallback;)V", "getVoterList", "", "entity", "Lcom/bytedance/lark/pb/basic/v1/Entity;", "paginatedVotedIndexInfo", "Lcom/bytedance/lark/pb/vote/v1/PaginatedVotedIndexInfo;", "updateData", "Companion", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VotePopupFacade extends BaseFragmentActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f445215m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f445216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f445217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f445218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f445219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VoterListAdapter f445220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f445221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f445222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<VoteUser> f445223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f445224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f445225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f445226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f445227l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VotePopupFacade f445228a;

        public b(VotePopupFacade r100) {
            this.f445228a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f445228a.finish();
        }
    }

    static {
    }

    public final void A1() {
        IGetDataCallback<sbc.a> r100 = new VotePopupFacade$updateData$callback$1(this);
        String r101 = this.f445225j;
        if (r101 == null) goto L6;
        Long r102 = this.f445221f;
        Long r103 = this.f445224i;
        Long r104 = this.f445222g;
        int r105 = e.f537022a;
        Intrinsics.checkNotNullParameter(r101, "scopeId");
        ArrayList r106 = new ArrayList();
        Paginate r107 = new Paginate.Builder().start_cursor(r103).size(10).build();
        r106.add(new PaginateIndex.Builder().index(r102).paginate(r107).build());
        GetVotedIndexInfoRequest.Builder r108 = new GetVotedIndexInfoRequest.Builder();
        r108.vote_id(r104);
        r108.indexes(r106);
        r108.scope_type = VoteScopeType.IM_CHAT;
        r108.scope_id = r101;
        SdkSender.asynSendRequestNonWrap(Command.GET_VOTED_INDEX_INFO, r108, r100, rbc.b.f537019a);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_UP_IN);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(ActivityAnimationManager.ANIM_SLIDE_BOTTOM_OUT);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VotePopupFacade.class.getName()));
    L5:
        super.onDestroy();
    }

    public final RecyclerView z1() {
        RecyclerView r100 = this.f445216a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("voterListRv");
        return null;
    }

    public VotePopupFacade() {
        this.f445223h = new ArrayList();
        this.f445224i = 0L;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(VotePopupFacade.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L59
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L59
    L8:
        super.onCreate(r100);
        setStatusBarColorResource(com.larus.nova.R.color.ud_N00);
        setContentView(com.larus.nova.R.layout.lark_vote_detail_people_list);
        TextView r101 = (TextView) findViewById(com.larus.nova.R.id.vote_facade_title);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f445217b = r101;
        TextView r102 = (TextView) findViewById(com.larus.nova.R.id.voted_num);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f445218c = r102;
        RecyclerView r103 = (RecyclerView) findViewById(com.larus.nova.R.id.vote_people_list);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f445216a = r103;
        ImageView r104 = (ImageView) findViewById(com.larus.nova.R.id.vote_facade_close);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f445219d = r104;
        VoterListAdapter r105 = null;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("voteCloseIv");
        r104 = null;
    L12:
        r104.setVisibility(0);
        ImageView r106 = this.f445219d;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("voteCloseIv");
        r106 = null;
    L16:
        r106.setOnClickListener(new b(this));
        Intent r107 = getIntent();
        if (r107 == null) goto L19;
        String r108 = r107.getStringExtra("vote.topic");
    L20:
        Intent r109 = getIntent();
        if (r109 == null) goto L23;
        Long r110 = Long.valueOf(r109.getLongExtra("vote.user.num", 0));
    L24:
        TextView r111 = this.f445217b;
        if (r111 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("voteTitleTv");
        r111 = null;
    L28:
        r111.setText(r108);
        TextView r112 = this.f445218c;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("votedNumTv");
        r112 = null;
    L32:
        r112.setText("(" + r110 + ')');
        Intent r113 = getIntent();
        if (r113 == null) goto L35;
        Long r114 = Long.valueOf(r113.getLongExtra("vote.index", 0));
    L36:
        this.f445221f = r114;
        Intent r115 = getIntent();
        if (r115 == null) goto L39;
        Long r116 = Long.valueOf(r115.getLongExtra("vote.id", 0));
    L40:
        this.f445222g = r116;
        Intent r117 = getIntent();
        if (r117 == null) goto L43;
        Long r118 = Long.valueOf(r117.getLongExtra("vote.initiator", 0));
    L44:
        this.f445227l = r118;
        Intent r119 = getIntent();
        if (r119 == null) goto L47;
        String r120 = r119.getStringExtra("chat.id");
    L48:
        this.f445225j = r120;
        if (z1().getAdapter() == null) goto L51;
        RecyclerView.Adapter r121 = z1().getAdapter();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type com.ss.android.lark.vote.message.detail.VoterListAdapter");
        this.f445220e = (VoterListAdapter) r121;
    L51:
        Context r122 = getApplicationContext();
        if (r122 == null) goto L57;
        Long r123 = this.f445227l;
        String r124 = this.f445225j;
        if (r124 != null) goto L56;
        r124 = "";
    L56:
        r105 = new VoterListAdapter(r122, r123, r124);
    L57:
        this.f445220e = r105;
        A1();
        z1().setAdapter(this.f445220e);
        z1().setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        z1().addOnScrollListener(new VotePopupFacade$initVoterList$2(this));
        return;
    L47:
        r120 = null;
        goto L48
    L43:
        r118 = null;
        goto L44
    L39:
        r116 = null;
        goto L40
    L35:
        r114 = null;
        goto L36
    L23:
        r110 = null;
        goto L24
    L19:
        r108 = null;
        goto L20
    }
}
