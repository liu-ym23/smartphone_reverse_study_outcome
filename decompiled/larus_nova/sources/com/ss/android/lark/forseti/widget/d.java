package com.ss.android.lark.forseti.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Sequence<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f424741a;

    public static final class a implements Iterator<View>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f424742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f424743b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f424742a >= this.f424743b.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final View next() {
            ViewGroup r100 = this.f424743b;
            int r101 = this.f424742a;
            this.f424742a = r101 + 1;
            View r102 = r100.getChildAt(r101);
            if (r102 == null) goto L6;
            return r102;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            ViewGroup r100 = this.f424743b;
            int r101 = this.f424742a - 1;
            this.f424742a = r101;
            r100.removeViewAt(r101);
        }

        public a(ViewGroup r100) {
            this.f424743b = r100;
        }
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<View> iterator() {
        return new a(this.f424741a);
    }

    public d(ViewGroup r100) {
        this.f424741a = r100;
    }
}
