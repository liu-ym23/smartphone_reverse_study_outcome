package com.bytedance.locallife.cube.api.config;

import android.view.View;
import com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering;
import com.lynx.jsbridge.LynxModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kp6.f;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bf\b\u0087\b\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008e\u0001B¯\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\b\b\u0002\u00103\u001a\u00020\u0006\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u00105\u001a\u00020\u0006\u0012\b\b\u0002\u00106\u001a\u00020\u0006\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019\u0012\b\b\u0002\u00108\u001a\u00020\u0006\u0012\b\b\u0002\u00109\u001a\u00020\u0006\u0012\b\b\u0003\u0010:\u001a\u00020\u0002\u0012\b\b\u0002\u0010;\u001a\u00020\u0002\u0012\b\b\u0003\u0010<\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010?\u001a\u00020\u0006\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u0012\b\b\u0002\u0010A\u001a\u00020\u0006\u0012*\b\u0002\u0010B\u001a$\u0012\u0004\u0012\u00020\u000b\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0(\u0012\u0006\u0012\u0004\u0018\u00010\u00010'0&\u0012\b\b\u0002\u0010C\u001a\u00020\u0006\u0012\b\b\u0002\u0010D\u001a\u00020\u0006\u0012\b\b\u0002\u0010E\u001a\u00020\u0006¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0000J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0002HÆ\u0003J\t\u0010 \u001a\u00020\u0002HÆ\u0003J\t\u0010!\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0002HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J+\u0010*\u001a$\u0012\u0004\u0012\u00020\u000b\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0(\u0012\u0006\u0012\u0004\u0018\u00010\u00010'0&HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J¶\u0002\u0010F\u001a\u00020\u00002\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00102\u001a\u00020\u00062\b\b\u0002\u00103\u001a\u00020\u00062\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u00020\u00062\b\b\u0002\u00106\u001a\u00020\u00062\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00192\b\b\u0002\u00108\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u00062\b\b\u0003\u0010:\u001a\u00020\u00022\b\b\u0002\u0010;\u001a\u00020\u00022\b\b\u0003\u0010<\u001a\u00020\u00022\b\b\u0002\u0010=\u001a\u00020\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010?\u001a\u00020\u00062\b\b\u0002\u0010@\u001a\u00020\u00022\b\b\u0002\u0010A\u001a\u00020\u00062*\b\u0002\u0010B\u001a$\u0012\u0004\u0012\u00020\u000b\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0(\u0012\u0006\u0012\u0004\u0018\u00010\u00010'0&2\b\b\u0002\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\bF\u0010GJ\t\u0010H\u001a\u00020\u000bHÖ\u0001R$\u0010.\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010I\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010LR$\u0010/\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010M\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010PR$\u00100\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010I\u001a\u0004\bQ\u0010\u000f\"\u0004\bR\u0010LR$\u00101\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010M\u001a\u0004\bS\u0010\u0011\"\u0004\bT\u0010PR\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u00103\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010U\u001a\u0004\bZ\u0010W\"\u0004\b[\u0010YR$\u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u00105\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010U\u001a\u0004\ba\u0010W\"\u0004\bb\u0010YR\"\u00106\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010U\u001a\u0004\bc\u0010W\"\u0004\bd\u0010YR*\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010e\u001a\u0004\bf\u0010\u001b\"\u0004\bg\u0010hR\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010U\u001a\u0004\bi\u0010W\"\u0004\bj\u0010YR\"\u00109\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010U\u001a\u0004\bk\u0010W\"\u0004\bl\u0010YR\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010m\u001a\u0004\br\u0010o\"\u0004\bs\u0010qR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010m\u001a\u0004\bt\u0010o\"\u0004\bu\u0010qR\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010m\u001a\u0004\bv\u0010o\"\u0004\bw\u0010qR$\u0010>\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\\\u001a\u0004\bx\u0010^\"\u0004\by\u0010`R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010U\u001a\u0004\bz\u0010W\"\u0004\b{\u0010YR\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010m\u001a\u0004\b|\u0010o\"\u0004\b}\u0010qR\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010U\u001a\u0004\b~\u0010W\"\u0004\b\u007f\u0010YRI\u0010B\u001a$\u0012\u0004\u0012\u00020\u000b\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020)0(\u0012\u0006\u0012\u0004\u0018\u00010\u00010'0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bB\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010C\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bC\u0010U\u001a\u0005\b\u0085\u0001\u0010W\"\u0005\b\u0086\u0001\u0010YR$\u0010D\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bD\u0010U\u001a\u0005\b\u0087\u0001\u0010W\"\u0005\b\u0088\u0001\u0010YR$\u0010E\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bE\u0010U\u001a\u0005\b\u0089\u0001\u0010W\"\u0005\b\u008a\u0001\u0010Y¨\u0006\u008f\u0001"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/LynxInitConfig;", "", "", "widthSpec", "heightSpec", "other", "", "equals", "hashCode", "lynxInitConfig", "", "", "different", "", "component1", "()Ljava/lang/Float;", "component2", "()Ljava/lang/Boolean;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "", "component10", "()[Ljava/lang/String;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "", "Lkotlin/Pair;", "Ljava/lang/Class;", "Lcom/lynx/jsbridge/LynxModule;", "component21", "component22", "component23", "component24", "fontScale", "fontScaleEnable", "mobileAdapterScale", "mobileAdapterScaleEnable", "enableSyncFlush", "enableJsGroupThread", "groupName", "shareGroup", "enableCanvas", "jsPaths", "enableDynamicV8", "enableCanvasOptimize", "widthSize", "widthSpecMode", "heightSize", "heightSpecMode", "codeCacheSourceUrl", "presetSafePoint", "threadStrategy", "enableMultiAsyncThread", "lynxModuleMap", "enableVsyncAlignedMessageLoop", "enableUIFlush", "enablePendingJsTask", "copy", "(Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;ZZLjava/lang/String;ZZ[Ljava/lang/String;ZZIIIILjava/lang/String;ZIZLjava/util/Map;ZZZ)Lcom/bytedance/locallife/cube/api/config/LynxInitConfig;", "toString", "Ljava/lang/Float;", "getFontScale", "setFontScale", "(Ljava/lang/Float;)V", "Ljava/lang/Boolean;", "getFontScaleEnable", "setFontScaleEnable", "(Ljava/lang/Boolean;)V", "getMobileAdapterScale", "setMobileAdapterScale", "getMobileAdapterScaleEnable", "setMobileAdapterScaleEnable", "Z", "getEnableSyncFlush", "()Z", "setEnableSyncFlush", "(Z)V", "getEnableJsGroupThread", "setEnableJsGroupThread", "Ljava/lang/String;", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "getShareGroup", "setShareGroup", "getEnableCanvas", "setEnableCanvas", "[Ljava/lang/String;", "getJsPaths", "setJsPaths", "([Ljava/lang/String;)V", "getEnableDynamicV8", "setEnableDynamicV8", "getEnableCanvasOptimize", "setEnableCanvasOptimize", "I", "getWidthSize", "()I", "setWidthSize", "(I)V", "getWidthSpecMode", "setWidthSpecMode", "getHeightSize", "setHeightSize", "getHeightSpecMode", "setHeightSpecMode", "getCodeCacheSourceUrl", "setCodeCacheSourceUrl", "getPresetSafePoint", "setPresetSafePoint", "getThreadStrategy", "setThreadStrategy", "getEnableMultiAsyncThread", "setEnableMultiAsyncThread", "Ljava/util/Map;", "getLynxModuleMap", "()Ljava/util/Map;", "setLynxModuleMap", "(Ljava/util/Map;)V", "getEnableVsyncAlignedMessageLoop", "setEnableVsyncAlignedMessageLoop", "getEnableUIFlush", "setEnableUIFlush", "getEnablePendingJsTask", "setEnablePendingJsTask", "<init>", "(Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;ZZLjava/lang/String;ZZ[Ljava/lang/String;ZZIIIILjava/lang/String;ZIZLjava/util/Map;ZZZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final class LynxInitConfig {
    public static final a Companion = null;
    private static final ThreadStrategyForRendering DEFAULT_THREAD_STRATEGY = null;
    private String codeCacheSourceUrl;
    private boolean enableCanvas;
    private boolean enableCanvasOptimize;
    private boolean enableDynamicV8;
    private boolean enableJsGroupThread;
    private boolean enableMultiAsyncThread;
    private boolean enablePendingJsTask;
    private boolean enableSyncFlush;
    private boolean enableUIFlush;
    private boolean enableVsyncAlignedMessageLoop;
    private Float fontScale;
    private Boolean fontScaleEnable;
    private String groupName;
    private int heightSize;
    private int heightSpecMode;
    private String[] jsPaths;
    private Map<String, Pair<Class<? extends LynxModule>, Object>> lynxModuleMap;
    private Float mobileAdapterScale;
    private Boolean mobileAdapterScaleEnable;
    private boolean presetSafePoint;
    private boolean shareGroup;
    private int threadStrategy;
    private int widthSize;
    private int widthSpecMode;

    public static final class a {
        public a() {
        }
    }

    public LynxInitConfig() {
        this(null, null, null, null, false, false, null, false, false, null, false, false, 0, 0, 0, 0, null, false, 0, false, null, false, false, false, 16777215, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxInitConfig copy$default(LynxInitConfig r110, Float r111, Boolean r112, Float r210, Boolean r211, boolean r212, boolean r213, String r214, boolean r215, boolean r216, String[] r217, boolean r218, boolean r219, int r310, int r311, int r312, int r313, String r314, boolean r315, int r316, boolean r317, Map r318, boolean r319, boolean r410, boolean r411, int r412, Object r413) {
        if ((r412 & 1) == 0) goto L5;
        Float r100 = r110.fontScale;
    L7:
        if ((r412 & 2) == 0) goto L9;
        Boolean r101 = r110.fontScaleEnable;
    L11:
        if ((r412 & 4) == 0) goto L13;
        Float r102 = r110.mobileAdapterScale;
    L15:
        if ((r412 & 8) == 0) goto L17;
        Boolean r103 = r110.mobileAdapterScaleEnable;
    L19:
        if ((r412 & 16) == 0) goto L21;
        boolean r104 = r110.enableSyncFlush;
    L23:
        if ((r412 & 32) == 0) goto L25;
        boolean r105 = r110.enableJsGroupThread;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r106 = r110.groupName;
    L31:
        if ((r412 & 128) == 0) goto L33;
        boolean r107 = r110.shareGroup;
    L35:
        if ((r412 & 256) == 0) goto L37;
        boolean r113 = r110.enableCanvas;
    L39:
        if ((r412 & 512) == 0) goto L41;
        String[] r114 = r110.jsPaths;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        boolean r115 = r110.enableDynamicV8;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        boolean r116 = r110.enableCanvasOptimize;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        int r117 = r110.widthSize;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        int r118 = r110.widthSpecMode;
    L58:
        int r320 = r118;
        if ((r412 & 16384) == 0) goto L61;
        int r119 = r110.heightSize;
    L62:
        int r321 = r119;
        if ((r412 & 32768) == 0) goto L65;
        int r120 = r110.heightSpecMode;
    L66:
        int r322 = r120;
        if ((r412 & 65536) == 0) goto L69;
        String r121 = r110.codeCacheSourceUrl;
    L70:
        String r323 = r121;
        if ((r412 & 131072) == 0) goto L73;
        boolean r122 = r110.presetSafePoint;
    L74:
        boolean r324 = r122;
        if ((r412 & 262144) == 0) goto L77;
        int r123 = r110.threadStrategy;
    L78:
        int r325 = r123;
        if ((r412 & 524288) == 0) goto L81;
        boolean r124 = r110.enableMultiAsyncThread;
    L82:
        boolean r326 = r124;
        if ((r412 & 1048576) == 0) goto L85;
        Map r125 = r110.lynxModuleMap;
    L86:
        Map r327 = r125;
        if ((r412 & 2097152) == 0) goto L89;
        boolean r126 = r110.enableVsyncAlignedMessageLoop;
    L90:
        boolean r328 = r126;
        if ((r412 & 4194304) == 0) goto L93;
        boolean r127 = r110.enableUIFlush;
    L95:
        if ((r412 & 8388608) == 0) goto L97;
        boolean r108 = r110.enablePendingJsTask;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r127, r108);
    L97:
        r108 = r411;
        goto L99
    L93:
        r127 = r410;
        goto L95
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

    public final Float component1() {
        return this.fontScale;
    }

    public final String[] component10() {
        return this.jsPaths;
    }

    public final boolean component11() {
        return this.enableDynamicV8;
    }

    public final boolean component12() {
        return this.enableCanvasOptimize;
    }

    public final int component13() {
        return this.widthSize;
    }

    public final int component14() {
        return this.widthSpecMode;
    }

    public final int component15() {
        return this.heightSize;
    }

    public final int component16() {
        return this.heightSpecMode;
    }

    public final String component17() {
        return this.codeCacheSourceUrl;
    }

    public final boolean component18() {
        return this.presetSafePoint;
    }

    public final int component19() {
        return this.threadStrategy;
    }

    public final Boolean component2() {
        return this.fontScaleEnable;
    }

    public final boolean component20() {
        return this.enableMultiAsyncThread;
    }

    public final Map<String, Pair<Class<? extends LynxModule>, Object>> component21() {
        return this.lynxModuleMap;
    }

    public final boolean component22() {
        return this.enableVsyncAlignedMessageLoop;
    }

    public final boolean component23() {
        return this.enableUIFlush;
    }

    public final boolean component24() {
        return this.enablePendingJsTask;
    }

    public final Float component3() {
        return this.mobileAdapterScale;
    }

    public final Boolean component4() {
        return this.mobileAdapterScaleEnable;
    }

    public final boolean component5() {
        return this.enableSyncFlush;
    }

    public final boolean component6() {
        return this.enableJsGroupThread;
    }

    public final String component7() {
        return this.groupName;
    }

    public final boolean component8() {
        return this.shareGroup;
    }

    public final boolean component9() {
        return this.enableCanvas;
    }

    public final LynxInitConfig copy(Float r210, Boolean r211, Float r212, Boolean r310, boolean r311, boolean r312, String r313, boolean r314, boolean r315, String[] r316, boolean r317, boolean r318, int r319, int r410, int r411, int r412, String r413, boolean r414, int r415, boolean r416, Map<String, Pair<Class<? extends LynxModule>, Object>> r417, boolean r418, boolean r419, boolean r510) {
        Intrinsics.checkNotNullParameter(r417, "lynxModuleMap");
        return new LynxInitConfig(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510);
    }

    public String toString() {
        return "LynxInitConfig(fontScale=" + this.fontScale + ", fontScaleEnable=" + this.fontScaleEnable + ", mobileAdapterScale=" + this.mobileAdapterScale + ", mobileAdapterScaleEnable=" + this.mobileAdapterScaleEnable + ", enableSyncFlush=" + this.enableSyncFlush + ", enableJsGroupThread=" + this.enableJsGroupThread + ", groupName=" + this.groupName + ", shareGroup=" + this.shareGroup + ", enableCanvas=" + this.enableCanvas + ", jsPaths=" + Arrays.toString(this.jsPaths) + ", enableDynamicV8=" + this.enableDynamicV8 + ", enableCanvasOptimize=" + this.enableCanvasOptimize + ", widthSize=" + this.widthSize + ", widthSpecMode=" + this.widthSpecMode + ", heightSize=" + this.heightSize + ", heightSpecMode=" + this.heightSpecMode + ", codeCacheSourceUrl=" + this.codeCacheSourceUrl + ", presetSafePoint=" + this.presetSafePoint + ", threadStrategy=" + this.threadStrategy + ", enableMultiAsyncThread=" + this.enableMultiAsyncThread + ", lynxModuleMap=" + this.lynxModuleMap + ", enableVsyncAlignedMessageLoop=" + this.enableVsyncAlignedMessageLoop + ", enableUIFlush=" + this.enableUIFlush + ", enablePendingJsTask=" + this.enablePendingJsTask + ')';
    }

    static {
        Companion = new a();
        DEFAULT_THREAD_STRATEGY = ThreadStrategyForRendering.MULTI_THREADS;
    }

    public int hashCode() {
        Float r100 = this.fontScale;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.fontScaleEnable;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.enableSyncFlush == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.groupName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.shareGroup == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.enableCanvas == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        String[] r117 = this.jsPaths;
        if (r117 == null) goto L29;
        int r118 = Arrays.hashCode(r117);
    L30:
        int r119 = (r116 + r118) * 31;
        if (this.enableDynamicV8 == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        if (this.enableCanvasOptimize == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (((((((((r121 + r122) * 31) + this.widthSize) * 31) + this.widthSpecMode) * 31) + this.heightSize) * 31) + this.heightSpecMode) * 31;
        String r124 = this.codeCacheSourceUrl;
        if (r124 == null) goto L41;
        r101 = r124.hashCode();
    L41:
        int r125 = (r123 + r101) * 31;
        if (this.presetSafePoint == false) goto L44;
        int r126 = 1231;
    L45:
        int r127 = (((r125 + r126) * 31) + this.threadStrategy) * 31;
        if (this.enableMultiAsyncThread == false) goto L48;
        int r128 = 1231;
    L49:
        int r129 = (r127 + r128) * 31;
        if (this.enableVsyncAlignedMessageLoop == false) goto L52;
        int r130 = 1231;
    L53:
        int r131 = (r129 + r130) * 31;
        if (this.enableJsGroupThread == false) goto L56;
        int r132 = 1231;
    L57:
        int r133 = (r131 + r132) * 31;
        if (this.enablePendingJsTask == true) goto L62;
        r107 = 1237;
    L62:
        return r133 + r107;
    L56:
        r132 = 1237;
        goto L57
    L52:
        r130 = 1237;
        goto L53
    L48:
        r128 = 1237;
        goto L49
    L44:
        r126 = 1237;
        goto L45
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = 0;
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final int heightSpec() {
        return View.MeasureSpec.makeMeasureSpec(this.heightSize, this.heightSpecMode);
    }

    public final int widthSpec() {
        return View.MeasureSpec.makeMeasureSpec(this.widthSize, this.widthSpecMode);
    }

    public static final /* synthetic */ ThreadStrategyForRendering access$getDEFAULT_THREAD_STRATEGY$cp() {
        return DEFAULT_THREAD_STRATEGY;
    }

    public final String getCodeCacheSourceUrl() {
        return this.codeCacheSourceUrl;
    }

    public final boolean getEnableCanvas() {
        return this.enableCanvas;
    }

    public final boolean getEnableCanvasOptimize() {
        return this.enableCanvasOptimize;
    }

    public final boolean getEnableDynamicV8() {
        return this.enableDynamicV8;
    }

    public final boolean getEnableJsGroupThread() {
        return this.enableJsGroupThread;
    }

    public final boolean getEnableMultiAsyncThread() {
        return this.enableMultiAsyncThread;
    }

    public final boolean getEnablePendingJsTask() {
        return this.enablePendingJsTask;
    }

    public final boolean getEnableSyncFlush() {
        return this.enableSyncFlush;
    }

    public final boolean getEnableUIFlush() {
        return this.enableUIFlush;
    }

    public final boolean getEnableVsyncAlignedMessageLoop() {
        return this.enableVsyncAlignedMessageLoop;
    }

    public final Float getFontScale() {
        return this.fontScale;
    }

    public final Boolean getFontScaleEnable() {
        return this.fontScaleEnable;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final int getHeightSize() {
        return this.heightSize;
    }

    public final int getHeightSpecMode() {
        return this.heightSpecMode;
    }

    public final String[] getJsPaths() {
        return this.jsPaths;
    }

    public final Map<String, Pair<Class<? extends LynxModule>, Object>> getLynxModuleMap() {
        return this.lynxModuleMap;
    }

    public final Float getMobileAdapterScale() {
        return this.mobileAdapterScale;
    }

    public final Boolean getMobileAdapterScaleEnable() {
        return this.mobileAdapterScaleEnable;
    }

    public final boolean getPresetSafePoint() {
        return this.presetSafePoint;
    }

    public final boolean getShareGroup() {
        return this.shareGroup;
    }

    public final int getThreadStrategy() {
        return this.threadStrategy;
    }

    public final int getWidthSize() {
        return this.widthSize;
    }

    public final int getWidthSpecMode() {
        return this.widthSpecMode;
    }

    public final Collection<String> different(LynxInitConfig r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L7;
        r101.add("LynxInitConfig");
        return r101;
    L7:
        if (Intrinsics.areEqual(this.fontScale, r100.fontScale) == true) goto L10;
        r101.add("LynxInitConfig.fontScale");
    L10:
        if (Intrinsics.areEqual(this.fontScaleEnable, r100.fontScaleEnable) == true) goto L13;
        r101.add("LynxInitConfig.fontScaleEnable");
    L13:
        if (this.enableSyncFlush == r100.enableSyncFlush) goto L16;
        r101.add("LynxInitConfig.enableSyncFlush");
    L16:
        if (Intrinsics.areEqual(this.groupName, r100.groupName) == true) goto L19;
        r101.add("LynxInitConfig.groupName");
    L19:
        if (this.shareGroup == r100.shareGroup) goto L22;
        r101.add("LynxInitConfig.shareGroup");
    L22:
        if (this.enableCanvas == r100.enableCanvas) goto L24;
        r101.add("LynxInitConfig.enableCanvas");
    L24:
        String[] r102 = this.jsPaths;
        Integer r103 = null;
        if (r102 == null) goto L27;
        Integer r104 = Integer.valueOf(Arrays.hashCode(r102));
    L28:
        String[] r105 = r100.jsPaths;
        if (r105 == null) goto L31;
        Integer r106 = Integer.valueOf(Arrays.hashCode(r105));
    L33:
        if (Intrinsics.areEqual(r104, r106) == true) goto L36;
        r101.add("LynxInitConfig.jsPaths");
    L36:
        if (this.enableDynamicV8 == r100.enableDynamicV8) goto L39;
        r101.add("LynxInitConfig.enableDynamicV8");
    L39:
        if (this.enableCanvasOptimize == r100.enableCanvasOptimize) goto L42;
        r101.add("LynxInitConfig.enableCanvasOptimize");
    L42:
        if (this.widthSize == r100.widthSize) goto L45;
        r101.add("LynxInitConfig.widthSize");
    L45:
        if (this.widthSpecMode == r100.widthSpecMode) goto L48;
        r101.add("LynxInitConfig.widthSpecMode");
    L48:
        if (this.heightSize == r100.heightSize) goto L51;
        r101.add("LynxInitConfig.heightSize");
    L51:
        if (this.heightSpecMode == r100.heightSpecMode) goto L53;
        r101.add("LynxInitConfig.heightSpecMode");
    L53:
        String r107 = this.codeCacheSourceUrl;
        if (r107 == null) goto L56;
        Integer r108 = Integer.valueOf(r107.hashCode());
    L57:
        String r109 = r100.codeCacheSourceUrl;
        if (r109 == null) goto L61;
        r103 = Integer.valueOf(r109.hashCode());
    L61:
        if (Intrinsics.areEqual(r108, r103) == true) goto L64;
        r101.add("LynxInitConfig.codeCacheSourceUrl");
    L64:
        if (this.presetSafePoint == r100.presetSafePoint) goto L67;
        r101.add("LynxInitConfig.presetSafePoint");
    L67:
        if (this.threadStrategy == r100.threadStrategy) goto L70;
        r101.add("LynxInitConfig.threadStrategy");
    L70:
        if (this.enableMultiAsyncThread == r100.enableMultiAsyncThread) goto L73;
        r101.add("LynxInitConfig.enableMultiAsyncThread");
    L73:
        if (this.enableVsyncAlignedMessageLoop == r100.enableVsyncAlignedMessageLoop) goto L76;
        r101.add("LynxInitConfig.enableVsyncAlignedMessageLoop");
    L76:
        if (this.enableJsGroupThread == r100.enableJsGroupThread) goto L79;
        r101.add("LynxInitConfig.enableJsGroupThread");
    L79:
        if (this.enablePendingJsTask == r100.enablePendingJsTask) goto L81;
        r101.add("LynxInitConfig.enablePendingJsTask");
    L81:
        return r101;
    L56:
        r108 = null;
        goto L57
    L31:
        r106 = null;
        goto L33
    L27:
        r104 = null;
        goto L28
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(LynxInitConfig.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.cube.api.config.LynxInitConfig");
        LynxInitConfig r102 = (LynxInitConfig) r100;
        if (Intrinsics.areEqual(this.fontScale, r102.fontScale) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.fontScaleEnable, r102.fontScaleEnable) == true) goto L19;
        return false;
    L19:
        if (this.enableSyncFlush == r102.enableSyncFlush) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.groupName, r102.groupName) == true) goto L25;
        return false;
    L25:
        if (this.shareGroup == r102.shareGroup) goto L28;
        return false;
    L28:
        if (this.enableCanvas == r102.enableCanvas) goto L30;
        return false;
    L30:
        String[] r103 = this.jsPaths;
        if (r103 == null) goto L39;
        String[] r104 = r102.jsPaths;
        if (r104 != null) goto L36;
        return false;
    L36:
        if (Arrays.equals(r103, r104) == true) goto L42;
        return false;
    L42:
        if (this.enableDynamicV8 == r102.enableDynamicV8) goto L45;
        return false;
    L45:
        if (this.enableCanvasOptimize == r102.enableCanvasOptimize) goto L48;
        return false;
    L48:
        if (this.widthSize == r102.widthSize) goto L51;
        return false;
    L51:
        if (this.widthSpecMode == r102.widthSpecMode) goto L54;
        return false;
    L54:
        if (this.heightSize == r102.heightSize) goto L57;
        return false;
    L57:
        if (this.heightSpecMode == r102.heightSpecMode) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.codeCacheSourceUrl, r102.codeCacheSourceUrl) == true) goto L63;
        return false;
    L63:
        if (this.presetSafePoint == r102.presetSafePoint) goto L66;
        return false;
    L66:
        if (this.threadStrategy == r102.threadStrategy) goto L69;
        return false;
    L69:
        if (this.enableMultiAsyncThread == r102.enableMultiAsyncThread) goto L72;
        return false;
    L72:
        if (this.enableVsyncAlignedMessageLoop == r102.enableVsyncAlignedMessageLoop) goto L75;
        return false;
    L75:
        if (this.enableJsGroupThread == r102.enableJsGroupThread) goto L78;
        return false;
    L78:
        if (this.enablePendingJsTask == r102.enablePendingJsTask) goto L80;
        return false;
    L80:
        return true;
    L39:
        if (r102.jsPaths == null) goto L42;
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public final void setCodeCacheSourceUrl(String r100) {
        this.codeCacheSourceUrl = r100;
    }

    public final void setEnableCanvas(boolean r100) {
        this.enableCanvas = r100;
    }

    public final void setEnableCanvasOptimize(boolean r100) {
        this.enableCanvasOptimize = r100;
    }

    public final void setEnableDynamicV8(boolean r100) {
        this.enableDynamicV8 = r100;
    }

    public final void setEnableJsGroupThread(boolean r100) {
        this.enableJsGroupThread = r100;
    }

    public final void setEnableMultiAsyncThread(boolean r100) {
        this.enableMultiAsyncThread = r100;
    }

    public final void setEnablePendingJsTask(boolean r100) {
        this.enablePendingJsTask = r100;
    }

    public final void setEnableSyncFlush(boolean r100) {
        this.enableSyncFlush = r100;
    }

    public final void setEnableUIFlush(boolean r100) {
        this.enableUIFlush = r100;
    }

    public final void setEnableVsyncAlignedMessageLoop(boolean r100) {
        this.enableVsyncAlignedMessageLoop = r100;
    }

    public final void setFontScale(Float r100) {
        this.fontScale = r100;
    }

    public final void setFontScaleEnable(Boolean r100) {
        this.fontScaleEnable = r100;
    }

    public final void setGroupName(String r100) {
        this.groupName = r100;
    }

    public final void setHeightSize(int r100) {
        this.heightSize = r100;
    }

    public final void setHeightSpecMode(int r100) {
        this.heightSpecMode = r100;
    }

    public final void setJsPaths(String[] r100) {
        this.jsPaths = r100;
    }

    public final void setLynxModuleMap(Map<String, Pair<Class<? extends LynxModule>, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lynxModuleMap = r100;
    }

    public final void setMobileAdapterScale(Float r100) {
        this.mobileAdapterScale = r100;
    }

    public final void setMobileAdapterScaleEnable(Boolean r100) {
        this.mobileAdapterScaleEnable = r100;
    }

    public final void setPresetSafePoint(boolean r100) {
        this.presetSafePoint = r100;
    }

    public final void setShareGroup(boolean r100) {
        this.shareGroup = r100;
    }

    public final void setThreadStrategy(int r100) {
        this.threadStrategy = r100;
    }

    public final void setWidthSize(int r100) {
        this.widthSize = r100;
    }

    public final void setWidthSpecMode(int r100) {
        this.widthSpecMode = r100;
    }

    public LynxInitConfig(Float r100, Boolean r101, Float r102, Boolean r103, boolean r104, boolean r105, String r110, boolean r111, boolean r112, String[] r113, boolean r114, boolean r115, int r116, int r117, int r118, int r119, String r210, boolean r211, int r212, boolean r213, Map<String, Pair<Class<? extends LynxModule>, Object>> r214, boolean r215, boolean r216, boolean r217) {
        Intrinsics.checkNotNullParameter(r214, "lynxModuleMap");
        this.fontScale = r100;
        this.fontScaleEnable = r101;
        this.mobileAdapterScale = r102;
        this.mobileAdapterScaleEnable = r103;
        this.enableSyncFlush = r104;
        this.enableJsGroupThread = r105;
        this.groupName = r110;
        this.shareGroup = r111;
        this.enableCanvas = r112;
        this.jsPaths = r113;
        this.enableDynamicV8 = r114;
        this.enableCanvasOptimize = r115;
        this.widthSize = r116;
        this.widthSpecMode = r117;
        this.heightSize = r118;
        this.heightSpecMode = r119;
        this.codeCacheSourceUrl = r210;
        this.presetSafePoint = r211;
        this.threadStrategy = r212;
        this.enableMultiAsyncThread = r213;
        this.lynxModuleMap = r214;
        this.enableVsyncAlignedMessageLoop = r215;
        this.enableUIFlush = r216;
        this.enablePendingJsTask = r217;
    }

    public /* synthetic */ LynxInitConfig(Float r210, Boolean r211, Float r212, Boolean r213, boolean r310, boolean r311, String r312, boolean r313, boolean r314, String[] r315, boolean r316, boolean r317, int r318, int r319, int r410, int r411, String r412, boolean r413, int r414, boolean r415, Map r416, boolean r417, boolean r418, boolean r419, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        Float r100 = null;
    L7:
        if ((r510 & 2) == 0) goto L9;
        Boolean r101 = null;
    L11:
        if ((r510 & 4) == 0) goto L13;
        Float r102 = null;
    L15:
        if ((r510 & 8) == 0) goto L17;
        Boolean r103 = null;
    L19:
        if ((r510 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r510 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r510 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r510 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r510 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r510 & 512) == 0) goto L41;
        String[] r112 = null;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        boolean r114 = false;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        int r115 = f.b();
    L55:
        if ((r510 & 8192) == 0) goto L57;
        int r107 = 1073741824;
    L59:
        if ((r510 & 16384) == 0) goto L61;
        int r108 = 0;
    L63:
        if ((r510 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r510 & 65536) == 0) goto L69;
        String r117 = null;
    L70:
        boolean r118 = true;
        if ((r510 & 131072) == 0) goto L73;
        boolean r119 = true;
    L75:
        if ((r510 & 262144) == 0) goto L77;
        int r214 = DEFAULT_THREAD_STRATEGY.id();
    L79:
        if ((r510 & 524288) == 0) goto L81;
        boolean r215 = false;
    L83:
        if ((r510 & 1048576) == 0) goto L85;
        Map r216 = new LinkedHashMap();
    L87:
        if ((r510 & 2097152) == 0) goto L89;
        boolean r217 = false;
    L91:
        if ((r510 & 4194304) != 0) goto L95;
        r118 = r418;
    L95:
        if ((r510 & 8388608) == 0) goto L97;
        boolean r109 = false;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r119, r214, r215, r216, r217, r118, r109);
        return;
    L97:
        r109 = r419;
        goto L98
    L89:
        r217 = r417;
        goto L91
    L85:
        r216 = r416;
        goto L87
    L81:
        r215 = r415;
        goto L83
    L77:
        r214 = r414;
        goto L79
    L73:
        r119 = r413;
        goto L75
    L69:
        r117 = r412;
        goto L70
    L65:
        r116 = r411;
        goto L67
    L61:
        r108 = r410;
        goto L63
    L57:
        r107 = r319;
        goto L59
    L53:
        r115 = r318;
        goto L55
    L49:
        r114 = r317;
        goto L51
    L45:
        r113 = r316;
        goto L47
    L41:
        r112 = r315;
        goto L43
    L37:
        r111 = r314;
        goto L39
    L33:
        r110 = r313;
        goto L35
    L29:
        r106 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
