package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeSuggestUIConfig;", "Ljava/io/Serializable;", "suggestSwitchInterval", "", "showSuggestOnUserSilenceInterval", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getSuggestSwitchInterval", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowSuggestOnUserSilenceInterval", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/platform/model/audio/RealtimeSuggestUIConfig;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeSuggestUIConfig implements Serializable {
    public static final a Companion = null;
    private static final RealtimeSuggestUIConfig DEFAULT = null;

    @SerializedName("show_suggest_on_user_silence_interval")
    private final Long showSuggestOnUserSilenceInterval;

    @SerializedName("suggest_switch_interval")
    private final Long suggestSwitchInterval;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealtimeSuggestUIConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RealtimeSuggestUIConfig copy$default(RealtimeSuggestUIConfig r100, Long r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.suggestSwitchInterval;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.showSuggestOnUserSilenceInterval;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.suggestSwitchInterval;
    }

    public final Long component2() {
        return this.showSuggestOnUserSilenceInterval;
    }

    public final RealtimeSuggestUIConfig copy(Long r100, Long r101) {
        return new RealtimeSuggestUIConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeSuggestUIConfig) == true) goto L8;
        return false;
    L8:
        RealtimeSuggestUIConfig r101 = (RealtimeSuggestUIConfig) r100;
        if (Intrinsics.areEqual(this.suggestSwitchInterval, r101.suggestSwitchInterval) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showSuggestOnUserSilenceInterval, r101.showSuggestOnUserSilenceInterval) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.suggestSwitchInterval;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.showSuggestOnUserSilenceInterval;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RealtimeSuggestUIConfig(suggestSwitchInterval=" + this.suggestSwitchInterval + ", showSuggestOnUserSilenceInterval=" + this.showSuggestOnUserSilenceInterval + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new a();
        Long r100 = null;
        Object[] r101 = 0 == true ? 1 : 0;
        DEFAULT = new RealtimeSuggestUIConfig(r100, r101, 3, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ RealtimeSuggestUIConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Long getShowSuggestOnUserSilenceInterval() {
        return this.showSuggestOnUserSilenceInterval;
    }

    public final Long getSuggestSwitchInterval() {
        return this.suggestSwitchInterval;
    }

    public RealtimeSuggestUIConfig(Long r100, Long r101) {
        this.suggestSwitchInterval = r100;
        this.showSuggestOnUserSilenceInterval = r101;
    }

    public /* synthetic */ RealtimeSuggestUIConfig(Long r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 3000L;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 5000L;
    L8:
        this(r100, r101);
    }
}
