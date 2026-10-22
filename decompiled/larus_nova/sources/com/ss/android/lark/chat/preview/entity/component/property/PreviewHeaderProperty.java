package com.ss.android.lark.chat.preview.entity.component.property;

import com.alipay.sdk.m.x.d;
import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.preview.entity.component.Tag;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 o2\u00020\u0001:\u0002opBÑ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010V\u001a\u00020\u0000H\u0016J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010]\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010`\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010h\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010lHÖ\u0003J\t\u0010m\u001a\u00020\u0011HÖ\u0001J\t\u0010n\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b\t\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b\u000b\u0010,\"\u0004\b0\u0010.R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010?\"\u0004\bC\u0010AR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010?\"\u0004\bI\u0010AR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\bN\u0010:\"\u0004\bO\u0010<R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!¨\u0006q"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "iconKey", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "title", "", "larkTag", "Lcom/ss/android/lark/chat/preview/entity/component/Tag;", "childComponentId", "isNeedCopyLink", "", "isNeedClose", "theme", "Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "headerType", "Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;", "numberOfLines", "", "tagColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "tagTextColor", "headerTag", "faviconUrl", "iconColor", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "iconSize", "dmIcon", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/Tag;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/ss/android/lark/chat/preview/entity/component/Theme;Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/UDIcon;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getIconKey", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setIconKey", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getLarkTag", "()Lcom/ss/android/lark/chat/preview/entity/component/Tag;", "setLarkTag", "(Lcom/ss/android/lark/chat/preview/entity/component/Tag;)V", "getChildComponentId", "setChildComponentId", "()Ljava/lang/Boolean;", "setNeedCopyLink", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setNeedClose", "getTheme", "()Lcom/ss/android/lark/chat/preview/entity/component/Theme;", "setTheme", "(Lcom/ss/android/lark/chat/preview/entity/component/Theme;)V", "getHeaderType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;", "setHeaderType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;)V", "getNumberOfLines", "()Ljava/lang/Integer;", "setNumberOfLines", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTagColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setTagColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getTagTextColor", "setTagTextColor", "getHeaderTag", "setHeaderTag", "getFaviconUrl", "setFaviconUrl", "getIconColor", "setIconColor", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "setUdIcon", "(Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getIconSize", "setIconSize", "getDmIcon", "setDmIcon", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/Tag;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/ss/android/lark/chat/preview/entity/component/Theme;Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/UDIcon;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ImageSet;)Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty;", "equals", "other", "", "hashCode", "toString", "Companion", "HeaderType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewHeaderProperty extends BaseProperty {
    public static final a Companion = null;
    public static final int DEFAULT_ICON_SIZE_DP = 16;
    private String childComponentId;
    private ImageSet dmIcon;
    private String faviconUrl;
    private String headerTag;
    private HeaderType headerType;
    private ThemeColor iconColor;
    private ImageSet iconKey;
    private Integer iconSize;
    private Boolean isNeedClose;
    private Boolean isNeedCopyLink;
    private Tag larkTag;
    private Integer numberOfLines;
    private ThemeColor tagColor;
    private ThemeColor tagTextColor;
    private Theme theme;
    private String title;
    private UDIcon udIcon;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/PreviewHeaderProperty$HeaderType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", EffectConstants.NORMAL, "HEADLINES", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HeaderType extends Enum<HeaderType> implements Serializable {
        public static final a Companion = null;
        public static final HeaderType HEADLINES = null;
        public static final HeaderType NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HeaderType[] f416257a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416258b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<HeaderType> getEntries() {
            return f416258b;
        }

        static {
            HeaderType r100 = new HeaderType(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            HeaderType r101 = new HeaderType("HEADLINES", 1, 1);
            HEADLINES = r101;
            HeaderType[] r102 = {r100, r101};
            f416257a = r102;
            f416258b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static HeaderType[] values() {
            return (HeaderType[]) f416257a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static HeaderType valueOf(String r100) {
            return (HeaderType) r27.a.a(HeaderType.class, r100);
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public HeaderType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ PreviewHeaderProperty copy$default(PreviewHeaderProperty r110, ImageSet r111, String r112, Tag r210, String r211, Boolean r212, Boolean r213, Theme r214, HeaderType r215, Integer r216, ThemeColor r217, ThemeColor r218, String r219, String r310, ThemeColor r311, UDIcon r312, Integer r313, ImageSet r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        ImageSet r100 = r110.iconKey;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Tag r102 = r110.larkTag;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.childComponentId;
    L19:
        if ((r315 & 16) == 0) goto L21;
        Boolean r104 = r110.isNeedCopyLink;
    L23:
        if ((r315 & 32) == 0) goto L25;
        Boolean r105 = r110.isNeedClose;
    L27:
        if ((r315 & 64) == 0) goto L29;
        Theme r106 = r110.theme;
    L31:
        if ((r315 & 128) == 0) goto L33;
        HeaderType r107 = r110.headerType;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Integer r113 = r110.numberOfLines;
    L39:
        if ((r315 & 512) == 0) goto L41;
        ThemeColor r114 = r110.tagColor;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        ThemeColor r115 = r110.tagTextColor;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.headerTag;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r110.faviconUrl;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        ThemeColor r118 = r110.iconColor;
    L58:
        ThemeColor r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        UDIcon r119 = r110.udIcon;
    L62:
        UDIcon r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        Integer r120 = r110.iconSize;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        ImageSet r108 = r110.dmIcon;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
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

    public final ImageSet component1() {
        return this.iconKey;
    }

    public final ThemeColor component10() {
        return this.tagColor;
    }

    public final ThemeColor component11() {
        return this.tagTextColor;
    }

    public final String component12() {
        return this.headerTag;
    }

    public final String component13() {
        return this.faviconUrl;
    }

    public final ThemeColor component14() {
        return this.iconColor;
    }

    public final UDIcon component15() {
        return this.udIcon;
    }

    public final Integer component16() {
        return this.iconSize;
    }

    public final ImageSet component17() {
        return this.dmIcon;
    }

    public final String component2() {
        return this.title;
    }

    public final Tag component3() {
        return this.larkTag;
    }

    public final String component4() {
        return this.childComponentId;
    }

    public final Boolean component5() {
        return this.isNeedCopyLink;
    }

    public final Boolean component6() {
        return this.isNeedClose;
    }

    public final Theme component7() {
        return this.theme;
    }

    public final HeaderType component8() {
        return this.headerType;
    }

    public final Integer component9() {
        return this.numberOfLines;
    }

    public final PreviewHeaderProperty copy(ImageSet r210, String r211, Tag r212, String r213, Boolean r214, Boolean r215, Theme r216, HeaderType r217, Integer r218, ThemeColor r219, ThemeColor r310, String r311, String r312, ThemeColor r313, UDIcon r314, Integer r315, ImageSet r316) {
        return new PreviewHeaderProperty(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreviewHeaderProperty) == true) goto L8;
        return false;
    L8:
        PreviewHeaderProperty r101 = (PreviewHeaderProperty) r100;
        if (Intrinsics.areEqual(this.iconKey, r101.iconKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (this.larkTag == r101.larkTag) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.childComponentId, r101.childComponentId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isNeedCopyLink, r101.isNeedCopyLink) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isNeedClose, r101.isNeedClose) == true) goto L27;
        return false;
    L27:
        if (this.theme == r101.theme) goto L30;
        return false;
    L30:
        if (this.headerType == r101.headerType) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.numberOfLines, r101.numberOfLines) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagColor, r101.tagColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.tagTextColor, r101.tagTextColor) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.headerTag, r101.headerTag) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.faviconUrl, r101.faviconUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.iconColor, r101.iconColor) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.udIcon, r101.udIcon) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.iconSize, r101.iconSize) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.dmIcon, r101.dmIcon) == true) goto L59;
        return false;
    L59:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        ImageSet r100 = this.iconKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Tag r107 = this.larkTag;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.childComponentId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isNeedCopyLink;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isNeedClose;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Theme r119 = this.theme;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        HeaderType r122 = this.headerType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.numberOfLines;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ThemeColor r128 = this.tagColor;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        ThemeColor r131 = this.tagTextColor;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.headerTag;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.faviconUrl;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        ThemeColor r140 = this.iconColor;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        UDIcon r143 = this.udIcon;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.iconSize;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        ImageSet r149 = this.dmIcon;
        if (r149 == null) goto L71;
        r101 = r149.hashCode();
    L71:
        return r148 + r101;
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
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
        return "PreviewHeaderProperty(iconKey=" + this.iconKey + ", title=" + this.title + ", larkTag=" + this.larkTag + ", childComponentId=" + this.childComponentId + ", isNeedCopyLink=" + this.isNeedCopyLink + ", isNeedClose=" + this.isNeedClose + ", theme=" + this.theme + ", headerType=" + this.headerType + ", numberOfLines=" + this.numberOfLines + ", tagColor=" + this.tagColor + ", tagTextColor=" + this.tagTextColor + ", headerTag=" + this.headerTag + ", faviconUrl=" + this.faviconUrl + ", iconColor=" + this.iconColor + ", udIcon=" + this.udIcon + ", iconSize=" + this.iconSize + ", dmIcon=" + this.dmIcon + ')';
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public PreviewHeaderProperty clone() {
        PreviewHeaderProperty r110 = new PreviewHeaderProperty(this.iconKey, this.title, this.larkTag, this.childComponentId, this.isNeedCopyLink, this.isNeedClose, this.theme, this.headerType, this.numberOfLines, this.tagColor, this.tagTextColor, this.headerTag, this.faviconUrl, this.iconColor, this.udIcon, this.iconSize, this.dmIcon);
        r110.setMarginLeft(getMarginLeft());
        r110.setMarginRight(getMarginRight());
        r110.setMarginTop(getMarginTop());
        r110.setMarginBottom(getMarginBottom());
        return r110;
    }

    public final String getChildComponentId() {
        return this.childComponentId;
    }

    public final ImageSet getDmIcon() {
        return this.dmIcon;
    }

    public final String getFaviconUrl() {
        return this.faviconUrl;
    }

    public final String getHeaderTag() {
        return this.headerTag;
    }

    public final HeaderType getHeaderType() {
        return this.headerType;
    }

    public final ThemeColor getIconColor() {
        return this.iconColor;
    }

    public final ImageSet getIconKey() {
        return this.iconKey;
    }

    public final Integer getIconSize() {
        return this.iconSize;
    }

    public final Tag getLarkTag() {
        return this.larkTag;
    }

    public final Integer getNumberOfLines() {
        return this.numberOfLines;
    }

    public final ThemeColor getTagColor() {
        return this.tagColor;
    }

    public final ThemeColor getTagTextColor() {
        return this.tagTextColor;
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final String getTitle() {
        return this.title;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    public final Boolean isNeedClose() {
        return this.isNeedClose;
    }

    public final Boolean isNeedCopyLink() {
        return this.isNeedCopyLink;
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public /* bridge */ /* synthetic */ Props clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L116;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        ImageSet r104 = null;
        UDIcon r105 = null;
        ThemeColor r106 = null;
        String r107 = null;
        String r108 = null;
        ThemeColor r109 = null;
        ThemeColor r110 = null;
        Boolean r111 = null;
        Boolean r112 = null;
        String r113 = null;
        String r114 = null;
        if (r103 == ComponentAttribute.icon.getValue()) goto L9;
        if (r103 == ComponentAttribute.title.getValue()) goto L15;
        int r115 = 0;
        if (r103 == ComponentAttribute.lark_tag.getValue()) goto L21;
        if (r103 == ComponentAttribute.child_component_id.getValue()) goto L29;
        if (r103 == ComponentAttribute.show_close_Btn.getValue()) goto L35;
        if (r103 == ComponentAttribute.show_copy_Link_Btn.getValue()) goto L41;
        if (r103 == ComponentAttribute.theme.getValue()) goto L47;
        if (r103 == ComponentAttribute.type.getValue()) goto L55;
        if (r103 == ComponentAttribute.number_of_lines.getValue()) goto L70;
        if (r103 == ComponentAttribute.tagColor.getValue()) goto L78;
        if (r103 == ComponentAttribute.tagTextColor.getValue()) goto L84;
        if (r103 == ComponentAttribute.header_tag.getValue()) goto L90;
        if (r103 == ComponentAttribute.favicon_url.getValue()) goto L96;
        if (r103 == ComponentAttribute.icon_color.getValue()) goto L102;
        if (r103 == ComponentAttribute.ud_icon_key.getValue()) goto L112;
        if (r103 == ComponentAttribute.ud_icon_theme_color.getValue()) goto L112;
        if (r103 != ComponentAttribute.unicode.getValue()) goto L6;
    L112:
        UDIcon r116 = this.udIcon;
        if (r116 == null) goto L115;
        r105 = r116.patchData(r102.getKey().intValue(), r102.getValue(), this.udIcon);
    L115:
        this.udIcon = r105;
        goto L6
    L102:
        PreviewData r117 = r102.getValue();
        if (r117 == null) goto L105;
        r106 = r117.getThemeColor();
    L105:
        this.iconColor = r106;
        goto L6
    L96:
        PreviewData r118 = r102.getValue();
        if (r118 == null) goto L99;
        r107 = r118.getString();
    L99:
        this.faviconUrl = r107;
        goto L6
    L90:
        PreviewData r119 = r102.getValue();
        if (r119 == null) goto L93;
        r108 = r119.getString();
    L93:
        this.headerTag = r108;
        goto L6
    L84:
        PreviewData r120 = r102.getValue();
        if (r120 == null) goto L87;
        r109 = r120.getThemeColor();
    L87:
        this.tagTextColor = r109;
        goto L6
    L78:
        PreviewData r121 = r102.getValue();
        if (r121 == null) goto L81;
        r110 = r121.getThemeColor();
    L81:
        this.tagColor = r110;
        goto L6
    L70:
        PreviewData r122 = r102.getValue();
        if (r122 == null) goto L74;
        int r123 = r122.getInt();
        if (r123 == null) goto L74;
    L75:
        this.numberOfLines = r123;
    L74:
        r123 = 3;
        goto L75
    L55:
        HeaderType.a r124 = HeaderType.Companion;
        PreviewData r125 = r102.getValue();
        if (r125 == null) goto L60;
        Integer r126 = r125.getInt();
        if (r126 == null) goto L60;
        r115 = r126.intValue();
    L60:
        r124.getClass();
        if (r115 != 0) goto L63;
        HeaderType r127 = HeaderType.NORMAL;
    L67:
        this.headerType = r127;
        goto L6
    L63:
        if (r115 == 1) goto L65;
        r127 = HeaderType.NORMAL;
        goto L67
    L65:
        r127 = HeaderType.HEADLINES;
        goto L67
    L47:
        Theme.a r128 = Theme.Companion;
        PreviewData r129 = r102.getValue();
        if (r129 == null) goto L52;
        Integer r130 = r129.getInt();
        if (r130 == null) goto L52;
        r115 = r130.intValue();
    L52:
        r128.getClass();
        this.theme = Theme.a.a(r115);
        goto L6
    L41:
        PreviewData r131 = r102.getValue();
        if (r131 == null) goto L44;
        r111 = r131.getBoolean();
    L44:
        this.isNeedCopyLink = r111;
        goto L6
    L35:
        PreviewData r132 = r102.getValue();
        if (r132 == null) goto L38;
        r112 = r132.getBoolean();
    L38:
        this.isNeedClose = r112;
        goto L6
    L29:
        PreviewData r133 = r102.getValue();
        if (r133 == null) goto L32;
        r113 = r133.getString();
    L32:
        this.childComponentId = r113;
        goto L6
    L21:
        Tag.a r134 = Tag.Companion;
        PreviewData r135 = r102.getValue();
        if (r135 == null) goto L26;
        Integer r136 = r135.getInt();
        if (r136 == null) goto L26;
        r115 = r136.intValue();
    L26:
        r134.getClass();
        this.larkTag = Tag.a.a(r115);
        goto L6
    L15:
        PreviewData r137 = r102.getValue();
        if (r137 == null) goto L18;
        r114 = r137.getString();
    L18:
        this.title = r114;
        goto L6
    L9:
        PreviewData r138 = r102.getValue();
        if (r138 == null) goto L12;
        r104 = r138.getImageSet();
    L12:
        this.iconKey = r104;
        goto L6
    }

    public final void setChildComponentId(String r100) {
        this.childComponentId = r100;
    }

    public final void setDmIcon(ImageSet r100) {
        this.dmIcon = r100;
    }

    public final void setFaviconUrl(String r100) {
        this.faviconUrl = r100;
    }

    public final void setHeaderTag(String r100) {
        this.headerTag = r100;
    }

    public final void setHeaderType(HeaderType r100) {
        this.headerType = r100;
    }

    public final void setIconColor(ThemeColor r100) {
        this.iconColor = r100;
    }

    public final void setIconKey(ImageSet r100) {
        this.iconKey = r100;
    }

    public final void setIconSize(Integer r100) {
        this.iconSize = r100;
    }

    public final void setLarkTag(Tag r100) {
        this.larkTag = r100;
    }

    public final void setNeedClose(Boolean r100) {
        this.isNeedClose = r100;
    }

    public final void setNeedCopyLink(Boolean r100) {
        this.isNeedCopyLink = r100;
    }

    public final void setNumberOfLines(Integer r100) {
        this.numberOfLines = r100;
    }

    public final void setTagColor(ThemeColor r100) {
        this.tagColor = r100;
    }

    public final void setTagTextColor(ThemeColor r100) {
        this.tagTextColor = r100;
    }

    public final void setTheme(Theme r100) {
        this.theme = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUdIcon(UDIcon r100) {
        this.udIcon = r100;
    }

    public PreviewHeaderProperty(ImageSet r100, String r101, Tag r102, String r103, Boolean r104, Boolean r105, Theme r106, HeaderType r110, Integer r111, ThemeColor r112, ThemeColor r113, String r114, String r115, ThemeColor r116, UDIcon r117, Integer r118, ImageSet r119) {
        super(Type.HEADER);
        this.iconKey = r100;
        this.title = r101;
        this.larkTag = r102;
        this.childComponentId = r103;
        this.isNeedCopyLink = r104;
        this.isNeedClose = r105;
        this.theme = r106;
        this.headerType = r110;
        this.numberOfLines = r111;
        this.tagColor = r112;
        this.tagTextColor = r113;
        this.headerTag = r114;
        this.faviconUrl = r115;
        this.iconColor = r116;
        this.udIcon = r117;
        this.iconSize = r118;
        this.dmIcon = r119;
    }

    public /* synthetic */ PreviewHeaderProperty(ImageSet r210, String r211, Tag r212, String r213, Boolean r214, Boolean r215, Theme r216, HeaderType r217, Integer r310, ThemeColor r311, ThemeColor r312, String r313, String r314, ThemeColor r315, UDIcon r316, Integer r317, ImageSet r318, int r319, DefaultConstructorMarker r410) {
        if ((r319 & 1) == 0) goto L5;
        ImageSet r100 = null;
    L7:
        if ((r319 & 4) == 0) goto L9;
        Tag r101 = null;
    L11:
        if ((r319 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r319 & 16) == 0) goto L17;
        Boolean r103 = null;
    L19:
        if ((r319 & 32) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r319 & 64) == 0) goto L25;
        Theme r110 = Theme.LIGHT;
    L27:
        if ((r319 & 128) == 0) goto L29;
        HeaderType r111 = HeaderType.NORMAL;
    L31:
        if ((r319 & 256) == 0) goto L33;
        Integer r112 = 3;
    L35:
        if ((r319 & 512) == 0) goto L37;
        ThemeColor r113 = null;
    L39:
        if ((r319 & 1024) == 0) goto L41;
        ThemeColor r114 = null;
    L43:
        if ((r319 & 2048) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r319 & 4096) == 0) goto L49;
        String r116 = null;
    L51:
        if ((r319 & 8192) == 0) goto L53;
        ThemeColor r117 = null;
    L55:
        if ((r319 & 16384) == 0) goto L57;
        UDIcon r118 = null;
    L59:
        if ((32768 & r319) == 0) goto L61;
        Integer r119 = 16;
    L63:
        if ((r319 & 65536) == 0) goto L65;
        ImageSet r218 = null;
    L66:
        this(r100, r211, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r218);
        return;
    L65:
        r218 = r318;
        goto L66
    L61:
        r119 = r317;
        goto L63
    L57:
        r118 = r316;
        goto L59
    L53:
        r117 = r315;
        goto L55
    L49:
        r116 = r314;
        goto L51
    L45:
        r115 = r313;
        goto L47
    L41:
        r114 = r312;
        goto L43
    L37:
        r113 = r311;
        goto L39
    L33:
        r112 = r310;
        goto L35
    L29:
        r111 = r217;
        goto L31
    L25:
        r110 = r216;
        goto L27
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
