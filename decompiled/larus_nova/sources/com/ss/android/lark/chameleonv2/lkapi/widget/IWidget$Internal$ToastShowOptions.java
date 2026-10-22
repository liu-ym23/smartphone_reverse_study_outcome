package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÂ\u0003JÈ\u0001\u0010G\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020\nHÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b)\u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001eR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006N"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachedOnX", "", "content", "duration", "", "hoverBlockTimer", "", "lineClamp", "", "maxDisplayCount", "offsetY", "operations", "", "showClose", "showIcon", "typeX", "webviewId", "windowId", "wordWrap", "zOrderX", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHoverBlockTimer", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLineClamp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxDisplayCount", "getOffsetY", "getOperations", "()Ljava/util/List;", "getShowClose", "getShowIcon", "getWebviewId", "getWindowId", "getWordWrap", "attachedOn", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastAttachment;", "getAttachedOn", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastAttachment;", "type", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$XToastType;", "getType", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$XToastType;", "zOrder", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastZOrder;", "getZOrder", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastZOrder;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ToastShowOptions;", "equals", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ToastShowOptions implements NonProguard {
    private final String attachedOnX;
    private final String content;
    private final Long duration;
    private final Boolean hoverBlockTimer;
    private final Integer lineClamp;
    private final Integer maxDisplayCount;
    private final Integer offsetY;
    private final List<String> operations;
    private final Boolean showClose;
    private final Boolean showIcon;
    private final String typeX;
    private final Integer webviewId;
    private final String windowId;
    private final Boolean wordWrap;
    private final String zOrderX;

    public IWidget$Internal$ToastShowOptions() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    private final String component1() {
        return this.attachedOnX;
    }

    private final String component11() {
        return this.typeX;
    }

    private final String component15() {
        return this.zOrderX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IWidget$Internal$ToastShowOptions copy$default(IWidget$Internal$ToastShowOptions r110, String r111, String r112, Long r113, Boolean r210, Integer r211, Integer r212, Integer r213, List r214, Boolean r215, Boolean r216, String r217, Integer r218, String r219, Boolean r310, String r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.attachedOnX;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.content;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Long r102 = r110.duration;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Boolean r103 = r110.hoverBlockTimer;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Integer r104 = r110.lineClamp;
    L23:
        if ((r312 & 32) == 0) goto L25;
        Integer r105 = r110.maxDisplayCount;
    L27:
        if ((r312 & 64) == 0) goto L29;
        Integer r106 = r110.offsetY;
    L31:
        if ((r312 & 128) == 0) goto L33;
        List r107 = r110.operations;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Boolean r114 = r110.showClose;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Boolean r115 = r110.showIcon;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        String r116 = r110.typeX;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Integer r117 = r110.webviewId;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        String r118 = r110.windowId;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        Boolean r119 = r110.wordWrap;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        String r108 = r110.zOrderX;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Boolean component10() {
        return this.showIcon;
    }

    public final Integer component12() {
        return this.webviewId;
    }

    public final String component13() {
        return this.windowId;
    }

    public final Boolean component14() {
        return this.wordWrap;
    }

    public final String component2() {
        return this.content;
    }

    public final Long component3() {
        return this.duration;
    }

    public final Boolean component4() {
        return this.hoverBlockTimer;
    }

    public final Integer component5() {
        return this.lineClamp;
    }

    public final Integer component6() {
        return this.maxDisplayCount;
    }

    public final Integer component7() {
        return this.offsetY;
    }

    public final List<String> component8() {
        return this.operations;
    }

    public final Boolean component9() {
        return this.showClose;
    }

    public final IWidget$Internal$ToastShowOptions copy(@JSONField(name = "attachedOn") String r110, String r111, Long r210, Boolean r211, Integer r212, Integer r213, Integer r214, List<String> r215, Boolean r216, Boolean r217, @JSONField(name = "type") String r218, Integer r219, String r310, Boolean r311, @JSONField(name = "zOrder") String r312) {
        return new IWidget$Internal$ToastShowOptions(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IWidget$Internal$ToastShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$Internal$ToastShowOptions r101 = (IWidget$Internal$ToastShowOptions) r100;
        if (Intrinsics.areEqual(this.attachedOnX, r101.attachedOnX) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hoverBlockTimer, r101.hoverBlockTimer) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lineClamp, r101.lineClamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxDisplayCount, r101.maxDisplayCount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.offsetY, r101.offsetY) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.operations, r101.operations) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showClose, r101.showClose) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.showIcon, r101.showIcon) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.typeX, r101.typeX) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.webviewId, r101.webviewId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.windowId, r101.windowId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.wordWrap, r101.wordWrap) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.zOrderX, r101.zOrderX) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r100 = this.attachedOnX;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.duration;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.hoverBlockTimer;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.lineClamp;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.maxDisplayCount;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.offsetY;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.operations;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.showClose;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.showIcon;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.typeX;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.webviewId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.windowId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.wordWrap;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.zOrderX;
        if (r143 == null) goto L63;
        r101 = r143.hashCode();
    L63:
        return r142 + r101;
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ToastShowOptions(attachedOnX=" + this.attachedOnX + ", content=" + this.content + ", duration=" + this.duration + ", hoverBlockTimer=" + this.hoverBlockTimer + ", lineClamp=" + this.lineClamp + ", maxDisplayCount=" + this.maxDisplayCount + ", offsetY=" + this.offsetY + ", operations=" + this.operations + ", showClose=" + this.showClose + ", showIcon=" + this.showIcon + ", typeX=" + this.typeX + ", webviewId=" + this.webviewId + ", windowId=" + this.windowId + ", wordWrap=" + this.wordWrap + ", zOrderX=" + this.zOrderX + ')';
    }

    public final IWidget$Internal$ToastAttachment getAttachedOn() {
        String r100 = this.attachedOnX;
        IWidget$Internal$ToastAttachment r101 = null;
        if (r100 == null) goto L15;
        IWidget$Internal$ToastAttachment.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        IWidget$Internal$ToastAttachment[] r102 = IWidget$Internal$ToastAttachment.values();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        IWidget$Internal$ToastAttachment r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r100) == true) goto L8;
        r104 = r104 + 1;
        goto L5
    L8:
        r101 = r105;
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return IWidget$Internal$ToastAttachment.CURRENT_WINDOW;
    L15:
        return null;
    }

    public final IWidget$Internal$XToastType getType() {
        String r100 = this.typeX;
        IWidget$Internal$XToastType r101 = null;
        if (r100 == null) goto L15;
        IWidget$Internal$XToastType.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        IWidget$Internal$XToastType[] r102 = IWidget$Internal$XToastType.values();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        IWidget$Internal$XToastType r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r100) == true) goto L8;
        r104 = r104 + 1;
        goto L5
    L8:
        r101 = r105;
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return IWidget$Internal$XToastType.INFO;
    L15:
        return null;
    }

    public final IWidget$Internal$ToastZOrder getZOrder() {
        String r100 = this.zOrderX;
        IWidget$Internal$ToastZOrder r101 = null;
        if (r100 == null) goto L15;
        IWidget$Internal$ToastZOrder.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        IWidget$Internal$ToastZOrder[] r102 = IWidget$Internal$ToastZOrder.values();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        IWidget$Internal$ToastZOrder r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r100) == true) goto L8;
        r104 = r104 + 1;
        goto L5
    L8:
        r101 = r105;
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return IWidget$Internal$ToastZOrder.DEFAULT;
    L15:
        return null;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Boolean getHoverBlockTimer() {
        return this.hoverBlockTimer;
    }

    public final Integer getLineClamp() {
        return this.lineClamp;
    }

    public final Integer getMaxDisplayCount() {
        return this.maxDisplayCount;
    }

    public final Integer getOffsetY() {
        return this.offsetY;
    }

    public final List<String> getOperations() {
        return this.operations;
    }

    public final Boolean getShowClose() {
        return this.showClose;
    }

    public final Boolean getShowIcon() {
        return this.showIcon;
    }

    public final Integer getWebviewId() {
        return this.webviewId;
    }

    public final String getWindowId() {
        return this.windowId;
    }

    public final Boolean getWordWrap() {
        return this.wordWrap;
    }

    public IWidget$Internal$ToastShowOptions(@JSONField(name = "attachedOn") String r100, String r101, Long r102, Boolean r103, Integer r104, Integer r105, Integer r106, List<String> r107, Boolean r108, Boolean r110, @JSONField(name = "type") String r111, Integer r112, String r113, Boolean r114, @JSONField(name = "zOrder") String r115) {
        this.attachedOnX = r100;
        this.content = r101;
        this.duration = r102;
        this.hoverBlockTimer = r103;
        this.lineClamp = r104;
        this.maxDisplayCount = r105;
        this.offsetY = r106;
        this.operations = r107;
        this.showClose = r108;
        this.showIcon = r110;
        this.typeX = r111;
        this.webviewId = r112;
        this.windowId = r113;
        this.wordWrap = r114;
        this.zOrderX = r115;
    }

    public /* synthetic */ IWidget$Internal$ToastShowOptions(String r110, String r111, Long r112, Boolean r113, Integer r210, Integer r211, Integer r212, List r213, Boolean r214, Boolean r215, String r216, Integer r217, String r218, Boolean r219, String r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 1) == 0) goto L5;
        String r100 = "current-window";
    L6:
        String r101 = null;
        if ((r311 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        Long r103 = 3000L;
    L15:
        if ((r311 & 8) == 0) goto L17;
        Boolean r104 = Boolean.FALSE;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Integer r105 = 2;
    L23:
        if ((r311 & 32) == 0) goto L25;
        Integer r106 = 2;
    L27:
        if ((r311 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        Boolean r114 = Boolean.FALSE;
    L39:
        if ((r311 & 512) == 0) goto L41;
        Boolean r115 = Boolean.TRUE;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r116 = "info";
    L47:
        if ((r311 & 2048) == 0) goto L49;
        Integer r117 = null;
    L51:
        if ((r311 & 4096) != 0) goto L55;
        r101 = r218;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        Boolean r118 = Boolean.TRUE;
    L59:
        if ((r311 & 16384) == 0) goto L61;
        String r109 = "default";
    L62:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r101, r118, r109);
        return;
    L61:
        r109 = r310;
        goto L62
    L57:
        r118 = r219;
        goto L59
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
