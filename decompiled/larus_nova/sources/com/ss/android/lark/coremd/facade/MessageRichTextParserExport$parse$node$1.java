package com.ss.android.lark.coremd.facade;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/richtextmd/parse/ext/RichTextToMarkdownConfig;", "Lcom/ss/android/lark/richtextmd/parse/RichTextToMarkdownConfigs;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageRichTextParserExport$parse$node$1 extends Lambda implements Function1<com.ss.android.lark.richtextmd.parse.a, com.ss.android.lark.richtextmd.parse.ext.b> {
    public static final MessageRichTextParserExport$parse$node$1 INSTANCE = null;

    static {
        INSTANCE = new MessageRichTextParserExport$parse$node$1();
    }

    public MessageRichTextParserExport$parse$node$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.richtextmd.parse.ext.b invoke2(com.ss.android.lark.richtextmd.parse.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$config");
        List<Float> r101 = b.f419622a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return a.f419621b;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.richtextmd.parse.ext.b invoke(com.ss.android.lark.richtextmd.parse.a r100) {
        return invoke2(r100);
    }
}
