package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¨\u0006\u0007"}, d2 = {"hasAllLocalPersonalTags", "", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerTagState;", "addsTagTo", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "currentState", "currentHasTagData", "picker-doubao_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DoubaoChatterTagEnricherKt {
    public static final /* synthetic */ boolean access$hasAllLocalPersonalTags(DoubaoPickerTagState r100) {
        return hasAllLocalPersonalTags(r100);
    }

    private static final boolean hasAllLocalPersonalTags(DoubaoPickerTagState r100) {
        if (r100.isResigned() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.isFrozen() == false) goto L9;
        if (r100.isOnLeave() == false) goto L9;
        return true;
    }

    public static final /* synthetic */ boolean access$addsTagTo(DoubaoLocalChatterTagState r100, DoubaoPickerTagState r101, boolean r102) {
        return addsTagTo(r100, r101, r102);
    }

    private static final boolean addsTagTo(DoubaoLocalChatterTagState r100, DoubaoPickerTagState r101, boolean r102) {
        if (r100.isResigned() == false) goto L7;
        if (r101.isResigned() == true) goto L7;
    L19:
        return true;
    L7:
        if (r100.isFrozen() == false) goto L11;
        if (r101.isFrozen() == false) goto L19;
    L11:
        if (r100.isOnLeave() == false) goto L15;
        if (r101.isOnLeave() == false) goto L19;
    L15:
        if (r100.isExternal() == true) goto L17;
    L20:
        return false;
    L17:
        if (r101.isExternal() == true) goto L20;
        if (r102 == true) goto L20;
        goto L19
    }
}
