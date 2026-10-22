package com.bytedance.ies.xelement.text.emoji;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-emoji"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.text.emoji")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xelement/text/emoji/LynxEmojiUI;", "Lcom/lynx/tasm/behavior/ui/text/UIText;", "", "name", "", "setEmojiName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-emoji_release"}, k = 1, mv = {1, 6, 0})
public final class LynxEmojiUI extends UIText {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f250377b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250378a;

    public static final class a {
        @JvmStatic
        public static String a(String r100) {
            if (r100 == null) goto L5;
            String r101 = StringsKt.trim(r100).toString();
        L6:
            boolean r102 = true;
            if (r101 != null) goto L9;
        L12:
            boolean r103 = true;
        L13:
            if (r103 == false) goto L15;
            return null;
        L15:
            String r104 = StringsKt.trim(StringsKt.removeSuffix(StringsKt.removePrefix(r101, "["), "]")).toString();
            if (r104.length() == 0) goto L19;
            r102 = false;
        L19:
            if (r102 == false) goto L22;
            return null;
        L22:
            return "[" + r104 + ']';
        L9:
            if (r101.length() == 0) goto L12;
            r103 = false;
            goto L13
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
    }

    @LynxProp(name = "emoji-name")
    public final void setEmojiName(String r100) {
    }

    public final void M() {
        T r100 = this.mView;
        if ((r100 instanceof f) == false) goto L5;
        f r101 = (f) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f250378a == false) goto L10;
    L13:
        boolean r102 = true;
    L14:
        r101.setDrawHandledByParentText(r102);
        return;
    L10:
        if ((getParent() instanceof UIText) == true) goto L13;
        r102 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.text.UIText, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        M();
    }

    @Override // com.lynx.tasm.behavior.ui.text.UIText, com.lynx.tasm.behavior.ui.LynxUI
    public final AndroidText createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new f(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.text.UIText, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r100) {
        if ((r100 instanceof c) == false) goto L6;
        this.f250378a = ((c) r100).f250379a;
        M();
        return;
    L6:
        super.updateExtraData(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.text.UIText, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r100) {
        return createView(r100);
    }

    public LynxEmojiUI(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
