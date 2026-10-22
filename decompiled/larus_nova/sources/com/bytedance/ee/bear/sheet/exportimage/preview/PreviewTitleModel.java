package com.bytedance.ee.bear.sheet.exportimage.preview;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class PreviewTitleModel implements NonProguard {
    private Item rightItem;
    private Item titleItem;

    public static class Item implements NonProguard {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        String f237532id;
        String text;

        public Item() {
        }

        public String toString() {
            return "Item{text='" + this.text + "', id='" + this.f237532id + "'}";
        }

        public String getId() {
            return this.f237532id;
        }

        public String getText() {
            return this.text;
        }

        public void setId(String r100) {
            this.f237532id = r100;
        }

        public void setText(String r100) {
            this.text = r100;
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

    public void setRightItem(Item r100) {
        this.rightItem = r100;
    }

    public void setTitleItem(Item r100) {
        this.titleItem = r100;
    }
}
