package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.n0;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0096\u00012\u00020\u0001:\u0006\u0096\u0001\u0097\u0001\u0098\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010t\u001a\u00020u2\b\b\u0001\u0010v\u001a\u00020\u00072\b\b\u0001\u0010w\u001a\u00020\u0007J&\u0010x\u001a\u00020u2\u000e\b\u0002\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010C2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010zJ\b\u0010{\u001a\u00020uH\u0002J\b\u0010|\u001a\u00020uH\u0002J\u0010\u0010}\u001a\u00020u2\u0006\u0010~\u001a\u00020VH\u0002J\b\u0010\u007f\u001a\u00020uH\u0002J\"\u0010\u0080\u0001\u001a\u00020\u00122\u0007\u0010\u0081\u0001\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020\u000eH\u0082@¢\u0006\u0003\u0010\u0083\u0001J\u0013\u0010\u0084\u0001\u001a\u00020$2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0017J\t\u0010\u0087\u0001\u001a\u00020$H\u0016J\u001b\u0010\u0088\u0001\u001a\u00020u2\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u0007H\u0014J\u001b\u0010\u008b\u0001\u001a\u00020u2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0002J%\u0010\u008e\u0001\u001a\u00020u2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0091\u0001\u001a\u00020u2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0014J\t\u0010\u0094\u0001\u001a\u00020uH\u0014J\t\u0010\u0095\u0001\u001a\u00020uH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001b\u0010-\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b2\u0010/R\u0014\u00104\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010/R\u0014\u00106\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010/R\u001b\u00108\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0019\u001a\u0004\b9\u0010/R\u001b\u0010;\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0019\u001a\u0004\b<\u0010\u001dR\u001e\u0010>\u001a\u0012\u0012\u0004\u0012\u00020@0?j\b\u0012\u0004\u0012\u00020@`AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010/R\u001a\u0010F\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010/\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010'\"\u0004\bL\u0010)R\u001a\u0010M\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010'\"\u0004\bO\u0010)R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020@0QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0019\u001a\u0004\bW\u0010XR#\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0019\u001a\u0004\b\\\u0010]R\u001f\u0010_\u001a\u00060`R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0019\u001a\u0004\ba\u0010bR\u001b\u0010d\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0019\u001a\u0004\bf\u0010gR\u000e\u0010i\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010l\u001a\u0004\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u000e\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "avatarKeys", "", "", "avatarKeyToEntityIdMap", "", "avatarKeyToBitmapMap", "Landroid/graphics/Bitmap;", "avatarKeyToBitmapLoadJobMap", "Lkotlinx/coroutines/Job;", "avatarPlaceholderBitmap", "getAvatarPlaceholderBitmap", "()Landroid/graphics/Bitmap;", "avatarPlaceholderBitmap$delegate", "Lkotlin/Lazy;", "avatarSizeDp", "", "getAvatarSizeDp", "()F", "setAvatarSizeDp", "(F)V", "textSizeDp", "getTextSizeDp", "setTextSizeDp", "value", "", "showAvatar", "getShowAvatar", "()Z", "setShowAvatar", "(Z)V", "tintLinkIconWithTextColor", "getTintLinkIconWithTextColor", "setTintLinkIconWithTextColor", "avatarSize", "getAvatarSize", "()I", "avatarSize$delegate", "replyMarginLeft", "getReplyMarginLeft", "replyMarginLeft$delegate", "contentStartMargin", "getContentStartMargin", "rowMinHeight", "getRowMinHeight", "spacingBetweenReplies", "getSpacingBetweenReplies", "spacingBetweenReplies$delegate", "lineSpacing", "getLineSpacing", "lineSpacing$delegate", "replyComparator", "Ljava/util/Comparator;", "Lcom/ss/android/lark/biz/im/api/ISimplifiedMessageInfo;", "Lkotlin/Comparator;", "rootMessage", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "showingReplyCount", "getShowingReplyCount", "maxShowingReplyCount", "getMaxShowingReplyCount", "setMaxShowingReplyCount", "(I)V", "showTailEllipsis", "getShowTailEllipsis", "setShowTailEllipsis", "showLastedItems", "getShowLastedItems", "setShowLastedItems", "showingReplyList", "", "lastTotalWidth", "needReGenerateReplyLayout", "spannableStringArray", "", "Landroid/text/SpannableStringBuilder;", "getSpannableStringArray", "()[Landroid/text/SpannableStringBuilder;", "spannableStringArray$delegate", "replyLayoutArray", "Landroid/text/StaticLayout;", "getReplyLayoutArray", "()[Landroid/text/StaticLayout;", "replyLayoutArray$delegate", "replyNameSpan", "Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$ReplyNameSpan;", "getReplyNameSpan", "()Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$ReplyNameSpan;", "replyNameSpan$delegate", "replyPaint", "Landroid/text/TextPaint;", "getReplyPaint", "()Landroid/text/TextPaint;", "replyPaint$delegate", "requiredVersionCode", "touchDownTime", "", "onClickReplyListener", "Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$OnClickReplyListener;", "getOnClickReplyListener", "()Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$OnClickReplyListener;", "setOnClickReplyListener", "(Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$OnClickReplyListener;)V", "longClickCheckRunnable", "Ljava/lang/Runnable;", "setTextColor", "", "usernameTextColor", "contentTextColor", "updateReplyList", "replyList", "", "updateAvatarData", "clearAvatarData", "tintLinkIcons", "spannable", "loadMissingAvatars", "loadAvatarBitmap", "avatarKey", "entityId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "checkSpannableString", RXScreenCaptureService.KEY_INDEX, "textMaxWidth", "getStaticLayout", "nameAndContent", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "ReplyNameSpan", "OnClickReplyListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadReplyExposureView extends View {
    public final Lazy A;
    public final int B;
    public long C;
    public b D;
    public final d E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CoroutineScope f412620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f412621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f412622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Bitmap> f412623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Job> f412624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f412625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f412626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f412627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f412628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f412629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f412630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f412631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f412632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f412633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f412634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public y6b.c<?> f412635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f412636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f412637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f412638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f412639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<n0> f412640u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f412641v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f412642w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f412643x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f412644y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f412645z;

    public static final class a {
    }

    public interface b {
        void a();

        void b(y6b.c<?> r100, n0 r101);
    }

    public final class c extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f412646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f412647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f412648c;

        public c(ThreadReplyExposureView r100) {
            this.f412646a = y9c.d.a(6);
            this.f412647b = new Rect();
            this.f412648c = UDColorUtils.getColor(r100.getContext(), R.color.text_title);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            if (r101 != null) goto L7;
            return 0;
        L7:
            return MathKt.roundToInt(r100.measureText(r101, r102, r103) + this.f412646a);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r210, Paint r211) {
            Intrinsics.checkNotNullParameter(r110, "canvas");
            Intrinsics.checkNotNullParameter(r211, "paint");
            if (r111 != null) goto L5;
            return;
        L5:
            this.f412647b.set(MathKt.roundToInt(r114), r115, MathKt.roundToInt((r114 + r211.measureText(r111, r112, r113)) + this.f412646a), r210);
            boolean r100 = r211 instanceof TextPaint;
            TextPaint r101 = null;
            if (r100 == false) goto L8;
            TextPaint r102 = (TextPaint) r211;
        L10:
            if (r102 == null) goto L12;
            boolean r117 = r102.isFakeBoldText();
        L13:
            int r118 = r211.getColor();
            r211.setColor(0);
            r110.drawRect(this.f412647b, r211);
            r211.setColor(this.f412648c);
            if (r100 == false) goto L16;
            r101 = (TextPaint) r211;
        L16:
            if (r101 == null) goto L18;
            r101.setFakeBoldText(true);
        L18:
            r110.drawText(r111, r112, r113, r114, r116, r211);
            TextPaint r103 = (TextPaint) r211;
            r103.setFakeBoldText(r117);
            r103.setColor(r118);
            return;
        L12:
            r117 = false;
            goto L13
        L8:
            r102 = null;
            goto L10
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadReplyExposureView f412649a;

        public d(ThreadReplyExposureView r100) {
            this.f412649a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f412649a.cancelPendingInputEvents();     // Catch: Throwable -> L6
            b r100 = this.f412649a.getOnClickReplyListener();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f412650a = null;

        static {
            f412650a = new e();
        }

        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((n0) r100).b() - ((n0) r101).b();
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadReplyExposureView f412651a;

        public f(ThreadReplyExposureView r100) {
            this.f412651a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f412651a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public ThreadReplyExposureView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ThreadReplyExposureView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Bitmap getAvatarPlaceholderBitmap() {
        return (Bitmap) this.f412625f.getValue();
    }

    private final int getAvatarSize() {
        return ((Number) this.f412630k.getValue()).intValue();
    }

    private final int getContentStartMargin() {
        if (this.f412628i == true) goto L7;
        return 0;
    L7:
        return getReplyMarginLeft();
    }

    private final float getLineSpacing() {
        return ((Number) this.f412633n.getValue()).floatValue();
    }

    private final StaticLayout[] getReplyLayoutArray() {
        return (StaticLayout[]) this.f412644y.getValue();
    }

    private final int getReplyMarginLeft() {
        return ((Number) this.f412631l.getValue()).intValue();
    }

    private final c getReplyNameSpan() {
        return (c) this.f412645z.getValue();
    }

    private final TextPaint getReplyPaint() {
        return (TextPaint) this.A.getValue();
    }

    private final int getRowMinHeight() {
        if (this.f412628i == true) goto L7;
        return 0;
    L7:
        return getAvatarSize();
    }

    private final int getSpacingBetweenReplies() {
        return ((Number) this.f412632m.getValue()).intValue();
    }

    private final SpannableStringBuilder[] getSpannableStringArray() {
        return (SpannableStringBuilder[]) this.f412643x.getValue();
    }

    public final void c() {
        if (this.f412628i == true) goto L6;
        return;
    L6:
        if (CoroutineScopeKt.isActive(this.f412620a) == true) goto L8;
        this.f412620a = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getMain()));
    L8:
        Iterator<String> r100 = this.f412621b.iterator();
    L10:
        if (r100.hasNext() == false) goto L27;
        String r101 = r100.next();
        if (this.f412623d.containsKey(r101) == false) goto L21;
        Bitmap r102 = (Bitmap) ((LinkedHashMap) this.f412623d).get(r101);
        boolean r103 = false;
        if (r102 != null) goto L16;
    L18:
        if (r103 == true) goto L21;
    L16:
        if (r102.isRecycled() != true) goto L18;
        r103 = true;
    L21:
        if (this.f412624e.containsKey(r101) == true) goto L10;
        String r104 = (String) ((LinkedHashMap) this.f412622c).get(r101);
        if (r104 == null) goto L10;
        this.f412624e.put(r101, BuildersKt.launch$default(this.f412620a, Dispatchers.getIO(), null, new ThreadReplyExposureView$loadMissingAvatars$1(this, r101, r104, null), 2, null));
        goto L10
    }

    public final void e() {
        if (this.f412628i == true) goto L5;
    L25:
        this.f412621b.clear();
        ((LinkedHashMap) this.f412622c).clear();
        ((LinkedHashMap) this.f412623d).clear();
        Iterator r100 = ((LinkedHashMap) this.f412624e).values().iterator();
    L27:
        if (r100.hasNext() == false) goto L29;
        Job.DefaultImpls.cancel$default((Job) r100.next(), null, 1, null);
        goto L27
    L29:
        ((LinkedHashMap) this.f412624e).clear();
        return;
    L5:
        if (((ArrayList) this.f412640u).isEmpty() == true) goto L25;
        LinkedHashSet r101 = new LinkedHashSet();
        ((LinkedHashMap) this.f412622c).clear();
        Iterator r102 = ((ArrayList) this.f412640u).iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        n0 r103 = (n0) r102.next();
        if (r103.d().length() != 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L15;
        r101.add(r103.d());
        this.f412622c.put(r103.d(), r103.c());
        goto L9
    L15:
        Log.w("MessageThreadCellReplyView", "updateReplyList, reply message id is " + r103.getMessageId() + ", sender id is " + r103.c() + ", avatar key is empty");
        goto L9
    L13:
        r104 = false;
        goto L14
    L17:
        ((LinkedHashMap) this.f412623d).keySet().retainAll(r101);
        Iterator r105 = ((LinkedHashMap) this.f412624e).entrySet().iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (r101.contains(r106.getKey()) == true) goto L19;
        Job.DefaultImpls.cancel$default((Job) r106.getValue(), null, 1, null);
        r105.remove();
        goto L19
    L23:
        Set<String> r107 = this.f412621b;
        r107.clear();
        r107.addAll(r101);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.f412620a, null, 1, null);
        ((LinkedHashMap) this.f412624e).clear();
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    public final float getAvatarSizeDp() {
        return this.f412626g;
    }

    public final int getMaxShowingReplyCount() {
        return this.f412637r;
    }

    public final b getOnClickReplyListener() {
        return this.D;
    }

    public final boolean getShowAvatar() {
        return this.f412628i;
    }

    public final boolean getShowLastedItems() {
        return this.f412639t;
    }

    public final boolean getShowTailEllipsis() {
        return this.f412638s;
    }

    public final int getShowingReplyCount() {
        return this.f412636q;
    }

    public final float getTextSizeDp() {
        return this.f412627h;
    }

    public final boolean getTintLinkIconWithTextColor() {
        return this.f412629j;
    }

    public static final /* synthetic */ int a(ThreadReplyExposureView r100) {
        return r100.getAvatarSize();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = this.f412636q;
        int r101 = 0;
        float r102 = 0.0f;
    L3:
        if (r101 >= r100) goto L21;
        r110.save();
        r110.translate(0.0f, r102);
        if (this.f412628i == false) goto L13;
        String r103 = ((n0) ListProtector.get(this.f412640u, r101)).d();
        Bitmap r104 = (Bitmap) ((LinkedHashMap) this.f412623d).get(r103);
        if (r104 != null) goto L10;
        Log.w("MessageThreadCellReplyView", "avatar bitmap not found for key: " + r103);
        r110.drawBitmap(getAvatarPlaceholderBitmap(), 0.0f, 0.0f, null);
        goto L13
    L10:
        if (r104.isRecycled() == false) goto L12;
        Log.w("MessageThreadCellReplyView", "avatar bitmap is recycled for key: " + r103);
        r110.drawBitmap(getAvatarPlaceholderBitmap(), 0.0f, 0.0f, null);
        goto L13
    L12:
        r110.drawBitmap(r104, 0.0f, 0.0f, null);
    L13:
        r110.translate(getContentStartMargin(), 0.0f);
        StaticLayout r105 = getReplyLayoutArray()[r101];
        if (r105 == null) goto L16;
        r105.draw(r110);
    L16:
        r110.restore();
        if (r105 == null) goto L19;
        int r106 = r105.getHeight();
    L20:
        r102 = r102 + (Math.max(r106, getRowMinHeight()) + getSpacingBetweenReplies());
        r101 = r101 + 1;
        goto L3
    L19:
        r106 = 0;
        goto L20
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.D != null) goto L5;
        return false;
    L5:
        int r101 = r100.getAction();
        if (r101 == 0) goto L44;
        if (r101 != 1) goto L9;
        removeCallbacks(this.E);
        if ((System.currentTimeMillis() - this.C) >= ViewConfiguration.getLongPressTimeout()) goto L16;
        boolean r102 = true;
    L17:
        if (r102 == true) goto L19;
        return true;
    L19:
        int r103 = this.f412636q;
        int r104 = 0;
        int r105 = 0;
    L20:
        if (r104 >= r103) goto L43;
        StaticLayout r106 = getReplyLayoutArray()[r104];
        if (r106 == null) goto L24;
        int r107 = r106.getHeight();
    L25:
        int r108 = r107 + r105;
        if (r104 != 0) goto L28;
    L31:
        int r109 = getSpacingBetweenReplies() / 2;
    L32:
        int r110 = r108 + r109;
        if (r105 > r100.getY()) goto L42;
        if (r110 < r100.getY()) goto L42;
        y6b.c<?> r111 = this.f412635p;
        if (r111 == null) goto L41;
        b r112 = this.D;
        if (r112 == null) goto L41;
        r112.b(r111, (n0) ListProtector.get(this.f412640u, r104));
    L41:
        return true;
    L42:
        r104 = r104 + 1;
        r105 = r110;
        goto L20
    L28:
        if (r104 == (this.f412636q - 1)) goto L31;
        r109 = getSpacingBetweenReplies();
        goto L32
    L24:
        r107 = 0;
        goto L25
    L43:
        return false;
    L16:
        r102 = false;
        goto L17
    L9:
        if (r101 == 3) goto L11;
        return false;
    L11:
        removeCallbacks(this.E);
        return true;
    L44:
        this.C = System.currentTimeMillis();
        Log.e("MessageThreadCellReplyView", "touchDownTime: " + this.C);
        removeCallbacks(this.E);
        postDelayed(this.E, (long) ViewConfiguration.getLongPressTimeout());
        return true;
    }

    public final void setAvatarSizeDp(float r100) {
        this.f412626g = r100;
    }

    public final void setMaxShowingReplyCount(int r100) {
        this.f412637r = r100;
    }

    public final void setOnClickReplyListener(b r100) {
        this.D = r100;
    }

    public final void setShowAvatar(boolean r100) {
        if (this.f412628i != r100) goto L5;
        return;
    L5:
        this.f412628i = r100;
        this.f412642w = true;
        e();
        c();
        requestLayout();
        invalidate();
    }

    public final void setShowLastedItems(boolean r100) {
        this.f412639t = r100;
    }

    public final void setShowTailEllipsis(boolean r100) {
        this.f412638s = r100;
    }

    public final void setTextSizeDp(float r100) {
        this.f412627h = r100;
    }

    public final void setTintLinkIconWithTextColor(boolean r100) {
        this.f412629j = r100;
    }

    public final void d(int r100, int r101) {
        getReplyNameSpan().f412648c = r100;
        getReplyPaint().setColor(r101);
    }

    public final void f(y6b.c<?> r110, List<? extends n0> r111) {
        this.f412635p = r110;
        ((ArrayList) this.f412640u).clear();
        List<? extends n0> r112 = r111;
        if (r112 != null) goto L5;
    L8:
        boolean r113 = true;
    L9:
        if (r113 == false) goto L11;
        this.f412636q = 0;
    L16:
        e();
        if (this.f412638s == false) goto L24;
        if (r111 == null) goto L20;
        int r114 = r111.size();
    L22:
        if (r114 <= this.f412637r) goto L24;
        boolean r115 = true;
    L25:
        int r116 = this.f412636q;
        int r100 = 0;
    L26:
        if (r100 >= r116) goto L49;
        n0 r101 = (n0) ListProtector.get(this.f412640u, r100);
        String r102 = r101.a();
        SpannableStringBuilder r103 = new SpannableStringBuilder().append(r102).append(r101.getMessageContent());
        if (r115 == true) goto L30;
    L32:
        r103.setSpan(getReplyNameSpan(), 0, r102.length(), 17);
        if (this.f412629j == false) goto L48;
        Intrinsics.checkNotNull(r103);
        int r104 = getReplyPaint().getColor();
        Iterator r105 = ArrayIteratorKt.iterator((ncc.e[]) r103.getSpans(0, r103.length(), ncc.e.class));
    L36:
        if (r105.hasNext() == false) goto L48;
        ncc.e r106 = (ncc.e) r105.next();
        if (r106.f518728e == false) goto L42;
        if (r106.f518729f == 0) goto L36;
    L42:
        Drawable r107 = r106.f518726c;
        if (r107 == null) goto L45;
        r107.mutate();
        r107.setTint(r104);
    L45:
        r106.a(new com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.d(this, r104));
        Bitmap r108 = r106.f518725b;
        if (r108 == null) goto L36;
        Paint r109 = new Paint();
        r109.setColorFilter(new PorterDuffColorFilter(r104, PorterDuff.Mode.SRC_IN));
        Bitmap r117 = Bitmap.createBitmap(r108.getWidth(), r108.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r117).drawBitmap(r108, 0.0f, 0.0f, r109);
        r106.f518725b = r117;
    L48:
        getSpannableStringArray()[r100] = r103;
        r100 = r100 + 1;
        goto L26
    L30:
        if (r100 != (this.f412636q - 1)) goto L32;
        r103.append("...");
        goto L32
    L49:
        this.f412642w = true;
        c();
        post(new f(this));
        return;
    L20:
        r114 = 0;
    L24:
        r115 = false;
        goto L25
    L11:
        this.f412636q = Math.min(this.f412637r, r111.size());
        List r118 = CollectionsKt.sortedWith(r111, this.f412634o);
        if (this.f412639t == false) goto L14;
        List r119 = r118.subList(r118.size() - this.f412636q, r118.size());
    L15:
        ArrayList r120 = (ArrayList) this.f412640u;
        r120.addAll(r119);
        goto L16
    L14:
        r119 = r118.subList(0, this.f412636q);
        goto L15
    L5:
        if (r112.isEmpty() == true) goto L8;
        r113 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        if (this.f412636q >= 1) goto L6;
        setMeasuredDimension(0, 0);
        return;
    L6:
        int r100 = View.MeasureSpec.getMode(r210);
        if (r100 != Integer.MIN_VALUE) goto L9;
    L11:
        int r101 = View.MeasureSpec.getSize(r210);
    L12:
        if (r101 > 0) goto L16;
        setMeasuredDimension(0, 0);
        return;
    L16:
        if (this.f412641v == r101) goto L19;
        this.f412642w = true;
    L19:
        if (this.f412642w == true) goto L21;
        int r102 = r101;
    L74:
        int r103 = getSpacingBetweenReplies();
        int r104 = this.f412636q;
        int r105 = (r103 * (r104 - 1)) + 0;
        int r106 = 0;
    L75:
        if (r106 >= r104) goto L81;
        StaticLayout r107 = getReplyLayoutArray()[r106];
        if (r107 == null) goto L79;
        int r108 = r107.getHeight();
    L80:
        r105 = r105 + Math.max(r108, getRowMinHeight());
        r106 = r106 + 1;
        goto L75
    L79:
        r108 = 0;
        goto L80
    L81:
        int r109 = Math.max(getMinimumWidth(), Math.min(r102, r101));
        this.f412641v = r109;
        setMeasuredDimension(r109, r105);
        return;
    L21:
        if ((r101 - getContentStartMargin()) >= 0) goto L23;
        int r110 = 0;
    L24:
        int r111 = this.f412636q;
        int r112 = 0;
    L26:
        if (r112 >= r111) goto L52;
        String r113 = ((n0) ListProtector.get(this.f412640u, r112)).a();
        float r114 = r110;
        if (getReplyPaint().measureText(r113) <= r114) goto L30;
        boolean r115 = getReplyPaint().isFakeBoldText();
        getReplyPaint().setFakeBoldText(true);
        CharSequence r116 = TextUtils.ellipsize(r113, getReplyPaint(), r114, TextUtils.TruncateAt.END);
        SpannableStringBuilder r117 = new SpannableStringBuilder().append(r116).append(((n0) ListProtector.get(this.f412640u, r112)).getMessageContent());
        r117.setSpan(getReplyNameSpan(), 0, r116.length(), 17);
        getSpannableStringArray()[r112] = r117;
        getReplyPaint().setFakeBoldText(r115);
    L30:
        CharSequence r118 = getSpannableStringArray()[r112];
        if (r118 != null) goto L34;
        r118 = "";
    L34:
        int r119 = this.B;
        Boolean r120 = ReplyInThreadUtil.f416628a;
        if (Build.VERSION.SDK_INT < r119) goto L37;
        boolean r121 = true;
    L39:
        if (r121 == false) goto L83;
        getReplyLayoutArray()[r112] = StaticLayout.Builder.obtain(r118, 0, r118.length(), getReplyPaint(), r110).setEllipsize(TextUtils.TruncateAt.END).setMaxLines(2).setLineSpacing(getLineSpacing(), 1.0f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(TextDirectionHeuristics.LOCALE).setIncludePad(true).build();
    L51:
        r112 = r112 + 1;
        goto L26
    L83:
        Class r122 = Integer.TYPE;     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        Class r123 = Float.TYPE;     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        Constructor r124 = StaticLayout.class.getConstructor(new Class[]{CharSequence.class, r122, r122, TextPaint.class, r122, Layout.Alignment.class, TextDirectionHeuristic.class, r123, r123, Boolean.TYPE, TextUtils.TruncateAt.class, r122, r122});     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        r124.setAccessible(true);     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        getReplyLayoutArray()[r112] = r124.newInstance(new Object[]{r118, 0, Integer.valueOf(r118.length()), getReplyPaint(), Integer.valueOf(r110), Layout.Alignment.ALIGN_NORMAL, TextDirectionHeuristics.LOCALE, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.TRUE, TextUtils.TruncateAt.END, Integer.valueOf(r110), 2});     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
    L47:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
    L45:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
    L49:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
    L43:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
        goto L51
    L37:
        r121 = false;
        goto L39
    L52:
        List r125 = ArraysKt.toList(getReplyLayoutArray()).subList(0, this.f412636q);
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r127 = r125.iterator();
    L54:
        if (r127.hasNext() == false) goto L68;
        StaticLayout r128 = (StaticLayout) r127.next();
        if (r128 == null) goto L66;
        int r129 = r128.getLineCount();
        ArrayList r130 = new ArrayList();
        if (r129 < 0) goto L63;
        int r131 = 0;
    L60:
        r130.add(Float.valueOf(r128.getLineWidth(r131)));
        if (r131 == r129) goto L63;
        r131 = r131 + 1;
    L63:
        Float r132 = CollectionsKt.m9877maxOrNull(r130);
        if (r132 == null) goto L66;
        float r133 = r132.floatValue();
    L67:
        r126.add(Float.valueOf(r133));
    L66:
        r133 = 0.0f;
        goto L67
    L68:
        Float r134 = CollectionsKt.m9877maxOrNull(r126);
        if (r134 == null) goto L71;
        r102 = ((int) r134.floatValue()) + getContentStartMargin();
    L72:
        this.f412642w = false;
        goto L74
    L71:
        r102 = r101;
        goto L72
    L23:
        r110 = r101 - getContentStartMargin();
        goto L24
    L9:
        if (r100 == 1073741824) goto L11;
        r101 = 0;
        goto L12
    }

    public ThreadReplyExposureView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f412620a = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f412621b = new LinkedHashSet();
        this.f412622c = new LinkedHashMap();
        this.f412623d = new LinkedHashMap();
        this.f412624e = new LinkedHashMap();
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f412625f = LazyKt.lazy(r103, new ThreadReplyExposureView$avatarPlaceholderBitmap$2(r100, this));
        this.f412626g = 20.0f;
        this.f412627h = 14.0f;
        this.f412628i = true;
        this.f412630k = LazyKt.lazy(r103, new ThreadReplyExposureView$avatarSize$2(r100, this));
        this.f412631l = LazyKt.lazy(r103, new ThreadReplyExposureView$replyMarginLeft$2(this));
        this.f412632m = LazyKt.lazy(r103, ThreadReplyExposureView$spacingBetweenReplies$2.INSTANCE);
        this.f412633n = LazyKt.lazy(r103, ThreadReplyExposureView$lineSpacing$2.INSTANCE);
        this.f412634o = e.f412650a;
        this.f412637r = 5;
        this.f412639t = true;
        this.f412640u = new ArrayList();
        this.f412642w = true;
        this.f412643x = LazyKt.lazy(r103, new ThreadReplyExposureView$spannableStringArray$2(this));
        this.f412644y = LazyKt.lazy(r103, new ThreadReplyExposureView$replyLayoutArray$2(this));
        this.f412645z = LazyKt.lazy(r103, new ThreadReplyExposureView$replyNameSpan$2(this));
        this.A = LazyKt.lazy(r103, new ThreadReplyExposureView$replyPaint$2(r100, this));
        this.B = 23;
        this.E = new d(this);
    }

    public /* synthetic */ ThreadReplyExposureView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final Object b(ThreadReplyExposureView r100, String r101, String r102, Continuation r103) {
        r100.getClass();
        j r104 = new j(IntrinsicsKt.intercepted(r103), 1);
        r104.C();
        IRequestCreator r105 = ImageLoader.with(r100.getContext()).load(AvatarImage.Builder.obtain(r101, r102, r100.getAvatarSize(), r100.getAvatarSize()).build());
        Bitmap r106 = r105.asBitmap().fitCenter().transform(new RoundedCornersTransformation(r100.getAvatarSize() / 2, 0)).getBitmap(r100.getAvatarSize(), r100.getAvatarSize());     // Catch: Throwable -> L5
    L11:
        if (r104.isActive() == true) goto L13;
        Log.w("MessageThreadCellReplyView", "continuation is not active, just return");
    L16:
        Object r107 = r104.B();
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L19:
        return r107;
    L13:
        if (r106 == null) goto L15;
        r104.resumeWith(Result.m9449constructorimpl(r106));
        goto L16
    L15:
        Log.e("MessageThreadCellReplyView", "Avatar load successfully for key: " + r101 + " but bitmap is null, resume with exception");
        Result.Companion r108 = Result.Companion;
        r104.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new NullPointerException("Image load failed"))));
    L5:
        th = move-exception;
        Log.e("MessageThreadCellReplyView", "Avatar load failed for key " + r101 + ": " + th);
        if (r104.isActive() == false) goto L9;
        Result.Companion r109 = Result.Companion;
        r104.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(th)));
    L9:
        r106 = null;
        goto L11
    }
}
