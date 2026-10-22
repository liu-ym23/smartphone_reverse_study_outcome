package com.bytedance.ee.bear.bitable.statistic;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$BW\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012(\b\u0002\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0001J\u001e\u0010 \u001a\u00020\u001d2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R.\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\f8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointModel;", "Ljava/io/Serializable;", "name", "", "timestamp", "", "unique", "", "pointType", "Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointType;", "extras", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;JZLcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointType;Ljava/util/HashMap;)V", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getUnique", "()Z", "type", "getType", "()Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointType;", NativeDownloadModel.JsonKey.EXTRA, "getExtras", "()Ljava/util/HashMap;", "isTempPoint", "addExtra", "", "key", "value", "addExtras", "extra", "", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableStatisticEventModel$NormalPointModel implements Serializable {
    public static final a Companion = null;
    private HashMap<String, Serializable> mExtras;
    private final String name;
    private final long timestamp;
    private final BitableStatisticEventModel$NormalPointType type;
    private final boolean unique;

    public static final class a {
        public a() {
        }

        public static BitableStatisticEventModel$NormalPointModel a(long r110, String r111) {
            Intrinsics.checkNotNullParameter(r111, "name");
            return new BitableStatisticEventModel$NormalPointModel(r111, r110, true, BitableStatisticEventModel$NormalPointType.INIT_POINT, null, 16, null);
        }

        public static BitableStatisticEventModel$NormalPointModel b(String r110, long r111, boolean r112, HashMap r113) {
            Intrinsics.checkNotNullParameter(r110, "name");
            return new BitableStatisticEventModel$NormalPointModel(r110, r111, r112, null, r113, 8, null);
        }

        public static BitableStatisticEventModel$NormalPointModel d(String r110, long r111, boolean r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r110, "name");
            if (r113 == false) goto L5;
            BitableStatisticEventModel$NormalPointType r114 = BitableStatisticEventModel$NormalPointType.TEMP_POINT_TRIGGER;
        L7:
            return new BitableStatisticEventModel$NormalPointModel(r110, r111, r112, r114, null, 16, null);
        L5:
            r114 = BitableStatisticEventModel$NormalPointType.TEMP_POINT;
            goto L7
        }

        public static /* synthetic */ BitableStatisticEventModel$NormalPointModel c(a r100, String r101, long r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L5;
            r103 = true;
        L5:
            r100.getClass();
            return b(r101, r102, r103, null);
        }

        public static /* synthetic */ BitableStatisticEventModel$NormalPointModel e(a r100, String r101, long r102, boolean r103, int r104) {
            if ((r104 & 8) == 0) goto L5;
            r103 = false;
        L5:
            r100.getClass();
            return d(r101, r102, false, r103);
        }
    }

    static {
        Companion = new a();
    }

    public BitableStatisticEventModel$NormalPointModel() {
        throw null;
    }

    public final boolean isTempPoint() {
        BitableStatisticEventModel$NormalPointType r100 = this.type;
        if (r100 != BitableStatisticEventModel$NormalPointType.TEMP_POINT) goto L5;
    L8:
        return true;
    L5:
        if (r100 == BitableStatisticEventModel$NormalPointType.TEMP_POINT_TRIGGER) goto L8;
        return false;
    }

    public final HashMap<String, Serializable> getExtras() {
        return this.mExtras;
    }

    public final String getName() {
        return this.name;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final BitableStatisticEventModel$NormalPointType getType() {
        return this.type;
    }

    public final boolean getUnique() {
        return this.unique;
    }

    public final void addExtras(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L9;
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
    L5:
        if (r101.hasNext() == false) goto L15;
        Map.Entry<String, ? extends Object> r102 = r101.next();
        Object r103 = r102.getValue();
        if ((r103 instanceof Serializable) == false) goto L5;
        addExtra(r102.getKey(), (Serializable) r103);
        goto L5
    L15:
        return;
    }

    public final void addExtra(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (this.mExtras != null) goto L5;
        this.mExtras = new HashMap();
    L5:
        HashMap<String, Serializable> r102 = this.mExtras;
        if (r102 == null) goto L9;
        r102.put(r100, r101);
        return;
    }

    public BitableStatisticEventModel$NormalPointModel(String r100, long r101, boolean r102, BitableStatisticEventModel$NormalPointType r103, HashMap r104, int r105, DefaultConstructorMarker r106) {
        if ((r105 & 4) == 0) goto L6;
        r102 = true;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = BitableStatisticEventModel$NormalPointType.POINT;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        this.name = r100;
        this.timestamp = r101;
        this.unique = r102;
        this.type = r103;
        this.mExtras = r104;
    }
}
