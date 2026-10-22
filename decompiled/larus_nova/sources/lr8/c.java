package lr8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.service.AccountService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f510447a = 0;

    static {
    }

    public static boolean a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getContentType() != 800) goto L7;
        if (Intrinsics.areEqual(r100.getBizContentType(), "flow_nested") == false) goto L7;
        return true;
    L7:
        if (com.larus.im.bean.message.a.b0(r100) == false) goto L32;
        List<Block> r101 = r100.getContentBlock();
        if (r101 == null) goto L27;
        List<Block> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L24;
        if (((Block) r103.next()).getBlockType() != BlockType.BLOCK_TYPE_ATTACHMENT.getValue()) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L17;
        boolean r105 = true;
    L25:
        if (r105 != true) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L32;
        if (Intrinsics.areEqual(AccountService.f365697a.getUserId(), r100.getSenderId()) == false) goto L32;
        boolean r107 = true;
    L33:
        if (r107 == true) goto L43;
        return false;
    L43:
        return true;
    L21:
        r104 = false;
    L24:
        r105 = false;
        goto L25
    L13:
        if (r102.isEmpty() == false) goto L15;
    L27:
        r106 = false;
    L32:
        r107 = false;
        goto L33
    }
}
