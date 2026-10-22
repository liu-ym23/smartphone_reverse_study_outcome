package com.ttnet.org.chromium.base;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class ObserverList<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int mCount;
    private boolean mEnableThreadAsserts;
    private int mIterationDepth;
    private boolean mNeedsCompact;
    public final List<E> mObservers;
    private final ThreadUtils.ThreadChecker mThreadChecker;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.ObserverList$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ObserverListIterator implements RewindableIterator<E> {
        private int mIndex;
        private boolean mIsExhausted;
        private int mListEndMarker;
        final /* synthetic */ ObserverList this$0;

        private void compactListIfNeeded() {
            if (this.mIsExhausted == true) goto L6;
            this.mIsExhausted = true;
            ObserverList.access$600(this.this$0);
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (ObserverList.access$300(this.this$0) == false) goto L5;
            ObserverList.access$400(this.this$0).assertOnValidThread();
        L5:
            int r100 = this.mIndex;
        L7:
            if (r100 >= this.mListEndMarker) goto L12;
            if (ObserverList.access$500(this.this$0, r100) != null) goto L12;
            r100 = r100 + 1;
        L12:
            if (r100 >= this.mListEndMarker) goto L15;
            return true;
        L15:
            compactListIfNeeded();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (ObserverList.access$300(this.this$0) == false) goto L5;
            ObserverList.access$400(this.this$0).assertOnValidThread();
        L5:
            int r100 = this.mIndex;
            if (r100 >= this.mListEndMarker) goto L10;
            if (ObserverList.access$500(this.this$0, r100) != null) goto L10;
            this.mIndex++;
        L10:
            int r101 = this.mIndex;
            if (r101 >= this.mListEndMarker) goto L14;
            ObserverList r102 = this.this$0;
            this.mIndex = r101 + 1;
            return (E) ObserverList.access$500(r102, r101);
        L14:
            compactListIfNeeded();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // com.ttnet.org.chromium.base.ObserverList.RewindableIterator
        public void rewind() {
            if (ObserverList.access$300(this.this$0) == false) goto L5;
            ObserverList.access$400(this.this$0).assertOnValidThread();
        L5:
            compactListIfNeeded();
            ObserverList.access$100(this.this$0);
            this.mListEndMarker = ObserverList.access$200(this.this$0);
            this.mIsExhausted = false;
            this.mIndex = 0;
        }

        private ObserverListIterator(ObserverList r100) {
            this.this$0 = r100;
            ObserverList.access$100(r100);
            this.mListEndMarker = ObserverList.access$200(r100);
        }

        public /* synthetic */ ObserverListIterator(ObserverList r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public interface RewindableIterator<E> extends Iterator<E> {
        void rewind();
    }

    public void disableThreadAsserts() {
        this.mEnableThreadAsserts = false;
    }

    private int capacity() {
        return this.mObservers.size();
    }

    private void compact() {
        int r100 = this.mObservers.size() - 1;
    L3:
        if (r100 < 0) goto L8;
        if (ListProtector.get(this.mObservers, r100) != null) goto L7;
        ListProtector.remove(this.mObservers, r100);
    L7:
        r100 = r100 - 1;
        goto L3
    }

    private void decrementIterationDepthAndCompactIfNeeded() {
        int r100 = this.mIterationDepth - 1;
        this.mIterationDepth = r100;
        if (r100 <= 0) goto L6;
        return;
    L6:
        if (this.mNeedsCompact == true) goto L8;
        return;
    L8:
        this.mNeedsCompact = false;
        compact();
    }

    private void incrementIterationDepth() {
        this.mIterationDepth++;
    }

    public void clear() {
        if (this.mEnableThreadAsserts == false) goto L5;
        this.mThreadChecker.assertOnValidThread();
    L5:
        int r100 = 0;
        this.mCount = 0;
        if (this.mIterationDepth != 0) goto L9;
        this.mObservers.clear();
        return;
    L9:
        int r101 = this.mObservers.size();
        boolean r102 = this.mNeedsCompact;
        if (r101 == 0) goto L12;
        boolean r103 = true;
    L13:
        this.mNeedsCompact = r102 | r103;
    L14:
        if (r100 >= r101) goto L16;
        ListProtector.set(this.mObservers, r100, null);
        r100 = r100 + 1;
        goto L14
    L16:
        return;
    L12:
        r103 = false;
        goto L13
    }

    public boolean isEmpty() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        if (this.mCount != 0) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return new ObserverListIterator(this, null);
    }

    public RewindableIterator<E> rewindableIterator() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return new ObserverListIterator(this, null);
    }

    public int size() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return this.mCount;
    }

    public ObserverList() {
        this.mObservers = new ArrayList();
        this.mEnableThreadAsserts = true;
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
    }

    static {
    }

    public static /* synthetic */ void access$100(ObserverList r100) {
        r100.incrementIterationDepth();
    }

    public static /* synthetic */ int access$200(ObserverList r100) {
        return r100.capacity();
    }

    public static /* synthetic */ boolean access$300(ObserverList r100) {
        return r100.mEnableThreadAsserts;
    }

    public static /* synthetic */ ThreadUtils.ThreadChecker access$400(ObserverList r100) {
        return r100.mThreadChecker;
    }

    public static /* synthetic */ void access$600(ObserverList r100) {
        r100.decrementIterationDepthAndCompactIfNeeded();
    }

    private E getObserverAt(int r100) {
        return (E) ListProtector.get(this.mObservers, r100);
    }

    public boolean addObserver(E r100) {
        if (this.mEnableThreadAsserts == false) goto L5;
        this.mThreadChecker.assertOnValidThread();
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (this.mObservers.contains(r100) == true) goto L13;
        this.mObservers.add(r100);
        this.mCount++;
        return true;
    L13:
        return false;
    }

    public boolean hasObserver(E r100) {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return this.mObservers.contains(r100);
    }

    public boolean removeObserver(E r100) {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        int r101 = this.mObservers.indexOf(r100);
        if (r101 != (-1)) goto L12;
        return false;
    L12:
        if (this.mIterationDepth != 0) goto L14;
        ListProtector.remove(this.mObservers, r101);
    L15:
        this.mCount--;
        return true;
    L14:
        this.mNeedsCompact = true;
        ListProtector.set(this.mObservers, r101, null);
        goto L15
    }

    public static /* synthetic */ Object access$500(ObserverList r100, int r101) {
        return r100.getObserverAt(r101);
    }
}
