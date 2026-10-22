package com.larksuite.component.card.protocol.data;

import com.ss.android.vesdk.VECameraSettings$Parameters$NoiseReduce;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/card/protocol/data/StreamingConfig;", "Ljava/io/Serializable;", "printStrategy", "Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "printFrequencyMs", "", "printStep", "<init>", "(Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;II)V", "getPrintStrategy", "()Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "getPrintFrequencyMs", "()I", "getPrintStep", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "PrintStrategy", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamingConfig implements Serializable {
    private final int printFrequencyMs;
    private final int printStep;
    private final PrintStrategy printStrategy;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FAST", "DELAY", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PrintStrategy extends Enum<PrintStrategy> implements Serializable {
        public static final PrintStrategy DELAY = null;
        public static final PrintStrategy FAST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrintStrategy[] f283900a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283901b = null;
        private final String value;

        public static EnumEntries<PrintStrategy> getEntries() {
            return f283901b;
        }

        static {
            PrintStrategy r100 = new PrintStrategy("FAST", 0, VECameraSettings$Parameters$NoiseReduce.FAST);
            FAST = r100;
            PrintStrategy r101 = new PrintStrategy("DELAY", 1, "delay");
            DELAY = r101;
            PrintStrategy[] r102 = {r100, r101};
            f283900a = r102;
            f283901b = EnumEntriesKt.enumEntries(r102);
        }

        public static PrintStrategy[] values() {
            return (PrintStrategy[]) f283900a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static PrintStrategy valueOf(String r100) {
            return (PrintStrategy) a.a(PrintStrategy.class, r100);
        }

        public PrintStrategy(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public StreamingConfig() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ StreamingConfig copy$default(StreamingConfig r100, PrintStrategy r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.printStrategy;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.printFrequencyMs;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.printStep;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final PrintStrategy component1() {
        return this.printStrategy;
    }

    public final int component2() {
        return this.printFrequencyMs;
    }

    public final int component3() {
        return this.printStep;
    }

    public final StreamingConfig copy(PrintStrategy r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "printStrategy");
        return new StreamingConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StreamingConfig) == true) goto L8;
        return false;
    L8:
        StreamingConfig r101 = (StreamingConfig) r100;
        if (this.printStrategy == r101.printStrategy) goto L12;
        return false;
    L12:
        if (this.printFrequencyMs == r101.printFrequencyMs) goto L15;
        return false;
    L15:
        if (this.printStep == r101.printStep) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.printStrategy.hashCode() * 31) + this.printFrequencyMs) * 31) + this.printStep;
    }

    public String toString() {
        return "StreamingConfig(printStrategy=" + this.printStrategy + ", printFrequencyMs=" + this.printFrequencyMs + ", printStep=" + this.printStep + ')';
    }

    public final int getPrintFrequencyMs() {
        return this.printFrequencyMs;
    }

    public final int getPrintStep() {
        return this.printStep;
    }

    public final PrintStrategy getPrintStrategy() {
        return this.printStrategy;
    }

    public StreamingConfig(PrintStrategy r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "printStrategy");
        this.printStrategy = r100;
        this.printFrequencyMs = r101;
        this.printStep = r102;
    }

    public /* synthetic */ StreamingConfig(PrintStrategy r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = PrintStrategy.FAST;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
