package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/settings/DoraGOnboardingQueryTopics;", "", "aiLiveScene", "", "", "queryTopic", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAiLiveScene", "()Ljava/util/List;", "getQueryTopic", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingQueryTopics {

    @SerializedName("ailive_scene")
    private final List<String> aiLiveScene;

    @SerializedName("query_scene")
    private final List<String> queryTopic;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraGOnboardingQueryTopics() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoraGOnboardingQueryTopics copy$default(DoraGOnboardingQueryTopics r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.aiLiveScene;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.queryTopic;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.aiLiveScene;
    }

    public final List<String> component2() {
        return this.queryTopic;
    }

    public final DoraGOnboardingQueryTopics copy(List<String> r100, List<String> r101) {
        return new DoraGOnboardingQueryTopics(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraGOnboardingQueryTopics) == true) goto L8;
        return false;
    L8:
        DoraGOnboardingQueryTopics r101 = (DoraGOnboardingQueryTopics) r100;
        if (Intrinsics.areEqual(this.aiLiveScene, r101.aiLiveScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryTopic, r101.queryTopic) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.aiLiveScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.queryTopic;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraGOnboardingQueryTopics(aiLiveScene=" + this.aiLiveScene + ", queryTopic=" + this.queryTopic + ')';
    }

    public final List<String> getAiLiveScene() {
        return this.aiLiveScene;
    }

    public final List<String> getQueryTopic() {
        return this.queryTopic;
    }

    public DoraGOnboardingQueryTopics(List<String> r100, List<String> r101) {
        this.aiLiveScene = r100;
        this.queryTopic = r101;
    }

    public /* synthetic */ DoraGOnboardingQueryTopics(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
