package com.obric.assistant.spi.task;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0001J/\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\nH\u0096\u0001J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0096\u0001J\u0013\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\"\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0017\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0096\u0001J\u001d\u0010'\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J\u001d\u0010*\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J\u001b\u0010+\u001a\u0004\u0018\u00010\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020!H\u0096\u0001J\u0018\u0010.\u001a\u0004\u0018\u00010!2\u0006\u0010/\u001a\u00020!H\u0096\u0001¢\u0006\u0002\u00100J\u0015\u00101\u001a\u0004\u0018\u00010\u00152\b\u00102\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0018\u00103\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!H\u0096\u0001¢\u0006\u0002\u00104J\u0018\u00103\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0002\u00105J\u0019\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0096\u0001¨\u00069"}, d2 = {"Lcom/obric/assistant/spi/task/ObricTaskSkillDelegate;", "Lcom/obric/assistant/spi/task/IObricTaskSkillService;", "<init>", "()V", "extendObricActionBarWhiteItems", "", "itemsConfig", "", "", "selectedDeepThinkStatus", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getBlueTagTextByOption", "modeKey", "modelKey", "menuSection", "isFromSettingPage", "", "getCurrentDisplayModel", "getDefaultModelItemJson", "getModelItemsJson", "getObricDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getPhoneOperationModeIdIfSupportModel", "replyOption", "modelIdentity", "getPhoneOperationModeSupportModel", "selectedMode", "Lcom/larus/bmhome/actionbar/model/ActiveSwitchMenuMode;", "injectObricDefaultReplyModeMenuInfo", "", "menuInfo", "isObricDefaultReplyModeAvailable", "itemId", "", "isPhoneOperationMode", "modeId", "markQuickModeModelsSize", "modeList", "", "onActionBarModelChanged", "activity", "Landroid/app/Activity;", "onSettingModelChanged", "resolveDefaultModelItemKey", "defaultModelItemKey", "defaultReplyMode", "resolveDefaultReplyMode", "serverDefaultReplyMode", "(I)Ljava/lang/Integer;", "resolveDefaultReplyOption", "defaultReplyOption", "saveObricDefaultReplyModeIfNeeded", "(I)Ljava/lang/Boolean;", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Boolean;", "storeIsUsingMenuConfV2", "isUsingMenuConfV2", "useModeModelList", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskSkillDelegate implements IObricTaskSkillService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricTaskSkillDelegate f392916b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricTaskSkillService f392917a;

    static {
        f392916b = new ObricTaskSkillDelegate();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String a(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "menuSection");
        return this.f392917a.a(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Object b(Object r100) {
        return this.f392917a.b(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean c(ReplyOption r100) {
        return this.f392917a.c(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean d(String r100) {
        return this.f392917a.d(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String e(ReplyOption r100, ModelItemIdentity r101) {
        Intrinsics.checkNotNullParameter(r101, "modelIdentity");
        return this.f392917a.e(r100, r101);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String f() {
        return this.f392917a.f();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ModelItemIdentity g(ModelItemIdentity r100, t0 r101) {
        Intrinsics.checkNotNullParameter(r101, "selectedMode");
        return this.f392917a.g(r100, r101);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String getCurrentDisplayModel() {
        return this.f392917a.getCurrentDisplayModel();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void h(List<t0> r100) {
        Intrinsics.checkNotNullParameter(r100, "modeList");
        this.f392917a.h(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String i() {
        return this.f392917a.i();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final String j(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultModelItemKey");
        return this.f392917a.j(r100, r101);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void k(Set<String> r100, ModelItemIdentity r101) {
        Intrinsics.checkNotNullParameter(r100, "itemsConfig");
        this.f392917a.k(r100, r101);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void l(ReplyOption r100, FragmentActivity r101) {
        this.f392917a.l(r100, r101);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption m() {
        return this.f392917a.m();
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Integer n(int r100) {
        return this.f392917a.n(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean o(int r100) {
        return this.f392917a.o(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final Boolean p(ReplyOption r100) {
        Intrinsics.checkNotNullParameter(r100, "replyOption");
        return this.f392917a.p(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final boolean q(int r100) {
        return this.f392917a.q(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void r(boolean r100, boolean r101) {
        this.f392917a.r(r100, r101);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final ReplyOption s(ReplyOption r100) {
        return this.f392917a.s(r100);
    }

    @Override // com.obric.assistant.spi.task.IObricTaskSkillService
    public final void t(ReplyOption r100, Activity r101) {
        this.f392917a.t(r100, r101);
    }

    private ObricTaskSkillDelegate() {
        this.f392917a = (IObricTaskSkillService) ServiceManager.get().getService(IObricTaskSkillService.class);
    }
}
