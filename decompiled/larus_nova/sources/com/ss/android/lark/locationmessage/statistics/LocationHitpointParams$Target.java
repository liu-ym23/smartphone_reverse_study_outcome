package com.ss.android.lark.locationmessage.statistics;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;
import s5c.d;
import s5c.e;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/locationmessage/statistics/LocationHitpointParams$Target;", "Lcom/ss/android/lark/statistics/extensions/ITargetParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MESSAGE_LOCATION_VIEW", "message-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocationHitpointParams$Target extends Enum<LocationHitpointParams$Target> implements e {
    public static final LocationHitpointParams$Target MESSAGE_LOCATION_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationHitpointParams$Target[] f431327a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431328b = null;
    private final String value;

    public static EnumEntries<LocationHitpointParams$Target> getEntries() {
        return f431328b;
    }

    @Override // s5c.d
    public String getKey() {
        return PickerReporterConstants.KEY.TARGET;
    }

    static {
        LocationHitpointParams$Target r100 = new LocationHitpointParams$Target();
        MESSAGE_LOCATION_VIEW = r100;
        LocationHitpointParams$Target[] r101 = {r100};
        f431327a = r101;
        f431328b = EnumEntriesKt.enumEntries(r101);
    }

    public LocationHitpointParams$Target() {
        super("MESSAGE_LOCATION_VIEW", 0);
        this.value = NavigateHitPoint$Event.MESSAGE_LOCATION_VIEW;
    }

    public static LocationHitpointParams$Target[] values() {
        return (LocationHitpointParams$Target[]) f431327a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static LocationHitpointParams$Target valueOf(String r100) {
        return (LocationHitpointParams$Target) a.a(LocationHitpointParams$Target.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }
}
