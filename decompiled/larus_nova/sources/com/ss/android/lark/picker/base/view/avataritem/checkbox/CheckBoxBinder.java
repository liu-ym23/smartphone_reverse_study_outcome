package com.ss.android.lark.picker.base.view.avataritem.checkbox;

import android.view.View;
import b08.b;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/checkbox/CheckBoxBinder;", "Lcom/larksuite/component/ui/list/IComponentBinder;", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "<init>", "()V", "bind", "", "view", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "unbind", "Companion", "CheckBoxBinderHolder", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckBoxBinder implements b<UDCheckBox, w3c.b> {
    public static final Companion Companion = null;
    private static final CheckBoxBinder instance = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/checkbox/CheckBoxBinder$CheckBoxBinderHolder;", "", "<init>", "()V", "instance", "Lcom/ss/android/lark/picker/base/view/avataritem/checkbox/CheckBoxBinder;", "getInstance", "()Lcom/ss/android/lark/picker/base/view/avataritem/checkbox/CheckBoxBinder;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CheckBoxBinderHolder {
        public static final CheckBoxBinderHolder INSTANCE = null;
        private static final CheckBoxBinder instance = null;

        private CheckBoxBinderHolder() {
        }

        static {
            INSTANCE = new CheckBoxBinderHolder();
            instance = new CheckBoxBinder(null);
        }

        public final CheckBoxBinder getInstance() {
            return instance;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/checkbox/CheckBoxBinder$Companion;", "", "<init>", "()V", "instance", "Lcom/ss/android/lark/picker/base/view/avataritem/checkbox/CheckBoxBinder;", "getInstance", "()Lcom/ss/android/lark/picker/base/view/avataritem/checkbox/CheckBoxBinder;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CheckBoxBinder getInstance() {
            return CheckBoxBinder.access$getInstance$cp();
        }
    }

    private CheckBoxBinder() {
    }

    public /* synthetic */ CheckBoxBinder(DefaultConstructorMarker r100) {
        this();
    }

    static {
        Companion = new Companion(null);
        instance = CheckBoxBinderHolder.INSTANCE.getInstance();
    }

    public static final /* synthetic */ CheckBoxBinder access$getInstance$cp() {
        return instance;
    }

    public void unbind(UDCheckBox r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setVisibility(8);
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void unbind(View r100) {
        unbind((UDCheckBox) r100);
    }

    public void bind(UDCheckBox r100, w3c.b r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r101.f558225c == false) goto L5;
        r100.setVisibility(0);
        r100.setEnabled(r101.f558224b);
        r100.setChecked(r101.f558223a);
        r100.setType(UDCheckBox.CheckBoxType.CHECK_BOX);
        return;
    L5:
        r100.setVisibility(8);
    }

    @Override // b08.b
    public /* bridge */ /* synthetic */ void bind(View r100, w3c.b r101) {
        bind((UDCheckBox) r100, r101);
    }
}
