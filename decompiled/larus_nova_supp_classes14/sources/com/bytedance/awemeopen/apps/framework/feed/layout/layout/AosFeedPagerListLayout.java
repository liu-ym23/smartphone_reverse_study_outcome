package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.PhotoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.AccountUsageHintHelper;
import com.bytedance.awemeopen.apps.framework.utils.IconSettingUtils;
import com.bytedance.awemeopen.apps.framework.utils.c0;
import com.bytedance.awemeopen.apps.framework.utils.z;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.AosConfigService;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f8F@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosFeedPagerListLayout;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/utils/z;", "Lcom/bytedance/awemeopen/apps/framework/utils/audio/a;", "getAudioHelper", "Landroid/os/Bundle;", "bundle", "", "setArguments", "Lk54/c;", "listener", "setFeedPageListener", "Ljz3/b;", "feedContext", "setFeedListContext", "F", "Ljz3/b;", "getAosFeedListContext", "()Ljz3/b;", "setAosFeedListContext", "(Ljz3/b;)V", "aosFeedListContext", "<set-?>", "G", "Lk54/c;", "getFeedPageListener", "()Lk54/c;", "feedPageListener", "Lr14/c;", "H", "Lr14/c;", "getAweme", "()Lr14/c;", "setAweme", "(Lr14/c;)V", "aweme", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosFeedPagerListLayout<VM extends FeedPagerListViewModel> extends AosPagerListLayout<jz3.a, VM> implements z {
    public static final /* synthetic */ int O = 0;
    public boolean E;
    public jz3.b F;
    public k54.c G;
    public r14.c H;
    public jz3.a I;
    public final com.bytedance.awemeopen.apps.framework.utils.audio.a J;
    public boolean K;
    public boolean L;
    public boolean M;
    public final AosFeedPagerListLayout$enterPinchObserver$1 N;

    public abstract void a0(int r1, jz3.a r2);

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public int f() {
        return 2131558648;
    }

    public final k54.c getFeedPageListener() {
        if (this.G != null) goto L12;
        jz3.b r0 = this.F;
        if (r0 == null) goto L9;
        Function0<? extends k54.c> r1 = r0.b;
        if (r1 == null) goto L9;
        k54.c r2 = (k54.c) r1.invoke();
    L10:
        this.G = r2;
    L9:
        r2 = null;
    L12:
        return this.G;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    public final boolean W() {
        Object r0 = getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r0);
        List r1 = (List) ((ListState) r0).a;
        int r2 = getVm().getCurrentSelectedIndex();
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= r1.size()) goto L21;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r3 = getAdapter().k(ListProtector.get(r1, r2));
        if ((r3 instanceof VideoFeedViewHolder) == false) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L15;
        return false;
    L15:
        if (r3 != null) goto L17;
        return false;
    L17:
        if (r3.d() != true) goto L23;
        return true;
    L23:
        return false;
    L9:
        if ((r3 instanceof PhotoFeedViewHolder) == true) goto L12;
        r4 = false;
        goto L13
    L21:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    public final void Z() {
        Object r0 = getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r0);
        List r1 = (List) ((ListState) r0).a;
        int r2 = getVm().getCurrentSelectedIndex();
        if (r2 >= 0) goto L5;
        return;
    L5:
        if (r2 >= r1.size()) goto L19;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r3 = getAdapter().k(ListProtector.get(r1, r2));
        PhotoFeedViewHolder r4 = null;
        if ((r3 instanceof VideoFeedViewHolder) == false) goto L9;
        VideoFeedViewHolder r5 = (VideoFeedViewHolder) r3;
    L10:
        if (r5 == null) goto L13;
        r5.i.r();
    L13:
        if ((r3 instanceof PhotoFeedViewHolder) == false) goto L15;
        r4 = (PhotoFeedViewHolder) r3;
    L15:
        if (r4 == null) goto L20;
        r4.l.r();
        return;
    L20:
        return;
    L9:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void h() {
        super.h();
        boolean r0 = getVm().getPageConfig().getShowBackButton();
        View r1 = findViewById(2131372213);
        if (r0 == false) goto L5;
        x54.b.d(r1);
        r1.setOnClickListener(new a(this));
    L6:
        getVm().getFeedPlayerHelper().c(new b(this));
        getVm().getEnterPinchMode().observe(this, this.N);
        String[] r2 = c0.a;
        c0.b(getContext(), this);
        return;
    L5:
        x54.b.a(r1);
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void i() {
        super.i();
        String[] r0 = c0.a;
        c0.c(getContext(), this);
        getVm().getEnterPinchMode().removeObserver(this.N);
        this.M = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void j() {
        getVm().getFeedHomeContainerDeliverHiddenState().setValue(Boolean.valueOf(getDeliverHiddenChangedCache()));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void k() {
        Bundle r0 = getBundle();
        if (r0 == null) goto L5;
        FeedPageConfig r1 = (FeedPageConfig) r0.getParcelable("FEED_PAGE_CONFIG_CONFIG_KEY");
    L6:
        if (r1 != null) goto L8;
        r1 = new FeedPageConfig();
    L8:
        getVm().initPageConfig(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final jz3.b getAosFeedListContext() {
        return this.F;
    }

    public final com.bytedance.awemeopen.apps.framework.utils.audio.a getAudioHelper() {
        return this.J;
    }

    public final r14.c getAweme() {
        return this.H;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout$enterPinchObserver$1] */
    public AosFeedPagerListLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.E = true;
        this.J = new com.bytedance.awemeopen.apps.framework.utils.audio.a();
        this.N = new AosFeedPagerListLayout$enterPinchObserver$1(this);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public void M(boolean r2) {
        if (r2 == false) goto L13;
        k54.c r3 = getFeedPageListener();
        if (r3 == null) goto L14;
        ListState r0 = (ListState) getVm().getDataList().getValue();
        if (r0 == null) goto L8;
        String r1 = r0.i;
    L9:
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        r3.onLoadError(r1);
        return;
    L8:
        r1 = null;
        goto L9
    L14:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.z
    public final void M00(String r3) {
        Intrinsics.checkNotNullParameter(r3, "filePath");
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L6;
        AosEventReporter r4 = AosEventReporter.a;
        VM r0 = getVm();
        r14.c r1 = this.H;
        r4.getClass();
        AosEventReporter.P(r0, r1);
        return;
    }

    public final void setAosFeedListContext(jz3.b r1) {
        this.F = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void setArguments(Bundle r1) {
        super.setArguments(r1);
        setBundle(r1);
    }

    public final void setAweme(r14.c r1) {
        this.H = r1;
    }

    public final void setFeedListContext(jz3.b r2) {
        Intrinsics.checkNotNullParameter(r2, "feedContext");
        this.F = r2;
    }

    public final void setFeedPageListener(k54.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.G = r2;
    }

    public void V(int r19, jz3.a r20) {
        Intrinsics.checkNotNullParameter(r20, "model");
        ListState r3 = (ListState) getVm().getDataList().getValue();
        Drawable r4 = null;
        if (r3 == null) goto L7;
        List r5 = (List) r3.a;
        if (r5 == null) goto L7;
        jz3.a r6 = (jz3.a) CollectionsKt.getOrNull(r5, r19);
    L8:
        if (r6 == null) goto L10;
        r14.c r7 = r6.a;
    L11:
        r14.c r8 = this.H;
        if (r8 == null) goto L14;
        Long r9 = Long.valueOf(r8.c);
    L15:
        if (r7 == null) goto L17;
        Long r10 = Long.valueOf(r7.c);
    L19:
        if (Intrinsics.areEqual(r9, r10) == true) goto L21;
        a0(r19, r20);
    L21:
        jz3.a r11 = this.I;
        boolean r12 = true;
        if (r11 != null) goto L24;
    L26:
        boolean r13 = false;
    L27:
        if (r13 == false) goto L31;
        if (r11 == null) goto L31;
        r11.g = false;
    L31:
        this.I = r20;
        this.H = r7;
        RelativeLayout r2 = (RelativeLayout) findViewById(2131384535);
        if (r2 == null) goto L89;
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        Integer r15 = Integer.valueOf(r19);
        if (r15.intValue() < 0) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == true) goto L41;
        r15 = null;
    L41:
        if (r6 == null) goto L43;
        AosConfigService.b r17 = new AosConfigService.b(u(r19, r6), r15);
    L44:
        AosExtConfig r18 = AosExtConfig.b;
        Context r110 = getContext();
        r14.c r21 = this.H;
        if (r21 == null) goto L47;
        String r111 = r21.u();
    L48:
        View r22 = r18.L1(r110, r111, getVm().getContentScene(), new c(this, r6, r14), r17);
        r2.removeAllViews();
        if (r22 == null) goto L89;
        r2.addView(r22);
        List r23 = (List) r14.element;
        if (r23 == null) goto L89;
        Iterator r24 = r23.iterator();
    L55:
        if (r24.hasNext() == false) goto L89;
        String r25 = (String) r24.next();
        AosEventReporter r26 = AosEventReporter.a;
        VM r27 = getVm();
        r26.getClass();
        Intrinsics.checkNotNullParameter(r25, "function_name");
        String r28 = "";
        if (r27 == null) goto L60;
        String r112 = r27.sceneId();
        if (r112 == null) goto L60;
    L61:
        if (r6 == null) goto L55;
        r14.c r113 = r6.a;
        if (r113 == null) goto L55;
        d14.a r114 = b14.a.a;
        t24.a r115 = b14.a.a(t24.a.class);
        User r116 = r113.f();
        if (r116 == null) goto L68;
        String r117 = r116.u();
        if (r117 == null) goto L68;
    L69:
        String r118 = r113.c();
        a0 r119 = r113.d;
        if (r119 == null) goto L75;
        String r120 = r119.a();
        if (r120 == null) goto L75;
        String r121 = r120;
    L76:
        String r122 = AosEventReporter.c(r6.a);
        if (r6.a.W() == false) goto L79;
        String r123 = "origin";
    L80:
        String r124 = r123;
        if (r27 == null) goto L88;
        FeedPageConfig r29 = r27.getPageConfig();
        if (r29 == null) goto L88;
        String r30 = r29.getPreviousPage();
        if (r30 == null) goto L88;
        r28 = r30;
    L88:
        r115.K1(r112, r117, r118, r121, r122, r124, r28, r25);
        goto L55
    L79:
        r123 = "sdk";
    L75:
        r121 = "";
    L68:
        r117 = "";
    L60:
        r112 = "";
        goto L61
    L47:
        r111 = null;
        goto L48
    L43:
        r17 = null;
        goto L44
    L37:
        r16 = false;
    L89:
        ImageView r31 = (ImageView) findViewById(2131363758);
        if (r31 != null) goto L93;
    L141:
        if (r19 == 0) goto L144;
        this.E = false;
    L144:
        if (this.E == true) goto L146;
        getVm().setStartType("next_video");
    L146:
        getVm().setOverType("next_video");
        return;
    L93:
        if (((Boolean) IconSettingUtils.b.getValue()).booleanValue() == false) goto L97;
        Context r32 = getContext();
        if (r32 == null) goto L100;
        r4 = r32.getDrawable(2131231431);
    L100:
        r31.setImageDrawable(r4);
        if (IconSettingUtils.a() != (-1)) goto L122;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.e == false) goto L105;
    L123:
        boolean r33 = true;
    L125:
        r14.c r34 = this.H;
        if (r34 != null) goto L128;
    L130:
        boolean r35 = false;
    L131:
        if (r35 == true) goto L137;
        if (r33 == true) goto L137;
        if (((Boolean) IconSettingUtils.a.getValue()).booleanValue() == true) goto L137;
        r12 = false;
    L137:
        if (r12 == false) goto L139;
        int r36 = 8;
    L140:
        r31.setVisibility(r36);
        goto L141
    L139:
        r36 = 0;
        goto L140
    L128:
        if (r34.W() != true) goto L130;
        r35 = true;
        goto L131
    L105:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.h == true) goto L123;
        if (AosExtConfig.b.W1().a == false) goto L116;
        FeedPageConfig r37 = getVm().getPageConfig();
        if (r37 != null) goto L111;
    L113:
        boolean r38 = false;
    L114:
        if (r38 == false) goto L116;
        boolean r39 = true;
    L117:
        if (r39 == true) goto L123;
        if (getVm().getPageConfig().getShowSeriesChannel() == true) goto L123;
    L124:
        r33 = false;
        goto L125
    L111:
        if (r37.getUselessFollowChannel() == true) goto L113;
        r38 = true;
    L116:
        r39 = false;
        goto L117
    L122:
        if (IconSettingUtils.a() == 0) goto L124;
    L97:
        Context r40 = getContext();
        if (r40 == null) goto L100;
        r4 = r40.getDrawable(2131231432);
        goto L100
    L24:
        if (r11.g != true) goto L26;
        r13 = true;
        goto L27
    L17:
        r10 = null;
        goto L19
    L14:
        r9 = null;
        goto L15
    L10:
        r7 = null;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final boolean t(jz3.a r4, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r5) {
        jz3.a r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        jz3.a r7 = r5.b;
        if (r7 == null) goto L9;
        r14.c r8 = r7.a;
        if (r8 == null) goto L9;
        if (r6.a.c != r8.c) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public /* bridge */ /* synthetic */ void w(int r1, jz3.a r2) {
        V(r1, r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public void N(List<jz3.a> r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
        Object r5 = getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r5);
        if (((ListState) r5).c != ListState.State.INITIAL_SUCCESS) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L23;
        Iterator<T> r7 = r2.iterator();
    L9:
        if (r7.hasNext() == false) goto L12;
        ((jz3.a) r7.next()).h = true;
        goto L9
    L12:
        if (Intrinsics.areEqual(getVm().sceneId(), "homepage_hot") == false) goto L18;
        getVm().getPageConfig().getEnterAid();
        if ((getContext() instanceof Activity) == false) goto L16;
        Context r8 = getContext();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.Activity");
        Activity r9 = (Activity) r8;
    L17:
        Lazy r10 = AccountUsageHintHelper.a;
        AccountUsageHintHelper.c(r9);
        goto L18
    L16:
        r9 = null;
    L18:
        k54.c r11 = getFeedPageListener();
        if (r11 == null) goto L24;
        r11.onLoadSuccess();
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r6 = false;
        goto L6
    }
}
