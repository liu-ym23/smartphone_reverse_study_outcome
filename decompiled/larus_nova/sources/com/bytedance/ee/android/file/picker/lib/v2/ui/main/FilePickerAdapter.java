package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerMainItemFileBinding;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import com.bytedance.ee.android.file.picker.lib.v2.ui.adapter.AbsFileListAdapter;
import com.bytedance.ee.android.file.picker.lib.v2.ui.adapter.ViewBindingHolder;
import com.bytedance.ee.android.file.picker.lib.v2.ui.view.FileInfoView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.button.LKUICheckBox;
import com.larksuite.framework.utils.o0;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J.\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020 H\u0016R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/FilePickerAdapter;", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/adapter/AbsFileListAdapter;", "Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerMainItemFileBinding;", "mCategoryConfigManager", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;", "<init>", "(Lcom/bytedance/ee/android/file/picker/lib/v2/data/category/FileCategoryConfigManager;)V", "mSelectedKeys", "Landroidx/collection/ArrayMap;", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "", "mSelectHandler", "Lkotlin/Function3;", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/GroupEntity;", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/FileEntry;", "", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/main/SelectHandler;", "getMSelectHandler", "()Lkotlin/jvm/functions/Function3;", "setMSelectHandler", "(Lkotlin/jvm/functions/Function3;)V", "setData", "list", "", "selectedKey", "", "setData$file_picker_lib_release", "onCreateChildViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindChildViewHolder", "holder", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/adapter/ViewBindingHolder;", "groupPosition", "childPosition", "getInitialGroupExpandedState", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilePickerAdapter extends AbsFileListAdapter<FilePickerMainItemFileBinding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayMap<Key, Set<Key>> f206110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function3<? super GroupEntity, ? super FileEntry, ? super Boolean, Unit> f206111e;

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter, aw7.c
    public final boolean l1(int r100) {
        if (r100 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    public FilePickerAdapter(sm4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "mCategoryConfigManager");
        super(r100);
        this.f206110d = new ArrayMap();
    }

    @Override // com.bytedance.ee.android.file.picker.lib.v2.ui.adapter.AbsFileListAdapter
    public final ViewBinding A2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = o0.a(r100).inflate(R.layout.file_picker_main_item_file, r100, false);
        int r102 = R.id.checkbox_file_select;
        LKUICheckBox r103 = (LKUICheckBox) ViewBindings.findChildViewById(r101, R.id.checkbox_file_select);
        if (r103 == null) goto L11;
        r102 = R.id.file_info_view;
        FileInfoView r104 = (FileInfoView) ViewBindings.findChildViewById(r101, R.id.file_info_view);
        if (r104 == null) goto L11;
        r102 = R.id.layout_file_select;
        View r105 = ViewBindings.findChildViewById(r101, R.id.layout_file_select);
        if (r105 == null) goto L11;
        return new FilePickerMainItemFileBinding((ConstraintLayout) r101, r103, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public final void B2(final List<GroupEntity> r100, Map<Key, ? extends Set<? extends Key>> r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r101, "selectedKey");
        Function1<ArrayList<GroupEntity>, Unit> r102 = new FilePickerAdapter$setData$1(r100);
        Intrinsics.checkNotNullParameter(r102, "block");
        r102.invoke(this.f206088c);
        this.f206110d.clear();
        this.f206110d.putAll(r101);
        notifyDataSetChanged();
    }

    @Override // aw7.c
    public final void d1(RecyclerView.ViewHolder r100, int r101, int r102, int r103) {
        ViewBindingHolder r104 = (ViewBindingHolder) r100;
        Intrinsics.checkNotNullParameter(r104, "holder");
        GroupEntity r105 = (GroupEntity) ListProtector.get(this.f206088c, r101);
        FileEntry r106 = (FileEntry) ListProtector.get(r105.f206022b, r102);
        ((FilePickerMainItemFileBinding) r104.f206091b).f206000c.setData(r106);
        ((FilePickerMainItemFileBinding) r104.f206091b).f206000c.getIconView().setOnClickListener(new a(r104, r106));
        Set<Key> r107 = this.f206110d.get(r105.f206023c);
        if (r107 == null) goto L5;
        boolean r108 = r107.contains(r106.f206020h);
    L6:
        ((FilePickerMainItemFileBinding) r104.f206091b).f205999b.setChecked(r108);
        ((FilePickerMainItemFileBinding) r104.f206091b).f205998a.setOnClickListener(new b(this, r105, r106, r108));
        return;
    L5:
        r108 = false;
        goto L6
    }
}
