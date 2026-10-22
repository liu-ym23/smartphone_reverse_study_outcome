package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.effect.model.template.CheckUpdateVersionModelTemplate;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR(\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/CheckUpdateVersionModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/CheckUpdateVersionModelTemplate;", "Ljava/io/Serializable;", "kUpdateModel", "Lcom/ss/ugc/effectplatform/model/CheckUpdateVersionModel;", "(Lcom/ss/ugc/effectplatform/model/CheckUpdateVersionModel;)V", "value", "", EffectConfiguration.KEY_CURSOR, "getCursor", "()Ljava/lang/String;", "setCursor", "(Ljava/lang/String;)V", "getKUpdateModel", "()Lcom/ss/ugc/effectplatform/model/CheckUpdateVersionModel;", EffectConfiguration.KEY_SORTING_POSITION, "getSorting_position", "setSorting_position", "version", "getVersion", "setVersion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class CheckUpdateVersionModel extends CheckUpdateVersionModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.CheckUpdateVersionModel kUpdateModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckUpdateVersionModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.CheckUpdateVersionModel
    public String getCursor() {
        com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r100 = getKUpdateModel();
        if (r100 == null) goto L8;
        String r101 = r100.getCursor();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCursor();
    }

    @Override // com.ss.ugc.effectplatform.model.CheckUpdateVersionModel
    public String getSorting_position() {
        com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r100 = getKUpdateModel();
        if (r100 == null) goto L8;
        String r101 = r100.getSorting_position();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSorting_position();
    }

    @Override // com.ss.ugc.effectplatform.model.CheckUpdateVersionModel
    public String getVersion() {
        com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r100 = getKUpdateModel();
        if (r100 == null) goto L8;
        String r101 = r100.getVersion();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getVersion();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CheckUpdateVersionModelTemplate
    public com.ss.ugc.effectplatform.model.CheckUpdateVersionModel getKUpdateModel() {
        return this.kUpdateModel;
    }

    public CheckUpdateVersionModel(com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r100) {
        super(r100);
        this.kUpdateModel = r100;
        com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r101 = getKUpdateModel();
        if (r101 == null) goto L14;
        String r102 = r101.getCursor();
        if (r102 == null) goto L7;
        super.setCursor(r102);
    L7:
        String r103 = r101.getSorting_position();
        if (r103 == null) goto L10;
        super.setSorting_position(r103);
    L10:
        String r104 = r101.getVersion();
        if (r104 == null) goto L15;
        super.setVersion(r104);
        return;
    L15:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.CheckUpdateVersionModel
    public void setCursor(String r100) {
        com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r101 = getKUpdateModel();
        if (r101 == null) goto L5;
        r101.setCursor(r100);
    L5:
        super.setCursor(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CheckUpdateVersionModel
    public void setSorting_position(String r100) {
        com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r101 = getKUpdateModel();
        if (r101 == null) goto L5;
        r101.setSorting_position(r100);
    L5:
        super.setSorting_position(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CheckUpdateVersionModel
    public void setVersion(String r100) {
        com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r101 = getKUpdateModel();
        if (r101 == null) goto L5;
        r101.setVersion(r100);
    L5:
        super.setVersion(r100);
    }

    public /* synthetic */ CheckUpdateVersionModel(com.ss.ugc.effectplatform.model.CheckUpdateVersionModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
