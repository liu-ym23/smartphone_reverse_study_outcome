package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/fragment/DriveMediaImmersiveVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveMimeTypeCategory", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeCategory;", "getLiveMimeTypeCategory", "()Landroidx/lifecycle/MutableLiveData;", "resolveFromEntry", "", "openEntities", "", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/BaseOpenEntity;", "resolveFromFileModel", "fileModel", "Lcom/bytedance/ee/bear/drive/core/model/AbsFileModel;", "isMediaImmersiveActive", "", "mediaImmersiveEnable", "isVc", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMediaImmersiveVM extends ViewModel {
    private final MutableLiveData<MimeTypeCategory> liveMimeTypeCategory;

    public DriveMediaImmersiveVM() {
        this.liveMimeTypeCategory = new MutableLiveData();
    }

    public final MutableLiveData<MimeTypeCategory> getLiveMimeTypeCategory() {
        return this.liveMimeTypeCategory;
    }

    public final void resolveFromEntry(List<? extends BaseOpenEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "openEntities");
        j.f224217a.getClass();
        Intrinsics.checkNotNullParameter(r100, "openEntities");
        List<? extends BaseOpenEntity> r101 = r100;
        Iterator r102 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r101), DrivePreviewMediaTypeResolver$firstMediaCategory$1.INSTANCE).iterator();
    L3:
        String r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        j.f224217a.getClass();
        if (j.b((MimeTypeCategory) r104) == false) goto L3;
    L9:
        MimeTypeCategory r105 = (MimeTypeCategory) r104;
        if (r105 != null) goto L12;
        r105 = (MimeTypeCategory) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r101), DrivePreviewMediaTypeResolver$firstKnownCategory$1.INSTANCE));
    L12:
        StringBuilder r106 = new StringBuilder("DriveMediaImmersiveVM resolveFromEntry category=");
        if (r105 == null) goto L15;
        r103 = r105.name();
    L15:
        r106.append(r103);
        r106.append(" count=");
        r106.append(r100.size());
        tt5.a.h("DRIVE_CACHE_FLOW", r106.toString());
        this.liveMimeTypeCategory.setValue(r105);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public final void resolveFromFileModel(w75.a r100) {
        Intrinsics.checkNotNullParameter(r100, "fileModel");
        j.f224217a.getClass();
        Intrinsics.checkNotNullParameter(r100, "fileModel");
        String[] r101 = new String[2];
        w75.b r102 = r100.c();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f558567k;
    L6:
        r101[0] = r104;
        r101[1] = r100.f558537f;
        String r105 = j.c(j.a(r101));
        w75.b r106 = r100.f558532a;
        String r107 = j.a(new String[]{r100.f558549r, r106.f558562f, r106.f558566j});
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        MimeTypeCategory r108 = j.e(r105, StringsKt.trim(r107).toString().toLowerCase(Locale.ROOT));
        MimeTypeCategory r109 = this.liveMimeTypeCategory.getValue();
        if (j.b(r109) == true) goto L12;
    L22:
        StringBuilder r110 = new StringBuilder("DriveMediaImmersiveVM resolveFromFileModel category=");
        if (r108 == null) goto L25;
        r103 = r108.name();
    L25:
        r110.append(r103);
        tt5.a.h("DRIVE_CACHE_FLOW", r110.toString());
        this.liveMimeTypeCategory.setValue(r108);
        return;
    L12:
        if (j.b(r108) == true) goto L22;
        StringBuilder r111 = new StringBuilder("DriveMediaImmersiveVM ignoreFileModelCategory current=");
        if (r109 == null) goto L16;
        String r112 = r109.name();
    L17:
        r111.append(r112);
        r111.append(" category=");
        if (r108 == null) goto L20;
        r103 = r108.name();
    L20:
        r111.append(r103);
        tt5.a.k("DRIVE_CACHE_FLOW", r111.toString());
        return;
    L16:
        r112 = null;
        goto L17
    L5:
        r104 = null;
        goto L6
    }

    public final boolean isMediaImmersiveActive(boolean r100, boolean r101) {
        if (r100 == false) goto L7;
        if (r101 == true) goto L9;
        j r102 = j.f224217a;
        MimeTypeCategory r103 = this.liveMimeTypeCategory.getValue();
        r102.getClass();
        return j.b(r103);
    L9:
        return false;
    L7:
        return false;
    }
}
