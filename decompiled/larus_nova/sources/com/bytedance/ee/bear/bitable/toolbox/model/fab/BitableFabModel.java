package com.bytedance.ee.bear.bitable.toolbox.model.fab;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class BitableFabModel implements NonProguard {
    private BitableFabItem[] data;
    public Boolean isEditableStage;

    public static class BitableFabItem implements NonProguard {
        public String[] carouselTexts;
        private boolean disabled;
        private boolean enable;
        public boolean fromCache;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f215995id;
        private String title;

        public BitableFabItem() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f215995id});
        }

        public String toString() {
            return "BitableFabItem{id='" + this.f215995id + "'title = '" + this.title + " '}";
        }

        public String getId() {
            return this.f215995id;
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

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L19;
            BitableFabItem r101 = (BitableFabItem) r100;
            if (this.disabled == r101.disabled) goto L13;
        L17:
            return false;
        L13:
            if (Objects.equals(this.f215995id, r101.f215995id) == false) goto L17;
            if (Objects.equals(this.title, r101.title) == false) goto L17;
            return true;
        }

        public void setDisabled(boolean r100) {
            this.disabled = r100;
        }

        public void setEnable(boolean r100) {
            this.enable = r100;
        }

        public void setId(String r100) {
            this.f215995id = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
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

    public static boolean isValid(BitableFabModel r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.getData() == null) goto L8;
        if (r100.getData().length <= 0) goto L8;
        return true;
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
        return Arrays.equals(this.data, ((BitableFabModel) r100).data);
    }

    public void setData(BitableFabItem[] r100) {
        this.data = r100;
    }
}
