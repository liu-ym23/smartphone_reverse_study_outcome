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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ArrayList a(ArrayList r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L17;
        JSPromptGroup r2 = (JSPromptGroup) r8.next();
        PromptGroup r3 = new PromptGroup(r2.getTitle(), null, 2, null);
        ArrayList<JSPrompt> r4 = r2.getPrompts();
        if (r4 == null) goto L16;
        r3.setPrompts(new ArrayList());
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Prompt r6 = b((JSPrompt) r5.next());
        if (r6 == null) goto L12;
        ArrayList r9 = r3.getPrompts();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.util.ArrayList<com.ss.android.lark.inline.ai.api.ui.Prompt>");
        r9.add(r6);
    L16:
        r1.add(r3);
        goto L7
    L17:
        return r1;
    }

    public static Prompt b(JSPrompt r17) {
        if (r17 != null) goto L5;
        return null;
    L5:
        String r1 = r17.getType();
        if (r1 != null) goto L8;
        String r3 = "";
    L9:
        String r2 = r17.getId();
        if (r2 != null) goto L12;
        String r4 = "";
    L13:
        String r5 = r17.getKey();
        if (r5 != null) goto L16;
        String r6 = "";
    L17:
        String r7 = r17.getTemplate();
        if (r7 != null) goto L20;
        String r8 = "";
    L21:
        String r9 = r17.getIcon();
        Map r10 = d.a;
        if (r9 != null) goto L24;
        r9 = "";
    L24:
        int r11 = d.a(r9);
        String r12 = r17.getText();
        if (r12 != null) goto L27;
        String r13 = "";
    L28:
        String r14 = r17.getI18nKey();
        if (r14 != null) goto L31;
        String r16 = "";
    L32:
        String r18 = r17.getOriginText();
        if (r18 != null) goto L35;
        String r19 = "";
    L36:
        String r20 = r3;
        String r21 = r4;
        String r22 = r6;
        String r23 = r8;
        String r24 = r13;
        String r26 = r16;
        String r27 = r19;
        return new Prompt(r20, r21, r22, r23, r11, r24, r26, r27, r17.getRightArrow(), r17.getParams(), r17.getExtras(), null, 2048, null);
    L35:
        r19 = r18;
        goto L36
    L31:
        r16 = r14;
        goto L32
    L27:
        r13 = r12;
        goto L28
    L20:
        r8 = r7;
        goto L21
    L16:
        r6 = r5;
        goto L17
    L12:
        r4 = r2;
        goto L13
    L8:
        r3 = r1;
        goto L9
    }
}
