package com.ss.android.lark.blueprint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
public final class BlueprintLayoutInflater extends LayoutInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f410627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f410628b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/blueprint/BlueprintLayoutInflater$InflateViewGroup;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "blueprint_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InflateViewGroup extends ViewGroup {
        public InflateViewGroup(Context r100, AttributeSet r101) {
            this(r100, r101, 4, 0);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        }

        public InflateViewGroup(Context r100, AttributeSet r101, int r102) {
            super(r100, r101, r102);
        }

        public /* synthetic */ InflateViewGroup(Context r100, AttributeSet r101, int r102, int r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, 0);
        }
    }

    public BlueprintLayoutInflater(Context r100) {
        super(r100);
        this.f410627a = LazyKt.lazy(new BlueprintLayoutInflater$viewGroup$2(this));
        this.f410628b = LazyKt.lazy(new BlueprintLayoutInflater$delegate$2(this));
    }

    public final View a(int r100) {
        return ((LayoutInflater) this.f410628b.getValue()).inflate(r100, (ViewGroup) this.f410627a.getValue(), false);
    }

    @Override // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context r100) {
        return new BlueprintLayoutInflater(this, r100);
    }

    public BlueprintLayoutInflater(LayoutInflater r100, Context r101) {
        super(r100, r101);
        this.f410627a = LazyKt.lazy(new BlueprintLayoutInflater$viewGroup$2(this));
        this.f410628b = LazyKt.lazy(new BlueprintLayoutInflater$delegate$2(this));
    }

    @Override // android.view.LayoutInflater
    public final View inflate(int r100, ViewGroup r101, boolean r102) {
        if (r102 == true) goto L7;
        if (r101 != null) goto L7;
        r101 = (ViewGroup) this.f410627a.getValue();
    L7:
        return ((LayoutInflater) this.f410628b.getValue()).inflate(r100, r101, r102);
    }
}
