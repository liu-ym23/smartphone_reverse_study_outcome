package zz4;

import com.bytedance.ee.bear.document.ai.inlineai.bean.JSPrompt;
import com.bytedance.ee.bear.document.ai.inlineai.bean.JSPromptGroup;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import com.ss.android.lark.inline.ai.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f574086a = 0;

    static {
    }

    public static ArrayList a(ArrayList r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        JSPromptGroup r103 = (JSPromptGroup) r102.next();
        PromptGroup r104 = new PromptGroup(r103.getTitle(), null, 2, null);
        ArrayList<JSPrompt> r105 = r103.getPrompts();
        if (r105 == null) goto L16;
        r104.setPrompts(new ArrayList());
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L16;
        Prompt r107 = b((JSPrompt) r106.next());
        if (r107 == null) goto L12;
        ArrayList<Prompt> r108 = r104.getPrompts();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type java.util.ArrayList<com.ss.android.lark.inline.ai.api.ui.Prompt>");
        r108.add(r107);
    L16:
        r101.add(r104);
        goto L7
    L17:
        return r101;
    }

    public static Prompt b(JSPrompt r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        String r100 = r110.getType();
        if (r100 != null) goto L8;
        String r101 = "";
    L9:
        String r102 = r110.getId();
        if (r102 != null) goto L12;
        String r103 = "";
    L13:
        String r104 = r110.getKey();
        if (r104 != null) goto L16;
        String r105 = "";
    L17:
        String r106 = r110.getTemplate();
        if (r106 != null) goto L20;
        String r107 = "";
    L21:
        String r108 = r110.getIcon();
        Map<String, Integer> r109 = d.f427240a;
        if (r108 != null) goto L24;
        r108 = "";
    L24:
        int r111 = d.a(r108);
        String r112 = r110.getText();
        if (r112 != null) goto L27;
        String r113 = "";
    L28:
        String r114 = r110.getI18nKey();
        if (r114 != null) goto L31;
        String r115 = "";
    L32:
        String r116 = r110.getOriginText();
        if (r116 != null) goto L35;
        String r117 = "";
    L36:
        String r118 = r101;
        String r119 = r103;
        String r120 = r105;
        String r121 = r107;
        String r122 = r113;
        String r123 = r115;
        String r124 = r117;
        return new Prompt(r118, r119, r120, r121, r111, r122, r123, r124, r110.getRightArrow(), r110.getParams(), r110.getExtras(), null, 2048, null);
    L35:
        r117 = r116;
        goto L36
    L31:
        r115 = r114;
        goto L32
    L27:
        r113 = r112;
        goto L28
    L20:
        r107 = r106;
        goto L21
    L16:
        r105 = r104;
        goto L17
    L12:
        r103 = r102;
        goto L13
    L8:
        r101 = r100;
        goto L9
    }
}
