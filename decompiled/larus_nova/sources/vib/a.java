package vib;

import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.forwardv3.configuration.ConvertMessageParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.g;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.widget.richtext.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
@ConvertMessageParamsHandler
public final class a implements g<TextForwardContent> {
    public a() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 3;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.g
    public final Object a(IForwardContent r100) {
        TextForwardContent r101 = (TextForwardContent) r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        j1.a r103 = new j1.a();
        r103.A = c.c(r101.f425377b);
        r102.add(r103);
        return r102;
    }
}
