package com.obric.assistant.spi.task;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.t0;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\fH&J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\fH&¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH&J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\bH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"H&J\u0012\u0010#\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\u0006H&J4\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u0016H&J\n\u0010*\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010+\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010-H&J\u001c\u0010.\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010-H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016H&J\u0016\u00102\u001a\u00020\u00032\f\u00103\u001a\b\u0012\u0004\u0012\u00020\"04H&J\n\u00105\u001a\u0004\u0018\u00010\u0013H&¨\u00066"}, d2 = {"Lcom/obric/assistant/spi/task/IObricTaskSkillService;", "", "extendObricActionBarWhiteItems", "", "itemsConfig", "", "", "selectedDeepThinkStatus", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "injectObricDefaultReplyModeMenuInfo", "menuInfo", "resolveDefaultReplyMode", "", "serverDefaultReplyMode", "(I)Ljava/lang/Integer;", "resolveDefaultModelItemKey", "defaultModelItemKey", "defaultReplyMode", "resolveDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "defaultReplyOption", "saveObricDefaultReplyModeIfNeeded", "", "itemId", "(I)Ljava/lang/Boolean;", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Boolean;", "isObricDefaultReplyModeAvailable", "getPhoneOperationModeIdIfSupportModel", "modelIdentity", "getModelItemsJson", "getDefaultModelItemJson", "getPhoneOperationModeSupportModel", "selectedMode", "Lcom/larus/bmhome/actionbar/model/ActiveSwitchMenuMode;", "isPhoneOperationMode", "modeId", "getBlueTagTextByOption", "modeKey", "modelKey", "menuSection", "isFromSettingPage", "getCurrentDisplayModel", "onSettingModelChanged", "activity", "Landroid/app/Activity;", "onActionBarModelChanged", "storeIsUsingMenuConfV2", "isUsingMenuConfV2", "useModeModelList", "markQuickModeModelsSize", "modeList", "", "getObricDefaultReplyOption", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTaskSkillService {
    String a(String r100, String r101, String r102, boolean r103);

    Object b(Object r100);

    boolean c(ReplyOption r100);

    boolean d(String r100);

    String e(ReplyOption r100, ModelItemIdentity r101);

    String f();

    ModelItemIdentity g(ModelItemIdentity r100, t0 r101);

    String getCurrentDisplayModel();

    void h(List<t0> r100);

    String i();

    String j(String r100, int r101);

    void k(Set<String> r100, ModelItemIdentity r101);

    void l(ReplyOption r100, FragmentActivity r101);

    ReplyOption m();

    Integer n(int r100);

    Boolean o(int r100);

    Boolean p(ReplyOption r100);

    boolean q(int r100);

    void r(boolean r100, boolean r101);

    ReplyOption s(ReplyOption r100);

    void t(ReplyOption r100, Activity r101);
}
