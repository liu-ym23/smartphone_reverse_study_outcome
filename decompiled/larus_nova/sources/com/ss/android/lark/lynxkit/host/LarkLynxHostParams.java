package com.ss.android.lark.lynxkit.host;

import android.view.ViewGroup;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bO\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b(\u0010)J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J\u0017\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00102J\t\u0010X\u001a\u00020\fHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010c\u001a\u00020\fHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010g\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010h\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010HJ\t\u0010i\u001a\u00020\fHÆ\u0003J\t\u0010j\u001a\u00020\fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jø\u0002\u0010o\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020\f2\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010s\u001a\u00020\nHÖ\u0001J\t\u0010t\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bB\u00105R\u0011\u0010\u001a\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bC\u00105R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00103\u001a\u0004\bE\u00102R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00103\u001a\u0004\bF\u00102R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR\u0011\u0010 \u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bJ\u00105R\u0011\u0010!\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010+R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010+¨\u0006u"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "", "templateUrl", "", "templatePath", "initDataJson", "initDataMap", "", "lynxViewShareData", "containerBackgroundColor", "", DyPayConstant.KEY_SHOW_LOADING, "", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "containerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "tagForJsContext", "tagForCustomComponent", "tagForGlobalData", "tagForBridgeMethodDispatcher", "tagForBridgeMethodGroup", "tagForJSModule", "tagForTemplateLoader", "devToolSocketUrl", "enableDevToolsDebug", "enableUserCodeCache", "codeCacheSourceUrl", "widthMeasureSpec", "heightMeasureSpec", "fontScale", "", "enableAsyncRender", "enableAsyncRenderForList", "tagForBridgeProtocol", "bridgeRuntimeFactory", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "bridgeProtocol", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "bridgeProtocolContainerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZLandroid/view/ViewGroup$LayoutParams;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;ZZLjava/lang/String;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;Ljava/lang/String;)V", "getTemplateUrl", "()Ljava/lang/String;", "getTemplatePath", "getInitDataJson", "getInitDataMap", "()Ljava/util/Map;", "getLynxViewShareData", "getContainerBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowLoading", "()Z", "getLayoutParams", "()Landroid/view/ViewGroup$LayoutParams;", "getContainerContext", "()Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "getTagForJsContext", "getTagForCustomComponent", "getTagForGlobalData", "getTagForBridgeMethodDispatcher", "getTagForBridgeMethodGroup", "getTagForJSModule", "getTagForTemplateLoader", "getDevToolSocketUrl", "getEnableDevToolsDebug", "getEnableUserCodeCache", "getCodeCacheSourceUrl", "getWidthMeasureSpec", "getHeightMeasureSpec", "getFontScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEnableAsyncRender", "getEnableAsyncRenderForList", "getTagForBridgeProtocol", "getBridgeRuntimeFactory", "()Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "getBridgeProtocol", "()Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "getBridgeProtocolContainerId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;ZLandroid/view/ViewGroup$LayoutParams;Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;ZZLjava/lang/String;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;Ljava/lang/String;)Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "equals", "other", "hashCode", "toString", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLynxHostParams {
    private final ILarkLynxBridgeProtocol bridgeProtocol;
    private final String bridgeProtocolContainerId;
    private final ILarkLynxBridgeRuntimeFactory bridgeRuntimeFactory;
    private final String codeCacheSourceUrl;
    private final Integer containerBackgroundColor;
    private final ILynxContainerContext containerContext;
    private final String devToolSocketUrl;
    private final boolean enableAsyncRender;
    private final boolean enableAsyncRenderForList;
    private final boolean enableDevToolsDebug;
    private final boolean enableUserCodeCache;
    private final Float fontScale;
    private final Integer heightMeasureSpec;
    private final String initDataJson;
    private final Map<String, Object> initDataMap;
    private final ViewGroup.LayoutParams layoutParams;
    private final Map<String, Object> lynxViewShareData;
    private final boolean showLoading;
    private final String tagForBridgeMethodDispatcher;
    private final String tagForBridgeMethodGroup;
    private final String tagForBridgeProtocol;
    private final String tagForCustomComponent;
    private final String tagForGlobalData;
    private final String tagForJSModule;
    private final String tagForJsContext;
    private final String tagForTemplateLoader;
    private final String templatePath;
    private final String templateUrl;
    private final Integer widthMeasureSpec;

    public LarkLynxHostParams() {
        this(null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, false, false, null, null, null, null, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkLynxHostParams copy$default(LarkLynxHostParams r110, String r111, String r112, String r210, Map r211, Map r212, Integer r213, boolean r214, ViewGroup.LayoutParams r215, ILynxContainerContext r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, boolean r315, boolean r316, String r317, Integer r318, Integer r319, Float r410, boolean r411, boolean r412, String r413, ILarkLynxBridgeRuntimeFactory r414, ILarkLynxBridgeProtocol r415, String r416, int r417, Object r418) {
        if ((r417 & 1) == 0) goto L5;
        String r100 = r110.templateUrl;
    L7:
        if ((r417 & 2) == 0) goto L9;
        String r101 = r110.templatePath;
    L11:
        if ((r417 & 4) == 0) goto L13;
        String r102 = r110.initDataJson;
    L15:
        if ((r417 & 8) == 0) goto L17;
        Map r103 = r110.initDataMap;
    L19:
        if ((r417 & 16) == 0) goto L21;
        Map r104 = r110.lynxViewShareData;
    L23:
        if ((r417 & 32) == 0) goto L25;
        Integer r105 = r110.containerBackgroundColor;
    L27:
        if ((r417 & 64) == 0) goto L29;
        boolean r106 = r110.showLoading;
    L31:
        if ((r417 & 128) == 0) goto L33;
        ViewGroup.LayoutParams r107 = r110.layoutParams;
    L35:
        if ((r417 & 256) == 0) goto L37;
        ILynxContainerContext r113 = r110.containerContext;
    L39:
        if ((r417 & 512) == 0) goto L41;
        String r114 = r110.tagForJsContext;
    L43:
        if ((r417 & 1024) == 0) goto L45;
        String r115 = r110.tagForCustomComponent;
    L47:
        if ((r417 & 2048) == 0) goto L49;
        String r116 = r110.tagForGlobalData;
    L51:
        if ((r417 & 4096) == 0) goto L53;
        String r117 = r110.tagForBridgeMethodDispatcher;
    L55:
        if ((r417 & 8192) == 0) goto L57;
        String r118 = r110.tagForBridgeMethodGroup;
    L58:
        String r320 = r118;
        if ((r417 & 16384) == 0) goto L61;
        String r119 = r110.tagForJSModule;
    L62:
        String r321 = r119;
        if ((r417 & 32768) == 0) goto L65;
        String r120 = r110.tagForTemplateLoader;
    L66:
        String r322 = r120;
        if ((r417 & 65536) == 0) goto L69;
        String r121 = r110.devToolSocketUrl;
    L70:
        String r323 = r121;
        if ((r417 & 131072) == 0) goto L73;
        boolean r122 = r110.enableDevToolsDebug;
    L74:
        boolean r324 = r122;
        if ((r417 & 262144) == 0) goto L77;
        boolean r123 = r110.enableUserCodeCache;
    L78:
        boolean r325 = r123;
        if ((r417 & 524288) == 0) goto L81;
        String r124 = r110.codeCacheSourceUrl;
    L82:
        String r326 = r124;
        if ((r417 & 1048576) == 0) goto L85;
        Integer r125 = r110.widthMeasureSpec;
    L86:
        Integer r327 = r125;
        if ((r417 & 2097152) == 0) goto L89;
        Integer r126 = r110.heightMeasureSpec;
    L90:
        Integer r328 = r126;
        if ((r417 & 4194304) == 0) goto L93;
        Float r127 = r110.fontScale;
    L94:
        Float r419 = r127;
        if ((r417 & 8388608) == 0) goto L97;
        boolean r128 = r110.enableAsyncRender;
    L98:
        boolean r420 = r128;
        if ((r417 & 16777216) == 0) goto L101;
        boolean r129 = r110.enableAsyncRenderForList;
    L102:
        boolean r421 = r129;
        if ((r417 & 33554432) == 0) goto L105;
        String r130 = r110.tagForBridgeProtocol;
    L106:
        String r422 = r130;
        if ((r417 & 67108864) == 0) goto L109;
        ILarkLynxBridgeRuntimeFactory r131 = r110.bridgeRuntimeFactory;
    L110:
        ILarkLynxBridgeRuntimeFactory r423 = r131;
        if ((r417 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        ILarkLynxBridgeProtocol r132 = r110.bridgeProtocol;
    L115:
        if ((r417 & 268435456) == 0) goto L117;
        String r108 = r110.bridgeProtocolContainerId;
    L119:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r419, r420, r421, r422, r423, r132, r108);
    L117:
        r108 = r416;
        goto L119
    L113:
        r132 = r415;
        goto L115
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
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

    public final String component1() {
        return this.templateUrl;
    }

    public final String component10() {
        return this.tagForJsContext;
    }

    public final String component11() {
        return this.tagForCustomComponent;
    }

    public final String component12() {
        return this.tagForGlobalData;
    }

    public final String component13() {
        return this.tagForBridgeMethodDispatcher;
    }

    public final String component14() {
        return this.tagForBridgeMethodGroup;
    }

    public final String component15() {
        return this.tagForJSModule;
    }

    public final String component16() {
        return this.tagForTemplateLoader;
    }

    public final String component17() {
        return this.devToolSocketUrl;
    }

    public final boolean component18() {
        return this.enableDevToolsDebug;
    }

    public final boolean component19() {
        return this.enableUserCodeCache;
    }

    public final String component2() {
        return this.templatePath;
    }

    public final String component20() {
        return this.codeCacheSourceUrl;
    }

    public final Integer component21() {
        return this.widthMeasureSpec;
    }

    public final Integer component22() {
        return this.heightMeasureSpec;
    }

    public final Float component23() {
        return this.fontScale;
    }

    public final boolean component24() {
        return this.enableAsyncRender;
    }

    public final boolean component25() {
        return this.enableAsyncRenderForList;
    }

    public final String component26() {
        return this.tagForBridgeProtocol;
    }

    public final ILarkLynxBridgeRuntimeFactory component27() {
        return this.bridgeRuntimeFactory;
    }

    public final ILarkLynxBridgeProtocol component28() {
        return this.bridgeProtocol;
    }

    public final String component29() {
        return this.bridgeProtocolContainerId;
    }

    public final String component3() {
        return this.initDataJson;
    }

    public final Map<String, Object> component4() {
        return this.initDataMap;
    }

    public final Map<String, Object> component5() {
        return this.lynxViewShareData;
    }

    public final Integer component6() {
        return this.containerBackgroundColor;
    }

    public final boolean component7() {
        return this.showLoading;
    }

    public final ViewGroup.LayoutParams component8() {
        return this.layoutParams;
    }

    public final ILynxContainerContext component9() {
        return this.containerContext;
    }

    public final LarkLynxHostParams copy(String r310, String r311, String r312, Map<String, ? extends Object> r313, Map<String, ? extends Object> r314, Integer r315, boolean r316, ViewGroup.LayoutParams r317, ILynxContainerContext r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, boolean r419, boolean r510, String r511, Integer r512, Integer r513, Float r514, boolean r515, boolean r516, String r517, ILarkLynxBridgeRuntimeFactory r518, ILarkLynxBridgeProtocol r519, String r610) {
        return new LarkLynxHostParams(r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkLynxHostParams) == true) goto L8;
        return false;
    L8:
        LarkLynxHostParams r101 = (LarkLynxHostParams) r100;
        if (Intrinsics.areEqual(this.templateUrl, r101.templateUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templatePath, r101.templatePath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.initDataJson, r101.initDataJson) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.initDataMap, r101.initDataMap) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lynxViewShareData, r101.lynxViewShareData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.containerBackgroundColor, r101.containerBackgroundColor) == true) goto L27;
        return false;
    L27:
        if (this.showLoading == r101.showLoading) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.layoutParams, r101.layoutParams) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.containerContext, r101.containerContext) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagForJsContext, r101.tagForJsContext) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.tagForCustomComponent, r101.tagForCustomComponent) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tagForGlobalData, r101.tagForGlobalData) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tagForBridgeMethodDispatcher, r101.tagForBridgeMethodDispatcher) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.tagForBridgeMethodGroup, r101.tagForBridgeMethodGroup) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.tagForJSModule, r101.tagForJSModule) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.tagForTemplateLoader, r101.tagForTemplateLoader) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.devToolSocketUrl, r101.devToolSocketUrl) == true) goto L60;
        return false;
    L60:
        if (this.enableDevToolsDebug == r101.enableDevToolsDebug) goto L63;
        return false;
    L63:
        if (this.enableUserCodeCache == r101.enableUserCodeCache) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.codeCacheSourceUrl, r101.codeCacheSourceUrl) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.widthMeasureSpec, r101.widthMeasureSpec) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.heightMeasureSpec, r101.heightMeasureSpec) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.fontScale, r101.fontScale) == true) goto L78;
        return false;
    L78:
        if (this.enableAsyncRender == r101.enableAsyncRender) goto L81;
        return false;
    L81:
        if (this.enableAsyncRenderForList == r101.enableAsyncRenderForList) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.tagForBridgeProtocol, r101.tagForBridgeProtocol) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.bridgeRuntimeFactory, r101.bridgeRuntimeFactory) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.bridgeProtocol, r101.bridgeProtocol) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.bridgeProtocolContainerId, r101.bridgeProtocolContainerId) == true) goto L95;
        return false;
    L95:
        return true;
    }

    public int hashCode() {
        String r100 = this.templateUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.templatePath;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.initDataJson;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.initDataMap;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.lynxViewShareData;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.containerBackgroundColor;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        int r119 = 1231;
        if (this.showLoading == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r118 + r120) * 31;
        ViewGroup.LayoutParams r122 = this.layoutParams;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        ILynxContainerContext r125 = this.containerContext;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.tagForJsContext;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.tagForCustomComponent;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.tagForGlobalData;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.tagForBridgeMethodDispatcher;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.tagForBridgeMethodGroup;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.tagForJSModule;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.tagForTemplateLoader;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.devToolSocketUrl;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        if (this.enableDevToolsDebug == false) goto L73;
        int r152 = 1231;
    L74:
        int r153 = (r151 + r152) * 31;
        if (this.enableUserCodeCache == false) goto L77;
        int r154 = 1231;
    L78:
        int r155 = (r153 + r154) * 31;
        String r156 = this.codeCacheSourceUrl;
        if (r156 != null) goto L81;
        int r157 = 0;
    L82:
        int r158 = (r155 + r157) * 31;
        Integer r159 = this.widthMeasureSpec;
        if (r159 != null) goto L85;
        int r160 = 0;
    L86:
        int r161 = (r158 + r160) * 31;
        Integer r162 = this.heightMeasureSpec;
        if (r162 != null) goto L89;
        int r163 = 0;
    L90:
        int r164 = (r161 + r163) * 31;
        Float r165 = this.fontScale;
        if (r165 != null) goto L93;
        int r166 = 0;
    L94:
        int r167 = (r164 + r166) * 31;
        if (this.enableAsyncRender == false) goto L97;
        int r168 = 1231;
    L98:
        int r169 = (r167 + r168) * 31;
        if (this.enableAsyncRenderForList == true) goto L102;
        r119 = 1237;
    L102:
        int r170 = (r169 + r119) * 31;
        String r171 = this.tagForBridgeProtocol;
        if (r171 != null) goto L105;
        int r172 = 0;
    L106:
        int r173 = (r170 + r172) * 31;
        ILarkLynxBridgeRuntimeFactory r174 = this.bridgeRuntimeFactory;
        if (r174 != null) goto L109;
        int r175 = 0;
    L110:
        int r176 = (r173 + r175) * 31;
        ILarkLynxBridgeProtocol r177 = this.bridgeProtocol;
        if (r177 != null) goto L113;
        int r178 = 0;
    L114:
        int r179 = (r176 + r178) * 31;
        String r180 = this.bridgeProtocolContainerId;
        if (r180 == null) goto L119;
        r101 = r180.hashCode();
    L119:
        return r179 + r101;
    L113:
        r178 = r177.hashCode();
        goto L114
    L109:
        r175 = r174.hashCode();
        goto L110
    L105:
        r172 = r171.hashCode();
        goto L106
    L97:
        r168 = 1237;
        goto L98
    L93:
        r166 = r165.hashCode();
        goto L94
    L89:
        r163 = r162.hashCode();
        goto L90
    L85:
        r160 = r159.hashCode();
        goto L86
    L81:
        r157 = r156.hashCode();
        goto L82
    L77:
        r154 = 1237;
        goto L78
    L73:
        r152 = 1237;
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
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
        r120 = 1237;
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
        return "LarkLynxHostParams(templateUrl=" + this.templateUrl + ", templatePath=" + this.templatePath + ", initDataJson=" + this.initDataJson + ", initDataMap=" + this.initDataMap + ", lynxViewShareData=" + this.lynxViewShareData + ", containerBackgroundColor=" + this.containerBackgroundColor + ", showLoading=" + this.showLoading + ", layoutParams=" + this.layoutParams + ", containerContext=" + this.containerContext + ", tagForJsContext=" + this.tagForJsContext + ", tagForCustomComponent=" + this.tagForCustomComponent + ", tagForGlobalData=" + this.tagForGlobalData + ", tagForBridgeMethodDispatcher=" + this.tagForBridgeMethodDispatcher + ", tagForBridgeMethodGroup=" + this.tagForBridgeMethodGroup + ", tagForJSModule=" + this.tagForJSModule + ", tagForTemplateLoader=" + this.tagForTemplateLoader + ", devToolSocketUrl=" + this.devToolSocketUrl + ", enableDevToolsDebug=" + this.enableDevToolsDebug + ", enableUserCodeCache=" + this.enableUserCodeCache + ", codeCacheSourceUrl=" + this.codeCacheSourceUrl + ", widthMeasureSpec=" + this.widthMeasureSpec + ", heightMeasureSpec=" + this.heightMeasureSpec + ", fontScale=" + this.fontScale + ", enableAsyncRender=" + this.enableAsyncRender + ", enableAsyncRenderForList=" + this.enableAsyncRenderForList + ", tagForBridgeProtocol=" + this.tagForBridgeProtocol + ", bridgeRuntimeFactory=" + this.bridgeRuntimeFactory + ", bridgeProtocol=" + this.bridgeProtocol + ", bridgeProtocolContainerId=" + this.bridgeProtocolContainerId + ')';
    }

    public final ILarkLynxBridgeProtocol getBridgeProtocol() {
        return this.bridgeProtocol;
    }

    public final String getBridgeProtocolContainerId() {
        return this.bridgeProtocolContainerId;
    }

    public final ILarkLynxBridgeRuntimeFactory getBridgeRuntimeFactory() {
        return this.bridgeRuntimeFactory;
    }

    public final String getCodeCacheSourceUrl() {
        return this.codeCacheSourceUrl;
    }

    public final Integer getContainerBackgroundColor() {
        return this.containerBackgroundColor;
    }

    public final ILynxContainerContext getContainerContext() {
        return this.containerContext;
    }

    public final String getDevToolSocketUrl() {
        return this.devToolSocketUrl;
    }

    public final boolean getEnableAsyncRender() {
        return this.enableAsyncRender;
    }

    public final boolean getEnableAsyncRenderForList() {
        return this.enableAsyncRenderForList;
    }

    public final boolean getEnableDevToolsDebug() {
        return this.enableDevToolsDebug;
    }

    public final boolean getEnableUserCodeCache() {
        return this.enableUserCodeCache;
    }

    public final Float getFontScale() {
        return this.fontScale;
    }

    public final Integer getHeightMeasureSpec() {
        return this.heightMeasureSpec;
    }

    public final String getInitDataJson() {
        return this.initDataJson;
    }

    public final Map<String, Object> getInitDataMap() {
        return this.initDataMap;
    }

    public final ViewGroup.LayoutParams getLayoutParams() {
        return this.layoutParams;
    }

    public final Map<String, Object> getLynxViewShareData() {
        return this.lynxViewShareData;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final String getTagForBridgeMethodDispatcher() {
        return this.tagForBridgeMethodDispatcher;
    }

    public final String getTagForBridgeMethodGroup() {
        return this.tagForBridgeMethodGroup;
    }

    public final String getTagForBridgeProtocol() {
        return this.tagForBridgeProtocol;
    }

    public final String getTagForCustomComponent() {
        return this.tagForCustomComponent;
    }

    public final String getTagForGlobalData() {
        return this.tagForGlobalData;
    }

    public final String getTagForJSModule() {
        return this.tagForJSModule;
    }

    public final String getTagForJsContext() {
        return this.tagForJsContext;
    }

    public final String getTagForTemplateLoader() {
        return this.tagForTemplateLoader;
    }

    public final String getTemplatePath() {
        return this.templatePath;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final Integer getWidthMeasureSpec() {
        return this.widthMeasureSpec;
    }

    public LarkLynxHostParams(String r100, String r101, String r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, Integer r105, boolean r106, ViewGroup.LayoutParams r110, ILynxContainerContext r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, boolean r210, boolean r211, String r212, Integer r213, Integer r214, Float r215, boolean r216, boolean r217, String r218, ILarkLynxBridgeRuntimeFactory r219, ILarkLynxBridgeProtocol r310, String r311) {
        this.templateUrl = r100;
        this.templatePath = r101;
        this.initDataJson = r102;
        this.initDataMap = r103;
        this.lynxViewShareData = r104;
        this.containerBackgroundColor = r105;
        this.showLoading = r106;
        this.layoutParams = r110;
        this.containerContext = r111;
        this.tagForJsContext = r112;
        this.tagForCustomComponent = r113;
        this.tagForGlobalData = r114;
        this.tagForBridgeMethodDispatcher = r115;
        this.tagForBridgeMethodGroup = r116;
        this.tagForJSModule = r117;
        this.tagForTemplateLoader = r118;
        this.devToolSocketUrl = r119;
        this.enableDevToolsDebug = r210;
        this.enableUserCodeCache = r211;
        this.codeCacheSourceUrl = r212;
        this.widthMeasureSpec = r213;
        this.heightMeasureSpec = r214;
        this.fontScale = r215;
        this.enableAsyncRender = r216;
        this.enableAsyncRenderForList = r217;
        this.tagForBridgeProtocol = r218;
        this.bridgeRuntimeFactory = r219;
        this.bridgeProtocol = r310;
        this.bridgeProtocolContainerId = r311;
    }

    public /* synthetic */ LarkLynxHostParams(String r310, String r311, String r312, Map r313, Map r314, Integer r315, boolean r316, ViewGroup.LayoutParams r317, ILynxContainerContext r318, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, boolean r418, boolean r419, String r510, Integer r511, Integer r512, Float r513, boolean r514, boolean r515, String r516, ILarkLynxBridgeRuntimeFactory r517, ILarkLynxBridgeProtocol r518, String r519, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r610 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r610 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r610 & 8) == 0) goto L17;
        Map r103 = null;
    L19:
        if ((r610 & 16) == 0) goto L21;
        Map r104 = null;
    L23:
        if ((r610 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r610 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r610 & 128) == 0) goto L33;
        ViewGroup.LayoutParams r110 = null;
    L35:
        if ((r610 & 256) == 0) goto L37;
        ILynxContainerContext r111 = null;
    L39:
        if ((r610 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r610 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r610 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r610 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r610 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r610 & 131072) == 0) goto L73;
        boolean r118 = false;
    L75:
        if ((r610 & 262144) == 0) goto L77;
        boolean r119 = false;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        String r210 = null;
    L83:
        if ((r610 & 1048576) == 0) goto L85;
        Integer r211 = null;
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        Integer r212 = null;
    L91:
        if ((r610 & 4194304) == 0) goto L93;
        Float r213 = null;
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        boolean r214 = false;
    L99:
        if ((r610 & 16777216) == 0) goto L101;
        boolean r215 = false;
    L103:
        if ((r610 & 33554432) == 0) goto L105;
        String r216 = null;
    L107:
        if ((r610 & 67108864) == 0) goto L109;
        ILarkLynxBridgeRuntimeFactory r217 = null;
    L111:
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        ILarkLynxBridgeProtocol r218 = null;
    L115:
        if ((r610 & 268435456) == 0) goto L117;
        String r109 = null;
    L118:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r109);
        return;
    L117:
        r109 = r519;
        goto L118
    L113:
        r218 = r518;
        goto L115
    L109:
        r217 = r517;
        goto L111
    L105:
        r216 = r516;
        goto L107
    L101:
        r215 = r515;
        goto L103
    L97:
        r214 = r514;
        goto L99
    L93:
        r213 = r513;
        goto L95
    L89:
        r212 = r512;
        goto L91
    L85:
        r211 = r511;
        goto L87
    L81:
        r210 = r510;
        goto L83
    L77:
        r119 = r419;
        goto L79
    L73:
        r118 = r418;
        goto L75
    L69:
        r117 = r417;
        goto L71
    L65:
        r116 = r416;
        goto L67
    L61:
        r108 = r415;
        goto L63
    L57:
        r107 = r414;
        goto L59
    L53:
        r115 = r413;
        goto L55
    L49:
        r114 = r412;
        goto L51
    L45:
        r113 = r411;
        goto L47
    L41:
        r112 = r410;
        goto L43
    L37:
        r111 = r318;
        goto L39
    L33:
        r110 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
