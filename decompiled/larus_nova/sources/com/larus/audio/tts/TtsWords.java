package com.larus.audio.tts;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/audio/tts/TtsWords;", "Ljava/io/Serializable;", BitableAnalytic.LocationClickType.WORDS, "", "Lcom/larus/audio/tts/TtsWord;", "<init>", "(Ljava/util/List;)V", "getWords", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsWords implements Serializable {

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private final List<TtsWord> words;

    /* JADX WARN: Multi-variable type inference failed */
    public TtsWords() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TtsWords copy$default(TtsWords r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.words;
    L6:
        return r100.copy(r101);
    }

    public final List<TtsWord> component1() {
        return this.words;
    }

    public final TtsWords copy(List<TtsWord> r100) {
        return new TtsWords(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TtsWords) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.words, ((TtsWords) r100).words) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<TtsWord> r100 = this.words;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "TtsWords(words=" + this.words + ')';
    }

    public final List<TtsWord> getWords() {
        return this.words;
    }

    public TtsWords(List<TtsWord> r100) {
        this.words = r100;
    }

    public /* synthetic */ TtsWords(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        this(r100);
    }
}
