package com.bytedance.creativex.mediaimport.preview.internal.base;

import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.scene.ui.ScenePageAdapter;
import fi4.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ti4.s;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0014\u001a\u00020\u0010H\u0004R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/creativex/mediaimport/preview/internal/base/BasePreviewScenePagerAdapter;", "DATA", "Lcom/bytedance/scene/ui/ScenePageAdapter;", "Lcom/bytedance/creativex/mediaimport/preview/internal/IPreviewPagerAdapter;", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectPagerView$Page;", "parent", "Lcom/bytedance/scene/group/GroupScene;", "<init>", "(Lcom/bytedance/scene/group/GroupScene;)V", "pageList", "", "updatePages", "", "list", "", "getCount", "", "asPagerAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "getPageData", "position", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasePreviewScenePagerAdapter<DATA> extends ScenePageAdapter implements b<s<DATA>> {
    @Override // fi4.b
    public final PagerAdapter b() {
        return this;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        throw null;
    }

    @Override // fi4.b
    public final void e(List<s<DATA>> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        throw null;
    }
}
