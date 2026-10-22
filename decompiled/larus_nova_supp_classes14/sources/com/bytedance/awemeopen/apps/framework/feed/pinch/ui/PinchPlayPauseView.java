package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/PinchPlayPauseView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "a", "I", "getPlayIcon", "()I", "setPlayIcon", "(I)V", "playIcon", "b", "getPauseIcon", "setPauseIcon", "pauseIcon", "c", "getNewPauseIcon", "setNewPauseIcon", "newPauseIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PinchPlayPauseView extends AppCompatImageView {
    public static final /* synthetic */ int d = 0;
    public int a;
    public int b;
    public int c;

    public PinchPlayPauseView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinchPlayPauseView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int getNewPauseIcon() {
        return this.c;
    }

    public final int getPauseIcon() {
        return this.b;
    }

    public final int getPlayIcon() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(int r4) {
        int r0 = this.a;
        Integer r5 = Integer.valueOf(r4);
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (r0 == (-1)) goto L23;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        if (r5 != null) goto L8;
    L14:
        setImageResource(r0);     // Catch: Throwable -> L17
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L17
    L19:
        Result.exceptionOrNull-impl(r7);
        return;
    L8:
        if (r5.intValue() == (-1)) goto L14;
        Drawable r1 = ContextCompat.getDrawable(getContext(), r0);     // Catch: Throwable -> L17
        if (r1 == null) goto L13;
        Drawable r3 = DrawableCompat.wrap(r1).mutate();     // Catch: Throwable -> L17
        DrawableCompat.setTint(r3, ContextCompat.getColor(getContext(), r5.intValue()));     // Catch: Throwable -> L17
        setImageDrawable(r3);     // Catch: Throwable -> L17
        r6 = Unit.INSTANCE;     // Catch: Throwable -> L17
        goto L15
    L13:
        r6 = null;
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final void setNewPauseIcon(int r1) {
        this.c = r1;
    }

    public final void setPauseIcon(int r1) {
        this.b = r1;
    }

    public final void setPlayIcon(int r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(final PinchPlayPauseView r2, final r0 r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "handler");
        final boolean r1 = true;
        r2.setOnClickListener(new a(r1, r2, r3));
        r2.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
    }

    public PinchPlayPauseView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = 2131237006;
        this.b = 2131235338;
        this.c = 2131235339;
    }

    public /* synthetic */ PinchPlayPauseView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
