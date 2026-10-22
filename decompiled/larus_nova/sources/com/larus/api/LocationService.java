package com.larus.api;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.applet.impl.r;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import hq9.a3;
import hq9.y2;
import hq9.z2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l48.b;
import l48.e;
import l48.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 H2\u00020\u0001:\u0001HJ\b\u0010\u0002\u001a\u00020\u0003H&JC\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJO\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\fH&Jk\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010!Js\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\"J4\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H&J<\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0014\u001a\u00020\u000eH&J`\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&JF\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000eH&J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH&J\b\u0010.\u001a\u00020\fH&J\n\u0010/\u001a\u0004\u0018\u00010\u000eH&J\u0014\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H&J\u0012\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u000106H&J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u000209H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u00108\u001a\u000209H&J\u0014\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH&J\u001c\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u001e2\b\b\u0002\u0010>\u001a\u00020\u001eH&J3\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00012!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u00030AH\u0016J3\u0010E\u001a\u00020\u00032!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u00030A2\u0006\u0010F\u001a\u00020\u0016H\u0016J\n\u0010G\u001a\u0004\u0018\u00010<H\u0016¨\u0006I"}, d2 = {"Lcom/larus/api/LocationService;", "", "init", "", "singleLocate", "scene", "Lcom/larus/platform/model/LocateScene;", "coordinateType", "Lcom/larus/api/CoordinateType;", "locationDataCallBack", "Lcom/larus/platform/model/LocationDataCallBack;", "acceptLightLocation", "", "traceContext", "", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Lcom/larus/platform/model/LocationDataCallBack;Ljava/lang/Boolean;Ljava/lang/String;)V", "trackInfo", "Lorg/json/JSONObject;", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Lcom/larus/platform/model/LocationDataCallBack;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;)V", "updateNavigationHint", LocationMonitorConst.IDENTIFIER, "navigationCode", "", "projectionBearing", "", "setUpdatingNavigationLocationConfig", "navigationId", "needUpload", "mode", "timeoutMs", "", "source", "maxCacheTimeMs", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/model/LocationDataCallBack;Ljava/lang/Boolean;Ljava/lang/String;)V", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/model/LocationDataCallBack;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;)V", "continuousLocate", "Lcom/larus/platform/model/LocationResult;", VideoThumbInfo.KEY_INTERVAL, "extra", "callback", "Lcom/larus/platform/model/LocationChangeCallBack;", "locationType", "workMode", "userMotionMode", "stopLocate", "reason", "isEnableLocationService", "getLocationSdkVersion", "showTotalGeolocationPermissionDialog", "Landroid/app/Dialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "tryRequestNewLocationAuthMessage", "locationAuthData", "Lcom/larus/platform/model/LocationAuthData;", "registerLocationHistoryListener", "listener", "Lcom/larus/api/LocationHistoryListener;", "unregisterLocationHistoryListener", "getLocationCache", "Lcom/larus/platform/model/GeoLocationInfo;", "createTime", "maxDiffMs", "addSubmitNotification", TextureRenderKeys.KEY_IS_CERT, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "location", "addNotification", FilterData.FilterOptionItem.Type.RANGE, "getLastLocation", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LocationService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286873a = null;

    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J;\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018JE\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001bJc\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00172\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0016J \u0010(\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0015H\u0016J\u0018\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0017H\u0016J(\u0010-\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0015H\u0016J\u0010\u00100\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0017H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\f2\u0006\u00102\u001a\u000203H\u0016Jm\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00172\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u00105J,\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J4\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010$\u001a\u00020\u0017H\u0016J>\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010$\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016JV\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J^\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u001a2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0017H\u0016J\u0018\u0010?\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u00020\u0015H\u0016J\n\u0010A\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010F\u001a\u00020\f2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J3\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020K2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110M¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\f0LH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010MH\u0016J3\u0010R\u001a\u00020\f2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110M¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\f0L2\u0006\u0010S\u001a\u00020\u001dH\u0016J\u0010\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020\f2\u0006\u0010U\u001a\u00020VH\u0016J\u0012\u0010X\u001a\u0004\u0018\u00010M2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010X\u001a\u0004\u0018\u00010M2\u0006\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u001fH\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006["}, d2 = {"Lcom/larus/api/LocationService$Companion;", "Lcom/larus/api/LocationService;", "Lcom/larus/api/NavigationLocationPrewarmCapability;", "Lcom/larus/api/LocationAutoPollCapability;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/api/LocationService;", "impl$delegate", "Lkotlin/Lazy;", "init", "", "singleLocate", "scene", "Lcom/larus/platform/model/LocateScene;", "coordinateType", "Lcom/larus/api/CoordinateType;", "locationDataCallBack", "Lcom/larus/platform/model/LocationDataCallBack;", "acceptLightLocation", "", "traceContext", "", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Lcom/larus/platform/model/LocationDataCallBack;Ljava/lang/Boolean;Ljava/lang/String;)V", "trackInfo", "Lorg/json/JSONObject;", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Lcom/larus/platform/model/LocationDataCallBack;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;)V", "mode", "", "timeoutMs", "", "source", "maxCacheTimeMs", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/model/LocationDataCallBack;Ljava/lang/Boolean;Ljava/lang/String;)V", "updateNavigationHint", LocationMonitorConst.IDENTIFIER, "navigationCode", "projectionBearing", "", "setUpdatingNavigationLocationConfig", "navigationId", "needUpload", "stopNavigationLocationOnly", "reason", "startAutoPoll", BasicTestActionHandler.TEST_ACTION_RESET, "isInBackgroundWhenStartingPoll", "stopAutoPoll", "registerAutoPollStrategy", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/larus/api/LocationAutoPollStrategy;", "unregisterAutoPollStrategy", "(Lcom/larus/platform/model/LocateScene;Lcom/larus/api/CoordinateType;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/model/LocationDataCallBack;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;)V", "continuousLocate", "Lcom/larus/platform/model/LocationResult;", VideoThumbInfo.KEY_INTERVAL, "extra", "callback", "Lcom/larus/platform/model/LocationChangeCallBack;", "locationType", "workMode", "userMotionMode", "stopLocate", "isEnableLocationService", "getLocationSdkVersion", "showTotalGeolocationPermissionDialog", "Landroid/app/Dialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "tryRequestNewLocationAuthMessage", "locationAuthData", "Lcom/larus/platform/model/LocationAuthData;", "addSubmitNotification", TextureRenderKeys.KEY_IS_CERT, "", "Lkotlin/Function1;", "Lcom/larus/platform/model/GeoLocationInfo;", "Lkotlin/ParameterName;", "name", "location", "getLastLocation", "addNotification", FilterData.FilterOptionItem.Type.RANGE, "registerLocationHistoryListener", "listener", "Lcom/larus/api/LocationHistoryListener;", "unregisterLocationHistoryListener", "getLocationCache", "createTime", "maxDiffMs", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements LocationService, f, b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286874b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<LocationService> f286875c = null;

        private Companion() {
        }

        static {
            f286874b = new Companion();
            f286875c = LazyKt.lazy(new e());
        }

        public static LocationService w() {
            return f286875c.getValue();
        }

        @Override // com.larus.api.LocationService
        public final String a() {
            LocationService r100 = w();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.a();
        }

        @Override // com.larus.api.LocationService
        public final boolean c() {
            LocationService r100 = w();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.c();
        }

        @Override // com.larus.api.LocationService
        public final void init() {
            LocationService r100 = w();
            if (r100 == null) goto L6;
            r100.init();
            return;
        }

        @Override // com.larus.api.LocationService
        public final GeoLocationInfo m() {
            LocationService r100 = w();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.m();
        }

        @Override // com.larus.api.LocationService
        public final void b(y2 r100) {
            LocationService r101 = w();
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.larus.api.LocationService
        public final Dialog d(FragmentActivity r100) {
            LocationService r101 = w();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.d(r100);
        }

        @Override // com.larus.api.LocationService
        public final GeoLocationInfo e(long r100) {
            LocationService r101 = w();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.e(r100);
        }

        @Override // com.larus.api.LocationService
        public final void f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            LocationService r101 = w();
            if (r101 == null) goto L6;
            r101.f(r100);
            return;
        }

        @Override // l48.b
        public final void t(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            LocationService r101 = w();
            if ((r101 instanceof b) == false) goto L5;
            b r102 = (b) r101;
        L6:
            if (r102 == null) goto L9;
            r102.t(r100);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // l48.b
        public final void u(y98.a.b r100) {
            Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            LocationService r101 = w();
            if ((r101 instanceof b) == false) goto L5;
            b r102 = (b) r101;
        L6:
            if (r102 == null) goto L9;
            r102.u(r100);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // l48.b
        public final void v(y98.a.b r100) {
            Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            LocationService r101 = w();
            if ((r101 instanceof b) == false) goto L5;
            b r102 = (b) r101;
        L6:
            if (r102 == null) goto L9;
            r102.v(r100);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // l48.f
        public final void g(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
            LocationService r102 = w();
            if ((r102 instanceof f) == false) goto L5;
            f r103 = (f) r102;
        L6:
            if (r103 == null) goto L9;
            r103.g(r100, r101);
            return;
        L9:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // l48.b
        public final boolean k(LocateScene r100, CoordinateType r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "coordinateType");
            LocationService r102 = w();
            if ((r102 instanceof b) == false) goto L5;
            b r103 = (b) r102;
        L6:
            if (r103 != null) goto L10;
            return false;
        L10:
            return r103.k(r100, r101);
        L5:
            r103 = null;
            goto L6
        }

        @Override // l48.f
        public final void n(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
            Intrinsics.checkNotNullParameter(r101, "navigationId");
            LocationService r102 = w();
            if ((r102 instanceof f) == false) goto L5;
            f r103 = (f) r102;
        L6:
            if (r103 == null) goto L9;
            r103.n(r100, r101);
            return;
        L9:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.larus.api.LocationService
        public final void p(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
            LocationService r102 = w();
            if (r102 == null) goto L6;
            r102.p(r100, r101);
            return;
        }

        @Override // com.larus.api.LocationService
        public final LocationResult s(CoordinateType r100, r r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "coordinateType");
            Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.IDENTIFIER);
            LocationService r103 = w();
            if (r103 == null) goto L7;
            LocationResult r104 = r103.s(r100, r101, r102);
            if (r104 == null) goto L7;
            return r104;
        L7:
            return LocationResult.NO_IMPL_MODULE;
        }

        @Override // com.larus.api.LocationService
        public final void updateNavigationHint(String r100, int r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
            LocationService r103 = w();
            if (r103 == null) goto L6;
            r103.updateNavigationHint(r100, r101, r102);
            return;
        }

        @Override // com.larus.api.LocationService
        public final LocationResult r(long r100, CoordinateType r110, JSONObject r111, z2 r112) {
            Intrinsics.checkNotNullParameter(r110, "coordinateType");
            LocationService r101 = w();
            if (r101 == null) goto L7;
            LocationResult r102 = r101.r(r100, r110, r111, r112);
            if (r102 == null) goto L7;
            return r102;
        L7:
            return LocationResult.NO_IMPL_MODULE;
        }

        @Override // com.larus.api.LocationService
        public final void l(LocateScene r100, CoordinateType r101, a3 r110, Boolean r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "coordinateType");
            LocationService r102 = w();
            if (r102 == null) goto L6;
            r102.l(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.larus.api.LocationService
        public final LocationResult h(long r110, CoordinateType r111, JSONObject r112, z2 r113, String r114, String r115) {
            Intrinsics.checkNotNullParameter(r111, "coordinateType");
            Intrinsics.checkNotNullParameter(r114, LocationMonitorConst.IDENTIFIER);
            LocationService r100 = w();
            if (r100 == null) goto L7;
            LocationResult r101 = r100.h(r110, r111, r112, r113, r114, r115);
            if (r101 == null) goto L7;
            return r101;
        L7:
            return LocationResult.NO_IMPL_MODULE;
        }

        @Override // com.larus.api.LocationService
        public final void q(LocateScene r100, CoordinateType r110, a3 r111, JSONObject r112, Boolean r113, String r114) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r110, "coordinateType");
            LocationService r101 = w();
            if (r101 == null) goto L6;
            r101.q(r100, r110, r111, r112, r113, r114);
            return;
        }

        @Override // com.larus.api.LocationService
        public final void i(LocateScene r110, CoordinateType r111, Integer r112, Long r113, String r114, Long r115, a3 r116, Boolean r117, String r210) {
            Intrinsics.checkNotNullParameter(r110, "scene");
            Intrinsics.checkNotNullParameter(r111, "coordinateType");
            LocationService r100 = w();
            if (r100 == null) goto L6;
            r100.i(r110, r111, r112, r113, r114, r115, r116, r117, r210);
            return;
        }

        @Override // com.larus.api.LocationService
        public final LocationResult o(long r110, CoordinateType r111, JSONObject r112, z2 r113, int r114, int r115, int r116, String r210, String r211) {
            Intrinsics.checkNotNullParameter(r111, "coordinateType");
            Intrinsics.checkNotNullParameter(r210, LocationMonitorConst.IDENTIFIER);
            LocationService r100 = w();
            if (r100 == null) goto L7;
            LocationResult r101 = r100.o(r110, r111, r112, r113, 7, 2, r116, r210, r211);
            if (r101 == null) goto L7;
            return r101;
        L7:
            return LocationResult.NO_IMPL_MODULE;
        }

        @Override // l48.f
        public final LocationResult j(long r110, CoordinateType r111, JSONObject r112, z2 r113, int r114, int r210, int r211, String r212, String r213, boolean r214) {
            Intrinsics.checkNotNullParameter(r111, "coordinateType");
            Intrinsics.checkNotNullParameter(r212, LocationMonitorConst.IDENTIFIER);
            LocationService r100 = w();
            if (r100 != null) goto L7;
            return LocationResult.NO_IMPL_MODULE;
        L7:
            if ((r100 instanceof f) == false) goto L9;
            f r101 = (f) r100;
        L10:
            f r102 = r101;
            if (r102 == null) goto L15;
            return r102.j(1000, r111, null, r113, 7, 2, r211, r212, r213, false);
        L15:
            return LocationResult.NOT_SUPPORT_CONTINUOUS;
        L9:
            r101 = null;
            goto L10
        }
    }

    public static final class a {
        public static /* synthetic */ void a(LocationService r100, LocateScene r101, CoordinateType r102, a3 r103, int r110) {
            if ((r110 & 2) == 0) goto L5;
            r102 = CoordinateType.WGS_84;
        L5:
            CoordinateType r104 = r102;
            if ((r110 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.l(r101, r104, r103, null, null);
        }
    }

    static {
        f286873a = Companion.f286874b;
    }

    String a();

    void b(y2 r100);

    boolean c();

    Dialog d(FragmentActivity r100);

    GeoLocationInfo e(long r100);

    void f(String r100);

    LocationResult h(long r100, CoordinateType r101, JSONObject r102, z2 r103, String r104, String r105);

    void i(LocateScene r100, CoordinateType r101, Integer r102, Long r103, String r104, Long r105, a3 r106, Boolean r107, String r108);

    void init();

    void l(LocateScene r100, CoordinateType r101, a3 r102, Boolean r103, String r104);

    GeoLocationInfo m();

    LocationResult o(long r100, CoordinateType r101, JSONObject r102, z2 r103, int r104, int r105, int r106, String r107, String r110);

    void p(String r100, String r101);

    void q(LocateScene r100, CoordinateType r101, a3 r102, JSONObject r103, Boolean r104, String r105);

    LocationResult r(long r100, CoordinateType r101, JSONObject r102, z2 r103);

    LocationResult s(CoordinateType r100, r r101, String r102);

    void updateNavigationHint(String r100, int r101, float r102);
}
