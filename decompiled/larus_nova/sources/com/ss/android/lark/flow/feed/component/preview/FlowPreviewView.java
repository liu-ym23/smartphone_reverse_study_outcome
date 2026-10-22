package com.ss.android.lark.flow.feed.component.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.cardcomponent.preview.FeedDigestTextView;
import com.ss.android.lark.feed.cardcomponent.preview.FeedDigestTextView$setDigest$spannableString$1$1;
import com.ss.android.lark.feed.cardcomponent.preview.FeedReactionView;
import com.ss.android.lark.feed.cardcomponent.preview.c;
import com.ss.android.lark.reaction.loader.ReactionLoaderManager;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020\u001bH\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/preview/FlowPreviewView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "feedActionViewList", "", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedReactionView;", "reactionDivider", "Landroidx/appcompat/widget/AppCompatImageView;", "reactionCountText", "Landroid/widget/TextView;", "digestComponent", "Lcom/ss/android/lark/feed/cardcomponent/preview/DigestComponent;", "flowTextLayerComponent", "Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerComponent;", "emojiCallbackList", "Lcom/ss/android/lark/flow/feed/component/preview/FlowPreviewView$EmojiCallback;", "getEmojiCallbackList", "()Ljava/util/List;", "emojiCallbackList$delegate", "Lkotlin/Lazy;", "init", "", "bindPreview", "reactionParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/FeedPreviewComponent$FeedReactionParams;", "digestParams", "Lcom/ss/android/lark/feed/cardcomponent/preview/DigestComponent$DigestParams;", "flowParams", "Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerComponent$FlowTextLayerParams;", "createReactionDivider", "createReactionCount", "bindFlowPreviewText", "params", "createReactionView", "hideReactionView", "bindDigestView", "onDetachedFromWindow", "Companion", "EmojiCallback", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowPreviewView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<FeedReactionView> f423332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f423333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f423334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.feed.cardcomponent.preview.a f423335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.flow.feed.component.text_layer.a f423336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f423337f;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/preview/FlowPreviewView$EmojiCallback;", "Lcom/larksuite/framework/callback/UIGetDataCallback;", "", "callbackList", "", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "key", "", "<init>", "(Ljava/util/List;Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;)V", "onSuccessed", "", "data", "(Ljava/lang/Boolean;)V", "onErrored", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EmojiCallback extends UIGetDataCallback<Boolean> {
        private final List<EmojiCallback> callbackList;
        private final AppCompatImageView imageView;
        private final String key;

        @Override // com.larksuite.framework.callback.UIGetDataCallback
        public void onErrored(ErrorResult r100) {
            super.onErrored(r100);
            this.callbackList.remove(this);
        }

        /* JADX INFO: renamed from: onSuccessed, reason: avoid collision after fix types in other method */
        public void onSuccessed2(Boolean r100) {
            super.onSuccessed(r100);
            this.callbackList.remove(this);
            ReactionLoaderManager r101 = ReactionLoaderManager.b.f439153a;
            ReactionLoaderManager.d(this.imageView, this.key, null);
        }

        @Override // com.larksuite.framework.callback.UIGetDataCallback
        public /* bridge */ /* synthetic */ void onSuccessed(Boolean r100) {
            onSuccessed2(r100);
        }

        public EmojiCallback(List<EmojiCallback> r100, AppCompatImageView r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "callbackList");
            Intrinsics.checkNotNullParameter(r101, "imageView");
            Intrinsics.checkNotNullParameter(r102, "key");
            this.callbackList = r100;
            this.imageView = r101;
            this.key = r102;
            r100.add(this);
        }
    }

    public static final class a {
    }

    static {
    }

    private final List<EmojiCallback> getEmojiCallbackList() {
        return (List) this.f423337f.getValue();
    }

    public final void b() {
        AppCompatImageView r100 = this.f423333b;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        TextView r101 = this.f423334c;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
    L9:
        if ((!this.f423332a.isEmpty()) == false) goto L14;
        Iterator<T> r102 = this.f423332a.iterator();
    L12:
        if (r102.hasNext() == false) goto L16;
        ((FeedReactionView) r102.next()).setVisibility(8);
        goto L12
    L16:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getEmojiCallbackList().clear();
    }

    public FlowPreviewView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public FlowPreviewView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f423332a = new ArrayList();
        this.f423337f = LazyKt.lazy(FlowPreviewView$emojiCallbackList$2.INSTANCE);
        setGravity(16);
        com.ss.android.lark.flow.feed.component.text_layer.a r102 = new com.ss.android.lark.flow.feed.component.text_layer.a(r100);
        this.f423336e = r102;
        addView(r102.c(), r102.b());
        com.ss.android.lark.feed.cardcomponent.preview.a r103 = new com.ss.android.lark.feed.cardcomponent.preview.a(r100);
        this.f423335d = r103;
        View r104 = r103.c();
        ViewGroup.MarginLayoutParams r105 = r103.b();
        setGravity(16);
        r105.setMarginEnd(UIUtils.dp2px(r100, 12.0f));
        Unit r106 = Unit.INSTANCE;
        addView(r104, r105);
    }

    /* JADX WARN: Type inference failed for: r1v24, types: [com.ss.android.lark.feed.cardcomponent.preview.FeedDigestTextView$setDigest$spannableString$1$1] */
    public final void a(c r110, com.ss.android.lark.feed.cardcomponent.preview.a.b r111, com.ss.android.lark.flow.feed.component.text_layer.a.C4997a r112) {
        Intrinsics.checkNotNullParameter(r110, "reactionParams");
        Intrinsics.checkNotNullParameter(r111, "digestParams");
        if (r112 != null) goto L5;
    L13:
        getEmojiCallbackList().clear();
        if ((!r110.f420947a.isEmpty()) == true) goto L16;
    L61:
        b();
    L63:
        if (r112 == null) goto L67;
        com.ss.android.lark.flow.feed.component.text_layer.a r100 = this.f423336e;
        if (r100 == null) goto L67;
        Intrinsics.checkNotNullParameter(r112, "data");
        r100.c().a(r112);
    L67:
        com.ss.android.lark.feed.cardcomponent.preview.a r113 = this.f423335d;
        if (r113 == null) goto L76;
        Intrinsics.checkNotNullParameter(r111, "data");
        final FeedDigestTextView r114 = r113.c();
        List<DigestElement> r101 = r111.f420940a;
        String r102 = r111.f420941b;
        String r103 = r111.f420942c;
        final int r104 = r111.f420944e;
        r114.f420875b = r102;
        r114.f420876c = r103;
        r114.f420874a = r101;
        r114.f420877d = new FeedDigestTextView$setDigest$spannableString$1$1(r114, r104);
        r114.setText(r114.x(r101, r114.f420877d, r104));
        r113.c().setTextColor(UIUtils.getColor(r113.getContext(), r111.f420943d));
        return;
    L76:
        return;
    L16:
        if (r110.f420949c == true) goto L61;
        if (this.f423333b != null) goto L21;
        AppCompatImageView r105 = new AppCompatImageView(getContext());
        r105.setImageResource(R.drawable.vertical_divier_1dp);
        this.f423333b = r105;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.gravity = 16;
        r106.rightMargin = UIHelper.dp2px(6.0f);
        r106.leftMargin = UIHelper.dp2px(2.0f);
        addView(this.f423333b, 0, r106);
    L21:
        if (this.f423334c != null) goto L23;
        TextView r107 = new TextView(getContext());
        r107.setGravity(17);
        r107.setTextSize(2, 11.0f);
        r107.setTextColor(UIUtils.getColor(r107.getContext(), R.color.lkui_N600));
        this.f423334c = r107;
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, UIHelper.dp2px(18.0f));
        r108.gravity = 16;
        r108.rightMargin = UIHelper.dp2px(4.0f);
        addView(this.f423334c, 0, r108);
    L23:
        float r109 = getMeasuredWidth();
        TextView r115 = this.f423334c;
        if (r115 == null) goto L60;
        int r116 = RangesKt.coerceAtLeast((int) (((r109 - r115.getPaint().measureText("...")) / (UIHelper.dp2px(18.0f) + UIHelper.dp2px(4.0f))) - 1), 6);
        int r117 = r110.f420947a.size();
        int r118 = r110.f420948b;
        if (r118 <= 0) goto L28;
        int r119 = RangesKt.coerceAtMost(r118, r117);
    L29:
        int r120 = RangesKt.coerceAtMost(r119, r116);
        if (r117 <= r120) goto L34;
        TextView r121 = this.f423334c;
        if (r121 == null) goto L37;
        r121.setVisibility(0);
        r121.setText("...");
    L37:
        if (r120 != r116) goto L41;
        AppCompatImageView r122 = this.f423333b;
        if (r122 == null) goto L45;
        r122.setVisibility(8);
    L45:
        if (r120 < ((ArrayList) this.f423332a).size()) goto L47;
        int r123 = ((ArrayList) this.f423332a).size();
    L50:
        if (r123 >= r120) goto L52;
        FeedReactionView r124 = new FeedReactionView(getContext(), null, 0, r110.f420952f, 6);
        r124.setShowBackground(r110.f420950d);
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(-2, -2);
        r125.gravity = 16;
        addView(r124, 0, r125);
        ListProtector.add(this.f423332a, 0, r124);
        r123 = r123 + 1;
    L52:
        int r126 = 0;
    L53:
        if (r126 >= r120) goto L63;
        FeedReactionView r127 = (FeedReactionView) ListProtector.get(this.f423332a, r126);
        Reaction r128 = (Reaction) ListProtector.get(r110.f420947a, r126);
        r127.setVisibility(0);
        if (r110.f420951e == false) goto L57;
        int r129 = r128.getCount();
    L58:
        r127.setReactionCount(r129);
        EmojiCallback r130 = new EmojiCallback(getEmojiCallbackList(), r127.getReactionIcon(), r128.getType());
        ReactionLoaderManager r131 = ReactionLoaderManager.b.f439153a;
        ReactionLoaderManager.d(r127.getReactionIcon(), r128.getType(), r130);
        r126 = r126 + 1;
        goto L53
    L57:
        r129 = 0;
    L47:
        if (((ArrayList) this.f423332a).size() <= r120) goto L52;
        removeView((FeedReactionView) ListProtector.remove(this.f423332a, 0));
        goto L47
    L41:
        AppCompatImageView r132 = this.f423333b;
        if (r132 == null) goto L45;
        r132.setVisibility(0);
        goto L45
    L34:
        TextView r133 = this.f423334c;
        if (r133 == null) goto L37;
        r133.setVisibility(8);
        goto L37
    L28:
        r119 = r117;
        goto L29
    L60:
        throw new IllegalStateException("Required value was null.".toString());
    L5:
        if (r112.f423349a == false) goto L7;
    L9:
        boolean r134 = false;
    L10:
        if (r134 == true) goto L13;
        b();
        goto L63
    L7:
        if (r112.f423350b > 0) goto L9;
        r134 = true;
        goto L10
    }
}
