package com.bytedance.ee.bear.bitable.newform.notification;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.config.ConfigKt;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.factory.PickerFactory;
import com.ss.android.lark.picker.factory.PickerFactoryLoader;
import com.ss.android.lark.picker.factory.PickerViewHolder;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.EntityType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0003;<=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J$\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001f\u0010#\u001a\u0004\u0018\u00010\u00132\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\rH\u0016J$\u0010*\u001a\u00020\r2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\bH\u0002J1\u00100\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020201\u0018\u00010,2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002¢\u0006\u0002\u00103J#\u00104\u001a\b\u0012\u0004\u0012\u00020/0,2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002¢\u0006\u0002\u00103J\u0014\u00105\u001a\u0004\u0018\u00010-2\b\u00106\u001a\u0004\u0018\u00010-H\u0002J\u0014\u00107\u001a\u0004\u0018\u0001022\b\u00108\u001a\u0004\u0018\u00010-H\u0002J\u0010\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020 H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/bytedance/ee/bear/bitable/newform/notification/ContactChooseFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "Landroid/content/DialogInterface$OnKeyListener;", "<init>", "()V", "mFinishListener", "Lcom/bytedance/ee/bear/bitable/newform/notification/ContactChooseFragment$OnSelectedFinishListener;", "mSelectedChats", "", "Lcom/bytedance/ee/bear/bitable/newform/notification/SelectItem;", "pickerViewHolder", "Lcom/ss/android/lark/picker/factory/PickerViewHolder;", "setFinishListener", "", "finishListener", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onCreateDialog", "Landroid/app/Dialog;", WidgetCostModule.TYPE_ON_START, "onKey", "", "dialog", "Landroid/content/DialogInterface;", "keyCode", "", "event", "Landroid/view/KeyEvent;", "getPicker", "preSelectedItems", "", "Lcom/bytedance/ee/bear/bitable/newform/notification/PreSelectItem;", "([Lcom/bytedance/ee/bear/bitable/newform/notification/PreSelectItem;)Landroid/view/View;", "confirmSelection", "onDestroyView", "buildSelectedChats", "ids", "", "", "infoList", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getPreSelectedIds", "Lkotlin/Pair;", "Lcom/ss/android/lark/search/dto/EntityType;", "([Lcom/bytedance/ee/bear/bitable/newform/notification/PreSelectItem;)Ljava/util/List;", "getPreSelectedSearchItems", "getAvatarKeyByUrl", "avatarUrl", "getChatEntityType", "type", "getChatTypeStr", "chatType", "ChatType", "OnSelectedFinishListener", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactChooseFragment extends BaseDialogFragment implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Regex f214772k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Regex f214773l = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f214774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<SelectItem> f214775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PickerViewHolder f214776j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/newform/notification/ContactChooseFragment$ChatType;", "", "<init>", "(Ljava/lang/String;I)V", "CHATTER", "CHAT", "UNKNOWN", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatType extends Enum<ChatType> {
        public static final ChatType CHAT = null;
        public static final ChatType CHATTER = null;
        public static final ChatType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatType[] f214777a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f214778b = null;

        public static EnumEntries<ChatType> getEntries() {
            return f214778b;
        }

        static {
            ChatType r100 = new ChatType("CHATTER", 0);
            CHATTER = r100;
            ChatType r101 = new ChatType("CHAT", 1);
            CHAT = r101;
            ChatType r102 = new ChatType("UNKNOWN", 2);
            UNKNOWN = r102;
            ChatType[] r103 = {r100, r101, r102};
            f214777a = r103;
            f214778b = EnumEntriesKt.enumEntries(r103);
        }

        public static ChatType[] values() {
            return (ChatType[]) f214777a.clone();
        }

        public static ChatType valueOf(String r100) {
            return (ChatType) r27.a.a(ChatType.class, r100);
        }

        public ChatType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(SelectItem[] r100);

        void onCancel();
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f214779a = null;

        static {
            int[] r100 = new int[EntityType.values().length];
            r100[EntityType.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[EntityType.CHATTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f214779a = r100;
        }
    }

    static {
        f214772k = new Regex("/([^/~]+)~");
        f214773l = new Regex("/([^/._]+)[._]?[^/]*$");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        PickerViewHolder r100 = this.f214776j;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        this.f214776j = null;
        super.onDestroyView();
    }

    public ContactChooseFragment() {
        this.f214775i = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        r101.addFlags(Integer.MIN_VALUE);
        r101.setStatusBarColor(getResources().getColor(R.color.red_6_30));
        return;
    L9:
        return;
    }

    public static final void ba0(ContactChooseFragment r100) {
        r100.getClass();
        tt5.a.b("ContactChooseFragment", "onConfirmed");
        Dialog r101 = r100.getDialog();
        if (r101 == null) goto L21;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r101);
        goto L21
    L14:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r103 == null) goto L18;
        d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L7:
        if (Looper.myLooper() == r102.getLooper()) goto L9;
        r102.post(DialogLancet.createDismissRunnable(r101));
    L21:
        b r104 = r100.f214774h;
        if (r104 == null) goto L28;
        ArrayList r105 = (ArrayList) r100.f214775i;
        r104.a((SelectItem[]) r105.toArray(new SelectItem[0]));
        return;
    }

    public static EntityType da0(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L11:
        return null;
    L6:
        if (TextUtils.equals("CHAT".toLowerCase(Locale.ROOT), r100) == false) goto L9;
        return EntityType.CHAT;
    L9:
        if (TextUtils.equals("CHATTER".toLowerCase(), r100) == false) goto L11;
        return EntityType.CHATTER;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        aa0(R.color.bg_body);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        if (r103 == null) goto L7;
        r103.windowAnimations = R.style.BitableBottomDialogAnimation;
    L7:
        return r101;
    }

    public final void ca0(List<String> r100, List<SearchBaseInfo> r110) {
        ((ArrayList) this.f214775i).clear();
        Iterator<String> r101 = r100.iterator();
        Iterator<SearchBaseInfo> r111 = r110.iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        if (r111.hasNext() == false) goto L26;
        String r102 = r101.next();
        SearchBaseInfo r103 = r111.next();
        if (r103.getType() == 2) goto L11;
        if (r103.getType() != 1) goto L4;
    L11:
        List<SelectItem> r104 = this.f214775i;
        String r105 = r103.getTitle();
        String r106 = r103.getAvatarKey();
        int r107 = r103.getType();
        if (r107 == 1) goto L16;
        if (r107 == 2) goto L15;
        String r108 = "";
    L17:
        ArrayList r109 = (ArrayList) r104;
        r109.add(new SelectItem(r105, r102, r106, r108));
        goto L4
    L15:
        r108 = "CHAT".toLowerCase();
        goto L17
    L16:
        r108 = "CHATTER".toLowerCase();
        goto L17
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.ArrayList] */
    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Bundle r100 = getArguments();
        View r101 = null;
        if (r100 == null) goto L5;
        Parcelable[] r102 = r100.getParcelableArray("key.init_selected_items");
    L7:
        if ((r102 instanceof PreSelectItem[]) == false) goto L9;
        final PreSelectItem[] r103 = (PreSelectItem[]) r102;
    L10:
        View r104 = r110.inflate(R.layout.bitable_forms_choose_contact, r111, false);
        final FragmentActivity r105 = getActivity();
        if (r105 == null) goto L70;
        final Boolean r106 = AppInfoUtils.f();
        if (r106.booleanValue() == false) goto L58;
        if (r103 == null) goto L55;
        final List r107 = new ArrayList();
        int r108 = r103.length;
        int r112 = 0;
    L16:
        if (r112 >= r108) goto L56;
        PreSelectItem r113 = r103[r112];
        EntityType r114 = da0(r113.getType());
        if (r114 != null) goto L20;
        int r115 = -1;
    L22:
        if (r115 == 1) goto L26;
        if (r115 == 2) goto L25;
        SearchBaseInfo r116 = null;
    L27:
        if (r116 == null) goto L51;
        r116.setId(r113.getId());
        String r117 = r113.getName();
        if (r117 != null) goto L31;
        r117 = "";
    L31:
        r116.setTitle(r117);
        String r118 = r113.getAvatarUrl();
        if (r118 != null) goto L34;
    L37:
        boolean r119 = true;
    L38:
        if (r119 == false) goto L41;
    L49:
        String r109 = null;
    L50:
        r116.setAvatarKey(r109);
        r116.setAvatarUrl(r113.getAvatarUrl());
    L52:
        if (r116 == null) goto L54;
        r107.add(r116);
    L54:
        r112 = r112 + 1;
        goto L16
    L41:
        if (StringsKt.contains$default(r118, Constants.WAVE_SEPARATOR, false, 2, null) == false) goto L43;
        Regex r120 = f214772k;
    L44:
        MatchResult r121 = Regex.find$default(r120, r118, 0, 2, null);
        if (r121 == null) goto L49;
        List<String> r122 = r121.getGroupValues();
        if (r122 == null) goto L49;
        r109 = (String) CollectionsKt.getOrNull(r122, 1);
        goto L50
    L43:
        r120 = f214773l;
        goto L44
    L34:
        if (r118.length() == 0) goto L37;
        r119 = false;
        goto L38
    L51:
        r116 = null;
        goto L52
    L25:
        r116 = new SearchChatterInfo();
        goto L27
    L26:
        r116 = new SearchChatInfo();
        goto L27
    L20:
        r115 = c.f214779a[r114.ordinal()];
    L56:
        if (r107 != 0) goto L60;
        r107 = CollectionsKt.emptyList();
    L60:
        if (r106.booleanValue() == false) goto L66;
        Iterable r123 = r107;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
        Iterator r125 = r123.iterator();
    L63:
        if (r125.hasNext() == false) goto L65;
        r124.add(((SearchBaseInfo) r125.next()).getId());
        goto L63
    L65:
        ca0(r124, CollectionsKt.toMutableList(r107));
    L66:
        PickerFactory r126 = PickerFactoryLoader.INSTANCE.load();
        final NavPickerConfig r127 = ConfigKt.navPickerConfig(new Dependency(r105, getChildFragmentManager()), new Permissions(CollectionsKt.emptyList()), ContactChooseFragment$getPicker$1$2.INSTANCE);
        r127.searcher(ContactChooseFragment$getPicker$1$3$1.INSTANCE);
        r127.addressBook(ContactChooseFragment$getPicker$1$3$2.INSTANCE);
        r127.extra(new ContactChooseFragment$getPicker$1$3$3(r106, r107, this, r103));
        r127.navigation(new ContactChooseFragment$getPicker$1$3$4(r105, r127, this));
        Unit r128 = Unit.INSTANCE;
        PickerViewHolder r129 = r126.createNavPickerHolder(r105, r127, PickerStatistics.Scene.BaseFormAddNotificationUser);
        this.f214776j = r129;
        View r130 = r129.getView();
        if (r130 == null) goto L70;
        r101 = r130;
        goto L70
    L55:
        r107 = 0;
        goto L56
    L58:
        r107 = CollectionsKt.emptyList();
    L70:
        if (r101 == null) goto L72;
        ((FrameLayout) r104.findViewById(R.id.root)).addView(r101, new FrameLayout.LayoutParams(-1, -1));
    L72:
        Dialog r131 = getDialog();
        if (r131 == null) goto L75;
        r131.setOnKeyListener(this);
    L75:
        return r104;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L10;
        if (r100 == null) goto L6;
        r100.dismiss();
    L6:
        b r103 = this.f214774h;
        if (r103 == null) goto L9;
        r103.onCancel();
    L9:
        return true;
    L10:
        return false;
    }
}
