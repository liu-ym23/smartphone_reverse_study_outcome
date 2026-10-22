package com.bytedance.ee.android.file.picker.lib.v2.ui.confirm;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerConfirmItemFileBinding;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import com.bytedance.ee.android.file.picker.lib.v2.ui.adapter.AbsFileListAdapter;
import com.bytedance.ee.android.file.picker.lib.v2.ui.adapter.ViewBindingHolder;
import com.bytedance.ee.android.file.picker.lib.v2.ui.view.FileInfoView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.o0;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0000¢\u0006\u0002\b\u0018J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J.\u0010\u001e\u001a\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\u001dH\u0016RR\u0010\u0007\u001a:\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\u0004\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/ConfirmAdapter;", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/adapter/AbsFileListAdapter;", "Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerConfirmItemFileBinding;", "categoryConfigManager", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;", "<init>", "(Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;)V", "mDeleteHandler", "Lkotlin/Function2;", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "Lkotlin/ParameterName;", "name", "groupKey", "fileKey", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/DeleteHandler;", "getMDeleteHandler", "()Lkotlin/jvm/functions/Function2;", "setMDeleteHandler", "(Lkotlin/jvm/functions/Function2;)V", "setData", "list", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/GroupEntity;", "setData$file_picker_lib_release", "onCreateChildViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindChildViewHolder", "holder", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/adapter/ViewBindingHolder;", "groupPosition", "childPosition", "getInitialGroupExpandedState", "", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfirmAdapter extends AbsFileListAdapter<FilePickerConfirmItemFileBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super Key, ? super Key, Unit> f206093d;

    public ConfirmAdapter(sm4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryConfigManager");
        super(r100);
    }

    @Override // com.bytedance.ee.android.file.picker.lib.v2.ui.adapter.AbsFileListAdapter
    public final ViewBinding A2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = o0.a(r100).inflate(R.layout.file_picker_confirm_item_file, r100, false);
        int r102 = R.id.file_info_view;
        FileInfoView r103 = (FileInfoView) ViewBindings.findChildViewById(r101, R.id.file_info_view);
        if (r103 == null) goto L11;
        r102 = R.id.right_remove_image;
        if (((ImageView) ViewBindings.findChildViewById(r101, R.id.right_remove_image)) == null) goto L11;
        r102 = R.id.right_remove_image_layout;
        View r104 = ViewBindings.findChildViewById(r101, R.id.right_remove_image_layout);
        if (r104 == null) goto L11;
        return new FilePickerConfirmItemFileBinding((ConstraintLayout) r101, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public final void B2(final List<GroupEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Function1<ArrayList<GroupEntity>, Unit> r101 = new ConfirmAdapter$setData$1(r100);
        Intrinsics.checkNotNullParameter(r101, "block");
        r101.invoke(this.f206088c);
        notifyDataSetChanged();
    }

    @Override // aw7.c
    public final void d1(RecyclerView.ViewHolder r100, int r101, int r102, int r103) {
        ViewBindingHolder r104 = (ViewBindingHolder) r100;
        Intrinsics.checkNotNullParameter(r104, "holder");
        GroupEntity r105 = (GroupEntity) ListProtector.get(this.f206088c, r101);
        FileEntry r106 = (FileEntry) ListProtector.get(r105.f206022b, r102);
        ((FilePickerConfirmItemFileBinding) r104.f206091b).f205980b.setData(r106);
        ((FilePickerConfirmItemFileBinding) r104.f206091b).f205981c.setOnClickListener(new a(this, r105, r106));
    }
}
