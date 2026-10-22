package ut1;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerUIManager;

/* JADX INFO: loaded from: classes8.dex */
public class a implements IDrawerFeedAction {
    public a() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public void closeDrawerDialog() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public void disableDrawerSlide() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public void enterHistory() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public void enterSearch() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public void feedEnd() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public final ViewModel getDataCenter() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public IDrawerUIManager getDrawerUIManager() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public void historyShow(int r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public final void scrollToTop(boolean r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public void setBackgroundByTabType(int r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction
    public final /* synthetic */ void setDrawerLockMode(int r100) {
        IDrawerFeedAction.CC.$default$setDrawerLockMode(this, r100);
    }
}
