package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroElasticTitle;", "", "", LocationMonitorConst.TYPE, "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "before", "Ljava/lang/String;", "getBefore", "()Ljava/lang/String;", "content", "d", "", "eventParam", "Ljava/util/Map;", "getEventParam", "()Ljava/util/Map;", "color", "b", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "colorList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "bold", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "fontSize", "I", "e", "()I", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroElasticTitle {

    @SerializedName("before")
    private final String before;

    @SerializedName("bold")
    private final Boolean bold;

    @SerializedName("color")
    private final String color;

    @SerializedName("color_list")
    private final List<String> colorList;

    @SerializedName("content")
    private final String content;

    @SerializedName("event_param")
    private final Map<String, String> eventParam;

    @SerializedName("font_size")
    private final int fontSize;

    @SerializedName(LocationMonitorConst.TYPE)
    private final Integer type;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroElasticTitle$Companion$IntroElasticTitleType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroElasticTitleType {
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof IntroElasticTitle) == false) goto L22;
        IntroElasticTitle r4 = (IntroElasticTitle) r3;
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.before, r4.before) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.eventParam, r4.eventParam) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.colorList, r4.colorList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bold, r4.bold) == true) goto L20;
        return false;
    L20:
        if (this.fontSize == r4.fontSize) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.type;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.before;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.content;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.eventParam;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.color;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.colorList;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.bold;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return ((r18 + r1) * 31) + this.fontSize;
    L25:
        r17 = 0;
        goto L26
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
        return "IntroElasticTitle(type=" + this.type + ", before=" + this.before + ", content=" + this.content + ", eventParam=" + this.eventParam + ", color=" + this.color + ", colorList=" + this.colorList + ", bold=" + this.bold + ", fontSize=" + this.fontSize + ")";
    }

    public IntroElasticTitle() {
        this.type = null;
        this.before = null;
        this.content = null;
        this.eventParam = null;
        this.color = null;
        this.colorList = null;
        this.bold = null;
        this.fontSize = 0;
    }

    public final Boolean a() {
        return this.bold;
    }

    public final String b() {
        return this.color;
    }

    public final List<String> c() {
        return this.colorList;
    }

    public final String d() {
        return this.content;
    }

    public final int e() {
        return this.fontSize;
    }

    public final Integer getType() {
        return this.type;
    }
}
