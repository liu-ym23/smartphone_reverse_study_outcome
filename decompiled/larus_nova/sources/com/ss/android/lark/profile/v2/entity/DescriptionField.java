package com.ss.android.lark.profile.v2.entity;

import com.ss.android.lark.profile.entity.ChatterDescription;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DescriptionField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "<init>", "()V", "description", "Lcom/ss/android/lark/profile/entity/ChatterDescription;", "getDescription", "()Lcom/ss/android/lark/profile/entity/ChatterDescription;", "setDescription", "(Lcom/ss/android/lark/profile/entity/ChatterDescription;)V", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DescriptionField extends BaseField {
    private ChatterDescription description;

    public DescriptionField() {
    }

    public final ChatterDescription getDescription() {
        return this.description;
    }

    public final void setDescription(ChatterDescription r100) {
        this.description = r100;
    }
}
