package com.bytedance.ies.xelement.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017Ja\u0010\r\u001a\u00020\u000b2Y\u0010\f\u001aU\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/xelement/view/PlaySeeker;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "state", "", "", "data", "view", "", "reporter", "setStateReporter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "x-element-video_release"}, k = 1, mv = {1, 6, 0})
public final class PlaySeeker extends AppCompatSeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function3<? super String, ? super Map<String, ? extends Object>, ? super PlaySeeker, Unit> f250426a;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlaySeeker f250427a;

        public a(PlaySeeker r100) {
            this.f250427a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            if (r100 == null) goto L4;
            int r101 = r100.getProgress();
        L5:
            this.f250427a.b("seekbegin", MapsKt.mapOf(TuplesKt.to("currentDuration", Integer.valueOf(r101))));
            return;
        L4:
            r101 = 0;
            goto L5
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            if (r100 == null) goto L4;
            int r101 = r100.getProgress();
        L5:
            this.f250427a.b("seekend", MapsKt.mapOf(TuplesKt.to("currentDuration", Integer.valueOf(r101))));
            return;
        L4:
            r101 = 0;
            goto L5
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            if (r100 == null) goto L4;
            int r103 = r100.getProgress();
        L5:
            this.f250427a.b("seekchanged", MapsKt.mapOf(TuplesKt.to("currentDuration", Integer.valueOf(r103))));
            return;
        L4:
            r103 = 0;
            goto L5
        }
    }

    public final void a() {
        getThumb().clearColorFilter();
        getProgressDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        getThumb().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        setOnSeekBarChangeListener(new a(this));
    }

    public PlaySeeker(Context r100) {
        new LinkedHashMap();
        super(r100);
        a();
    }

    public final void setStateReporter(Function3<? super String, ? super Map<String, ? extends Object>, ? super PlaySeeker, Unit> r100) {
        this.f250426a = r100;
    }

    public PlaySeeker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        new LinkedHashMap();
        super(r100, r101);
        a();
    }

    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "data");
        Function3<? super String, ? super Map<String, ? extends Object>, ? super PlaySeeker, Unit> r102 = this.f250426a;
        if (r102 == null) goto L6;
        r102.invoke(r100, r101, this);
        return;
    }

    public PlaySeeker(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        new LinkedHashMap();
        super(r100, r101, r102);
        a();
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
