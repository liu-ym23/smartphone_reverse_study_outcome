package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class y extends SettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f472070a = null;

    static {
        f472070a = new y();
    }

    public y() {
        super("live_notify_effect_frequency_config", "高级消息控制策略", "{\n    \"configs\": [\n        {\n            \"forAnchor\": 1,\n            \"scenes\": [\n                {\n                    \"key\": \"traffic_strategy\",\n                    \"maxWatingTime\": 30000,\n                    \"subScenes\": [\n                        {\n                            \"key\": \"feed_exposure\",\n                            \"frequencyConfig\": {\n                                \"timeGap\": 60000,\n                                \"maxNumInTimeSlice\": 3\n                            },\n                            \"maxShowTimes\": 10\n                        },\n                        {\n                            \"key\": \"valuable_user_guide\",\n                            \"frequencyConfig\": {\n                                \"timeGap\": 30000,\n                                \"maxNumInTimeSlice\": 1\n                            }\n                        }\n                    ]\n                }\n            ]\n        },\n        {\n            \"forAnchor\": 3,\n            \"scenes\": [\n                {\n                    \"key\": \"sell_well\",\n                    \"frequencyConfig\": {\n                        \"timeGap\": 60000,\n                        \"maxNumInTimeSlice\": 10\n                    }\n                }\n            ]\n        }\n    ]\n}", "{\n    \"configs\": [\n        {\n            \"forAnchor\": 1,\n            \"scenes\": [\n                {\n                    \"key\": \"traffic_strategy\",\n                    \"maxWatingTime\": 30000,\n                    \"subScenes\": [\n                        {\n                            \"key\": \"feed_exposure\",\n                            \"frequencyConfig\": {\n                                \"timeGap\": 60000,\n                                \"maxNumInTimeSlice\": 3\n                            },\n                            \"maxShowTimes\": 10\n                        },\n                        {\n                            \"key\": \"valuable_user_guide\",\n                            \"frequencyConfig\": {\n                                \"timeGap\": 30000,\n                                \"maxNumInTimeSlice\": 1\n                            }\n                        }\n                    ]\n                }\n            ]\n        },\n        {\n            \"forAnchor\": 3,\n            \"scenes\": [\n                {\n                    \"key\": \"sell_well\",\n                    \"frequencyConfig\": {\n                        \"timeGap\": 60000,\n                        \"maxNumInTimeSlice\": 10\n                    }\n                }\n            ]\n        }\n    ]\n}", false);
    }
}
