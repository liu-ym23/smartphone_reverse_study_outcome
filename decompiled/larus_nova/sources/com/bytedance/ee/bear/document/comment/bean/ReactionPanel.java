package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ReactionPanel implements BaseJSModel {
    private Position position;
    private List<OperationItem> toolBar;

    public static class OperationItem implements BaseJSModel {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f219283id;
        private String text;

        public OperationItem() {
        }

        public String toString() {
            return "OperationItem{id='" + this.f219283id + "', text='" + this.text + "'}";
        }

        public String getId() {
            return this.f219283id;
        }

        public String getText() {
            return this.text;
        }

        public void setId(String r100) {
            this.f219283id = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }
    }

    public static class Position implements BaseJSModel {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f219284x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f219285y;

        public Position() {
        }

        public String toString() {
            return "Position{x=" + this.f219284x + ", y=" + this.f219285y + '}';
        }

        public int getX() {
            return this.f219284x;
        }

        public int getY() {
            return this.f219285y;
        }

        public void setX(int r100) {
            this.f219284x = r100;
        }

        public void setY(int r100) {
            this.f219285y = r100;
        }
    }

    public ReactionPanel() {
    }

    public String toString() {
        return "OperationPanel{position=" + this.position + ", toolBar=" + this.toolBar + '}';
    }

    public Position getPosition() {
        return this.position;
    }

    public List<OperationItem> getToolBar() {
        return this.toolBar;
    }

    public void setPosition(Position r100) {
        this.position = r100;
    }

    public void setToolBar(List<OperationItem> r100) {
        this.toolBar = r100;
    }
}
