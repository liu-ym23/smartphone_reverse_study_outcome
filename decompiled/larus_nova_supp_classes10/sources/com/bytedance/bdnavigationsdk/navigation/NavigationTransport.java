package com.bytedance.bdnavigationsdk.navigation;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class NavigationTransport {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bdnavigationsdk/navigation/NavigationTransport$TransportType;", "", "code", "", "description", "speed", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;F)V", "getCode", "()Ljava/lang/String;", "getDescription", "getSpeed", "()F", "Walking", "Bicycling", "EBicycling", "Driving", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final enum TransportType extends Enum<TransportType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TransportType[] $VALUES = null;
        private static final Lazy<juc.d<Object>> $cachedSerializer$delegate = null;
        public static final TransportType Bicycling = null;
        public static final a Companion = null;
        public static final TransportType Driving = null;
        public static final TransportType EBicycling = null;
        public static final TransportType Walking = null;
        private static final Map<String, TransportType> codeMap = null;
        private static final Map<String, TransportType> descriptionMap = null;
        private final String code;
        private final String description;
        private final float speed;

        public static final class a {
            public a() {
            }

            public final juc.d<TransportType> serializer() {
                return (juc.d) TransportType.access$get$cachedSerializer$delegate$cp().getValue();
            }
        }

        public static EnumEntries<TransportType> getEntries() {
            return $ENTRIES;
        }

        static {
            TransportType r6 = new TransportType("Walking", 0, "foot", "步行导航", 5.0f);
            Walking = r6;
            TransportType r0 = new TransportType("Bicycling", 1, "bicycle", "骑行导航", 15.0f);
            Bicycling = r0;
            TransportType r1 = new TransportType("EBicycling", 2, "ebicycle", "骑行导航", 20.0f);
            EBicycling = r1;
            TransportType r2 = new TransportType("Driving", 3, "car", "驾车导航", 40.0f);
            Driving = r2;
            TransportType[] r3 = {r6, r0, r1, r2};
            $VALUES = r3;
            $ENTRIES = EnumEntriesKt.enumEntries(r3);
            Companion = new a();
            EnumEntries<TransportType> r4 = getEntries();
            LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16));
            Iterator r7 = r4.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Object r8 = r7.next();
            r5.put(((TransportType) r8).code, r8);
            goto L4
        L6:
            codeMap = r5;
            EnumEntries<TransportType> r9 = getEntries();
            LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
            Iterator r11 = r9.iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            Object r12 = r11.next();
            r10.put(((TransportType) r12).description, r12);
            goto L8
        L10:
            descriptionMap = r10;
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new n());
        }

        public static TransportType[] values() {
            return (TransportType[]) $VALUES.clone();
        }

        public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
            return $cachedSerializer$delegate;
        }

        public static final /* synthetic */ Map access$getCodeMap$cp() {
            return codeMap;
        }

        public static final /* synthetic */ Map access$getDescriptionMap$cp() {
            return descriptionMap;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getDescription() {
            return this.description;
        }

        public final float getSpeed() {
            return this.speed;
        }

        public static TransportType valueOf(String r1) {
            return (TransportType) r27.a.a(TransportType.class, r1);
        }

        public TransportType(String r1, int r2, String r3, String r4, float r5) {
            super(r1, r2);
            this.code = r3;
            this.description = r4;
            this.speed = r5;
        }
    }

    static {
    }
}
