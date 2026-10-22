package com.bytedance.ee.bear.drive.view.preview.excel;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ExcelPreviewExtraBean implements NonProguard {
    private MainBean main;
    private List<SheetsBean> sheets;
    private StyleBean style;

    public static class MainBean implements NonProguard {
        private long file_id;
        private String name;
        private long version;

        public MainBean() {
        }

        public String toString() {
            return "MainBean{name='" + this.name + "', file_id=" + this.file_id + ", version=" + this.version + '}';
        }

        public long getFile_id() {
            return this.file_id;
        }

        public String getName() {
            return this.name;
        }

        public long getVersion() {
            return this.version;
        }

        public void setFile_id(long r100) {
            this.file_id = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setVersion(long r100) {
            this.version = r100;
        }
    }

    public static class SheetsBean implements NonProguard {
        private long file_id;
        private String name;
        private long size;
        private long version;

        public SheetsBean() {
        }

        public long getFile_id() {
            return this.file_id;
        }

        public String getName() {
            return this.name;
        }

        public long getSize() {
            return this.size;
        }

        public long getVersion() {
            return this.version;
        }

        public void setFile_id(long r100) {
            this.file_id = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setSize(long r100) {
            this.size = r100;
        }

        public void setVersion(long r100) {
            this.version = r100;
        }
    }

    public static class StyleBean implements NonProguard {
        private long file_id;
        private String name;
        private long version;

        public StyleBean() {
        }

        public String toString() {
            return "StyleBean{name='" + this.name + "', file_id=" + this.file_id + ", version=" + this.version + '}';
        }

        public long getFile_id() {
            return this.file_id;
        }

        public String getName() {
            return this.name;
        }

        public long getVersion() {
            return this.version;
        }

        public void setFile_id(long r100) {
            this.file_id = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setVersion(long r100) {
            this.version = r100;
        }
    }

    public ExcelPreviewExtraBean() {
    }

    public String toString() {
        return "ExcelPreviewExtraBean{main=" + this.main + ", style=" + this.style + ", sheets=" + this.sheets + '}';
    }

    public MainBean getMain() {
        return this.main;
    }

    public List<SheetsBean> getSheets() {
        return this.sheets;
    }

    public StyleBean getStyle() {
        return this.style;
    }

    public void setMain(MainBean r100) {
        this.main = r100;
    }

    public void setSheets(List<SheetsBean> r100) {
        this.sheets = r100;
    }

    public void setStyle(StyleBean r100) {
        this.style = r100;
    }
}
