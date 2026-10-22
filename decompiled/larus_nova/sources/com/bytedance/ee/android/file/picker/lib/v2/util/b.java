package com.bytedance.ee.android.file.picker.lib.v2.util;

import com.bytedance.ee.android.file.picker.lib.FilePickerParams;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f206158a = 0;

    static {
    }

    public static FilePickerParams a(pm4.a r110) {
        String r100 = UIHelper.mustacheFormat(R.string.Lark_Message_File_defTitle);
        String r101 = r110.f529835j;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
    L14:
        String r111 = r101;
        if (202001 != r110.f529837l) goto L17;
        Set r103 = SetsKt.setOf("picker_received");
    L18:
        long r104 = r110.f529830e;
        long r105 = r110.f529831f;
        int r106 = r110.f529832g;
        String r107 = r110.f529833h;
        String r108 = r110.f529834i;
        Intrinsics.checkNotNull(r111);
        boolean r112 = r110.f529836k;
        return new FilePickerParams(r104, r105, r106, r107, r108, r100, r111, r112, r103, 7680);
    L17:
        r103 = SetsKt.setOf(new String[]{"picker_video", "picker_doc", "picker_received"});
        goto L18
    L11:
        if (r110.f529829d != 0) goto L13;
        r101 = UIHelper.getString(R.string.Lark_Legacy_Send);
        goto L14
    L13:
        r101 = UIHelper.getString(R.string.Lark_File_FilePickerUpload);
        goto L14
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }
}
