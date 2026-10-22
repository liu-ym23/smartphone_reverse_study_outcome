package com.obric.assistant.spi.training;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.setting.impl.modeltraining.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 #2\u00020\u0001:\u0001#J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0006H&J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0015H&J\b\u0010\u0016\u001a\u00020\u000fH&JD\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0015H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H&J\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\"¨\u0006$"}, d2 = {"Lcom/obric/assistant/spi/training/IObricPrivacyModelTrainingService;", "", "updateUserConfigs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getModelTrainOverallDescString", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getModelTrainingList", "", "Lcom/obric/assistant/spi/training/bean/ObricModelTrainingUIModel;", "isModelTrainingPermissionType", "permissionType", "setupModelTrainingGroup", "", "host", "Landroidx/fragment/app/Fragment;", "group", "Landroid/view/ViewGroup;", "onRequestPermissionSetting", "Lkotlin/Function1;", "releaseModelTrainingGroup", "setupModelTrainingPermissionSwitch", "learnMorePostFix", "descriptionView", "Lcom/larus/common_ui/widget/UrlSpanTextView;", "itemSwitch", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "onOpenPrivacyUrl", "isModelTrainingEnable", "id", "setModelTrainingEnable", "enable", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricPrivacyModelTrainingService {
    void a();

    void b();

    void c();

    void d(Fragment r100, ItemGroup r101, b r102);
}
