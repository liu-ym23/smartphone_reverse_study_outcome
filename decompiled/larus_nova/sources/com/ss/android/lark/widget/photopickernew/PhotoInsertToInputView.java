package com.ss.android.lark.widget.photopickernew;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J \u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/widget/photopickernew/PhotoInsertToInputView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "requestedVisible", "", "overlayAboveAnchor", "showAfterLayoutPosted", "animateAfterLayout", "showAfterLayoutRunnable", "Ljava/lang/Runnable;", "setInsertVisible", "", "visible", "aboveAnchor", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "setOnInsertClickListener", "listener", "Landroid/view/View$OnClickListener;", "setEnabled", "enabled", "updateVisibility", "onDetachedFromWindow", "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoInsertToInputView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f447867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f447868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f447869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f447870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f447871e;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoInsertToInputView f447872a;

        public b(PhotoInsertToInputView r100) {
            this.f447872a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PhotoInsertToInputView r100 = this.f447872a;     // Catch: Throwable -> L6
            r100.f447869c = false;     // Catch: Throwable -> L6
            if (r100.f447867a == false) goto L9;
            r100.b(true, r100.f447868b, r100.f447870d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoInsertToInputView f447873a;

        public c(PhotoInsertToInputView r100) {
            this.f447873a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PhotoInsertToInputView r100 = this.f447873a;     // Catch: Throwable -> L6
            if (r100.f447867a == true) goto L9;
            r100.setVisibility(8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public PhotoInsertToInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhotoInsertToInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        animate().cancel();
        removeCallbacks(this.f447871e);
        this.f447869c = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        View r101 = findViewById(R.id.layout_photo_insert_message_action);
        if (r101 == null) goto L6;
        r101.setEnabled(r100);
        return;
    }

    public final void setOnInsertClickListener(View.OnClickListener r100) {
        View r101 = findViewById(R.id.layout_photo_insert_message_action);
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void a(boolean r100, boolean r101) {
        if (this.f447867a == r100) goto L5;
    L7:
        this.f447867a = r100;
        this.f447868b = false;
        animate().cancel();
        if (r100 == true) goto L10;
    L17:
        b(r100, false, r101);
        return;
    L10:
        if (isLaidOut() == true) goto L12;
    L13:
        setVisibility(4);
        this.f447870d = r101;
        if (this.f447869c == true) goto L19;
        this.f447869c = true;
        post(this.f447871e);
        return;
    L19:
        return;
    L12:
        if (getHeight() != 0) goto L17;
    L5:
        if (this.f447868b == true) goto L7;
    }

    public PhotoInsertToInputView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f447870d = true;
        this.f447871e = new b(this);
    }

    public final void b(boolean r100, boolean r101, boolean r102) {
        if (r101 == false) goto L4;
        float r103 = -getHeight();
    L5:
        float r104 = getHeight() + r103;
        if (r100 == false) goto L17;
        if (getVisibility() != 0) goto L11;
        setTranslationY(r103);
        return;
    L11:
        setVisibility(0);
        setTranslationY(r104);
        if (r102 == false) goto L14;
        animate().translationY(r103).setDuration(200).setInterpolator(new DecelerateInterpolator()).start();
        return;
    L14:
        setTranslationY(r103);
        return;
    L17:
        if (getVisibility() == 0) goto L20;
        setVisibility(8);
        setTranslationY(r104);
        return;
    L20:
        if (r102 == false) goto L22;
        animate().translationY(r104).setDuration(200).setInterpolator(new DecelerateInterpolator()).withEndAction(new c(this)).start();
        return;
    L22:
        setTranslationY(r104);
        setVisibility(8);
        return;
    L4:
        r103 = 0.0f;
        goto L5
    }

    public /* synthetic */ PhotoInsertToInputView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
