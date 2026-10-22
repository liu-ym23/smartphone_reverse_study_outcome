package com.larksuite.component.card.component.header;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/component/header/CardHeaderView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/larksuite/component/card/component/header/CardHeaderView$HeaderConfig;", "getConfig", "()Lcom/larksuite/component/card/component/header/CardHeaderView$HeaderConfig;", "setConfig", "(Lcom/larksuite/component/card/component/header/CardHeaderView$HeaderConfig;)V", "updateConfig", "", ThumbGlideUrl.SOURCE_TEMPLATE, "", "startColor", "endColor", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "HeaderConfig", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardHeaderView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f283370a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f283371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f283372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f283373c;

        public a(String r100, Integer r101, Integer r102) {
            this.f283371a = r100;
            this.f283372b = r101;
            this.f283373c = r102;
        }
    }

    public final a getConfig() {
        return this.f283370a;
    }

    public CardHeaderView(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        TraceEvent.beginSection("CardHeaderView.onDraw");
        super.onDraw(r100);
        TraceEvent.endSection("CardHeaderView.onDraw");
    }

    public final void setConfig(a r100) {
        this.f283370a = r100;
    }

    public CardHeaderView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CardHeaderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
