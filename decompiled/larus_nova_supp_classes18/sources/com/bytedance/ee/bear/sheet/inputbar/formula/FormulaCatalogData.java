package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public void setCategories(List<Category> r1) {
            this.categories = r1;
        }

        public void setPopular(List<Item> r1) {
            this.popular = r1;
        }

        public void setSearchPlaceholder(String r1) {
            this.searchPlaceholder = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }
    }

    public static class Category implements NonProguard {
        private List<Item> functions;
        private String id;
        private String label;

        public Category() {
        }

        public List<Item> getFunctions() {
            return this.functions;
        }

        public String getId() {
            return this.id;
        }

        public String getLabel() {
            return this.label;
        }

        public void setFunctions(List<Item> r1) {
            this.functions = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setLabel(String r1) {
            this.label = r1;
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

        public void setDesc(String r1) {
            this.desc = r1;
        }

        public void setName(String r1) {
            this.name = r1;
        }
    }

    public FormulaCatalogData() {
    }

    public Catalog getCatalog() {
        return this.catalog;
    }

    public void setCatalog(Catalog r1) {
        this.catalog = r1;
    }
}
