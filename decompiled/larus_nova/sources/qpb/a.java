package qpb;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: qpb.a$a, reason: collision with other inner class name */
    public static class C7379a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f534445a = null;

        static {
            f534445a = new a();
        }
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "log_config";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "LogSettingHandler";
    }

    public a() {
        AbstractBaseSettingHandler.a r100 = new AbstractBaseSettingHandler.a();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f431107f = r100;
    }
}
