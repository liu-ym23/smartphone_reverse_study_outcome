package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public void setTokenEnd(int r1) {
            this.tokenEnd = r1;
        }

        public void setTokenStart(int r1) {
            this.tokenStart = r1;
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

        public void setDetail(String r1) {
            this.detail = r1;
        }

        public void setInsertText(String r1) {
            this.insertText = r1;
        }

        public void setKind(String r1) {
            this.kind = r1;
        }

        public void setLabel(String r1) {
            this.label = r1;
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

    public void setAnchor(Anchor r1) {
        this.anchor = r1;
    }

    public void setItems(List<Item> r1) {
        this.items = r1;
    }

    public void setRequestId(String r1) {
        this.requestId = r1;
    }
}
