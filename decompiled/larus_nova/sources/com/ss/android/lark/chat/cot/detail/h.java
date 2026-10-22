package com.ss.android.lark.chat.cot.detail;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f414976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f414977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CotDetailBlueprintAdapter f414978c;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getActionMasked() != 1) goto L7;
        c.b(this.f414976a, this.f414977b, this.f414978c, r100);
        return false;
    L7:
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        c.b(this.f414976a, this.f414977b, this.f414978c, r100);
        return false;
    }

    public h(c r100, RecyclerView r101, CotDetailBlueprintAdapter r102) {
        this.f414976a = r100;
        this.f414977b = r101;
        this.f414978c = r102;
    }
}
