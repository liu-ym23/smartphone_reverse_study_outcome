package com.bytedance.ee.bear.search.picker.filter.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/chat/ChatPickerFragment;", "Lcom/bytedance/ee/bear/search/picker/BaseSearchPickerFragment;", "<init>", "()V", "pickerNotifyListener", "Lcom/bytedance/ee/bear/search/picker/filter/chat/ChatPickerNotifyListener;", "picker", "Lcom/ss/android/lark/picker/NavPicker;", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "selectedChat", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/ArrayList;", "getSelectedChat", "()Ljava/util/ArrayList;", "setSelectedChat", "(Ljava/util/ArrayList;)V", "multipleSelect", "", "getMultipleSelect", "()Z", "setMultipleSelect", "(Z)V", "getPicker", "Landroid/view/View;", "getPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "fragmentactivity", "Landroidx/fragment/app/FragmentActivity;", "confirmResult", "", "info", "isConfirm", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatPickerFragment extends BaseSearchPickerFragment {
    public static final /* synthetic */ int h = 0;
    public com.bytedance.ee.bear.search.picker.filter.chat.a e;
    public ArrayList<SearchBaseInfo> f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final View V90() {
        Bundle r1 = getArguments();     // Catch: Exception -> L9
        if (r1 == null) goto L6;
        Serializable r2 = r1.getSerializable("EXTRA_SELECTED_CHAT");     // Catch: Exception -> L9
    L7:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.util.ArrayList<com.ss.android.lark.search.dto.info.SearchBaseInfo>");     // Catch: Exception -> L9
        this.f = (ArrayList) r2;     // Catch: Exception -> L9
    L10:
        this.g = !CollectionUtils.isEmpty(this.f);
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L16;
        NavPicker r4 = new NavPicker(r3, null, 2, null);
        r4.scene(PickerStatistics.Scene.CcmFilterByChat);
        Intrinsics.checkNotNullParameter(r3, "fragmentactivity");
        this.e = new com.bytedance.ee.bear.search.picker.filter.chat.a(this);
        NavPickerConfig r0 = new NavPickerConfig(new Dependency(r3, r3.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r0.searcher(ChatPickerFragment$getPickerConfig$config$1$1.INSTANCE);
        r0.extra(new ChatPickerFragment$getPickerConfig$config$1$2(this));
        r0.navigation(new ChatPickerFragment$getPickerConfig$config$1$3(this));
        r0.recommendList(ChatPickerFragment$getPickerConfig$config$1$4.INSTANCE);
        r4.init(r0);
        return r4;
    L16:
        return null;
    L6:
        r2 = null;
    L9:
        tt5.a.d("ChatterPickerFragment", "parse selectedChat error");
        goto L10
    }

    public ChatPickerFragment() {
        this.f = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.search.picker.BaseSearchPickerFragment
    public final void U90(SearchBaseInfo r2, boolean r3) {
        if (r3 == false) goto L4;
    L6:
        Intent r4 = new Intent();
        r4.putExtra("EXTRA_CHAT_INFO", this.f);
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L9;
        r5.setResult(4098, r4);
    L9:
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L13;
        r6.finish();
        return;
    L13:
        return;
    L4:
        if (this.g == false) goto L6;
    }
}
