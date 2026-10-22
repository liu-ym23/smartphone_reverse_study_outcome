package com.ss.android.ugc.aweme.search.mob;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.discover.viewmodel.ECSearchEnterViewModel;
import com.ss.android.ugc.aweme.search.ecommerce.api.IECPhotoSearch;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import com.ss.android.ugc.aweme.search.vision.IPhotoSearch;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/CommodityMobHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityMobHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f453290a = 0;

    private CommodityMobHelper() {
    }

    static {
        new CommodityMobHelper();
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        ECSearchEnterViewModel.Companion r101 = ECSearchEnterViewModel.Companion;
        boolean r102 = r100 instanceof FragmentActivity;
        if (r102 == true) goto L5;
        Context r103 = null;
    L6:
        r101.getClass();
        SearchEnterParam r104 = ECSearchEnterViewModel.Companion.a((FragmentActivity) r103).getEnterParam();
        if (r104 != null) goto L9;
    L11:
        if (r102 == true) goto L13;
        Context r105 = null;
    L14:
        FragmentActivity r106 = (FragmentActivity) r105;
        if (r106 != null) goto L18;
        return false;
    L18:
        if ((r106 instanceof IPhotoSearch) == false) goto L20;
        return true;
    L20:
        if ((r106 instanceof IECPhotoSearch) == true) goto L26;
        if (r102 == true) goto L23;
        r100 = null;
    L23:
        FragmentActivity r107 = (FragmentActivity) r100;
        return false;
    L26:
        return true;
    L13:
        r105 = r100;
        goto L14
    L9:
        if (r104.isHalfScreenPhotoSearch() != true) goto L11;
        return true;
    L5:
        r103 = r100;
        goto L6
    }
}
