package com.ss.android.lark.locationmessage.statistics;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/locationmessage/statistics/LocationHitpointParams$IsFullScreen;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "FALSE", "message-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocationHitpointParams$IsFullScreen extends Enum<LocationHitpointParams$IsFullScreen> implements d {
    public static final LocationHitpointParams$IsFullScreen FALSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationHitpointParams$IsFullScreen[] f431325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431326b = null;
    private final String key;
    private final String value;

    public LocationHitpointParams$IsFullScreen() {
        throw null;
    }

    public static EnumEntries<LocationHitpointParams$IsFullScreen> getEntries() {
        return f431326b;
    }

    static {
        LocationHitpointParams$IsFullScreen r100 = new LocationHitpointParams$IsFullScreen("FALSE", 0, "false", null, 2, null);
        FALSE = r100;
        LocationHitpointParams$IsFullScreen[] r101 = {r100};
        f431325a = r101;
        f431326b = EnumEntriesKt.enumEntries(r101);
    }

    public static LocationHitpointParams$IsFullScreen[] values() {
        return (LocationHitpointParams$IsFullScreen[]) f431325a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getKey() {
        return this.key;
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static LocationHitpointParams$IsFullScreen valueOf(String r100) {
        return (LocationHitpointParams$IsFullScreen) a.a(LocationHitpointParams$IsFullScreen.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }

    public LocationHitpointParams$IsFullScreen(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "is_full_screen";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
