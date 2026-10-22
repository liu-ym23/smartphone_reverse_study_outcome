package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000f¨\u0006)"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "message", "", "type", "duration", "", "icon", "customIcon", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getCustomIcon", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ext", "", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getIcon", "getMessage", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;", "equals", "", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ToastBuilder {
    private final Context context;
    private final String customIcon;
    private final Integer duration;
    private Map<String, ? extends Object> ext;
    private final String icon;
    private final String message;
    private final String type;

    public static /* synthetic */ ToastBuilder copy$default(ToastBuilder r100, Context r101, String r102, String r103, Integer r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.message;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.type;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.duration;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.icon;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.customIcon;
    L20:
        Context r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.type;
    }

    public final Integer component4() {
        return this.duration;
    }

    public final String component5() {
        return this.icon;
    }

    public final String component6() {
        return this.customIcon;
    }

    public final ToastBuilder copy(Context r100, String r110, String r111, Integer r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ToastBuilder(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ToastBuilder) == true) goto L8;
        return false;
    L8:
        ToastBuilder r101 = (ToastBuilder) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.customIcon, r101.customIcon) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.context.hashCode() * 31;
        String r101 = this.message;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.type;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.duration;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.icon;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.customIcon;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ToastBuilder(context=" + this.context + ", message=" + this.message + ", type=" + this.type + ", duration=" + this.duration + ", icon=" + this.icon + ", customIcon=" + this.customIcon + ')';
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCustomIcon() {
        return this.customIcon;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getType() {
        return this.type;
    }

    public final void setExt(Map<String, ? extends Object> r100) {
        this.ext = r100;
    }

    public ToastBuilder(Context r100, String r101, String r102, Integer r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.message = r101;
        this.type = r102;
        this.duration = r103;
        this.icon = r104;
        this.customIcon = r105;
    }

    public /* synthetic */ ToastBuilder(Context r100, String r101, String r102, Integer r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        String r103 = null;
        if ((r113 & 2) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r105 = "success";
    L11:
        if ((r113 & 8) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r113 & 32) != 0) goto L22;
        r103 = r112;
    L22:
        this(r100, r104, r105, r106, r107, r103);
        return;
    L17:
        r107 = r111;
        goto L19
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r102;
        goto L11
    L5:
        r104 = r101;
        goto L7
    }
}
