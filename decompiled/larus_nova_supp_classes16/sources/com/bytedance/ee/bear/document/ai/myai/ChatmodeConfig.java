package com.bytedance.ee.bear.document.ai.myai;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = ChatmodeConfig.KEY)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0006H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/myai/ChatmodeConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "toolIds", "", "", "getToolIds", "()Ljava/util/List;", "setToolIds", "(Ljava/util/List;)V", "toString", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatmodeConfig implements NonProguard {
    public static final a Companion = null;
    public static final String KEY = "ccm_myai_chatmode_config";
    private List<String> toolIds;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "ChatmodeConfig(toolIds=" + this.toolIds + ')';
    }

    public ChatmodeConfig() {
        this.toolIds = new ArrayList();
    }

    public final List<String> getToolIds() {
        return this.toolIds;
    }

    public final void setToolIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.toolIds = r2;
    }
}
