package com.bytedance.ee.bear.document.model.blockmenu;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class BlockMenu implements NonProguard {
    List<MenuItem> items;

    public static class MenuItem implements NonProguard {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        String f220256id;
        String text;

        public int hashCode() {
            return Objects.hash(new Object[]{this.f220256id, this.text});
        }

        public String toString() {
            return "MenuItem{id='" + this.f220256id + "', text='" + this.text + "'}";
        }

        public MenuItem() {
        }

        public String getId() {
            return this.f220256id;
        }

        public String getText() {
            return this.text;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L17;
            MenuItem r101 = (MenuItem) r100;
            if (Objects.equals(this.f220256id, r101.f220256id) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.text, r101.text) == false) goto L15;
            return true;
        }

        public void setId(String r100) {
            this.f220256id = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }

        public MenuItem(BlockMenuId r100, String r101) {
            this.f220256id = r100.name();
            this.text = r101;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.items});
    }

    public String toString() {
        return "BlockShortcutMenu{items=" + this.items + '}';
    }

    public BlockMenu() {
    }

    public List<MenuItem> getItems() {
        return this.items;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.items, ((BlockMenu) r100).items);
    }

    public void setItems(List<MenuItem> r100) {
        this.items = r100;
    }
}
