package com.ss.android.lark.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes38.dex */
public class PullDownRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f448179a;

    public class a extends com.ss.android.lark.widget.util.b {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ PullDownRecyclerView f448180k;

        @Override // com.ss.android.lark.widget.util.b
        public final boolean a() {
            return false;
        }

        public a(PullDownRecyclerView r100) {
            this.f448180k = r100;
        }

        @Override // com.ss.android.lark.widget.util.b
        public final boolean c(int r100, MotionEvent r101) {
            if (this.f448180k.canScrollVertically(-1) == false) goto L5;
            return false;
        L5:
            if (r100 != 8) goto L12;
            b r102 = this.f448180k.f448179a;
            if (r102 == null) goto L13;
            r102.a(r101);
            return false;
        L13:
            return false;
        L12:
            return false;
        }

        @Override // com.ss.android.lark.widget.util.b
        public final boolean b(int r100, int r101, MotionEvent r102) {
            if (this.f448180k.canScrollVertically(-1) == false) goto L5;
            return false;
        L5:
            if (r100 != 8) goto L12;
            b r103 = this.f448180k.f448179a;
            if (r103 == null) goto L13;
            r103.b(r102);
            return true;
        L13:
            return false;
        L12:
            return false;
        }
    }

    public interface b {
        void a(MotionEvent r100);

        void b(MotionEvent r100);
    }

    public PullDownRecyclerView(Context r100) {
        this(r100, null);
    }

    public void setOnPullDownListener(b r100) {
        this.f448179a = r100;
    }

    public PullDownRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public PullDownRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setOnTouchListener(new a(this));
    }
}
