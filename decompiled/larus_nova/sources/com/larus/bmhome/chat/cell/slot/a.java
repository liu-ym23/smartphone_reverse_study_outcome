package com.larus.bmhome.chat.cell.slot;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements ed8.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatCheckBox f297763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GestureDetector f297764b;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.cell.slot.a$a, reason: collision with other inner class name */
    public static final class C4028a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f297765a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return true;
        }

        public C4028a(a r100) {
            this.f297765a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f297765a.f297763a.performClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f297765a.f297763a.performClick();
            return true;
        }
    }

    @Override // ed8.e
    public final boolean c() {
        return this.f297763a.getInterceptTouchEvent();
    }

    @Override // ed8.e
    public final GestureDetector b() {
        return this.f297764b;
    }

    public a(ChatCheckBox r100) {
        Intrinsics.checkNotNullParameter(r100, "chatCheckBox");
        this.f297763a = r100;
        this.f297764b = new GestureDetector(r100.getContext(), new C4028a(this));
    }

    @Override // ed8.e
    public final boolean a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f297763a.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
