package com.bytedance.ee.bear.document.dialog.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MoreDialogModel implements NonProguard {
    private List<MoreDialogItem> items;

    public static class MoreDialogItem implements NonProguard {
        private boolean enable;
        private String id;
        private String text;

        public MoreDialogItem() {
        }

        public String toString() {
            return "MoreDialogItem{id='" + this.id + "', text='" + this.text + "', enable=" + this.enable + '}';
        }

        public String getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public void setEnable(boolean r1) {
            this.enable = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setText(String r1) {
            this.text = r1;
        }
    }

    public MoreDialogModel() {
    }

    public String toString() {
        return "MoreDialogModel{items=" + this.items + '}';
    }

    public List<MoreDialogItem> getItems() {
        return this.items;
    }

    public void setItems(List<MoreDialogItem> r1) {
        this.items = r1;
    }
}
