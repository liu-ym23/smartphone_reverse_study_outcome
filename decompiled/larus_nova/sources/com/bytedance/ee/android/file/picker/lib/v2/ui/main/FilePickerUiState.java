package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import com.larksuite.arch.jack.j;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerUiState implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f206113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<GroupEntity> f206114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Key, Set<Key>> f206115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f206116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f206117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Key, Long> f206118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f206119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f206120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f206121j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FilePickerUiState) == true) goto L8;
        return false;
    L8:
        FilePickerUiState r101 = (FilePickerUiState) r100;
        if (Intrinsics.areEqual(this.f206112a, r101.f206112a) == true) goto L12;
        return false;
    L12:
        if (this.f206113b == r101.f206113b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f206114c, r101.f206114c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f206115d, r101.f206115d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f206116e, r101.f206116e) == true) goto L24;
        return false;
    L24:
        if (this.f206117f == r101.f206117f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f206118g, r101.f206118g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f206112a.hashCode() * 31;
        int r101 = 1231;
        if (this.f206113b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((r100 + r102) * 31) + this.f206114c.hashCode()) * 31) + this.f206115d.hashCode()) * 31) + this.f206116e.hashCode()) * 31;
        if (this.f206117f == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f206118g.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FilePickerUiState(title=" + this.f206112a + ", showSystemPicker=" + this.f206113b + ", groupList=" + this.f206114c + ", selectedKey=" + this.f206115d + ", bottomBarBtnText=" + this.f206116e + ", showLoading=" + this.f206117f + ", selectedOrders=" + this.f206118g + ')';
    }

    public final boolean b() {
        return ((Boolean) this.f206120i.getValue()).booleanValue();
    }

    public static FilePickerUiState a(FilePickerUiState r100, List r110, Map r111, String r112, Map r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r101 = r100.f206112a;
    L6:
        String r102 = r101;
        if ((r114 & 2) == 0) goto L9;
        boolean r103 = r100.f206113b;
    L11:
        if ((r114 & 4) == 0) goto L13;
        r110 = r100.f206114c;
    L13:
        List r104 = r110;
        if ((r114 & 8) == 0) goto L16;
        r111 = r100.f206115d;
    L16:
        Map r105 = r111;
        if ((r114 & 16) == 0) goto L19;
        r112 = r100.f206116e;
    L19:
        String r106 = r112;
        if ((r114 & 32) == 0) goto L22;
        boolean r107 = r100.f206117f;
    L24:
        if ((r114 & 64) == 0) goto L26;
        r113 = r100.f206118g;
    L26:
        Map r108 = r113;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r104, "groupList");
        Intrinsics.checkNotNullParameter(r105, "selectedKey");
        Intrinsics.checkNotNullParameter(r106, "bottomBarBtnText");
        Intrinsics.checkNotNullParameter(r108, "selectedOrders");
        return new FilePickerUiState(r102, r103, r104, r105, r106, r107, r108);
    L22:
        r107 = false;
        goto L24
    L9:
        r103 = false;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilePickerUiState(String r100, boolean r101, List<GroupEntity> r102, Map<Key, ? extends Set<? extends Key>> r103, String r104, boolean r105, Map<Key, Long> r106) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "groupList");
        Intrinsics.checkNotNullParameter(r103, "selectedKey");
        Intrinsics.checkNotNullParameter(r104, "bottomBarBtnText");
        Intrinsics.checkNotNullParameter(r106, "selectedOrders");
        this.f206112a = r100;
        this.f206113b = r101;
        this.f206114c = r102;
        this.f206115d = r103;
        this.f206116e = r104;
        this.f206117f = r105;
        this.f206118g = r106;
        this.f206119h = LazyKt.lazy(new FilePickerUiState$selectedGroups$2(this));
        this.f206120i = LazyKt.lazy(new FilePickerUiState$bottomBarBtnEnabled$2(this));
        this.f206121j = LazyKt.lazy(new FilePickerUiState$bottomBarCountText$2(this));
    }
}
