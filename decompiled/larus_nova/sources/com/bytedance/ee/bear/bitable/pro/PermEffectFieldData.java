package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.util.io.NonProguard;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "effectFormulaInfo", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaInfo;", "getEffectFormulaInfo", "()Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaInfo;", "setEffectFormulaInfo", "(Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaInfo;)V", "Companion", "IEffectFormulaInfo", "IEffectFormulaDetailInfo", "IEffectFormulaDetailFieldInfo", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermEffectFieldData implements NonProguard {
    public static final a Companion = null;
    public static final int FIELD_ITEM = 2;
    public static final int TABLE_ITEM = 1;
    private IEffectFormulaInfo effectFormulaInfo;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailFieldInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "name", "getName", "setName", "getItemType", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IEffectFormulaDetailFieldInfo implements NonProguard, MultiItemEntity {
        private String name;
        private String type;

        public IEffectFormulaDetailFieldInfo() {
        }

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return 2;
        }

        public final String getName() {
            return this.name;
        }

        public final String getType() {
            return this.type;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setType(String r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "formulaFieldInfo", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailFieldInfo;", "Lkotlin/collections/ArrayList;", "getFormulaFieldInfo", "()Ljava/util/ArrayList;", "setFormulaFieldInfo", "(Ljava/util/ArrayList;)V", "getItemType", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IEffectFormulaDetailInfo implements NonProguard, MultiItemEntity {
        private ArrayList<IEffectFormulaDetailFieldInfo> formulaFieldInfo;
        private String name;

        public IEffectFormulaDetailInfo() {
        }

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return 1;
        }

        public final ArrayList<IEffectFormulaDetailFieldInfo> getFormulaFieldInfo() {
            return this.formulaFieldInfo;
        }

        public final String getName() {
            return this.name;
        }

        public final void setFormulaFieldInfo(ArrayList<IEffectFormulaDetailFieldInfo> r100) {
            this.formulaFieldInfo = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "formulaCount", "", "getFormulaCount", "()Ljava/lang/Integer;", "setFormulaCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "formulaInfo", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailInfo;", "Lkotlin/collections/ArrayList;", "getFormulaInfo", "()Ljava/util/ArrayList;", "setFormulaInfo", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IEffectFormulaInfo implements NonProguard {
        private Integer formulaCount;
        private ArrayList<IEffectFormulaDetailInfo> formulaInfo;

        public IEffectFormulaInfo() {
        }

        public final Integer getFormulaCount() {
            return this.formulaCount;
        }

        public final ArrayList<IEffectFormulaDetailInfo> getFormulaInfo() {
            return this.formulaInfo;
        }

        public final void setFormulaCount(Integer r100) {
            this.formulaCount = r100;
        }

        public final void setFormulaInfo(ArrayList<IEffectFormulaDetailInfo> r100) {
            this.formulaInfo = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PermEffectFieldData() {
    }

    public final IEffectFormulaInfo getEffectFormulaInfo() {
        return this.effectFormulaInfo;
    }

    public final void setEffectFormulaInfo(IEffectFormulaInfo r100) {
        this.effectFormulaInfo = r100;
    }
}
