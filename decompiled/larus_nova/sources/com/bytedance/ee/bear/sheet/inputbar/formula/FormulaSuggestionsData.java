package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaSuggestionsData implements NonProguard {
    private Anchor anchor;
    private List<Item> items;
    private String requestId;

    public static class Anchor implements NonProguard {
        private int tokenEnd;
        private int tokenStart;

        public Anchor() {
        }

        public int getTokenEnd() {
            return this.tokenEnd;
        }

        public int getTokenStart() {
            return this.tokenStart;
        }

        public void setTokenEnd(int r100) {
            this.tokenEnd = r100;
        }

        public void setTokenStart(int r100) {
            this.tokenStart = r100;
        }
    }

    public static class Item implements NonProguard {
        private String detail;
        private String insertText;
        private String kind;
        private String label;

        public Item() {
        }

        public String getDetail() {
            return this.detail;
        }

        public String getInsertText() {
            return this.insertText;
        }

        public String getKind() {
            return this.kind;
        }

        public String getLabel() {
            return this.label;
        }

        public void setDetail(String r100) {
            this.detail = r100;
        }

        public void setInsertText(String r100) {
            this.insertText = r100;
        }

        public void setKind(String r100) {
            this.kind = r100;
        }

        public void setLabel(String r100) {
            this.label = r100;
        }
    }

    public FormulaSuggestionsData() {
    }

    public Anchor getAnchor() {
        return this.anchor;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAnchor(Anchor r100) {
        this.anchor = r100;
    }

    public void setItems(List<Item> r100) {
        this.items = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }
}
