package com.obric.assistant.spi.training;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.setting.impl.modeltraining.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016JD\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0016J\u001e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"Lcom/obric/assistant/spi/training/DefaultObricPrivacyModelTrainingService;", "Lcom/obric/assistant/spi/training/IObricPrivacyModelTrainingService;", "<init>", "()V", "updateUserConfigs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getModelTrainOverallDescString", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getModelTrainingList", "", "Lcom/obric/assistant/spi/training/bean/ObricModelTrainingUIModel;", "isModelTrainingPermissionType", "permissionType", "setupModelTrainingGroup", "", "host", "Landroidx/fragment/app/Fragment;", "group", "Landroid/view/ViewGroup;", "onRequestPermissionSetting", "Lkotlin/Function1;", "releaseModelTrainingGroup", "setupModelTrainingPermissionSwitch", "learnMorePostFix", "descriptionView", "Lcom/larus/common_ui/widget/UrlSpanTextView;", "itemSwitch", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "onOpenPrivacyUrl", "isModelTrainingEnable", "id", "setModelTrainingEnable", "enable", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricPrivacyModelTrainingService implements IObricPrivacyModelTrainingService {
    public DefaultObricPrivacyModelTrainingService() {
    }

    @Override // com.obric.assistant.spi.training.IObricPrivacyModelTrainingService
    public final void a() {
    }

    @Override // com.obric.assistant.spi.training.IObricPrivacyModelTrainingService
    public final void b() {
    }

    @Override // com.obric.assistant.spi.training.IObricPrivacyModelTrainingService
    public final void c() {
    }

    @Override // com.obric.assistant.spi.training.IObricPrivacyModelTrainingService
    public final void d(Fragment r100, ItemGroup r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "group");
        Intrinsics.checkNotNullParameter(r102, "onRequestPermissionSetting");
    }
}
