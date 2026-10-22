package com.bytedance.ee.android.file.picker.lib.v2.ui.adapter;

import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/adapter/ViewBindingHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/viewbinding/ViewBinding;", "Lcom/h6ah4i/android/widget/advrecyclerview/utils/AbstractExpandableItemViewHolder;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ViewBindingHolder<T extends ViewBinding> extends AbstractExpandableItemViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f206091b;

    public ViewBindingHolder(T r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100.getRoot());
        this.f206091b = r100;
    }
}
