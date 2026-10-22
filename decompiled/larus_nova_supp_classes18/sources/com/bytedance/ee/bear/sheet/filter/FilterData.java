package com.bytedance.ee.bear.sheet.filter;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterItem;", "getData", "()Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterItem;", "setData", "(Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterItem;)V", "FilterItem", "FilterSheetItem", "ColRange", "FilterOptionItem", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterData implements NonProguard {
    private FilterItem data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterData$ColRange;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "total", "", "getTotal", "()I", "setTotal", "(I)V", "index", "getIndex", "setIndex", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ColRange implements NonProguard {
        private int index;
        private int total;

        public ColRange() {
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getTotal() {
            return this.total;
        }

        public final void setIndex(int r1) {
            this.index = r1;
        }

        public final void setTotal(int r1) {
            this.total = r1;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "items", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "getItems", "()[Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "setItems", "([Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;)V", "[Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "colRange", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$ColRange;", "getColRange", "()Lcom/bytedance/ee/bear/sheet/filter/FilterData$ColRange;", "setColRange", "(Lcom/bytedance/ee/bear/sheet/filter/FilterData$ColRange;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "sheetId", "getSheetId", "setSheetId", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FilterItem implements NonProguard {
        private ColRange colRange;
        private FilterSheetItem[] items;
        private String sheetId;
        private String title;

        public FilterItem() {
        }

        public final ColRange getColRange() {
            return this.colRange;
        }

        public final FilterSheetItem[] getItems() {
            return this.items;
        }

        public final String getSheetId() {
            return this.sheetId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setColRange(ColRange r1) {
            this.colRange = r1;
        }

        public final void setItems(FilterSheetItem[] r1) {
            this.items = r1;
        }

        public final void setSheetId(String r1) {
            this.sheetId = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR$\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR$\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_ID, "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "isSelect", "", "()Z", "setSelect", "(Z)V", "value", "getValue", "setValue", "count", "", "getCount", "()I", "setCount", "(I)V", "isVisible", "setVisible", "colorValue", "getColorValue", "setColorValue", "colors", "", "getColors", "()[Ljava/lang/String;", "setColors", "([Ljava/lang/String;)V", "[Ljava/lang/String;", ResourceData.KEY_TYPE, "getType$annotations", "getType", "setType", "conditionValue", "getConditionValue", "setConditionValue", "Type", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FilterOptionItem implements NonProguard {
        private String colorValue;
        private String[] colors;
        private String[] conditionValue;
        private int count;
        private String id;
        private boolean isSelect;
        private boolean isVisible;
        private String title;
        private String type;
        private String value;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem$Type;", "", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface Type {
            public static final a Companion = null;
            public static final String RANGE = "range";
            public static final String SINGLE = "single";
            public static final String TEXT = "text";

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }

        public static /* synthetic */ void getType$annotations() {
        }

        public FilterOptionItem() {
            this.isVisible = true;
        }

        public final String getColorValue() {
            return this.colorValue;
        }

        public final String[] getColors() {
            return this.colors;
        }

        public final String[] getConditionValue() {
            return this.conditionValue;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean isSelect() {
            return this.isSelect;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public final void setColorValue(String r1) {
            this.colorValue = r1;
        }

        public final void setColors(String[] r1) {
            this.colors = r1;
        }

        public final void setConditionValue(String[] r1) {
            this.conditionValue = r1;
        }

        public final void setCount(int r1) {
            this.count = r1;
        }

        public final void setId(String r1) {
            this.id = r1;
        }

        public final void setSelect(boolean r1) {
            this.isSelect = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }

        public final void setType(String r1) {
            this.type = r1;
        }

        public final void setValue(String r1) {
            this.value = r1;
        }

        public final void setVisible(boolean r1) {
            this.isVisible = r1;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_ID, "", "getId$annotations", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "total", "", "getTotal", "()I", "setTotal", "(I)V", "current", "getCurrent", "setCurrent", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "isSelectAll", "setSelectAll", "list", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "getList", "()[Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "setList", "([Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;)V", "[Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "Id", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FilterSheetItem implements NonProguard {
        private int current;
        private boolean hasNext;
        private String id;
        private boolean isSelectAll;
        private FilterOptionItem[] list;
        private String title;
        private int total;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem$Id;", "", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface Id {
            public static final a Companion = null;
            public static final String FILTER_COLOR = "filterColor";
            public static final String FILTER_CONDITION = "filterCondition";
            public static final String FILTER_VALUE = "filterValue";

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }

        public FilterSheetItem() {
        }

        public static /* synthetic */ void getId$annotations() {
        }

        public final int getCurrent() {
            return this.current;
        }

        public final boolean getHasNext() {
            return this.hasNext;
        }

        public final String getId() {
            return this.id;
        }

        public final FilterOptionItem[] getList() {
            return this.list;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getTotal() {
            return this.total;
        }

        public final boolean isSelectAll() {
            return this.isSelectAll;
        }

        public final void setCurrent(int r1) {
            this.current = r1;
        }

        public final void setHasNext(boolean r1) {
            this.hasNext = r1;
        }

        public final void setId(String r1) {
            this.id = r1;
        }

        public final void setList(FilterOptionItem[] r1) {
            this.list = r1;
        }

        public final void setSelectAll(boolean r1) {
            this.isSelectAll = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }

        public final void setTotal(int r1) {
            this.total = r1;
        }
    }

    public FilterData() {
    }

    public final FilterItem getData() {
        return this.data;
    }

    public final void setData(FilterItem r1) {
        this.data = r1;
    }
}
