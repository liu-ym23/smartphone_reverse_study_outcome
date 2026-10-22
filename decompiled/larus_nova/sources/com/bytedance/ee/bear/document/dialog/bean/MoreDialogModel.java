package com.bytedance.ee.bear.document.dialog.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class MoreDialogModel implements NonProguard {
    private List<MoreDialogItem> items;

    public static class MoreDialogItem implements NonProguard {
        private boolean enable;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f219515id;
        private String text;

        public MoreDialogItem() {
        }

        public String toString() {
            return "MoreDialogItem{id='" + this.f219515id + "', text='" + this.text + "', enable=" + this.enable + '}';
        }

        public String getId() {
            return this.f219515id;
        }

        public String getText() {
            return this.text;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public void setEnable(boolean r100) {
            this.enable = r100;
        }

        public void setId(String r100) {
            this.f219515id = r100;
        }

        public void setText(String r100) {
            this.text = r100;
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

    public void setItems(List<MoreDialogItem> r100) {
        this.items = r100;
    }
}
