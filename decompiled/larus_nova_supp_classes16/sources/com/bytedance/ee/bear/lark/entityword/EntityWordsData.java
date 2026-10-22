package com.bytedance.ee.bear.lark.entityword;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class EntityWordsData implements NonProguard {
    private String abbrId;
    private String clientArgs;
    private String query;
    private TriggerInfo triggerInfo;

    public static class TriggerInfo implements NonProguard {
        private double height;
        private double width;
        private int x;
        private int y;

        private TriggerInfo() {
        }

        public double getHeight() {
            return this.height;
        }

        public double getWidth() {
            return this.width;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setHeight(double r1) {
            this.height = r1;
        }

        public void setWidth(double r1) {
            this.width = r1;
        }

        public void setX(int r1) {
            this.x = r1;
        }

        public void setY(int r1) {
            this.y = r1;
        }
    }

    public EntityWordsData() {
    }

    public String getAbbrId() {
        return this.abbrId;
    }

    public String getClientArgs() {
        return this.clientArgs;
    }

    public String getQuery() {
        return this.query;
    }

    public TriggerInfo getTriggerInfo() {
        return this.triggerInfo;
    }

    public void setAbbrId(String r1) {
        this.abbrId = r1;
    }

    public void setClientArgs(String r1) {
        this.clientArgs = r1;
    }

    public void setQuery(String r1) {
        this.query = r1;
    }

    public void setTriggerInfo(TriggerInfo r1) {
        this.triggerInfo = r1;
    }
}
