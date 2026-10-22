package com.ss.android.lark.locationmessage.statistics;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/locationmessage/statistics/LocationHitpointParams$Click;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", HTTP.LOCATION, "message-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocationHitpointParams$Click extends Enum<LocationHitpointParams$Click> implements d {
    public static final LocationHitpointParams$Click LOCATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationHitpointParams$Click[] f431323a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431324b = null;
    private final String value;

    public static EnumEntries<LocationHitpointParams$Click> getEntries() {
        return f431324b;
    }

    @Override // s5c.d
    public String getKey() {
        return "click";
    }

    static {
        LocationHitpointParams$Click r100 = new LocationHitpointParams$Click();
        LOCATION = r100;
        LocationHitpointParams$Click[] r101 = {r100};
        f431323a = r101;
        f431324b = EnumEntriesKt.enumEntries(r101);
    }

    public LocationHitpointParams$Click() {
        super(HTTP.LOCATION, 0);
        this.value = "location";
    }

    public static LocationHitpointParams$Click[] values() {
        return (LocationHitpointParams$Click[]) f431323a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static LocationHitpointParams$Click valueOf(String r100) {
        return (LocationHitpointParams$Click) a.a(LocationHitpointParams$Click.class, r100);
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
