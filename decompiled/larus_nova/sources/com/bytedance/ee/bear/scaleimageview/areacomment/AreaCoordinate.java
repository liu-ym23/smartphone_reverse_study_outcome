package com.bytedance.ee.bear.scaleimageview.areacomment;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
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

        public void setBottom(float r100) {
            this.bottom = r100;
        }

        public void setLeft(float r100) {
            this.left = r100;
        }

        public void setPage(int r100) {
            this.page = r100;
        }

        public void setQuads(Quad[] r100) {
            this.quads = r100;
        }

        public void setRight(float r100) {
            this.right = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }

        public void setTop(float r100) {
            this.top = r100;
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

    public void setPosition(Position r100) {
        this.position = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
