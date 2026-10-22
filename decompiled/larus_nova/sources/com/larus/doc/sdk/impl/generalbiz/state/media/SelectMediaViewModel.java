package com.larus.doc.sdk.impl.generalbiz.state.media;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.api.toolbar.media.impl.SelectedMediaItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0014\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_hideContainer", "Landroidx/lifecycle/MutableLiveData;", "", "hideContainer", "Landroidx/lifecycle/LiveData;", "getHideContainer", "()Landroidx/lifecycle/LiveData;", "", "resetContainerVisible", "callback", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaViewModel$ISelectMediaCallback;", "setCallback", "onSelectMediaV1", "media", "", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "onSelectMedia", "Lcom/bytedance/ee/bear/api/toolbar/media/impl/SelectedMediaItem;", "onPrepareInsertImage", "ISelectMediaCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectMediaViewModel extends ViewModel {
    private final MutableLiveData<Boolean> _hideContainer;
    private ISelectMediaCallback callback;
    private final LiveData<Boolean> hideContainer;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H&¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaViewModel$ISelectMediaCallback;", "", "onBeginTakePhoto", "", "onSelectMediaV1", "media", "", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "onSelectMedia", "Lcom/bytedance/ee/bear/api/toolbar/media/impl/SelectedMediaItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ISelectMediaCallback {
        void onBeginTakePhoto();

        void onSelectMedia(List<? extends SelectedMediaItem> r100);

        void onSelectMediaV1(List<SelectedMediaItemV1> r100);
    }

    public final void hideContainer() {
        this._hideContainer.setValue(Boolean.TRUE);
    }

    public final void onPrepareInsertImage() {
        ISelectMediaCallback r100 = this.callback;
        if (r100 == null) goto L6;
        r100.onBeginTakePhoto();
        return;
    }

    public final void resetContainerVisible() {
        this._hideContainer.setValue(Boolean.FALSE);
    }

    public SelectMediaViewModel() {
        MutableLiveData<Boolean> r100 = new MutableLiveData(Boolean.FALSE);
        this._hideContainer = r100;
        this.hideContainer = r100;
    }

    public final LiveData<Boolean> getHideContainer() {
        return this.hideContainer;
    }

    public final void onSelectMedia(List<? extends SelectedMediaItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "media");
        ISelectMediaCallback r101 = this.callback;
        if (r101 == null) goto L6;
        r101.onSelectMedia(r100);
        return;
    }

    public final void onSelectMediaV1(List<SelectedMediaItemV1> r100) {
        Intrinsics.checkNotNullParameter(r100, "media");
        ISelectMediaCallback r101 = this.callback;
        if (r101 == null) goto L6;
        r101.onSelectMediaV1(r100);
        return;
    }

    public final void setCallback(ISelectMediaCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.callback = r100;
    }
}
