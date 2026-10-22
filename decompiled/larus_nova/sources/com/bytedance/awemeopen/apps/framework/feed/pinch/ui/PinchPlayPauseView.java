package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/PinchPlayPauseView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getPlayIcon", "()I", "setPlayIcon", "(I)V", "playIcon", "b", "getPauseIcon", "setPauseIcon", "pauseIcon", "c", "getNewPauseIcon", "setNewPauseIcon", "newPauseIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PinchPlayPauseView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f195777d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f195778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f195779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f195780c;

    public PinchPlayPauseView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinchPlayPauseView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getNewPauseIcon() {
        return this.f195780c;
    }

    public final int getPauseIcon() {
        return this.f195779b;
    }

    public final int getPlayIcon() {
        return this.f195778a;
    }

    public final void l(int r100) {
        int r101 = this.f195778a;
        Integer r102 = Integer.valueOf(r100);
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (r101 == (-1)) goto L23;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        if (r102 != null) goto L8;
    L14:
        setImageResource(r101);     // Catch: Throwable -> L17
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L17
    L19:
        Result.m9452exceptionOrNullimpl(r105);
        return;
    L8:
        if (r102.intValue() == (-1)) goto L14;
        Drawable r106 = ContextCompat.getDrawable(getContext(), r101);     // Catch: Throwable -> L17
        if (r106 == null) goto L13;
        Drawable r107 = DrawableCompat.wrap(r106).mutate();     // Catch: Throwable -> L17
        DrawableCompat.setTint(r107, ContextCompat.getColor(getContext(), r102.intValue()));     // Catch: Throwable -> L17
        setImageDrawable(r107);     // Catch: Throwable -> L17
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L17
        goto L15
    L13:
        r104 = null;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final void setNewPauseIcon(int r100) {
        this.f195780c = r100;
    }

    public final void setPauseIcon(int r100) {
        this.f195779b = r100;
    }

    public final void setPlayIcon(int r100) {
        this.f195778a = r100;
    }

    public static void j(final PinchPlayPauseView r100, final r0 r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "handler");
        final boolean r102 = true;
        r100.setOnClickListener(new a(r102, r100, r101));
        r100.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
    }

    public PinchPlayPauseView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f195778a = R.drawable.ic_s_s_play_filled;
        this.f195779b = R.drawable.familiar_pinch_pause_btn;
        this.f195780c = R.drawable.familiar_pinch_pause_btn_new;
    }

    public /* synthetic */ PinchPlayPauseView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
