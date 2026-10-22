package com.ss.ttvideoengine.log;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.canvas.KryptonCamera;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.info.networkRTTLevelListener;
import com.ss.ttvideoengine.portrait.IPortrait;
import com.ss.ttvideoengine.portrait.NetworkPortraitData;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class PortraitNetworkScore implements IPortrait {
    public static final int PORTRAIT_OPTION_NET_LEVEL_MAX_COUNT = 2;
    public static final int PORTRAIT_OPTION_NET_MIN_DURATION = 4;
    public static final int PORTRAIT_OPTION_NET_TIMER_TASK_INTERVAL = 3;
    public static final int PORTRAIT_OPTION_VAR_STRING = 4;
    private static final String TAG = "PortraitNetworkScore";
    private static PortraitNetworkScore mInstance = null;
    private static double mLastTargetBitrate = -1.0d;
    private final NetworkPortraitData mPortraitData;
    private NetworkQualityAlgorithm mQualityAlg;

    public static class BitrateCalculationTask extends TimerTask {
        private NetworkQualityAlgorithm mAlgorithm;
        private NetworkPortraitData mData;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_log_PortraitNetworkScore$BitrateCalculationTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_log_PortraitNetworkScore$BitrateCalculationTask__run$___twin___() {
            List<Integer> r100 = this.mData.getRttList();
            List<Float> r101 = this.mData.getMdlSeepList();
            NetworkQualityAlgorithm r102 = this.mAlgorithm;
            if (r102 == null) goto L8;
            if (r100 == null) goto L9;
            if (r101 == null) goto L10;
            double r103 = r102.calculateTargetBitrate(r100, r101);
            StrategyHelper.helper().getCenter().h(31213, String.valueOf(r103));
            return;
        L10:
            return;
        L9:
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_log_PortraitNetworkScore$BitrateCalculationTask_com_larus_apm_impl_protector_RunnableLancet_run(BitrateCalculationTask r100) {
            r100.com_ss_ttvideoengine_log_PortraitNetworkScore$BitrateCalculationTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public BitrateCalculationTask(NetworkPortraitData r100, NetworkQualityAlgorithm r101) {
            this.mData = r100;
            this.mAlgorithm = r101;
        }
    }

    public interface NetworkQualityAlgorithm {
        double calculateTargetBitrate(List<Integer> r100, List<Float> r101);

        int getLastNetworkScore();

        int getNetworkScore();

        void init();

        void setStringOption(int r100, String r101);
    }

    public class NetworkQualityAlgorithmV1 implements NetworkQualityAlgorithm {
        private int mLastNetworkScore;
        private Map<String, Integer> mLevelCodeMap;
        private Map<String, Double> mRttCodeMap;
        private Map<String, Double> mSigCodeMap;
        final /* synthetic */ PortraitNetworkScore this$0;

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public double calculateTargetBitrate(List<Integer> r100, List<Float> r101) {
            return -1.0d;
        }

        private void setDefaultLevelMap() {
            HashMap r100 = new HashMap();
            this.mLevelCodeMap = r100;
            r100.put(com.bytedance.android.ec.core.event.a.VALUE_MAIN_PIC_SQUARE, 0);
            this.mLevelCodeMap.put("1_2", 1);
            this.mLevelCodeMap.put("1_3", 2);
            this.mLevelCodeMap.put("2_1", 3);
            this.mLevelCodeMap.put("2_2", 4);
            this.mLevelCodeMap.put("1_4", 5);
            this.mLevelCodeMap.put("2_3", 6);
            this.mLevelCodeMap.put("3_1", 7);
            this.mLevelCodeMap.put("3_2", 8);
            this.mLevelCodeMap.put("3_3", 9);
            this.mLevelCodeMap.put("2_4", 10);
            this.mLevelCodeMap.put(com.bytedance.android.ec.core.event.a.VALUE_MAIN_PIC_THREE_QUARTERS, 11);
            this.mLevelCodeMap.put("4_1", 12);
            this.mLevelCodeMap.put("4_2", 13);
            this.mLevelCodeMap.put("4_3", 14);
            this.mLevelCodeMap.put("4_4", 15);
        }

        private void setDefaultRttMap() {
            HashMap r100 = new HashMap();
            this.mRttCodeMap = r100;
            r100.put("-1", Double.valueOf(1.8d));
            this.mRttCodeMap.put("2", Double.valueOf(93.0d));
            this.mRttCodeMap.put("3", Double.valueOf(70.0d));
            this.mRttCodeMap.put("4", Double.valueOf(26.0d));
            this.mRttCodeMap.put("5", Double.valueOf(12.0d));
            this.mRttCodeMap.put("6", Double.valueOf(7.0d));
            this.mRttCodeMap.put("7", Double.valueOf(2.0d));
            this.mRttCodeMap.put("8", Double.valueOf(1.0d));
        }

        private void setDefaultSigMap() {
            HashMap r100 = new HashMap();
            this.mSigCodeMap = r100;
            r100.put("excellent", Double.valueOf(1.0d));
            this.mSigCodeMap.put("good", Double.valueOf(2.4d));
            this.mSigCodeMap.put("unknown", Double.valueOf(5.4d));
            this.mSigCodeMap.put(KryptonCamera.Config.RESOLUTION_MEDIUM, Double.valueOf(7.6d));
            this.mSigCodeMap.put("weak", Double.valueOf(20.6d));
            this.mSigCodeMap.put("unavailable", Double.valueOf(36.0d));
        }

        public void calculateNetworkScore() {
            List<Integer> r100 = PortraitNetworkScore.access$000(this.this$0).getRttList();
            List<String> r101 = PortraitNetworkScore.access$000(this.this$0).getSignalStrengthList();
            if (this.mRttCodeMap != null) goto L5;
            return;
        L5:
            if (this.mSigCodeMap != null) goto L7;
            return;
        L7:
            if (this.mLevelCodeMap == null) goto L87;
            if (r100 == null) goto L88;
            if (r101 != null) goto L12;
            return;
        L12:
            if (r100.isEmpty() == false) goto L14;
            return;
        L14:
            if (r101.isEmpty() == true) goto L91;
            int r102 = r100.size();
            int r103 = 0;
            double r104 = 0.0d;
            int r105 = 0;
        L18:
            if (r105 >= r102) goto L27;
            String r110 = String.valueOf(((Integer) ListProtector.get(r100, r105)).intValue());     // Catch: Exception -> L25
            if (this.mRttCodeMap.containsKey(r110) == false) goto L23;
            double r111 = this.mRttCodeMap.get(r110).doubleValue();     // Catch: Exception -> L25
        L24:
            r104 = r104 + r111;
            r105 = r105 + 1;
            goto L18
        L23:
            r111 = 0.0d;
        L25:
            e = move-exception;
            TTVideoEngineLog.e(PortraitNetworkScore.TAG, e.toString());
        L29:
            if (r104 >= 1.0d) goto L31;
            return;
        L31:
            int r106 = r101.size();
            double r112 = 0.0d;
        L32:
            if (r103 >= r106) goto L45;
            String r107 = (String) ListProtector.get(r101, r103);     // Catch: Exception -> L43
            if (r107 != null) goto L37;
        L42:
            r103 = r103 + 1;
            goto L32
        L37:
            if (this.mSigCodeMap.containsKey(r107) == false) goto L40;
            double r113 = this.mSigCodeMap.get(r107).doubleValue();     // Catch: Exception -> L43
        L41:
            r112 = r112 + r113;
            goto L42
        L40:
            r113 = 0.0d;
        L43:
            e = move-exception;
            TTVideoEngineLog.e(PortraitNetworkScore.TAG, e.toString());
        L47:
            if (r112 >= 1.0d) goto L49;
            return;
        L49:
            StringBuilder r108 = new StringBuilder();
            if (r104 > 2.0d) goto L53;
            r108.append('1');
        L59:
            r108.append('_');
            if (r112 != 1.0d) goto L63;
            r108.append('1');
        L69:
            String r109 = r108.toString();
            if (this.mLevelCodeMap.containsKey(r109) == false) goto L72;
            int r114 = this.mLevelCodeMap.get(r109).intValue();
        L73:
            this.mLastNetworkScore = r114;
            TTVideoEngineLog.d(PortraitNetworkScore.TAG, "rtt score:" + r104 + " sig score:" + r112 + " level:" + r109);
            return;
        L72:
            r114 = -1;
            goto L73
        L63:
            if (r112 > 3.0d) goto L66;
            r108.append('2');
            goto L69
        L66:
            if (r112 > 7.0d) goto L68;
            r108.append('3');
            goto L69
        L68:
            r108.append('4');
            goto L69
        L53:
            if (r104 > 11.0d) goto L56;
            r108.append('2');
            goto L59
        L56:
            if (r104 > 26.0d) goto L58;
            r108.append('3');
            goto L59
        L58:
            r108.append('4');
            goto L59
        L45:
            r112 = r112 / ((double) r106);
            goto L47
        L27:
            r104 = r104 / ((double) r102);
            goto L29
        L91:
            return;
        L88:
            return;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getLastNetworkScore() {
            if (this.mLastNetworkScore != (-1)) goto L6;
            calculateNetworkScore();
        L6:
            return this.mLastNetworkScore;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getNetworkScore() {
            calculateNetworkScore();
            return this.mLastNetworkScore;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void init() {
            setDefaultRttMap();
            setDefaultSigMap();
            setDefaultLevelMap();
        }

        public NetworkQualityAlgorithmV1(PortraitNetworkScore r100) {
            this.this$0 = r100;
            this.mRttCodeMap = null;
            this.mSigCodeMap = null;
            this.mLevelCodeMap = null;
            this.mLastNetworkScore = -1;
            init();
        }

        private Map _jsonStringToMap(String r100, boolean r101) throws Exception {
            if (r101 == false) goto L7;
            HashMap r102 = new HashMap();     // Catch: Exception -> L13
            JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L13
            Iterator<String> r104 = r103.keys();     // Catch: Exception -> L13
        L5:
            if (r104.hasNext() == false) goto L12;
            String r105 = r104.next();     // Catch: Exception -> L13
            r102.put(r105, Integer.valueOf(JSONObjectProtectorUtils.getInt(r103, r105)));     // Catch: Exception -> L13
        L12:
            return r102;
        L7:
            r102 = new HashMap();     // Catch: Exception -> L13
            JSONObject r106 = new JSONObject(r100);     // Catch: Exception -> L13
            Iterator<String> r107 = r106.keys();     // Catch: Exception -> L13
        L9:
            if (r107.hasNext() == false) goto L12;
            String r108 = r107.next();     // Catch: Exception -> L13
            r102.put(r108, Double.valueOf(JSONObjectProtectorUtils.getDouble(r106, r108)));     // Catch: Exception -> L13
        L13:
            e = move-exception;
            TTVideoEngineLog.e(PortraitNetworkScore.TAG, e.toString());
            throw e;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void setStringOption(int r100, String r101) {
            if (r100 != 3) goto L5;
            this.mRttCodeMap = _jsonStringToMap(r101, false);     // Catch: Exception -> L18
            return;
        L18:
            setDefaultRttMap();
            return;
        L5:
            if (r100 != 4) goto L7;
            this.mSigCodeMap = _jsonStringToMap(r101, false);     // Catch: Exception -> L15
            return;
        L15:
            setDefaultSigMap();
            return;
        L7:
            if (r100 == 5) goto L24;
            return;
        L24:
            this.mLevelCodeMap = _jsonStringToMap(r101, true);     // Catch: Exception -> L12
            return;
        L12:
            setDefaultLevelMap();
        }
    }

    public static class NetworkQualityAlgorithmV2 implements NetworkQualityAlgorithm {
        private double mLinkFuncOffset;
        private double[] mParameters;
        private String mVarsToParse;

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getLastNetworkScore() {
            return -1;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public int getNetworkScore() {
            return -1;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void init() {
        }

        public NetworkQualityAlgorithmV2() {
            this.mParameters = new double[]{0.54551238d, -0.03129748d, 0.19721764d, 0.24254935d, 0.01385684d, -1.56912212d, -0.40001913d, -0.57657028d, -0.63627456d, -0.13389704d, 0.0628909d, -0.13203807d, -0.08140563d, -0.09929551d, 0.10024534d, 0.31530643d};
            this.mVarsToParse = null;
            JSONObject r100 = SettingsHelper.helper().getVodJsonObject("net_quality");
            if (r100 != null) goto L5;
            double r101 = 1.0d;
        L6:
            this.mLinkFuncOffset = r101;
            if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
            this.mLinkFuncOffset = 1.0d;
        L9:
            TTVideoEngineLog.i(PortraitNetworkScore.TAG, "link function offset: " + this.mLinkFuncOffset);
            return;
        L5:
            r101 = r100.optDouble(VideoEventLoggerV2.SETTINGS_LINK_FUNCTION_OFFSET, 1.0d);
            goto L6
        }

        private void parseVariable(String r100) {
            String[] r101 = r100.split(",");
            int r102 = r101.length;
            int r103 = 0;
            int r104 = 0;
        L3:
            if (r103 >= r102) goto L8;
            String r105 = r101[r103];
            int r106 = r104 + 1;
            this.mParameters[r104] = CastDoubleProtector.valueOf(r105).doubleValue();
            if (r106 == this.mParameters.length) goto L11;
            r103 = r103 + 1;
            r104 = r106;
            goto L3
        L11:
            return;
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public double calculateTargetBitrate(List<Integer> r310, List<Float> r311) {
            TTVideoEngineLog.d(PortraitNetworkScore.TAG, "calculateTargetBitrate rttList:" + r310 + ", speedList:" + r311);
            if (r310 != null) goto L5;
        L6:
            if (r311 != null) goto L8;
            return -1.0d;
        L8:
            if (r311.isEmpty() == true) goto L131;
        L10:
            String r100 = this.mVarsToParse;
            if (r100 != null) goto L13;
        L15:
            double r101 = 1.0d;
            double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (r311 == null) goto L45;
            Iterator<Float> r111 = r311.iterator();
        L19:
            if (r111.hasNext() == false) goto L24;
            if (r111.next().floatValue() > 0.0f) goto L19;
            r111.remove();
            goto L19
        L24:
            if (r311.isEmpty() == false) goto L26;
            double r102 = 0.0d;
            double r112 = 0.0d;
            double r210 = 0.0d;
            double r211 = 0.0d;
        L44:
            double r103 = r112;
            double r113 = r210;
            r110 = r211;
        L46:
            if (r310 == null) goto L66;
            Iterator<Integer> r104 = r310.iterator();
        L49:
            if (r104.hasNext() == false) goto L54;
            if (r104.next().intValue() > 0) goto L49;
            r104.remove();
            goto L49
        L54:
            if (r310.size() <= 0) goto L66;
            Iterator<Integer> r105 = r310.iterator();
            double r114 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r212 = Double.MIN_VALUE;
            double r213 = Double.MAX_VALUE;
        L57:
            if (r105.hasNext() == false) goto L65;
            r115 = r115 + r101;
            double r106 = r105.next().intValue();
            r114 = r114 + r106;
            if (r106 <= r212) goto L62;
            r212 = r106;
        L62:
            if (r106 >= r213) goto L64;
            r213 = r106;
        L64:
            r101 = 1.0d;
            goto L57
        L65:
            double r107 = (r114 / r115) / 1000.0d;
            double r108 = (r212 - r213) / 1000.0d;
        L67:
            int r116 = TTNetWorkListener.getInstance().getCurrentAccessType();
            int r109 = TTNetWorkListener.getInstance().getCurrentAccessStrength();
            if (r116 == 0) goto L81;
            if (r116 != 1) goto L71;
            double r214 = this.mParameters[9];
        L82:
            double r215 = r214;
        L84:
            if (r109 != 1) goto L86;
            double r216 = this.mParameters[12];
        L96:
            double r117 = r216;
        L97:
            StringBuilder r118 = new StringBuilder("calculateTargetBitrate speedMean:");
            r118.append(r103);
            r118.append(", speedStd:");
            r118.append(r102);
            r118.append(", speedMin:");
            r118.append(r113);
            r118.append(", speedMax:");
            r118.append(r110);
            r118.append(", rttMean:");
            r118.append(r107);
            r118.append(", rttVar:");
            r118.append(r108);
            r118.append(", netTypeVar:");
            double r217 = r108;
            double r119 = r215;
            r118.append(r119);
            r118.append(", sigStrengthVar:");
            r118.append(r117);
            TTVideoEngineLog.d(PortraitNetworkScore.TAG, r118.toString());
            double[] r120 = this.mParameters;
            double r121 = (((((((r120[0] + (r120[1] * r103)) + (r120[2] * r102)) + (r120[3] * r113)) + (r120[4] * r110)) + (r120[5] * r107)) + (r120[6] * r217)) + r119) + r117;
            double r122 = this.mLinkFuncOffset;
            if (r121 > r122) goto L100;
            double r123 = r122 * Math.pow(2.718281828459045d, r121 - r122);
        L102:
            if (Double.isNaN(r123) == false) goto L104;
            double r124 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r125 = -1.0d;
        L106:
            if (r125 <= r124) goto L108;
            PortraitNetworkScore.access$102(r125);
        L108:
            TTVideoEngineLog.d(PortraitNetworkScore.TAG, "calculateTargetBitrate pred:" + r121 + ", qualityBitrate:" + r125 + ", mLastTargetBitrate:" + PortraitNetworkScore.access$100());
            return r125;
        L104:
            r125 = r123;
            r124 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L106
        L100:
            r123 = r121;
            goto L102
        L86:
            if (r109 != 2) goto L88;
            r216 = this.mParameters[13];
            goto L96
        L88:
            if (r109 != 3) goto L90;
            r216 = this.mParameters[14];
            goto L96
        L90:
            if (r109 == 4) goto L92;
            r117 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L97
        L92:
            r216 = this.mParameters[15];
            goto L96
        L71:
            if (r116 != 2) goto L73;
            r214 = this.mParameters[7];
            goto L82
        L73:
            if (r116 != 3) goto L75;
            r214 = this.mParameters[8];
            goto L82
        L75:
            if (r116 == 4) goto L77;
            r215 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L84
        L77:
            r214 = this.mParameters[10];
            goto L82
        L81:
            r214 = this.mParameters[11];
        L66:
            r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
            r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L67
        L26:
            Iterator<Float> r126 = r311.iterator();
            double r127 = 0.0d;
            double r128 = 0.0d;
            double r218 = Double.MAX_VALUE;
            double r219 = Double.MIN_VALUE;
        L28:
            if (r126.hasNext() == false) goto L36;
            double r129 = r126.next().floatValue();
            r128 = r128 + r129;
            r127 = r127 + 1.0d;
            if (r129 >= r218) goto L33;
            r218 = r129;
        L33:
            if (r129 <= r219) goto L28;
            r219 = r129;
            goto L28
        L36:
            if (r127 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L38;
            double r130 = r128 / r127;
        L39:
            r210 = r218 / 1048576.0d;
            r211 = r219 / 1048576.0d;
            double r131 = 0.0d;
            int r132 = 0;
        L41:
            if (r132 >= r311.size()) goto L43;
            r131 = r131 + Math.pow(((double) ((Float) ListProtector.get(r311, r132)).floatValue()) - r130, 2.0d);
            r132 = r132 + 1;
            goto L41
        L43:
            r102 = Math.sqrt(r131 / ((double) r311.size())) / 1048576.0d;
            r112 = r130 / 1048576.0d;
            goto L44
        L38:
            r130 = 0.0d;
            goto L39
        L45:
            r102 = 0.0d;
            r103 = 0.0d;
            r113 = 0.0d;
            goto L46
        L13:
            if (r100.isEmpty() == true) goto L15;
            parseVariable(this.mVarsToParse);
            this.mVarsToParse = null;
            goto L15
        L131:
            return -1.0d;
        L5:
            if (r310.isEmpty() == false) goto L10;
            goto L6
        }

        @Override // com.ss.ttvideoengine.log.PortraitNetworkScore.NetworkQualityAlgorithm
        public void setStringOption(int r100, String r101) {
            if (r100 != 4) goto L7;
            this.mVarsToParse = r101;
            return;
        }
    }

    @Override // com.ss.ttvideoengine.portrait.IPortrait
    public int getId() {
        return 1;
    }

    public static PortraitNetworkScore getInstance() {
        if (mInstance != null) goto L6;
        mInstance = new PortraitNetworkScore();
    L6:
        return mInstance;
    }

    public NetworkQualityAlgorithm genNetworkQualityAlg() {
        return new NetworkQualityAlgorithmV2();
    }

    public int getLastPortraitResult() {
        NetworkQualityAlgorithm r100 = this.mQualityAlg;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getLastNetworkScore();
    }

    public int getNetworkRTTLevel() {
        return this.mPortraitData.getNetworkRTTLevel();
    }

    public int getNetworkRTTMS() {
        return this.mPortraitData.getNetworkRTTMS();
    }

    public int getPortraitResult() {
        NetworkQualityAlgorithm r100 = this.mQualityAlg;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getNetworkScore();
    }

    public void start() {
        this.mPortraitData.start();
        this.mQualityAlg = new NetworkQualityAlgorithmV1(this);
    }

    public void stop() {
        this.mPortraitData.stop();
    }

    private PortraitNetworkScore() {
        this.mQualityAlg = null;
        this.mPortraitData = new NetworkPortraitData();
    }

    public static /* synthetic */ double access$100() {
        return mLastTargetBitrate;
    }

    public double getLastTargetBitrate() {
        return mLastTargetBitrate;
    }

    public NetworkPortraitData getPortraitData() {
        return this.mPortraitData;
    }

    public static /* synthetic */ NetworkPortraitData access$000(PortraitNetworkScore r100) {
        return r100.mPortraitData;
    }

    public static /* synthetic */ double access$102(double r100) {
        mLastTargetBitrate = r100;
        return r100;
    }

    public void setNetworkRTTLevelListener(networkRTTLevelListener r100) {
        this.mPortraitData.setNetworkRTTLevelListener(r100);
    }

    public void setIntOption(int r100, int r101) {
        if (r100 != 2) goto L5;
        this.mPortraitData.setMaxCount(r101);
        return;
    L5:
        if (r100 != 3) goto L7;
        if (r101 <= 0) goto L17;
        this.mPortraitData.setSampleInterval(r101);
        start();
        return;
    L17:
        return;
    L7:
        if (r100 != 4) goto L19;
        if (r101 >= 0) goto L11;
        return;
    L11:
        this.mPortraitData.setMinDataSize(r101);
        return;
    }

    public void setStringOption(int r100, String r101) {
        this.mQualityAlg.setStringOption(r100, r101);
    }
}
