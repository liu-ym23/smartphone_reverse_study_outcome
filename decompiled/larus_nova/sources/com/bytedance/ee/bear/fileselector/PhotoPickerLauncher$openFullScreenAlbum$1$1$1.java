package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photopicker.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/widget/photopicker/PickerParams$Builder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class PhotoPickerLauncher$openFullScreenAlbum$1$1$1 extends Lambda implements Function1<s.a, Unit> {
    final /* synthetic */ FileSelectConfig $it;

    public PhotoPickerLauncher$openFullScreenAlbum$1$1$1(FileSelectConfig r100) {
        this.$it = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(s.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$build");
        FileSelectConfig r101 = this.$it;
        r100.f447593l = !r101.showGif;
        r100.f447582a = r101.sourceType;
        r100.f447594m = r101.showOrigin;
        r100.f447583b = r101.mediaType;
        r100.f447584c = r101.maxSelectImageNum;
        int r102 = r101.totalMaxPhotoCount;
        r100.f447585d = r102;
        if (r102 == (-1)) goto L5;
        boolean r103 = true;
    L6:
        r100.f447589h = r103;
        int r104 = h.f226795a;
        int r105 = r101.larkAlbumActionType;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L10;
        int r106 = R.string.Lark_Legacy_PickerSend;
    L15:
        String r107 = UIHelper.getString(r106);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f447599r = r107;
        FileSelectConfig r108 = this.$it;
        r100.f447588g = r108.showSingleSelector;
        r100.f447595n = r108.checkedKeepOrigin;
        r100.f447600s = r108.selectLocalMedias;
        return;
    L10:
        if (r105 != 2) goto L14;
        r106 = R.string.Lark_Legacy_PickerUpload;
    L14:
        r106 = R.string.Lark_Legacy_PickerConfirm;
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(s.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
