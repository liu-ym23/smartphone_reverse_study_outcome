package com.bytedance.pitaya.api.feature.store;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0015\u0018\u0000 #2\u00020\u0001:\u0001#B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureDescription;", "Lcom/bytedance/pitaya/api/feature/store/PTYMetaFeatureDescription;", "featureName", "", "eventName", "eventFilter", "eventField", "type", "", "featureSource", "dump", "", "maxCacheCount", "divideTimeType", "subFeatures", "", "startSessionEvent", "endSessionEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZIILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getDivideTimeType", "()I", "getDump", "()Z", "getEndSessionEvent", "()Ljava/lang/String;", "getEventField", "getEventFilter", "getEventName", "getFeatureName", "getFeatureSource", "getMaxCacheCount", "getStartSessionEvent", "getSubFeatures", "()Ljava/util/List;", "getType", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYFeatureDescription extends PTYMetaFeatureDescription {
    public static final Companion Companion = null;
    public static final int PTYDivideTimeApplog = 2;
    public static final int PTYDivideTimeCustom = 3;
    public static final int PTYDivideTimeForeground = 1;
    public static final int PTYDivideTimeLaunch = 0;
    public static final int PTYDivideTimeUnknown = 999;
    public static final int PTYFEDataTypeKVNumic = 1;
    public static final int PTYFEDataTypeKVString = 0;
    public static final int PTYFEDataTypeSeqDict = 6;
    public static final int PTYFEDataTypeSeqNumic = 3;
    public static final int PTYFEDataTypeSeqString = 2;
    public static final int PTYFEDataTypeSessionNumic = 5;
    public static final int PTYFEDataTypeSessionString = 4;
    public static final int PTYFEDataTypeUnkown = 999;
    public static final int PTYFeatureSourceApplog = 0;
    public static final int PTYFeatureSourceNative = 1;
    public static final int PTYFeatureSourceUnkown = 999;
    private final int divideTimeType;
    private final boolean dump;
    private final String endSessionEvent;
    private final String eventField;
    private final String eventFilter;
    private final String eventName;
    private final String featureName;
    private final int featureSource;
    private final int maxCacheCount;
    private final String startSessionEvent;
    private final List<PTYMetaFeatureDescription> subFeatures;
    private final int type;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureDescription$Companion$PTYFeatureDataType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PTYFeatureDataType {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureDescription$Companion$PTYFeatureDivideTimeType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PTYFeatureDivideTimeType {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureDescription$Companion$PTYFeatureSource;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PTYFeatureSource {
        }

        public Companion() {
        }
    }

    static {
        Companion = new Companion();
    }

    public final int getDivideTimeType() {
        return this.divideTimeType;
    }

    public final boolean getDump() {
        return this.dump;
    }

    public final String getEndSessionEvent() {
        return this.endSessionEvent;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getEventField() {
        return this.eventField;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getEventFilter() {
        return this.eventFilter;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getEventName() {
        return this.eventName;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public String getFeatureName() {
        return this.featureName;
    }

    public final int getFeatureSource() {
        return this.featureSource;
    }

    public final int getMaxCacheCount() {
        return this.maxCacheCount;
    }

    public final String getStartSessionEvent() {
        return this.startSessionEvent;
    }

    public final List<PTYMetaFeatureDescription> getSubFeatures() {
        return this.subFeatures;
    }

    @Override // com.bytedance.pitaya.api.feature.store.PTYMetaFeatureDescription
    public int getType() {
        return this.type;
    }

    public PTYFeatureDescription(String r100, String r101, String r102, String r103, int r104, int r105, boolean r106, int r107, int r110, List<PTYMetaFeatureDescription> r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        Intrinsics.checkNotNullParameter(r111, "subFeatures");
        super(r100, r101, r102, r103, r104);
        this.featureName = r100;
        this.eventName = r101;
        this.eventFilter = r102;
        this.eventField = r103;
        this.type = r104;
        this.featureSource = r105;
        this.dump = r106;
        this.maxCacheCount = r107;
        this.divideTimeType = r110;
        this.subFeatures = r111;
        this.startSessionEvent = r112;
        this.endSessionEvent = r113;
    }

    public /* synthetic */ PTYFeatureDescription(String r110, String r111, String r112, String r210, int r211, int r212, boolean r213, int r214, int r215, List r216, String r217, String r218, int r219, DefaultConstructorMarker r310) {
        if ((r219 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r219 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r219 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r219 & 32) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r219 & 64) == 0) goto L21;
        boolean r113 = false;
    L23:
        if ((r219 & 128) == 0) goto L25;
        int r114 = 0;
    L27:
        if ((r219 & 256) == 0) goto L29;
        int r115 = 999;
    L31:
        if ((r219 & 512) == 0) goto L33;
        List r116 = new ArrayList();
    L35:
        if ((r219 & 1024) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r219 & 2048) == 0) goto L41;
        String r118 = null;
    L42:
        this(r110, r100, r101, r102, r211, r103, r113, r114, r115, r116, r117, r118);
        return;
    L41:
        r118 = r218;
        goto L42
    L37:
        r117 = r217;
        goto L39
    L33:
        r116 = r216;
        goto L35
    L29:
        r115 = r215;
        goto L31
    L25:
        r114 = r214;
        goto L27
    L21:
        r113 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
