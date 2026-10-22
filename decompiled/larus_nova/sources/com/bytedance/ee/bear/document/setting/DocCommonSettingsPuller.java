package com.bytedance.ee.bear.document.setting;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DocCommonSettingsPuller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f221724a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocCommonSettingsPuller$Params;", "Lcom/bytedance/ee/util/io/NonProguard;", "scene", "", "<init>", "(Ljava/lang/String;)V", "getScene", "()Ljava/lang/String;", "setScene", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Params implements NonProguard {
        private String scene;

        public final String getScene() {
            return this.scene;
        }

        public Params(String r100) {
            this.scene = r100;
        }

        public final void setScene(String r100) {
            this.scene = r100;
        }
    }

    public static final class a {
    }

    static {
    }

    public DocCommonSettingsPuller(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        this.f221724a = r100;
    }
}
