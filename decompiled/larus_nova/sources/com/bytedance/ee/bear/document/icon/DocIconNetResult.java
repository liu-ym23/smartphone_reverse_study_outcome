package com.bytedance.ee.bear.document.icon;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class DocIconNetResult extends Result<Data> implements NonProguard {

    public static class Category implements NonProguard {
        public int category_id;
        public List<Section> data;
        public Map<String, String> title;

        public Category() {
        }

        public String toString() {
            return "Category{category_id=" + this.category_id + ", title=" + this.title + ", sections=" + this.data + '}';
        }
    }

    public static class Data implements NonProguard {
        public List<Category> data;

        public Data() {
        }

        public String toString() {
            return "DocIconData{categories=" + this.data + '}';
        }
    }

    public static class Icon implements NonProguard {
        public String fs_unit;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public int f219956id;
        public String key;
        public Map<String, String> name;
        public int type;

        public Icon() {
        }

        public String toString() {
            return "Icon{id=" + this.f219956id + ", key='" + this.key + "', type=" + this.type + ", fs_unit='" + this.fs_unit + "', name=" + this.name + '}';
        }
    }

    public static class Section implements NonProguard {
        public int category_id;
        public List<Icon> data;
        public Map<String, String> sub_title;
        public int type;

        public Section() {
        }

        public String toString() {
            return "Section{category_id=" + this.category_id + ", sub_title=" + this.sub_title + ", icons=" + this.data + '}';
        }
    }

    public DocIconNetResult() {
    }
}
