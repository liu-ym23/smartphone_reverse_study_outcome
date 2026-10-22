package com.larksuite.component.card.protocol.context;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.component.card.protocol.CardRenderData;
import com.larksuite.component.card.protocol.data.StreamingConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/larksuite/component/card/protocol/context/StreamingState;", "Ljava/io/Serializable;", "printStrategy", "Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "streamingPhase", "Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "pendingStreamingData", "Lcom/larksuite/component/card/protocol/CardRenderData;", "<init>", "(Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;Lcom/larksuite/component/card/protocol/CardRenderData;)V", "getPrintStrategy", "()Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "setPrintStrategy", "(Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;)V", "getStreamingPhase", "()Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "setStreamingPhase", "(Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;)V", "getPendingStreamingData", "()Lcom/larksuite/component/card/protocol/CardRenderData;", "setPendingStreamingData", "(Lcom/larksuite/component/card/protocol/CardRenderData;)V", BasicTestActionHandler.TEST_ACTION_RESET, "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "StreamingPhase", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamingState implements Serializable {
    private CardRenderData pendingStreamingData;
    private StreamingConfig.PrintStrategy printStrategy;
    private StreamingPhase streamingPhase;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "IN_STREAMING", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StreamingPhase extends Enum<StreamingPhase> implements Serializable {
        public static final StreamingPhase IDLE = null;
        public static final StreamingPhase IN_STREAMING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StreamingPhase[] f283897a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283898b = null;

        public static EnumEntries<StreamingPhase> getEntries() {
            return f283898b;
        }

        static {
            StreamingPhase r100 = new StreamingPhase("IDLE", 0);
            IDLE = r100;
            StreamingPhase r101 = new StreamingPhase("IN_STREAMING", 1);
            IN_STREAMING = r101;
            StreamingPhase[] r102 = {r100, r101};
            f283897a = r102;
            f283898b = EnumEntriesKt.enumEntries(r102);
        }

        public static StreamingPhase[] values() {
            return (StreamingPhase[]) f283897a.clone();
        }

        public static StreamingPhase valueOf(String r100) {
            return (StreamingPhase) a.a(StreamingPhase.class, r100);
        }

        public StreamingPhase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public StreamingState() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StreamingState copy$default(StreamingState r100, StreamingConfig.PrintStrategy r101, StreamingPhase r102, CardRenderData r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.printStrategy;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.streamingPhase;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pendingStreamingData;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final StreamingConfig.PrintStrategy component1() {
        return this.printStrategy;
    }

    public final StreamingPhase component2() {
        return this.streamingPhase;
    }

    public final CardRenderData component3() {
        return this.pendingStreamingData;
    }

    public final StreamingState copy(StreamingConfig.PrintStrategy r100, StreamingPhase r101, CardRenderData r102) {
        Intrinsics.checkNotNullParameter(r100, "printStrategy");
        Intrinsics.checkNotNullParameter(r101, "streamingPhase");
        return new StreamingState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StreamingState) == true) goto L8;
        return false;
    L8:
        StreamingState r101 = (StreamingState) r100;
        if (this.printStrategy == r101.printStrategy) goto L12;
        return false;
    L12:
        if (this.streamingPhase == r101.streamingPhase) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pendingStreamingData, r101.pendingStreamingData) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.printStrategy.hashCode() * 31) + this.streamingPhase.hashCode()) * 31;
        CardRenderData r101 = this.pendingStreamingData;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "StreamingState(printStrategy=" + this.printStrategy + ", streamingPhase=" + this.streamingPhase + ", pendingStreamingData=" + this.pendingStreamingData + ')';
    }

    public final void reset() {
        this.streamingPhase = StreamingPhase.IDLE;
        this.pendingStreamingData = null;
    }

    public final CardRenderData getPendingStreamingData() {
        return this.pendingStreamingData;
    }

    public final StreamingConfig.PrintStrategy getPrintStrategy() {
        return this.printStrategy;
    }

    public final StreamingPhase getStreamingPhase() {
        return this.streamingPhase;
    }

    public final void setPendingStreamingData(CardRenderData r100) {
        this.pendingStreamingData = r100;
    }

    public final void setPrintStrategy(StreamingConfig.PrintStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.printStrategy = r100;
    }

    public final void setStreamingPhase(StreamingPhase r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamingPhase = r100;
    }

    public StreamingState(StreamingConfig.PrintStrategy r100, StreamingPhase r101, CardRenderData r102) {
        Intrinsics.checkNotNullParameter(r100, "printStrategy");
        Intrinsics.checkNotNullParameter(r101, "streamingPhase");
        this.printStrategy = r100;
        this.streamingPhase = r101;
        this.pendingStreamingData = r102;
    }

    public /* synthetic */ StreamingState(StreamingConfig.PrintStrategy r100, StreamingPhase r101, CardRenderData r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = StreamingConfig.PrintStrategy.FAST;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = StreamingPhase.IDLE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
