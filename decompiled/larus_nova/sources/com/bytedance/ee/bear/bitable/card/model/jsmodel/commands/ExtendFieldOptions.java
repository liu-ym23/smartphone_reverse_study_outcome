package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0005j\b\u0012\u0004\u0012\u00020\r`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "addFieldOptions", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions$AddExtendFieldOption;", "Lkotlin/collections/ArrayList;", "getAddFieldOptions", "()Ljava/util/ArrayList;", "setAddFieldOptions", "(Ljava/util/ArrayList;)V", "deleteFieldOptions", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions$DeleteExtendFieldOption;", "getDeleteFieldOptions", "setDeleteFieldOptions", "AddExtendFieldOption", "DeleteExtendFieldOption", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtendFieldOptions implements NonProguard {
    private ArrayList<AddExtendFieldOption> addFieldOptions;
    private ArrayList<DeleteExtendFieldOption> deleteFieldOptions;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions$AddExtendFieldOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "originFieldReportType", "", "getOriginFieldReportType", "()Ljava/lang/String;", "setOriginFieldReportType", "(Ljava/lang/String;)V", "extendFieldType", "getExtendFieldType", "setExtendFieldType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddExtendFieldOption implements NonProguard {
        private String extendFieldType;
        private String originFieldReportType;

        public AddExtendFieldOption() {
        }

        public final String getExtendFieldType() {
            return this.extendFieldType;
        }

        public final String getOriginFieldReportType() {
            return this.originFieldReportType;
        }

        public final void setExtendFieldType(String r100) {
            this.extendFieldType = r100;
        }

        public final void setOriginFieldReportType(String r100) {
            this.originFieldReportType = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/ExtendFieldOptions$DeleteExtendFieldOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "extendFieldType", "", "getExtendFieldType", "()Ljava/lang/String;", "setExtendFieldType", "(Ljava/lang/String;)V", "extendFieldId", "getExtendFieldId", "setExtendFieldId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeleteExtendFieldOption implements NonProguard {
        private String extendFieldId;
        private String extendFieldType;

        public DeleteExtendFieldOption() {
        }

        public final String getExtendFieldId() {
            return this.extendFieldId;
        }

        public final String getExtendFieldType() {
            return this.extendFieldType;
        }

        public final void setExtendFieldId(String r100) {
            this.extendFieldId = r100;
        }

        public final void setExtendFieldType(String r100) {
            this.extendFieldType = r100;
        }
    }

    public ExtendFieldOptions() {
        this.addFieldOptions = new ArrayList();
        this.deleteFieldOptions = new ArrayList();
    }

    public final ArrayList<AddExtendFieldOption> getAddFieldOptions() {
        return this.addFieldOptions;
    }

    public final ArrayList<DeleteExtendFieldOption> getDeleteFieldOptions() {
        return this.deleteFieldOptions;
    }

    public final void setAddFieldOptions(ArrayList<AddExtendFieldOption> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.addFieldOptions = r100;
    }

    public final void setDeleteFieldOptions(ArrayList<DeleteExtendFieldOption> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deleteFieldOptions = r100;
    }
}
