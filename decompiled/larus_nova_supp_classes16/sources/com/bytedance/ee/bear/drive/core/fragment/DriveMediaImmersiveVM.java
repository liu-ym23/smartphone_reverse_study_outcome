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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/fragment/DriveMediaImmersiveVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveMimeTypeCategory", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeCategory;", "getLiveMimeTypeCategory", "()Landroidx/lifecycle/MutableLiveData;", "resolveFromEntry", "", "openEntities", "", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/BaseOpenEntity;", "resolveFromFileModel", "fileModel", "Lcom/bytedance/ee/bear/drive/core/model/AbsFileModel;", "isMediaImmersiveActive", "", "mediaImmersiveEnable", "isVc", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMediaImmersiveVM extends ViewModel {
    private final MutableLiveData<MimeTypeCategory> liveMimeTypeCategory;

    public DriveMediaImmersiveVM() {
        this.liveMimeTypeCategory = new MutableLiveData();
    }

    public final MutableLiveData<MimeTypeCategory> getLiveMimeTypeCategory() {
        return this.liveMimeTypeCategory;
    }

    public final void resolveFromEntry(List<? extends BaseOpenEntity> r7) {
        Intrinsics.checkNotNullParameter(r7, "openEntities");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "openEntities");
        List<? extends BaseOpenEntity> r0 = r7;
        Iterator r1 = SequencesKt.mapNotNull(CollectionsKt.asSequence(r0), DrivePreviewMediaTypeResolver$firstMediaCategory$1.INSTANCE).iterator();
    L3:
        String r3 = null;
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        j.a.getClass();
        if (j.b((MimeTypeCategory) r2) == false) goto L3;
    L9:
        MimeTypeCategory r4 = (MimeTypeCategory) r2;
        if (r4 != null) goto L12;
        r4 = (MimeTypeCategory) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r0), DrivePreviewMediaTypeResolver$firstKnownCategory$1.INSTANCE));
    L12:
        StringBuilder r5 = new StringBuilder("DriveMediaImmersiveVM resolveFromEntry category=");
        if (r4 == null) goto L15;
        r3 = r4.name();
    L15:
        r5.append(r3);
        r5.append(" count=");
        r5.append(r7.size());
        tt5.a.h("DRIVE_CACHE_FLOW", r5.toString());
        this.liveMimeTypeCategory.setValue(r4);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void resolveFromFileModel(w75.a r8) {
        Intrinsics.checkNotNullParameter(r8, "fileModel");
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "fileModel");
        String[] r1 = new String[2];
        w75.b r2 = r8.c();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.k;
    L6:
        r1[0] = r4;
        r1[1] = r8.f;
        String r5 = j.c(j.a(r1));
        w75.b r9 = r8.a;
        String r10 = j.a(new String[]{r8.r, r9.f, r9.j});
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        MimeTypeCategory r11 = j.e(r5, StringsKt.trim(r10).toString().toLowerCase(Locale.ROOT));
        MimeTypeCategory r0 = (MimeTypeCategory) this.liveMimeTypeCategory.getValue();
        if (j.b(r0) == true) goto L12;
    L22:
        StringBuilder r6 = new StringBuilder("DriveMediaImmersiveVM resolveFromFileModel category=");
        if (r11 == null) goto L25;
        r3 = r11.name();
    L25:
        r6.append(r3);
        tt5.a.h("DRIVE_CACHE_FLOW", r6.toString());
        this.liveMimeTypeCategory.setValue(r11);
        return;
    L12:
        if (j.b(r11) == true) goto L22;
        StringBuilder r7 = new StringBuilder("DriveMediaImmersiveVM ignoreFileModelCategory current=");
        if (r0 == null) goto L16;
        String r12 = r0.name();
    L17:
        r7.append(r12);
        r7.append(" category=");
        if (r11 == null) goto L20;
        r3 = r11.name();
    L20:
        r7.append(r3);
        tt5.a.k("DRIVE_CACHE_FLOW", r7.toString());
        return;
    L16:
        r12 = null;
        goto L17
    L5:
        r4 = null;
        goto L6
    }

    public final boolean isMediaImmersiveActive(boolean r1, boolean r2) {
        if (r1 == false) goto L7;
        if (r2 == true) goto L9;
        j r3 = j.a;
        MimeTypeCategory r4 = (MimeTypeCategory) this.liveMimeTypeCategory.getValue();
        r3.getClass();
        return j.b(r4);
    L9:
        return false;
    L7:
        return false;
    }
}
