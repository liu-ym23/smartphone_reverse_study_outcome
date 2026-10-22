package com.obric.assistant.common.spi.interaction;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0096\u0001J\u001d\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0001J\u001d\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/common/spi/interaction/ObricMessagePopupServiceDelegate;", "Lcom/obric/assistant/common/spi/interaction/IObricMessagePopupService;", "<init>", "()V", "filterMessageMenuItemsIfNeeded", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "menuItems", "", "markNextDropdownRewriteIfNeeded", "anchor", "Landroid/view/View;", "popupWindow", "Landroid/widget/PopupWindow;", "prepareFollowClickMenuBeforeShow", "", "menuView", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMessagePopupServiceDelegate implements IObricMessagePopupService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricMessagePopupServiceDelegate f387845b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricMessagePopupService f387846a;

    static {
        f387845b = new ObricMessagePopupServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final void filterMessageMenuItemsIfNeeded(Context r100, List<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "menuItems");
        this.f387846a.filterMessageMenuItemsIfNeeded(r100, r101);
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final void markNextDropdownRewriteIfNeeded(View r100, PopupWindow r101) {
        this.f387846a.markNextDropdownRewriteIfNeeded(r100, r101);
    }

    @Override // com.obric.assistant.common.spi.interaction.IObricMessagePopupService
    public final boolean prepareFollowClickMenuBeforeShow(View r100, View r101) {
        return this.f387846a.prepareFollowClickMenuBeforeShow(r100, r101);
    }

    private ObricMessagePopupServiceDelegate() {
        IObricMessagePopupService r100 = (IObricMessagePopupService) ServiceManager.get().getService(IObricMessagePopupService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricMessagePopupServiceImpl();
    L5:
        this.f387846a = r100;
    }
}
