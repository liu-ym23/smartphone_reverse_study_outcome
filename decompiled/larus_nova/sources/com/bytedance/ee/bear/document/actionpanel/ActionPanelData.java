package com.bytedance.ee.bear.document.actionpanel;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ActionPanelData implements NonProguard {
    private Callback callback;
    private List<Data> data;
    private String title;

    public static class Callback implements NonProguard {
        private String actionId;

        public Callback() {
        }

        public String getActionId() {
            return this.actionId;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }
    }

    public static class Data implements NonProguard {
        private String actionId;
        private int actionStyle;
        private boolean clickable;
        private String title;

        public String toString() {
            return "Data{actionId='" + this.actionId + "', title='" + this.title + "', actionStyle=" + this.actionStyle + '}';
        }

        public Data() {
            this.clickable = true;
        }

        public String getActionId() {
            return this.actionId;
        }

        public int getActionStyle() {
            return this.actionStyle;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isClickable() {
            return this.clickable;
        }

        public void setActionId(String r100) {
            this.actionId = r100;
        }

        public void setActionStyle(int r100) {
            this.actionStyle = r100;
        }

        public void setClickable(boolean r100) {
            this.clickable = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
        }
    }

    public ActionPanelData() {
    }

    public String toString() {
        return "ActionPanelData{data=" + this.data + ", callback=" + this.callback + '}';
    }

    public Callback getCallback() {
        return this.callback;
    }

    public List<Data> getData() {
        return this.data;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCallback(Callback r100) {
        this.callback = r100;
    }

    public void setData(List<Data> r100) {
        this.data = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
