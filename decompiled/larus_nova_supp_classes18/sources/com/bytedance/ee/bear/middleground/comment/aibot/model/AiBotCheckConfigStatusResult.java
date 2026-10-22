package com.bytedance.ee.bear.middleground.comment.aibot.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AiBotCheckConfigStatusResult extends Result<ResultsData> implements NonProguard {

    public static class Data implements NonProguard, Serializable {

        @JSONField(name = "auth_url")
        public String authUrl;

        @JSONField(name = "bot_id")
        public long botId;

        @JSONField(name = "device_code")
        public String deviceCode;

        @JSONField(name = "device_code_expire_time")
        public Long deviceCodeExpireTime;

        @JSONField(name = "finished_config")
        public boolean finishedConfig;

        @JSONField(name = "has_app_visibility")
        public boolean hasAppVisibility;

        @JSONField(name = "help_doc_url")
        public String helpDocUrl;

        @JSONField(name = "is_app_manager")
        public boolean isAppManager;

        @JSONField(name = "is_event_subscribed")
        public boolean isEventSubscribed;

        @JSONField(name = "is_scope_authed")
        public boolean isScopeAuthed;

        @JSONField(name = "is_store_app")
        public boolean isStoreApp;

        public Data() {
        }
    }

    public static class ResultsData implements NonProguard, Serializable {
        public ArrayList<Data> results;

        public ResultsData() {
        }
    }

    public AiBotCheckConfigStatusResult() {
    }
}
