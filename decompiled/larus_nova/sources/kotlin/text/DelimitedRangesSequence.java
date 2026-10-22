package kotlin.text;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.byted.cast.common.TeaEventTrack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DelimitedRangesSequence implements Sequence<IntRange> {
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
    private final CharSequence input;
    private final int limit;
    private final int startIndex;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<IntRange>, KMappedMarker {
        private int counter;
        private int currentStartIndex;
        private IntRange nextItem;
        private int nextSearchIndex;
        private int nextState;
        final /* synthetic */ DelimitedRangesSequence this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        private final void calcNext() {
            int r100 = 0;
            if (this.nextSearchIndex >= 0) goto L6;
            this.nextState = 0;
            this.nextItem = null;
            return;
        L6:
            if (DelimitedRangesSequence.access$getLimit$p(this.this$0) <= 0) goto L10;
            int r101 = this.counter + 1;
            this.counter = r101;
            if (r101 < DelimitedRangesSequence.access$getLimit$p(this.this$0)) goto L10;
        L11:
            this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
            this.nextSearchIndex = -1;
        L19:
            this.nextState = 1;
            return;
        L10:
            if (this.nextSearchIndex > DelimitedRangesSequence.access$getInput$p(this.this$0).length()) goto L11;
            Pair r102 = (Pair) DelimitedRangesSequence.access$getGetNextMatch$p(this.this$0).invoke(DelimitedRangesSequence.access$getInput$p(this.this$0), Integer.valueOf(this.nextSearchIndex));
            if (r102 != null) goto L15;
            this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.access$getInput$p(this.this$0)));
            this.nextSearchIndex = -1;
            goto L19
        L15:
            int r103 = ((Number) r102.component1()).intValue();
            int r104 = ((Number) r102.component2()).intValue();
            this.nextItem = RangesKt.until(this.currentStartIndex, r103);
            int r105 = r103 + r104;
            this.currentStartIndex = r105;
            if (r104 != 0) goto L18;
            r100 = 1;
        L18:
            this.nextSearchIndex = r105 + r100;
            goto L19
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState != (-1)) goto L6;
            calcNext();
        L6:
            if (this.nextState == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public IntRange next2() {
            if (this.nextState != (-1)) goto L6;
            calcNext();
        L6:
            if (this.nextState == 0) goto L10;
            IntRange r100 = this.nextItem;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return r100;
        L10:
            throw new NoSuchElementException();
        }

        public final int getCounter() {
            return this.counter;
        }

        public final int getCurrentStartIndex() {
            return this.currentStartIndex;
        }

        public final IntRange getNextItem() {
            return this.nextItem;
        }

        public final int getNextSearchIndex() {
            return this.nextSearchIndex;
        }

        public final int getNextState() {
            return this.nextState;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ IntRange next() {
            return next2();
        }

        public AnonymousClass1(DelimitedRangesSequence r100) {
            this.this$0 = r100;
            this.nextState = -1;
            int r101 = RangesKt.coerceIn(DelimitedRangesSequence.access$getStartIndex$p(r100), 0, DelimitedRangesSequence.access$getInput$p(r100).length());
            this.currentStartIndex = r101;
            this.nextSearchIndex = r101;
        }

        public final void setCounter(int r100) {
            this.counter = r100;
        }

        public final void setCurrentStartIndex(int r100) {
            this.currentStartIndex = r100;
        }

        public final void setNextItem(IntRange r100) {
            this.nextItem = r100;
        }

        public final void setNextSearchIndex(int r100) {
            this.nextSearchIndex = r100;
        }

        public final void setNextState(int r100) {
            this.nextState = r100;
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new AnonymousClass1(this);
    }

    public static final /* synthetic */ Function2 access$getGetNextMatch$p(DelimitedRangesSequence r100) {
        return r100.getNextMatch;
    }

    public static final /* synthetic */ CharSequence access$getInput$p(DelimitedRangesSequence r100) {
        return r100.input;
    }

    public static final /* synthetic */ int access$getLimit$p(DelimitedRangesSequence r100) {
        return r100.limit;
    }

    public static final /* synthetic */ int access$getStartIndex$p(DelimitedRangesSequence r100) {
        return r100.startIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence r100, int r101, int r102, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> r103) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r103, "getNextMatch");
        this.input = r100;
        this.startIndex = r101;
        this.limit = r102;
        this.getNextMatch = r103;
    }
}
