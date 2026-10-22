package com.obric.assistant.remote_card_container.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant_card.provider_core.bean.CardAction;
import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import com.obric.assistant.remote_card_container.cache.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\rB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000eJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0012J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020!H\u0014J\b\u0010'\u001a\u00020!H\u0014J\u001c\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010*\u001a\u00020+H\u0002J\u001a\u0010,\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0014H\u0016J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0002J(\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0014J\u0018\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0002J(\u0010=\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010>\u001a\u00020.2\u0006\u00100\u001a\u00020\u00142\u0006\u0010?\u001a\u00020@H\u0002J \u0010A\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00142\u0006\u0010B\u001a\u00020@H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/assistant/remote_card_container/widget/RemoteCardContainer;", "Landroid/widget/RelativeLayout;", "Lcom/obric/assistant/remote_card_container/manager/CardChangeListener$OnCardChangeListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "bindCardData", "Lcom/obric/assistant/remote_card_container/widget/MsgCardData;", "displayedCardUri", "", "roundAnglePath", "Landroid/graphics/Path;", "getRoundAnglePath", "()Landroid/graphics/Path;", "roundAnglePath$delegate", "Lkotlin/Lazy;", "loadJob", "Lkotlinx/coroutines/Job;", "defaultRoundAngle", "onLongClickListener", "Landroid/view/View$OnLongClickListener;", "setDefaultRoundAngle", "", "roundAngle", "cardData", "setOnLongClickListener", "listener", "onAttachedToWindow", "onDetachedFromWindow", "loadRemoteCard", "remoteCardData", "allowCache", "", "wrapChildWithHorizontalScrollView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "onCardStateChanged", "cardUri", "draw", "canvas", "Landroid/graphics/Canvas;", "drawWithAngle", "onSizeChanged", "w", "h", "oldw", "oldh", "updateRoundPath", "width", "height", "bindCardActionToView", "view", "cardAction", "Lcom/obric/aiagent/assistant_card/provider_core/bean/CardAction;", "handleCardActionClick", "action", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteCardContainer extends RelativeLayout implements com.obric.assistant.remote_card_container.manager.c.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f391295h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f391296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.obric.assistant.remote_card_container.widget.a f391297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f391298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f391299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f391300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f391301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnLongClickListener f391302g;

    public static final class a {
    }

    static {
    }

    private final Path getRoundAnglePath() {
        return (Path) this.f391299d.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Set<com.obric.assistant.remote_card_container.manager.c.a> r100 = com.obric.assistant.remote_card_container.manager.c.f391288a;
        Intrinsics.checkNotNullParameter(this, "listener");
        com.obric.assistant.remote_card_container.manager.c.f391288a.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Set<com.obric.assistant.remote_card_container.manager.c.a> r100 = com.obric.assistant.remote_card_container.manager.c.f391288a;
        Intrinsics.checkNotNullParameter(this, "listener");
        com.obric.assistant.remote_card_container.manager.c.f391288a.remove(this);
    }

    public RemoteCardContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.obric.assistant.remote_card_container.manager.c.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cardUri");
        BuildersKt.launch$default(this.f391296a, null, null, new RemoteCardContainer$onCardStateChanged$1(r100, this, null), 3, null);
    }

    public final void b(com.obric.assistant.remote_card_container.widget.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        p9a.e r101 = p9a.b.f528329a;
        p9a.b.a("RemoteCardContainer", "bindCardData: cardUri = " + r100.f391303a + ", messageId = " + r100.f391304b + ", height = " + r100.f391306d + ", extraParams = " + r100.f391305c);
        this.f391297b = r100;
        d(r100, true);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f391301f <= 0) goto L5;
        r100.save();
        r100.clipPath(getRoundAnglePath());
        super.draw(r100);
        r100.restore();
        return;
    L5:
        super.draw(r100);
    }

    public final void setDefaultRoundAngle(int r100) {
        this.f391301f = r100;
        if (r100 > 0) goto L5;
        boolean r101 = true;
    L6:
        setWillNotDraw(r101);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f391302g = r100;
        super.setOnLongClickListener(r100);
    }

    public RemoteCardContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final void d(com.obric.assistant.remote_card_container.widget.a r110, boolean r111) {
        if (r110 != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L11;
        p9a.e r112 = p9a.b.f528329a;
        p9a.b.a("RemoteCardContainer", "loadRemoteCard: card data is not valid " + r110);
        return;
    L11:
        Job r101 = this.f391300e;
        if (r101 == null) goto L14;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L14:
        CoroutineScope r102 = this.f391296a;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L17;
        CoroutineStart r103 = CoroutineStart.UNDISPATCHED;
    L18:
        this.f391300e = BuildersKt.launch$default(r102, null, r103, new RemoteCardContainer$loadRemoteCard$1(r110, this, r111, null), 1, null);
        return;
    L17:
        r103 = CoroutineStart.DEFAULT;
        goto L18
    L5:
        if ((o0.d(r110.f391303a) & o0.d(r110.f391304b)) != true) goto L7;
        r100 = true;
        goto L8
    }

    public RemoteCardContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f391296a = CoroutineScopeKt.MainScope();
        this.f391299d = LazyKt.lazy(new d());
        setMinimumHeight(1);
    }

    public static void c(Context r100, String r101, CardAction r102) {
        p9a.e r103 = p9a.b.f528329a;
        p9a.b.a("RemoteCardContainer", "handleCardActionClick: cardUri = " + r101 + ", action = " + r102);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RemoteCardContainer$handleCardActionClick$1(r100, r101, r102, null), 3, null);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, final int r101, int r110, int r111) {
        super.onSizeChanged(r100, r101, r110, r111);
        if (r101 > 0) goto L5;
    L13:
        getRoundAnglePath().reset();
        int r112 = this.f391301f;
        if (r112 <= 0) goto L18;
        float r113 = r112;
        getRoundAnglePath().addRoundRect(0.0f, 0.0f, r100, r101, new float[]{r113, r113, r113, r113, r113, r113, r113, r113}, Path.Direction.CW);
        return;
    L18:
        return;
    L5:
        if (getLayoutParams().height != (-2)) goto L13;
        p9a.e r114 = p9a.b.f528329a;
        p9a.b.a("RemoteCardContainer", "onSizeChanged: displayedCardUri = " + this.f391298c + ", height is " + r101);
        m r115 = m.f391249a;
        String r102 = this.f391298c;
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        if (r115.a(r102) == null) goto L12;
        r115.b(this.f391298c, new b(r101));
        goto L13
    L12:
        FLogger.f375446a.i("RemoteCardContainer", "card info not found, create new one");
        final String r116 = this.f391298c;
        final com.obric.assistant.remote_card_container.widget.a r117 = this.f391297b;
        CardCacheManager r103 = CardCacheManager.f391235a;
        CardCacheManager.b(new c(r116, r117, r101));
        goto L13
    }
}
