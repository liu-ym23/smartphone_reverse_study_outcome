package com.bytedance.ee.bear.bitable.superagent;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0019\u0018\u0000 (2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0014J\b\u0010#\u001a\u00020\u001cH\u0014J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentFabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pill", "Landroid/widget/LinearLayout;", "textView", "Landroid/widget/TextView;", "handler", "Landroid/os/Handler;", "texts", "", "", "currentIndex", "charCount", "deleting", "", "running", "ticker", "com/bytedance/ee/bear/bitable/superagent/BitableSuperAgentFabView$ticker$1", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentFabView$ticker$1;", "setCarouselTexts", "", "carouselTexts", "", "([Ljava/lang/String;)V", BatterySceneData.OPT_START, "stop", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentFabView extends FrameLayout {
    public final TextView a;
    public final Handler b;
    public List<String> c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public final b h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BitableSuperAgentFabView a;

        public final void a() {
            if (this.a.c.isEmpty() == false) goto L5;
            return;
        L5:
            BitableSuperAgentFabView r0 = this.a;
            String r1 = (String) ListProtector.get(r0.c, r0.d);
            BitableSuperAgentFabView r2 = this.a;
            if (r2.f == false) goto L8;
        L10:
            BitableSuperAgentFabView r3 = this.a;
            if (r3.f == false) goto L13;
        L17:
            BitableSuperAgentFabView r4 = this.a;
            if (r4.f == false) goto L22;
            int r5 = r4.e;
            if (r5 <= 0) goto L22;
            int r6 = r5 - 1;
            r4.e = r6;
            r4.a.setText(r1.substring(0, r6));
            this.a.b.postDelayed(this, 30);
            return;
        L22:
            r4.f = false;
            r4.d = (r4.d + 1) % r4.c.size();
            this.a.b.postDelayed(this, 300);
            return;
        L13:
            if (r3.e != r1.length()) goto L17;
            if (this.a.c.size() <= 1) goto L25;
            BitableSuperAgentFabView r7 = this.a;
            r7.f = true;
            r7.b.postDelayed(this, 1800);
            return;
        L25:
            return;
        L8:
            if (r2.e >= r1.length()) goto L10;
            BitableSuperAgentFabView r8 = this.a;
            int r9 = r8.e + 1;
            r8.e = r9;
            r8.a.setText(r1.substring(0, r9));
            this.a.b.postDelayed(this, 60);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(BitableSuperAgentFabView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public BitableSuperAgentFabView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BitableSuperAgentFabView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (this.g == false) goto L5;
        return;
    L5:
        if (this.c.size() > 1) goto L8;
        return;
    L8:
        if (q.a().a() == false) goto L10;
        return;
    L10:
        this.g = true;
        this.b.post(this.h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
        this.b.removeCallbacks(this.h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    public final void setCarouselTexts(String[] r8) {
        this.g = false;
        this.b.removeCallbacks(this.h);
        if (r8 == null) goto L13;
        ?? r2 = new ArrayList();
        int r3 = r8.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L14;
        String r5 = r8[r4];
        if (r5.length() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        r2.add(r5);
    L12:
        r4 = r4 + 1;
        goto L5
    L9:
        r6 = false;
    L14:
        if (r2 != 0) goto L16;
        r2 = CollectionsKt.emptyList();
    L16:
        this.c = r2;
        this.d = 0;
        this.e = 0;
        this.f = false;
        if (r2.isEmpty() == false) goto L20;
        this.a.setText("");
        return;
    L20:
        if (this.c.size() != 1) goto L22;
    L25:
        this.a.setText((CharSequence) ListProtector.get(this.c, 0));
        return;
    L22:
        if (q.a().a() == true) goto L25;
        a();
        return;
    L13:
        r2 = 0;
        goto L14
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 0) goto L5;
        a();
        return;
    L5:
        this.g = false;
        this.b.removeCallbacks(this.h);
    }

    public BitableSuperAgentFabView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new Handler(Looper.getMainLooper());
        this.c = CollectionsKt.emptyList();
        this.h = new b(this);
        LayoutInflater.from(r2).inflate(2131559168, this, true);
        LinearLayout r5 = (LinearLayout) findViewById(2131364233);
        this.a = (TextView) findViewById(2131364234);
    }

    public /* synthetic */ BitableSuperAgentFabView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
