package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J+\u0010\u000b\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/audio/AudioStrategy;", "", "strategyList", "Ljava/util/ArrayList;", "Lcom/larus/platform/model/audio/StrategyData;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getStrategyList", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioStrategy {

    @SerializedName("strategy_list")
    private final ArrayList<StrategyData> strategyList;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioStrategy() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AudioStrategy copy$default(AudioStrategy r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.strategyList;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<StrategyData> component1() {
        return this.strategyList;
    }

    public final AudioStrategy copy(ArrayList<StrategyData> r100) {
        return new AudioStrategy(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioStrategy) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.strategyList, ((AudioStrategy) r100).strategyList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ArrayList<StrategyData> r100 = this.strategyList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "AudioStrategy(strategyList=" + this.strategyList + ')';
    }

    public final ArrayList<StrategyData> getStrategyList() {
        return this.strategyList;
    }

    public AudioStrategy(ArrayList<StrategyData> r100) {
        this.strategyList = r100;
    }

    public /* synthetic */ AudioStrategy(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
