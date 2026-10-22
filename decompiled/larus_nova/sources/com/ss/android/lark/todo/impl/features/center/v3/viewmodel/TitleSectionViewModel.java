package com.ss.android.lark.todo.impl.features.center.v3.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m7c.n;
import q7c.g;
import t7c.f;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J%\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000eH\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/TitleSectionViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewstate/TitleSectionViewState;", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/TitleSectionViewAction;", "subModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/model/ITitleSectionModel;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/center/v3/model/ITitleSectionModel;)V", "getSubModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/model/ITitleSectionModel;", "defaultState", "initViewModel", "", "handleAction", ExifInterface.GPS_DIRECTION_TRUE, "action", "actionData", "(Lcom/ss/android/lark/todo/impl/features/center/v3/action/TitleSectionViewAction;Ljava/lang/Object;)V", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleSectionViewModel extends SubViewModel<f, n> {
    private final g subModel;

    public <T> void handleAction(n r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public f defaultState() {
        return getSubModel().getTitleSectionViewState();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ com.ss.android.lark.todo.impl.features.center.v3.arch.a getSubModel() {
        return getSubModel();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public void initViewModel() {
        super.initViewModel();
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public /* bridge */ /* synthetic */ j defaultState() {
        return defaultState();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public g getSubModel() {
        return this.subModel;
    }

    public TitleSectionViewModel(g r100) {
        Intrinsics.checkNotNullParameter(r100, "subModel");
        this.subModel = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ void handleAction(com.ss.android.lark.todo.impl.features.center.v3.arch.b r100, Object r101) {
        handleAction((n) r100, r101);
    }
}
