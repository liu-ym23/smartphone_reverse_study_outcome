package zc9;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.block.BlockInsertReference;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f571277a = null;

    static {
        f571277a = new j();
    }

    public j() {
    }

    public final byte[] insert(byte[] r100, byte[] r101, BlockInsertReference r110) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r110, "insertMeta");
        List<Integer> r102 = r110.getPosList();
        List<Integer> r103 = r102;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return r101;
    L11:
        int r105 = ((Number) ListProtector.get(r102, 0)).intValue();
        if (r105 >= 0) goto L14;
    L33:
        return r101;
    L14:
        if (r105 > r101.length) goto L33;
        int r106 = r101.length;
        int r107 = r100.length;
        String r108 = r110.getUrl();
        String r109 = r110.getDocId();
        Intrinsics.checkNotNullParameter("inline_doc_id", "paramKey");
        if (r108 == null) goto L26;
        Uri r111 = UriProtector.parse(r108);
        if (r111 == null) goto L26;
        Uri.Builder r112 = r111.buildUpon();
        if (r112 == null) goto L26;
        Uri.Builder r113 = r112.appendQueryParameter("inline_doc_id", r109);
        if (r113 == null) goto L26;
        Uri r114 = r113.build();
        if (r114 == null) goto L26;
        String r115 = r114.toString();
    L27:
        byte[] r116 = StringsKt.encodeToByteArray("[[" + r110.getInsertText() + "]](" + r115 + ')');
        int r117 = r106 - (r107 - r105);
        if (r117 < 0) goto L33;
        if (r117 > r101.length) goto L33;
        return ArraysKt.plus(ArraysKt.plus(ArraysKt.copyOfRange(r101, 0, r117), r116), ArraysKt.copyOfRange(r101, r117, r106));
    L26:
        r115 = null;
        goto L27
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }
}
