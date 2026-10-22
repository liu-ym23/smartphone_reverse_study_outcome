package com.bytedance.ee.bear.lark.entityword;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
class EntityWordsData implements NonProguard {
    private String abbrId;
    private String clientArgs;
    private String query;
    private TriggerInfo triggerInfo;

    public static class TriggerInfo implements NonProguard {
        private double height;
        private double width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f227360x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f227361y;

        private TriggerInfo() {
        }

        public double getHeight() {
            return this.height;
        }

        public double getWidth() {
            return this.width;
        }

        public int getX() {
            return this.f227360x;
        }

        public int getY() {
            return this.f227361y;
        }

        public void setHeight(double r100) {
            this.height = r100;
        }

        public void setWidth(double r100) {
            this.width = r100;
        }

        public void setX(int r100) {
            this.f227360x = r100;
        }

        public void setY(int r100) {
            this.f227361y = r100;
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

    public void setAbbrId(String r100) {
        this.abbrId = r100;
    }

    public void setClientArgs(String r100) {
        this.clientArgs = r100;
    }

    public void setQuery(String r100) {
        this.query = r100;
    }

    public void setTriggerInfo(TriggerInfo r100) {
        this.triggerInfo = r100;
    }
}
