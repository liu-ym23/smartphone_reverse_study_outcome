package com.bytedance.locallife.dito.data;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\bg\b\u0086\b\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008e\u0001B\u0087\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00103\u001a\u00020\u0004\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010 \u0012\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\t\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"\u0012\u0018\b\u0002\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010(¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\tHÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0019\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"HÆ\u0003J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"HÆ\u0003J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010,J\u000b\u0010.\u001a\u0004\u0018\u00010(HÆ\u0003J\u008e\u0002\u0010@\u001a\u00020\u00002\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00101\u001a\u00020\u00042\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00103\u001a\u00020\u00042\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010 2\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\t2\b\b\u0002\u00109\u001a\u00020\u00042\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"2\u0018\b\u0002\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010(HÆ\u0001¢\u0006\u0004\b@\u0010AJ\t\u0010B\u001a\u00020\u0007HÖ\u0001J\t\u0010C\u001a\u00020\u0002HÖ\u0001J\u0013\u0010E\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010(HÖ\u0003R$\u0010/\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u00100\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010F\u001a\u0004\bK\u0010H\"\u0004\bL\u0010JR\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u00102\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010F\u001a\u0004\bR\u0010H\"\u0004\bS\u0010JR\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010M\u001a\u0004\bT\u0010O\"\u0004\bU\u0010QR$\u00104\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u00105\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u00106\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010e\u001a\u0004\bf\u0010gR0\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR*\u00108\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u00109\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010M\u001a\u0004\br\u0010OR\u001c\u0010:\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010F\u001a\u0004\bs\u0010HR*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010h\u001a\u0004\bt\u0010jR*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010h\u001a\u0004\bu\u0010jR$\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010v\u001a\u0004\bw\u0010,\"\u0004\bx\u0010yR$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010v\u001a\u0004\bz\u0010,\"\u0004\b{\u0010yR%\u0010?\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b?\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010MR\u001e\u0010\u0082\u0001\u001a\u00020\u00048FX\u0087\u0004¢\u0006\u000f\u0012\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0005\b\u0082\u0001\u0010OR\u0013\u0010\u0085\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010OR\u0013\u0010\u0086\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010OR\u0013\u0010\u0087\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010OR\u0013\u0010\u0088\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010OR\u0013\u0010\u0089\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010OR\u0013\u0010\u008a\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010O¨\u0006\u008f\u0001"}, d2 = {"Lcom/bytedance/locallife/dito/data/DitoNode;", "Ljava/io/Serializable;", "", "pageColumns", "", "isComponentNode", "isGroupNode", "", "eventName", "", "Lcom/bytedance/locallife/dito/data/DitoActionModel;", "getActions", "actionName", "getAction", "enableLoadStrategy", "isViewStubAndNotInflated", "isInflateViewStubAfterFmp", "", "markViewStubInflated", "isPresetSizeCacheEnable", "()Ljava/lang/Boolean;", "isPreloadInBody", "component1", "component2", "component3", "component4", "component5", "Lcom/bytedance/locallife/dito/data/d;", "component6", "component7", "Lcom/bytedance/locallife/dito/data/DitoStyle;", "component8", "Lcom/bytedance/locallife/dito/data/c;", "component9", "", "component10", "Lcom/bytedance/locallife/dito/data/DitoEvent;", "component11", "component12", "component13", "", "component14", "component15", "component16", "()Ljava/lang/Integer;", "component17", "component18", "type", "subType", "multiColumn", "updateType", "nodeIsFloat", "data", "style", "config", ThumbGlideUrl.SOURCE_TEMPLATE, "events", "receivePageScroll", "customTag", "trackParams", DitoNode.KEY_BTM_PARAMS, "dataRef", "trackParamsRef", "rawData", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/bytedance/locallife/dito/data/d;ILcom/bytedance/locallife/dito/data/DitoStyle;Lcom/bytedance/locallife/dito/data/c;Ljava/util/Map;Ljava/util/List;ZLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;)Lcom/bytedance/locallife/dito/data/DitoNode;", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getSubType", "setSubType", "Z", "getMultiColumn", "()Z", "setMultiColumn", "(Z)V", "getUpdateType", "setUpdateType", "getNodeIsFloat", "setNodeIsFloat", "Lcom/bytedance/locallife/dito/data/d;", "getData", "()Lcom/bytedance/locallife/dito/data/d;", "setData", "(Lcom/bytedance/locallife/dito/data/d;)V", "I", "getPageColumns", "()I", "setPageColumns", "(I)V", "Lcom/bytedance/locallife/dito/data/DitoStyle;", "getStyle", "()Lcom/bytedance/locallife/dito/data/DitoStyle;", "setStyle", "(Lcom/bytedance/locallife/dito/data/DitoStyle;)V", "Lcom/bytedance/locallife/dito/data/c;", "getConfig", "()Lcom/bytedance/locallife/dito/data/c;", "Ljava/util/Map;", "getTemplate", "()Ljava/util/Map;", "setTemplate", "(Ljava/util/Map;)V", "Ljava/util/List;", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "getReceivePageScroll", "getCustomTag", "getTrackParams", "getBtmParams", "Ljava/lang/Integer;", "getDataRef", "setDataRef", "(Ljava/lang/Integer;)V", "getTrackParamsRef", "setTrackParamsRef", "Ljava/lang/Object;", "getRawData", "()Ljava/lang/Object;", "setRawData", "(Ljava/lang/Object;)V", "viewStubInflated", "isStick", "isStick$annotations", "()V", "isFloat", "isComponentStick", "isChildViewStick", "isStickNode", "isComponentStickNode", "isChildViewStickNode", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/bytedance/locallife/dito/data/d;ILcom/bytedance/locallife/dito/data/DitoStyle;Lcom/bytedance/locallife/dito/data/c;Ljava/util/Map;Ljava/util/List;ZLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoNode implements Serializable {
    public static final String CLEAR = "clear";
    public static final a Companion = null;
    public static final String DITO_TRACK_TYPE = "ditoTrackType";
    public static final String DITO_TRACK_TYPE_GLOBAL = "global";
    public static final String KEY_BTM_PARAMS = "btmParams";
    public static final String LOAD_MORE = "loadMore";
    public static final String LOAD_STRATEGY_AFTER_FMP = "afterFmp";
    public static final String LOAD_STRATEGY_DEFAULT = "default";
    public static final String LOAD_STRATEGY_MANUAL = "manual";
    public static final String REFRESH = "refresh";
    public static final String REMOVE = "remove";
    public static final String UPDATE = "update";

    @SerializedName(KEY_BTM_PARAMS)
    private final Map<String, Object> btmParams;

    @SerializedName("config")
    private final c config;

    @SerializedName("customTag")
    private final String customTag;

    @SerializedName("data")
    private d data;

    @SerializedName("data_ref")
    private Integer dataRef;

    @SerializedName("events")
    private List<DitoEvent> events;

    @SerializedName(alternate = {"isSingle"}, value = "multiColumn")
    private boolean multiColumn;

    @SerializedName("isFloat")
    private boolean nodeIsFloat;

    @SerializedName("pageColumns")
    private int pageColumns;
    private Object rawData;

    @SerializedName("receivePageScroll")
    private final boolean receivePageScroll;

    @SerializedName("style")
    private DitoStyle style;

    @SerializedName("subType")
    private String subType;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private Map<String, String> template;

    @SerializedName("trackParams")
    private final Map<String, Object> trackParams;

    @SerializedName("track_params_ref")
    private Integer trackParamsRef;

    @SerializedName("type")
    private String type;

    @SerializedName("updateType")
    private String updateType;
    private boolean viewStubInflated;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DitoNode() {
        this(null, null, false, null, false, null, 0, null, null, null, null, false, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DitoNode copy$default(DitoNode r110, String r111, String r112, boolean r210, String r211, boolean r212, d r213, int r214, DitoStyle r215, c r216, Map r217, List r218, boolean r219, String r310, Map r311, Map r312, Integer r313, Integer r314, Object r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.type;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.subType;
    L11:
        if ((r316 & 4) == 0) goto L13;
        boolean r102 = r110.multiColumn;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.updateType;
    L19:
        if ((r316 & 16) == 0) goto L21;
        boolean r104 = r110.nodeIsFloat;
    L23:
        if ((r316 & 32) == 0) goto L25;
        d r105 = r110.data;
    L27:
        if ((r316 & 64) == 0) goto L29;
        int r106 = r110.pageColumns;
    L31:
        if ((r316 & 128) == 0) goto L33;
        DitoStyle r107 = r110.style;
    L35:
        if ((r316 & 256) == 0) goto L37;
        c r113 = r110.config;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Map r114 = r110.template;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        List r115 = r110.events;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        boolean r116 = r110.receivePageScroll;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r117 = r110.customTag;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        Map r118 = r110.trackParams;
    L58:
        Map r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        Map r119 = r110.btmParams;
    L62:
        Map r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        Integer r120 = r110.dataRef;
    L66:
        Integer r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        Integer r121 = r110.trackParamsRef;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        Object r108 = r110.rawData;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
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

    @Deprecated(message = "Replaced by isComponentStick or isChildViewStick")
    public static /* synthetic */ void isStick$annotations() {
    }

    public final String component1() {
        return this.type;
    }

    public final Map<String, String> component10() {
        return this.template;
    }

    public final List<DitoEvent> component11() {
        return this.events;
    }

    public final boolean component12() {
        return this.receivePageScroll;
    }

    public final String component13() {
        return this.customTag;
    }

    public final Map<String, Object> component14() {
        return this.trackParams;
    }

    public final Map<String, Object> component15() {
        return this.btmParams;
    }

    public final Integer component16() {
        return this.dataRef;
    }

    public final Integer component17() {
        return this.trackParamsRef;
    }

    public final Object component18() {
        return this.rawData;
    }

    public final String component2() {
        return this.subType;
    }

    public final boolean component3() {
        return this.multiColumn;
    }

    public final String component4() {
        return this.updateType;
    }

    public final boolean component5() {
        return this.nodeIsFloat;
    }

    public final d component6() {
        return this.data;
    }

    public final int component7() {
        return this.pageColumns;
    }

    public final DitoStyle component8() {
        return this.style;
    }

    public final c component9() {
        return this.config;
    }

    public final DitoNode copy(String r210, String r211, boolean r212, String r213, boolean r214, d r215, int r216, DitoStyle r217, c r218, Map<String, String> r310, List<DitoEvent> r311, boolean r312, String r313, Map<String, ? extends Object> r314, Map<String, ? extends Object> r315, Integer r316, Integer r317, Object r318) {
        return new DitoNode(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoNode) == true) goto L8;
        return false;
    L8:
        DitoNode r101 = (DitoNode) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L15;
        return false;
    L15:
        if (this.multiColumn == r101.multiColumn) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.updateType, r101.updateType) == true) goto L21;
        return false;
    L21:
        if (this.nodeIsFloat == r101.nodeIsFloat) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L27;
        return false;
    L27:
        if (this.pageColumns == r101.pageColumns) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.events, r101.events) == true) goto L42;
        return false;
    L42:
        if (this.receivePageScroll == r101.receivePageScroll) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.customTag, r101.customTag) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.btmParams, r101.btmParams) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.dataRef, r101.dataRef) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.trackParamsRef, r101.trackParamsRef) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.rawData, r101.rawData) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.subType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.multiColumn == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.updateType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.nodeIsFloat == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        d r115 = this.data;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (((r114 + r116) * 31) + this.pageColumns) * 31;
        DitoStyle r118 = this.style;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        c r121 = this.config;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Map<String, String> r124 = this.template;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        List<DitoEvent> r127 = this.events;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        if (this.receivePageScroll == true) goto L46;
        r107 = 1237;
    L46:
        int r130 = (r129 + r107) * 31;
        String r131 = this.customTag;
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        int r133 = (r130 + r132) * 31;
        Map<String, Object> r134 = this.trackParams;
        if (r134 != null) goto L53;
        int r135 = 0;
    L54:
        int r136 = (r133 + r135) * 31;
        Map<String, Object> r137 = this.btmParams;
        if (r137 != null) goto L57;
        int r138 = 0;
    L58:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.dataRef;
        if (r140 != null) goto L61;
        int r141 = 0;
    L62:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.trackParamsRef;
        if (r143 != null) goto L65;
        int r144 = 0;
    L66:
        int r145 = (r142 + r144) * 31;
        Object r146 = this.rawData;
        if (r146 == null) goto L71;
        r101 = r146.hashCode();
    L71:
        return r145 + r101;
    L65:
        r144 = r143.hashCode();
        goto L66
    L61:
        r141 = r140.hashCode();
        goto L62
    L57:
        r138 = r137.hashCode();
        goto L58
    L53:
        r135 = r134.hashCode();
        goto L54
    L49:
        r132 = r131.hashCode();
        goto L50
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final void markViewStubInflated() {
        this.viewStubInflated = true;
    }

    public String toString() {
        return "DitoNode(type=" + this.type + ", subType=" + this.subType + ", multiColumn=" + this.multiColumn + ", updateType=" + this.updateType + ", nodeIsFloat=" + this.nodeIsFloat + ", data=" + this.data + ", pageColumns=" + this.pageColumns + ", style=" + this.style + ", config=" + this.config + ", template=" + this.template + ", events=" + this.events + ", receivePageScroll=" + this.receivePageScroll + ", customTag=" + this.customTag + ", trackParams=" + this.trackParams + ", btmParams=" + this.btmParams + ", dataRef=" + this.dataRef + ", trackParamsRef=" + this.trackParamsRef + ", rawData=" + this.rawData + ')';
    }

    public final boolean isChildViewStick() {
        DitoStyle r100 = this.style;
        if (r100 == null) goto L14;
        ChildViewStick r101 = r100.getChildViewStick();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isStick() == true) goto L9;
        return false;
    L9:
        if (com.bytedance.locallife.dito.utils.j.i(r101.getStickNodeId()) == true) goto L11;
        return false;
    L11:
        if (com.bytedance.locallife.dito.utils.j.i(r101.getStickNodeContainerId()) == true) goto L13;
        return false;
    L13:
        return true;
    L14:
        return false;
    }

    public final boolean isComponentNode() {
        return Intrinsics.areEqual(this.type, "component");
    }

    public final boolean isComponentStick() {
        DitoStyle r100 = this.style;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getComponentStick();
    }

    public final boolean isFloat() {
        c r100 = this.config;
        if (r100 == null) goto L8;
        Boolean r101 = r100.g();
        if (r101 == null) goto L8;
        return r101.booleanValue();
    L8:
        return this.nodeIsFloat;
    }

    public final boolean isGroupNode() {
        return Intrinsics.areEqual(this.type, "group");
    }

    public final boolean isInflateViewStubAfterFmp() {
        c r100 = this.config;
        if (r100 == null) goto L5;
        String r101 = r100.c();
    L7:
        return Intrinsics.areEqual(r101, LOAD_STRATEGY_AFTER_FMP);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isPreloadInBody() {
        c r100 = this.config;
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.h(), Boolean.TRUE);
    }

    public final Boolean isPresetSizeCacheEnable() {
        c r100 = this.config;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public final boolean isStick() {
        DitoStyle r100 = this.style;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isStick();
    }

    public final int pageColumns() {
        int r100 = this.pageColumns;
        if (r100 != 0) goto L6;
        return 1;
    L6:
        return r100;
    }

    public final boolean isChildViewStickNode() {
        if (isStick() == false) goto L5;
    L8:
        return true;
    L5:
        if (isChildViewStick() == true) goto L8;
        return false;
    }

    public final boolean isComponentStickNode() {
        if (isStick() == false) goto L5;
    L8:
        return true;
    L5:
        if (isComponentStick() == true) goto L8;
        return false;
    }

    public final boolean isStickNode() {
        if (isStick() == false) goto L5;
    L10:
        return true;
    L5:
        if (isComponentStick() == true) goto L10;
        if (isChildViewStick() == true) goto L10;
        return false;
    }

    public final Map<String, Object> getBtmParams() {
        return this.btmParams;
    }

    public final c getConfig() {
        return this.config;
    }

    public final String getCustomTag() {
        return this.customTag;
    }

    public final d getData() {
        return this.data;
    }

    public final Integer getDataRef() {
        return this.dataRef;
    }

    public final List<DitoEvent> getEvents() {
        return this.events;
    }

    public final boolean getMultiColumn() {
        return this.multiColumn;
    }

    public final boolean getNodeIsFloat() {
        return this.nodeIsFloat;
    }

    public final int getPageColumns() {
        return this.pageColumns;
    }

    public final Object getRawData() {
        return this.rawData;
    }

    public final boolean getReceivePageScroll() {
        return this.receivePageScroll;
    }

    public final DitoStyle getStyle() {
        return this.style;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final Map<String, String> getTemplate() {
        return this.template;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final Integer getTrackParamsRef() {
        return this.trackParamsRef;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUpdateType() {
        return this.updateType;
    }

    public final List<DitoActionModel> getActions(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        List<DitoEvent> r101 = this.events;
        if (r101 != null) goto L8;
        return null;
    L8:
        Iterator<DitoEvent> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L15;
        DitoEvent r103 = r102.next();
        if (Intrinsics.areEqual(r103.getName(), r100) == false) goto L10;
        return r103.getActions();
    L15:
        return null;
    }

    public final boolean isViewStubAndNotInflated(boolean r100) {
        c r101 = this.config;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L23;
        if (r100 == false) goto L22;
        c r103 = this.config;
        String r104 = null;
        if (r103 == null) goto L13;
        String r105 = r103.c();
    L15:
        if (Intrinsics.areEqual(r105, LOAD_STRATEGY_AFTER_FMP) == true) goto L23;
        c r106 = this.config;
        if (r106 == null) goto L20;
        r104 = r106.c();
    L20:
        if (Intrinsics.areEqual(r104, "manual") == false) goto L22;
    L13:
        r105 = null;
    L22:
        boolean r107 = false;
    L24:
        if (r107 == true) goto L26;
        return false;
    L26:
        if (this.viewStubInflated == true) goto L30;
        return true;
    L30:
        return false;
    L23:
        r107 = true;
        goto L24
    L5:
        if (r101.f() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void setData(d r100) {
        this.data = r100;
    }

    public final void setDataRef(Integer r100) {
        this.dataRef = r100;
    }

    public final void setEvents(List<DitoEvent> r100) {
        this.events = r100;
    }

    public final void setMultiColumn(boolean r100) {
        this.multiColumn = r100;
    }

    public final void setNodeIsFloat(boolean r100) {
        this.nodeIsFloat = r100;
    }

    public final void setPageColumns(int r100) {
        this.pageColumns = r100;
    }

    public final void setRawData(Object r100) {
        this.rawData = r100;
    }

    public final void setStyle(DitoStyle r100) {
        this.style = r100;
    }

    public final void setSubType(String r100) {
        this.subType = r100;
    }

    public final void setTemplate(Map<String, String> r100) {
        this.template = r100;
    }

    public final void setTrackParamsRef(Integer r100) {
        this.trackParamsRef = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setUpdateType(String r100) {
        this.updateType = r100;
    }

    public final DitoActionModel getAction(String r100, String r101) {
        Object r102 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
        return null;
    L7:
        List<DitoActionModel> r103 = getActions(r100);
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((DitoActionModel) r105).getType(), r101) == false) goto L11;
        r102 = r105;
    L16:
        return (DitoActionModel) r102;
    L20:
        return null;
    }

    public DitoNode(String r100, String r101, boolean r102, String r103, boolean r104, d r105, int r106, DitoStyle r110, c r111, Map<String, String> r112, List<DitoEvent> r113, boolean r114, String r115, Map<String, ? extends Object> r116, Map<String, ? extends Object> r117, Integer r118, Integer r119, Object r210) {
        this.type = r100;
        this.subType = r101;
        this.multiColumn = r102;
        this.updateType = r103;
        this.nodeIsFloat = r104;
        this.data = r105;
        this.pageColumns = r106;
        this.style = r110;
        this.config = r111;
        this.template = r112;
        this.events = r113;
        this.receivePageScroll = r114;
        this.customTag = r115;
        this.trackParams = r116;
        this.btmParams = r117;
        this.dataRef = r118;
        this.trackParamsRef = r119;
        this.rawData = r210;
    }

    public /* synthetic */ DitoNode(String r210, String r211, boolean r212, String r213, boolean r214, d r215, int r216, DitoStyle r217, c r218, Map r219, List r310, boolean r311, String r312, Map r313, Map r314, Integer r315, Integer r316, Object r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L10:
        boolean r102 = false;
        if ((r318 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r104 = "refresh";
    L19:
        if ((r318 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r318 & 32) == 0) goto L25;
        d r106 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        int r107 = 1;
    L31:
        if ((r318 & 128) == 0) goto L33;
        DitoStyle r110 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        c r111 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        Map r112 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        List r113 = null;
    L47:
        if ((r318 & 2048) != 0) goto L51;
        r102 = r311;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        Map r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        Map r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        Integer r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        Object r109 = null;
    L74:
        this(r100, r101, r103, r104, r105, r106, r107, r110, r111, r112, r113, r102, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r219;
        goto L43
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r107 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }
}
