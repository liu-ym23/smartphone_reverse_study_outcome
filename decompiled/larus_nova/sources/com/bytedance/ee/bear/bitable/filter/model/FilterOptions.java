package com.bytedance.ee.bear.bitable.filter.model;

import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "conjunctionOptions", "", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$ConjunctionOption;", "getConjunctionOptions", "()[Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$ConjunctionOption;", "setConjunctionOptions", "([Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$ConjunctionOption;)V", "[Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$ConjunctionOption;", "durationOptions", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;", "getDurationOptions", "()[Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;", "setDurationOptions", "([Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;)V", "[Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;", "fieldOptions", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "getFieldOptions", "()[Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", "setFieldOptions", "([Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;)V", "[Lcom/bytedance/ee/bear/bitable/filter/model/FilterFieldOption;", TimeZoneItemV2.TIME_ZONE, "", "getTimeZone", "()Ljava/lang/String;", "setTimeZone", "(Ljava/lang/String;)V", "loading", "", "getLoading", "()Ljava/lang/Boolean;", "setLoading", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "ConjunctionOption", "DurationOption", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterOptions implements NonProguard {
    private ConjunctionOption[] conjunctionOptions;
    private DurationOption[] durationOptions;
    private FilterFieldOption[] fieldOptions;
    private Boolean loading;
    private String timeZone;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$ConjunctionOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "text", "getText", "setText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConjunctionOption implements NonProguard {
        private String text;
        private String value;

        public ConjunctionOption() {
        }

        public final String getText() {
            return this.text;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setValue(String r100) {
            this.value = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions$DurationOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "text", "getText", "setText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DurationOption implements NonProguard {
        private String text;
        private String value;

        public DurationOption() {
        }

        public final String getText() {
            return this.text;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setValue(String r100) {
            this.value = r100;
        }
    }

    public FilterOptions() {
    }

    public final ConjunctionOption[] getConjunctionOptions() {
        return this.conjunctionOptions;
    }

    public final DurationOption[] getDurationOptions() {
        return this.durationOptions;
    }

    public final FilterFieldOption[] getFieldOptions() {
        return this.fieldOptions;
    }

    public final Boolean getLoading() {
        return this.loading;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final void setConjunctionOptions(ConjunctionOption[] r100) {
        this.conjunctionOptions = r100;
    }

    public final void setDurationOptions(DurationOption[] r100) {
        this.durationOptions = r100;
    }

    public final void setFieldOptions(FilterFieldOption[] r100) {
        this.fieldOptions = r100;
    }

    public final void setLoading(Boolean r100) {
        this.loading = r100;
    }

    public final void setTimeZone(String r100) {
        this.timeZone = r100;
    }
}
