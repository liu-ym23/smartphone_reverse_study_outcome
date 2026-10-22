package com.bytedance.ee.android.file.picker.lib.v2.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerFileInfoBinding;
import com.bytedance.ee.android.file.picker.lib.utils.FileUtils;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.larksuite.framework.utils.o0;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm4.b;
import y9c.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/view/FileInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBinding", "Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerFileInfoBinding;", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "mIconLoaderManager", "Lcom/bytedance/ee/android/file/picker/lib/v2/icon/FileIconLoaderManager;", "getMIconLoaderManager", "()Lcom/bytedance/ee/android/file/picker/lib/v2/icon/FileIconLoaderManager;", "setMIconLoaderManager", "(Lcom/bytedance/ee/android/file/picker/lib/v2/icon/FileIconLoaderManager;)V", "iconSize", "", "setData", "", "data", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/FileEntry;", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
public final class FileInfoView extends Hilt_FileInfoView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FilePickerFileInfoBinding f206143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    public b f206144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f206145e;

    public final ImageView getIconView() {
        return this.f206143c.f205983b;
    }

    public final b getMIconLoaderManager() {
        b r100 = this.f206144d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mIconLoaderManager");
        return null;
    }

    public FileInfoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setData(FileEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        b r101 = getMIconLoaderManager();
        String r102 = r100.f206017e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "type");
        Provider<vm4.a> r103 = r101.f556342b.get(r102);
        if (r103 != null) goto L5;
        Log.w("FilePickerV2", "File icon loader [" + r102 + "] not registered.");
        vm4.a r104 = r101.f556341a.get();
    L6:
        r104.a(this.f206143c.f205983b, this.f206145e, r100);
        this.f206143c.f205986e.setText(r100.f206013a);
        TextView r105 = this.f206143c.f205987f;
        String[] r106 = FileUtils.f206006a;
        r105.setText(FileUtils.a(r100.f206016d));
        this.f206143c.f205985d.setText(r100.f206018f);
        return;
    L5:
        r104 = r103.get();
        goto L6
    }

    public final void setMIconLoaderManager(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f206144d = r100;
    }

    public FileInfoView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110);
        o0.a(this).inflate(R.layout.file_picker_file_info, this);
        int r111 = R.id.icon;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(this, R.id.icon);
        if (r101 == null) goto L15;
        r111 = R.id.icon_click_view;
        View r102 = ViewBindings.findChildViewById(this, R.id.icon_click_view);
        if (r102 == null) goto L15;
        r111 = R.id.tv_file_extra;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_file_extra);
        if (r103 == null) goto L15;
        r111 = R.id.tv_file_name;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_file_name);
        if (r104 == null) goto L15;
        r111 = R.id.tv_file_size;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_file_size);
        if (r105 == null) goto L15;
        this.f206143c = new FilePickerFileInfoBinding(this, r101, r102, r103, r104, r105);
        this.f206145e = d.d(r100, R.dimen.file_picker_file_info_icon_size);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r111)));
    }
}
