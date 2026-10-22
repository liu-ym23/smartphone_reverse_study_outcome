package com.ss.android.ugc.aweme.search.vision.result.content.card;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.ss.android.ugc.aweme.search.vision.model.decouple.SelectEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/content/card/CropImageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addUserDrawLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getAddUserDrawLiveData", "()Landroidx/lifecycle/MutableLiveData;", "selectEntityLiveData", "Lcom/ss/android/ugc/aweme/search/vision/model/decouple/SelectEntity;", "getSelectEntityLiveData", "updateSelectEntityLiveData", "getUpdateSelectEntityLiveData", "buildSelectEntity", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CropImageViewModel extends ViewModel {
    public static final Companion Companion = null;
    private final MutableLiveData<String> addUserDrawLiveData;
    private final MutableLiveData<SelectEntity> selectEntityLiveData;
    private final MutableLiveData<SelectEntity> updateSelectEntityLiveData;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/content/card/CropImageViewModel$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static CropImageViewModel a(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return (CropImageViewModel) ViewModelProviders.of(r100).get(CropImageViewModel.class);
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final SelectEntity buildSelectEntity() {
        SelectEntity r100 = new SelectEntity(null, null, null, 63);
        this.updateSelectEntityLiveData.setValue(r100);
        return r100;
    }

    public CropImageViewModel() {
        this.addUserDrawLiveData = new MutableLiveData();
        this.selectEntityLiveData = new MutableLiveData();
        this.updateSelectEntityLiveData = new MutableLiveData();
    }

    public final MutableLiveData<String> getAddUserDrawLiveData() {
        return this.addUserDrawLiveData;
    }

    public final MutableLiveData<SelectEntity> getSelectEntityLiveData() {
        return this.selectEntityLiveData;
    }

    public final MutableLiveData<SelectEntity> getUpdateSelectEntityLiveData() {
        return this.updateSelectEntityLiveData;
    }
}
