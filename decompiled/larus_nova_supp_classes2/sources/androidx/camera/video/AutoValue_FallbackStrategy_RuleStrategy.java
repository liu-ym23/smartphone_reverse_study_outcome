package androidx.camera.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_FallbackStrategy_RuleStrategy extends FallbackStrategy.RuleStrategy {
    private final Quality fallbackQuality;
    private final int fallbackRule;

    public int hashCode() {
        return ((this.fallbackQuality.hashCode() ^ 1000003) * 1000003) ^ this.fallbackRule;
    }

    public String toString() {
        return "RuleStrategy{fallbackQuality=" + this.fallbackQuality + ", fallbackRule=" + this.fallbackRule + "}";
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    public Quality getFallbackQuality() {
        return this.fallbackQuality;
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    public int getFallbackRule() {
        return this.fallbackRule;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof FallbackStrategy.RuleStrategy) == false) goto L14;
        FallbackStrategy.RuleStrategy r6 = (FallbackStrategy.RuleStrategy) r5;
        if (this.fallbackQuality.equals(r6.getFallbackQuality()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.fallbackRule != r6.getFallbackRule()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_FallbackStrategy_RuleStrategy(Quality r1, int r2) {
        if (r1 == null) goto L7;
        this.fallbackQuality = r1;
        this.fallbackRule = r2;
        return;
    L7:
        throw new NullPointerException("Null fallbackQuality");
    }
}
