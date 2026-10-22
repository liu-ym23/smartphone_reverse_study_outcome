package opc;

import com.ss.android.lark.biz.im.api.k;
import com.ss.android.lark.biz.im.api.l;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.forwardv3.configuration.ConvertMessageParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.g;
import com.suite.lark.platform.feature.forward.doubao.file.DoubaoFileForwardContent;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@ConvertMessageParamsHandler
public final class a implements g<DoubaoFileForwardContent> {
    public a() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 10;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g
    public final Object a(IForwardContent r110) {
        DoubaoFileForwardContent r111 = (DoubaoFileForwardContent) r110;
        String r100 = null;
        if (r111 != null) goto L6;
        return null;
    L6:
        if (StringsKt.isBlank(r111.f461342a) == false) goto L8;
        return null;
    L8:
        if (StringsKt.isBlank(r111.f461343b) == true) goto L24;
        int r101 = r111.f461344c;
        if (r101 <= 0) goto L26;
        k r102 = new k(r111.f461342a, r111.f461343b, r101);
        MessageParams.a[] r103 = new MessageParams.a[1];
        l.a r104 = new l.a();
        String r105 = r111.f461343b;
        if (r105 == null) goto L15;
        r104.B = r105;
    L15:
        r104.C = r102.a();
        r104.D = RangesKt.coerceAtLeast(r111.f461345d, 0);
        String r112 = r111.f461346e;
        if ((true ^ StringsKt.isBlank(r112)) == false) goto L18;
        r100 = r112;
    L18:
        if (r100 != null) goto L20;
        r104.E = "*/*";
    L21:
        r104.F = FileState.UPLOADING;
        r104.f410267J = r102;
        r103[0] = r104;
        return CollectionsKt.arrayListOf(r103);
    L20:
        r104.E = r100;
        goto L21
    L26:
        return null;
    L24:
        return null;
    }
}
