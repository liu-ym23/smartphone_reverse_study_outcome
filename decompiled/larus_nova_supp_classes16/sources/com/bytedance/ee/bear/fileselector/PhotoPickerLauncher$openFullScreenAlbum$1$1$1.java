package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photopicker.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/widget/photopicker/PickerParams$Builder;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class PhotoPickerLauncher$openFullScreenAlbum$1$1$1 extends Lambda implements Function1<s.a, Unit> {
    final /* synthetic */ FileSelectConfig $it;

    public PhotoPickerLauncher$openFullScreenAlbum$1$1$1(FileSelectConfig r1) {
        this.$it = r1;
        super(1);
    }

    public final void invoke(s.a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$build");
        FileSelectConfig r0 = this.$it;
        r5.l = !r0.showGif;
        r5.a = r0.sourceType;
        r5.m = r0.showOrigin;
        r5.b = r0.mediaType;
        r5.c = r0.maxSelectImageNum;
        int r1 = r0.totalMaxPhotoCount;
        r5.d = r1;
        if (r1 == (-1)) goto L5;
        boolean r2 = true;
    L6:
        r5.h = r2;
        int r3 = h.a;
        int r4 = r0.larkAlbumActionType;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L10;
        int r6 = 2131892079;
    L15:
        String r7 = UIHelper.getString(r6);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r5.r = r7;
        FileSelectConfig r8 = this.$it;
        r5.g = r8.showSingleSelector;
        r5.n = r8.checkedKeepOrigin;
        r5.s = r8.selectLocalMedias;
        return;
    L10:
        if (r4 != 2) goto L14;
        r6 = 2131892082;
    L14:
        r6 = 2131892072;
        goto L15
    L5:
        r2 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s.a) r1);
        return Unit.INSTANCE;
    }
}
