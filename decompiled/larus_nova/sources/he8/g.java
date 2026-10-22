package he8;

import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.x;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.platform.spi.IAIChatService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vd9.r;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements je8.a {
    public g() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        IChatAzerothService r102 = x.a();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return false;
    L11:
        if (r101.getContentType() == 1) goto L18;
        if (r101.getContentType() == 66) goto L18;
        if (r101.getContentType() == 9999) goto L18;
        return false;
    L18:
        if (r101.getMessageStatus() == MessageStatus.MessageStatus_INVISIBLE) goto L46;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Block r104 = (Block) CollectionsKt.firstOrNull(r.a(r101));
        if (r104 == null) goto L27;
        BlockContent r105 = r104.getContent();
        if (r105 == null) goto L27;
        TextBlock r106 = r105.getTextBlock();
        if (r106 == null) goto L27;
        String r107 = r106.text;
    L28:
        if (r107 != null) goto L30;
    L33:
        boolean r108 = true;
    L34:
        if (r108 == false) goto L37;
        return false;
    L37:
        if (IAIChatService.f365899a.B7(r101) == null) goto L40;
        return false;
    L40:
        if (com.larus.bmhome.chat.bean.d.G0(r101) == false) goto L49;
        return true;
    L49:
        return false;
    L30:
        if (StringsKt.isBlank(r107) == true) goto L33;
        r108 = false;
    L27:
        r107 = null;
        goto L28
    L46:
        return false;
    L5:
        if (r102.d(r101) != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new f(r101);
    }
}
