package com.bytedance.ee.bear.bitable.card.model.jsmodel.permission;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/FieldPermission;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "stageConvert", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getStageConvert", "()Ljava/util/HashMap;", "setStageConvert", "(Ljava/util/HashMap;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldPermission implements NonProguard {
    private HashMap<String, Boolean> stageConvert;

    public FieldPermission() {
    }

    public final HashMap<String, Boolean> getStageConvert() {
        return this.stageConvert;
    }

    public final void setStageConvert(HashMap<String, Boolean> r100) {
        this.stageConvert = r100;
    }
}
