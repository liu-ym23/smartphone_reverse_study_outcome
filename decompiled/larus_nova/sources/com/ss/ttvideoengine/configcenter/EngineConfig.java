package com.ss.ttvideoengine.configcenter;

import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public final class EngineConfig implements IEngineConfig {
    private static final String TAG = "EngineConfig";
    private static final Map<Integer, Object> defaultValueMap = null;
    private final ConfigItemFactory configItemFactory;
    private final boolean enableDiffCheck;
    private final Map<Integer, ConfigItem> itemMap;

    public final class Builder {
        private final Map<Integer, ConfigItem> builderMap;
        final /* synthetic */ EngineConfig this$0;

        public EngineConfig build() {
            return new EngineConfig(this.builderMap);
        }

        public Builder(EngineConfig r100) {
            this.this$0 = r100;
            this.builderMap = new HashMap();
        }

        public Builder setFloatOption(int r100, float r101) {
            ConfigItem r102 = EngineConfig.access$000(this.this$0).createFloatOption(r100, r101);
            this.builderMap.put(Integer.valueOf(r100), r102);
            return this;
        }

        public Builder setIntOption(int r100, int r101) {
            ConfigItem r102 = EngineConfig.access$000(this.this$0).createIntOption(r100, r101);
            this.builderMap.put(Integer.valueOf(r100), r102);
            return this;
        }

        public Builder setLongOption(int r100, int r101) {
            ConfigItem r102 = EngineConfig.access$000(this.this$0).createIntOption(r100, r101);
            this.builderMap.put(Integer.valueOf(r100), r102);
            return this;
        }

        public Builder setStringOption(int r100, String r101) {
            ConfigItem r102 = EngineConfig.access$000(this.this$0).createStringOption(r100, r101);
            this.builderMap.put(Integer.valueOf(r100), r102);
            return this;
        }
    }

    static {
        HashMap r100 = new HashMap();
        defaultValueMap = r100;
        r100.put(963, 1);
        r100.put(5, 3);
        r100.put(11, 30);
        r100.put(12, 5000000);
        r100.put(612, 1);
        r100.put(85, -1);
        r100.put(28, 30);
        r100.put(100, 1);
        r100.put(160, Integer.valueOf(EngineGlobalConfig.getInstance().isOnlyUseMediaLoader() ? 1 : 0));
        r100.put(110, -1);
        r100.put(310, -1);
        r100.put(675, -1);
        r100.put(956, -1);
        r100.put(1406, -1);
        r100.put(183, 1);
        r100.put(184, 1);
        r100.put(201, 500);
        r100.put(202, 5000);
        r100.put(851, 10);
        r100.put(852, 300);
        r100.put(853, 3);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_HW_DYNAMIC_FRAME_DROPPING_MULTIPLE), 10);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_HW_DYNAMIC_FRAME_DROPPING_CHECK_PERIOD), 300);
        r100.put(864, 3);
        r100.put(950, 500);
        r100.put(207, 2);
        r100.put(208, 1);
        r100.put(215, 1);
        r100.put(414, 3);
        r100.put(37, 1);
        r100.put(417, 1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK), 1);
        r100.put(422, 1048576);
        r100.put(423, Integer.valueOf(TTVideoEngineInterface.DEFAULT_AUDIO_RANGE_SIZE));
        r100.put(474, 5000);
        r100.put(475, 10000);
        r100.put(424, 2);
        r100.put(427, 1);
        r100.put(430, -1);
        r100.put(476, 2);
        r100.put(500, 500);
        r100.put(504, 1);
        r100.put(574, 4);
        r100.put(506, 2);
        Resolution r101 = Resolution.Undefine;
        r100.put(502, Integer.valueOf(r101.getIndex()));
        r100.put(544, Integer.valueOf(r101.getIndex()));
        Resolution r102 = Resolution.SuperHigh;
        r100.put(536, Integer.valueOf(r102.getIndex()));
        r100.put(537, Integer.valueOf(r102.getIndex()));
        r100.put(334, -1);
        r100.put(335, -1);
        r100.put(341, -1);
        r100.put(342, -1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_SET_NETSPEED_LEVEL), -1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_SEGMENT_FORMAT_FLAG), 2);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_PREPARE_CACHE_MS), 1000);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_USE_FALLBACK_API), 1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_UPDATE_TIMESTAMP_MODE), 1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT), 1);
        r100.put(568, -1);
        r100.put(517, -3);
        r100.put(607, 5000000);
        r100.put(610, 1);
        r100.put(657, 300);
        r100.put(558, 1);
        r100.put(670, 1);
        r100.put(255, 3);
        r100.put(700, -1);
        r100.put(572, 1);
        r100.put(721, 1);
        r100.put(578, 1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_ENABLE_GET_PLAYER_REQ_OFFSET), 1);
        r100.put(801, -1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_SET_AUDIOTRACK_CONTENTTYPE), -1);
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_METRICS_INTERVAL), 60);
        r100.put(325, Float.valueOf(0.25f));
        r100.put(326, Float.valueOf(-18.0f));
        r100.put(327, Float.valueOf(8.0f));
        r100.put(328, Float.valueOf(0.007f));
        r100.put(348, Float.valueOf(200.0f));
        r100.put(349, Float.valueOf(3.0f));
        r100.put(359, Float.valueOf(50.0f));
        r100.put(526, Float.valueOf(0.9f));
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER), Float.valueOf(9.0f));
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_ABR_SWITCH_PENALTY_PARAMETER), Float.valueOf(2.0f));
        r100.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_ABR_BANDWIDTH_PARAMETER), Float.valueOf(1.0f));
        r100.put(531, "");
        r100.put(355, "");
        r100.put(532, "");
        r100.put(546, "");
        r100.put(547, "");
        r100.put(1000, "h264");
        r100.put(4024, 4);
        r100.put(571, 1);
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public void reset() {
        this.itemMap.clear();
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public Map<Integer, ConfigItem> getItemMap() {
        return this.itemMap;
    }

    public EngineConfig(Map<Integer, ConfigItem> r100) {
        this(false, r100);
    }

    public static /* synthetic */ ConfigItemFactory access$000(EngineConfig r100) {
        return r100.configItemFactory;
    }

    private Object getConfigItemValueOrDefault(int r100) {
    L8:
        e = move-exception;
        TTVideoEngineLog.e(TAG, e.getMessage());
        return null;
    L3:
        if (this.itemMap.containsKey(Integer.valueOf(r100)) == false) goto L7;
        return this.itemMap.get(Integer.valueOf(r100)).getValue();
    L7:
        return defaultValueMap.get(Integer.valueOf(r100));
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public float getFloatOption(int r100) {
        Object r101 = getConfigItemValueOrDefault(r100);
        if (r101 == null) goto L12;
        return ((Float) r101).floatValue();
    L7:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "key: " + r100 + ", " + e.getMessage());
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public int getIntOption(int r100) {
        Object r101 = getConfigItemValueOrDefault(r100);
        if (r101 == null) goto L12;
        return ((Integer) r101).intValue();
    L7:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "key: " + r100 + ", " + e.getMessage());
        return 0;
    L12:
        return 0;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public long getLongOption(int r100) {
        Object r101 = getConfigItemValueOrDefault(r100);
        if (r101 == null) goto L12;
        return ((Long) r101).longValue();
    L7:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "key: " + r100 + ", " + e.getMessage());
        return 0;
    L12:
        return 0;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem getOption(int r100) {
        return this.itemMap.get(Integer.valueOf(r100));
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public String getStringOption(int r100) {
        Object r101 = getConfigItemValueOrDefault(r100);
        if (r101 == null) goto L13;
        return (String) r101;
    L8:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "key: " + r100 + ", " + e.getMessage());
        return null;
    L13:
        return "";
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public boolean isKeySet(int r100) {
        return this.itemMap.containsKey(Integer.valueOf(r100));
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public void remove(int r100) {
        this.itemMap.remove(Integer.valueOf(r100));
    }

    public EngineConfig(boolean r100, Map<Integer, ConfigItem> r101) {
        this.configItemFactory = new ConfigItemFactory();
        this.enableDiffCheck = r100;
        this.itemMap = r101;
    }

    private boolean isSameString(String r100, String r101) {
        return Objects.equals(r100, r101);
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setFloatOption(int r100, float r101) {
        if (this.enableDiffCheck == true) goto L5;
    L8:
        ConfigItem r102 = this.configItemFactory.createFloatOption(r100, r101);
        if (r102 == null) goto L11;
        this.itemMap.put(Integer.valueOf(r100), r102);
    L11:
        return r102;
    L5:
        if (r101 != getFloatOption(r100)) goto L8;
        TTVideoEngineLog.i(TAG, "option value not changed");
        return null;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setIntOption(int r100, int r101) {
        if (this.enableDiffCheck == true) goto L5;
    L8:
        ConfigItem r102 = this.configItemFactory.createIntOption(r100, r101);
        if (r102 == null) goto L11;
        this.itemMap.put(Integer.valueOf(r100), r102);
    L11:
        return r102;
    L5:
        if (r101 != getIntOption(r100)) goto L8;
        TTVideoEngineLog.i(TAG, "option value not changed");
        return null;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setLongOption(int r100, long r101) {
        if (this.enableDiffCheck == true) goto L5;
    L8:
        ConfigItem r102 = this.configItemFactory.createLongOption(r100, r101);
        if (r102 == null) goto L11;
        this.itemMap.put(Integer.valueOf(r100), r102);
    L11:
        return r102;
    L5:
        if (r101 != getLongOption(r100)) goto L8;
        TTVideoEngineLog.i(TAG, "option value not changed");
        return null;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setStringOption(int r100, String r101) {
        if (this.enableDiffCheck == true) goto L5;
    L8:
        ConfigItem r102 = this.configItemFactory.createStringOption(r100, r101);
        if (r102 == null) goto L11;
        this.itemMap.put(Integer.valueOf(r100), r102);
    L11:
        return r102;
    L5:
        if (isSameString(r101, getStringOption(r100)) == false) goto L8;
        TTVideoEngineLog.i(TAG, "option value not changed");
        return null;
    }
}
