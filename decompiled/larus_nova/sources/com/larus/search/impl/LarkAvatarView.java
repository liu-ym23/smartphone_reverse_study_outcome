package com.larus.search.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarView;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J(\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/search/impl/LarkAvatarView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/larus/extension/aggregate_search_ui/api/ILarkAvatarView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentKey", "Lkotlin/Pair;", "", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "clearDrawable", "", "bind", "avatarKey", "entityId", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkAvatarView extends AppCompatImageView implements ILarkAvatarView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<String, String> f367418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f367419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f367420c;

    public static final class a {
    }

    static {
    }

    public LarkAvatarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LarkAvatarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.extension.aggregate_search_ui.api.ILarkAvatarView
    public final void clearDrawable() {
        setImageDrawable(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getWidth() > 0) goto L5;
    L7:
        super.onDraw(r100);
        return;
    L5:
        if (getHeight() <= 0) goto L7;
        int r101 = r100.save();
        r100.clipPath(this.f367419b);
        super.onDraw(r100);
        r100.restoreToCount(r101);
    }

    @Override // com.larus.extension.aggregate_search_ui.api.ILarkAvatarView
    public final void bind(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "entityId");
        cza.a r102 = null;
        if (StringsKt.isBlank(r100) == false) goto L6;
        this.f367418a = null;
        setImageDrawable(null);
        return;
    L6:
        final Pair<String, String> r103 = TuplesKt.to(r100, r101);
        if (Intrinsics.areEqual(this.f367418a, r103) == true) goto L9;
    L11:
        this.f367418a = r103;
        setImageDrawable(null);
        Object r104 = xp9.o.f564776a;
        if ((r104 instanceof OfficeSDKUserApi) == false) goto L14;
        OfficeSDKUserApi r105 = (OfficeSDKUserApi) r104;
    L15:
        if (r105 == null) goto L19;
        aza.d r106 = (aza.d) r105.getService(aza.d.class);
        if (r106 == null) goto L19;
        r102 = r106.getAvatarService();
    L19:
        if (r102 != null) goto L22;
        FLogger.f375446a.w("LarkAvatarView", "OfficeSDK avatarService is null, userApi=" + xp9.o.f564776a);
        return;
    L22:
        r102.a(getContext(), new cza.b(r100, r101), new AnonymousClass1(this, r103, r100, r101));
        return;
    L14:
        r105 = null;
        goto L15
    L9:
        if (getDrawable() == null) goto L11;
    }

    public LarkAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f367419b = new Path();
        this.f367420c = new RectF();
    }

    public /* synthetic */ LarkAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f367420c.set(0.0f, 0.0f, r100, r101);
        this.f367419b.reset();
        this.f367419b.addOval(this.f367420c, Path.Direction.CW);
    }
}
