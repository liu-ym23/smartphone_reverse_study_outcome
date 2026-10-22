package com.larus.bmhome.floatchat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.setting.FragmentProvider;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mp8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012H\u0016¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/floatchat/FloatChatServiceImpl;", "Lcom/larus/bmhome/floatchat/IFloatChatService;", "<init>", "()V", "createFloatChatFragment", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "hasBottomTab", "", "overrideContainer", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "overrideLayout", "", "initContainerData", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Bundle;ZLcom/larus/ui/arch/modulizer/di/ContainerFilter;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatChatServiceImpl implements IFloatChatService {
    public FloatChatServiceImpl() {
    }

    @Override // com.larus.bmhome.floatchat.IFloatChatService
    public final Fragment a(Bundle r110, boolean r111, ContainerFilter r112, Integer r113, final Function1<? super Container, Unit> r114) {
        Intrinsics.checkNotNullParameter(r110, "bundle");
        Intrinsics.checkNotNullParameter(r114, "initContainerData");
        FLogger.f375446a.i("FloatChatServiceImpl", "createFloatChatFragment");
        FragmentProvider r100 = FragmentProvider.f313806b;
        int r101 = r110.getInt("bottom_tab_height", 0);
        if (r113 == null) goto L5;
        int r115 = r113.intValue();
    L6:
        Integer r102 = Integer.valueOf(r115);
        if (r112 != null) goto L10;
        r112 = ContainerFilter.FLOAT_CHAT;
    L10:
        return r100.d(r110, r111, r101, r102, r112, new a(r114));
    L5:
        r115 = R.layout.larus_layout_float_chat;
        goto L6
    }
}
