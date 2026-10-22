package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ReactionPanel implements BaseJSModel {
    private Position position;
    private List<OperationItem> toolBar;

    public static class OperationItem implements BaseJSModel {
        private String id;
        private String text;

        public OperationItem() {
        }

        public String toString() {
            return "OperationItem{id='" + this.id + "', text='" + this.text + "'}";
        }

        public String getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setText(String r1) {
            this.text = r1;
        }
    }

    public static class Position implements BaseJSModel {
        private int x;
        private int y;

        public Position() {
        }

        public String toString() {
            return "Position{x=" + this.x + ", y=" + this.y + '}';
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setX(int r1) {
            this.x = r1;
        }

        public void setY(int r1) {
            this.y = r1;
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

    public void setPosition(Position r1) {
        this.position = r1;
    }

    public void setToolBar(List<OperationItem> r1) {
        this.toolBar = r1;
    }
}
