package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.t1;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/t;", "", "", "iconType", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "", "text", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/t1;", "icon", "Lcom/bytedance/android/ec/model/response/t1;", "c", "()Lcom/bytedance/android/ec/model/response/t1;", "", "duration", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", LocationMonitorConst.TAG, "e", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a;", "elementIcon", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("element_icon")
    private final com.bytedance.android.livesdk.livecommerce.intro.model.resp.a elementIcon;

    @SerializedName("icon")
    private final t1 icon;

    @SerializedName("icon_type")
    private final Integer iconType;

    @SerializedName(LocationMonitorConst.TAG)
    private final String tag;

    @SerializedName("text")
    private final String text;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof t) == false) goto L18;
        t r4 = (t) r3;
        if (Intrinsics.areEqual(this.iconType, r4.iconType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r4.duration) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tag, r4.tag) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.elementIcon, r4.elementIcon) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.iconType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.text;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        t1 r7 = this.icon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.duration;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.tag;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.a r16 = this.elementIcon;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroIcon(iconType=" + this.iconType + ", text=" + this.text + ", icon=" + this.icon + ", duration=" + this.duration + ", tag=" + this.tag + ", elementIcon=" + this.elementIcon + ")";
    }

    public t() {
        this.iconType = null;
        this.text = null;
        this.icon = null;
        this.duration = null;
        this.tag = null;
        this.elementIcon = null;
    }

    public final Long a() {
        return this.duration;
    }

    public final com.bytedance.android.livesdk.livecommerce.intro.model.resp.a b() {
        return this.elementIcon;
    }

    public final t1 c() {
        return this.icon;
    }

    public final Integer d() {
        return this.iconType;
    }

    public final String e() {
        return this.tag;
    }

    public final String f() {
        return this.text;
    }
}
