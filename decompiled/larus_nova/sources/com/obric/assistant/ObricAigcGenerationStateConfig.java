package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/ObricAigcGenerationStateConfig;", "", "supportedTaskKeys", "", "", "<init>", "(Ljava/util/List;)V", "getSupportedTaskKeys", "()Ljava/util/List;", "resolvedSupportedTaskKeys", "getResolvedSupportedTaskKeys", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAigcGenerationStateConfig {
    public static final a Companion = null;
    private static final List<String> DEFAULT_SUPPORTED_TASK_KEYS = null;

    @SerializedName("supported_task_keys")
    private final List<String> supportedTaskKeys;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricAigcGenerationStateConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricAigcGenerationStateConfig copy$default(ObricAigcGenerationStateConfig r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.supportedTaskKeys;
    L6:
        return r100.copy(r101);
    }

    public final List<String> component1() {
        return this.supportedTaskKeys;
    }

    public final ObricAigcGenerationStateConfig copy(List<String> r100) {
        return new ObricAigcGenerationStateConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricAigcGenerationStateConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.supportedTaskKeys, ((ObricAigcGenerationStateConfig) r100).supportedTaskKeys) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.supportedTaskKeys;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ObricAigcGenerationStateConfig(supportedTaskKeys=" + this.supportedTaskKeys + ')';
    }

    static {
        Companion = new a();
        DEFAULT_SUPPORTED_TASK_KEYS = CollectionsKt.listOf(new String[]{"gen_video", "gen_music", "recording_summary"});
    }

    public final List<String> getResolvedSupportedTaskKeys() {
        List<String> r100 = this.supportedTaskKeys;
        if (r100 == null) goto L7;
        List<String> r101 = CollectionsKt.filterNotNull(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return DEFAULT_SUPPORTED_TASK_KEYS;
    }

    public final List<String> getSupportedTaskKeys() {
        return this.supportedTaskKeys;
    }

    public ObricAigcGenerationStateConfig(List<String> r100) {
        this.supportedTaskKeys = r100;
    }

    public /* synthetic */ ObricAigcGenerationStateConfig(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = DEFAULT_SUPPORTED_TASK_KEYS;
    L5:
        this(r100);
    }
}
