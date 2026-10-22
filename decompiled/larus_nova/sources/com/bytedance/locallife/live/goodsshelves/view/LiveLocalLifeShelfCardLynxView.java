package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.locallife.live.goodsshelves.viewholder.LiveLocalLifeGoodsShelvesLynxNativeViewHolder;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.j0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/LiveLocalLifeShelfCardLynxView;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getUniqueKey", "()Ljava/lang/String;", "setUniqueKey", "(Ljava/lang/String;)V", "uniqueKey", "Lcom/bytedance/locallife/live/lynx/LiveLocalLifeLynxView;", "b", "Lcom/bytedance/locallife/live/lynx/LiveLocalLifeLynxView;", "getLynxView", "()Lcom/bytedance/locallife/live/lynx/LiveLocalLifeLynxView;", "lynxView", "Landroid/view/View;", "c", "Landroid/view/View;", "getNativeLayout", "()Landroid/view/View;", "setNativeLayout", "(Landroid/view/View;)V", "nativeLayout", "Landroid/view/View$OnAttachStateChangeListener;", "d", "Landroid/view/View$OnAttachStateChangeListener;", "getAttachStateListener", "()Landroid/view/View$OnAttachStateChangeListener;", "setAttachStateListener", "(Landroid/view/View$OnAttachStateChangeListener;)V", "attachStateListener", "Lcom/bytedance/locallife/live/goodsshelves/viewholder/LiveLocalLifeGoodsShelvesLynxNativeViewHolder;", "e", "Lcom/bytedance/locallife/live/goodsshelves/viewholder/LiveLocalLifeGoodsShelvesLynxNativeViewHolder;", "getViewHolder", "()Lcom/bytedance/locallife/live/goodsshelves/viewholder/LiveLocalLifeGoodsShelvesLynxNativeViewHolder;", "setViewHolder", "(Lcom/bytedance/locallife/live/goodsshelves/viewholder/LiveLocalLifeGoodsShelvesLynxNativeViewHolder;)V", "viewHolder", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeShelfCardLynxView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f260267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveLocalLifeLynxView f260268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f260269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnAttachStateChangeListener f260270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveLocalLifeGoodsShelvesLynxNativeViewHolder f260271e;

    public static final class a {
    }

    static {
    }

    public LiveLocalLifeShelfCardLynxView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, null, 14);
    }

    public LiveLocalLifeShelfCardLynxView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, null, 12);
    }

    public LiveLocalLifeShelfCardLynxView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, null, 8);
    }

    public final View.OnAttachStateChangeListener getAttachStateListener() {
        return this.f260270d;
    }

    public final LiveLocalLifeLynxView getLynxView() {
        return this.f260268b;
    }

    public final View getNativeLayout() {
        return this.f260269c;
    }

    public final String getUniqueKey() {
        return this.f260267a;
    }

    public final LiveLocalLifeGoodsShelvesLynxNativeViewHolder getViewHolder() {
        return this.f260271e;
    }

    public final void setAttachStateListener(View.OnAttachStateChangeListener r100) {
        this.f260270d = r100;
    }

    public final void setNativeLayout(View r100) {
        this.f260269c = r100;
    }

    public final void setUniqueKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f260267a = r100;
    }

    public final void setViewHolder(LiveLocalLifeGoodsShelvesLynxNativeViewHolder r100) {
        this.f260271e = r100;
    }

    public LiveLocalLifeShelfCardLynxView(Context r100, AttributeSet r101, int r102, String r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r111 & 8) == 0) goto L11;
        r110 = "";
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "uniqueKey");
        super(r100, r101, r102);
        this.f260267a = r110;
        LiveLocalLifeLynxView r103 = new LiveLocalLifeLynxView(r100, null, 0, this.f260267a, 6);
        this.f260268b = r103;
        r103.setMinimumHeight(j0.c(120));
        addView(r103);
        addOnAttachStateChangeListener(new d(this));
    }
}
