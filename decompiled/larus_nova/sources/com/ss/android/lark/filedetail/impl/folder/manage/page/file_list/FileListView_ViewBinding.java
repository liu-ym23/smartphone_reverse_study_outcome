package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public final class FileListView_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FileListView f421756a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        FileListView r100 = this.f421756a;
        if (r100 == null) goto L7;
        this.f421756a = null;
        r100.mFileListRv = null;
        r100.mPtrView = null;
        r100.mContentLayout = null;
        r100.mLoadingLayout = null;
        r100.loadingIv = null;
        r100.mEmptyLayout = null;
        r100.mEmptyIv = null;
        r100.mEmptyHint = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public FileListView_ViewBinding(FileListView r100, View r101) {
        this.f421756a = r100;
        r100.mFileListRv = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.file_info_list_rv, "field 'mFileListRv'", RecyclerView.class);
        r100.mPtrView = (LKUIPtrClassicFrameLayout) Utils.findRequiredViewAsType(r101, R.id.ptr_view, "field 'mPtrView'", LKUIPtrClassicFrameLayout.class);
        r100.mContentLayout = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.content_layout, "field 'mContentLayout'", ViewGroup.class);
        r100.mLoadingLayout = Utils.findRequiredView(r101, R.id.fetch_loading, "field 'mLoadingLayout'");
        r100.loadingIv = (ImageView) Utils.findRequiredViewAsType(r101, R.id.fetch_loading_iv, "field 'loadingIv'", ImageView.class);
        r100.mEmptyLayout = Utils.findRequiredView(r101, R.id.fetch_result_empty, "field 'mEmptyLayout'");
        r100.mEmptyIv = (ImageView) Utils.findRequiredViewAsType(r101, R.id.empty_iv, "field 'mEmptyIv'", ImageView.class);
        r100.mEmptyHint = (TextView) Utils.findRequiredViewAsType(r101, R.id.empty_hint, "field 'mEmptyHint'", TextView.class);
    }
}
