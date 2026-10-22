package com.larksuite.component.card.plugin;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.larksuite.component.card.protocol.data.options.OptionUser;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes24.dex */
public class ShowSelectMenuPlugin extends OPPlugin {
    public static final String MULTI_SELECT_PERSON = "multi_select_person";
    public static final String MULTI_SELECT_STATIC = "multi_select_static";
    public static final String OVERFLOW = "overflow";
    public static final String SELECT_PERSON = "select_person";
    public static final String SELECT_STATIC = "select_static";
    public static final String TAG = "ShowSelectMenuPlugin";

    public static /* synthetic */ String e(ShowSelectMenuPlugin r100, com.larksuite.component.card.cardcontainer.c r101, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r102, String r103) {
        return r100.lambda$showMultiSelectStaticPanel$3(r101, r102, r103);
    }

    public static /* synthetic */ Unit f(com.larksuite.component.card.cardcontainer.c r100, LKEvent r101, j18.f r102, List r103) {
        return lambda$showMultiSelectStaticPanel$4(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit g(com.larksuite.component.card.cardcontainer.c r100, LKEvent r101, j18.f r102, UniversalCardShowSelectMenuPluginModel$OptionsItemModel r103) {
        return lambda$showSelectStaticPanel$2(r100, r101, r102, r103);
    }

    public static /* synthetic */ void h(ShowSelectMenuPlugin r100, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r101, LKEvent r102, com.larksuite.component.card.cardcontainer.c r103, j18.f r104) {
        r100.lambda$showSelectMenu$0(r101, r102, r103, r104);
    }

    public static /* synthetic */ String i(ShowSelectMenuPlugin r100, com.larksuite.component.card.cardcontainer.c r101, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r102, String r103) {
        return r100.lambda$showSelectStaticPanel$1(r101, r102, r103);
    }

    public ShowSelectMenuPlugin() {
    }

    private static com.larksuite.component.card.cardcontainer.c getUniversalCardShareData(LKEvent r100) {
        Object r101 = r100.f285495h;
        if ((r101 instanceof ILynxBridgeContext) == false) goto L13;
        ILynxContainerContext r102 = ((ILynxBridgeContext) r101).getContainerContext();
        if (r102 == null) goto L13;
        if (r102.getBizExtra() == null) goto L13;
        if (r102.getBizExtra().get("card_share_data") == null) goto L13;
        if ((r102.getBizExtra().get("card_share_data") instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L13;
        return (com.larksuite.component.card.cardcontainer.c) r102.getBizExtra().get("card_share_data");
    L13:
        return null;
    }

    private static CardAttachment getJsonAttachment(boolean r100, com.larksuite.component.card.cardcontainer.c r101) {
        if (r100 == false) goto L7;
        if (r101.f283234b.getTranslateContent() == null) goto L7;
        return r101.f283234b.getTranslateContent().getAttachment();
    L7:
        return r101.f283234b.getCardContent().getAttachment();
    }

    private String getOptionItemIcon(com.larksuite.component.card.cardcontainer.c r100, boolean r101, String r102) {
        CardAttachment r103 = getJsonAttachment(r101, r100);
        if (r103.getImages() == null) goto L8;
        RichTextElement.ImageProperty r104 = r103.getImages().get(r102);
        CardDataUtils.f283938a.getClass();
        Image r105 = CardDataUtils.d(r104, 1);
        if (r105 != null) goto L7;
        return null;
    L7:
        return r105.getKey();
    L8:
        return null;
    }

    private static void initSelectedValues(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r100, com.larksuite.component.card.cardcontainer.c r101, List<String> r102) {
        ArrayList<String> r103 = r100.initialOptions;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.size() <= 0) goto L22;
        CardAttachment r104 = getJsonAttachment(r100.isTranslateElement, r101);
        if (r104.getOptionUsers() == null) goto L16;
        int r105 = 0;
    L10:
        if (r105 >= r100.initialOptions.size()) goto L23;
        OptionUser r106 = r104.getOptionUsers().get(ListProtector.get(r100.initialOptions, r105));
        if (r106 == null) goto L14;
        r102.add(r106.getUserId());
    L15:
        r105 = r105 + 1;
        goto L10
    L14:
        r102.add((String) ListProtector.get(r100.initialOptions, r105));
        goto L15
    L23:
        return;
    L16:
        r102.addAll(r100.initialOptions);
        return;
    }

    private /* synthetic */ String lambda$showMultiSelectStaticPanel$3(com.larksuite.component.card.cardcontainer.c r100, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r101, String r102) {
        return getOptionItemIcon(r100, r101.isTranslateElement, r102);
    }

    private /* synthetic */ String lambda$showSelectStaticPanel$1(com.larksuite.component.card.cardcontainer.c r100, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r101, String r102) {
        return getOptionItemIcon(r100, r101.isTranslateElement, r102);
    }

    @LKPluginFunction(async = true, eventName = {"universalCardShowSelectMenu"})
    public void showSelectMenu(final LKEvent r100, final UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r101, final j18.f<LKBaseResponseModel> r110) {
        final com.larksuite.component.card.cardcontainer.c r102 = getUniversalCardShareData(r100);
        mz7.b.a(new f(this, r101, r100, r102, r110));
    }

    private static void initOptions(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r100, ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r101, com.larksuite.component.card.cardcontainer.c r102, List<String> r103) {
        CardAttachment r104 = getJsonAttachment(r100.isTranslateElement, r102);
        if (r104.getOptionUsers() == null) goto L12;
        int r105 = 0;
    L6:
        if (r105 >= r101.size()) goto L16;
        OptionUser r106 = r104.getOptionUsers().get(((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(r101, r105)).value);
        if (r106 == null) goto L10;
        r103.add(r106.getUserId());
    L11:
        r105 = r105 + 1;
        goto L6
    L10:
        r103.add(((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(r101, r105)).value);
        goto L11
    L16:
        return;
    }

    private static Unit lambda$showMultiSelectStaticPanel$4(com.larksuite.component.card.cardcontainer.c r100, LKEvent r101, j18.f r102, List r103) {
        if (r100 == null) goto L5;
        r100.f283234b.getCardID();
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        com.larksuite.component.card.monitor.a.a(r100.f283234b.getVersion(), MULTI_SELECT_STATIC, r100.f283235c.getMonitorData(), r100.f283234b.getCardID(), r100.f283234b.isStreamingMode());
        UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r104 = new UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel();
        ArrayList<UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel> r105 = new ArrayList();
        Iterator r106 = r103.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r107 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) r106.next();
        UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel r108 = new UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel();
        r108.text = r107.text;
        r108.value = r107.value;
        r105.add(r108);
        goto L9
    L11:
        r104.selectedValues = r105;
        k.c(r101, r104, r102);
        return null;
    }

    private /* synthetic */ void lambda$showSelectMenu$0(UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r100, LKEvent r110, com.larksuite.component.card.cardcontainer.c r111, j18.f r112) {
        if (SELECT_STATIC.equals(r100.type) == true) goto L12;
        if (MULTI_SELECT_STATIC.equals(r100.type) == true) goto L12;
        if (CollectionUtils.isEmpty(r100.options) == false) goto L10;
        showGroupMenu(r110, SELECT_PERSON.equals(r100.type), r100, r111, r112);
        return;
    L10:
        showTargetMenu(r110, SELECT_PERSON.equals(r100.type), r100, r111, r112);
        return;
    L12:
        if (CollectionUtils.isEmpty(r100.options) == false) goto L16;
        Log.w(TAG, "options is empty");
        return;
    L16:
        if (SELECT_STATIC.equals(r100.type) == false) goto L18;
        showSelectStaticPanel(r110, r100, r111, r112);
        return;
    L18:
        showMultiSelectStaticPanel(r110, r100, r111, r112);
    }

    private static Unit lambda$showSelectStaticPanel$2(com.larksuite.component.card.cardcontainer.c r100, LKEvent r101, j18.f r102, UniversalCardShowSelectMenuPluginModel$OptionsItemModel r103) {
        if (r100 == null) goto L5;
        r100.f283234b.getCardID();
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        com.larksuite.component.card.monitor.a.a(r100.f283234b.getVersion(), SELECT_STATIC, r100.f283235c.getMonitorData(), r100.f283234b.getCardID(), r100.f283234b.isStreamingMode());
        UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r104 = new UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel();
        ArrayList<UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel> r105 = new ArrayList();
        UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel r106 = new UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel();
        r106.text = r103.text;
        r106.value = r103.value;
        r105.add(r106);
        r104.selectedValues = r105;
        k.c(r101, r104, r102);
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larksuite.component.card.plugin.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larksuite.component.card.plugin.c] */
    private void showMultiSelectStaticPanel(final LKEvent r100, final UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r101, final com.larksuite.component.card.cardcontainer.c r102, final j18.f<LKBaseResponseModel> r103) {
        com.larksuite.component.card.plugin.select.i.a(r100, r101, new b(this, r102, r101), new c(r102, r100, r103));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larksuite.component.card.plugin.d] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larksuite.component.card.plugin.e] */
    private void showSelectStaticPanel(final LKEvent r100, final UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r101, final com.larksuite.component.card.cardcontainer.c r102, final j18.f<LKBaseResponseModel> r103) {
        com.larksuite.component.card.plugin.select.j.c(r100, r101, new d(this, r102, r101), new e(r102, r100, r103));
    }

    private void showGroupMenu(final LKEvent r110, final boolean r111, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r112, final com.larksuite.component.card.cardcontainer.c r113, final j18.f<LKBaseResponseModel> r114) {
        if (r113 != null) goto L6;
        Log.w(TAG, "card share data is null");
        return;
    L6:
        final String r100 = r113.f283234b.getCardID();
        ArrayList r101 = new ArrayList();
        initSelectedValues(r112, r113, r101);
        CardActionDependencyData r102 = r113.f283235c.getCardActionDependencyData();
        if (TextUtils.isEmpty(r102.getSelectPersonCurrentChatId()) == true) goto L9;
        String r103 = r102.getSelectPersonCurrentChatId();
    L10:
        String r104 = r103;
        if ((r110.getContext() instanceof Activity) == false) goto L14;
        Activity r105 = (Activity) r110.getContext();
    L19:
        Activity r106 = r105;
        if (r106 != null) goto L22;
        Log.w(TAG, "showTargetMenu Activity is null");
    L22:
        ty7.a.a().pickGroupMember(r106, r104, r101, r111, r112.title, new AnonymousClass2(this, r110, r100, r111, r113, r114));
        return;
    L14:
        if ((r110.getContext() instanceof dwa.e) == true) goto L16;
    L18:
        r105 = null;
        goto L19
    L16:
        if ((((dwa.e) r110.getContext()).getBaseContext() instanceof Activity) == false) goto L18;
        r105 = (Activity) ((dwa.e) r110.getContext()).getBaseContext();
        goto L19
    L9:
        r103 = "";
        goto L10
    }

    private void showTargetMenu(final LKEvent r110, final boolean r111, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r112, final com.larksuite.component.card.cardcontainer.c r113, final j18.f<LKBaseResponseModel> r114) {
        if (r113 != null) goto L6;
        Log.w(TAG, "card share data is null");
        return;
    L6:
        final String r100 = r113.f283234b.getCardID();
        ArrayList r101 = new ArrayList();
        initOptions(r112, r112.options, r113, r101);
        ArrayList r102 = new ArrayList();
        initSelectedValues(r112, r113, r102);
        if ((r110.getContext() instanceof Activity) == false) goto L10;
        Activity r103 = (Activity) r110.getContext();
    L15:
        Activity r104 = r103;
        if (r104 != null) goto L18;
        Log.w(TAG, "showTargetMenu Activity is null");
    L18:
        ty7.a.a().pickTargetMember(r104, r101, r102, r111, r112.title, new AnonymousClass1(this, r110, r100, r111, r113, r114));
        return;
    L10:
        if ((r110.getContext() instanceof dwa.e) == true) goto L12;
    L14:
        r103 = null;
        goto L15
    L12:
        if ((((dwa.e) r110.getContext()).getBaseContext() instanceof Activity) == false) goto L14;
        r103 = (Activity) ((dwa.e) r110.getContext()).getBaseContext();
        goto L15
    }

    private void handleCallBack(LKEvent r100, String r101, boolean r102, List<ChatChatter> r103, com.larksuite.component.card.cardcontainer.c r104, j18.f<LKBaseResponseModel> r105) {
        String r106 = r104.f283234b.getVersion();
        if (r102 == false) goto L5;
        String r107 = SELECT_PERSON;
    L6:
        com.larksuite.component.card.monitor.a.a(r106, r107, r104.f283235c.getMonitorData(), r104.f283234b.getCardID(), r104.f283234b.isStreamingMode());
        UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel r108 = new UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuResponseModel();
        ArrayList<UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel> r109 = new ArrayList();
        Iterator<ChatChatter> r110 = r103.iterator();
    L8:
        if (r110.hasNext() == false) goto L10;
        ChatChatter r111 = r110.next();
        UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel r112 = new UniversalCardShowSelectMenuPluginModel$SelectedValuesItemModel();
        r112.text = r111.getLocalizedName();
        r112.value = r111.getId();
        r109.add(r112);
        goto L8
    L10:
        r108.selectedValues = r109;
        k.c(r100, r108, r105);
        return;
    L5:
        r107 = MULTI_SELECT_PERSON;
        goto L6
    }

    public static /* synthetic */ void access$000(ShowSelectMenuPlugin r100, LKEvent r101, String r102, boolean r103, List r104, com.larksuite.component.card.cardcontainer.c r105, j18.f r106) {
        r100.handleCallBack(r101, r102, r103, r104, r105, r106);
    }
}
