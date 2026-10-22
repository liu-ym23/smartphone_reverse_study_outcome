package com.bytedance.ee.bear.sheet.exportimage.preview;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PreviewTitleModel implements NonProguard {
    private Item rightItem;
    private Item titleItem;

    public static class Item implements NonProguard {
        String id;
        String text;

        public Item() {
        }

        public String toString() {
            return "Item{text='" + this.text + "', id='" + this.id + "'}";
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

    public PreviewTitleModel() {
    }

    public String toString() {
        return "PreviewTitleModel{rightItem=" + this.rightItem + ", titleItem=" + this.titleItem + '}';
    }

    public Item getRightItem() {
        return this.rightItem;
    }

    public Item getTitleItem() {
        return this.titleItem;
    }

    public void setRightItem(Item r1) {
        this.rightItem = r1;
    }

    public void setTitleItem(Item r1) {
        this.titleItem = r1;
    }
}
