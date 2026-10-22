package com.bytedance.creativex.mediaimport.view.internal.main;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import ki4.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti4.q;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/main/MediaSelectSelectAllView;", "Lcom/bytedance/creativex/mediaimport/view/internal/main/BaseMediaSelectSelectAllView;", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "Lcom/bytedance/creativex/mediaimport/repository/api/IFolderItem;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewGroup;", "selectAllViewModel", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectAllViewModel;", "viewConfigureBuilder", "Lkotlin/Function1;", "Lcom/bytedance/creativex/mediaimport/view/internal/main/BaseMediaSelectSelectAllView$ViewConfigure;", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/ViewGroup;Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectAllViewModel;Lkotlin/jvm/functions/Function1;)V", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MediaSelectSelectAllView extends BaseMediaSelectSelectAllView<r, IFolderItem> {
    public MediaSelectSelectAllView(LifecycleOwner r100, ViewGroup r101, q r102, Function1<? super BaseMediaSelectSelectAllView.a, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        super(r100, r101, r102, r103);
    }
}
