package com.ss.android.lark.picker.doubao.entity;

import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocType;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocTypes;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"createDefaultDocTypes", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "picker-doubao-api_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DoubaoPickerConfigKt {
    private static final DoubaoDocTypes createDefaultDocTypes() {
        return new DoubaoDocTypes.NEW(SetsKt.setOf(new DoubaoDocType[]{DoubaoDocType.DOCX, DoubaoDocType.FILE, DoubaoDocType.SLIDES, DoubaoDocType.SHEET, DoubaoDocType.WIKI, DoubaoDocType.BITABLE, DoubaoDocType.MINDNOTE}));
    }

    public static final /* synthetic */ DoubaoDocTypes access$createDefaultDocTypes() {
        return createDefaultDocTypes();
    }
}
