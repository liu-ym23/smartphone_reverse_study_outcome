package com.bytedance.ee.bear.bitable.sort;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.model.condition.EFilterSortFieldInvalidType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0004'()*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010#\u001a\u00020\rJ\u001a\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0014R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/sort/BitableSortData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "sortInfo", "", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortedField;", "getSortInfo", "()[Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortedField;", "setSortInfo", "([Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortedField;)V", "[Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortedField;", "autoSort", "", "getAutoSort", "()Ljava/lang/Boolean;", "setAutoSort", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "fieldOptions", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortFieldOption;", "getFieldOptions", "()[Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortFieldOption;", "setFieldOptions", "([Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortFieldOption;)V", "[Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortFieldOption;", "notice", "", "getNotice", "()Ljava/lang/String;", "setNotice", "(Ljava/lang/String;)V", "disposableSortEnabled", "getDisposableSortEnabled", "setDisposableSortEnabled", "isOverMaxSize", "findUnSortedFieldOptions", "", "ignoreSortedFieldOption", "Companion", "SortedField", "SortFieldOption", "OrderOption", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSortData implements NonProguard {
    public static final a Companion = null;
    public static final int MAX_SIZE = 20;
    private Boolean autoSort;
    private Boolean disposableSortEnabled;
    private SortFieldOption[] fieldOptions;
    private String notice;
    private SortedField[] sortInfo;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$OrderOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "desc", "", "getDesc", "()Ljava/lang/Boolean;", "setDesc", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OrderOption implements NonProguard {
        private Boolean desc;
        private String text;

        public OrderOption() {
        }

        public final Boolean getDesc() {
            return this.desc;
        }

        public final String getText() {
            return this.text;
        }

        public final void setDesc(Boolean r1) {
            this.desc = r1;
        }

        public final void setText(String r1) {
            this.text = r1;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortFieldOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "type", "", "fieldUIType", "orders", "", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$OrderOption;", "getOrders", "()[Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$OrderOption;", "setOrders", "([Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$OrderOption;)V", "[Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$OrderOption;", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "invalidType", "getInvalidType", "()Ljava/lang/Integer;", "setInvalidType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isSync", "", "()Z", "setSync", "(Z)V", "getFieldCompositeType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SortFieldOption implements NonProguard {
        private FieldCompositeType fieldCompositeType;
        private final String fieldUIType;
        private String id;
        private Integer invalidType;
        private boolean isSync;
        private String name;
        private OrderOption[] orders;
        private final int type;

        public SortFieldOption() {
        }

        public final FieldCompositeType getFieldCompositeType() {
            FieldCompositeType r0 = this.fieldCompositeType;
            if (r0 != null) goto L6;
            FieldCompositeType r1 = new FieldCompositeType(Integer.valueOf(this.type), this.fieldUIType);
            this.fieldCompositeType = r1;
            return r1;
        L6:
            return r0;
        }

        public final String getId() {
            return this.id;
        }

        public final Integer getInvalidType() {
            return this.invalidType;
        }

        public final String getName() {
            return this.name;
        }

        public final OrderOption[] getOrders() {
            return this.orders;
        }

        public final boolean isSync() {
            return this.isSync;
        }

        public final void setId(String r1) {
            this.id = r1;
        }

        public final void setInvalidType(Integer r1) {
            this.invalidType = r1;
        }

        public final void setName(String r1) {
            this.name = r1;
        }

        public final void setOrders(OrderOption[] r1) {
            this.orders = r1;
        }

        public final void setSync(boolean r1) {
            this.isSync = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortedField;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldId", "", "desc", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getFieldId", "()Ljava/lang/String;", "setFieldId", "(Ljava/lang/String;)V", "getDesc", "()Ljava/lang/Boolean;", "setDesc", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SortedField implements NonProguard {
        private Boolean desc;
        private String fieldId;

        public SortedField() {
        }

        public final Boolean getDesc() {
            return this.desc;
        }

        public final String getFieldId() {
            return this.fieldId;
        }

        public final void setDesc(Boolean r1) {
            this.desc = r1;
        }

        public final void setFieldId(String r1) {
            this.fieldId = r1;
        }

        public SortedField(String r1, Boolean r2) {
            this.fieldId = r1;
            this.desc = r2;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BitableSortData() {
    }

    public final boolean isOverMaxSize() {
        SortedField[] r0 = this.sortInfo;
        if (r0 == null) goto L5;
        int r1 = r0.length;
    L7:
        if (r1 < 20) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    public final Boolean getAutoSort() {
        return this.autoSort;
    }

    public final Boolean getDisposableSortEnabled() {
        return this.disposableSortEnabled;
    }

    public final SortFieldOption[] getFieldOptions() {
        return this.fieldOptions;
    }

    public final String getNotice() {
        return this.notice;
    }

    public final SortedField[] getSortInfo() {
        return this.sortInfo;
    }

    public final List<SortFieldOption> findUnSortedFieldOptions(SortFieldOption r14) {
        SortFieldOption[] r0 = this.fieldOptions;
        if (r0 == null) goto L43;
        ArrayList r2 = new ArrayList();
        int r3 = r0.length;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L37;
        SortFieldOption r6 = r0[r5];
        SortedField[] r7 = this.sortInfo;
        if (r7 == null) goto L14;
        int r8 = r7.length;
        int r9 = 0;
    L9:
        if (r9 >= r8) goto L14;
        SortedField r10 = r7[r9];
        if (TextUtils.equals(r10.getFieldId(), r6.getId()) == true) goto L15;
        r9 = r9 + 1;
    L15:
        boolean r11 = true;
        if (r10 == null) goto L18;
        boolean r12 = true;
    L19:
        String r13 = r6.getId();
        if (r14 == null) goto L22;
        String r16 = r14.getId();
    L23:
        boolean r17 = TextUtils.equals(r13, r16);
        Integer r18 = r6.getInvalidType();
        int r19 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
        if (r18 != null) goto L27;
    L29:
        if (r12 == false) goto L32;
        if (r17 == true) goto L32;
    L33:
        if (r11 == true) goto L35;
        r2.add(r6);
    L35:
        r5 = r5 + 1;
    L32:
        r11 = false;
        goto L33
    L27:
        if (r18.intValue() != r19) goto L29;
    L22:
        r16 = null;
        goto L23
    L18:
        r12 = false;
    L14:
        r10 = null;
        goto L15
    L37:
        return r2;
    L43:
        return null;
    }

    public final void setAutoSort(Boolean r1) {
        this.autoSort = r1;
    }

    public final void setDisposableSortEnabled(Boolean r1) {
        this.disposableSortEnabled = r1;
    }

    public final void setFieldOptions(SortFieldOption[] r1) {
        this.fieldOptions = r1;
    }

    public final void setNotice(String r1) {
        this.notice = r1;
    }

    public final void setSortInfo(SortedField[] r1) {
        this.sortInfo = r1;
    }

    public static /* synthetic */ List findUnSortedFieldOptions$default(BitableSortData r0, SortFieldOption r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.findUnSortedFieldOptions(r1);
    }
}
