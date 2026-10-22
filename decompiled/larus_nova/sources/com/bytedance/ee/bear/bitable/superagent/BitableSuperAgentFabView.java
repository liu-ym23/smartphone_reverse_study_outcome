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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0019\u0018\u0000 (2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0014J\b\u0010#\u001a\u00020\u001cH\u0014J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentFabView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pill", "Landroid/widget/LinearLayout;", "textView", "Landroid/widget/TextView;", "handler", "Landroid/os/Handler;", "texts", "", "", "currentIndex", "charCount", "deleting", "", "running", RemoteMessageConst.Notification.TICKER, "com/bytedance/ee/bear/bitable/superagent/BitableSuperAgentFabView$ticker$1", "Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentFabView$ticker$1;", "setCarouselTexts", "", "carouselTexts", "", "([Ljava/lang/String;)V", "start", "stop", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentFabView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f215740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f215741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f215742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f215743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f215744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f215745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f215746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f215747h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSuperAgentFabView f215748a;

        public final void a() {
            if (this.f215748a.f215742c.isEmpty() == false) goto L5;
            return;
        L5:
            BitableSuperAgentFabView r100 = this.f215748a;
            String r101 = (String) ListProtector.get(r100.f215742c, r100.f215743d);
            BitableSuperAgentFabView r102 = this.f215748a;
            if (r102.f215745f == false) goto L8;
        L10:
            BitableSuperAgentFabView r103 = this.f215748a;
            if (r103.f215745f == false) goto L13;
        L17:
            BitableSuperAgentFabView r104 = this.f215748a;
            if (r104.f215745f == false) goto L22;
            int r105 = r104.f215744e;
            if (r105 <= 0) goto L22;
            int r106 = r105 - 1;
            r104.f215744e = r106;
            r104.f215740a.setText(r101.substring(0, r106));
            this.f215748a.f215741b.postDelayed(this, 30);
            return;
        L22:
            r104.f215745f = false;
            r104.f215743d = (r104.f215743d + 1) % r104.f215742c.size();
            this.f215748a.f215741b.postDelayed(this, 300);
            return;
        L13:
            if (r103.f215744e != r101.length()) goto L17;
            if (this.f215748a.f215742c.size() <= 1) goto L25;
            BitableSuperAgentFabView r107 = this.f215748a;
            r107.f215745f = true;
            r107.f215741b.postDelayed(this, 1800);
            return;
        L25:
            return;
        L8:
            if (r102.f215744e >= r101.length()) goto L10;
            BitableSuperAgentFabView r108 = this.f215748a;
            int r109 = r108.f215744e + 1;
            r108.f215744e = r109;
            r108.f215740a.setText(r101.substring(0, r109));
            this.f215748a.f215741b.postDelayed(this, 60);
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

        public b(BitableSuperAgentFabView r100) {
            this.f215748a = r100;
        }
    }

    static {
    }

    public BitableSuperAgentFabView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableSuperAgentFabView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f215746g == false) goto L5;
        return;
    L5:
        if (this.f215742c.size() > 1) goto L8;
        return;
    L8:
        if (q.a().a() == false) goto L10;
        return;
    L10:
        this.f215746g = true;
        this.f215741b.post(this.f215747h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f215746g = false;
        this.f215741b.removeCallbacks(this.f215747h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    public final void setCarouselTexts(String[] r100) {
        this.f215746g = false;
        this.f215741b.removeCallbacks(this.f215747h);
        if (r100 == null) goto L13;
        ?? r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        String r104 = r100[r103];
        if (r104.length() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        r101.add(r104);
    L12:
        r103 = r103 + 1;
        goto L5
    L9:
        r105 = false;
    L14:
        if (r101 != 0) goto L16;
        r101 = CollectionsKt.emptyList();
    L16:
        this.f215742c = r101;
        this.f215743d = 0;
        this.f215744e = 0;
        this.f215745f = false;
        if (r101.isEmpty() == false) goto L20;
        this.f215740a.setText("");
        return;
    L20:
        if (this.f215742c.size() != 1) goto L22;
    L25:
        this.f215740a.setText((CharSequence) ListProtector.get(this.f215742c, 0));
        return;
    L22:
        if (q.a().a() == true) goto L25;
        a();
        return;
    L13:
        r101 = 0;
        goto L14
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L5;
        a();
        return;
    L5:
        this.f215746g = false;
        this.f215741b.removeCallbacks(this.f215747h);
    }

    public BitableSuperAgentFabView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f215741b = new Handler(Looper.getMainLooper());
        this.f215742c = CollectionsKt.emptyList();
        this.f215747h = new b(this);
        LayoutInflater.from(r100).inflate(R.layout.bitable_superagent_float_button, this, true);
        LinearLayout r103 = (LinearLayout) findViewById(R.id.bitable_superagent_float_root);
        this.f215740a = (TextView) findViewById(R.id.bitable_superagent_float_text);
    }

    public /* synthetic */ BitableSuperAgentFabView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
