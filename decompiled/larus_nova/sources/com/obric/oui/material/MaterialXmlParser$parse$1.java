package com.obric.oui.material;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/xmlpull/v1/XmlPullParser;", "parser", "Lcom/obric/oui/material/c;", AbsMethodDelegate.TAG_INVOKE, "(Lorg/xmlpull/v1/XmlPullParser;)Lcom/obric/oui/material/c;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class MaterialXmlParser$parse$1 extends Lambda implements Function1<XmlPullParser, c> {
    public static final MaterialXmlParser$parse$1 INSTANCE = null;

    static {
        INSTANCE = new MaterialXmlParser$parse$1();
    }

    public MaterialXmlParser$parse$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c invoke2(XmlPullParser r100) {
        Intrinsics.checkNotNullParameter(r100, "parser");
        return MaterialXmlParser.f401400a.p(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ c invoke(XmlPullParser r100) {
        return invoke2(r100);
    }
}
