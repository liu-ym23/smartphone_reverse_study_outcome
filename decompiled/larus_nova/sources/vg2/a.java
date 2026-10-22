package vg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f554676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f554677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EventType f554678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f554680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f554681f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f554677b, r101.f554677b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f554678c, r101.f554678c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f554679d, r101.f554679d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554680e, r101.f554680e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f554681f, r101.f554681f) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f554677b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        EventType r104 = this.f554678c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f554679d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f554680e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f554681f;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ActionRecordEvent(name=" + this.f554677b + ", type=" + this.f554678c + ", module=" + this.f554679d + ", action=" + this.f554680e + ", actionUUID=" + this.f554681f + ")";
    }

    public final EventType getType() {
        return this.f554678c;
    }

    public a(String r100, EventType r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, "action");
        this.f554677b = r100;
        this.f554678c = r101;
        this.f554679d = r102;
        this.f554680e = r103;
        this.f554681f = r104;
        this.f554676a = new LinkedHashMap();
    }
}
