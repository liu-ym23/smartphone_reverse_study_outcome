package com.bytedance.ies.xelement.text.emoji;

import android.content.Context;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxNativeModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxNativeModule(name = LynxEmojiModule.NAME)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/xelement/text/emoji/LynxEmojiModule;", "Lcom/lynx/jsbridge/LynxModule;", "", "name", "", "hasEmoji", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "params", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "(Landroid/content/Context;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-emoji_release"}, k = 1, mv = {1, 6, 0})
public final class LynxEmojiModule extends LynxModule {
    public static final a Companion = null;
    public static final String NAME = "LynxEmojiModule";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LynxEmojiModule(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @LynxMethod
    public final boolean hasEmoji(String r100) {
        int r101 = LynxEmojiUI.f250377b;
        String r102 = LynxEmojiUI.a.a(r100);
        if (r102 != null) goto L10;
        return false;
    L10:
        d r103 = d.f250380b;     // Catch: Exception -> L9
        if (d.a.a().a(this.mContext, r102) == null) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    public LynxEmojiModule(Context r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
