package com.larus.bmhome.floatchat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mp8.f;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H&¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/floatchat/IFloatChatService;", "", "createFloatChatFragment", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "hasBottomTab", "", "overrideContainer", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "overrideLayout", "", "initContainerData", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Bundle;ZLcom/larus/ui/arch/modulizer/di/ContainerFilter;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroidx/fragment/app/Fragment;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFloatChatService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Fragment a(IFloatChatService r100, Bundle r101, boolean r110, ContainerFilter r111, Integer r112, Function1 r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            ContainerFilter r102 = null;
        L7:
            if ((r114 & 8) == 0) goto L9;
            Integer r103 = null;
        L11:
            if ((r114 & 16) == 0) goto L14;
            r113 = new f();
        L14:
            return r100.a(r101, r110, r102, r103, r113);
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }
    }

    Fragment a(Bundle r100, boolean r101, ContainerFilter r102, Integer r103, Function1<? super Container, Unit> r104);
}
