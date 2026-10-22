package com.ss.android.lark.compose.chatsetting.main.ui.sections.doubao;

import com.larksuite.framework.utils.ICUUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1 extends FunctionReferenceImpl implements Function2<String, String, String> {
    public static final DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1 INSTANCE = null;

    static {
        INSTANCE = new DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1();
    }

    public DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1() {
        super(2, DoubaoSettingsSectionKt.class, "formatBrandedText", "formatBrandedText(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ICUUtils.FormatArgsBuilder r102 = new ICUUtils.FormatArgsBuilder();
        r102.b("brandName", r101);
        return ICUUtils.icuFormat(r100, r102.f285892a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(String r100, String r101) {
        return invoke2(r100, r101);
    }
}
