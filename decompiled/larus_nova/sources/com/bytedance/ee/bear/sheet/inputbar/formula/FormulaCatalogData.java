package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class FormulaCatalogData implements NonProguard {
    private Catalog catalog;

    public static class Catalog implements NonProguard {
        private List<Category> categories;
        private List<Item> popular;
        private String searchPlaceholder;
        private String title;

        public Catalog() {
        }

        public List<Category> getCategories() {
            return this.categories;
        }

        public List<Item> getPopular() {
            return this.popular;
        }

        public String getSearchPlaceholder() {
            return this.searchPlaceholder;
        }

        public String getTitle() {
            return this.title;
        }

        public void setCategories(List<Category> r100) {
            this.categories = r100;
        }

        public void setPopular(List<Item> r100) {
            this.popular = r100;
        }

        public void setSearchPlaceholder(String r100) {
            this.searchPlaceholder = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
        }
    }

    public static class Category implements NonProguard {
        private List<Item> functions;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f237986id;
        private String label;

        public Category() {
        }

        public List<Item> getFunctions() {
            return this.functions;
        }

        public String getId() {
            return this.f237986id;
        }

        public String getLabel() {
            return this.label;
        }

        public void setFunctions(List<Item> r100) {
            this.functions = r100;
        }

        public void setId(String r100) {
            this.f237986id = r100;
        }

        public void setLabel(String r100) {
            this.label = r100;
        }
    }

    public static class Item implements NonProguard {
        private String desc;
        private String name;

        public Item() {
        }

        public String getDesc() {
            return this.desc;
        }

        public String getName() {
            return this.name;
        }

        public void setDesc(String r100) {
            this.desc = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }
    }

    public FormulaCatalogData() {
    }

    public Catalog getCatalog() {
        return this.catalog;
    }

    public void setCatalog(Catalog r100) {
        this.catalog = r100;
    }
}
