package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYMetaFeatureDescription;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "featureName", "", "eventName", "eventFilter", "eventField", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEventField", "()Ljava/lang/String;", "getEventFilter", "getEventName", "getFeatureName", "getType", "()I", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class PTYMetaFeatureDescription implements ReflectionCall {
    private final String eventField;
    private final String eventFilter;
    private final String eventName;
    private final String featureName;
    private final int type;

    public String getEventField() {
        return this.eventField;
    }

    public String getEventFilter() {
        return this.eventFilter;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getFeatureName() {
        return this.featureName;
    }

    public int getType() {
        return this.type;
    }

    public PTYMetaFeatureDescription(String r100, String r101, String r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        this.featureName = r100;
        this.eventName = r101;
        this.eventFilter = r102;
        this.eventField = r103;
        this.type = r104;
    }

    public /* synthetic */ PTYMetaFeatureDescription(String r100, String r101, String r110, String r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        String r104 = null;
    L14:
        this(r100, r102, r103, r104, r112);
        return;
    L13:
        r104 = r111;
        goto L14
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
