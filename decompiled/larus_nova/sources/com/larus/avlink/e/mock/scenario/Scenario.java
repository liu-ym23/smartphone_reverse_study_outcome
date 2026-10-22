package com.larus.avlink.e.mock.scenario;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.larus.avlink.e.mock.CameraCallbackRecord;
import com.larus.avlink.e.mock.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J]\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006,"}, d2 = {"Lcom/larus/avlink/e/mock/scenario/Scenario;", "", "name", "", "description", "callbacks", "", "Lcom/larus/avlink/e/mock/CameraCallbackRecord;", "parameterMapping", "", "timingStrategy", "Lcom/larus/avlink/e/mock/scenario/TimingStrategy;", PromotionProductPrivilegesStruct.TAGS, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/larus/avlink/e/mock/scenario/TimingStrategy;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getDescription", "getCallbacks", "()Ljava/util/List;", "getParameterMapping", "()Ljava/util/Map;", "getTimingStrategy", "()Lcom/larus/avlink/e/mock/scenario/TimingStrategy;", "getTags", "describe", "toJson", "hasTag", "", "tag", "summary", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Scenario {
    public static final int $stable = 0;
    public static final a Companion = null;
    private final List<CameraCallbackRecord> callbacks;
    private final String description;
    private final String name;
    private final Map<String, Object> parameterMapping;
    private final List<String> tags;
    private final TimingStrategy timingStrategy;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Scenario copy$default(Scenario r100, String r101, String r102, List r103, Map r104, TimingStrategy r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.description;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.callbacks;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.parameterMapping;
    L14:
        Map r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.timingStrategy;
    L17:
        TimingStrategy r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.tags;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.description;
    }

    public final List<CameraCallbackRecord> component3() {
        return this.callbacks;
    }

    public final Map<String, Object> component4() {
        return this.parameterMapping;
    }

    public final TimingStrategy component5() {
        return this.timingStrategy;
    }

    public final List<String> component6() {
        return this.tags;
    }

    public final Scenario copy(String r100, String r110, List<CameraCallbackRecord> r111, Map<String, ? extends Object> r112, TimingStrategy r113, List<String> r114) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r110, "description");
        Intrinsics.checkNotNullParameter(r111, "callbacks");
        Intrinsics.checkNotNullParameter(r112, "parameterMapping");
        Intrinsics.checkNotNullParameter(r113, "timingStrategy");
        Intrinsics.checkNotNullParameter(r114, PromotionProductPrivilegesStruct.TAGS);
        return new Scenario(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Scenario) == true) goto L8;
        return false;
    L8:
        Scenario r101 = (Scenario) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callbacks, r101.callbacks) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parameterMapping, r101.parameterMapping) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.timingStrategy, r101.timingStrategy) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.callbacks.hashCode()) * 31) + this.parameterMapping.hashCode()) * 31) + this.timingStrategy.hashCode()) * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "Scenario(name=" + this.name + ", description=" + this.description + ", callbacks=" + this.callbacks + ", parameterMapping=" + this.parameterMapping + ", timingStrategy=" + this.timingStrategy + ", tags=" + this.tags + ')';
    }

    public final String describe() {
        StringBuilder r100 = new StringBuilder();
        r100.append("Scenario: " + this.name);
        r100.append('\n');
        r100.append("  Description: " + this.description);
        r100.append('\n');
        StringBuilder r101 = new StringBuilder("  Callbacks: ");
        r101.append(this.callbacks.size());
        r101.append(" (");
        List<CameraCallbackRecord> r102 = this.callbacks;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(((CameraCallbackRecord) r104.next()).getCallbackType());
        goto L4
    L6:
        r101.append(CollectionsKt.joinToString$default(r103, ", ", null, null, 0, null, null, 62, null));
        r101.append(')');
        r100.append(r101.toString());
        r100.append('\n');
        if ((!this.parameterMapping.isEmpty()) == false) goto L9;
        r100.append("  Parameter Mapping: " + this.parameterMapping);
        r100.append('\n');
    L9:
        r100.append("  Timing Strategy: " + this.timingStrategy);
        r100.append('\n');
        if ((!this.tags.isEmpty()) == false) goto L13;
        r100.append("  Tags: " + CollectionsKt.joinToString$default(this.tags, ", ", null, null, 0, null, null, 62, null));
        r100.append('\n');
    L13:
        return r100.toString();
    }

    public final String summary() {
        return "Scenario(" + this.name + ", " + this.callbacks.size() + " callbacks, " + this.timingStrategy + ')';
    }

    public final String toJson() {
        return h.e(this);
    }

    public final List<CameraCallbackRecord> getCallbacks() {
        return this.callbacks;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getParameterMapping() {
        return this.parameterMapping;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final TimingStrategy getTimingStrategy() {
        return this.timingStrategy;
    }

    public final boolean hasTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return this.tags.contains(r100);
    }

    public Scenario(String r100, String r101, List<CameraCallbackRecord> r102, Map<String, ? extends Object> r103, TimingStrategy r104, List<String> r105) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r102, "callbacks");
        Intrinsics.checkNotNullParameter(r103, "parameterMapping");
        Intrinsics.checkNotNullParameter(r104, "timingStrategy");
        Intrinsics.checkNotNullParameter(r105, PromotionProductPrivilegesStruct.TAGS);
        this.name = r100;
        this.description = r101;
        this.callbacks = r102;
        this.parameterMapping = r103;
        this.timingStrategy = r104;
        this.tags = r105;
        if ((!StringsKt.isBlank(r100)) == false) goto L10;
        if ((!r102.isEmpty()) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("场景必须包含至少一个回调".toString());
    L10:
        throw new IllegalArgumentException("场景名称不能为空".toString());
    }

    public /* synthetic */ Scenario(String r100, String r101, List r110, Map r111, TimingStrategy r112, List r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        r101 = "";
    L5:
        String r102 = r101;
        if ((r114 & 8) == 0) goto L8;
        r111 = MapsKt.emptyMap();
    L8:
        Map r103 = r111;
        if ((r114 & 16) == 0) goto L11;
        r112 = TimingStrategy.c.f291821a;
    L11:
        TimingStrategy r104 = r112;
        if ((r114 & 32) == 0) goto L14;
        r113 = CollectionsKt.emptyList();
    L14:
        this(r100, r102, r110, r103, r104, r113);
    }
}
