package com.ss.android.lark.widget.richtext.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.genv2.RichTextGenerateUtils2;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final <T extends Serializable> T a(T r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L7
        new ObjectOutputStream(r101).writeObject(r100);     // Catch: Exception -> L7
        Object r102 = new ObjectInputStream(new ByteArrayInputStream(r101.toByteArray())).readObject();     // Catch: Exception -> L7
        if ((r102 instanceof Serializable) == false) goto L11;
        return (T) r102;
    L11:
        return null;
    L7:
        Log.e("ExtensionRichText", "copy richText failed");
        return null;
    }

    public static final RichText b(RichText r100, RichText r101) {
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r100 != null) goto L5;
        return r101;
    L5:
        int r102 = b.f448388a;
        Intrinsics.checkNotNullParameter(r100, "richText1");
        Intrinsics.checkNotNullParameter(r101, "richText2");
        ArrayList r103 = new ArrayList();
        List r104 = b.a(r100, false);
        List r105 = b.a(r101, false);
        r103.addAll(r104);
        jec.c r106 = (jec.c) CollectionsKt.lastOrNull(r104);
        jec.c r107 = (jec.c) CollectionsKt.firstOrNull(r105);
        RichTextElement.RichTextTag r108 = null;
        if (r106 == null) goto L10;
        RichTextElement r109 = r106.f498845a;
        if (r109 == null) goto L10;
        RichTextElement.RichTextTag r110 = r109.getTag();
    L11:
        RichTextElement.RichTextTag r111 = RichTextElement.RichTextTag.PARAGRAPH;
        if (r110 != r111) goto L21;
        if (r107 == null) goto L17;
        RichTextElement r112 = r107.f498845a;
        if (r112 == null) goto L17;
        r108 = r112.getTag();
    L17:
        if (r108 != r111) goto L21;
        r106.f498846b.addAll(r107.f498846b);
        int r113 = ((ArrayList) r105).size();
        int r114 = 1;
    L19:
        if (r114 >= r113) goto L22;
        r103.add(ListProtector.get(r105, r114));
        r114 = r114 + 1;
    L22:
        RichTextGenerateUtils2 r115 = RichTextGenerateUtils2.f448313a;
        return RichTextGenerateUtils2.c(r103);
    L21:
        r103.addAll(r105);
    L10:
        r110 = null;
        goto L11
    }
}
