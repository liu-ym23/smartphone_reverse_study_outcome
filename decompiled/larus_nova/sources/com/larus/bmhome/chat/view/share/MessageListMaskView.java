package com.larus.bmhome.chat.view.share;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qo8.g;
import qo8.i;
import qo8.j;
import qo8.k;
import qo8.l;
import v19.h;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010R\u001b\u0010\u0019\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001a\u0010\u0010R\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001d\u0010\u0010R\u001b\u0010\u001f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b \u0010\u0010¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/view/share/MessageListMaskView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isImmersiveMode", "", "immersiveBgColor", "Ljava/lang/Integer;", "maxPicHeight", "getMaxPicHeight", "()I", "maxPicHeight$delegate", "Lkotlin/Lazy;", "maxDiff", "getMaxDiff", "maxDiff$delegate", "normalFooterHeight", "getNormalFooterHeight", "normalFooterHeight$delegate", "normalMessageListBottomMaskHeight", "getNormalMessageListBottomMaskHeight", "normalMessageListBottomMaskHeight$delegate", "immersiveFooterHeight", "getImmersiveFooterHeight", "immersiveFooterHeight$delegate", "immersiveMessageListBottomMaskHeight", "getImmersiveMessageListBottomMaskHeight", "immersiveMessageListBottomMaskHeight$delegate", "initParams", "", "(ZLjava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawNormalMaskForMessageList", "drawImmersiveMaskForMessageList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListMaskView extends View {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f310385i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f310386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f310387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f310388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f310389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f310390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f310391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f310392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f310393h;

    public static final class a {
    }

    static {
    }

    public MessageListMaskView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MessageListMaskView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getImmersiveFooterHeight() {
        return ((Number) this.f310392g.getValue()).intValue();
    }

    private final int getImmersiveMessageListBottomMaskHeight() {
        return ((Number) this.f310393h.getValue()).intValue();
    }

    private final int getMaxDiff() {
        return ((Number) this.f310389d.getValue()).intValue();
    }

    private final int getMaxPicHeight() {
        return ((Number) this.f310388c.getValue()).intValue();
    }

    private final int getNormalFooterHeight() {
        return ((Number) this.f310390e.getValue()).intValue();
    }

    private final int getNormalMessageListBottomMaskHeight() {
        return ((Number) this.f310391f.getValue()).intValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        FLogger.f375446a.d("MessageListMaskView", "onDraw: canvas.height = " + Integer.valueOf(r210.getHeight()) + ", canvas.width = " + Integer.valueOf(r210.getWidth()) + ", view.height = " + getHeight() + ", view.width = " + getWidth());
        if (r210.getHeight() >= getMaxPicHeight()) goto L7;
        if ((getMaxPicHeight() - r210.getHeight()) > getMaxDiff()) goto L7;
    L8:
        setVisibility(0);
        if (this.f310386a == false) goto L17;
        int r100 = r210.getHeight() - getImmersiveFooterHeight();
        int r101 = r100 - getImmersiveMessageListBottomMaskHeight();
        if (r100 <= 0) goto L28;
        if (r101 <= 0) goto L29;
        if (r100 <= r101) goto L30;
        Integer r102 = this.f310387b;
        if (r102 == null) goto L31;
        Intrinsics.checkNotNull(r102);
        int r110 = ColorUtils.setAlphaComponent(r102.intValue(), 255);
        Integer r103 = this.f310387b;
        Intrinsics.checkNotNull(r103);
        LinearGradient r104 = new LinearGradient(0.0f, r100, 0.0f, r101, r110, ColorUtils.setAlphaComponent(r103.intValue(), 0), Shader.TileMode.CLAMP);
        Paint r105 = new Paint();
        r105.setShader(r104);
        r210.drawRect(new Rect(0, r101, r210.getWidth(), r100), r105);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L17:
        int r106 = r210.getHeight() - getNormalFooterHeight();
        int r107 = r106 - getNormalMessageListBottomMaskHeight();
        if (r106 <= 0) goto L33;
        if (r107 <= 0) goto L34;
        if (r106 <= r107) goto L35;
        boolean r108 = h.f552477a;
        if (h.a(null) == false) goto L24;
        LinearGradient r109 = new LinearGradient(0.0f, r106, 0.0f, r107, ColorProtector.parseColor("#FF161616"), ColorProtector.parseColor("#00161616"), Shader.TileMode.CLAMP);
    L25:
        Paint r111 = new Paint();
        r111.setShader(r109);
        r210.drawRect(new Rect(0, r107, r210.getWidth(), r106), r111);
        return;
    L24:
        r109 = new LinearGradient(0.0f, r106, 0.0f, r107, ColorProtector.parseColor("#FFFFFFFF"), ColorProtector.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP);
        goto L25
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L7:
        if (r210.getHeight() >= getMaxPicHeight()) goto L8;
        setVisibility(8);
    }

    public MessageListMaskView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f310388c = LazyKt.lazy(new g());
        this.f310389d = LazyKt.lazy(new qo8.h());
        this.f310390e = LazyKt.lazy(new i());
        this.f310391f = LazyKt.lazy(new j());
        this.f310392g = LazyKt.lazy(new k());
        this.f310393h = LazyKt.lazy(new l());
    }

    public /* synthetic */ MessageListMaskView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
