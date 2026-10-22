package com.ss.android.lark.picker.base.view.avataritem.userduty;

import android.view.View;
import b08.b;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.picker.base.view.ShrinkDutyView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w3c.i;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/userduty/UserDutyBinder;", "Lcom/larksuite/component/ui/list/IComponentBinder;", "Lcom/ss/android/lark/picker/base/view/ShrinkDutyView;", "Lcom/ss/android/lark/search/dto/bindermodel/UserDutyModel;", "<init>", "()V", "bind", "", "view", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "unbind", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserDutyBinder implements b<ShrinkDutyView, i> {
    public static final UserDutyBinder INSTANCE = null;

    static {
        INSTANCE = new UserDutyBinder();
    }

    private UserDutyBinder() {
    }

    public void unbind(ShrinkDutyView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setVisibility(8);
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void unbind(View r100) {
        unbind((ShrinkDutyView) r100);
    }

    public void bind(ShrinkDutyView r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r100.setVisibility(8);
        r100.setDividerVisibility(0);
        r101.getClass();
        r100.setSectionVisibility(8);
        r100.setDividerVisibility(8);
        r100.setSection("");
        r100.setDutyVisibility(8);
        r100.setDividerVisibility(8);
        r100.setDuty("");
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void bind(View r100, i r101) {
        bind((ShrinkDutyView) r100, r101);
    }
}
