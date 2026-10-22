package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListArgs;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListArgs;)V", "getArgs", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListArgs;", "title", "Landroidx/lifecycle/MutableLiveData;", "", "getTitle", "()Landroidx/lifecycle/MutableLiveData;", "searching", "", "getSearching", "searchInput", "", "getSearchInput", "init", "", "setInSearching", "inSearching", "setSearchInput", "input", "clearSearchInput", "Companion", "Factory", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceTabViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "WikiSpaceListViewModel";
    private final WikiSpaceListArgs args;
    private final MutableLiveData<String> searchInput;
    private final MutableLiveData<Boolean> searching;
    private final MutableLiveData<Integer> title;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static WikiSpaceTabViewModel a(Fragment r3) {
            Intrinsics.checkNotNullParameter(r3, "owner");
            Bundle r0 = r3.getArguments();
            if (r0 == null) goto L5;
            WikiSpaceListArgs r1 = (WikiSpaceListArgs) r0.getParcelable(WikiSpaceListArgs.class.getName());
        L7:
            return (WikiSpaceTabViewModel) new ViewModelProvider(r3, new b(r1)).get(WikiSpaceTabViewModel.class);
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class b implements ViewModelProvider.Factory {
        public final WikiSpaceListArgs a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public b(WikiSpaceListArgs r1) {
            this.a = r1;
        }

        public final <T extends ViewModel> T create(Class<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "modelClass");
            return r5.getConstructor(new Class[]{WikiSpaceListArgs.class}).newInstance(new Object[]{this.a});
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final WikiSpaceTabViewModel newInstance(Fragment r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public final void clearSearchInput() {
        this.searchInput.setValue("");
    }

    public final void init() {
        this.searching.setValue(Boolean.FALSE);
        this.searchInput.setValue("");
        this.title.setValue(2131888330);
    }

    public final WikiSpaceListArgs getArgs() {
        return this.args;
    }

    public final MutableLiveData<String> getSearchInput() {
        return this.searchInput;
    }

    public final MutableLiveData<Boolean> getSearching() {
        return this.searching;
    }

    public final MutableLiveData<Integer> getTitle() {
        return this.title;
    }

    public WikiSpaceTabViewModel(WikiSpaceListArgs r1) {
        this.args = r1;
        this.title = new MutableLiveData();
        this.searching = new MutableLiveData();
        this.searchInput = new MutableLiveData();
        init();
    }

    public final void setInSearching(boolean r2) {
        this.searching.setValue(Boolean.valueOf(r2));
    }

    public final void setSearchInput(String r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        this.searchInput.setValue(r2);
    }
}
