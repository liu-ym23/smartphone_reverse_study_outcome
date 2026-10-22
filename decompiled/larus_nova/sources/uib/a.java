package uib;

import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.forwardv3.configuration.ConvertMessageParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.g;
import com.ss.android.lark.forwardv3.forward.imageforward.ImageForwardContent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes36.dex */
@ConvertMessageParamsHandler
public final class a implements g<ImageForwardContent> {
    public a() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 5;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g
    public final Object a(IForwardContent r100) {
        ImageForwardContent r101 = (ImageForwardContent) r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.f425358b.iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        p0.a r105 = new p0.a();
        r105.A = r104;
        r102.add(r105);
        goto L7
    L10:
        return r102;
    }
}
