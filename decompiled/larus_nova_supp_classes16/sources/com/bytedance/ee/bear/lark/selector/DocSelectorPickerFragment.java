package com.bytedance.ee.bear.lark.selector;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0015\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010 \u001a\u00020\u0018H\u0002J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\u0018J\b\u0010&\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/lark/selector/DocSelectorPickerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "mTitle", "", "mConfirmText", "mMaxNum", "", "mDisableNewDoc", "", "mPicker", "Lcom/ss/android/lark/picker/NavPicker;", "mResult", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/ArrayList;", "chatId", "createDocEntry", "Landroid/view/View;", "pickerListener", "com/bytedance/ee/bear/lark/selector/DocSelectorPickerFragment$pickerListener$1", "Lcom/bytedance/ee/bear/lark/selector/DocSelectorPickerFragment$pickerListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setWindowInsets", "onViewCreated", "view", "initMVP", "hasBenefit", "onConfirm", "buildCreateDocumentEntry", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSelectorPickerFragment extends BaseFragment {
    public String d;
    public String e;
    public boolean f;
    public NavPicker g;
    public ArrayList<SearchBaseInfo> h;
    public String i;
    public View j;
    public final b k;

    public static final class a {
    }

    public static final class b extends BasePicker.IOnPickNotify {
        public final /* synthetic */ DocSelectorPickerFragment a;

        public final void onSelected(String r2, SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "info");
        }

        public b(DocSelectorPickerFragment r1) {
            this.a = r1;
        }

        public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
            Intrinsics.checkNotNullParameter(r2, "ids");
            Intrinsics.checkNotNullParameter(r3, "infoList");
            ArrayList<SearchBaseInfo> r4 = (ArrayList) r3;
            this.a.h = r4;
        }
    }

    static {
    }

    public final boolean T90() {
        ICCMApi r0 = (ICCMApi) ApiUtils.getApi(ICCMApi.class);     // Catch: Exception -> L7
        if (r0 == null) goto L5;
        r0.checkAndInit();     // Catch: Exception -> L7
    L5:
        return ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("ccm_convert_to_doc");
    L7:
        e = move-exception;
        tt5.a.d(((BaseFragment) this).PARENT_TAG, e.toString());
        return false;
    }

    public final void onConfirm() {
        if (this.h.isEmpty() == false) goto L8;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r0 == null) goto L7;
        r0.c(0, new Bundle());
        return;
    L7:
        setResult(0);
        finish();
        return;
    L8:
        ArrayList<String> r1 = new ArrayList();
        JSONArray r2 = new JSONArray();
        Iterator<SearchBaseInfo> r3 = this.h.iterator();
    L10:
        if (r3.hasNext() == false) goto L24;
        SearchSpaceInfo r4 = (SearchBaseInfo) r3.next();
        if ((r4 instanceof SearchSpaceInfo) == false) goto L15;
        String r5 = r4.getDocUrl();
    L18:
        JSONObject r6 = new JSONObject();
        r6.put("filePath", r5);     // Catch: JSONException -> L21
        r6.put("fileName", r4.getTitle());     // Catch: JSONException -> L21
        r2.put(r6);     // Catch: JSONException -> L21
    L23:
        r1.add(r5);
    L21:
        e = move-exception;
        tt5.a.d(((BaseFragment) this).PARENT_TAG, e.toString());
        goto L23
    L15:
        if ((r4 instanceof SearchWikiInfo) == false) goto L17;
        r5 = ((SearchWikiInfo) r4).getUrl();
        goto L18
    L17:
        r5 = "";
        goto L18
    L24:
        Intent r7 = new Intent();
        r7.putStringArrayListExtra("data", r1);
        r7.putExtra("extra_selected_data", r2.toString());
        com.suite.lark.component.navroute.forseti.g r8 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r8 == null) goto L30;
        Bundle r9 = r7.getExtras();
        if (r9 != null) goto L29;
        r9 = new Bundle();
    L29:
        r8.c(-1, r9);
        return;
    L30:
        setResult(-1, r7);
        finish();
    }

    public DocSelectorPickerFragment() {
        this.d = "";
        this.e = "";
        this.h = new ArrayList();
        this.i = "";
        this.k = new b(this);
    }

    public static final /* synthetic */ String S90(DocSelectorPickerFragment r0) {
        return ((BaseFragment) r0).PARENT_TAG;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        com.ss.android.lark.insets.f r3 = WindowInsetsUtils.b(this);
        r3.f(false);
        r3.o(true);
        r3.c(true);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        NavPicker r5 = r3.findViewById(2131369357);
        this.g = r5;
        if (r5 == null) goto L6;
        r5.scene(PickerStatistics.Scene.ImSelectDocs);
    L6:
        if (this.f == false) goto L8;
    L12:
        Bundle r6 = getArguments();
        if (r6 == null) goto L18;
        this.d = r6.getString("extra_title");
        this.e = r6.getString("extra_confirm_text");
        r6.getInt("extra_max_num", 10);
        this.f = r6.getBoolean("extra_disable_new_doc", this.f);
        String r7 = r6.getString("chat_id");
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        this.i = r7;
    L18:
        NavPickerConfig r8 = new NavPickerConfig(new Dependency(requireActivity(), getChildFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r8.navigation(new DocSelectorPickerFragment$initMVP$config$1$1(this));
        r8.extra(new DocSelectorPickerFragment$initMVP$config$1$2(this));
        r8.searcher(DocSelectorPickerFragment$initMVP$config$1$3.INSTANCE);
        r8.recommendList(DocSelectorPickerFragment$initMVP$config$1$4.INSTANCE);
        NavPicker r9 = this.g;
        if (r9 == null) goto L22;
        r9.init(r8);
        return;
    L22:
        return;
    L8:
        if (idb.f.a().isCurrentEnable("im.messenger.chatbox_createdocs") == false) goto L12;
        View r10 = LayoutInflater.from(getContext()).inflate(2131559961, null);
        this.j = r10;
        if (r10 == null) goto L12;
        r10.setOnClickListener(new DocSelectorPickerFragment$buildCreateDocumentEntry$1(this));
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558458, r3, false);
    }
}
