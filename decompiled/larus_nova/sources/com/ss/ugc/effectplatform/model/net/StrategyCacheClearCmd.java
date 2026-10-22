package com.ss.ugc.effectplatform.model.net;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006 "}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/StrategyCacheClearCmd;", "", "type", "", "panel", "delete_keys", "", "allow_keys", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "time_threshold", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAllow_keys", "()Ljava/util/List;", "getDelete_keys", "getPanel", "()Ljava/lang/String;", "getStrategy", "getTime_threshold", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class StrategyCacheClearCmd {
    private final List<String> allow_keys;
    private final List<String> delete_keys;
    private final String panel;
    private final String strategy;
    private final String time_threshold;
    private final String type;

    public StrategyCacheClearCmd() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StrategyCacheClearCmd copy$default(StrategyCacheClearCmd r100, String r101, String r102, List r103, List r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.panel;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.delete_keys;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.allow_keys;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.strategy;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.time_threshold;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.panel;
    }

    public final List<String> component3() {
        return this.delete_keys;
    }

    public final List<String> component4() {
        return this.allow_keys;
    }

    public final String component5() {
        return this.strategy;
    }

    public final String component6() {
        return this.time_threshold;
    }

    public final StrategyCacheClearCmd copy(String r100, String r110, List<String> r111, List<String> r112, String r113, String r114) {
        return new StrategyCacheClearCmd(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StrategyCacheClearCmd) == false) goto L18;
        StrategyCacheClearCmd r101 = (StrategyCacheClearCmd) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.panel, r101.panel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.delete_keys, r101.delete_keys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.allow_keys, r101.allow_keys) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.time_threshold, r101.time_threshold) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.panel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.delete_keys;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.allow_keys;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.strategy;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.time_threshold;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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

    public String toString() {
        return "StrategyCacheClearCmd(type=" + this.type + ", panel=" + this.panel + ", delete_keys=" + this.delete_keys + ", allow_keys=" + this.allow_keys + ", strategy=" + this.strategy + ", time_threshold=" + this.time_threshold + ")";
    }

    public final List<String> getAllow_keys() {
        return this.allow_keys;
    }

    public final List<String> getDelete_keys() {
        return this.delete_keys;
    }

    public final String getPanel() {
        return this.panel;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public final String getTime_threshold() {
        return this.time_threshold;
    }

    public final String getType() {
        return this.type;
    }

    public StrategyCacheClearCmd(String r100, String r101, List<String> r102, List<String> r103, String r104, String r105) {
        this.type = r100;
        this.panel = r101;
        this.delete_keys = r102;
        this.allow_keys = r103;
        this.strategy = r104;
        this.time_threshold = r105;
    }

    public /* synthetic */ StrategyCacheClearCmd(String r100, String r101, List r102, List r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        List r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
