package com.bytedance.cloudplay.xplay2.api;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\bG\b\u0087\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u0017\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eHÆ\u0003J\u0017\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eHÆ\u0003J\u0017\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010L\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0014HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010?J\u0010\u0010T\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eHÆ\u0003Jþ\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020\u00162\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\u0006HÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR$\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001a\"\u0004\bF\u0010\u001c¨\u0006]"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/LaunchParams;", "", "gameId", "", "channel", "displayWidth", "", "displayHeight", "xToken", "pcDisplayWidthRatio", "", "pcDisplayHeightRatio", "expectCore", "extra", "", "appExtra", "innerExtra", "debugExtra", "clientLibraLabel", "cloudPlayerNames", "", "enableGameSafeArea", "", "acceptEngine", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAcceptEngine", "()Ljava/lang/String;", "setAcceptEngine", "(Ljava/lang/String;)V", "getAppExtra", "()Ljava/util/Map;", "setAppExtra", "(Ljava/util/Map;)V", "getChannel", "setChannel", "getClientLibraLabel", "setClientLibraLabel", "getCloudPlayerNames", "()Ljava/util/List;", "setCloudPlayerNames", "(Ljava/util/List;)V", "getDebugExtra", "setDebugExtra", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "getDisplayWidth", "setDisplayWidth", "getEnableGameSafeArea", "()Ljava/lang/Boolean;", "setEnableGameSafeArea", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getExpectCore", "setExpectCore", "getExtra", "setExtra", "getGameId", "setGameId", "getInnerExtra", "setInnerExtra", "getPcDisplayHeightRatio", "()Ljava/lang/Float;", "setPcDisplayHeightRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getPcDisplayWidthRatio", "setPcDisplayWidthRatio", "getXToken", "setXToken", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/cloudplay/xplay2/api/LaunchParams;", "equals", "other", "hashCode", "toString", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LaunchParams {
    private String acceptEngine;
    private Map<String, ? extends Object> appExtra;
    private String channel;
    private String clientLibraLabel;
    private List<String> cloudPlayerNames;
    private Map<String, ? extends Object> debugExtra;
    private int displayHeight;
    private int displayWidth;
    private Boolean enableGameSafeArea;
    private String expectCore;
    private Map<String, ? extends Object> extra;
    private String gameId;
    private Map<String, ? extends Object> innerExtra;
    private Float pcDisplayHeightRatio;
    private Float pcDisplayWidthRatio;
    private String xToken;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LaunchParams copy$default(LaunchParams r110, String r111, String r112, int r210, int r211, String r212, Float r213, Float r214, String r215, Map r216, Map r217, Map r218, Map r219, String r310, List r311, Boolean r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.gameId;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.channel;
    L11:
        if ((r314 & 4) == 0) goto L13;
        int r102 = r110.displayWidth;
    L15:
        if ((r314 & 8) == 0) goto L17;
        int r103 = r110.displayHeight;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = r110.xToken;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Float r105 = r110.pcDisplayWidthRatio;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Float r106 = r110.pcDisplayHeightRatio;
    L31:
        if ((r314 & 128) == 0) goto L33;
        String r107 = r110.expectCore;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Map r113 = r110.extra;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Map r114 = r110.appExtra;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Map r115 = r110.innerExtra;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        Map r116 = r110.debugExtra;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = r110.clientLibraLabel;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r118 = r110.cloudPlayerNames;
    L58:
        List r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        Boolean r119 = r110.enableGameSafeArea;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.acceptEngine;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.gameId;
    }

    public final Map<String, Object> component10() {
        return this.appExtra;
    }

    public final Map<String, Object> component11() {
        return this.innerExtra;
    }

    public final Map<String, Object> component12() {
        return this.debugExtra;
    }

    public final String component13() {
        return this.clientLibraLabel;
    }

    public final List<String> component14() {
        return this.cloudPlayerNames;
    }

    public final Boolean component15() {
        return this.enableGameSafeArea;
    }

    public final String component16() {
        return this.acceptEngine;
    }

    public final String component2() {
        return this.channel;
    }

    public final int component3() {
        return this.displayWidth;
    }

    public final int component4() {
        return this.displayHeight;
    }

    public final String component5() {
        return this.xToken;
    }

    public final Float component6() {
        return this.pcDisplayWidthRatio;
    }

    public final Float component7() {
        return this.pcDisplayHeightRatio;
    }

    public final String component8() {
        return this.expectCore;
    }

    public final Map<String, Object> component9() {
        return this.extra;
    }

    public final LaunchParams copy(String r210, String r211, int r212, int r213, String r214, Float r215, Float r216, String r217, Map<String, ? extends Object> r218, Map<String, ? extends Object> r219, Map<String, ? extends Object> r310, Map<String, ? extends Object> r311, String r312, List<String> r313, Boolean r314, String r315) {
        Intrinsics.checkNotNullParameter(r210, "gameId");
        Intrinsics.checkNotNullParameter(r211, "channel");
        return new LaunchParams(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LaunchParams) == true) goto L8;
        return false;
    L8:
        LaunchParams r101 = (LaunchParams) r100;
        if (Intrinsics.areEqual(this.gameId, r101.gameId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L15;
        return false;
    L15:
        if (this.displayWidth == r101.displayWidth) goto L18;
        return false;
    L18:
        if (this.displayHeight == r101.displayHeight) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.xToken, r101.xToken) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pcDisplayWidthRatio, r101.pcDisplayWidthRatio) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pcDisplayHeightRatio, r101.pcDisplayHeightRatio) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.expectCore, r101.expectCore) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.appExtra, r101.appExtra) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.innerExtra, r101.innerExtra) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.debugExtra, r101.debugExtra) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.clientLibraLabel, r101.clientLibraLabel) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.cloudPlayerNames, r101.cloudPlayerNames) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.enableGameSafeArea, r101.enableGameSafeArea) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.acceptEngine, r101.acceptEngine) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.gameId.hashCode() * 31) + this.channel.hashCode()) * 31) + this.displayWidth) * 31) + this.displayHeight) * 31;
        String r101 = this.xToken;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Float r105 = this.pcDisplayWidthRatio;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Float r108 = this.pcDisplayHeightRatio;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.expectCore;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, ? extends Object> r114 = this.extra;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Map<String, ? extends Object> r117 = this.appExtra;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Map<String, ? extends Object> r120 = this.innerExtra;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Map<String, ? extends Object> r123 = this.debugExtra;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.clientLibraLabel;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        List<String> r129 = this.cloudPlayerNames;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        Boolean r132 = this.enableGameSafeArea;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.acceptEngine;
        if (r135 == null) goto L51;
        r102 = r135.hashCode();
    L51:
        return r134 + r102;
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "LaunchParams(gameId=" + this.gameId + ", channel=" + this.channel + ", displayWidth=" + this.displayWidth + ", displayHeight=" + this.displayHeight + ", xToken=" + this.xToken + ", pcDisplayWidthRatio=" + this.pcDisplayWidthRatio + ", pcDisplayHeightRatio=" + this.pcDisplayHeightRatio + ", expectCore=" + this.expectCore + ", extra=" + this.extra + ", appExtra=" + this.appExtra + ", innerExtra=" + this.innerExtra + ", debugExtra=" + this.debugExtra + ", clientLibraLabel=" + this.clientLibraLabel + ", cloudPlayerNames=" + this.cloudPlayerNames + ", enableGameSafeArea=" + this.enableGameSafeArea + ", acceptEngine=" + this.acceptEngine + ')';
    }

    public final String getAcceptEngine() {
        return this.acceptEngine;
    }

    public final Map<String, Object> getAppExtra() {
        return this.appExtra;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getClientLibraLabel() {
        return this.clientLibraLabel;
    }

    public final List<String> getCloudPlayerNames() {
        return this.cloudPlayerNames;
    }

    public final Map<String, Object> getDebugExtra() {
        return this.debugExtra;
    }

    public final int getDisplayHeight() {
        return this.displayHeight;
    }

    public final int getDisplayWidth() {
        return this.displayWidth;
    }

    public final Boolean getEnableGameSafeArea() {
        return this.enableGameSafeArea;
    }

    public final String getExpectCore() {
        return this.expectCore;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final Map<String, Object> getInnerExtra() {
        return this.innerExtra;
    }

    public final Float getPcDisplayHeightRatio() {
        return this.pcDisplayHeightRatio;
    }

    public final Float getPcDisplayWidthRatio() {
        return this.pcDisplayWidthRatio;
    }

    public final String getXToken() {
        return this.xToken;
    }

    public final void setAcceptEngine(String r100) {
        this.acceptEngine = r100;
    }

    public final void setAppExtra(Map<String, ? extends Object> r100) {
        this.appExtra = r100;
    }

    public final void setChannel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channel = r100;
    }

    public final void setClientLibraLabel(String r100) {
        this.clientLibraLabel = r100;
    }

    public final void setCloudPlayerNames(List<String> r100) {
        this.cloudPlayerNames = r100;
    }

    public final void setDebugExtra(Map<String, ? extends Object> r100) {
        this.debugExtra = r100;
    }

    public final void setDisplayHeight(int r100) {
        this.displayHeight = r100;
    }

    public final void setDisplayWidth(int r100) {
        this.displayWidth = r100;
    }

    public final void setEnableGameSafeArea(Boolean r100) {
        this.enableGameSafeArea = r100;
    }

    public final void setExpectCore(String r100) {
        this.expectCore = r100;
    }

    public final void setExtra(Map<String, ? extends Object> r100) {
        this.extra = r100;
    }

    public final void setGameId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameId = r100;
    }

    public final void setInnerExtra(Map<String, ? extends Object> r100) {
        this.innerExtra = r100;
    }

    public final void setPcDisplayHeightRatio(Float r100) {
        this.pcDisplayHeightRatio = r100;
    }

    public final void setPcDisplayWidthRatio(Float r100) {
        this.pcDisplayWidthRatio = r100;
    }

    public final void setXToken(String r100) {
        this.xToken = r100;
    }

    public LaunchParams(String r100, String r101, int r102, int r103, String r104, Float r110, Float r111, String r112, Map<String, ? extends Object> r113, Map<String, ? extends Object> r114, Map<String, ? extends Object> r115, Map<String, ? extends Object> r116, String r117, List<String> r118, Boolean r119, String r210) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.gameId = r100;
        this.channel = r101;
        this.displayWidth = r102;
        this.displayHeight = r103;
        this.xToken = r104;
        this.pcDisplayWidthRatio = r110;
        this.pcDisplayHeightRatio = r111;
        this.expectCore = r112;
        this.extra = r113;
        this.appExtra = r114;
        this.innerExtra = r115;
        this.debugExtra = r116;
        this.clientLibraLabel = r117;
        this.cloudPlayerNames = r118;
        this.enableGameSafeArea = r119;
        this.acceptEngine = r210;
    }

    public /* synthetic */ LaunchParams(String r210, String r211, int r212, int r213, String r214, Float r215, Float r216, String r217, Map r218, Map r310, Map r311, Map r312, String r313, List r314, Boolean r315, String r316, int r317, DefaultConstructorMarker r318) {
        if ((r317 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r317 & 32) == 0) goto L9;
        Float r101 = Float.valueOf(0.0f);
    L11:
        if ((r317 & 64) == 0) goto L13;
        Float r110 = Float.valueOf(0.0f);
    L15:
        if ((r317 & 128) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r317 & 256) == 0) goto L21;
        Map r112 = MapsKt.emptyMap();
    L23:
        if ((r317 & 512) == 0) goto L25;
        Map r113 = MapsKt.emptyMap();
    L27:
        if ((r317 & 1024) == 0) goto L29;
        Map r114 = MapsKt.emptyMap();
    L31:
        if ((r317 & 2048) == 0) goto L33;
        Map r115 = MapsKt.emptyMap();
    L35:
        if ((r317 & 4096) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r317 & 8192) == 0) goto L41;
        List r117 = null;
    L43:
        if ((r317 & 16384) == 0) goto L45;
        Boolean r118 = Boolean.FALSE;
    L47:
        if ((r317 & 32768) == 0) goto L49;
        String r119 = null;
    L50:
        this(r210, r211, r212, r213, r100, r101, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
        return;
    L49:
        r119 = r316;
        goto L50
    L45:
        r118 = r315;
        goto L47
    L41:
        r117 = r314;
        goto L43
    L37:
        r116 = r313;
        goto L39
    L33:
        r115 = r312;
        goto L35
    L29:
        r114 = r311;
        goto L31
    L25:
        r113 = r310;
        goto L27
    L21:
        r112 = r218;
        goto L23
    L17:
        r111 = r217;
        goto L19
    L13:
        r110 = r216;
        goto L15
    L9:
        r101 = r215;
        goto L11
    L5:
        r100 = r214;
        goto L7
    }
}
