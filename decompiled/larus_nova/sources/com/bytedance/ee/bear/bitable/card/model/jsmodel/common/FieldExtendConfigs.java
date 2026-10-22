package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.util.io.NonProguard;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendConfigs;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isOwner", "", "()Ljava/lang/Boolean;", "setOwner", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendConfig;", "Lkotlin/collections/ArrayList;", "getConfigs", "()Ljava/util/ArrayList;", "setConfigs", "(Ljava/util/ArrayList;)V", "hasExtendFields", "getHasExtendFields", "()Z", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldExtendConfigs implements NonProguard {
    private ArrayList<FieldExtendConfig> configs;
    private Boolean isOwner;

    public FieldExtendConfigs() {
    }

    public final boolean getHasExtendFields() {
        ArrayList<FieldExtendConfig> r100 = this.configs;
        Object r101 = null;
        if (r100 == null) goto L24;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L23;
        Object r103 = r102.next();
        ArrayList<FieldExtendConfigItem> r104 = ((FieldExtendConfig) r103).getExtendItems();
        if (r104 == null) goto L17;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L15;
        Object r106 = r105.next();
        if (((FieldExtendConfigItem) r106).isChecked() == false) goto L11;
    L16:
        FieldExtendConfigItem r107 = (FieldExtendConfigItem) r106;
    L18:
        if (r107 == null) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L6;
        r101 = r103;
        goto L23
    L20:
        r108 = false;
        goto L21
    L15:
        r106 = null;
        goto L16
    L17:
        r107 = null;
    L23:
        r101 = (FieldExtendConfig) r101;
    L24:
        if (r101 != null) goto L36;
        return false;
    L36:
        return true;
    }

    public final ArrayList<FieldExtendConfig> getConfigs() {
        return this.configs;
    }

    public final Boolean isOwner() {
        return this.isOwner;
    }

    public final void setConfigs(ArrayList<FieldExtendConfig> r100) {
        this.configs = r100;
    }

    public final void setOwner(Boolean r100) {
        this.isOwner = r100;
    }
}
