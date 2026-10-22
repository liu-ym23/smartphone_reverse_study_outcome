package tmc;

import android.text.TextUtils;
import com.ss.videoarch.liveplayer.config.PlayerConfig;
import com.ss.videoarch.liveplayer.i0;
import com.ss.videoarch.liveplayer.log.c;
import com.ss.videoarch.liveplayer.w;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.network.VeLSNetworkManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    private static final Integer StrategyConfigLevelCheckInvalidState = null;
    private static final Integer StrategyConfigLevelDisable = null;
    private static final String TAG = "PlayerStrategyConfig";

    static {
        StrategyConfigLevelDisable = 0;
        StrategyConfigLevelCheckInvalidState = 1;
    }

    public b() {
    }

    public static boolean enableAbr(int r100) {
        String r101 = getStrategyConfigByName("LivePlayerSettings", r100);
        if (r100 == StrategyConfigLevelCheckInvalidState.intValue()) goto L5;
    L13:
        int r102 = new JSONObject(r101).optInt("VeLivePlayerKeySetABRAlgorithum", 0);     // Catch: Exception -> L9
    L10:
        if (r102 <= 0) goto L15;
        return true;
    L15:
        return false;
    L9:
        c.w(TAG, "enableAbr fail");
        r102 = 0;
        goto L10
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return false;
    }

    public static JSONObject generateNetAdapt(int r100) {
        String r101 = getStrategyConfigByName("LivePlayerSettings", r100);
        if (r100 == StrategyConfigLevelCheckInvalidState.intValue()) goto L5;
    L13:
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L11
        if (r102.optInt("VeLivePlayerKeySetHurryEnable", 0) <= 0) goto L12;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L11
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L11
        r104.put("Enabled", 1);     // Catch: Exception -> L11
        r104.put("HurryTime", r102.optInt("VeLivePlayerKeySetHurryTime", 0));     // Catch: Exception -> L11
        r104.put("HurrySpeed", r102.optInt("VeLivePlayerKeySetHurrySpeed", 0));     // Catch: Exception -> L11
        r104.put("SlowTime", r102.optInt("VeLivePlayerKeySetSlowTime", 0));     // Catch: Exception -> L11
        r104.put("SlowSpeed", r102.optInt("VeLivePlayerKeySetSlowSpeed", 0));     // Catch: Exception -> L11
        r103.put("NetworkAdapt", r104);     // Catch: Exception -> L11
        return r103;
    L12:
        return null;
    L11:
        c.w(TAG, "generateNetAdapt fail");
        goto L12
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return null;
    }

    public static JSONObject getAbrMethodConfig(int r100) {
        String r101 = getStrategyConfigByName("live_stream_strategy_abr_auto", r100);
        if (r100 == StrategyConfigLevelCheckInvalidState.intValue()) goto L5;
    L11:
        return new JSONObject(r101);
    L9:
        c.w(TAG, "getAbrMethodConfig fail");
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return null;
    }

    public static String getLLSConfig(int r100) {
        String r101 = getStrategyConfigByName("RTMPlayer", r100);
        c.t(TAG, "getLLSConfig:" + r101);
        return r101;
    }

    public static JSONObject getQuicConfig(int r100) {
        String r101 = getStrategyConfigByName("live_stream_strategy_http_over_quic", r100);
        if (r100 == StrategyConfigLevelCheckInvalidState.intValue()) goto L5;
    L11:
        return new JSONObject(r101);
    L9:
        c.w(TAG, "getQuicConfig fail");
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return null;
    }

    private static String getStrategyConfigByName(String r100, int r101) {
        if (r101 != StrategyConfigLevelCheckInvalidState.intValue()) goto L8;
        if (LiveStrategyManager.inst().mIsRunning == true) goto L8;
        return "";
    L8:
        if (TextUtils.equals(r100, "RTMPlayer") == false) goto L12;
        return new VeLSNetworkManager().GetRTMPlayer();
    L12:
        if (TextUtils.equals(r100, "LivePlayerSettings") == true) goto L14;
        JSONObject r102 = new JSONObject();
        r102.put("strategyName", r100);     // Catch: JSONException -> L19
        String r103 = (String) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 51, "", r102);     // Catch: JSONException -> L19
        c.i(TAG, "getStrategyConfigByName:" + r100 + ", config:" + r103);
        return r103;
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    L14:
        return new VeLSNetworkManager().GetLivePlayerSettings();
    }

    public static void mergeJSONObject(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L10
    L7:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Exception -> L10
        r101.put(r103, r100.get(r103));     // Catch: Exception -> L10
        goto L7
    L18:
        return;
    L10:
        c.w(TAG, "combineJSONObject fail");
        return;
    L17:
        return;
    }

    public static void parseStrategyConfig(PlayerConfig r100, i0 r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        int r102 = r100.mergeStrategyConfigLevel.value().intValue();
        if (r101 != null) goto L17;
    L8:
        String r103 = getStrategyConfigByName("LivePlayerSettings", r102);     // Catch: Exception -> L15
        if (r102 == StrategyConfigLevelCheckInvalidState.intValue()) goto L11;
    L13:
        c.d(TAG, "configStr:" + r103);     // Catch: Exception -> L15
        parseConfigObject(r100, new JSONObject(r103), 8);     // Catch: Exception -> L15
        return;
    L15:
        c.w(TAG, "parseStrategyConfig ex=");
        return;
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        return;
    L17:
        r100.VeLivePlayerKeySetABRAlgorithm.setConfig(0, 2);     // Catch: Exception -> L15
        goto L8
    }

    public static void setPlayerConfigByUser(PlayerConfig r100, w r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r100.VeLivePlayerKeySetHardwareDecode.setConfig(Integer.valueOf(r101.f459659b ? 1 : 0), 2);
        r100.mergeStrategyConfigLevel.setConfig(0, 8);
        return;
    L8:
        return;
    }

    public static void parseConfigObject(Object r100, JSONObject r101, int r102) {
        Iterator<String> r103 = r101.keys();     // Catch: Exception -> L10
    L3:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();     // Catch: Exception -> L10
        if ((r101.get(r104) instanceof JSONObject) == true) goto L7;
        setConfigFieldValue(r100, r104, r101.get(r104), r102);     // Catch: Exception -> L10
        goto L3
    L7:
        parseConfigObject(r100.getClass().getDeclaredField(r104).get(r100), (JSONObject) r101.get(r104), r102);     // Catch: Exception -> L10
        goto L3
    L20:
        return;
    L10:
        c.w(TAG, "parseConfigObject ex=");
    }

    private static void setConfigFieldValue(Object r100, String r101, Object r102, int r103) {
        Field r104 = r100.getClass().getDeclaredField(r101);     // Catch: Exception -> L23
        Type r105 = r104.getGenericType();     // Catch: Exception -> L23
        if ((r105 instanceof ParameterizedType) == false) goto L5;
        Type r106 = ((ParameterizedType) r105).getActualTypeArguments()[0];     // Catch: Exception -> L23
    L6:
        if (r106 == null) goto L8;
        r104.setAccessible(true);     // Catch: Exception -> L23
        Object r107 = r104.get(r100);     // Catch: Exception -> L23
        Method r108 = r107.getClass().getMethod("setConfig", new Class[]{Object.class, Integer.TYPE});     // Catch: Exception -> L23
        if ((r102 instanceof Double) == false) goto L19;
        r108.invoke(r107, new Object[]{Float.valueOf(BigDecimal.valueOf(((Double) r102).doubleValue()).floatValue()), Integer.valueOf(r103)});     // Catch: Exception -> L23
        return;
    L19:
        if ((r102 instanceof BigDecimal) == false) goto L21;
        r108.invoke(r107, new Object[]{Float.valueOf(((BigDecimal) r102).floatValue()), Integer.valueOf(r103)});     // Catch: Exception -> L23
        return;
    L21:
        r108.invoke(r107, new Object[]{r102, Integer.valueOf(r103)});     // Catch: Exception -> L23
        return;
    L8:
        if ((r102 instanceof Double) == false) goto L11;
        r104.set(r100, Float.valueOf(BigDecimal.valueOf(((Double) r102).doubleValue()).floatValue()));     // Catch: Exception -> L23
        return;
    L11:
        if ((r102 instanceof BigDecimal) == false) goto L13;
        r104.set(r100, Float.valueOf(((BigDecimal) r102).floatValue()));     // Catch: Exception -> L23
        return;
    L13:
        r104.set(r100, r102);     // Catch: Exception -> L23
        return;
    L5:
        r106 = null;
    L23:
        c.d(TAG, "set config ex");
    }
}
