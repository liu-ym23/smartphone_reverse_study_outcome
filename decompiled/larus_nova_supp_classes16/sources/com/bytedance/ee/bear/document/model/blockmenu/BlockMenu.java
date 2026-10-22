package com.bytedance.ee.bear.document.model.blockmenu;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BlockMenu implements NonProguard {
    List<MenuItem> items;

    public static class MenuItem implements NonProguard {
        String id;
        String text;

        public int hashCode() {
            return Objects.hash(new Object[]{this.id, this.text});
        }

        public String toString() {
            return "MenuItem{id='" + this.id + "', text='" + this.text + "'}";
        }

        public MenuItem() {
        }

        public String getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L17;
            MenuItem r6 = (MenuItem) r5;
            if (Objects.equals(this.id, r6.id) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.text, r6.text) == false) goto L15;
            return true;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setText(String r1) {
            this.text = r1;
        }

        public MenuItem(BlockMenuId r1, String r2) {
            this.id = r1.name();
            this.text = r2;
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

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.items, ((BlockMenu) r3).items);
    }

    public void setItems(List<MenuItem> r1) {
        this.items = r1;
    }
}
