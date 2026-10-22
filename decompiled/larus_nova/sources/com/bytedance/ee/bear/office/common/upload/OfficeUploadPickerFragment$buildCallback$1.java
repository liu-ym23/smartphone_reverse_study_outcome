package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeUploadPickerFragment$buildCallback$1 implements com.bytedance.ee.bear.office.export.space.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeUploadPickerFragment f235290a;

    public OfficeUploadPickerFragment$buildCallback$1(OfficeUploadPickerFragment r100) {
        this.f235290a = r100;
    }

    @Override // com.bytedance.ee.bear.office.export.space.n
    public final void onCancel(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        final OfficeUploadPickerFragment r101 = this.f235290a;
        Function0<Unit> r102 = new OfficeUploadPickerFragment$buildCallback$1$onCancel$1(r100, r101);
        int r103 = OfficeUploadPickerFragment.f235282j;
        r101.T90(r100, r102);
    }

    @Override // com.bytedance.ee.bear.office.export.space.n
    public final void a(String r100, List<OfficeSpaceUploadSelection> r101) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, "selections");
        OfficeUploadPickerFragment r102 = this.f235290a;
        int r103 = OfficeUploadPickerFragment.f235282j;
        r102.getClass();
        r102.T90(r100, new OfficeUploadPickerFragment$consumeSelected$1(r102, r101));
    }

    @Override // com.bytedance.ee.bear.office.export.space.n
    public final void onError(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        final OfficeUploadPickerFragment r102 = this.f235290a;
        Function0<Unit> r103 = new OfficeUploadPickerFragment$buildCallback$1$onError$1(r100, r101, r102);
        int r104 = OfficeUploadPickerFragment.f235282j;
        r102.T90(r100, r103);
    }
}
