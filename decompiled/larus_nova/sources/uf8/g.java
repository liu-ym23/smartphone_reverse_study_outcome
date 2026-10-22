package uf8;

import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.j;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements xc8.g {

    public static final class a {
    }

    static {
    }

    @Override // xc8.g
    public final int c() {
        return 20;
    }

    public g() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() != 2021) goto L11;
        int r102 = j.f304087a;
        AiGenVideoContentData r103 = j.a(r101.getContent());
        if (r103 == null) goto L7;
        String r104 = r103.getMobileSupport();
    L9:
        if (Intrinsics.areEqual(r104, "1") == false) goto L11;
        return true;
    L7:
        r104 = null;
    L11:
        return false;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new f(r101);
    }
}
