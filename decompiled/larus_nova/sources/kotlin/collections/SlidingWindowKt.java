package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Iterator<T> $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(int r100, int r101, Iterator<? extends T> r102, boolean r103, boolean r104, Continuation<? super AnonymousClass1> r105) {
            this.$size = r100;
            this.$step = r101;
            this.$iterator = r102;
            this.$reuseBuffer = r103;
            this.$partialWindows = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
            AnonymousClass1 r101 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, r110);
            r101.L$0 = r100;
            return r101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
            return invoke((SequenceScope) r100, r101);
        }

        public final Object invoke(SequenceScope<? super List<? extends T>> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a6 -> B:16:0x0058). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011d -> B:59:0x0120). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x014b -> B:72:0x014e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L17;
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L14;
            if (r101 == 3) goto L13;
            if (r101 == 4) goto L12;
            if (r101 == 5) goto L14;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            RingBuffer r102 = (RingBuffer) this.L$1;
            SequenceScope r103 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            AnonymousClass1<T> r111 = this;
        L72:
            r102.removeFirst(r111.$step);
        L64:
            if (r102.size() <= r111.$step) goto L74;
            if (r111.$reuseBuffer == false) goto L68;
            RandomAccess r104 = r102;
        L69:
            r111.L$0 = r103;
            r111.L$1 = r102;
            r111.L$2 = null;
            r111.label = 4;
            if (r103.yield(r104, r111) != r100) goto L72;
            return r100;
        L68:
            r104 = new ArrayList(r102);
            goto L69
        L74:
            if ((!r102.isEmpty()) == false) goto L79;
            r111.L$0 = null;
            r111.L$1 = null;
            r111.L$2 = null;
            r111.label = 5;
            if (r103.yield(r102, r111) != r100) goto L79;
            return r100;
        L79:
            return Unit.INSTANCE;
        L13:
            Iterator<T> r105 = (Iterator) this.L$2;
            RingBuffer r106 = (RingBuffer) this.L$1;
            SequenceScope r107 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            r111 = this;
        L59:
            r106.removeFirst(r111.$step);
        L46:
            if (r105.hasNext() == false) goto L61;
            r106.add(r105.next());
            if (r106.isFull() == false) goto L46;
            int r108 = r106.size();
            int r112 = r111.$size;
            if (r108 >= r112) goto L53;
            r106 = r106.expanded(r112);
            goto L46
        L53:
            if (r111.$reuseBuffer == false) goto L55;
            RandomAccess r109 = r106;
        L56:
            r111.L$0 = r107;
            r111.L$1 = r106;
            r111.L$2 = r105;
            r111.label = 3;
            if (r107.yield(r109, r111) != r100) goto L59;
            return r100;
        L55:
            r109 = new ArrayList(r106);
            goto L56
        L61:
            if (r111.$partialWindows == false) goto L79;
            r102 = r106;
            r103 = r107;
        L14:
            ResultKt.throwOnFailure(r110);
            goto L79
        L15:
            int r113 = this.I$0;
            Iterator<T> r114 = (Iterator) this.L$2;
            ArrayList r115 = (ArrayList) this.L$1;
            SequenceScope r116 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            AnonymousClass1<T> r117 = this;
        L16:
            int r118 = r113;
            if (r117.$reuseBuffer == false) goto L33;
            r115.clear();
        L34:
            r113 = r118;
        L21:
            if (r114.hasNext() == false) goto L36;
            T r119 = r114.next();
            if (r118 > 0) goto L24;
            r115.add(r119);
            if (r115.size() != r117.$size) goto L21;
            r117.L$0 = r116;
            r117.L$1 = r115;
            r117.L$2 = r114;
            r117.I$0 = r113;
            r117.label = 1;
            if (r116.yield(r115, r117) != r100) goto L16;
            return r100;
        L24:
            r118 = r118 - 1;
            goto L21
        L36:
            if ((!r115.isEmpty()) == false) goto L79;
            if (r117.$partialWindows == false) goto L40;
        L41:
            r117.L$0 = null;
            r117.L$1 = null;
            r117.L$2 = null;
            r117.label = 2;
            if (r116.yield(r115, r117) != r100) goto L79;
            return r100;
        L40:
            if (r115.size() != r117.$size) goto L79;
        L33:
            r115 = new ArrayList(r117.$size);
            goto L34
        L17:
            ResultKt.throwOnFailure(r110);
            SequenceScope r120 = (SequenceScope) this.L$0;
            int r121 = RangesKt.coerceAtMost(this.$size, 1024);
            int r122 = this.$step - this.$size;
            if (r122 < 0) goto L44;
            r116 = r120;
            r115 = new ArrayList(r121);
            r118 = 0;
            r114 = this.$iterator;
            r113 = r122;
            r117 = this;
            goto L21
        L44:
            r106 = new RingBuffer(r121);
            r105 = this.$iterator;
            r107 = r120;
            r111 = this;
            goto L46
        }
    }

    public static final void checkWindowSizeStep(int r100, int r101) {
        if (r100 <= 0) goto L5;
        if (r101 <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (r100 == r101) goto L10;
        String r103 = "Both size " + r100 + " and step " + r101 + " must be greater than zero.";
    L12:
        throw new IllegalArgumentException(r103.toString());
    L10:
        r103 = "size " + r100 + " must be greater than zero.";
    L5:
        r102 = false;
        goto L6
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> r100, int r101, int r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "iterator");
        if (r100.hasNext() == true) goto L7;
        return EmptyIterator.INSTANCE;
    L7:
        return SequencesKt.iterator(new AnonymousClass1(r101, r110, r100, r112, r111, null));
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> r100, final int r101, final int r102, final boolean r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        checkWindowSizeStep(r101, r102);
        return new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(r100, r101, r102, r110, r111);
    }
}
