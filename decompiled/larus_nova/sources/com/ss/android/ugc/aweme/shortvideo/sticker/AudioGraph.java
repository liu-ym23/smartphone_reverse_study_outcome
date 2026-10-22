package com.ss.android.ugc.aweme.shortvideo.sticker;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ,\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/sticker/AudioGraph;", "Ljava/io/Serializable;", "sources", "", "", "useOutput", "", "([Ljava/lang/String;Ljava/lang/Boolean;)V", "getSources", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getUseOutput", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "([Ljava/lang/String;Ljava/lang/Boolean;)Lcom/ss/android/ugc/aweme/shortvideo/sticker/AudioGraph;", "enableMic", "enableMusic", "equals", "other", "", "hashCode", "", "toString", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class AudioGraph implements Serializable {

    @SerializedName("sources")
    private final String[] sources;

    @SerializedName("use_output")
    private final Boolean useOutput;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioGraph() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AudioGraph copy$default(AudioGraph r100, String[] r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.sources;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.useOutput;
    L9:
        return r100.copy(r101, r102);
    }

    public final String[] component1() {
        return this.sources;
    }

    public final Boolean component2() {
        return this.useOutput;
    }

    public final AudioGraph copy(String[] r100, Boolean r101) {
        return new AudioGraph(r100, r101);
    }

    public String toString() {
        return "AudioGraph(sources=" + Arrays.toString(this.sources) + ", useOutput=" + this.useOutput + ")";
    }

    public final boolean enableMic() {
        String[] r100 = this.sources;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (ArraysKt.contains(r100, "mic") != true) goto L7;
        return true;
    }

    public final boolean enableMusic() {
        String[] r100 = this.sources;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (ArraysKt.contains(r100, "music") != true) goto L7;
        return true;
    }

    public int hashCode() {
        String[] r100 = this.sources;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.useOutput;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String[] getSources() {
        return this.sources;
    }

    public final Boolean getUseOutput() {
        return this.useOutput;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(AudioGraph.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L29;
        AudioGraph r102 = (AudioGraph) r100;
        String[] r103 = this.sources;
        if (r103 == null) goto L22;
        String[] r104 = r102.sources;
        if (r104 != null) goto L19;
        return false;
    L19:
        if (Arrays.equals(r103, r104) == true) goto L25;
        return false;
    L25:
        if ((!Intrinsics.areEqual(this.useOutput, r102.useOutput)) == false) goto L27;
        return false;
    L27:
        return true;
    L22:
        if (r102.sources == null) goto L25;
        return false;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.shortvideo.sticker.AudioGraph");
    L8:
        r101 = null;
        goto L10
    }

    public AudioGraph(String[] r100, Boolean r101) {
        this.sources = r100;
        this.useOutput = r101;
    }

    public /* synthetic */ AudioGraph(String[] r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
