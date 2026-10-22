package com.bytedance.ee.bear.scaleimageview.areacomment;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AreaCoordinate implements Serializable {
    public static final int POSITION_BOTTOM = 4;
    public static final int POSITION_DATA_LENGTH = 5;
    public static final int POSITION_LEFT = 1;
    public static final int POSITION_RIGHT = 3;
    public static final int POSITION_TOP = 2;
    public static final int TYPE_RECT = 1;
    private Position position;
    private int type;

    public static class Position implements Serializable {
        private float bottom;
        private float left;
        private int page;

        @JSONField(name = "quads")
        private Quad[] quads;
        private float right;
        private String text;
        private float top;

        public Position() {
        }

        public String toString() {
            return "Position{page=" + this.page + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }

        public float getBottom() {
            return this.bottom;
        }

        public float getLeft() {
            return this.left;
        }

        public int getPage() {
            return this.page;
        }

        public Quad[] getQuads() {
            return this.quads;
        }

        public float getRight() {
            return this.right;
        }

        public String getText() {
            return this.text;
        }

        public float getTop() {
            return this.top;
        }

        public void setBottom(float r1) {
            this.bottom = r1;
        }

        public void setLeft(float r1) {
            this.left = r1;
        }

        public void setPage(int r1) {
            this.page = r1;
        }

        public void setQuads(Quad[] r1) {
            this.quads = r1;
        }

        public void setRight(float r1) {
            this.right = r1;
        }

        public void setText(String r1) {
            this.text = r1;
        }

        public void setTop(float r1) {
            this.top = r1;
        }
    }

    public AreaCoordinate() {
    }

    public String toString() {
        return "AreaCoordinate{type=" + this.type + ", position=" + this.position + '}';
    }

    public Position getPosition() {
        return this.position;
    }

    public int getType() {
        return this.type;
    }

    public void setPosition(Position r1) {
        this.position = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
