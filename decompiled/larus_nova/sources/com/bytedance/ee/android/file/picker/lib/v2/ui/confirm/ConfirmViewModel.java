package com.bytedance.ee.android.file.picker.lib.v2.ui.confirm;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.SavedStateHandle;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fJ\b\u0010\u0013\u001a\u00020\u0002H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/ConfirmViewModel;", "Lcom/larksuite/arch/jack/JackViewModel;", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/confirm/ConfirmUiState;", "mSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "mSelectedFiles", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/GroupEntity;", "mUnselectedKeys", "Landroidx/collection/ArrayMap;", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "Landroidx/collection/ArraySet;", "getUnSelectedGroups", "unselectFile", "", "groupKey", "fileKey", "defaultState", "Companion", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfirmViewModel extends JackViewModel<ConfirmUiState> {
    public static final a Companion = null;
    private final SavedStateHandle mSavedStateHandle;
    private final List<GroupEntity> mSelectedFiles;
    private final ArrayMap<Key, ArraySet<Key>> mUnselectedKeys;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public ConfirmUiState defaultState() {
        return new ConfirmUiState(new ArrayList(this.mSelectedFiles));
    }

    public final List<GroupEntity> getUnSelectedGroups() {
        if (this.mUnselectedKeys.isEmpty() == true) goto L5;
        List<GroupEntity> r100 = this.mSelectedFiles;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L24;
        GroupEntity r103 = (GroupEntity) r102.next();
        a r104 = Companion;
        ArrayMap<Key, ArraySet<Key>> r105 = this.mUnselectedKeys;
        r104.getClass();
        ArraySet<Key> r106 = r105.get(r103.f206023c);
        if (r106 == null) goto L20;
        List<FileEntry> r107 = r103.f206022b;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L14:
        if (r109.hasNext() == false) goto L19;
        Object r110 = r109.next();
        if (r106.contains(((FileEntry) r110).f206020h) == false) goto L14;
        r108.add(r110);
        goto L14
    L19:
        if (r108.isEmpty() == true) goto L20;
        GroupEntity r111 = GroupEntity.a(r103, r108);
    L22:
        if (r111 == null) goto L8;
        r101.add(r111);
    L20:
        r111 = null;
        goto L22
    L24:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public /* bridge */ /* synthetic */ j defaultState() {
        return defaultState();
    }

    @Inject
    public ConfirmViewModel(SavedStateHandle r100) {
        Intrinsics.checkNotNullParameter(r100, "mSavedStateHandle");
        this.mSavedStateHandle = r100;
        Companion.getClass();
        List<GroupEntity> r101 = (ArrayList) r100.get("selected_files");
        if (r101 != null) goto L5;
        Log.e("FilePickerV2", "get selected file error");
        r101 = CollectionsKt.emptyList();
    L5:
        this.mSelectedFiles = r101;
        this.mUnselectedKeys = new ArrayMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    public final void unselectFile(Key r100, Key r101) {
        Intrinsics.checkNotNullParameter(r100, "groupKey");
        Intrinsics.checkNotNullParameter(r101, "fileKey");
        ArrayMap<Key, ArraySet<Key>> r102 = this.mUnselectedKeys;
        ArraySet<Key> r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new ArraySet(0, 1, null);
        r102.put(r100, r103);
    L5:
        r103.add(r101);
        List<GroupEntity> r104 = this.mSelectedFiles;
        final ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L7:
        if (r106.hasNext() == false) goto L23;
        GroupEntity r107 = (GroupEntity) r106.next();
        ArraySet<Key> r108 = this.mUnselectedKeys.get(r107.f206023c);
        if (r108 == null) goto L16;
        List<FileEntry> r109 = r107.f206022b;
        ?? r110 = new ArrayList();
        Iterator r111 = r109.iterator();
    L12:
        if (r111.hasNext() == false) goto L18;
        Object r112 = r111.next();
        if (r108.contains(((FileEntry) r112).f206020h) == true) goto L12;
        r110.add(r112);
    L18:
        if (r110.isEmpty() == false) goto L20;
        GroupEntity r113 = null;
    L21:
        if (r113 == null) goto L7;
        r105.add(r113);
        goto L7
    L20:
        r113 = GroupEntity.a(r107, r110);
        goto L21
    L16:
        r110 = r107.f206022b;
        goto L18
    L23:
        setState(new AnonymousClass2(r105));
    }
}
