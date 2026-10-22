package com.bytedance.ee.bear.bitable.toolbox.model.fab;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BitableFabModel implements NonProguard {
    private BitableFabItem[] data;
    public Boolean isEditableStage;

    public static class BitableFabItem implements NonProguard {
        public String[] carouselTexts;
        private boolean disabled;
        private boolean enable;
        public boolean fromCache;
        private String id;
        private String title;

        public BitableFabItem() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.id});
        }

        public String toString() {
            return "BitableFabItem{id='" + this.id + "'title = '" + this.title + " '}";
        }

        public String getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isDisabled() {
            return this.disabled;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L19;
            BitableFabItem r6 = (BitableFabItem) r5;
            if (this.disabled == r6.disabled) goto L13;
        L17:
            return false;
        L13:
            if (Objects.equals(this.id, r6.id) == false) goto L17;
            if (Objects.equals(this.title, r6.title) == false) goto L17;
            return true;
        }

        public void setDisabled(boolean r1) {
            this.disabled = r1;
        }

        public void setEnable(boolean r1) {
            this.enable = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }
    }

    public BitableFabModel() {
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public String toString() {
        return "BitableFabModel{data=" + Arrays.toString(this.data) + '}';
    }

    public BitableFabItem[] getData() {
        return this.data;
    }

    public static boolean isValid(BitableFabModel r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.getData() == null) goto L8;
        if (r1.getData().length <= 0) goto L8;
        return true;
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
        return Arrays.equals(this.data, ((BitableFabModel) r3).data);
    }

    public void setData(BitableFabItem[] r1) {
        this.data = r1;
    }
}
