package q29;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import fs9.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements gs9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<UserCreation> f531463a;

    @Override // gs9.e
    public final void checkLoadMore() {
    }

    @Override // gs9.e
    public final LiveData<List<UserCreationModel>> getFeedDataLiveData() {
        List<UserCreation> r100 = this.f531463a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        UserCreation r103 = (UserCreation) r102.next();
        UserCreationModel r104 = new UserCreationModel(0, CollectionsKt.mutableListOf(new UserCreation[]{r103}), r103.f364987a, 1);
        a0.c(r104);
        r101.add(r104);
        goto L4
    L7:
        return new MutableLiveData(r101);
    }

    @Override // gs9.e
    public final LiveData<gs9.i> getMoreState() {
        return new MutableLiveData();
    }

    public e(List<UserCreation> r100) {
        this.f531463a = r100;
    }

    @Override // gs9.e
    public final void updateCreationContent(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "userCreation");
    }

    @Override // gs9.e
    public final void deleteUserCreation(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "creationId");
    }

    @Override // gs9.e
    public final void updateCreationModelPrivacy(int r100, boolean r101, UserCreation r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "userCreation");
    }
}
