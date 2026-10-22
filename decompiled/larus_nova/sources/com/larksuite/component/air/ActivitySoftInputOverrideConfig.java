package com.larksuite.component.air;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
@AppConfig(key = "activity_softinput_override")
public class ActivitySoftInputOverrideConfig implements Serializable {

    @SerializedName("items")
    private ArrayList<Item> items;

    public static class Item implements Serializable {

        @SerializedName("activity")
        private String activity;

        @SerializedName("ignore_window_flags")
        private boolean ignoreWindowFlags;

        @SerializedName("soft_input_mode")
        private String softInputMode;

        public Item() {
        }

        public String getActivity() {
            return this.activity;
        }

        public String getSoftInputMode() {
            return this.softInputMode;
        }

        public boolean isIgnoreWindowFlags() {
            return this.ignoreWindowFlags;
        }

        public void setActivity(String r100) {
            this.activity = r100;
        }

        public void setIgnoreWindowFlags(boolean r100) {
            this.ignoreWindowFlags = r100;
        }

        public void setSoftInputMode(String r100) {
            this.softInputMode = r100;
        }
    }

    public ActivitySoftInputOverrideConfig() {
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> r100) {
        this.items = new ArrayList(r100);
    }
}
